package com.example.Task.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Task.DTO.PasswordChangeDto;
import com.example.Task.DTO.UserLogDto;
import com.example.Task.DTO.UserRegDto;
import com.example.Task.Entity.UserLogin;
import com.example.Task.ExceptionHandling.Exceptions.IncorrectPasswordException;
import com.example.Task.ExceptionHandling.Exceptions.NewPasswordSameAsOldException;
import com.example.Task.ExceptionHandling.Exceptions.PasswordNotMatchException;
import com.example.Task.ExceptionHandling.Exceptions.UserPresentException;
import com.example.Task.ExceptionHandling.Exceptions.UsernameAlreadyTakenException;
import com.example.Task.ExceptionHandling.Exceptions.UsernameNotFoundException;
import com.example.Task.Repository.UserLoginRepo;

import jakarta.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserLoginRepo userLogRepo;
    @Value("${app.secret.key}")
    private String secretKey;

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("userLog", new UserLogDto());
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@Valid @ModelAttribute("userLog") UserLogDto user,
            BindingResult result, Model model) {
        UserLogin userLog;
        if (result.hasErrors()) {
            return "login";
        }
        try {
            userLog = userLogRepo.findByUsername(user.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Username doesn't exist."));
            if (!user.getPassword().equals(userLog.getPassword())) {
                throw new IncorrectPasswordException("Password is incorrect");
            }
            return "redirect:/add-employee-form";
        } catch (UsernameNotFoundException e) {
            result.rejectValue("username", "error.userLog", e.getMessage());
            return "login";
        } catch (IncorrectPasswordException e) {
            result.rejectValue("password", "error.userLog", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("userReg", new UserRegDto());
        return "register";
    }

    @PostMapping("/register")
    public String submitRegister(@Valid @ModelAttribute("userReg") UserRegDto user,
            BindingResult result, RedirectAttributes redirectAttributes) throws InterruptedException {
        if (result.hasErrors()) {
            return "register";
        }
        try {
            if (!user.getSecretKey().equals(secretKey)) {
                result.rejectValue("secretKey", "error.userReg", "Access denied. Invalid Secret Key");
                return "register";
            }

            if(userLogRepo.findByName(user.getName()).isPresent()) {
                throw new UserPresentException("User Already Exists");
            }
            if(userLogRepo.findByUsername(user.getUsername()).isPresent()) {
                throw new UsernameAlreadyTakenException("Username is already taken.");
            }

            if (!user.getPassword().equals(user.getConfirmPassword())) {
                throw new PasswordNotMatchException("Password should match the entered password");
            }
            UserLogin userReg = new UserLogin();
            userReg.setName(user.getName());
            userReg.setUsername(user.getUsername());
            userReg.setPassword(user.getConfirmPassword());
            userLogRepo.save(userReg);
            redirectAttributes.addFlashAttribute("successMessage", "User Registered Successfully!");
            
            Thread.sleep(2000);
            return "redirect:/login";
        } catch (UserPresentException e) {
            result.rejectValue("name", "error.userReg", e.getMessage());
            return "register";
        } catch (UsernameAlreadyTakenException e) {
            result.rejectValue("username", "error.userReg", e.getMessage());
            return "register";
        } catch (PasswordNotMatchException e) {
            result.rejectValue("confirmPassword", "error.userReg", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/forgot-password")
    public String showForgotPassword(Model model) {
        model.addAttribute("forgotPass", new PasswordChangeDto());
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String handleChangePassword(@Valid @ModelAttribute("forgotPass") PasswordChangeDto passChng,
            BindingResult result, RedirectAttributes redirectAttributes) throws InterruptedException {
        if (result.hasErrors()) {
            return "forgot-password";
        }
        try {
            UserLogin user = userLogRepo.findByUsername(passChng.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException(passChng.getUsername() + " doesn't exist"));
            if (passChng.getNewPassword().equals(user.getPassword())) {
                throw new NewPasswordSameAsOldException("New password cannot be same as old one.");
            }
            if (!passChng.getSecretKey().equals(secretKey)) {
                result.rejectValue("secretKey", "error.forgotPass", "Invalid secret key");
                return "forgot-password";
            }

            user.setPassword(passChng.getNewPassword());
            userLogRepo.save(user);
            redirectAttributes.addFlashAttribute("successMessage", "Password Changed Successfully!");

            Thread.sleep(2000);
            return "redirect:/login";
        } catch (NewPasswordSameAsOldException e) {
            result.rejectValue("newPassword", "error.forgotPass", e.getMessage());
            return "forgot-password";
        } catch (UsernameNotFoundException e) {
            result.rejectValue("username", "error.forgotPass", e.getMessage());
            return "forgot-password";
        }
    }
}

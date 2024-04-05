package com.ecommerce.loginsignup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/about-Us")
    public String showAbout() {
        return "aboutUs"; 
    }

    @GetMapping("/Bag")
    public String showBag() {
        return "bag"; 
    }


    @GetMapping("/gift-Card")
    public String showGift() {
        return "GiftCards"; 
    }

    @GetMapping("/Wishlist")
    public String showWishlist() {
        return "Wishlist"; 
    }

    @GetMapping("/ContactUs")
    public String showContact() {
        return "ContactUs"; 
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "LoginPage"; // Return the login page template name
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user, Model model) {
        if (userService.loginUser(user)) {
            return "redirect:http://localhost:8080/"; // Redirect to main page if login is successful
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "LoginPage"; // Return to login page with error message if login fails
        }
    }
    
    @GetMapping("/signup")
    public String showRegistrationForm(@ModelAttribute("user") User user) {
        return "registration"; // Return the registration form template name
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.createUser(user);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "LoginPage"; // Return to registration page with error message if registration fails
        }
        return "redirect:http://localhost:8080/"; // Redirect to login page after successful registration
    }
}

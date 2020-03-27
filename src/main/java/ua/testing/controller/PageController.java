package ua.testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.testing.service.BookService;
import ua.testing.service.UserService;

@Controller
public class PageController {

  private BookService bookService;
  private UserService userService;

  public PageController(BookService bookService, UserService userService) {
    this.bookService = bookService;
    this.userService = userService;
  }

  @GetMapping("/admin")
  public String adminPage(Model model) {
    model.addAttribute("users",userService.getAllUser());
    return "admin";
  }

  @GetMapping("/user")
  public String userPage(Model model) {
    model.addAttribute("books", bookService.getAllBook());
    return "user";
  }

  @GetMapping("/")
  public String loginPage(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout,
      Model model) {
    model.addAttribute("error", error != null);
    model.addAttribute("logout", logout != null);
    return "login";
  }

  @GetMapping("/register")
  public String registerPage() {
    return "register";
  }
}


package vish.dima.crud.CrudSecurity.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vish.dima.crud.CrudSecurity.security.PersonDetails;
import vish.dima.crud.CrudSecurity.services.AdminService;

@Controller
public class HelloController {
    private final AdminService adminService;

    public HelloController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails= (PersonDetails)authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }
    @GetMapping("/adminPage")
    public String adminPage() {
        adminService.doAdmin();
        return "adminPage";
    }
}

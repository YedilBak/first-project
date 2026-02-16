package kz.index.demo.controller;

import kz.index.demo.db.DBManager;
import kz.index.demo.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/") //http:localhost:8080/
    public String getMainPage(Model model){
        model.addAttribute("cars",DBManager.getCars());
        return "main";
    }

    @PostMapping(value = "/add-car")
    public String addCar(Car car){
        DBManager.addCar(car);
        return "redirect:/";
    }


}

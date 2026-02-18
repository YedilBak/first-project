package kz.index.demo.controller;

import kz.index.demo.db.DBManager;
import kz.index.demo.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping(value = "/") //http://localhost:8080/
    public String getMainPage(Model model){
        model.addAttribute("cars",DBManager.getCars());
        return "main";
    }

    @PostMapping(value = "/add-car")
    public String addCar(Car car){
        DBManager.addCar(car);
        return "redirect:/";
    }

    @GetMapping(value = "/get-car/{id}")//http://localhost:8080/get-car
    public String getCarById(@PathVariable int id,
                             Model model){

        model.addAttribute("car", DBManager.getCarById(id));

        return "details-car";
    }


    @PostMapping(value = "/update-car")
    public String updateCar(Car car){

        DBManager.updateCar(car);

        return "redirect:/";
    }

    @PostMapping(value = "/delete-car")
    public String deleteCar(@RequestParam int id){
        DBManager.deleteCarById(id);

        return "redirect:/";
    }
}

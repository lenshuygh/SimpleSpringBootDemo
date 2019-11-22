package com.boot.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationMvcController {

    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservations.php")
    String reservations (Model model){
        model.addAttribute("reservations",reservationRepository.findAll());
        return "reservations";
    }
}

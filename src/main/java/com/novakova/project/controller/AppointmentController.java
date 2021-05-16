package com.novakova.project.controller;

import com.novakova.project.model.Appointment;
import com.novakova.project.model.User;
import com.novakova.project.service.AppointmentService;
import com.novakova.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createAppointment(Model model){
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        model.addAttribute("dateString", "");

        return "appointment";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createAppointmentPost(@ModelAttribute("appointment") Appointment appointment,
                                        @ModelAttribute("dateString") String date,
                                        Model model,
                                        Principal principal) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d = format.parse(date);
        appointment.setDate(d);

        User user = userService.findByUsername(principal.getName());
        appointment.setUser(user);

        appointmentService.createAppointment(appointment);

        return "redirect:/userFront";
    }

}

package com.hskspring.eazyschool.controller;

import com.hskspring.eazyschool.model.Person;
import com.hskspring.eazyschool.model.Profile;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ProfileController {
    @RequestMapping("/displayProfile")
    public ModelAndView displayProfileMessages(Model model, HttpSession session) {
        // now let load person details from session that we store in dashboard from DB
        Person person = (Person) session.getAttribute("loggedInPerson");
        Profile profile = new Profile();
        // let's populate person profile using person Object that we loaded from the session
        profile.setName(person.getName());
        profile.setMobileNumber(person.getMobileNumber());
        profile.setEmail(person.getEmail());
        // let check if address details available in person Object, fetch them as well
        if (person.getAddress() != null && person.getAddress().getAddressId() > 0) {
            profile.setAddress1(person.getAddress().getAddress1());
            profile.setAddress2(person.getAddress().getAddress2());
            profile.setCity(person.getAddress().getCity());
            profile.setState(person.getAddress().getState());
            profile.setZipCode(person.getAddress().getZipCode());
        }

        ModelAndView modelAndView = new ModelAndView("profile.html");
        modelAndView.addObject("profile", profile);
        return modelAndView;
    }
}

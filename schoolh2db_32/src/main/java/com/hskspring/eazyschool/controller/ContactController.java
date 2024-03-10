package com.hskspring.eazyschool.controller;

import com.hskspring.eazyschool.model.Contact;
import com.hskspring.eazyschool.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j //private static Logger log = LoggerFactory.getLogger(ContactController.class);
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());//this will bring the validations in the Contact class & send it to frontend
        return "contact.html";
    }

    /* @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
     public ModelAndView saveMessage(
             @RequestParam String name,
             @RequestParam String mobileNum,
             @RequestParam String email,
             @RequestParam String subject,
             @RequestParam String message
     ) {
         log.info("Name : " + name);
         log.info("Mobile Number : " + mobileNum);
         log.info("Email Address : " + email);
         log.info("Subject : " + subject);
         log.info("Message : " + message);
         return new ModelAndView("redirect:/contact");
     }*/
    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact.html";// this display the contact page
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";// recheck all the validations again in the contact page
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs", contactMsgs);
        return modelAndView;
    }
    //Close message
    @RequestMapping(value = "/closeMsg",method = RequestMethod.GET)
    public String closeMsg(@RequestParam int id, Authentication authentication) {
        contactService.updateMsgStatus(id, authentication.getName());
        return "redirect:/displayMessages";
    }
}































package com.hskspring.eazyschool.rest;

import com.hskspring.eazyschool.model.Contact;
import com.hskspring.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/contact")
public class ContactRestController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/getMessagesByStatus")
    @ResponseBody
    public List<Contact> getMessagesByStatus(@RequestParam(name = "status") String status) {
        return contactRepository.findByStatus(status);
    }


    @GetMapping("/getAllMsgsByStatus")
    @ResponseBody
    public List<Contact> getAllMsgsByStatus(@RequestBody Contact contact) {
        if (null != contact && null != contact.getStatus()) {

            return contactRepository.findByStatus(contact.getStatus());
        } else {
            return List.of();
        }
    }
}

package com.hskspring.eazyschool.service;

import com.hskspring.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j// it will provide log object
@Service
@RequestScope
public class ContactService {
    /*
      save Contact Details into DB
      @param contact
      @return boolean
     */

    private int counter = 0;

    public ContactService() {
        System.out.println("Contact Service Bean initialized"); // this bean will be created each http request
    }

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

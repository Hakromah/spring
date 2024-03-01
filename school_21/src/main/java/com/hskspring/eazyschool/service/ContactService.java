package com.hskspring.eazyschool.service;

import com.hskspring.eazyschool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    /*
      save Contact Details into DB
      @param contact
      @return boolean
     */

    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }
}

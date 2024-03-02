package com.hskspring.eazyschool.service;

import com.hskspring.eazyschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Slf4j// it will provide log object
@Service
public class ContactService {
    /*
      save Contact Details into DB
      @param contact
      @return boolean
     */
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }
}

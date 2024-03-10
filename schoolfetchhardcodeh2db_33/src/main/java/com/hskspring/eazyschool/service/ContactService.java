package com.hskspring.eazyschool.service;

import com.hskspring.eazyschool.constants.EasySchoolContacts;
import com.hskspring.eazyschool.model.Contact;
import com.hskspring.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j// it will provide log object
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }
    /*
      save Contact Details into DB
      @param contact
      @return boolean
     */

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EasySchoolContacts.OPEN);
        contact.setCreatedBy(EasySchoolContacts.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if (result > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(EasySchoolContacts.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy) {
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId, EasySchoolContacts.CLOSE, updatedBy);
        if (result > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}

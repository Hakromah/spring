package com.hskspring.eazyschool.service;

import com.hskspring.eazyschool.constants.EasySchoolContacts;
import com.hskspring.eazyschool.model.Contact;
import com.hskspring.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j// it will provide log object
@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    /*
      save Contact Details into DB
      @param contact
      @return boolean
     */

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EasySchoolContacts.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if (null != savedContact && savedContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        List<Contact> contactMsgs = contactRepository.findByStatus(EasySchoolContacts.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(EasySchoolContacts.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if (null != updatedContact && updatedContact.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}

package com.hskspring.eazyschool.service;

import com.hskspring.eazyschool.constants.EasySchoolConstants;
import com.hskspring.eazyschool.model.Contact;
import com.hskspring.eazyschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public boolean saveMessageDetails(@RequestBody Contact contact) {
        boolean isSaved = false;
        contact.setStatus(EasySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if (null != savedContact && savedContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

//    public List<Contact> findMsgsWithOpenStatus() {
//        int pageSize =5;
//
//        List<Contact> contactMsgs = contactRepository.findByStatus(EasySchoolConstants.OPEN);
//        return contactMsgs;
//    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatusWithQuery(
                EasySchoolConstants.OPEN, pageable
        );
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId) {
        boolean isUpdated = false;
        int rows = contactRepository.updateMsgStatus(EasySchoolConstants.CLOSE, contactId);
        if (rows > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}

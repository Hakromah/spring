package com.hskspring.eazyschool.service;

import com.hskspring.eazyschool.constants.EasySchoolConstants;
import com.hskspring.eazyschool.model.Person;
import com.hskspring.eazyschool.model.Roles;
import com.hskspring.eazyschool.repository.PersonRepository;
import com.hskspring.eazyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EasySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}

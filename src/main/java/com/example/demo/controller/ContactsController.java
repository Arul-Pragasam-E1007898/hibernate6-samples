package com.example.demo.controller;


import com.example.demo.entities.SalesContact;
import com.example.demo.repository.SalesContactRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/contacts")
public class ContactsController {
    @Autowired
    private SalesContactRepository salesContactRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<SalesContact> getAllContacts() {
        return salesContactRepository.findAll();
    }

    @GetMapping(path="/create")
    public @ResponseBody SalesContact create() {
        SalesContact demo = SalesContact.builder().firstName("demo").build();
        return salesContactRepository.save(demo);
    }

    @GetMapping(path="{id}/get")
    public @ResponseBody SalesContact get(@PathVariable Long id) {
        return salesContactRepository.findById(id).get();
    }

    @GetMapping(path="{id}/update")
    public @ResponseBody SalesContact update(@PathVariable Long id) {
        //Session session = entityManager.unwrap(Session.class);
        //Filter filter = session.enableFilter("account_id");
        //filter.setParameter("account_id", "1653575335");

        SalesContact salesContact = salesContactRepository.findById(id).get();
        salesContact.setFirstName("demo-x");
        //SalesContact demo = SalesContact.builder().id(id).firstName("demo-xxx").build();
        return salesContactRepository.save(salesContact);
    }

    @GetMapping(path="{id}/delete")
    public @ResponseBody void delete(@PathVariable Long id) {
        salesContactRepository.deleteById(id);
    }
}


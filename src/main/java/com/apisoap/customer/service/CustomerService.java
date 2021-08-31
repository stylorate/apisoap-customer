package com.apisoap.customer.service;

import com.apisoap.customer.endpoint.CustomerEndpoint;
import com.apisoap.customer.persistence.entity.Customer;
import com.apisoap.customer.persistence.repository.CustomerRepository;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService extends BaseService {

    Logger log = Logger.getLogger(CustomerService.class);

    @Autowired
    CustomerRepository repository;

    @Autowired
    private ModelMapper mapper;

    public Customer createOrUpdate(Customer customer, soap_web_service.Customer req) {
        log.info("into Service");
        customer.setBondingDate(req.getBondingDate().toGregorianCalendar().getTime());
        customer.setBirthDate(req.getBirthDate().toGregorianCalendar().getTime());
        Optional<Customer> opt = repository.findByDocumentNumber(customer.getDocumentNumber());
        if (opt.isPresent()) {
            mapper.map(customer, opt.get());
            return repository.save(opt.get());
        }
        return repository.save(customer);
    }

    @Transactional(readOnly = true)
    public ArrayList<soap_web_service.Customer> getList() {
        log.info("into Service");
        ArrayList<Customer> list = (ArrayList<Customer>) repository.findAll();
        return (ArrayList<soap_web_service.Customer>) mapList(list, soap_web_service.Customer.class);
    }
}

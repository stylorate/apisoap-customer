package com.apisoap.customer.service;

import com.apisoap.customer.endpoint.CustomerEndpoint;
import com.apisoap.customer.persistence.entity.Customer;
import com.apisoap.customer.persistence.repository.CustomerRepository;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
public class CustomerService {

    Logger log = Logger.getLogger(CustomerService.class);

    @Autowired
    CustomerRepository repository;

    @Autowired
    private ModelMapper mapper;

    public Customer createOrUpdate(Customer customer, soap_web_service.Customer req) {
        log.info("into Service");
        customer.setBondingDate(req.getBondingDate().toGregorianCalendar().getTime());
        customer.setBirthDate(req.getBirthDate().toGregorianCalendar().getTime());
        log.info("after: " + customer.getBirthDate());
        log.info("after: " + customer.getBondingDate());
//        String pattern = "yyyy-MM-dd";
//        String pattern2 = "yyyy-MM-dd HH:mm:ss";
        Optional<Customer> opt = repository.findByDocumentNumber(customer.getDocumentNumber());
        log.info("after query " );
        if(opt.isPresent()){
            log.info("Entra if " );
            mapper.map(customer, opt.get());
            return repository.save(opt.get());
        }
        return repository.save(customer);
    }
}

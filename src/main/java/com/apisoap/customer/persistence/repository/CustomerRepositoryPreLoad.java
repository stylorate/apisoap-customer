package com.apisoap.customer.persistence.repository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import soap_web_service.Customer;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerRepositoryPreLoad {

    private static final Map<String, Customer> map = new HashMap<>();

    @PostConstruct
    public void initData() {
        Customer algo = new Customer();
        algo.setIdCustomer(1);
        algo.setName("Spain");
        algo.setLastName("Madrid");
        algo.setDocumentType("CC");
        algo.setDocumentNumber("123456789");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        try {
            algo.setBirthDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
            algo.setBondingDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        algo.setPosition("Manager");
        algo.setSalary(100.000);


        map.put(algo.getName(), algo);

    }

    public Customer findCustomer(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return map.get(name);
    }
}

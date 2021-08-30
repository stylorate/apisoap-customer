package com.apisoap.customer.endpoint;

import com.apisoap.customer.service.CustomerService;
import com.apisoap.customer.persistence.entity.Customer;
import com.apisoap.customer.persistence.repository.CustomerRepository;
import com.apisoap.customer.persistence.repository.CustomerRepositoryPreLoad;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soap_web_service.GetCustomerRequest;
import soap_web_service.GetCustomerResponse;


@Endpoint
public class CustomerEndpoint {

    private static final String NAMESPACE_URI = "soap-web-service";

    Logger log = Logger.getLogger(CustomerEndpoint.class);


    @Autowired
    private CustomerService service;

    @Autowired
    private ModelMapper mapper;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse createOrUpdate(@RequestPayload GetCustomerRequest request) {
        log.info("Into endpoint");
        GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(mapper.map(service.createOrUpdate(mapper.map(request.getCustomer(), Customer.class)
                , request.getCustomer())
                , soap_web_service.Customer.class));
        return response;
    }
}

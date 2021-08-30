package com.apisoap.customer.config;


import com.apisoap.customer.persistence.entity.Customer;
import org.apache.log4j.Logger;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;


@Configuration
public class MapperConfig {

    Logger log = Logger.getLogger(MapperConfig.class);

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        Converter<XMLGregorianCalendar, Date> conv = ctx -> ctx.getSource() == null
//                ? null : ctx.getSource().toGregorianCalendar().getTime();
        modelMapper.createTypeMap(soap_web_service.Customer.class, Customer.class);
        modelMapper.addMappings(new PropertyMap<Customer, Customer>() {
                    @Override
                    protected void configure() {
                        skip(destination.getIdCustomer());
//                        using(conv).map(source.getBondingDate()).setBondingDate(null);
//                        using(conv).map(source.getBondingDate()).setBirthDate(null);
                    }
                });


        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}

package com.apisoap.customer.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "ENTITY_SEQ", sequenceName = "ENTITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ENTITY_SEQ")
    @Column(name = "id_customer", updatable = false, nullable = false)
    private int idCustomer;
//    @NotBlank(message = "Name is mandatory")
    private String name;
//    @NotBlank(message = "LastName is mandatory")
    private String lastName;
//    @NotBlank(message = "Document type is mandatory")
    private String documentType;
//    @NotBlank(message = "IdCard is mandatory")
    private String documentNumber;
    //    @NotBlank(message = "BirthDate is mandatory")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    //    @NotBlank(message = "BondingDate is mandatory")
    @Temporal(TemporalType.DATE)
    private Date bondingDate;
//    @NotBlank(message = "Position is mandatory")
    private String position;
//    @NotBlank(message = "Salary is mandatory")
    private Double salary;

}

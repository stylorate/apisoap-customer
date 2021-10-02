package com.apisoap.customer.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;
import org.w3c.dom.Element;

import javax.wsdl.Fault;
import javax.wsdl.Message;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.xml.namespace.QName;
import java.util.List;
import java.util.Map;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{" + SQLExceptionHandler.NAMESPACE_URI + "}custom_fault",
        faultStringOrReason = "@faultString")
public class SQLExceptionHandler extends Exception {

    private static final long serialVersionUID = 1L;
    public static final String NAMESPACE_URI = "http://javaspringclub.com/exception";

    public SQLExceptionHandler(String message) {
        super(message);
    }
}

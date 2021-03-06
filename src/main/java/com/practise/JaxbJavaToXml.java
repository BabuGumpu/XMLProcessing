package com.practise;

import pojo.ObjectFactory;
import pojo.EmplyeeType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class JaxbJavaToXml {
    public static void main(String[] args) {


        try {
            JAXBContext jc = JAXBContext.newInstance("pojo");
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Create Employee Objects
            EmplyeeType employeeType = new EmplyeeType();
            employeeType.setFirstName("Gopal");
            employeeType.setSurName("Gumpu");
            employeeType.setPhone("9440017021");

            // Marshal Customer
            marshaller.marshal(employeeType, System.out);

            // Marshal Billing Address
            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<EmplyeeType> je = objectFactory.createEmplyee(employeeType);
            marshaller.marshal(je, System.out);

        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

    }
}
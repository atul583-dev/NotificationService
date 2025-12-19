package com.programs.notificationservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactUs {

    Long id;
    private String fullName;
    private String emailId;
    private String mobileNo;
    private String companyName;
    private String message;

    @Override
    public String toString() {
        String content = "Customer Details :" +
                "\nFull Name : " + fullName +
                "\n Email ID : " + emailId +
                "\n Mobile No : " + mobileNo +
                "\n Company Name : " + companyName +
                "\n Message : " + message;

        return content;
    }
}

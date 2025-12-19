package com.programs.notificationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactUsDto {

    Long id;
    private String fullName;
    private String emailId;
    private String mobileNo;
    private String companyName;
    private String message;
}

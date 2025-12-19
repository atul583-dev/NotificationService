package com.programs.notificationservice.utils.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programs.notificationservice.dto.ContactUsDto;
import com.programs.notificationservice.dto.NotificationDto;
import com.programs.notificationservice.model.ContactUs;
import com.programs.notificationservice.model.Notification;

import java.io.IOException;

public class NotificationMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Notification fromNotificationDto(NotificationDto dto) throws IOException {
        String json = objectMapper.writeValueAsString(dto);
        Notification model = objectMapper.readValue(json, Notification.class);

        return model;
    }

    public static NotificationDto fromNotification(Notification model) throws IOException {
        String json = objectMapper.writeValueAsString(model);
        return objectMapper.readValue(json, NotificationDto.class);
    }

    public static ContactUs fromContactUsDto(ContactUsDto dto) throws IOException {
        String json = objectMapper.writeValueAsString(dto);
        ContactUs model = objectMapper.readValue(json, ContactUs.class);

        return model;
    }

    public static ContactUsDto fromContactUs(ContactUs model) throws IOException {
        String json = objectMapper.writeValueAsString(model);
        return objectMapper.readValue(json, ContactUsDto.class);
    }

}

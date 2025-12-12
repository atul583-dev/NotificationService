package com.programs.notificationservice.controller;

import com.programs.notificationservice.dto.NotificationDto;
import com.programs.notificationservice.model.Notification;
import com.programs.notificationservice.service.NotificationService;
import com.programs.notificationservice.utils.mapper.NotificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notify")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDto notificationDto) {

        if (notificationDto == null || notificationDto.getRecipient() == null
                || notificationDto.getRecipient().isEmpty()) {
            throw new IllegalArgumentException("Request doesn't contain necessary fields. Failed to process notification.");
        }

        try {
            Notification notification = NotificationMapper.fromNotificationDto(notificationDto);

            switch (notificationDto.getNotificationType()) {
                case EMAIL:
                    notificationService.sendEmail(notification);
                    break;
                case SMS:
                    notificationService.sendMessage(notification);
                    break;
            }

            return ResponseEntity.ok("Notification sent successfully");

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process notification: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

}

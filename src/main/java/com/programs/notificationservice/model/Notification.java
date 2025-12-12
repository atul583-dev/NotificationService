package com.programs.notificationservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Notification {
    private Long id;

    private NotificationType notificationType;

    private String recipient;

    private String sender;

    private String subject;

    private String content;

    private Priority priority;

    private NotificationStatus status;
}

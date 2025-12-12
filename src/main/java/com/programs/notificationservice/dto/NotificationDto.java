package com.programs.notificationservice.dto;

import com.programs.notificationservice.model.NotificationStatus;
import com.programs.notificationservice.model.NotificationType;
import com.programs.notificationservice.model.Priority;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NotificationDto {

    private Long id;

    private NotificationType notificationType;

    private String recipient;

    private String sender;

    private String subject;

    private String content;

    private Priority priority;
}

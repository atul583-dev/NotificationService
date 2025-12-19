package com.programs.notificationservice.service;

import com.programs.notificationservice.model.ContactUs;
import com.programs.notificationservice.model.Notification;

public interface NotificationService {
    public void sendEmail(Notification notification);
    public void sendMessage(Notification notification);
    public void contactUs(ContactUs contactUs);
}

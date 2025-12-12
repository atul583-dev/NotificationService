package com.programs.notificationservice.service;

import com.programs.notificationservice.model.Notification;
import com.twilio.Twilio;
import org.springframework.stereotype.Service;
import com.twilio.type.PhoneNumber;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Value("${app.email.username}")
    private String emailUsername;

    @Value("${app.email.password}")
    private String emailPassword;

    @Value("${smtp.auth}")
    private String smtpAuth;

    @Value("${smtp.starttls.enable}")
    private String starttlsStatus;

    @Value("${smtp.host}")
    private String smtpHost;

    @Value("${smtp.port}")
    private String smtpPort;

    @Value("${twilio.accountsid}")
    private String accountSID;

    @Value("${twilio.auth}")
    private String authToken;

    @Value("${twilio.phonenumber}")
    private String phoneNumber;

    @Override
    public void sendEmail(Notification notification) {

        Properties props = new Properties();
        props.put(smtpAuth, "true");
        props.put(starttlsStatus, "true");
        props.put(smtpHost, "smtp.gmail.com");
        props.put(smtpPort, "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailUsername, emailPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailUsername));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(notification.getRecipient()));
            message.setSubject(notification.getSubject());
            message.setText(notification.getContent());

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(Notification notification) {

        Twilio.init(accountSID, authToken);

        try {
            // Create and send the message
            com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
                            new PhoneNumber(notification.getRecipient()),
                            new PhoneNumber(phoneNumber),
                            notification.getContent())
                    .create();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

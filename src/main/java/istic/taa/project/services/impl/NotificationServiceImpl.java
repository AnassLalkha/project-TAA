package istic.taa.project.services.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import istic.taa.project.constants.AppConfig;
import istic.taa.project.exceptions.TechnicalException;
import istic.taa.project.services.INotificationService;

@Component
public class NotificationServiceImpl implements INotificationService {
	private static final Logger LOG = Logger.getLogger(NotificationServiceImpl.class);
	@Autowired
	private AppConfig config;

	@Override
	public void sendMessage(istic.taa.project.model.Message msg) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(config.getDefaultNotificationUsername(),
						config.getDefaultNotificationPwd());
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(config.getDefaultNotificationUsername()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(msg.getEmail()));
			message.setSubject(msg.getSubject());
			message.setText(msg.doTemplate());

			Transport.send(message);
			LOG.info("Notification sent succeffuly to user : " + msg.getEmail());

		} catch (MessagingException e) {
			throw new TechnicalException("Unable to send email to user", e);
		}
	}
}

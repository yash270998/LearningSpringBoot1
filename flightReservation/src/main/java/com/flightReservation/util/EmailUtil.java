package com.flightReservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender sender;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	public void sendItinerary(String toAddress, String filepath) {
		LOGGER.info("Inside SendItinerary");
		MimeMessage msgMessage = sender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msgMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject("Itinerary for your flight");
			mimeMessageHelper.setText("Please find your PDF attached!");
			mimeMessageHelper.addAttachment("Itinerary", new File(filepath));
			sender.send(msgMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Exception :"+e);
		}
	}
}

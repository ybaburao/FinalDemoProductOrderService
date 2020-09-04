package com.cts.mc.email.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.cts.mc.email.exception.EmailException;
import com.cts.mc.email.model.EmailMessage;
import com.cts.mc.email.service.EmailService;

@SpringBootTest
@TestPropertySource(properties = {
	    "gmail.username=ybaburao@gmail.com",
	})
public class EmailControllerTest {

	@Value("${gmail.username}")
	private String username;

	@Autowired
	private EmailController controller;
	@Spy
    @InjectMocks
	private EmailService service;
	@Spy
	private Message msg;
	@Mock
	private InternetAddress internetAddress;

	@Test
	public void sendEmailTest() throws EmailException, MessagingException {

		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setTo_address("ybaburao@gmail.com");
		emailMessage.setBody("Welcome mail");
		emailMessage.setOrderId("1111");
		emailMessage.setSubject("Welcome to Mail for Testing");

		 assertThrows(EmailException.class, () -> {
			 controller.sendEmail(emailMessage);
		    });

	}


}

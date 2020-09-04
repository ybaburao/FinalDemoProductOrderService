package com.cts.mc.email.service;

import com.cts.mc.email.exception.EmailException;
import com.cts.mc.email.model.EmailMessage;
@FunctionalInterface
public interface IEmailService {
public String sendEmail(EmailMessage emailMessage)throws EmailException ;
}

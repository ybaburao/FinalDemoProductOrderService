package com.cts.mc.user.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.cts.mc.user.UserRegistrationApplication;

@Component
public class LambdaHandler implements RequestStreamHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(LambdaHandler.class);
	
    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    static {
        try {
        	logger.info("insideLambdaHandler");
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(UserRegistrationApplication.class);
        } catch (ContainerInitializationException e) {
        	logger.error("Exception Occured{}", e.getMessage());
        }
    }
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}

package com.example.store_email_configuration.service;

import com.example.store_email_configuration.model.EmailConfig;

public class EmailConfigsServiceImpl implements EmailConfigsService {
    @Override
    public void saveEmailConfigs(EmailConfig emailConfig) {
        EmailConfig emailConfig1 = EmailConfig.getInstance();
        emailConfig1.setLanguage(emailConfig.getLanguage());
        emailConfig1.setSignature(emailConfig.getSignature());
        emailConfig1.setPageSize(emailConfig.getPageSize());
        emailConfig1.setSpamFilter(emailConfig.isSpamFilter());
    }
}

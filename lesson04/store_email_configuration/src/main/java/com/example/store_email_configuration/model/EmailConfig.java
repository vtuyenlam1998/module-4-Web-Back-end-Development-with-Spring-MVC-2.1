package com.example.store_email_configuration.model;

public class EmailConfig {
    private String language = "Vietnamese";
    private int pageSize = 5;
    private boolean spamFilter = true;
    private String signature = "Tuyền Lâm\r\n\r\n\r\n21K Nguyễn Văn Trỗi, Phú Nhuận";
    private static final EmailConfig emailConfig = new EmailConfig();
    public static EmailConfig getInstance(){
        return emailConfig;
    }

    private EmailConfig() {
    }

    public EmailConfig(String language, int pageSize, boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

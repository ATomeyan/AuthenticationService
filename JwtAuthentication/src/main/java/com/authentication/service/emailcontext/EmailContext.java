package com.authentication.service.emailcontext;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Tomeyan
 * @date 02.01.2023
 */
@Data
public abstract class EmailContext {

    private String from;
    private String to;
    private String subject;
    private String email;
    private String attachment;
    private String fromDisplayName;
    private String emailLanguage;
    private String displayName;
    private String templateLocation;
    private Map<String, Object> context;

    public EmailContext() {
        this.context = new HashMap<>();
    }

    public abstract <T> void init(T context);

    public Object put(String key, Object value) {
        return key == null ? null : this.context.put(key.intern(), value);
    }
}
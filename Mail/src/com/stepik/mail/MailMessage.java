package com.stepik.mail;

import java.util.Objects;

/*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
public class MailMessage extends AbstractSendable {

    private final String message;

    public MailMessage(String from, String to, String message) {
        super(from, to);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailMessage that = (MailMessage) o;

        return Objects.equals(message, that.message);
    }

}


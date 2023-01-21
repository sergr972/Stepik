package com.stepik.mail;

import java.util.logging.Logger;

/*
2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется
от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения
полей почты):
        2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с
        уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
        2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
*/
public class Spy implements MailService {

    public static Logger LOGGER;

    public static final String AUSTIN_POWERS = "Austin Powers";

    public Spy(Logger logger) {
        LOGGER = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail.getClass() == MailMessage.class) {
            MailMessage mailMessage = (MailMessage) mail;
            String from = mailMessage.getFrom();
            String to = mailMessage.getTo();
            if (from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS)) {
                LOGGER.warning("Detected target mail correspondence: from " + from + " to " + to + " \"" + mailMessage.getMessage() + "\"");
            } else {
                LOGGER.info("Usual correspondence: from " + from + " to " + to + "");
            }
        }
        return mail;
    }
}
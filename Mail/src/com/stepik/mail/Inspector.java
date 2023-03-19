package com.stepik.mail;

/*
4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состаящую из
камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны
объявить самостоятельно в виде непроверяемых исключений.
*/
class IllegalPackageException extends RuntimeException {}
class StolenPackageException extends RuntimeException {}

public class Inspector implements MailService {
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";
    @Override
    public Sendable processMail(Sendable mail) {
        if(mail.getClass() == MailPackage.class) {
            Package pac = ((MailPackage)mail).getContent();
            String content = pac.getContent();
            if(content.indexOf("stones instead of ") == 0) {
                throw new StolenPackageException();
            } else if(content.equals(WEAPONS) || content.equals(BANNED_SUBSTANCE)){
                throw new IllegalPackageException();
            }
        }
        return mail;
    }
}

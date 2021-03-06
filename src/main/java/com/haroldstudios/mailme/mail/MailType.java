package com.haroldstudios.mailme.mail;

import com.haroldstudios.mailme.MailMe;
import org.bukkit.entity.Player;

public enum MailType {
    // Reminder this shouldn't be more than 16 characters (for database)
    MESSAGE, BOOK, ITEM, CONSOLE_CMD;

    public static MailType getMailTypeFromMail(Mail mail) {
        if (mail instanceof MailMessage) {
            return MESSAGE;
        } else if (mail instanceof MailItems) {
            return ITEM;
        } else if (mail instanceof MailBook) {
            return BOOK;
        } else if (mail instanceof MailConsoleCommand) {
            return CONSOLE_CMD;
        }

        return null;
    }

    public static MailType getMailTypeFromMail(Mail.Builder<?> mail) {
        if (mail instanceof MailMessage.Builder) {
            return MESSAGE;
        } else if (mail instanceof MailItems.Builder) {
            return ITEM;
        } else if (mail instanceof MailBook.Builder) {
            return BOOK;
        } else if (mail instanceof MailConsoleCommand.Builder) {
            return CONSOLE_CMD;
        }

        return null;
    }

    public static String getLanguageType(MailType type, Player player) {
        switch (type) {
            case MESSAGE:
                return MailMe.getInstance().getLocale().getMessage(player, "mail-types.message");
            case ITEM:
                return MailMe.getInstance().getLocale().getMessage(player, "mail-types.item");
            case BOOK:
                return MailMe.getInstance().getLocale().getMessage(player, "mail-types.book");
            case CONSOLE_CMD:
                return MailMe.getInstance().getLocale().getMessage(player, "mail-types.console");
            default:
                return "";
        }
    }
}

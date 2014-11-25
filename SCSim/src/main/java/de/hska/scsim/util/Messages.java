package de.hska.scsim.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

    private static final String german = "messages_de";
    private static final String english = "messages_en";

    private Messages() {
    }

    public static String getString(String key) {
        try {

            if (Locale.getDefault().equals(Locale.GERMANY)) {
                return ResourceBundle.getBundle(german).getString(key);
            } else {
                return ResourceBundle.getBundle(english).getString(key);
            }
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}

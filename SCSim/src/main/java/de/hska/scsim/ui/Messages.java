package de.hska.scsim.ui;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String german = "messages_de"; //$NON-NLS-1$
	private static final String english = "messages_en"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE_DE = ResourceBundle.getBundle(german);
	private static final ResourceBundle RESOURCE_BUNDLE_EN = ResourceBundle.getBundle(english);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			
			if(Locale.getDefault().equals(Locale.GERMANY)) {
				return RESOURCE_BUNDLE_DE.getString(key);
			}
			else {
				return RESOURCE_BUNDLE_EN.getString(key);
			}
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}

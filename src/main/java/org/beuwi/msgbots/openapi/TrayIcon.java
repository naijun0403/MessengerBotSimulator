package org.beuwi.msgbots.openapi;

import java.awt.Toolkit;

public class TrayIcon extends java.awt.TrayIcon {
	public TrayIcon() {
		super(Toolkit.getDefaultToolkit().createImage("icon.png"));

		// setToolTip();
		// setPopupMenu();
		setImageAutoSize(true);
	}

	public void display(String title, String message) {
        displayMessage(title, message, MessageType.NONE);
    }
}
package org.beuwi.msgbots.openapi;

import java.awt.SystemTray;

// Window Notification
public class WinNotice
{
	private final SystemTray tray;
	private final TrayIcon icon;

	public WinNotice()
	{
		tray = SystemTray.getSystemTray();
		icon = new TrayIcon();

		try
		{
			tray.add(icon);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

    public void display(String title, String message)
    {
        icon.display(title, message);
    }
}
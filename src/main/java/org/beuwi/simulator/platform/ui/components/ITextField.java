package org.beuwi.simulator.platform.ui.components;

import javafx.scene.control.TextField;

public class ITextField extends TextField
{
	{
		this.getStyleClass().add("ifx-text-field");
	}

	public ITextField()
	{
		this.setContextMenu(new IContextMenu
		(
			new IMenuItem("Cut", "Ctrl + X", event -> this.cut()),
			new IMenuItem("Copy", "Ctrl + C", event -> this.copy()),
			new IMenuItem("Paste", "Ctrl + V", event -> this.paste())
		));
	}
}
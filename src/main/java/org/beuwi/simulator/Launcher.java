package org.beuwi.simulator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.beuwi.simulator.platform.application.parts.activitybar.ActiveAreaView;
import org.beuwi.simulator.platform.application.parts.editorarea.EditorAreaView;
import org.beuwi.simulator.platform.application.parts.toolbar.ToolBarView;
import org.beuwi.simulator.platform.application.views.*;

import java.io.File;
import java.io.FileInputStream;

public class Launcher extends Application
{
	@Override
	public void start(Stage stage)
	{
		try
		{
			/* Text Anti Aliasing */
			System.setProperty("prism.lcdtext", "false");
			System.setProperty("prism.subpixeltext", "false");

			/* Load Fonts */
			File[] fonts = new File(getClass().getResource("/fonts").toURI()).listFiles();

			for (File font : fonts)
			{
				Font.loadFont(new FileInputStream(font), 0);
			}

			// WindowStage.setPrimaryStage(stage);



			AnchorPane root = new AnchorPane();

			root.getStylesheets().add(getClass().getResource("/themes/default.css").toExternalForm());

			BorderPane pane = new MainWindowView();
			pane.setMinSize(1100, 700);
			pane.setPrefSize(1300, 900);

			AnchorPane anpMenuBar      = new ToolBarView();
			AnchorPane anpActiveArea   = new ActiveAreaView();
			AnchorPane anpEditorArea   = new EditorAreaView();
			AnchorPane anpStatusBar    = new StatusBarView();

			pane.setTop(anpMenuBar);
			pane.setLeft(anpActiveArea);
			pane.setCenter(anpEditorArea);
			pane.setBottom(anpStatusBar);

			// init Actions
			// AddEditorTabAction.initialize();
			// CloseEditorTabAction.initialize();
			//ResizeActiveAreaAction.initialize();

			// getStyleClass().add()

			// pane.getStyleClass().add("main");
			// root.getStyleClass().add("window");

			root.getStylesheets().add(getClass().getResource("/themes/darcula.css").toExternalForm());

			root.getChildren().add(pane);

			AnchorPane.setTopAnchor(pane, .0);
			AnchorPane.setRightAnchor(pane, .0);
			AnchorPane.setBottomAnchor(pane, .0);
			AnchorPane.setLeftAnchor(pane, .0);

			// new WindowView(stage, pane, WindowType.WINDOW);

			stage.setMinWidth(250);
			// stage.setMinHeight();
			stage.setWidth(1300);
			stage.setHeight(900);
			// stage.setMaxWidth(Double.MAX_VALUE);
			// stage.setMaxHeight(Double.MAX_VALUE);

			stage.setScene(new Scene(root));
			stage.show();

			// toFront가 안먹히는 문제점 수정해야됨
			stage.toFront();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void stop()
	{

	}


	public static void main(String[] args)
	{
		launch(args);
	}
}

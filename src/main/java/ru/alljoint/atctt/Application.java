package ru.alljoint.atctt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

@Lazy
@SpringBootApplication
public class Application extends AbstractJavaFxApplicationSupport {
	@Value("${ui.title:JavaFX приложение}")//
    private String windowTitle;

	@Qualifier("mainView")
    @Autowired
    private ConfigurationControllers.View view;
	
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(windowTitle);
        
//        Group root = new Group();
//        Scene scene = new Scene(root, 400, 250, Color.WHITE);
//        TabPane tabPane = new TabPane();
//        BorderPane borderPane = new BorderPane();
        
//        Tab tab = new Tab();
//        tab.setText("Табличный отчет");
//        tab.setClosable(false);
//        tab.setContent(view.getView());
//        tabPane.getTabs().add(tab);
//
//        tab = new Tab();
//        tab.setText("Диаграмма");
//        tab.setClosable(false);
//        HBox hbox = new HBox();
//        hbox.getChildren().add(new Label("Диаграмма"));
//        hbox.setAlignment(Pos.CENTER);
//        tab.setContent(hbox);
//        tabPane.getTabs().add(tab);

//        borderPane.prefHeightProperty().bind(scene.heightProperty());
//        borderPane.prefWidthProperty().bind(scene.widthProperty());

//        borderPane.setCenter(tabPane);
//        root.getChildren().add(borderPane);
        
//        stage.setScene(new Scene(tabPane));
//		stage.setResizable(true);
//		stage.centerOnScreen();
//		stage.show();
        
        stage.setScene(new Scene(view.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }
}

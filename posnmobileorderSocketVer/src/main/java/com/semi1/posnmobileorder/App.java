package com.semi1.posnmobileorder;


import com.semi1.mobile.MobileHome;
import com.semi1.pos.Login;
import com.semi1.pos.MainHome;
import com.semi1.testarea.TestForm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = SystemInfo.javaVersion();
        String javafxVersion = SystemInfo.javafxVersion();

        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        //TestForm f = new TestForm();
        //CloseStore f = new CloseStore();
        //SalesControl f = new SalesControl();
        
        Login f1 = new Login();
        Login f2 = new Login();
        MobileHome f3 = new MobileHome();
        f1.show();
        f2.show();
        f3.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
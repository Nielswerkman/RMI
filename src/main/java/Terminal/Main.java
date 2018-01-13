package main.java.Terminal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.Repository.HibernateProductRepository;
import main.java.Shared.Models.Product;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private static HibernateProductRepository productRepo = new HibernateProductRepository();
    public static List<Product> mijnVoorraadLijst = new ArrayList<Product>();
    public static VoorraadNotificationListener voorraadNotificationListener;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        try{
            voorraadNotificationListener = new VoorraadNotificationListener();
        }catch (RemoteException ex){
            ex.printStackTrace();
        }
    }

    public static void updateVoorraadLijst(){
        Main.mijnVoorraadLijst = productRepo.findAll();
    }
}

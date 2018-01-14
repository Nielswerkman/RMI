package Terminal;

import Data.RMI.MutatieRMI;
import Data.RMI.VoorraadBestelRMI;
import Data.RMI.VoorraadRMI;
import Repository.HibernateProductRepository;
import Shared.Interfaces.IMutatieBeheer;
import Shared.Interfaces.IVoorraadBeheer;
import Shared.Interfaces.IVoorraadBestelBeheer;
import Shared.Models.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public class Main extends Application {

    private static HibernateProductRepository productRepo = new HibernateProductRepository();
    public static List<Product> mijnVoorraadLijst = new ArrayList<Product>();
    public static VoorraadNotificationListener voorraadNotificationListener;

    public static IMutatieBeheer mutatieBeheer;
    public static IVoorraadBeheer voorraadBeheer;
    public static IVoorraadBestelBeheer voorraadBestelBeheer;
    public static Controller c;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Terminal");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
        c = loader.getController();

    }


    public static void main(String[] args) {
        try{
            mutatieBeheer = new MutatieRMI().getMutatieBeheer();
            voorraadBeheer = new VoorraadRMI().getVoorraadBeheer();
            voorraadBestelBeheer = new VoorraadBestelRMI().getVoorraadBestelBeheer();

            voorraadNotificationListener = new VoorraadNotificationListener();

            mijnVoorraadLijst = voorraadBeheer.getProducten();

        }catch (RemoteException ex){
            ex.printStackTrace();
        }
//        Product p = new Product("Cola", 12, 4, new Date());
//        User u = new User("Niels", "Niels12", "Werkman");
//        new HibernateUserRepository().create(u);
//        productRepo.create(p);

//        User u = (User) new HibernateUserRepository().findAll().get(0);
//        Product p = (Product) productRepo.findAll().get(0);
//        try {
//            mutatieBeheer.AddMutatie(p, "Kapot", u);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

        launch(args);

    }

    public static void updateVoorraadLijst(){
        System.out.println("Ik ga een update doen!");
        mijnVoorraadLijst = productRepo.findAll();
    }
}

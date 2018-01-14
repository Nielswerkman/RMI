package Terminal;

import Shared.Models.Mutatie;
import Shared.Models.Product;
import Shared.Models.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.rmi.RemoteException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Controller {

    //region FXMl

    @FXML
    public Label userLabel;
    @FXML
    public ListView defaultProductTable;
    @FXML
    public ListView productenOpDatumTable;
    @FXML
    public ListView voorraadAanpassenTable;
    @FXML
    public ListView mutatiesTable;
    @FXML
    public DatePicker vindProductPicker;
    @FXML
    public DatePicker nieuweDatumPicker;
    @FXML
    public DatePicker vindMutatiePicker;
    @FXML
    public TextField loginField;
    @FXML
    public TextField wachtwoordField;
    @FXML
    public TextField redenField;
    @FXML
    public TextField voorraadAantalField;
    @FXML
    public javafx.scene.control.Button refreshButton;
    @FXML
    public Button loginButton;
    @FXML
    public Button vindProductButton;
    @FXML
    public Button nieuweDatumButton;
    @FXML
    public Button muteerButton;
    @FXML
    public Button vraagVoorraadOpButton;
    @FXML
    public Button updateVoorraadButton;
    @FXML
    public Button vindMutatiesButton;

    //endregion

    @FXML
    protected void initialize() throws RemoteException{
        defaultProductTableRefresh();
    }

    private List<Product> productenOpDatum = new ArrayList<Product>();
    private List<Mutatie> mutatieLijst = new ArrayList<Mutatie>();

    private User user = new User("Niels", "Niels12", "Werkman");

    public void refreshButtonClicked(){
        defaultProductTableRefresh();

    }

    public void loginButtonClicked(){

    }

    public void vindProductButtonClicked(){
        String date = vindProductPicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date d = new Date(date);
        try {
            productenOpDatum = Main.mutatieBeheer.GetProductenOpDatum(d);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        productenOpDatumTableRefresh();

    }

    public void nieuweDatumButtonClicked(){
        System.out.println("New Date Clicked!");
//        String date = nieuweDatumPicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date d = new Date();
        try {
            Main.mutatieBeheer.SetNewProductDatum((Product) defaultProductTable.getSelectionModel().getSelectedItems().get(0), d);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        defaultProductTableRefresh();

    }

    public void muteerButtonClicked(){
        try {
            Main.mutatieBeheer.AddMutatie((Product) defaultProductTable.getSelectionModel().getSelectedItems().get(0), redenField.getText(), user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        mutatiesTableRefresh();

    }

    public void vraagVoorraadOpButtonClicked(){
        int voorraad = 0;

        try {
            voorraad = Main.voorraadBeheer.getProductVoorraad((Product) voorraadAanpassenTable.getSelectionModel().getSelectedItems().get(0));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        voorraadAantalField.setText(Integer.toString(voorraad));

    }

    public void updateVoorraadButtonClicked(){
        Product p = (Product) voorraadAanpassenTable.getSelectionModel().getSelectedItems().get(0);
        p.setAantal(Integer.getInteger(voorraadAantalField.getText()));

        try {
            Main.voorraadBeheer.updateProductVoorraad(p);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        voorraadAanpassenTableRefresh();

    }

    public void vindMutatiesButtonClicked(){
        String date = vindMutatiePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date d = new Date(date);

        try {
            Main.mutatieBeheer.GetMutatiesVanDatum(d);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        mutatiesTableRefresh();

    }

    private void defaultProductTableRefresh(){
        List<Product> plist = Main.mijnVoorraadLijst;
         defaultProductTable.setItems(FXCollections.observableList(plist));
    }

    private void productenOpDatumTableRefresh(){
        defaultProductTable.setItems(FXCollections.observableList(productenOpDatum));

    }

    private void voorraadAanpassenTableRefresh(){
        voorraadAanpassenTable.setItems(FXCollections.observableList(Main.mijnVoorraadLijst));

    }

    private void mutatiesTableRefresh(){
        mutatiesTable.setItems(FXCollections.observableList(mutatieLijst));

    }

    private void refresh(){
        voorraadAanpassenTableRefresh();
        mutatiesTableRefresh();
        defaultProductTableRefresh();
        productenOpDatumTableRefresh();
    }





}

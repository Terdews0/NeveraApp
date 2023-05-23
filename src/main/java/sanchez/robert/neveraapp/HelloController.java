package sanchez.robert.neveraapp;

import david.duarte.Fitxers;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import sanchez.robert.neveraapp.clases.Producte;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class HelloController {


    @FXML
private Button BTGuarda;
@FXML
private Label LProductes1;
@FXML
private TextField TFNom1;
@FXML
private Text TNom1;
@FXML
private TextField TFPreu1;
@FXML
private Text TPreu1;
@FXML
private TextField TFDescripcio1;
@FXML
private Text TDescripcio1;
@FXML
private Text TDataCaducitat1;
@FXML
private DatePicker DPDataCaducitat1;
@FXML
private Button BTTreu;
@FXML
private Button BTPrimer;
@FXML
private Button BTAbans;
@FXML
private Button BTDespres;
@FXML
private Button BTUltim;
@FXML
private Label LProductes;
@FXML
private TextField TFNom;
@FXML
private Text TNom;
@FXML
private TextField TFPreu;
@FXML
private Text TPreu;
@FXML
private TextField TFDescripcio;
@FXML
private Text TDescripcio;
@FXML
private Text TDataCaducitat;
@FXML
private DatePicker DPDataCaducitat;
@FXML
private Button BTCerca;









    static  Fitxers f = new Fitxers();

    static Producte p =new Producte();
    static String fitxer= ".data/productes.csv";

    public void guardar() throws Exception {

        f.escriuText(fitxer, "-" + TFNom1.getText() + "\n-" + TFPreu1.getText() + "\n-" + TFDescripcio1.getText() + "\n-" +  DPDataCaducitat1.getValue()+"\n", true);
        LProductes1.setText("-" + TFNom1.getText() + "\n-" + TFPreu1.getText() + "\n-" + TFDescripcio1.getText() + "\n-" + DPDataCaducitat1.getValue()+"\n");


    }


//    public void cerca() {
//
//        String impresio;
//
//        f.buscar(fitxer, TFNom.getText());
//
//        if (f.buscar(fitxer, TFNom.getText())) {
//
//
//
//        }
//        impresio=f.imprimirBuscat(fitxer, TFNom.getText());
//        LProductes.setText(impresio);
//    }

    private void actualitzaPantalla() throws IOException, InterruptedException {
        /*contingutFitxer = p.retornaLlistaPersones();
        LBNumPersones.setText(contingutFitxer.size() + " persones");      // quantitat de persones en el fitxer
        String text = "";

        for (Persona pers : contingutFitxer) {
            text = text +
                    pers.getNom() + " " + pers.getCognom() + "\n" +
                    pers.getEdat() + " anys\n"
                    + pers.getSou() + " €" + "\n\n";
        }

        TAPantalla.setText(text);
        BTGuardaPersona.setText("Guarda");*/
    }

    /**
     * Tot el que vullguem executar a l'arranc del formulari
     *
     * @throws IOException          excepció d'E/S
     * @throws InterruptedException excepció d'interrupció
     */
    /*public void initialize() throws IOException, InterruptedException {

        // comprovem que existeix el fitxer i si és així
        // llegim el fitxer
        // formatem les dades de les persones de manera més amigable
        if (f.existeix(p.getFitxer())) {
            actualitzaPantalla();
        }
    }*/

    /**
     * Buidem els Text Fields
     */
    /*private void netejaCamps() {

        TFNom.setText("");
        TFCognom.setText("");
        TFEdat.setText("");
        TFSou.setText("");

        TFCognom.setDisable(false);

    }*/

    /**
     * botó de guardar persona
     *
     * @throws IOException          Excepció d'Entrada / Sortida
     * @throws InterruptedException Excepció d'interrupció
     */
    /*public void guardaPersona() throws IOException, InterruptedException {

        LBError.setText("");

        // Ens assegurem que tots els camps estàn plens
        if (
                TFNom.getText().length() >= 1 &&
                        TFCognom.getText().length() >= 1 &&
                        TFEdat.getText().length() >= 1 &&
                        TFSou.getText().length() >= 1
        ) {

            // Agafem els camps dels TextFields
            String nom = TFNom.getText();
            String cognom = TFCognom.getText();
            int edat = Integer.parseInt(TFEdat.getText());
            double sou = Double.parseDouble(TFSou.getText());

            // Construïm una persona amb aquests camps
            Persona pers = new Persona(nom, cognom, edat, sou);

            // Agafem el text del botó (per comprovar si guardem o modifiquem)
            String textBoto = BTGuardaPersona.getText();

            // si volem modificar
            if (!textBoto.equals("Guarda")) {
                BTGuardaPersona.setText("Guarda");
                pers.modificarPersona();
            } else {                    // si volem guardar
                pers.guardaPersona();
            }
            netejaCamps();              // reiniciem els TextFields
            actualitzaPantalla();       // recarreguem el fitxer al TextArea
        } else {
            // En cas que no hagim posat algun dels camps als textFields. Missatge de Warning avisant
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("ERROR");
            al.setContentText("Has d'omplir tots els camps");
            al.show();
        }
    }*/

    /**
     * botó de cercar persones
     *
     * @throws IOException          Excepció d'Entrada / Sortida
     * @throws InterruptedException Excepció d'interrupció
     */
    public void cercaProducte() throws IOException, InterruptedException, ParseException {
        //LBError.setText("");
        String nom = TFNom.getText();
        int preu = Integer.parseInt(TFPreu.getText());
        String descripcio = TFDescripcio.getText();
        LocalDate localDate = DPDataCaducitat.getValue();
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
        Date data = new Date(sqlDate.getTime());

        if (nom != null && !nom.isEmpty()) {
            //cercaPerNom

        }

        List<Producte> llista = p.cercarPerNom(nom);

        if (llista.isEmpty()) {
            //LBError.setText("Aquesta persona no existeix");
            //netejaCamps();
        } else {            // agafem sols la primera persona de la llista (per fer-ho més fàcil)
            Producte prod = llista.get(0);

            // canviem el text al botó
            BTGuardaPersona.setText("Modifica");

            // afegim els camps TextField amb les dades de la persona
            TFNom.setText(prod.getNom());
            TFPreu.setText(String.valueOf(prod.getPreu()));
            TFDescripcio.setText(prod.getDescripcio());
            TF.setText(String.valueOf(prod.getSou()));

            TFCognom.setDisable(true);
        }
    }

    private void comprovaBotonera() throws IOException, ParseException, InterruptedException {

        Producte p = new Producte();

        if(numPersonesCerca>0){
            BTPrimer.setDisable(false);
            BTAbans.setDisable(false);
        } else{
            BTPrimer.setDisable(true);
            BTAbans.setDisable(true);
            BTUltim.setDisable(false);
        }

        if(numPersonesCerca>p.retornaLlistaproductes().size() - 1){
            BTUltim.setDisable(false);
            BTDespres.setDisable(false);
        } else{
            BTUltim.setDisable(true);
            BTDespres.setDisable(true);
            BTPrimer.setDisable(false);
        }
    }

    int numPersonesCerca = 0;

    public void btPrimer() throws IOException, ParseException, InterruptedException {
        numPersonesCerca = 0;
        comprovaBotonera();
        //mostraProducte(LProductes.get(numPersonesCerca));
    }

    public void btAbans() throws IOException, ParseException, InterruptedException {
        numPersonesCerca--;
        comprovaBotonera();
        //mostraProducte(LProductes.get(numPersonesCerca));
    }

    public void btDespres() throws IOException, ParseException, InterruptedException {
        numPersonesCerca++;
        comprovaBotonera();
        //mostraProducte(LProductes.get(numPersonesCerca));
    }

    public void btUltim() throws IOException, ParseException, InterruptedException {
        //numPersonesCerca = llistaProductes.size() - 1;
        comprovaBotonera();
        //mostraProducte(LProductes.get(numPersonesCerca));
    }

}
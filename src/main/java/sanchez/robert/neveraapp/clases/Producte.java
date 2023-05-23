package sanchez.robert.neveraapp.clases;

import david.duarte.Fitxers;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Producte {


    private String nom;
    private int preu;
    private String descripcio;
    private Date dataCaduc;

    static final String fitxer = ".data/productes.csv";
    static final Fitxers f = new Fitxers();

    public Producte() {
    }

    public Producte(String nom, int preu, String descripcio, Date dataCaduc) {
        this.nom = nom;
        this.preu = preu;
        this.descripcio = descripcio;
        this.dataCaduc = dataCaduc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Date getDataCaduc() {
        return dataCaduc;
    }

    public void setDataCaduc(Date dataCaduc) {
        this.dataCaduc = dataCaduc;
    }


//</editor-fold>

    //<editor-fold desc="MÈTODES">
    // toString


    // guardar Producte fitxer


    /**
     * Guarda Producte.
     *
     * @throws IOException the io exception
     */
    public void guardaProducte() throws IOException {
//        String text;
//        text=getNom()+";"+getPreu()+";"+getEdat()+";"+getSou();
        f.escriuText(fitxer, this.toString(), true);

    }

    public List<Producte> cercarPerNom(String nom) throws IOException, InterruptedException, ParseException {
        List<Producte> productesTrobats = new ArrayList<>();
        List<Producte> llistaProductes = retornaLlistaproductes();

        for (Producte producte : llistaProductes) {
            if (producte.getNom().equals(nom)) {
                productesTrobats.add(producte);
            }
        }

        return productesTrobats;
    }



    /**
     * Retorna string productes string.
     *
     * @return the string
     */
    public String retornaStringproductes() throws Exception {
        return f.retornarFitxer(fitxer);
    }

    /**
     * Cercar per preu string.
     *
     * @param preuACercar the preu a cercar
     * @return the string
     */
    // cercar per cogonom
    public List<Producte> cercarPerPreu(String preuACercar) throws Exception {
        List<String> productes = Collections.singletonList(f.retornar(fitxer, "UTF-8"));
        String preu;
        List<Producte> productesTrobades = new ArrayList<>();

        for (String fila : productes) {
            String[] dades = fila.split(";");
            preu = dades[1];
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dataCaducitat = format.parse(dades[3]);
            if (preu.equals(preuACercar)) {
                Producte pers = new Producte(
                        dades[0],
                        Integer.parseInt(preu),
                        dades[2],
                        dataCaducitat
                );

                productesTrobades.add(pers);
            }
        }

        return productesTrobades;
    }


    /**
     * Retorna productes Producte [ ].
     *
     * @return the Producte [ ]
     * @deprecated perquè tenim el mètode que retorna una llista de productes
     */
    @Deprecated
    public Producte[] retornaproductes() throws IOException, InterruptedException, ParseException {

        String productes = f.retornar(fitxer,"UTF-8");

        String[] files = productes.split(";");
        int cont = files.length;


        Producte[] arrayproductes = new Producte[cont];


        for (int i = 0; i < files.length; i++) {
            String[] dades = files[i].split(";");
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dataCaducitat = format.parse(dades[3]);

            Producte p1 = new Producte(
                    dades[0],
                    Integer.parseInt(dades[1]),
                    dades[2],
                    dataCaducitat);

            arrayproductes[i] = p1;

        }
        return arrayproductes;
    }

    /**
     * Retorna productes Producte [ ].
     *
     * @return the Producte [ ]
     */
    public List<Producte> retornaLlistaproductes() throws IOException, InterruptedException, ParseException {

        String productes = f.retornar(fitxer,"UTF-8");

        String[] files = productes.split("\n");


        List<Producte> llista = new ArrayList<>();


        for (int i = 0; i < files.length; i++) {
            String[] dades = files[i].split(";");
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date dataCaducitat = format.parse(dades[3]);

            Producte p1 = new Producte(
                    dades[0],
                    Integer.parseInt(dades[1]),
                    dades[2],
                    dataCaducitat);

            llista.add(p1);

        }
        return llista;
    }


    /**
     * Elimina una Producte del fitxer a partir del seu preu.
     *
     * @param preu preu de la Producte a eliminar
     * @throws IOException Excepció d'Entrada/Sortida
     * @see #retornaproductes()
     */


    public void eliminaProducte(String preu) throws IOException, InterruptedException, ParseException {
        Producte[] productes = retornaproductes();
        boolean afegir = false;
        boolean trobat=false;

        for (int i = 0; i < productes.length; i++) {
            // sobreescrivim el fitxer excloent la Producte a eliminar
            if ((productes[i].getPreu() != Integer.parseInt(preu)) || trobat) {
                f.escriuText(fitxer, productes[i].toString(), afegir);
                afegir = true;
            }else{
                trobat=true;        // així sols eliminem una sola Producte amb el preu i no totes
            }
        }
    }

    @Override
    public String toString() {
        return nom + ";" + preu + ";" + descripcio + ";" + dataCaduc;
    }

    //</editor-fold>

}

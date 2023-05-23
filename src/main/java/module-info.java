module sanchez.robert.neveraapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires fitxers.llibreria;
    requires java.sql;


    opens sanchez.robert.neveraapp to javafx.fxml;
    exports sanchez.robert.neveraapp;
}
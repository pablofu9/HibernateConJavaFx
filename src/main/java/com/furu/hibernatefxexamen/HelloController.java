package com.furu.hibernatefxexamen;

import alertas.Alerts;
import com.jfoenix.controls.*;
import entity.Zona;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.CRUD_Zonas;
import util.HibernateUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private JFXTextField txtIdZona, txtNombreZona;

    @FXML
    private JFXButton btn,btnModificar;

    @FXML
    private TabPane tabPane;

    @FXML
    private JFXListView listaZonas;


    @FXML
    private StackPane stack;

    @FXML
    JFXDialog dialog;


    private void cargarLista(){
        try{
            List<Zona> zonas = CRUD_Zonas.llenarTabla();
            listaZonas.setItems(FXCollections.observableList(zonas));
        }catch (Exception e){
            Alerts.crearAlertaError(stack, "No se pudo cargar la lista");
        }
    }

    //Mandamos la zona seleccionada en la tabla a los campos de texto
    @FXML
    public void zonaCargada(Zona z){
        txtIdZona.setText(String.valueOf(z.getId_zona()));
        txtNombreZona.setText(z.getNombre_zona());
    }

    //Metodo de onMouseClicked de la tabla, para ver que zona esta seleccionada
    @FXML
    public void zonaSelected(){
        Zona zonaSel = (Zona) listaZonas.getSelectionModel().getSelectedItem();
        zonaCargada(zonaSel);
    }

    @FXML
    public void limpiar(){
        txtNombreZona.setText("");
        txtIdZona.setText("");
    }
    @FXML
    private void click(){
        /*Boton que usamos para crear la zona nueva, usa el metodo insertarzona CRUD_Zonas
        Comprobamos que el textfield del nombre de zona este relleno, para no enviar a la DB campos vacios,
        el id es autoincrement
         */
        Zona nuevaZona = new Zona(txtNombreZona.getText());

        if(txtNombreZona.getText().isEmpty()){
             //Creamos una ventana de aviso de que falta el nombre y la hacemos visible

            Alerts.crearAlertaError(stack, "Dame un nombre");

        }else{
            CRUD_Zonas.insertarZona(nuevaZona);
            Alerts.crearAlertaInfo(stack, "Nueva zona insertada");
        }

    }
    @FXML
    private void modificar(){
        Zona zonaModified = new Zona(Integer.parseInt(txtIdZona.getText()), txtNombreZona.getText());
        CRUD_Zonas.modificarZona(Integer.parseInt(txtIdZona.getText()), txtNombreZona.getText());
        Alerts.crearAlertaInfo(stack,"Zona modificada");
        cargarLista();
        limpiar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarLista();

    }
}
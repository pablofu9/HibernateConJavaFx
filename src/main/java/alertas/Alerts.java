package alertas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Alerts {

    //Usando la libreria de JFOENIX para material design, creamos las alertas
    public static void crearAlertaError(StackPane stack, String body){
        JFXDialogLayout content = new JFXDialogLayout();

        content.setHeading(new Text("Error"));
        content.setBody(new Text(body));
        JFXDialog dialog=new JFXDialog(stack, content, JFXDialog.DialogTransition.CENTER);
        JFXButton boton = new JFXButton("Aceptar");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
                stack.setVisible(false);
            }
        });
        content.setActions(boton);
        dialog.show();
        stack.setVisible(true);

    }

    public static void crearAlertaInfo(StackPane stack, String body){
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("OK"));
        content.setBody(new Text(body));
        JFXDialog dialog=new JFXDialog(stack, content, JFXDialog.DialogTransition.CENTER);
        JFXButton boton = new JFXButton("Aceptar");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
                stack.setVisible(false);
            }
        });
        content.setActions(boton);
        dialog.show();
        stack.setVisible(true);
    }
}

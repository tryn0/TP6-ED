import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
 
public class programa extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage)
    {
        //Titulo de la ventana
        stage.setTitle("TP6 ED");
        stage.show();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Tamaño de la ventana
        Scene scene = new Scene(grid, 400, 375);
        stage.setScene(scene);

        //Titulo en la ventana
        Text titulo = new Text("Bienvenido");
        //fuente
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(titulo, 0, 0, 2, 1);

        //Texto del label y lo agrego al grid para que aparezca Nombre:
        Label nombre = new Label("Nombre:");
        grid.add(nombre, 0, 1);

        TextField texto = new TextField();
        grid.add(texto, 1, 1);
        //Informacion cuando pongo raton encima
        texto.setTooltip(new Tooltip("Escribe tu nombre"));

        //Texto del label y lo agrego al grid para que aparezca Apellidos:
        Label ap = new Label("Apellidos:");
        grid.add(ap, 0, 2);

        TextField aptexto = new TextField();
        grid.add(aptexto, 1, 2);
        //Informacion cuando pongo raton encima
        aptexto.setTooltip(new Tooltip("Escribe tus apellidos"));

        //Boton aceptar
        Button boton = new Button("Aceptar");
        HBox hbBtn = new HBox(10);
        //Informacion cuando pongo raton encima
        boton.setTooltip(new Tooltip("Aceptar y salir"));
        //Posicion en este caso abajo_izquierda
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(boton);
        //posicion en el grid
        grid.add(hbBtn, 0, 4);
        //posicion desplazada respecto a su posicion en el grid
        boton.setTranslateX(25);
        boton.setTranslateY(0);

        //Boton limpiar
        Button limpiar = new Button("Limpiar");
        HBox hbboton = new HBox(5);
        //Posicion en este caso abajo_derecha
        hbboton.setAlignment(Pos.BOTTOM_RIGHT);
        hbboton.getChildren().add(limpiar);
        //posicion en el grid
        grid.add(hbboton,1,4);
        //posicion desplazada respecto a su posicion en el grid
        limpiar.setTranslateX(-45);
        limpiar.setTranslateY(0);
        //Informacion cuando pongo raton encima
        limpiar.setTooltip(new Tooltip("Limpiar"));

        //Accion del boton limpiar
        limpiar.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                texto.clear();
                aptexto.clear();
            }

        });

        //Accion del boton aceptar
        boton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                //Nueva ventana
                Stage stage = new Stage();
                //Titulo de la ventana
                stage.setTitle("Informaci\u00F3n");
                GridPane grid = new GridPane();
                //Tamaño de la ventana
                stage.setScene(new Scene(grid, 400, 375));
                stage.show();

                //Texto
                Text persona = new Text();
                //Contenido del texto, en este caso getter de la informacion 
                //que se haya puesto en los textfields de nombre y apellidos
                persona.setText(texto.getText()+" "+aptexto.getText());
                //añadir ese texto en el grid
                grid.add(persona, 0, 1);
            }
        });
    }
}
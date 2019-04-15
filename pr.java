import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
 
public class pr extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("TP6 ED");
        stage.show();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);

        Text titulo = new Text("Bienvenido");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(titulo, 0, 0, 2, 1);

        Label nombre = new Label("Nombre:");
        grid.add(nombre, 0, 1);

        TextField texto = new TextField();
        grid.add(texto, 1, 1);

        Label ap = new Label("Apellidos:");
        grid.add(ap, 0, 2);

        TextField aptexto = new TextField();
        grid.add(aptexto, 1, 2);

        Button boton = new Button("Aceptar");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(boton);
        grid.add(hbBtn, 1, 4);

        final Text accion = new Text();
        grid.add(accion, 1, 6);

        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                accion.setFill(Color.FIREBRICK);
                accion.setText("Boton Aceptar presionado.");
            }
        });
    }
}
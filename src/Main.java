
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    private GridPane root = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception{

        root.setHgap(1.0);
        root.setVgap(1.0);
        for(int i =0; i < 10;i++){
            for(int a = 0; a <10; a++) {
                Rectangle n = new Rectangle();
                n.setHeight(25);
                n.setWidth(25);
                n.setOnMouseClicked(this::mouseSetColor);
                root.add(n, a, i);
            }
        }

        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Pathfinder");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();


           aiSetColor(1,1);


    }

    private void mouseSetColor(MouseEvent mouseEvent) {
        Rectangle t = (Rectangle) mouseEvent.getSource();
        t.setFill(Color.BLUE);
    }

    private void aiSetColor(int x, int y){
        y--;
        x--;
        ((Rectangle)root.getChildren().get(x + y)).setFill(Color.DARKGREEN);
    }


    public static void main(String[] args) {
        launch(args);
    }

}

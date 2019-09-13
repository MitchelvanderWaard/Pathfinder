
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    private GridPane root = new GridPane();
    private int x = 10;
    private int y = 10;

    @Override
    public void start(Stage primaryStage) throws Exception{

        root.setHgap(1.0);
        root.setVgap(1.0);
        for(int i =0; i < y;i++){
            for(int a = 0; a < x; a++) {
                Rectangle n = new Rectangle();
                n.setHeight(25);
                n.setWidth(25);
                n.setFill(Color.GRAY);
                n.setOnMouseClicked(this::mouseSetColor);
                root.add(n, a, i);
            }
        }

        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Pathfinder");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();


        aiSetColor(5,10);


    }

    private void mouseSetColor(MouseEvent mouseEvent) {
        Rectangle mouseTarget = (Rectangle) mouseEvent.getSource();
        Paint mouseTargetColor = mouseTarget.getFill();
        switch (mouseTargetColor.toString()){
            case "0x000000ff":
                mouseTarget.setFill(Color.RED);
                break;
            case "0xff0000ff":
                mouseTarget.setFill(Color.BLUE);
                break;
            default:
                mouseTarget.setFill(Color.BLACK);
                break;
        }
    }

    public void aiSetColor(int cellX, int cellY){
        //to make sure the algorithm never uses a wrong x or y
        if(cellX <= x & cellX >= 0 & cellY <= y & cellY >= 0) {
            //calculates the index of the given coordinates
            int index = (cellX - 1) + (cellY - 1) * x;
            ((Rectangle) root.getChildren().get(index)).setFill(Color.DARKGREEN);
        }
        else{
            throw new NullPointerException();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}

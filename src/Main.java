
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    private static GridPane root = new GridPane();
    private int x = 10;
    private int y = 10;
    private int home = 1;
    private int goal = 99;

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
        Button startalg = new Button("Start");
        startalg.setOnMouseClicked(this::initalg);
        root.add(startalg, x + 1,y + 1);
        root.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Pathfinder");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();


        aiSetColor(getCor(goal)[0],getCor(goal)[1]);
        aiSetColor(1, 1);
        //aiSetColor(2, 3);
        //aiSetColor(4, 2);
        //System.out.println(getCor(0)[0]);
        //System.out.println(getCor(0)[1]);
        //alg(1,1);
    }

    private void mouseSetColor(MouseEvent mouseEvent) {
        Rectangle mouseTarget = (Rectangle) mouseEvent.getSource();
        Paint mouseTargetColor = mouseTarget.getFill();
        switch (mouseTargetColor.toString()){
            case "0x000000ff":
                mouseTarget.setFill(Color.RED);
                break;
            case "0xff0000ff":
                mouseTarget.setFill(Color.GRAY);
                break;
            default:
                mouseTarget.setFill(Color.BLACK);
                break;
        }
    }

    public void aiSetColor(int cellX, int cellY){
        int index = getIndex(cellX,cellY);
        ((Rectangle) root.getChildren().get(index)).setFill(Color.BLUE);
    }


    public static void main(String[] args) {


        launch(args);
        //Algorithm myAlgorithm = new Algorithm(root,0 , 0,5,10);
        //myAlgorithm.run();
    }

    private int[] getCor(int index){
      int corX = (index % x);
      int corY = (index / x) + 1;
      return new int[]{corX,corY};
    }

    private int getIndex(int cellX, int cellY){
        //to make sure the algorithm never uses a wrong x or y
        //calculates the index of the given coordinates
        if(cellX <= x & cellX > 0 & cellY <= y & cellY > 0) return (cellX - 1) + (cellY - 1) * x;
        throw new NullPointerException();
    }

    private void initalg(MouseEvent mouseEvent){
        alg(1,1);
    }

    private void alg(int x, int y){
        if (x > this.x || y > this.y || x <= 0|| y <= 0 || getIndex(x,y) == goal || ((Rectangle)root.getChildren().get(getIndex(x,y))).getFill() == Color.BLACK || ((Rectangle)root.getChildren().get(getIndex(x,y))).getFill() == Color.GOLD ) return;
        ((Rectangle)root.getChildren().get(getIndex(x,y))).setFill(Color.GOLD);
        alg(x, y + 1);
        alg(x + 1, y);
        alg(x, y - 1);
        alg(x - 1, y);
    }

}

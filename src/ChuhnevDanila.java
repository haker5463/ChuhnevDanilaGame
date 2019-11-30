import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontWeight;


public class ChuhnevDanila extends Application {
        private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public  static ArrayList<Coin> coins = new ArrayList<>();
    Text t;

    Vector vector = new Vector();
    ArrayList<Vector> vectors = new ArrayList<>();
    Coordinate coordinate =  new Coordinate();
    public Coin coin;
    public Coin coin1;
    public Coin coin2;


    Image image1 = new Image(getClass().getResourceAsStream("map.png"));

    ImageView imageView1 = new ImageView(image1);

    Box box = new Box();
    Character player;
    Pane root;
    Pane rootWindow;
    int i =0;

    private static int WIDTH = 1200;
    private static int HEIGHT = 800;
    private static int PLAYER_X = WIDTH/2-10;
    private static int PLAYER_Y = HEIGHT /2-10;
     public ChuhnevDanila(){

        t = new Text();
        t.setText("Количество глифов : " );
        t.getText();
        t.setFill(Color.GRAY);
      t.setFont(Font.font("Verdana", FontPosture.REGULAR, 15));
        t.setX(10);
        t.setY(13);


    player = new Character();
    player.setTranslateX( coordinate.getPlayerX() );
    player.setTranslateY( coordinate.getPlayerY());


        coin = new Coin();
        coin.setTranslateX(130);
        coin.setTranslateY(120);
        coins.add(coin);
        coin1 = new Coin();
        coin1.setTranslateX(10);
        coin1.setTranslateY(120);
        coins.add(coin1);
        coin2 = new Coin();
        coin2.setTranslateX(13);
        coin2.setTranslateY(20);
        coins.add(coin2);

        root = new Pane();
        rootWindow = new Pane();
}
public void camera(){
    player.translateXProperty().addListener((obs , old , newValue)->{
        int offset = newValue.intValue();
        if(offset >  PLAYER_X && offset<WIDTH+200 - coordinate.getPlayerX()){
            root.setLayoutX(-(offset - coordinate.getPlayerX() ));
        }else if(offset< PLAYER_X && offset<WIDTH+200 - coordinate.getPlayerX()){
            root.setLayoutX(-(offset -coordinate.getPlayerX() ));
        }
    });
    player.translateYProperty().addListener((obs , old , newValue)->{
        int offset = newValue.intValue();
        if(offset >  PLAYER_Y && offset<HEIGHT+200 -  coordinate.getPlayerY()){
            root.setLayoutY(-(offset -   coordinate.getPlayerY() ));
        }else if(offset< PLAYER_Y && offset<HEIGHT+200 - coordinate.getPlayerY()){
            root.setLayoutY(-(offset -  coordinate.getPlayerY()));
        }
    });
   }
public void update() {

  for(Coin coin : coins) {
      if (coin.getBoundsInParent().intersects(player.getBoundsInParent())) {
          if(root.getChildren().remove(coin)){
            i++;
        }
          if(i > 2){
              t.setText("Победа!");
              t.setFill(Color.GREEN);
          }
          else {
              t.setText("Количество глифов : " + i);
          }

    }

 }
        camera();
        if (isPressed(KeyCode.UP)) {
            player.animation.play();
            player.animation.setOffsetY(96);
            player.moveY(-2);

        } else if (isPressed(KeyCode.DOWN)) {
            player.animation.play();
            player.animation.setOffsetY(0);
            player.moveY(2);
        } else if (isPressed(KeyCode.RIGHT)) {
            player.animation.play();
            player.animation.setOffsetY(64);
            player.moveX(2);
        } else if (isPressed(KeyCode.LEFT)) {
            player.animation.play();
            player.animation.setOffsetY(32);
            player.moveX(-2);
        }
        else{
            player.animation.stop();
        }
    }
    public boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }
    

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {
       //создание кнопок
        Button Play = new Button();
        Play.setText("Play ");
        Button Help = new Button();
        Help.setText("Help");
        Button Exit = new Button();

        Exit.setText(" Exit ");
       
        //делаем кнопки активными
        Play.setOnAction(new EventHandler<ActionEvent>() {
           @Override
          public void handle (ActionEvent ActionEvent) {
               // System.out.println("Hi, welcom to Diablo VII,the game is currently under development");
       rootWindow.getChildren().add(root);
        rootWindow.getChildren().add(t);
        root.setPrefSize(WIDTH,HEIGHT);
        root.getChildren().addAll(imageView1 ,player ,box , coin , coin1 , coin2);
                
                
       Label secondLabel = new Label("Hi, i very stupid man");
              
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
        Scene scene = new Scene(rootWindow);
        scene.setOnKeyPressed(event->keys.put(event.getCode(),true));
        scene.setOnKeyReleased(event-> {
            keys.put(event.getCode(), false);
        });
        scene.setOnMouseClicked(event -> {
            vector = new Vector();
            vectors.add(vector);
            for(int i = 0 ; i < vectors.size() ; i++) {


            }

            System.out.println("size" + vectors.size());
                vector.setTranslateX(player.getTranslateX());
                vector.setTranslateY(player.getTranslateY());
                vector.setTarget(event.getSceneX(), event.getScreenY());



            root.getChildren().add(vector);

        });
              
           AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();

                vector.move();
            }
        };

        timer.start();
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(scene);
 
                // Set position of second window, related to primary window.
                newWindow.setX(theStage.getX() + 200);
                newWindow.setY(theStage.getY() + 100);
                secondLabel.getStylesheets().add("css/Game.css");
                newWindow.show();

            }
        });

        Help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             Label secondLabel = new Label("Справочная информация по игре:\n"
                     + "движение осуществляеться по кнопкам left;right;up;down\n"
                     + "Цель игры добыть максимально количество глифов равное 3\n"
                     + "Глифы расположени в разных частях карты\n"
                     + "Каждый из глифов так или иначе влияет на игровой процесс\n"
                     + "P.S. в ближайшее время в игре будут добавлены монстры, пока это лишь АЛЬФАТЕСТ");
             
                     
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
 
                Scene secondScene = new Scene(secondaryLayout, 1280, 1280);
 
                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Second Stage");
                newWindow.setScene(secondScene);
 
                // Set position of second window, related to primary window.
                newWindow.setX(theStage.getX() + 200);
                newWindow.setY(theStage.getY() + 100);
                secondLabel.getStylesheets().add("css/ButtonStyle2.css");
            
                newWindow.show();
            }
        });

        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) Exit.getScene().getWindow();
                stage.close();
            }

        });

        theStage.setTitle("Diablo VII");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1920, 1080);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image pic = new Image("Diablo-Immortal_2.png");
        gc.drawImage(pic, 0, 0);
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("Diablo VII", 930, 50);
        gc.strokeText("Diablo VII", 930, 50);
        Image pic1 = new Image("(7).png");
        gc.drawImage(pic1, -100, 0);
        Image pic2 = new Image("(28).png");
        gc.drawImage(pic2, 1100, 0);
        root.getChildren().add(Play);
        root.getChildren().add(Help);
        root.getChildren().add(Exit);
        Play.relocate(960, 340);
        Help.relocate(960, 440);
        Exit.relocate(960, 540);
        root.getStylesheets().add("css/Game.css");

        theStage.show();

    }

}


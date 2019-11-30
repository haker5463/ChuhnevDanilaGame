import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Vector extends Pane {
    Image image2 = new Image(getClass().getResourceAsStream("explosions.png"));
    public ImageView imageView2 = new ImageView(image2);
    Box box = new Box();
    //Main main = new Main();
    public Point2D velocity = new Point2D(0,0);
    Coordinate coordinate = new Coordinate();
Character character;
    public Vector() {
        character = new Character();
    
        SpriteAnimation animation = new SpriteAnimation(imageView2, Duration.millis(1000), 15, 15, 15, 10, 60, 60);

        animation.play();


        getChildren().add(imageView2);

    }
    public void setTarget(double x , double y) {
        velocity = new Point2D(x, y).subtract(getTranslateX(), getTranslateY()).normalize().multiply(15);
    }

    public void move(){
        setTranslateX(getTranslateX()+velocity.getX());
        setTranslateY(getTranslateY()+velocity.getY());

    }
//стрельба


}


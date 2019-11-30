import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;


 public class Coin extends Pane {

    Image image = new Image(getClass().getResourceAsStream("ball.png"));
    public ImageView imageView2 = new ImageView(image);
    DropShadow dropShadow;
    public Coin(){

            SpriteAnimation animation = new SpriteAnimation(imageView2, Duration.millis(400), 3, 4, 2, 2, 32, 32);

            animation.play();


        getChildren().add(imageView2);

    }

}

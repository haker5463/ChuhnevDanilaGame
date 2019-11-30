import javafx.scene.Node;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Box extends Pane {
   //сталкивание
    Image image2 = new Image(getClass().getResourceAsStream("7.png"));
    public ImageView imageView2 = new ImageView(image2);
    public Box(){

        SpriteAnimation animation = new SpriteAnimation(imageView2 , Duration.millis(200) , 1 , 1 ,262,200, 62 ,53);
        imageView2.setTranslateX(40);
        imageView2.setTranslateY(60);

        getChildren().add(imageView2);
    }

}

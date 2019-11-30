import javafx.geometry.Rectangle2D;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Character extends Pane {

    private int count = 3;
    private int column = 3;
    private int offer_x = 0;
    private int offer_y = 0;
    private int width = 32;
    private int height = 32;
    SpriteAnimation animation;
    DropShadow dropShadow;
    Box box = new Box();



    Image image = new Image(getClass().getResourceAsStream("1.png"));
    ImageView imageView = new ImageView(image);
    public Character(){
      dropShadow = new DropShadow();
        dropShadow.setRadius(10.0);
        dropShadow.setOffsetX(5.0);
        dropShadow.setOffsetY(4.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5));
        imageView.setViewport(new Rectangle2D(offer_x ,offer_y , width  ,height));
        imageView.setEffect(dropShadow);
        animation = new SpriteAnimation(imageView ,Duration.millis(200),count , column , offer_x , offer_y , width , height);



        getChildren().addAll(imageView);

    }
//столкновение 
    public void moveX(int x){

        boolean right = x > 0 ?true: false;
        if(getBoundsInParent().intersects(box.imageView2.getBoundsInParent())) {
            if (getTranslateX() == box.imageView2.getTranslateX()) {
                setTranslateX(getTranslateX() - 1);
                return;
            }
            else if(getBoundsInParent().intersects(box.imageView2.getBoundsInParent())){
                if (getTranslateX() == box.imageView2.getTranslateX() +70) {
                    setTranslateX(getTranslateX() + 1);
                    return;
                }
            }
        }
        if(right){

            setTranslateX(getTranslateX()+ 1);
        }else{
            setTranslateX(getTranslateX()- 1);
        }


    }
    public void moveY(int y){
        boolean down = y > 0?true: false;
        if(getBoundsInParent().intersects(box.imageView2.getBoundsInParent())) {
            System.out.println("Нет пути");
            if (getTranslateY() == box.imageView2.getTranslateY()) {
                setTranslateY(getTranslateY() - 1);
                return;
            }
            else if(getBoundsInParent().intersects(box.imageView2.getBoundsInParent())){
                if (getTranslateY() == box.imageView2.getTranslateY() +70) {
                    setTranslateY(getTranslateY() + 1);
                    return;
                }
            }
        }
        if(down){
            setTranslateY(getTranslateY() + 1);
        }else{
            setTranslateY(getTranslateY() - 1);
        }
    }

}

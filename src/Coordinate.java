
public class Coordinate {

    public static int WIDTH = 600;
    public static int HEIGHT = 600;
    public static int PLAYER_X = WIDTH/2-10;
    public static int PLAYER_Y = HEIGHT /2-10;

    public static void setPlayerX(int playerX) {
        PLAYER_X = playerX;
    }

    public static void setPlayerY(int playerY) {
        PLAYER_Y = playerY;
    }

    public static int getWIDTH() {
        return WIDTH;
    }



    public static int getHEIGHT() {
        return HEIGHT;
    }



    public static int getPlayerX() {
        return PLAYER_X;
    }



    public static int getPlayerY() {
        return PLAYER_Y;
    }
}

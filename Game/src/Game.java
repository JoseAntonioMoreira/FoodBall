import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public static final int CANVAS_WIDTH = 1250;
    public static final int CANVAS_HEIGHT = 720;

    Rectangle canvas;
    Ball ball;
    Picture player;


    public Game(){
        canvas = new Rectangle(10, 10, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.draw();
        ball = new Ball();

        
        player = new Picture(50,50);
        player.translate(600, 600);
        player.draw();
    }

    public void update(long millis) throws InterruptedException {
        while (true) {
            Thread.sleep(millis);
            ball.update();

            ball.getKickCollisionsForRightPlayer(player);
        }

    }

}

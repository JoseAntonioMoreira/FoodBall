import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public static final int CANVAS_WIDTH = 1250;
    public static final int CANVAS_HEIGHT = 720;

    Rectangle canvas;
    Ball ball;
    //Picture player;
    Player p1;
    Player p2;

    public Game(){
        canvas = new Rectangle(10, 10, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.draw();
        ball = new Ball();
        //player = new Picture(50,50);
        //player.translate(600, 600);
        //player.draw();

        p1 = new Player(ControlScheme.WAD,50.0,50.0);
        p2 = new Player(ControlScheme.ARROWS,1200.0,50.0);
    }

    public void update(long millis) throws InterruptedException {
        while (true) {
            Thread.sleep(millis);// frame rate, if it's too slow/choppy change to smaller number.
            ball.update();
            p1.update();
            p2.update();
            ball.getKickCollisionsForLeftPlayer(p1.getPlayerImage());
            ball.getKickCollisionsForRightPlayer(p2.getPlayerImage());
        }

    }

}

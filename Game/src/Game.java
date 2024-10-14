import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {
    public static final int CANVAS_WIDTH = 1250;
    public static final int CANVAS_HEIGHT = 720;

    Rectangle canvas;
    Ball ball;

    public Game(){
        canvas = new Rectangle(10, 10, CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.draw();
        ball = new Ball();
        ball.setVelocity(-5, 5);
    }

    public void update(long millis) throws InterruptedException {
        while (true) {
            Thread.sleep(millis);// frame rate, if it's too slow/choppy change to smaller number.
            ball.update();
        }

    }

}

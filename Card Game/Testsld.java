public class Testsld
{
    // instance variables - replace the example below with your own
    double xSpeed;

    void setup() {
        size(800, 800);
        circleX = 0;
        xSpeed = 2;
    }

    void draw() {
        background(0);
        fill(100);
        stroke(255);
        ellipse(circleX, 400, 200, 200);
        circleX += xSpeed;
        if (circleX >= width || circleX <= 0) {
            xSpeed *= -2;
        }

    }

}

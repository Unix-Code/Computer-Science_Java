PImage grass;
PImage dirt;
PImage path;
int x, y;
double Step = 5;

void setup() {
  size(640, 480);
  fill(0);
  x = 420;
  y = 0;
  grass = loadImage("grass.png");
  path = loadImage("dirt.png");
  dirt = loadImage("dirt-mask2.png");
  path.mask(dirt);
}

void draw() {
  image(grass, 0, 0, width, height);
  image(path, 0, 0, width, height);
  rect(x, y, 20, 30);
  if (x > width) {
    x = 0;
  } else if (y > height) {
    y = 0;
  } else if (x < 0) {
    x = width;
  } else if (y < -20) {
    y = height;
  }
  print("x: " + x + "\n");
  print("y: " + y + "\n");
}

void keyPressed() {
  if (key == CODED) {
    switch (keyCode) {
    case UP:    
        y -= Step;
      break;
    case DOWN:
      y += Step;
      break;
    case LEFT :
      x -= Step;
      if (Step < 20) {
        Step *= 1.01;
      }
      break;
    case RIGHT:
      x += Step;
      if (Step < 20) {
        Step *= 1.01;
      }
      break;
    }
  }
}
void keyReleased() {
  Step = 5;
}
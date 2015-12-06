class Bubble {
  int x;
  int y;
  int size;
  Bubble() {
    x = width/2;
    y = height;
    size = 64;
  }
  Bubble(int inX, int inY, int inSize) {
    size = inSize;
    x = inX;
    y = inY;
  }
  void display() {
    fill(255);
    stroke(0);
    ellipse(x, y, size, size);
    background(127);
  }
  void ascend() {
    while (y > size/2) {
      y -= 4;
      x += random(-2, 2);
    }
  }
}
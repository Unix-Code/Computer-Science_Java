class Circle {
  float x, y;
  float size
    float xSpeed, ySpeed;
  float tempX, tempY;
  float moveX, moveY;

  Circle() {
    size = 100
      x = size/2 + 1;
    y = size/2 + 1;
    xSpeed = 24;
    ySpeed = 27;
    tempX = 0;
    tempY = 0;
    moveX = xSpeed;
    moveY = ySpeed;
  }
  Circle(float x, float y, float xSpeed, float ySpeed, float size) {
    this.size = size;
    this.x = x;
    this.y = y;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }
  void display() {
    fill(100);
    stroke(255);
    ellipse(x, y, size, size);
  }
  void move() {
    xSpeed *= -1;
  }
  void ballHit() {
    if (x + xSpeed >= (width - size/2) || x + xSpeed <= size/2) {
      
    } 
    else if (y + ySpeed >= (height - size/2) || y + ySpeed <= size/2) {
      ySpeed *= -1;
    }
  }
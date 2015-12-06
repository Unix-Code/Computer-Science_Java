int shapeColor;
void setup() {
  size(800, 800);
  stroke(0);
}

void draw() {
  if (mousePressed && mouseButton == LEFT) {
    fill(shapeColor);
    stroke(shapeColor);
    ellipse(mouseX, mouseY, 80, 80);
  }
  
}
void mouseWheel(MouseEvent event) {
  shapeColor = event.getCount();
}
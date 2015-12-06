ArrayList<Bubble> bubbles;
Bubble b1;
// int numBubble;
void setup() {
  size(800, 800);
  bubbles = new ArrayList<Bubble>();
  // numBubble = 0;
  b1 = new Bubble(30, 800, 64);
}

void draw() {
  // for (int i = 0; i < bubbles.size(); i++) {
    
  // }
 
  //b1.ascend();
  background(127);
  if (mousePressed && mouseButton == LEFT) {
    bubbles.add(new Bubble(mouseX, mouseY, 64));
    bubbles.get(0).display(); 
    // bubbles.get(0).ascend();    
  }
}
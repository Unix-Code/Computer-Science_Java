public class ConvertToBase10 {
    public void convert(String numStart, int base) {
        String start = numStart.toUpperCase();
        int endNum = 0;
        char placeValue;
        int temp = 0;
        int power = 0;
        for (int i = start.length() - 1; i > -1; i--) {
            placeValue = start.charAt(i);
            if (placeValue >= '0' && placeValue <= '9') {
                temp = placeValue - '0';
            }
            else if (placeValue >= 'A' && placeValue <= 'Z') {
                temp = 10 + (placeValue - 'A');
            }
            endNum += temp * Math.pow(base, power);
            power++;
        }
        
        System.out.println("Start: " + start + " in base " + base + "\nEnd: " + endNum); 
    }
}
/*for (char ch = 'A'; ch <= 'Z'; ++ch) 
  map.put(String.valueOf(ch), 0); */
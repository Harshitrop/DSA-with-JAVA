public class OPP {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setcolor("blue");
        System.out.println(p1.color);
        p1.settip("ballpoint");
        System.out.println(p1.tip);
    }
}

class Pen{
    String color;
    String tip;

    void setcolor(String newcolor){
        color = newcolor;
    }
    void settip(String newtip){
        tip = newtip;
    }
}
public class Project2 {
    public static void main(String[] args) {
        //Rectangle의 파라미터 - 인덱스, 중점의 X좌표, 중점의 Y좌표, 가로길이, 세로길이
        Rectangle rect0 = new Rectangle(0, -1, -1, 2, 2);
        Rectangle rect1 = new Rectangle(1, 1, 1, 4, 3);

        //Circle의 파라미터 - 인덱스, 중점의 X좌표, 중점의 Y좌표, 반지름
        Circle circle2 = new Circle(2, 4, 3, 1);

        //LeafNode의 파라미터 - 인덱스, Shape 객체
        LeafNode node0 = new LeafNode(0, rect0);
        LeafNode node1 = new LeafNode(1, rect1);
        LeafNode node2 = new LeafNode(2, circle2);

        //InnerNode의 파라미터 - 인덱스, 왼쪽 자식 Node 객체, 오른쪽 자식 Node 객체
        InnerNode node3 = new InnerNode(3, node1, node0);
        InnerNode node4 = new InnerNode(4, node3, node2);

        System.out.println(node4);
        System.out.println(node3);
        System.out.println(node2);
        System.out.println(node1);
        System.out.println(node0);
    }
}


class BoundingBox{
    double minX,minY,maxX,maxY;
    BoundingBox(double minX,double minY,double maxX,double maxY){
        this.minX=minX;
        this.minY=minY;
        this.maxX=maxX;
        this.maxY=maxY;
    }

}
class Shape{
    int index;
    Shape(int index){
        this.index=index;
    }
}
class Rectangle extends Shape {
    double x,y,width,height;
    Rectangle(int index,double x, double y, double width,double height){
        super(index);
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }


}
class Circle extends Shape {
    double x,y,r;
    Circle(int index,double x,double y,double r){
        super(index);
        this.x=x;
        this.y=y;
        this.r=r;
    }

}
class Node{
    int index;
    BoundingBox box;
    Node(int index){
        this.index=index;
    }
}
class LeafNode extends Node {
    Shape shape;
    LeafNode(int index, Shape shape){
        super(index);
        this.shape=shape;

        double minX=0,minY=0,maxX=0,maxY=0;
        if(shape instanceof Circle){
            Circle c=(Circle) shape;
            minX=c.x-c.r;
            minY=c.y-c.r;
            maxX=c.x+c.r;
            maxY=c.y+c.r;
        }

        else if (shape instanceof Rectangle){
            Rectangle r=(Rectangle) shape;
            minX=r.x-(r.width/2.0);
            minY=r.y-(r.height/2.0);
            maxX=r.x+(r.width/2.0);
            maxY=r.y+(r.height/2.0);
        }
        this.box=new BoundingBox(minX,minY,maxX,maxY);


    }
    public String toString(){
        return "node("+index+"): min ("+box.minX+" "+box.minY+") max ("+
                box.maxX+" "+box.maxY+"), shape index ("+ shape.index+")";

    }
}

class InnerNode extends Node {
    Node left;
    Node right;

    InnerNode(int index, Node left, Node right) {
        super(index);
        this.left = left;
        this.right = right;

        double oMinX;
        double oMinY;
        double oMaxX;
        double oMaxY;
        if (left.box.minX >= right.box.minX)
            oMinX = right.box.minX;
        else oMinX = left.box.minX;

        if (left.box.minY >= right.box.minY)
            oMinY = right.box.minY;
        else oMinY = left.box.minY;

        if (left.box.maxX >= right.box.maxX)
            oMaxX = left.box.maxX;
        else oMaxX = right.box.maxX;
        if (left.box.maxY >= right.box.maxY)
            oMaxY = left.box.maxY;
        else oMaxY = right.box.maxY;

        this.box = new BoundingBox(oMinX, oMinY, oMaxX, oMaxY);


    }

    public String toString() {
        return "node(" + index + "): min (" + box.minX + " " + box.minY + ") max (" +
                box.maxX + " " + box.maxY + "), child index (" + left.index + " " + right.index + ")";
    }
}
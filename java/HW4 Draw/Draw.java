/*
* ID: 104213046
* Author: §õ¬êèû
*/
import java.lang.Math;
public class Draw{
    static Pen p = new Pen();
    public static void draw(int x1, int y1, int x2,int y2){
        if(x1 == x2 && y1 == y2){
            // draw a point at(x1,y1)
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            // try{
            //     Thread.currentThread().sleep(10);
            // }catch(Exception err){
            // }
            return;
        }
        // Dividing into three parts until x1=x2 and y1=y2,then draw the point
        int offsetx = (x2 - x1)/3;
        int offsety = (y2 - y1)/3;
        // Draw each square in sequence
        draw(x1, y1, x1+offsetx, y1+offsety);
        draw(x1+offsetx, y1, x1+2*offsetx, y1+offsety);
        draw(x1+2*offsetx, y1, x1+3*offsetx, y1+offsety);
        draw(x1, y1+offsetx, x1+offsetx, y1+2*offsety);
        draw(x1+2*offsetx, y1+offsetx, x1+3*offsetx, y1+2*offsety);
        draw(x1, y1+2*offsetx, x1+offsetx, y1+3*offsety);
        draw(x1+offsetx, y1+2*offsetx, x1+2*offsetx, y1+3*offsety);
        draw(x1+2*offsetx, y1+2*offsetx, x1+3*offsetx, y1+3*offsety);

    }
    public static void tri(int x1, int y1, int len){
        if(len <= 1){
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            return;
        }
        tri(x1, y1, len/2);
        tri(x1+len/2,y1,len/2);
        tri(x1+len/4,(int)(y1-len*Math.sin(60*Math.PI/360)),len/2);
    }

    public static void main(String[] argv){
        draw(50,50,350,350);
        tri(400,350,300);
    }
}
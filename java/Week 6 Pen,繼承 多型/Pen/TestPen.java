import java.lang.Math;
public class TestPen{
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
        // 每次進入都切3等分,一直切一直切,切到變一點的時候畫出
        int offsetx = (x2 - x1)/3;
        int offsety = (y2 - y1)/3;
        // // 跳出時左上角畫完
        // draw(x1, y1, x1+offsetx, y1+offsety);
        // // 右上
        // draw(x1+2*offsetx, y1, x1+3*offsetx, y1+offsety);
        // // 中上
        // draw(x1+offsetx, y1+offsety, x1+2*offsetx, y1+2*offsety);
        // // 左下
        // draw(x1, y1+2*offsety, x1+offsetx, y1+3*offsety);
        // // 右下
        // draw(x1+2*offsetx, y1+2*offsety, x1+3*offsetx, y1+3*offsety);

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
    public static void line(int x1, int y1, int len, int degree){
        // 直線分割成 -^-
        int x2,y2,x3,y3,x4,y4;
        if(len <= 1){
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            return;
        }
        x2 = (int)(x1 + len*Math.cos(Math.PI*degree/180)/3);
        y2 = (int)(y1 - len*Math.sin(Math.PI*degree/180)/3);
        x4 = (int)(x1 + 2*len*Math.cos(Math.PI*degree/180)/3);
        y4 = (int)(y1 - 2*len*Math.sin(Math.PI*degree/180)/3);
        x3 = (int)(x2 + len*Math.cos(Math.PI*(degree+60)/180)/3);
        y3 = (int)(y2 - len*Math.sin(Math.PI*(degree+60)/180)/3);
        line(x1, y1, len/3, degree);
        line(x2, y2, len/3, degree+60);
        line(x3, y3, len/3, degree-60);
        line(x4, y4, len/3, degree);
    }
    public static void line2(int x1, int y1, int len, int degree){
        // 直線分割成 _ㄇ_
        int x2,y2,x3,y3,x4,y4,x5,y5;
        if(len <= 1){
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            return;
        }
        x2 = (int)(x1 + 0.4*len*Math.cos(Math.PI*degree/180)/3);
        y2 = (int)(y1 - 0.4*len*Math.sin(Math.PI*degree/180)/3);
        x5 = (int)(x1 + 0.6*len*Math.cos(Math.PI*degree/180)/3);
        y5 = (int)(y1 - 0.6*len*Math.sin(Math.PI*degree/180)/3);
        x3 = (int)(x2 + 0.2*len*Math.cos(Math.PI*(degree+90)/180)/3);
        y3 = (int)(y2 - 0.2*len*Math.sin(Math.PI*(degree+90)/180)/3);
        x4 = (int)(x3 + 0.2*len*Math.cos(Math.PI*degree/180)/3);
        y4 = (int)(y3 - 0.2*len*Math.sin(Math.PI*degree/180)/3);
        line2(x1, y1, (int)(0.4*len), degree);
        line2(x2, y2, (int)(0.2*len), degree+90);
        line2(x3, y3, (int)(0.2*len), degree);
        line2(x4, y4, (int)(0.2*len), degree-90);
        line2(x5, y5, (int)(0.4*len), degree);
    }
    public static void main(String[] argv){
        tri(100+100,500,400);
        draw(100,100,400,400);
        // line2(10,200,600,0);
    }
}

package figures;

import java.awt.*;

public class poligono extends Figure{

    protected int[] pontosX;
    protected int[] pontosY;
    protected int[] rgb2;
    protected int w = 50, h = 50;

    public poligono(int x, int y, int[] rgb, int[] rgb2) {
        
        super(rgb, x, y);
        this.rgb2 = rgb2;
        this.pontosX = new int[] {x, x+25, x+25, x, x-25, x-25};
        this.pontosY = new int[] {y, y+15, y+40, y+55, y+40, y+15};

    }
    
    public void print () {
        System.out.format("poligono de 6 lados.\n");
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.rgb[0], this.rgb[1], this.rgb[2]));
        g2d.drawPolygon(this.pontosX, this.pontosY, 6);

        g2d.setColor(new Color(this.rgb2[0], this.rgb2[1], this.rgb2[2]));
        g2d.fillPolygon(this.pontosX, this.pontosY, 6);
    }

    public boolean clicked (int mx, int my) { //função para dectar quando o mouse clicar na figura
        return (this.pontosX[5] <= mx && mx<= this.pontosX[1]  && this.pontosY[0] <= my && my <= this.pontosY[3]);
    }

    public void drag(int dx, int dy){
        this.x += dx;
        this.y += dy;
        
        for(int i = 0; i < 6; i++){
            this.pontosX[i] += dx;
            this.pontosY[i] += dy;
        }
    }
    public void tamanho(int w, int h){

        if(this.w >= 40 && this.w <= 200){
            if(this.w == 200){
                w = -5;
                h = -5;
            }
            else if(this.w == 40){
                w = +5;
                h = +5;
            }

            this.w += w;
            this.h += h;

            this.pontosX[1] += w; 
            this.pontosX[2] += w; 
            this.pontosX[4] -= w; 
            this.pontosX[5] -= w; 

            this.pontosY[1] += h/2; 
            this.pontosY[2] += h; 
            this.pontosY[3] += h + h/2; 
            this.pontosY[4] += h; 
            this.pontosY[5] += h/2; 
        }

        
    }
}
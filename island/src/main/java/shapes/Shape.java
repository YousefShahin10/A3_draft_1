package shapes;

import java.awt.Color;
import meshcomponents.MyMesh;

public abstract class Shape {
    Color insideColor = null;
    Color borderColor = null;
    Color outsideColor = null;
    double centerX;
    double centerY;



    public Color getInsideColor() {
        return this.insideColor;
    }

    public void setInsideColor(Color insideColor) {
        this.insideColor = insideColor;
    }

    public Color getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Color getOutsideColor() {
        return this.outsideColor;
    }

    public void setOutsideColor(Color outsideColor) {
        this.outsideColor = outsideColor;
    }

    public double getCenterX() {
        return this.centerX;
    }

    public double getCenterY() {
        return this.centerY;
    }
    

    public abstract void draw(MyMesh mesh);
}

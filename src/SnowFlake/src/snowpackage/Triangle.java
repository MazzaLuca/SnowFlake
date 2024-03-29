/*
 * The MIT License
 * 
 * Copyright 2020 Luca Mazza.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
*/

package snowpackage;

import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

/**
 * Triangle model, that has height, width.
 * 
 * @author Luca Mazza
 * @since 1.0
 */
public class Triangle {

    /**
     * Triangle polygon.
     */
    Polygon triangle = new Polygon();

    /**
     * Height of the triangle.
     */
    int height;

    /**
     * Length of the cathetus.
     */
    int cath;

    /**
     * Height of the panel
     */
    int panelHeight;

    /**
     * Width of the panel
     */
    int panelWidth;
    
    /**
     * X coordinates.
     */
    int[] xEs = new int[3];

    /**
     * Y coordinates.
     */
    int[] yS = new int[3];

    /**
     * Width of the triangle.
     */
    public static final int WIDTH = 500;

    /**
     * Height of the triangle.
     */
    public static final double HEIGHT = 500 * Math.sqrt(3);

    /**
     * Constructor method.
     * 
     * @param panelHeight Height of the panel
     * @param panelWidth Width of the panel
     */
    public Triangle(int panelHeight, int panelWidth) {
        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;
        this.calculateSizes();
    }

    /**
     * Calculates the sizes of the triangle.
     */
    public void calculateSizes(){
        this.cath =(int)(WIDTH * (this.panelHeight/2)/HEIGHT);
        this.height = (int)(this.cath * Math.sqrt(3));
        this.xEs[0] =(int)(this.panelWidth /4);
        this.xEs[1] = this.xEs[0];
        this.xEs[2] = this.xEs[0] + this.cath;
        this.yS[0] = this.panelHeight / 4;
        this.yS[1] = this.yS[0] + this.height;
        this.yS[2] = this.yS[0];
        this.triangle = new Polygon(this.xEs, this.yS, 3);
        
    }
}

/**
 * The MIT License
 * 
 * Copyright 2019 lucamazza.
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
package snowflake;

import java.awt.Polygon;

/**
 *
 * @author Luca Mazza
 * @version 8 Nov 2019
 */
public class Triangle {
    Polygon triangle = new Polygon();
    int height;
    int hypo;
    int cath;
    int panelHeight;
    int panelWidth;
    int[] xEs = new int[3];
    int[] yS = new int[3];

    public Triangle(int panelHeight, int panelWidth) {
        this.panelHeight = panelHeight;
        this.panelWidth = panelWidth;
        this.calculateSizes();
    }

    public void calculateSizes(){
        this.height = this.panelHeight / 2;
        this.hypo = (int)(height * 1.1547);
        this.cath = hypo / 2;
        this.xEs[0] = (int)(this.panelWidth / 2.5);
        this.xEs[1] = this.xEs[0];
        this.xEs[2] = this.xEs[0] + this.cath;
        this.yS[0] = this.panelHeight / 4;
        this.yS[1] = this.yS[0] + this.height;
        this.yS[2] = this.yS[0];
        this.triangle = new Polygon(this.xEs, this.yS, 3);
    }
}

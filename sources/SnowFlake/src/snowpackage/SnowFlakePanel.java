/*
 * The MIT License
 *
 * Copyright 2019 Luca Mazza.
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucamazza
 */
public class SnowFlakePanel extends javax.swing.JPanel {
    
    /**
     * 
     */
    Point mousePosition;
    
    /**
     * 
     */
    Polygon poly;
    
    /**
     * 
     */
    List<Point> points;
    
    /**
     * 
     */
    boolean showLines;
    
    /**
     * 
     */
    boolean generated;
    
    /**
     * 
     */
    private Triangle t1;
    
    /**
     * 
     */
    private Point center;
    
    /**
     * 
     */
    Color triangleColor = Color.BLACK;
    
    /**
     * 
     */
    boolean newPolygon = false;
    
    /**
     *
     */
    int RAD;
    
    /**
     * Creates new form TrianglePanel
     */
    public SnowFlakePanel() {
        this.showLines = true;
        this.poly = new Polygon();
        this.points = new ArrayList<>();
        this.mousePosition = new Point(0, 0);
        this.generated = false;
        
        initComponents();
    }
    
    /**
     *
     * @param g2d
     */
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        this.t1 = new Triangle(this.getHeight(), this.getWidth(), this.generated);
        Area triangle = new Area(this.t1.triangle);
        Area cutArea = new Area(this.poly);
        g2d.setColor(this.triangleColor);
        if(this.poly.npoints > 2){
            triangle.subtract(cutArea);
        }
        g2d.fill(triangle);
        this.center = new Point(this.t1.xEs[1], this.t1.yS[1]);
        for (int i = 6; i <= 36; i += 6) {
            g2d.fill(rotateArea(flipArea(triangle), i*10));
            g2d.fill(rotateArea(triangle, i*10));
        }
        
        
        if(showLines){
            if(this.triangleColor == Color.BLACK){
                g2d.setColor(Color.WHITE);
            }else{
                g2d.setColor(Color.BLACK);
            }
            g2d.draw(triangle);
            g2d.setColor(new Color(120, 30, 30, 255));
            g2d.draw(cutArea);
            for (Point point : this.points) {
                g2d.setColor(new Color(100, 100, 100, 100));
                g2d.fillOval(point.x - this.RAD, point.y - this.RAD, this.RAD*2, this.RAD*2);
                g2d.setColor(new Color(0, 0, 0, 255));
                g2d.drawOval(point.x - this.RAD, point.y - this.RAD, this.RAD*2, this.RAD*2);
            }
}   
    }

    /**
     * 
     * @param origPoints
     * @return 
     */
    public Shape flipArea(Area origPoints) {
        AffineTransform ty2 = new AffineTransform();
        ty2.scale(-1, 1);
        AffineTransform ty3 = new AffineTransform();
        ty3.translate(-center.x * 2, 0);
        AffineTransform ty1 = new AffineTransform();
        ty1.concatenate(ty2);
        ty1.concatenate(ty3);
        return ty1.createTransformedShape(origPoints);
    }
    
    /**
     * 
     * @param origPoints
     * @param angle
     * @return 
     */
    public Shape rotateArea(Shape origPoints, double angle) {
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(angle), this.center.x, this.center.y);
        return tx.createTransformedShape(origPoints);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * @param evt 
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(evt.getButton() == evt.BUTTON1){
            this.poly.addPoint(evt.getX(), evt.getY());
            this.points.add(evt.getPoint());
            repaint();
        }else if(evt.getButton() == evt.BUTTON3){
            for (Point point : points) {
                if(evt.getPoint().distance(point) <= this.RAD){
                    this.points.remove(point);
                    break;
                }
            }
            this.poly.reset();
            int[] x = new int[points.size()];
            int[] y = new int[points.size()];
            for (int i = 0; i < this.points.size(); i++) {
                x[i] = this.points.get(i).x;
                y[i] = this.points.get(i).y;
                this.poly = new Polygon(x, y, this.points.size());
                repaint();
            }
        }
    }//GEN-LAST:event_formMouseClicked

    /**
     * 
     * @param evt 
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        for (Point point : points) {
                if(evt.getPoint().distance(point) <= this.RAD){
                    int index = this.points.indexOf(point);
                    this.points.add(index, evt.getPoint());
//                    this.points.add(evt.getPoint());
                    this.points.remove(point);
                    break;
                }
        }
        this.poly.reset();
        int[] x = new int[points.size()];
        int[] y = new int[points.size()];
        for (int i = 0; i < this.points.size(); i++) {
            x[i] = this.points.get(i).x;
            y[i] = this.points.get(i).y;
            this.poly = new Polygon(x, y, this.points.size());
        }
        repaint();
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

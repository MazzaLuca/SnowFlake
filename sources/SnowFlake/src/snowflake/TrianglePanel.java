/*
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucamazza
 */
public class TrianglePanel extends javax.swing.JPanel {
    Polygon poly = new Polygon();
    int hypo;
    int cath;
    List<Point> points = new ArrayList<>();
    boolean clicked;
    private Triangle t1;
    public static final int RAD = 5;
    public static final Color CLICKED_COLOR = new Color(0, 200, 25, 255);

    /**
     * Creates new form TrianglePanel
     */
    public TrianglePanel() {
        initComponents();
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        this.t1 = new Triangle(this.getHeight(), this.getWidth());
        Area triangle = new Area(this.t1.triangle);
        Area cuts = new Area(this.poly);
        for (Point point : this.points) {
            g2d.setColor(
                    this.clicked?
                            CLICKED_COLOR:
                            new Color(100, 100, 100, 255)
            );
            g2d.fillOval(point.x - RAD, point.y - RAD, RAD*2, RAD*2);
            g2d.setColor(new Color(0, 0, 0, 255));
            g2d.drawOval(point.x - RAD, point.y - RAD, RAD*2, RAD*2);
        }
        g2d.setColor(new Color(120, 30, 30, 255));
        g2d.draw(cuts);
        g2d.setColor(new Color(10, 10, 10, 255));
        if(this.poly.npoints > 2){
            triangle.subtract(cuts);
        }
        g2d.fill(triangle);

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

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(evt.getButton() == evt.BUTTON1){
            this.poly.addPoint(evt.getX(), evt.getY());
            this.points.add(evt.getPoint());
            repaint();
        }else if(evt.getButton() == evt.BUTTON3){
            for (Point point : points) {
                if(evt.getPoint().distance(point) <= RAD){
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

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        for (Point point : points) {
                if(evt.getPoint().distance(point) <= RAD){
                    this.points.add(evt.getPoint());
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

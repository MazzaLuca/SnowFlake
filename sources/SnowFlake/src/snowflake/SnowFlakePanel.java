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
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucamazza
 */
public class SnowFlakePanel extends javax.swing.JPanel {
    Point mousePosition;
    int hypo;
    int cath;
    Polygon poly;
    List<Point> points;
    boolean showLines;
    boolean generated;
    private Triangle t1;
    private Point center;
    Color triangleColor = Color.WHITE;

    /**
     *
     */
    public static final int RAD = 5;



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
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                                 RenderingHints.VALUE_ANTIALIAS_ON));
        g2d.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
                            RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        this.t1 = new Triangle(this.getHeight(), this.getWidth(), this.generated);
        Area triangle = new Area(this.t1.triangle);
        Area cutArea = new Area(this.poly);
        g2d.setColor(this.triangleColor);
        if(this.poly.npoints > 2){
            triangle.subtract(cutArea);
        }
        g2d.fill(triangle);

        if(this.generated){
           this.center = new Point(this.t1.xEs[1], this.t1.yS[1]);
            Polygon cuts = convertToPolygon(triangle);
            Point[] pol1 = convertToArray(cuts);
            Point[] pol2 = convertToArray(cuts);
            Point[] pol3 = convertToArray(cuts);
            Point[] pol4= convertToArray(cuts);
            Point[] pol5= convertToArray(cuts);
            Point[] pol6= convertToArray(cuts);
            Point[] pol7= convertToArray(cuts);
            Point[] pol8= convertToArray(cuts);
            Point[] pol9= convertToArray(cuts);
            Point[] pol10= convertToArray(cuts);
            Point[] pol11= convertToArray(cuts);

            rotatePointMatrix(convertToArray(cuts), 60, pol1, convertToArray(cuts).length);
            rotatePointMatrix(convertToArray(cuts), 120, pol2, convertToArray(cuts).length);
            rotatePointMatrix(convertToArray(cuts), 180, pol3, convertToArray(cuts).length);
            rotatePointMatrix(convertToArray(cuts), 240, pol4, convertToArray(cuts).length);
            rotatePointMatrix(convertToArray(cuts), 300, pol5, convertToArray(cuts).length);

            Point[] prova = convertToArray(cuts);

            Point[] result = new Point[prova.length];
            for(int i = 0; i < prova.length; i++) {
                int pX = prova[i].x;
                int pY = (center.y - prova[i].y) + center.y;
                result[i] = new Point(pX, pY);
            }
            rotatePointMatrix(result, 0, pol6, result.length);
            rotatePointMatrix(result, 60, pol7, result.length);
            rotatePointMatrix(result, 120, pol8, result.length);
            rotatePointMatrix(result, 180, pol9, result.length);
            rotatePointMatrix(result, 240, pol10, result.length);
            rotatePointMatrix(result, 300, pol11, result.length);
            
            
            
            g2d.fill(getPolygon(pol1));
            g2d.fill(getPolygon(pol2));
            g2d.fill(getPolygon(pol3));
            g2d.fill(getPolygon(pol4));
            g2d.fill(getPolygon(pol5));
            g2d.fill(getPolygon(pol6));
            g2d.fill(getPolygon(pol7));
            g2d.fill(getPolygon(pol8));
            g2d.fill(getPolygon(pol9));
            g2d.fill(getPolygon(pol10));
            g2d.fill(getPolygon(pol11));
        }
        g2d.setColor(Color.BLACK);
        g2d.draw(triangle);
        if(showLines){
            g2d.setColor(new Color(120, 30, 30, 255));
            g2d.draw(cutArea);
            for (Point point : this.points) {
                g2d.setColor(new Color(100, 100, 100, 255));
                g2d.fillOval(point.x - RAD, point.y - RAD, RAD*2, RAD*2);
                g2d.setColor(new Color(0, 0, 0, 255));
                g2d.drawOval(point.x - RAD, point.y - RAD, RAD*2, RAD*2);
            }
        }
    }
    
    public Point[] convertToArray(Polygon pol) {
        Point[] points = new Point[pol.npoints];
        for(int i = 0; i < pol.npoints; i++) {
            points[i] = new Point(pol.xpoints[i], pol.ypoints[i]);
        }
        return points;
    }
    
    public Polygon convertToPolygon(Area a) {
        PathIterator iterator = a.getPathIterator(null);
        float[] floats = new float[6];
        Polygon p = new Polygon();
        while (!iterator.isDone()) {
            int type = iterator.currentSegment(floats);
            int x = (int) floats[0];
            int y = (int) floats[1];
            if(type != PathIterator.SEG_CLOSE) {
                p.addPoint(x, y);
                System.out.println("adding x = " + x + ", y = " + y);
            }
            iterator.next();
        }
        return p;
    }
    
    public Polygon getPolygon(Point[] points) {
        Polygon pol = new Polygon();
        for(int i = 0; i < points.length; i++) {
            pol.addPoint((points[i].x), (points[i].y));
        }
        return pol;
    }
    
    public void rotatePointMatrix(Point[] origPoints, double angle, Point[] storeTo, int length) {

        /* We ge the original points of the polygon we wish to rotate
         *  and rotate them with affine transform to the given angle. 
         *  After the opeariont is complete the points are stored to the 
         *  array given to the method.
         */
        AffineTransform.getRotateInstance(Math.toRadians(angle), this.center.x, this.center.y)
                .transform(origPoints, 0, storeTo, 0, length);

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

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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucamazza
 * @since 1.0
 */
public class TrianglePanel extends javax.swing.JPanel {

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
    
    List<Polygon> polygons;

    /**
     * 
     */
    private Triangle t1;

    /**
     * 
     */
    Point center;
    
    /**
     * 
     */
    Color fillColor = new Color(22, 152, 175);
    Color strokeColor = Color.BLACK;

    /**
     *
     */
    int RAD = 5;

    /**
     * 
     */
    public Area triangle = new Area();
    
    /**
     * 
     */
    boolean fill = true;
    
    /**
     * 
     */
    boolean stroke = false;
    /**
     * 
     */
    public TrianglePanel() {
        this.poly = new Polygon();
        this.points = new ArrayList<>();
        this.mousePosition = new Point(0, 0);
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
        this.t1 = new Triangle(this.getHeight(), this.getWidth(), false);
        this.triangle = new Area(this.t1.triangle);
        Area cutArea = new Area(this.poly);
        g2d.setColor(this.fillColor);
        if(this.poly.npoints > 2){
            triangle.subtract(cutArea);
        }
        if(this.fill){
            g2d.fill(this.triangle);
        }
        if(this.stroke){
            g2d.setColor(this.strokeColor);
            g2d.draw(this.triangle);
        }
        this.center = new Point(this.t1.xEs[1], this.t1.yS[1]);
        g2d.setColor(new Color(120, 30, 30, 255));
        g2d.draw(cutArea);
        for (Point point : this.points) {
            g2d.setColor(new Color(100, 100, 100, 100));
            g2d.fillOval(
                    point.x - this.RAD,
                    point.y - this.RAD,
                    this.RAD*2,
                    this.RAD*2);
            g2d.setColor(new Color(0, 0, 0, 255));
            g2d.drawOval(point.x - this.RAD,
                    point.y - this.RAD,
                    this.RAD*2,
                    this.RAD*2);
        }
    }

    /**
     *
     * @param handle
     */
    public void serialize(File handle){
        String path = handle.toString();
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.poly);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot write file " + handle + ". Code: tp158",
                    "Error opening file",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    /**
     * 
     * @param handle 
     */
    public void deSerialize(File handle){
        String path = handle.toString();
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.poly = (Polygon) in.readObject();
            if(!this.points.isEmpty()){
                this.points.clear();
            }
            for(int i = 0; i < this.poly.npoints; i++){
                this.points.add(
                        new Point(this.poly.xpoints[i], this.poly.ypoints[i]));
            }
            repaint();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot open file " + handle + ". Code: tp190",
                    "Error opening file",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(300, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
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
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        for (Point point : points) {
                if(evt.getPoint().distance(point) <= this.RAD){
                    if(evt.getX() > this.RAD && evt.getY() > this.RAD){
                        if(evt.getX() < this.getWidth() - this.RAD
                                && evt.getY() < this.getHeight() - this.RAD){
                            int index = this.points.indexOf(point);
                            this.points.add(index, evt.getPoint());
                            this.points.remove(point);
                            break;
                        }
                    }
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

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(evt.getButton() == evt.BUTTON1){
            this.poly.addPoint(evt.getX(), evt.getY());
            this.points.add(evt.getPoint());
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
            }
        }
        repaint();    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

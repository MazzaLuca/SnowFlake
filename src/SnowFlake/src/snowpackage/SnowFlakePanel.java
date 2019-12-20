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
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Writer;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2DIOException;

import org.w3c.dom.Document;
import org.w3c.dom.DOMImplementation;



/**
 * This panel contains the generated snowflake that generates its self live.
 * 
 * @author Luca Mazza
 * @since 1.0
 */
public class SnowFlakePanel extends javax.swing.JPanel {

    /**
     * Actual position of the mouse on the panel.
     */
    Point mousePosition;

    /**
     * TrianglePanel instance, used to import the cut triangle.
     */
    TrianglePanel tf;
    

    /**
     * Center point of the generated hexagon.
     */
    private Point center;

    /**
     * Color of the snowflake.
     */
    Color fillColor = new Color(22, 152, 175);

    /**
     * Color of the border.
     */
    Color strokeColor = Color.BLACK;

    /**
     * Flag that decides if the fill gets displayed.
     */
    boolean fill = true;

    /**
     * Flag that decides if the border gets displayed.
     */
    boolean stroke = false;

    /**
     * Creates new form TrianglePanel.
     */
    public SnowFlakePanel() {
        this.mousePosition = new Point(0, 0);
        this.setBackground(Color.WHITE);
        initComponents();
    }

    /**
     * Draws the generated snowflake on the panel.
     * 
     * @param g Graphics instance
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.addRenderingHints(
                new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                   RenderingHints.VALUE_ANTIALIAS_ON));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        try{        
            Area triangle = this.tf.triangle;
            this.center = new Point(this.tf.center.x, this.tf.center.y);
            for (int i = 6; i <= 36; i += 6) {
                
                if(this.fill){
                    g2d.setColor(this.fillColor);
                    g2d.fill(translateToCenter(rotateArea(flipArea(triangle), i*10)));
                    g2d.fill(translateToCenter(rotateArea(triangle, i*10)));
                }
                if(this.stroke){
                    g2d.setColor(this.strokeColor);
                    g2d.draw(translateToCenter(rotateArea(flipArea(triangle), i*10)));
                    g2d.draw(translateToCenter(rotateArea(triangle, i*10)));
                }
            }
        }catch(Exception ex){
            
        }
        
    }

    /**
     * Flips an <code>Area</code> using <code>AffineTransform</code>, moving it
     * to the border, scaling it by -1 and retranslating it in the center.
     *
     * @param origArea original <code>Area</code> to flip.
     * @return flipped origArea (<code>Shape</code>)
     */
    public Shape flipArea(Area origArea) {
        AffineTransform mirror = new AffineTransform();
        mirror.scale(-1, 1);
        AffineTransform toBorder = new AffineTransform();
        toBorder.translate(-center.x * 2, 0);
        AffineTransform concat = new AffineTransform();
        concat.concatenate(mirror);
        concat.concatenate(toBorder);
        return concat.createTransformedShape(origArea);
    }

    /**
     * Translates to the center of the panel a <code>Shape</code>, moving it to
     * the border and retranslating it in the panel's center.
     * 
     * @param origShape original <code>Shape</code> to move to the center
     * @return moved origShape (<code>Shape</code>)
     */
    public Shape translateToCenter(Shape origShape){
        AffineTransform toBorder = new AffineTransform();
        toBorder.translate(-this.center.x, -this.center.y);
        AffineTransform toCenter = new AffineTransform();
        toCenter.translate(this.getWidth()/2, this.getHeight()/2);
        AffineTransform concat = new AffineTransform();
        concat.concatenate(toBorder);
        concat.concatenate(toCenter);
        return concat.createTransformedShape(origShape);
    }

    /**
     * Translates to the side of the panel a <code>Shape</code>, moving it to
     * the border and retranslating it in the panel's side.
     * 
     * @param origPoints original <code>Shape</code> to move to the center
     * @return moved origShape (<code>Shape</code>)
     */
    public Shape translateToSide(Shape origPoints){
        AffineTransform toBorder = new AffineTransform();
        toBorder.translate(-this.center.x, -this.center.y);
        AffineTransform toCenter = new AffineTransform();
        toCenter.translate(300, 300);
        AffineTransform concat = new AffineTransform();
        concat.concatenate(toBorder);
        concat.concatenate(toCenter);
        return concat.createTransformedShape(origPoints);
    }

    /**
     * Rotates the <code>Shape</code> origPoints by the angle, using
     * <code>AffineTransform</code>.
     * 
     * @param origPoints original non-rotated Shape
     * @param angle rotation angle
     * @return rotated <code>Shape</code>
     */
    public Shape rotateArea(Shape origPoints, double angle) {
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(angle), this.center.x, this.center.y);
        return tx.createTransformedShape(origPoints);
    }

    /**
     * Generates an SVG file based on the <code>Graphics2D</code> object in the 
     * paintComponent method.
     * 
     * @param filename path of the destination file
     */
    public void generateSVG(String filename){
        DOMImplementation domImpl =
        GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        this.paintComponent(svgGenerator);
        boolean useCSS = true;
        Writer out;
        try {
            svgGenerator.stream(filename, useCSS);
        } catch (SVGGraphics2DIOException ex) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Graphic error. Code: sf206",
                    "Graphic error",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE,
                    null, null, null);
        }
    }

    /**
     * Generates a PNG image, using a <code>Graphics2D</code> object 
     * to paint the snowflake.
     * 
     * @param filename path of the destination file
     * @param width width (and height) of the image in pixels
     */
    public void generatePNG(String filename, int width){
        try {
            BufferedImage buffImg = new BufferedImage
                (width, width, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = buffImg.createGraphics();
            try{        
                Area triangle = this.tf.triangle;
                this.center = new Point(this.tf.center.x, this.tf.center.y);
                for (int i = 6; i <= 36; i += 6) {
                    if(this.fill){
                        g2d.setColor(this.fillColor);
                        g2d.fill(
                                translateToSide(
                                        rotateArea(
                                                flipArea(triangle), i*10)
                                )
                        );
                        g2d.fill(
                                translateToSide(
                                        rotateArea(triangle, i*10)
                                )
                        );
                    }
                    if(this.stroke){
                        g2d.setColor(this.strokeColor);
                        g2d.draw(
                                translateToSide(
                                        rotateArea(
                                                flipArea(triangle), i*10)
                                )
                        );
                        g2d.draw(
                                translateToSide(
                                        rotateArea(triangle, i*10)
                                )
                        );
                    }
                }
            }catch(Exception ex){
            }
            ImageIO.write(buffImg, "PNG", new File(filename));
        } catch (IOException ie) {
            JOptionPane jop = new JOptionPane();
            jop.showOptionDialog(
                    null,
                    "Cannot create file",
                    "Error creating file",
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

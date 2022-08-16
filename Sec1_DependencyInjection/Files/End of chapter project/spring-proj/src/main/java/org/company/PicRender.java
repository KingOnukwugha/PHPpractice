//Class created by me
package org.company;

import java.io.IOException;

import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.JLabel; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
	
public class PicRender extends JPanel{
	/**
	 * @author AlexanderOnukwugha
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	public int flipNumb;
	public PicRender(int flipNumb) throws IOException, InterruptedException {
		img = ImageIO.read(getClass().getResource("Hamsterflip0.png"));
		final int imgX = img.getWidth()/2; 
		final int imgY = img.getHeight()/2;
		
		//img.getScaledInstance(imgX, imgY, ABORT);
	
		JFrame window = new JFrame();
		BufferedImage newSiz = ReSizeImg(img, imgX/2, imgY/2);
		BufferedImage box = RotationPane(newSiz, flipNumb);
		
		//box.dispose();
		//Presets dimensions 
		window.setSize(imgX, imgY);
		window.setResizable(false);

		//JPanel bigbox = new JPanel();
		JLabel bigbox = new JLabel(new ImageIcon(box));
		
		window.getContentPane();
		window.add(bigbox);
		//Sets image to center
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setAlwaysOnTop(true);
		window.setVisible(true);
		
		
	}
	//boolean thrown = false;
	
	/**
	 * @param img
	 * @return
	 */
	
	public BufferedImage ReSizeImg(BufferedImage newImg, int X, int Y) {
		BufferedImage nImg = new BufferedImage(X, Y, newImg.getType());
		Graphics2D g = nImg.createGraphics();
		g.drawImage(newImg, 0, 0, X, Y, null);
		g.dispose();
		return nImg;
	}
	
	public BufferedImage RotationPane(BufferedImage img, int flipNumb) {
		
		int n = 90 * flipNumb;
		double rotationRequired = Math.toRadians(n);
		double locationX = img.getWidth()/2;
		double locationY = img.getHeight()/2;
		AffineTransform tsfm = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tsfm,AffineTransformOp.TYPE_BILINEAR);
		BufferedImage newImg = new BufferedImage(img.getWidth(),img.getHeight(),img.getType());
		op.filter(img, newImg);
		return (newImg);
	}
}

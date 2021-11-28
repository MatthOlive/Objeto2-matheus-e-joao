import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Nomes  {
	static int lChegada = 500;
	static int max = 20;
	
	static int min = 5;
	

    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        
        JFrame f=new JFrame();//creating instance of JFrame  
     
        
        
        f.setSize(700,lChegada+300);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
        
        System.out.println(t.getName());
        Carros carro1 = new Carros("Carlos", lChegada,(int)Math.floor(Math.random()*(max-min+1)+min), f, 0);
        Carros carro2 = new Carros("joão", lChegada,(int)Math.floor(Math.random()*(max-min+1)+min), f, 1);
        Carros carro3 = new Carros("Augusto", lChegada,(int)Math.floor(Math.random()*(max-min+1)+min), f, 2);
        Carros carro4 = new Carros("Matheus", lChegada,(int)Math.floor(Math.random()*(max-min+1)+min), f, 3);
        Carros carro5 = new Carros("Lucas", lChegada,(int)Math.floor(Math.random()*(max-min+1)+min), f, 4);
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("img/Rua 1.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            f.add(picLabel);
            picLabel.setBounds(0,0,500,lChegada);
            }
            catch (Exception e) {
    			
    		}
        try {
            BufferedImage myPicture = ImageIO.read(new File("img/linha.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            f.add(picLabel);
            picLabel.setBounds(0,500,lChegada,50);
            }
            catch (Exception e) {
    			
    		}

    }

}

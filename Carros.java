import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Carros  extends Thread

{
	
	//variaveis
	int lChegada = 100;
	
    int posição;
    
    int velocidade;
    
    int aceleração;
    
    JLabel picLabel;
   
    int index;
    
    int largura = 53;
    
    private String nome;
    
      
    public Carros(String nome, int lChegada,int aceleração, JFrame f, int meuIndex)
    {
        this.nome = nome;
        
        this.lChegada = lChegada;
        
        this.velocidade = 1;
        
        this.aceleração = aceleração;
        
        index = meuIndex;
        
        System.out.println("Carro " + nome + " tem aceleração de " + aceleração);
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("img/car 1.png"));
            picLabel = new JLabel(new ImageIcon(myPicture));
            f.add(picLabel);
            start();
            }
            catch (Exception e) {
            	System.out.println(e.getMessage());
    		}
        
       
    }


	public void run()
    {
		
        Thread t = Thread.currentThread();
        
        System.out.println(t.getName());
        
        System.out.println("A chegada esta a "+lChegada);
        
        while(posição < lChegada) {
        	velocidade += aceleração;  
        	posição += velocidade;
        	picLabel.setBounds(index*100+25,posição,largura,85);
        	System.out.println(nome + " correu " + velocidade + " m" + ", percorreram um total de " + posição +" m");
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (posição >= lChegada) {
        	System.out.println(nome + " Alcançou a linha de chegada ");
        }
        
    }
}
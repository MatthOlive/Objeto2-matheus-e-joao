import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Carros  extends Thread

{
	
	//variaveis
	int lChegada = 100;
	
    int posi��o;
    
    int velocidade;
    
    int acelera��o;
    
    JLabel picLabel;
   
    int index;
    
    int largura = 53;
    
    private String nome;
    
      
    public Carros(String nome, int lChegada,int acelera��o, JFrame f, int meuIndex)
    {
        this.nome = nome;
        
        this.lChegada = lChegada;
        
        this.velocidade = 1;
        
        this.acelera��o = acelera��o;
        
        index = meuIndex;
        
        System.out.println("Carro " + nome + " tem acelera��o de " + acelera��o);
        
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
        
        while(posi��o < lChegada) {
        	velocidade += acelera��o;  
        	posi��o += velocidade;
        	picLabel.setBounds(index*100+25,posi��o,largura,85);
        	System.out.println(nome + " correu " + velocidade + " m" + ", percorreram um total de " + posi��o +" m");
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        if (posi��o >= lChegada) {
        	System.out.println(nome + " Alcan�ou a linha de chegada ");
        }
        
    }
}
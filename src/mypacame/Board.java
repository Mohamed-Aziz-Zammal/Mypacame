/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypacame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Aziz
 */
public class Board extends JPanel{
    
    int score;
    
    Image titleScreen =Toolkit.getDefaultToolkit().getImage(".\\src\\img\\titleScreen.jpg") ;
    Image over =Toolkit.getDefaultToolkit().getImage(".\\src\\img\\over.jpg") ;
    Image win =Toolkit.getDefaultToolkit().getImage(".\\src\\img\\win.jpg") ;
//ghosts
    Image red_ghost1 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost10.jpg") ;
    Image red_ghost2 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost11.jpg") ;
    Image[] G_red={red_ghost1,red_ghost2};
    
    Image yellow_ghost1 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost20.jpg") ;
    Image yellow_ghost2 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost21.jpg") ;
    Image[] G_yellow={yellow_ghost1,yellow_ghost2};
    
    Image blue_ghost1 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost30.jpg") ;
    Image blue_ghost2 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost31.jpg") ;
    Image[] G_blue={blue_ghost1,blue_ghost2};
    
    Image pink_ghost1 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost40.jpg") ;
    Image pink_ghost2 =Toolkit.getDefaultToolkit().getImage("./src/img/ghost41.jpg") ;
    Image[] G_pink={pink_ghost1,pink_ghost2};
//pacman
    
    Image tttt =Toolkit.getDefaultToolkit().getImage("./src/img/pacman.jpg") ;
    
    Image pacman_left =Toolkit.getDefaultToolkit().getImage("./src/img/pacmanleft.jpg") ;
    Image pacman_right =Toolkit.getDefaultToolkit().getImage("./src/img/pacmanright.jpg") ;
    Image pacman_up =Toolkit.getDefaultToolkit().getImage("./src/img/pacmanup.jpg") ;
    Image pacman_down =Toolkit.getDefaultToolkit().getImage("./src/img/pacmandown.jpg") ;
    Image[] G_pacman={pacman_left,pacman_right,pacman_up,pacman_down};
    
    Pacman pacman=new Pacman(10*Componant.cellSize, 15*Componant.cellSize);

    
   //ghostsO
    Ghost ghodt1=new Ghost(10*Componant.cellSize, 8*Componant.cellSize);
    Ghost ghodt2=new Ghost(10*Componant.cellSize, 9*Componant.cellSize);
    Ghost ghodt3=new Ghost(11*Componant.cellSize, 9*Componant.cellSize);
    Ghost ghodt4=new Ghost(9*Componant.cellSize, 9*Componant.cellSize);
    
    boolean title;
    boolean balls[][];
    boolean states[][];
    int lives=2;
    
    public void drawLives(Graphics g){
    g.setColor(Color.yellow);
         for(int i=0;i<lives;i++){
          // g.drawImage(pacman_left,(Componant.cellSize +5)* i+15, Componant.max+10, null );
           // g.fillOval(Componant.cellSize * i, Componant.max+10, Componant.cellSize, Componant.cellSize);
           //g.drawImage(pacman_left, (40+5) *i , 20+10, null);
          g.drawImage(pacman_left,(Componant.cellSize+5)*i+15 , 20*Componant.cellSize, null );
         }
    
    }
    
    public void init(){
        for(int i=0;i<Componant.cellSize;i++){
            for(int j=0;j<Componant.cellSize;j++){
               balls[i][j]=true;
               states[i][j]=true;
            }
        }
        balls[10][8]=false;
        balls[10][9]=false;
        balls[11][9]=false;
        balls[9][9]=false;
        balls[10][15]=false;
    
    }
    
    
    public Board(){
        title=true;
        balls=new boolean[Componant.cellSize][Componant.cellSize];
        states=new boolean[Componant.cellSize][Componant.cellSize];
        init();
    }
    
    
    public void update(Graphics g,int x,int y,int width,int height){
        g.fillRect(x, y, width, height);
        for(int i=x/20;i< x/20 + width/20;i++){
            for(int j=y/20;j<y/20 + height/20;j++){
                balls[i][j]=false;
                states[i-1][j-1]=false;
            
            }
        
        }
        
    }
    public void drawBalls(Graphics g){
        g.setColor(Color.yellow);
        for(int i=1;i<Componant.cellSize;i++){
            for(int j=1;j<Componant.cellSize;j++){
                if(balls[i][j])
                    g.fillOval(i*20+8, j*20+8,4, 4);
                
            }
        }
    }
    public void reset(){
       if(lives >0)
           lives--;
       
       ghodt1.x=10*Componant.cellSize;
       ghodt1.y=8*Componant.cellSize;
       
       ghodt2.x=10*Componant.cellSize;
       ghodt2.y=9*Componant.cellSize;
       
       ghodt3.x=11*Componant.cellSize;
       ghodt3.y=9*Componant.cellSize;
       
       ghodt4.x=9*Componant.cellSize;
       ghodt4.y=9*Componant.cellSize;
       
       pacman.x=10*Componant.cellSize;
       pacman.y=15*Componant.cellSize;
       
       Game.flag=true;
       
    
    
    }
    
    public void drawBoard(Graphics g){
        g.setColor(Color.white);
        g.drawRect(19, 19, 382, 380);
        g.setColor(Color.blue);
       // update(g, 40, 40, 60, 20);
       update(g,40,40,60,20);
        update(g,120,40,60,20);
        update(g,200,20,20,40);
        update(g,240,40,60,20);
        update(g,320,40,60,20);
        update(g,40,80,60,20);
        update(g,160,80,100,20);
        update(g,200,80,20,60);
        update(g,320,80,60,20);
        update(g,20,120,80,60);
        update(g,320,120,80,60);
        update(g,20,200,80,60);
        update(g,320,200,80,60);
        update(g,160,160,40,20);
        update(g,220,160,40,20);
        update(g,160,180,20,20);
        update(g,160,200,100,20);
        update(g,240,180,20,20);
        update(g,120,120,60,20);
        update(g,120,80,20,100);
        update(g,280,80,20,100);
        update(g,240,120,60,20);
        update(g,280,200,20,60);    
        update(g,120,200,20,60); 
        update(g,160,240,100,20);
        update(g,200,260,20,40);
        update(g,120,280,60,20);
        update(g,240,280,60,20);
        update(g,40,280,60,20);
        update(g,80,280,20,60);
        update(g,320,280,60,20);
        update(g,320,280,20,60);
        update(g,20,320,40,20);
        update(g,360,320,40,20);
        update(g,160,320,100,20);
        update(g,200,320,20,60);
        update(g,40,360,140,20);
        update(g,240,360,140,20);
        update(g,280,320,20,60);
        update(g,120,320,20,60);
        
        
        repaint();
    }
    

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 420, 500);
        drawBoard(g);
        drawBalls(g);
        drawLives(g);
        Font f=new Font("Ari",Font.BOLD,20);
        g.setFont(f);
        g.drawString("score:"+score, Componant.max/2+50, Componant.max+20);
        g.drawImage(G_red[ghodt1.index],ghodt1.x , ghodt1.y, null);
        g.drawImage(G_yellow[ghodt1.index], ghodt2.x,ghodt2.y , null);
        g.drawImage(G_pink[ghodt1.index],ghodt3.x , ghodt3.y, null);
        g.drawImage(G_blue[ghodt1.index],ghodt4.x , ghodt4.y, null);
        
        g.drawImage(G_pacman[pacman.index],pacman.x,pacman.y, null);
        //g.drawImage(pacman_left,Componant.cellSize , 20*Componant.cellSize, null );
       if(title)
           g.drawImage(titleScreen, 0, 0, null);
       if(lives==0)
           g.drawImage(over, 0, 0, null);
        if(check())
           g.drawImage(win, 0, 0, null);
        
    }
    
    public boolean check(){
      for(int i=1;i<Componant.cellSize;i++){
            for(int j=1;j<Componant.cellSize;j++){
                if(balls[i][j])
                    return false;
                
            }} 
      return true;
    
    
    }
}

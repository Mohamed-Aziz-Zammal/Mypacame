/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mypacame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Aziz
 */
public class Game implements KeyListener{

    /**
     * @param args the command line arguments
     */
    
    Board board=new Board();
    Timer timer;
    char direction='L';
     static boolean flag=true;
    public Game(){
        JFrame frame=new JFrame();
        frame.setSize(420, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(board,BorderLayout.CENTER);
        frame.setTitle("pac-man");
        frame.setVisible(true);
        frame.addKeyListener(this);
        timer =new Timer(50,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!board.title && board.lives>0){
                    if(flag){
                        try {
                            Thread.sleep(2000);
                            flag=false; 
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                board.ghodt1.move();
                if (board.ghodt1.getShape().intersects(board.pacman.getShape())){
                    board.reset();
                }
                
                board.ghodt2.move();
                if (board.ghodt2.getShape().intersects(board.pacman.getShape())){
                    board.reset();
                }
                
                board.ghodt3.move();
                if (board.ghodt3.getShape().intersects(board.pacman.getShape())){
                    board.reset();
                }
                
                board.ghodt4.move();
                if (board.ghodt4.getShape().intersects(board.pacman.getShape())){
                    board.reset();
                }
            
                board.ghodt1.undateState(board.states);
                board.ghodt2.undateState(board.states);
                board.ghodt3.undateState(board.states);
                board.ghodt4.undateState(board.states);
            
                board.pacman.move(direction);
                if(board.balls[board.pacman.x/20][board.pacman.y/20]){
                board.balls[board.pacman.x/20][board.pacman.y/20]=Boolean.FALSE;
                board.score++;
                }
                board.pacman.undateState(board.states);}
            }
       
       
        });
        timer.start();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_LEFT)
            direction='L';
        else if(e.getKeyCode()== KeyEvent.VK_RIGHT)
            direction='R';
        else if(e.getKeyCode()== KeyEvent.VK_UP)
            direction='U';
        else if(e.getKeyCode()== KeyEvent.VK_DOWN)
            direction='D';
        else if(e.getKeyCode()== KeyEvent.VK_ENTER)
            board.title=false;
            
            
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}

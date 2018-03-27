/*package Ex1;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.prism.shader.FillRoundRect_Color_AlphaTest_Loader;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameJava2_11 extends JFrame implements Runnable, ActionListener { 
  Thread clock;
  Clip clip;

  Image off; 
  Graphics offG;

  Random r;

  boolean[][] map;
  Color[] colorType;
  Color[][] colorMap;

  int blockType;
  int[] blockX;
  int[] blockY;
  int blockPos;

  int score;
  int delayTime;
  int runGame;


  JButton startButton;
  JPanel buttonPanel;

  public GameJava2_11()
  {
    
    // GUI
   setLayout(new BorderLayout());
   setBounds(50, 50, 230, 450);
   buttonPanel= new JPanel();

   startButton= new JButton("START");
    startButton.addActionListener(this);
    buttonPanel.add(startButton);
   add("South", buttonPanel);
    
    setVisible(true);
    
   map= new boolean[12][21];
   colorMap=new Color[12][21];
   colorType= new Color[7];
   setColorType();
   
   blockX=new int[4];
   blockY=new int[4];
   blockPos = 0;
   
   r= new Random();
   blockType = Math.abs(r.nextInt()% 7);
   setBlockXY(blockType);
    
   //����ȭ�� �����
   off= createImage(181, 316);
   offG=off.getGraphics();
   offG.setColor(Color.white);
   offG.fillRect(0,0,192,192);
   
   // ����, ��϶������� �ð� �� �ʱ�ȭ 
   score = 0; // ����
   delayTime=1000; //����� �������� �ð�
   runGame=0;
   
   //���� ó�� ���۵Ǵ� �����ڿ� ó�� ���̴� ȭ�� �ʱ�ȭ ���ֱ� ���� �޼ҵ� 3�� 
   drawBlock();
   drawMap();
   drawGrid();
  
   //mykeyhandler�� �̺�Ʈ�ڵ鷯�� �����. �Ű�� ���ȴ��� �Ǵ��ϴ� �޼ҵ�  
   addKeyListener(new MyKeyHandler());

   start();
    
  }
  //��Ͽ� �´� ������ ���س��� �׻��� ����Ϸ��� �޼ҵ� 
  public void setColorType()
  {
     colorType[0] = new Color(65,228,82);
     colorType[1] = new Color(58,98,235);
     colorType[2] = new Color(128,0,64);
     colorType[3] = new Color(255,35,31);
     colorType[4] = new Color(68,17,111);
     colorType[5] = new Color(246,118,57);
     colorType[6] = new Color(224,134,4);
  }

  public void setBlockXY(int type)
  {
     switch(type) {
     case 0:  //���簢�� �׸����� ���� �߰��κп� ����°���.  
     blockX[0]= 5; blockY[0] =0; //5�� �ప 0�� ������ �ش�Ǵ� map�̶�� 2���� �迭�� �ε��� ��ȣ. 
     blockX[1]= 6; blockY[1] =0;
     blockX[2]= 5; blockY[2] =1;
     blockX[3]= 6; blockY[3] =1;
     break;
     case 1:
     blockX[0]= 6; blockY[0] =0; 
     blockX[1]= 5; blockY[1] =1;
     blockX[2]= 6; blockY[2] =1;
     blockX[3]= 7; blockY[3] =1;
     break;
     case 2:
        blockX[0]= 7; blockY[0] =0; 
        blockX[1]= 5; blockY[1] =1;
        blockX[2]= 6; blockY[2] =1;
        blockX[3]= 7; blockY[3] =1;
        break;
     case 3:
        blockX[0]= 5; blockY[0] =0; 
        blockX[1]= 5; blockY[1] =1;
        blockX[2]= 6; blockY[2] =1;
        blockX[3]= 7; blockY[3] =1;
        break;
     case 4:
        blockX[0]= 5; blockY[0] =0; 
        blockX[1]= 5; blockY[1] =1;
        blockX[2]= 6; blockY[2] =1;
        blockX[3]= 7; blockY[3] =1;
        break;
     case 5:
        blockX[0]= 6; blockY[0] =0; 
        blockX[1]= 5; blockY[1] =1;
        blockX[2]= 6; blockY[2] =1;
        blockX[3]= 7; blockY[3] =1;
        break;
     case 6:
        blockX[0]= 4; blockY[0] =0; 
        blockX[1]= 5; blockY[1] =0;
        blockX[2]= 6; blockY[2] =0;
        blockX[3]= 7; blockY[3] =0;
        break;     
  }
  }
  
  //�� �����尡 ��� ���⶧���� �Ʊ� �����Ÿ��� ������ �ذ� �Ҽ�����
  public void start()
  {
    if(clock==null) {
       clock = new Thread(this);
       clock.start(); 
    }
  }
  //����ȭ�鿡 �ִ� �͵��� �Űٰܴ� ������ �׷��ִ� �޼ҵ�. 
  public void paint(Graphics g)
  {    
     g.drawImage(off, 25, 50, this);
  }

  public void update(Graphics g)
  {
    paint(g);
  }

  public void run()
  {
   while(true)
   {
      try {
         clock.sleep(delayTime);
      } catch (InterruptedException ie) {}

   dropBlock();
   switch(runGame) {
   case 1:
      drawBlock();
      drawMap();
      drawGrid();
      break;
   case 2:
      drawScore();
      break;
      default:
         drawTitle();
         break;
   }

      repaint(); // paint() 
   }
  }

  public void drawScore()
  {
    
    
    
  
  }

  public void drawTitle()
  {
   offG.setColor(Color.white);
   offG.fillRect(29, 120, 123, 70);
   offG.setColor(Color.black);
   offG.drawRect(31, 125, 121, 60);
   offG.setColor(Color.red);
   offG.drawString("TETRIS", 70, 150);
   offG.setColor(Color.blue);
   offG.drawString("Press START button!", 35, 170);
               
  }
//����� ����Ʈ���ִ� ����
  public void dropBlock()
  {
    removeBlock(); //������ ����� �����  �׸��� ����� ��ǥ���� �״�� ��������. 
    
    if(checkDrop()) { //checkDrop�� ����� üũ���ִ� ����. �Ʒ� ����̾���(=true)�� �׷���  y+1
       for(int i= 0; i<4; i++) {
          blockY[i] =blockY[i]+1; //
       }
    }else { //����������� ���� 
       drawBlock();  
       nextBlock();  //���� ��ϻ���
    }
  }

  public void delLine()   
  {
   boolean delOk;
   
   for(int row=20; row>=0; row--) { //����� ���ﶧ ĭ�� �ٸ޲����ִ��� ������ Ȯ���ϴ� ������ �ϴ� ����  
      delOk = true;
      for(int col=0; col<12; col++) {
         if(!map[col][row]) delOk = false;
      }
      
      if(delOk) {
         try
         {
            AudioInputStream stream=
                  AudioSystem.getAudioInputStream(new File("src/sound/shoot.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
         }
         catch (Exception ex) 
         {}
      finally 
      {
         score+=10;
      }
         
         if(score<1000) {
            delayTime = 1000-score;
         } else { 
            delayTime = 0;
         }
         
         for(int delRow=row; delRow>0; delRow--) {
            for(int delCol=0; delCol<12; delCol++) {
               map[delCol][delRow] = map[delCol][delRow-1];
               colorMap[delCol][delRow] = colorMap[delCol][delRow-1];
            }
         }
         for(int i=0; i<12; i++) {
            map[0][i]=false;
            colorMap[0][i]=Color.white;
         }
      row++;
      }
   }
  }

  public void nextBlock()
  {
     blockType= Math.abs(r.nextInt()%7);
     blockPos = 0;
     delLine();
     setBlockXY(blockType);
     checkGameOver();
  }

  public void checkGameOver()
  {
    
    
    
  }
  
  public void removeBlock()
  {
          for(int i= 0; i<4; i++) {
             map[blockX[i]][blockY[i]] =false;
             colorMap[blockX[i]][blockY[i]]= Color.white;
          }
  }

  public boolean checkDrop()
  {
   boolean dropOk=true;
   
   for(int i=0; i<4; i++) {
      if((blockY[i]+1)!=21) {
         if(map[blockX[i]][blockY[i]+1]) dropOk= false;
      }else {
         dropOk=false;
      }
   }
   return dropOk;
  }

  public void drawBlock()
  {
     for(int i=0; i<4; i++) {
        map[blockX[i]][blockY[i]]=true;
        colorMap[blockX[i]][blockY[i]]=colorType[blockType];
     }
  }

  //
  public void drawMap()
  {
     for(int i=0; i<12; i++) {
        for(int j=0; j<21; j++) {
           if(map[i][j]) { //�о�� �迭�� ���� true�� ������ ������ �׸���
              offG.setColor(colorMap[i][j]);
              offG.fillRect(i*15, j*15, 15, 15);
           }else { //�װ� �ƴ϶�� �÷��� ȭ��Ʈ��. �׷���
              offG.setColor(Color.white);
              offG.fillRect(i*15, j*15, 15, 15); //��ĭ�׷��������μ��� 15��  
              //fillRect�ϸ� �׳� ����簢��, ��ȭ��ó�� ����. ��輱�� �Ⱥ��� 
           }
        }
     }
  }

  //��輱�� �����ִ� �޼ҵ� 
  public void drawGrid()
  {
   offG.setColor(new Color(190,190,190));
   for(int i=0; i<12; i++) {
        for(int j=0; j<21; j++) {
           offG.drawRect(i*15, j*15, 15, 15);
        }
     }
  }
  public void stop()
  {
    
    
    
  }

  //start ��ư �������� ����Ǵ� �޼ҵ� 
  public void actionPerformed(ActionEvent e)
  {

blockPos=0;
for(int i=0; i<12; i++) {
   for(int j=0; j<21; j++) {
      map[i][j]=false;
   }
}
 r= new Random();
 blockType= Math.abs(r.nextInt()%7);
 setBlockXY(blockType);
 
 drawBlock();
 drawMap();
 drawGrid();
 
 score=0;
 delayTime=100;
 runGame=1;
 
 this.requestFocus();
  }

  public static void main(String[] args) 
  {
    new GameJava2_11();
  }
  
  //Ű�� �������� Ű������ �̺�Ʈ�� ó�����ִ� Ŭ���� 
  class MyKeyHandler extends KeyAdapter
  {
    public void keyPressed(KeyEvent e)
    {
        
      
    
    
    
      repaint();
    }

    public boolean checkTurn()
    {
      
    
    
    }

    public boolean checkMove(int dir)
    {
      
    
    
    }


    
    public void turnBlock()
    {
      
    
    
    }
  } 
} */
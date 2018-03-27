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
    
   //가상화면 만들기
   off= createImage(181, 316);
   offG=off.getGraphics();
   offG.setColor(Color.white);
   offG.fillRect(0,0,192,192);
   
   // 점수, 블록떨어지는 시간 등 초기화 
   score = 0; // 점수
   delayTime=1000; //블록이 떨어지는 시간
   runGame=0;
   
   //가장 처음 시작되는 생성자에 처음 보이는 화면 초기화 해주기 위한 메소드 3개 
   drawBlock();
   drawMap();
   drawGrid();
  
   //mykeyhandler를 이벤트핸들러로 사용함. 어떤키가 눌렸는지 판단하는 메소드  
   addKeyListener(new MyKeyHandler());

   start();
    
  }
  //블록에 맞는 색깔을 정해놓고 그색깔 사용하려는 메소드 
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
     case 0:  //정사각형 네모블록을 맨위 중간부분에 만드는거임.  
     blockX[0]= 5; blockY[0] =0; //5는 행값 0은 열값에 해당되는 map이라는 2차원 배열의 인덱스 번호. 
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
  
  //이 쓰레드가 계속 돌기때문에 아까 버벅거리는 문제를 해결 할수있음
  public void start()
  {
    if(clock==null) {
       clock = new Thread(this);
       clock.start(); 
    }
  }
  //가상화면에 있는 것들을 옮겨다가 실제로 그려주는 메소드. 
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
//블록을 떨어트려주는 역할
  public void dropBlock()
  {
    removeBlock(); //기존의 블록을 지우기  그림만 지우고 좌표값은 그대로 남아있음. 
    
    if(checkDrop()) { //checkDrop은 블록을 체크해주는 역할. 아래 블록이없다(=true)다 그러면  y+1
       for(int i= 0; i<4; i++) {
          blockY[i] =blockY[i]+1; //
       }
    }else { //블록이있으면 실행 
       drawBlock();  
       nextBlock();  //다음 블록생성
    }
  }

  public void delLine()   
  {
   boolean delOk;
   
   for(int row=20; row>=0; row--) { //블록을 지울때 칸이 다메꿔져있는지 없는지 확인하는 역할을 하는 구문  
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
           if(map[i][j]) { //읽어온 배열의 값이 true면 색깔을 입혀서 그리고
              offG.setColor(colorMap[i][j]);
              offG.fillRect(i*15, j*15, 15, 15);
           }else { //그게 아니라면 컬러를 화이트로. 그려라
              offG.setColor(Color.white);
              offG.fillRect(i*15, j*15, 15, 15); //한칸그려질때가로세로 15임  
              //fillRect하면 그냥 흰색사각형, 도화지처럼 보임. 경계선이 안보임 
           }
        }
     }
  }

  //경계선을 보여주는 메소드 
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

  //start 버튼 눌렀을때 실행되는 메소드 
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
  
  //키가 눌렸을때 키에대한 이벤트를 처리해주는 클래스 
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
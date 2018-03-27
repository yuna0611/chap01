package com_yuna_test;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Random;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameJava2_11 extends JFrame 
 implements Runnable, ActionListener	//다중상속 //ActionListener :  Swing의 이벤트핸들러 (ex)start button 눌렀을 때 처리하기 
{ 
  Thread clock;
  Clip clip;

  Image off; //이미지 불러올 때, 가상화면 만들때 사용  //가상화면 만드는 이유는 버퍼링을 제거하기 위해
  Graphics offG;

  Random r;

  boolean[][] map;	//테트리스 배경화면(눈금 배열) 12행 21열 -> 실제로 출력될 때는 21행 12열로 보임
  Color[] colorType;
  Color[][] colorMap;

  int blockType;	//7개 중의 한개 random으로 해서 나오게
  int[] blockX;	//기존의 블록 저장하는 배열
  int[] blockY;	//기존의 블록 저장하는 배열
  int blockPos;		//회전 횟수 MAX=3, default = 0, 회전은 시계 반대방향

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
    
    
    //멤버변수 초기화 하는 작업
    map=new boolean[12][21];
    colorMap = new Color[12][21];
    colorType= new Color[7];
    setColorType();	//밑에서 정의함
    
    blockX=new int[4];
    blockY=new int[4];
    blockPos=0;
    
    r=new Random();
    blockType = Math.abs(r.nextInt()%7);
    setBlockXY(blockType); //밑에서 정의함
    
    
    //가상화면 초기화
    off=createImage(181, 316);	//181x316 격자 GUI 사이즈 //가로 세로 15pixel
    offG=off.getGraphics();
    offG.setColor(Color.WHITE);
    offG.fillRect(0, 0, 192, 192);
    
    score=0;	//점수 초기화, 한 줄 깰때마다 +10
    delayTime=300;	//블록 떨어지는 시간 
    runGame=0;	
    
    //가장 처음 시작되는 생성자에 가상화면에 초기화 해주기 위한 메소드 3개
    drawBlock();
    drawMap();
    drawGrid();
    
    addKeyListener(new MyKeyHandler());	//키 눌리면 눌릴때마다 이벤트 핸들러 수행 ( 어떤 키가 눌리는지에 대해 처리)
    
    start();
    
    
    //여기까지가 생성자에서 초기화 완료
    //생성자에서 선언한 메소드 밑에서 완성하기
  }
  

  //색 저장하는 colorType에 R,G,B 컬러값 주기
  public void setColorType()
  {
	  colorType[0]= new Color(65,228,82);
	  colorType[1]= new Color(58,98,235);
	  colorType[2]= new Color(128,0,64);
	  colorType[3]= new Color(255,35,31);
	  colorType[4]= new Color(68,17,111);
	  colorType[5]= new Color(246,118,57);
	  colorType[6]= new Color(224,134,4);
  }

  
  //blockX,blockY 초기화
  public void setBlockXY(int type)
  {
	  switch (type) {
	case 0:	//블록 종류
		blockX[0]=5; blockY[0]=0;	//5, 0 -> 6행, 0열 -> 가운데서 떨어지게 하기 위해서
		blockX[1]=6; blockY[1]=0;
		blockX[2]=5; blockY[2]=1;
		blockX[3]=6; blockY[3]=1;	//map 2차원 배열의 인덱스 번호 //블록 그리기 위한 인덱스
		break;
	case 1:
		blockX[0]=6; blockY[0]=0;
		blockX[1]=5; blockY[1]=1;
		blockX[2]=6; blockY[2]=1;
		blockX[3]=7; blockY[3]=1;
		break;
	case 2:
		blockX[0]=7; blockY[0]=0;
		blockX[1]=5; blockY[1]=1;
		blockX[2]=6; blockY[2]=1;
		blockX[3]=7; blockY[3]=1;
		break;
	case 3:
		blockX[0]=5; blockY[0]=0;
		blockX[1]=5; blockY[1]=1;
		blockX[2]=6; blockY[2]=1;
		blockX[3]=7; blockY[3]=1;
		break;
	case 4:
		blockX[0]=5; blockY[0]=0;
		blockX[1]=5; blockY[1]=1;
		blockX[2]=6; blockY[2]=1;
		blockX[3]=6; blockY[3]=2;
		break;
	case 5:
		blockX[0]=6; blockY[0]=0;
		blockX[1]=5; blockY[1]=1;
		blockX[2]=6; blockY[2]=1;
		blockX[3]=5; blockY[3]=2;
		break;
	case 6:
		blockX[0]=4; blockY[0]=0;
		blockX[1]=5; blockY[1]=0;
		blockX[2]=6; blockY[2]=0;
		blockX[3]=7; blockY[3]=0;
		break;
	  }
  }

  //이미지 버퍼링 해결
  public void start()
  {
	  if(clock==null) {
		  clock = new Thread(this);
		  clock.start();
	  }
  }

  //자동 호출되는 메소드 //가상화면에 그려지는 메소드
  public void paint(Graphics g)
  {
	  g.drawImage(off, 25, 50, this); 
  }

  public void update(Graphics g)
  {
    paint(g);
  }

  //버퍼링 해결 
  public void run()
  {
	  while(true) {
		  try {
			clock.sleep(delayTime);
		} catch (InterruptedException ie) {}
		  
		  dropBlock();
		  
		  switch (runGame) {
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
	  offG.setColor(Color.white);
	  offG.fillRect(35, 120, 110, 70);
	  offG.setColor(Color.BLACK);
	  offG.drawRect(40, 125, 100, 60);
	  offG.setColor(Color.RED);
	  offG.drawString("Game Over !", 56, 150);
	  offG.setColor(Color.blue);
	  offG.drawString("Score : "+score, 56, 170);
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

  //블록 떨어지기
  public void dropBlock()
  {
	  removeBlock();
	  
	  if(checkDrop()) {
		  for (int i = 0; i < 4; i++) {
			blockY[i] = blockY[i]+1;
		}
	  }else {
		  drawBlock();
		  nextBlock();
	  }
  }

  public void delLine()
  {
	  boolean delOK;
	  
	  for (int row = 20; row >=0; row--) {
		delOK=true;
		for (int col = 0; col < 12; col++) {
			if(!map[col][row])
				delOK=false;
		}
		if(delOK) {
			try {
				AudioInputStream stream = AudioSystem.getAudioInputStream(new File("src/sound/shoot.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(stream);
				clip.start();
			} catch (Exception ex) {
			}finally {
				score+=10;
			}
			
			if(score<1000) {
				delayTime=300-score;
			}else {
				delayTime=0;
			}
			for (int delRow =row; delRow>0; delRow--) {
				for (int delCol = 0; delCol < 12; delCol++) {
					map[delCol][delRow] = map[delCol][delRow-1];
					colorMap[delCol][delRow]=colorMap[delCol][delRow-1];
				}
			}
			for (int i = 0; i < 12; i++) {
				map[0][i]=false;
				colorMap[0][i] = Color.white;
			}
			row++;
		}
	}
  }

  public void nextBlock()
  {
	blockType = Math.abs(r.nextInt()%7);
	blockPos=0;
	delLine();
	setBlockXY(blockType);
	checkGameOver();
  }

  public void checkGameOver()
  {
	  for (int i = 0; i < 4; i++) {
		if(map[blockX[i]][blockY[i]]) {
			if(runGame==1) {
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(new File("src/sound/end.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
				} catch (Exception e) {
					// TODO: handle exception
				}
				runGame=2;
			}
		}
	}
  }

  //블록이 떨어질때 기존의 블록 지우기
  public void removeBlock()
  {
	  for (int i = 0; i < 4; i++) {
		  map[blockX[i]][blockY[i]] = false;
		  colorMap[blockX[i]][blockY[i]]=Color.white;
	}
  }

  
  public boolean checkDrop()
  {
	  boolean dropOk = true;
	  
	  for (int i = 0; i < 4; i++) {
		if((blockY[i]+1)!=21) {
			if(map[blockX[i]][blockY[i]+1])
				dropOk=false;
		}else
			dropOk=false;
	}
	  	return dropOk; 
  }

  //map, colorMap 초기화
  public void drawBlock()
  {
	  for (int i = 0; i < 4; i++) {
		map[blockX[i]][blockY[i]]=true;
		colorMap[blockX[i]][blockY[i]] = colorType[blockType];
	}
  }

  public void drawMap()
  {
	  for (int i = 0; i < 12; i++) {
		for (int j = 0; j < 21; j++) {
			if(map[i][j]) {
				offG.setColor(colorMap[i][j]);
				offG.fillRect(i*15, j*15, 15, 15);
			}else {
				offG.setColor(Color.white);
				offG.fillRect(i*15, j*15, 15, 15);
			}
		}
	}
  }

  public void drawGrid()
  {
	  offG.setColor(new Color(190, 190, 190));
	  
	  for (int i = 0; i < 12; i++) {
		  for (int j = 0; j < 21; j++) {
			offG.drawRect(i*15, j*15, 15, 15);
		}
	}
  }

  public void stop()
  {
    /*
	 
	 */
  }

  //start 버튼 눌렀을 때 실행되는 메소드
  public void actionPerformed(ActionEvent e)
  {
	  blockPos=0;

	  for (int i = 0; i < 12; i++) {
		  for (int j = 0; j < 21; j++) {
			map[i][j]=false;
		}
	}
	
	  
	  for (int i = 20; i > 15; i--) {
		  for (int j = 0; j < 12; j++) {
			  int check=(int)(Math.random()*2)+1;
			
			  if(check==1) {
				  map[j][i]=true;
				  colorMap[j][i]=colorType[blockType];
			  }
		}
	  }
	  
	  r=new Random();
	  blockType=Math.abs(r.nextInt()%7);
	  setBlockXY(blockType);
	  
	  drawBlock();
	  drawMap();
	  drawGrid();
	  
	  score=0;
	  delayTime=300;
	  runGame=1;
	  
	  this.requestFocus();
  }

  public static void main(String[] args) 
  {
	 new GameJava2_11();
  }
  
  
  //키 눌렀을 때 실행되는 이벤트핸들러
  class MyKeyHandler extends KeyAdapter
  {
    public void keyPressed(KeyEvent e)
    {
        int keyCode = (int)e.getKeyCode();
        
        if(keyCode==KeyEvent.VK_LEFT) {
        	if(checkMove(-1)) {
        		for (int i = 0; i < 4; i++) {
					blockX[i]=blockX[i]-1;
				}
        	}
        }
        if(keyCode==KeyEvent.VK_RIGHT) {
        	if(checkMove(1)) {
        		for (int i = 0; i < 4; i++) {
					blockX[i]=blockX[i]+1;
				}
        	}
        }
        if(keyCode==KeyEvent.VK_DOWN) {
        	removeBlock();
        	
        	if(checkDrop()) {
        		for (int i = 0; i < 4; i++) {
        			blockY[i]=blockY[i]+1;
        		}
        	}else
        		drawBlock();
        }
        
        if(keyCode==KeyEvent.VK_UP) {
        	int[] tempX = new int[4];
        	int[] tempY = new int[4];
        	
        	for (int i = 0; i < 4; i++) {
				tempX[i]=blockX[i];
				tempY[i]=blockY[i];
			}
        	removeBlock();
        	turnBlock();
        	
        	if(checkTurn()) {
        		try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(new File("src/sound/sound.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
				} catch (Exception e2) {}
        		
        		if(blockPos<4)
        			blockPos++;
        		else
        			blockPos=0;
        	}else
        		for (int i = 0; i < 4; i++) {
					blockX[i]=tempX[i];
					blockY[i]=tempY[i];
					map[blockX[i]][blockY[i]]=true;
					colorMap[blockX[i]][blockY[i]] = colorType[blockType];
				}
        		drawBlock();
        }
      repaint();
    }

    public boolean checkTurn()
    {
    	boolean turnOk = true;
    	
    	for (int i = 0; i < 4; i++) {
			if((blockX[i]>=0) && (blockX[i]<12) && (blockY[i]>=0)&&(blockY[i]<21)) {
				if(map[blockX[i]][blockY[i]])
					turnOk=false;
			}else 
			turnOk=false;
    	}
		return turnOk;
    }

    public boolean checkMove(int dir)
    {
    	boolean moveOk = true;
    	removeBlock();
    	
    	for (int i = 0; i < 4; i++) {
			if(((blockX[i]+dir)>=0) && ((blockX[i]+dir)<12)) {
				if(map[blockX[i]+dir][blockY[i]])
					moveOk=false;
			}else
				moveOk=false;
			
    	}
			if(!moveOk)
				drawBlock();
			return moveOk;
    }

    
    public void turnBlock()
    {
    	switch (blockType) {
		case 1:
			switch (blockPos) {
			case 0:
				blockX[0]=blockX[0] ; blockY[0]=blockY[0];
				blockX[1]=blockX[1] ; blockY[1]=blockY[1];
				blockX[2]=blockX[2] ; blockY[2]=blockY[2];
				blockX[3]=blockX[3]-1 ; blockY[3]=blockY[3]+1;
				break;
			case 1:
				blockX[0]=blockX[0]-1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]+1 ; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]+1 ; blockY[2]=blockY[2]-1;
				blockX[3]=blockX[3] ; blockY[3]=blockY[3]-1;
				break;
			case 2:
				blockX[0]=blockX[0]+1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1] ; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2] ; blockY[2]=blockY[2]+1;
				blockX[3]=blockX[3] ; blockY[3]=blockY[3]+1;
				break;
			case 3:
				blockX[0]=blockX[0] ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]-1 ; blockY[1]=blockY[1];
				blockX[2]=blockX[2]-1 ; blockY[2]=blockY[2];
				blockX[3]=blockX[3]+1 ; blockY[3]=blockY[3]-1;
				break;
			}
			break;

		case 2:
			switch (blockPos) {
			case 0:
				blockX[0]=blockX[0]-1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]+2; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]+1; blockY[2]=blockY[2];
				blockX[3]=blockX[3] ; blockY[3]=blockY[3]+1;
				break;
			case 1:
				blockX[0]=blockX[0]-1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]-1 ; blockY[1]=blockY[1];
				blockX[2]=blockX[2] ; blockY[2]=blockY[2]-1;
				blockX[3]=blockX[3]-2 ; blockY[3]=blockY[3]-1;
				break;
				
				
			case 2:
				blockX[0]=blockX[0]+1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1] ; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2]-1; blockY[2]=blockY[2]+2;
				blockX[3]=blockX[3]+2; blockY[3]=blockY[3]+1;
				break;
				
				
			case 3:
				blockX[0]=blockX[0]+1; blockY[0]=blockY[0];
				blockX[1]=blockX[1]-1 ; blockY[1]=blockY[1];
				blockX[2]=blockX[2] ; blockY[2]=blockY[2]-1;
				blockX[3]=blockX[3] ; blockY[3]=blockY[3]-1;
				break;
			}
			break;
			
		case 3:
			switch (blockPos) {
			case 0:
				blockX[0]=blockX[0]+1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]+1; blockY[1]=blockY[1];
				blockX[2]=blockX[2]-1; blockY[2]=blockY[2]+1;
				blockX[3]=blockX[3]-1; blockY[3]=blockY[3]+1;
				break;
			case 1:
				blockX[0]=blockX[0]-1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1] ; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]+2; blockY[2]=blockY[2]-2;
				blockX[3]=blockX[3]+1 ; blockY[3]=blockY[3]-1;
				break;
				
				
			case 2:
				blockX[0]=blockX[0]+1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]+1; blockY[1]=blockY[1];
				blockX[2]=blockX[2]-1; blockY[2]=blockY[2]+1;
				blockX[3]=blockX[3]-1; blockY[3]=blockY[3]+1;
				break;
				
				
			case 3:
				blockX[0]=blockX[0]-1; blockY[0]=blockY[0];
				blockX[1]=blockX[1]-2 ; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2] ; blockY[2]=blockY[2];
				blockX[3]=blockX[3]+1; blockY[3]=blockY[3]-1;
				break;
			}
			break;
		case 4:
			switch (blockPos) {
			case 0:
				blockX[0]=blockX[0]+1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]+2; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]-1; blockY[2]=blockY[2];
				blockX[3]=blockX[3]; blockY[3]=blockY[3]-1;
				break;
			case 1:
				blockX[0]=blockX[0] ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]-1 ; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2]+2; blockY[2]=blockY[2];
				blockX[3]=blockX[3]+1 ; blockY[3]=blockY[3]+1;
				break;
			case 2:
				blockX[0]=blockX[0] ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]+1; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]-2; blockY[2]=blockY[2];
				blockX[3]=blockX[3]-1; blockY[3]=blockY[3]-1;
				break;
			case 3:
				blockX[0]=blockX[0]-1; blockY[0]=blockY[0];
				blockX[1]=blockX[1]-2 ; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2]+1; blockY[2]=blockY[2];
				blockX[3]=blockX[3]; blockY[3]=blockY[3]+1;
				break;
			}
			break;
		case 5:
			switch (blockPos) {
			case 0:
				blockX[0]=blockX[0]-1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]+1; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]; blockY[2]=blockY[2];
				blockX[3]=blockX[3]+2; blockY[3]=blockY[3]-1;
				break;
			case 1:
				blockX[0]=blockX[0]+2; blockY[0]=blockY[0];
				blockX[1]=blockX[1] ; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2]+1; blockY[2]=blockY[2];
				blockX[3]=blockX[3]-1 ; blockY[3]=blockY[3]+1;
				break;
			case 2:
				blockX[0]=blockX[0]-2; blockY[0]=blockY[0];
				blockX[1]=blockX[1]; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]-1; blockY[2]=blockY[2];
				blockX[3]=blockX[3]+1; blockY[3]=blockY[3]-1;
				break;
			case 3:
				blockX[0]=blockX[0]+1; blockY[0]=blockY[0];
				blockX[1]=blockX[1]-1 ; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2]; blockY[2]=blockY[2];
				blockX[3]=blockX[3]-2; blockY[3]=blockY[3]+1;
				break;
			}
			break;
		case 6:
			switch (blockPos) {
			case 0:
				blockX[0]=blockX[0]+1 ; blockY[0]=blockY[0];
				blockX[1]=blockX[1]; blockY[1]=blockY[1]+1;
				blockX[2]=blockX[2]-1; blockY[2]=blockY[2]+2;
				blockX[3]=blockX[3]-2; blockY[3]=blockY[3]+3;
				break;
			case 1:
				blockX[0]=blockX[0]-1; blockY[0]=blockY[0];
				blockX[1]=blockX[1] ; blockY[1]=blockY[1]-1;
				blockX[2]=blockX[2]+1; blockY[2]=blockY[2]-2;
				blockX[3]=blockX[3]+2 ; blockY[3]=blockY[3]-3;
				break;
			}
			break;
		}
    }
  } 
} 

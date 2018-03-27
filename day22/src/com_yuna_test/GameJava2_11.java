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
 implements Runnable, ActionListener	//���߻�� //ActionListener :  Swing�� �̺�Ʈ�ڵ鷯 (ex)start button ������ �� ó���ϱ� 
{ 
  Thread clock;
  Clip clip;

  Image off; //�̹��� �ҷ��� ��, ����ȭ�� ���鶧 ���  //����ȭ�� ����� ������ ���۸��� �����ϱ� ����
  Graphics offG;

  Random r;

  boolean[][] map;	//��Ʈ���� ���ȭ��(���� �迭) 12�� 21�� -> ������ ��µ� ���� 21�� 12���� ����
  Color[] colorType;
  Color[][] colorMap;

  int blockType;	//7�� ���� �Ѱ� random���� �ؼ� ������
  int[] blockX;	//������ ��� �����ϴ� �迭
  int[] blockY;	//������ ��� �����ϴ� �迭
  int blockPos;		//ȸ�� Ƚ�� MAX=3, default = 0, ȸ���� �ð� �ݴ����

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
    
    
    //������� �ʱ�ȭ �ϴ� �۾�
    map=new boolean[12][21];
    colorMap = new Color[12][21];
    colorType= new Color[7];
    setColorType();	//�ؿ��� ������
    
    blockX=new int[4];
    blockY=new int[4];
    blockPos=0;
    
    r=new Random();
    blockType = Math.abs(r.nextInt()%7);
    setBlockXY(blockType); //�ؿ��� ������
    
    
    //����ȭ�� �ʱ�ȭ
    off=createImage(181, 316);	//181x316 ���� GUI ������ //���� ���� 15pixel
    offG=off.getGraphics();
    offG.setColor(Color.WHITE);
    offG.fillRect(0, 0, 192, 192);
    
    score=0;	//���� �ʱ�ȭ, �� �� �������� +10
    delayTime=300;	//��� �������� �ð� 
    runGame=0;	
    
    //���� ó�� ���۵Ǵ� �����ڿ� ����ȭ�鿡 �ʱ�ȭ ���ֱ� ���� �޼ҵ� 3��
    drawBlock();
    drawMap();
    drawGrid();
    
    addKeyListener(new MyKeyHandler());	//Ű ������ ���������� �̺�Ʈ �ڵ鷯 ���� ( � Ű�� ���������� ���� ó��)
    
    start();
    
    
    //��������� �����ڿ��� �ʱ�ȭ �Ϸ�
    //�����ڿ��� ������ �޼ҵ� �ؿ��� �ϼ��ϱ�
  }
  

  //�� �����ϴ� colorType�� R,G,B �÷��� �ֱ�
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

  
  //blockX,blockY �ʱ�ȭ
  public void setBlockXY(int type)
  {
	  switch (type) {
	case 0:	//��� ����
		blockX[0]=5; blockY[0]=0;	//5, 0 -> 6��, 0�� -> ����� �������� �ϱ� ���ؼ�
		blockX[1]=6; blockY[1]=0;
		blockX[2]=5; blockY[2]=1;
		blockX[3]=6; blockY[3]=1;	//map 2���� �迭�� �ε��� ��ȣ //��� �׸��� ���� �ε���
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

  //�̹��� ���۸� �ذ�
  public void start()
  {
	  if(clock==null) {
		  clock = new Thread(this);
		  clock.start();
	  }
  }

  //�ڵ� ȣ��Ǵ� �޼ҵ� //����ȭ�鿡 �׷����� �޼ҵ�
  public void paint(Graphics g)
  {
	  g.drawImage(off, 25, 50, this); 
  }

  public void update(Graphics g)
  {
    paint(g);
  }

  //���۸� �ذ� 
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

  //��� ��������
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

  //����� �������� ������ ��� �����
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

  //map, colorMap �ʱ�ȭ
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

  //start ��ư ������ �� ����Ǵ� �޼ҵ�
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
  
  
  //Ű ������ �� ����Ǵ� �̺�Ʈ�ڵ鷯
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

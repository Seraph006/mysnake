package mysnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import grid.Grid;

public class Snake {
	    
	    public Snake(){
	    	init();
	    }
	    
	    public void init(){
	    	int x = Grid.WIDTH/2;
	    	int y = Grid.HEIGHT/2;
	    	for(int i=0;i<33;i++){
	    		body.addFirst(new Point(x--,y));
	    	}
	    olddirection = newdirection = LEFT;
	    life = true;
	    efil = true;
	    efil1 = 0;
	    threadspeed = 10;
	    }
	
	    public static final int UP = 0;
	    public static final int DOWN = 1;
	    public static final int LEFT = 2;
	    public static final int RIGHT = 3;
	    //private Point oldTail;
	    
	    private int olddirection,newdirection;
		private LinkedList<Point> body = new LinkedList<Point>();
	    private Set<Snakelisten> listener = new HashSet<Snakelisten>();
	    private boolean life;
	    private boolean efil;
	    private int efil1;
	    private int threadspeed;
	    public Point getHead(){
	    	return body.getFirst();
	    }
	    public void move(){
	    	/*oldTail = */
			int x = body.getFirst().x;
			int y = body.getFirst().y;	
			switch(efil1){case 0: 
				if((olddirection+newdirection!=5)&&(olddirection+newdirection!=1)){
					olddirection = newdirection;
				}
				body.removeLast();
				switch(olddirection){
				case UP:y--;if(y<0){y=Grid.HEIGHT-1;}break;
				case DOWN:y++;if(y+10>=Grid.HEIGHT){y=0;}break;
				case LEFT:x--;if(x<0){x=Grid.WIDTH-1;}break;
				case RIGHT:x++;if(x+10>=Grid.WIDTH){x=0;}break;
				}
				Point newHead = new Point(x,y);
				body.addFirst(newHead);
				break;
				case 1:break;}	
		}
		public void changeDirection(int direction){			
			newdirection = direction;		
		}
		public void eatFood(){
			int x = body.getFirst().x;
			int y = body.getFirst().y;
			for(int i=0;i<10;i++){
			switch(olddirection){
			case UP:y--;if(y<0){y=Grid.HEIGHT-1;}break;
			case DOWN:y++;if(y+10>=Grid.HEIGHT){y=0;}break;
			case LEFT:x--;if(x<0){x=Grid.WIDTH-1;}break;
			case RIGHT:x++;if(x+10>=Grid.WIDTH){x=0;}break;
			}
			//body.addLast(oldTail);
			Point newHead = new Point(x,y);
			body.addFirst(newHead);}
		}
		public boolean isEatBody(){
			for(int i=22;i<body.size();i++){
			if((((this.getHead().x*Grid.CELL_SIZE+Grid.CELL_SIZE*10)==
					body.get(i).x*Grid.CELL_SIZE+1*Grid.CELL_SIZE)&&
					(this.getHead().y>(body.get(i).y-Grid.CELL_SIZE*10))&&
					(this.getHead().y<(body.get(i).y+Grid.CELL_SIZE*10)))||
	(((this.getHead().x*Grid.CELL_SIZE)==body.get(i).x*Grid.CELL_SIZE+9*Grid.CELL_SIZE)&&
			(this.getHead().y>(body.get(i).y-Grid.CELL_SIZE*10))&&
							(this.getHead().y<(body.get(i).y+Grid.CELL_SIZE*10)))||
	(((this.getHead().y*Grid.CELL_SIZE+Grid.CELL_SIZE*10)==body.get(i).y*Grid.CELL_SIZE+1*Grid.CELL_SIZE)&&
			(this.getHead().x>(body.get(i).x-Grid.CELL_SIZE*10))&&
			   (this.getHead().x<body.get(i).x+Grid.CELL_SIZE*10))||
	(((this.getHead().y*Grid.CELL_SIZE)==body.get(i).y*Grid.CELL_SIZE+9*Grid.CELL_SIZE)&&
			(this.getHead().x>(body.get(i).x-Grid.CELL_SIZE*10))&&
			   (this.getHead().x<body.get(i).x+Grid.CELL_SIZE*10))){
				return true;
			}}
			return false;
		}
		public boolean foodcatchsnakebody(Food food){
			for(int i=10;i<body.size();i++)
			{
				if(((food.x*Grid.CELL_SIZE+10*Grid.CELL_SIZE>body.get(i).x*Grid.CELL_SIZE)
						&&(food.x*Grid.CELL_SIZE<(body.get(i).x*Grid.CELL_SIZE+Grid.CELL_SIZE*10)))&&
						((food.y*Grid.CELL_SIZE+10*Grid.CELL_SIZE>body.get(i).y*Grid.CELL_SIZE)&&
								(food.y*Grid.CELL_SIZE<(body.get(i).y*Grid.CELL_SIZE+Grid.CELL_SIZE*10))))
							
				return true;
			}
			return false;
		}
		public void drawMe(Graphics g){
			g.setColor(Color.WHITE);
			for(Point i:body){
				g.fill3DRect(i.x*Grid.CELL_SIZE,i.y*Grid.CELL_SIZE,Grid.CELL_SIZE*10,Grid.CELL_SIZE*10,true);
			}
		}
		//move itselg altolly!!!
		private class SnakeDriver implements Runnable{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(life){
					move();
					for(Snakelisten i:listener){
						i.move(Snake.this);
					}
					try{Thread.sleep(threadspeed);}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				
			}
			
		}
		public void addListener(Snakelisten l){
			if(l!=null){
				this.listener.add(l);
			}
		}
		public void start(){
			new Thread(new SnakeDriver()).start();
		}

		public void die() {
			// TODO Auto-generated method stub
			life = false;
		}
		public void pause(){
			if(efil){
				efil = false;
				efil1 = 1;
			}
			else{
				efil = true;
				efil1 = 0;
			}
        }

		public void acc() {
			// TODO Auto-generated method stub
			if(threadspeed>1)threadspeed--;
		}

		public void slow() {
			// TODO Auto-generated method stub
			if(threadspeed<19)threadspeed++;
		}
}

package mysnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import grid.Grid;

public class Food extends Point{
	private int xx = new Random().nextInt(7);
	public boolean isSnakeEatFood(Snake snake){
		if((((snake.getHead().x*Grid.CELL_SIZE+Grid.CELL_SIZE*10)==this.x*Grid.CELL_SIZE+1*Grid.CELL_SIZE)&&
				(snake.getHead().y>(this.y-Grid.CELL_SIZE*10))&&
						(snake.getHead().y<(this.y+Grid.CELL_SIZE*10)))||
		(((snake.getHead().x*Grid.CELL_SIZE)==this.x*Grid.CELL_SIZE+9*Grid.CELL_SIZE)&&
				(snake.getHead().y>(this.y-Grid.CELL_SIZE*10))&&
								(snake.getHead().y<(this.y+Grid.CELL_SIZE*10)))||
		(((snake.getHead().y*Grid.CELL_SIZE+Grid.CELL_SIZE*10)==this.y*Grid.CELL_SIZE+1*Grid.CELL_SIZE)&&
				(snake.getHead().x>(this.x-Grid.CELL_SIZE*10))&&
				   (snake.getHead().x<this.x+Grid.CELL_SIZE*10))||
		(((snake.getHead().y*Grid.CELL_SIZE)==this.y*Grid.CELL_SIZE+9*Grid.CELL_SIZE)&&
				(snake.getHead().x>(this.x-Grid.CELL_SIZE*10))&&
				   (snake.getHead().x<this.x+Grid.CELL_SIZE*10))){
			return true;
	}else{
		return false;
	}
}

	public void drawMe(Graphics g){
		switch(xx){
		case 0:g.setColor(Color.RED);break;
		case 1:g.setColor(Color.ORANGE);break;
		case 2:g.setColor(Color.YELLOW);break;
		case 3:g.setColor(Color.GREEN);break;
		case 4:g.setColor(Color.BLUE);break;
		case 5:g.setColor(Color.CYAN);break;
		case 6:g.setColor(Color.PINK);break;
		}
		g.fill3DRect(x*Grid.CELL_SIZE,y*Grid.CELL_SIZE,Grid.CELL_SIZE*10,Grid.CELL_SIZE*10,true);
	}
	
	//public Food(){
		//int x =new Random().nextInt(888);
		//int y =new Random().nextInt(666);
		//this.x = x;
		//this.y = y;
	//}
	
	public void newFood(Point p){
		this.setLocation(p);
	}

	/*public void freeexersize() {
		// TODO Auto-generated method stub
		if(y<0){y=Grid.HEIGHT-1;}
	    if(y+10>=Grid.HEIGHT){y=0;}
	    if(x<0){x=Grid.WIDTH-1;}
	    if(x+10>=Grid.WIDTH){x=0;}
		Random random = new Random();
		int z=random.nextInt(8);
		switch(z){
		case 0:x+=3;if(x+10>=Grid.WIDTH){x=0;}break;
		case 1:x-=3;if(x<0){x=Grid.WIDTH-1;}break;
		case 2:y+=3;if(y+10>=Grid.HEIGHT){y=0;}break;
		case 3:y-=3;if(y<0){y=Grid.HEIGHT-1;}break;
		case 4:y-=3;x+=3;if(y<0){y=Grid.HEIGHT-1;}if(x+10>=Grid.WIDTH){x=0;}break;
		case 5:y-=3;x-=3;if(y<0){y=Grid.HEIGHT-1;}if(x<0){x=Grid.WIDTH-1;}break;
		case 6:y+=3;x+=3;if(y+10>=Grid.HEIGHT){y=0;}if(x+10>=Grid.WIDTH){x=0;}break;
		case 7:y+=3;x-=3;if(y+10>=Grid.HEIGHT){y=0;}if(x<0){x=Grid.WIDTH-1;}break;
		}
	}*/
}


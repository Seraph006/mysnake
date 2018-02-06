package mysnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import grid.Grid;

public class Ground{
	private int[][] rocks = new int[Grid.WIDTH][Grid.HEIGHT]; 
	private int xx = new Random().nextInt(7);
	public boolean isSnakeEatRock(Snake snake){
		for(int i=0;i<Grid.WIDTH;i++){
			for(int j=0;j<Grid.HEIGHT;j++){
		if((rocks[i][j]==1)&&
				((((snake.getHead().x*Grid.CELL_SIZE+Grid.CELL_SIZE*10)==i*Grid.CELL_SIZE+1*Grid.CELL_SIZE)&&
				(snake.getHead().y>(j-Grid.CELL_SIZE*10))&&
				(snake.getHead().y<(j+Grid.CELL_SIZE*10)))||
(((snake.getHead().x*Grid.CELL_SIZE)==i*Grid.CELL_SIZE+9*Grid.CELL_SIZE)&&
		(snake.getHead().y>(j-Grid.CELL_SIZE*10))&&
						(snake.getHead().y<(j+Grid.CELL_SIZE*10)))||
(((snake.getHead().y*Grid.CELL_SIZE+Grid.CELL_SIZE*10)==j*Grid.CELL_SIZE+1*Grid.CELL_SIZE)&&
		(snake.getHead().x>(i-Grid.CELL_SIZE*10))&&
		   (snake.getHead().x<i+Grid.CELL_SIZE*10))||
(((snake.getHead().y*Grid.CELL_SIZE)==j*Grid.CELL_SIZE+9*Grid.CELL_SIZE)&&
		(snake.getHead().x>(i-Grid.CELL_SIZE*10))&&
		   (snake.getHead().x<i+Grid.CELL_SIZE*10))))
		{return true;}}}
		 return false;
}
	
	public boolean catchfood(Food food){
		for(int i=0;i<Grid.WIDTH;i++){
			for(int j=0;j<Grid.HEIGHT;j++){
		if((rocks[i][j]==1)&&((((food.x*Grid.CELL_SIZE+10*Grid.CELL_SIZE>i*Grid.CELL_SIZE)
				&&(food.x*Grid.CELL_SIZE<(i*Grid.CELL_SIZE+Grid.CELL_SIZE*10)))&&
				((food.y*Grid.CELL_SIZE+10*Grid.CELL_SIZE>j*Grid.CELL_SIZE)&&
						(food.y*Grid.CELL_SIZE<(j*Grid.CELL_SIZE+Grid.CELL_SIZE*10))))))
		{return true;}}}
		 return false;
}
	
	public Ground(){
		for(int i=0;i<100;i++){
			int a = new Random().nextInt(Grid.WIDTH);
			int b = new Random().nextInt(Grid.HEIGHT);
			if(b<0){b=Grid.HEIGHT-1;}
			if(b+10>=Grid.HEIGHT){b=0;}
			if(a<0){a=Grid.WIDTH-1;}
			if(a+10>=Grid.WIDTH){a=0;}
			rocks[a][b] = 1;
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
	for(int x=0;x<Grid.WIDTH;x++){
		for(int y=0;y<Grid.HEIGHT;y++){
			if(rocks[x][y]==1){
				g.fill3DRect(x*Grid.CELL_SIZE,y*Grid.CELL_SIZE,Grid.CELL_SIZE*10,Grid.CELL_SIZE*10,true);
			}
		}
	}
}
}

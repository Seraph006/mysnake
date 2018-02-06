package control;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import grid.Grid;
import mysnake.Food;
import mysnake.Ground;
import mysnake.Snake;
import mysnake.Snakelisten;
import view.GamePanel;

public class Controller extends KeyAdapter implements Snakelisten{
	
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamepanel;

	
	
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamepanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamepanel = gamepanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:snake.changeDirection(Snake.UP);break;
		}
		switch(e.getKeyCode()){
		case KeyEvent.VK_DOWN:snake.changeDirection(Snake.DOWN);break;
		}
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:snake.changeDirection(Snake.LEFT);break;
		}
		switch(e.getKeyCode()){
		case KeyEvent.VK_RIGHT:snake.changeDirection(Snake.RIGHT);break;
		}
		switch(e.getKeyCode()){
		case KeyEvent.VK_SPACE:snake.pause();break;
		}
		switch(e.getKeyCode()){
		case KeyEvent.VK_X:snake.acc();break;
		}
		switch(e.getKeyCode()){
		case KeyEvent.VK_Z:snake.slow();break;
		}
		
	}

	@Override
	public void move(Snake snake) {
		// TODO Auto-generated method stub
		gamepanel.display(snake, food, ground);
		if(food.isSnakeEatFood(snake)){
			snake.eatFood();
			food.newFood(getPoint());
		}
		//food.freeexersize();
		if(ground.isSnakeEatRock(snake)){
			snake.die();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
		if(ground.catchfood(food)){
			food.newFood(getPoint());
		}
		if(snake.isEatBody()){
			snake.die();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
		if(snake.foodcatchsnakebody(food)){
			food.newFood(getPoint());
		}
	}
	
	public void newGame(){
		snake.start();
		food.newFood(getPoint());
	}
	
	public Point getPoint(){
		Random random = new Random();
		int x = random.nextInt(Grid.WIDTH);
		int y = random.nextInt(Grid.HEIGHT);
		if(x<0){x=Grid.WIDTH-1;}
		if((x+10)>Grid.WIDTH){x=0;}
		if(y<0){y=Grid.HEIGHT-1;}
		if(y+10>Grid.HEIGHT){y=0;}
		return new Point(x,y);
	}
}

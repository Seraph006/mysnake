package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import grid.Grid;
import mysnake.Food;
import mysnake.Ground;
import mysnake.Snake;

public class GamePanel extends JPanel{
	
	private Food food;
	private Snake snake;
	private Ground ground;
	
	public void display(Snake snake,Food food,Ground ground){
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {//redraw
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0,0,Grid.WIDTH*Grid.CELL_SIZE,Grid.HEIGHT*Grid.CELL_SIZE);
		if(ground!=null&&snake!=null&&food!=null){
		this.snake.drawMe(g);
		this.ground.drawMe(g);
		this.food.drawMe(g);
		}
	}
	
}

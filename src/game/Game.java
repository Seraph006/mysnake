package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import control.Controller;
import grid.Grid;
import mysnake.Food;
import mysnake.Ground;
import mysnake.Snake;
import view.GamePanel;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Snake snake = new Snake();
		Food food = new Food();
		GamePanel gamepanel = new GamePanel();
		Ground ground = new Ground();
		Controller controller = new Controller(snake,food,ground,gamepanel);
		
		
        JFrame frame = new JFrame("      Snake --- By Locust6      "
        		+ "�� �� �� �� �� �� �� : move      Z : decelerate      X : accelerate      Space : pause");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamepanel.setSize(Grid.WIDTH*Grid.CELL_SIZE,Grid.HEIGHT*Grid.CELL_SIZE);
		frame.setSize(Grid.WIDTH*Grid.CELL_SIZE+10,Grid.HEIGHT*Grid.CELL_SIZE+35);
		frame.add(gamepanel,BorderLayout.CENTER);
		gamepanel.addKeyListener(controller);
		snake.addListener(controller);
		frame.addKeyListener(controller);
		frame.setVisible(true);
		controller.newGame();
}
}

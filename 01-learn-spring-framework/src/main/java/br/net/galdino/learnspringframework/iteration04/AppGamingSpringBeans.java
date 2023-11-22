package br.net.galdino.learnspringframework.iteration04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.net.galdino.learnspringframework.iteration02.game.GamingConsole;
import br.net.galdino.learnspringframework.iteration04.game.GameRunner;

public class AppGamingSpringBeans {
	
	public static void main(String[] args) {
	
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		//var marioGame = new MarioGame();
		//var superContraGame = new SuperContraGame();
		//var gameRunner = new GameRunner(superContraGame);
		//gameRunner.run();

	}	

}

package br.net.galdino.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.net.galdino.learnspringframework.iteration05")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {
	
		try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		//var marioGame = new MarioGame();
		//var superContraGame = new SuperContraGame();
		//var gameRunner = new GameRunner(superContraGame);
		//gameRunner.run();

	}	

}

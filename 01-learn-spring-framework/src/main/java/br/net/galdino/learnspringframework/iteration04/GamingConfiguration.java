package br.net.galdino.learnspringframework.iteration04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.net.galdino.learnspringframework.iteration04.game.GameRunner;
import br.net.galdino.learnspringframework.iteration04.game.GamingConsole;
import br.net.galdino.learnspringframework.iteration04.game.PacMan;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		return new PacMan();
	}
	
	@Bean
	public GameRunner gameRunner() {
		return new GameRunner(game());
	}
	
	//var superContraGame = new SuperContraGame();
	//var gameRunner = new GameRunner(superContraGame);
	//gameRunner.run();

}

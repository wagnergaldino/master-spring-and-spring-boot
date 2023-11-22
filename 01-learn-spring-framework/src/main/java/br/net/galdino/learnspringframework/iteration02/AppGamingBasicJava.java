package br.net.galdino.learnspringframework.iteration02;

import br.net.galdino.learnspringframework.iteration02.game.GameRunner;
import br.net.galdino.learnspringframework.iteration02.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		//var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();

	}

}

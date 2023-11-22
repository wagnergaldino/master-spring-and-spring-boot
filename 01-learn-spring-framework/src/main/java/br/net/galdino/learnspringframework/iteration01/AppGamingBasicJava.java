package br.net.galdino.learnspringframework.iteration01;

import br.net.galdino.learnspringframework.iteration01.game.GameRunner;
import br.net.galdino.learnspringframework.iteration01.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		//var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();

	}

}

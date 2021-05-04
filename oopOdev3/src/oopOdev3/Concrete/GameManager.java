package oopOdev3.Concrete;

import oopOdev3.Abstract.IGameService;
import oopOdev3.Entities.Campaign;
import oopOdev3.Entities.Game;
import oopOdev3.Entities.Player;

public class GameManager implements IGameService{
	
	Campaign campaign;
	public GameManager(Campaign campaign) {
		this.campaign = campaign;
	}

	@Override
	public void buy(Game game, Player player) {
		System.out.println(player.getFirstName() + " adl� oyuncu �u kampanyay� kullanarak (" + this.campaign.getName() + ") sat�n ald� : " + game.getName());
		
	}
	
}

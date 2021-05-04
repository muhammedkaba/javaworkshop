package oopOdev3;

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

package oopOdev3.Concrete;

import oopOdev3.Abstract.IPlayerService;
import oopOdev3.Entities.Player;
import oopOdev3.Utils.VerifyHelper;

public class PlayerManager implements IPlayerService{

	@Override
	public void register(Player player) {
		VerifyHelper.Verify(player);
		System.out.println("Oyuncu kaydedildi : " + player.getFirstName());
		
	}

	@Override
	public void update(Player player) {
		System.out.println("Oyuncu güncellendi : " + player.getFirstName());
		
	}

	@Override
	public void delete(Player player) {
		System.out.println("Oyuncu silindi : " + player.getFirstName());
		
	}

}

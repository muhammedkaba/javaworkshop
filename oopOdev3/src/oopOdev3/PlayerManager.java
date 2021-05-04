package oopOdev3;

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

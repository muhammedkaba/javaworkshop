package oopOdev3.Abstract;

import oopOdev3.Entities.Player;

public interface IPlayerService {
	public void register(Player player);
	public void update(Player player);
	public void delete(Player player);
}

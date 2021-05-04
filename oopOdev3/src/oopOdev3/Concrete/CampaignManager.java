package oopOdev3.Concrete;

import oopOdev3.Abstract.ICampaignService;
import oopOdev3.Entities.Campaign;

public class CampaignManager implements ICampaignService{

	@Override
	public void add(Campaign campaign) {
		System.out.println("Kampanya eklendi : " + campaign.getName());
		
	}

	@Override
	public void delete(Campaign campaign) {
		System.out.println("Kampanya silindi : " + campaign.getName());
		
	}

}

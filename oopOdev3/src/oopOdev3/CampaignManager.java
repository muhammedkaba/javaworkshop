package oopOdev3;

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

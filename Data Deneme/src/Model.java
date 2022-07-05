/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kalka
 */
public class Model {
    private Model() {}
    
    //can be called with: Model.DATA
    //each row represents an object instance (DATA[i]),
    //each column of a row represent an object's attributes(DATA[i][j])
    //these attributes are:
    //DATA[i][0]: Long id
    //DATA[i][1]: String name
    //DATA[i][2]: String surname
    //DATA[i][3]: String telephoneNumber
    //DATA[i][3]: String subscriptionType
    //DATA[i][4]: Double balance
    //DATA[i][5]: Integer numberOfFollowers
    
    public static final Object[][] DATA = {
			{ 1L, "Ahmet", "Songül", "0(455) 234 99 54", "None", 500.0D, 84},
			{ 2L, "Kazım", "Çelik", "0(454) 642 66 88", "None", -500.0D, 0},
			{ 3L, "Sinem", "Kılışarslan", "0(425) 792 96 41", "Premium", 250.0D, 120},
			{ 4L, "Salih", "Çobanoğlu", "0(455) 578 12 12", "Gold Premium", 150.0D, 354},
			{ 5L, "Ceren", "Beyaz", "0(358) 572 40 20", "Premium", 350.0D, 386},
			{ 6L, "Zelda", "Sırma", "0(149) 782 37 13", "None", 10.0D, 53},
			{ 7L, "Ali", "Divanlı", "0(943) 771 21 64", "VIP", 0.0D, 120527},
			{ 8L, "Mehmet", "Çelik", "0(863) 893 54 81", "Gold Premium", 0.0D, 65398},
			{ 9L, "Kibariye", "Kılıç", "0(953) 123 00 32", "VIP", 1000000.0D, 1685942},
			{ 10L, "İbrahim", "Yıldız", "0(248) 836 29 85", "None", -7000.0D, 5698},
			{ 11L, "Songül", "Çelik Dikenoğlu", "0(643) 456 99 54", "Premium", 480.0D, 230056},
			{ 12L, "Ahmet", "Kara", "0(054) 234 56 54", "None", -25.0D, 205}
    };
	
}

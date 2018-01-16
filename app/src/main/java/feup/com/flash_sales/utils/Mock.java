package feup.com.flash_sales.utils;

import java.util.Arrays;
import java.util.List;

import feup.com.flash_sales.R;
import feup.com.flash_sales.model.Address;
import feup.com.flash_sales.model.Preferences;
import feup.com.flash_sales.model.Promotion;
import feup.com.flash_sales.model.Store;

/**
 * Created by jhonny on 05-01-2018.
 */

public class Mock {
    public static List<Promotion> getPromotions() {
        return Arrays.asList(new Promotion("NewYorker","Cachecol Xedrez Vermelho", R.drawable.ny, "","1"),
                new Promotion("Levi's","Calças Jeans Casual",R.drawable.levi, "","2"),
                new Promotion("H&M","Casaco Inverno Xedrez",R.drawable.hem, "","3"),
                new Promotion("PANDORA","Pulseira Prata e Rosa",R.drawable.pandora, "","4"),
                new Promotion("SPRINGFIELD","Camisola de lã Beige",R.drawable.springfield, "","5"),
                new Promotion("KIKO Milano", "Lipstick Rosa",R.drawable.kiko,"","6"));
    }

    public static List<Preferences> getPreferences() {
        return Arrays.asList(
                new Preferences("tech"), new Preferences("moda femininas"),
                new Preferences("moda masculina"), new Preferences("moda infantil"),
                new Preferences("toys"), new Preferences("restauraçao"), new Preferences("cinema"),
                new Preferences("carros"),new Preferences("sports"));
    }


    public static Address getAddress(int id){
        Address address;
        if(id% 2 == 0){
             address = new Address("1","Alameda Shop","Rua dos Campeões Europeus","29-198",
                     "","Bela Vista", "Porto", "Porto");
             address.setZipcode("4350-414");

             address.setLatitude(41.163501);
             address.setLongitude(-8.583346);
        }else {
            address = new Address("2", "ViaCatarina Shopping", "Rua de Santa Catarina", "312",
                    "", "Aliados", "Porto", "Porto");
            address.setZipcode("4000-008");
            address.setLatitude(41.148971);
            address.setLongitude(-8.606059);
        }
        return address;
    }

    public static Store getStore(String id){
        return new Store(getAddress(2),"Nome da loja", "Breve Descriçao da loja","https://www.logogarden.com/wp-content/uploads/lg-logo-samples/Education-Counseling-Logo-5.png");
        /*switch (Integer.parseInt(id)){
            case 1:
            case 2:
                return new Store(getAddress(98),"Loja", "Descricao");
            case 3:
                return new Store(getAddress(56),"Loja", "Descricao");
            case 4:
                return new Store(getAddress(257),"Loja", "Descricao");
            case 5:
                return new Store(getAddress(237),"Loja", "Descricao");
           default:
               return new Store(getAddress(213),"Loja", "Descricao");
        }*/
    }
}

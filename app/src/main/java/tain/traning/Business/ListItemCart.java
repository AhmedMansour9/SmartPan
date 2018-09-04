package tain.traning.Business;

import java.util.ArrayList;
import java.util.List;

import tain.traning.Model.Categoryitem;
import tain.traning.Model.ItemCart;

/**
 * Created by HP on 10/08/2018.
 */

public class ListItemCart {

   static List<ItemCart> item=new ArrayList<>();

    public void Listitem(ItemCart list){

        item.add(list);
    }
    public List<ItemCart> getlist(){

        return item;
    }
}

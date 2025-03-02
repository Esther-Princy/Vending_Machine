package inventory;
import item.ItemShelf;
import item.Item;
public class Inventory {
    private ItemShelf[] inventory;
    public Inventory(int n){
        inventory=new ItemShelf[n];
        initialEmptyInventory();
    }
    public ItemShelf[] getInventory(){
        return this.inventory;
    }
    public void setInventory(ItemShelf[] inventory){
        this.inventory=inventory;
    }
    public void initialEmptyInventory(){
       int startCode=101;
       for(int i=0;i<inventory.length;i++){
           ItemShelf itemShelf=new ItemShelf();
           itemShelf.setItemCode(startCode);
           itemShelf.setSoldOut(true);
           inventory[i]=itemShelf;
           startCode++;
       }
    }
    public void addItem(Item item,int itemCode){
        for(ItemShelf shelf:inventory){
            if(shelf.getItemCode()==itemCode){
                if(shelf.isSoldOut()==true){
                    shelf.setItem(item);
                    shelf.setSoldOut(false);
                }
            }
        }
    }
    public Item getItem(int itemCode){
        for(ItemShelf shelf:inventory){
            if(shelf.getItemCode()==itemCode){
                if(shelf.isSoldOut()){
                    System.out.println("item is already soldout");
                    return new Item();
                }else{
                    return shelf.getItem();
                }
            }
        }
    
    System.out.println("invalid itemcode");
    return new Item();
    }
    public void updateSoldOutitem(int itemCodeNumber){
        for(ItemShelf shelf:inventory){
            if(shelf.getItemCode()==itemCodeNumber){
                shelf.setSoldOut(true);
            }
        }
    }
    
}

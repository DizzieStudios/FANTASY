
public class Shop
{
    private Items[] storage;
    private Hero hero;
    public Shop(Hero hero){
        this.hero = hero;
    }

    public void open(){
        generateOffers();
    }
    
    public Items[] getStock(){
        return storage;
    }
    
    public void listStock(){
        System.out.println("Stock:");
        for ( int i = 0 ; i < 10 ; i++ ){
            System.out.println(i+": "+storage[i].getName());
        }
    }

    public void generateOffers(){
        storage = new Items[10];
        for ( int i = 0 ; i < 10 ; i++ ){
            storage[i] = Random_Item.randomItem(hero);
        }
    }

    public void buy(int index) throws InsufficientCurrencyException {
        if ( hero.getCurrency() >= storage[index].getWorth() ){
            hero.addToInventory(storage[index]);
            hero.setCurrency(hero.getCurrency()-storage[index].getWorth());
            generateOffers();
        }else{
            throw new InsufficientCurrencyException( (storage[index].getWorth()-hero.getCurrency())+" short" );
        }
    }
}

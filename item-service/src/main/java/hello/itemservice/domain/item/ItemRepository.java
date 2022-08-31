package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    /*실무에서의 꿀팁!!!
     * 실무에서는 HashMap을 쓰면 안된다
     * 해당 객체는 싱글톤이기 때문에 멀티쓰레드 환경에서 동시에 접근해버리면
     * 동시성문제가 생길 수 있다. concurrentHashMap 을 사용해야함
     * */
    private static final Map<Long, Item> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);

        /*정석
        * update에서는 지금 id가 사용되지 않기에
        * 따로 DTO를 만드는 것이 옳다
        * */
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
        findItem.setOpen(updateParam.getOpen());
        findItem.setRegions(updateParam.getRegions());
        findItem.setItemType(updateParam.getItemType());
        findItem.setDeliveryCode(updateParam.getDeliveryCode());
    }

    public void clearStore(){
        store.clear();
    }
}

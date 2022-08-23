package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    /*의존자동주입
     * 1. 생성자 주입이 좋다. setter 함수가 없어 객체가 생성될 때 싱글톤으로 하나만 생성할 수 있기 때문
     * 2. 생성자가 하나일 경우 @Autowired 를 붙이지 않아도 자동주입이 된다.
     * 3. Lombok에 RequiredArgsConstructor를 쓰면 final이 붙은 필드 프로퍼티에 생성자를 만들어주고 의존주입을 해준다.
     * */

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String save(/*@ModelAttribute("item")*/ Item item, RedirectAttributes redirectAttributes) {
        /*@ModelAttribute의 역할 --> 자동추가
        1.
        * ModelAttribute에 괄호를 치고 View로 넘겨주고자 하는 객체의 이름을 적으면
        * Model 객체에 따로 넘겨줄 필요없이 자신이 바로 넘겨준다.
        2.
        * 이름을 생략하더라도 Model 객체에 자동으로 추가해준다.
        * 규칙 : 객체 클래스의 이름에서 첫글자를 소문자로 바꾼다. Item --> item
        3. 
        * 아예 생략해도 상관이 없다. 위의 이름규칙으로 자동으로 모델 객체에 추가시켜줌
        * */

        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        //model.addAttribute("item", item);

        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);

        /* redirect는 해당 URL로 새로 요청하는 것 */
        return "redirect:/basic/items/{itemId}";
    }


    /*테스트용 데이터 추가*/
    @PostConstruct
    public void init() {

        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }
}

package jpabook.shop.service;

import jpabook.shop.domain.item.Book;
import jpabook.shop.domain.item.Item;
import jpabook.shop.dto.BookUpdateDto;
import jpabook.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void update(BookUpdateDto bookUpdateDto){
        Book item = (Book)findOne(bookUpdateDto.getId());
        item.updateBook(bookUpdateDto);
    }


    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

}

package jpabook.shop.domain.item;

import jpabook.shop.dto.BookUpdateDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item{

    private String author;
    private String isbn;

    public void updateBook(BookUpdateDto bookUpdateDto){
        super.setName(bookUpdateDto.getName());
        super.setStockQuantity(bookUpdateDto.getStockQuantity());
        super.setPrice(bookUpdateDto.getPrice());
        this.author = bookUpdateDto.getAuthor();
        this.isbn = bookUpdateDto.getIsbn();
    }
}

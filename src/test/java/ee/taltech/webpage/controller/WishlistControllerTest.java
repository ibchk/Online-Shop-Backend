package ee.taltech.webpage.controller;

import ee.taltech.webpage.common.RestTemplateTests;
import ee.taltech.webpage.model.Comment;
import ee.taltech.webpage.model.Item;
import ee.taltech.webpage.model.ItemCount;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WishlistControllerTest extends RestTemplateTests {

    @Test
    void wishlist() {
//        ResponseEntity<List<Item>> exchangeWishlist = templateWithUser().exchange("/wishlist", HttpMethod.GET, null, LIST_OF_ITEMS);
//        List<Item> items = exchangeWishlist.getBody();
//        assertNotNull(items);
//        assertEquals(HttpStatus.OK, exchangeWishlist.getStatusCode());
//        assertTrue(items.isEmpty());
//        ResponseEntity<Item> addItem = templateWithUser().exchange("/user/wishList", HttpMethod.POST, null, ITEM);

    }
}

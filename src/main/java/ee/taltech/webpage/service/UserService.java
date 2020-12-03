package ee.taltech.webpage.service;

import ee.taltech.webpage.model.Item;
import ee.taltech.webpage.model.ItemCount;
import ee.taltech.webpage.model.User;
import ee.taltech.webpage.repository.ItemCountRepository;
import ee.taltech.webpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private ItemCountRepository itemCountRepository;

    public List<Item> getWishlist() {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        return user.map(User::getWishlist).orElse(null);
    }

    public Item addToWishlist(Long id) {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        Item item = null;
        if (user.isPresent()) {
            item = itemsService.getItemById(id);
            user.get().addToWishlist(item);
            userRepository.save(user.get());
        }
        return item;
    }

    public void clearWishlist() {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        if (user.isPresent()) {
            user.get().clearWishlist();
            userRepository.save(user.get());
        }
    }

    public List<ItemCount> getShoppingCart() {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        if (user.isPresent()) {
            return user.get().getShoppingCart();
        }
        return new LinkedList<>();
    }

    public Item addItemToShoppingCart(Long id) {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        Item item = null;
        if (user.isPresent()) {
            item = itemsService.getItemById(id);
            user.get().addItemToShoppingCart(item, itemCountRepository);
            userRepository.save(user.get());
        }
        return item;
    }

    public void removeItemFromShoppingCart(Long id) {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        user.ifPresent(value -> value.removeItemFromShoppingCart(itemsService.getItemById(id), itemCountRepository));
    }

    public Item removeFromWishlist(Long id) {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        Item item = null;
        if (user.isPresent()) {
            item = itemsService.getItemById(id);
            user.get().removeFromWishlist(item);
            userRepository.save(user.get());
        }
        return item;
    }

    public void clearShoppingCart() {
        Optional<User> user = userRepository.findAll().stream().findFirst();
        if (user.isPresent()) {
            user.get().clearShoppingCart();
            userRepository.save(user.get());
        }
    }

}

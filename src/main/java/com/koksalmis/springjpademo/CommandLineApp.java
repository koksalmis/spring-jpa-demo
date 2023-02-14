package com.koksalmis.springjpademo;

import com.koksalmis.springjpademo.models.Cart;
import com.koksalmis.springjpademo.models.CartItem;
import com.koksalmis.springjpademo.models.Channel;
import com.koksalmis.springjpademo.models.Passport;
import com.koksalmis.springjpademo.models.Person;
import com.koksalmis.springjpademo.models.Subscriber;
import com.koksalmis.springjpademo.repository.CartItemRepository;
import com.koksalmis.springjpademo.repository.CartRepository;
import com.koksalmis.springjpademo.repository.ChannelRepository;
import com.koksalmis.springjpademo.repository.PassportRepository;
import com.koksalmis.springjpademo.repository.PersonRepository;
import com.koksalmis.springjpademo.repository.SubscriberRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineApp implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public void run(String... args) throws Exception {
//        oneToOneExample();
//        oneToManyExample();
        manyToManyExample();
    }

    private void manyToManyExample() {
        Channel channel = new Channel();
        channel.setName("kanal d");
        channel.setUrl("url1");

        Channel channel2 = new Channel();
        channel2.setName("kanal c");
        channel2.setUrl("url2");

        Subscriber subscriber = new Subscriber();
        subscriber.setUserName("subscriber1");

        Subscriber subscriber2 = new Subscriber();
        subscriber2.setUserName("subscriber2");

        channel.setSubscribers(List.of(subscriber, subscriber2));
        this.subscriberRepository.saveAll(List.of(subscriber, subscriber2));
        this.channelRepository.saveAll(List.of(channel, channel2));

        List<Channel> channels = this.channelRepository.findAll();
        List<Subscriber> subscribers = this.subscriberRepository.findAll();

        System.out.println(subscribers);
        System.out.println(channels);

    }

    private void oneToManyExample() {
        Cart cart = new Cart();
        cart.setUserId(5);

        this.cartRepository.save(cart);

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProductCode("1");
        cartItem.setQuantity(5);
        cartItem.setUnitPrice(BigDecimal.valueOf(23.2));

        CartItem cartItem2 = new CartItem();
        cartItem2.setCart(cart);
        cartItem2.setProductCode("2");
        cartItem2.setQuantity(5);
        cartItem2.setUnitPrice(BigDecimal.valueOf(25.2));

        CartItem cartItem3 = new CartItem();
        cartItem2.setCart(cart);
        cartItem2.setProductCode("3");
        cartItem2.setQuantity(15);
        cartItem2.setUnitPrice(BigDecimal.valueOf(26.2));

        this.cartItemRepository.save(cartItem);
        this.cartItemRepository.save(cartItem2);
        this.cartItemRepository.save(cartItem3);

        List<Cart> carts = this.cartRepository.findAll();
        List<CartItem> cartItems = this.cartItemRepository.findAll();

        System.out.println(carts.get(0).getCartItems());
        System.out.println(cartItems.get(0).getCart());
    }

    private void oneToOneExample() {
        Person person = Person.builder().name("enes").surname("koksalmis").build();
        Passport passport = Passport.builder().expireDate(Instant.now().plus(365, ChronoUnit.DAYS).getEpochSecond())
                .person(person)
                .build();

        this.passportRepository.save(passport);
        System.out.println(passport);
    }
}
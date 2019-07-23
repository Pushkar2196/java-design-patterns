package com.company.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<String, Item> items = new HashMap<String, Item>();
    public Registry() {
        loadItems();
    }

    public Item createItem(String type) {
        Item item = null;

        try {
            item = (Item)(items.get(type)).clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setRuntime("2 hours");
        movie.setPrice(24.99);
        movie.setTitle("Basic Movie");
        items.put("Movie", movie);

        Book book = new Book();
        book.setNumberOfPages(5);
        book.setPrice(1.99);
        book.setTitle("cat in hat");
        items.put("Book", book);
    }
}

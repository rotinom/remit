package com.rotinom.remit.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rotinom.remit.ChargeNumberItem;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<ChargeNumberItem> ITEMS = new ArrayList<ChargeNumberItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, ChargeNumberItem> ITEM_MAP = new HashMap<String, ChargeNumberItem>();

    static {
        // Add 3 sample items.
        addItem(new ChargeNumberItem("1", "one"));
        addItem(new ChargeNumberItem("3", "two"));
        addItem(new ChargeNumberItem("2", "three"));
    }

    private static void addItem(ChargeNumberItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getNumber(), item);
    }

//    /**
//     * A dummy item representing a piece of content.
//     */
//    public static class DummyItem {
//        public String id;
//        public String content;
//
//        public DummyItem(String id, String content) {
//            this.id = id;
//            this.content = content;
//        }
//
//        @Override
//        public String toString() {
//            return content;
//        }
//    }
}

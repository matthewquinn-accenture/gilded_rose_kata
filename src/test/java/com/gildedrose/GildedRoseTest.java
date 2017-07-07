package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void shouldDenoteNameOfItem() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldDenoteNumberOfDaysToSellItem(){
        Item[] items = new Item[] {new Item("Apples", 2,0)};
        GildedRose app = new GildedRose(items);
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void shouldDenoteQualityOfItem(){
        Item[] items = new Item[] {new Item("Apples",2,0)};
        GildedRose app = new GildedRose(items);
        assertEquals(0,app.items[0].quality);
    }

    @Test
    public void shouldDenoteNameOfSecondItemInList(){
        Item[] items = new Item[] {new Item("Apples",0,0), new Item("foo",0,0)};
        GildedRose app = new GildedRose(items);
        assertEquals("foo", app.items[1].name);
    }

    @Test
    public void shouldDecreaseQualityTwiceAsFastWhenSellnIsNegative(){
        Item[] items = new Item[]{new Item("Apple",0,2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    @Test
    public void shouldNotHaveNegativeQualityWhenQualityReachesItsLimit(){
        Item[] items = new Item[] {new Item("Apples",4,0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }
}

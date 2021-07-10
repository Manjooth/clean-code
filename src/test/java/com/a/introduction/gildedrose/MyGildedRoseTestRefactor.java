package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyGildedRoseTestRefactor {

	public static final int NOT_EXPIRED_SELL_IN = 15;
	public static final int DEFAULT_QUALITY = 3;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int EXPIRED_SELL_IN = -1;
	public static final String AGED_BRIE = "Aged Brie";
	public static final int SELL_IN = 4;
	public static final int HIGH_QUALITY = 50;
	public static final String TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

	private GildedRose createGildedRoseWithItem(String itemType, int sellin, int quality) {
		Item item = new Item(itemType, sellin, quality);
		Item[] items = new Item[] { item };
		return new GildedRose(items);
	}

	private void assertItem(Item actual, Item expected) {
		assertEquals(expected.name, actual.name);
		assertEquals(expected.sellIn, actual.sellIn);
		assertEquals(expected.quality, actual.quality);
	}

	@Test
	public void unexpiredItem_qualityDecreasesBy1() {
		// setup
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);
		//verify
		app.updateQuality();
		// verify
		Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 1);
		// expected, actual
		assertItem(app.items[0], expected);
	}

	@Test
	public void expiredItem_qualityDecreasesBy2() {
		GildedRose app = createGildedRoseWithItem(DEFAULT_ITEM, EXPIRED_SELL_IN, DEFAULT_QUALITY);
		app.updateQuality();
		Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 2);
		assertItem(app.items[0], expected);
	}
	@Test
	public void unexpiredAgedBrie_qualityIncreasesBy1() {
		GildedRose app = createGildedRoseWithItem(AGED_BRIE, SELL_IN, DEFAULT_QUALITY);
		app.updateQuality();
		Item expected = new Item(AGED_BRIE, SELL_IN - 1, DEFAULT_QUALITY + 1);
		assertItem(app.items[0], expected);
	}

	@Test
	public void expiredAgedBrie_qualityIncreasesBy2() {
		GildedRose app = createGildedRoseWithItem(AGED_BRIE, EXPIRED_SELL_IN, DEFAULT_QUALITY);
		app.updateQuality();
		Item expected = new Item(AGED_BRIE, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 2);
		assertItem(app.items[0], expected);
	}

	@Test
	public void unexpiredAgedBrie_withMaxQualityIncreasesBy0() {
		GildedRose app = createGildedRoseWithItem(AGED_BRIE, SELL_IN, HIGH_QUALITY);
		app.updateQuality();
		Item expected = new Item(AGED_BRIE, SELL_IN - 1, HIGH_QUALITY);
		assertItem(app.items[0], expected);
	}

	@Test
	public void unexpiredTicketsGreaterThan10Days_withQualityIncreasesBy1() {
		GildedRose app = createGildedRoseWithItem(TAFKAL_80_ETC_CONCERT, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);
		app.updateQuality();
		Item expected = new Item(TAFKAL_80_ETC_CONCERT, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 1);
		assertItem(app.items[0], expected);
	}

	@Test
	public void unexpiredTicketsGreaterThan5Dayss_withQualityIncreasesBy2() {
		GildedRose app = createGildedRoseWithItem(TAFKAL_80_ETC_CONCERT, 7, DEFAULT_QUALITY);
		app.updateQuality();
		Item expected = new Item(TAFKAL_80_ETC_CONCERT, 6, DEFAULT_QUALITY + 2);
		assertItem(app.items[0], expected);
	}

	@Test
	public void unexpiredTicketsLessThan5Days_withQualityIncreasesBy3() {
		GildedRose app = createGildedRoseWithItem(TAFKAL_80_ETC_CONCERT, SELL_IN, DEFAULT_QUALITY);
		app.updateQuality();
		Item expected = new Item(TAFKAL_80_ETC_CONCERT, SELL_IN - 1, DEFAULT_QUALITY + 3);
		assertItem(app.items[0], expected);
	}

}
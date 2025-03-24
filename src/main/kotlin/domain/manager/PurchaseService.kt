package domain.manager

import domain.entities.LibraryItem
import domain.shops.Shop

/**
 * Менеджер по закупкам библиотечных материалов.
 * Может совершать покупки в любом магазине, реализующем интерфейс Shop.
 */
class PurchaseService {

    /**
     * Покупка товара в магазине.
     * @param shop Магазин, в котором совершается покупка
     * @return Купленный товар типа T
     */
    fun <T : LibraryItem> purchase(shop: Shop<T>): T {
        return shop.sell()
    }
}
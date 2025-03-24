package domain.shops

import domain.entities.LibraryItem

/**
 * Обобщенный интерфейс для магазинов.
 * @param T Тип товара, который продает магазин (должен быть подтипом LibraryItem)
 */
interface Shop<out T : LibraryItem> {
    /**
     * Продажа товара.
     * @return Новый экземпляр товара типа T
     */
    fun sell(): T
}
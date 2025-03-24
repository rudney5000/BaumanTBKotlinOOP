package domain.usecases

import domain.entities.LibraryItem
import domain.manager.PurchaseService
import domain.shops.Shop

/**
 * Use case для покупки нового элемента для библиотеки.
 * @property purchaseService Сервис для обработки покупок
 */
class PurchaseItemUseCase(private val purchaseService: PurchaseService) {
    /**
     * Осуществляет покупку нового элемента.
     * @param shop Магазин, через который осуществляется покупка
     * @return Купленный элемент библиотеки
     */
    operator fun <T : LibraryItem> invoke(shop: Shop<T>): T {
        return purchaseService.purchase(shop)
    }
}
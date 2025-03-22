package ui.menus

import domain.entities.*
import domain.shops.BookShop
import domain.shops.DiskShop
import domain.shops.NewspaperShop
import domain.usecases.*
import utils.extensions.readInt

/**
 * Меню действий с выбранным элементом.
 * @param purchaseItemUseCase Use case для покупки элемента
 * @param takeItemHomeUseCase Use case для взятия элемента домой
 * @param readItemInLibraryUseCase Use case для чтения элемента в библиотеке
 * @param returnItemUseCase Use case для возврата элемента
 * @param item Выбранный элемент
 */
class ItemActionsMenu(
    private val item: LibraryItem,
    private val purchaseItemUseCase: PurchaseItemUseCase,
    private val takeItemHomeUseCase: TakeItemHomeUseCase,
    private val readItemInLibraryUseCase: ReadItemInLibraryUseCase,
    private val returnItemUseCase: ReturnItemUseCase
) {

    /**
     * Отображение меню действий и обработка выбора пользователя.
     */
    fun display() {
        while (true) {
            println("\n=== ДЕЙСТВИЯ С ЭЛЕМЕНТОМ ===")
            println("Выбран элемент: ${item.getBriefInfo()}")
            println("1. Взять домой")
            println("2. Читать в читальном зале")
            println("3. Показать подробную информацию")
            println("4. Купить")
            println("5. Вернуть")
            println("0. Вернуться к списку")

            when (readInt("Выберите действие:")) {
                1 -> takeItemHome()
                2 -> readItemInLibrary()
                3 -> showDetailedInfo()
                4 -> purchaseItem()
                5 -> returnItem()
                0 -> return
                else -> println("Некорректный выбор. Попробуйте снова.")
            }
        }
    }

    /**
     * Обработка действия "Взять домой".
     */
    private fun takeItemHome() {
        if (takeItemHomeUseCase(item)) {
            val itemType = when (item) {
                is Book -> "Книга"
                is Disk -> "Диск"
                else -> "Элемент"
            }
            println("$itemType ${item.id} успешно взят домой")
        } else {
            if (!item.isAvailable) {
                println("Этот элемент уже недоступен")
            } else if (item is Newspaper) {
                println("Газеты нельзя брать домой, их можно только читать в зале")
            }
        }
    }

    /**
     * Обработка действия "Читать в читальном зале".
     */
    private fun readItemInLibrary() {
        if (readItemInLibraryUseCase(item)) {
            val itemType = when (item) {
                is Book -> "Книга"
                is Newspaper -> "Газета"
                else -> "Элемент"
            }
            println("$itemType ${item.id} взяли в читальный зал")
        } else {
            if (!item.isAvailable) {
                println("Этот элемент уже недоступен")
            } else if (item is Disk) {
                println("Диски нельзя читать в зале, их можно только брать домой")
            }
        }
    }

    /**
     * Отображение подробной информации об элементе.
     */
    private fun showDetailedInfo() {
        println(item.getDetailedInfo())
    }

    /**
     * Метод для возврата элемента в клиентском коде.
     * Использует полиморфизм для определения типа элемента.
     */
    private fun returnItem() {
        if (returnItemUseCase(item)) {
            println("${item.getDisplayTypeName()} ${item.id} успешно возвращен")
        } else {
            println("Этот элемент уже доступен и не может быть возвращен")
        }
    }

    private fun purchaseItem() {
        val shop = when (item) {
            is Book -> BookShop(item)
            is Newspaper -> NewspaperShop(item)
            is Disk -> DiskShop(item)
            is BaseLibraryItem -> throw IllegalArgumentException("Неизвестный тип элемента")
        }

        println("Успешно куплено: ${purchaseItemUseCase(shop).getDetailedInfo()}")
    }
}

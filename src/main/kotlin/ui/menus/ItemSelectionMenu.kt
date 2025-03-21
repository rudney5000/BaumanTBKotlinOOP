package ui.menus

import domain.entities.LibraryItem
import domain.usecases.*
import utils.extensions.readInt

/**
 * Меню выбора элемента из списка.
 * @param takeItemHomeUseCase Use case для взятия элемента домой
 * @param readItemInLibraryUseCase Use case для чтения элемента в библиотеке
 * @param returnItemUseCase Use case для возврата элемента
 * @param purchaseItemUseCase Use case для покупки элемента
 * @param items Список элементов для отображения
 * @param title Заголовок меню
 */
class ItemSelectionMenu(
    private val takeItemHomeUseCase: TakeItemHomeUseCase,
    private val readItemInLibraryUseCase: ReadItemInLibraryUseCase,
    private val returnItemUseCase: ReturnItemUseCase,
    private val purchaseItemUseCase: PurchaseItemUseCase,
    private val items: List<LibraryItem>,
    private val title: String
) {

    /**
     * Отображение списка элементов и обработка выбора пользователя.
     */
    fun display() {
        while (true) {
            println("\n=== $title ===")

            if (items.isEmpty()) {
                println("Нет доступных элементов.")
                println("0. Вернуться в главное меню")

                if (readInt("Выберите опцию:") == 0) {
                    return
                }
                continue
            }

            displayItems()
            println("0. Вернуться в главное меню")

            val choice = readInt("Выберите элемент (или 0 для возврата):")

            if (choice == 0) {
                return
            } else if (choice in 1..items.size) {
                val selectedItem = items[choice - 1]
                ItemActionsMenu(
                    selectedItem,
                    purchaseItemUseCase,
                    takeItemHomeUseCase,
                    readItemInLibraryUseCase,
                    returnItemUseCase
                ).display()
            } else {
                println("Некорректный выбор. Попробуйте снова.")
            }
        }
    }

    /**
     * Отображение списка элементов с порядковыми номерами.
     */
    private fun displayItems() {
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${item.getBriefInfo()}")
        }
    }
}
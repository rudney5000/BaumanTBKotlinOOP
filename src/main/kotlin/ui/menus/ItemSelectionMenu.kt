package ui.menus

import domain.entities.LibraryItem
import domain.usecases.LibraryUseCases
import utils.extensions.readInt

/**
 * Меню выбора элемента из списка.
 * @param libraryUseCases Объект с бизнес-логикой
 * @param items Список элементов для отображения
 * @param title Заголовок меню
 */
class ItemSelectionMenu(
    private val libraryUseCases: LibraryUseCases,
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
                ItemActionsMenu(libraryUseCases, selectedItem).display()
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
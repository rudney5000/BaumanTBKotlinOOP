package ui.menus

import domain.usecases.LibraryUseCases
import utils.extensions.readInt

/**
 * Класс главного меню приложения.
 * Отображает основные опции выбора категорий элементов.
 * @param libraryUseCases Объект с бизнес-логикой
 */
class MainMenu(private val libraryUseCases: LibraryUseCases) {

    /**
     * Отображение главного меню и обработка выбора пользователя.
     */
    fun display() {
        while (true) {
            println("\n=== ГЛАВНОЕ МЕНЮ ===")
            println("1. Показать книги")
            println("2. Показать газеты")
            println("3. Показать диски")
            println("0. Выход")

            when (readInt("Выберите опцию:")) {
                1 -> ItemSelectionMenu(libraryUseCases, libraryUseCases.getAllBooks(), "КНИГИ").display()
                2 -> ItemSelectionMenu(libraryUseCases, libraryUseCases.getAllNewspapers(), "ГАЗЕТЫ").display()
                3 -> ItemSelectionMenu(libraryUseCases, libraryUseCases.getAllDisks(), "ДИСКИ").display()
                0 -> return
                else -> println("Некорректный выбор. Попробуйте снова.")
            }
        }
    }
}
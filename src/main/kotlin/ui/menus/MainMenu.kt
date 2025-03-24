package ui.menus

import domain.digitization.DigitizationService
import domain.manager.PurchaseService
import domain.repositories.LibraryRepository
import domain.usecases.*
import utils.extensions.readInt

/**
 * Класс главного меню приложения.
 * Отображает основные опции выбора категорий элементов.
 */
class MainMenu(repository: LibraryRepository) {

    private val getBooksUseCase = GetBooksUseCase(repository)
    private val getNewspapersUseCase = GetNewspapersUseCase(repository)
    private val getDisksUseCase = GetDisksUseCase(repository)
    private val takeItemHomeUseCase = TakeItemHomeUseCase(repository)
    private val readItemInLibraryUseCase = ReadItemInLibraryUseCase(repository)
    private val returnItemUseCase = ReturnItemUseCase(repository)
    private val purchaseItemUseCase = PurchaseItemUseCase(PurchaseService())
    private val digitizeItemUseCase = DigitizeItemUseCase(DigitizationService())

    /**
     * Отображение главного меню и обработка выбора пользователя.
     */
    fun display() {
        while (true) {
            println("\n=== ГЛАВНОЕ МЕНЮ ===")
            println("1. Показать книги")
            println("2. Показать газеты")
            println("3. Показать диски")
            println("4. Управление закупками")
            println("5. Оцифровка материалов")
            println("0. Выход")

            when (readInt("Выберите опцию:")) {
                1 -> ItemSelectionMenu(
                    title = "КНИГИ",
                    items = getBooksUseCase(),
                    takeItemHomeUseCase = takeItemHomeUseCase,
                    readItemInLibraryUseCase = readItemInLibraryUseCase,
                    returnItemUseCase = returnItemUseCase,
                    purchaseItemUseCase = purchaseItemUseCase
                ).display()

                2 -> ItemSelectionMenu(
                    title = "ГАЗЕТЫ",
                    items = getNewspapersUseCase(),
                    takeItemHomeUseCase = takeItemHomeUseCase,
                    readItemInLibraryUseCase = readItemInLibraryUseCase,
                    returnItemUseCase = returnItemUseCase,
                    purchaseItemUseCase = purchaseItemUseCase
                ).display()

                3 -> ItemSelectionMenu(
                    title = "ДИСКИ",
                    items = getDisksUseCase(),
                    takeItemHomeUseCase = takeItemHomeUseCase,
                    readItemInLibraryUseCase = readItemInLibraryUseCase,
                    returnItemUseCase = returnItemUseCase,
                    purchaseItemUseCase = purchaseItemUseCase
                ).display()

                4 -> PurchaseMenu(
                    purchaseItemUseCase = purchaseItemUseCase,
                    getBooksUseCase = getBooksUseCase,
                    getNewspapersUseCase = getNewspapersUseCase,
                    getDisksUseCase = getDisksUseCase
                ).display()

                5 -> DigitizationMenu(
                    getBooksUseCase = getBooksUseCase,
                    getNewspapersUseCase = getNewspapersUseCase,
                    digitizeItemUseCase = digitizeItemUseCase
                ).display()

                0 -> return
                else -> println("Некорректный выбор. Попробуйте снова.")
            }
        }
    }
}
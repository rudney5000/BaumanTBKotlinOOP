package ui.menus

import domain.shops.BookShop
import domain.shops.DiskShop
import domain.shops.NewspaperShop
import domain.usecases.GetBooksUseCase
import domain.usecases.GetDisksUseCase
import domain.usecases.GetNewspapersUseCase
import domain.usecases.PurchaseItemUseCase
import utils.extensions.readInt

/**
 * Меню для покупки новых элементов библиотеки.
 * @property purchaseItemUseCase Use case для покупки элементов
 * @property getBooksUseCase Use case для получения списка книг
 * @property getNewspapersUseCase Use case для получения списка газет
 * @property getDisksUseCase Use case для получения списка дисков
 */
class PurchaseMenu(
    private val purchaseItemUseCase: PurchaseItemUseCase,
    private val getBooksUseCase: GetBooksUseCase,
    private val getNewspapersUseCase: GetNewspapersUseCase,
    private val getDisksUseCase: GetDisksUseCase
) {
    /**
     * Отображает меню покупок и обрабатывает выбор пользователя.
     */
    fun display() {
        while (true) {
            println("\n=== МЕНЮ ПОКУПОК ===")
            println("1. Купить книгу")
            println("2. Купить газету")
            println("3. Купить диск")
            println("0. Вернуться в главное меню")

            when (readInt("Выберите действие: ")) {
                1 -> purchaseBook()
                2 -> purchaseNewspaper()
                3 -> purchaseDisk()
                0 -> return
                else -> println("Некорректный выбор. Попробуйте снова.")
            }
        }
    }

    /**
     * Обрабатывает покупку книги.
     */
    private fun purchaseBook() {
        println("\n=== ВЫБОР КНИГИ ДЛЯ ПОКУПКИ ===")
        val books = getBooksUseCase()
        println("Список существующих книг:")
        books.forEachIndexed { index, book ->
            println("${index + 1}. ${book.getDetailedInfo()}")
        }
        println("${books.size + 1}. Добавить новую книгу")

        val choice = readInt("Выберите номер: ")
        if (choice <= books.size) {
            val selectedBook = books[choice - 1]
            val bookShop = BookShop(selectedBook.title, selectedBook.author, selectedBook.pages)
            val purchasedBook = purchaseItemUseCase(bookShop)
            println("Куплена книга: ${purchasedBook.getDetailedInfo()}")
        }
    }

    /**
     * Обрабатывает покупку газеты.
     */
    private fun purchaseNewspaper() {
        println("\n=== ВЫБОР ГАЗЕТЫ ДЛЯ ПОКУПКИ ===")
        val newspapers = getNewspapersUseCase()

        println("Список существующих газет:")
        newspapers.forEachIndexed { index, newspaper ->
            println("${index + 1}. ${newspaper.getDetailedInfo()}")
        }
        println("${newspapers.size + 1}. Добавить новую газету")

        val choice = readInt("Выберите номер: ")

        if (choice <= newspapers.size) {
            val selectedNewspaper = newspapers[choice - 1]
            val newspaperShop = NewspaperShop(
                selectedNewspaper.title,
                selectedNewspaper.issueNumber,
                selectedNewspaper.month
            )
            val purchasedNewspaper = purchaseItemUseCase(newspaperShop)
            println("Куплена газета: ${purchasedNewspaper.getDetailedInfo()}")
        }
    }

    /**
     * Обрабатывает покупку диска.
     */
    private fun purchaseDisk() {
        println("\n=== ВЫБОР ДИСКА ДЛЯ ПОКУПКИ ===")
        val disks = getDisksUseCase()

        println("Список существующих дисков:")
        disks.forEachIndexed { index, disk ->
            println("${index + 1}. ${disk.getDetailedInfo()}")
        }
        println("${disks.size + 1}. Добавить новый диск")

        val choice = readInt("Выберите номер: ")

        if (choice <= disks.size) {
            val selectedDisk = disks[choice - 1]
            val diskShop = DiskShop(selectedDisk.title, selectedDisk.type)
            val purchasedDisk = purchaseItemUseCase(diskShop)
            println("Куплен диск: ${purchasedDisk.getDetailedInfo()}")
        }
    }
}
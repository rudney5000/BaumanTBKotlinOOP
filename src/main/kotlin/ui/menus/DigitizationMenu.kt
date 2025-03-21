package ui.menus

import domain.usecases.LibraryUseCases
import utils.extensions.readInt

class DigitizationMenu(private val libraryUseCases: LibraryUseCases) {
    fun display() {
        while (true) {
            println("\n=== МЕНЮ ОЦИФРОВКИ ===")
            println("1. Оцифровать книгу")
            println("2. Оцифровать газету")
            println("0. Вернуться в главное меню")

            when (readInt("Выберите опцию:")) {
                1 -> digitizeBook()
                2 -> digitizeNewspaper()
                0 -> return
                else -> println("Некорректный выбор. Попробуйте снова.")
            }
        }
    }

    private fun digitizeBook() {
        val books = libraryUseCases.getAllBooks()
        if (books.isEmpty()) {
            println("Нет доступных книг для оцифровки.")
            return
        }

        println("\n=== ВЫБЕРИТЕ КНИГУ ДЛЯ ОЦИФРОВКИ ===")
        books.forEachIndexed { index, book ->
            println("${index + 1}. ${book.title} (${book.author})")
        }
        println("0. Отмена")

        val choice = readInt("Выберите книгу:")
        if (choice == 0) return
        if (choice in 1..books.size) {
            val selectedBook = books[choice - 1]
            val disk = libraryUseCases.digitizeItem(selectedBook)
            println("Книга успешно оцифрована. Создан диск: ${disk.getDetailedInfo()}")
        } else {
            println("Некорректный выбор.")
        }
    }

    private fun digitizeNewspaper() {
        val newspapers = libraryUseCases.getAllNewspapers()
        if (newspapers.isEmpty()) {
            println("Нет доступных газет для оцифровки.")
            return
        }

        println("\n=== ВЫБЕРИТЕ ГАЗЕТУ ДЛЯ ОЦИФРОВКИ ===")
        newspapers.forEachIndexed { index, newspaper ->
            println("${index + 1}. ${newspaper.title} (Выпуск ${newspaper.issueNumber} за ${newspaper.month})")
        }
        println("0. Отмена")

        val choice = readInt("Выберите газету:")
        if (choice == 0) return
        if (choice in 1..newspapers.size) {
            val selectedNewspaper = newspapers[choice - 1]
            val disk = libraryUseCases.digitizeItem(selectedNewspaper)
            println("Газета успешно оцифрована. Создан диск: ${disk.getDetailedInfo()}")
        } else {
            println("Некорректный выбор.")
        }
    }
}
package domain.digitization

import domain.entities.*

/**
 * Класс для оцифровки печатных материалов библиотеки.
 */
class DigitizationService<T : LibraryItem>(private val diskType: DiskType = DiskType.CD) {

    /**
     * Оцифровка материала библиотеки.
     * @param item Материал для оцифровки (книга или газета)
     * @return Диск с цифровой версией материала
     * @throws IllegalArgumentException если передан неподдерживаемый тип материала
     */
    fun digitize(item: T): Disk {
        return when (item) {
            is Book -> createDiskFromBook(item)
            is Newspaper -> createDiskFromNewspaper(item)
            else -> throw IllegalArgumentException("Можно оцифровать только книги и газеты")
        }
    }

    private fun createDiskFromBook(book: Book): Disk {
        val diskTitle = "Цифровая версия книги: ${book.title} (${book.author})"
        return Disk(
            id = generateDiskId(),
            title = diskTitle,
            isAvailable = true,
            type = diskType
        )
    }

    private fun createDiskFromNewspaper(newspaper: Newspaper): Disk {
        val diskTitle = "Цифровая версия газеты: ${newspaper.title} №${newspaper.issueNumber}"
        return Disk(
            id = generateDiskId(),
            title = diskTitle,
            isAvailable = true,
            type = diskType
        )
    }

    /**
     * Генерация ID для цифровой версии.
     * @return Новый ID для цифровой версии
     */
    private fun generateDiskId(): Int {
        return 3000 + (Math.random() * 1000).toInt()
    }
}
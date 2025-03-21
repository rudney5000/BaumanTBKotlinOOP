package domain.digitization

import domain.entities.*

/**
 * Класс для оцифровки печатных материалов библиотеки.
 */
class DigitizationService {

    /**
     * Оцифровка.
     * @param item для оцифровки
     * @return Диск с цифровой версией газеты
     */
    fun <T> digitize(item: T): Disk where T : LibraryItem, T : BaseLibraryItem {
        val diskTitle = when (item) {
            is Book -> "Цифровая версия книги: ${item.title}"
            is Newspaper -> "Цифровая версия газеты: ${item.title} №${item.issueNumber}"
            else -> "Цифровая версия: ${item.title}"
        }

        return Disk(
            id = generateDiskId(),
            title = diskTitle,
            isAvailable = true,
            type = DiskType.CD
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
package domain.digitization

import domain.entities.*

/**
 * Класс для оцифровки печатных материалов библиотеки.
 */
class DigitizationService<T : LibraryItem> {

    /**
     * Оцифровка.
     * @param item для оцифровки
     * @return Диск с цифровой версией газеты
     */
    fun digitize(item: T): String {
        return item.digitize()
    }

    /**
     * Генерация ID для цифровой версии.
     * @return Новый ID для цифровой версии
     */
    private fun generateDiskId(): Int {
        return 3000 + (Math.random() * 1000).toInt()
    }
}
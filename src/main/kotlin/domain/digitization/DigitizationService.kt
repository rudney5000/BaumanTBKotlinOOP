package domain.digitization

import domain.entities.*

/**
 * Класс для оцифровки печатных материалов библиотеки.
 */
class DigitizationService<T : LibraryItem>(private val diskType: DiskType = DiskType.CD) {

    /**
     * Оцифровка.
     * @param item для оцифровки
     * @return Диск с цифровой версией газеты
     */
    fun digitize(item: T): String {
        return when (diskType) {
            DiskType.CD -> "Оцифровано на CD: ${item.digitize()}"
            DiskType.DVD -> "Оцифровано на DVD: ${item.digitize()}"
        }
    }

}
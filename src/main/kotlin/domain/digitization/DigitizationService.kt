package domain.digitization

import domain.entities.*

/**
 * Класс для оцифровки печатных материалов библиотеки.
 */
class DigitizationService<T : Digitizable>(private val diskType: DiskType = DiskType.CD) {

    /**
     * Оцифровка материала библиотеки.
     * @param item Материал для оцифровки
     * @return Диск с цифровой версией материала
     */
    fun digitize(item: T): Disk = item.toDigitalFormat()
}
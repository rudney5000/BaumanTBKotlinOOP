package domain.usecases

import domain.digitization.DigitizationService
import domain.entities.BaseLibraryItem
import domain.entities.Disk
import domain.entities.LibraryItem

/**
 * Use case для оцифровки элементов библиотеки.
 * @property digitizationService Сервис для оцифровки элементов
 */
class DigitizeItemUseCase(private val digitizationService: DigitizationService) {
    /**
     * Выполняет оцифровку элемента библиотеки.
     * @param item Элемент для оцифровки
     * @return Созданный диск с оцифрованным содержимым
     */
    operator fun <T> invoke(item: T): Disk where T : LibraryItem, T : BaseLibraryItem {
        return digitizationService.digitize(item)
    }
}
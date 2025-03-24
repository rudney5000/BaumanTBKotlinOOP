package domain.usecases

import domain.digitization.Digitizable
import domain.digitization.DigitizationService
import domain.entities.Disk
import domain.entities.LibraryItem

/**
 * Use case для оцифровки элементов библиотеки.
 * @property digitizationService Сервис для оцифровки элементов
 */
class DigitizeItemUseCase(private val digitizationService: DigitizationService<Digitizable>) {
    /**
     * Выполняет оцифровку элемента библиотеки.
     * @param item Элемент для оцифровки
     * @return Строка с результатом оцифровки
     */
    operator fun invoke(item: LibraryItem): Disk {
        if (item !is Digitizable) {
            throw UnsupportedOperationException("Этот тип элемента нельзя оцифровать")
        }
        return digitizationService.digitize(item)
    }
}
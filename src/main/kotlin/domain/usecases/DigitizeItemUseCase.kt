package domain.usecases

import domain.digitization.DigitizationService
import domain.entities.LibraryItem

/**
 * Use case для оцифровки элементов библиотеки.
 * @property digitizationService Сервис для оцифровки элементов
 */
class DigitizeItemUseCase(private val digitizationService: DigitizationService<LibraryItem>) {
    /**
     * Выполняет оцифровку элемента библиотеки.
     * @param item Элемент для оцифровки
     * @return Строка с результатом оцифровки
     */
    operator fun invoke(item: LibraryItem): String {
        return digitizationService.digitize(item)
    }
}
package domain.usecases

import domain.entities.LibraryItem
import domain.repositories.LibraryRepository

/**
 * Use case для возврата элемента в библиотеку.
 * @property repository Репозиторий для доступа к данным библиотеки
 */
class ReturnItemUseCase(private val repository: LibraryRepository) {
    /**
     * Обрабатывает возврат элемента в библиотеку.
     * @param item Элемент библиотеки, который нужно вернуть
     * @return true если операция успешна, false если элемент уже доступен
     */
    operator fun invoke(item: LibraryItem): Boolean {
        return if (item.isAvailable) {
            false
        } else {
            repository.updateItemAvailability(item, true)
            true
        }
    }
}
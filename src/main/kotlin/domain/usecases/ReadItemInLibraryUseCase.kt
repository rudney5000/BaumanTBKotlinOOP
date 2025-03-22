package domain.usecases

import domain.entities.LibraryItem
import domain.repositories.LibraryRepository

/**
 * Use case для чтения элемента в библиотеке.
 * @property repository Репозиторий для доступа к данным библиотеки
 */
class ReadItemInLibraryUseCase(private val repository: LibraryRepository) {
    /**
     * Обрабатывает чтение элемента в библиотеке.
     * @param item Элемент библиотеки, который нужно прочитать
     * @return true если операция успешна, false если элемент недоступен или его нельзя читать в библиотеке
     */
    operator fun invoke(item: LibraryItem): Boolean {
        return when {
            !item.isAvailable -> false
            !item.canBeReadInLibrary() -> false
            else -> {
                repository.updateItemAvailability(item, false)
                true
            }
        }
    }
}
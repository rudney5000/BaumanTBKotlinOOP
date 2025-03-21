package domain.usecases

import domain.entities.LibraryItem
import domain.repositories.LibraryRepository

/**
 * Use case для взятия элемента библиотеки домой.
 * @property repository Репозиторий для доступа к данным библиотеки
 */
class TakeItemHomeUseCase(private val repository: LibraryRepository) {
    /**
     * Обрабатывает взятие элемента домой.
     * @param item Элемент библиотеки, который нужно взять домой
     * @return true если операция успешна, false если элемент недоступен или его нельзя брать домой
     */
    operator fun invoke(item: LibraryItem): Boolean {
        return when {
            !item.isAvailable -> false
            !item.canBeTakenHome() -> false
            else -> {
                repository.updateItemAvailability(item, false)
                true
            }
        }
    }
}
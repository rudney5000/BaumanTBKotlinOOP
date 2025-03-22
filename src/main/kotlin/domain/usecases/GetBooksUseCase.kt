package domain.usecases

import domain.repositories.LibraryRepository

/**
 * Use case для получения списка всех книг.
 * @property repository Репозиторий для доступа к данным библиотеки
 */
class GetBooksUseCase(private val repository: LibraryRepository) {
    /**
     * Получает список всех книг из репозитория.
     * @return Список всех доступных книг
     */
    operator fun invoke() = repository.getAllBooks()
}
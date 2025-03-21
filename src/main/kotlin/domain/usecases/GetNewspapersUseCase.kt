package domain.usecases

import domain.repositories.LibraryRepository

/**
 * Use case для получения списка всех газет.
 * @property repository Репозиторий для доступа к данным библиотеки
 */
class GetNewspapersUseCase(private val repository: LibraryRepository) {
    /**
     * Получает список всех газет из репозитория.
     * @return Список всех доступных газет
     */
    operator fun invoke() = repository.getAllNewspapers()
}
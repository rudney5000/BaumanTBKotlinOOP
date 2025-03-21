package domain.usecases

import domain.repositories.LibraryRepository

/**
 * Use case для получения списка всех дисков.
 * @property repository Репозиторий для доступа к данным библиотеки
 */
class GetDisksUseCase(private val repository: LibraryRepository) {
    /**
     * Получает список всех дисков из репозитория.
     * @return Список всех доступных дисков
     */
    operator fun invoke() = repository.getAllDisks()
}
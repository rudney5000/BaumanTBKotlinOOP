package domain.usecases

import domain.entities.*
import domain.repositories.LibraryRepository

/**
 * Класс, содержащий бизнес-логику операций с элементами библиотеки.
 * @param repository Репозиторий для доступа к данным
 */
class LibraryUseCases(private val repository: LibraryRepository) {

    /**
     * Получение всех книг.
     * @return Список всех книг из репозитория
     */
    fun getAllBooks(): List<Book> = repository.getAllBooks()

    /**
     * Получение всех газет.
     * @return Список всех газет из репозитория
     */
    fun getAllNewspapers(): List<Newspaper> = repository.getAllNewspapers()

    /**
     * Получение всех дисков.
     * @return Список всех дисков из репозитория
     */
    fun getAllDisks(): List<Disk> = repository.getAllDisks()

    /**
     * Взять элемент домой.
     * Газеты нельзя брать домой, только книги и диски.
     * @param item Элемент для взятия домой
     * @return true, если операция успешна, false в противном случае
     */
    fun takeItemHome(item: LibraryItem): Boolean {
        return when {
            !item.isAvailable -> false
            !item.canBeTakenHome() -> false
            else -> {
                repository.updateItemAvailability(item, false)
                true
            }
        }
    }

    /**
     * Читать элемент в читальном зале.
     * Диски нельзя читать в зале, только книги и газеты.
     * @param item Элемент для чтения в зале
     * @return true, если операция успешна, false в противном случае
     */
    fun readItemInLibrary(item: LibraryItem): Boolean {
        return when {
            !item.isAvailable -> false
            !item.canBeReadInLibrary() -> false
            else -> {
                repository.updateItemAvailability(item, false)
                true
            }
        }
    }

    /**
     * Вернуть элемент в библиотеку.
     * @param item Элемент для возврата
     * @return true, если операция успешна, false если элемент уже доступен
     */
    fun returnItem(item: LibraryItem): Boolean {
        return if (item.isAvailable) {
            false
        } else {
            repository.updateItemAvailability(item, true)
            true
        }
    }
}
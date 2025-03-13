package domain.repositories

import domain.entities.*

/**
 * Интерфейс репозитория для работы с элементами библиотеки.
 * Определяет методы получения и обновления элементов.
 */
interface ILibraryRepository {

    /**
     * Получение всех книг из репозитория.
     * @return Список всех книг
     */
    fun getAllBooks(): List<Book>

    /**
     * Получение всех газет из репозитория.
     * @return Список всех газет
     */
    fun getAllNewspapers(): List<Newspaper>

    /**
     * Получение всех дисков из репозитория.
     * @return Список всех дисков
     */
    fun getAllDisks(): List<Disk>

    /**
     * Поиск книги по идентификатору.
     * @param id Идентификатор книги
     * @return Найденная книга или null, если не найдена
     */
    fun getBookById(id: Int): Book?

    /**
     * Поиск газеты по идентификатору.
     * @param id Идентификатор газеты
     * @return Найденная газета или null, если не найдена
     */
    fun getNewspaperById(id: Int): Newspaper?

    /**
     * Поиск диска по идентификатору.
     * @param id Идентификатор диска
     * @return Найденный диск или null, если не найден
     */
    fun getDiskById(id: Int): Disk?

    /**
     * Обновление доступности элемента библиотеки.
     * @param item Элемент для обновления
     * @param isAvailable Новое состояние доступности
     */
    fun updateItemAvailability(item: LibraryItem, isAvailable: Boolean)
}
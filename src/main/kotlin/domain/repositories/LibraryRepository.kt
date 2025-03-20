package domain.repositories

import domain.entities.*

/**
 * Интерфейс репозитория для работы с элементами библиотеки.
 * Определяет методы получения и обновления элементов.
 */
interface LibraryRepository {

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
     * Обновление доступности элемента библиотеки.
     * @param item Элемент для обновления
     * @param isAvailable Новое состояние доступности
     */
    fun updateItemAvailability(item: LibraryItem, isAvailable: Boolean)
}
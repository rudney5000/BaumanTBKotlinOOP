package data.datasources

import domain.entities.*

/**
 * Интерфейс источника данных для элементов библиотеки.
 */
interface LocalDataSource {

    /**
     * Получение всех книг из источника данных.
     * @return Список книг
     */
    fun getBooks(): List<Book>

    /**
     * Получение всех газет из источника данных.
     * @return Список газет
     */
    fun getNewspapers(): List<Newspaper>

    /**
     * Получение всех дисков из источника данных.
     * @return Список дисков
     */
    fun getDisks(): List<Disk>
}
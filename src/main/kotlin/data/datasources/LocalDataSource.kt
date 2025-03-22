package data.datasources

import domain.entities.*

/**
 * Интерфейс источника данных для элементов библиотеки.
 */
interface LocalDataSource {
    /**
     * Получение всех элементов библиотеки из источника данных.
     * @return Список всех элементов библиотеки
     */
    fun getAllItems(): List<LibraryItem>
}
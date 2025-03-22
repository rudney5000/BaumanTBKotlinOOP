package data.repositories

import data.datasources.LocalDataSource
import domain.entities.*
import domain.repositories.LibraryRepository
import utils.extensions.filterByType

/**
 * Реализация репозитория библиотеки.
 * Работает с источником данных для получения и обновления элементов.
 * @param dataSource Источник данных
 */
class LibraryRepositoryImpl(private val dataSource: LocalDataSource) : LibraryRepository {

    /**
     * Получение всех книг.
     * @return Список всех книг
     */
    override fun getAllBooks(): List<Book> = dataSource.getAllItems().filterByType<Book>()

    /**
     * Получение всех газет.
     * @return Список всех газет
     */
    override fun getAllNewspapers(): List<Newspaper> = dataSource.getAllItems().filterByType<Newspaper>()

    /**
     * Получение всех дисков.
     * @return Список всех дисков
     */
    override fun getAllDisks(): List<Disk> = dataSource.getAllItems().filterByType<Disk>()

    /**
     * Обновление доступности элемента.
     * @param item Элемент для обновления
     * @param isAvailable Новое состояние доступности
     */
    override fun updateItemAvailability(item: LibraryItem, isAvailable: Boolean) {
        if (item is BaseLibraryItem) {
            item.changeAvailability(isAvailable)
        }
    }
}
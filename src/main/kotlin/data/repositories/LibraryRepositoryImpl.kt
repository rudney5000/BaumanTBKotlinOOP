package data.repositories

import data.datasources.LocalDataSource
import domain.entities.*
import domain.repositories.ILibraryRepository

/**
 * Реализация репозитория библиотеки.
 * Работает с источником данных для получения и обновления элементов.
 * @param dataSource Источник данных
 */
class LibraryRepositoryImpl(private val dataSource: LocalDataSource) : ILibraryRepository {

    /**
     * Получение всех книг.
     * @return Список всех книг
     */
    override fun getAllBooks(): List<Book> = dataSource.getBooks()

    /**
     * Получение всех газет.
     * @return Список всех газет
     */
    override fun getAllNewspapers(): List<Newspaper> = dataSource.getNewspapers()

    /**
     * Получение всех дисков.
     * @return Список всех дисков
     */
    override fun getAllDisks(): List<Disk> = dataSource.getDisks()

    /**
     * Поиск книги по идентификатору.
     * @param id Идентификатор книги
     * @return Найденная книга или null
     */
    override fun getBookById(id: Int): Book? = getAllBooks().find { it.id == id }

    /**
     * Поиск газеты по идентификатору.
     * @param id Идентификатор газеты
     * @return Найденная газета или null
     */
    override fun getNewspaperById(id: Int): Newspaper? = getAllNewspapers().find { it.id == id }

    /**
     * Поиск диска по идентификатору.
     * @param id Идентификатор диска
     * @return Найденный диск или null
     */
    override fun getDiskById(id: Int): Disk? = getAllDisks().find { it.id == id }

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

    /**
     * Получение всех элементов библиотеки.
     * @return Список всех элементов библиотеки
     */
    override fun getAllItems(): List<LibraryItem> = dataSource.getAllItems()

    /**
     * Получение элемента по идентификатору.
     * @param id Идентификатор элемента
     * @return Найденный элемент или null, если не найден
     */
    override fun getItemById(id: Int): LibraryItem? = getAllItems().find { it.id == id }

    /**
     * Получение элементов определенного типа.
     * @param type Класс типа элементов
     * @return Список элементов заданного типа
     */
    override fun getItemsByType(type: Class<out LibraryItem>): List<LibraryItem> = getAllItems().filter { type.isInstance(it) }
}
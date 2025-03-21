package data.datasources

import domain.entities.*
import utils.extensions.filterByType

/**
 * Реализация источника данных в памяти.
 * Содержит предварительно заполненные списки книг, газет и дисков.
 */
class InMemoryDataSource : LocalDataSource {

    /** Список книг в памяти */
    private val books = mutableListOf(
        Book(1001, "Маугли", true, 202, "Джозеф Киплинг"),
        Book(1002, "Война и мир", true, 1225, "Лев Толстой"),
        Book(1003, "Преступление и наказание", false, 672, "Федор Достоевский"),
        Book(1004, "Мастер и Маргарита", true, 448, "Михаил Булгаков")
    )

    /** Список газет в памяти */
    private val newspapers = mutableListOf(
        Newspaper(2001, "Сельская жизнь", true, 794, Month.МАРТ),
        Newspaper(2002, "Аргументы и факты", false, 123, Month.АПРЕЛЬ),
        Newspaper(2003, "Коммерсантъ", true, 456, Month.ЯНВАРЬ),
        Newspaper(2004, "Известия", true, 789, Month.ОКТЯБРЬ)
    )

    /** Список дисков в памяти */
    private val disks = mutableListOf(
        Disk(3001, "Дэдпул и Росомаха", true, DiskType.DVD),
        Disk(3002, "Лучшие песни 2023", false, DiskType.CD),
        Disk(3003, "Звездные войны: Эпизод IX", true, DiskType.DVD),
        Disk(3004, "Классическая музыка", true, DiskType.CD)
    )

    /**
     * Получение списка книг.
     * @return Список всех книг
     */
    override fun getBooks(): List<Book> = getAllItems().filterByType<Book>()

    /**
     * Получение списка газет.
     * @return Список всех газет
     */
    override fun getNewspapers(): List<Newspaper> = getAllItems().filterByType<Newspaper>()

    /**
     * Получение списка дисков.
     * @return Список всех дисков
     */
    override fun getDisks(): List<Disk> = getAllItems().filterByType<Disk>()

    override fun getAllItems(): List<LibraryItem> {
        val allItems = mutableListOf<LibraryItem>()
        allItems.addAll(books)
        allItems.addAll(newspapers)
        allItems.addAll(disks)
        return allItems
    }
}
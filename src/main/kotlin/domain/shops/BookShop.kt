package domain.shops

import domain.entities.Book

/**
 * Реализация магазина книг.
 * Продает только книги.
 */
class BookShop(
    private val title: String,
    private val author: String,
    private val pages: Int
) : Shop<Book> {
    /**
     * Продажа книги.
     * @return Новый экземпляр книги с предустановленными значениями
     */
    override fun sell(): Book {
        return Book(
            id = 0,
            title = title,
            isAvailable = true,
            pages = pages,
            author = author
        )
    }
}
package domain.shops

import domain.entities.Book

/**
 * Реализация магазина книг.
 * Продает только книги.
 */
class BookShop(
    private val book: Book,
) : Shop<Book> {
    /**
     * Продажа книги.
     * @return Новый экземпляр книги с предустановленными значениями
     */
    override fun sell(): Book {
        return Book(
            id = 0,
            title = book.title,
            isAvailable = true,
            pages = book.pages,
            author = book.author
        )
    }
}
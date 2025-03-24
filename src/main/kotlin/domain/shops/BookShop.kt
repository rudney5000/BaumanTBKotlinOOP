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
        return book.copy(
            id = 0,
            isAvailable = true
        )
    }
}
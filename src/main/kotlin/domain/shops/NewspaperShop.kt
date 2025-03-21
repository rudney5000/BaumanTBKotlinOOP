package domain.shops

import domain.entities.Month
import domain.entities.Newspaper

/**
 * Реализация газетного киоска.
 * Продает только газеты.
 */
class NewspaperShop(
    private val title: String,
    private val issueNumber: Int,
    private val month: Month
) : Shop<Newspaper> {
    /**
     * Продажа газеты.
     * @return Новый экземпляр газеты с предустановленными значениями
     */
    override fun sell(): Newspaper {
        return Newspaper(
            id = 0,
            title = title,
            isAvailable = true,
            issueNumber = issueNumber,
            month = month
        )
    }
}
package domain.shops

import domain.entities.Newspaper

/**
 * Реализация газетного киоска.
 * Продает только газеты.
 */
class NewspaperShop(
    private val newspaper: Newspaper
) : Shop<Newspaper> {
    /**
     * Продажа газеты.
     * @return Новый экземпляр газеты с предустановленными значениями
     */
    override fun sell(): Newspaper {
        return Newspaper(
            id = 0,
            title = newspaper.title,
            isAvailable = true,
            issueNumber = newspaper.issueNumber,
            month = newspaper.month
        )
    }
}
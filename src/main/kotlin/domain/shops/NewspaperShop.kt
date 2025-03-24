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
        return newspaper.copy(
            id = 0,
            isAvailable = true,
        )
    }
}
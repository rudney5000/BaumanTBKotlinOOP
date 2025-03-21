package domain.shops

import domain.entities.Disk
import domain.entities.DiskType

/**
 * Реализация магазина дисков.
 * Продает только диски.
 */
class DiskShop(
    private val title: String,
    private val type: DiskType
) : Shop<Disk> {
    /**
     * Продажа диска.
     * @return Новый экземпляр диска с предустановленными значениями
     */
    override fun sell(): Disk {
        return Disk(
            id = 0,
            title = title,
            isAvailable = true,
            type = type
        )
    }
}
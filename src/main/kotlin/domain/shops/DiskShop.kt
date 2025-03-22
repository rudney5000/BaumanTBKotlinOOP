package domain.shops

import domain.entities.Disk

/**
 * Реализация магазина дисков.
 * Продает только диски.
 */
class DiskShop(
    private val disk: Disk,
) : Shop<Disk> {
    /**
     * Продажа диска.
     * @return Новый экземпляр диска с предустановленными значениями
     */
    override fun sell(): Disk {
        return Disk(
            id = 0,
            title = disk.title,
            isAvailable = true,
            type = disk.type
        )
    }
}
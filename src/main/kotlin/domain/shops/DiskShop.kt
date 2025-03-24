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
        return disk.copy(
            id = 0,
            isAvailable = true,
        )
    }
}
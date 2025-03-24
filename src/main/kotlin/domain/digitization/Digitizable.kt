package domain.digitization

import domain.entities.Disk

interface Digitizable {
    fun toDigitalFormat(): Disk
}
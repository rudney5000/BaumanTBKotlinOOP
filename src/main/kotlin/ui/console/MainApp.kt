package ui.console

import data.datasources.InMemoryDataSource
import data.repositories.LibraryRepositoryImpl
import domain.usecases.LibraryUseCases

/**
 * Объект для запуска и настройки приложения.
 */
object MainApp {
    /**
     * Инициализация и запуск приложения.
     */
    fun run() {
        // Инициализация компонентов
        val dataSource = InMemoryDataSource()
        val repository = LibraryRepositoryImpl(dataSource)
        val useCases = LibraryUseCases(repository)

        // Запуск UI
        val libraryUI = LibraryUI(useCases)
        libraryUI.start()
    }
}
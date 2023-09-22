package au.bystritskaia.controllers.streams;

import au.bystritskaia.services.streams.GroupStreamService;

/**
 * Контороллер потока
 */
public class GroupStreamController {
    /**
     * Сервис потока
     */
    private final GroupStreamService service;

    /**
     * Конструктор контроллера потока
     * @param service Сервис потока
     */
    public GroupStreamController(GroupStreamService service) {
        this.service = service;
    }

    /**
     * Вывести группы
     */
    public void printGroups() {
        this.service.printGroups();
    }

    /**
     * Вывести отсортированные группы
     */
    public void printSortedGroups() {
        this.service.sortGroups().forEach(g -> System.out.println(g.toString()));
    }
}

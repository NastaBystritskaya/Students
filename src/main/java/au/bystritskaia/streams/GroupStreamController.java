package au.bystritskaia.streams;

import au.bystritskaia.groups.StudentGroupService;

public class GroupStreamController {

    private GroupStreamService service;

    public GroupStreamController(GroupStreamService service) {
        this.service = service;
    }

    public void printGroups() {
        this.service.printGroups();
    }

    public void printSortedGroups() {
        this.service.sortGroups().forEach(g -> System.out.println(g.toString()));
    }
}

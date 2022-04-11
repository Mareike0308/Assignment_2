package GUI.Model;

import BE.Event;
import BLL.Manager;

import java.io.IOException;

public class AdminModel {
    Manager manager;

    public AdminModel() throws IOException {
        manager = new Manager();
    }
   /* public void deleteEvent(Event selectedItem) {
        manager.deleteEvent(selectedItem);
    }*/
}

package com.c.refactoring.menuexamples;

import java.util.List;

public class MyMenuAccessRefactor {

    public void setAuthorizationsInEachMenus(List<MenuItem> menuItemsList, Role[] roles) {
        for (int i = 0; i < menuItemsList.size(); i++) {
            MenuItem menuItem = menuItemsList.get(i);
            setAuthorisation(roles, menuItem);
        }
    }

    private void setAuthorisation(Role[] roles, MenuItem menuItem) {
        if (roles != null) {
            for (int j = 0; j < roles.length; j++) {
                String role = roles[j].getName();
                // if write access is false
                boolean checkWriteAccess = !Constants.WRITE.equals(menuItem.getAccess());
                setAccess(menuItem, role, checkWriteAccess);
            }
        }
    }

    private void setAccess(MenuItem menuItem, String role, boolean checkWriteAccess) {
        if (role.equals(menuItem.getWriteAccessRole())) {
            menuItem.setAccess(Constants.WRITE);
            menuItem.setVisible(true);
        }
        if (role.equals(menuItem.getReadAccessRole()) && checkWriteAccess) {
            menuItem.setAccess(Constants.READ);
            menuItem.setVisible(true);
        }
    }

}

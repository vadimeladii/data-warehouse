package md.utm.fcim.webservice.controller.impl;

import md.utm.fcim.webservice.controller.UserController;
import md.utm.fcim.webservice.view.UserView;

public class UserControllerImpl implements UserController {

    @Override
    public UserView test() {
        return new UserView(1L);
    }
}

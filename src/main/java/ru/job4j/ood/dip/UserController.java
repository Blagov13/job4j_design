package ru.job4j.ood.dip;

public class UserController {
    private UserService userService = new UserService();

    public void registerUser(String username, String password) {
        userService.register(username, password);
    }

    /*Прямая зависимость от конкретного сервиса*/
}

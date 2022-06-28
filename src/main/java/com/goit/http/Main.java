package com.goit.http;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;

public class Main {
    private static final String POSTS = "https://jsonplaceholder.typicode.com/posts";
    private static final String USERS = "https://jsonplaceholder.typicode.com/users";


    public static void main(String[] args) throws IOException, InterruptedException {
        User defaultUser = new User(1, "Graham", "Bret",
            "Sincere@april.biz", new Address("Kulas Light", "Apt. 556", "Gwenborough",
            "92998-3874", new Geo("-37.3159", "81.1496")),
            "1-770-736-8031 x56442","hildegard.org",
            new Company("Romaguera-Crona", "Multi-layered client-server neural-net",
            "harness real-time e-markets"));
        //1.1) создание нового объекта
        User createdUser = HttpUtil.putUser(URI.create(USERS), defaultUser);
        System.out.println(createdUser);
        //1.2) обновление объекта
        User updatedUser = HttpUtil.postUser(URI.create(USERS), defaultUser);
        System.out.println(updatedUser);
        //1.3) удаление объекта
        HttpUtil.deleteUser(URI.create(USERS), 11);
        //1.4) получение информации обо всех пользователях
        List<User> allUsers = HttpUtil.getUsers(URI.create(USERS));
        System.out.println(allUsers);
        //1.5) получение информации о пользователе с определенным id
        User userById = HttpUtil.getUserById(URI.create(USERS),1);
        System.out.println(userById);
        //1.6) получение информации о пользователе с определенным username
        User userName = HttpUtil.getUserByUserName(URI.create(USERS), "Delphine");
        System.out.println(userName);
        //все комментарии к последнему посту определенного пользователя
        HttpUtil.getUserComments(2);
        //3)все открытые задачи для пользователя
        List<Todo> allTodos = HttpUtil.getUserTodos(URI.create(USERS), 1);
        System.out.println(allTodos);

    }
}

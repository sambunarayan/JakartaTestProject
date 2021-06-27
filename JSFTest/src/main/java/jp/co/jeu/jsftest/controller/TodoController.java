/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jsftest.controller;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jp.co.jeu.jsftest.bean.User;
import jp.co.jeu.jsftest.entity.TodoList;

/**
 *
 * @author soyou
 */
@Named
@RequestScoped
public class TodoController {

    private User user = new User();
    private List<TodoList> todoList = new ArrayList<>();

    public String findTodoList() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jp.co.jeu_JSFTest_war_1.0.0PU");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("TodoList.findByUserName");
        query.setParameter("userName", user.getName());

        todoList = (List<TodoList>) query.getResultList();

        return "todo/todo_list.xhtml";
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the todoList
     */
    public List<TodoList> getTodoList() {
        return todoList;
    }

    /**
     * @param todoList the todoList to set
     */
    public void setTodoList(List<TodoList> todoList) {
        this.todoList = todoList;
    }
}

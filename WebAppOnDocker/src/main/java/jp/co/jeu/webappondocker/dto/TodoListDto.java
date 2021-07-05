/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author soyou
 */
public class TodoListDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String todoId;
    private String userName;
    private String title;
    private String status;
    private String fromDate;
    private String limitDate;

    public TodoListDto() {
    }

    public TodoListDto(String todoId) {
        this.todoId = todoId;
    }

    public TodoListDto(String todoId, String userName, String title, String status) {
        this.todoId = todoId;
        this.userName = userName;
        this.title = title;
        this.status = status;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(String limitDate) {
        this.limitDate = limitDate;
    }
}

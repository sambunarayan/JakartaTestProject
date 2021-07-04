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
    private Long todoId;
    private String userName;
    private String title;
    private short status;
    private Date fromDate;
    private Date limitDate;

    public TodoListDto() {
    }

    public TodoListDto(Long todoId) {
        this.todoId = todoId;
    }

    public TodoListDto(Long todoId, String userName, String title, short status) {
        this.todoId = todoId;
        this.userName = userName;
        this.title = title;
        this.status = status;
    }

    public Long getTodoId() {
        return todoId;
    }

    public void setTodoId(Long todoId) {
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

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }
}

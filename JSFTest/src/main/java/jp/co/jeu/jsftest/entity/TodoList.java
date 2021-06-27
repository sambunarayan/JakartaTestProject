/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jsftest.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author soyou
 */
@Entity
@Table(name = "TODO_LIST")
@NamedQueries({
    @NamedQuery(name = "TodoList.findAll", query = "SELECT t FROM TodoList t"),
    @NamedQuery(name = "TodoList.findByTodoId", query = "SELECT t FROM TodoList t WHERE t.todoId = :todoId"),
    @NamedQuery(name = "TodoList.findByUserName", query = "SELECT t FROM TodoList t WHERE t.userName = :userName"),
    @NamedQuery(name = "TodoList.findByTitle", query = "SELECT t FROM TodoList t WHERE t.title = :title"),
    @NamedQuery(name = "TodoList.findByStatus", query = "SELECT t FROM TodoList t WHERE t.status = :status"),
    @NamedQuery(name = "TodoList.findByFromDate", query = "SELECT t FROM TodoList t WHERE t.fromDate = :fromDate"),
    @NamedQuery(name = "TodoList.findByLimitDate", query = "SELECT t FROM TodoList t WHERE t.limitDate = :limitDate")})
public class TodoList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TODO_ID")
    private Long todoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private short status;
    @Column(name = "FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Column(name = "LIMIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date limitDate;

    public TodoList() {
    }

    public TodoList(Long todoId) {
        this.todoId = todoId;
    }

    public TodoList(Long todoId, String userName, String title, short status) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (todoId != null ? todoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TodoList)) {
            return false;
        }
        TodoList other = (TodoList) object;
        if ((this.todoId == null && other.todoId != null) || (this.todoId != null && !this.todoId.equals(other.todoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.jeu.jsftest.entity.TodoList[ todoId=" + todoId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    @NamedQuery(name = "TodoList.findByTodoName", query = "SELECT t FROM TodoList t WHERE t.todoName = :todoName"),
    @NamedQuery(name = "TodoList.findByStatus", query = "SELECT t FROM TodoList t WHERE t.status = :status"),
    @NamedQuery(name = "TodoList.findByTodoDate", query = "SELECT t FROM TodoList t WHERE t.todoDate = :todoDate"),
    @NamedQuery(name = "TodoList.findByTodoListId", query = "SELECT t FROM TodoList t WHERE t.todoListId = :todoListId")})
public class TodoList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "TODO_NAME")
    private String todoName;
    @Column(name = "STATUS")
    private BigInteger status;
    @Column(name = "TODO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date todoDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TODO_LIST_ID")
    private BigDecimal todoListId;

    public TodoList() {
    }

    public TodoList(BigDecimal todoListId) {
        this.todoListId = todoListId;
    }

    public TodoList(BigDecimal todoListId, String todoName) {
        this.todoListId = todoListId;
        this.todoName = todoName;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    public BigDecimal getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(BigDecimal todoListId) {
        this.todoListId = todoListId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (todoListId != null ? todoListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TodoList)) {
            return false;
        }
        TodoList other = (TodoList) object;
        if ((this.todoListId == null && other.todoListId != null) || (this.todoListId != null && !this.todoListId.equals(other.todoListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.jeu.webappondocker.entity.TodoList[ todoListId=" + todoListId + " ]";
    }
    
}

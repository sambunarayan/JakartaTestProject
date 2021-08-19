/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.Dependent;
import javax.persistence.Query;
import javax.transaction.Transactional;
import jp.co.jeu.webappondocker.dto.TodoListDto;
import jp.co.jeu.webappondocker.dto.TodoSearchRequestDto;
import jp.co.jeu.webappondocker.entity.TodoList;
import org.eclipse.persistence.internal.jpa.EJBQueryImpl;

/**
 *
 * @author soyou
 */
@Transactional
@Dependent
public class TodoDao extends AbstractWebAppDao {

    public List<TodoListDto> findAll() {
        Query query = getEntityManager().createNamedQuery("TodoList.findAll");
        return (List<TodoListDto>) query.getResultStream()
                .map(o -> {
                    TodoList entity = (TodoList) o;
                    TodoListDto todo = new TodoListDto();
                    todo.setTodoId(entity.getTodoId().toString());
                    todo.setUserName(entity.getUserName());
                    todo.setTitle(entity.getTitle());
                    todo.setStatus(String.valueOf(entity.getStatus()));
                    todo.setFromDate(entity.getFromDate().toString());
                    todo.setLimitDate(entity.getLimitDate().toString());
                    return todo;
                }).collect(Collectors.toList());
    }

    public TodoList findTodoByKey(TodoSearchRequestDto reqDto) {
        Query query = null;
        try {
            query = getEntityManager().createNamedQuery("TodoList.findByTodoId");
            query.setParameter("todoId", BigDecimal.valueOf(reqDto.getId()));
            return (TodoList) query.getSingleResult();
        } catch (Exception e) {
            if (query != null) {
                System.out.println(query.unwrap(EJBQueryImpl.class).getDatabaseQuery().getSQLString());
            }
            throw e;
        }
    }
}

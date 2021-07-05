/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.logic;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import jp.co.jeu.webappondocker.dao.TodoDao;
import jp.co.jeu.webappondocker.dto.TodoListFindAllDto;
import jp.co.jeu.webappondocker.dto.TodoSearchRequestDto;
import jp.co.jeu.webappondocker.entity.TodoList;

/**
 *
 * @author soyou
 */
@Dependent
public class TodoSearchLogic {

    @Inject
    private TodoDao todoDao;

    public TodoListFindAllDto findAll() {
        TodoListFindAllDto findAllDto = new TodoListFindAllDto();
        findAllDto.setFindAll(todoDao.findAll());
        return findAllDto;
    }

    public TodoList findTodoByKey(TodoSearchRequestDto reqDto) {
        return todoDao.findTodoByKey(reqDto);
    }
}

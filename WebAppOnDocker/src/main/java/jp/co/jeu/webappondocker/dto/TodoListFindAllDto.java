/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.dto;

import java.util.List;

/**
 *
 * @author soyou
 */
public class TodoListFindAllDto {

    private List<TodoListDto> findAll;

    /**
     * @return the findAll
     */
    public List<TodoListDto> getFindAll() {
        return findAll;
    }

    /**
     * @param findAll the findAll to set
     */
    public void setFindAll(List<TodoListDto> findAll) {
        this.findAll = findAll;
    }
}

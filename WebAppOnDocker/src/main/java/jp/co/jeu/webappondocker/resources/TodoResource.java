package jp.co.jeu.webappondocker.resources;

import com.google.gson.Gson;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.webappondocker.dto.TodoListFindAllDto;
import jp.co.jeu.webappondocker.dto.TodoSearchRequestDto;
import jp.co.jeu.webappondocker.entity.TodoList;
import jp.co.jeu.webappondocker.logic.TodoSearchLogic;

/**
 *
 * @author
 */
@Path("todo")
public class TodoResource {
    
    @Inject
    private TodoSearchLogic searchLogic;
    
    @Path("/findAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTodo() {
        TodoListFindAllDto resEntity = searchLogic.findAll();
        return Response
                .ok()
                .entity(resEntity)
                .build();
    }
    
    @Path("/findByKey")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTodoByKey(TodoSearchRequestDto reqDto) {
        TodoList todoList = searchLogic.findTodoByKey(reqDto);
        return Response
                .ok()
                .entity(todoList)
                .build();
    }
}

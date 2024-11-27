package vn.herta.controllers.admin;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import vn.herta.services.impl.UserService;

@Controller
public class GraphQLController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CategoryService categoryService;
    
    @QueryMapping
    public List<User> users() {
        return userService.findAll();
    }
    
    @QueryMapping
    public List<Category> categories() {
        return categoryService.findAll();
    }
    
    @QueryMapping
    public List<Category> userCategories(@Argument Long userId) {
        return userService.findUserCategories(userId);
    }
    
    @MutationMapping
    public User createUser(@Argument UserInput input) {
        return userService.createUser(input);
    }
    
    @MutationMapping
    public User updateUser(@Argument Long id, @Argument UserInput input) {
        return userService.updateUser(id, input);
    }
    
    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        return userService.deleteUser(id);
    }
}
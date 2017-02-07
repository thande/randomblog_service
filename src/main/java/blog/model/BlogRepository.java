package blog.model;

import blog.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sdelight on 2/6/17.
 */
public interface BlogRepository extends MongoRepository<Blog, String> {

    public Blog findByName(String name);
}

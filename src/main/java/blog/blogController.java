package blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
/**
 * Created by sdelight on 5/28/15.
 * This class handles all Blog requests
 */

@RestController
public class blogController {

    private static final Logger logger = LoggerFactory.getLogger(blogController.class);

    //Map to store blogs, TODO update to database
    Map<Integer, Blog> blogData = new HashMap<Integer, Blog>();

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = blogRestURIConstants.DUMMY_BLOG, method = RequestMethod.GET)
    public @ResponseBody Blog getDummyBlog() {
        logger.info("Start getDummyEmployee");
        Blog blg = new Blog();
        blg.setId(9999);
        blg.setName("Dummy");
        blg.setCreatedDate(new Date());
        blogData.put(9999, blg);
        return blg;
    }

    @RequestMapping(value = blogRestURIConstants.GET_BLOG, method = RequestMethod.GET)
    public @ResponseBody Blog getBlog(@PathVariable("id") int blgId) {
        logger.info("Start getBlog. ID="+blgId);

        return blogData.get(blgId);
    }

    @RequestMapping(value = blogRestURIConstants.GET_ALL_BLOG, method = RequestMethod.GET)
    public @ResponseBody List<Blog> getAllBlogs() {
        logger.info("Start getAllBlogs");
        List<Blog> blogs = new ArrayList<Blog>();
        Set<Integer> blogIdKeys = blogData.keySet();
        for(Integer i : blogIdKeys){
            blogs.add(blogData.get(i));
        }
        return blogs;
    }

    @RequestMapping(value = blogRestURIConstants.CREATE_BLOG, method = RequestMethod.POST)
    public @ResponseBody Blog createBlog(@RequestBody Blog blg) {
        logger.info("Start createBlog");
        blg.setCreatedDate(new Date());
        blg.setId(((int) counter.incrementAndGet()));
        blogData.put(blg.getId(), blg);
        return blg;
    }

    @RequestMapping(value = blogRestURIConstants.DELETE_BLOG, method = RequestMethod.PUT)
    public @ResponseBody Blog deleteBlog(@PathVariable("id") int blogId) {
        logger.info("Start deleteBlog");
        Blog blg = blogData.get(blogId);
        blogData.remove(blogId);
        return blg;
    }


}



package blog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by sdelight on 2/6/17.
 */



@RunWith(SpringJUnit4ClassRunner.class)
public class blogControllerTest {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private Blog blog;

    @Before
    public void setup() throws Exception {

        blogController blogController= new blogController();
        mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();

        }

    @Test
    public void getDummyBlog() throws Exception {

    }

    @Test
    public void getBlog() throws Exception {
        //Returns single blog
        MvcResult result = mockMvc.perform(get("/rest/blog/9999")) //get the dummy blog
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String content = result.getResponse().getContentAsString();

        //Assert(content,"")

    }

    @Test
    public void getAllBlogs() throws Exception {

        String content = "{\"make\":\"Ford\",\"model\":\"Focus\"}";
        //Returns list of available blogs
        MvcResult result = mockMvc.perform(get("/rest/blog"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();

        String response = result.getResponse().getContentAsString();
    }

//    @Test
    public void createBlog() throws Exception {

        MvcResult result = mockMvc.perform(post("/rest/blog")
                .content("{\"name\":\"Dummy2\",\"description\":\"Awesome description\"}"))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        log.debug(content);
    }

    @Test
    public void deleteBlog() throws Exception {

    }

    @Test
    public void blogNotFound() throws Exception {
        mockMvc.perform(get("/rest/blog/123")
                .contentType(contentType))
                .andExpect(status().is2xxSuccessful()); //ToDo change this to 404 .isNotFound()
    }


}

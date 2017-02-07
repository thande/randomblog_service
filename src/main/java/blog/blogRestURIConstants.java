package blog;

/**
 * Created by sdelight on 5/28/15.
 */
public class blogRestURIConstants {
    public static final String BASE_URI = "/rest";
    public static final String DUMMY_BLOG = BASE_URI+"/blog/dummy";
    public static final String GET_BLOG = BASE_URI+"/blog/{id}";
    public static final String GET_ALL_BLOG = BASE_URI+"/blog";
    public static final String CREATE_BLOG = BASE_URI+"/blog/create";
    public static final String DELETE_BLOG = BASE_URI+"/blog/delete/{id}";
}

package org.acme.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.model.Post;
import org.acme.model.Usuario;
import org.acme.service.PostService;

import java.util.List;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    PostService postService;

    @POST
    @Transactional
    public Response addPost(Post post) {
        postService.addPost(post);
        return Response.status(Response.Status.CREATED).entity(post).build();
    }

    @GET
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}

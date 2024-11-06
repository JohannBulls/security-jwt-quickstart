package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.acme.model.Post;
import java.util.List;

@ApplicationScoped
public class PostService {

    @Inject
    EntityManager em;

    public void addPost(Post post) {
        em.persist(post);
    }

    public List<Post> getAllPosts() {
        return em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
    }
}


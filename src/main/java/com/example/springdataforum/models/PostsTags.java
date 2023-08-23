package com.example.springdataforum.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Posts_Tags")
public class PostsTags extends BaseEntity{
    @Column(name = "posts_id", nullable = false)
    private long posts_id;
    @Column(name = "tags_id", nullable = false)
    private long tags_id;

    public long getPosts_id() {
        return posts_id;
    }

    public long getTags_id() {
        return tags_id;
    }

    private void setPosts_id(long posts_id) {
        this.posts_id = posts_id;
    }

    private void setTags_id(long tags_id) {
        this.tags_id = tags_id;
    }

    public PostsTags(long posts_id, long tags_id) {
        this.posts_id = posts_id;
        this.tags_id = tags_id;
    }
    protected PostsTags(){}

    @Override
    public String toString() {
        return "PostsTags{" +
                "posts_id=" + posts_id +
                ", tags_id=" + tags_id +
                ", id=" + id +
                '}';
    }
    // Links below
    @ManyToOne
    @JoinColumn(
            name = "posts_id",
            insertable = false, updatable = false)
    private Posts posts;
    @ManyToOne
    @JoinColumn(
            name = "tags_id",
            insertable = false, updatable = false)
    private Tags tags;
}

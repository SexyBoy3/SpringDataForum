package com.example.springdataforum.dtos;

public class PostsTagsDto {
    private long id;
    public void setId(long id) {this.id = id;}
    public long getId() {return id;}

    private long posts_id;
    private long tags_id;
    PostsDto postsDto;
    TagsDto tagsDto;

    public long getPosts_id() {
        return posts_id;
    }

    public void setPosts_id(long posts_id) {
        this.posts_id = posts_id;
    }

    public long getTags_id() {
        return tags_id;
    }

    public void setTags_id(long tags_id) {
        this.tags_id = tags_id;
    }

    public PostsTagsDto(long posts_id, long tags_id) {
        this.posts_id = posts_id;
        this.tags_id = tags_id;
    }
    public PostsTagsDto(){}

    @Override
    public String toString() {
        return "PostsTagsDto{" +
                "posts_id=" + posts_id +
                ", tags_id=" + tags_id +
                '}';
    }
}

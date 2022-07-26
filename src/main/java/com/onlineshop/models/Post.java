package com.onlineshop.models;

import java.util.Objects;

public class Post {
    private String title;
    private String imageUrl;

    public Post(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return title.equals(post.title) && imageUrl.equals(post.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, imageUrl);
    }
}

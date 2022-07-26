package com.onlineshop.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    public enum Theme {
        Light,
        Dark
    }

    private Theme theme = Theme.Light;

    private List<Post> posts = new ArrayList<>();

    private User(UserBuilder userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.userName = userBuilder.userName;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public Post getPostByTitleAndImageUrl(String title, String imageUrl) {
        Post post = new Post(title, imageUrl);
        for (Post p : this.posts) {
            if (p.equals(post)) return p;
        }
        return null;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;
        private String password;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder() {}

        public UserBuilder username(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

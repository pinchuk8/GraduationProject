package models;

public class User {
    private String username;
    private String password;

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public User.Builder withUsername(String username) {
            newUser.username = username;
            return this;
        }

        public User.Builder withPassword(String password) {
            newUser.password = password;
            return this;
        }

        public User build() {
            return newUser;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

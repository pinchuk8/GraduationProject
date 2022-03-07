package models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("username")
    private String username;
    private String password;
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private int userStatus;

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }

        public Builder withUsername(String username) {
            newUser.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            newUser.password = password;
            return this;
        }

        public Builder withId(int id) {
            newUser.id = id;
            return this;
        }

        public Builder withFirstname(String firstname) {
            newUser.firstname = firstname;
            return this;
        }
        public Builder withLastname(String lastname) {
            newUser.lastname = lastname;
            return this;
        }

        public Builder withEmail(String email) {
            newUser.email = email;
            return this;
        }

        public Builder withPhone(String phone) {
            newUser.phone = phone;
            return this;
        }

        public Builder withUserStatus(int userStatus) {
            newUser.userStatus = userStatus;
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

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getUserStatus() {
        return userStatus;
    }
}

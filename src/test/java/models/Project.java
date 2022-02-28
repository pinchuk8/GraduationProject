package models;

public class Project {
    private String name;
    private String key;

    public static class Builder {
        private Project newProject;

        public Builder() {
            newProject = new Project();
        }

        public Builder withName(String name) {
            newProject.name = name;
            return this;
        }

        public Builder withKey(String key) {
            newProject.key = key;
            return this;
        }

        public Project build() {
            return newProject;
        }
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }
}

package models;

import enums.TypesOfTask;

public class Task {
    private String summary;
    private String description;
    private TypesOfTask typeOfTask;

    public static class Builder{
        private Task newTask;

        public Builder() {
            newTask = new Task();
        }

        public Builder withSummary(String summary) {
            newTask.summary = summary;
            return this;
        }

        public Builder withDescription(String description) {
            newTask.description = description;
            return this;
        }

        public Builder withTypeOfTask(TypesOfTask typeOfTask) {
            newTask.typeOfTask = typeOfTask;
            return this;
        }

        public Task build() {
            return newTask;
        }
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public TypesOfTask getTypeOfTask() {
        return typeOfTask;
    }
}

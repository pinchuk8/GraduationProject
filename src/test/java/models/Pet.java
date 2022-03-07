package models;

public class Pet {
   private String name;
   private String photoUrls;
   private int id;
   private String status;

   public static class Builder{
       private Pet newPet;

       public Builder() {
           newPet = new Pet();
       }

       public Builder withName(String name) {
          newPet.name = name;
          return this;
       }
       public Builder withPhotoUrls(String photoUrls) {
           newPet.photoUrls = photoUrls;
           return this;
       }

       public Builder withId(int id) {
           newPet.id = id;
           return this;
       }

       public Builder withStatus(String status){
           newPet.status = status;
           return this;
       }

       public Pet build() {
           return newPet;
       }
   }

    public String getName() {
        return name;
    }

    public String getPhotoUrls() {
        return photoUrls;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}

package main.models;

public class User {

    private String name;
    private String lastName;
    private String eMail;
    private String password;
    private String[] coursesID = new String[Course.MAX_COURSE];
    private int coursesCount = 0;
    private static User instance;

    private User(){}

    public static User getUserInstance (){
         if (instance == null){
            instance = new User();
        }
        return instance;
    }


    public void addCourse(String Id){
        if(coursesCount != Course.MAX_COURSE){
            coursesID[coursesCount] = Id;
            coursesCount++;
        }
    }

    public String[] getCourses() {
        return coursesID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public int getCoursesCount() {
        return coursesCount;
    }

    public String getPassword() {
        return password;
    }

}

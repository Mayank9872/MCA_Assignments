

class Course{
    String courseName;
    double duration;
    void showCourse(){
        System.out.println("\nCourse details :\n");
        System.out.println("Course name : "+courseName);
        System.out.println("Course duration : "+duration+" years");
    }
}
class OnlineCourse extends Course{
    String platform;
    boolean isRecorded;
    void showCourse(){
        System.out.println("\nCourse details :\n");
        System.out.println("Course name : "+courseName);
        System.out.println("Course duration : "+duration+" years");
        System.out.println("Course platform : "+platform);
        if (isRecorded){System.out.println("Course will be recorded.");}
        else{System.out.println("Course will not be recorded.");}
    }
}
class PaidOnlineCourse extends OnlineCourse{
    double fee;
    int discount;
    void showCourse(){
        System.out.println("\nCourse details :\n");
        System.out.println("Course name : "+courseName);
        System.out.println("Course duration : "+duration+" years");
        System.out.println("Course platform : "+platform);
        if (isRecorded){System.out.println("Course will be recorded.");}
        else{System.out.println("Course will not be recorded.");}
        System.out.println("Course discount : "+discount+" %");
        System.out.println("Course fee : Rs."+(fee-(fee*(discount/100))));
    }
}
public class educationalCourse{
    public static void main(String[] args) {
        Course crs1=new Course();
        crs1.courseName="Advanced JAVA";
        crs1.duration=2;
        crs1.showCourse();

        OnlineCourse crs2=new OnlineCourse();
        crs2.courseName="UI/UX";
        crs2.duration=1.5;
        crs2.isRecorded=true;
        crs2.platform="Zoom meeting";
        crs2.showCourse();

        PaidOnlineCourse crs3=new PaidOnlineCourse();
        crs3.courseName="RDBMS";
        crs3.duration=3;
        crs3.isRecorded=false;
        crs3.platform="Google meet";
        crs3.discount=20;
        crs3.fee=15000;
        crs3.showCourse();
    }
}
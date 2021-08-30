package com.example.demo.pckg1;

import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DataB {
static int flag=1;
    static ArrayList<Kid> kids;
    static ArrayList<Course> courses  = new ArrayList<>();
    static ArrayList<Leader> leaders;
    static ArrayList<Parent> parents;
    static ArrayList<Category> categories;
    static ArrayList<Meeting> meetings;

    public DataB(){
        kids = new ArrayList<>();
        courses = new ArrayList<>();
        leaders = new ArrayList<>();
        parents = new ArrayList<>();
        categories= new ArrayList<>();
        meetings = new ArrayList<>();
    }



    public ArrayList<Course> addCourses() throws ParseException {
        String sDate1="21/08/2021";
        String sDate2="1/02/2021";
        String sDate3="1/08/2021";
        String sDate4="1/08/2020";
        String sDate5="1/07/2021";
        String sDate6="23/08/2021";
        String sDate7="30/08/2021";
        String sDate8="26/08/2021";
        String sDate9="26/07/2021";
        String sDate10="28/8/2020";
        String sDate11="13/08/2021";
        String sDate12="17/06/2020";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
        Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);
        Date date4=new SimpleDateFormat("dd/MM/yyyy").parse(sDate4);
        Date date5=new SimpleDateFormat("dd/MM/yyyy").parse(sDate5);
        Date date6=new SimpleDateFormat("dd/MM/yyyy").parse(sDate6);
        Date date7=new SimpleDateFormat("dd/MM/yyyy").parse(sDate7);
        Date date8=new SimpleDateFormat("dd/MM/yyyy").parse(sDate8);
        Date date9=new SimpleDateFormat("dd/MM/yyyy").parse(sDate9);
        Date date10=new SimpleDateFormat("dd/MM/yyyy").parse(sDate10);
        Date date11=new SimpleDateFormat("dd/MM/yyyy").parse(sDate11);
        Date date12=new SimpleDateFormat("dd/MM/yyyy").parse(sDate12);
        Date[] dates={date1,date2,date3,date4,date5,date6,
                date7,date8,date9,date10,date11,date12};
String cor="course";
for ( int i=0; i<41;i++){
    int j = (int)(Math.random() * 6);
    int f = (int)(Math.random() * 12);
    courses.add(new Course(i+"","course"+j,dates[f],dates[f] , Day.Friday , j+""));
}
return  courses;
    }
    private void AddCategories(){


        Category category1 = new Category("category1","1001","1");
        categories.add(category1);
        Category category2 = new Category("category2","2002","2");
        categories.add(category2);
        Category category3 = new Category("category3","3003","3");
        categories.add(category3);
        Category category4 = new Category("category4","4004","4");
        categories.add(category4);

    }
    public  ArrayList<Parent> AddParents() throws ParseException {
        String[] Firstnames ={ "Aaron",
                "Daanyaal", "Jonny", "Ruaidhri",
                "Valery",
                "Shaun-Paul"};
        String[] Lastnames ={ "Ronan-Benedict",
                "Shadow",
                "Usman",  "Owen",
                "Pablo","Pardeepraj"};
        String[] gmail ={ "Aaron@gmail.com",
                "Shadow@gmail.com",
                "Usman@gmail.com",  "Owen@gmail.com",
                "Pablo@gmail.com","Pardeepraj@gmail.com"};
        String[] pass ={ "Aaron12!",
                "Shadow14!",
                "Usman15!",  "Owen@17!",
                "Pablo18!","Pardee19!"};
        String sDate1="21/08/2021";
        String sDate2="1/02/2021";
        String sDate3="1/08/2021";
        String sDate4="1/08/2020";
        String sDate5="1/07/2021";
        String sDate6="26/08/2021";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
        Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);
        Date date4=new SimpleDateFormat("dd/MM/yyyy").parse(sDate4);
        Date date5=new SimpleDateFormat("dd/MM/yyyy").parse(sDate5);
        Date date6=new SimpleDateFormat("dd/MM/yyyy").parse(sDate6);
        Date[] date={date1,date2,date3,date4,date5,date6};
        for (int i=0;i<100;i++){
            int j = (int)(Math.random() * 6);
            Parent p = new Parent(Firstnames[j],Lastnames[j],gmail[j],pass[j]);
            p.setActiveDate(date[j]);
            parents.add(p);
        }
        return parents;
    }
    public  ArrayList<Kid> AddKids() throws ParseException {
        String[] Firstnames ={ "Aaron",
                "Daanyaal", "Jonny", "Ruaidhri",
                "Valery",
                "Shaun-Paul"};
        String[] Lastnames ={ "Ronan-Benedict",
                "Shadow",
                "Usman",  "Owen",
                "Pablo","Pardeepraj"};
        String[] gmail ={ "Aaron@gmail.com",
                "Shadow@gmail.com",
                "Usman@gmail.com",  "Owen@gmail.com",
                "Pablo@gmail.com","Pardeepraj@gmail.com"};
        String[] pass ={ "Aaron12!",
                "Shadow14!",
                "Usman15!",  "Owen@17!",
                "Pablo18!","Pardee19!"};
        String sDate1="21/08/2021";
        String sDate2="1/02/2021";
        String sDate3="1/08/2021";
        String sDate4="1/08/2020";
        String sDate5="1/07/2021";
        String sDate6="26/08/2021";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
        Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);
        Date date4=new SimpleDateFormat("dd/MM/yyyy").parse(sDate4);
        Date date5=new SimpleDateFormat("dd/MM/yyyy").parse(sDate5);
        Date date6=new SimpleDateFormat("dd/MM/yyyy").parse(sDate6);
        Date[] date={date1,date2,date3,date4,date5,date6};
        for (int i=0;i<100;i++){
            int j = (int)(Math.random() * 6);
            int f = (int)(Math.random() * 39);

            Kid k = new Kid(i+"",Firstnames[j],date1,Gender.Female,"1");
            k.setActiveDate(date[j]);
           k.setActiveCourses( k.addCourse(courses.get(f).getID()));
            courses.get(f).AddKids(k.getId());
            kids.add(k);

        }
        return kids;
    }

    public ArrayList<Meeting> addMeetings() throws ParseException {
        Meeting meeting;
        List<String> toreturn = new ArrayList<>();
        String sDate1="21/08/2021";
        String sDate2="1/02/2021";
        String sDate3="1/08/2021";
        String sDate4="1/08/2020";
        String sDate5="1/07/2021";
        String sDate6="26/08/2021";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
        Date date3=new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);
        Date date4=new SimpleDateFormat("dd/MM/yyyy").parse(sDate4);
        Date date5=new SimpleDateFormat("dd/MM/yyyy").parse(sDate5);
        Date date6=new SimpleDateFormat("dd/MM/yyyy").parse(sDate6);
        Date[] date={date1,date2,date3,date4,date5,date6};
        for(Course c : courses)
            toreturn.add(c.getID());
        for(int i = 0; i < 100;i++){
            int j = (int)(Math.random() * toreturn.size());
            int m = (int)(Math.random() * 6);
            int s = (int)(Math.random() * 2);

            meeting = new Meeting(toreturn.get(j),date[m]);
            meeting.setActualMeetingDuration((int)(Math.random() * 3));
            if(s==1)
            meeting.setCancelled(true);
            if(s==0)
            meeting.setCancelled(false);
            meetings.add(meeting);

        }
        return meetings;
    }

    public int addAllData(){
        if(flag==1) {
            AddCategories();
            try {
                AddCategories();
                addCourses();
                AddParents();
                AddKids();
                addMeetings();
                flag=0;
                return 1;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}

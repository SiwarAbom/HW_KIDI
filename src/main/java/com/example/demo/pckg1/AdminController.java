package com.example.demo.pckg1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    Leader_Repository leaderRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TCourseRepository courseRepository;
    @Autowired
    DataB dataB;
    @Autowired
    Parent_repository parent_repository;
    @Autowired
    KidRepository kidRepository;
    @Autowired
   MeetingRepository meetingRepository;

    /**
     * @param categoryID
     * @return array list of leader in given category
     * */

    @GetMapping("/getLeaderByCategory/{categoryID}")
    public ArrayList<Leader> getLeadersByCategoryID(@PathVariable String categoryID){
        return leaderRepository.getCategoryLeaders(categoryID);
    }
    @GetMapping("/getParents")
    public ArrayList<Parent> getparents()  {

        try {
            return dataB.AddParents();
        } catch (ParseException e) {
            e.printStackTrace();
        }

return null;
    }

//    //addMeetings()
//    @GetMapping("/getMeetings")
//    public ArrayList<Meeting> getMeetings()  {
//        try {
//            return dataB.addMeetings();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @GetMapping("/getTotal/{period}")
    public HashMap<String, Integer> getTotal(@PathVariable Integer period)  {
            return categoryRepository.getKidsCountByCategory(period);

    }
    @GetMapping("/AddAll")
    public Integer getAll()  {
        return dataB.addAllData();

    }

    @GetMapping("/getActivityTime/{period}")
    public HashMap<String, Double> getActivityTime(@PathVariable Integer period)  {

        return meetingRepository.getActivityTime(period);

    }
    @GetMapping("/get")
    public Integer gets()  {
 return  1;
    }

    @GetMapping("/getParentsPe/{pe}")
    public HashMap<String, Integer> getParentsPe( @PathVariable Integer pe)  {
            return parent_repository.getNewParents(pe);
    }
    @GetMapping("/getKidsPe/{pe}")
    public HashMap<String, Integer> getNewKids( @PathVariable Integer pe)  {
        return kidRepository.getNewKids(pe);
    }
    @GetMapping("/getKids")
    public ArrayList<Kid>  getKids( )  {
        try {
            return dataB.AddKids();
        }
        catch (ParseException e)
        {
            System.out.println("fe 3l6*************");

        }
        return null;
    }
    @GetMapping("/getCourses")
    public ArrayList<Course> getcourses()  {
        try {
            return dataB.addCourses();
        }
        catch (ParseException p){
            System.out.println("FAT 3L6");
        }
        return  null;
    }
    @GetMapping("/getcOURSESs1")
    public ArrayList<Course> getcoursess()  {

            return dataB.courses;

    }

    /**
     * @param leaderID
     * @param courseID
     * @return boolean variable if leader was added to given
     * course of id or not
     * */
    @PutMapping("/LeaderCourse/{courseID}/{leaderID}")
    public ResponseEntity<Boolean> AddLeaderToCourse(@PathVariable String courseID , @PathVariable String leaderID){
//  Leader le=ileaderRepository.updateLeaderTOActive(leaderID);
        if(leaderID.isEmpty()|| courseID.isEmpty())
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_ACCEPTABLE);

        Boolean b = courseRepository.addLeaderToCourse(courseID,leaderID);
        if(!b)
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Boolean>(b, HttpStatus.OK);
    }

    /**
     * @param courseID
     * @param leaderID
     * @return response if leader was removed from given course
     * */
    @PutMapping("/LeaderCourseRemove/{courseID}/{leaderID}")
    public ResponseEntity<Boolean> RemoveLeaderToCourse(@PathVariable String courseID , @PathVariable String leaderID){
//  Leader le=ileaderRepository.updateLeaderTOActive(leaderID);
        if(leaderID.isEmpty()|| courseID.isEmpty())
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_ACCEPTABLE);

        Boolean b = courseRepository.removeLeaderCourse(courseID,leaderID);
        if(!b)
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);

        return new ResponseEntity<Boolean>(b, HttpStatus.OK);
    }

    /**
     * @param name
     * @return course of given name
     * */
    @GetMapping("/getCourseByName/{name}")
    public Object getCourseByName(@PathVariable String name) {

        if(name==null)
            return new ResponseEntity<Course>((Course) null, HttpStatus.NOT_ACCEPTABLE);

        Course my_Course = courseRepository.getASpecificCourseByName(name);
        if(my_Course== null)
            return new ResponseEntity<Course>((Course) null, HttpStatus.NOT_FOUND);
        else
            return my_Course;
    }

    /**
     * @param courseName
     * @return list of leaders of given course name
     * */
    @GetMapping("/getLeadersBysCourseName/{courseName}")
    public Object getLeadersBysCourseName(@PathVariable String courseName) {
        if(courseName==null)
            return new ResponseEntity<Leader>((Leader) null, HttpStatus.NOT_ACCEPTABLE);

        ArrayList<String> my_leaders = courseRepository.getCourseLeadersByName(courseName);
        if(my_leaders.isEmpty())
            return new ResponseEntity<Leader>((Leader) null, HttpStatus.NOT_FOUND);
        else
            return my_leaders;
    }



    /**
     * @return array list of all categories
     * */
    @GetMapping("/categories/getCategories")
    public ArrayList<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }


}
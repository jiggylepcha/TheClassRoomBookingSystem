/**
 * This program implements a classroom booking system. Users (Admin, Student, Faculty) can request and book rooms. Students can also
 * see which courses are available and can register for multiple courses.
 *
 * AP Project.
 *
 * @author Jigme Lobsang Lepcha 2016045.
 * @author Nakul Ramanathan 2016168.
 * @version 1.0
 * @since 2017-10-06

 */
package Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main extends Application implements Serializable {
    public static final long serialVersionUID = 12323139863L;

    public static Parent root;

    public ArrayList<Course> course;
    public static ArrayList<Room> rooms = new ArrayList<Room>(18);

    /** Loads the initial Login page */
    @Override
    public void start(Stage primaryStage) throws Exception {
        //System.out.println(new File(""));
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }
    /** This is the main function which actuallr runs the application*/
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Main ob = new Main();
        ob.populateClassroom();
        //ob.CSVParser();
//        ArrayList<Course> cou = deserializeCSV();
//        System.out.println(cou.get(0).getCourseName());
        launch(args);
    }
    /** This function parses CSV files. It needs to be called only once as the database is being stored.
     * We have used s regex to separate the commas which come in between the sentences.
     * Each course is being stored in a Course class which is then stored in an ArrayList.
     * The ArrayList is then being serialised to save all the data*/
    public void CSVParser() throws FileNotFoundException, IOException {
        File file = new File("./src/");
        Scanner scanner = new Scanner(new File("./src/Classes/TheFinalCSVYES.csv"));
        String line = null;
        course = new ArrayList<Course>();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            String[] splitted = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            Course c = new Course(splitted[0],
                    splitted[1], splitted[2], splitted[3], splitted[4], splitted[5],
                    splitted[6], splitted[7], splitted[8], splitted[9], splitted[10],
                    splitted[11], splitted[12], splitted[13], splitted[14]);
            course.add(c);
        }
        serializeCSV(course);

    }

    /** This function serialises the ArrayList*/

    private void serializeCSV(ArrayList<Course> c) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("csv.ser"));
            out.writeObject(c);
        } finally {
            out.close();
        }
    }
    /** This function deserialises the CSV file, so that we can access the data which is being stored*/

    public static ArrayList<Course> deserializeCSV() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        ArrayList<Course> cou = null;
        try {
            in = new ObjectInputStream(new FileInputStream("csv.ser"));
            cou = (ArrayList<Course>) in.readObject();
        } finally {
            in.close();
        }

        return cou;
    }

    /** This function populates the classroom i.e., the room class is being populated with the Room data(Room number, size etc.)*/

    public static void populateClassroom() throws IOException, ClassNotFoundException {

        int n = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 1; j < 5; j++)
            {
                Room tempRoom = new Room();
                tempRoom.setRoomNumber("C"+Integer.toString(i)+Integer.toString(j));
                //System.out.println("C"+Integer.toString(i)+Integer.toString(j));
                rooms.add(tempRoom);
                n++;
            }
        }

        for(int i = 1; i <=3 ; i++) {
            Room tempRoom = new Room();
            tempRoom.setRoomNumber("LR"+Integer.toString(i));
            rooms.add(tempRoom);
            n++;
        }

        for(int i = 1; i <=3 ;i++)
        {
            Room tempRoom = new Room();
            tempRoom.setRoomNumber("L2"+Integer.toString(i));
            rooms.add(tempRoom);
            n++;
        }
        //setClassRoomBookingSystem();
  }
/** This function maps each classroom to it's availability.
 * The data is being stored in a hashmap with Room class as the key and a 2D binary matrix as the key.
 * The 2D matrix stores the time division as the column values and the days as the row values.
 * Room booking for a particular classroom is shown as 1 and unbooked room as 0*/
    public static void setClassRoomBookingSystem() throws IOException, ClassNotFoundException {
        int arr[][] = new int[5][18];
        Map<Room, int[][]> roomMap = new HashMap<Room, int[][]>();
        ArrayList<Course> readCourse = Main.deserializeCSV();
        //System.out.println(readCourse.size()+", "+rooms.size());
        for (int i = 1; i < readCourse.size(); i++) {

            for (int j = 0; j < rooms.size(); j++) {
                //System.out.println(readCourse.get(i).getAcronym()+", "+rooms.get(i).getRoomNumber());

                if (readCourse.get(i).getMondayVenue().equals(rooms.get(j).getRoomNumber())) {
                    //System.out.println(readCourse.get(i).getMondayVenue()+","+rooms.get(j).getRoomNumber());
                    roomMap.put(rooms.get(j), arr);
                }
                if (readCourse.get(i).getTuesdayVenue().equals(rooms.get(j).getRoomNumber())) {
                    //System.out.println(readCourse.get(i).getMondayVenue()+","+rooms.get(j).getRoomNumber());
                    roomMap.put(rooms.get(j), arr);
                }
                if (readCourse.get(i).getWednesdayVenue().equals(rooms.get(j).getRoomNumber())) {
                    roomMap.put(rooms.get(j), arr);
                }
                if (readCourse.get(i).getThursdayVenue().equals(rooms.get(j).getRoomNumber())) {
                    roomMap.put(rooms.get(j), arr);
                }
                if (readCourse.get(i).getFridayVenue().equals(rooms.get(j).getRoomNumber())) {
                    roomMap.put(rooms.get(j), arr);
                }
            }
        }
        for(int i = 1; i < readCourse.size(); i++) {
            if (!readCourse.get(i).getMondayTime().equals("-")) {
                int[] monday = returnCoordinatesToStore(readCourse.get(i).getMondayTime());

                //roomMap.get(rooms.get(i))[monday[0]][monday[1]] = 1;
                for(int j=monday[0];j<monday[1]+monday[0];j++){
                    roomMap.get(rooms.get(i))[0][j]=1;
                }

            }
            if (!readCourse.get(i).getTuesdayTime().equals("-")) {
                int[] tuesday = returnCoordinatesToStore(readCourse.get(i).getTuesdayTime());
                System.out.println(tuesday[0] + " "+ tuesday[1]);
                for(int j=tuesday[0];j<tuesday[1]+tuesday[0];j++){
                    roomMap.get(rooms.get(i))[1][j]=1;
                }
            }
            if (!readCourse.get(i).getWednesdayTime().equals("-")) {
                int[] wednesday = returnCoordinatesToStore(readCourse.get(i).getWednesdayTime());
                for(int j=wednesday[0];j<wednesday[1]+wednesday[0];j++){
                    roomMap.get(rooms.get(i))[2][j]=1;
                }
            }
            if (!readCourse.get(i).getThursdayTime().equals("-")) {
                int[] thursday = returnCoordinatesToStore(readCourse.get(i).getThursdayTime());
                for(int j=thursday[0];j<thursday[1]+thursday[0];j++){
                    roomMap.get(rooms.get(i))[3][j]=1;
                }
            }
            if (!readCourse.get(i).getFridayTime().equals("-")) {
                int[] friday = returnCoordinatesToStore(readCourse.get(i).getFridayTime());
                for(int j=friday[0];j<friday[1]+friday[0];j++){
                    roomMap.get(rooms.get(i))[4][j]=1;
                }
            }
        }

        System.out.println(roomMap.entrySet().size());
        for (Map.Entry<Room, int[][]> entry : roomMap.entrySet()) {
            System.out.println("Key " + entry.getKey());
            int a[][] = entry.getValue();
            for(int r = 0 ; r < 5; r++)
            {
                for (int j = 0; j < 18; j++)
                {
                    System.out.print(a[r][j]);
                }
                System.out.println();
            }
        }
    }
/** This function returns an array of two integers, the first integer being column number of starting time division.
 * The second integer number of time divisions the loop needs to iterate and store 1s there. */
        private static int[] returnCoordinatesToStore (String time)
        {
            System.out.println(time);
            int[] arr = new int[2];
            int posOfdash = time.indexOf("-");
            String startTime = time.substring(0, posOfdash);
            String endTime = time.substring(posOfdash + 1, time.length());
            //System.out.println(startTime+" "+endTime);
            int seperatorForStartTime = startTime.indexOf(":");
            int seperatorForEndTime = endTime.indexOf(":");
            //System.out.println(seperatorForStartTime+" "+seperatorForEndTime);
            String startTimeHour = startTime.substring(0, seperatorForStartTime);
            String startTimeMin = startTime.substring(seperatorForStartTime + 1, posOfdash);

            int startTime24;
            if((Integer.parseInt(startTimeHour) >= 1)&& (Integer.parseInt(startTimeHour) <= 6))
            {
                startTime24 = Integer.parseInt(startTimeHour) + 12;
            }
            else
            {
                startTime24 = Integer.parseInt(startTimeHour);
            }

            //System.out.println(startTimeHour+" "+startTimeMin);
            String endTimeHour = endTime.substring(0, seperatorForEndTime);
            String endTimeMin = endTime.substring(seperatorForEndTime + 1);

            int endTime24;
            if((Integer.parseInt(endTimeHour) >= 1)&& (Integer.parseInt(endTimeHour) <= 6))
            {
                endTime24 = Integer.parseInt(endTimeHour) + 12;
            }
            else
            {
                endTime24 = Integer.parseInt(endTimeHour);
            }

            //System.out.println("Start Time and End time" +startTime24+"##"+endTime24);

            //System.out.println(endTimeHour+" "+endTimeMin);
            arr[0] = (startTime24 - 9) * 2;   //VJR Algo
            if (startTimeMin.equals("30")) {
                arr[0] += 1;
            }

            arr[1] = (endTime24 - startTime24) * 2; //VJR ALGO
            if (Integer.parseInt(endTimeMin) - Integer.parseInt(startTimeMin) == 30) {
                arr[1] += 1;
            } else if (Integer.parseInt(endTimeMin) - Integer.parseInt(startTimeMin) == -30) {
                arr[1] -= 1;
            }
            return arr;
        }

    }

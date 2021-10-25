import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ClassRoomReserveSystem {
    static class Menu{
        public void printMenu(){
            System.out.println("==== 강의실 대여 및 인적사항 조회 ====");
            System.out.println("1. 전체 예약 현황 조회");
            System.out.println("2. 호실 예약 현황 조회");
            System.out.println("3. 예약하기 및 예약 취소하기");
            System.out.println("4. 나의 예약 조회");
            System.out.println("5. 학생 인적사항 변경");
            System.out.println("6. 교수 인적사항 조회");
            System.out.println("7. 종료");
        }
        public void printClassRooms(ArrayList<Reservation> reservations){
            for (Reservation reservation : reservations) {
                System.out.println(reservation.getRoomNum());
                System.out.println(reservation.getRoomCheckList(0));
                System.out.println(reservation.getRoomCheckList(1));
            }
        }
        public void printRoomCheck(ArrayList<Reservation> reservations, int roomNum){
            String res = null;

            for (Reservation reservation : reservations) {
                if (reservation.getRoomNum() == roomNum) {
                    res = reservation.getPossibleTime();
                    break;
                }
            }

            if(res == null){
                System.out.println("강의실 조회가 되지 않습니다.");
            }
            else{
                System.out.println(res);
            }
        }
        public void makeReservation(ArrayList<Student> students, ArrayList<Professor> professors, ArrayList<Reservation> reservations,
                                    String name, String id, String room, String time, String reason) throws IOException {
            int cnt = students.size();
            boolean student_check = false;
            for(int i = 0; i < cnt; i++) {
                if (students.get(i).getName().equals(name) && students.get(i).getStudentId().equals(id)) {
                    student_check = true;
                    break;
                }
            }

            boolean professor_check = false;
            if(!student_check) {
                cnt = professors.size();
                for (int i = 0; i < cnt; i++) {
                    if (professors.get(i).getName().equals(name) && professors.get(i).getProfessorId().equals(id)) {
                        professor_check = true;
                        break;
                    }
                }
            }

            cnt = reservations.size();
            boolean roomNum_check = false;
            boolean roomTime_check = false;
            for(int i = 0; i < cnt; i++){
                if(room.contains(Integer.toString(reservations.get(i).getRoomNum()))){
                    roomNum_check = true;

                    boolean time_check = false;
                    int tt = Integer.parseInt(String.valueOf(time.charAt(2)));
                    if(time.contains("오전")){
                        time_check = true;
                    }

                    tt *= 2;
                    tt--;
                    if(time_check) tt--;

                    if(reservations.get(i).getRoomCheck().get(tt).check){
                        roomTime_check = true;
                        reservations.get(i).setReservation(name, id, reason, tt);
                        break;
                    }
                }
            }

            if(student_check || professor_check && roomNum_check && roomTime_check){
                makeReservationFile(reservations);
                String res = room + " " + time + "에 예약되었습니다.";
                System.out.println(res);
            }

            else{
                System.out.println("예약 실패!");
            }
        }
        public void cancelReservation(ArrayList<Reservation> reservations,
                                      String name, String id, String room, String time) throws IOException {
            for (Reservation reservation : reservations) {
                if (room.contains(String.valueOf(reservation.getRoomNum()))) {
                    boolean time_check = false;
                    int tt = Integer.parseInt(String.valueOf(time.charAt(2)));
                    if (time.contains("오전")) {
                        time_check = true;
                    }

                    tt *= 2;
                    tt--;
                    if (time_check) tt--;

                    if (reservation.getRoomCheck().get(tt).name.equals(name) && reservation.getRoomCheck().get(tt).id.equals(id)
                            && !reservation.getRoomCheck().get(tt).check) {
                        reservation.cancelReservation(name, id, tt);
                        makeReservationFile(reservations);
                        System.out.println("예약이 취소되었습니다.");
                        break;
                    }
                }
            }
        }
        public void printReservationCheck(ArrayList<Reservation> reservations, String name, String id){
            boolean res = false;
            for(Reservation reservation : reservations){
                res = reservation.getReservationInfo(name, id);
            }

            if(!res){
                System.out.println("없는 예약입니다. 이름과 아이디를 다시 확인해주세요.");
            }
        }
        public void printStudents(ArrayList<Student> students){
            for (Student student : students){
                System.out.println(student.getFullInfo());
            }
        }
        public boolean checkStudentName(ArrayList<Student> students, String name){
            for(Student student : students){
                if(student.getName().equals(name)){
                    return true;
                }
            }
            return false;
        }
        public void changeStudentName(ArrayList<Student> students, String name, String changeName) throws IOException {
            for(Student student : students){
                if(student.getName().equals(name)){
                    student.setName(changeName);
                    break;
                }
            }
            System.out.println("이름 변경이 완료되었습니다.");
            makeStudentFile(students);
        }
        public void deleteStudentName(ArrayList<Student> students, String name) throws IOException {
            int cnt = students.size();
            for(int i = 0; i < cnt; i++){
                if(students.get(i).getName().equals(name)){
                    students.remove(i);
                    break;
                }
            }
            System.out.println("삭제되었습니다.");
            makeStudentFile(students);
        }
        public void printProfessors(ArrayList<Professor> professors){
            for (Professor professor : professors) {
                System.out.println(professor.getFullInfo());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ClassRoomReserveSystem.Menu menu = new Menu();
        ArrayList<Student> students;
        ArrayList<Professor> professors;
        ArrayList<Reservation> reservations;

        students = getStudents();
        professors = getProfessors();
        reservations = getReservations();

        Scanner sc = new Scanner(System.in);

        while(true){
            menu.printMenu();
            System.out.print(">>> ");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("[1. 전체 예약 현황 조회]");
                    menu.printClassRooms(reservations);
                    break;
                case 2:
                    System.out.println("[2. 호실 예약 현황 조회]");
                    System.out.print(">>> ");
                    int roomNum = sc.nextInt();
                    menu.printRoomCheck(reservations, roomNum);
                    break;
                case 3:
                    System.out.println("[3. 예약하기 및 취소하기]");
                    System.out.println("1. 예약하기");
                    System.out.println("2. 예약 취소하기");
                    System.out.print(">>> ");
                    int tmp = sc.nextInt();
                    switch (tmp){
                        case 1:
                            System.out.println("이름, 아이디, 호실 번호, 시간, 사유 입력");
                            System.out.print(">>> ");
                            String name = sc.next();
                            String id = sc.next();
                            String room = sc.next();
                            String time = sc.next();
                            String reason = sc.next();
                            menu.makeReservation(students, professors, reservations, name, id, room, time, reason);
                            break;
                        case 2:
                            System.out.println("이름, 아이디, 호실 번호, 시간 입력");
                            System.out.print(">>> ");
                            name = sc.next();
                            id = sc.next();
                            room = sc.next();
                            time = sc.next();
                            menu.cancelReservation(reservations, name, id, room, time);
                            break;
                        default:
                            System.out.println("입력이 잘못되었습니다. 상위 메뉴로 돌아갑니다.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("[4. 나의 예약조회]");
                    System.out.println("이름과 아이디(학번 또는 교직원번호)입력");
                    System.out.print(">>> ");
                    String name = sc.next();
                    String id = sc.next();
                    menu.printReservationCheck(reservations, name, id);
                    break;
                case 5:
                    System.out.println("[5. 학생 인적사항 변경]");
                    System.out.println("1. 인적사항 조회");
                    System.out.println("2. 이름 변경");
                    System.out.println("3. 학생 삭제");
                    System.out.print(">>> ");
                    tmp = sc.nextInt();
                    switch (tmp){
                        case 1:
                            System.out.println("1. 인적사항 조회");
                            menu.printStudents(students);
                            break;
                        case 2:
                            System.out.println("2. 이름 변경");
                            System.out.print(">>> ");
                            name = sc.next();
                            if(menu.checkStudentName(students, name)) {
                                System.out.println("어떤 이름으로 변경하시겠습니까?");
                                System.out.print(">>> ");
                                String changeName = sc.next();
                                menu.changeStudentName(students, name, changeName);
                                Collections.sort(students);
                            }
                            else{
                                System.out.println("없는 이름입니다. 다시 확인해주세요");
                            }
                            break;
                        case 3:
                            System.out.println("3. 학생 삭제");
                            System.out.print(">>> ");
                            name = sc.next();
                            if(menu.checkStudentName(students, name)) {
                                menu.deleteStudentName(students, name);
                            }
                            else{
                                System.out.println("없는 이름입니다. 다시 확인해주세요");
                            }
                            break;
                        default:
                            System.out.println("입력이 잘못되었습니다. 상위 메뉴로 돌아갑니다");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("[6. 교수 인적사항 조회]");
                    menu.printProfessors(professors);
                    break;
                case 7:
                    System.out.println("종료합니다!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("숫자를 다시 입력해주세요(범위 1 ~ 7)");
            }
        }
    }

    private static ArrayList<Student> getStudents() throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File("student.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        br.readLine();

        while((line = br.readLine()) != null){
            String[] temp = line.split(",");
            Student tmp = new Student(temp[0], temp[1], temp[2], temp[3]);
            students.add(tmp);
        }

        Collections.sort(students);
        return students;
    }

    private static ArrayList<Professor> getProfessors() throws IOException {
        ArrayList<Professor> professors = new ArrayList<>();
        File file = new File("professor.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        br.readLine();

        while((line = br.readLine()) != null){
            String[] temp = line.split(",");
            Professor tmp = new Professor(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]));
            professors.add(tmp);
        }

        Collections.sort(professors);
        return professors;
    }

    private static ArrayList<Reservation> getReservations() throws IOException {
        ArrayList<Reservation> reservations = new ArrayList<>();
        File file = new File("reservation.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        br.readLine();

        while((line = br.readLine()) != null){
            ArrayList<Reservation.roomCheck> checkLists = new ArrayList<>();
            String[] temp = line.split(",");
            for(int i = 1; i < temp.length; i++){
                Reservation.roomCheck roomCheck;
                boolean check = temp[i].equals("possible");
                roomCheck = new Reservation.roomCheck(null, null, check, null);

                checkLists.add(roomCheck);
            }

            Reservation tmp = new Reservation(Integer.parseInt(temp[0]), checkLists);

            reservations.add(tmp);
        }

        Collections.sort(reservations);
        return reservations;
    }

    private static void makeStudentFile(ArrayList<Student> students) throws IOException {
        String fname = "student.csv";
        File file = new File(fname);
        if(file.exists()){
            file.delete();
        }

        file = new File(fname);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String nl = System.lineSeparator();

        bw.write("name,department,studentId,phoneNum");
        bw.write(nl);

        for(Student student : students){
            bw.write(student.getName() + "," + student.getDepartment() + "," + student.getStudentId() + "," + student.getPhoneNum());
            bw.write(nl);
        }
        bw.flush();
        bw.close();
    }

    private static void makeReservationFile(ArrayList<Reservation> reservations) throws IOException {
        String fname = "reservation.csv";
        File file = new File(fname);
        if(file.exists()){
            file.delete();
        }

        file = new File(fname);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String nl = System.lineSeparator();

        bw.write("roomNum,6/1 a.m.,6/1 p.m.,6/2 a.m.,6/2 p.m.,6/3 a.m.,6/3 p.m.,6/4 a.m.,6/4 p.m.,6/5 a.m.,6/5 p.m.,6/6 a.m.,6/6 p.m.,6/7 a.m.,6/7 p.m.");
        bw.write(nl);

        for(Reservation reservation: reservations){
            bw.write(reservation.getRoomNum() + ",");

            StringBuilder str = new StringBuilder();
            for(Reservation.roomCheck rc : reservation.getRoomCheck()){
                if(rc.check){
                    str.append("possible,");
                }
                else{
                    str.append("impossible,");
                }
            }
            str = new StringBuilder(str.substring(0, str.length() - 1));
            bw.write(str.toString());
            bw.write(nl);
        }
        bw.flush();
        bw.close();
    }
}

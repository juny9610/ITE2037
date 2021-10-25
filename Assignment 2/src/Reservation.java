import java.util.ArrayList;

public class Reservation implements Comparable<Reservation>{
    public Reservation(int roomNum, ArrayList<roomCheck> checkLists){
        this.roomNum = roomNum;
        this.checkLists = checkLists;
    }
    @Override
    public int compareTo(Reservation reservation) {
        if(this.roomNum < reservation.roomNum) return -1;
        return 1;
    }

    public String getRoomCheckList(int ampm){
        StringBuilder str;

        if(ampm == 0) str = new StringBuilder("오전: ");
        else str = new StringBuilder("오후: ");
        boolean check = false;

        int cnt = this.checkLists.size();

        for(int i = ampm; i < cnt; i += 2){
            String res = "6/" + (i + 2) / 2;
            if(this.checkLists.get(i).check){
                str.append(res).append(", ");
                check = true;
            }
        }

        if(check) str = new StringBuilder(str.substring(0, str.length() - 2));
        return str.toString();
    }
    public String getPossibleTime(){
        StringBuilder str = new StringBuilder("가능한 시간: ");
        boolean check = false;

        int cnt = this.checkLists.size();

        for(int i = 0; i < cnt; i++){
            String res = "6/" + (i + 2) / 2;
            if(i % 2 == 0) res += "오전, ";
            else res += "오후, ";

            if(this.checkLists.get(i).check){
                str.append(res);
                check = true;
            }
        }

        if(check) str = new StringBuilder(str.substring(0, str.length() - 2));
        return str.toString();
    }
    public void setReservation(String name, String id, String reason, int idx){
        roomCheck tmp = new roomCheck(name, id, false, reason);
        this.checkLists.set(idx, tmp);
    }
    public void cancelReservation(String name, String id, int idx){
        roomCheck tmp = new roomCheck(null, null, true, null);
        this.checkLists.set(idx, tmp);
    }
    public boolean getReservationInfo(String name, String id){
        String res = null;
        ArrayList<Reservation.roomCheck> rcList = this.checkLists;
        int cnt = rcList.size();

        for(int i = 0; i < cnt; i++){
            if(name.equals(rcList.get(i).name) && id.equals(rcList.get(i).id)){
                res = "이름: " + rcList.get(i).name + ", "
                        + "아이디: " + rcList.get(i).id + ", "
                        + "호실번호: " + this.roomNum + ", ";
                String time = "6/" + (i + 2) / 2;
                if(i % 2 == 0) time += "오전";
                else time += "오후";

                res += time + ", " + "예약사유: " + checkLists.get(i).reason;

                System.out.println(res);
            }
        }

        return res != null;
    }
    public int getRoomNum() { return this.roomNum; }
    public ArrayList<roomCheck> getRoomCheck() { return this.checkLists; }

    public static class roomCheck {
        String name;
        String id;
        Boolean check;
        String reason;

        public roomCheck(String name, String id, boolean b, String reason) {
            this.name = name;
            this.id = id;
            this.check = b;
            this.reason = reason;
        }
    }
    private int roomNum;
    private ArrayList<roomCheck> checkLists;
}

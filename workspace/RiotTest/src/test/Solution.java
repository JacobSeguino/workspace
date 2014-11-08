package test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Skeleton for Interview Street coding challenge
 */
public class Solution {

    public static int computeMaxConcurrentLogins(List<LoginEvent> events) {
    	int count = 0;
     	int loc ;
        LoginType in = events.get(1).getType();
        LoginType out = events.get(2).getType();
        
         for(int i=0; i<events.size(); i++){
         	loc = i;
         	LoginEvent row = events.get(i);
            if(row.getType().equals(in)){
         		for(int j = loc+1; j <events.size(); j++){
         			LoginEvent moreRow = events.get(j);
         			if((row.getTimestamp() <= moreRow.getTimestamp()&& moreRow.getType().equals(in))){
         				LoginEvent nextRow = events.get(j+1);
         				if(nextRow.getTimestamp() <= row.getTimestamp()){
         					count++;
         				}
         				
         			}
         		}
            }
         }
         
         return count;
     }

    public enum LoginType {LOGIN, LOGOUT};

    public static class LoginEvent {
        private final LoginType type;
        private final long timestamp;

        public LoginEvent(LoginType type, long timestamp) {
            this.type = type;
            this.timestamp = timestamp;
        }

        public LoginType getType() {
            return type;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }


    public static void main(String [] args) throws IOException {
        List<LoginEvent> loginEvents = readEvents(System.in);
        System.out.println(computeMaxConcurrentLogins(loginEvents));
    }

    public static List<LoginEvent> readEvents(InputStream in) throws IOException {
        Scanner scanner = new Scanner(in);
        List<LoginEvent> loginEvents = new ArrayList<LoginEvent>();
        while (scanner.hasNext()) {
            LoginType login = Enum.valueOf(LoginType.class, scanner.next());
            long timestamp = scanner.nextLong();
            loginEvents.add(new LoginEvent(login, timestamp));
        }
        return loginEvents;
    }
}

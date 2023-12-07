import java.util.Random;

public class LeaveWithChaining {

    private static final Random random = new Random();

    public static void main(String[] args) {
        try {
            getLeave();
        } catch(NoLeaveGrantedException e) {
            e.printStackTrace();
        }
    }

    static void getLeave() throws NoLeaveGrantedException {
        try {
            workToBeDone();
            howIsTeamLead();
            System.out.println("Leave granted");
        } catch(Exception e) {
            throw new NoLeaveGrantedException("Leave not granted", e);
        }
    }

    static void howIsTeamLead() throws TeamLeadUpsetException {
        if(random.nextInt(3) == 0) {
            throw new TeamLeadUpsetException("Team lead is upset");
        }
    }

    static void workToBeDone() throws WorkToBeDoneException {
        if(random.nextInt(3) == 0) {
            throw new WorkToBeDoneException("Work to be done");
        }
    }

    static class NoLeaveGrantedException extends Exception {
        public NoLeaveGrantedException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class TeamLeadUpsetException extends Exception {
        public TeamLeadUpsetException(String message) {
            super(message);
        }
    }

    static class WorkToBeDoneException extends Exception {
        public WorkToBeDoneException(String message) {
            super(message);
        }
    }
}

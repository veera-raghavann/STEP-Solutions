import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class ClubStudent {
    private final String rollNumber;
    private final String name;

    public ClubStudent(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ClubStudent)) {
            return false;
        }

        ClubStudent other = (ClubStudent) object;
        return rollNumber.equals(other.rollNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }

    public String getRollNumber() {
        return rollNumber;
    }
}

public class StudentClubRegistrationManagement {
    public static void main(String[] args) {
        Set<ClubStudent> members = new HashSet<>();

        add(members, new ClubStudent("21CS01", "Asha"));
        add(members, new ClubStudent("21CS01", "Asha"));
        add(members, new ClubStudent("21CS02", "Ravi"));

        System.out.println("member count " + members.size());
        contains(members, new ClubStudent("21CS02", "Ravi"));
        contains(members, new ClubStudent("21CS03", "Priya"));
    }

    private static void add(Set<ClubStudent> members, ClubStudent student) {
        System.out.println(members.add(student) ? "Added" : "duplicate rejected");
    }

    private static void contains(Set<ClubStudent> members, ClubStudent student) {
        System.out.println("contains: " + members.contains(student));
    }
}

// Hash-set add/contains: O(1) average; O(n) storage.

public class FitZoneMembershipDesk {
    interface MembershipPlan {
        double calculateFee();
        String getName();
    }

    static class MonthlyPlan implements MembershipPlan {
        public double calculateFee() { return 1000; }
        public String getName() { return "Monthly"; }
    }

    static class QuarterlyPlan implements MembershipPlan {
        public double calculateFee() { return 1000 * 3 * 0.90; }
        public String getName() { return "Quarterly"; }
    }

    static class AnnualPlan implements MembershipPlan {
        public double calculateFee() { return 1000 * 12 * 0.75; }
        public String getName() { return "Annual"; }
    }

    enum Status { ACTIVE, FROZEN, EXPIRED }

    static class Member {
        private final String name;
        Member(String name) { this.name = name; }
    }

    static class Membership {
        private final Member member;
        private final MembershipPlan plan;
        private Status status = Status.ACTIVE;

        Membership(Member member, MembershipPlan plan) {
            this.member = member; this.plan = plan;
            System.out.printf("%s membership created for %s. Fee: ₹%.2f. Status: Active.%n",
                    plan.getName(), member.name, plan.calculateFee());
        }

        void checkIn() {
            if (status == Status.ACTIVE) System.out.println(member.name + " checked in successfully.");
            else System.out.println("Check-in denied: " + member.name + "'s membership is " + status + ".");
        }

        void freeze() {
            if (status != Status.ACTIVE) {
                System.out.println("Cannot freeze an " + status + " membership.");
                return;
            }
            status = Status.FROZEN;
            System.out.println(member.name + "'s membership frozen. Status: Frozen.");
        }

        void unfreeze() {
            if (status != Status.FROZEN) {
                System.out.println("Cannot unfreeze an " + status + " membership.");
                return;
            }
            status = Status.ACTIVE;
            System.out.println(member.name + "'s membership unfrozen. Status: Active.");
        }

        void expire() {
            status = Status.EXPIRED;
            System.out.println(member.name + "'s membership expired. Status: Expired.");
        }
    }

    public static void main(String[] args) {
        Membership asha = new Membership(new Member("Asha"), new QuarterlyPlan());
        Membership ravi = new Membership(new Member("Ravi"), new MonthlyPlan());
        asha.checkIn();
        asha.freeze();
        asha.checkIn();
        ravi.expire();
        ravi.freeze();
    }
}

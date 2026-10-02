public class FitZoneMembershipDesk {

    interface MembershipPlan {
        double calculateFee();
        String getName();
    }

    static class MonthlyPlan implements MembershipPlan {
        public double calculateFee() {
            return 1000;
        }

        public String getName() {
            return "Monthly";
        }
    }

    static class QuarterlyPlan implements MembershipPlan {
        public double calculateFee() {
            return 2700;
        }

        public String getName() {
            return "Quarterly";
        }
    }

    static class AnnualPlan implements MembershipPlan {
        public double calculateFee() {
            return 9000;
        }

        public String getName() {
            return "Annual";
        }
    }

    enum Status {
        ACTIVE,
        FROZEN,
        EXPIRED
    }

    static class Membership {
        String name;
        MembershipPlan plan;
        Status status = Status.ACTIVE;

        Membership(String name, MembershipPlan plan) {
            this.name = name;
            this.plan = plan;

            System.out.printf(
                "%s membership created for %s. Fee: ₹%.2f. Status: Active.%n",
                plan.getName(),
                name,
                plan.calculateFee()
            );
        }

        void checkIn() {
            if (status == Status.ACTIVE) {
                System.out.println(name + " checked in successfully.");
            } else {
                System.out.println(
                    "Check-in denied: " + name + "'s membership is " + status + "."
                );
            }
        }

        void freeze() {
            if (status == Status.ACTIVE) {
                status = Status.FROZEN;
                System.out.println(
                    name + "'s membership frozen. Status: Frozen."
                );
            }
        }

        void unfreeze() {
            if (status == Status.FROZEN) {
                status = Status.ACTIVE;
                System.out.println(
                    name + "'s membership unfrozen. Status: Active."
                );
            }
        }

        void expire() {
            status = Status.EXPIRED;
            System.out.println(
                name + "'s membership expired. Status: Expired."
            );
        }
    }

    public static void main(String[] args) {
        Membership membership = new Membership(
            "Asha",
            new QuarterlyPlan()
        );

        membership.checkIn();
        membership.freeze();
        membership.checkIn();
        membership.unfreeze();
        membership.checkIn();
    }
}

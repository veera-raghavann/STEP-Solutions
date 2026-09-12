public class LibraryMemberJavaBean {
    private String membershipId;
    private String securityAnswerHash;

    public LibraryMemberJavaBean() {
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }

    public void setSecurityAnswer(String answer) {
        securityAnswerHash = Integer.toHexString(answer.hashCode());
    }

    public static void main(String[] a) {
        LibraryMemberJavaBean m = new LibraryMemberJavaBean();
        m.setMembershipId("LIB-1");
        m.setMembershipId("LIB-2");
        m.setSecurityAnswer("BlueMountain");
        System.out.println(m.getMembershipId());
    }
}

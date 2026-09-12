public class MovieBookingProfile {
    private String name;
    private String otpHash;

    public MovieBookingProfile() {
        this("");
    }

    public MovieBookingProfile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOtp(String otp) {
        otpHash = Integer.toHexString(otp.hashCode());
    }

    public static void main(String[] a) {
        MovieBookingProfile p = new MovieBookingProfile("Asha");
        p.setOtp("1234");
        System.out.println(p.getName());
    }
}

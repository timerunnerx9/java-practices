public class PhoneNumberFormatter {
    public static void main(String[] args) {
        Data data = new Data(334144,3);
        getPhoneNumber(data);


    }
    public static void getPhoneNumber(Data data) {
        String number = String.format("%010d",data.getPhoneNumber());
        System.out.println("+"+data.getCountryCode()+"("+number.substring(0,3)+")"+number.substring(3,6)+"-"+number.substring(6,8)
                +"-"+number.substring(8,10));
        System.out.println("+" + data.getCountryCode() + number.replaceFirst("(.{3})(.{3})(.{2})(.{2})", "($1)$2-$3-$4"));
    }


    public static class Data{
        int phoneNumber;
        int countryCode;

        public Data(int phoneNumber, int countryCode){
            this.phoneNumber = phoneNumber;
            this.countryCode = countryCode;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public int getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(int countryCode) {
            this.countryCode = countryCode;
        }
    }
}

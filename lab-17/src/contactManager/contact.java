package contactManager;

public class contact implements Displayable {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public contact(String id, String name, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Static method helper
    public static boolean hasPhone(contact c, String phone) {
        return c.getPhone().equalsIgnoreCase(phone);
    }

    // Getter/Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void display() {
        System.out.println("ID: " + id + " | Ten: " + name + " | SĐT: " + phone +
                " | Email: " + email + " | Dia chi: " + address);
    }
}

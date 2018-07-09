package co.ppk.domain;

public class Customer {

    private final String id;
    private final String identification;
    private final String name;
    private final String lastName;
    private final String email;
    private final String address;
    private final String phone;
    private final String type;
    private final String status;
    private final String createDate;
    private final String updateDate;

    private Customer(
            String id,
            String identification,
            String name,
            String lastName,
            String email,
            String address,
            String phone,
            String type,
            String status,
            String createDate,
            String updateDate) {
        this.id = id;
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getId() { return id; }

    public String getIdentification() { return identification; }

    public String getName() { return name; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public String getAddress() { return address; }

    public String getPhone() { return phone; }

    public String getType() { return type; }

    public String getStatus() { return status; }

    public String getCreateDate() { return createDate; }

    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private String id;
        private String identification;
        private String name;
        private String lastName;
        private String email;
        private String address;
        private String phone;
        private String type;
        private String status;
        private String createDate;
        private String updateDate;

        public Customer.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Customer.Builder setIdentification(String identification) {
            this.identification = identification;
            return this;
        }

        public Customer.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Customer.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Customer.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Customer.Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Customer.Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer.Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Customer.Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Customer.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Customer.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Customer build() {
            return new Customer(id, identification, name, lastName, email, address, phone, type, status, createDate, updateDate);
        }
    }
}

package co.ppk.domain;

public class Faceplate {

    private final String id;
    private final String faceplate;
    private final String customerid;
     private final String createDate;
    private final String updateDate;

    private Faceplate(
            String id,
            String faceplate,
            String customerid,
            String createDate,
            String updateDate) {
        this.id = id;
        this.faceplate = faceplate;
        this.customerid = customerid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getId() { return id; }

    public String getFaceplate() { return faceplate; }

    public String getCustomerid() { return customerid; }

    public String getCreateDate() { return createDate; }

    public String getUpdateDate() { return updateDate; }

    public static class Builder {
        private String id;
        private String faceplate;
        private String customerid;
        private String createDate;
        private String updateDate;

        public Faceplate.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Faceplate.Builder setFaceplate(String faceplate) {
            this.faceplate = faceplate;
            return this;
        }

        public Faceplate.Builder setCustomerid(String customerid) {
            this.customerid = customerid;
            return this;
        }


        public Faceplate.Builder setCreateDate(String createDate) {
            this.createDate = createDate;
            return this;
        }

        public Faceplate.Builder setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Faceplate build() {
            return new Faceplate(id, faceplate, customerid, createDate, updateDate);
        }
    }
}

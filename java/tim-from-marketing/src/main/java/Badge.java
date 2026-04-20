class Badge {
    private int employeeId;
    private String name;
    private String department;

    public Badge() {}

    public String print(Integer id, String name, String department) {
        this.employeeId = id != null ? id : 0;
        this.name = name;
        this.department = department != null ? department : "OWNER";

        if (employeeId != 0) {
            return String.format("[%d] - %s - %s", employeeId, this.name, this.department.toUpperCase());
        } else {
            return String.format("%s - %s", this.name, this.department.toUpperCase());
        }

    }
    
}

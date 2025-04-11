class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, long nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Username: " + username);
    }
}
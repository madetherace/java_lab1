package entity;

public class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String creditCardNumber;
    private double debit;
    private double credit;
    private double localCallTime;
    private double longDistanceCallTime;

    public Phone(int id, String lastName, String firstName, String patronymic, String address, String creditCardNumber, double debit, double credit, double localCallTime, double longDistanceCallTime) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.localCallTime = localCallTime;
        this.longDistanceCallTime = longDistanceCallTime;
    }

    // Getters
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }
    public String getAddress() { return address; }
    public String getCreditCardNumber() { return creditCardNumber; }
    public double getDebit() { return debit; }
    public double getCredit() { return credit; }
    public double getLocalCallTime() { return localCallTime; }
    public double getLongDistanceCallTime() { return longDistanceCallTime; }


    @Override
    public String toString() {
        return "ID: " + id + ", Фамилия: " + lastName + ", Имя: " + firstName + ", Отчество: " + patronymic +
                ", Адрес: " + address + ", Номер карты: " + creditCardNumber + ", Дебет: " + debit +
                ", Кредит: " + credit + ", Городские разговоры: " + localCallTime +
                ", Междугородние разговоры: " + longDistanceCallTime;
    }
}
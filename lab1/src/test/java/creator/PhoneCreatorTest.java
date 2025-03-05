package creator;


import entity.Phone;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhoneCreatorTest {

    private static final int ID = 1;
    private static final String LAST_NAME = "Иванов";
    private static final String FIRST_NAME = "Иван";
    private static final String PATRONYMIC = "Иванович";
    private static final String ADDRESS = "ул. Ленина, 1";
    private static final String CREDIT_CARD_NUMBER = "1234567890123456";
    private static final double DEBIT = 100.0;
    private static final double CREDIT = 50.0;
    private static final double LOCAL_CALL_TIME = 20.0;
    private static final double LONG_DISTANCE_CALL_TIME = 5.0;


    @Test
    public void testCreatePhoneValidData() {
        // Arrange
        PhoneCreator creator = new PhoneCreator();

        // Act
        Phone phone = creator.createPhone(ID, LAST_NAME, FIRST_NAME, PATRONYMIC, ADDRESS,
                CREDIT_CARD_NUMBER, DEBIT, CREDIT,
                LOCAL_CALL_TIME, LONG_DISTANCE_CALL_TIME);

        // Assert
        Assert.assertEquals(phone.getId(),ID);
        Assert.assertEquals(phone.getLastName(),LAST_NAME);
        Assert.assertEquals(phone.getFirstName(),FIRST_NAME);
        Assert.assertEquals(phone.getPatronymic(),PATRONYMIC);
        Assert.assertEquals(phone.getAddress(),ADDRESS);
        Assert.assertEquals(phone.getCreditCardNumber(),CREDIT_CARD_NUMBER);
        Assert.assertEquals(phone.getDebit(),DEBIT);
        Assert.assertEquals(phone.getCredit(),CREDIT);
        Assert.assertEquals(phone.getLocalCallTime(),LOCAL_CALL_TIME);
        Assert.assertEquals(phone.getLongDistanceCallTime(),LONG_DISTANCE_CALL_TIME);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreatePhoneInvalidData() {
        PhoneCreator creator = new PhoneCreator();
        creator.createPhone(-1, "", "", "", "", "invalid", -1, -1, -1, -1);
    }
}

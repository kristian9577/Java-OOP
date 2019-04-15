import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtTests {

    private Database db;

    @Before
    public void createDatabase() throws OperationNotSupportedException {
        this.db = new Database(new Person(1, "PESHO"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowExceptionWithNullParam() throws OperationNotSupportedException {

        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameCantFindPersonWithGivenUsername() throws OperationNotSupportedException {
        db.findByUsername("PEPI");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameFindMoreThanOneResult() throws OperationNotSupportedException {
        db.add(new Person(12, "PESHO"));
        db.findByUsername("PESHO");
    }

    @Test
    public void findByUsernameReturnsCorrectAnswer() throws OperationNotSupportedException {
        Person p = db.findByUsername("PESHO");
        Assert.assertEquals("PESHO", p.getUsername());
    }
}

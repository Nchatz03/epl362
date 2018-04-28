package JunitTest;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

public class UserAuthenticationTest {

	@Test
	public final void testFindUserType()  {
		try {
			UserAuthentication a = new UserAuthImpl();
			String username = "test";
			String password = "test";
			assertNotNull(a.findUserType(username, password));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

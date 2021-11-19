package gumtreeAPITest;

import com.intuit.karate.junit5.Karate;


class APITest {

	@Karate.Test
    Karate testAPI() {
		return Karate.run("APITest").relativeTo(getClass());
    }

}

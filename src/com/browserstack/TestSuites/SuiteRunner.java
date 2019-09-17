package com.browserstack.TestSuites;


import com.browserstack.Tests.TestFlightsFinder;
import com.browserstack.Tests.TestLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestLogin.class,
        TestFlightsFinder.class
})

public class SuiteRunner {

}



package com.testerum;

import com.testerum.runner.junit5.TesterumJunitTestFactory;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

public class JunitTesterumTests {

    @TestFactory
    public List<DynamicNode> testerumTestsFactory() {
        return new TesterumJunitTestFactory("tests")
                .packagesToScan(Arrays.asList(
                        "custom"
                ))
                .getTests();
    }
}

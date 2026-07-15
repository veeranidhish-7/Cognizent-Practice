package com.example.model;

/**
 * A service class that depends on {@link ExternalApi}. In the Mockito
 * exercises, ExternalApi is mocked so that MyService can be tested in
 * isolation without calling any real external system.
 */
public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /** Exercise 1 & 2: simple delegation, used for mocking/stubbing and verifying interactions. */
    public String fetchData() {
        return externalApi.getData();
    }

    /** Exercise 3: delegates with a specific argument, used for argument matching. */
    public String fetchDataFor(String userId) {
        externalApi.performAction("lookup:" + userId);
        return externalApi.getData();
    }

    /** Exercise 4 & 7: delegates to a void method, used for void-method stubbing/exceptions. */
    public void triggerAction() {
        externalApi.performAction();
    }

    /** Exercise 5: calls getData() multiple times, used for consecutive-return stubbing. */
    public String fetchDataThreeTimes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(externalApi.getData());
        }
        return sb.toString();
    }

    /** Exercise 6: calls methods in a specific order, used for verifying interaction order. */
    public void performOrderedActions() {
        externalApi.performAction();
        externalApi.getData();
        externalApi.performAction("done");
    }
}

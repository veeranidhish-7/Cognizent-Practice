package com.example.mockito;

import com.example.model.ExternalApi;
import com.example.model.MyService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Exercise 1: Mocking and Stubbing.
 * Mocks the ExternalApi dependency and stubs its getData() method to
 * return a predefined value, then verifies MyService returns that value.
 */
public class Exercise1_MockingAndStubbingTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }
}

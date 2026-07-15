package com.example.mockito;

import com.example.model.ExternalApi;
import com.example.model.MyService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Exercise 5: Mocking and Stubbing with Multiple Returns.
 * Stubs a method to return different values on consecutive calls.
 */
public class Exercise5_MultipleReturnsTest {

    @Test
    public void testMultipleReturns() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the method to return different values on consecutive calls
        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second")
                .thenReturn("Third");

        // 3. Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchDataThreeTimes();

        assertEquals("FirstSecondThird", result);
    }
}

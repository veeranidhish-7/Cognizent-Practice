package com.example.mockito;

import com.example.model.ExternalApi;
import com.example.model.MyService;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Exercise 3: Argument Matching.
 * Uses Mockito argument matchers to verify a method was called with
 * arguments matching a certain pattern, rather than an exact value.
 */
public class Exercise3_ArgumentMatchingTest {

    @Test
    public void testArgumentMatching() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("user data");

        MyService service = new MyService(mockApi);

        // 2. Call the method with specific arguments
        service.fetchDataFor("user123");

        // 3. Use argument matchers to verify the interaction
        verify(mockApi).performAction(eq("lookup:user123"));
        verify(mockApi).performAction(contains("user123"));
        verify(mockApi).performAction(anyString());
    }
}

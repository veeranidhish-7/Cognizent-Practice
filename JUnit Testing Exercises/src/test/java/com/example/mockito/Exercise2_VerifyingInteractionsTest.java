package com.example.mockito;

import com.example.model.ExternalApi;
import com.example.model.MyService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Exercise 2: Verifying Interactions.
 * Confirms that a mocked method was actually called (and how many times).
 */
public class Exercise2_VerifyingInteractionsTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Call the method with specific arguments
        service.fetchData();

        // 3. Verify the interaction happened exactly once
        verify(mockApi).getData();
        verify(mockApi, times(1)).getData();
    }
}

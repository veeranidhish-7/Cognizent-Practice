package com.example.mockito;

import com.example.model.ExternalApi;
import com.example.model.MyService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Exercise 7: Handling Void Methods with Exceptions.
 * Stubs a void method to throw an exception when called, and verifies
 * that the exception propagates and the mock was still invoked.
 */
public class Exercise7_VoidMethodsWithExceptionsTest {

    @Test
    public void testVoidMethodThrowsException() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the void method to throw an exception
        doThrow(new RuntimeException("External API failure"))
                .when(mockApi).performAction();

        MyService service = new MyService(mockApi);

        // 3. Verify the interaction / exception behavior
        assertThrows(RuntimeException.class, service::triggerAction);
        verify(mockApi).performAction();
    }
}

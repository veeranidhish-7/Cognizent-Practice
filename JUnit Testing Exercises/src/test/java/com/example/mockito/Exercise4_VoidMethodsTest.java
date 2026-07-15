package com.example.mockito;

import com.example.model.ExternalApi;
import com.example.model.MyService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Exercise 4: Handling Void Methods.
 * Void methods can't be stubbed with when(...).thenReturn(...), so Mockito
 * provides doNothing()/doThrow()/doAnswer() for stubbing them instead.
 */
public class Exercise4_VoidMethodsTest {

    @Test
    public void testVoidMethod() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the void method (doNothing is actually the default behavior,
        //    but it's shown explicitly here for clarity)
        doNothing().when(mockApi).performAction();

        MyService service = new MyService(mockApi);
        service.triggerAction();

        // 3. Verify the interaction
        verify(mockApi).performAction();
    }
}

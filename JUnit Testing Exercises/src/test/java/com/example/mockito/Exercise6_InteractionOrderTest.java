package com.example.mockito;

import com.example.model.ExternalApi;
import com.example.model.MyService;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * Exercise 6: Verifying Interaction Order.
 * Uses Mockito's InOrder API to confirm that methods on a mock were
 * called in a specific sequence.
 */
public class Exercise6_InteractionOrderTest {

    @Test
    public void testInteractionOrder() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // 2. Call the methods in a specific order
        service.performOrderedActions();

        // 3. Verify the interaction order
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).performAction();
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).performAction("done");
    }
}

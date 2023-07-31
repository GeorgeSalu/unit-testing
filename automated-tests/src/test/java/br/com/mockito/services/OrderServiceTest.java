package br.com.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class OrderServiceTest {
	
    private final OrderService cut = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");

    @Test
    void shouldIncludeRandomOrderIdWhenNoParentOrderExists() {

        try (MockedStatic<UUID> mockedUuid = Mockito.mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            Order result = cut.createOrder("MacBook Pro", 2L, null);

            assertEquals("8d8b30e3-de52-4f1c-a71c-9905a8043dac", result.getId());
        }
    }

}

package ru.shop.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.model.ProductReturn;
import ru.shop.repository.ProductReturnRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductReturnServiceTest {
    private final ProductReturnRepository repository = Mockito.mock();
    private final ProductReturnService productReturnService = new ProductReturnService(repository);

    @Test
    void testFindAll() {
        List<ProductReturn> productReturn = new ArrayList<>();

        repository.findAll();
        Mockito.when(repository.findAll()).thenReturn(productReturn);

        List<ProductReturn> result = productReturnService.findAll();

        assertEquals(productReturn, result);
    }

    @Test
    void shouldGetProductReturn() {
        UUID id = UUID.randomUUID();
        ProductReturn productReturn = new ProductReturn();

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(productReturn));

        ProductReturn result = productReturnService.getById(id);

        assertEquals(productReturn, result);
    }
/*
    @Test
    public void shouldSaveProductReturn() {

        ProductReturn productReturn = new ProductReturn();

        productReturnService.add(productReturn);

        Mockito.verify(repository).save(productReturn);
    }*/

    @Test
    public void shouldThrowWhenProductReturnNotFound() {
        // then
        assertThatThrownBy(() -> productReturnService.getById(UUID.randomUUID())).isInstanceOf(EntityNotFoundException.class);
    }

}



package com.endava.store.storepets.service;

import com.endava.store.storepets.model.CategoryModel;
import com.endava.store.storepets.testData.CategoryData;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GenericServiceTest {
    @InjectMocks
    private GenericService genericService;
    @Mock
    private JpaRepository jpaRepository;

    List<CategoryModel> listModel;

    @Before
    public void setUp(){
        listModel = CategoryData.getCategoriesModel();
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void testWhenEntityServiceDoesNotExistExceptionIsThrown() throws NotFoundException {
        exceptionRule.expect(NotFoundException.class);
        exceptionRule.expectMessage("The Category was not found!");
        Mockito.when(jpaRepository.existsById(listModel.get(1).getId())).thenReturn(false);
        genericService.exist(jpaRepository,listModel.get(1).getId(),"Category");
    }

    @Test
    public void testDelete() throws NotFoundException {
        Mockito.when(jpaRepository.existsById(listModel.get(1).getId())).thenReturn(true);
        genericService.delete(jpaRepository,listModel.get(1).getId(),"Category");

        verify(jpaRepository, times(1)).deleteById(listModel.get(1).getId());

    }
}
package com.testprojg.testproja.ControllerTest;

import com.testprojg.testproja.Entity.Person;
import com.testprojg.testproja.Service.TestService;
import com.testprojg.testproja.controller.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    private TestService testService;

    @InjectMocks
    private Test personController;

    @org.junit.jupiter.api.Test
    void addPerson_shouldSavePerson_andReturnSaved() {

        String name = "Arya";

        when(testService.savePerson(any(Person.class)))
                .thenReturn(new Person(name));   // 👈 return something

        String response = personController.addPerson(name);

        assertEquals("Saved!", response);

        verify(testService, times(1))
                .savePerson(any(Person.class));
    }

}


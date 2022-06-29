package br.com.systemsgs.service;

import br.com.systemsgs.domain.ModelUser;
import br.com.systemsgs.dto.ModelUserDTO;
import br.com.systemsgs.exception.DataIntegratyViolationException;
import br.com.systemsgs.exception.ObjectNotFoundException;
import br.com.systemsgs.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NAME = "Guilherme";
    public static final String EMAIL = "gui@gmail.com";
    public static final String PASSWORD = "123";
    public static final int INDEX = 0;

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    private ModelUser user;

    private ModelUserDTO userDTO;

    private Optional<ModelUser> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        ModelUser response = service.findById(ID);

        assertNotNull(response);
        assertEquals(ModelUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não Encontrado!"));
        try{
            service.findById(ID);
        }catch(Exception exception){
            assertEquals(ObjectNotFoundException.class, exception.getClass());
            assertEquals("Objeto não Encontrado!", exception.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnAnListOfUsers() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<ModelUser> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(ModelUser.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
        assertEquals(PASSWORD, response.get(INDEX).getPassword());
    }

    @Test
    void whenCreateThenReturnSucess() {
        when(repository.save(any())).thenReturn(user);

        ModelUser response = service.create(userDTO);

        assertNotNull(response);
        assertEquals(ModelUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void whenCreateThenReturnAnyDataIntegratyViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            optionalUser.get().setId(2);
            service.create(userDTO);
        }catch(Exception exception){
            assertEquals(DataIntegratyViolationException.class, exception.getClass());
            assertEquals("E-mail já cadastrado no sistema", exception.getMessage());
        }
    }

    @Test
    void whenUpdateThenReturnSucess() {
        when(repository.save(any())).thenReturn(user);

        ModelUser response = service.update(userDTO);

        assertNotNull(response);
        assertEquals(ModelUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new ModelUser(ID, NAME, EMAIL, PASSWORD);
        userDTO = new ModelUserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new ModelUser(ID, NAME, EMAIL, PASSWORD));
    }

}
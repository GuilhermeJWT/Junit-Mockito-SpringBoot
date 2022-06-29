package br.com.systemsgs.controller;

import br.com.systemsgs.domain.ModelUser;
import br.com.systemsgs.dto.ModelUserDTO;
import br.com.systemsgs.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    public static final Integer ID = 1;
    public static final String NAME = "Guilherme";
    public static final String EMAIL = "gui@gmail.com";
    public static final String PASSWORD = "123";

    private ModelUser user;
    private ModelUserDTO userDTO;

    @InjectMocks
    private UserController controller;

    @Mock
    private UserService service;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
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
    }

}
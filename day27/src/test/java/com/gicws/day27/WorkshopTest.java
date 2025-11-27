package com.gicws.day27;



import com.gicws.day27.Controller.RestApiController;
import com.gicws.day27.Service.SingletonService;
import com.gicws.day27.Service.UserService;
import com.gicws.day27.Validator.UserForm;
import com.gicws.day27.Validator.UserFormValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WorkshopTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    /*
     * Q1: POST Mapping
     */
    @Test
    void testPostMapping() throws Exception {
        mockMvc.perform(post("/form/submit"))
                .andExpect(status().isOk());
    }

    /*
     * Q2: Constructor Injection
     */
    @Test
    void testConstructorInjection() {
        UserService service = context.getBean(UserService.class);
        assertThat(service).isNotNull();
    }

    /*
     * Q3: Component Scan (bean exists)
     */
    @Test
    void testComponentScan() {
        assertThat(context.containsBean("userRepository")).isTrue();
    }

    /*
     * Q4: Custom Validator Implements Validator
     */
    @Test
    void testCustomValidator() {
        UserFormValidator validator = context.getBean(UserFormValidator.class);
        UserForm form = new UserForm();
        form.setEmail("invalidEmail");

        Errors errors = new BeanPropertyBindingResult(form, "userForm");
        validator.validate(form, errors);

        assertThat(errors.hasErrors()).isTrue();
    }

    /*
     * Q5: Custom Property Loaded from application.properties
     */
    @Test
    void testCustomProperty() {
        String title = context.getEnvironment().getProperty("app.title");
        assertThat(title).isEqualTo("Spring Quiz Demo Project");
    }

    /*
     * Q6: REST Controller
     */
    @Test
    void testRestControllerExists() {
        RestApiController controller = context.getBean(RestApiController.class);
        assertThat(controller).isNotNull();
    }

    /*
     * Q7: @Bean Injection (DataSource → JdbcTemplate)
     */
    @Test
    void testBeanInjection() {
        DataSource ds = context.getBean(DataSource.class);
        JdbcTemplate template = context.getBean(JdbcTemplate.class);

        assertThat(ds).isNotNull();
        assertThat(template).isNotNull();
    }

    /*
     * Q8: Global Exception Handler (@ControllerAdvice)
     * (We test indirectly by triggering an error)
     */
    @Test
    void testGlobalExceptionHandler() throws Exception {
        // Force null pointer by posting empty form
        mockMvc.perform(post("/form/submit"))
                .andExpect(status().isOk()); // Exception is handled globally
    }

    /*
     * Q9: Singleton Scope
     */
    @Test
    void testSingletonScope() {
        SingletonService s1 = context.getBean(SingletonService.class);
        SingletonService s2 = context.getBean(SingletonService.class);

        assertThat(s1).isSameAs(s2); // same instance = singleton
    }

    /*
     * Q10: Auto-Config Conditions Endpoint Exists
     */
    @Test
    void testActuatorConditionsEndpointExists() {
        assertThat(context.containsBean("endpointConditions")).isTrue();
    }
}

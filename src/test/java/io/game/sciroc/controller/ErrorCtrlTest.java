package io.game.sciroc.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MimeTypeUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.controller
 * USER      : sean
 * DATE      : 19-Wed-Sep-2018
 * TIME      : 21:59
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = {ErrorCtrl.class})
public class ErrorCtrlTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorCtrlTest.class);

    @Autowired
    private ErrorCtrl errorCtrl;

    private MockMvc mockMvc;

    @AfterClass
    public static void tearDown() throws Exception {
        LOGGER.info("completed {} execution...", ErrorCtrlTest.class.getSimpleName());
    }

    @Before
    public void setUp() throws Exception {
        LOGGER.info("setup...");
        mockMvc = MockMvcBuilders
                .standaloneSetup(errorCtrl)
                .build();
    }

    @After
    public void teardown() {
        LOGGER.info("completed...");
        mockMvc = null;
    }

    @Test
    public void getMapping_invalid_shouldReturnClientError() throws Exception {
        final ResultActions result = mockMvc.perform(
                get("/error-does-not-exist")
                        .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        result.andExpect(status().is4xxClientError());

    }

    @Test
    public void getMapping_valid_shouldReturnSuccessful() throws Exception {
        final ResultActions result = mockMvc.perform(
                get("/error")
                        .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        result.andExpect(status().is2xxSuccessful());
        result.andExpect(view().name("404"));
    }

//    @Test
//    public void getLanguages_null_shouldReturnOk() throws Exception {
    // Given
    // Real application context

    // When
//        final ResultActions result = mockMvc.perform(
//                get("/api/languages")
//                        .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));
//
//        // Then
//        final int expectedSize = LANGUAGES.size();
//        final String[] expectedLanguageNames = LANGUAGES.stream().map(Language::getName)
//                .collect(Collectors.toList()).toArray(new String[LANGUAGES.size()]);
//        result.andExpect(status().isOk());
//        result.andExpect(jsonPath("$.length()").value(expectedSize));
//        result.andExpect(jsonPath("$[*].name", containsInAnyOrder(expectedLanguageNames)));
//    }
}
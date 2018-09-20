package io.game.sciroc.controller;

import org.junit.After;
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
 * TIME      : 22:48
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
//@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {HomeCtrl.class})
public class HomeCtrlTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeCtrl.class);
    @Autowired
    private HomeCtrl homeCtrl;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        LOGGER.info("setup...");
        mockMvc = MockMvcBuilders
                .standaloneSetup(homeCtrl)
                .build();
    }

    @After
    public void tearDown() throws Exception {
        mockMvc = null;
    }

    @Test
    public void getHome_valid_shouldReturn_ModelAndView() throws Exception {
        final ResultActions result = mockMvc.perform(
                get("/")
                        .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));
        result.andExpect(status().is2xxSuccessful());
        result.andExpect(view().name("home"));
    }
}
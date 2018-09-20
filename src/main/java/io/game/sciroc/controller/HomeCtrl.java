package io.game.sciroc.controller;

import io.game.sciroc.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static java.lang.Boolean.FALSE;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.controller
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 14:06
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@RestController
@RequestMapping("/")
public class HomeCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeCtrl.class);

    @GetMapping("/")
    public ModelAndView homePage(HttpServletRequest request) {
        LOGGER.debug("Home Page Invoked...");
        final ModelAndView modelAndView = new ModelAndView("home");
        final ModelMap objectMap = new ModelMap();

        HttpSession session = null != request || null != request.getSession(FALSE) ? request.getSession(FALSE) : request.getSession();

        if (session != null && session.isNew()) {

            LOGGER.debug("Session is new...");
        } else {
//            Cookie cookie = new Cookie("codeName", codeName);
//            cookie.setSecure(TRUE);
//            response.addCookie(cookie);

            LOGGER.debug("Session is NOT new...");
        }

        objectMap.put("title", Constants.HOME_TITLE);
        modelAndView.setStatus(HttpStatus.OK);
        modelAndView.addAllObjects(objectMap);
        return modelAndView;
    }

}

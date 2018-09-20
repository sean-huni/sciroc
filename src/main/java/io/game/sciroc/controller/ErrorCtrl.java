package io.game.sciroc.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.controller
 * USER      : sean
 * DATE      : 17-Mon-Sep-2018
 * TIME      : 12:43
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@Controller
public class ErrorCtrl implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public String handleError() {
        return "404";
    }

    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
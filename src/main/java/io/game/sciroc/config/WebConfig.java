package io.game.sciroc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static io.game.sciroc.utils.Constants.EXTERNAL_REF_URI_RESOURCES;
import static io.game.sciroc.utils.Constants.INTERNAL_REF_URI_RESOURCES;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.config
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 15:41
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Maps resource-handler to resource-locations.
     *
     * @param registry see {@link ResourceHandlerRegistry}
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(EXTERNAL_REF_URI_RESOURCES)
                .addResourceLocations(INTERNAL_REF_URI_RESOURCES);
    }

}

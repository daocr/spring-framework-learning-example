package com.huilong.chapter3.conf;

import com.huilong.chapter3.registrar.MyPropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author daocr
 * @date 2020/12/23
 */
@Configuration
public class Config {

    @Bean
    public CustomEditorConfigurer genCustomEditorConfigurer(@Autowired MyPropertyEditorRegistrar myPropertyEditorRegistrar) {

        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        customEditorConfigurer.setPropertyEditorRegistrars(Arrays.asList(myPropertyEditorRegistrar).toArray(new PropertyEditorRegistrar[1]));

        return customEditorConfigurer;
    }
}

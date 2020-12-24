package com.huilong.chapter3.registrar;

import com.huilong.chapter3.editor.MyCustomDateEditor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 注册 属性 编辑器
 *
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
@Component
public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {

        registry.registerCustomEditor(Date.class,new MyCustomDateEditor());

        Object wrappedInstance = ((BeanWrapperImpl) registry).getWrappedInstance();

        log.info("注册属性编辑器成功 class {}" ,wrappedInstance.getClass().getName());
    }
}

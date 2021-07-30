package com.huilong.chapter1.group.provider;

import com.huilong.chapter1.dto.PersonDto;
import com.huilong.chapter1.group.Update;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态选择 需要验证的组
 *
 * @author : yhl
 * date : 2021-07-30
 */
public class MyDefaultGroupSequenceProvider implements DefaultGroupSequenceProvider<PersonDto> {
    @Override
    public List<Class<?>> getValidationGroups(PersonDto personDto) {

        final ArrayList<Class<?>> group = new ArrayList<>();
        // 这段代码不能少，如果少了会导致其他 验证 规则无效
        group.add(PersonDto.class);

        if (personDto != null) {
            if (personDto.getId() != null) {
                group.add(Update.class);
            }
        }


        return group;
    }
}

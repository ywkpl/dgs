package com.dotest.dsg.config;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.Optional;

@Component
public class PatchMapper {
    public <I, V> void patch(I input, V view) {

        BeanWrapper inputWrap = new BeanWrapperImpl(input);
        BeanWrapper viewWrap = new BeanWrapperImpl(view);

        for (PropertyDescriptor pd : inputWrap.getPropertyDescriptors()) {
            Object value = inputWrap.getPropertyValue(pd.getName());

            // 排除 ID 且值不為 null 時才寫入 target
            if (value != null && !"id".equals(pd.getName()) && viewWrap.isWritableProperty(pd.getName())) {
                viewWrap.setPropertyValue(pd.getName(), value);
            }

//            if (value instanceof Optional<?> optional) {
//                optional.ifPresent(o -> viewWrap.setPropertyValue(
//                        pd.getName(),
//                        o
//                ));
//            }
        }
    }
}
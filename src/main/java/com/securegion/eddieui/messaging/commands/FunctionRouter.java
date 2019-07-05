package com.securegion.eddieui.messaging.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Service
public class FunctionRouter {
    @Autowired
    ApplicationContext context;
    @Autowired
    ObjectMapper mapper;

    public Object route(Message message) {
        String category = message.getFunctionCategory();
        String subcategory = message.getSubcategory();
        String method = message.getMethod();
        Map<String, Object> params = (Map<String, Object>)message.getData();
        if (StringUtils.isEmpty(category)) {
            log.error("Category empty. " + message.toString());
            return null;
        }

        Command func = getFuncClass(category, subcategory);
        if (func == null) {
            log.error("Subcategory not found. " + category + " " + subcategory + " " + method);
            return null;
        }
        return func.run(method, params, message);
    }

    private Command getFuncClass(String category, String subcategory) {
        String namespace = getClass().getPackage().getName();
        try {
            String className = namespace + "." + category.toLowerCase() + "." + subcategory + "Func";
            Class<?> clazz = Class.forName(className);
            if (clazz == null) {
                log.error("Command not found: " + className);
                return null;
            }

            context.getBean(clazz);

            return (Command) context.getBean(clazz);
        } catch (Exception e) {
            log.error(e.toString());
        }

        return null;
    }
}

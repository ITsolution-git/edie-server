package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.GenericQuery;
import com.securegion.eddieui.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/search")
@RestController
public class SearchApi {
    @Autowired IMHook imHook;

    @GetMapping("/query") Object query(GenericQuery req) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Search")
                .subcategory("Search")
                .method("query")
                .data(req)
                .build(), Object.class);
    }

    @GetMapping("/getMapping") Object getMapping() {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Search")
                .subcategory("Search")
                .method("getMapping")
                .build(), Object.class);
    }

    @GetMapping("/fields")
    List<Map<String, Object>> fields(GenericQuery req) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Search")
                .subcategory("Search")
                .method("fields")
                .data(req)
                .build(), List.class);
    }

    @GetMapping("/getRecordCount") List<Object> getRecordCount(GenericQuery req) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Search")
                .subcategory("Search")
                .method("getRecordCount")
                .data(req)
                .build(), List.class);
    }

    @GetMapping("/getRecordCounts") List<Object> getRecordCounts(GenericQuery req) {
        return imHook.sendMessageSync(Message.builder()
                .functionCategory("Search")
                .subcategory("Search")
                .method("getRecordCounts")
                .data(req)
                .build(), List.class);
    }
}

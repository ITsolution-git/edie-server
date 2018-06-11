package com.securegion.eddieui.api.eddie_webapi;

import com.securegion.eddieui.Const;
import com.securegion.eddieui.hook.EddieHook;
import com.securegion.eddieui.model.BrainCell;
import com.securegion.eddieui.model.Message;
import com.securegion.eddieui.model.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class BrainCellApi {
    @Autowired EddieHook eddieHook;

    @GetMapping("/getAllBraincells")
    BrainCell[] getAllBraincells() {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Braincell")
                    .method("getAll")
                    .build();
            return eddieHook.sendMessageSync(msg, BrainCell[].class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/saveBraincell")
    BrainCell saveBraincell(@RequestBody BrainCell entity) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Braincell")
                    .method("save")
                    .data(entity)
                    .build();
            return eddieHook.sendMessageSync(msg, BrainCell.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @PostMapping("/deleteBraincell")
    Result<Object> deleteBraincell(@RequestBody BrainCell entity) {
        try {
            Message msg = Message.builder()
                    .type(Const.MSG_TYPE_FUNC)
                    .functionCategory("Internal")
                    .subcategory("Braincell")
                    .method("delete")
                    .data(entity)
                    .build();
            return eddieHook.sendMessageSync(msg, Result.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return new Result<>();
    }
}

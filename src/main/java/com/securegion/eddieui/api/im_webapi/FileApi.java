package com.securegion.eddieui.api.im_webapi;

import com.securegion.eddieui.hook.IMHook;
import com.securegion.eddieui.model.CustomImage;
import com.securegion.eddieui.model.Message;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
public class FileApi {
    @Autowired IMHook imHook;

    @PostMapping("/upload")
    CustomImage handleFileUpload(@RequestParam("file") MultipartFile file){
        try {
            String content = Base64.getEncoder().encodeToString(file.getBytes());
            Map<String, Object> data = new HashMap<>();
            data.put("content", content);
            data.put("fileName", file.getOriginalFilename());
            data.put("contentType", file.getContentType());
            return imHook.sendMessageSync(
                    Message.builder()
                            .functionCategory("Internal")
                            .subcategory("Image")
                            .method("upload")
                            .data(data)
                            .build(),
                    CustomImage.class);
        } catch (Exception e) {
            log.error("Error", e);
        }
        return null;
    }

    @GetMapping("/externalpictures") void downloadImage(String name, HttpServletResponse response) {
        try {
            Map<String, Object> data = new HashMap<>();
            data.put("uuid", name);
            CustomImage img = imHook.sendMessageSync(
                    Message.builder()
                            .functionCategory("Internal")
                            .subcategory("Image")
                            .method("getByUuid")
                            .data(data)
                            .build(),
                    CustomImage.class);
            if (img != null) {

                byte[] content = Base64.getDecoder().decode(img.getContent());

                response.setContentLength(content.length);
                response.setContentType(img.getMimeType());

                IOUtils.write(content, response.getOutputStream());
            } else {
                response.sendRedirect("/images/" + name);
            }
        } catch (Exception e) {
            log.error("Error", e);
        }
    }
}

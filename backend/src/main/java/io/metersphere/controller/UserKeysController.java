package io.metersphere.controller;

import io.metersphere.base.domain.UserKey;
import io.metersphere.commons.utils.SessionUtils;
import io.metersphere.service.UserKeyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user/key")
public class UserKeysController {

    @Resource
    private UserKeyService userKeyService;

    @GetMapping("info")
    public List<UserKey> getUserKeysInfo() {
        String userId = SessionUtils.getUser().getId();
        return userKeyService.getUserKeysInfo(userId);
    }

    @GetMapping("generate")
    public void generateUserKey() {
        String userId = SessionUtils.getUser().getId();
        userKeyService.generateUserKey(userId);
    }

    @GetMapping("delete/{id}")
    public void deleteUserKey(@PathVariable String id) {
        userKeyService.deleteUserKey(id);
    }

    @GetMapping("active/{id}")
    public void activeUserKey(@PathVariable String id) {
        userKeyService.activeUserKey(id);
    }

    @GetMapping("disable/{id}")
    public void disabledUserKey(@PathVariable String id) {
        userKeyService.disableUserKey(id);
    }
}
package com.heartsignal.dev.controller;

import com.heartsignal.dev.Facade.AggregationFacade;
import com.heartsignal.dev.domain.User;
import com.heartsignal.dev.dto.userInfo.DuplicatedNickname;
import com.heartsignal.dev.dto.userInfo.SaveAdditionalInfo;
import com.heartsignal.dev.oauth.PrincipalDetails;
import com.heartsignal.dev.service.domain.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserInfoController {
    private final AggregationFacade aggregationFacade;
    @PostMapping("/additional")
    public void saveAdditionalInfo(@RequestBody SaveAdditionalInfo additionalInfo, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User user = principalDetails.getUser();
        aggregationFacade.saveAdditionalInfo(user, additionalInfo);
    }
    @PostMapping("/duplicate-nickname/{nickname}")
    public DuplicatedNickname checkDuplicatedNickname(@PathVariable String nickname){
        return aggregationFacade.checkDuplicatedNickname(nickname);
    }
}
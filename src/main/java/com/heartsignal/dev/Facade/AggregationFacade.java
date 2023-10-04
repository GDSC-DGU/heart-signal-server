package com.heartsignal.dev.Facade;

import com.heartsignal.dev.dto.userInfo.DuplicatedNickname;
import com.heartsignal.dev.service.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AggregationFacade {
    private final UserInfoService userInfoService;
    private final UserService userService;
    private final TeamService teamService;
    private final MeetingRoomService meetingRoomService;
    private final BarService barService;
    private final BarChatroomService barChatroomService;

    public DuplicatedNickname checkDuplicatedNickname(String nickname){
        return new DuplicatedNickname(userInfoService.isExistedNickname(nickname));
    }
}
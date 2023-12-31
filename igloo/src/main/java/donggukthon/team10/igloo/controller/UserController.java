package donggukthon.team10.igloo.controller;

import donggukthon.team10.igloo.common.ApiResponse;
import donggukthon.team10.igloo.dto.user.request.IglooPageDTO;
import donggukthon.team10.igloo.dto.user.request.UpdateInfoDTO;
import donggukthon.team10.igloo.dto.user.request.UpdateNicknameDTO;
import donggukthon.team10.igloo.dto.user.request.UpdatePasswordDTO;
import donggukthon.team10.igloo.dto.user.response.IglooPageResponseDTO;
import donggukthon.team10.igloo.dto.user.response.UpdatePasswordResponseDTO;
import donggukthon.team10.igloo.dto.user.response.VisitResponseDTO;
import donggukthon.team10.igloo.service.IglooService;
import donggukthon.team10.igloo.service.UserService;
import donggukthon.team10.igloo.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final IglooService iglooService;
    private final VisitService visitService;
    @PatchMapping("/nickname")
    public ApiResponse<String> updateNickname(@RequestBody UpdateNicknameDTO updateNicknameDTO){
        return ApiResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(userService.updateNickname(updateNicknameDTO.getNickname()))
                .build();
    }
    @PatchMapping("/info")
    public ApiResponse<String> updateInfo(@RequestBody UpdateInfoDTO updateInfoDTO){
        return ApiResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(userService.updateInfo(updateInfoDTO))
                .build();
    }
    @GetMapping("/mainPage")
    public ApiResponse<IglooPageResponseDTO> showIgloo(@RequestBody IglooPageDTO iglooPageDTO){
        return ApiResponse.<IglooPageResponseDTO>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(iglooService.showIglooInfo(iglooPageDTO.getCode()))
                .build();
    }
    @GetMapping("/visit")
    public ApiResponse<VisitResponseDTO> showVisits(){
        return ApiResponse.<VisitResponseDTO>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(visitService.showVisits(iglooService.findMyIgloo(userService.getLoginUser())))
                .build();
    }
    @PatchMapping("/password")
    public ApiResponse<UpdatePasswordResponseDTO> changePassword(@RequestBody UpdatePasswordDTO updatePasswordDTO){
        return ApiResponse.<UpdatePasswordResponseDTO>builder()
                .code(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(userService.updatePassword(updatePasswordDTO))
                .build();
    }
}

//package com.carrotzmarket.api.domain.user;
//
//import com.carrotzmarket.api.domain.user.controller.UserPrivateApiController;
//import com.carrotzmarket.api.domain.user.dto.response.UserResponse;
//import com.carrotzmarket.api.domain.user.dto.response.UserSession;
//import com.carrotzmarket.api.domain.user.service.UserManagementService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.junit.jupiter.MockitoSettings;
//import org.mockito.quality.Strictness;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.nio.charset.StandardCharsets;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
//class UserPrivateApiControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private UserManagementService userManagementService;
//
//    @InjectMocks
//    private UserPrivateApiController userPrivateApiController;
//
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userPrivateApiController)
//                .defaultResponseCharacterEncoding(StandardCharsets.UTF_8) // UTF-8 설정 추가
//                .build();
//        objectMapper = new ObjectMapper();
//    }
//
//    @Test
//    void getMyInfo_shouldReturnUserInfo() throws Exception {
//        // GIVEN
//        String loginId = "testUser";
//        UserResponse response = new UserResponse();
//        response.setLoginId(loginId);
//        response.setEmail("test@example.com");
//
//        given(userManagementService.getUserInfo(loginId)).willReturn(response);
//
//        // WHEN & THEN
//        mockMvc.perform(get("/private-api/user/me")
//                        .param("loginId", loginId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.loginId").value(loginId))
//                .andExpect(jsonPath("$.email").value("test@example.com"));
//    }
//
//    @Test
//    void deleteUser_shouldReturnSuccessMessage() throws Exception {
//        // GIVEN
//        String loginId = "testUser";
//
//        // WHEN & THEN
//        mockMvc.perform(delete("/private-api/user/delete")
//                        .param("loginId", loginId))
//                .andExpect(status().isOk())
//                .andExpect(content().string("유저의 계정이 삭제되었습니다."));
//    }
//
//    @Test
//    void logout_shouldInvalidateSession() throws Exception {
//        // GIVEN
//        MockHttpSession session = new MockHttpSession();
//        session.setAttribute("userSession", new UserSession());
//
//        // WHEN & THEN
//        mockMvc.perform(post("/private-api/user/logout")
//                        .session(session))
//                .andExpect(status().isOk())
//                .andExpect(content().string("성공적으로 로그아웃 하였습니다."));
//    }
//
//
//    @Test
//    void getSessionInfo_shouldReturnSessionInfo() throws Exception {
//        // GIVEN
//        UserSession sessionInfo = new UserSession();
//        sessionInfo.setLoginId("testUser");
//        MockHttpSession session = new MockHttpSession();
//        session.setAttribute("userSession", sessionInfo);
//
//        // WHEN & THEN
//        mockMvc.perform(get("/private-api/user/session-info")
//                        .session(session))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.loginId").value("testUser"));
//    }
//
//    @Test
//    void searchUser_shouldReturnUserInfo() throws Exception {
//        // GIVEN
//        String loginId = "testUser";
//        UserResponse response = new UserResponse();
//        response.setLoginId(loginId);
//        response.setEmail("test@example.com");
//
//        given(userManagementService.getUserInfoByLoginId(loginId)).willReturn(response);
//
//        // WHEN & THEN
//        mockMvc.perform(get("/private-api/user/search")
//                        .param("loginId", loginId))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.loginId").value(loginId))
//                .andExpect(jsonPath("$.email").value("test@example.com"));
//    }
//
////    @Test
////    void updateUser_shouldReturnUpdatedUser() throws Exception {
////        // GIVEN
////        String loginId = "testUser";
////        UserUpdateRequest request = new UserUpdateRequest();
////        request.setEmail("updated@example.com");
////
////        UserResponse updatedUser = new UserResponse();
////        updatedUser.setLoginId(loginId);
////        updatedUser.setEmail("updated@example.com");
////
////        // Stubbing에 정확한 인자 전달
////        given(userService.updateUser(eq(loginId), any(UserUpdateRequest.class), any(MultipartFile.class)))
////                .willReturn(updatedUser);
////
////        // WHEN & THEN
////        mockMvc.perform(post("/private-api/user/users/update")
////                        .param("loginId", loginId)
////                        .contentType(MediaType.MULTIPART_FORM_DATA)
////                        .flashAttr("request", request))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.loginId").value(loginId))
////                .andExpect(jsonPath("$.email").value("updated@example.com"));
////    }
//
//}

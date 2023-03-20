package com.solution.blog.domain.search.controller;

import com.solution.blog.domain.search.controller.model.SortType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class BlogSearchControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .alwaysDo(print())
                .build();
    }

    // 필수값만 넣고 조회 가능한지 확인
    @Test
    public void requirementTest() throws Exception {
        // given
        String keyword = "123";

        // when
        //then
        mockMvc.perform(
                MockMvcRequestBuilders.get("/blog/search")
                        .param("keyword", keyword)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    // 필수값이 입력되지 않은 경우 - validationException 예외 발생
    @Test
    public void requirementBlankTest() throws Exception {
        // given
        String keyword = "";

        // when
        //then
        mockMvc.perform(
                MockMvcRequestBuilders.get("/blog/search")
                        .param("keyword", keyword)
        )
                .andExpect(
                        MockMvcResultMatchers.status().is4xxClientError()
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.code")
                                .value("validationException")
                )
                .andReturn();

    }

    // 정렬 타입을 잘못 요청한 경우 - MethodArgumentTypeMismatchException 예외 발생
    @Test
    public void sortTypeTest() throws Exception {
        // given
        String keyword = "내용";
        String sortType = "accuracy111";

        // when
        //then
        mockMvc.perform(
                MockMvcRequestBuilders.get("/blog/search")
                        .param("keyword", keyword)
                        .param("sortType", sortType)
        )
                .andExpect(
                        MockMvcResultMatchers.status().is4xxClientError()
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.code")
                                .value("MethodArgumentTypeMismatchException")
                )
                .andReturn();

    }

    // page 요청 범위가 벗어난 경우 - ValidationException 예외 발생
    @Test
    public void rangeOverTest() throws Exception {
        // given
        String keyword = "내용";
        String sortType = SortType.RECENCY.name();
        Integer page = 0;

        // when
        //then
        mockMvc.perform(
                MockMvcRequestBuilders.get("/blog/search")
                        .param("keyword", keyword)
                        .param("sortType", sortType)
                        .param("page", String.valueOf(page))
        )
                .andExpect(
                        MockMvcResultMatchers.status().is4xxClientError()
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.code")
                                .value("ValidationException")
                )
                .andReturn();

    }

}
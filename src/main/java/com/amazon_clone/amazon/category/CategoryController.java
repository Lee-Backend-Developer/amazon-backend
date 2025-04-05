package com.amazon_clone.amazon.category;

import com.amazon_clone.amazon.category.domain.Category;
import com.amazon_clone.amazon.category.request.CategoryAddRequest;
import com.amazon_clone.amazon.category.response.CategoryResponse;
import com.amazon_clone.amazon.common.Response;
import com.amazon_clone.amazon.member.MemberService;
import com.amazon_clone.amazon.member.domain.Member;
import com.amazon_clone.amazon.member.request.MemberLogin;
import com.amazon_clone.amazon.member.request.MemberRegister;
import com.amazon_clone.amazon.member.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    // 카테고리 생성
    @PutMapping("add")
    public ResponseEntity<CategoryResponse> add(@RequestBody CategoryAddRequest request) {
        Category category = categoryService.addCategory(request);
        CategoryResponse response = new CategoryResponse(category, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 카테고리 삭제
    @DeleteMapping("delete/{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}

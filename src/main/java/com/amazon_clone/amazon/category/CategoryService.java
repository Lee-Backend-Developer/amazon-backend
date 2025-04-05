package com.amazon_clone.amazon.category;

import com.amazon_clone.amazon.category.domain.Category;
import com.amazon_clone.amazon.category.repository.CategoryRepository;
import com.amazon_clone.amazon.category.request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    // 카테고리 생성
    @Transactional
    public Category addCategory(CategoryRequest request) {
        Category saveCategory = Category.builder()
                .name(request.getName())
                .build();
        return categoryRepository.save(saveCategory);
    }

}

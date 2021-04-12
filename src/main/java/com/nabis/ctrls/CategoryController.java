package com.nabis.ctrls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.nabis.mappers.CategoryDto;
import com.nabis.svc.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public @ResponseBody List<CategoryDto> getCategories() {
		return categoryService.getCategories();
	}
	
	@PostMapping
	public RedirectView newCategories(@ModelAttribute CategoryDto categoryDto) {
		categoryService.newCategories(categoryDto);
		return new RedirectView("/admin/category");
	}
}

package guru.springframework.spring5receipeapp.controllers;

import guru.springframework.spring5receipeapp.domain.Category;
import guru.springframework.spring5receipeapp.domain.MeasureUnit;
import guru.springframework.spring5receipeapp.repositiories.CategoryRepository;
import guru.springframework.spring5receipeapp.repositiories.MeasureUnitRespository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private MeasureUnitRespository measureUnitRespository;

    public IndexController(CategoryRepository categoryRepository, MeasureUnitRespository measureUnitRespository) {
        this.categoryRepository = categoryRepository;
        this.measureUnitRespository = measureUnitRespository;
    }

    @RequestMapping({"","/","index","index.html"})
    public String getIndexPage(){
        Optional<Category> categoryDescriptionList=categoryRepository.findByDescription("ITALIAN");
        Optional<MeasureUnit> measureUnitList=measureUnitRespository.findByDescription("CUP");
        System.out.println(categoryDescriptionList.get().getId());
        System.out.println(measureUnitList.get().getId());
        return "index";
    }

}

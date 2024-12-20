package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerService;
import com.mysite.sbb.catrgory.Category;
import com.mysite.sbb.catrgory.CategoryService;
import com.mysite.sbb.qustion.Question;
import com.mysite.sbb.qustion.QuestionService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@RequiredArgsConstructor
@ControllerAdvice
public class GlobalController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerService answerService;

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model) {
        String requestURI = request.getRequestURI();
        List<Category> category = categoryService.getCategorys();
        Answer currentAnswer = answerService.getCurrentAnswer();
        Question currentQuestion = questionService.getCurrentQuestion();
        model.addAttribute("categorys", category);
        model.addAttribute("currentAnswer", currentAnswer);
        model.addAttribute("currentQuestion", currentQuestion);

    }
}

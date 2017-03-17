package de.deutschepost.epost.springproject.controllers;

import de.deutschepost.epost.springproject.models.Article;
import de.deutschepost.epost.springproject.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by afischer on 17/03/2017.
 */
@Controller
public class WelcomeController {

@Autowired
    ArticleRepository articleRepository;

    @Value("${welcome.message:test}") // wird überschrieben durch welcome.message in application.properties
    private String message = "Hello World";


    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);

        Iterable<Article> articleList = articleRepository.findAll();

        model.put("articles", articleList);

        return "welcome";






    }




}

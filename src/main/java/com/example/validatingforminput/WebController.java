package com.example.validatingforminput;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller //webコントローラーであることを宣言
public class WebController implements WebMvcConfigurer {

    @Override // WebMvcConfigurerをオーバーライドしていることを明示的に宣言
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    // GETでルートにアクセスされた場合
    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    // POSTでルートにアクセスされた場合
    @PostMapping("/")
    // @Validをつけることで、入力チェックをするよ、という指標になる。
    // ためしに外してみると、入力チェックはされなくなった。
    public String checkPersonalInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }
}

package be.vdab.oauth.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secured")
public class SecuredController {

    @GetMapping
    public ModelAndView securedPage(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return new ModelAndView(
                "secured",
                "userName",
                oAuth2User.getAttribute("login")
        );
    }
}

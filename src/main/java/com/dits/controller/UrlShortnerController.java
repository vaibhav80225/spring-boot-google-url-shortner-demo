package com.dits.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dits.constant.EnvironConstant;
import com.dits.rest.model.GoogleUrlShortnerRequest;
import com.dits.service.GoogleServiceFactory;
import com.dits.service.GoogleUrlShortnerService;

@Controller
@RequestMapping("/")
public class UrlShortnerController {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private GoogleServiceFactory serviceFactory;
    public UrlShortnerController() {
        super();
    }
    
    public UrlShortnerController(GoogleServiceFactory serviceFactory) {
        super();
        this.serviceFactory = serviceFactory;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }
    
    @RequestMapping(value = "short_url", method = RequestMethod.POST)
    public @ResponseBody String shortUrl(HttpServletRequest request){
        String url = request.getParameter("url");
        url = UrlShortner(url);
        return url;
    }

    private String UrlShortner(String Url) {
        String ShortUrl = "";
        try {
            GoogleUrlShortnerService googleUrlShortnerService = serviceFactory.getService(GoogleUrlShortnerService.class);
            GoogleUrlShortnerRequest googleUrlShortnerRequest = new GoogleUrlShortnerRequest(Url);
            ShortUrl = googleUrlShortnerService
                    .shortUrl(System.getenv(EnvironConstant.GOOGLE_URL_SHORTNER_API_KEY), googleUrlShortnerRequest)
                    .execute().body().getId();
            logger.info(ShortUrl);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return ShortUrl;
    }
}

package org.mashup.lottery.controller

import org.mashup.lottery.service.LotterService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LotterController(private val lotterService: LotterService) {

    @RequestMapping(value = ["/", "/index.html"])
    fun extractRandom(model: Model): String {
        model.addAttribute("crew", lotterService.extract())
        return "index"
    }
}
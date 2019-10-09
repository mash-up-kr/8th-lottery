package org.mashup.lottery.controller

import org.mashup.lottery.entity.Crew
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SpecialController {

    @GetMapping("/special")
    fun special(model: Model): String {
        model.addAttribute("crew", Crew("한태웅", 4, "BACKEND"))
        return "index"
    }
}
package pl.edu.wszib.jwd.jwdcolors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.jwd.jwdcolors.dao.SelectedColorDao;
import pl.edu.wszib.jwd.jwdcolors.helper.ColorHelper;
import pl.edu.wszib.jwd.jwdcolors.model.SelectedColor;
import pl.edu.wszib.jwd.jwdcolors.service.SelectedColorService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StatController {

    @Value("${app.title.stat}")
    private String title;

    @Autowired
    SelectedColorService selectedColorService;

    @GetMapping("/stat")
    String statPage(Model model) {
        List<SelectedColor> selectedColors = selectedColorService.getAllData();
        Map<String, Long> dataMap = selectedColors.stream().collect(Collectors.groupingBy(SelectedColor::getColor, Collectors.counting()));

//        System.out.println(dataMap);

        model.addAttribute("title", title);
        model.addAttribute("labels", dataMap.keySet());
        model.addAttribute("data", dataMap.values());
        model.addAttribute("backgrounds", ColorHelper.convertColors(dataMap.keySet()));
        return "stat";
    }
}

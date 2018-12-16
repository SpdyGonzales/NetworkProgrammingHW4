package conv.presentation.converter;

import conv.domain.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import conv.application.ConverterService;
import conv.domain.CurrencyDTO;

import javax.validation.Valid;
import java.util.List;

@Controller
@Scope("session")
public class ConvController {
    static final String DEFAULT_PAGE_URL = "/";
    static final String CONVERT_SUM_URL = "convert-sum";
    private ConverterForm convertSumForm;
    private CurrencyDTO currentCurr;

    @Autowired
    private ConverterService service;

    @GetMapping(DEFAULT_PAGE_URL)
    public String converter(Model model, ConverterForm convertSumForm) {
        List<String> currencies = service.findAll();
        model.addAttribute("currencies", currencies);
        model.addAttribute("convertSumForm", convertSumForm);
        return "converter";
    }

    @PostMapping("/" + CONVERT_SUM_URL)
    public String convertSum(Model model, @ModelAttribute ConverterForm convertSumForm) throws Exception {

        if(convertSumForm.getFromCurrency().equals(convertSumForm.getToCurrency())){
            convertSumForm.setResult(Math.abs(convertSumForm.getAmount()));
            this.convertSumForm = convertSumForm;
            model.addAttribute("result", convertSumForm.getResult());
            return "redirect:/";
        }

        currentCurr = service.getRate(convertSumForm.getFromCurrency(), convertSumForm.getToCurrency());
        double newSum = Math.abs((double) Math.round(currentCurr.getRate()*convertSumForm.getAmount()* 100d) / 100d);
        convertSumForm.setResult(newSum);
        this.convertSumForm = convertSumForm;
        model.addAttribute("result", convertSumForm.getResult());
        return "redirect:/";
    }
}

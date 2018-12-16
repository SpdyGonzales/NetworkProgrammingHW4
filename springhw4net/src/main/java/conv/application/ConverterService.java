package conv.application;

import conv.domain.Currency;
import conv.domain.CurrencyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import conv.repository.CurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class ConverterService {
    private List<Currency> currencies;

    @Autowired
    private CurrencyRepository currencyRepo;

    public List<String> findAll() {
        this.currencies = this.currencyRepo.findAll();
        List<String> nameCurr = new ArrayList<>();
        for(Currency currency : currencies){
            if(!nameCurr.contains(currency.getFromCurrency())){
                nameCurr.add(currency.getFromCurrency());
            }
        }
        return nameCurr;
    }
    public CurrencyDTO getRate(String from, String to){
        CurrencyDTO curr = null;
        for(Currency currency : currencies){
            if(currency.getFromCurrency().equals(from) && currency.getToCurrency().equals(to)){
                curr = currency;
            }
        }
        return curr;
    }
}

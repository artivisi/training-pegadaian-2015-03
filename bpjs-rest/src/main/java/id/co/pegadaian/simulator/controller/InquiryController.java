package id.co.pegadaian.simulator.controller;

import id.co.pegadaian.simulator.entity.Tagihan;
import id.co.pegadaian.simulator.service.BpjsService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/inquiry")
public class InquiryController {
    
    @Autowired BpjsService bpjsService;
    
    @RequestMapping(value="/halo/{nama}")
    public Map<String, String> halo(@PathVariable String nama){
        Map<String, String> hasil = new HashMap<String, String>();
        hasil.put("greetings", "Halo "+nama);
        return hasil;
    }
    
    @RequestMapping(value="/kesehatan/{nomer}")
    public List<Tagihan> inquriry(@PathVariable String nomer){
        return bpjsService.cariTagihan(nomer);
    }
}

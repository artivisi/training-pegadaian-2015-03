package id.co.pegadaian.simulator.controller;

import id.co.pegadaian.simulator.dto.PaymentRequest;
import id.co.pegadaian.simulator.entity.Pembayaran;
import id.co.pegadaian.simulator.entity.Tagihan;
import id.co.pegadaian.simulator.service.BpjsService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    
    @Autowired private BpjsService bpjsService;
    
    @RequestMapping(value = "/kesehatan", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void bayar(@RequestBody PaymentRequest req, HttpServletRequest request, HttpServletResponse response){
        Tagihan t = bpjsService.cariTagihanById(req.getIdTagihan());
        Pembayaran p = bpjsService.bayar(t, req.getKodeLoket(), req.getUserLoket());
        System.out.println("ID Pembayaran : "+p.getId());
        
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, p.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value = "/kesehatan/{id}", method = RequestMethod.GET)
    public Pembayaran info(@PathVariable String id){
        Pembayaran p = bpjsService.cariPembayaranById(id);
        return p;
    }
}

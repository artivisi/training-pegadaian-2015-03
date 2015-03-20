# Contoh Aplikasi SOAP Server

## Cara menjalankan ##

```
mvn clean spring-boot:run
```

Browse WSDL di `http://localhost:8080/soap/bpjs.wsdl`

## Test ##

Kita bisa mengetes layanan web service :

* Inquiry Tagihan
* Pembayaran Tagihan


### Inquiry ###

Create XML Message berikut

```xml
<?xml version="1.0" encoding="UTF-8"?>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
  <SOAP-ENV:Header/>
  <SOAP-ENV:Body>
    <bpjs:inquiryRequest xmlns:bpjs="http://pegadaian.co.id/bpjs">
        <bpjs:idPelanggan>1234567890</bpjs:idPelanggan>
    </bpjs:inquiryRequest>
  </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

Kirim dengan HTTP Post ke http://localhost:8080/soap
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
        <idPelanggan>1234567890</idPelanggan>
    </bpjs:inquiryRequest>
  </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

Kirim dengan HTTP Post ke http://localhost:8080/soap, misalnya dengan curl

```
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/soap
```

Response yang dihasilkan seperti ini

```xml
<?xml version="1.0"?>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
  <SOAP-ENV:Header/>
  <SOAP-ENV:Body>
    <ns3:inquiryResponse xmlns:ns3="http://pegadaian.co.id/bpjs">
      <daftarTagihan>
        <tagihan>
          <id>t001</id>
          <lunas>true</lunas>
          <nilai>100000.00</nilai>
          <peserta>
            <id>abc123</id>
            <nama>Endy Muhardin</nama>
            <nomer>1234567890</nomer>
          </peserta>
          <tanggalJatuhTempo>2015-03-20T00:00:00+07:00</tanggalJatuhTempo>
          <tanggalTagihan>2015-03-01T00:00:00+07:00</tanggalTagihan>
        </tagihan>
      </daftarTagihan>
    </ns3:inquiryResponse>
  </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
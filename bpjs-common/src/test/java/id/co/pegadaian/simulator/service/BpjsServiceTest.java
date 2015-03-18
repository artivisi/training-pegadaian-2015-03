package id.co.pegadaian.simulator.service;

import id.co.pegadaian.simulator.App;
import id.co.pegadaian.simulator.entity.Peserta;
import id.co.pegadaian.simulator.entity.Tagihan;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@SqlGroup(
    {
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data-awal.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:bersih-bersih.sql")
    }
)
public class BpjsServiceTest {
    @Autowired private BpjsService service;
    
    @Test
    public void testSimpanPeserta(){
        Peserta p = new Peserta();
        p.setNomer("9876543210");
        p.setNama("Adi Sulistiono");
        
        service.simpan(p);
        Assert.assertNotNull(p.getId());
        System.out.println("ID : "+p.getId());
    }
    
    @Test
    public void testHitungJumlahPeserta(){
        Long jumlah = service.hitungJumlahPeserta();
        Assert.assertTrue("Jumlah peserta dalam database harusnya 1", jumlah == 1);
    }
    
    @Test
    public void testCariTagihanByNomerPeserta(){
        List<Tagihan> data = service.cariTagihan("1234567890");
        Assert.assertTrue("Jumlah data harusnya 1", data.size() == 1);
    }
}

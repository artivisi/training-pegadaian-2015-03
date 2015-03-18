package id.co.pegadaian.simulator.dao;

import id.co.pegadaian.simulator.entity.Pembayaran;
import org.springframework.data.repository.CrudRepository;

public interface PembayaranDao extends CrudRepository<Pembayaran, String>{

    public Pembayaran findByTagihanId(String id);
    
}

package id.co.pegadaian.simulator.dao;

import id.co.pegadaian.simulator.entity.Peserta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PesertaDao extends CrudRepository<Peserta, String> {
    
}

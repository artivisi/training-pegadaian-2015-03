package id.co.pegadaian.simulator.dao;

import id.co.pegadaian.simulator.entity.Tagihan;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagihanDao extends PagingAndSortingRepository<Tagihan, String> {
    public List<Tagihan> findByPesertaNomerOrderByTanggalTagihanDesc(String nomer);
}

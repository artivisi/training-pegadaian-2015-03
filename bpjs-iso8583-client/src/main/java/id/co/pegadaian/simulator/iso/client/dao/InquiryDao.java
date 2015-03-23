package id.co.pegadaian.simulator.iso.client.dao;

import id.co.pegadaian.simulator.iso.client.entity.Inquiry;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface InquiryDao extends CrudRepository<Inquiry, String>{
    public List<Inquiry> findByStatus(String status);
}

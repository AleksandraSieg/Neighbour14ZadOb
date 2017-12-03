package pl.madison.dao;

import org.springframework.data.repository.CrudRepository;
import pl.madison.domain.BlockOfFlats;

public interface BlockOfFlatsDao extends CrudRepository<BlockOfFlats, Long>{
}

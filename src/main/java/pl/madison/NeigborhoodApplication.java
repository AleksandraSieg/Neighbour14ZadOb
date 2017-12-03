package pl.madison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.madison.dao.BlockOfFlatsDao;
import pl.madison.domain.BlockOfFlats;

@SpringBootApplication
public class NeigborhoodApplication implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(NeigborhoodApplication.class, args);
    }

    @Autowired
    BlockOfFlatsDao blockDao;

    public void run(String... strings) throws Exception {
        BlockOfFlats block1 = new BlockOfFlats();
        BlockOfFlats block2 = new BlockOfFlats();
        BlockOfFlats block3 = new BlockOfFlats();
        BlockOfFlats block4 = new BlockOfFlats();

        block1.setNumber(34);
        block2.setNumber(12);
        block3.setNumber(3);
        block4.setNumber(121);

        block1.setStreet("Koralowa");
        block2.setStreet("Diamentowa");
        block3.setStreet("Krzemowa");
        block4.setStreet("Uranowa");

        blockDao.save(block1);
        blockDao.save(block2);
        blockDao.save(block3);
        blockDao.save(block4);


    }
}

package ch1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) throws Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class,args);
        assert(ctx!=null);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        String singerName;
        singerName = singerDao.findNameById(1L);
        logger.info("blabla" + singerName);
        System.in.read();
        ctx.close();
    }
}

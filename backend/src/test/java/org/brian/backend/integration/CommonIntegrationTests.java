package org.brian.backend.integration;

import org.brian.backend.BackendApplication;
import org.brian.backend.dao.SequenceDao;
import org.brian.backend.exception.ModuleException;
import org.brian.dao.ext.entity.Guestbook;
import org.brian.dao.ext.mapper.GuestbookMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = BackendApplication.class)
public class CommonIntegrationTests {

    //做 Transaction 的 field
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DataSourceTransactionManager transactionManager;
    private TransactionStatus txStatus;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private GuestbookMapper mapperGuestbook;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SequenceDao sequenceDao;

    @BeforeEach
    public void before() {
        txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    @AfterEach
    public void after() {
        transactionManager.rollback(txStatus);
    }

    @Test
    public void test() throws ModuleException {
        Guestbook guestbook = new Guestbook();
        guestbook.setSn(sequenceDao.getDepositSeq());
        guestbook.setAccount("Brian");
        guestbook.setTitle("Test Titlel");
        guestbook.setContent("Test Content");
        guestbook.setModifyDate(new Date());
        guestbook.setIsDelete(false);
        guestbook.setIsTop(false);

        int actual = mapperGuestbook.insert(guestbook);

        int excepted = 1;

        assertThat(actual).isEqualTo(excepted);
    }
}

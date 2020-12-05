package org.brian.backend.dao;

import org.brian.backend.exception.ModuleException;
import org.brian.backend.utiiity.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDao {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private IToolDao toolDao;

    /**
     * @param seqName 資料庫 Sequence 名稱
     * @return Long 該 Sequence 的 nextval()
     * @throws ModuleException 取出來為 null
     * @author Brian
     * @date 2019/08/27 11:38:23
     */
    private Long getSeq(String seqName) throws ModuleException {
        Long seq = toolDao.getSeq(seqName);
        if (CheckUtil.checkIsNull(seq)) {
            throw new ModuleException(ModuleException.Exceptions.SequenceIsNotExist.getMessage() + ", seqName = " + seqName);
        }
        return seq;
    }

    /**
     * @param theLong   從 Sequence 取得的值
     * @param tableName 該 Sequence 對應的 Table
     * @return int, 因為目前資料庫的 Table 都是開 Int(11)，所以把 Long 轉成 int。如果超過 int，則發出警示，提醒要換成 BigInt()。
     * @author Brian
     * @date 2019/08/27 16:57:06
     */
    private int convertLongToInt(Long theLong, String tableName) throws ModuleException {
        try {
            return Math.toIntExact(theLong);
        } catch (ArithmeticException e) {
            throw new ModuleException("int 不夠用了，請將 Table : " + tableName + " 的 PK 調整為 BigInt/long");
        }
    }

    /**
     * @return int, 取得欲新增留言板貼文的序號
     * @author Brian
     * @date 2019/08/27 16:59:45
     */
    public int getDepositSeq() throws ModuleException {
        return convertLongToInt(getSeq("SEQ_Guestbook"), "Guestbook");
    }
}

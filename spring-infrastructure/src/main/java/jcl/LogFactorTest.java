package jcl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author ISJINHAO
 * @Date 2020/11/28 13:02
 */
public class LogFactorTest {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(LogFactorTest.class);
        log.info("aaa");
    }

}

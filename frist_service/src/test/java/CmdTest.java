import com.yuanqi.common.util.CmdUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: yq
 * @Date：2019/6/6 17:07
 * @Describe:
 */
public class CmdTest {

    @Test
    public void test() throws IOException {
//        System.getProperty("start.bat");
//        boolean b = CmdUtil.run_cmd("cmd /k cd C:\\Users\\Win_YQ\\Desktop\\SxzYYApp");
//         CmdUtil.run_cmd("cmd /c terminal-app.exe");
//        System.out.println(b);
        boolean b = CmdUtil.run_cmd("");
    }
}

import org.junit.Test;

/**
 * @Author: yq
 * @Date：2019/5/15 9:04
 * @Describe:
 */
public class TestErWeiMa {

    @Test
    public void testM() throws Exception {
        // 存放在二维码中的内容
        String text = "慕肖肖";
        // 嵌入二维码的图片路径
        String imgPath = "D:/123.jpg";
        // 生成的二维码的路径及名称
        String destPath = "d:/jam.jpg";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);

    }
}

package i18n.format;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Date;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/12/21
 */
public class MessageFormatInJDK {

    public static void main(String[] args) throws Exception{

        // 普通的格式化
        int planet = 7;
        String event = "a disturbance in the Force";

        String result = MessageFormat.format(
            "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
            planet, new Date(), event);
        System.out.println(result);

        // 输出引号
        int fileCount = 1273;
        String diskName = "MyDisk";
        Object[] testArgs = {new Long(fileCount), diskName};
        MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0} file(s).");
        System.out.println(form.format(testArgs));

        // ChoiceFormat
        form = new MessageFormat("The disk \"{1}\" contains {0}.");
        double[] filelimits = {0, 1, 2};
        String[] filepart = {"no files","one file","{0,number} files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        form.setFormatByArgumentIndex(0, fileform);
        System.out.println(form.format(testArgs));

        // 小数的输出
        MessageFormat mf = new MessageFormat("{0,number,#.##}, {0,number,#.###}");
        Object[] objs = {new Double(3.1415), new Double(4.1123)};
        result = mf.format(objs);
        System.out.println(result);     // "3.14, 3.1"


    }

}

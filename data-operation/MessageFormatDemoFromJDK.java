package org.geekbang.thinking.in.spring.i18n;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.Date;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/12/21
 */
public class MessageFormatDemoFromJDK {

    public static void main(String[] args) {

//        int planet = 7;
//        String event = "a disturbance in the Force";
//
//        String result = MessageFormat.format(
//            "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
//            planet, new Date(), event);
//
//        System.out.println(result);

//        int fileCount = 1273;
//        String diskName = "MyDisk";
//        Object[] testArgs = {new Long(fileCount), diskName};
//
//        MessageFormat form = new MessageFormat(
//            "The disk \"{1}\" contains {0} file(s).");
//
//        System.out.println(form.format(testArgs));

        MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0}.");
        double[] filelimits = {0, 1, 2};
        String[] filepart = {"no files","one file","{0,number} files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        form.setFormatByArgumentIndex(0, fileform);

        int fileCount = 1273;
        String diskName = "MyDisk";
        Object[] testArgs = {new Long(fileCount), diskName};

        System.out.println(form.format(testArgs));

        MessageFormat mf = new MessageFormat("{0,number,#.##}, {0,number,#.###}");
        Object[] objs = {new Double(3.1415), new Double(3.1415926)};
        String result = mf.format( objs );
        System.out.println(result);
        // result now equals "3.14, 3.1"
        objs = null;
        objs = mf.parse(result, new ParsePosition(0));
        System.out.println(objs[0]);
        // objs now equals {new Double(3.1)}


//        MessageFormat mf = new MessageFormat("{0}, {0}, {0}");
//        String forParsing = "x, y, z";
//        Object[] objs = mf.parse(forParsing, new ParsePosition(0));
//        // result now equals {new String("z")}
    }

}

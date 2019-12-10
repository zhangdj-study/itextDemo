package com.zdj.zdj2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.jsoup.Jsoup;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author zhangdj
 * @date 2019/7/24
 */
public class ItextParseHtml {
    public static void main(String[] args) throws Exception{
        // 1.新建document
        Document document = new Document();
        // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        //创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/test.pdf"));
        // 3.打开文档
        document.open();
        //要解析的html
        String content = "<h1 style=\"text-align:center\"><span style=\"color:#3498db\"><strong>内容标题</strong></span></h1>↵↵<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size:22px\"><span style=\"color:#2ecc71\">拜访计划内容拜访计划内容拜访计划内容,拜访计划内容拜访计划内容拜访计划内容,拜访计划内容拜访计划内容,拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容.</span></span></p>↵↵<figure class=\"easyimage easyimage-full\"><img alt=\"\" sizes=\"100vw\" src=\"http://oss.job.cnoocmall.com/cnooc/crmB40245B912624D3DB30BA81B435FD087.jpg\" srcset=\"\" width=\"1024\" />↵<figcaption></figcaption>↵</figure>↵↵<p><span style=\"font-size:22px\"><span style=\"color:#2ecc71\">&nbsp; &nbsp; &nbsp; 拜访计划内容2拜访计划内容拜访计划,内容拜访计划内容拜访计划内容拜访计划,内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计,划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计,划内容拜访计划内容拜,访计划内容拜访计划内容,拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容拜访计划内容.</span></span></p>";
        //html转换成普通文字,方法如下:
        org.jsoup.nodes.Document contentDoc = Jsoup.parseBodyFragment(content);
        org.jsoup.nodes.Document.OutputSettings outputSettings = new org.jsoup.nodes.Document.OutputSettings();
        outputSettings.syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
        contentDoc.outputSettings(outputSettings);
        String parsedHtml = contentDoc.outerHtml();
        //这儿的font-family不支持汉字，{font-family:仿宋} 是不可以的。
        InputStream cssIs = new ByteArrayInputStream("* {font-family: PingFang-SC-Medium.otf;}".getBytes("UTF-8"));
        //第四个参数是html中的css文件的输入流
        //第五个参数是字体提供者，使用系统默认支持的字体时，可以不传。
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(parsedHtml.getBytes()), cssIs);
        // 5.关闭文档
        document.close();
    }
}

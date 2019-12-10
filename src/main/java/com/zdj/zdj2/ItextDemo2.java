package com.zdj.zdj2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;

/**
 * @author zhangdj
 * @date 2019/7/17
 */
public class ItextDemo2 {
    public static void main(String[] args) throws Exception {
        // 新建document
        Document document = new Document();
        // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        // 创建 PdfWriter 对象 参数是对文档对象 和 文路径
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/test.pdf"));
        // 打开文档
        document.open();
        //设置字体
        // 系统字体 C:/WINDOWS/Fonts/simkai.ttf 目录下 右键字体属性 SIMFANG.TTF
        BaseFont bfChinese = BaseFont.createFont("PingFang-SC-Medium.otf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        //字体大小
        Font font = new Font(bfChinese, 20);
        //段落
        Paragraph title = new Paragraph("报告标题", font);
        //设置居中
        title.setAlignment(Element.ALIGN_CENTER);
        //段后间距
        title.setSpacingAfter(20f);
        //添加到文档
        document.add(title);
        // 创建一条线
        LineSeparator line = new LineSeparator();
        // 设置线的颜色
        line.setLineColor(new BaseColor(0, 0, 0));
        //加入文档
        document.add(line);
        Paragraph paragraph = new Paragraph("段落段落段落段落段落段落段落段落段落段落段落段落段落段落段落段落段落段落段落", font);
        //设置段落行距
        paragraph.setLeading(30f);
        //段落前后间距
        paragraph.setSpacingBefore(20f);
        paragraph.setSpacingAfter(20f);
        //左缩进
        paragraph.setIndentationLeft(30f);
        //右缩进
        paragraph.setIndentationRight(30f);
        document.add(paragraph);

        //创建一个表格指定表格列数为3
        PdfPTable table = new PdfPTable(3);
        for (int i = 0; i < 6; i++) {
            //创建单元格
            PdfPCell cell = new PdfPCell();
            //单元格设置内容 字体
            cell.setPhrase(new Phrase("单元格",font));
            //单元格不显示边框
            cell.setBorderWidth(0);
            //单元格添加到表格
            table.addCell(cell);
        }
        document.add(table);
        // 5.关闭文档
        document.close();
    }
}

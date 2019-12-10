package com.zdj.zdj2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/7/18
 */
public class ItextDemo3 {

    /**
     * 单元格边框   0则没有边框
     */
    public static final Integer CELLWIDTH = 0;

    public static void main(String[] args) throws Exception {
        // 1.新建document
        Document document = new Document();
        // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        //创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/test.pdf"));
        // 3.打开文档
        document.open();
        // 系统字体 C:/WINDOWS/Fonts 目录下 右键字体属性 SIMFANG.TTF
        // 也可以使用其他.ttf .otf的字体文件 可以访问得到即可
        BaseFont bfChinese = BaseFont.createFont("PingFang-SC-Medium.otf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        // 标题字体
        Font font = new Font(bfChinese, 14);
        //正文字体
        Font font1 = new Font(bfChinese, 10);
        //写标题
        writeTitle(document, font);
        //写拜访对象信息
        writeCustomer(document, font, font1);
        //写基本信息
        writeBaseInfo(document, font, font1);
        //写拜访内容
        writeContent(document, font, font1);
        // 5.关闭文档
        document.close();
    }

    /**
     * 写大标题  拜访报告
     *
     * @param document
     * @param font
     */
    private static void writeTitle(Document document, Font font) {
        try {
            //写标题
            Paragraph paragraph = new Paragraph("拜访报告", font);
            //设置标题居中
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeCustomer(Document document, Font font, Font font1) {
        try {
            //写"拜访对象信息"
            Paragraph paragraph = new Paragraph("拜访对象信息", font);
            //段后间距
            paragraph.setSpacingAfter(5);
            //段前间距
            paragraph.setSpacingBefore(30);
            document.add(paragraph);
            // 创建一条线
            LineSeparator line = new LineSeparator();
            // 设置颜色
            line.setLineColor(new BaseColor(0, 0, 0));
            document.add(line);
            //用段增加行距
            Paragraph space = new Paragraph();
            space.setSpacingAfter(15);
            document.add(space);
            //创建表格
            PdfPTable table = new PdfPTable(4);
            //拜访对象来源单元格 第一行 第一列
            PdfPCell customerSource = new PdfPCell();
            customerSource.setPhrase(new Phrase("拜访对象来源：", font1));
            //单元格边框设置为0
            customerSource.setBorderWidth(CELLWIDTH);
            //单元格高度
            customerSource.setFixedHeight(26f);
            table.addCell(customerSource);
            //拜访对象来源的值单元格 第一行 第二列
            PdfPCell customerSourceValue = new PdfPCell();
            customerSourceValue.setPhrase(new Phrase("商机", font1));
            customerSourceValue.setBorderWidth(CELLWIDTH);
            table.addCell(customerSourceValue);
            //第一行 第三列
            PdfPCell sourceClue = new PdfPCell();
            sourceClue.setBorderWidth(CELLWIDTH);
            sourceClue.setPhrase(new Phrase("来源线索：", font1));
            table.addCell(sourceClue);
            //第一行第四列
            PdfPCell oneFour = new PdfPCell();
            oneFour.setBorderWidth(CELLWIDTH);
            oneFour.setPhrase(new Phrase("来源线索", font1));
            table.addCell(oneFour);
            //第二行第一列
            PdfPCell twoOne = new PdfPCell();
            twoOne.setBorderWidth(CELLWIDTH);
            twoOne.setFixedHeight(26f);
            twoOne.setPhrase(new Phrase("拜访对象：", font1));
            table.addCell(twoOne);
            //第二行第二列 拜访对象的值
            PdfPCell twoTwo = new PdfPCell();
            twoTwo.setBorderWidth(CELLWIDTH);
            twoTwo.setPhrase(new Phrase("拜访对象", font1));
            table.addCell(twoTwo);
            //第二行第三列 注册地址
            PdfPCell twoThree = new PdfPCell();
            twoThree.setBorderWidth(CELLWIDTH);
            twoThree.setPhrase(new Phrase("注册地址：", font1));
            table.addCell(twoThree);

            //第二行第四列 注册地址的值
            PdfPCell twoFour = new PdfPCell();
            twoFour.setBorderWidth(CELLWIDTH);
            twoFour.setFixedHeight(26f);
            twoFour.setPhrase(new Phrase("注册地址的值", font1));
            table.addCell(twoFour);

            //第三行第一列 联系人
            PdfPCell threeOne = new PdfPCell();
            threeOne.setBorderWidth(CELLWIDTH);
            threeOne.setFixedHeight(26f);
            threeOne.setPhrase(new Phrase("联系人：", font1));
            table.addCell(threeOne);
            //第三行第二列 联系人
            String s= "联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人联系人";
            PdfPCell threeTwo = new PdfPCell();
            threeTwo.setBorderWidth(CELLWIDTH);
            threeTwo.setPhrase(new Phrase(s, font1));
            table.addCell(threeTwo);
            //第三行第三列 联系人s
            PdfPCell threeThree = new PdfPCell();
            threeThree.setBorderWidth(CELLWIDTH);
            threeThree.setPhrase(new Phrase("联系人：", font1));
            table.addCell(threeThree);
            //第三行第四列 联系人
            PdfPCell threeFour = new PdfPCell();
            threeFour.setBorderWidth(CELLWIDTH);
            threeFour.setPhrase(new Phrase("联系人", font1));
            table.addCell(threeFour);
            table.setSpacingAfter(5);
            //设置表格宽度百分比
            table.setWidthPercentage(100f);
            document.add(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeBaseInfo(Document document, Font font, Font font1) {
        try {
            //写"基本信息"
            Paragraph paragraph = new Paragraph("基本信息", font);
            //段后间距
            paragraph.setSpacingAfter(5);
            document.add(paragraph);
            // 创建一条线
            LineSeparator line = new LineSeparator();
            // 设置颜色
            line.setLineColor(new BaseColor(0, 0, 0));
            document.add(line);
            //段增加行距
            Paragraph space = new Paragraph();
            space.setSpacingAfter(15);
            document.add(space);
            //表格
            PdfPTable table = new PdfPTable(2);
            //一行一列 拜访目的 单元格
            PdfPCell oneOne = new PdfPCell();
            oneOne.setPhrase(new Phrase("拜访目的", font1));
            oneOne.setBorderWidth(CELLWIDTH);
            oneOne.setFixedHeight(26f);
            table.addCell(oneOne);
            //一行二列 拜访目的值
            PdfPCell oneTwo = new PdfPCell();
            oneTwo.setPhrase(new Phrase("目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁目的驱蚊器翁", font1));
            oneTwo.setBorderWidth(CELLWIDTH);
            oneOne.setFixedHeight(26f);
            table.addCell(oneTwo);
            //二行 一列 拜访类型
            PdfPCell twoOne = new PdfPCell();
            twoOne.setPhrase(new Phrase("类型", font1));
            twoOne.setBorderWidth(CELLWIDTH);
            twoOne.setFixedHeight(26f);
            table.addCell(twoOne);
            //二行二列 拜访类型的值
            PdfPCell twoTwo = new PdfPCell();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = simpleDateFormat.format(new Date());
            String s1 = "的获分就是同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人同行人长度测试长度测试11111111111111111111111111111测试速度的方式雕刻技法精神科大夫搭街坊昆仑山搭街坊九点十六分就是";
            twoTwo.setPhrase(new Phrase(s1, font1));
            twoTwo.setBorderWidth(CELLWIDTH);
            oneOne.setFixedHeight(26f);
            table.addCell(twoTwo);
            //补全单元格
            for (int i = 0; i < 8; i++) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Phrase("类型", font1));
                cell.setBorderWidth(CELLWIDTH);
                cell.setFixedHeight(26f);
                table.addCell(cell);
            }
            //指定表格的列宽
            float[] floats = new float[2];
            floats[0] = 200f;
            floats[1] = 700f;
            table.setTotalWidth(floats);
            //宽度百分比
            table.setWidthPercentage(100f);
            table.setSpacingAfter(5);
            document.add(table);
        } catch (Exception e) {

        }
    }

    private static void writeContent(Document document, Font font, Font font1) {
        try {
            //写"拜访内容"
            Paragraph paragraph = new Paragraph("拜访内容", font);
            //段后间距
            paragraph.setSpacingAfter(5);
            document.add(paragraph);
            // 创建一条线
            LineSeparator line = new LineSeparator();
            // 设置颜色
            line.setLineColor(new BaseColor(0, 0, 0));
            document.add(line);
            //段增加行距
            Paragraph space = new Paragraph();
            space.setSpacingAfter(5);
            document.add(space);
            String s = "实际拜实际拜访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事访内容安达市多碍事实际拜访内容安达市多碍事实际拜访内容安达市多碍事";
            Paragraph content = new Paragraph(s, font1);
            //行距
            content.setLeading(15);
            document.add(content);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

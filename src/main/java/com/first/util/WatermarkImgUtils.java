package com.first.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WatermarkImgUtils {

    public static void main(String[] args) {
        System.out.println("开始水印：");
     //   new WatermarkImgUtils().addWatermark("C:\\Users\\Administrator\\Desktop\\123.jpg", "C:\\Users\\Administrator\\Desktop\\1237.jpg", "fangfaxian.房发现！", "jpg");



            String srcImgPath = "C:\\Users\\Administrator\\Desktop\\110.jpg";
            String iconPath = "C:\\Users\\Administrator\\Desktop\\136.png";
            String targerPath = "C:\\Users\\Administrator\\Desktop\\12333.jpg";
            String targerPath2 = "C:\\Users\\Administrator\\Desktop\\12443.jpg";
            // 给图片添加水印
        new WatermarkImgUtils().markImageByIcon(iconPath, srcImgPath, targerPath);
            // 给图片添加水印,水印旋转-45
        new WatermarkImgUtils().markImageByIcon(iconPath, srcImgPath, targerPath2,
                    -45);


        System.out.println("水印完成。");
    }

    /**
     * @description
     * @param sourceImgPath 源图片路径
     * @param tarImgPath 保存的图片路径
     * @param waterMarkContent 水印内容
     * @param fileExt 图片格式
     * @return void
     */
    public void addWatermark(String sourceImgPath, String tarImgPath, String waterMarkContent,String fileExt){
        Font font = new Font("宋体", Font.BOLD, 36);//水印字体，大小
        Color markContentColor = Color.red;//水印颜色
        Integer degree = 45;//设置水印文字的旋转角度
        float alpha = 0.5f;//设置水印透明度
        OutputStream outImgStream = null;
        try {
            File srcImgFile = new File(sourceImgPath);//得到文件
            Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();//得到画笔
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //设置水印颜色
            g.setFont(font);              //设置字体
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));//设置水印文字透明度
            if (null != degree) {
                g.rotate(Math.toRadians(degree));//设置水印旋转
            }
            JLabel label = new JLabel(waterMarkContent);
            FontMetrics metrics = label.getFontMetrics(font);
            int width = metrics.stringWidth(label.getText());//文字水印的宽
            int rowsNumber = srcImgHeight/width;// 图片的高  除以  文字水印的宽    ——> 打印的行数(以文字水印的宽为间隔)
            int columnsNumber = srcImgWidth/width;//图片的宽 除以 文字水印的宽   ——> 每行打印的列数(以文字水印的宽为间隔)
            //防止图片太小而文字水印太长，所以至少打印一次
            if(rowsNumber < 1){
                rowsNumber = 1;
            }
            if(columnsNumber < 1){
                columnsNumber = 1;
            }
            for(int j=0;j<rowsNumber;j++){
                for(int i=0;i<columnsNumber;i++){
                    g.drawString(waterMarkContent, i*width + j*width, -i*width + j*width);//画出水印,并设置水印位置
                }
            }
            g.dispose();// 释放资源
            // 输出图片
            outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, fileExt, outImgStream);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally{
            try {
                if(outImgStream != null){
                    outImgStream.flush();
                    outImgStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }




        /**
         * 给图片添加图片水印
         * @param iconPath 水印图片路径
         * @param srcImgPath 源图片路径
         * @param targerPath 目标图片路径
         */
        public static void markImageByIcon(String iconPath, String srcImgPath,
                                           String targerPath) {
            markImageByIcon(iconPath, srcImgPath, targerPath, null);
        }

        /**
         * 给图片添加水印、可设置水印图片旋转角度
         * @param iconPath 水印图片路径
         * @param srcImgPath 源图片路径
         * @param targerPath 目标图片路径
         * @param degree 水印图片旋转角度
         */
        public static void markImageByIcon(String iconPath, String srcImgPath,
                                           String targerPath, Integer degree) {
            OutputStream os = null;
            try {
                Image srcImg = ImageIO.read(new File(srcImgPath));

                BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                        srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

                // 得到画笔对象
                // Graphics g= buffImg.getGraphics();
                Graphics2D g = buffImg.createGraphics();

                // 设置对线段的锯齿状边缘处理
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg
                        .getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

                if (null != degree) {
                    // 设置水印旋转
                    g.rotate(Math.toRadians(degree),
                            (double) buffImg.getWidth() / 2, (double) buffImg
                                    .getHeight() / 2);
                }

                // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
                ImageIcon imgIcon = new ImageIcon(iconPath);

                // 得到Image对象。
                Image img = imgIcon.getImage();

                float alpha = 0.9f; // 透明度
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                        alpha));

                // 表示水印图片的位置
                g.drawImage(img, 0, 0, null);

                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
                g.dispose();
                os = new FileOutputStream(targerPath);
                // 生成图片
                ImageIO.write(buffImg, "JPG", os);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != os)
                        os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }




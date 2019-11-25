package org.ithang.tools.lang;

import java.io.ByteArrayOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class ZXTools {

	/**
	 * 生成二维码图片,并保存到指定目录
	 * @param text 二维码内容
	 * @param width 宽
	 * @param height 高
	 * @param filePath,如/Users/gisboy/Desktop/MyQRCode.png
	 */
	public static void generateQRCodeImage(String text, int width, int height, String filePath) {
		try{
		      QRCodeWriter qrCodeWriter = new QRCodeWriter();
		      BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		      Path path = FileSystems.getDefault().getPath(filePath);
		      MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成二维图片的字节数据
	 * @param text
	 * @param width
	 * @param height
	 * @return
	 */
	public static byte[] getQRCodeImage(String text, int width, int height) {
		try{
              QRCodeWriter qrCodeWriter = new QRCodeWriter();
              BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
         
              ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
              MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
              return pngOutputStream.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
		}
        return null;

	}
	
}

package me.moe.common.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
/**
 * 一些文件操作
 * @author liu
 *
 */
public class MoeFileUtils {
	
	public static String getExtname(String filename){
		String[] arr = StringUtils.split(filename,".");
		if(arr == null){
			return "";
		}
		int temp = arr.length-1;
		return arr[temp];
	}
	
	public static boolean isImg(String ContentType){
		boolean flag = false;
		if("image/jpeg".equals(ContentType) ||"image/png".equals(ContentType) || "image/gif".equals(ContentType) || "image/bmp".equals(ContentType)){
			flag = true;
		}
		return flag;		
	}
	
	public static boolean isVideo(String ContentType){
		boolean flag = false;
		if("video/mpeg4".equals(ContentType)){
			flag = true;
		}
		return flag;	
	}
	
	public static boolean isVoice(String ContentType){
		boolean flag = false;
		if("audio/mp3".equals(ContentType) ||"audio/x-ms-wma".equals(ContentType) || "audio/wav".equals(ContentType) || "image/bmp".equals(ContentType)){
			flag = true;
		}
		return flag;	
	}
	
	/**
	 * 调整图片尺寸
	 * @param srcImgPath
	 * @param distImgPath
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void resizeImage(String srcImgPath, String distImgPath,  
            int width, int height) throws IOException {  
  
        File srcFile = new File(srcImgPath);  
        Image srcImg = ImageIO.read(srcFile);  
        BufferedImage buffImg = null;  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        buffImg.getGraphics().drawImage(  
                srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0,  
                0, null);  
  
        ImageIO.write(buffImg, "JPEG", new File(distImgPath));  
  
    }  	
	
	/**
	 * 调整图片尺寸
	 * @param srcImgPath
	 * @param distImgPath
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void resizeImage(File srcImgFile, File distImgFile,  
            int width, int height) throws IOException {  
  
        Image srcImg = ImageIO.read(srcImgFile);  
        BufferedImage buffImg = null;  
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        buffImg.getGraphics().drawImage(  
                srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0,  
                0, null);  
  
        ImageIO.write(buffImg, "JPEG", distImgFile);    
    }  	
	
	/**
	 * 获取保存路径
	 * @return
	 */
	public static String getpath(String rootpath){
		return "";
	}
	
	/**
	 * 按照"uid_时间戳"的格式重新生成文件文件名
	 * @return
	 */
	public static String createfilename(String uid,String ext){
		return uid+"_"+ (new Date().getTime()) + "." + ext;
	}
}

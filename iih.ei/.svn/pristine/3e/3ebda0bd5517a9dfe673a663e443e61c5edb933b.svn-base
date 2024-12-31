package iih.ei.itf.md2.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public abstract class ImgHelper {

	public InputStream setImgByUrl(String url) {
		if (!url.startsWith("http")) {
			return setImgByPath(url);
		}
		HttpClient client = new HttpClient();
		client.getParams().setSoTimeout(10000); // 图片读取超时时间为10秒
		GetMethod method = null;
		InputStream is = null;

		try {
			method = new GetMethod(url);
			// 伪装成chrome浏览器
			method.addRequestHeader("User-Agent",
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36");
			int statusCode = client.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {
				System.out.println("无法抓取到图片，抓取地址为：" + url + ",状态码为：" + statusCode);
			} else {
				is = method.getResponseBodyAsStream();
				setIntoFile(is);
			}
			return is;
		} catch (Exception e) {
			System.out.println("无法抓取到图片，抓取地址为：" + url);
			System.out.println(e.getMessage());
			if (url.startsWith("https")) {
				System.out.println("改用http抓取一次图片");
				url = url.replace("https", "http");
				setImgByUrl(url);
			} else {
				setIntoFile(null);
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (method != null) {
				method.releaseConnection();
			}
		}
		return null;
	}

	public InputStream setImgByPath(String path) {
		File imgFile = new File(path);
		if (!imgFile.exists()) {
			System.out.println("图片不存在：" + path);
			return null;
		}

		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(imgFile);
		} catch (FileNotFoundException e) {
			System.out.println("图片不存在：" + path);
			return null;
		}
		setIntoFile(inputStream);
		return inputStream;
	}

	public int[] getImgWidthHeight(InputStream is) {
		int[] ia = new int[2];
		try {

			BufferedImage bi = ImageIO.read(is);
			ia[0] = bi.getWidth();
			ia[1] = bi.getHeight();

		} catch (Exception e) {

		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ia;
	}

	public abstract void setIntoFile(InputStream is);
}

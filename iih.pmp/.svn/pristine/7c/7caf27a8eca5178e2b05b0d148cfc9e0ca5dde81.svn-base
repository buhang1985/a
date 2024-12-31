package iih.pmp.pay.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import xap.mw.coreitf.d.FDate;

public class BillCheckAppUtils {
	static PmpPayAppBaseUtils utils=new PmpPayAppBaseUtils();

	public static String encodeHmacMD5(byte[] data, byte[] key)
			throws Exception {
		// 还原密钥
		SecretKey secretKey = new SecretKeySpec(key, "HmacMD5");
		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		// 初始化mac
		mac.init(secretKey);
		// 执行消息摘要
		byte[] digest = mac.doFinal(data);
		return new HexBinaryAdapter().marshal(digest);// 转为十六进制的字符串
	}

	public static FDate getEndDate(FDate endtime) {
		FDate dt = utils.getServerDateTime().getDate();

		if (endtime.before(dt))
			return endtime;
		return dt.getDateBefore(1);
	}
	
	public static FDate getStartDate(FDate begin, FDate end){
		if (end.getDaysBetween(begin, end) <= 90) {
			return begin;
		}
		return end.getDateBefore(90);
		
	}

	public static int getTimeSpan(FDate begin, FDate end) {
		if (end.getDaysBetween(begin, end) <= 90) {
			return end.getDaysBetween(begin, end);
		}
		return 90;
	}

	public static String getKey() {

		return "serverfilemacvalidate";
	}

	public static String FormatFDate(FDate d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d.toDate());
	}
	
	 public static String getTimeSpanSql(FDate begin,FDate end,String name){
	    	
	    	return name+" <'"+BillCheckAppUtils.FormatFDate(end)+"' and "+name+" >= '"+BillCheckAppUtils.FormatFDate(begin)+"'";
	    }
	 
	 public static void AppendBuilder(StringBuilder sb,String val){
		 if (sb.length() == 0) {
				sb.append("'" + val + "'");
			} else {
				sb.append(",'" + val + "'");
			}
	 }

	 public static String compress(byte[] data){
		    ByteArrayOutputStream out=new ByteArrayOutputStream();
		    try {
		        GZIPOutputStream gzip=new GZIPOutputStream(out);
		        gzip.write(data);
		        gzip.close();
		        return utils.getBase64Str(out.toByteArray());
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return null;
		}
	 public static  byte[] upcompress(String msg){
		    byte[] data=utils.Base64Decodeb(msg);
		    ByteArrayInputStream input=new ByteArrayInputStream(data);
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    try {
		        GZIPInputStream gzip = new GZIPInputStream(input);
		        byte[] buffer = new byte[1024];
		        int offset = -1;
		        while ((offset = gzip.read(buffer)) != -1) {
		            out.write(buffer, 0, offset);
		        }
		        return out.toByteArray();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return null;
		}

}

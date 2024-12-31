package iih.ci.mrm.cimrmdirheareportdto.s.bp;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFWriter;

import iih.ci.mrm.cimrmdirheareportdto.d.CiMrmDirHeaReportDTO;
import xap.mw.core.data.BaseDTO;

public class CiMrmGenerateByteBp {

	public static byte[] writeCSV(List<Object> lists,String[] fs){
		
		 ArrayList<Map<String, Object>> data=getKeysAndValues(lists);
		 byte[] bytes=null;
		 FileOutputStream outf =null;
		 OutputStreamWriter outs =null;
		 BufferedWriter out=null;
		 
		 try {
			//创建临时文件
			File temp = File.createTempFile("csv", ".csv");
			temp.deleteOnExit();
			 
          outf = new FileOutputStream(temp);
			outs = new OutputStreamWriter(outf,"UTF-8");
			out =new BufferedWriter(outs); 
			outf.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });

           for(String str:data.get(0).keySet()){
          	 out.write(str);
          	 out.write(","); 
           }
           out.newLine();
           
           for (Map<String, Object> map:data)
           {    	
          	for(Object o:map.values()){
          		 out.write(o.toString());
          		 out.write(",");
				}
               out.newLine();
           } 
           out.flush();
           out.close();
           outs.close();
           outf.close();
           
           FileInputStream fis = new FileInputStream(temp);
           ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
           byte[] b = new byte[1024];
           int len = 0;
           while((len = fis.read(b)) != -1) {
               bos.write(b, 0, len);
           }
           fis.close();
           bos.close();
           bytes=bos.toByteArray();
       } catch (Exception e) {
           e.printStackTrace();
       }
		return bytes;
	 }
	
	public static byte[] writeCSVByDTOs(List<CiMrmDirHeaReportDTO> lists,String[] fs){
		 ArrayList<Map<String, Object>> data=getKeysAndValuesFromDTO(lists.toArray(new CiMrmDirHeaReportDTO[0]));
		 byte[] bytes=null;
		 FileOutputStream outf =null;
		 OutputStreamWriter outs =null;
		 BufferedWriter out=null;
		 
		 try {
			//创建临时文件
			File temp = File.createTempFile("csv", ".csv");
			temp.deleteOnExit();
			 
         outf = new FileOutputStream(temp);
			outs = new OutputStreamWriter(outf,"UTF-8");
			out =new BufferedWriter(outs); 
			outf.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });

          for(String str:fs){
         	 out.write(str);
         	 out.write(","); 
          }
          out.newLine();
          
          for (Map<String, Object> map:data)
          {    	
         	for(String strArName : fs){
         		 out.write(map.get(strArName)==null?"":map.get(strArName).toString());
         		 out.write(",");
				}
              out.newLine();
          } 
          out.flush();
          out.close();
          outs.close();
          outf.close();
          
          FileInputStream fis = new FileInputStream(temp);
          ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
          byte[] b = new byte[1024];
          int len = 0;
          while((len = fis.read(b)) != -1) {
              bos.write(b, 0, len);
          }
          fis.close();
          bos.close();
          bytes=bos.toByteArray();
      } catch (Exception e) {
          e.printStackTrace();
      }
		 System.out.println(bytes);
		return bytes;
	 }
	 
	@SuppressWarnings({ "deprecation", "resource" })
	public static byte[] writeDBF(List<CiMrmDirHeaReportDTO> lists,String[] fs) {
		ArrayList<Map<String, Object>> data = getKeysAndValuesFromDTO(lists.toArray(new CiMrmDirHeaReportDTO[0]));
		OutputStream fos = null;  
		byte[] bytes=null;
		
		try {   
			File temp = File.createTempFile("dbf", ".dbf");//创建临时文件
			fos = new FileOutputStream(temp); 
			//			temp.deleteOnExit();
			//定义DBF文件字段   
			Map<String, Object> map=data.get(0);
			int length=fs.length;
			DBFField[] fields = new DBFField[length];
			int i=0;
			for(String str:fs){
				fields[i] = new DBFField(str,DBFDataType.CHARACTER,100);  
				if(i==length-1)
					break;
				i++;
			}
			
			DBFWriter writer = new DBFWriter(fos,Charset.forName("GBK"));
			writer.setFields(fields);   
				
			for(Map<String, Object> m:data){
				//写入记录   
				Object[] rowData = new Object[length]; 
				int j=0;
				for(String strArName :fs){
					rowData[j] = m.get(strArName)==null||m.get(strArName).toString().equals("")?"":m.get(strArName).toString();
					if(j==length-1)
						break;
					j++;
				}			
				writer.addRecord(rowData);  
			}
			
			
			//写入数据   
			writer.close();
			
			FileInputStream fis = new FileInputStream(temp);
	        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
	        byte[] b = new byte[1024];
	        int len = 0;
	        while((len = fis.read(b)) != -1) {
	            bos.write(b, 0, len);
	        }
	        fos.close();
	        fis.close();
	        bos.close();
	        bytes=bos.toByteArray();
		} catch(Exception e) {   
			e.printStackTrace();   
		} 
		return bytes;
	}
	
	public static ArrayList<Map<String, Object>> getKeysAndValues(List<Object> lists) {
		    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	        for (Object obj : lists) {
	            Class userCla;
	            userCla = (Class) obj.getClass();
	            // 获取类中的所有属性集合 
	            Field[] fs = userCla.getDeclaredFields();
	            Map<String, Object> listChild = new HashMap<String, Object>();
	            for (int i = 0; i < fs.length; i++) {
	                Field f = fs[i];
	                f.setAccessible(true); 
	                Object val = new Object();
	                try {
	                    val = f.get(obj);
	                    listChild.put(f.getName(), val);
	                } catch (IllegalArgumentException e) {
	                    e.printStackTrace();
	                } catch (IllegalAccessException e) {
	                    e.printStackTrace();
	                }
	            }
	            list.add(listChild);
	            //System.out.println(list);
	        }
	        return list;
	    }
	public static ArrayList<Map<String, Object>> getKeysAndValuesFromDTO(BaseDTO[] lists) {
	    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
      for (BaseDTO bas : lists) {

          // 获取类中的所有属性集合 
          String[] fs = bas.getAttrNames();
   	   
          Map<String, Object> listChild = new HashMap<String, Object>();
          for (int i = 0; i < fs.length; i++) {                
              try {
           	   String attarName = fs[i].substring(0, 1).toUpperCase()+fs[i].substring(1);
           	   if(bas.getAttrVal(attarName)==null)
           		 listChild.put(fs[i], "");
           	   else
           		   listChild.put(fs[i], bas.getAttrVal(attarName));
              } catch (IllegalArgumentException e) {
                  e.printStackTrace();
          }
       }
          list.add(listChild);
      
      }
      return list;
  }
	
	
}

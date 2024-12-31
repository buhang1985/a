package iih.pmp.pay.bill.bp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillCudService;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import iih.pmp.pay.util.PmpPayAppBaseUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.utils.AlipayConfigInitUtil;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class AlipayDownloadBillBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void exec() throws BizException {
		
		FDateTime dt = pmputils.getServerDateTime();
		FDate end = dt.getDate();
		List<ChannelBillDO> channellist = new ArrayList<>();
		
		for(int i = 1; i < 2; i++) {
			FDate now = end.getDateBefore(i);
			String data = getBillData(now);
			ChannelBillDO chlbill = new ChannelBillDO();
			chlbill.setBill_content(data);
			chlbill.setId_chl(PmpPayConst.getUdiID(PmpPayConst.ALIPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID));
			chlbill.setSd_chl(PmpPayConst.ALIPAY_CHANNEL_CODE);
			chlbill.setDt_bill(now);
			chlbill.setBill_type("TRADE");
			chlbill.setStatus(DOStatus.NEW);
			chlbill.setDt_createtime(dt);
			String feature = "";
			try {
				feature = BillCheckAppUtils.encodeHmacMD5(data.getBytes(), BillCheckAppUtils.getKey().getBytes());
				chlbill.setBill_feature(feature);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			channellist.add(chlbill);
		}
		
		IChannelbillCudService _service = ServiceFinder.find(IChannelbillCudService.class);
		IChannelbillRService _rservice = ServiceFinder.find(IChannelbillRService.class);
//		_service.delete(_rservice.find(" id_chl='" + PmpPayConst.getUdiID(PmpPayConst.ALIPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID) + "'", "", FBoolean.FALSE));
//		IChannelbillitemRService _itemrrservice = ServiceFinder.find(IChannelbillitemRService.class);
//		IChannelbillitemCudService _itemservice = ServiceFinder.find(IChannelbillitemCudService.class);
//		_itemservice.delete(_itemrrservice.find(" id_chl='" + PmpPayConst.getUdiID(PmpPayConst.ALIPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID) + "'", "", FBoolean.FALSE));
//		_service.save(channellist.toArray(new ChannelBillDO[0]));
	}
	
	private String getBillData(FDate date) throws BizException {
		
		String downloadbill_url = null, bill_data = null;
		File temp = null;
		
		if (!AlipayConfigInitUtil.LoadConfig())
			throw new BizException("支付宝环境配置文件加载失败");
		
		AlipayDataDataserviceBillDownloadurlQueryResponse response = getDownloadBillResponse(date);
		
		if (response != null && "10000".equals(response.getCode())) {
			downloadbill_url = response.getBillDownloadUrl();
		}
		else {
			return null;
		}
		
		try {
			temp = File.createTempFile("temp", ".zip");
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		if (temp != null) {
			if(!downLoadZip(downloadbill_url, temp)) {
				return null;
			}
			
			bill_data = readZipToString(temp);
			
			temp.delete();
			
			return bill_data;
		}		
		
		return null;
	}
	
	private String readZipToString(File file) {
       String connet = "";
       try {
           ZipInputStream in = new ZipInputStream(new FileInputStream(file), Charset.forName("gbk")); 
           //不解压直接读取,加上gbk解决乱码问题 
           BufferedReader br = new BufferedReader(new InputStreamReader(in, "gbk"));  
           ZipEntry zipFile;
           //循环读取zip中的cvs文件，无法使用jdk自带，因为文件名中有中文 
           while ((zipFile=in.getNextEntry()) != null) {
               if (zipFile.isDirectory()){
                   //如果是目录，不处理 
               }
               String file_connet = "";
               //获得cvs名字 
               String fileName = zipFile.getName();
               //检测文件是否存在 
               if (fileName != null && !fileName.contains("汇总")) {
                    String line;
                    /*
                     * 1.每一行用 | 隔开
                     * 2.每一个文件用 ; 隔开
                     */
                    while ((line = br.readLine()) != null) {                     
                    	file_connet = file_connet + "|" + line;                     
                    }   
               }
                
               connet = connet + file_connet + ";";
           }

           br.close(); 
           in.close();                        
       } 
       catch (Exception e) {
 
         return "false";
       }
         
       return connet;
	}
	
	private boolean downLoadZip(String downloadbill_url, File f) {
        boolean down_success = false;
        int byteread = 0;
 
        InputStream inStream = null;
        FileOutputStream fs = null;
         
        try {         
            URL url = new URL(downloadbill_url);
            URLConnection conn = url.openConnection();
            inStream = conn.getInputStream();
             
            fs = new FileOutputStream(f);
 
            byte[] buffer = new byte[4028];
 
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
            }
            down_success = true;
        } catch (Exception e) {
            e.printStackTrace();
 
            return false;
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {
                inStream = null;
            }
 
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                fs = null;
            }
        }
        return down_success;
	}
	
	private AlipayDataDataserviceBillDownloadurlQueryResponse getDownloadBillResponse(FDate date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		AlipayClient alipayClient = new DefaultAlipayClient(Configs.getOpenApiDomain(), Configs.getAppid(), Configs.getPrivateKey(),
				"json", "utf-8", Configs.getAlipayPublicKey(), Configs.getSignType());//获得初始化的AlipayClient
		
		AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();//创建API对应的request类
		request.setBizContent("{" +
		"    \"bill_type\":\"trade\"," +
		"    \"bill_date\":\"" + sdf.format(date.toDate()) + "\"}"); //设置业务参数
		
		try {
			return alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
		}
		catch (AlipayApiException e) {
			return null;
		}
	}
}

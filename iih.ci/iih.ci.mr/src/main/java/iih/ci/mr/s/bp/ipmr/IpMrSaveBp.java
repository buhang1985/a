package iih.ci.mr.s.bp.ipmr;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.common.primitives.Ints;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.mrname.i.ICiMrNameParamService;
import iih.ci.mr.mrsign.d.CiMrSignCaDO;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.i.ICiMrSignCaDORService;
import iih.ci.mr.mrsign.i.IMrsignMDORService;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class IpMrSaveBp {


	/** 病历产生电子文档
	 * @param lsImage
	 * @param ciMrDo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public  FArrayList2 engenderMrEleDoc(String[] lsImage,CiMrDO ciMrDo) throws BizException{
		
		 // 参数
         ICiMrParamService paramService=ServiceFinder.find(ICiMrParamService.class);
         String SaveFormat=paramService.getSysParamSaveFormat(Context.get().getOrgId());  
		 String idSaveFormat = ICiMrDictCodeConst.ID_BD_MRM_DATAFORAMT_IMAGE;
         String sdSaveFormat = ICiMrDictCodeConst.SD_BD_MRM_DATAFORAMT_IMAGE;
         if ("2".equals(SaveFormat)){
             idSaveFormat = ICiMrDictCodeConst.ID_BD_MRM_DATAFORAMT_PDF;
             sdSaveFormat = ICiMrDictCodeConst.SD_BD_MRM_DATAFORAMT_PDF;
         }
         else if(!"1".equals(SaveFormat)){
             return null;
         }
         
         // 参数
         ICiamrRService ciamrService=ServiceFinder.find(ICiamrRService.class);
         AMrDO[] aMrDOs = ciamrService.find("id_ent='" + ciMrDo.getId_ent() + "'", "", FBoolean.FALSE);
         ICimrmfileinfoRService fileInfoService=ServiceFinder.find(ICimrmfileinfoRService.class);
         CiMrmFileInfoDO[] fileInfoDOs = fileInfoService.find("id_ci_amr='"+ aMrDOs[0].getId_enhr() +"'",CiMrmFileInfoDO.SORTNO, FBoolean.FALSE);
         int count=0;
         if (fileInfoDOs != null && fileInfoDOs.length>0){
        	 for(CiMrmFileInfoDO infoDo:fileInfoDOs){
        		 Integer parsedResult = Ints.tryParse(infoDo.getName());
        		 if(parsedResult!=null){
        			 if (infoDo.getName().length() == 3){
        				 if (parsedResult > count)
         	                 count = parsedResult;
                     }
                 }			
              }
          }
          String strResult = padRight(String.valueOf(count+1),3,'0'); //001 
          
          // 参数
          CiMrmFileInfoDO[] infoDOs = fileInfoService.find("id_bu_sy ='" + ciMrDo.getId_mr() + "' ", "sv desc", FBoolean.FALSE);
         
          // 参数
          IMrsignMDORService signService=ServiceFinder.find(IMrsignMDORService.class);
          CiMrSignDO[] mrsign = signService.find("id_mr = '" + ciMrDo.getId_mr() + "'", "sv desc", FBoolean.FALSE);
          CiMrSignCaDO[] ciMrSignCa = null;
          if (mrsign != null && mrsign.length > 0){
        	  ICiMrSignCaDORService signCa=ServiceFinder.find(ICiMrSignCaDORService.class);
              ciMrSignCa = signCa.find("id_mrsign = '" + mrsign[0].getId_mrsign() + "'", "sv desc", FBoolean.FALSE);
          }
          
          // 参数
          ICiMrNameParamService paramService2=ServiceFinder.find(ICiMrNameParamService.class);
          String nameParam=paramService2.GetMrNameParam(Context.get().getOrgId()); 
                 
          FArrayList2 fArrayList2 = new FArrayList2();
          for(int i = 0; i < lsImage.length; i++){
        	  FArrayList lsEleDoc = new FArrayList();
        	  
        	  lsEleDoc.add(lsImage[i]);
        	  lsEleDoc.add(ciMrDo.getId_ent());
              lsEleDoc.add(ciMrDo.getId_mr());
              lsEleDoc.add(ciMrDo.getId_mrtp());
              
              if("1001".equals(nameParam)){
            	  lsEleDoc.add(ciMrDo.getName());
              }else if("1002".equals(nameParam)){
            	  SimpleDateFormat  df=new SimpleDateFormat("yyyyMMddHHmmss");
            	  lsEleDoc.add(df.format(new Date()));
              }else if("1003".equals(nameParam)){
            	  lsEleDoc.add(strResult);
              }
              
              lsEleDoc.add(idSaveFormat);
              lsEleDoc.add(sdSaveFormat);
              lsEleDoc.add("False");
              
              if (fileInfoDOs != null && fileInfoDOs.length > 0){
            	  lsEleDoc.add(String.valueOf(fileInfoDOs.length+1));
     
              }else{
            	  lsEleDoc.add(String.valueOf(i+1));
              }
              
              // 文件系统路径
              if (infoDOs != null && infoDOs.length > 0){
                  lsEleDoc.add(infoDOs[0].getCode_file());
              }
              else{
                  lsEleDoc.add("");
              }
              
              if (FBoolean.TRUE.equals(ciMrDo.getFg_sign()) && mrsign != null && mrsign.length > 0 && ciMrSignCa != null && ciMrSignCa.length > 0){
                  lsEleDoc.add("True");
                  lsEleDoc.add(ciMrSignCa[0].getPlain_sign_time());
                  lsEleDoc.add(mrsign[0].getId_emp_sign());
                  lsEleDoc.add(mrsign[0].getId_dep());
                  lsEleDoc.add(mrsign[0].getName_psn());
                  lsEleDoc.add(mrsign[0].getName_dept());
                  lsEleDoc.add(mrsign[0].getEu_pat_sign());
                  lsEleDoc.add(mrsign[0].getName_pat_sign());
              }
              else{
                  lsEleDoc.add("False");
                  lsEleDoc.add("");
                  lsEleDoc.add("");
                  lsEleDoc.add("");
                  lsEleDoc.add("");
                  lsEleDoc.add("");
                  lsEleDoc.add("");
                  lsEleDoc.add("");
              }   
              fArrayList2.add(lsEleDoc);
          }
		  return fArrayList2;
	}
	
	
	public String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }
        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
	}
}

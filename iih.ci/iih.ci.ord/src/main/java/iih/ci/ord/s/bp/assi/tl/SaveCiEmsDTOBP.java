/**
 * 
 */
package iih.ci.ord.s.bp.assi.tl;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.assi.CiEmsValidate;
import iih.ci.sdk.utils.StringUtils;

/**
 * @ClassName: SaveCiEmsDTOBP
 * @Description: 多医嘱的保存
 * @author Comsys-li_zheng
 * @date 2016年9月13日 下午7:41:47
 * @Package iih.ci.ord.s.bp.assi
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class SaveCiEmsDTOBP {
	
	public static MoreEmsParamDTO SaveCiEmsDTO(CiEnContextDTO envinfo,CiEmsDTO[] ciEms,MoreEmsParamDTO param)throws BizException{
		if(param==null){
			param = new MoreEmsParamDTO();
		}
		 // 保存成功的医嘱
		 FArrayList2 orderList = new FArrayList2();
		 StringBuffer errorinfoBuffer = new StringBuffer();
		 int num = 1;
		 FArrayList errorEmsList = new FArrayList();
		 List<String> errorList= new ArrayList<String>();
		 if(ciEms != null && ciEms.length >0){
			 ICiOrdMaintainService orderMainService = ServiceFinder.find(ICiOrdMaintainService.class); 
		     for(CiEmsDTO EmsDTO: ciEms){
		    	 try{
		    		 CiEmsValidate bp = new CiEmsValidate();
		    		 CiTmplValidateRstDTO validateRst = bp.exec(EmsDTO,errorList);
		    		 if(validateRst==null || CiTmplValidateRstDTO.INFO.compareTo(validateRst.getLevel()) == 0){
		    			// 校验通过，则可以保存，保存不成功，或者保存存在异常，将其添加到错误队列中
		    			// CiOrderDO[] ciOrders = orderMainService.SaveCiEmsDTO_TL(EmsDTO,envinfo);
		    			 EmsRstDTO[] rst= orderMainService.SaveCiEmsDTO_TL_new(EmsDTO,envinfo);
		    			 for (EmsRstDTO emsRstDTO : rst) {
							CiOrderDO dto=(CiOrderDO)emsRstDTO.getDocument().get(0);
							orderList.add(dto);
		    			 }
		    			 FMap2 emsExtMap = rst[0].getExtension();
		    			 if(emsExtMap.containsKey("RelSrvMessageList")) {
		    				 CiOrderDO dto=(CiOrderDO)rst[0].getDocument().get(0);
		    				 String msg = (String)emsExtMap.get("RelSrvMessageList");
		    				 String promptmsg=param.getPrompt_msg();
		    				 String prompt=promptmsg==null?"\r\n"+dto.getName_or()+":"+msg:promptmsg+" \r\n "+dto.getName_or()+":"+msg;
		    				 param.setPrompt_msg(prompt);
		    			 }
//		    			 for(CiOrderDO ciorder:ciOrders){
//		    				 orderList.add(ciorder);
//		    			 }
		    		 }else if(CiTmplValidateRstDTO.WARN.compareTo(validateRst.getLevel())==0){
		    			 param.addErrorEms(num+EmsDTO.getName()+ new Date().getTime(), EmsDTO); // !!!暂时添加
		    		      num ++;
		    		 }else if(CiTmplValidateRstDTO.ERROR.compareTo(validateRst.getLevel())>=0){
		    			 //错误级别，不能保存，也不能在医疗单打开
		    		 }
		    		 
		    		 for(String errorStr : errorList){
		    			 if(!(errorinfoBuffer.indexOf(errorStr)!=-1)) {
		    				 errorinfoBuffer.append(errorStr).append(System.lineSeparator());
		    			 }
		    		 }
		    		
		    		 
		    	 }catch(Exception e){
		    		 num ++;
		    		 e.printStackTrace();
		    		 e.getMessage();
		    		 errorinfoBuffer.append( e.getMessage()).append(System.lineSeparator());
		    		 errorEmsList.add(EmsDTO); // 注意这行代码有错误：当两个医疗单发生相同的错误时候，最后一个发生错误的医疗单得到保存，前者会被覆盖
		    		 continue;
		    	 }
		    	 finally
		    	 {
		    		 //Errormap2.put(EmsDTO.getName() + new Date().toString(), EmsDTO); // !!!暂时添加
		    	 }
		     }
		 }
		 //医嘱列表
		  FMap2  Ordermap2 = new FMap2();
		  /*String whereStr =" id_en ='"+envinfo.getId_en()+"'";
		  CiOrderDO[] orders = CiOrdAppUtils.getOrQryService().find(whereStr, "id_en", FBoolean.FALSE);		  
		  orderList.addAll(Arrays.asList(orders));*/
		  Ordermap2.put("orders", orderList);		  
		  param.setOrdermap2(Ordermap2);
		  //错误信息
		  if(!CiOrdUtils.isEmpty(errorEmsList)){
			  for(Object obj : errorEmsList){
				  CiEmsDTO dto  = (CiEmsDTO)obj;
				  param.addErrorEms(dto);
				}
		  }
		  //Errormap2.put("errorOrders", errorEmsList);
		  param.setErrorinfo(StringUtils.isEmptty(param.getErrorinfo())?errorinfoBuffer.toString():(param.getErrorinfo()+System.lineSeparator()+errorinfoBuffer.toString()));
		 //返回 成功的和本次就诊的医嘱和错误的信息
		
		return param;
	}

}

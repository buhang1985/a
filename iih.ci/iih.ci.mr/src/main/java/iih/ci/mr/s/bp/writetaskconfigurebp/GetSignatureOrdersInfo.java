package iih.ci.mr.s.bp.writetaskconfigurebp;

import java.util.ArrayList;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrPubUtils;

public class GetSignatureOrdersInfo {

	public CiOrderDO[] getOrdInfo8Status(Object[] newObjs,String orderclassify){
		CiOrderDO ordo;
		ArrayList<CiOrderDO> rtn=new ArrayList<CiOrderDO>();		
		//遍历
		for(Object obj: newObjs){
			ordo=(CiOrderDO) obj;	
			//if(!isOrStatus(ordo,flag))continue;		
			//是否为特定类型医嘱
			if(!isSpecificOrder(ordo,orderclassify))continue;		
			//加入列表中
			rtn.add(ordo);
		}	
		//空判断
		if(rtn==null || rtn.size()==0)return null;		
		return rtn.toArray(new CiOrderDO[0]);
	}
	
	public boolean isSpecificOrder(CiOrderDO or,String orderclassify) {
		boolean flag=false;
		switch(orderclassify){
		  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_SHOUSHU:
			  flag=CiOrderTypeEnum.OPERATIONORDER.equals(CiOrPubUtils.getCiOrderType(or))
						|| CiOrderTypeEnum.BEDOPORDER.equals(CiOrPubUtils.getCiOrderType(or))
						|| CiOrderTypeEnum.ALLOPORDER.equals(CiOrPubUtils.getCiOrderType(or));
			  break;
		  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_HUIZHEN:
			  flag=CiOrderTypeEnum.CONSULTORDER.equals(CiOrPubUtils.getCiOrderType(or));
			  break;
		  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_BINGWEI:
			  flag=CiOrderTypeEnum.ILLSTATEORDER.equals(CiOrPubUtils.getCiOrderType(or));
			  break;  
		  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_SIWANG:
			  flag=CiOrderTypeEnum.DEATHORDER.equals(CiOrPubUtils.getCiOrderType(or));
			  break; 
		  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_CHUYUAN:
			  flag=CiOrderTypeEnum.OUTHOSPORDER.equals(CiOrPubUtils.getCiOrderType(or));
			  break; 
		  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_QIANGJIU:
			  flag=CiOrderTypeEnum.RESCUEORDER.equals(CiOrPubUtils.getCiOrderType(or));
			  break; 
		  case ICiMrDictCodeConst.SD_MR_TASK_EVENT_ZHUANCHU:
			  flag=CiOrderTypeEnum.DEPT2DEPTORDER.equals(CiOrPubUtils.getCiOrderType(or));
			  break; 
		  case IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A:
			  flag=IBdSrvDictCodeConst.SD_SRVTP_ENTRUST_A.equals(or.getSd_srvtp())
			       && "术后医嘱".equals(or.getName_or());
			  break; 
		}
		return flag;
	}
}

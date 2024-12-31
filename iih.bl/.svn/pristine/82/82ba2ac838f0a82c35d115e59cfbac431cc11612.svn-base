package iih.bl.cc.ebs.st;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.cc.ebs.dg.dto.OutpatientincomeDTO;
import iih.bl.cc.ebs.erp.GatherDispBatchDataBP;
import xap.mw.core.data.BizException;

public class GatherPatRegistInBatchDataBP {
	public void exec(String beathType, String midTableParam,String selectDate) throws BizException{	
		//1.本域数据插入中间表
		OutpatientincomeDTO[] outpatientincomeDTO=new GatherDispOPDataBP().exec(midTableParam,selectDate,beathType);
		//2.如果有业务数据，就插入日志
		if(!ArrayUtils.isEmpty(outpatientincomeDTO)){
			MpIFaceBatchDO logDo = new GatherDispBatchDataBP().exec(outpatientincomeDTO[0].getIface_batch_id().toString(),beathType,midTableParam,selectDate);
		}
	}
}

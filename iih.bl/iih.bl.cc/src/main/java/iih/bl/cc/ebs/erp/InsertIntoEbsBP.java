package iih.bl.cc.ebs.erp;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.cc.ebs.dg.MpIFaceMidDO;
import xap.mw.core.data.BizException;

/**
 * 本his数据插入ebs中间表逻辑类
 * @author 
 *
 */
public class InsertIntoEbsBP {

	public void exec(String midTableParam,String selectDate) throws BizException{			
		//1.本域数据插入中间表
		MpIFaceMidDO[] mpIFaceMidDO= new GatherDispDataBP().exec(midTableParam,selectDate);
	    //2.如果数据表插入数据不为空，则插入日志表
	    if(!ArrayUtils.isEmpty(mpIFaceMidDO)){
	    	MpIFaceBatchDO logDo = new GatherDispBatchDataBP().exec(mpIFaceMidDO[0].getIface_batch_id().toString(), "MEDIC",midTableParam,selectDate);
	    }
	}
	/**
	 * 删除当天的日志和业务数据
	 * @param table
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private void deleteTableData(String table,String date,String sWhere,boolean isbatch)throws BizException {
		MpOperateEbsUtil.deleteTableData(table, date,sWhere,isbatch);
	 
	}		
}

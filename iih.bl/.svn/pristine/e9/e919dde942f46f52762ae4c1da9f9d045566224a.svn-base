package iih.bl.cc.ebs.erp;

import iih.bl.cc.ebs.dg.MpIFaceBatchDO;
import iih.bl.comm.log.BLTaskLogger;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
/**
 * 
 *  汇总当天已收费发药数据(住院和门诊)，插入到IIH中间日志表
 * 
 * @author shaosq
 * @date 2016年10月17日  下午5:37:08
 */
public class GatherDispBatchDataBP {
/**
 * 
 * @param batcheType
 * @param midTableParam
 * @param date 同步日期
 * @param chargeDate 数据记账日期
 * @return
 * @throws BizException
 */
	
	public MpIFaceBatchDO exec(String iface_batch_id,String batcheType,String midTableParam,String date) throws BizException {
		String dec="";
		MpIFaceBatchDO batchDo = new MpIFaceBatchDO();
//		batchDo.setIface_batch_id(MpOperateEbsUtil.getMaxBatchId(midTableParam.split(",")[0],FBoolean.TRUE).toString());
		batchDo.setIface_batch_id(iface_batch_id);
		batchDo.setHospital_code("100");
		batchDo.setBatch_type(batcheType);
		batchDo.setSync_date(new FDateTime());
		batchDo.setProcess_flag("N");
		// by lim 日志表Description字段需要赋值
		batchDo.setDescription(getDesc(batcheType,date));
		List<MpIFaceBatchDO> batchDos = new ArrayList<MpIFaceBatchDO>();
		batchDos.add(batchDo);
		try {
			MpOperateEbsUtil.saveBatchData(batchDos,midTableParam.split(",")[0]);
		} catch (BizException ex) {
			BLTaskLogger.info("保存数据到IIh中间日志表出错！");
		}

		return batchDo;
	}
	/**
	 * 获取日志表描述字段Description
	 * @param batcheType
	 * @param date
	 * @return
	 */
	private String getDesc(String batcheType,String date){
		String sDesc="";
		switch (batcheType) {
		case "J3":
			sDesc=date+" 普通挂号";
			break;
		case "J4":
			sDesc=date+" 门诊收费";
			break;
		case "JY":
			sDesc=date+" 门诊预交金";
			break;
		case "JN":
			sDesc=date+" 门诊预付费消费明细";
			break;
		case "JO":
			sDesc=date+" 门诊预付费结算";
			break;			
		}
		return sDesc;
	}
}

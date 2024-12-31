package iih.bl.cc.ebs.st.bp;

import iih.bd.base.utils.DateTimeUtils;
import iih.bl.cc.ebs.params.Params;
import iih.bl.cc.ebs.st.GatherPatRegistInBatchDataBP;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.coreitf.d.FDateTime;

public class STOutPatientAppDataBP {
	public void exec(String bath_type,String selectDate) {
		BLTaskLogger.info("与ERP同步门诊收入数据定时任务开始："+new FDateTime());	
		try{
			// 将本域数据汇总插入到中间表
			String midTableParam=new Params().midTableParam_J;// "CUX_GL_HIS_IIH_BATCH_IFACE,CUX_GL_HIS_IIH_CHARGE_IFACE";
			GatherPatRegistInBatchDataBP mpPluginBp = new GatherPatRegistInBatchDataBP();
			//获取传入日期前一天的日期
			String date=DateTimeUtils.getSpecifiedDayBefore(selectDate);
			mpPluginBp.exec(bath_type,midTableParam,date);
		}catch(Exception ex){
			BLTaskLogger.error("与ERP同步门诊收入数据定时任务失败", ex);
		}
		BLTaskLogger.info("与EBS同步门诊挂号收入数据定时任务结束。"+new FDateTime());
	}
}

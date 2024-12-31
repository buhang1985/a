package iih.bl.cc.ebs.erp.bp;

import iih.bd.base.utils.DateTimeUtils;
import iih.bl.cc.ebs.erp.InsertIntoEbsBP;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;

/**
 * 同步到iih中间表服务
 * @author Administrator
 *
 */
public class MpCreateMedAppliDataBP {
	
	public void exec(String selectDate) {
		BLTaskLogger.info("与ERP同步发药数据定时任务开始："+new FDateTime());
	
		try{
			//IIH日志表，IIH中间表，原HIS日志表，原HIS中间表，EBS日志表，EBS中间表
			//String midTableParam = new Params().MPDGIPOP0014();
			String midTableParam="CUX_GL_HIS_IIH_BATCH_IFACE,CUX_INV_HIS_IIH_MEDIC_IFACE,CUX_GL_HIS_CHIS_BATCH_IFACE,CUX_INV_HIS_CHIS_MEDIC_IFACE,CUX_GL_HIS_BATCH_IFACE,CUX_INV_HIS_MEDIC_IFACE";
			if(StringUtil.isEmpty(midTableParam)){
				BLTaskLogger.info("ERP对接中间表参数设置异常，请检查参数：MPDGIPOP0014");
				return;
			}
			
			// 将本域发药数据汇总插入到中间表
			InsertIntoEbsBP mpPluginBp = new InsertIntoEbsBP();
			//获取传入日期的前一天 lim
			selectDate=DateTimeUtils.getSpecifiedDayBefore(selectDate);
			mpPluginBp.exec(midTableParam,selectDate);
			
		}catch(Exception ex){
			BLTaskLogger.error("与ERP同步发药数据定时任务开始失败", ex);
		}
	}
}

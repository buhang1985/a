package iih.bl.cc.ebs.erp.bp;

import iih.bd.base.utils.DateTimeUtils;
import iih.bl.cc.ebs.erp.CombineErpDataBP;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 合并数据到ebs中间表
 * @author Administrator
 *
 */
public class MpCombinOldHisDataToErpBP {
	
	public void exec(String selectDate) {
		BLTaskLogger.info("合并原His发药数据到ERP中间表定时任务开始："+new FDateTime());
	
		try{
			//IIH日志表，IIH中间表，原HIS日志表，原HIS中间表，EBS日志表，EBS中间表
			//String midTableParam = new Params().MPDGIPOP0014();
			String midTableParam="CUX_GL_HIS_IIH_BATCH_IFACE,CUX_INV_HIS_IIH_MEDIC_IFACE,CUX_GL_HIS_CHIS_BATCH_IFACE,CUX_INV_HIS_CHIS_MEDIC_IFACE,CUX_GL_HIS_BATCH_IFACE,CUX_INV_HIS_MEDIC_IFACE";
			if(StringUtil.isEmpty(midTableParam)){
				BLTaskLogger.info("ERP对接中间表参数设置异常，请检查参数：MPDGIPOP0014");
				return;
			}
			
			// 汇总老HIS系统数据，共同插入到EBS中间表
			CombineErpDataBP comErpBP = new CombineErpDataBP();
			if(StringUtil.isEmpty(selectDate))
				selectDate=  new FDate().toString();
			//获取前一天数据
			selectDate=DateTimeUtils.getSpecifiedDayBefore(selectDate);
			comErpBP.exec(midTableParam,selectDate);
		}catch(Exception ex){
			BLTaskLogger.error("合并原His发药数据到ERP中间表定时任务开始失败", ex);
		}
	}
}

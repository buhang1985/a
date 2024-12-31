package iih.bl.cc.ebs.st.bp;

import iih.bd.base.utils.DateTimeUtils;
import iih.bl.cc.ebs.st.CombinePatRegistInDataBP;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.coreitf.d.FDateTime;

public class STCombinHisToErpBP {
	public void exec(String selectDate) {
		BLTaskLogger.info("合并原门诊收入数据到ERP中间表定时任务开始："+new FDateTime());
		
		try{
			//IIH日志表，IIH中间表，原HIS日志表，原HIS中间表，EBS日志表，EBS中间表
			String midTableParam= "CUX_GL_HIS_IIH_BATCH_IFACE,CUX_GL_HIS_IIH_CHARGE_IFACE,CUX_GL_HIS_CHIS_BATCH_IFACE,CUX_GL_HIS_CHIS_CHARGE_IFACE,CUX_GL_HIS_BATCH_IFACE,CUX_GL_HIS_CHARGE_IFACE";
			// 汇总老HIS系统数据，共同插入到EBS中间表
			CombinePatRegistInDataBP comErpBP = new CombinePatRegistInDataBP();
			//获取前一天数据
			selectDate=DateTimeUtils.getSpecifiedDayBefore(selectDate);
			comErpBP.exec(midTableParam,selectDate,"J3") ;
			comErpBP.exec(midTableParam,selectDate,"J4") ;
			comErpBP.exec(midTableParam,selectDate,"JY") ;
			comErpBP.exec(midTableParam,selectDate,"JO") ;
			comErpBP.exec(midTableParam,selectDate,"JN") ;
			//comErpBP.exec(midTableParam,"2017-05-31");
		}catch(Exception ex){
			BLTaskLogger.error("合并原门诊收入数据到ERP中间表定时任务失败",ex);
		}
		BLTaskLogger.info("合并原门诊收入数据到ERP中间表定时任务结束。"+new FDateTime());
	}
}

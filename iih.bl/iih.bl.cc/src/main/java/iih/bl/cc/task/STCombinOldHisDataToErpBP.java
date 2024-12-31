package iih.bl.cc.task;

import iih.bl.cc.ebs.erp.CombineErpDataBP;
import iih.bl.cc.ebs.erp.ErpSqlCondHelper;
import iih.bl.cc.ebs.st.CombinePatRegistInDataBP;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
/**
 * 将ebs中间库数据合并到最终的中间库
 * @author LIM
 *
 */
public class STCombinOldHisDataToErpBP implements IBackgroundWorkPlugin {
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc)
			throws BizException {
		PreAlertObject retObj = new PreAlertObject();	
		BLTaskLogger.info("合并原门诊收入数据到ERP中间表定时任务开始："+new FDateTime());
	
		try{
			//IIH日志表，IIH中间表，原HIS日志表，原HIS中间表，EBS日志表，EBS中间表
			String midTableParam="CUX_GL_HIS_IIH_BATCH_IFACE,CUX_GL_HIS_IIH_CHARGE_IFACE,CUX_GL_HIS_CHIS_BATCH_IFACE,CUX_GL_HIS_CHIS_CHARGE_IFACE,CUX_GL_HIS_BATCH_IFACE,CUX_GL_HIS_CHARGE_IFACE";
			
			String date =ErpSqlCondHelper.getCurrentDateBefore();
			//date="2017-10-12" ;
			// 汇总老HIS系统数据，共同插入到EBS中间表
			CombinePatRegistInDataBP comErpBP = new CombinePatRegistInDataBP();
			comErpBP.exec(midTableParam,date,"J3") ;
			comErpBP.exec(midTableParam,date,"J4") ;
			comErpBP.exec(midTableParam,date,"JO") ;
			comErpBP.exec(midTableParam,date,"JY") ;
			comErpBP.exec(midTableParam,date,"JN") ;
			//comErpBP.exec(midTableParam,"2017-05-31");
			
			//合并发药数据
			midTableParam="CUX_GL_HIS_IIH_BATCH_IFACE,CUX_INV_HIS_IIH_MEDIC_IFACE,CUX_GL_HIS_CHIS_BATCH_IFACE,CUX_INV_HIS_CHIS_MEDIC_IFACE,CUX_GL_HIS_BATCH_IFACE,CUX_INV_HIS_MEDIC_IFACE";
			CombineErpDataBP combineErpDataBP= new CombineErpDataBP();
			combineErpDataBP.exec(midTableParam, date);
		}catch(Exception ex){
			BLTaskLogger.error("合并原门诊收入数据到ERP中间表定时任务失败", ex);
		}
		BLTaskLogger.info("合并原门诊收入数据到ERP中间表定时任务结束。"+new FDateTime());
		return retObj;		
	}
}

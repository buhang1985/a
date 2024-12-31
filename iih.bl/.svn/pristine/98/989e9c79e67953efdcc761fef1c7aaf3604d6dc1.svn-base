 package iih.bl.cc.ebs.st;

import iih.bl.cc.ebs.erp.ErpSqlCondHelper;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
/**
 * by li 2017-05-26 同步门诊收入到中间库
 * @author LIM
 *
 */
public class STEBSOutpatientRegistrationPlugin  implements IBackgroundWorkPlugin  {
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc)
			throws BizException {
		BLTaskLogger.info("与EBS同步门诊挂号收入数据定时任务开始："+new FDateTime());
		PreAlertObject retObj = new PreAlertObject();
//		retObj.setReturnType(PreAlertReturnType.RETURNNOTHING);
	
		try{
			String date =ErpSqlCondHelper.getCurrentDateBefore();
						
			// 将本域发药数据汇总插入到中间表
			String midTableParam="IIH_GL_HIS_BATCH_IFACE,IIH_GL_HIS_CHARGE_IFACE";
			GatherPatRegistInBatchDataBP mpPluginBp = new GatherPatRegistInBatchDataBP();
			mpPluginBp.exec("J3",midTableParam,date);
			mpPluginBp.exec("J4",midTableParam,date);
			mpPluginBp.exec("JY",midTableParam,date);
			mpPluginBp.exec("JN",midTableParam,date);
			mpPluginBp.exec("JO",midTableParam,date);
//			mpPluginBp.exec("J3",midTableParam,"2017-04-11");
//			mpPluginBp.exec("J4",midTableParam,"2017-04-11");
//			mpPluginBp.exec("JY",midTableParam,"2017-05-03");
//			mpPluginBp.exec("JN",midTableParam,"2017-05-03");
//			mpPluginBp.exec("JO",midTableParam,"2017-05-03");
//			
		}catch(Exception ex){
			BLTaskLogger.error("与EBS同步门诊挂号收入数据定时任务失败",ex);
		}
		BLTaskLogger.info("与EBS同步门诊挂号收入数据定时任务结束。"+new FDateTime());
		
		return retObj;		
	}
}

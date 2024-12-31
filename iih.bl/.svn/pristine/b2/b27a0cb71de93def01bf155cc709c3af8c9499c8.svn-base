package iih.bl.cc.ebs.erp;

import iih.bl.cc.ebs.params.Params;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 
 * 与ERP同步发药数据定时任务 
 * 
 * @author shaosq
 * @date 2016年10月16日  下午11:41:27
 */
public class MpCreateMedAppliDataPlugin implements IBackgroundWorkPlugin {
	
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc)
			throws BizException {
		
		BLTaskLogger.info("与ERP同步发药数据定时任务开始："+new FDateTime());
		PreAlertObject retObj = new PreAlertObject();
//		retObj.setReturnType(PreAlertReturnType.RETURNNOTHING);
	
		try{
			//IIH日志表，IIH中间表，原HIS日志表，原HIS中间表，EBS日志表，EBS中间表
			String midTableParam = new Params().MPDGIPOP0014();
			if(StringUtil.isEmpty(midTableParam)){
				BLTaskLogger.info("ERP对接中间表参数设置异常，请检查参数：MPDGOP0014");
				return retObj;
			}
			
			// 将本域发药数据汇总插入到中间表
			InsertIntoEbsBP mpPluginBp = new InsertIntoEbsBP();
			mpPluginBp.exec(midTableParam,null);
			
		}catch(Exception ex){
			BLTaskLogger.error("与ERP同步发药数据定时任务开始失败", ex);;
		}
		BLTaskLogger.info("与ERP同步发药数据定时任务结束。"+new FDateTime());
		
		return retObj;
	}
}

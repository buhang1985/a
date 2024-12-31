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
 * 合并原His发药数据到ERP中间表定时任务
 * 
 * @author shaosq
 * @date 2016年10月24日  下午13:20:27
 */
public class MpCombinOldHisDataToErpPlugin implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		
		BLTaskLogger.info("合并原His发药数据到ERP中间表定时任务开始："+new FDateTime());
		PreAlertObject retObj = new PreAlertObject();
//		retObj.setReturnType(PreAlertReturnType.RETURNNOTHING);
	
		try{
			//IIH日志表，IIH中间表，原HIS日志表，原HIS中间表，EBS日志表，EBS中间表
			String midTableParam = new Params().MPDGIPOP0014();
			if(StringUtil.isEmpty(midTableParam)){
				BLTaskLogger.info("ERP对接中间表参数设置异常，请检查参数：MPDGOP0014");
				return retObj;
			}
			String date =ErpSqlCondHelper.getCurrentDateBefore();
			// 汇总老HIS系统数据，共同插入到EBS中间表
			CombineErpDataBP comErpBP = new CombineErpDataBP();
			comErpBP.exec(midTableParam,date);
		}catch(Exception ex){
			BLTaskLogger.error("合并原His发药数据到ERP中间表定时任务失败",ex);
		}
		BLTaskLogger.info("合并原His发药数据到ERP中间表定时任务结束。"+new FDateTime());
		
		return retObj;
	}

}

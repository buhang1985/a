 package iih.bl.cc.task;

import iih.bl.cc.ebs.erp.ErpSqlCondHelper;
import iih.bl.cc.ebs.erp.InsertIntoEbsBP;
import iih.bl.cc.ebs.params.Params;
import iih.bl.cc.ebs.st.GatherPatRegistInBatchDataBP;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
/**
 * by li 2017-05-26 同步门诊收入到ebs中间库
 * @author LIM
 *
 */
public class STEBSOutpatientRegistrationPlugin  implements IBackgroundWorkPlugin  {
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwc)
			throws BizException {
		BLTaskLogger.info("与EBS同步门诊挂号收入数据定时任务开始："+new FDateTime());
		PreAlertObject retObj = new PreAlertObject();
		try{
			String date =ErpSqlCondHelper.getCurrentDateBefore();
			// 将本域数据汇总插入到中间表
			String midTableParam=new Params().midTableParam_J;//"CUX_GL_HIS_IIH_BATCH_IFACE,CUX_GL_HIS_IIH_CHARGE_IFACE";
			GatherPatRegistInBatchDataBP mpPluginBp = new GatherPatRegistInBatchDataBP();
			mpPluginBp.exec("J3",midTableParam,date);
			mpPluginBp.exec("J4",midTableParam,date);
			mpPluginBp.exec("JY",midTableParam,date);
			mpPluginBp.exec("JN",midTableParam,date);
			mpPluginBp.exec("JO",midTableParam,date);
			
			//发药数据
			//IIH日志表，IIH中间表，原HIS日志表，原HIS中间表，EBS日志表，EBS中间表
			midTableParam="CUX_GL_HIS_IIH_BATCH_IFACE,CUX_INV_HIS_IIH_MEDIC_IFACE,CUX_GL_HIS_CHIS_BATCH_IFACE,CUX_INV_HIS_CHIS_MEDIC_IFACE,CUX_GL_HIS_BATCH_IFACE,CUX_INV_HIS_MEDIC_IFACE";
			if(StringUtil.isEmpty(midTableParam)){
				BLTaskLogger.info("ERP对接中间表参数设置异常，请检查参数：MPDGIPOP0014");
				return retObj;
			}
			InsertIntoEbsBP insertIntoEbsBP = new InsertIntoEbsBP();
			insertIntoEbsBP.exec(midTableParam, date);		
		}catch(Exception ex){
			BLTaskLogger.error("与EBS同步门诊挂号收入数据定时任务失败", ex);
		}
		BLTaskLogger.info("与EBS同步门诊挂号收入数据定时任务结束。"+new FDateTime());
		
		return retObj;		
	}
}

package iih.ci.mrqc.s.bp.task;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import iih.ci.mrqc.cimrrecall.i.ICimrrecallCudService;
import iih.ci.mrqc.cimrrecall.i.ICimrrecallRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;

public class UpdateRecallTimeoutTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		// TODO Auto-generated method stub
		
		UpdWithSql();
		//UpdWithService();
		return null;
	}
	/**
	 * 使用sql更新
	 * @throws BizException
	 */
	private void UpdWithSql() throws BizException
	{
		DAFacade daf = new DAFacade(); 
		FDate fDate = new FDate();		
		String time_out = fDate.toLocalString();
		StringBuilder sql = new StringBuilder();
		sql.append("update ci_mr_recall  set fg_timeout = 'Y'");		
	    sql.append(" where id_state = '");
	    sql.append(ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_APPLY);
	    sql.append("' and dt_end < '");
	    sql.append(time_out);
	    sql.append("' and fg_timeout <> 'Y' and ds ='0'");
	    String sqlStr = sql.toString();
		daf.execUpdate(sqlStr);
	}
	
	/**
	 * 使用框架更新
	 */
	private void UpdWithService() throws BizException
	{
		//获取服务
		ICimrrecallRService CimrrecallRService =ServiceFinder.find(ICimrrecallRService.class);
		ICimrrecallCudService CimrrecallCudService = ServiceFinder.find(ICimrrecallCudService.class);
		if(CimrrecallRService!=null&&CimrrecallCudService!=null)
		{
			FDate fDate = new FDate();		
			String time_out = fDate.toLocalString();
			
			String sqlWhere ="id_state = '"+
			ICiMrDictCodeConst.ID_CIMRRECALL_STATUS_APPLY+"'"+
			"' and dt_end < '"+	time_out+
			"' and fg_timeout <> 'Y' and ds ='0'";
			
			CiMrRecallDO[] recalls = CimrrecallRService.find(sqlWhere, null, FBoolean.FALSE);
			if(recalls!=null&&recalls.length>0)
				CimrrecallCudService.save(recalls);
		}
		
	}
}

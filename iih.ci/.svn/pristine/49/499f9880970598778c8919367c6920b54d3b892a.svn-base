package iih.ci.mr.s.bp.task;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bs.workcalendar.i.IWorkcalendarExtService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

public class CiMrmAutoPigeonholeTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		// TODO Auto-generated method stub
		
		String id_grp = Context.get().getGroupId();
		
		IOrgRServiceExt orgRService =ServiceFinder.find(IOrgRServiceExt.class);
		OrgDO[] orgs = orgRService.queryAllOrgUnitVOsByGroupID(id_grp,false,true);//获取集团下所有组织id
		for(OrgDO org :orgs)
		{
			String id_org = org.getId_org();
			Context.get().setOrgId(id_org);
			if(CiMrParamUtils.GetSysParamMrmCiAutoPigeonhole(id_org))
			{
				
				//UpdWithSql(id_org);
				UpdWithService(id_org);
			}
			
		}
		
		return null;
	}
	
	/**
	 * 使用sql更新完成自动归档
	 * @param id_org
	 * @throws BizException
	 */
	private void UpdWithSql(String id_org) throws BizException
	{
		IWorkcalendarExtService calService = ServiceFinder.find(IWorkcalendarExtService.class);//工作日历
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);//参数
		int hours = CiMrParamUtils.GetSysParamMrmCiPigeonholeInterval(id_org);
		String id_cld = paraService.getSysParamHoliday(id_org);	//工作日历
		DAFacade daf = new DAFacade(); 	
		FDateTime fd = new FDateTime();
		
		String time_now = fd.toLocalString();
		//int days = hours/24;//目前取整，如果接口支持小数时可能需要改为double
		fd = calService.getEndDateTime(fd, -hours, id_cld);
		//fd = fd.addSeconds(-3600*hours);
		StringBuilder sql = new StringBuilder();
		sql.append("update ci_amr  set ci_amr.id_qa_doctor_part_sta = '");	
		sql.append(ICiMrDictCodeConst.ID_MR_HASTOFILE);
		sql.append("' , ci_amr.sd_qa_doctor_part_sta = '");
		sql.append(ICiMrDictCodeConst.SD_MR_HASTOFILE);
		sql.append("', ci_amr.dt_pigeonhole = '");
		sql.append(time_now);
		sql.append("',ci_amr.id_dep_pigeonhole ='IIH',ci_amr.id_user_pigeonhole ='IIH'");
		sql.append(" where exists(select * from en_ent_op where ci_amr.id_ent = en_ent_op.id_ent");
		 sql.append(" and ci_amr.id_qa_doctor_part_sta <> '");
		 sql.append(ICiMrDictCodeConst.ID_MR_HASTOFILE);
	    sql.append("' and en_ent_op.dt_valid_e < '");
	    sql.append(fd.toLocalString());
	    sql.append("' and ci_amr.ds ='0')");
	    String sqlStr = sql.toString();
		daf.execUpdate(sqlStr);
		
	}
	
	/**
	 * 使用框架完成自动归档
	 */
	private void UpdWithService(String id_org) throws BizException
	{
		//获得服务
		IOutpatientRService OutpatientRService = ServiceFinder.find(IOutpatientRService.class);
		ICiamrRService CiamrRService = ServiceFinder.find(ICiamrRService.class);
		ICiamrCudService CiamrCudService =  ServiceFinder.find(ICiamrCudService.class);
		IWorkcalendarExtService calService = ServiceFinder.find(IWorkcalendarExtService.class);//工作日历
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);//参数
		
		String id_cld = paraService.getSysParamHoliday(id_org);	//工作日历
		
		
		if(OutpatientRService!=null&&CiamrRService!=null&&CiamrCudService!=null)
		{
			int hours = CiMrParamUtils.GetSysParamMrmCiPigeonholeInterval(id_org);
			FDateTime fd = new FDateTime();
			FDateTime time_now = (FDateTime)fd.clone();
			//int days = hours/24;//目前取整，如果接口支持小数时可能需要改为double
			fd = calService.getEndDateTime(fd, -hours, id_cld);
			//fd = fd.addSeconds(-3600*hours);
			
			String sqlWhere_op = "dt_valid_e < '"+fd.toLocalString()+"'";
			OutpatientDO[] opDOs = OutpatientRService.find(sqlWhere_op, null, FBoolean.FALSE);
			
			
			if(opDOs!=null&&opDOs.length>0)
			{
				String opIds = "id_ent in ( '";
				int  count =0;
				for(OutpatientDO op :opDOs)
				{
					count+=1;
					if(count ==900)
					{
						opIds += op.getId_ent()+"' )";
						count =0;
					}
					
					else
						opIds += op.getId_ent()+"' ,'";
				}
				
				opIds = opIds.substring(0, opIds.length()-2)+")";
				
				String sqlWhere_amr = opIds+
						" and ds ='0' and id_qa_doctor_part_sta <> '"+
						ICiMrDictCodeConst.ID_MR_HASTOFILE+"'";
				
				AMrDO[] amrDOs = CiamrRService.find(sqlWhere_amr, null, FBoolean.FALSE);
				if(amrDOs!=null&&amrDOs.length>0)
				{
					for(AMrDO amr :amrDOs)
					{
						amr.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_HASTOFILE);
						amr.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_HASTOFILE);
						amr.setDt_pigeonhole(time_now);
						amr.setId_dep_pigeonhole("IIH");
						amr.setId_user_pigeonhole("IIH");
						amr.setStatus(DOStatus.UPDATED);
					}
					CiamrCudService.save(amrDOs);
				}
				
			}
			
		}
	}
}
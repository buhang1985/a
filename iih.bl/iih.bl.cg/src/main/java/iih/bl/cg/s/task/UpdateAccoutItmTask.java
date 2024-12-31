package iih.bl.cg.s.task;

import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.utils.BdPpParamUtils;
import iih.bl.comm.log.BLTaskLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

/**
 * 
 * 补充记账数据核算科目定时任务
 * @author ly 2018/10/28
 *
 */
public class UpdateAccoutItmTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		
		IOrgRServiceExt orgService = ServiceFinder.find(IOrgRServiceExt.class);
		OrgDO[] orgDos =  orgService.queryAllOrgUnitVOs();
		
		if(ArrayUtil.isEmpty(orgDos))
			return null;
		
		for (OrgDO orgDO : orgDos) {
			
			BLTaskLogger.info(String.format("组织%s补充记账数据核算科目定时任务开始", orgDO.getName()));
			Context.get().setGroupId(orgDO.getId_grp());
			Context.get().setOrgId(orgDO.getId_org());
			Context.get().setGroupNumber(orgDO.getGroupno());
		
			if(FBoolean.TRUE.equals(BdPpParamUtils.GetIfIIHAcSystem())){
				
				FBoolean fgShare = BdPpParamUtils.GetIfShareAcSystem();
				//门诊
				int opCnt = this.updateOpCg(fgShare);
				BLTaskLogger.info(String.format("组织%s补充记账数据核算科目定时任务,更新门诊记账数据%s条", orgDO.getName(), opCnt));
				
				//住院
				int ipCnt = this.updateIpCg(fgShare);
				BLTaskLogger.info(String.format("组织%s补充记账数据核算科目定时任务,更新住院记账数据%s条", orgDO.getName(), ipCnt));
			}else{
				BLTaskLogger.info(String.format("组织%s不启用IIH核算体系", orgDO.getName()));
			}
			BLTaskLogger.info(String.format("组织%s补充记账数据核算科目定时任务结束", orgDO.getName()));
		}
		return null;
	}
	
	/**
	 * 更新门诊记账数据
	 * @param fgShare
	 * @return
	 * @throws BizException
	 */
	private int updateOpCg(FBoolean fgShare) throws BizException{
		
		String accSystemId = FBoolean.TRUE.equals(fgShare) ? 
				IBdPpDictCodeConst.ID_ACCOUNT_GY : IBdPpDictCodeConst.ID_ACCOUNT_MZ;
		
		String sql = "update bl_cg_itm_oep set code_account = %s,name_account = %s where code_account is null and id_org = '%s' ";
		sql = String.format(sql,
				this.getValueSql("code", accSystemId, "bl_cg_itm_oep.id_srv"),
				this.getValueSql("name", accSystemId, "bl_cg_itm_oep.id_srv"),
				Context.get().getOrgId());
		
		return new DAFacade().execUpdate(sql);
	}
	
	/**
	 * 更新住院记账数据
	 * @param fgShare
	 * @return
	 * @throws BizException
	 */
	private int updateIpCg(FBoolean fgShare) throws BizException{
		
		String accSystemId = FBoolean.TRUE.equals(fgShare) ? 
				IBdPpDictCodeConst.ID_ACCOUNT_GY : IBdPpDictCodeConst.ID_ACCOUNT_ZY;
		
		String sql = "update bl_cg_ip set code_account = %s,name_account = %s where code_account is null and id_org = '%s' ";
		sql = String.format(sql,
				this.getValueSql("code", accSystemId, "bl_cg_ip.id_srv"),
				this.getValueSql("name", accSystemId, "bl_cg_ip.id_srv"),
				Context.get().getOrgId());
		
		return new DAFacade().execUpdate(sql);
	}
	
	/**
	 * 获取核算科目值sql
	 * @param column
	 * @return
	 */
	private String getValueSql(String column,String accSystemId, String srvId){
		
		String sql = "(select accca.%s from bd_account_ca accca "
				+ "inner join bd_account_ca_vs_srv accsrv "
				+ "on accca.id_accountca = accsrv.id_accountca "
				+ "where accsrv.id_account = '%s' "
				//+ "and accsrv.id_org = '%s' "
				+ "and accsrv.id_srv = %s ) ";
		
		sql = String.format(sql, column, accSystemId, srvId);
		return sql;
	}
}

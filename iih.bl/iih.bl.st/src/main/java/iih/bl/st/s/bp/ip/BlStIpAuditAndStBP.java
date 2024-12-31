package iih.bl.st.s.bp.ip;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.params.BlParams;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.i.IBlStCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 自动审核结算全部费用(出院结算)
 * @author ly 2019/04/08
 *
 */
public class BlStIpAuditAndStBP {

	/**
	 * 自动审核结算全部费用(出院结算)
	 * @param entId 就诊id
	 * @return 结算do
	 * @throws BizException
	 */
	public BlStIpDO exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("自动审核结算全部费用:入参就诊id为空");
		}
		
		//查询就诊记录
		DAFacade daf = new DAFacade();
		PatiVisitDO entDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
		if(entDO == null){
			throw new BizException("自动审核结算全部费用:未查询到就诊信息");
		}
		
		if(FBoolean.TRUE.equals(entDO.getFg_ip())){
			return null;
		}
		
		//查询是是否存在待结算数据
		boolean hasCanStData = this.hasCanStData(entId);
		if(!hasCanStData)
			return null;
		
		//保存审核记录
		IBlStCmdService stCmdService = ServiceFinder.find(IBlStCmdService.class);
		OperatorInfoDTO operDto = new OperatorInfoDTO();
		operDto.setId_grp(Context.get().getGroupId());
		operDto.setId_org(Context.get().getOrgId());
		operDto.setId_emp(Context.get().getStuffId());
		operDto.setId_dep(Context.get().getDeptId());
		stCmdService.saveIpAudit(entId, operDto);
		
		if(!StringUtil.isEmpty(entDO.getId_hp())){
			stCmdService.saveHpAudit(entId, operDto);
		}
		
		//结算
		String stId = stCmdService.doSettlement(entDO.getId_pat(), entDO.getId_ent(), "*",
				Context.get().getStuffId(), AppUtils.getServerDateTime());
		
		BlStIpDO stDO = (BlStIpDO)daf.findByPK(BlStIpDO.class, stId);
		
		return stDO;
	}
	
	/**
	 * 判断是否存在待结算数据
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean hasCanStData(String entId) throws BizException{
		
		FBoolean isMerge =  BlParams.BLSTIP0005();
		
		String sql = "select count(1) from bl_cg_ip where fg_st = 'N' ";
		SqlParam param = new SqlParam();
		
		if (FBoolean.TRUE.equals(isMerge)) {
			sql += " and (id_ent = ? or id_ent_mom = ? ) ";
			param.addParam(entId);
			param.addParam(entId);
		} else {
			sql += " and id_ent = ? ";
			param.addParam(entId);
		}
		
		DAFacade daf = new DAFacade();
		Integer count = (Integer)daf.execQuery(sql, param, new ColumnHandler());
		
		return count != null && count > 0;
	}
}

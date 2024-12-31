package iih.ci.ord.s.bp;

import java.util.List;

import iih.ci.ord.cior.d.EnumOpAgainChkRst;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class LoadCheckAgainDataBP extends GetApSugAgainDosBP{
	public OrdApOpAgainDO[] exec() throws BizException{
		List<OrdApOpAgainDO> apOpAgains = getApOpAgains();
		getPatAge(apOpAgains);
		return apOpAgains.toArray(new OrdApOpAgainDO[0]);
	}
	
	/**
	 * 查询已经保存的申请单
	 * @param id_ent
	 * @return
	 * @throws DAException 
	 */
	private List<OrdApOpAgainDO> getApOpAgains() throws DAException{
		DAFacade dao = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(EnumOpAgainChkRst.NULL);
		List<OrdApOpAgainDO> patients= (List<OrdApOpAgainDO>)dao.execQuery(getApOpAgainSql(), param, new BeanListHandler(OrdApOpAgainDO.class));
		return patients;
	}
	@Override
	protected String getWherePart(){
		return "where ci.fg_canc='N' and again.sd_reltp = ?  and again.fg_submit='Y'  order by again.dt_apply desc ";
	}
}

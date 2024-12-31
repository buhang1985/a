package iih.ci.ord.s.bp;

import java.util.List;

import iih.ci.ord.cior.d.EnumOpAgainChkRst;
import iih.ci.ord.cior.d.OpAgainQueryDTO;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryCheckAgainDataBP  extends GetApSugAgainDosBP{
	

	OpAgainQueryDTO agindo;
	
	public OrdApOpAgainDO[] exec(OpAgainQueryDTO agindo) throws BizException{
		this.agindo=agindo;

		List<OrdApOpAgainDO> apOpAgains = getApOpAgains(this.agindo);
		getPatAge(apOpAgains);
		return apOpAgains.toArray(new OrdApOpAgainDO[0]);
	}
	
	/**
	 * 查询已经保存的申请单
	 * @param id_ent
	 * @return
	 * @throws DAException 
	 */
	private List<OrdApOpAgainDO> getApOpAgains(OpAgainQueryDTO agindo) throws DAException{
		DAFacade dao = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(this.agindo.getSd_reltp());
		if(this.agindo.getDt_start()!=null)
		param.addParam(this.agindo.getDt_start().toString());
		if(this.agindo.getDt_end()!=null)
		param.addParam(this.agindo.getDt_end().toString());
		List<OrdApOpAgainDO> patients= (List<OrdApOpAgainDO>)dao.execQuery(getApOpAgainSql(), param, new BeanListHandler(OrdApOpAgainDO.class));
		return patients;
	}
	@Override
	protected String getWherePart(){
		StringBuilder sb=new StringBuilder();
		sb.append(" where ci.fg_canc='N'  and again.fg_submit='Y'  and again.sd_reltp = ? ");
		if(this.agindo.getDt_start()!=null) {
			sb.append("  and again.dt_again_op>=?  ");
		}
		if(this.agindo.getDt_end()!=null) {
			sb.append("  and again.dt_again_op<=?  ");
		}
		sb.append(" order by again.dt_apply desc ");
		return sb.toString();
	}

}

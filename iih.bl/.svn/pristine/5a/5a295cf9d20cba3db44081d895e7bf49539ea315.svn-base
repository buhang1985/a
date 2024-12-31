package iih.bl.hp.s.bp;

import iih.bl.cg.blcgquery.d.BlCgIpDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检索是否有明细费用上传至医保中心
 * @author liwq
 */
public class CheckHpFeeStatesBp {

	public FBoolean exec(String idEnt) throws BizException {	
		StringBuilder sql = new StringBuilder();
		sql.append(" select cg.* from bl_st_ip st ");
		sql.append(" left join bl_cg_ip cg on st.id_stip = cg.id_stip ");
		sql.append( " where cg.fg_hp = 'Y' and st.fg_pay ='N' and  st.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(idEnt);		
		List<BlCgIpDO> cgList = (List<BlCgIpDO>)new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(BlCgIpDO.class));
		if(cgList.isEmpty())
			return FBoolean.FALSE;
		return FBoolean.TRUE;
	}
}

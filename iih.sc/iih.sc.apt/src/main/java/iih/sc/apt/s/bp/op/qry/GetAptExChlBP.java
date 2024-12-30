package iih.sc.apt.s.bp.op.qry;

import iih.sc.apt.scapt.d.AptExChlDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取外部渠道预约信息
 * 
 * @author renying
 *
 */
public class GetAptExChlBP {

	/**
	 * 获取外部渠道预约信息
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public AptExChlDO[] exec(String entId) throws BizException {
		SqlBuildHelper sqlBuilder = new SqlBuildHelper();
		sqlBuilder.append(" select  ex.*,op.id_ent");
		sqlBuilder.append(" from en_ent_op op");
		sqlBuilder.append(" inner join  sc_apt apt");
		sqlBuilder.append(" on op.id_schapt = apt.id_apt");
		sqlBuilder.append(" inner join sc_apt_exchl  ex");
		sqlBuilder.append("  on ex.id_apt = apt.id_apt");
		sqlBuilder.append(" where op.id_ent = ? ");
		SqlParam params = new SqlParam();
		params.addParam(entId);
		List<AptExChlDO> aptExchlList = (List<AptExChlDO>) new DAFacade().execQuery(sqlBuilder.toString(), params,
				new BeanListHandler(AptExChlDO.class));
		return aptExchlList.toArray(new AptExChlDO[0]);
	}
}

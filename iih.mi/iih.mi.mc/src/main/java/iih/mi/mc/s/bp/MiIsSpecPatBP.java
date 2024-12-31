package iih.mi.mc.s.bp;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.AppUtils;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 是否特殊病患者诊断
 * @author lim 
 * @since 2019-12-04
 *
 */
public class MiIsSpecPatBP {
	/**
	 * 是否特殊病患者诊断
	 * @param hpId 医保计划id
	 * @param hpNo 医保号
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String hpId,String hpNo) throws BizException{
		
		if(StringUtil.isEmpty(hpId) || StringUtil.isEmpty(hpNo)){
			throw new ArgumentNullException("是否特殊病患者","医保计划id或医保号");
		}
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select count(1) ");
		sqlSb.append("from mi_mc_pat_spec spec ");
		sqlSb.append("inner join mi_mc_pat_spec_di specdi ");
		sqlSb.append("on spec.id_mimcpatspec = specdi.id_mimcpatspec ");
		sqlSb.append("where ");
		sqlSb.append("spec.id_hp = ? ");
		sqlSb.append("and substr(spec.no_hp,1,9) = ? ");
		sqlSb.append("and specdi.dt_b <= ? ");
		sqlSb.append("and specdi.dt_e >= ? ");

		// 添加组织条件
		String orgSql = EnvContextUtil.processEnvContext("", new BlHpPatSpecDO(), "spec");
		if (!StringUtil.isEmpty(orgSql)) {
			sqlSb.append("and " + orgSql);
		}
		
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		param.addParam(hpNo.length() > 9 ? hpNo.substring(0, 9) : hpNo);
		
		String now = AppUtils.getServerDateTime().toString();
		param.addParam(now);
		param.addParam(now);
		
		int count = (Integer)new DAFacade().execQuery(sqlSb.toString(), param, new ColumnHandler());
		return new FBoolean(count > 0);
	}
}

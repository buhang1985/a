package iih.bl.pay.s.bp.ip;

import java.util.List;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据结算ID查询本次结算的预交金信息
 * @author wq.li 2019-4-28
 *
 */
public class GetPrepayInfoByIpStIdBP {

	/**
	 * 根据结算ID查询本次结算的预交金信息
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] exec(String stId) throws BizException
	{
		if(StringUtil.isEmpty(stId)){
			return null;
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append(" ");
		sql.append(" select ");
		sql.append(" pre.code_rep, ");
		sql.append(" pre.amt * payitm.eu_direct amt, ");
		sql.append(" pre.eu_direct, ");
		sql.append(" pre.id_pm, ");
		sql.append(" pm.name paymodename, ");
		sql.append(" pre.paymodenode, ");
		sql.append(" pre.dt_pay, ");
		sql.append(" dep.name Deptpayname, ");
		sql.append(" psndoc.name EMP_NAME,  ");
		sql.append(" psndoc.des ");
		sql.append("  from ");
		sql.append(" bl_st_ip st ");
		sql.append(" inner join bl_pay_pat_ip pay on pay.id_stip=st.id_stip ");
		sql.append(" inner join bl_pay_itm_pat_ip payitm on payitm.id_paypatip=pay.id_paypatip ");
		sql.append(" inner join bl_prepay_pat pre on pre.id_paypat=payitm.id_paypat ");
		sql.append(" left join bd_pri_pm pm on pm.id_pm=pre.id_pm ");
		sql.append(" left join bd_dep dep on dep.id_dep=pre.id_dep_pay ");
		sql.append(" left join bd_psndoc psndoc on psndoc.id_psndoc =pre.id_emp_pay ");
		sql.append(" where st.id_stip=?  ");
		sql.append(" order by dt_pay ");
		
		SqlParam param=new SqlParam();
		param.addParam(stId);
		
		List<BlPrePayPatDO> list =(List<BlPrePayPatDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(BlPrePayPatDO.class));
		
		return list.toArray(new BlPrePayPatDO[0]);
	}
}

package iih.bl.st.s.bp;

import iih.bl.st.dto.blipchargechk.d.BlIpChargeChkFeeDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院费用核对费用信息查询类
 * @author ly 2017/10/10
 *
 */
public class GetBlIpChargeChkFeeBP {

	/**
	 * 住院费用核对查询费用信息
	 * @param ordId 医嘱id
	 * @return 费用信息
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlIpChargeChkFeeDTO[] exec(String ordId) throws BizException{
	
		if(StringUtil.isEmpty(ordId))
			throw new BizException("住院费用核对费用查询服务：入参医嘱id为空");
		
		String sql = this.getSql();
 		SqlParam param = new SqlParam();
 		param.addParam(ordId);
 		
 		DAFacade daf = new DAFacade();
 		List<BlIpChargeChkFeeDTO> rlt = (List<BlIpChargeChkFeeDTO>)daf.execQuery(
 				sql, param, new BeanListHandler(BlIpChargeChkFeeDTO.class));
 		
		if(ListUtil.isEmpty(rlt))
			return null;
 		
		return rlt.toArray(new BlIpChargeChkFeeDTO[rlt.size()]);
	}
	
	/**
	 * 查询sql
	 * @return
	 */
	private String getSql(){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("ip.name_srv,");
		sqlSb.append("ip.spec,");
		sqlSb.append("ip.dt_cg,");
		sqlSb.append("ip.price,");
		sqlSb.append("ip.price_ratio,");
		sqlSb.append("ip.quan * ip.eu_direct quan,");
		sqlSb.append("ip.amt * ip.eu_direct amt,");
		sqlSb.append("ip.amt_ratio * ip.eu_direct amt_ratio,");
		sqlSb.append("psn.name name_emp_srv,");
		sqlSb.append("ip.note ");
		sqlSb.append("from bl_cg_ip ip ");
		sqlSb.append("left join bd_psndoc psn ");
		sqlSb.append("on ip.id_emp_or = psn.id_psndoc ");
		sqlSb.append("where ip.id_or = ? ");
		sqlSb.append("order by ip.dt_cg,ip.code_srv ");
		
		return sqlSb.toString();
	}
}

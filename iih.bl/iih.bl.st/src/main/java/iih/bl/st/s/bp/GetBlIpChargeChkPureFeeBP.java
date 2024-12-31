package iih.bl.st.s.bp;

import java.util.List;

import iih.bl.st.dto.blipchargechk.d.BlIpChargeChkFeeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院费用核对纯费用信息查询类
 * @author ly 2017/10/17
 *
 */
public class GetBlIpChargeChkPureFeeBP {

	/**
	 * 住院费用核对查询纯费用信息
	 * @param entId 就诊id
	 * @return 费用信息
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlIpChargeChkFeeDTO[] exec(String entId) throws BizException{
		
		if(StringUtil.isEmpty(entId))
			throw new BizException("住院费用核对纯费用查询服务：入参就诊id为空");
		
		String sql = this.getSql();
 		SqlParam param = new SqlParam();
 		param.addParam(entId);
 		
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
		sqlSb.append("ip.id_srv,");
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
		sqlSb.append("where ip.id_ent = ? ");
		sqlSb.append("and nvl(ip.id_or,'~') = '~' ");
		sqlSb.append("and nvl(ip.id_orsrv,'~') = '~' ");
		sqlSb.append("order by ip.dt_cg,ip.code_srv ");
		
		return sqlSb.toString();
	}
}

package iih.bl.cg.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已经结算的账单项明细
 * @author hanjq
 *
 */
public class GetSettleInccasBp {

	public BlStIpInccaInfoDTO[] exec(String idStip, String idIncIp, String wherePart) throws BizException {
		checkParam(idStip, idIncIp, wherePart);
		String sql = getSql(idStip, idIncIp, wherePart);
		SqlParam sqlParam = getSqlParam(idStip, idIncIp);
		DAFacade daf = new DAFacade();
		BlStIpInccaInfoDTO[] array = new BlStIpInccaInfoDTO[0];
		
		@SuppressWarnings("unchecked")
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) daf.execQuery(sql, sqlParam,new BeanListHandler(BlStIpInccaInfoDTO.class));
		if(list != null && list.size() > 0){
			array = list.toArray(array);
		}
		return array;
	}
	
	private void checkParam(String idStip, String idIncIp, String wherePart) throws BizException{
		if(StringUtils.isBlank(idStip) && StringUtils.isBlank(idIncIp) && StringUtils.isBlank(wherePart)){
			throw new BizException("查询参数不能为空");
		}
	}
	
	private SqlParam getSqlParam(String idStip, String idIncIp){
		SqlParam sql = new SqlParam();
		if(StringUtils.isNotBlank(idStip)){
			sql.addParam(idStip);
		}
		if(StringUtils.isNotBlank(idIncIp)){
			sql.addParam(idIncIp);
		}
		return sql;
	}
	
	private String getSql(String idStip, String idIncIp, String wherePart){
		StringBuilder sql = new StringBuilder();
		sql.append(" select cg.name_inccaitm, cg.code_inccaitm, sum(amt_ratio) amt_ratio	");
		sql.append("	,sum(amt_hp) amt_hp ,sum(amt_pat) amt_pat					");
		sql.append("from (		");
		
		sql.append("select distinct cg.id_cgip,cg.name_inccaitm, cg.code_inccaitm, (cg.amt_ratio * cg.eu_direct) amt_ratio		");
		sql.append("	,decode(cg.fg_hp,'Y',cg.amt_ratio * cg.eu_direct,0) amt_hp			");
		sql.append("	,decode(cg.fg_selfpay,'Y',cg.amt_ratio * cg.eu_direct,0) amt_pat			");
		sql.append("from bl_cg_ip cg									");
		sql.append("join bl_st_ip st on st.id_stip = cg.id_stip			");
		sql.append("join bl_inc_ip inc on inc.id_stip = st.id_stip		");
		sql.append("join bd_incca_itm inccaitm on inccaitm.id_incca = inc.id_incca and cg.code_inccaitm = inccaitm.code		");
		sql.append(" where 1=1 			");
		if(StringUtils.isNotBlank(idStip)){
			sql.append(" and  st.id_stip = ?	");
		}
		if(StringUtils.isNotBlank(idIncIp)){
			sql.append(" and  inc.id_incip = ?	");
		}
		if(StringUtils.isNotBlank(wherePart)){
			sql.append(" and	").append(wherePart);
		}
		sql.append(")	cg		");
		
		sql.append("group by cg.name_inccaitm, cg.code_inccaitm		");
		return sql.toString();
	}
	
}

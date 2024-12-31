package iih.bl.hp.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bl.hp.dto.d.HpFeeSumDTO;

import java.util.List;

import xap.lui.exta.qrytmpl.qryscheme.xml.QueryNode;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;


/**
 * 获取结算后的费用总和
 * 
 * @author liwq
 *
 */
public class GetSettledInfoBP {

	@SuppressWarnings({ "unused", "unchecked" })
	public HpFeeSumDTO[] exec(String whereCond, String code_enttp) throws BizException {		
		StringBuilder sql = new StringBuilder();
		sql.append(" select en.code entcode,en.name_pat empname,st.code_st stcode,st.dt_st ");
		sql.append(" from en_ent en ");
		if(code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) 
				|| code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) {
			sql.append(" inner join bl_st_oep st on en.id_ent = st.id_ent ");
		}
		if(code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {
			sql.append(" inner join bl_st_ip st on en.id_ent = st.id_ent ");
		}
		sql.append(" left join en_ent_hp enhp on en.id_ent = enhp.id_ent ");
		sql.append(" left join bd_hp hp on enhp.id_hp = hp.id_hp ");
		sql.append(" left join bd_cust cust on hp.id_cust = cust.id_cust ");
		sql.append(" left join bd_custca custca on custca.id_custca = cust.id_custca ");
		sql.append(" where custca.sd_custtp = '").append(IBdPpDictCodeConst.SD_PAYMENT_ORG).append("' ");
		sql.append(whereCond);
		sql.append(" order by st.dt_st desc, stcode ");
		List<HpFeeSumDTO> feeList = (List<HpFeeSumDTO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(HpFeeSumDTO.class));
		
		if(ListUtil.isEmpty(feeList)) {
			//throw new BizException("未查询到对应的已结算信息！");
			return null;
		}
		return feeList.toArray(new HpFeeSumDTO[]{});
	}
}

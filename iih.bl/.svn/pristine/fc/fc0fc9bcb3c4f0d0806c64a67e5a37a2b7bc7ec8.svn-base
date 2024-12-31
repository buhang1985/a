package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.BillInfoDTO;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据就诊code获取住院结算单据信息
 * @author liwq 2017-8-6 19:13:44
 *
 */
public class GetIpBillInfoDTOsBP {

	 public BillInfoDTO[]  exec(String codeent) throws BizException{	
		 //1、先关联结算表查询是否已经结算，已结算则返回结算关联信息 
		StringBuffer sql = new StringBuffer();
		sql.append(" select hpentcode.hp_ent_serial_no hp_ent_serialno,st.dt_st dt_st, st.code_st bill_code,en.code code_ent from en_ent en ");
		sql.append(" left join bl_hp_entcode_ah hpentcode on hpentcode.id_ent = en.id_ent ");
		sql.append(" left join bl_st_ip st ");
		sql.append(" on en.id_pat = st.id_pat and hpentcode.id_ent = st.id_ent ");		
		sql.append(" where hpentcode.fg_active = 'Y' and st.eu_direct = 1 and st.fg_canc ='N' and en.code = ? ");
		sql.append(" order by st.dt_st desc ");
		SqlParam sp = new SqlParam();
		sp.addParam(codeent);

		@SuppressWarnings("unchecked")
		List<BillInfoDTO> list = (List<BillInfoDTO>) new DAFacade().execQuery(sql.toString(), sp, new BeanListHandler(BillInfoDTO.class));
		if(list.size() > 0  && !StringUtils.isEmptyWithTrim(list.get(0).getHp_ent_serialno())){
			return list.toArray(new BillInfoDTO[] {});
		}
		//2.若未结算返回医保交易流水号
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select hp_ent_serial_no from bl_hp_entcode_ah where fg_active = 'Y' and code_ent = ? ");

		List<String> serialList = (List<String>)new DAFacade().execQuery(sqlb.toString(), sp, new ColumnListHandler());
		BillInfoDTO bill = new BillInfoDTO();
		bill.setHp_ent_serialno(serialList.get(0));
		return new BillInfoDTO[]{bill};
	  }
}

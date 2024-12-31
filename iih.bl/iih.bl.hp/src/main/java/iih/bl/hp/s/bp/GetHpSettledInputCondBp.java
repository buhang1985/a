package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.CostSettlementQueryDTO;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;


/**
 * 单独进行医保结算撤销(安徽),查询医保结算撤销入参条件
 * @author liwq
 */
public class GetHpSettledInputCondBp {

	public CostSettlementQueryDTO exec(String idStIP) throws BizException {
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select hpentcode.hp_ent_serial_no Ipoepnum, st.code_st Code,en.code_hpmedkind Medicate,st.dt_st Dt_stdate,en.dt_end Dt_levhosdate  from bl_st_ip st ");
		sqlb.append(" left join en_ent en on st.id_ent = en.id_ent ");
		sqlb.append(" left join bl_hp_entcode_ah hpentcode on st.id_ent = hpentcode.id_ent ");
		sqlb.append(" where st.id_stip = ? and en.fg_ip='N' and en.fg_st= 'N' ");
		SqlParam param = new SqlParam();
		param.addParam(idStIP);
		List<CostSettlementQueryDTO> settledList = (List<CostSettlementQueryDTO>) new DAFacade().execQuery(sqlb.toString(),param, new BeanListHandler(CostSettlementQueryDTO.class));
		
		if(!ArrayUtils.isEmpty(settledList.toArray())){
			return settledList.get(0);
		}		
		return null;
	}
}

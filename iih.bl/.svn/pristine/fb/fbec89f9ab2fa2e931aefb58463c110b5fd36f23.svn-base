package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.CostSettlementQueryDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保结算成功HIS失败时，撤销医保交易所用（医保结算撤销节点）
 * @author liwq
 */
public class GetHpSettledExceptionBp {

	public CostSettlementQueryDTO exec( String id_ent) throws BizException {
		
		//1、先查询结算表中是否存在已结算数据
		StringBuilder sql = new StringBuilder();
		sql.append(" select hpent.hp_ent_serial_no Ipoepnum, en.code_hpmedkind Medicate, st.code_st code, st.dt_st Dt_stdate, en.dt_end dt_levhosdate ");
		sql.append(" from bl_hp_entcode_ah hpent inner join en_ent en on en.id_ent = hpent.id_ent ");
		sql.append(" inner join bl_st_ip st on st.id_ent = hpent.id_ent ");
		sql.append(" where  hpent.fg_active = 'Y' and st.fg_pay = 'N' and hpent.id_ent = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		
		List<CostSettlementQueryDTO> list =(List<CostSettlementQueryDTO>)new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(CostSettlementQueryDTO.class));
		
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		
		return  null;
	}
}

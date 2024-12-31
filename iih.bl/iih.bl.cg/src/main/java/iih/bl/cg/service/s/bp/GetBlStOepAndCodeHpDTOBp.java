package iih.bl.cg.service.s.bp;

import iih.bl.st.dto.d.BlStOepAndCodeHpDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据id_ent,id_cgoep，查对应的结算主键和医保交易流水号
 * 
 * @author yang.lu
 * @since 2017年6月26日
 *
 */
public class GetBlStOepAndCodeHpDTOBp {

	/**
	 * 供就诊使用：根据id_ent,id_cgoep，查对应的结算主键和医保交易流水号
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param id_cgoep
	 *            记账主表ID
	 * @return 结算主键和医保交易流水号DTO
	 * @throws BizException
	 */
	public BlStOepAndCodeHpDTO exec(String id_ent, String id_cgoep) throws BizException {
		BlStOepAndCodeHpDTO blStOepAndCodeHpDTO = null;
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("select b.code_st,b.Id_stoep, d.code_hp");
		sqlb.append("  from bl_cg_itm_oep a");
		sqlb.append(" inner join bl_st_oep b");
		sqlb.append("    on a.id_stoep = b.id_stoep");
		sqlb.append(" left join bl_prop_oep c");
		sqlb.append("    on b.id_stoep = c.id_stoep");
		sqlb.append(" left join bl_prop_ar_oep d");
		sqlb.append("    on c.id_propoep = d.id_propoep");
		sqlb.append(" where a.id_ent = ?");
		sqlb.append("  and a.id_cgoep = ?");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_ent);
		sqlParam.addParam(id_cgoep);
		List<BlStOepAndCodeHpDTO> blStOepAndCodeHpDTOList = (List<BlStOepAndCodeHpDTO>) dafacade.execQuery(sqlb.toString(), sqlParam, new BeanListHandler(BlStOepAndCodeHpDTO.class));
		if (blStOepAndCodeHpDTOList != null && blStOepAndCodeHpDTOList.size() > 0) {
			blStOepAndCodeHpDTO = blStOepAndCodeHpDTOList.toArray(new BlStOepAndCodeHpDTO[0])[0];
		}
		return blStOepAndCodeHpDTO;
	}

}

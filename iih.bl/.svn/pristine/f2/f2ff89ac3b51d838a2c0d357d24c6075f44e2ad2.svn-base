package iih.bl.hp.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.hp.dto.d.SettledDetailDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保结算交易费用明细查询
 * @param  结算id和就诊类型code组合map
 * @author liwq 
 * @return
 * @throws BizException
 */
public class GetHpTransDetailInfoBP {

	public PagingRtnData<SettledDetailDTO> exec(FMap map, PaginationInfo pg) throws BizException {
		if(map == null)
			return null;
		String id_st = map.get("id_st").toString();
		String code_enttp = map.get("code_enttp").toString();
		StringBuilder sql = new StringBuilder();
		if(code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) {
			sql.append(" select oep.id_stoep id_st, oep.quan,oep.amt_ratio amt,oep.name_srv srv_name, ");
			sql.append(" case oep.sd_hpsrvtp when '1' then '甲类' when '2' then '乙类' else '自费' end chargelevel ");
			sql.append("  from bl_cg_itm_oep oep ");
			sql.append(" where oep.id_stoep = ?   ");			
		}
		if(code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) {
			sql.append(" select ip.id_stip id_st, ip.quan,ip.amt_ratio amt,ip.name_srv srv_name, ");
			sql.append(" case hpsrvca.sd_hpsrvtp when '1' then '甲类' when '2' then '乙类' else '自费' end chargelevel ");
			sql.append("  from bl_cg_ip ip ");
			sql.append(" left join bd_hp_srvorca hpsrvca ");
			sql.append("  on ip.id_srv = hpsrvca.id_srv ");
			sql.append(" where ip.id_stip = ?  ");
		}
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_st);
		
		SettledDetailDTO hpDto = new SettledDetailDTO();
		PagingServiceImpl<SettledDetailDTO> pagingServiceImpl = new PagingServiceImpl<SettledDetailDTO>();

		PagingRtnData<SettledDetailDTO> prd = pagingServiceImpl.findByPageInfo(hpDto, pg, sql.toString(), "", sqlParam);
		return prd;
	}
}

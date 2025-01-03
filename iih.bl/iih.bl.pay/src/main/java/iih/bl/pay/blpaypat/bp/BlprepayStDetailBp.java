package iih.bl.pay.blpaypat.bp;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bl.pay.blprepayunstdetaildto.d.BlPrepayUnStDetailDTO;
import iih.bl.st.blstdetaildto.d.BlStDetailDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class BlprepayStDetailBp {
	public BlStDetailDTO[] findPrepayStDetail(String id_paypat, String code_enttp)
			throws BizException {

		if (StringUtils.isEmpty(id_paypat)) {
			throw new BizException("收付款主键不能为空!");
		}
		
		if (StringUtils.isEmpty(code_enttp)) {
			throw new BizException("患者类型不能为空!");
		}
		
		FMap map = new FMap();
        map.put("id_paypat", id_paypat);
        map.put("code_enttp", code_enttp);
        
		StringBuffer sql = new StringBuffer();
		sql = getSql(map);
		
		SqlParam sp = new SqlParam();
		sp = getParam(map);

		List<BlStDetailDTO> ipdtos = (List<BlStDetailDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(BlStDetailDTO.class));
		return ipdtos.toArray(new BlStDetailDTO[0]);
	}
	
	
	public PagingRtnData<BlStDetailDTO> findPrepayStDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException {
		PagingRtnData<BlStDetailDTO> pageFeeDTO = new PagingRtnData<BlStDetailDTO>();
		PagingServiceImpl<BlStDetailDTO> service = new PagingServiceImpl<BlStDetailDTO>();
		
		
		StringBuffer sql = new StringBuffer();
		sql = getSql(map);

		SqlParam param = new SqlParam();
		param = getParam(map);

		pageFeeDTO = service.findByPageInfo(new BlStDetailDTO(), pageInfo,
				sql.toString(), "", param);
		
		return pageFeeDTO;
	}


	private SqlParam getParam(FMap map) throws BizException {
		
		String id_paypat = map.get("id_paypat").toString();
		String code_enttp = map.get("code_enttp").toString();

		if (StringUtils.isEmpty(id_paypat)) {
			throw new BizException("收付款主键不能为空!");
		}
		
		if (StringUtils.isEmpty(code_enttp)) {
			throw new BizException("患者类型不能为空!");
		}
		SqlParam sp = new SqlParam();
		sp.addParam(id_paypat);
		return sp;
	}


	private StringBuffer getSql(FMap map) throws BizException{
		String id_paypat = map.get("id_paypat").toString();
		String code_enttp = map.get("code_enttp").toString();

		if (StringUtils.isEmpty(id_paypat)) {
			throw new BizException("收付款主键不能为空!");
		}
		
		if (StringUtils.isEmpty(code_enttp)) {
			throw new BizException("患者类型不能为空!");
		}
		StringBuffer sql = new StringBuffer();
		if("00".equals(code_enttp)){
			sql.append("select cgitm.name_srv, ");
			sql.append("       cgitm.spec, " );
			sql.append("       mea.name            as util, " );
			sql.append("       cgitm.quan, " );
			sql.append("       To_Char((cgitm.price_ratio), '999999999990.9999')   as price, " );
			sql.append("       To_Char((cgitm.amt_ratio), '999999999990.99')     as amt, " );
			sql.append("       cgitm.name_inccaitm as name_inc_itm " );
			sql.append("  from bl_pay_itm_pat_oep payitm " );
			sql.append(" inner join bl_st_oep st " );
			sql.append("    on st.id_paypatoep = payitm.id_paypatoep " );
			sql.append(" inner join bl_cg_itm_oep cgitm " );
			sql.append("    on st.id_stoep = cgitm.id_stoep " );
			sql.append("  left join bd_measdoc mea " );
			sql.append("    on cgitm.srvu = mea.id_measdoc " );
			sql.append(" where payitm.id_paypat = ? ");
		}else if("10".equals(code_enttp)){
			sql.append("select cg.name_srv, ");
			sql.append("        cg.spec, " );
			sql.append("        mea.name         as util, " );
			sql.append("        cg.quan, " );
			sql.append("        To_Char((cg.price_ratio), '999999999990.9999')   as price, " );
			sql.append("        To_Char((cg.amt_ratio), '999999999990.99')     as amt, " );
			sql.append("        cg.name_inccaitm as name_inc_itm " );
			sql.append("   from bl_pay_itm_pat_ip payitm " );
			sql.append("   inner join bl_pay_pat_ip pay " );
			sql.append("     on payitm.id_paypatip = pay.id_paypatip " );
			sql.append("   inner join bl_st_ip st " );
			sql.append("     on st.id_stip = pay.id_stip " );
			sql.append("   inner join bl_cg_ip cg " );
			sql.append("     on st.id_stip = cg.id_stip " );
			sql.append("   left join bd_measdoc mea " );
			sql.append("     on cg.srvu = mea.id_measdoc " );
			sql.append("  where payitm.id_paypat = ? ");
		}
		return sql;
	}
	
}

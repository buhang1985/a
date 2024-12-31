package iih.bl.pay.blpaypat.bp;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bl.pay.blprepayunstdetaildto.d.BlPrepayUnStDetailDTO;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class BlprepayUnStDetailBp {
	public BlPrepayUnStDetailDTO[] findPrepayUnStDetail(String id_pat, String code_enttp, String Dt_start, String Dt_end)
			throws BizException {

		if (StringUtils.isEmpty(id_pat)) {
			throw new BizException("患者ID不能为空!");
		}

		if (StringUtils.isEmpty(code_enttp)) {
			throw new BizException("患者类型不能为空!");
		}
		
		FMap map = new FMap();
        map.put("id_pat", id_pat);
        map.put("code_enttp", code_enttp);
        map.put("Dt_start", StringUtils.isEmpty(Dt_start) ? "" : Dt_start);
        map.put("Dt_end", StringUtils.isEmpty(Dt_end) ? "" : Dt_end);
        map.put("Or", "");
        map.put("Srv", "");
        map.put("Dt_cg_start", "");
        map.put("Dt_cg_end", "");
		StringBuffer sql = new StringBuffer();
		sql = getSql(map);
		
		SqlParam sp = new SqlParam();
		sp = getParam(map);
		
		@SuppressWarnings("unchecked")
		List<BlPrepayUnStDetailDTO> ipdtos = (List<BlPrepayUnStDetailDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(BlPrepayUnStDetailDTO.class));
		return ipdtos.toArray(new BlPrepayUnStDetailDTO[0]);
		
	}
	
	public PagingRtnData<BlPrepayUnStDetailDTO> findPrepayUnStDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException {
		PagingRtnData<BlPrepayUnStDetailDTO> pageFeeDTO = new PagingRtnData<BlPrepayUnStDetailDTO>();
		PagingServiceImpl<BlPrepayUnStDetailDTO> service = new PagingServiceImpl<BlPrepayUnStDetailDTO>();
		
		
		StringBuffer sql = new StringBuffer();
		sql = getSql(map);

		SqlParam param = new SqlParam();
		param = getParam(map);

		pageFeeDTO = service.findByPageInfo(new BlPrepayUnStDetailDTO(), pageInfo,
				sql.toString(), "", param);
		
		return pageFeeDTO;
	}

	private StringBuffer getSql(FMap map) throws BizException {
		
		String id_pat = map.get("id_pat").toString();
		String code_enttp = map.get("code_enttp").toString();
		String Dt_start = map.containsKey("Dt_start") ? map.get("Dt_start").toString() : "";
		String Dt_end = map.containsKey("Dt_end") ?map.get("Dt_end").toString() : "";

		String Or = map.containsKey("Or") ?map.get("Or").toString() : "";
		String Srv = map.containsKey("Srv") ?map.get("Srv").toString() : "";
		String Dt_cg_start = map.containsKey("Dt_cg_start") ?map.get("Dt_cg_start").toString() : "";
		String Dt_cg_end = map.containsKey("Dt_cg_end") ?map.get("Dt_cg_end").toString() : "";
		
		if (StringUtils.isEmpty(id_pat)) {
			throw new BizException("患者ID不能为空!");
		}

		if (StringUtils.isEmpty(code_enttp)) {
			throw new BizException("患者类型不能为空!");
		}
		
		StringBuffer sql = new StringBuffer();

		if("00".equals(code_enttp)){
			sql.append("select ci.content_or, ");
			sql.append("       ci.id_or, ");
			sql.append("       ci.code_or, " );
			sql.append("       cgitm.id_srv, ");
			sql.append("       cgitm.name_srv, " );
			sql.append("       cgitm.name_mm, " );
			sql.append("       To_Char((cgitm.price_ratio), '999999999990.9999')  price_ratio ," );
			sql.append("       cgitm.quan * cg.eu_direct quan ," );
			sql.append("       mea.name as util, " );
			sql.append("       To_Char((cgitm.amt_ratio * cg.eu_direct), '999999999990.99')  amt_ratio ," );
			sql.append("       ordep.name name_dep_or, " );
			sql.append("       cg.dt_cg " );
			sql.append("  from bl_cg_itm_oep cgitm " );
			sql.append(" inner join bl_cg_oep cg " );
			sql.append("    on cgitm.id_cgoep = cg.id_cgoep " );
			sql.append("  left join ci_order ci " );
			sql.append("    on ci.id_or = cgitm.id_or " );
			sql.append("  left join bd_measdoc mea " );
			sql.append("    on cgitm.srvu = mea.id_measdoc " );
			sql.append("  left join bd_dep ordep " );
			sql.append("    on ordep.id_dep = cgitm.id_dep_or " );
			sql.append(" where cgitm.fg_st = 'N' " );
			sql.append("   and cgitm.id_pat = ? " );
			sql.append("   and cgitm.code_enttp = '00' ");
		}
		else if("10".equals(code_enttp)){
			sql.append("select ci.content_or, ");
			sql.append("       ci.id_or, ");
			sql.append("       cgitm.id_srv, ");
			sql.append("       ci.code_or, " );
			sql.append("       cgitm.name_srv, " );
			sql.append("       cgitm.name_mm, " );
			sql.append("       cgitm.spec, " );
			sql.append("       mea.name as util, " );
			sql.append("       To_Char((cgitm.price_ratio), '999999999990.9999')  price_ratio ," );
			sql.append("       cgitm.quan * cgitm.eu_direct quan ," );
			sql.append("       To_Char((cgitm.amt_ratio * cgitm.eu_direct), '999999999990.99')  amt_ratio ," );
			sql.append("       cgitm.dt_cg, " );
			sql.append("       ordep.name as name_dep_or, " );
			sql.append("       mpdep.name name_dep_mp, " );
			sql.append("       cgitm.fg_research " );
			sql.append("  from bl_cg_ip cgitm " );
			sql.append(" left join ci_order ci " );
			sql.append("    on cgitm.id_or = ci.id_or " );
			sql.append(" left join bd_measdoc mea " );
			sql.append("    on cgitm.srvu = mea.id_measdoc " );
			sql.append(" left join bd_dep ordep " );
			sql.append("    on ordep.id_dep = cgitm.id_dep_or " );
			sql.append(" left join bd_dep mpdep " );
			sql.append("    on mpdep.id_dep = cgitm.id_dep_mp " );
			sql.append(" where cgitm.fg_st = 'N' " );
			sql.append("   and cgitm.id_ent = ? " );
			sql.append("   and cgitm.code_enttp = '10' ");
		}
		
		if (!StringUtils.isEmpty(Dt_start))
			sql.append(" and cgitm.dt_cg >= ? ");
		if (!StringUtils.isEmpty(Dt_end))
			sql.append(" and cgitm.dt_cg < ? ");
		if(!StringUtils.isEmpty(Or)){
			sql.append(" and (ci.content_or like ? or ci.code_or like ? or ci.id_or like ?) ");
		}
		if(!StringUtils.isEmpty(Srv)){
			sql.append(" and (cgitm.name_srv like ? or cgitm.name_mm like ? or cgitm.id_srv like ? )");
		}
		if (!StringUtils.isEmpty(Dt_cg_start))
			sql.append(" and cgitm.dt_cg >= ? ");
		if (!StringUtils.isEmpty(Dt_cg_end))
			sql.append(" and cgitm.dt_cg < ? ");
		
		sql.append(" order by cgitm.dt_cg ");
		return sql;
	}

	private SqlParam getParam(FMap map) throws BizException {
		String id_pat = map.get("id_pat").toString();
		String code_enttp = map.get("code_enttp").toString();
		
		String Dt_start = map.containsKey("Dt_start") ? map.get("Dt_start").toString() : "";
		String Dt_end = map.containsKey("Dt_end") ?map.get("Dt_end").toString() : "";

		String Or = map.containsKey("Or") ?map.get("Or").toString() : "";
		String Srv = map.containsKey("Srv") ?map.get("Srv").toString() : "";
		String Dt_cg_start = map.containsKey("Dt_cg_start") ?map.get("Dt_cg_start").toString() : "";
		String Dt_cg_end = map.containsKey("Dt_cg_end") ?map.get("Dt_cg_end").toString() : "";
		
		if (StringUtils.isEmpty(id_pat)) {
			throw new BizException("患者ID不能为空!");
		}

		if (StringUtils.isEmpty(code_enttp)) {
			throw new BizException("患者类型不能为空!");
		}
		SqlParam sp = new SqlParam();
		sp.addParam(id_pat);
		if (!StringUtils.isEmpty(Dt_start))
			sp.addParam(Dt_start);
		if (!StringUtils.isEmpty(Dt_end))
			sp.addParam(Dt_end);
		if(!StringUtils.isEmpty(Or)){
			sp.addParam("%"+ Or + "%");
			sp.addParam("%"+ Or + "%");
			sp.addParam("%"+ Or + "%");
		}
		
		if(!StringUtils.isEmpty(Srv)){
			sp.addParam("%"+ Srv + "%");
			sp.addParam("%"+ Srv + "%");
			sp.addParam("%"+ Srv + "%");
		}
		
		if (!StringUtils.isEmpty(Dt_cg_start))
			sp.addParam(Dt_cg_start);
		if (!StringUtils.isEmpty(Dt_cg_end))
			sp.addParam(Dt_cg_end);
		return sp;
	}
}

package iih.bl.cg.s.bp.newrfd;

import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.params.BlParams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取可以退费的数据
 * @author xy.zhou
 *
 */
public class GetFeeRefundAbleBP {

	@SuppressWarnings("unchecked")
	public NurseCompFeeItmDTO[] exec(NurseCompFeeItmDTO nFeeItmDTO) throws BizException {
		if (nFeeItmDTO.getId_ent() == null) {
			throw new BizException("查询医嘱明细就诊主键不能为空");
		}
		String id_ent = nFeeItmDTO.getId_ent();

		if (nFeeItmDTO.getId_srv() == null) {
			throw new BizException("查询项目明细项目id不能为空");
		}
		String id_srv = nFeeItmDTO.getId_srv();

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select cg.id_ent, ");
		sqlSb.append("       cg.id_cgip, ");
		sqlSb.append("       cg.dt_cg, ");
		sqlSb.append("       cg.id_pat, ");
		sqlSb.append("       cg.id_or, ");
		sqlSb.append("       cg.id_orsrv, ");
		sqlSb.append("       cg.id_or_pr_srv, ");
		sqlSb.append("       cg.quan, ");
		sqlSb.append("       cg.quan_ret quan_refunded, ");
		sqlSb.append("       (cg.quan - cg.quan_ret) quan_maximum, ");
		sqlSb.append("       (cg.quan - cg.quan_ret) quan_mend, ");
		sqlSb.append("       cg.price_ratio price, ");
		sqlSb.append("       ord.name_or, ");
		sqlSb.append("       ord.code_or, ");
		sqlSb.append("       cg.dt_or, ");
		sqlSb.append("       dep1.name name_dep_or, ");
		sqlSb.append("       dep2.name name_dep_mp, ");
		sqlSb.append("       dep3.name name_dep_cg, ");
		sqlSb.append("       cg.id_mm, ");
		sqlSb.append("       cg.fg_mm, ");
		sqlSb.append("       cg.name_mm, ");
		sqlSb.append("       cg.onlycode, ");
		sqlSb.append("       cg.cd_batch, ");
		sqlSb.append("       cg.id_srv, ");
		sqlSb.append("       cg.name_srv, ");
		sqlSb.append("       cg.code_srv, ");
		sqlSb.append("       cg.srvu, ");
		sqlSb.append("       doc.name name_srvu, ");
		sqlSb.append("       cg.pgku_cur, ");
		sqlSb.append("       cg.ratio_pripat, ");
		sqlSb.append("        nvl(udi1.name, '可申请') as name_rdfitm, ");
		sqlSb.append("        nvl(rtm.sd_su_rdfitm, '0') as sd_rdfitm, ");
		sqlSb.append("        rtm.id_rfditm ");
		sqlSb.append("  from bl_cg_ip cg ");
		sqlSb.append("  left outer join ci_order ord ");
		sqlSb.append("    on cg.id_or = ord.id_or ");
		sqlSb.append("  left outer join bd_dep dep1 ");
		sqlSb.append("    on cg.id_dep_or = dep1.id_dep ");
		sqlSb.append("  left outer join bd_dep dep2 ");
		sqlSb.append("    on cg.id_dep_mp = dep2.id_dep ");
		sqlSb.append("  left outer join bd_dep dep3 ");
		sqlSb.append("    on cg.id_dep_cg = dep3.id_dep ");
		sqlSb.append("  left outer join bd_measdoc doc ");
		sqlSb.append("    on cg.srvu = doc.id_measdoc ");
		sqlSb.append("  left join bl_rfd_itm rtm ");
		sqlSb.append("    on rtm.id_cgip = cg.id_cgip and rtm.fg_active='Y' ");
		sqlSb.append("  left join bd_udidoc udi1 ");
		sqlSb.append("    on udi1.id_udidoc=rtm.id_su_rdfitm ");
		sqlSb.append(" where 1 = 1 ");
		sqlSb.append("   and cg.fg_real = 'Y'");
		sqlSb.append(" and (cg.quan - cg.quan_ret)>0 ");
		SqlParam param = new SqlParam();
		FBoolean isMerge = BlParams.BLSTIP0005();
		if (FBoolean.TRUE.equals(isMerge)) {
			sqlSb.append(" and (cg.id_ent = ? ").append(" or cg.id_ent_mom = ? ) ");
			param.addParam(id_ent);
			param.addParam(id_ent);
		} else {
			sqlSb.append(" and (cg.id_ent = ? ) ");
			param.addParam(id_ent);
		}
		
		sqlSb.append(" and cg.fg_st='N' ");
		sqlSb.append(" and (cg.id_dep_or=? or cg.id_dep_mp=? or cg.id_dep_cg=? )" );//or cg.id_dep_nur = ? 
		param.addParam(Context.get().getDeptId());
		param.addParam(Context.get().getDeptId());
		param.addParam(Context.get().getDeptId());
		
		sqlSb.append(" and cg.eu_direct = 1 ");
		sqlSb.append(" and cg.id_srv=?");
		param.addParam(id_srv);
		sqlSb.append(" order by cg.dt_cg desc ");

		DAFacade df = new DAFacade();
		List<NurseCompFeeItmDTO> srvList = (List<NurseCompFeeItmDTO>) df.execQuery(sqlSb.toString(), param,
				new BeanListHandler(NurseCompFeeItmDTO.class));

		if (ListUtil.isEmpty(srvList)) {
			 return null ;
		}
		
		List<String> cgIdList = new ArrayList<String>();
		for (NurseCompFeeItmDTO itmDto : srvList) {
			cgIdList.add(itmDto.getId_cgip());
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select id_par ,max(dt_cg) as dt_cg ");
		sql.append(" from ");
		sql.append(" bl_cg_ip ");
		sql.append(" where fg_real = 'Y' and " + SqlUtils.getInSqlByBigIds("id_par", cgIdList.toArray(new String[0])));
		sql.append(" group by id_par ");
		List<NurseCompFeeItmDTO> retList = (List<NurseCompFeeItmDTO>) df.execQuery(sql.toString(), null,
				new BeanListHandler(NurseCompFeeItmDTO.class));
		//List<NurseCompFeeItmDTO> dtlist = new ArrayList<NurseCompFeeItmDTO>();
		if (!ListUtil.isEmpty(retList)) {

			Map<String, NurseCompFeeItmDTO> retMap = (Map<String, NurseCompFeeItmDTO>) MapUtils.convertListToMap(retList, "Id_par");
			for (NurseCompFeeItmDTO itmDto : srvList) {
				NurseCompFeeItmDTO retDto = retMap.get(itmDto.getId_cgip());
				if (retDto != null) {
					itmDto.setDt_refund(retDto.getDt_cg());
				}
				// dtlist.add(itmDto);
			}
		}
		return srvList.toArray(new NurseCompFeeItmDTO[] {});
	}
}

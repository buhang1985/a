package iih.bl.cg.s.bp.et;

import java.util.List;

import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @ClassName: GetSrvCgdetailsBP  
* @Description: 病区补退费（获取该项目下的可退费明细） 
* @author xy.zhou
* @date 2019年3月14日
 */
public class GetEtSrvCgDetailsBP {

	@SuppressWarnings("unchecked")
	public NurseCompFeeItmDTO[] exec(NurseCompFeeItmDTO nFeeItmDTO) throws BizException{
		if (nFeeItmDTO.getId_ent()==null) {
			throw new BizException("查询医嘱明细就诊主键不能为空");
		}
		String id_ent=nFeeItmDTO.getId_ent();

		if(nFeeItmDTO.getId_srv()==null){
			throw new BizException("查询项目明细项目id不能为空");
		}
		String id_srv=nFeeItmDTO.getId_srv();
		String dep_id=Context.get().getDeptId();
		StringBuilder sqlSb = new StringBuilder();
		SqlParam param=new SqlParam();
		Integer blst0002 = BlParams.BLST0002();
		
		if(blst0002==1){
			this.getOepCgSql(sqlSb, param, id_srv, dep_id,id_ent);
		}else if(blst0002==2){
			this.getIpCgSql(sqlSb, param, id_srv, dep_id,id_ent);
		}else{
			throw new BizException("参数BLST0002为空或者维护范围错误！该参数为"+blst0002);
		}
		DAFacade df = new DAFacade();
		List<NurseCompFeeItmDTO> srvList = (List<NurseCompFeeItmDTO>)df.execQuery(sqlSb.toString(), param, new BeanListHandler(NurseCompFeeItmDTO.class));
		
		if (ListUtil.isEmpty(srvList)) {
			throw new BizException("未获取到明细集合");
		}
		
		return srvList.toArray(new NurseCompFeeItmDTO[]{});
	}
	/**
	 * 
	* @Title: getOepCgSql  
	* @Description: 获取门诊sql  
	* @return String 
	* @throws
	 */
	private String getOepCgSql(StringBuilder sqlSb,SqlParam param,String id_srv,String dep_id,String id_ent){
		
		sqlSb.append("select item.id_ent, ");
		sqlSb.append("         item.id_cgitmoep id_cgip, ");
		sqlSb.append("         cg.dt_cg, ");
		sqlSb.append("           item.id_pat, ");
		sqlSb.append("           item.id_or, ");
		sqlSb.append("           item.id_orsrv, ");
		sqlSb.append("           item.id_or_pr_srv, ");
		sqlSb.append("           item.quan, ");
		sqlSb.append("           0 as quan_refunded, ");
		sqlSb.append("           item.quan  as quan_maximum, ");
		sqlSb.append("           item.quan as quan_mend, ");
		sqlSb.append("           item.price_ratio as price, ");
		sqlSb.append("           ord.name_or, ");
		sqlSb.append("           ord.code_or, ");
		sqlSb.append("           item.dt_or, ");
		sqlSb.append("           dep1.name as name_dep_or, ");
		sqlSb.append("           dep2.name as name_dep_mp, ");
		sqlSb.append("           dep3.name as name_dep_cg, ");
		sqlSb.append("           item.id_mm, ");
		sqlSb.append("           item.fg_mm, ");
		sqlSb.append("           item.name_mm, ");
		sqlSb.append("           item.onlycode, ");
		sqlSb.append("           item.cd_batch, ");
		sqlSb.append("           item.id_srv, ");
		sqlSb.append("           item.name_srv, ");
		sqlSb.append("           item.code_srv, ");
		sqlSb.append("           item.srvu, ");
		sqlSb.append("           doc.name as name_srvu, ");
		sqlSb.append("           item.pgku_cur, ");
		sqlSb.append("           item.ratio_pripat ");
		sqlSb.append("      from bl_cg_itm_oep item ");
		sqlSb.append("      left join bl_cg_oep cg ");
		sqlSb.append("      on item.id_cgoep=cg.id_cgoep ");
		sqlSb.append("      left join ci_order ord ");
		sqlSb.append("        on item.id_or = ord.id_or ");
		sqlSb.append("      left join bd_dep dep1 ");
		sqlSb.append("        on item.id_dep_or = dep1.id_dep ");
		sqlSb.append("      left join bd_dep dep2 ");
		sqlSb.append("        on item.id_dep_mp = dep2.id_dep ");
		sqlSb.append("      left join bd_dep dep3 ");
		sqlSb.append("        on cg.id_dep_cg = dep3.id_dep ");
		sqlSb.append("      left join bd_measdoc doc ");
		sqlSb.append("        on item.srvu = doc.id_measdoc ");
		sqlSb.append("      where 1=1");
		
		sqlSb.append(" and item.id_srv=? ");
		param.addParam(id_srv);
		sqlSb.append(" and cg.eu_direct=1 ");
		sqlSb.append(" and (item.id_dep_or=? or item.id_dep_mp=? or cg.id_dep_cg=? )");
		param.addParam(dep_id);
		param.addParam(dep_id);
		param.addParam(dep_id);
		sqlSb.append(" and item.id_ent=? ");
		param.addParam(id_ent);
		sqlSb.append("   and item.fg_refund = 'N' and cg.eu_direct = 1 ");
		return sqlSb.toString();
	}
	/**
	 * 
	* @Title: getIpCgSql  
	* @Description: 获取住院sql 
	* @return String 
	* @throws
	 */
	private String getIpCgSql(StringBuilder sqlSb,SqlParam param,String id_srv,String dep_id,String id_ent){
		
		sqlSb.append("select cg.id_ent, ");
		sqlSb.append("		 cg.id_cgip,");
		sqlSb.append("		 cg.dt_cg,");
		sqlSb.append("       cg.id_pat, ");
		sqlSb.append("       cg.id_or, ");
		sqlSb.append("       cg.id_orsrv, ");
		sqlSb.append("       cg.id_or_pr_srv, ");
		sqlSb.append("       cg.quan, ");
		sqlSb.append("       cg.quan_ret as quan_refunded, ");
		sqlSb.append("       (cg.quan - cg.quan_ret) as quan_maximum, ");
		sqlSb.append("       (cg.quan - cg.quan_ret) as quan_mend, ");
		sqlSb.append("       cg.price_ratio as price, ");
		sqlSb.append("       ord.name_or, ");
		sqlSb.append("       ord.code_or, ");
		sqlSb.append("       cg.dt_or, ");
		sqlSb.append("       dep1.name as name_dep_or, ");
		sqlSb.append("       dep2.name as name_dep_mp, ");
		sqlSb.append("       dep3.name as name_dep_cg, ");
		sqlSb.append("       cg.id_mm, ");
		sqlSb.append("       cg.fg_mm, ");
		sqlSb.append("       cg.name_mm, ");
		sqlSb.append("       cg.onlycode, ");
		sqlSb.append("       cg.cd_batch, ");
		sqlSb.append("       cg.id_srv, ");
		sqlSb.append("       cg.name_srv, ");
		sqlSb.append("       cg.code_srv, ");
		sqlSb.append("       cg.srvu, ");
		sqlSb.append("       doc.name as name_srvu, ");
		sqlSb.append("       cg.pgku_cur, ");
		sqlSb.append("       cg.ratio_pripat ");
		sqlSb.append("  from bl_cg_ip cg ");
		sqlSb.append("  left join ci_order ord ");
		sqlSb.append("    on cg.id_or = ord.id_or ");
		sqlSb.append("  left join bd_dep dep1 ");
		sqlSb.append("    on cg.id_dep_or = dep1.id_dep ");
		sqlSb.append("  left join bd_dep dep2 ");
		sqlSb.append("    on cg.id_dep_mp = dep2.id_dep ");
		sqlSb.append("  left join bd_dep dep3 ");
		sqlSb.append("    on cg.id_dep_cg = dep3.id_dep ");
		sqlSb.append("  left join bd_measdoc doc ");
		sqlSb.append("    on cg.srvu = doc.id_measdoc ");
		sqlSb.append("  where 1=1 ");
		
		sqlSb.append(" and cg.eu_direct = 1 ");
		sqlSb.append(" and cg.id_srv=?");
		param.addParam(id_srv);
		sqlSb.append(" and (cg.id_dep_or=? or cg.id_dep_mp=? or cg.id_dep_cg=? )");
		param.addParam(dep_id);
		param.addParam(dep_id);
		param.addParam(dep_id);
		sqlSb.append(" and cg.id_ent=? ");
		param.addParam(id_ent);
		return sqlSb.toString();
	}
}

package iih.bl.cg.blcgopheaddto.s;

import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgopheaddto.d.BlcgopHeadDto;
import iih.bl.cg.blcgopheaddto.i.IBlcgopHeadDtoService;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/** 文件头注释
* ==============================================================================
* @Filename: BlcgopHeadDtoImpl   
* @Date: 2016/06/30 10:37:15
* @Compiler: Eclipse luna 4.4.1 
* @author li_pengying
* @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* @Description: 门诊费用清单的接口实现类
* ==============================================================================
*/




/**
 * 门诊费用清单的接口实现类
 * @author li_pengying
 *
 */
@Service(serviceInterfaces = { IBlcgopHeadDtoService.class }, binding = Binding.JSONRPC)
public class BlcgopHeadDtoImpl implements IBlcgopHeadDtoService {

	@Override
	public BlcgopHeadDto BlcgopHeadFind(String patCode, String entCode,String id_grp,String id_org)
			throws BizException {
		StringBuffer sqlb=new StringBuffer();
		sqlb.append(" SELECT PI_PAT.code     Pat_code, ");
		sqlb.append("        PI_PAT.Name     Pat_name, ");
		sqlb.append("        bd_pri_pat.name Pat_id_pripat, ");
		sqlb.append("        bd_dep.name     Id_dep_reg, ");
		sqlb.append("        en_ent.dt_acpt  Pat_dt_acpt ");
		sqlb.append("   FROM PI_PAT ");
		sqlb.append("   JOIN EN_ENT ");
		sqlb.append("     ON PI_PAT.ID_PAT = EN_ENT.ID_PAT ");
		sqlb.append("   join bd_pri_pat ");
		sqlb.append("     on en_ent.id_pripat = bd_pri_pat.id_pripat ");
		sqlb.append("   join en_ent_op ");
		sqlb.append("     on EN_ENT.ID_ENT = en_ent_op.id_ent ");
		sqlb.append("   join bd_dep ");
		sqlb.append("     on en_ent_op.id_dep_reg=bd_dep.id_dep ");
		sqlb.append("  where en_ent.code_entp = '00' ");
		sqlb.append("    and PI_PAT.code = ? ");
		sqlb.append("    and en_ent.code = ? ");
		sqlb.append("    and pi_pat.id_grp=? ");
		sqlb.append("    and pi_pat.id_org=? ");
		SqlParam parameter=new SqlParam();
		
		parameter.addParam(patCode);
		parameter.addParam(entCode);
		parameter.addParam(id_grp);
		parameter.addParam(id_org);

		@SuppressWarnings("unchecked")
		List<BlcgopHeadDto> list = (List<BlcgopHeadDto>) new DAFacade().execQuery(sqlb.toString(),parameter, new BeanListHandler(BlcgopHeadDto.class));
		// 用取出的结果集给对应属性赋.
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	@Override
	public BlCgItmOepDO[] BlcgopBodyFind(String[] cond) throws BizException {

		if (cond[0] == null && cond[1] == null)
			return null;

	StringBuffer whereSql=new StringBuffer();
	if (cond[2] != null && cond[3] != null)
		{
		whereSql.append(" and b.dt_cg between '").append(cond[2]).append("' and '").append(cond[3]).append("'");
		}
	
	if(cond[4] == null || cond[4]==""){
		whereSql.append(" and 1=1 ");	//此时用户选择的是 不限定 这个条件
	}else{
		whereSql.append((cond[4]));   //cond[4]此时取  and a.fg_st='Y' 或者  and a.fg_st='N'  两种情况的字符串
	}
	

	if(cond[5] == null){
		whereSql.append("  ");	
	}else{
		whereSql.append(" and cc.id_inccaitm like '").append(cond[5]).append("%'");
	}
	
	if(cond[6]!=null){
		whereSql.append(" and a.amt_std>=").append(cond[6].toString());
		}
	
	 if(cond[7]==null){
		 whereSql.append("  ");
	 }else{
		 whereSql.append(" and a.id_dep_or like '").append(cond[7]).append("%'"); 
	 }
		
		StringBuffer sb=new StringBuffer();
		sb.append(" select distinct  a.id_cgitmoep,a.id_cgoep,a.id_dep_mp,a.id_dep_or,a.id_emp_or,a.id_ent,a.id_enttp,a.id_srvtp,a.id_pat,a.id_srvca,cc.id_inccaitm,cc.name as inccaitm_name,a.id_srv,a.name_srv,a.srvu,f.name as srvu_name, a.price,a.quan,a.amt,a.amt_hp,a.amt_pat,a.amt_std,a.ratio_hp,a.ratio_pripat,a.amt_acc,a.code_enttp,a.code_mm,a.code_srv,a.dt_or,a.dt_srv,a.dt_st,a.fg_hp,a.fg_mm,a.fg_refund,a.fg_st,a.fg_susp,a.cd_batch,a.id_hp,a.id_mm,a.id_mmtp,a.sd_mmtp,a.code_mm,");
		sb.append("  ");
		sb.append("  ");
		sb.append("  ");
		sb.append("        b.eu_direct,");
		sb.append("        c.code as ent_code,");
		sb.append("        c.code_entp,");
		sb.append("        d.code  as pat_code, ");
		sb.append("        cc.name as inccaitm_name");
		sb.append("  from  bl_cg_itm_oep  a ");
		sb.append(" inner join bl_cg_oep b ");
		sb.append("   on a.id_cgoep=b.id_cgoep ");
		sb.append(" inner join   en_ent  c ");
		sb.append("   on a.id_ent=c.id_ent ");
		sb.append(" inner join  pi_pat   d ");
		sb.append("   on a.id_pat=d.id_pat and c.id_pat=d.id_pat ");
    	sb.append("  left outer join bd_measdoc   f ");
		sb.append("   on a.srvu=f.id_measdoc ");
		sb.append("  inner join bd_incca_itm_rel  bb  on  a.id_srv=bb.id_srv ");
		sb.append("  left  join bd_incca_itm      cc  on  bb.id_inccaitm=cc.id_inccaitm  ");
        sb.append(" where c.code='").append(cond[1]).append("' and d.code='").append(cond[0]).append("'");
	    sb.append(whereSql);
	    sb.append("  AND cc.id_incca='").append(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE).append("'  and a.ds=0  "); 
	    sb.append("  and  a.id_grp='").append(cond[8]).append("'  and a.id_org='").append(cond[9]).append("'");
	   
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> list = (List<BlCgItmOepDO>) new DAFacade().execQuery(sb.toString(), new BeanListHandler(BlCgItmOepDO.class));
		BlCgItmOepDO[] results = list.toArray(new BlCgItmOepDO[0]);
		return results;
	}

}

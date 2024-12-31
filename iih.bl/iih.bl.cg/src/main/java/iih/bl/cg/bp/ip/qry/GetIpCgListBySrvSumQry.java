package iih.bl.cg.bp.ip.qry;

import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.kernel.SqlParam;

import com.mysql.jdbc.StringUtils;

public class GetIpCgListBySrvSumQry implements ITransQry{
	String entId;
	String id_Srv;
	FBoolean fg_Merge;
	String id_dep_or="~";
	String id_dep_mp="~";
	
	String whereStr;
	
	public GetIpCgListBySrvSumQry(String entId,BlIpCgSrvSumDTO inIpCgSrvSumDto,QryRootNodeDTO qryRootNodeDTO) throws BizException {	
		this.entId = entId;
		this.fg_Merge = BlParams.BLSTIP0005();//是否需要母婴合并结算
		this.id_Srv = inIpCgSrvSumDto.getId_srv();
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		this.whereStr = ser.getQueryStringWithoutDesc(qryRootNodeDTO);	
		this.id_dep_mp=inIpCgSrvSumDto.getId_dep_mp();
		this.id_dep_or=inIpCgSrvSumDto.getId_dep_or();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		
		if(FBoolean.TRUE.equals(this.fg_Merge)){    //如果允许母婴合并结算
			//查询医嘱费用条件
			param.addParam(entId);
			param.addParam(entId);
			param.addParam(id_Srv);	
			//查询非医嘱费用条件
			param.addParam(entId);
			param.addParam(entId);
			param.addParam(id_Srv);
			if(!StringUtil.isEmpty(id_dep_or)){
				param.addParam(this.id_dep_or);
			}
			if(!StringUtil.isEmpty(this.id_dep_mp)){
				param.addParam(this.id_dep_mp);
			}
		}else{ //不母婴合并结算时，
			//查询医嘱费用条件
			param.addParam(entId);
			param.addParam(id_Srv);	
			//查询非医嘱费用条件
			param.addParam(entId);
			param.addParam(id_Srv);
			if(!StringUtil.isEmpty(id_dep_or)){
				param.addParam(this.id_dep_or);
			}
			if(!StringUtil.isEmpty(this.id_dep_mp)){
				param.addParam(this.id_dep_mp);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		if(FBoolean.TRUE.equals(this.fg_Merge)){  //允许母婴合并结算时
			// 查询医嘱对应的收费项目
			sb.append("select cgip.id_dep_or,dep.name as name_dep_or,cgip.id_dep_mp,dep2.name as name_dep_mp,");
			sb.append("cgip.id_srv,cgip.name_srv,cgip.price_ratio,(cgip.quan*cgip.eu_direct) as quan_mend,cgip.amt_ratio,nvl(cgip.spec,'/') spec,cgip.name_mm,");
			
			sb.append("cior.name_or name_or, psn.name as name_emp_or, ");
			
			sb.append("cgip.code_inccaitm,cgip.name_inccaitm ,cgip.dt_cg,psn2.name as name_emp_cg, cgip.fg_bb,cgip.fg_additm  ");
			//sb.append(" decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') sd_hpsrvtp ");
			sb.append("from  bl_cg_ip cgip ");
		
			sb.append("join ci_order cior on cior.id_or = cgip.id_or ");
			sb.append("left join bd_psndoc psn on cgip.id_emp_or=psn.id_psndoc ");
			
			sb.append("join bd_dep  dep on cgip.id_dep_or = dep.id_dep ");
			sb.append("join bd_dep  dep2 on  cgip.id_dep_mp = dep2.id_dep ");
			//sb.append("join bd_hp_srvorca  hpsrv on  (cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y') ");
			sb.append("left join bd_psndoc psn2 on cgip.id_emp_cg=psn2.id_psndoc ");
			sb.append(" where (cgip.id_ent =?  or  cgip.id_ent_mom=?) ");
			sb.append(" and cgip.fg_real = 'Y' ");
			sb.append(" and cgip.id_srv = ?  ");	
			sb.append("	AND nvl(cgip.fg_research,'N')='N' ");
			if(!StringUtils.isEmptyOrWhitespaceOnly(this.whereStr))
				sb.append("  and ").append(this.whereStr);
			
			//查询非医嘱对应的收费项目			
			sb.append(" union all ");
			
			sb.append("select cgip.id_dep_or,dep.name as name_dep_or,cgip.id_dep_mp,dep2.name as name_dep_mp,");
			sb.append("cgip.id_srv,cgip.name_srv,cgip.price_ratio,(cgip.quan*cgip.eu_direct) as quan_mend,cgip.amt_ratio,nvl(cgip.spec,'/') spec,cgip.name_mm,");
			
			sb.append("'' name_or, '' as name_emp_or, ");
			
			sb.append("cgip.code_inccaitm,cgip.name_inccaitm ,cgip.dt_cg,psn2.name as name_emp_cg,cgip.fg_bb,cgip.fg_additm ");
			//sb.append(" decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') sd_hpsrvtp ");
			sb.append("from  bl_cg_ip cgip ");

			sb.append("join bd_dep  dep on cgip.id_dep_or = dep.id_dep ");
			sb.append("join bd_dep  dep2 on  cgip.id_dep_mp = dep2.id_dep ");
			//sb.append("join bd_hp_srvorca  hpsrv on  (cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y') ");
			sb.append("left join bd_psndoc psn2 on cgip.id_emp_cg=psn2.id_psndoc ");
			sb.append(" where (cgip.id_or is null or cgip.id_or ='~') and  (cgip.id_ent =?  or  cgip.id_ent_mom=?) ");
			sb.append(" and cgip.fg_real = 'Y' ");
			sb.append(" and cgip.id_srv = ?  ");	
			sb.append("	AND nvl(cgip.fg_research,'N')='N' ");
			if(!StringUtils.isEmptyOrWhitespaceOnly(this.whereStr)){
				sb.append("  and ").append(this.whereStr);
			}
			
			if(!StringUtil.isEmpty(this.id_dep_or)){

				sb.append(" and id_dep_or=?");
			}
			if(!StringUtil.isEmpty(this.id_dep_mp)){
				sb.append(" and id_dep_mp=?");
			}
		    sb.append("  order by dt_cg desc ");	
		}else{
			//非母婴合并结算时 
			// 查询医嘱对应的收费项目
			sb.append("select cgip.id_dep_or,dep.name as name_dep_or,cgip.id_dep_mp,dep2.name as name_dep_mp,");
			sb.append("cgip.id_srv,cgip.name_srv,cgip.price_ratio,(cgip.quan*cgip.eu_direct) as quan_mend,cgip.amt_ratio,nvl(cgip.spec,'/') spec,cgip.name_mm,");
			sb.append("cior.name_or name_or, psn.name as name_emp_or,");
			sb.append("cgip.code_inccaitm,cgip.name_inccaitm ,cgip.dt_cg,psn2.name as name_emp_cg,cgip.fg_bb,cgip.fg_additm ");
			//sb.append(" decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') sd_hpsrvtp ");
			sb.append("from  bl_cg_ip cgip ");
			
			sb.append("join ci_order cior on cior.id_or = cgip.id_or ");
			sb.append("left join bd_psndoc psn on cgip.id_emp_or=psn.id_psndoc ");
			
			sb.append("join bd_dep  dep on cgip.id_dep_or = dep.id_dep ");
			sb.append("join bd_dep  dep2 on  cgip.id_dep_mp = dep2.id_dep ");
			//sb.append("join bd_hp_srvorca  hpsrv on  (cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y') ");
			sb.append("left join bd_psndoc psn2 on cgip.id_emp_cg=psn2.id_psndoc ");
			sb.append(" where  cgip.id_ent =? and cgip.id_srv = ? ");
			sb.append(" and cgip.fg_real = 'Y' ");
			sb.append("	AND nvl(cgip.fg_research,'N')='N' ");
			if(!StringUtils.isEmptyOrWhitespaceOnly(this.whereStr))
				sb.append("  and ").append(this.whereStr);
			
			//查询非医嘱对应的收费项目			
			sb.append(" union all ");
			
			sb.append("select cgip.id_dep_or,dep.name as name_dep_or,cgip.id_dep_mp,dep2.name as name_dep_mp,");
			sb.append("cgip.id_srv,cgip.name_srv,cgip.price_ratio,(cgip.quan*cgip.eu_direct) as quan_mend,cgip.amt_ratio,nvl(cgip.spec,'/') spec,cgip.name_mm,");
			sb.append("'' name_or, '' as name_emp_or, ");
			sb.append("cgip.code_inccaitm,cgip.name_inccaitm ,cgip.dt_cg,psn2.name as name_emp_cg ,cgip.fg_bb,cgip.fg_additm ");
			//sb.append(" decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') sd_hpsrvtp ");
			sb.append("from  bl_cg_ip cgip ");
			
			sb.append("join bd_dep  dep on cgip.id_dep_or = dep.id_dep ");
			sb.append("join bd_dep  dep2 on  cgip.id_dep_mp = dep2.id_dep ");
			//sb.append("join bd_hp_srvorca  hpsrv on  (cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y') ");
			sb.append("left join bd_psndoc psn2 on cgip.id_emp_cg=psn2.id_psndoc ");
			sb.append(" where (cgip.id_or is null or cgip.id_or ='~') and (cgip.id_ent =?  ) ");
			sb.append(" and cgip.fg_real = 'Y' ");
			sb.append(" and cgip.id_srv = ?  ");	
			sb.append("	AND nvl(cgip.fg_research,'N')='N' ");
			if(!StringUtils.isEmptyOrWhitespaceOnly(this.whereStr)){
				sb.append("  and ").append(this.whereStr);
			}
			
			if(!StringUtil.isEmpty(this.id_dep_or)){

				sb.append(" and id_dep_or=?");
			}
			if(!StringUtil.isEmpty(this.id_dep_mp)){
				sb.append(" and id_dep_mp=?");
			}
		    sb.append(" order by dt_cg desc ");
		}
		return sb.toString();
	}
}

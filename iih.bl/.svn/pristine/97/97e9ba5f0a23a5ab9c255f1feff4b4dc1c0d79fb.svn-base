package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询住院医保审核费用明细信息-不分组
 * @author hanjq
 *
 */
public class GetIpAuditFeeDetailsBp {

	@SuppressWarnings("unchecked")
	public PagingRtnData<BlIpAuditFeeDTO> exec(PaginationInfo pgInfo, String idEnt, String wherePart) throws BizException {
		FBoolean fg_merge =  BlParams.BLSTIP0005();//是否需要母婴合并结算
		if(StringUtils.isBlank(idEnt)){
			throw new BizException("就诊id不能为空");
		}
		SqlParam param = new SqlParam();
		String sql = getSql(fg_merge, idEnt, wherePart,param);
		PagingServiceImpl<BlIpAuditFeeDTO> pageService = new PagingServiceImpl<BlIpAuditFeeDTO>();
		PagingRtnData<BlIpAuditFeeDTO> pageAudit = pageService.findByPageInfo(new BlIpAuditFeeDTO(), pgInfo, sql.toString(), "", param);
		if(pageAudit != null && pageAudit.getPageData() != null && pageAudit.getPageData().size() > 0){
			FArrayList data = pageAudit.getPageData();
			List<BlIpAuditFeeDTO> auditList = new ArrayList<>(data.size());
			for(Object obj : data){
				if(obj != null && obj instanceof BlIpAuditFeeDTO)
					auditList.add((BlIpAuditFeeDTO)obj);
			}
			GetIpAuditFeesBp bp = new GetIpAuditFeesBp();
			bp.addDepInfos(auditList);
			bp.addHpRelatedField(auditList);
			data = new FArrayList();
			data.addAll(auditList);
			pageAudit.setPageData(data);
		}
		
		return pageAudit;
	}

	

	private String getSql(FBoolean fg_merge,String idEnt,String wherePart,SqlParam param){
		// 1、查询数据
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT cg.Id_cgip, 				");
		sql.append("		cg.Id_ent,					");
		sql.append(" 		cg.Id_srv, 					");
		sql.append(" 		cg.Id_mm, 					");
		sql.append(" 		cg.name_srv, 				");
		sql.append("		cg.name_inccaitm ITMNAME, 	");
		sql.append("		cg.code_inccaitm,			 ");
		sql.append("		cg.name_inccaitm,			 ");
		sql.append("		to_char(cg.PRICE, '99999990.0000') as price, ");
		sql.append("		to_char(cg.QUAN * cg.EU_DIRECT, '99999990.00') AS QUAN,	");
		sql.append("		to_char(cg.PRICE_RATIO, '99999990.0000') as price_ratio,");
		sql.append("		cg.SPEC, 		");
		sql.append("		cg.Id_dep_or,	");
		sql.append("		cg.Id_dep_nur,	");
		sql.append("		cg.Id_dep_mp,	");
		sql.append("		cg.Dt_or,		");
		sql.append("		cg.Dt_srv,		");
		sql.append("		unit.NAME as unit_name,		 ");
		sql.append("		cg.Id_emp_cg,empcg.NAME AS Name_emp_cg,	");
		sql.append("		cg.Dt_cg,	");
		sql.append("		cg.Fg_bb,	");
		sql.append("		decode(cg.Fg_selfpay,'Y','N','Y') Fg_hpin,	");
		sql.append(" 		cg.Name_mm, 				");
		sql.append(" 		cg.Code_mm, 				");
		sql.append(" 		cg.Fg_hp, 				");
		sql.append("		to_char(cg.AMT_RATIO * cg.EU_DIRECT, '99999990.00') AS AMT_RATIO, ");
		sql.append("		cg.Id_emp_or,emp.NAME AS Emp_name_or,	");
		sql.append("		cg.ratio_pripat	");
		sql.append(" FROM BL_CG_IP cg		");
		sql.append(" LEFT JOIN BD_PSNDOC emp  ON cg.ID_EMP_OR = emp.ID_PSNDOC	");
		sql.append(" LEFT JOIN BD_PSNDOC empcg  ON cg.ID_EMP_OR = empcg.ID_PSNDOC	");
		sql.append(" LEFT JOIN BD_MEASDOC unit  ON cg.SRVU = unit.ID_MEASDOC	");
		sql.append(" where 1=1	");
		
		if(StringUtils.isNotBlank(idEnt)){
			if(FBoolean.TRUE.equals(fg_merge)){
				sql.append(" and (cg.id_ent = ? or cg.id_ent_mom = ?)	");
				param.addParam(idEnt);		
				param.addParam(idEnt);
			}else{
				sql.append(" and cg.id_ent = ? 	");
				param.addParam(idEnt);		
			}
		}		
		
		if(StringUtils.isNotBlank(wherePart)){
			sql.append(" and ").append(wherePart);
		}
		
		sql.append(" order by cg.dt_cg ");
		return sql.toString();
	}
	

}

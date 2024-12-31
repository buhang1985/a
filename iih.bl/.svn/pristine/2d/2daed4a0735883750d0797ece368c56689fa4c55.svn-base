package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.mi.mibd.dep.d.DepDo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询住院医保审核费用明细
 * @author hanjq
 *
 */
public class GetIpAuditFeesBp {

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
			addDepInfos(auditList);
			addHpRelatedField(auditList);
			data = new FArrayList();
			data.addAll(auditList);
			pageAudit.setPageData(data);
		}
		
		return pageAudit;
	}

	

	private String getSql(FBoolean fg_merge,String idEnt,String wherePart,SqlParam param){
		// 1、查询数据
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  				");
		sql.append("		cg.Id_ent,					");
		sql.append(" 		cg.Id_srv, 					");
		sql.append(" 		cg.Id_mm, 					");
		sql.append(" 		cg.name_srv, 				");
		sql.append("		cg.name_inccaitm ITMNAME, 	");
		sql.append("		cg.code_inccaitm,			 ");
		sql.append("		cg.name_inccaitm,			 ");
		sql.append("		to_char(cg.PRICE, '99999990.0000') as price, ");
		sql.append("		to_char(sum(QUAN * EU_DIRECT), '99999990.00') AS QUAN,	");
		sql.append("		to_char(cg.PRICE_RATIO, '99999990.0000') as price_ratio,");
		sql.append("		cg.SPEC, 		");
		sql.append("		cg.Id_dep_or,	");
		sql.append("		cg.Id_dep_nur,	");
		sql.append("		cg.Id_dep_mp,	");
		sql.append("		unit.NAME as unit_name,		 ");
		sql.append("		cg.Id_emp_cg,empcg.NAME AS Name_emp_cg,	");
		sql.append("		cg.Fg_bb,	");
		sql.append("		decode(cg.Fg_selfpay,'Y','N','Y') Fg_hpin,	");
		sql.append(" 		cg.Name_mm, 				");
		sql.append(" 		cg.Code_mm, 				");
		sql.append(" 		cg.Fg_hp, 				");
		sql.append("		to_char(sum(cg.AMT_RATIO * cg.EU_DIRECT), '99999990.00') AS AMT_RATIO, ");
		sql.append("		cg.Id_emp_or,emp.NAME AS Emp_name_or,	");
		sql.append("		cg.ratio_pripat	");
		sql.append(" FROM BL_CG_IP cg		");
		sql.append(" LEFT JOIN BD_PSNDOC emp  ON cg.ID_EMP_OR = emp.ID_PSNDOC	");
		sql.append(" LEFT JOIN BD_PSNDOC empcg  ON cg.ID_EMP_OR = empcg.ID_PSNDOC	");
		sql.append(" LEFT JOIN BD_MEASDOC unit  ON cg.SRVU = unit.ID_MEASDOC	");
		sql.append(" where 1=1	");
		
		if(FBoolean.TRUE.equals(fg_merge)){
			sql.append(" and (cg.id_ent = ? or cg.id_ent_mom = ?)	");
			param.addParam(idEnt);		
			param.addParam(idEnt);
		}else{
			sql.append(" and cg.id_ent = ? 	");
			param.addParam(idEnt);		
		}
		
		if(StringUtils.isNotBlank(wherePart)){
			sql.append(" and ").append(wherePart);
		}

		sql.append(" group by cg.Id_ent,cg.Id_srv,cg.Id_mm,cg.name_srv, ");
		sql.append("  cg.name_inccaitm,cg.code_inccaitm,cg.PRICE,cg.QUAN,cg.EU_DIRECT,cg.PRICE_RATIO, ");
		sql.append("  cg.SPEC,cg.Id_dep_or,cg.Id_dep_nur,cg.Id_dep_mp, ");
		sql.append(" unit.NAME,cg.Id_emp_cg,empcg.NAME,cg.Fg_bb,cg.Fg_selfpay,cg.Name_mm, ");
		sql.append(" cg.Code_mm,cg.Fg_hp,cg.Id_emp_or,emp.NAME,cg.ratio_pripat ");
		return sql.toString();
	}
	
	/**
	 * 添加部门信息
	 * @param auditList
	 * @throws DAException
	 */
	public void addDepInfos(List<BlIpAuditFeeDTO> auditList) throws DAException {
		HashSet<String> idDeps = new HashSet<>();
		for(BlIpAuditFeeDTO itm:auditList){
			if(StringUtils.isNotBlank(itm.getId_dep_mp()))
				idDeps.add(itm.getId_dep_mp());
			if(StringUtils.isNotBlank(itm.getId_dep_or()))
				idDeps.add(itm.getId_dep_or());
			if(StringUtils.isNotBlank(itm.getId_dep_nur()))
				idDeps.add(itm.getId_dep_nur());
		}
		
		String sql = "select id_dep,name from bd_dep where id_dep in("+SqlUtils.arrayToStr(idDeps.toArray(new String[0]))+")";
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<DepDo> deps = (List<DepDo>) daf.execQuery(sql, new BeanListHandler(DepDo.class));
		if(deps != null && deps.size() > 0){
			HashMap<String, String> idName = new HashMap<>();
			for(DepDo dep:deps){
				idName.put(dep.getId_dep(), dep.getName());
			}
			for(BlIpAuditFeeDTO itm:auditList){
				itm.setName_dep_mp(idName.get(itm.getId_dep_mp()));
				itm.setName_dep_or(idName.get(itm.getId_dep_or()));
				itm.setName_dep_nur(idName.get(itm.getId_dep_nur()));
			}
		}
	}
	
	/**
	 * 添加医保相关字段: 医保适应症 医院适应症 医保等级
	 * @param bList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void addHpRelatedField(List<BlIpAuditFeeDTO> bList) throws BizException {

		if (ListUtil.isEmpty(bList) || StringUtils.isBlank(bList.get(0).getId_ent()))
			return;
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct  hpsrvca.id_srv,hpsrvca.id_mm,hpsrvca.des ,hpsrvca.his_des,hpsrvca.sd_hpsrvtp,udidoc.name as name_hpsrvtp,hpsrvca.code Hp_srvcode,hpsrvca.name Hp_srvname  ");
		sql.append("from bd_hp_srvorca hpsrvca  ");
		sql.append("join bd_udidoc udidoc on hpsrvca.id_hpsrvtp = udidoc.id_udidoc  ");//增加医保目录类型编码，医保计划目录类型名称 2020/6/4
		sql.append("join en_ent ent on ent.id_hp = hpsrvca.id_hp  ");
		sql.append("where ent.id_ent = ? and decode(nvl(hpsrvca.id_mm,'~'),'~',hpsrvca.id_srv,hpsrvca.id_mm) in (");
		String douHao = "";
		String danYinHao = "'";
		HashSet<String> keys = new HashSet<>();
		for (BlIpAuditFeeDTO bFeeDTO : bList) {
			String key = getKey(bFeeDTO.getId_srv(), bFeeDTO.getId_mm());
			if(!keys.contains(key)){
				sql.append(douHao).append(danYinHao).append(key).append(danYinHao);
				douHao=",";
				keys.add(key);
			}
		}
		sql.append(") ");
		
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(bList.get(0).getId_ent());
		List<BlIpAuditFeeDTO> comp =(List<BlIpAuditFeeDTO>) daf.execQuery(sql.toString(),param, new BeanListHandler(BlIpAuditFeeDTO.class));
		HashMap<String, BlIpAuditFeeDTO> compMap = new HashMap<>();
		if (!ListUtil.isEmpty(comp)){
			for(BlIpAuditFeeDTO itm:comp){
				compMap.put(getKey(itm.getId_srv(), itm.getId_mm()), itm);
			}
		}
		BlIpAuditFeeDTO compItm = null;
		for(BlIpAuditFeeDTO itm:bList){
			compItm = compMap.get(getKey(itm.getId_srv(), itm.getId_mm()));
			if(compItm != null){
				itm.setDes(compItm.getDes());
				itm.setHis_des(compItm.getHis_des());
				itm.setSd_hpsrvtp(compItm.getSd_hpsrvtp());
				itm.setName_hpsrvtp(compItm.getName_hpsrvtp());
				itm.setHp_srvcode(compItm.getHp_srvcode());
				itm.setHp_srvname(compItm.getHp_srvname());
			}else{
				itm.setSd_hpsrvtp("3");//丙类
				itm.setName_hpsrvtp("丙类");
			}
		}
	}
	
	private String getKey(String idSrv,String idMM){
		if(StringUtils.isNotBlank(idMM) && !"~".equals(idMM)){
			return idMM;
		}
		return idSrv;		
	}
}

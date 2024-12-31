package iih.bl.cg.bp;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.mp.ot.dto.depitm.d.MpOtDeptDTO;
import iih.pi.reg.pat.d.PatDO;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

public class QueryBlCg {

	public BlIpAuditFeeDTO[] queryBlCgByCond(FMap2 queryMap) throws DAException {
		if( queryMap == null )
		return null;
		
		
		List<BlIpAuditFeeDTO> datas = null;
		
		 
		// 1、查询数据
		StringBuilder sql = new StringBuilder();
		String orgSql = EnvContextUtil.processEnvContext("", new IncCaItmDO(), "ITM");
		sql.append("SELECT SUM(A0.AMT_RATIO * A0.EU_DIRECT) AS AMT_RATIO, ");
		sql.append("A0.NAME_SRV, C0.NAME as unit_name, SUM(QUAN*EU_DIRECT) AS QUAN, A0.SPEC, F0.ITMNAME, ");
		sql.append("A0.PRICE_RATIO PRICE, A0.ID_DEP_OR, A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.ID_SRV, A0.ID_ENT, ");
		sql.append("A0.ID_EMP_OR, B0.NAME AS EMP_NAME_OR, a0.code_inccaitm, a0.name_inccaitm ");
		sql.append("FROM BL_CG_IP A0 ");
		sql.append("LEFT JOIN ");
		sql.append("(SELECT DISTINCT INCCA.NAME, INCCA.CODE, INCCA.ID_INCCA, ITM.NAME AS ITMNAME, ITM.ID_INCCAITM, ITM.CODE AS CODE_INCCAITM ");
		sql.append(" FROM BD_INCCA_ITM ITM ");
		//sql.append("INNER JOIN BD_INCCA_ITM ITM ON ITMREL.ID_INCCA = ITM.ID_INCCA AND ITMREL.ID_INCCAITM = ITM.ID_INCCAITM  ");
		sql.append("INNER JOIN BD_INCCA INCCA ON ITM.ID_INCCA = INCCA.ID_INCCA WHERE INCCA.CODE = '12' and"+orgSql+") F0 ");
		sql.append(" ON A0.CODE_INCCAITM = F0.CODE_INCCAITM ");

		sql.append("LEFT JOIN BD_PSNDOC B0 ON A0.ID_EMP_OR = B0.ID_PSNDOC ");
		sql.append("LEFT JOIN BD_MEASDOC C0 ON A0.SRVU = C0.ID_MEASDOC ");
		sql.append("WHERE A0.DS = 0 and a0.fg_real = 'Y' and a0.id_ent = ? and a0.dt_cg >= ? and a0.dt_cg <= ?  ");
		
		SqlParam param = new SqlParam();
		String id_ent = "";
		String dt_cg_begin ="";
		String dt_cg_end = "";
		StringBuilder queryCond = new StringBuilder();
		 for (String keyString : queryMap.keySet()) {
	            System.out.println("key:" + keyString);
	            System.out.println("values:" + queryMap.get(keyString));
	            if(queryMap.isEmpty())
	            	break;
	            if(keyString.equals("id_ent"))
	            {
	            	id_ent = queryMap.get(keyString).toString();	
	            	continue;
	            }
	            else if(keyString.equals("dt_cg_begin"))
	            {
	            	dt_cg_begin = queryMap.get(keyString).toString();	
	            	continue;
	            }
	            else if(keyString.equals("dt_cg_end"))
	            {
	            	dt_cg_end = queryMap.get(keyString).toString();	
	            	continue;
	            }	           
	            else {            	
	            	queryCond.append(queryMap.get(keyString).toString());}
	            
	            }
		 param.addParam(id_ent);
		 param.addParam(dt_cg_begin);
		 param.addParam(dt_cg_end);
		 if(queryCond.length() > 0){
			 sql.append(queryCond);
		 }
		
		sql.append("GROUP BY a0.code_inccaitm,a0.name_inccaitm,ITMNAME,NAME_SRV,PRICE_RATIO,SPEC,A0.ID_ENT,A0.ID_SRV, ");
		sql.append("  A0.ID_DEP_OR,A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.ID_EMP_OR, B0.NAME,C0.NAME ORDER  BY ITMNAME ");

		

		@SuppressWarnings("unchecked")
		List<BlIpAuditFeeDTO> auditList = (List<BlIpAuditFeeDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(BlIpAuditFeeDTO.class));
		if (auditList == null || auditList.size() == 0) {
			return null;
		}

		// 2、将查询出来的科室Id结果集放入map
		Map<String, MpOtDeptDTO> deptDtoMap = new HashMap<String, MpOtDeptDTO>();
		DAFacade dAFacade = new DAFacade();

		@SuppressWarnings("unchecked")
		List<MpOtDeptDTO> deptDtoList = (List<MpOtDeptDTO>) dAFacade.execQuery(
				"SELECT ID_ORG AS ID_DEP,NAME AS NAME_DEP FROM BD_ORG ",
				new BeanListHandler(MpOtDeptDTO.class));

		if (deptDtoList != null && deptDtoList.size() > 0) {
			for (MpOtDeptDTO deptDto : deptDtoList) {
				if (deptDtoMap.get(deptDto.getId_dep()) == null) {
					// 向Map中添加键值 <对象主键,对象>
					deptDtoMap.put(deptDto.getId_dep(), deptDto);
				}
			}
		}

		// 3、根据科室病区id 获取名称
		datas = new ArrayList<BlIpAuditFeeDTO>();
		for (BlIpAuditFeeDTO feeInfoDto : auditList) {
			// 开立科室名称
			String idDepOr = feeInfoDto.getId_dep_or();
			MpOtDeptDTO depDtoOr = deptDtoMap.get(idDepOr);
			if (depDtoOr != null) {
				feeInfoDto.setName_dep_or(depDtoOr.getName_dep());
			} else {
				feeInfoDto.setName_dep_or(null);
			}

			// 病区名称
			String idDepNur = feeInfoDto.getId_dep_nur();
			MpOtDeptDTO depDtoNur = deptDtoMap.get(idDepNur);
			if (depDtoNur != null) {
				feeInfoDto.setName_dep_nur(depDtoNur.getName_dep());
			} else {
				feeInfoDto.setName_dep_nur(null);
			}

			// 执行科室名称
			String idDepMp = feeInfoDto.getId_dep_mp();
			MpOtDeptDTO depDtoMp = deptDtoMap.get(idDepMp);
			if (depDtoMp != null) {
				feeInfoDto.setName_dep_mp(depDtoMp.getName_dep());
			} else {
				feeInfoDto.setName_dep_mp(null);
			}
			datas.add(feeInfoDto);
		}

		BlIpAuditFeeDTO[] datasArr = datas.toArray(new BlIpAuditFeeDTO[] {});
		return datasArr;
	}
	
	/**
	 * 获取某服务项目对应的记账明细 (分页)
	 * @param BlIpAuditFeeDTO
	 * @param PaginationInfo
	 * @author liwq
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditFeeDTO> getIpCgFeeDetail(BlIpAuditFeeDTO feeDto, PaginationInfo pageInfo) throws BizException  {
		if( feeDto == null ||feeDto.getId_ent() == null || feeDto.getId_srv() == null)
			return null;	

		PagingRtnData<BlIpAuditFeeDTO> pageFeeDTO = new PagingRtnData<BlIpAuditFeeDTO>();
		PagingServiceImpl<BlIpAuditFeeDTO> service =new PagingServiceImpl();
		
			String id_ent = feeDto.getId_ent();
			String id_srv = feeDto.getId_srv();
			List<BlIpAuditFeeDTO> datas = null;			
			 
			// 1、查询数据
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT A0.NAME_SRV, A0.SPEC, A0.PRICE_RATIO PRICE,C0.NAME AS UNIT_NAME, A0.QUAN*EU_DIRECT AS QUAN, A0.DT_OR DT_OR, A0.ID_EMP_OR, ");
			sql.append("A0.ID_DEP_OR, A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.DT_SRV, A0.ID_SRV,A0.ID_ENT, ");
			sql.append(" B0.NAME AS EMP_NAME_OR,A0.DT_CG,D0.NAME AS NAME_EMP_CG,A0.NOTE ");
			sql.append("FROM BL_CG_IP A0 ");
			sql.append("LEFT JOIN BD_PSNDOC B0 ON A0.ID_EMP_OR = B0.ID_PSNDOC ");
			sql.append("LEFT JOIN BD_PSNDOC D0 ON A0.ID_EMP_CG = D0.ID_PSNDOC ");
			sql.append("LEFT JOIN BD_MEASDOC C0 ON A0.SRVU = C0.ID_MEASDOC ");
			sql.append("WHERE A0.DS = 0 and a0.fg_real = 'Y' and A0.ID_ENT = ? AND A0.ID_SRV = ?  ");
			sql.append("and a0.price_ratio = ? ");
			
			if(feeDto.getId_dep_or() != null){
				sql.append(" AND A0.ID_DEP_OR = '").append(feeDto.getId_dep_or()).append("' ");
			}
			if(feeDto.getId_dep_mp() != null){
				sql.append(" AND A0.ID_DEP_MP = '").append(feeDto.getId_dep_mp()).append("' ");
			}
			if(feeDto.getId_dep_nur() != null){
				sql.append(" AND A0.ID_DEP_NUR = '").append(feeDto.getId_dep_nur()).append("' ");
			}
			
			sql.append(" ORDER BY A0.DT_CG DESC ");
			
			SqlParam param = new SqlParam();
			param.addParam(id_ent);
			param.addParam(id_srv);	
			param.addParam(feeDto.getPrice());
			
			pageFeeDTO = service.findByPageInfo(new BlIpAuditFeeDTO(), pageInfo, sql.toString(), "", param);
			List<BlIpAuditFeeDTO> feeItemlist = new ArrayList<BlIpAuditFeeDTO>();
			feeItemlist = pageFeeDTO.getPageData();
			if (feeItemlist == null || feeItemlist.size() == 0) {
				return null;
			}

			// 2、将查询出来的科室Id结果集放入map
			Map<String, MpOtDeptDTO> deptDtoMap = new HashMap<String, MpOtDeptDTO>();
			DAFacade dAFacade = new DAFacade();

			@SuppressWarnings("unchecked")
			List<MpOtDeptDTO> deptDtoList = (List<MpOtDeptDTO>) dAFacade.execQuery(
					"SELECT ID_ORG AS ID_DEP,NAME AS NAME_DEP FROM BD_ORG ",
					new BeanListHandler(MpOtDeptDTO.class));

			if (deptDtoList != null && deptDtoList.size() > 0) {
				for (MpOtDeptDTO deptDto : deptDtoList) {
					if (deptDtoMap.get(deptDto.getId_dep()) == null) {
						// 向Map中添加键值 <对象主键,对象>
						deptDtoMap.put(deptDto.getId_dep(), deptDto);
					}
				}
			}

			// 3、根据科室病区id 获取名称
			datas = new ArrayList<BlIpAuditFeeDTO>();
			for (BlIpAuditFeeDTO feeInfoDto : feeItemlist) {
				// 开立科室名称
				String idDepOr = feeInfoDto.getId_dep_or();
				MpOtDeptDTO depDtoOr = deptDtoMap.get(idDepOr);
				if (depDtoOr != null) {
					feeInfoDto.setName_dep_or(depDtoOr.getName_dep());
				} else {
					feeInfoDto.setName_dep_or(null);
				}

				// 病区名称
				String idDepNur = feeInfoDto.getId_dep_nur();
				MpOtDeptDTO depDtoNur = deptDtoMap.get(idDepNur);
				if (depDtoNur != null) {
					feeInfoDto.setName_dep_nur(depDtoNur.getName_dep());
				} else {
					feeInfoDto.setName_dep_nur(null);
				}

				// 执行科室名称
				String idDepMp = feeInfoDto.getId_dep_mp();
				MpOtDeptDTO depDtoMp = deptDtoMap.get(idDepMp);
				if (depDtoMp != null) {
					feeInfoDto.setName_dep_mp(depDtoMp.getName_dep());
				} else {
					feeInfoDto.setName_dep_mp(null);
				}
				datas.add(feeInfoDto);
			}

			BlIpAuditFeeDTO[] datasArr = datas.toArray(new BlIpAuditFeeDTO[] {});
			FArrayList list = new FArrayList();
			for(BlIpAuditFeeDTO itm : datasArr)
			{
				list.add(itm);
			}
			
			 pageFeeDTO.setPageData(list);
			 return pageFeeDTO;
	}
}

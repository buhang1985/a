package iih.bl.st.blauditip.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.utils.StringUtil;

import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlAuditIncInfoDTO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlIpAuditStPayInfoDTO;
import iih.bl.st.dto.d.BlIpChargeAuditDTO;
import iih.mp.ot.dto.depitm.d.MpOtDeptDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 住院费用审核相关函数
 * 
 * @author liwq
 *
 */
public class GetIpChargeAuditInfoBp {
	/**
	 * 根据id_ent 获取树形节点值
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlIpChargeAuditDTO[] findFeeStateByIdent(String id_ent)
			throws BizException {
		List<BlIpChargeAuditDTO> datas = null;
		datas = new ArrayList<BlIpChargeAuditDTO>();

		if (id_ent == "" || id_ent == null) {
			return null;
		}

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT A.ID_STIP,A.ID_ENT,A.DT_START,A.DT_END,A.FG_PAY,A.FG_CANC ");
		sql.append("FROM BL_ST_IP A WHERE A.EU_DIRECT = 1  AND A.ID_ENT = '" + id_ent
				+ "' ORDER BY A.DT_ST ");
		FArrayList flist = AppFwUtil.getMapListWithDao(sql.toString());
		if (null == flist || flist.size() == 0) {
			return null;
		}

		for (int i = 0; i < flist.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) flist.get(i);
			BlIpChargeAuditDTO dto = new BlIpChargeAuditDTO();
			String key = "id_stip";
			dto.setId_stip(map.get(key) == null ? null : map.get(key)
					.toString());
			key = "id_ent";
			dto.setId_ent(map.get(key) == null ? null : map.get(key).toString());

			key = "fg_pay";
			dto.setFg_pay(map.get(key) == null ? null : map.get(key).toString());
			key = "fg_st";
			dto.setFg_st(map.get(key) == null ? null : map.get(key).toString());
			dto.setId_tr(String.valueOf(i + 1));

			key = "fg_canc";
			String fg_canc = map.get(key) == null ? null : map.get(key).toString();
			
			StringBuilder Name_tr = new StringBuilder();
			String strState = (dto.getFg_pay().equals("N") && fg_canc.equals("N")) ? "结算" : ((dto.getFg_pay().equals("Y") && fg_canc.equals("Y")) ? "冲账" : "付款");
			
			String strStartDate = map.get("dt_start").toString()
					.substring(0, 10);
			String strEndtDate = map.get("dt_end").toString().substring(0, 10);
			Name_tr.append("账页：" + String.valueOf(i + 1) + "(" + strState
					+ ") ");
			Name_tr.append(strStartDate + "至" + strEndtDate);
			dto.setName_tr(Name_tr.toString());
			dto.setFg_st("Y");
			// dto.setLevel_tr(3);

			datas.add(dto);
		}
		BlIpChargeAuditDTO[] dtoArr = datas
				.toArray(new BlIpChargeAuditDTO[] {});

		return dtoArr;
	}

	/**
	 * 根据就诊id获取已结算发票信息
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param id_stip
	 *            结算id
	 * @return BlAuditIncInfoDTO[] 费用审核-发票信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	@SuppressWarnings("unchecked")
	public BlAuditIncInfoDTO[] getBlAuditIncInfoByIdEnt(String id_ent,
			String id_stip) throws DAException {
		List<BlAuditIncInfoDTO> datas = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT A.ID_STIP,A.ID_ENT,C.ID_INCIP Id_inc,C.INCNO,C.DT_INC,C.AMT AS AMT_INC,A.DT_ST,A.ID_EMP_ST, ");
		sql.append("C.DT_INC AS DT_PAY,B.ID_EMP_PAY,A.FG_PAY,C.ID_EMP_INC,A.FG_CANC FROM BL_ST_IP A ");
		sql.append("INNER JOIN BL_PAY_PAT_IP B ON A.ID_STIP = B.ID_STIP ");
		sql.append("LEFT JOIN BL_INC_IP C ON A.ID_STIP = C.ID_STIP ");
		sql.append("WHERE A.ID_ENT = ? ");

		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		if (id_stip != null) {
			sql.append(" AND A.ID_STIP = ? AND C.AMT != 0");
			param.addParam(id_stip);
		}

		List<BlAuditIncInfoDTO> auditList = (List<BlAuditIncInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), param, new BeanListHandler(
						BlAuditIncInfoDTO.class));
		if (auditList == null || auditList.size() == 0) {
			return null;
		}

		// 将查询出来的人员Id结果集放入map
		Map<String, PsnDocDO> psnDocMap = new HashMap<String, PsnDocDO>();
		String[] fields = { "Id_psndoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		List<PsnDocDO> psnDocDOList = (List<PsnDocDO>) dAFacade.findByCond(
				PsnDocDO.class, "1=1", "1", fields);
		if (psnDocDOList != null && psnDocDOList.size() > 0) {
			for (PsnDocDO psnDocDO : psnDocDOList) {
				if (psnDocMap.get(psnDocDO.getId_psndoc()) == null) {
					// 向Map中添加键值 <对象主键,对象>
					psnDocMap.put(psnDocDO.getId_psndoc(), psnDocDO);
				}
			}
		}

		// 根据id_emp 获取name
		datas = new ArrayList<BlAuditIncInfoDTO>();

		for (BlAuditIncInfoDTO incInfoDto : auditList) {
			// 结算人名称
			String idEmpSt = incInfoDto.getId_emp_st();
			PsnDocDO psnDoSt = psnDocMap.get(idEmpSt);
			if (psnDoSt != null) {
				incInfoDto.setEmp_st_name(psnDoSt.getName());
			} else {
				incInfoDto.setEmp_st_name(null);
			}
			// 收款人名称
			String idEmpPay = incInfoDto.getId_emp_pay();
			PsnDocDO psnDoPay = psnDocMap.get(idEmpPay);
			if (psnDoPay != null) {
				incInfoDto.setEmp_pay_name(psnDoPay.getName());
			} else {
				incInfoDto.setEmp_pay_name(null);
			}
			// 发票开立人名称
			String idEmpInc = incInfoDto.getId_emp_inc();
			PsnDocDO psnDoInc = psnDocMap.get(idEmpInc);
			if (psnDoInc != null) {
				incInfoDto.setEmp_inc_name(psnDoInc.getName());
			} else {
				incInfoDto.setEmp_inc_name(null);
			}
			// 设置已结算树节点名称
			if (incInfoDto.getFg_pay().equals("Y") && incInfoDto.getFg_canc().equals("Y")) {
				incInfoDto.setOnstatus("冲账");
			} else if (incInfoDto.getFg_pay().equals("N") && incInfoDto.getFg_canc().equals("N")){
				incInfoDto.setOnstatus("结算");
			} else {
				incInfoDto.setOnstatus("付款");
			}

			datas.add(incInfoDto);
		}

		BlAuditIncInfoDTO[] datasArr = datas
				.toArray(new BlAuditIncInfoDTO[] {});
		return datasArr;
	}

	/**
	 * 根据就诊id_ent id_stip fg_st获取费用信息 
	 * @param BlIpChargeAuditDTO 树形节点模型
	 * @param id_ent      就诊id
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	public BlIpAuditFeeDTO[] getBlIpAuditFeeInfo(BlIpChargeAuditDTO treeAuditDTO)
			throws DAException {
		if (treeAuditDTO == null)
			return null;
		if (treeAuditDTO.getId_ent() == null
//				|| treeAuditDTO.getFg_pay() == null
				|| treeAuditDTO.getFg_st() == null)
			return null;

		String id_ent = treeAuditDTO.getId_ent();
		String fg_st = treeAuditDTO.getFg_st();
		String id_stip = treeAuditDTO.getId_stip();

		List<BlIpAuditFeeDTO> datas = null;
		// 1、查询数据
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from ( ");
		sql.append("SELECT to_char(SUM(A0.AMT_RATIO * A0.EU_DIRECT), '99999990.00') AS AMT_RATIO, ");
		sql.append("A0.NAME_SRV, to_char(SUM(QUAN*EU_DIRECT) , '99999990.00')  AS QUAN, C0.NAME as unit_name, A0.SPEC, F0.ITMNAME, to_char(A0.PRICE, '99999990.0000') as price,to_char(A0.PRICE_RATIO, '99999990.0000') as price_ratio, ");
		sql.append("A0.ID_DEP_OR, A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.ID_SRV, A0.ID_ENT, ");
		sql.append("A0.ID_EMP_OR, B0.NAME AS EMP_NAME_OR , a0.ratio_pripat ");
		sql.append("FROM BL_CG_IP A0 ");

		sql.append("LEFT JOIN ");
		sql.append("( SELECT DISTINCT INCCA.NAME, INCCA.CODE, INCCA.ID_INCCA, ITM.NAME AS ITMNAME, ");
		sql.append("ITMREL.ID_INCCAITM, ITMREL.ID_SRV FROM BD_INCCA_ITM_REL ITMREL ");
		sql.append("INNER JOIN BD_INCCA_ITM ITM ON ITMREL.ID_INCCA = ITM.ID_INCCA AND ITMREL.ID_INCCAITM = ITM.ID_INCCAITM ");
		sql.append("INNER JOIN BD_INCCA INCCA ON ITM.ID_INCCA = INCCA.ID_INCCA WHERE INCCA.CODE = '12' ) F0 ");
		sql.append("ON A0.ID_SRV = F0.ID_SRV ");

		sql.append("LEFT JOIN BD_PSNDOC B0 ON A0.ID_EMP_OR = B0.ID_PSNDOC ");
		sql.append("LEFT JOIN BD_MEASDOC C0 ON A0.SRVU = C0.ID_MEASDOC ");
		sql.append("WHERE ((A0.ID_ENT = ? or a0.id_ent_mom = ?) ");
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(id_ent);
		//点击未结费用 即查询未结算的费用信息
		if(fg_st.equals("N") && (treeAuditDTO.getLevel_tr() == Integer.valueOf("2"))){
			sql.append("AND A0.FG_ST = 'N' ");
		}
//		//点击已结费用节点 查询条件 即查询所有已经结算的费用信息
//		if(treeAuditDTO.getLevel_tr() == 2 && fg_st == "Y"){
//			sql.append("AND A0.FG_ST = 'Y' ");
//		}
		//点击已结费用的子节点时，查询条件 即 查询某一次已经结算的费用信息
		if(fg_st.equals("Y") && treeAuditDTO.getLevel_tr() == Integer.valueOf("3")){
			sql.append("AND A0.FG_ST = 'Y' AND A0.ID_STIP = ? ");
			param.addParam(id_stip);
			
		}
		
		sql.append(" AND A0.DS = 0) ");
		sql.append("GROUP BY ITMNAME,NAME_SRV,ratio_pripat,PRICE,PRICE_RATIO,SPEC,A0.ID_ENT,A0.ID_SRV, ");
		sql.append("A0.ID_DEP_OR,A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.ID_EMP_OR, B0.NAME,C0.NAME ORDER  BY ITMNAME ");

		sql.append(" ) x where quan > 0 ");

		@SuppressWarnings("unchecked")
		List<BlIpAuditFeeDTO> auditList = (List<BlIpAuditFeeDTO>) new DAFacade()
				.execQuery(sql.toString(), param, new BeanListHandler(
						BlIpAuditFeeDTO.class));
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
	 * 根据就诊id和id_srv fg_st 分页获取费用明细 
	 * BlIpAuditFeeDTO 费用信息模型
	 * @param id_ent 就诊id id_srv 服务id
	 * @param fg_st 是否结算 id_stip 结算id
	 * @param PaginationInfo 分页信息
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author liwq
	 * */
	@SuppressWarnings("unchecked")
	public PagingRtnData<BlIpAuditFeeDTO> getBlIpAuditFeeItemInfo(
			BlIpAuditFeeDTO auditFeeDto, String fg_st,String id_stip,PaginationInfo pageInfo) throws BizException {
		if (auditFeeDto == null || auditFeeDto.getId_ent() == null
				|| auditFeeDto.getId_srv() == null || fg_st == null)
			return null;
		
		PagingRtnData<BlIpAuditFeeDTO> pageFeeDTO = new PagingRtnData<BlIpAuditFeeDTO>();
		PagingServiceImpl<BlIpAuditFeeDTO> service =new PagingServiceImpl<>();
		
		List<BlIpAuditFeeDTO> datas = null;
		// 1、查询费用明细信息
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT A0.NAME_SRV, A0.SPEC, to_char(A0.PRICE, '99999990.0000') as price, to_char(A0.PRICE_RATIO, '99999990.0000') as price_ratio,to_char(A0.QUAN*EU_DIRECT, '99999990.0000') as QUAN,C0.NAME as unit_name, A0.DT_OR DT_OR, A0.ID_EMP_OR, ");
		sql.append("A0.ID_DEP_OR, A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.DT_SRV, A0.ID_SRV,A0.ID_ENT, ");
		sql.append(" B0.NAME AS EMP_NAME_OR,A0.NOTE ");
		sql.append("FROM BL_CG_IP A0 ");
		sql.append("LEFT JOIN BD_PSNDOC B0 ON A0.ID_EMP_OR = B0.ID_PSNDOC ");
		sql.append("LEFT JOIN BD_MEASDOC C0 ON A0.SRVU = C0.ID_MEASDOC ");
		sql.append("WHERE A0.ID_ENT = ? AND A0.ID_SRV = ? ");
	
		
		if(auditFeeDto.getId_dep_or() != null){
			sql.append(" AND A0.ID_DEP_OR = '").append(auditFeeDto.getId_dep_or()).append("' ");
		}
		if(auditFeeDto.getId_dep_mp() != null){
			sql.append(" AND A0.ID_DEP_MP = '").append(auditFeeDto.getId_dep_mp()).append("' ");
		}
		if(auditFeeDto.getId_dep_nur() != null){
			sql.append(" AND A0.ID_DEP_NUR = '").append(auditFeeDto.getId_dep_nur()).append("' ");
		}
		if(auditFeeDto.getRatio_pripat() != null){
			sql.append(" AND A0.RATIO_PRIPAT = '").append(auditFeeDto.getRatio_pripat()).append("' ");
		}
		SqlParam param = new SqlParam();
		param.addParam(auditFeeDto.getId_ent());
		param.addParam(auditFeeDto.getId_srv());

		//已结算费用明细条件 针对某次结算的费用明细
		if (fg_st.equals("Y")) {
			sql.append("AND A0.FG_ST = 'Y' AND A0.ID_STIP = ? ");
			param.addParam(id_stip);
		}
		//未结算费用明细条件 针对所有没有结算的费用明细
		if (fg_st.equals("N")) {
			sql.append("AND A0.FG_ST = 'N' ");
		}
		sql.append("AND A0.DS = 0 ORDER BY A0.DT_SRV DESC ");
		
		pageFeeDTO = service.findByPageInfo(new BlIpAuditFeeDTO(), pageInfo, sql.toString(), "", param);
		
		List<BlIpAuditFeeDTO> feeItemlist = new ArrayList<BlIpAuditFeeDTO>();
		
//		feeItemlist = (List<BlIpAuditFeeDTO>) new DAFacade().execQuery(sql
//				.toString(), param, new BeanListHandler(BlIpAuditFeeDTO.class));
		feeItemlist = pageFeeDTO.getPageData();

		if (feeItemlist == null || feeItemlist.size() <= 0) {
			return null;
		}
		// 2、将查询出来的科室Id结果集放入map
		Map<String, MpOtDeptDTO> deptDtoMap = new HashMap<String, MpOtDeptDTO>();
		DAFacade dAFacade = new DAFacade();

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

	/**
	 * 根据结算id_stip获取已结算费用收付款信息
	 * @param id_stip	 结算id
	 * @return BlIpAuditStPayInfoDTO[] 费用审核-已结算收款信息
	 * @throws BizException
	 * @author liwq
	 * @throws DAException
	 * */
	@SuppressWarnings("unchecked")
	public BlIpAuditStPayInfoDTO[] getBlIpAuditStPayInfo(String id_stip)
			throws DAException {
		if (id_stip == null) {
			return null;
		}
		// 1、查询收款信息
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT C.ID_STIP, to_char(A.EU_DIRECT*A.AMT, '99999990.00') AS AMT, C.DT_PAY, B.NAME AS SD_PM_NAME, A.SD_PM, ");
		sql.append("C.ID_EMP_PAY, D.NAME AS EMP_NAME_PAY, ");
		sql.append("CASE WHEN (A.SD_PM <>'05')  THEN '结算' ");
		sql.append("WHEN (A.SD_PM ='05' AND A.EU_DIRECT <0) THEN '退预交金' ");
		sql.append("WHEN (A.SD_PM ='05' AND A.EU_DIRECT >0) THEN '收预交金' END  AS PAY_STATUS, ");
		sql.append("E.CODE_REP AS PREPAYCODENO FROM BL_PAY_ITM_PAT_IP A ");
		sql.append("LEFT JOIN BD_PRI_PM B ON A.ID_PM = B.ID_PM ");
		sql.append("LEFT JOIN BL_PAY_PAT_IP C ON A.ID_PAYPATIP = C.ID_PAYPATIP ");
		sql.append("INNER JOIN BD_PSNDOC D ON C.ID_EMP_PAY = D.ID_PSNDOC ");
		sql.append("LEFT JOIN BL_PREPAY_PAT E ON  A.ID_PAYPAT =E.ID_PAYPAT ");
		sql.append("WHERE C.ID_STIP = ? ORDER BY E.DT_PAY ");

		SqlParam param = new SqlParam();
		param.addParam(id_stip);

		List<BlIpAuditStPayInfoDTO> listDatas = new ArrayList<BlIpAuditStPayInfoDTO>();
		listDatas = (List<BlIpAuditStPayInfoDTO>) new DAFacade().execQuery(sql
				.toString(), param, new BeanListHandler(
				BlIpAuditStPayInfoDTO.class));

		if (listDatas == null || listDatas.size() <= 0) {
			return null;
		}

		BlIpAuditStPayInfoDTO[] datasArr = listDatas
				.toArray(new BlIpAuditStPayInfoDTO[] {});

		return datasArr;
	}
	/**
	 * 根据就诊id_ent id_stip fg_st获取急诊留观费用信息
	 * 
	 * @param BlIpChargeAuditDTO
	 *            树形节点模型
	 * @param id_ent
	 *            就诊id
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author liwq 2018/08/05 重构部分逻辑 ly 2018/08/05
	 * @throws DAException
	 */
	public BlIpAuditFeeDTO[] getBlETAuditFeeInfo(BlIpChargeAuditDTO treeAuditDTO) throws BizException {
		if (treeAuditDTO == null)
			return null;
		if (treeAuditDTO.getId_ent() == null || treeAuditDTO.getId_ent().isEmpty() || treeAuditDTO.getFg_st() == null
				|| treeAuditDTO.getFg_st().isEmpty())
			return null;

		// 1、查询数据
		List<BlIpAuditFeeDTO> auditList = getETAuditFee(treeAuditDTO);
		if (auditList == null || auditList.size() == 0) {
			return null;
		}

		// 2 填充 科室名称 、 医保适应症、医院适应症
		BlIpAuditFeeDTO[] datasArr = replenishDTO(auditList, treeAuditDTO);
		return datasArr;
	}
	
	@SuppressWarnings("unchecked")
	private List<BlIpAuditFeeDTO> getETAuditFee(BlIpChargeAuditDTO treeAuditDTO) throws DAException {
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		if (BlParams.BLST0002() == 1) {
			sql.append("select * from (");
			sql.append("  SELECT ");
			sql.append("  A0.ID_SRV,");
			sql.append("  A0.id_mm,");
			sql.append("  A0.NAME_SRV, ");// 服务名称
			sql.append("  A0.name_inccaitm ITMNAME, ");// 费用类别
			sql.append("  to_char(A0.PRICE, '99999990.0000') price, ");// 单价
			sql.append("  to_char(A0.PRICE_RATIO, '99999990.0000') price_ratio, ");// 单价
			sql.append("  to_char(SUM(QUAN * CG.EU_DIRECT), '99999990.00') QUAN, ");// 数量
			sql.append("  C0.NAME unit_name, ");// 单位
			sql.append("  to_char(SUM(A0.AMT_RATIO * CG.EU_DIRECT), '99999990.00') AMT_RATIO, ");// 金额
			sql.append("  ");// 医保适应症
			sql.append("  ");// 医院适应症
			sql.append("  A0.fg_selfpay,");
			sql.append("  case");
			sql.append("    when A0.fg_selfpay = 'Y' then");
			sql.append("     'N'");
			sql.append("    when A0.fg_selfpay = 'N' then");
			sql.append("     'Y'");
			sql.append("  end fg_hpin, ");// 保内保外标志
			sql.append("  A0.ID_DEP_OR, ");// 开立科室
			sql.append("  A0.ID_DEP_NUR, ");// 病区
			sql.append("  A0.ID_DEP_MP, ");// 执行科室
			sql.append("  ");
			sql.append("  A0.SPEC, ");// 规格
			sql.append("  measdoc_cur.id_measdoc idunit, ");// 替换大小规格需要用
			sql.append("  ");
			sql.append("  A0.code_inccaitm, ");// 费用类别编码
			sql.append("  A0.ID_ENT, ");// 就诊Id
			sql.append("  A0.ID_EMP_OR, ");// 开立医生
			sql.append("  B0.NAME          EMP_NAME_OR, ");// 记账人员
			sql.append("  a0.ratio_pripat, ");// 价格比例
			sql.append("  D0.FG_INDIC ");// 医保适应症标志
			sql.append("   FROM BL_CG_ITM_OEP A0 ");// 记账明细表
			sql.append("  Inner join bl_cg_oep cg");
			sql.append("     on A0.Id_Cgoep = cg.id_cgoep");
			sql.append("  INNER JOIN BD_PSNDOC B0 ");// 人员表
			sql.append("     ON A0.ID_EMP_OR = B0.ID_PSNDOC");

			sql.append("   LEFT outer JOIN BD_MEASDOC C0 ");// 查询单位用表
			sql.append("     ON A0.SRVU = C0.ID_MEASDOC");
			sql.append("   LEFT outer JOIN BD_MEASDOC measdoc_cur ");// 查询规格用表
			sql.append("     ON measdoc_cur.id_measdoc = A0.pgku_cur");

			sql.append("   LEFT outer JOIN CI_OR_SRV D0 ");// 医嘱服务表
			sql.append("     ON D0.ID_ORSRV = A0.ID_ORSRV");

			sql.append("  WHERE 1 = 1");
			sql.append("    and A0.ID_ENT = ?"); //
			param.addParam(treeAuditDTO.getId_ent());

			// 点击未结费用 即查询未结算的费用信息
			if (treeAuditDTO.getFg_st().equals("N") && (treeAuditDTO.getLevel_tr() == Integer.valueOf("2"))) {
				sql.append("AND A0.FG_ST = 'N' ");
			}
			// 点击已结费用的子节点时，查询条件 即 查询某一次已经结算的费用信息
			if (treeAuditDTO.getFg_st().equals("Y") && treeAuditDTO.getLevel_tr() == Integer.valueOf("3")) {
				sql.append("AND A0.FG_ST = 'Y' AND A0.Id_Stoep = ? ");
				param.addParam(treeAuditDTO.getId_stip());
			}

			sql.append("    AND A0.DS = 0");

			sql.append("  GROUP BY name_inccaitm,");
			sql.append("           code_inccaitm,");
			sql.append("           NAME_SRV,");
			sql.append("           ratio_pripat,");
			sql.append("           PRICE,");
			sql.append("           PRICE_RATIO,");
			sql.append("           SPEC,");
			sql.append("           A0.ID_ENT,");
			sql.append("           A0.ID_SRV,");
			sql.append("           A0.id_mm,");
			sql.append("           measdoc_cur.id_measdoc,");
			sql.append("           A0.ID_DEP_OR,");
			sql.append("           A0.ID_DEP_NUR,"); 
			sql.append("           A0.ID_DEP_MP,");
			sql.append("           A0.ID_EMP_OR,");
			sql.append("           B0.NAME,");
			sql.append("           C0.NAME,");
			sql.append("           D0.FG_INDIC,");
			sql.append("           A0.fg_selfpay");
			sql.append("  ORDER BY name_inccaitm");
			sql.append(" ) x where quan > 0 ");

		} else if (BlParams.BLST0002() == 2) {
			sql.append("select * from (");
			sql.append("SELECT to_char(SUM(A0.AMT_RATIO * A0.EU_DIRECT),'99999990.00') AS AMT_RATIO,");
			sql.append("A0.NAME_SRV,");
			sql.append("to_char(SUM(QUAN*EU_DIRECT) ,'99999990.00')  AS QUAN,");
			sql.append("C0.NAME as unit_name,");
			sql.append("A0.SPEC,A0.name_inccaitm ITMNAME,");
			sql.append("A0.code_inccaitm,");
			sql.append("to_char(A0.PRICE,'99999990.0000') as price,");
			sql.append("to_char(A0.PRICE_RATIO,'99999990.0000') as price_ratio,");
			sql.append("A0.ID_DEP_OR,");
			sql.append("A0.ID_DEP_NUR,");
			sql.append("A0.ID_DEP_MP,");
			sql.append("A0.ID_SRV,");
			sql.append("A0.id_mm,");
			sql.append(" measdoc_cur.id_measdoc idunit, ");
			sql.append("A0.ID_ENT,");
			sql.append("A0.ID_EMP_OR,");
			sql.append("B0.NAME AS EMP_NAME_OR ,");
			sql.append("a0.ratio_pripat,");
			sql.append("A0.FG_BB,");
			sql.append("D0.FG_INDIC,");
			sql.append("A0.fg_selfpay, ");
			sql.append("case when A0.fg_selfpay = 'Y' then 'N' when  A0.fg_selfpay = 'N' then 'Y' end fg_hpin ");
			sql.append("FROM BL_CG_IP A0 ");
			sql.append("LEFT JOIN BD_PSNDOC B0 ON A0.ID_EMP_OR = B0.ID_PSNDOC ");
			sql.append("LEFT JOIN BD_MEASDOC C0 ON A0.SRVU = C0.ID_MEASDOC ");
			sql.append("LEFT JOIN CI_OR_SRV D0 ON D0.ID_ORSRV = A0.ID_ORSRV ");
			sql.append("LEFT outer JOIN BD_MEASDOC measdoc_cur ");
			sql.append("ON measdoc_cur.id_measdoc = A0.pgku_cur ");
			sql.append("WHERE ((A0.ID_ENT = ?  ");
			sql.append(")");

			param.addParam(treeAuditDTO.getId_ent());

			// 点击未结费用 即查询未结算的费用信息
			if (treeAuditDTO.getFg_st().equals("N") && (treeAuditDTO.getLevel_tr() == Integer.valueOf("2"))) {
				sql.append("AND A0.FG_ST = 'N' ");
			}
			// 点击已结费用的子节点时，查询条件 即 查询某一次已经结算的费用信息
			if (treeAuditDTO.getFg_st().equals("Y") && treeAuditDTO.getLevel_tr() == Integer.valueOf("3")) {
				sql.append("AND A0.FG_ST = 'Y' AND A0.ID_STIP = ? ");
				param.addParam(treeAuditDTO.getId_stip());
			}

			sql.append(" AND A0.DS = 0) ");
			sql.append(
					"GROUP BY name_inccaitm,code_inccaitm,NAME_SRV,ratio_pripat,PRICE,PRICE_RATIO,SPEC,A0.ID_ENT,A0.ID_SRV,A0.id_mm,measdoc_cur.id_measdoc,  ");
			sql.append(
					"A0.ID_DEP_OR,A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.ID_EMP_OR, B0.NAME,C0.NAME,A0.FG_BB,D0.FG_INDIC,A0.fg_selfpay ORDER  BY name_inccaitm ");
			sql.append(" ) x where quan > 0 ");
		}

		List<BlIpAuditFeeDTO> auditList = (List<BlIpAuditFeeDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlIpAuditFeeDTO.class));
		if (auditList == null || auditList.size() == 0) {
			return null;
		}

		return auditList;
	}

	
	/**
	 * 填充 科室名称 、 医保适应症、医院适应症 、改动大小规格等
	 * 
	 * @param bList
	 * @param treeAuditDTO
	 * @return
	 * @throws BizException
	 */
	private BlIpAuditFeeDTO[] replenishDTO(List<BlIpAuditFeeDTO> bList, BlIpChargeAuditDTO treeAuditDTO)
			throws BizException {
		// 根据科室病区id 获取名称
		addDepInfo(bList);

		// 添加医保对照查询及控制策略查询
		//addHpRelatedField(bList);

		BlIpAuditFeeDTO[] datasArr = bList.toArray(new BlIpAuditFeeDTO[] {});
		return datasArr;
	}

	/**
	 * 根据id_dep查询出科室名称 BlIpAuditFeeDTO 费用信息模型
	 * 
	 * @return List<BlIpAuditFeeDTO> 补充完科室名称的费用明细
	 * @throws BizException
	 * @author 未知 整理by xuebei ps 这部分其实可以从sql中筛选,不知为何当时这样处理
	 */
	@SuppressWarnings("unchecked")
	private void addDepInfo(List<BlIpAuditFeeDTO> feeItemlist) throws DAException {
		// 1、将查询出来的科室Id结果集放入map
		Map<String, DeptDO> deptDtoMap = new HashMap<String, DeptDO>();
		DAFacade dAFacade = new DAFacade();

		List<DeptDO> deptDtoList = (List<DeptDO>) dAFacade.execQuery("SELECT ID_ORG AS ID_DEP,NAME FROM BD_ORG ",
				new BeanListHandler(DeptDO.class));

		if (deptDtoList != null && deptDtoList.size() > 0) {
			for (DeptDO deptDto : deptDtoList) {
				if (deptDtoMap.get(deptDto.getId_dep()) == null) {
					// 向Map中添加键值 <对象主键,对象>
					deptDtoMap.put(deptDto.getId_dep(), deptDto);
				}
			}
		}

		// 2、根据科室病区id 获取名称
		List<BlIpAuditFeeDTO> datas = new ArrayList<BlIpAuditFeeDTO>();
		for (BlIpAuditFeeDTO feeInfoDto : feeItemlist) {
			// 开立科室名称
			String idDepOr = feeInfoDto.getId_dep_or();
			DeptDO depDtoOr = deptDtoMap.get(idDepOr);
			if (depDtoOr != null) {
				feeInfoDto.setName_dep_or(depDtoOr.getName());
			} else {
				feeInfoDto.setName_dep_or(null);
			}

			// 病区名称
			String idDepNur = feeInfoDto.getId_dep_nur();
			DeptDO depDtoNur = deptDtoMap.get(idDepNur);
			if (depDtoNur != null) {
				feeInfoDto.setName_dep_nur(depDtoNur.getName());
			} else {
				feeInfoDto.setName_dep_nur(null);
			}

			// 执行科室名称
			String idDepMp = feeInfoDto.getId_dep_mp();
			DeptDO depDtoMp = deptDtoMap.get(idDepMp);
			if (depDtoMp != null) {
				feeInfoDto.setName_dep_mp(depDtoMp.getName());
			} else {
				feeInfoDto.setName_dep_mp(null);
			}
			datas.add(feeInfoDto);
		}
	}
	
	/**
	 * 根据结算id_st获取已结算急诊留观费用收付款信息
	 * 
	 * @param id_st
	 *            结算id
	 * @return BlIpAuditStPayInfoDTO[] 费用审核-已结算收款信息
	 * @throws BizException
	 * @author xuebei
	 * @throws DAException
	 */
	public BlIpAuditStPayInfoDTO[] getBlETAuditStPayInfo (String id_st) throws DAException
	{
		if(BlParams.BLST0002() == 1)
		{
			return getBlOepAuditStPayInfo(id_st);
		}
		else if(BlParams.BLST0002() == 2)
		{
			return getBlIpAuditStPayInfo(id_st);
		}
		return null;
	}

	
	/**
	 * 根据结算id_stoep获取已结算门诊费用收付款信息
	 * 
	 * @param id_stoep
	 *            结算id
	 * @return BlIpAuditStPayInfoDTO[] 费用审核-已结算收款信息
	 * @throws BizException
	 * @author xuebei
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	public BlIpAuditStPayInfoDTO[] getBlOepAuditStPayInfo(String id_stoep) throws DAException{

		if (id_stoep == null) {
			return null;
		}
		// 1、查询收款信息
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT E.ID_STOEP ID_STIP, ");
		sql.append("        TO_CHAR(A.EU_DIRECT * A.AMT, '99999990.00') AMT, ");
		sql.append("        C.DT_PAY, ");
		sql.append("        B.NAME SD_PM_NAME, ");
		sql.append("        A.SD_PM, ");
		sql.append("        C.ID_EMP_PAY, ");
		sql.append("        D.NAME EMP_NAME_PAY, ");
		sql.append("        CASE ");
		sql.append("          WHEN (A.SD_PM <> '05') THEN ");
		sql.append("           '结算' ");
		sql.append("          WHEN (A.SD_PM = '05' AND A.EU_DIRECT < 0) THEN ");
		sql.append("           '退预交金' ");
		sql.append("          WHEN (A.SD_PM = '05' AND A.EU_DIRECT > 0) THEN ");
		sql.append("           '收预交金' ");
		sql.append("        END PAY_STATUS, ");
		sql.append("        E.CODE_REP PREPAYCODENO ");
		sql.append("   FROM BL_PAY_ITM_PAT_OEP A ");
		sql.append("   LEFT OUTER JOIN BD_PRI_PM B ");
		sql.append("     ON A.ID_PM = B.ID_PM ");
		sql.append("   LEFT OUTER JOIN BL_PAY_PAT_OEP C ");
		sql.append("     ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sql.append("     INNER JOIN BL_ST_OEP E  ");
		sql.append("     ON A.ID_PAYPATOEP = E.ID_PAYPATOEP  ");
		sql.append("  INNER JOIN BD_PSNDOC D ");
		sql.append("     ON C.ID_EMP_PAY = D.ID_PSNDOC ");
		sql.append("   LEFT OUTER JOIN BL_PREPAY_PAT E ");
		sql.append("     ON A.ID_PAYPAT = E.ID_PAYPAT ");
		sql.append("  WHERE E.ID_STOEP = ? ");
		sql.append("  ORDER BY E.DT_PAY ");

		SqlParam param = new SqlParam();
		param.addParam(id_stoep);

		List<BlIpAuditStPayInfoDTO> listDatas = new ArrayList<BlIpAuditStPayInfoDTO>();
		listDatas = (List<BlIpAuditStPayInfoDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlIpAuditStPayInfoDTO.class));

		if (listDatas == null || listDatas.size() <= 0) {
			return null;
		}

		BlIpAuditStPayInfoDTO[] datasArr = listDatas.toArray(new BlIpAuditStPayInfoDTO[] {});

		return datasArr;
	}

	/**
	 * 根据id_ent 获取急诊留观费用审核树形节点值
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public BlIpChargeAuditDTO[] findFeeStateByIdentET(String id_ent) throws BizException {

		if (id_ent == "" || id_ent == null) {
			return null;
		}

		StringBuilder sql = new StringBuilder();
		if (BlParams.BLST0002() == 1) {
			sql.append(
					"SELECT A.ID_STOEP ID_STIP, A.ID_ENT, A.Dt_St DT_START, a.Dt_St DT_END,  case  when A.Id_Paypatoep is null then 'N' when A.Id_Paypatoep is not null then 'Y' else 'N' end  FG_PAY, A.FG_CANC ");
			sql.append("FROM BL_ST_OEP A ");
			sql.append("WHERE A.EU_DIRECT = 1 ");
			sql.append(" AND A.Id_Paypatoep is not null ");
			sql.append(" AND A.ID_ENT = '" + id_ent + "' ORDER BY A.DT_ST ");
		}
		else if (BlParams.BLST0002() == 2) {
			sql.append("SELECT A.ID_STIP,A.ID_ENT,A.DT_START,A.DT_END,A.FG_PAY,A.FG_CANC ");
			sql.append("FROM BL_ST_IP A WHERE A.EU_DIRECT = 1  AND A.ID_ENT = '" + id_ent + "' ORDER BY A.DT_ST ");
		}  
			

		FArrayList flist = AppFwUtil.getMapListWithDao(sql.toString());

		BlIpChargeAuditDTO[] dtoArr = mygetArr(flist);

		return dtoArr;
	}
	
	/**
	 * 组装账页信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlIpChargeAuditDTO[] mygetArr(FArrayList flist) {
		if (null == flist || flist.size() == 0) {
			return null;
		}
		List<BlIpChargeAuditDTO> datas = new ArrayList<BlIpChargeAuditDTO>();
		for (int i = 0; i < flist.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) flist.get(i);
			BlIpChargeAuditDTO dto = new BlIpChargeAuditDTO();
			String key = "id_stip";
			dto.setId_stip(map.get(key) == null ? null : map.get(key).toString());
			key = "id_ent";
			dto.setId_ent(map.get(key) == null ? null : map.get(key).toString());

			key = "fg_pay";
			dto.setFg_pay(map.get(key) == null ? null : map.get(key).toString());
			key = "fg_st";
			dto.setFg_st(map.get(key) == null ? null : map.get(key).toString());
			dto.setId_tr(String.valueOf(i + 1));

			key = "fg_canc";
			String fg_canc = map.get(key) == null ? null : map.get(key).toString();

			StringBuilder Name_tr = new StringBuilder();
			String strState = (dto.getFg_pay().equals("N") && fg_canc.equals("N")) ? "结算"
					: ((dto.getFg_pay().equals("Y") && fg_canc.equals("Y")) ? "冲账" : "付款");

			String strStartDate = map.get("dt_start").toString().substring(0, 10);
			String strEndtDate = map.get("dt_end").toString().substring(0, 10);
			Name_tr.append("账页：" + String.valueOf(i + 1) + "(" + strState + ") ");
			Name_tr.append(strStartDate + "至" + strEndtDate);
			dto.setName_tr(Name_tr.toString());
			dto.setFg_st("Y");
			dto.setLevel_tr(3);

			datas.add(dto);
		}
		BlIpChargeAuditDTO[] dtoArr = datas.toArray(new BlIpChargeAuditDTO[] {});
		return dtoArr;
	}

	
	/**
	 * 
	 * @Description: 查询费用明细 
	 */
	@SuppressWarnings("unchecked")
	public PagingRtnData<BlIpAuditFeeDTO> findBlIpAuditFeeDTO(PaginationInfo pgInfo, BlIpAuditFeeDTO whereDto,FDateTime dtB,FDateTime dtE) throws BizException {
		if(whereDto == null || StringUtil.isEmpty(whereDto.getId_ent())){
			throw new BizException("就诊患者不能为空");
		}
		String id_ent = whereDto.getId_ent();
		PagingServiceImpl<BlIpAuditFeeDTO> pageService = new PagingServiceImpl<BlIpAuditFeeDTO>();
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select cg.dt_cg, ");
		sqlSb.append("       cg.dt_or, ");
		sqlSb.append("       cg.id_ent, ");
		sqlSb.append("       cg.id_cgip, ");
		sqlSb.append("       cg.name_srv,");
		sqlSb.append("       cg.id_srv, ");
		sqlSb.append("       cg.id_mm, ");
		sqlSb.append("       measdoc_cur.id_measdoc idunit,");
		sqlSb.append("       cg.name_mm, ");
		sqlSb.append("       cg.name_inccaitm, ");
		sqlSb.append("       cg.code_inccaitm, ");
		sqlSb.append("       cg.spec, ");
		sqlSb.append("       to_char(cg.price_ratio,'99999990.0000') price, ");
		sqlSb.append("       to_char( (cg.quan-cg.quan_ret),'99999990.0000') as quan, ");
		sqlSb.append("       to_char( cg.amt_ratio-(cg.quan_ret*cg.price_ratio),'99999990.00') as amt_ratio, ");
		sqlSb.append("       decode(cg.fg_selfpay,'Y','N','Y') fg_hpin ,");
		sqlSb.append("       cg.fg_bb, ");
		sqlSb.append("       cg.fg_selfpay, ");
		sqlSb.append("       cg.id_dep_or, ");
		sqlSb.append("       cg.id_dep_mp, ");
		sqlSb.append("       cg.id_dep_nur, ");
		sqlSb.append("       cg.fg_hp, ");
		sqlSb.append("       dep1.name name_dep_or, ");
		sqlSb.append("       dep2.name name_dep_mp, ");
		sqlSb.append("       dep3.name name_dep_nur, ");
		sqlSb.append("       order1.fg_pres_outp, ");
		sqlSb.append("       psn.name as name_emp_cg ");
		sqlSb.append("  from bl_cg_ip cg ");
		sqlSb.append("  left join bd_dep dep1 ");
		sqlSb.append("    on cg.id_dep_or = dep1.id_dep ");
		sqlSb.append("  left join bd_dep dep2 ");
		sqlSb.append("    on cg.id_dep_mp = dep2.id_dep ");
		sqlSb.append("  left join bd_dep dep3 ");
		sqlSb.append("    on cg.id_dep_nur = dep3.id_dep ");
		sqlSb.append("  left join BD_PSNDOC psn ");
		sqlSb.append("    on psn.id_psndoc = cg.id_emp_cg ");
		sqlSb.append("    left outer join ci_order order1 ");
		sqlSb.append("    on order1.id_or = cg.id_or ");
		sqlSb.append("    LEFT outer JOIN BD_MEASDOC measdoc_cur ");
		sqlSb.append("    ON measdoc_cur.id_measdoc = cg.pgku_cur ");
		sqlSb.append(" where 1=1 ");
		
//		sqlSb.append(" and (cg.quan-quan_ret)>=0 ");
		sqlSb.append(" and cg.fg_real = 'Y' ");
		SqlParam param = new SqlParam();
		FBoolean isMerge = BlParams.BLSTIP0005();
		
		if (FBoolean.TRUE.equals(isMerge)) {
			sqlSb.append(" and (cg.id_ent =? or cg.id_ent_mom = ?) ");
			param.addParam(id_ent);
			param.addParam(id_ent);
		} else {
			sqlSb.append(" and cg.id_ent=?");
			param.addParam(id_ent);
		}
		if(!StringUtil.isEmpty(whereDto.getId_dep_or())){
			sqlSb.append(" and cg.id_dep_or = ? ");
			param.addParam(whereDto.getId_dep_or());
		}
		
		if(!StringUtil.isEmpty(whereDto.getId_dep_mp())){
			sqlSb.append(" and cg.id_dep_mp = ? ");
			param.addParam(whereDto.getId_dep_mp());
		}
		
		if(!StringUtil.isEmpty(whereDto.getId_dep_nur())){
			sqlSb.append(" and cg.id_dep_nur = ? ");
			param.addParam(whereDto.getId_dep_nur());
		}
		
		if(!StringUtil.isEmpty(whereDto.getCode_inccaitm())){
			sqlSb.append(" and cg.code_inccaitm = ? ");
			param.addParam(whereDto.getCode_inccaitm());
		}
		FBoolean fgHpIn = whereDto.getFg_hpin();
		if(fgHpIn != null){
			if(FBoolean.TRUE.equals(fgHpIn)){
				sqlSb.append(" and cg.fg_selfpay = 'N' ");
			}else{
				sqlSb.append(" and cg.fg_selfpay = 'Y' ");
			}
		}
		
		FBoolean fgHp = whereDto.getFg_hp();
		if(fgHp != null){
			if(FBoolean.FALSE.equals(fgHp)){
				sqlSb.append(" and cg.fg_hp = 'N' ");
			}else{
				sqlSb.append(" and cg.fg_hp = 'Y' ");
			}
		}
		
		if(dtB != null){
			sqlSb.append("cg.dt_or >= '").append(dtB.toString()).append("'");
		}
		
		if(dtE != null){
			sqlSb.append("cg.dt_or <= '").append(dtE.toString()).append("'");
		}
		
		sqlSb.append(" and   not  exists  ");
		sqlSb.append("  ( select hpexc.id_srv from bd_hp_srv_upload_exclude  hpexc ,en_ent ent   ");
		sqlSb.append("   where");
		sqlSb.append("  cg.id_enttp = hpexc.id_entp ");
		sqlSb.append("  and cg.id_ent=ent.id_ent and ent.id_hp = hpexc.id_hp and (hpexc.id_hp is not null and hpexc.id_hp != '~') ");
		sqlSb.append("  and hpexc.fg_active='Y'  ");
		sqlSb.append("  and hpexc.sd_owtp='1'  ");
		sqlSb.append("  and cg.id_dep_or = hpexc.id_dep ");
		sqlSb.append("  and cg.id_srv = hpexc.id_srv  ");
		sqlSb.append("  ) ");
		sqlSb.append(" and   not  exists   ");
		sqlSb.append(" ( select id_srv from bd_hp_srv_upload_exclude  hpexc,en_ent ent  ");
		sqlSb.append("   where");
		sqlSb.append("   hpexc.id_entp = cg.id_enttp ");
		sqlSb.append("   and hpexc.fg_active='Y' ");
		sqlSb.append("   and hpexc.sd_owtp ='0' ");
		sqlSb.append("   and cg.id_ent=ent.id_ent and ent.id_hp = hpexc.id_hp   and (hpexc.id_hp is not null and hpexc.id_hp != '~') ");
		sqlSb.append("   and cg.id_srv = hpexc.id_srv ");
		sqlSb.append("  ) ");
		sqlSb.append("  order by cg.eu_direct desc ");
		PagingRtnData<BlIpAuditFeeDTO> pageAudit = pageService.findByPageInfo(new BlIpAuditFeeDTO(), pgInfo, sqlSb.toString(), "", param);
		if(pageAudit != null && pageAudit.getPageData() != null && pageAudit.getPageData().size() > 0){
			FArrayList data = pageAudit.getPageData();
			List<BlIpAuditFeeDTO> auditList = new ArrayList<>(data.size());
			for(Object obj : data){
				if(obj != null && obj instanceof BlIpAuditFeeDTO)
					auditList.add((BlIpAuditFeeDTO)obj);
			}
			addHpRelatedField(auditList);
			data = new FArrayList();
			data.addAll(auditList);
			pageAudit.setPageData(data);
		}
//		result = Tools.updateBigAndSmallSpec(result);
		return pageAudit;
	}
	
	/**
	 * 添加医保相关字段: 医保适应症 医院适应症 医保等级
	 * @param bList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void addHpRelatedField(List<BlIpAuditFeeDTO> bList) throws BizException {

		if (ListUtil.isEmpty(bList))
			return;
		StringBuffer sql = new StringBuffer();
		sql.append("select cgip.id_cgip, hpsrvca.des ,hpsrvca.his_des,hpsrvca.sd_hpsrvtp,hpsrvca.code Hp_srvcode,hpsrvca.name Hp_srvname,hpsrvca.def1,hpsrvca.def2,hpsrvca.def3 ");
		sql.append("from bl_cg_ip cgip  ");
		sql.append(" join bd_hp_srvorca hpsrvca on ");
		sql.append(" decode(nvl(cgip.id_mm,'~'),'~',cgip.id_srv,cgip.id_mm) = decode(nvl(cgip.id_mm,'~'),'~',hpsrvca.id_srv,hpsrvca.id_mm) ");
		sql.append("where cgip.id_cgip in (");
		String douHao = "";
		String danYinHao = "'";
		for (BlIpAuditFeeDTO bFeeDTO : bList) {
			sql.append(douHao).append(danYinHao).append(bFeeDTO.getId_cgip()).append(danYinHao);
			douHao=",";
		}
		sql.append(") ");
		
		DAFacade daf = new DAFacade();
		List<BlIpAuditFeeDTO> comp =(List<BlIpAuditFeeDTO>) daf.execQuery(sql.toString(), new BeanListHandler(BlIpAuditFeeDTO.class));
		HashMap<String, BlIpAuditFeeDTO> compMap = new HashMap<>();
		if (!ListUtil.isEmpty(comp)){
			for(BlIpAuditFeeDTO itm:comp){
				compMap.put(itm.getId_cgip(), itm);
			}
		}
		BlIpAuditFeeDTO compItm = null;
		for(BlIpAuditFeeDTO itm:bList){
			compItm = compMap.get(itm.getId_cgip());
			if(compItm != null){
				itm.setDes(compItm.getDes());
				itm.setHis_des(compItm.getHis_des());
				itm.setSd_hpsrvtp(itm.getSd_hpsrvtp());
				itm.setHp_srvcode(compItm.getHp_srvcode());
				itm.setHp_srvname(compItm.getHp_srvname());
				itm.setDef1(compItm.getDef1());
				itm.setDef2(compItm.getDef2());
				itm.setDef3(compItm.getDef3());
			}
		}
	}
	
	/**
	 * 根据就诊id和id_srv fg_st 分页获取急诊留观费用明细 BlIpAuditFeeDTO 费用信息模型
	 * 
	 * @param id_ent
	 *            就诊id id_srv 服务id
	 * @param fg_st
	 *            是否结算 id_stip 结算id
	 * @param PaginationInfo
	 *            分页信息
	 * @return BlIpAuditFeeDTO[] 费用审核-费用信息
	 * @throws BizException
	 * @author xuebei
	 */
	@SuppressWarnings("unchecked")
	public PagingRtnData<BlIpAuditFeeDTO> getBlETAuditFeeItemInfo(BlIpAuditFeeDTO auditFeeDto, String fg_st,
			String id_stip, PaginationInfo pageInfo) throws BizException {
		if (auditFeeDto == null || auditFeeDto.getId_ent() == null || auditFeeDto.getId_srv() == null || fg_st == null)
			return null;

		PagingRtnData<BlIpAuditFeeDTO> pageFeeDTO = new PagingRtnData<BlIpAuditFeeDTO>();
		PagingServiceImpl<BlIpAuditFeeDTO> service = new PagingServiceImpl<BlIpAuditFeeDTO>();

		// 1、查询费用明细信息
		StringBuilder sql = new StringBuilder();

		if (BlParams.BLST0002() == 1) {
			sql.append(" SELECT A0.NAME_SRV, ");
			sql.append("        A0.SPEC, ");
			sql.append("        to_char(A0.PRICE, '99999990.0000') price, ");
			sql.append("        to_char(A0.PRICE_RATIO, '99999990.0000') price_ratio, ");
			sql.append("        A0.id_mm, ");
			sql.append("        measdoc_cur.id_measdoc idunit, ");
			sql.append("        to_char(A0.QUAN * CG.EU_DIRECT, '99999990.0000') QUAN, ");
			sql.append("        C0.NAME unit_name, ");
			sql.append("        A0.DT_OR DT_OR, ");
			sql.append("        A0.ID_EMP_OR, ");
			sql.append("        A0.ID_DEP_OR, ");
			sql.append("        A0.ID_DEP_NUR, ");
			sql.append("        A0.ID_DEP_MP, ");
			sql.append("        A0.DT_SRV, ");
			sql.append("        A0.ID_SRV, ");
			sql.append("        A0.ID_ENT, ");
			sql.append("        CG.DT_CG, ");
			sql.append("        B0.NAME      EMP_NAME_OR, ");
			sql.append("        A0.NOTE, ");
			sql.append("        D0.NAME      NAME_EMP_CG ");
			sql.append("   FROM BL_CG_ITM_OEP A0 ");
			sql.append("  INNER JOIN BL_CG_OEP CG ");
			sql.append("     ON A0.Id_Cgoep = CG.Id_Cgoep ");
			sql.append("   LEFT outer JOIN BD_PSNDOC B0 ");
			sql.append("     ON A0.ID_EMP_OR = B0.ID_PSNDOC ");
			sql.append("   LEFT outer JOIN BD_PSNDOC D0 ");
			sql.append("     ON CG.ID_EMP_CG = D0.ID_PSNDOC ");
			sql.append("   LEFT outer JOIN BD_MEASDOC C0 ");
			sql.append("     ON A0.SRVU = C0.ID_MEASDOC ");
			sql.append("   LEFT outer JOIN BD_MEASDOC measdoc_cur ");
			sql.append("     ON measdoc_cur.id_measdoc = A0.pgku_cur ");
			sql.append("  WHERE A0.ID_ENT = '"+auditFeeDto.getId_ent()+"' ");
			sql.append("    AND A0.ID_SRV = '"+auditFeeDto.getId_srv()+"' ");

			// 已结算费用明细条件 针对某次结算的费用明细
			if (fg_st.equals("Y")) {
				sql.append("AND A0.FG_ST = 'Y' AND A0.ID_STOEP = '"+id_stip+"' ");
			}
			// 未结算费用明细条件 针对所有没有结算的费用明细
			else if (fg_st.equals("N")) {
				sql.append("AND A0.FG_ST = 'N' ");
			}
		} else if (BlParams.BLST0002() == 2) {
			sql.append(
					"SELECT A0.NAME_SRV, A0.SPEC, to_char(A0.PRICE, '99999990.0000') as price, to_char(A0.PRICE_RATIO, '99999990.0000') as price_ratio,A0.id_mm, measdoc_cur.id_measdoc idunit,");
			sql.append(
					" to_char(A0.QUAN*EU_DIRECT, '99999990.0000') as QUAN,C0.NAME as unit_name, A0.DT_OR DT_OR, A0.ID_EMP_OR, ");
			sql.append(" A0.ID_DEP_OR, A0.ID_DEP_NUR, A0.ID_DEP_MP, A0.DT_SRV, A0.ID_SRV,A0.ID_ENT,A0.DT_CG, ");
			sql.append(" B0.NAME AS EMP_NAME_OR,A0.NOTE,D0.NAME AS NAME_EMP_CG ");
			sql.append("FROM BL_CG_IP A0 ");
			sql.append("LEFT JOIN BD_PSNDOC B0 ON A0.ID_EMP_OR = B0.ID_PSNDOC ");
			sql.append("LEFT JOIN BD_PSNDOC D0 ON A0.ID_EMP_CG = D0.ID_PSNDOC ");
			sql.append("LEFT JOIN BD_MEASDOC C0 ON A0.SRVU = C0.ID_MEASDOC ");
			sql.append(" LEFT outer JOIN BD_MEASDOC measdoc_cur  ");
			sql.append(" ON measdoc_cur.id_measdoc = A0.pgku_cur ");
			sql.append("WHERE A0.ID_ENT = '"+auditFeeDto.getId_ent()+"' AND A0.ID_SRV = '"+auditFeeDto.getId_srv()+"' ");
			//sql.append("  and nvl(A0.fg_research,'N')='N' ");

			// 已结算费用明细条件 针对某次结算的费用明细
			if (fg_st.equals("Y")) {
				sql.append("AND A0.FG_ST = 'Y' AND A0.ID_STIP = '"+id_stip+"' ");
			}
			// 未结算费用明细条件 针对所有没有结算的费用明细
			else if (fg_st.equals("N")) {
				sql.append("AND A0.FG_ST = 'N' ");
			}
		}

		if (auditFeeDto.getId_dep_nur() != null) {
			sql.append(" AND A0.ID_DEP_NUR = '").append(auditFeeDto.getId_dep_nur()).append("' ");
		}
		
		if (auditFeeDto.getId_dep_or() != null) {
			sql.append(" AND A0.ID_DEP_OR = '").append(auditFeeDto.getId_dep_or()).append("' ");
		}
		if (!StringUtil.isEmpty(auditFeeDto.getId_emp_or())) {
			sql.append(" AND A0.ID_EMP_OR = '").append(auditFeeDto.getId_emp_or()).append("' ");
		}
		if (auditFeeDto.getId_dep_mp() != null) {
			sql.append(" AND A0.ID_DEP_MP = '").append(auditFeeDto.getId_dep_mp()).append("' ");
		}
		if (auditFeeDto.getRatio_pripat() != null) {
			sql.append(" AND A0.RATIO_PRIPAT = '").append(auditFeeDto.getRatio_pripat()).append("' ");
		}
		if (auditFeeDto.getFg_hpin() != null) {
			sql.append(" AND A0.fg_selfpay = '").append(FBoolean.TRUE.equals(auditFeeDto.getFg_hpin()) ? "N" : "Y")
					.append("' ");
		}

		sql.append("    AND A0.DS = 0 ");
		sql.append("  ORDER BY A0.DT_SRV DESC ");

		pageFeeDTO = service.findByPageInfo(new BlIpAuditFeeDTO(), pageInfo, sql.toString(), "", new SqlParam());

		List<BlIpAuditFeeDTO> feeItemlist = new ArrayList<BlIpAuditFeeDTO>();

		feeItemlist = pageFeeDTO.getPageData();

		if (feeItemlist == null || feeItemlist.size() <= 0) {
			return pageFeeDTO;
		}

		// 3、根据科室病区id 获取名称
		addDepInfo(feeItemlist);

		BlIpAuditFeeDTO[] datasArr = feeItemlist.toArray(new BlIpAuditFeeDTO[] {});
		
		FArrayList list = new FArrayList();
		for (BlIpAuditFeeDTO itm : datasArr) {
			list.add(itm);
		}

		pageFeeDTO.setPageData(list);
		return pageFeeDTO;
	}

}

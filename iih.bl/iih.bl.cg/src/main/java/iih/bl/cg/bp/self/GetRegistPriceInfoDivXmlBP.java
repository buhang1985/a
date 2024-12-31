package iih.bl.cg.bp.self;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.pp.hp.i.IHpDepDORService;
import iih.bl.cg.api.d.PriceApplyInfo;
import iih.bl.cg.api.d.RegistPriceInfo;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.util.BlCodeUtils;
import iih.ci.ord.dto.recipedto.d.RecipeDTO;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * (挂号)自助医保门诊交费分解xml接口
 * 
 * @author LIM
 *
 */
public class GetRegistPriceInfoDivXmlBP {
	public PriceApplyInfo exec(RegistPriceInfo param) throws BizException {
		if (param == null) {
			throw new BizException("传入的参数不能为空！");
		}
		if (param.getPatCode() == null || param.getInsurCardNo() == null || param.getEntpCode() == null || param.getOperatorCode() == null || param.getSrv_Code() == null) {
			throw new BizException("传入的参数不能为空！");
		}
		PriceApplyInfo info = new PriceApplyInfo();
		info.setResultCode("1");
		// 1.根据患者code查询操作员
		// 判断操作员是否存在
		String[] psn = { "Id_psndoc,code" };
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class, "code='" + param.getOperatorCode() + "'", "code", psn);
		if (psnList == null || psnList.size() <= 0) {
			info.setResultMsg("该操作员不存在！");
			return info;
		}
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_dep(psnList.get(0).getId_dep());
		operatorInfoDTO.setId_emp(psnList.get(0).getId_psndoc());
		operatorInfoDTO.setId_grp(psnList.get(0).getId_group());
		operatorInfoDTO.setId_org(psnList.get(0).getId_org());
		operatorInfoDTO.setId_org_emp(psnList.get(0).getId_org());
		String operatorCode = psnList.get(0).getCode();
		// 2.判断就诊类型
		String entpCode = "";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(param.getEntpCode())) {
			entpCode = "17";// 门诊挂号
		} else {
			entpCode = "18";// 急诊挂号
		}
		// 3.获取发票包
		// IBLInvoiceService service =
		// ServiceFinder.find(IBLInvoiceService.class);
		// BlIncissOepDTO incIssOepDto =
		// service.getIncissOepDtoByEmp(psnList.get(0).getId_psndoc(),
		// IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
		// String strIncPkgCode = incIssOepDto.getCode_incpkg();
		// 4.组织记账数据
		// 4.1.获取挂号服务信息
		IScBdOutQryService scBdQryService = ServiceFinder.find(IScBdOutQryService.class);
		ScheduleSrvRelDO[] scheduleSrvRelDOArr = scBdQryService.getSchSrvRelBP(param.getSrv_Code());
		if (ArrayUtils.isEmpty(scheduleSrvRelDOArr)) {
			info.setResultMsg("未查询到服务信息！");
			return info;
		}
		// 4.2 组装处方信息
		RecipeDTO recipeDTO = new RecipeDTO();
		// 挂号数据 处方编号 为固定编码

		String id_pres = DateTimeUtils.toStringFDateTimeFormat(AppUtils.getServerDateTime()) + param.getOperatorCode();
		if (id_pres.length() > 20){
			id_pres = id_pres.substring(0, 20);
		}
		recipeDTO.setId_pres(id_pres);
		recipeDTO.setDt_entry(AppUtils.getServerDateTime());
		recipeDTO.setDidef_code("");
		recipeDTO.setDidef_name("");
		recipeDTO.setId_en("");
		// 获取医保科室编码 与名称---TODO需要修改
		HpDepDO hpDepDO = GetHpDep(param.getDeptCode());
		if (hpDepDO != null) {
			recipeDTO.setDepcode_hp(hpDepDO.getCode_hp());
			recipeDTO.setDepname_hp(hpDepDO.getName_hp());
		} else {
			recipeDTO.setDepcode_hp("");
			recipeDTO.setDepname_hp("");
		}
		DeptDO dept = getDeptDO(param.getDeptCode());
		if (dept != null) {
			recipeDTO.setId_dep_name(dept.getName());
		}
		PsnDocDO doc = null;
		if (!StringUtil.isEmptyWithTrim(param.getResCode())) {
			doc = getPsnDocDO(param.getResCode());
			if (doc != null) {
				recipeDTO.setId_emp_or(doc.getCode());
				recipeDTO.setId_emp_name(doc.getName());
			} else {
				recipeDTO.setId_emp_or("");
				recipeDTO.setId_emp_name("");
			}
		}

		recipeDTO.setRecipetype(FBoolean.TRUE);
		recipeDTO.setHelpmedicineflag(FBoolean.FALSE);
		recipeDTO.setRegistertradeno("");
		recipeDTO.setBillstype("1");

		// 4.3 通过挂号信息中的服务组装费用信息
		List<BlCgItmOepDO> cgitmList = new ArrayList<BlCgItmOepDO>();
		// 循环服务
		for (ScheduleSrvRelDO itm : scheduleSrvRelDOArr) {

			BlCgItmOepDO cgitm = new BlCgItmOepDO();
			cgitm.setSd_srvtp(itm.getSd_srvtp());
			// 设置名称
			cgitm.setFg_mm(FBoolean.FALSE);
			cgitm.setName_srv(itm.getName_mdsrv());
			// 设置单价
			cgitm.setAmt_std(itm.getPri_mdsrv());
			cgitm.setAmt_ratio(itm.getPri_mdsrv());
			cgitm.setPrice(itm.getPri_mdsrv());
			cgitm.setPrice_ratio(itm.getPri_mdsrv());

			// 设置就诊科室便于组装处方使用
			if (hpDepDO != null) {
				cgitm.setDepor_code(hpDepDO.getCode_hp());
				cgitm.setDepor_name(hpDepDO.getName_hp());
			} else {
				cgitm.setDepor_code("");
				cgitm.setDepor_name("");
			}
			// 设置就诊医生便于组装处方使用
			if (doc != null) {
				cgitm.setEmpor_code(doc.getCode());
				cgitm.setEmpor_name(doc.getName());
			} else {
				cgitm.setEmpor_code("");
				cgitm.setEmpor_name("");
			}

			cgitm.setId_pres(id_pres);
			// 当前未结算没有交易流水号， 因为是预划价可以先设置为固定数据
			cgitm.setCode_st(id_pres);
			cgitm.setCode_srv(itm.getCode_mdsrv());
			cgitm.setQuan(new FDouble(1));
			cgitmList.add(cgitm);
		}
		BlcgoepAggDO aggDO = new BlcgoepAggDO();
		aggDO.setBlCgItmOepDO(cgitmList.toArray(new BlCgItmOepDO[cgitmList.size()]));
		FArrayList arrayList = new FArrayList();
		arrayList.add(aggDO);
		BlCgOepAggDTO cgOepAggDTO = new BlCgOepAggDTO();
		cgOepAggDTO.setBlcgoepAggDO(arrayList);
		// 7.调用拼接字符串方法
		GetOrderXmlBp getOrderXmlBp = new GetOrderXmlBp();
		info.setInsurPriceData(getOrderXmlBp.Divide(cgOepAggDTO, null, operatorCode, entpCode, param.getInsurPerson()));
		info.setResultCode("0");
		info.setResultMsg("");
		return info;
	}

	private HpDepDO GetHpDep(String depCode) throws BizException {
		IHpDepDORService service = ServiceFinder.find(IHpDepDORService.class);
		HpDepDO[] hpDepDOs = service.find(HpDepDO.ID_DEP + " IN (SELECT ID_DEP FROM BD_DEP WHERE CODE='" + depCode + "')", "", FBoolean.FALSE);
		if (hpDepDOs != null && hpDepDOs.length > 0) {
			return hpDepDOs[0];
		}
		return null;
	}

	/**
	 * 获取医生信息
	 * 
	 * @param idPd
	 * @return
	 * @throws BizException
	 */
	private PsnDocDO getPsnDocDO(String code) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT PHY.DRID CODE,DOC.NAME FROM BD_PSNDOC DOC INNER JOIN BD_EMP_PHY PHY ON PHY.ID_PSNDOC=DOC.ID_PSNDOC where DOC.CODE= ? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(code);
		@SuppressWarnings("unchecked")
		List<PsnDocDO> list = (List<PsnDocDO>) new DAFacade().execQuery(sql.toString(), sqlParam, new BeanListHandler(PsnDocDO.class));
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 获取部门信息
	 * 
	 * @param idPd
	 * @return
	 * @throws BizException
	 */
	private DeptDO getDeptDO(String code) throws BizException {
		StringBuilder sqlDep = new StringBuilder();
		sqlDep.append(" select id_dep,code,name from bd_dep where code = ? ");
		SqlParam sqlParamDep = new SqlParam();
		sqlParamDep.addParam(code);
		@SuppressWarnings("unchecked")
		List<DeptDO> depList = (List<DeptDO>) new DAFacade().execQuery(sqlDep.toString(), sqlParamDep, new BeanListHandler(DeptDO.class));
		if (depList == null || depList.size() <= 0) {
			throw new BizException("未查询到对应的开单科室！");
		}
		return depList.get(0);
	}
}

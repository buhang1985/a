package iih.bl.cg.bp.self;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.FDoubleUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hp.d.HpDepDO;
import iih.bd.pp.hp.i.IHpDepDORService;
import iih.bl.cg.api.d.InsurPriceInfo;
import iih.bl.cg.api.d.PriceApplyInfo;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendIncParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.comm.IBlConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.st.service.i.IBLStQueService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;

public class GetInsurPriceInfoBP {

	public PriceApplyInfo exec(InsurPriceInfo param) throws BizException {
		// 1.判断参数是否为空
		if (param == null) {
			throw new BizException("传入的参数不能为空！");
		}
		if (param.getPatCode() == null || param.getInsurCardNo() == null || param.getEntpCode() == null || param.getOperatorCode() == null ||param.getAmt()==null) {
			throw new BizException("传入的参数不能为空！");
		}
		writeLog(param);
		String entpCode = "";
		if ((param.getEntpCode()).equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)) {
			entpCode = "11";// 门诊
		} else {
			entpCode = "19";// 急诊
		}

		PriceApplyInfo info = new PriceApplyInfo();
		info.setResultCode("1");

		if (param.getPresNoArray() == null) {
			info.setResultMsg("处方号不能为空！");
			return info;
		}
		// 2.根据患者code查询患者id_pat
		String[] pat = { "Id_pat,id_org" };
		List<PatDO> patDoList = (List<PatDO>) new DAFacade().findByCond(PatDO.class, "code = '" + param.getPatCode() + "' ", "1", pat);

		if (patDoList == null || patDoList.size() <= 0) {
			info.setResultMsg("该患者不存在！");
			return info;
		}
		// 3.根据患者code查询操作员
		// 判断操作员是否存在
		String[] psn = { "Id_psndoc,code" };
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class, "code='" + param.getOperatorCode() + "'", "code", psn);
		if (psnList == null || psnList.size() <= 0) {
			info.setResultMsg("该操作员不存在！");
			return info;
		}
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_dep(Context.get().getDeptId());
		operatorInfoDTO.setId_emp(psnList.get(0).getId_psndoc());
		operatorInfoDTO.setId_grp(Context.get().getGroupId());
		operatorInfoDTO.setId_org(Context.get().getOrgId());
		operatorInfoDTO.setId_org_emp(Context.get().getOrgId());
		// 操作员编码
		String operatorCode = psnList.get(0).getCode();

		// 5.获取所有未支付医嘱信息
		IBLStQueService rservice = ServiceFinder.find(IBLStQueService.class);
		BlOrderAppendBillParamDTO[] dto = rservice.getOrderSrvPrinceInfoByIdpres_load(patDoList.get(0).getId_pat(), 180);

		// 6.过滤需要的数据
		List<String> list = Arrays.asList(param.getPresNoArray());
		List<BlOrderAppendBillParamDTO> blorder = new ArrayList<BlOrderAppendBillParamDTO>();
		//是否校验0挂
//		Boolean bZeroReg= BlParamUtils.isEnableHpCompFeeZeroReg();
		for (BlOrderAppendBillParamDTO orderdto : dto) {
			// 过滤缴费信息
			if (list.contains(orderdto.getCode_apply()) && (param.getId_ent()).equals(orderdto.getId_ent())) {
//				if(bZeroReg){
//					// 判断是否存在医技补费医嘱，如果存在则返回，不能结算，由参数控制
//					if((OrSourceFromEnum.IIHMEDTECHORDERS).equals(orderdto.getEu_orsrcmdtp()) 
//							&& orderdto.getDt_or().compareTo(BlParamUtils.getOepPresCanStEarliestTime())==-1){
//						throw new BizException("存在需要零挂的医保数据，请到窗口处理！");
//					}
//				}
				blorder.add(orderdto);
			}
		}
		
		// 判断结算数据是否为空
		if (blorder.size() <= 0) {
			info.setResultMsg("没有需要结算数据！");
			return info;
		}
		
		
		// 7.划价
		// 7.1 组装数据
		BlOrderAppendBillParamDTO[] blorderPricedto = blorder.toArray(new BlOrderAppendBillParamDTO[blorder.size()]);
		for (BlOrderAppendBillParamDTO item : blorderPricedto) {
			item.setId_grp(operatorInfoDTO.getId_grp());
			item.setId_org(operatorInfoDTO.getId_org());
			item.setId_org_cg(operatorInfoDTO.getId_org());
			item.setId_dep_cg(operatorInfoDTO.getId_dep());
			item.setId_emp_cg(operatorInfoDTO.getId_emp());
			// TODO RecipeDTO只能为空，如果new了，count=0，则传输有问题
			if (item.getRecipeDTO() != null && item.getRecipeDTO().size() == 0)
				item.setRecipeDTO(null);
			BlOrderAppendIncParamDTO IncBillDTO = new BlOrderAppendIncParamDTO();
			IncBillDTO.setId_emp_inc(operatorInfoDTO.getId_emp());
			item.setIncBillDTO(IncBillDTO);
			item.getIncBillDTO().setCode_incca(IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
			item.getIncBillDTO().setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
			item.setEu_direct(IBlConst.BL_CHARGES);
		}
		// 7.2 划价
		IBLCiOrderToBlCgService orderService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		BlCgOepAggDTO cgaggDto = orderService.SetCiOrderToPrice(blorderPricedto, operatorInfoDTO, FBoolean.FALSE);
		
		//7.3增加判断支付金额与传入的金额时候相等
		FDouble amt =new FDouble() ;
		if(cgaggDto!=null){
			if (cgaggDto != null && cgaggDto.getBlcgoepAggDO() != null && cgaggDto.getBlcgoepAggDO().size() != 0) {
				for (Object cgaggdo : cgaggDto.getBlcgoepAggDO()) {
					BlcgoepAggDO cgdto = (BlcgoepAggDO) cgaggdo;
					for (int i = 0; i < cgdto.getBlCgItmOepDO().length; i++) {
						amt=amt.add(cgdto.getBlCgItmOepDO()[i].getAmt_ratio());
					}
				}
			}
		}
		if(!FDoubleUtils.isEqualWithTwoFDouble(new FDouble(param.getAmt()), amt)){
			info.setResultMsg("结算金额与传入金额不相等！可能发生原因：存在重复项目，单笔结算导致！");
			return info;
		}
		// 8.调用拼接字符串方法
		GetOrderXmlBp bp = new GetOrderXmlBp();
		info.setInsurPriceData(bp.Divide(cgaggDto, null, operatorCode, entpCode, param.getInsurPerson()));
		info.setResultCode("0");
		info.setResultMsg("");
		return info;
	}

	private HpDepDO GetHpDep(String depId) throws BizException {
		IHpDepDORService service = ServiceFinder.find(IHpDepDORService.class);
		HpDepDO[] hpDepDOs = service.find(HpDepDO.ID_DEP + "='" + depId + "'", "", FBoolean.FALSE);
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
		sql.append("SELECT PHY.DRID CODE,DOC.NAME FROM BD_PSNDOC DOC INNER JOIN BD_EMP_PHY PHY ON PHY.ID_PSNDOC=DOC.ID_PSNDOC where DOC.ID_PSNDOC= ? ");
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

	private void writeLog(InsurPriceInfo paramIn) {
		BLThirdItfLogger.info("getInsurPriceInfo{");
		BLThirdItfLogger.info("InsurPriceInfo{");
		BLThirdItfLogger.info("entpcode:" + paramIn.getEntpCode());
		BLThirdItfLogger.info("id_ent:" + paramIn.getId_ent());
		BLThirdItfLogger.info("insurcardno:" + paramIn.getInsurCardNo());
		BLThirdItfLogger.info("insureperson:" + paramIn.getInsurPerson());
		BLThirdItfLogger.info("operatorcode:" + paramIn.getOperatorCode());
		BLThirdItfLogger.info("patcode:" + paramIn.getPatCode());
		BLThirdItfLogger.info("presnoarray:" + CollectionUtils.toFArrayList(paramIn.getPresNoArray()).serializeJson());
		BLThirdItfLogger.info("}");
		BLThirdItfLogger.info("}");
	}
}

package iih.bl.cg.bp.self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cg.api.d.OpPayParam;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.bp.self.qry.GetEntHpQry;
import iih.bl.cg.s.bp.GetPayCodeBP;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.IBlConst;
import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.hp.divideresult.d.FeeBreakDTO;
import iih.bl.hp.divideresult.d.MediCatalog2DTO;
import iih.bl.prop.blproparoep.d.BlPropArItmOepDO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.dto.medicareinformation.d.HealthFeeDTO;
import iih.bl.st.dto.medicareinformation.d.HealthFeeItemDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 组装医保的分解的汇总信息
 * 
 * @author LIM
 *
 */
public class AssmHealthFeeDTOBp {
	/**
	 * 组装医保的分解的汇总信息
	 * 
	 * @param result
	 * @return
	 * @throws BizException
	 */
	public HealthFeeDTO exec(DivideResultDTO result) throws BizException {
		HealthFeeDTO feeInfo = new HealthFeeDTO();
		List<MediCatalog2DTO> cata2 = new ArrayList<MediCatalog2DTO>();
		cata2.add((MediCatalog2DTO) result.getCatalog2().get(0));

		feeInfo.setCode_st("");
		feeInfo.setPat_code("");
		feeInfo.setAccpay(result.getAccpay());
		feeInfo.setBalance(result.getBalance());
		feeInfo.setBcpay(result.getBcpay());
		feeInfo.setCash(result.getCash());
		feeInfo.setCuretype(result.getCuretype());
		feeInfo.setFeeall(result.getFeeall());
		feeInfo.setFund(result.getFund());
		feeInfo.setInvoiceno(result.getFeeno());
		feeInfo.setJcbz(result.getJcbz());
		feeInfo.setMzbigpay(result.getMzbigpay());
		feeInfo.setMzbigselfpay(result.getMzbigselfpay());
		feeInfo.setMzfee(result.getMzfee());
		feeInfo.setMzfeein(result.getMzfeein());
		feeInfo.setMzfeeout(result.getMzfeeout());
		feeInfo.setMzoutofbig(result.getMzoutofbig());
		feeInfo.setMzpayfirst(result.getMzpayfirst());
		feeInfo.setMzselfpay2(result.getMzselfpay2());
		feeInfo.setCommonservice(cata2.get(0).getCommonservice());
		feeInfo.setDiagnosis(cata2.get(0).getDiagnosis());
		feeInfo.setExamine(cata2.get(0).getExamine());
		feeInfo.setLabexam(cata2.get(0).getLabexam());
		feeInfo.setMaterial(cata2.get(0).getMaterial());
		feeInfo.setMedicalservice(cata2.get(0).getMedicalservice());
		feeInfo.setMedicine(cata2.get(0).getMedicine());
		feeInfo.setOperation(cata2.get(0).getOperation());
		feeInfo.setOther(cata2.get(0).getOther());
		feeInfo.setRegistfee(cata2.get(0).getRegistfee());
		feeInfo.setTherb(cata2.get(0).getTherb());
		feeInfo.setTmedicine(cata2.get(0).getTmedicine());
		feeInfo.setTradedate(result.getTradedate().getDate());
		feeInfo.setTradeno(result.getTradeno());
		feeInfo.setTreatment(cata2.get(0).getTreatment());
		return feeInfo;
	}

	/**
	 * 医保收费分解的明细信息
	 * 
	 * @param result
	 * @return
	 */
	public List<HealthFeeItemDTO> ConvertTOHealthFeeItemDTOLst(DivideResultDTO result) {
		List<HealthFeeItemDTO> feeItemList = new ArrayList<HealthFeeItemDTO>();
		for (Object obj : result.getFeebreaks()) {
			FeeBreakDTO item = (FeeBreakDTO) obj;
			HealthFeeItemDTO infoItem = new HealthFeeItemDTO();
			infoItem.setCount(item.getCount().intValue());
			infoItem.setFee(item.getFee());
			infoItem.setFee_type(item.getFee_type());
			infoItem.setFeein(item.getFeein());
			infoItem.setFeeout(item.getFeeout());
			infoItem.setItemcode(item.getItemcode());
			infoItem.setHisitemcode(item.getHisitemcode());
			infoItem.setItemname(item.getItemname());
			infoItem.setItemno(item.getItemno());
			infoItem.setItemtype(item.getItemtype());
			infoItem.setPreferentialfee(item.getPreferentialfee());
			infoItem.setPreferentialscale(item.getPreferentialscale());
			infoItem.setRecipeno(item.getRecipeno());
			infoItem.setSelfpay2(item.getSelfpay2());
			infoItem.setState(item.getState());
			infoItem.setUnitprice(item.getUnitprice());
			feeItemList.add(infoItem);
		}
		return feeItemList;
	}

	/**
	 * 组装分摊数据 与 组装应收数据
	 * 
	 * @param operatorInfoDTO
	 * @param id_stoep
	 * @return
	 */
	public List<BlPropOepDO> ConvertTOPropOepDODTOLst(OperatorInfoDTO operatorInfoDTO, String id_stoep) {
		// 组装分摊数据
		List<BlPropOepDO> blPropOepDOList = new ArrayList<BlPropOepDO>();
		BlPropOepDO blPropOepDO = new BlPropOepDO();
		blPropOepDO.setId_grp(operatorInfoDTO.getId_grp());
		blPropOepDO.setId_org(operatorInfoDTO.getId_org());
		// 结算金额的赋值
		blPropOepDO.setId_stoep(id_stoep);
		// 医保收费，方向为1
		blPropOepDO.setEu_direct(IBlConst.BL_CHARGES);
		blPropOepDO.setFg_active(FBoolean.TRUE);
		// 2 新增 3 删除 1 更新
		blPropOepDO.setStatus(2);
		blPropOepDOList.add(blPropOepDO);

		return blPropOepDOList;
	}

	/**
	 * 组装AGGDO
	 * 
	 * @param feeInfo
	 * @param feeItemList
	 * @param id_ent
	 * @throws BizException
	 */
	public List<BlproparoepAggDO> ConvertTOBlproparoepAggDOLst(HealthFeeDTO feeInfo, List<HealthFeeItemDTO> feeItemList, String id_ent) throws BizException {

		String cardinfo = "";
		String id_hp = "";
		// 组装应收数据

		List<BlproparoepAggDO> blproparoepAggDOList = new ArrayList<BlproparoepAggDO>();
		BlproparoepAggDO aggdo = new BlproparoepAggDO();

		BlPropArOepDO blPropArOepDO = new BlPropArOepDO();
		blPropArOepDO.setEu_direct(1);
		blPropArOepDO.setAmt_all(feeInfo.getFeeall());
		// 基金支付
		blPropArOepDO.setAmt_hp(feeInfo.getFund());
		// 个人帐户支付金额
		blPropArOepDO.setAmt_psnacc(feeInfo.getAccpay());
		// 现金支付
		blPropArOepDO.setAmt_cash(feeInfo.getCash());
		blPropArOepDO.setFg_clear(FBoolean.TRUE);
		// 交易流水号
		blPropArOepDO.setCode_hp(feeInfo.getTradeno());
		// TODO result的Card_No为空，需要获取值
		// 查询医保信息
		GetEntHpQry qry = new GetEntHpQry(id_ent);
		List<HPDO> hpDoList = (List<HPDO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(HPDO.class));
		if (hpDoList != null && hpDoList.size() > 0) {
			cardinfo = hpDoList.get(0).getCode();
			id_hp = hpDoList.get(0).getId_hp();
		}
		blPropArOepDO.setCardinfo(cardinfo);
		blPropArOepDO.setId_hp(id_hp);
		blPropArOepDO.setOutputinfo("");
		blPropArOepDO.setInputinfo("");
		blPropArOepDO.setStatus(2);

		List<BlPropArItmOepDO> blPropArItmOepDOList = new ArrayList<BlPropArItmOepDO>();
		for (HealthFeeItemDTO item : feeItemList) {
			BlPropArItmOepDO oepDo = new BlPropArItmOepDO();
			oepDo.setCode(item.getHisitemcode());
			oepDo.setName(item.getItemname());
			oepDo.setCode_hp(item.getItemcode());
			oepDo.setAmt_hp(item.getFeein());
			oepDo.setAmt_pat(item.getFeeout());
			oepDo.setQuan(new FDouble(item.getCount()));
			oepDo.setStatus(2);
			blPropArItmOepDOList.add(oepDo);
		}
		aggdo.setBlPropArItmOepDO(blPropArItmOepDOList.toArray(new BlPropArItmOepDO[blPropArItmOepDOList.size()]));
		aggdo.setParentDO(blPropArOepDO);
		blproparoepAggDOList.add(aggdo);

		return blproparoepAggDOList;
	}

	/**
	 * 结算时组装支付数据
	 * @param param
	 * @param patId
	 * @return
	 */
	public BlpaypatoepAggDO AssemblePayData(OpPayParam param, String patId,OperatorInfoDTO operatorInfoDTO) {
		BlpaypatoepAggDO blpaypatoepAggDO = new BlpaypatoepAggDO();
		BlPayPatOepDO blPayPatOepDO = new BlPayPatOepDO();
		blPayPatOepDO.setId_grp(Context.get().getGroupId());
		blPayPatOepDO.setId_grp(Context.get().getOrgId());
		// 就诊类型
		blPayPatOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		blPayPatOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		blPayPatOepDO.setId_pat(patId); // =
										// this.patientInfo.Id_pat;
		blPayPatOepDO.setEu_direct(IBlConst.BL_CHARGES);
		// 费用来源
		blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_SELF_TERMINAL);
		// 实际的收付款数肯定应该是要收入的金额
		blPayPatOepDO.setAmt(new FDouble(param.getAmt()));

		blPayPatOepDO.setId_org_pay(Context.get().getOrgId());
		blPayPatOepDO.setId_dep_pay(Context.get().getDeptId());
		blPayPatOepDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		blPayPatOepDO.setStatus(DOStatus.NEW);

		blpaypatoepAggDO.setParentDO(blPayPatOepDO);
		if (!StringUtil.isEmptyWithTrim(param.getPmCode())) {
			// 取付款方式
			Map<String, PriPmDO> priPm = convertIdPm(param.getPmCode());
			PriPmDO priPmDO = new PriPmDO();
			priPmDO = priPm.get(param.getPmCode());
			if (priPmDO != null) {
				// 付款明细
				BlPayItmPatOepDO blPayItmPatOepDO_remain = new BlPayItmPatOepDO();
				blPayItmPatOepDO_remain.setId_grp(Context.get().getGroupId());
				blPayItmPatOepDO_remain.setId_org(Context.get().getOrgId());
				blPayItmPatOepDO_remain.setEu_direct(1);

				blPayItmPatOepDO_remain.setId_pm(priPmDO.getId_pm());
				blPayItmPatOepDO_remain.setSd_pm(priPmDO.getCode());
				blPayItmPatOepDO_remain.setName_pm(priPmDO.getName());
				blPayItmPatOepDO_remain.setPm_code(priPmDO.getCode());
				blPayItmPatOepDO_remain.setStatus(DOStatus.NEW);
				blPayItmPatOepDO_remain.setPaymodenode(param.getPayOrder());
				blPayItmPatOepDO_remain.setAmt(new FDouble(param.getAmt()));
				blPayItmPatOepDO_remain.setBankno(param.getAccount());
				blPayItmPatOepDO_remain.setFg_realpay(FBoolean.TRUE);
				// 子项添加到AggDO
				blpaypatoepAggDO.setBlPayItmPatOepDO(new BlPayItmPatOepDO[] { blPayItmPatOepDO_remain });
			}
		}
		return blpaypatoepAggDO;
	}

	/**
	 * 通过医保返回xml 获取支付信息
	 * 
	 * @param xmlResult
	 * @return
	 * @throws BizException
	 */
	public List<BlPayItmPatOepDO> getInsurPayItmByXml(String xmlResult) throws BizException {
		if (!StringUtil.isEmptyWithTrim(xmlResult)) {
			List<BlPayItmPatOepDO> list = new ArrayList<BlPayItmPatOepDO>();
			DivideResultByXmlBp bp = new DivideResultByXmlBp();
			DivideResultDTO resdto = bp.exec(xmlResult);
			// 取付款方式
			if (resdto.getFund() != null && !FDouble.ZERO_DBL.equals(resdto.getFund())) {
				PriPmDO priPmDO = GetPmByID(IBdPripmCodeConst.ID_PRI_PM_INSUR);

				BlPayItmPatOepDO blPayItmPatOepDO_remain = new BlPayItmPatOepDO();
				blPayItmPatOepDO_remain.setId_grp(Context.get().getGroupId());
				blPayItmPatOepDO_remain.setId_org(Context.get().getOrgId());
				blPayItmPatOepDO_remain.setEu_direct(1);

				blPayItmPatOepDO_remain.setId_pm(priPmDO.getId_pm());
				blPayItmPatOepDO_remain.setSd_pm(priPmDO.getCode());
				blPayItmPatOepDO_remain.setName_pm(priPmDO.getName());
				blPayItmPatOepDO_remain.setPm_code(priPmDO.getCode());
				blPayItmPatOepDO_remain.setPm_name(priPmDO.getName());
				blPayItmPatOepDO_remain.setStatus(DOStatus.NEW);
				blPayItmPatOepDO_remain.setAmt(new FDouble(resdto.getFund()));
				blPayItmPatOepDO_remain.setFg_realpay(FBoolean.TRUE);
				list.add(blPayItmPatOepDO_remain);
			}
			if (resdto.getAccpay() != null && !FDouble.ZERO_DBL.equals(resdto.getAccpay())) {
				PriPmDO priPmDO = GetPmByID(IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT);

				BlPayItmPatOepDO blPayItmPatOepDO_remain = new BlPayItmPatOepDO();
				blPayItmPatOepDO_remain.setId_grp(Context.get().getGroupId());
				blPayItmPatOepDO_remain.setId_org(Context.get().getOrgId());
				blPayItmPatOepDO_remain.setEu_direct(1);

				blPayItmPatOepDO_remain.setId_pm(priPmDO.getId_pm());
				blPayItmPatOepDO_remain.setSd_pm(priPmDO.getCode());
				blPayItmPatOepDO_remain.setName_pm(priPmDO.getName());
				blPayItmPatOepDO_remain.setPm_code(priPmDO.getCode());
				blPayItmPatOepDO_remain.setPm_name(priPmDO.getName());
				blPayItmPatOepDO_remain.setStatus(DOStatus.NEW);
				blPayItmPatOepDO_remain.setAmt(new FDouble(resdto.getAccpay()));
				blPayItmPatOepDO_remain.setFg_realpay(FBoolean.TRUE);
				list.add(blPayItmPatOepDO_remain);
			}
			return list;
		}
		return null;
	}

	/**
	 * 获取记账aggdo
	 * 
	 * @return
	 * @throws BizException
	 */
	public BlcgoepAggDO[] getBlcgoepAggDO(String id_stoep) throws BizException {
		IBlcgoepRService aggService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] aggDos = aggService.find(" id_cgoep in (SELECT ID_CGOEP FROM BL_CG_ITM_OEP WHERE ID_STOEP='" + id_stoep + "')", "", FBoolean.TRUE);
		return aggDos;
	}

	/**
	 * 获取支付DO
	 * @param pmId
	 * @return
	 * @throws BizException
	 */
	public PriPmDO GetPmByID(String pmId) throws BizException {
		IPripmRService pmser = ServiceFinder.find(IPripmRService.class);
		return pmser.findById(pmId);
	}

	/**
	 * 返回相应支付方式
	 * 
	 * @param pmCode
	 * @return
	 */
	private Map<String, PriPmDO> convertIdPm(String pmCode) {
		GetPayCodeBP bp = new GetPayCodeBP();
		Map<String, PriPmDO> priMap = new HashMap<String, PriPmDO>();
		priMap.put(pmCode, bp.exec(pmCode, true));
		return priMap;
	}
}

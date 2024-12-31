package iih.bl.st.s.task.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.log.BLBizLogger;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.params.BlParams;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.s.bp.op.OpCgGetNotStPrepayCgBP;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.pat.d.PatDO;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 预付费自动结算处理类 只处理自费患者预付费记账
 * 
 * @author ly 2018/05/17
 *
 */
public class OpAutoPrepaySettlementBP {

	/**
	 * 预付费自动结算
	 * 
	 * @param patId
	 * @param dtBegin
	 * @throws BizException
	 */
	public void exec(String patId, FDateTime dtBegin, String patcaid, FDateTime dtend) throws BizException {

		List<PatDO> list = this.getNeedSettlePat(patId, dtBegin, patcaid, dtend);
		if (ListUtil.isEmpty(list))
			return;

		// 自动结算设置结算默认患者分类
		IPatientcategoryRService caService = ServiceFinder.find(IPatientcategoryRService.class);

		PiPatCaDO[] caDos = caService.find("a0.fg_def = 'Y' ", null, FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(caDos)) {
			Context.get().setAttribute("DEFAULTPATCA", caDos[0].getId_patca());
		}

		for (PatDO patDO : list) {
			BLTaskLogger.info(String.format("患者%s(%s)门诊预交金自动结算处理开始", patDO.getName(), patDO.getId_pat()));
			try {

				final String fpatId = patDO.getId_pat();
				final FDateTime fdtBegin = dtBegin;
				final FDateTime fddtend = dtend;
				TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
					@Override
					public String doInTransaction(TransactionStatus status) throws InvocationTargetException {
						try {
							process(fpatId, fdtBegin, fddtend);
						} catch (BizException e) {
							throw new InvocationTargetException(e);
						}
						return null;
					}
				});
				BLTaskLogger.info(String.format("患者%s(%s)门诊预交金自动结算处理成功", patDO.getName(), patDO.getId_pat()));
			} catch (Exception e) {
				BLTaskLogger.error(String.format("患者%s(%s)门诊预交金自动结算处理失败", patDO.getName(), patDO.getId_pat()), e);
			}
		}
	}

	/**
	 * 查询需要结算的患者信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<PatDO> getNeedSettlePat(String patId, FDateTime dtBegin, String patcaid, FDateTime startDate) throws BizException {

		String patcaIds = patcaid == null ? BlParams.BLSTBK0002() : patcaid;
		String[] patcaArr = null;
		if (!StringUtil.isEmpty(patcaIds)) {
			patcaArr = patcaIds.split(",");
		}

		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct pat.id_pat,pat.name ");
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_cg_oep cgoep ");
		sqlSb.append("on cgitm.id_cgoep = cgoep.id_cgoep ");
		sqlSb.append("inner join pi_pat pat ");
		sqlSb.append("on cgitm.id_pat = pat.id_pat ");
		sqlSb.append("where nvl(cgitm.id_stoep,'~') = '~' ");
		sqlSb.append("and cgitm.fg_acc = 'Y' ");
		sqlSb.append("and cgoep.eu_direct = 1   ");
		sqlSb.append("and cgitm.fg_refund = 'N' ");
		sqlSb.append("and cgoep.dt_cg > ? ");
		sqlSb.append("and cgoep.dt_cg < ? ");
		if (!ArrayUtil.isEmpty(patcaArr)) {
			sqlSb.append("and " + SqlUtils.getInSqlByIds("pat.id_paticate", patcaArr));
		}

		String orgSql = EnvContextUtil.processEnvContext("", new BlCgItmOepDO(), "cgitm");
		sqlSb.append("and " + orgSql);

		SqlParam param = new SqlParam();
		param.addParam(dtBegin);
		param.addParam(startDate);
		if (!StringUtil.isEmpty(patId)) {
			sqlSb.append("and pat.id_pat = ? ");
			param.addParam(patId);
		}

		DAFacade daf = new DAFacade();
		List<PatDO> rlt = (List<PatDO>) daf.execQuery(sqlSb.toString(), param, new BeanListHandler(PatDO.class));
		return rlt;
	}

	/**
	 * 预交金结算处理
	 * 
	 * @param patId
	 * @param dtBegin
	 * @param dtend
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void process(String patId, FDateTime dtBegin, FDateTime dtend) throws BizException {

		// 检索明细
		OpCgGetNotStPrepayCgBP cgBp = new OpCgGetNotStPrepayCgBP();
		List<BlOrderAppendBillParamDTO> billPrams = cgBp.exec(patId, dtBegin, dtend);
		if (ListUtil.isEmpty(billPrams))
			return;
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_grp(Context.get().getGroupId());
		operatorInfoDTO.setId_org(Context.get().getOrgId());
		operatorInfoDTO.setId_dep(Context.get().getDeptId());
		operatorInfoDTO.setId_emp(Context.get().getStuffId());
		operatorInfoDTO.setId_org_emp(Context.get().getOrgId());

		FBoolean BLSTBK0003 = BlParams.BLSTBK0003();// 门诊自动结算是否按执行时间点拆分
		FBoolean BLSTOEP0031 =BlParams.BLSTOEP0031();//门诊收费：是否允许挂号费和医嘱费用合并结算
		List<BlOrderAppendBillParamDTO> noEntbillPrams= new ArrayList<BlOrderAppendBillParamDTO>();
		//如果挂号费和医嘱分开结算，则先结算挂号费
		if(FBoolean.FALSE.equals(BLSTOEP0031)){
			HashMap<String, List<BlOrderAppendBillParamDTO>> entBillParamDtoMap = new HashMap<String, List<BlOrderAppendBillParamDTO>>();
			for (BlOrderAppendBillParamDTO dto : billPrams) {
				if (FeeOriginEnum.ENCOUNTER_FEE.equals(dto.getEu_srctp())) {
					if(entBillParamDtoMap.containsKey(dto.getId_ent())){
						entBillParamDtoMap.get(dto.getId_ent()).add(dto);
					}else{
						List<BlOrderAppendBillParamDTO> tmpEntList = new ArrayList<BlOrderAppendBillParamDTO>();
						tmpEntList.add(dto);
						entBillParamDtoMap.put(dto.getId_ent(), tmpEntList);
					}
				}else{
					noEntbillPrams.add(dto);
				}
			}	
			if(entBillParamDtoMap.size()>0){
				for (String idEnt : entBillParamDtoMap.keySet()) {
					this.settlement(patId, entBillParamDtoMap.get(idEnt).toArray(new BlOrderAppendBillParamDTO[0]), operatorInfoDTO);
				}
			}
			if (ListUtil.isEmpty(noEntbillPrams))
				return;
			billPrams=noEntbillPrams;
		}
		
		if (FBoolean.TRUE.equals(BLSTBK0003)) {
			HashMap<FDateTime, List<BlOrderAppendBillParamDTO>> billPramsDtoMap = new HashMap<FDateTime, List<BlOrderAppendBillParamDTO>>();
			for (BlOrderAppendBillParamDTO dto : billPrams) {
				if (billPramsDtoMap.containsKey(dto.getDt_cg())) {
					billPramsDtoMap.get(dto.getDt_cg()).add(dto);
				} else {
					List<BlOrderAppendBillParamDTO> tmpList = new ArrayList<BlOrderAppendBillParamDTO>();
					tmpList.add(dto);
					billPramsDtoMap.put(dto.getDt_cg(), tmpList);
				}
			}
			if (billPramsDtoMap.size() > 0) {
				for (FDateTime dt : billPramsDtoMap.keySet()) {
					this.settlement(patId, billPramsDtoMap.get(dt).toArray(new BlOrderAppendBillParamDTO[0]), operatorInfoDTO);
				}
			}
		} else {
			this.settlement(patId, billPrams.toArray(new BlOrderAppendBillParamDTO[0]), operatorInfoDTO);
		}
	}

	/**
	 * 门诊划价结算
	 * 
	 * @param patId
	 * @param billPrams
	 * @param operatorInfoDTO
	 * @throws BizException
	 */
	private void settlement(String patId, BlOrderAppendBillParamDTO[] billPrams, OperatorInfoDTO operatorInfoDTO) throws BizException {
		// 划价
		IBLCiOrderToBlCgService blCgService = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		BlCgOepAggDTO blCgOepAggDTO = blCgService.SetCiOrderToPrice(billPrams, operatorInfoDTO, FBoolean.FALSE);

		// 计算总额
		String stId = null;

		FDouble amt_ratio = new FDouble(0);
		FArrayList blcgoepAggDOLst = blCgOepAggDTO.getBlcgoepAggDO();
		@SuppressWarnings("unchecked")
		BlcgoepAggDO[] blcgoepAggDOs = (BlcgoepAggDO[]) blcgoepAggDOLst.toArray(new BlcgoepAggDO[0]);
		for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOs) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				stId = blCgItmOepDO.getId_stoep();
				amt_ratio = amt_ratio.add(blCgItmOepDO.getAmt_ratio());
			}
		}

		// 查询结算数据
		IBlstoepRService stService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stDO = stService.findById(stId);

		// TESTLOG
		try {
			if (stDO.getAmt_ratio().compareTo(amt_ratio) != 0) {

				String cgItms = "";
				for (BlcgoepAggDO blcgoepAggDO : blcgoepAggDOs) {
					BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
					for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
						cgItms += blCgItmOepDO.getId_cgitmoep() + ",";
					}
				}

				String log = String.format("结算金额和记账金额不一致，结算金额-->%s，记账金额-->%s,记账id-->%s", stDO.getAmt_ratio().toString(), amt_ratio.toString(), cgItms);
				BLBizLogger.info(log);
			}
		} catch (Exception e) {
		}

		// 组装支付数据
		BlpaypatoepAggDO blpaypatoepAggDO = this.assemblePayData(stDO.getAmt_ratio(), operatorInfoDTO, patId);

		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SD_PTTP, IBlDictCodeConst.SD_PTTP_SYSTEM);

		// 结算
		blCgService.SettlementPayment(blcgoepAggDOs, blpaypatoepAggDO, FBoolean.FALSE, FBoolean.FALSE, FBoolean.FALSE);
	}

	/**
	 * 组装支付数据 之后迭代 TODO
	 * 
	 * @param amtPay
	 * @param operatorInfoDTO
	 * @param patId
	 * @return
	 */
	private BlpaypatoepAggDO assemblePayData(FDouble amtPay, OperatorInfoDTO operatorInfoDTO, String patId) {
		BlpaypatoepAggDO blpaypatoepAggDO = new BlpaypatoepAggDO();
		// 1.组装主表
		BlPayPatOepDO blPayPatOepDO = new BlPayPatOepDO();
		blPayPatOepDO.setId_grp(operatorInfoDTO.getId_grp());
		blPayPatOepDO.setId_org(operatorInfoDTO.getId_org());
		blPayPatOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		blPayPatOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		blPayPatOepDO.setId_pat(patId);
		blPayPatOepDO.setEu_direct(PayDirectEnum.CHARGE);
		// 费用来源
		// blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_SYSTEM);
		blPayPatOepDO.setId_pttp(IBlDictCodeConst.ID_PTTP_SYSTEM);
		// 实际的收付款数肯定应该是要收入的金额
		blPayPatOepDO.setAmt(amtPay);
		blPayPatOepDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
		blPayPatOepDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatOepDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);

		// 2. 组装子表
		BlPayItmPatOepDO[] arr = new BlPayItmPatOepDO[1];
		BlPayItmPatOepDO blPayItmPatOepDO_1 = new BlPayItmPatOepDO();
		blPayItmPatOepDO_1.setId_grp(operatorInfoDTO.getId_grp());
		blPayItmPatOepDO_1.setId_org(operatorInfoDTO.getId_org());
		blPayItmPatOepDO_1.setEu_direct(Integer.valueOf(IBlDictCodeConst.SD_DIRECT_CHARGE).intValue());
		blPayItmPatOepDO_1.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		blPayItmPatOepDO_1.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
		blPayItmPatOepDO_1.setStatus(DOStatus.NEW);
		blPayItmPatOepDO_1.setPaymodenode(null);
		blPayItmPatOepDO_1.setAmt(amtPay);
		blPayItmPatOepDO_1.setFg_realpay(FBoolean.TRUE);// 真实数据
		arr[0] = blPayItmPatOepDO_1;
		// 子项添加到AggDO
		blpaypatoepAggDO.setBlPayItmPatOepDO(arr);

		return blpaypatoepAggDO;
	}
}

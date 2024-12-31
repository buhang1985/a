package iih.bl.cg.ip.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.bp.ValidateParam;
import iih.bl.cg.ip.dto.d.IpCompensateBillDTO;
import iih.bl.cg.ip.s.ep.InccaCommonEp;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 多患者执行计费
 * @author yi
 *	@Date 2017-09-21
 */
public class ExecuChargeMultiPatBp {

	/**	多患者执行计费
	 * @return 计费后明细信息
	 * @throws BizException
	 */
	public IpCompensateBillDTO[] exec(IpCompensateBillDTO[] ipCompensateBillDtoArr) throws BizException
	{
		List<BlOrderAppendBillParamDTO> billParamDtoLst=assemblyBlorderAppendParamDtoLst(ipCompensateBillDtoArr);
		//容器
		List<BlOrderAppendBillParamDTO> billItmDtoLst = new ArrayList<BlOrderAppendBillParamDTO>();
		Map<String, FDouble> entVsAmtMap = new HashMap<String, FDouble>();// <id_ent,消费金额>
		//就诊Vs账单明细
		Map<String, List<BlOrderAppendBillParamDTO>> entVsBillItmMap = new HashMap<String, List<BlOrderAppendBillParamDTO>>();// <id_ent,记费明细>
				FDouble sumAmtRatio = new FDouble(0);
		List<String> orsrvids_list = new ArrayList<String>();// 需要修改记账信息的医嘱
		List<String> id_entLst = new ArrayList<String>(); // 待补费的患者集合
		for (BlOrderAppendBillParamDTO billItmDto : billParamDtoLst) {
			if (!id_entLst.contains(billItmDto.getId_ent())) {
				id_entLst.add(billItmDto.getId_ent());
			}
			// 记录已记账的医嘱序号
			if (!orsrvids_list.contains(billItmDto.getId_orsrv())) {
				orsrvids_list.add(billItmDto.getId_orsrv());
			}
			billItmDto.setFg_susp(FBoolean.FALSE);// 补费的数据未挂起
			billItmDto.setFg_hp(FBoolean.FALSE);// 记账上传医保标志
			if (billItmDto.getPrice_ratio() == null) {
				billItmDto.setPrice_ratio(billItmDto.getPrice());
			}
			billItmDto.setAmt(billItmDto.getAmt().setScale(-2, BigDecimal.ROUND_HALF_UP));
			billItmDto.setAmt_std(billItmDto.getAmt_std().setScale(-2, BigDecimal.ROUND_HALF_UP));
			billItmDto.setAmt_hp(billItmDto.getAmt_hp().setScale(-2, BigDecimal.ROUND_HALF_UP));
			billItmDto.setAmt_pat(billItmDto.getAmt_pat().setScale(-2, BigDecimal.ROUND_HALF_UP));
			if (billItmDto.getAmt_ratio() == null) {
				billItmDto.setAmt_ratio(billItmDto.getAmt());
			} else {
				billItmDto.setAmt_ratio(billItmDto.getAmt_ratio().setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
			//统计就诊金额
			if(entVsAmtMap.containsKey(billItmDto.getId_ent()))
			{
				FDouble fdAmtRatio=entVsAmtMap.get(billItmDto.getId_ent()).add(billItmDto.getAmt_ratio());
				entVsAmtMap.put(billItmDto.getId_ent(), fdAmtRatio);
			}
			else{
				entVsAmtMap.put(billItmDto.getId_ent(), billItmDto.getAmt_ratio());
			}
			
			if(entVsBillItmMap.containsKey(billItmDto.getId_ent()))
			{
				List<BlOrderAppendBillParamDTO> lst=entVsBillItmMap.get(billItmDto.getId_ent());
				lst.add(billItmDto);
				entVsBillItmMap.put(billItmDto.getId_ent(), lst);
			}
			else
			{
				List<BlOrderAppendBillParamDTO> arr=new ArrayList<BlOrderAppendBillParamDTO>();
				arr.add(billItmDto);
				entVsBillItmMap.put(billItmDto.getId_ent(), arr);
			}
			if (billItmDto.getName_inccaitm() == null || billItmDto.getName_inccaitm().trim().length() == 0) {
				InccaCommonEp inccaCommonEp=new InccaCommonEp();
				// 完善账单码
				IncCaItmDO incCaItmDO = inccaCommonEp.getInccaitmCodeAndName(billItmDto.getCode_enttp(), billItmDto.getId_srv());
				if (incCaItmDO != null) {
					billItmDto.setName_inccaitm(incCaItmDO.getName());
					billItmDto.setCode_inccaitm(incCaItmDO.getCode());
				}
			}
		}
		return calcualtePriceAndCharge(entVsBillItmMap,entVsAmtMap);
	}

	private IpCompensateBillDTO[] calcualtePriceAndCharge(Map<String, List<BlOrderAppendBillParamDTO>> entVsBillItmMap,Map<String, FDouble> entVsAmtMap) throws BizException{
		ValidateParam validater=new ValidateParam();
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);
		List<IpCompensateBillDTO> chargedBillItmDtoLst=new ArrayList<IpCompensateBillDTO>();
		for(String strKey:entVsBillItmMap.keySet())
		{
			FBoolean isMerge =BlParams.BLSTIP0005();
			List<BlOrderAppendBillParamDTO> billItmDtoArr=entVsBillItmMap.get(strKey);
			NewbornDO entNewBorn = inpPatAccImpls.getNewbornDO(strKey);
			//1、参数验证
			List<String> strIdOrSrvLst=validateParam(billItmDtoArr,entNewBorn);
			//2、母婴关系判断
			//预交金持有人，如果是新生儿，则用母亲账户
			String strIdEntAcc=null;
			if(entNewBorn!=null && FBoolean.TRUE.equals(isMerge))
			{
				strIdEntAcc = entNewBorn.getId_ent_mom();
			}
			else
			{
				strIdEntAcc=strKey;
			}
			//3、校验一下是否已经封账,如果是新生儿则校验母亲的账户是否被封
			validater.validateFreezeAccAndAuditStatus(strIdEntAcc);
			//4、计算住院账户余额：调用住院账户接口，比对是否允许记账
			BalanceDTO balanceDTO=inpPatAccImpls.getBalanceDTO(strIdEntAcc);
			FDouble prepayAmount = balanceDTO.getAvailable();
			FDouble fdAmtRatio=entVsAmtMap.get(strKey);
			// 与标准金额比较，当预交金余额不足时，需要进行是否允许后付费的判断
			if (prepayAmount.compareTo(fdAmtRatio) < 0) {
				if (!billItmDtoArr.get(0).getSupportAppendBill().booleanValue()) {
					throw new BizException("住院预交金余额不足，不支持后付费！\r\n本次执行金额：" + fdAmtRatio.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "\r\n差额："
							+ fdAmtRatio.sub(prepayAmount).setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
				}
			}

			//5.生成记账信息
			BlCgIpDO[] blCgIpDOs =mapperToCgIpDoArr(billItmDtoArr);
			// 存入住院记账表
			IBlcgqueryCudService iBlcgqueryMDOCudService = ServiceFinder.find(IBlcgqueryCudService.class);
			BlCgIpDO[] blCgIpDOArr = iBlcgqueryMDOCudService.save(blCgIpDOs);
			if (null == blCgIpDOArr || blCgIpDOArr.length == 0) {
				throw new BizException("保存住院记账信息失败");
			}
			
			//6、预交金账户处理
			enAccService.consume(strIdEntAcc, fdAmtRatio);
			
			//7、更改医嘱记账状态
			ICiOrdMaintainService obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
			FBoolean updateCiOrder = obj2X.UpdateOrdChargeRelInfo2(strIdOrSrvLst.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, AppUtils.getServerDateTime(), FeeReverseType.NOBLCANCEL);
			
			//8、获取记账后的明细
			List<IpCompensateBillDTO> chargedBillItmDtoArr=mapperToBillItmDtoArr(blCgIpDOArr);
			
			chargedBillItmDtoLst.addAll(chargedBillItmDtoArr);
		}
		return chargedBillItmDtoLst.toArray(new IpCompensateBillDTO[chargedBillItmDtoLst.size()]);
	}
	/**参数校验
	 * @param paramsDTOArr 记账明细
	 * @throws BizException 
	 */
	private List<String> validateParam(List<BlOrderAppendBillParamDTO> paramsDTOArr,NewbornDO entNewBorn) throws BizException
	{
		if(ListUtil.isEmpty(paramsDTOArr))
			throw new BizException("没有传入补费信息");
		List<String> strIdOrSrvLst=new ArrayList<String>();
		for(BlOrderAppendBillParamDTO itmDto:paramsDTOArr)
		{
			if(entNewBorn!=null)
			{
				//如果是新生儿
				if(itmDto.getInpBillDTO()!=null)
				{
					BlOrderAppendInpBillParamDTO inpBillDto=itmDto.getInpBillDTO();
					inpBillDto.setFg_bb(FBoolean.TRUE);
					inpBillDto.setNo_bb(entNewBorn.getNo_bb());
					inpBillDto.setId_ent_mom(entNewBorn.getId_ent_mom());
				}
				else{
					BlOrderAppendInpBillParamDTO inpBillDto=new BlOrderAppendInpBillParamDTO();
					inpBillDto.setFg_bb(FBoolean.TRUE);
					inpBillDto.setNo_bb(entNewBorn.getNo_bb());
					inpBillDto.setId_ent_mom(entNewBorn.getId_ent_mom());
					itmDto.setInpBillDTO(inpBillDto);
				}
			}
			if (itmDto.getPrice() != null) {
				if (itmDto.getPrice().compareTo(new FDouble(0)) == 0) {
					throw new BizException("参与计价的明细价格应大于0，项目："
							+ itmDto.getName_srv());
				}
				if (itmDto.getAmt() == null
						|| itmDto.getAmt().compareTo(new FDouble(0)) < 0) {
					throw new BizException("本人费用应该大于0 ！项目："
							+ itmDto.getName_srv());
				}
				if (itmDto.getAmt_std() == null
						|| itmDto.getAmt_std().compareTo(new FDouble(0)) < 0) {
					throw new BizException("标准金额应该大于0 ！项目："
							+ itmDto.getName_srv());
				}
			}
			if (itmDto.getQuan() == null
					|| itmDto.getQuan().compareTo(new FDouble(0)) < 0) {
				throw new BizException("项目数量应该大于0 ！项目：" + itmDto.getName_srv());
			}
			if (null == itmDto.getId_org()) {
				throw new BizException("集团不允许为空！服务名称：" + itmDto.getName_srv());
			}
			if (null == itmDto.getId_grp()) {
				throw new BizException("组织不允许为空！服务名称：" + itmDto.getName_srv());
			}
			// id_srvca与sd_srvtp的非空校验
			if (null == itmDto.getId_srvca()) {
				throw new BizException("服务项目分类不允许为空！服务名称："
						+ itmDto.getName_srv());
			}
			if (null == itmDto.getSd_srvtp()) {
				throw new BizException("服务项目类型不允许为空！服务名称："
						+ itmDto.getName_srv());
			}
			if (itmDto.getSrvu() == null) {
				throw new BizException("项目单位不允许为空！项目：" + itmDto.getName_srv());
			}
			if (itmDto.getId_dep_mp() == null) {
				throw new BizException("执行科室不允许为空！项目：" + itmDto.getName_srv());
			}
			if (itmDto.getId_pripat() == null) {
				throw new BizException("患者价格分类不允许为空！项目：" + itmDto.getName_srv());
			}
			if (itmDto.getCode_enttp() == null) {
				throw new BizException("就诊类型代码不允许为空！项目：" + itmDto.getName_srv());
			}
			if (itmDto.getId_enttp() == null) {
				throw new BizException("就诊类型代码不允许为空！项目：" + itmDto.getName_srv());
			}
			strIdOrSrvLst.add(itmDto.getId_orsrv());
		}
		return strIdOrSrvLst;
	}

	/**映射到记账实体
	 * @param paramsDTOArr 记账明细
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO[] mapperToCgIpDoArr(List<BlOrderAppendBillParamDTO> paramsDTOArr) throws BizException
	{
		List<BlCgIpDO> cgIpDoLst = new ArrayList<BlCgIpDO>();
		GetCodeByCustomization billCustom=new GetCodeByCustomization();
		for (BlOrderAppendBillParamDTO billItmDto:paramsDTOArr) {
			BlCgIpDO blCgIpDO = new BlCgIpDO();
			blCgIpDO.setCode_apply(billItmDto.getCode_apply());
			blCgIpDO.setFg_free(billItmDto.getFg_free());
			blCgIpDO.setId_grp(billItmDto.getId_grp());
			blCgIpDO.setId_org(billItmDto.getId_org());
			blCgIpDO.setId_pat(billItmDto.getId_pat());
			blCgIpDO.setId_ent(billItmDto.getId_ent());
			blCgIpDO.setId_enttp(billItmDto.getId_enttp());
			blCgIpDO.setCode_enttp(billItmDto.getCode_enttp());
			// 账单码
			if (billItmDto.getCode_inccaitm() == null || billItmDto.getName_inccaitm() == null) {
				InccaCommonEp inccaCommonEp=new InccaCommonEp();
				IncCaItmDO incCaItmDO = inccaCommonEp.getInccaitmCodeAndName(billItmDto.getCode_enttp(), billItmDto.getId_srv());
				if (incCaItmDO != null) {
					blCgIpDO.setName_inccaitm(incCaItmDO.getName());
					blCgIpDO.setCode_inccaitm(incCaItmDO.getCode());
				} else {
					throw new BizException("未查询到【" + billItmDto.getName_srv() + "】所对应的发票分类！");
				}
			} else {
				blCgIpDO.setName_inccaitm(billItmDto.getName_inccaitm());
				blCgIpDO.setCode_inccaitm(billItmDto.getCode_inccaitm());
			}
			blCgIpDO.setFg_additm(billItmDto.getFg_additm());// 是否补费标志
			blCgIpDO.setNote(billItmDto.getNote());
			// 兼容
			if (String.valueOf(billItmDto.getEu_direct()) == null || ("").equals(String.valueOf(billItmDto.getEu_direct()).trim())) {
				throw new BizException("请设置记、退费方向！");
			} else {
				blCgIpDO.setEu_direct(billItmDto.getEu_direct());// 记退费方向
			}
			//记账流水号
			blCgIpDO.setCode_cg(billCustom.GetCodeBlCgOep());
			blCgIpDO.setId_srvtp(billItmDto.getId_srvtp());
			blCgIpDO.setSd_srvtp(billItmDto.getSd_srvtp());
			blCgIpDO.setId_srvca(billItmDto.getId_srvca());
			blCgIpDO.setId_srv(billItmDto.getId_srv());
			blCgIpDO.setCode_srv(billItmDto.getCode_srv());
			blCgIpDO.setName_srv(billItmDto.getName_srv());
			blCgIpDO.setSrvu(billItmDto.getSrvu());
			blCgIpDO.setPrice(billItmDto.getPrice());
			blCgIpDO.setPrice_ratio(billItmDto.getPrice_ratio());
			blCgIpDO.setQuan(billItmDto.getQuan());
			blCgIpDO.setAmt(billItmDto.getAmt());
			blCgIpDO.setAmt_ratio(billItmDto.getAmt_ratio());
			blCgIpDO.setAmt_hp(new FDouble(0.00));
			blCgIpDO.setAmt_pat(new FDouble(0.00));
			if (billItmDto.getRatio_pripat() != null) {
				blCgIpDO.setRatio_pripat(billItmDto.getRatio_pripat());
			} else {
				blCgIpDO.setRatio_pripat(new FDouble(1));
			}
			blCgIpDO.setAmt_std(billItmDto.getAmt_std());
			IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
			PatiVisitDO patiVisitDO = service.findById(billItmDto.getId_ent());
			if (billItmDto.getId_org_or() != null) {
				blCgIpDO.setId_org_or(billItmDto.getId_org_or());
			} else {
				blCgIpDO.setId_org_or(Context.get().getOrgId());
			}

			if (billItmDto.getId_dep_or() != null) {
				blCgIpDO.setId_dep_or(billItmDto.getId_dep_or());
			} else {
				blCgIpDO.setId_dep_or(patiVisitDO.getId_dep_phy());
			}

			if (billItmDto.getId_emp_or() != null) {
				blCgIpDO.setId_emp_or(billItmDto.getId_emp_or());
				;
			} else {
				//TODO 这里不可取，即使校验环节校验非空，也不能再次获取患者就诊信息 。。2017-09-22 yangyang 重构过程中发现，以此记录
				blCgIpDO.setId_emp_or(patiVisitDO.getId_emp_phy());
			}

			if (billItmDto.getDt_or() != null) {
				blCgIpDO.setDt_or(billItmDto.getDt_or());
			} else {
				blCgIpDO.setDt_or(AppUtils.getServerDateTime());
			}

			if (billItmDto.getInpBillDTO() != null && billItmDto.getInpBillDTO().getId_wg_or() != null) {
				blCgIpDO.setId_wg_or(billItmDto.getInpBillDTO().getId_wg_or());// 医疗组
			} else {
				blCgIpDO.setId_wg_or(patiVisitDO.getId_wg_phy());
			}

			if (billItmDto.getInpBillDTO() != null && billItmDto.getInpBillDTO().getId_dep_nur() != null) {
				blCgIpDO.setId_dep_nur(billItmDto.getInpBillDTO().getId_dep_nur());// 病区
			} else {
				blCgIpDO.setId_dep_nur(patiVisitDO.getId_dep_nur());
			}
			blCgIpDO.setId_org_mp(billItmDto.getId_org_mp());
			blCgIpDO.setId_dep_mp(billItmDto.getId_dep_mp());
			if (billItmDto.getId_dep_wh() != null) {
				blCgIpDO.setId_dep_wh(billItmDto.getId_dep_wh());
			} else {
				blCgIpDO.setId_dep_wh(patiVisitDO.getId_dep_phy());
			}
			if (null != billItmDto.getDt_srv()) // 服务发生时间
			{
				blCgIpDO.setDt_srv(billItmDto.getDt_srv());
			} else {
				blCgIpDO.setDt_srv(AppUtils.getServerDateTime());
			}
			blCgIpDO.setId_pripat(billItmDto.getId_pripat());
			blCgIpDO.setId_hp(billItmDto.getId_hp());
			blCgIpDO.setRatio_hp(billItmDto.getRatio_hp());
			 if(billItmDto.getInpBillDTO()==null)
			 {
				 blCgIpDO.setFg_bb(FBoolean.FALSE);
				 blCgIpDO.setNo_bb(null);
				 blCgIpDO.setId_ent_mom("~");
			 }
			 else
			 {
				 //婴儿计费时，写入母亲的就诊id
				 blCgIpDO.setId_ent_mom(billItmDto.getInpBillDTO().getId_ent_mom());
				 blCgIpDO.setFg_bb(billItmDto.getInpBillDTO().getFg_bb());
				 blCgIpDO.setNo_bb(billItmDto.getInpBillDTO().getNo_bb());
			 }
			blCgIpDO.setFg_mm(billItmDto.getFg_mm());
			blCgIpDO.setId_mm(billItmDto.getId_mm());
			blCgIpDO.setId_mmtp(billItmDto.getId_mmtp());
			blCgIpDO.setSd_mmtp(billItmDto.getSd_mmtp());
			blCgIpDO.setCode_mm(billItmDto.getCode_mm());
			blCgIpDO.setOnlycode(billItmDto.getOnlycode());
			blCgIpDO.setName_mm(billItmDto.getName_mm());
			blCgIpDO.setCd_batch(billItmDto.getCd_batch());
			blCgIpDO.setPgku_base(billItmDto.getPgku_base());
			blCgIpDO.setPgku_cur(billItmDto.getPgku_cur());
			blCgIpDO.setFactor(billItmDto.getFactor());
			blCgIpDO.setQuan_base(billItmDto.getQuan_base());
			blCgIpDO.setId_or(billItmDto.getId_or());
			blCgIpDO.setId_orsrv(billItmDto.getId_orsrv());
			blCgIpDO.setId_or_pr(billItmDto.getId_or_pr());
			blCgIpDO.setId_or_pr_srv(billItmDto.getId_or_pr_srv());
			blCgIpDO.setId_pres(billItmDto.getId_pres());

			if (billItmDto.getInpBillDTO() == null) {
				blCgIpDO.setFg_pddisc(FBoolean.FALSE);
			} else {
				blCgIpDO.setFg_pddisc(billItmDto.getInpBillDTO().getFg_pddisc());
			}
			blCgIpDO.setFg_st(FBoolean.FALSE);
			blCgIpDO.setId_stip(null);
			blCgIpDO.setDt_st(null);
			if (billItmDto.getFg_hp() == null || ("").equals(String.valueOf(billItmDto.getFg_hp()).trim())) {
				blCgIpDO.setFg_hp(FBoolean.FALSE);
			} else {
				blCgIpDO.setFg_hp(billItmDto.getFg_hp());
			}
			blCgIpDO.setFg_susp(FBoolean.FALSE);
			blCgIpDO.setId_par(null);
			blCgIpDO.setCode_cg(null);
			blCgIpDO.setId_org_cg(Context.get().getOrgId());
			blCgIpDO.setId_dep_cg(billItmDto.getId_dep_cg());
			blCgIpDO.setId_emp_cg(billItmDto.getId_emp_cg());
			blCgIpDO.setDt_cg(AppUtils.getServerDateTime());
			if (null == billItmDto.getEu_srctp()) {
				blCgIpDO.setEu_srctp(FeeOriginEnum.ORDERS_FEE);// 医嘱产生
			} else {
				blCgIpDO.setEu_srctp(billItmDto.getEu_srctp());// 医嘱产生
			}
			blCgIpDO.setNote(null);
			blCgIpDO.setSrcfunc_des(billItmDto.getSrcfunc_des());
			blCgIpDO.setSpec(billItmDto.getSpec());
			blCgIpDO.setFg_refund(billItmDto.getFg_refund());// 已退款标志
			blCgIpDO.setId_par(billItmDto.getId_par());// 退费关联记账主键
			blCgIpDO.setStatus(DOStatus.NEW);
			cgIpDoLst.add(blCgIpDO);
		}
		return cgIpDoLst.toArray(new BlCgIpDO[] {});
	}

	/**
	 * 住院记账表BlCgIp中信息转化成 List<BlOrderAppendBillParamDTO>
	 * 
	 * @param blcgoepAggDOs
	 * @return
	 */
	private List<IpCompensateBillDTO> mapperToBillItmDtoArr(BlCgIpDO[] blCgIpDOArr) {
		List<IpCompensateBillDTO> chargedBillItmDtoArr = new ArrayList<IpCompensateBillDTO>();
		for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
			IpCompensateBillDTO billItmDto = new IpCompensateBillDTO();
			billItmDto.setId_cg(blCgIpDO.getId_cgip());
			billItmDto.setId_or(blCgIpDO.getId_or());
			billItmDto.setId_orsrv(blCgIpDO.getId_orsrv());
			billItmDto.setId_pat(blCgIpDO.getId_pat());
			billItmDto.setId_ent(blCgIpDO.getId_ent());
			billItmDto.setId_mm(blCgIpDO.getId_mm());
			billItmDto.setId_enttp(blCgIpDO.getId_enttp());
			billItmDto.setCode_enttp(blCgIpDO.getCode_enttp());

			billItmDto.setName_srv(blCgIpDO.getName_srv());
			billItmDto.setId_srv(blCgIpDO.getId_srv());
			billItmDto.setCode_srv(blCgIpDO.getCode_srv());
			billItmDto.setAmt_std(blCgIpDO.getAmt_std());
			billItmDto.setPrice(blCgIpDO.getPrice());
			billItmDto.setQuan(blCgIpDO.getQuan());
			billItmDto.setSrvu(blCgIpDO.getSrvu());

			billItmDto.setId_or_pr(blCgIpDO.getId_or_pr());
			billItmDto.setId_or_pr_srv(blCgIpDO.getId_or_pr_srv());

			chargedBillItmDtoArr.add(billItmDto);
		}
		return chargedBillItmDtoArr;
	}

	private List<BlOrderAppendBillParamDTO> assemblyBlorderAppendParamDtoLst(IpCompensateBillDTO[] compensateBillDtoArr) throws BizException
	{
		List<BlOrderAppendBillParamDTO> billParamDtoLst=new ArrayList<BlOrderAppendBillParamDTO>();
		for(IpCompensateBillDTO billDto:compensateBillDtoArr)
		{
			BlOrderAppendBillParamDTO billItmDto=new BlOrderAppendBillParamDTO();
			billItmDto.setId_org(Context.get().getOrgId());
			billItmDto.setId_grp(Context.get().getGroupId());
			billItmDto.setId_pat(billDto.getId_pat());
			billItmDto.setId_ent(billDto.getId_ent());
			billItmDto.setId_enttp(billDto.getId_enttp());
			billItmDto.setCode_enttp(billDto.getCode_enttp());
			billItmDto.setId_or(billDto.getId_or());
			billItmDto.setId_orsrv(billDto.getId_orsrv());
			billItmDto.setQuan(billDto.getQuan());
			billItmDto.setId_srvtp(billDto.getId_srvtp());
			billItmDto.setSd_srvtp(billDto.getSd_srvtp());
			billItmDto.setId_srvca(billDto.getId_srvca());
			billItmDto.setId_srv(billDto.getId_srv());
			billItmDto.setCode_srv(billDto.getCode_srv());
			billItmDto.setName_srv(billDto.getName_srv());
			billItmDto.setSrvu(billDto.getSrvu());
			billItmDto.setEu_direct(billDto.getEu_direct());
			billItmDto.setPrice(billDto.getPrice());
			billItmDto.setAmt_std(billDto.getAmt_std());
			billItmDto.setAmt_pat(billDto.getAmt_ratio());
			billItmDto.setAmt(billDto.getAmt_ratio());
			billItmDto.setAmt_ratio(billDto.getAmt_ratio());
			billItmDto.setAmt_hp(new FDouble(0));
			billItmDto.setId_dep_or(billDto.getId_dep_or());
			billItmDto.setId_emp_or(billDto.getId_emp_or());
			billItmDto.setId_dep_mp(billDto.getId_dep_mp());//库房
			billItmDto.setId_dep_wh(billDto.getId_dep_wh());
			billItmDto.setId_emp_cg(billDto.getId_emp_cg());
			billItmDto.setId_dep_cg(billDto.getId_dep_cg());
			billItmDto.setFg_mm(billDto.getFg_mm());
			billItmDto.setId_mm(billDto.getId_mm());
			billItmDto.setId_mmtp(billDto.getId_mmtp());
			billItmDto.setCode_mm(billDto.getCode_mm());
			billItmDto.setName_mm(billDto.getName_mm());
			billItmDto.setPgku_base(billDto.getPgku_base());
			billItmDto.setPgku_cur(billDto.getPgku_cur());
			billItmDto.setFactor(billDto.getFactor());
			billItmDto.setId_org_cg(Context.get().getOrgId());
			
			billItmDto.setSpec(billDto.getSpec());
			billItmDto.setSupportAppendBill(billDto.getSupportappendbill());

			billItmDto.setId_srv(billDto.getId_srv());
			billItmDto.setCode_srv(billDto.getCode_srv());
			billItmDto.setDt_or(billDto.getDt_or());
			billItmDto.setId_or_pr_srv(billDto.getId_or_pr_srv());
			billItmDto.setId_or_pr(billDto.getId_or_pr());
			
			billItmDto.setSrcfunc_des(billDto.getSrcfunc_des());

			billItmDto.setId_pripat(billDto.getId_pripat());
			billItmDto.setRatio_pripat(FDouble.ONE_DBL);

			BlOrderAppendInpBillParamDTO ipParam = new BlOrderAppendInpBillParamDTO();
			ipParam.setFg_bb(FBoolean.FALSE);
			ipParam.setId_dep_nur(billDto.getId_dep_nur());
			billItmDto.setInpBillDTO(ipParam);
			billParamDtoLst.add(billItmDto);
		}
		return billParamDtoLst;
	}
}

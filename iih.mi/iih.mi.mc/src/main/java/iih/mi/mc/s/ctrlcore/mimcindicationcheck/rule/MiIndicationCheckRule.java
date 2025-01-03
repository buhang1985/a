package iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.bdhpsrvctrds.d.BdHpSrvCtrDsDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import iih.bd.pp.i.IBdHpQryService;
import iih.bd.pp.mpayratiodf.d.MPayRatioDfDO;
import iih.bd.pp.service.i.IPpQueService;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.mi.constant.IMiMcCheckConst;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.mimcindicationrule.d.EuMiJudgeType;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationInParamDTO;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationOutParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcDiDefDTO;
import iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule.bp.GetMiCtrlDiBP;
import iih.mi.mc.s.ctrlcore.mimcindicationcheck.rule.bp.GetMiCtrlDsBP;
import iih.mi.mc.s.ctrlcore.rule.MiMcCheckRule;
import iih.mi.mc.s.util.MiBaseInfoUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保适应症校验
 * 
 * @author LIM
 * @since 2019-09-27
 */
public class MiIndicationCheckRule extends MiMcCheckRule {
	/**
	 * 医保适应症校验
	 * 
	 * @param inparam
	 * @return
	 * @throws BizException
	 */
	public MiMcIndicationOutParamDTO[] exec(MiMcIndicationInParamDTO[] inparam) throws BizException {
		List<MiMcIndicationOutParamDTO> indRstList = new ArrayList<MiMcIndicationOutParamDTO>();
		// 参数校验
		if (ArrayUtil.isEmpty(inparam)) {
			return indRstList.toArray(new MiMcIndicationOutParamDTO[0]);
		}

		// 1.根据服务、物品进行分组
		String hpId = inparam[0].getId_hp();// 当前只支持一个医保计划
		List<String> srvIdList = new ArrayList<String>();
		List<String> srvAllIdList = new ArrayList<String>();
		List<String> mmIdList = new ArrayList<String>();
		List<String> idList = new ArrayList<String>(); //
		for (MiMcIndicationInParamDTO bdHpIndicationDTO : inparam) {
			if (StringUtil.isEmptyWithTrim(bdHpIndicationDTO.getId_mm())) {
				srvIdList.add(bdHpIndicationDTO.getId_srv());// 非物品
			} else {
				mmIdList.add(bdHpIndicationDTO.getId_mm());
			}
			srvAllIdList.add(bdHpIndicationDTO.getId_srv());
			idList.add(bdHpIndicationDTO.getId_srv() + bdHpIndicationDTO.getId_mm());
		}
		// 2.获取医保规则所对应策略
		HashMap<String, String> ruleMap = this.getCheckRule(hpId, inparam[0].getCode_entp(), IMiMcCheckConst.ID_MIMC_TACTICS_INDICATION);
		if (ruleMap == null || !ruleMap.containsKey(IMiMcCheckConst.ID_MIMC_TACTICS_INDICATION_DIINDICATION)) {
			return indRstList.toArray(new MiMcIndicationOutParamDTO[0]);
		}
		// 3.批量获取医保对照数据
		Map<String, List<HPSrvorcaDO>> srvMap = this.getHpSrvorcaListBySrvId(hpId, srvIdList);// 服务对照
		Map<String, List<HPSrvorcaDO>> mmMap = this.getHpSrvorcaListByMmId(hpId, mmIdList); // 药品对照
		// 4.获取限制诊断数据
		Map<String, List<BdHpSrvCtrDiDO>> diCtrMap = null;
		// 5.获取限制病种数据
		Map<String, List<BdHpSrvCtrDsDO>> dsCtrMap = null;
		// 6.获取医生站开单模式
		//病种模式属于诊断模式下的一个分支，因此适应症判断不再判断病种模式 by lim 2020-04-18
		int orderMode =1;// MiParamUtil.MHIR0001();// 0：采用病种模式；1:诊断模式
		if (orderMode == 0) {
			GetMiCtrlDsBP dsBP = new GetMiCtrlDsBP();
			dsCtrMap = dsBP.exec(hpId, idList);
		} else {
			GetMiCtrlDiBP diBP = new GetMiCtrlDiBP();
			diCtrMap = diBP.exec(hpId, srvAllIdList);
		}
		// 7.规则验证
		FBoolean isAllInHp = MiBaseInfoUtil.getPatAllhp(inparam[0].getId_ent());
		List<HPSrvorcaDO> hpsrvList = null;
		for (MiMcIndicationInParamDTO hpIndParam : inparam) {
			if (hpIndParam == null)
				continue;
			hpsrvList = null;
			if (StringUtil.isEmptyWithTrim(hpIndParam.getId_mm())) {
				if (srvMap != null) {
					hpsrvList = srvMap.get(hpIndParam.getId_srv());
				}
			} else if (mmMap != null) {
				hpsrvList = mmMap.get(hpIndParam.getId_mm());
			}

			MiMcIndicationOutParamDTO indRst = this.checkHpIndication(hpId, hpIndParam, hpsrvList, diCtrMap, dsCtrMap, isAllInHp, orderMode);
			indRstList.add(indRst);
		}
		return indRstList.toArray(new MiMcIndicationOutParamDTO[0]);
	}

	/**
	 * 获取医保对照项目集合
	 * 
	 * @param srvIdList
	 *            服务ID集合
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<HPSrvorcaDO>> getHpSrvorcaListBySrvId(String hpId, List<String> srvIdList) throws BizException {
		if (StringUtil.isEmpty(hpId) || ListUtil.isEmpty(srvIdList)) {
			return null;
		}
		IPpQueService ppQueService = ServiceFinder.find(IPpQueService.class);
		HPSrvorcaDO[] hpSrvorcaDOs = ppQueService.getHPSrvorcaDOByIdsrvIdHP(hpId, srvIdList.toArray(new String[0]));
		if (ArrayUtil.isEmpty(hpSrvorcaDOs)) {
			return null;
		}

		Map<String, List<HPSrvorcaDO>> srvMap = new HashMap<String, List<HPSrvorcaDO>>();
		for (HPSrvorcaDO srv : hpSrvorcaDOs) {
			List<HPSrvorcaDO> srvRelList = srvMap.get(srv.getId_srv());
			if (srvRelList == null) {
				srvRelList = new ArrayList<HPSrvorcaDO>();
				srvMap.put(srv.getId_srv(), srvRelList);
			}
			srvRelList.add(srv);
		}
		return srvMap;
	}

	/**
	 * 获取医保对照项目集合
	 * 
	 * @param mmIdList
	 *            物品ID集合
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<HPSrvorcaDO>> getHpSrvorcaListByMmId(String hpId, List<String> mmIdList) throws BizException {
		if (StringUtil.isEmpty(hpId) || ListUtil.isEmpty(mmIdList)) {
			return null;
		}
		IPpQueService ppQueService = ServiceFinder.find(IPpQueService.class);
		HPSrvorcaDO[] hpSrvorcaDOs = ppQueService.getHPSrvorcaDOByIdmmIdHP(hpId, mmIdList.toArray(new String[0]));
		if (ArrayUtil.isEmpty(hpSrvorcaDOs)) {
			return null;
		}

		Map<String, List<HPSrvorcaDO>> mmMap = new HashMap<String, List<HPSrvorcaDO>>();
		for (HPSrvorcaDO srv : hpSrvorcaDOs) {
			List<HPSrvorcaDO> srvRelList = mmMap.get(srv.getId_mm());
			if (srvRelList == null) {
				srvRelList = new ArrayList<HPSrvorcaDO>();
				mmMap.put(srv.getId_mm(), srvRelList);
			}
			srvRelList.add(srv);
		}
		return mmMap;
	}

	/**
	 * 检查医保适应症
	 * 
	 * @param hpId
	 *            医保ID
	 * @param hpsrvList
	 *            医保对照服务集合（含服务、药品）
	 * @param hpIndParam
	 *            医保适应症参数
	 * @param diCtrMap
	 *            诊断控制集合
	 * @param dsCtrMap
	 *            病种控制集合
	 * @param isAllInHp
	 *            是否全保内
	 * @param orderMode
	 *            医生站医生开单模式
	 * @return
	 */
	private MiMcIndicationOutParamDTO checkHpIndication(String hpId, MiMcIndicationInParamDTO hpIndParam, List<HPSrvorcaDO> hpsrvList, Map<String, List<BdHpSrvCtrDiDO>> diCtrMap,
			Map<String, List<BdHpSrvCtrDsDO>> dsCtrMap, FBoolean isAllInHp, Integer orderMode) throws BizException {
		MiMcIndicationOutParamDTO indRst = this.convertMiMcIndicationOutParamDTO(hpIndParam);
		// 诊断限制list
		FArrayList hpSrvCtrDiList = new FArrayList();
		// 病种限制list
		FArrayList hpSrvCtrDsList = new FArrayList();
		if (ListUtil.isEmpty(hpsrvList)) {
			if (isAllInHp.booleanValue()) {
				this.setHpIndication(indRst, FBoolean.TRUE, "", "不在医保目录对照表中", IBdPpCodeTypeConst.SD_HP_BJ_THREE, IBdPpCodeTypeConst.ID_HP_BJ_THREE, HpIndicationRuleEnum.NO_CONTROL, hpSrvCtrDiList,
						hpSrvCtrDsList, "不在医保目录对照表中");
				return indRst;
			}
			// 保外
			this.setHpIndication(indRst, FBoolean.FALSE, null, "不在医保目录对照表中", IBdPpCodeTypeConst.SD_HP_BJ_THREE, IBdPpCodeTypeConst.ID_HP_BJ_THREE, HpIndicationRuleEnum.NO_CONTROL, hpSrvCtrDiList,
					hpSrvCtrDsList, "不在医保目录对照表中");
		} else {
			HPSrvorcaDO hpsrv = hpsrvList.get(0);
			if (orderMode == 0) {
				hpSrvCtrDsList = this.getDsConvertStr(hpsrv.getId_srv(), hpsrv.getId_mm(), dsCtrMap);
			} else {
				hpSrvCtrDiList = this.getDiConvertStr(hpsrv.getId_srv(), hpsrv.getId_mm(), diCtrMap);
			}
			String des_dilimit = "";
			// 判断如果全保内 直接返回保内
			if (isAllInHp.booleanValue()) {
				this.setHpIndication(indRst, FBoolean.TRUE, hpsrv.getHis_des(), hpsrv.getDes(), hpsrv.getSd_hpsrvtp(), hpsrv.getId_hpsrvtp(), HpIndicationRuleEnum.NO_CONTROL, hpSrvCtrDiList,
						hpSrvCtrDsList, des_dilimit);
				return indRst;
			}

			if (IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(hpsrv.getSd_hpsrvtp())) {
				// 丙级不控制
				this.setHpIndication(indRst, FBoolean.FALSE, hpsrv.getHis_des(), hpsrv.getDes(), hpsrv.getSd_hpsrvtp(), hpsrv.getId_hpsrvtp(), HpIndicationRuleEnum.NO_CONTROL, hpSrvCtrDiList,
						hpSrvCtrDsList, "收费等级为丙类");
			} else {
				if (StringUtil.isEmpty(hpsrv.getEu_hpsrvctrtp())) {
					this.setHpIndication(indRst, FBoolean.TRUE, hpsrv, hpSrvCtrDiList, hpSrvCtrDsList, des_dilimit);
				} else {
					switch (hpsrv.getEu_hpsrvctrtp()) {
					case HpIndicationRuleEnum.NO_CONTROL:// 不控制
						this.setHpIndication(indRst, FBoolean.TRUE, hpsrv, hpSrvCtrDiList, hpSrvCtrDsList, des_dilimit);
						break;
					case HpIndicationRuleEnum.DOC_CONFIRM:// 医生判断及确认
						this.setHpIndication(indRst, null, hpsrv, hpSrvCtrDiList, hpSrvCtrDsList, des_dilimit);
						// 暂时先不处理多比例
						// this.loadSrvMPayRatio(hpIndParam.getId_hp(),indRst);//
						// 加载多支付比例
						break;
//					case HpIndicationRuleEnum.SYS_CONFIRM:
//						boolean chk = false;
//						if (orderMode == 0) {
//							chk = this.checkDs(hpIndParam.getId_dsdef(), hpSrvCtrDsList);
//							if (!chk) {
//								des_dilimit = "患者目前病种与适应症不符，需自费处理！";
//							}
//						} else {
//							chk = this.checkDi(hpIndParam, hpsrv.getId_mm(), hpsrv.getId_srv(), diCtrMap);
//							if (!chk) {
//								des_dilimit = "患者目前诊断与适应症不符，需自费处理！";
//							}
//						}
//						this.setHpIndication(indRst, new FBoolean(chk), hpsrv, hpSrvCtrDiList, hpSrvCtrDsList, des_dilimit);
//						break;
					case HpIndicationRuleEnum.SYS_JUD_DOCCONFIRM:
						// 系统判断和系统判断医生确认，需要进行系统规则校验
						boolean chkRst = false;
						if (orderMode == 0) {
							chkRst = this.checkDs(hpIndParam.getId_dsdef(), hpSrvCtrDsList);
							if (!chkRst) {
								des_dilimit = "患者目前病种与适应症不符，需自费处理！";
							}
						} else {
							chkRst = this.checkDi(hpIndParam, hpsrv.getId_mm(), hpsrv.getId_srv(), diCtrMap);
							if (!chkRst) {
								des_dilimit = "患者目前诊断与适应症不符，请医生判断处理！";
							}
						}
						this.setHpIndication(indRst, new FBoolean(chkRst), hpsrv, hpSrvCtrDiList, hpSrvCtrDsList, des_dilimit);
						break;
					}
				}
			}
		}
		return indRst;
	}

	/**
	 * 校验诊断控制
	 * 
	 * @param hpIndctDTO
	 *            医保校验DTO
	 * @param hpSrvCode
	 *            医保服务编码
	 * @param diCtrMap
	 *            诊断控制map
	 * @return
	 */
	private boolean checkDi(MiMcIndicationInParamDTO hpIndParam, String mmId, String srvId, Map<String, List<BdHpSrvCtrDiDO>> diCtrMap) {
		if (diCtrMap == null || diCtrMap.size() <= 0 || !diCtrMap.containsKey(srvId)) {
			return true;
		}
		// 1、获取当前开立诊断
		FArrayList diList = hpIndParam.getCi_di_itms();
		List<String> diIdList = new ArrayList<String>();
		for (Object itm : diList) {
			MiMcDiDefDTO diItm = (MiMcDiDefDTO) itm;
			if (diItm != null) {
				diIdList.add(diItm.getId_didef());
			}
		}

		// 2、检查是否符合诊断控制
		boolean hasDi = false;
		List<BdHpSrvCtrDiDO> ctrDiList = diCtrMap.get(srvId);
		for (BdHpSrvCtrDiDO ctrDi : ctrDiList) {
			if ((!StringUtil.isEmpty(mmId) && !mmId.equals(ctrDi.getId_mm())) && !StringUtil.isEmpty(srvId) && !srvId.equals(ctrDi.getId_srv()))
				continue;

			if (StringUtil.isEmpty(ctrDi.getId_di_def())) {
				hasDi = true;// 如果控制诊断为空，则校验通过
			} else if (diIdList.contains(ctrDi.getId_di_def())) {
				hasDi = true;// 如果此次诊断包含控制诊断，则校验通过
			}
		}

		return hasDi;
	}

	/**
	 * 校验病种控制
	 * 
	 * @param id_dsdef
	 * @param dsCtrList
	 * @return
	 */
	private boolean checkDs(String id_dsdef, FArrayList dsCtrList) {
		if ((dsCtrList == null || dsCtrList.size() <= 0) || StringUtil.isEmpty(id_dsdef)) {
			return false;
		}
		// 2、检查是否符合病种控制
		boolean hasDs = false;
		for (Object ctrDs : dsCtrList) {
			BdHpSrvCtrDsDO dsDo = (BdHpSrvCtrDsDO) ctrDs;
			if (!StringUtil.isEmpty(dsDo.getId_dsdef()) && id_dsdef.equals(dsDo.getId_dsdef())) {
				hasDs = true;// 如果控制诊断为空，则校验通过
				break;
			}
		}
		return hasDs;
	}

	/**
	 * 加载多支付比例
	 * 
	 * @param indRst
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void loadSrvMPayRatio(String id_hp, MiMcIndicationOutParamDTO hpOutParam) throws BizException {
		boolean isMm = this.isMm(hpOutParam);
		String srvId = isMm ? hpOutParam.getId_mm() : hpOutParam.getId_srv();
		IBdHpQryService hpQryService = ServiceFinder.find(IBdHpQryService.class);
		MPayRatioDfDO[] ratios = hpQryService.getSrvPayRatioList(id_hp, srvId, new FBoolean(isMm));
		if (!ArrayUtil.isEmpty(ratios)) {
			FArrayList mutiPayRatioList = new FArrayList();
			for (MPayRatioDfDO ratio : ratios) {
				mutiPayRatioList.add(ratio);
			}
			hpOutParam.setMutipayratiolist(mutiPayRatioList);
		}
	}

	/**
	 * 是否为物品
	 * 
	 * @param indctDTO
	 * @return
	 */
	private boolean isMm(MiMcIndicationOutParamDTO hpIndParam) {
		return !StringUtil.isEmptyWithTrim(hpIndParam.getId_mm());
	}

	/**
	 * 将入参部分值赋值给出参
	 * 
	 * @param hpIndParam
	 *            入参
	 * @return
	 */
	private MiMcIndicationOutParamDTO convertMiMcIndicationOutParamDTO(MiMcIndicationInParamDTO hpIndParam) {
		MiMcIndicationOutParamDTO outParamDTO = new MiMcIndicationOutParamDTO();
		outParamDTO.setId_or(hpIndParam.getId_or());
		outParamDTO.setCode_or(hpIndParam.getCode_or());
		outParamDTO.setName_or(hpIndParam.getName_or());
		outParamDTO.setId_orsrv(hpIndParam.getId_orsrv());
		outParamDTO.setId_srv(hpIndParam.getId_srv());
		outParamDTO.setCode_srv(hpIndParam.getCode_or());
		outParamDTO.setName_srv(hpIndParam.getName_srv());
		outParamDTO.setSd_srvtp(hpIndParam.getSd_srvtp());
		outParamDTO.setId_mm(hpIndParam.getId_mm());
		outParamDTO.setCode_mm(hpIndParam.getCode_mm());
		outParamDTO.setName_mm(hpIndParam.getName_mm());
		outParamDTO.setPrice(hpIndParam.getPrice());
		outParamDTO.setFg_allowdedit(hpIndParam.getFg_allowdedit());
		if (!StringUtil.isEmpty(hpIndParam.getEu_orsrvhp())) {
			switch (hpIndParam.getEu_orsrvhp()) {
			case EuMiJudgeType.HP:
				outParamDTO.setFg_srv_self(FBoolean.FALSE);
				outParamDTO.setFg_srv_hp(FBoolean.TRUE);
				break;
			case EuMiJudgeType.SELF:
				outParamDTO.setFg_srv_self(FBoolean.TRUE);
				outParamDTO.setFg_srv_hp(FBoolean.FALSE);
			}
		}
		return outParamDTO;
	}

	/**
	 * 返回诊断限制list
	 * 
	 * @author LIM
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getDiConvertStr(String srvId, String mmId, Map<String, List<BdHpSrvCtrDiDO>> diCtrMap) {
		FArrayList diList = new FArrayList();
		if (diCtrMap == null || diCtrMap.isEmpty())
			return diList;
		List<BdHpSrvCtrDiDO> ctrDiList = new ArrayList<BdHpSrvCtrDiDO>();
		ctrDiList = diCtrMap.get(srvId);
		if (!ListUtil.isEmpty(ctrDiList)) {
			for (BdHpSrvCtrDiDO ctrDi : ctrDiList) {
				if (!StringUtil.isEmpty(ctrDi.getDi_def_code()) && !StringUtil.isEmpty(ctrDi.getDi_def_name())) {
					diList.add(ctrDi);
				}
			}
		}
		return diList;
	}

	/**
	 * 返回病种限制list
	 * 
	 * @author LIM
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getDsConvertStr(String srvId, String mmId, Map<String, List<BdHpSrvCtrDsDO>> dsCtrMap) {
		FArrayList diList = new FArrayList();
		if (dsCtrMap == null || dsCtrMap.isEmpty())
			return diList;
		List<BdHpSrvCtrDsDO> ctrDsList = new ArrayList<BdHpSrvCtrDsDO>();
		ctrDsList = dsCtrMap.get(srvId + mmId);
		if (!ListUtil.isEmpty(ctrDsList)) {
			for (BdHpSrvCtrDsDO ctrDs : ctrDsList) {
				if (!StringUtil.isEmpty(ctrDs.getDsdef_code()) && !StringUtil.isEmpty(ctrDs.getDsdef_name())) {
					diList.add(ctrDs);
				}
			}
		}
		return diList;
	}

	/**
	 * 设置医保校验结果
	 * 
	 * @param bdHpIndicationDTO
	 * @param result
	 * @param hpsrv
	 */
	private void setHpIndication(MiMcIndicationOutParamDTO outParamDTO, FBoolean result, HPSrvorcaDO hpsrv, FArrayList hpSrvCtrDiList, FArrayList hpSrvCtrDsList, String des_dilimit) {
		this.setHpIndication(outParamDTO, result, hpsrv.getHis_des(), hpsrv.getDes(), hpsrv.getSd_hpsrvtp(), hpsrv.getId_hpsrvtp(), hpsrv.getEu_hpsrvctrtp(), hpSrvCtrDiList, hpSrvCtrDsList,
				des_dilimit);
	}

	/**
	 * 设置适应症信息
	 * 
	 * @param outParamDTO
	 *            适应症DTO
	 * @param fgIndic
	 *            系统判断结果
	 * @param hisLimitDes
	 *            医院限制条件
	 * @param hpLimitDes
	 *            医保限制条件
	 * @param hpsrvtpCode
	 *            医保目录类型编码
	 * @param hpsrvtpId
	 *            医保目录类型ID
	 * @param indicJugedCode
	 *            判断方式
	 * @param hpSrvCtrDiList
	 *            医保限定诊断集合
	 * @param des_hisdilimit
	 *            诊断(病种)限制描述
	 * @param des_hisdslimit
	 *            病种限制描述
	 */
	private void setHpIndication(MiMcIndicationOutParamDTO outParamDTO, FBoolean fgIndic, String hisLimitDes, String hpLimitDes, String hpsrvtpCode, String hpsrvtpId, String indicJugedCode,
			FArrayList hpSrvCtrDiList, FArrayList hpSrvCtrDsList, String des_hislimit) {
		outParamDTO.setFg_checkflag(fgIndic);// 保外,系统判断结果
		outParamDTO.setDes_hislimit(hisLimitDes);// 医院限制条件
		outParamDTO.setDes_hplimit(hpLimitDes); // 医保限制条件
		outParamDTO.setSd_hpsrvtp(hpsrvtpCode);// 来源于自定义档案
		outParamDTO.setId_hpsrvtp(hpsrvtpId);
		outParamDTO.setCode_hpindicjudged(indicJugedCode);// 判断方式
		outParamDTO.setHpsrvctrdilist(hpSrvCtrDiList);// 医保限定诊断集合
		outParamDTO.setHpsrvctrdslist(hpSrvCtrDsList);// 医保限定病种集合
		outParamDTO.setEu_orsrvhp(this.getOrSrvHp(fgIndic));
		outParamDTO.setDes_limit(des_hislimit); // 限制描述
	}

	/**
	 * 为ci返回医保判断结果
	 * 
	 * @param fgIndic
	 * @return
	 */
	private String getOrSrvHp(FBoolean fgIndic) {
		if (fgIndic == null)
			return EuMiJudgeType.NOJUDGE;
		if (FBoolean.TRUE.equals(fgIndic)) {
			return EuMiJudgeType.HP;
		} else {
			return EuMiJudgeType.SELF;
		}
	}
}

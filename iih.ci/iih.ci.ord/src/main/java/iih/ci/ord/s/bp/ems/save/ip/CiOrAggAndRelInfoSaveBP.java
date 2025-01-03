package iih.ci.ord.s.bp.ems.save.ip;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.utils.ParamUtils;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciord.d.desc.OrSrvAgentInfoDODesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.hp.tl.HpService;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import iih.ci.ord.i.ICiOrdLogService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.external.obtain.ICiOrdBlRService;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.CiOrEventsSaveBP;
import iih.ci.ord.s.bp.CiOrderDOValidateBP;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.ci.ord.s.bp.ems.hp.CiOrHpInfoBP;
import iih.ci.ord.s.bp.ems.hp.NeusoftHpCheckedBP;
import iih.ci.ord.s.bp.ems.save.op.CiOrSkinTestRsPreSaveBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.CiEnContextUtils;
import iih.ci.ord.s.external.obtain.bp.bl.GetArrearageCheckBP;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.i.ISkintestRService;
import iih.hp.cp.docinfodto.d.CpOrderJudge;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/*
 * 临床医嘱及相关实体信息保存操作BP
 */
public class CiOrAggAndRelInfoSaveBP {

	/**
	 * 临床医嘱及相关实体信息保存
	 * 
	 * @param oraggandrelinfo
	 * @param iseventsave
	 * @param iemstp
	 * @return
	 * @throws BizException
	 */
	public CiorderAggDO exec(CiOrAggAndRelDatum oraggandrelinfo, boolean iseventsave, Integer iemstp)
			throws BizException {
		if (oraggandrelinfo == null || oraggandrelinfo.getOraggdo() == null)
			return null;
		// 保存之前的验证 执行科室
		String medicalinfo = null;
		CiorderAggDO[] ciorList = { oraggandrelinfo.getOraggdo() };
		CiOrderDOValidateBP bp = new CiOrderDOValidateBP();
		bp.ValidateDeptMp(ciorList);
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		//保存欠费校验
		GetArrearageCheckBP arrearageCheckBP = new GetArrearageCheckBP();
		arrearageCheckBP.saveCheckdArrearage(context,ciorList);
		// 铜陵去掉医保细则校验
		// 医保细规则TODO 待修改 10,40时保存返回提示
		/*
		 * if(CiOrdUtils.isHpUsing(context) ){ //医保的规则条件 HpDetailedRuleBP hpDetailedRule
		 * = new HpDetailedRuleBP(); String[] HPMessage =
		 * hpDetailedRule.getHpDetailedRule(oraggandrelinfo,context); // HPMessage = new
		 * String[2]; // HPMessage[0]="ceshi"; // HPMessage[1]="10"; if(HPMessage !=
		 * null && HPMessage.length >1){ // 40 已经废弃，10 单方限制 if(HPMessage[1] != null &&
		 * ("10".equals( HPMessage[1]) || "40".equals( HPMessage[1]))){
		 * ///oragginfo.getParentDO().setMdicalInfo(HPMessage[0].toString()); //return
		 * oragginfo.getParentDO(); medicalinfo = HPMessage[0].toString(); }else{ throw
		 * new BizException(HPMessage[0]); } } }
		 */

		// 判断是否临床路径患者
		String id_ent = oraggandrelinfo.getOraggdo().getParentDO().getId_en();
		if (CiOrdAppUtils.getIHpcpAppItfService().getEntIncpFlagExcludeWaitcp(id_ent)) {
			try {
				CiOrdAppUtils.getIHpcpAppItfService().checkCiorderSrv(id_ent, ciorList);
				transMMUncporToCiOrdEuUncpor(ciorList);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		/*
		 * int i = 0;
		 * 
		 * Ent4BannerDTO banner = context.getEnt4BannerDTO(); //高端商保判断是每条医嘱的金额 不能超过限制的
		 * 金额 if( banner != null &&
		 * (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
		 * banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) &&
		 * banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
		 * //高端商保标志·
		 * 
		 * String id_hp = "id_hp ='"+banner.getId_hp()+"'"; BdHpCtrDO[] hpctr =
		 * CiOrdAppUtils.getIBdHpCtrDORService().find(id_hp, "", FBoolean.FALSE);
		 * if(hpctr != null && hpctr.length >0){ BdHpCtrDO hpctrdo = hpctr[0];
		 * if(hpctrdo.getOr_limit_amt() !=null &&
		 * !hpctrdo.getOr_limit_amt().isTrimZero()){ FDouble sumprice =
		 * getSumPrice(oraggandrelinfo); if(Double.compare(sumprice.getDouble(),
		 * hpctrdo.getOr_limit_amt().getDouble()) >0){ throw new
		 * BizException("医嘱的金额超出限制 "+hpctrdo.getOr_limit_amt().getDouble()); } } }
		 * 
		 * }else if( banner != null && banner.getSd_hptp() != null &&
		 * banner.getSd_hptp().startsWith("1")){ //医保信息 改成 在签署时调用 2016-11-23
		 * //JudgeCiHpSave(oraggandrelinfo, diagList); //适应症 信息 是否启用医保标志
		 * if(CiOrdUtils.isHpUsing(context)){ FArrayList2 diagList =
		 * getDiagList(oraggandrelinfo.getOraggdo().getParentDO().getId_en());
		 * //setMedicalInsurance(oraggandrelinfo,diagList);
		 * HpMedicalInsurance.setMedicalInsurance(oraggandrelinfo, diagList); } }
		 * 
		 * if(medicalinfo != null &&
		 * banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
		 * banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET) ){
		 * setFg_selfPay(oraggandrelinfo.getOraggdo()); }
		 */

		// 如果是医保就诊获取服务对应的医保目录信息
		// if(CiOrdUtils.isHpUsing(context)){
		//
		// OrdSrvDO[] ordSrvs = oraggandrelinfo.getOraggdo().getOrdSrvDO();
		//
		// // 构造服务id与物品id集合，批量获取医保目录信息
		// Map<String,String> idSrvIdMmMap = new HashMap<String,String>();
		// for(OrdSrvDO ordSrv : ordSrvs){
		// idSrvIdMmMap.put(ordSrv.getId_srv(), ordSrv.getId_mm());
		// }
		//
		// // 调用医保目录接口获取结果，返回结果key值：如果有id_mm则id_srv和id_mm拼接结果，否则key值id_srv
		// ICiOrdBlRService ciOrdBlRService =
		// (ICiOrdBlRService)ServiceFinder.find(ICiOrdBlRService.class);
		// Map<String, HPSrvorcaDO> hpSrvorcaMap =
		// ciOrdBlRService.getHpSrvorcaByIdSrvs(context.getId_hp(),
		// idSrvIdMmMap);
		//
		// String tempKey = null;
		//
		// // 遍历服务项目，如果存在医保目录的设置医保计划目录类型
		// for(OrdSrvDO ordSrv : ordSrvs){
		//
		// tempKey = ordSrv.getId_srv() ;
		// if(StringUtils.isNotBlank(ordSrv.getId_mm())){
		// tempKey = ordSrv.getId_srv() + "," + ordSrv.getId_mm();
		// }
		//
		// // 不存在医保目录的设置为自费
		// if(!hpSrvorcaMap.containsKey(tempKey)){
		// if(ordSrv.getFg_bl() == FBoolean.TRUE){
		// ordSrv.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
		// ordSrv.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
		// }
		// ordSrv.setFg_selfpay(FBoolean.TRUE);
		// continue;
		// }
		// HPSrvorcaDO hpSrvorca = hpSrvorcaMap.get(tempKey);
		//
		//
		// ordSrv.setId_hpsrvtp(hpSrvorca.getId_hpsrvtp());
		// ordSrv.setSd_hpsrvtp(hpSrvorca.getSd_hpsrvtp());
		// ordSrv.setFg_selfpay(IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(hpSrvorca.getSd_hpsrvtp())
		// ? FBoolean.TRUE: FBoolean.FALSE);
		// //drug.setLimit(hpIndiccation.getDes_hplimit());
		// ordSrv.setId_hp(context.getId_hp());
		// ordSrv.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
		// }
		// }
		// 郑州保内和保外设置，通过医保目录进行赋值，甲类/乙类/丙类
		NeusoftHpCheckedBP neusoftHpCheckedBP = new NeusoftHpCheckedBP();
		List<CiOrAggAndRelDatum> aggAndRelDatums = new ArrayList<CiOrAggAndRelDatum>();
		aggAndRelDatums.add(oraggandrelinfo);
		neusoftHpCheckedBP.execChecked(context, aggAndRelDatums);
		// 设置医嘱表中的保内和保外标志（fg_orhp）,ci_or_srv中有一个是保内的，则医嘱为保内
		CiOrdUtils.SetFgOrHpOfCiOrder(new CiorderAggDO[] { oraggandrelinfo.getOraggdo() });
		// 设置医嘱开立的医生站类型
		if (ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(context.getStationType())) {
			oraggandrelinfo.getOraggdo().getParentDO().setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_MT);
			oraggandrelinfo.getOraggdo().getParentDO().setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);
		} else if (ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(context.getStationType())) {
			oraggandrelinfo.getOraggdo().getParentDO().setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_NUR);
			oraggandrelinfo.getOraggdo().getParentDO().setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_NUR);
		} else {
			oraggandrelinfo.getOraggdo().getParentDO().setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
			oraggandrelinfo.getOraggdo().getParentDO().setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
		}
		
		/*CiOrHpInfoBP ordHpInfo = new CiOrHpInfoBP();
		CiorderAggDO orderAgg = ordHpInfo.exec(context, oraggandrelinfo);
		CiOrderDO order = orderAgg.getParentDO();
		if(StringUtils.isNotEmpty(order.getMdicalinfo()) && order.getMdicalinfo().startsWith("Stop^")){
			return orderAgg;
		}*/
		// 医嘱保存
		CiorderAggDO aggdo = orAggDOSave(context, oraggandrelinfo);
		CiOrderDO order = aggdo.getParentDO();
		if(StringUtils.isNotEmpty(order.getMdicalinfo()) && order.getMdicalinfo().startsWith("Stop^")){
			return aggdo;
		}
		
		// 附属信息保存
		orAggAttachInfoSave(aggdo, oraggandrelinfo.getOrattachht(), iemstp);

		// 医嘱事件数据保存
		ciEventInfoSave(aggdo, iseventsave);
		if (medicalinfo != null && aggdo != null) {
			aggdo.getParentDO().setMdicalinfo(medicalinfo);
		}
		// 校验ci_or_srv中存在重复id_srv数据
		verifyOrSrvDuplication(aggdo);
		// 结果返回
		return aggdo;
	}
	/**
	 * 校验ci_or_srv中不必要的重复服务
	 * @param aggdo
	 */
	private void verifyOrSrvDuplication(CiorderAggDO aggdo) {
		if(aggdo == null){
			return;
		} 
		OrdSrvDO[] ordsrvs = aggdo.getOrdSrvDO();
		CiOrderDO ciOrderDO = aggdo.getParentDO();
		if(ordsrvs == null || ordsrvs.length == 0){
			return;
		}
		//0178355: 住院医生站-开立出院医嘱的时候，部分数据在ci_ord_srv表里会存在两条一样的记录
		if(ciOrderDO == null || StringUtils.isEmpty(ciOrderDO.getSd_srvtp()) || (!ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_LEAVEHOS)))
			return;
		List<String> idsrvs = new ArrayList<String>();
		for (OrdSrvDO ordsrv : ordsrvs) {
			if(idsrvs.contains(ordsrv.getId_srv())){
				//一个医嘱中存在相同服务了
				ICiOrdLogService log = ServiceFinder.find(ICiOrdLogService.class);
				String mString ="ci_or_srv中存在相同服务,医嘱："+aggdo.getParentDO().toString()+",服务："+ordsrv.toString();
				log.log(mString, Level.ERROR);
				try {
					throw new IOException(mString);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			idsrvs.add(ordsrv.getId_srv());
		}
	}

	// 草药单方自费
	private void setFg_selfPay(CiorderAggDO aggdo) {
		if (aggdo != null && aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length > 0) {
			for (OrdSrvDO srvdo : aggdo.getOrdSrvDO()) {
				srvdo.setFg_selfpay(FBoolean.TRUE);
			}
		}
	}

	/**
	 * 每条医嘱的总金额
	 * 
	 * @param aggdo
	 * @return
	 */
	private FDouble getSumPrice(CiOrAggAndRelDatum orAggAndRelDatum) {

		FDouble fSumPrice = FDouble.ZERO_DBL;

		CiorderAggDO aggdo = orAggAndRelDatum.getOraggdo();
		String key = OrdSrvMmDODesc.CLASS_FULLNAME;
		FMap mmMap = null;
		if (!CiOrdUtils.isEmpty(orAggAndRelDatum.getOrattachht()))
			mmMap = (FMap) orAggAndRelDatum.getOrattachht().get(key);

		if (aggdo != null && aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length > 0) {
			OrdSrvDO[] ordsrvDO = aggdo.getOrdSrvDO();
			List tempList = null;
			int i = 0;
			for (OrdSrvDO srvdo : ordsrvDO) {
				if (FBoolean.TRUE.equals(srvdo.getFg_bl())
						&& (srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.PHYSIAN
								|| srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMPRIMD
								|| srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD)
						&& srvdo.getPri() != null) {

					if (FBoolean.TRUE.equals(srvdo.getFg_mm())  && null != mmMap) {
						if (tempList == null) {
							tempList = getMap(mmMap);
						}
						if (tempList != null && i < tempList.size()) {
							List<OrdSrvMmDO> list = (List<OrdSrvMmDO>) mmMap.get(tempList.get(i));
							if (list != null && list.size() > 0) {
								for (OrdSrvMmDO mm : list) {
									fSumPrice = fSumPrice.add(mm.getPrice_pgku_cur().multiply(mm.getQuan_cur()));
								}
							}

						}
					} else {
						if (srvdo.getQuan_total_medu() != null)
							fSumPrice = fSumPrice.add(srvdo.getPri().multiply(srvdo.getQuan_total_medu()));
					}

				}
				i++;
			}
		}
		return fSumPrice;// new FDouble().sum(sumprice);
	}

	/**
	 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口，
	 * 
	 * @param aggDO
	 * @return
	 */
	public FBoolean JudgeCiHpSave(CiOrAggAndRelDatum oraggandrelinfo, FArrayList2 diagList) throws BizException {
		CiorderAggDO aggDO = oraggandrelinfo.getOraggdo();
		if (aggDO != null && aggDO.getParentDO() != null && aggDO.getOrdSrvDO().length > 0
				&& aggDO.getOrdSrvDO()[0].getId_hp() != null && aggDO.getOrdSrvDO()[0].getFg_selfpay() != null
				&& !aggDO.getOrdSrvDO()[0].getFg_selfpay().booleanValue()) {
			CiHpCheckDTO ciHpCheckDTO = new CiHpCheckDTO();
			ciHpCheckDTO.setId_pat(aggDO.getParentDO().getId_pat());
			ciHpCheckDTO.setId_ent(aggDO.getParentDO().getId_en());
			ciHpCheckDTO.setQuerydays(aggDO.getParentDO().getDays_or());
			ciHpCheckDTO.setCi_di_itms(diagList);
			// 医嘱 ，医嘱项目 ，物品 等 集合信息
			getOrderSrvMmDO(ciHpCheckDTO, oraggandrelinfo);
			CiHpCheckResultDTO result = HpService.checkCiHpSave(ciHpCheckDTO);
			if (result != null) {
				if (!FBoolean.TRUE.equals(result.getCheckflag())) {
					FMap2 map = result.getFailidorsrvmap();
					String error = "";
					for (Object str : map.values()) {
						error += str.toString() + "\n";
					}
					throw new BizException(error);
				} else {
					return FBoolean.TRUE;
				}
			}
		} else if (aggDO != null && aggDO.getParentDO() != null && aggDO.getOrdSrvDO().length > 0
				&& aggDO.getOrdSrvDO()[0].getId_hp() != null && aggDO.getOrdSrvDO()[0].getFg_selfpay() == null) {
			setOrderWathingJudge(aggDO);
		}
		return FBoolean.FALSE;
	}

	/**
	 * 
	 * @param aggDO
	 */
	private void setOrderWathingJudge(CiorderAggDO aggDO) {
		if (aggDO != null && aggDO.getOrdSrvDO().length > 0) {
			for (OrdSrvDO srvDO : aggDO.getOrdSrvDO()) {
				srvDO.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
			}
		}
		aggDO.getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.WAITINGJUDGE);
	}

	/**
	 * 获取物品信息
	 * 
	 * @param oraggandrelinfo
	 * @return
	 */
	private String getOrderId_mm(String id_srv, CiOrAggAndRelDatum oraggandrelinfo) {
		String id_mm = null;
		OrdSrvDO[] orsrvdos = oraggandrelinfo.getOraggdo().getOrdSrvDO();
		if (orsrvdos != null && orsrvdos.length > 0) {
			List tempList = null;
			int i = 0;
			FMap srvmmmap = getOrdSrvMmDOMap(oraggandrelinfo.getOrattachht());
			OrdSrvMmDO mm = null;
			// 医嘱项目对应的服务物品处理
			if (srvmmmap != null) {

				if (tempList == null) {
					tempList = getMap(srvmmmap);
				}
				if (tempList != null && i <= tempList.size()) {
					mm = (OrdSrvMmDO) srvmmmap.get(id_srv);
					i++;
					// mm.setId_orsrv(id_orsrv);
					id_mm = mm.getId_mm();
				}
			}
		}
		return id_mm;
	}

	/**
	 * 获取物品信息
	 * 
	 * @param oraggandrelinfo
	 * @return
	 */
	private void getOrderSrvMmDO(CiHpCheckDTO ciHpCheckDTO, CiOrAggAndRelDatum oraggandrelinfo) {
		FArrayList2 srvMmList = new FArrayList2();
		FArrayList2 srvList = new FArrayList2();
		FArrayList2 hpqry = new FArrayList2();
		HpQryCiorderDTO hpqryCiOrderDto = new HpQryCiorderDTO();
		OrdSrvDO[] orsrvdos = oraggandrelinfo.getOraggdo().getOrdSrvDO();
		if (orsrvdos != null && orsrvdos.length > 0) {
			FMap srvmmmap = getOrdSrvMmDOMap(oraggandrelinfo.getOrattachht());
			OrdSrvMmDO mm = null;
			List tempList = null;
			int i = 0;
			for (OrdSrvDO srvDO : orsrvdos) {
				// 医嘱项目对应的服务物品处理
				if (srvmmmap != null) {
					if (tempList == null) {
						tempList = getMap(srvmmmap);
					}
					if (tempList != null && i <= tempList.size()) {
						mm = (OrdSrvMmDO) srvmmmap.get(tempList.get(i));
						i++;
						// mm.setId_orsrv(id_orsrv);
						srvMmList.add(mm);
					}
				}
				srvList.append(srvDO);

			}
		}
		hpqryCiOrderDto.setCiorderdo(oraggandrelinfo.getOraggdo().getParentDO());
		hpqryCiOrderDto.setOrdsrvmms(srvMmList);
		hpqryCiOrderDto.setOrdsrvs(srvList);
		hpqry.append(hpqryCiOrderDto);
		ciHpCheckDTO.setSavecidto(hpqry);
	}

	/**
	 * 医保适应证 的接口
	 * 
	 * @param aggDO
	 */
	private void setMedicalInsurance(CiOrAggAndRelDatum oraggandrelinfo, FArrayList2 diagList) throws BizException {
		CiorderAggDO aggDO = oraggandrelinfo.getOraggdo();
		if (aggDO != null && aggDO.getOrdSrvDO() != null) {
			// 有医保计划 并且是 Fg_selfpay() 不是自费的
			if (aggDO.getOrdSrvDO().length > 0) {
				/*
				 * && aggDO.getOrdSrvDO()[0].getId_hp() != null &&
				 * aggDO.getOrdSrvDO()[0].getFg_selfpay() != null &&
				 * !aggDO.getOrdSrvDO()[0].getFg_selfpay().booleanValue()
				 */
				// 判断医保
				/*
				 * 医保目录类型：甲/乙/丙 判断方式：01不限制/11系统确定判断/12系统辅助判断/21医生判断 系统判断结果：是否适应Y/N 医保限制条件
				 */
				// 入参：患者主医保计划，服务ID集合、性别、新生儿标志、出生日期、诊断信息、开单科室、就诊类型
				// 患者的性别 和出生日期 代优化 ，需要上下文传入过来
				IPatiMDORService pipatService = (IPatiMDORService) ServiceFinder.find(IPatiMDORService.class);
				PatDO pipatdo = pipatService.findById(aggDO.getParentDO().getId_pat());

				int num = 0;
				// BdHpIndicationDTO[] hpIndications = new
				// BdHpIndicationDTO[aggDO.getOrdSrvDO().length];
				ArrayList<BdHpIndicationDTO> hpIndications = new ArrayList<BdHpIndicationDTO>();
				for (OrdSrvDO srvdo : aggDO.getOrdSrvDO()) {
					if (srvdo.getId_hp() != null
							&& (srvdo.getFg_selfpay() == null || !srvdo.getFg_selfpay().booleanValue())) {
						BdHpIndicationDTO hpIndicationDto = new BdHpIndicationDTO();
						hpIndicationDto.setId_srv(srvdo.getId_srv());
						hpIndicationDto.setCi_orsrvdo(srvdo);
						hpIndicationDto.setCi_di_itms(diagList);
						hpIndicationDto.setId_mm(getOrderId_mm(srvdo.getId_srv(), oraggandrelinfo));
						if (pipatdo != null) {
							hpIndicationDto.setPipatdo(pipatdo);
							hpIndicationDto.setSd_sex(pipatdo.getSd_sex());
							hpIndicationDto.setDt_birth(pipatdo.getDt_birth());
						}
						hpIndicationDto.setFg_bb(aggDO.getParentDO().getFg_bb());
						hpIndicationDto.setFg_mm(srvdo.getFg_mm());
						hpIndicationDto.setCode_entp(aggDO.getParentDO().getCode_entp());
						hpIndicationDto.setId_dep_or(aggDO.getParentDO().getId_dep_or());
						hpIndicationDto.setUse_day(aggDO.getParentDO().getDays_or());
						hpIndicationDto.setId_hp(srvdo.getId_hp());

						// hpIndications[num] = hpIndicationDto;
						hpIndications.add(hpIndicationDto);
						num++;
					} else {
						srvdo.setFg_selfpay(FBoolean.TRUE);

					}
				}

				if (hpIndications != null && hpIndications.size() > 0) {
					BdHpIndicationDTO[] hpIndicationsInfo = HpService
							.getHpIndication(hpIndications.toArray(new BdHpIndicationDTO[hpIndications.size()]));
					// 判断医保
					JudgeHPIndication(aggDO, hpIndicationsInfo);
				} else {
					aggDO.getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
				}

			} else if (aggDO != null && aggDO.getParentDO() != null && aggDO.getOrdSrvDO().length > 0
					&& aggDO.getOrdSrvDO()[0].getId_hp() != null && aggDO.getOrdSrvDO()[0].getFg_selfpay() == null) {
				setOrderWathingJudge(aggDO);
				// 到这有异常
			}
		}

	}

	/**
	 * a) 若服务无对应的医保限制条件时，则判断方式为【01不限制】。 b) 若服务有对应的医保限制条件时， 
	 * 若针对该医保限制条件，系统可以识别，并能最终确定是否适应（例如限三级医院使用），
	 * 则判断方式为【11系统确定判断】，系统判断结果为【系统识别的是否适应结果】  若针对该医保限制条件，系统可以识别，但需要医生做最终确认的（例如限），
	 * 则判断方式为【12系统辅助判断】，系统判断结果为【系统识别的是否适应结果】  若针对该医保限制条件，系统不可以识别，需要医生自己判断的，
	 * 则判断方式为【21医生判断】，系统判断结果为空，默认赋值为N
	 * 
	 * @param aggDO
	 * @param hpIndicationsInfo
	 */
	private void JudgeHPIndication(CiorderAggDO aggDO, BdHpIndicationDTO[] hpIndicationsInfo) throws BizException {
		if (aggDO != null && hpIndicationsInfo != null) {
			// OrdSrvDO[] ordSrvDOS = new OrdSrvDO[hpIndicationsInfo.length];
			boolean Eu_hpindicjudge = false;
			boolean temp_Eu_hpindicjudge = false;
			int num = 0;
			for (BdHpIndicationDTO indication : hpIndicationsInfo) {
				OrdSrvDO srvdo = (OrdSrvDO) indication.getCi_orsrvdo();
				srvdo.setFg_feertnable(FBoolean.TRUE);
				srvdo.setSd_hpsrvtp(indication.getSd_hpsrvtp());
				srvdo.setId_hpsrvtp(CiOrdUtils.idHpSrvtpFromSdHpSrvtp(indication.getSd_hpsrvtp()));

				if (JudgeHp(indication, srvdo, Eu_hpindicjudge)) {
					temp_Eu_hpindicjudge = true;
				}
				for (OrdSrvDO tempordsrv : aggDO.getOrdSrvDO()) {
					if (tempordsrv.getId_srv() == srvdo.getId_srv()) {
						tempordsrv = srvdo;
					}
				}

				/*
				 * if("01".equals(indication.getCode_hpindicjudged())){
				 * srvdo.setFg_indic(indication.getFg_indic());
				 * srvdo.setDes_hplimit(indication.getDes_hplimit());
				 * 
				 * srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE); }else
				 * if("11".equals(indication.getCode_hpindicjudged())){ //参数配置是否提醒
				 * if(CiOrdUtils.getIsRemind4FgIndicFalseConfirmed().booleanValue()){
				 * Eu_hpindicjudge = true; srvdo.setFg_indic(indication.getFg_indic());
				 * srvdo.setDes_hplimit(indication.getDes_hplimit());
				 * srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE); }else{
				 * srvdo.setFg_indic(indication.getFg_indic());
				 * srvdo.setDes_hplimit(indication.getDes_hplimit());
				 * srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE); }
				 * 
				 * }else if("12".equals(indication.getCode_hpindicjudged())){
				 * srvdo.setFg_indic(indication.getFg_indic());
				 * srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
				 * srvdo.setDes_hplimit(indication.getDes_hplimit()); Eu_hpindicjudge = true;
				 * }else if("21".equals(indication.getCode_hpindicjudged())){
				 * //srvdo.setFg_indic(indication.getFg_indic());
				 * srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
				 * srvdo.setDes_hplimit(indication.getDes_hplimit()); Eu_hpindicjudge = true; }
				 */
				// ordSrvDOS[num] = srvdo;
				num++;
			}
			if (temp_Eu_hpindicjudge) {
				aggDO.getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.WAITINGJUDGE);
			} else {
				aggDO.getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
			}
			// aggDO.setOrdSrvDO(ordSrvDOS);
		}
	}

	/**
	 * 
	 * @param indication
	 * @param srvdo
	 * @param Eu_hpindicjudge
	 * @return
	 * @throws BizException
	 */
	public static boolean JudgeHp(BdHpIndicationDTO indication, OrdSrvDO srvdo, boolean Eu_hpindicjudge)
			throws BizException {

		if (indication != null) {
			if (indication.getFg_indic() != null) {
				if (indication.getFg_indic().booleanValue()) {
					if ("12".equals(indication.getCode_hpindicjudged())) {
						srvdo.setFg_indic(indication.getFg_indic());
						srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
						srvdo.setDes_hplimit(indication.getDes_hplimit());
						Eu_hpindicjudge = true;
					} else {
						srvdo.setFg_indic(indication.getFg_indic());
						srvdo.setDes_hplimit(indication.getDes_hplimit());
						srvdo.setFg_selfpay(FBoolean.FALSE);
						srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
					}
				} else {
					// 确认为非适应症时是否提醒医生
					// @return 默认 是 false 不提醒， true 提醒
					if (CiOrdUtils.getIsRemind4FgIndicFalseConfirmed().booleanValue()) {
						Eu_hpindicjudge = true;
						srvdo.setFg_indic(indication.getFg_indic());
						srvdo.setDes_hplimit(indication.getDes_hplimit());
						srvdo.setFg_selfpay(FBoolean.TRUE);
						srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
					} else {
						if ("12".equals(indication.getCode_hpindicjudged())) {
							srvdo.setFg_indic(indication.getFg_indic());
							srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
							srvdo.setDes_hplimit(indication.getDes_hplimit());
							if (indication.getFg_indic().booleanValue()) {
								srvdo.setFg_selfpay(FBoolean.FALSE);
							} else {
								srvdo.setFg_selfpay(FBoolean.TRUE);
							}

							Eu_hpindicjudge = true;
						} else if ("21".equals(indication.getCode_hpindicjudged())) {
							// srvdo.setFg_indic(FBoolean.TRUE);
							srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
							srvdo.setDes_hplimit(indication.getDes_hplimit());
							srvdo.setFg_selfpay(FBoolean.TRUE);
							Eu_hpindicjudge = true;
						} else if ("11".equals(indication.getCode_hpindicjudged())) {
							srvdo.setFg_indic(indication.getFg_indic());
							srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
							srvdo.setDes_hplimit(indication.getDes_hplimit());
							if (indication.getFg_indic().booleanValue()) {
								srvdo.setFg_selfpay(FBoolean.FALSE);
							} else {
								srvdo.setFg_selfpay(FBoolean.TRUE);
							}

							Eu_hpindicjudge = true;
						} else { // 一般不会，到这里就有异常数据
							srvdo.setFg_indic(indication.getFg_indic());
							srvdo.setDes_hplimit(indication.getDes_hplimit());
							srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
							srvdo.setFg_selfpay(FBoolean.TRUE);
						}
					}
				}
			} else {
				if ("12".equals(indication.getCode_hpindicjudged())) {
					srvdo.setFg_indic(indication.getFg_indic());
					srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
					srvdo.setDes_hplimit(indication.getDes_hplimit());
					srvdo.setFg_selfpay(FBoolean.TRUE);
					Eu_hpindicjudge = true;
				} else if ("21".equals(indication.getCode_hpindicjudged())) {
					// srvdo.setFg_indic(FBoolean.TRUE);
					srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
					srvdo.setDes_hplimit(indication.getDes_hplimit());
					srvdo.setFg_selfpay(FBoolean.TRUE);
					Eu_hpindicjudge = true;
				} else { // 一般不会，到这里就有异常数据
					srvdo.setFg_indic(indication.getFg_indic());
					srvdo.setDes_hplimit(indication.getDes_hplimit());
					srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
					srvdo.setFg_selfpay(FBoolean.TRUE);
				}
			}

		}
		return Eu_hpindicjudge;
	}

	/**
	 * 医嘱保存
	 * 
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO orAggDOSave(CiEnContextDTO ctx, CiOrAggAndRelDatum oraggandrelinfo) throws BizException {
		
		CiorderAggDO aggdo = oraggandrelinfo.getOraggdo();
		CiOrdUtils.LogerOutInfo("医嘱基本保存的 方法  orAggDOSave " + "  " + "医嘱类型 " + aggdo.getParentDO().getSd_srvtp()
				+ "医嘱名称：" + aggdo.getParentDO().getNote_or());
		long startTime = System.currentTimeMillis();
		setFG_feertnable(aggdo);

		// 设置医嘱的排序号
		CiOrderDO ciOrder = aggdo.getParentDO();
		if (ciOrder.getStatus() == DOStatus.NEW) {
			String qryMaxSortno = "select max(nvl(sortno,0)) from ci_order where id_en = '" + ciOrder.getId_en() + "'";
			Integer result = (Integer) new DAFacade().execQuery(qryMaxSortno, new ColumnHandler());
			if (result == null) {
				result = 0;
			}
			ciOrder.setSortno(++result);
		}
		// 医嘱是否打印到医嘱单，默认是打印，对象保存不支持默认值，只能自己设置
		if (ciOrder.getFg_prn() == null) {
			ciOrder.setFg_prn(FBoolean.TRUE);
		}
	    //根据有手术收费策略，设置非本科室执行的服务是否保存
		setSugPrimd(aggdo);
		//设置草药的结束时间
		this.setDtEnd(aggdo);
		//设置出院带药的结束时间
		this.setDtOutTPEnd(aggdo);
		setFgSkintestByRoute(aggdo);
		//设置在院整领属性
		handleWholepack(aggdo);
		
		CiOrHpInfoBP ordHpInfo = new CiOrHpInfoBP();
		CiorderAggDO orderAgg = ordHpInfo.exec(ctx, oraggandrelinfo);
		CiOrderDO order = orderAgg.getParentDO();
		if(StringUtils.isNotEmpty(order.getMdicalinfo()) && order.getMdicalinfo().startsWith("Stop^")){
			return orderAgg;
		}
		
		ICiorderCudService orservice = CiOrdAppUtils.getOrAggService();
		CiorderAggDO[] aggdos = orservice.save(new CiorderAggDO[] { aggdo });
		//保存原液皮试的皮试申请单
		saveDrugSkintestOr(aggdos[0]);
		CiOrdUtils.LogerOutInfo("医嘱基本保存的 方法  orAggDOSave  耗时" + (System.currentTimeMillis() - startTime));
		if (aggdos == null || aggdos.length == 0)
			return null;
		return aggdos[0];
	}
	/**
	 * 在院整领属性
	 * @param aggdo
	 * @throws BizException 
	 */
	private void handleWholepack(CiorderAggDO aggdo) throws BizException {
		CiOrderDO order = aggdo.getParentDO();
		OrdSrvDO[] ordsrvs = aggdo.getOrdSrvDO();
		if(StringUtils.isEmpty(order.getSd_srvtp())||!order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
			return;
		}
		if(FBoolean.TRUE.equals(order.getFg_wholepack())){
			//在院整领药品医嘱在院执行模式
			String WholepackOrderMpMode = getWholepackOrderMpMode();
			if("00".equals(WholepackOrderMpMode)){//不在院用药执行
				order.setFg_mp_in(FBoolean.FALSE);
				order.setDt_end(order.getDt_effe());
				order.setDt_last_bl(order.getDt_effe());
				order.setQuan_firday_mp(1);
				for (OrdSrvDO ordSrvDO : ordsrvs) {
					ordSrvDO.setDt_last_bl(order.getDt_effe());
				}
			}else if("10".equals(WholepackOrderMpMode)){//b)只IV类医嘱在院执行
				String id_routes = getIVIdRoutes();
				if(!StringUtils.isEmpty(id_routes) && !StringUtils.isEmpty(order.getId_route()) && id_routes.contains(order.getId_route())){
					order.setFg_mp_in(FBoolean.TRUE);
				}else{
					order.setFg_mp_in(FBoolean.FALSE);
					order.setDt_end(order.getDt_effe());
					order.setDt_last_bl(order.getDt_effe());
					order.setQuan_firday_mp(1);
					for (OrdSrvDO ordSrvDO : ordsrvs) {
						ordSrvDO.setDt_last_bl(order.getDt_effe());
					}
				}
			}else if("11".equals(WholepackOrderMpMode)){//全部在院用药执行
				order.setFg_mp_in(FBoolean.TRUE);
			}
			//在院整领医嘱是否默认进行医嘱单打印（0166634: 医嘱单上不显示在院整领的药品医嘱，为了不影响其他项目，请做成配置，默认关闭，需要不显示的项目自行开启该功能）
			FBoolean flag = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),ICiOrdNSysParamConst.SYS_PARAM_FGWHOLEPACK_PRN);
			  if(FBoolean.FALSE.equals(flag)){
				order.setFg_prn(FBoolean.FALSE); 
			  }else{
				  order.setFg_prn(FBoolean.TRUE);
			  }
		}else if(FBoolean.TRUE.equals(order.getFg_pres_outp())){
			//出院带药医嘱在院执行模式
			String PresOutpOrderMpMode = getPresOutpOrderMpMode();
			if("00".equals(PresOutpOrderMpMode)){//不在院用药执行
				order.setFg_mp_in(FBoolean.FALSE);
				order.setDt_end(order.getDt_effe());
				order.setDt_last_bl(order.getDt_effe());
				order.setQuan_firday_mp(1);
				for (OrdSrvDO ordSrvDO : ordsrvs) {
					ordSrvDO.setDt_last_bl(order.getDt_effe());
				}
			}else if("10".equals(PresOutpOrderMpMode)){//b)只IV类医嘱在院执行
				String id_routes = getIVIdRoutes();
				if(!StringUtils.isEmpty(id_routes) && !StringUtils.isEmpty(order.getId_route()) && id_routes.contains(order.getId_route())){
					order.setFg_mp_in(FBoolean.TRUE);
				}else{
					order.setFg_mp_in(FBoolean.FALSE);
					order.setDt_end(order.getDt_effe());
					order.setDt_last_bl(order.getDt_effe());
					order.setQuan_firday_mp(1);
					for (OrdSrvDO ordSrvDO : ordsrvs) {
						ordSrvDO.setDt_last_bl(order.getDt_effe());
					}
				}
			}else if("11".equals(PresOutpOrderMpMode)){//全部在院用药执行
				order.setFg_mp_in(FBoolean.TRUE);
			}
		}else{
			String code_entp=order.getCode_entp();
			if(CiOrdUtils.isIpWf(code_entp)){
				order.setFg_mp_in(FBoolean.TRUE);
			}
		}
		
	}

	private void setFgSkintestByRoute(CiorderAggDO aggdo) {
		// 只处理药品
		if (!CiOrdUtils.isEmpty(aggdo.getParentDO().getSd_srvtp())
				&& aggdo.getParentDO().getSd_srvtp().startsWith("01")) {
			try {
				String skinRouteIds = ParamsetQryUtil.getParaString(aggdo.getParentDO().getId_org(),
						ICiOrdNSysParamConst.SYS_PARAM_RoutesSkinTest);
				if (!CiOrdUtils.isEmpty(skinRouteIds)) {
					String idRoute = aggdo.getParentDO().getId_route();
					if (!CiOrdUtils.isEmpty(idRoute) && skinRouteIds.contains(idRoute)) {
						aggdo.getParentDO().setFg_skintest(FBoolean.TRUE);
					}else {
						aggdo.getParentDO().setFg_skintest(FBoolean.FALSE);
					}
				}
			} catch (Exception ex) {
				return;
			}
		}
	}

	private void saveDrugSkintestOr(CiorderAggDO aggdo) throws BizException {
		// 只处理药品
		if (!CiOrdUtils.isEmpty(aggdo.getParentDO().getSd_srvtp()) && aggdo.getParentDO().getSd_srvtp().startsWith("01")
				&& FBoolean.TRUE.equals(aggdo.getParentDO().getFg_skintest())) {
			String id_or = aggdo.getParentDO().getId_or();
			//判断皮试申请单是否存在
			ISkintestRService service = ServiceFinder.find(ISkintestRService.class);
			CiSkinTestRstDO[] ciSkinTestRsts = service.findByAttrValString(CiSkinTestRstDO.ID_OR, id_or);
			if(ciSkinTestRsts==null||ciSkinTestRsts.length==0){
				// 保存皮试医嘱
				CiOrSkinTestRsPreSaveBP bp = new CiOrSkinTestRsPreSaveBP();
				bp.exec(aggdo);
			}
		}

	}
	// 设置退费标志
	private void setFG_feertnable(CiorderAggDO aggdo) {
		if (aggdo != null && aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length > 0) {
			for (OrdSrvDO srvdo : aggdo.getOrdSrvDO()) {
				srvdo.setFg_feertnable(FBoolean.TRUE);
			}
		}
	}
	/**
	 * 根据有手术收费策略，设置非本科室执行的服务是否保存
	 * @param aggdo
	 * @return
	 * @throws BizException 
	 */
    private void setSugPrimd(CiorderAggDO aggdo) {
    	// 手术收费策略 获取轻量级参数
		FBoolean sug_pre = FBoolean.TRUE;
		try {
			sug_pre = ParamUtils.GetOrgParamFBooleanValue(ICiOrdCustomSysParamConst.LL_PARAM_SUG_REL);
		} catch (BizException e) {
			OrdBizLogger.info(null, e.getMessage());
		}
		if (FBoolean.FALSE.equals(sug_pre)) {
			// 获取是手术的医嘱
			if (IBdSrvDictCodeConst.SD_SRVTP_OP.equals(aggdo.getParentDO().getSd_srvtp().substring(0, 2))) {
				// SRV表执行科室非当前登录科室的手术 附加手术
				List<OrdSrvDO> list = new ArrayList<OrdSrvDO>();
				for (OrdSrvDO ordSrvDO : aggdo.getOrdSrvDO()) {
					if ((IBdSrvDictCodeConst.SD_SRVTP_OP.equals(ordSrvDO.getSd_srvtp().substring(0, 2)))
							|| (Context.get().getDeptId().equals(ordSrvDO.getId_dep_mp())
									&& ordSrvDO.getId_srv().equals(aggdo.getParentDO().getId_srv()))) {
						ordSrvDO.setId_primd(IBdPrimdCodeConst.ID_PRI_FREE);
						ordSrvDO.setFg_bl(FBoolean.FALSE);
						list.add(ordSrvDO);
					}
				}
				aggdo.setOrdSrvDO(list.toArray(new OrdSrvDO[0]));
			}
		}
		
    }
	/**
	 * 医嘱临床事件数据保存
	 * 
	 * @param aggdos
	 * @return
	 * @throws BizException
	 */
	private void ciEventInfoSave(CiorderAggDO aggdo, boolean iseventsave) throws BizException {
		// 有效性校验
		if (!iseventsave)
			return;
		if (aggdo == null)
			return;
		BDCommonEvent event = new BDCommonEvent("iih.bd.srv.medsrv.d.MedSrvDO", IEventType.TYPE_UPDATE_AFTER, "");
		EventDispatcher.fireEvent(event);
		CiOrEventsSaveBP bp = new CiOrEventsSaveBP();
		bp.exec(new CiOrderDO[] { aggdo.getParentDO() });
	}

	/**
	 * 医嘱关联实体保存
	 * 
	 * @param aggdo
	 * @param ht
	 * @throws NegativeArraySizeException
	 * @throws BizException
	 */
	private void orAggAttachInfoSave(CiorderAggDO aggdo, Hashtable ht, Integer iemstp)
			throws BizException, NegativeArraySizeException {
		if (aggdo == null || ht == null || ht.size() == 0)
			return;
		CiOrderDO ordo = aggdo.getParentDO();
		OrdSrvDO[] orsrvdos = aggdo.getOrdSrvDO();

		// 临时 map
		Map map = new HashMap();
		// 医嘱项目对应物品记录的保存 医嘱项目对应变动用药记 医嘱及医嘱项目对应的套内项目
		FMap srvmmmap = getOrdSrvMmDOMap(ht);
		FMap srvdosesmap = getOrdSrvDoseDOsMap(ht);
		FMap srvagentmap = getOrSrvAgentInfoDOMap(ht);
		FMap srvsetsmap = getOrdSrvSetDOMap(ht);
		FMap orappmap = getOrAppSheetInfoMap(ht, iemstp);
		if ((srvmmmap == null || srvmmmap.size() == 0) && (srvdosesmap == null || srvdosesmap.size() == 0)
				&& (srvsetsmap == null || srvsetsmap.size() == 0) && (orappmap == null || orappmap.size() == 0))
			return;

		// 参数设置
		String id_srv = "", id_or = ordo.getId_or(), id_orsrv = "";
		ArrayList<OrdSrvMmDO> srvmmdo = new ArrayList<OrdSrvMmDO>();
		ArrayList<OrSrvAgentInfoDO> agentdo = new ArrayList<OrSrvAgentInfoDO>();
		ArrayList<OrdSrvDoseDO> srvdosedo = new ArrayList<OrdSrvDoseDO>();
		ArrayList<OrdSrvSetDO> srvsetdo = new ArrayList<OrdSrvSetDO>();
		AgentInfoMap2List4DelStatus(agentdo, srvagentmap);
		OrdSrvMmDO mm = null;
		OrdSrvDoseDO[] doses = null;
		OrdSrvSetDO[] sets = null;
		OrSrvAgentInfoDO srvagent = null;
		// 补全mm对象的数据
		completionSrvMm(srvmmdo, orsrvdos, srvmmmap);
		if (orsrvdos != null) {
			// 遍历
			List tempList = null;
			;
			for (int i = 0; i < orsrvdos.length; i++) {
				id_srv = orsrvdos[i].getId_srv();
				if (CiOrdUtils.isEmpty(id_or)) {
					id_or = orsrvdos[i].getId_or();
				}
				id_orsrv = orsrvdos[i].getId_orsrv();

				// 代办人的处理修改为，在签署的时候录入
				// //医嘱项目对应的代办人处理
				// if(srvagentmap!=null && srvagentmap.containsKey(id_srv)){
				// srvagent=(OrSrvAgentInfoDO)srvagentmap.get(id_srv);
				// srvagent.setId_or(id_or);
				// srvagent.setId_orsrv(id_orsrv);
				// agentdo.add(srvagent);
				// }

				// 医嘱项目对应的变动剂量处理
				if (srvdosesmap != null && srvdosesmap.containsKey(id_srv)) {
					doses = (OrdSrvDoseDO[]) srvdosesmap.get(id_srv);
					for (int j = 0; j < doses.length; j++) {
						doses[j].setId_or(id_or);
						doses[j].setId_orsrv(id_orsrv);
						srvdosedo.add(doses[j]);
					}
				}

				// 医嘱项目对应的套内项目处理
				// 为什么放在 循环里面？
				// if(srvsetsmap!=null && srvsetsmap.containsKey(ordo.getId_srv())){
				// sets=(OrdSrvSetDO[])srvsetsmap.get(ordo.getId_srv());
				// for(int j=0;j<sets.length;j++){
				// sets[j].setId_or(id_or);
				// sets[j].setId_orsrv(id_orsrv);
				// srvsetdo.add(sets[j]);
				// }
				// }
			}
		}
		// todo 暂时 放到 循环外面 如有不对在修改 李政
		if (srvsetsmap != null && srvsetsmap.containsKey(ordo.getId_srv())) {
			sets = (OrdSrvSetDO[]) srvsetsmap.get(ordo.getId_srv());
			for (int j = 0; j < sets.length; j++) {
				sets[j].setId_or(id_or);
				sets[j].setId_orsrv(id_orsrv);
				srvsetdo.add(sets[j]);

			}
		}
		if (srvsetsmap != null && srvsetsmap.containsKey(id_or)) {
			sets = (OrdSrvSetDO[]) srvsetsmap.get(id_or);
			for (int j = 0; j < sets.length; j++) {
				// if(!map.containsKey(sets[j].getId_orsrv())){
				sets[j].setId_or(id_or);
				// sets[j].setId_orsrv(id_orsrv);
				srvsetdo.add(sets[j]);
				// map.put(sets[j].getId_orsrv(), sets[j].getId_orsrv());
				// }
			}
		}

		if (srvmmdo != null && srvmmdo.size() != 0) {
			CiOrdAppUtils.getOrsrvmmService().save(
					(OrdSrvMmDO[]) srvmmdo.toArray((OrdSrvMmDO[]) Array.newInstance(OrdSrvMmDO.class, srvmmdo.size())));
		}

		if (!CiOrdUtils.isEmpty(agentdo)) {
			orSrvAgentInfoSave(agentdo);
		}

		if (srvdosedo != null && srvdosedo.size() != 0) {
			CiOrdAppUtils.getOrsrvdoseService().save(
					(OrdSrvDoseDO[]) srvdosedo.toArray((OrdSrvDoseDO[]) Array.newInstance(OrdSrvDoseDO.class, 0)));
		}

		if (srvsetdo != null && srvsetdo.size() != 0) {
			CiOrdAppUtils.getOrsrvsetService()
					.save((OrdSrvSetDO[]) srvsetdo.toArray((OrdSrvSetDO[]) Array.newInstance(OrdSrvSetDO.class, 0)));
		}

		// 医嘱对应的申请单保存
		ciOrAppSaveHandle(orappmap, id_or, iemstp);
	}

	/**
	 * 
	 * @param srvmmdo
	 *            存放用于保存的物品对象
	 * @param orsrvdos
	 *            物品的收费项目
	 * @param srvmmmap
	 *            HashMap中存储物品对象的map
	 */
	private void completionSrvMm(ArrayList<OrdSrvMmDO> srvmmdo, OrdSrvDO[] orsrvdos, FMap srvmmmap) {
		// 服务对应的物品处理
		// 1、将物品服务放入Map中,key=id_srv+id_mm
		Map<String, OrdSrvDO> srvMap = new HashMap<String, OrdSrvDO>();
		for (OrdSrvDO srvdo : orsrvdos) {
			if (!CiOrdUtils.isEmpty(srvdo.getFg_mm()) && srvdo.getFg_mm().booleanValue()) {
				srvMap.put(srvdo.getId_srv() + srvdo.getId_mm(), srvdo);
			}
		}
		if (!srvMap.isEmpty() && srvmmmap != null) {
			Iterator iter = srvmmmap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				List<OrdSrvMmDO> mmDOList = (List<OrdSrvMmDO>) entry.getValue();
				if (!CiOrdUtils.isEmpty(mmDOList)) {
					for (OrdSrvMmDO mmDO : mmDOList) {
						srvmmdo.add(mmDO);
						String mmKey = mmDO.getId_srv() + mmDO.getId_mm();
						if (srvMap.containsKey(mmKey)) {
							mmDO.setId_orsrv(srvMap.get(mmKey).getId_orsrv());
						}
					}
				}
			}
		}
	}

	/**
	 * 医嘱对应的申请单保存处理
	 * 
	 * @param orappmap
	 * @param id_or
	 * @param iemstp
	 * @throws BizException
	 */
	private void ciOrAppSaveHandle(FMap orappmap, String id_or, Integer iemstp) throws BizException {
		// 有效性判断
		if (orappmap == null || orappmap.size() == 0 || iemstp == -1 || CiOrdUtils.isEmpty(id_or))
			return;

		CiOrRelAppSheetSaveBP bp = new CiOrRelAppSheetSaveBP();
		bp.exec(orappmap.get(CiOrdUtils.ORAPP_SHEET_KEY), id_or, iemstp);
	}

	/**
	 * 获得医嘱项目对应的物品DO Map数据<id_srv,do>
	 * 
	 * @param ht
	 * @return
	 */
	private FMap getOrdSrvMmDOMap(Hashtable ht) {
		if (ht == null)
			return null;
		String key = OrdSrvMmDODesc.CLASS_FULLNAME;
		return (FMap) ht.get(key);
	}

	/**
	 * 获得医嘱项目对应变动剂量DO Map数据<id_srv,do[]>
	 * 
	 * @param ht
	 * @return
	 */
	private FMap getOrdSrvDoseDOsMap(Hashtable ht) {
		String key = OrdSrvDoseDODesc.CLASS_FULLNAME;
		return (FMap) ht.get(key);
	}

	/**
	 * 获得医嘱项目对应代办人DO Map数据<id_srv,do>
	 * 
	 * @param ht
	 * @return
	 */
	private FMap getOrSrvAgentInfoDOMap(Hashtable ht) {
		String key = OrSrvAgentInfoDODesc.CLASS_FULLNAME;
		return (FMap) ht.get(key);
	}

	/**
	 * 获得医嘱或医嘱项目对应的套DO Map数据<id_srv_set,dos>
	 * 
	 * @param ht
	 * @return
	 */
	private FMap getOrdSrvSetDOMap(Hashtable ht) {
		String key = OrdSrvSetDODesc.CLASS_FULLNAME;
		return (FMap) ht.get(key);
	}

	/**
	 * 获得医嘱申请单对应DO或aggdo Map数据<CiOrdUtils.ORAPP_SHEET_KEY,dos>
	 * 
	 * @param ht
	 * @return
	 */
	private FMap getOrAppSheetInfoMap(Hashtable ht, Integer iemstp) {
		String key = CiOrdUtils.getOrAppClizname(iemstp);
		return (FMap) ht.get(key);
	}

	/**
	 * 毒麻药品服务代办人信息保存
	 * 
	 * @param agentdo
	 * @throws BizException
	 */
	private void orSrvAgentInfoSave(ArrayList<OrSrvAgentInfoDO> agentdo) throws BizException {
		CiOrSrvAgentInfoSaveBP bp = new CiOrSrvAgentInfoSaveBP();
		bp.exec(agentdo);
	}

	/**
	 * 代理人信息（删除的）转换到列表中
	 * 
	 * @param agentdos
	 * @param srvagentmap
	 */
	private void AgentInfoMap2List4DelStatus(ArrayList<OrSrvAgentInfoDO> agentdos, FMap srvagentmap) {
		// 空校验
		if (CiOrdUtils.isEmpty(srvagentmap))
			return;

		// 参数
		String key = "";
		OrSrvAgentInfoDO agentdo = null;
		Iterator it = srvagentmap.keySet().iterator();

		// 遍历
		while (it.hasNext()) {
			agentdo = (OrSrvAgentInfoDO) srvagentmap.get(it.next());
			if (CiOrdUtils.isDODel(agentdo)) {

				agentdos.add(agentdo);

			}
		}
	}

	/***
	 * 将物品域返回的临床路径字段转换为医嘱域中用于显示临床路径图标的字段 物品域返回的值：0： 非径内医嘱,1:径内医嘱,-1:路径无关联
	 * 医嘱域：0：不需要判断，1：待判断，2:已判断
	 * 
	 * @param aggdos
	 */
	private void transMMUncporToCiOrdEuUncpor(CiorderAggDO[] aggdos) {
		if (CiOrdUtils.isEmpty(aggdos))
			return;
		for (CiorderAggDO aggdo : aggdos) {
			CiOrderDO ciOrdDO = aggdo.getParentDO();
			if (ciOrdDO == null)
				continue;
			Integer cpor = ciOrdDO.getEu_uncporjudge();
			if (cpor == null || cpor == CpOrderJudge.OWNCP || cpor == CpOrderJudge.NONRELCP) {
				ciOrdDO.setEu_uncporjudge(HpIndicJudgeEnum.NONEEDJUDGE);
			} else if (cpor == CpOrderJudge.NONOWNCP) {
				ciOrdDO.setEu_uncporjudge(HpIndicJudgeEnum.WAITINGJUDGE);
			}
		}
	}

	/**
	 * 
	 * @param srvmmmap
	 * @return
	 */
	private List<String> getMap(FMap srvmmmap) {
		List list = new ArrayList();
		if (srvmmmap != null) {
			Iterator entrys = srvmmmap.entrySet().iterator();
			while (entrys.hasNext()) {
				Map.Entry entry = (Map.Entry) entrys.next();
				list.add(entry.getKey().toString());
			}
		}
		return list;
	}
	//草药设置结束时间和首日执行次数
	private void  setDtEnd(CiorderAggDO aggdo) {
		if(aggdo != null && aggdo.getParentDO().getSd_srvtp().startsWith("0103")) {
			aggdo.getParentDO().setDt_end(aggdo.getParentDO().getDt_effe());
			aggdo.getParentDO().setDt_last_bl(aggdo.getParentDO().getDt_effe());
			aggdo.getParentDO().setQuan_firday_mp(1);
			OrdSrvDO[] ordsrvs = aggdo.getOrdSrvDO();
			for(OrdSrvDO ordsrv : ordsrvs){
				ordsrv.setDt_last_bl(aggdo.getParentDO().getDt_effe());
			}
		}
	}
	//出院带药的
	private void  setDtOutTPEnd(CiorderAggDO aggdo) {
		if(aggdo != null && aggdo.getParentDO().getSd_srvtp().startsWith("01")
			&& FBoolean.TRUE.equals(aggdo.getParentDO().getFg_pres_outp()) ) {
			aggdo.getParentDO().setDt_end(aggdo.getParentDO().getDt_effe());
			aggdo.getParentDO().setDt_last_bl(aggdo.getParentDO().getDt_effe());
			aggdo.getParentDO().setQuan_firday_mp(1);
			aggdo.getParentDO().setFg_long(FBoolean.FALSE);
			OrdSrvDO[] ordsrvs = aggdo.getOrdSrvDO();
			for(OrdSrvDO ordsrv : ordsrvs){
				ordsrv.setDt_last_bl(aggdo.getParentDO().getDt_effe());
			}
		}
	}	
	/**
	 * 在院整领药品医嘱在院执行模式
	 * @return
	 */
	private String getWholepackOrderMpMode(){
		try{
			String WholepackOrderMpMode = ParamsetQryUtil.getParaString(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_WholepackOrderMpMode);
			if(StringUtils.isEmpty(WholepackOrderMpMode)){
				return "00";
			}
			return WholepackOrderMpMode;
		}catch(Exception ex){
			return "00";
		}
	}
	/**
	 * 出院带药药品医嘱在院执行模式
	 * @return
	 */
	private String getPresOutpOrderMpMode(){
		try{
			String WholepackOrderMpMode = ParamsetQryUtil.getParaString(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_PresOutpOrderMpMode);
			if(StringUtils.isEmpty(WholepackOrderMpMode)){
				return "00";
			}
			return WholepackOrderMpMode;
		}catch(Exception ex){
			return "00";
		}
	}
	/**
	 * IV药用法集合
	 * @return
	 */
	private String getIVIdRoutes(){
		try{
			String  id_routes = ParamsetQryUtil.getParaString(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope);
			return id_routes;
		}catch(Exception ex){
			return "";
		}
	}
}

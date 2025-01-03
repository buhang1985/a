package iih.ci.ord.s.bp.validate.skintest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.dto.d.SkinTestUsePharmRstDTO;
import iih.ci.ord.dto.skintest.d.LimitDurg;
import iih.ci.ord.dto.skintest.d.SkinTestJudgeRstEnum;
import iih.ci.ord.dto.skintest.d.SkinTestRstDTO;
import iih.ci.ord.dto.skintest.d.SkinTestSignParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.skintest.GetLatelySkinTestRelInfoBP;
import iih.ci.ord.s.bp.skintest.IsExistsPatiAllergicHisBP;
import iih.ci.ord.s.bp.skintest.Management0fAllergyHistoryBP;
import iih.ci.ord.s.bp.validate.SkinTestOrSignBP;
import iih.ci.ord.s.bp.validate.skintest.sign.SkinOrderSignBP;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.pi.overview.overview.d.PiPatAlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 皮试药品签署逻辑判断
 * 
 * @author zhangwq
 *
 */
public class OpSkinTestOrSignBP extends SkinTestOrSignBP {
	private CiEnContextDTO ciEnContextDTO;
	private Map<String, List<SkinTestSignParamDTO>> skinTestParamMap;
	// 皮试校验模式
	private String skinTestVerifyMode;
	// 异常情况下的处理模式
	private String eu_unusualinjectmodel;
	// 皮试结果为归，用药医嘱开立模式
	private String skinTestNoRstOrderPhyMode;
	// 是否默认生成皮试医嘱 0:自动生成，1：提示模式
	private String isAutoCreateOrder;

	// 是否进行连续用药校验
	private FBoolean isNeedToValidateContinueExcDrug;

	private IOrdsrvmmRService ordsrvmmRService;

	private IMeterialMDORService mmRService;

	private String warnInfo1 = "【%s】皮试结果未归，是否继续用药？";
	private String warnInfo2 = "【%s】皮试结果为阳性，是否继续用药？";
	private String warnInfo3 = "【%s】于%s存在阳性皮试记录，不允许用药";
	private String warnInfo4 = "患者于%s存在过敏史，是否继续用药？";
	private String warnInfo5 = "【%s】皮试结果未归，不允许用药";
	private String warnInfo6 = "皮试结果未归，是否签署医嘱";
	private FMap2 extendsion;
	// 过敏史限制药品的个数
	int limitNumber = 0;

	public OpSkinTestOrSignBP() {
		ciEnContextDTO = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		ordsrvmmRService = ServiceFinder.find(IOrdsrvmmRService.class);
	}

	public FMap2 exec(CiorderAggDO[] aggors, OrderOperateDTO arg) throws BizException {
		extendsion = arg.getExtension();
		if(extendsion !=null && extendsion.containsKey("ErrMsg")){
			this.extendsion.remove("ErrMsg");
		}
		if (extendsion == null || !extendsion.containsKey(SkinTestSignParamDTO.class.getName())) {
			FMap2 skinTestJudgeRst = skinTestJudge(aggors, arg);
			if (this.isNeedToFront()) {
				return skinTestJudgeRst;
			} else {
				extendsion = skinTestJudgeRst;
			}
		}
		Map<String,List<CiOrderDO>> map = skinTestCreateOrder(aggors, extendsion);
		List<CiOrderDO> stopSignOrList = map.get("stopSignOrList");
		List<CiOrderDO> SignOrList = map.get("SignOrList");
		
		//List<String> signORList =skinTestCreateOrder(aggors, extendsion);
		ICiorderSrvDOCudService orderSrvService = ServiceFinder.find(ICiorderSrvDOCudService.class);
		// 更新关联的皮试信息
		for (CiorderAggDO orderAggDO : aggors) {
			OrdSrvDO[] ordSrvs = orderAggDO.getOrdSrvDO();
			for (OrdSrvDO ordSrv : ordSrvs) {
				ordSrv.setStatus(DOStatus.UPDATED);
			}
			orderSrvService.save(ordSrvs);
		}
		// 被停止签署的医嘱，如果等于aggors的长度，说明全部都被停止了，返回错误
		if (stopSignOrList != null && stopSignOrList.size() > 0) {
			extendsion.put("StopSignOrders", stopSignOrList);
			if (SignOrList!=null &&SignOrList.size() >0) {
				extendsion.put("SignOrList", SignOrList);
			}
			return extendsion;
		}
		return null;
	}

	/**
	 * 皮试生成逻辑,返回停止签署的医嘱id_or
	 * 
	 * @param aggors
	 * @param extendsion
	 * @throws BizException
	 */
	private Map<String,List<CiOrderDO>> skinTestCreateOrder(CiorderAggDO[] aggors, FMap2 extendsion) throws BizException {
		Map<String, List<CiOrderDO>> map = new HashMap<String, List<CiOrderDO>>();
		// 停止签署的医嘱
		List<CiOrderDO> stopSignOrList = new ArrayList<CiOrderDO>();
		// 生成的皮试医嘱
		List<CiOrderDO> SignOrList = new ArrayList<CiOrderDO>();
		if (extendsion != null && extendsion.containsKey(SkinTestSignParamDTO.class.getName())) {
			Map<String, CiorderAggDO> orderAggMap = new HashMap<String, CiorderAggDO>();
			C: for (CiorderAggDO agg : aggors) {
				for (OrdSrvDO ordsrv : agg.getOrdSrvDO()) {
					if (FBoolean.TRUE.equals(ordsrv.getFg_skintest())) {
						orderAggMap.put(agg.getParentDO().getId_or(), agg);
						continue C;
					}
				}
			}
			FMap2 skinTestParamMap2 = (FMap2) extendsion.get(SkinTestSignParamDTO.class.getName());
			Iterator<String> keys = orderAggMap.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				CiorderAggDO orderAggDO = orderAggMap.get(key);
				CiOrderDO order = orderAggDO.getParentDO();
				List<SkinTestSignParamDTO> signParamList_old = (List<SkinTestSignParamDTO>) skinTestParamMap2.get(key);
				// 皮试成组药，皮试类型编码和皮试药品为同一个则只生成一个即可，2020/4/12，liyuelong
				List<SkinTestSignParamDTO> signParamList=removeDuplicate(signParamList_old);
				if(signParamList!=null&&signParamList.size()>0){
					for(SkinTestSignParamDTO signParam:signParamList){
				// 1、皮试结果为阳性时，根据医生选择，决定是否签署；
				if (SkinTestJudgeRstEnum.SKINTESTASKTOUSE.equals(signParam.getEu_skintestjudgerst())) {
					// 继续用药
					if ("0".equals(signParam.getEu_doctorinjectmodel())) {
						// 直接签署签署了，录入强制使用原因
						order.setSd_skintest_skip_reason(signParam.getSkip_skintest_reason());
					} else {
						// 停止签署，终止
						stopSignOrList.add(order);
					}
				} else if (SkinTestJudgeRstEnum.SKINTESTNOUSE.equals(signParam.getEu_skintestjudgerst())) {
					// 不能用药，停止签署，终止
					stopSignOrList.add(order);
				} else if (SkinTestJudgeRstEnum.SKINTESTSHOWSKINFORM.equals(signParam.getEu_skintestjudgerst())) {
					// 弹出皮试结果列表，医生自己选择，关联皮试，还是取消签署，去生成皮试医嘱
					// 继续用药
					if ("0".equals(signParam.getEu_doctorinjectmodel())) {
						// 阴性时，可以签署；阳性时判断是否有强制用药原因，有强制用药原因也可以签署，否则不能签署
						// 关联皮试医嘱，录入强制使用原因，直接签署
						order.setSd_skintest_skip_reason(signParam.getSkip_skintest_reason());
						this.setOrdSrvIdOrRel(orderAggDO.getOrdSrvDO(), signParam.getId_or_rel(),signParam.getId_srv());
						
					} else {
						// 停止签署，生成皮试医嘱
						CiOrderDO skinTestOrder = this.createSkinTestOrder(signParam, order,orderAggDO.getOrdSrvDO());
						this.setOrdSrvIdOrRel(orderAggDO.getOrdSrvDO(), skinTestOrder.getId_or(),signParam.getId_srv());
						SignOrList.add(skinTestOrder);
						stopSignOrList.add(order);
					}
				} else if (SkinTestJudgeRstEnum.SKINTESTCREATESKINORDER.equals(signParam.getEu_skintestjudgerst())) {
					// 停止签署，生成皮试医嘱
					CiOrderDO skinTestOrder = this.createSkinTestOrder(signParam, order,orderAggDO.getOrdSrvDO());
					this.setOrdSrvIdOrRel(orderAggDO.getOrdSrvDO(), skinTestOrder.getId_or(),signParam.getId_srv());
					stopSignOrList.add(order);
					SignOrList.add(skinTestOrder);
				} else if (SkinTestJudgeRstEnum.SKINTESTNORSTASKTOUSE.equals(signParam.getEu_skintestjudgerst())
						|| SkinTestJudgeRstEnum.SKINTESTALHISSHOW.equals(signParam.getEu_skintestjudgerst())) {
					// 1、允许开立，提示皮试结果未归，录入强制用药；2、存在过敏史，弹出过敏信息，询问是否用药
					if ("0".equals(signParam.getEu_doctorinjectmodel())) {
						// 直接签署签署了，保存强制用药原因
						order.setSd_skintest_skip_reason(signParam.getSkip_skintest_reason());
					} else {
						if (!StringUtils.isNullOrEmpty(signParam.getId_or_rel())) {
							CiSkinTestRstDO rstDo = CiOrdUtils.getCiSkinTestRstDOUnCanc(signParam.getId_or_rel());
							if (rstDo == null) {
								// 停止签署，生成皮试医嘱
								CiOrderDO skinTestOrder = this.createSkinTestOrder(signParam, order,orderAggDO.getOrdSrvDO());
								this.setOrdSrvIdOrRel(orderAggDO.getOrdSrvDO(), skinTestOrder.getId_or(),signParam.getId_srv());
								SignOrList.add(skinTestOrder);
							}
						} else {
							// 停止签署，生成皮试医嘱
							CiOrderDO skinTestOrder = this.createSkinTestOrder(signParam, order,orderAggDO.getOrdSrvDO());
							this.setOrdSrvIdOrRel(orderAggDO.getOrdSrvDO(), skinTestOrder.getId_or(),signParam.getId_srv());
							SignOrList.add(skinTestOrder);
						}
						stopSignOrList.add(order);
					}
				}else{
					if ("1".equals(signParam.getEu_doctorinjectmodel())) {
						//停止签署
						stopSignOrList.add(order);
					}
					if (!StringUtils.isNullOrEmpty(signParam.getId_or_rel())) {
						CiSkinTestRstDO rstDo = CiOrdUtils.getCiSkinTestRstDOUnCanc(signParam.getId_or_rel());
						if (rstDo == null) {
							// 停止签署，生成皮试医嘱
							CiOrderDO skinTestOrder = this.createSkinTestOrder(signParam, order,orderAggDO.getOrdSrvDO());
							this.setOrdSrvIdOrRel(orderAggDO.getOrdSrvDO(), skinTestOrder.getId_or(),signParam.getId_srv());
							SignOrList.add(skinTestOrder);
						}
					} else {
						// 停止签署，生成皮试医嘱
						CiOrderDO skinTestOrder = this.createSkinTestOrder(signParam, order,orderAggDO.getOrdSrvDO());
						this.setOrdSrvIdOrRel(orderAggDO.getOrdSrvDO(), skinTestOrder.getId_or(),signParam.getId_srv());
						SignOrList.add(skinTestOrder);
					}
				}
			}
		}
		}
		}
		// 成组皮试药品时需要去重
		for(int i=0;i<stopSignOrList.size()-1;i++){
			for(int j=stopSignOrList.size()-1;j>i;j--){
				if(stopSignOrList.get(j).getId_or().equals(stopSignOrList.get(i).getId_or())){
					stopSignOrList.remove(j);
				}
			}
		}
		map.put("stopSignOrList", stopSignOrList);
		map.put("SignOrList", SignOrList);
		return map;
		
	}
	
	

	/**
	 * 皮试逻辑判断过程，判断应该使用何种方式处理皮试数据
	 * 
	 * @param aggors
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FMap2 skinTestJudge(CiorderAggDO[] aggors, OrderOperateDTO arg) throws BizException {
		Map<String, CiorderAggDO> newAggors=new HashMap<String, CiorderAggDO>();//step1.用于更新皮试结果和关联医嘱
		FMap2 extendsion = arg.getExtension();
		// 需要一个判断，判断是否再进行皮试判断逻辑了
		GetLatelySkinTestRelInfoBP getLatelySkinTestRelInfoBP = new GetLatelySkinTestRelInfoBP();
		String id_org = ciEnContextDTO.getId_org();
		String id_pat = ciEnContextDTO.getId_pat();
		List<String> skinidors = new ArrayList<String>();
		skinTestParamMap = new HashMap<String, List<SkinTestSignParamDTO>>();
		// 获得需要皮试的药品医嘱
		for (CiorderAggDO aggor : aggors) {
			FArrayList array = new FArrayList();
			List<SkinTestSignParamDTO> ParamDTOList=new ArrayList<SkinTestSignParamDTO>();
			CiOrderDO orderdo = aggor.getParentDO();
			String id_or = orderdo.getId_or();
			OrdSrvDO[] orsrvdos = aggor.getOrdSrvDO();
			newAggors.put(id_or, aggor);//step2.赋值
			for (OrdSrvDO ordsrv : orsrvdos) {
				if (FBoolean.TRUE.equals(ordsrv.getFg_skintest())) {
					OrdSrvMmDO ordsrvmm = getOrdSrvMmDO(ordsrv.getId_orsrv());
					SkinTestSignParamDTO param = new SkinTestSignParamDTO();
					param.setId_srv(ordsrv.getId_srv());
					param.setId_or(id_or);
					param.setId_org(id_org);
					param.setId_pi(id_pat);
					param.setId_or_rel(ordsrv.getId_or_rel());
					if(ciEnContextDTO.getDt_birth()!=null){
						param.setDt_birth(new FDate(ciEnContextDTO.getDt_birth()));
					}
					param.setFg_skintest_rst(ordsrv.getFg_skintest_rst());
					param.setName_srv(ordsrv.getName());
					if (ordsrvmm != null) {
						param.setId_mm(ordsrvmm.getId_mm());
						MeterialDO skinMMDO = getMeterialMDORService().findById(ordsrvmm.getId_mm());
						param.setSd_skinca(skinMMDO.getSd_skinca());// 皮试类型编码
						if(!CiOrdUtils.isEmpty(skinMMDO.getId_mmskin())){
						param.setId_mmskin(skinMMDO.getId_mmskin());// 皮试药品
						}
						if(!CiOrdUtils.isEmpty(skinMMDO.getId_srvskin())){
						param.setId_srvskin(skinMMDO.getId_srvskin());// 皮试服务项目
					}
					}
					ParamDTOList.add(param);
				}
			}
			array.addAll(ParamDTOList);
			skinTestParamMap.put(id_or, array);
			skinidors.add(id_or);
			continue;
		}
		// 存在需要皮试的医嘱
		if (skinidors.size() > 0) {
			// 存在皮试医嘱时，初始化参数模板参数
			initParams(ciEnContextDTO.getId_org());
			FMap2 rstMap = new FMap2();
			if (extendsion == null || !extendsion.containsKey(SkinTestSignParamDTO.class.getName())) {
				// 开始皮试判断
				for (String id_or : skinidors) {
					List<SkinTestSignParamDTO> skintestparamList = skinTestParamMap.get(id_or);
					if(skintestparamList!=null&&skintestparamList.size()>0){
						for(SkinTestSignParamDTO skintestparam:skintestparamList){
					skintestparam.setEu_unusualinjectmodel(this.eu_unusualinjectmodel);
					skintestparam.setFg_haspowertosign(getFgHaspowertosign());
					// 皮试结果已出，判断皮试信息
					if (!StringUtils.isNullOrEmpty(skintestparam.getId_or_rel())) {
						CiSkinTestRstDO rstDo = CiOrdUtils.getCiSkinTestRstDOUnCanc(skintestparam.getId_or_rel());
						if (rstDo != null) {
							String sd_rst = rstDo.getSd_rst_skintest();
							if (!CiOrdUtils.isEmpty(sd_rst)) {
								// 异常情况，处理办法
								if (sd_rst.startsWith("1")) {// 阳性
									// 皮试结果为阳性时，处理办法
									if ("0".equals(this.eu_unusualinjectmodel)) {
										// 允许全部医生强制用药，需要提示，是否继续，继续的话，需要填写强制用药原因【返回前台】
										skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTASKTOUSE);
										skintestparam
												.setWarninfo(String.format(warnInfo2, skintestparam.getName_srv()));
									} else if ("1".equals(this.eu_unusualinjectmodel)) {
										// 允许授权医生强制用药
										if (true) {
											// 在授权范围内，需要提示，是否继续，继续的话，需要录入强制用药原因
											skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTASKTOUSE);
											skintestparam
													.setWarninfo(String.format(warnInfo2, skintestparam.getName_srv()));
										} else {
											// 不能用药，提示存在阳性皮试记录，不允许用药【返回前台】
											skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNOUSE);
											skintestparam.setWarninfo(String.format(warnInfo3,
													skintestparam.getName_srv(), rstDo.getDt_create()));
										}
									} else if ("2".equals(this.eu_unusualinjectmodel)) {
										// 禁止医生强制用药
										// 提示存在非阴性的皮试记录，不允许继续用药【返回前台】
										skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNOUSE);
										skintestparam.setWarninfo(String.format(warnInfo3, skintestparam.getName_srv(),
												rstDo.getDt_create()));
									}
									continue;
								} else if (sd_rst.startsWith("0")&&skintestparamList.size()<=1) {// 阴性
									// 可以签署，继续下一条判断
									skinTestParamMap.remove(id_or);
									continue;
								}
							} else {
								// 皮试结果未归时的用药模式，
								// 禁止开立
								if ("00".equals(skinTestNoRstOrderPhyMode)) {
									// 禁止开立,生成皮试医嘱,
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNOUSE);
									skintestparam.setWarninfo(String.format(warnInfo5, skintestparam.getName_srv()));
								} else if ("10".equals(skinTestNoRstOrderPhyMode)) {
									// 允许医生强制用药,需要弹窗提示【皮试结果未归，若需要开立该药品，请录入无皮试结果继续用药原因】
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTASKTOUSE);
									skintestparam.setWarninfo(String.format(warnInfo1, skintestparam.getName_srv()));
								} else if ("11".equals(skinTestNoRstOrderPhyMode)) {
									// 允许授权医生强制用药
									// 需要弹窗提示【皮试结果未归，若需要开立该药品，请录入无皮试结果继续用药原因】
									if (true) {
										skintestparam
												.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTASKTOUSE);
										skintestparam
												.setWarninfo(String.format(warnInfo1, skintestparam.getName_srv()));
									} else {
										// 禁止用药，返回前台提示
										skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNOUSE);
										skintestparam
												.setWarninfo(String.format(warnInfo5, skintestparam.getName_srv()));
									}
								} else if ("20".equals(skinTestNoRstOrderPhyMode)) {
									// 允许开立，弹出提示【皮试结果未归，是否签署医嘱】
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTTOSIGN);
									skintestparam.setWarninfo(warnInfo6);
								}
								continue;
							}
						} else {
							// 皮试医嘱被删掉了,继续判断，按照初次签署模式处理
						}
					}
					// 存在相同药品不用批次，也得进行皮试，增加参数控制，是否进行连续用药的判断
					if (this.getIsNeedToValidateContinueExcDrug(this.ciEnContextDTO.getId_org()).booleanValue()) {
						// 判断是否存在连续用药
						SkinTestUsePharmRstDTO skinTestUseRst = getLatelySkinTestRelInfoBP
								.existValidisNeedSkinExOr(skintestparam);
						// 存在用药记录
						if (skinTestUseRst != null) {
							continue;
						}
					}
					// 医生判断
					if ("0".equals(skinTestVerifyMode)) {
						// 获取皮试效期内全部有效的皮试结果记录,返回前台进行判断
						SkinTestRstDTO[] skinTestRsts = getLatelySkinTestRelInfoBP
								.getPiValidSkinTestOrInfo(skintestparam);
						if (!CiOrdUtils.isEmpty(skinTestRsts)) {
							FArrayList skinTestRstList = new FArrayList();
							for (SkinTestRstDTO skinTestRstDTO : skinTestRsts) {
								// 0154812:
								// 验证版，开立头孢他啶，带出来的原液皮试，在门急诊输液执行后，门诊医生站开立青霉素针，点击签署，报错
								skinTestRstDTO.setSd_rst_skintest(skinTestRstDTO.getSd_rst_skintest() == null ? null
										: skinTestRstDTO.getSd_rst_skintest().substring(0, 1));
								skinTestRstList.add(skinTestRstDTO);
							}
							// 返回前台医生【返回前台】
							skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTSHOWSKINFORM);
							rstMap.put(SkinTestRstDTO.class.getName(), skinTestRstList);
						} else {
							// 不存在皮试结果记录,进入皮试结果未归，皮试用药医嘱开立流程
							if ("00".equals(skinTestNoRstOrderPhyMode)) {
								// 禁止开立,生成皮试医嘱
								skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTCREATESKINORDER);
								// 不返回前台，直接在后台生成皮试医嘱
							} else if ("10".equals(skinTestNoRstOrderPhyMode)) {
								// 允许医生强制用药,需要弹窗提示【皮试结果未归，若需要开立该药品，请录入无皮试结果继续用药原因】
								skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTASKTOUSE);
								skintestparam.setWarninfo(String.format(warnInfo1, skintestparam.getName_srv()));
							} else if ("11".equals(skinTestNoRstOrderPhyMode)) {
								// 允许授权医生强制用药
								// 需要弹窗提示【皮试结果未归，若需要开立该药品，请录入无皮试结果继续用药原因】
								if (true) {
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTASKTOUSE);
									skintestparam.setWarninfo(String.format(warnInfo1, skintestparam.getName_srv()));
								} else {
									// 皮试医嘱生成流程
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTCREATESKINORDER);
									// 不返回前台，直接在后台生成皮试医嘱
								}
							} else if ("20".equals(skinTestNoRstOrderPhyMode)) {
								// 允许开立
								skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTTOSIGN);
								skintestparam.setWarninfo(warnInfo6);
							}
						}
					} else if ("1".equals(skinTestVerifyMode)) {// 系统判断
						// 第一步：判断患者是否存在过敏史，阳性记录
						IsExistsPatiAllergicHisBP bp = new IsExistsPatiAllergicHisBP();
						PiPatAlDO[] piPatAlDO = bp.exec(id_org, id_pat, skintestparam.getId_mm());
						if (!CiOrdUtils.isEmpty(piPatAlDO)) {
							// 获取过敏史限制开立药品
							Management0fAllergyHistoryBP allergyHistoryBP = new Management0fAllergyHistoryBP();
							LimitDurg[] limitbd_mm = allergyHistoryBP.exec(piPatAlDO);

							if (!CiOrdUtils.isEmpty(limitbd_mm)) {
								for (LimitDurg limitDurg : limitbd_mm) {
									if (limitDurg.getId_mm().equals(skintestparam.getId_mm())) {
										limitNumber++;
										// // 存在过敏史，处理办法
										if ("0".equals(this.eu_unusualinjectmodel)) {
											// 允许全部医生强制用药，需要提示，是否继续，继续的话，需要填写强制用药原因【返回前台】
											skintestparam
													.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTALHISSHOW);
											skintestparam
													.setWarninfo(String.format(warnInfo4, piPatAlDO[0].getDt_act()));
										} else if ("1".equals(this.eu_unusualinjectmodel)) {
											// 允许授权医生强制用药
											if (true) {
												// 在授权范围内，需要提示，是否继续，继续的话，需要录入强制用药原因
												skintestparam
														.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTALHISSHOW);
												skintestparam.setWarninfo(
														String.format(warnInfo4, piPatAlDO[0].getDt_act()));
											} else {
												// 不能用药，提示存在阳性皮试记录，不允许用药【返回前台】
												skintestparam
														.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNOUSE);
												skintestparam.setWarninfo(String.format(warnInfo3,
														skintestparam.getName_srv(), piPatAlDO[0].getDt_act()));
											}
										} else if ("2".equals(this.eu_unusualinjectmodel)) {
											// 禁止医生强制用药
											// 提示存在非阴性的皮试记录，不允许继续用药【返回前台】
											skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNOUSE);
											skintestparam.setWarninfo(String.format(warnInfo3,
													skintestparam.getName_srv(), piPatAlDO[0].getDt_act()));
										} else {
											// 存在过敏史记录,返回前台，弹出药品的过敏史信息，是否继续用药
											skintestparam
													.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTALHISSHOW);
											skintestparam
													.setWarninfo(String.format(warnInfo4, piPatAlDO[0].getDt_act()));
										}
										break;
									}
								}
							}

						}
						if (CiOrdUtils.isEmpty(piPatAlDO) || limitNumber == 0) {
							// 判断【皮试效期内有无关联的阴性皮试结果记录】
							//皮试效期内，有无当前用药医嘱对应的皮试结果记录
							SkinTestRstDTO[] skinTestRsts = getLatelySkinTestRelInfoBP
									.getPiValidSkinTestOrInfo(skintestparam);
							//查询用药医嘱对应的诊疗皮试项目或者原液皮试项目阴性皮试记录
							SkinTestRstDTO rst =getActiveNegativeRst(skinTestRsts,skintestparam.getId_mm());
							if(rst!=null){
								for (Map.Entry<String, CiorderAggDO> entry : newAggors.entrySet()) {// step3.更新ci_or_srv
									if (id_or.equals(entry.getKey())) {
										OrdSrvDO[] ordSrvDOs = entry.getValue().getOrdSrvDO();
										for (OrdSrvDO ordsrv : ordSrvDOs) {
											if (FBoolean.TRUE.equals(ordsrv.getFg_skintest())&&ordsrv.getId_srv().equals(skintestparam.getId_srv())) {
												ordsrv.setFg_skintest_rst(FBoolean.TRUE);
												ordsrv.setId_or_rel(rst.getId_or());
											}
										}
									}
								}
								if(skintestparamList.size()<=1){
								// 可以签署，继续下一条判断
								skinTestParamMap.remove(id_or);
								}
								continue; 
							}else{
								// 不存在，结果未归，皮试用药医嘱开立流程
								if ("00".equals(skinTestNoRstOrderPhyMode)) {
									// 禁止开立,生成皮试医嘱
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTCREATESKINORDER);
									// 不返回前台，直接在后台生成皮试医嘱
								} else if ("10".equals(skinTestNoRstOrderPhyMode)) {
									// 允许医生强制用药,需要弹窗提示【皮试结果未归，若需要开立该药品，请录入无皮试结果继续用药原因】
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTASKTOUSE);
									skintestparam.setWarninfo(String.format(warnInfo1, skintestparam.getName_srv()));
								} else if ("11".equals(skinTestNoRstOrderPhyMode)) {
									// 允许授权医生强制用药
									// 需要弹窗提示【皮试结果未归，若需要开立该药品，请录入无皮试结果继续用药原因】
									if (true) {
										skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTASKTOUSE);
										skintestparam.setWarninfo(String.format(warnInfo1, skintestparam.getName_srv()));
									} else {
										// 皮试医嘱生成流程
										skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTCREATESKINORDER);
										// 不返回前台，直接在后台生成皮试医嘱
									}
								} else if ("20".equals(skinTestNoRstOrderPhyMode)) {
									// 允许开立，弹出提示【皮试结果未归，是否签署医嘱】
									skintestparam.setEu_skintestjudgerst(SkinTestJudgeRstEnum.SKINTESTNORSTTOSIGN);
									skintestparam.setWarninfo(warnInfo6);
								}
							}
						}
					}
				}
			}
				if (!skinTestParamMap.isEmpty()) {
					FMap2 skinTestParamMap2 = new FMap2();
					skinTestParamMap2.putAll(skinTestParamMap);
					rstMap.put(SkinTestSignParamDTO.class.getName(), skinTestParamMap2);

				}
			}
			} else if (extendsion != null && extendsion.containsKey(SkinTestSignParamDTO.class.getName())) {
				// 存在医生判断的数据了
			}
			return rstMap;
		}
		return null;

	}

	/**
	 * 获取皮试用药医嘱，在药品基本信息中维护的皮试医嘱对应的阴性结果记录
	 * 
	 * @param skinTestRsts
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	private SkinTestRstDTO getActiveNegativeRst(SkinTestRstDTO[] skinTestRsts, String id_mm) throws BizException {
		if(skinTestRsts==null){
			return null;
		}
		MeterialDO skinMMDO = getMeterialMDORService().findById(id_mm);
		// 皮试类型:0,诊疗皮试;1,原液皮试
		String sd_skinca = skinMMDO.getSd_skinca();
		CiOrderDO skinOrder = null;
		if ("0".equals(sd_skinca)) {
			String id_srvskin = skinMMDO.getId_srvskin();
			// 遍历皮试结果，获得服务对应的阴性皮试结果记录
			for (SkinTestRstDTO skinTestRstDTO : skinTestRsts) {
				if (!StringUtils.isNullOrEmpty(id_srvskin) && id_srvskin.equals(skinTestRstDTO.getId_srv())) {
					String sd_rst = skinTestRstDTO.getSd_rst_skintest();
					if (!CiOrdUtils.isEmpty(sd_rst)) {
						// 阴性
						if (sd_rst.startsWith("0")) {
							return skinTestRstDTO;// 取最新的记录
						}
					}
				}
			}
		} else if ("1".equals(sd_skinca)) {
			String id_skinmm = skinMMDO.getId_mmskin();
			for (SkinTestRstDTO skinTestRstDTO : skinTestRsts) {
				if (!StringUtils.isNullOrEmpty(id_skinmm) && id_skinmm.equals(skinTestRstDTO.getId_mm())) {
					String sd_rst = skinTestRstDTO.getSd_rst_skintest();
					if (!CiOrdUtils.isEmpty(sd_rst)) {
						// 阴性
						if (sd_rst.startsWith("0")) {
							return skinTestRstDTO;// 取最新的记录
						}
					}
				}
			}
		}
		return null;
	}

	private void setOrdSrvIdOrRel(OrdSrvDO[] srvdos, String id_or_rel, String id_srv) {
		for (OrdSrvDO srv : srvdos) {
			if (FBoolean.TRUE.equals(srv.getFg_skintest())&&srv.getId_srv().equals(id_srv)) {
				srv.setId_or_rel(id_or_rel);
				srv.setFg_skintest_rst(FBoolean.TRUE);//皮试结果
			}
		}
	}

	/**
	 * 关联的物品，如果是自备药的话，不皮试
	 * 
	 * @param id_orsrv
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO getOrdSrvMmDO(String id_orsrv) throws BizException {
		OrdSrvMmDO[] ordsrvmms = ordsrvmmRService.findByAttrValString(OrdSrvMmDO.ID_ORSRV, id_orsrv);
		if (ordsrvmms != null && ordsrvmms.length > 0) {
			return ordsrvmms[0];
		}
		return null;
	}

	private void initParams(String id_org) throws BizException {
		try {
			skinTestVerifyMode = ParamsetQryUtil.getParaString(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_SkinTestVerifyMode);
		} catch (Exception ex) {
			skinTestVerifyMode = "1";// 系统判断
		}
		try {
			eu_unusualinjectmodel = ParamsetQryUtil.getParaString(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_SkinTestExceptionDrugCreateMode);
		} catch (Exception ex) {
			eu_unusualinjectmodel = "2";// 禁止强制用药
		}
		try {
			skinTestNoRstOrderPhyMode = ParamsetQryUtil.getParaString(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_SkinTestNoRstOrderPhyMode);
		} catch (Exception ex) {
			skinTestNoRstOrderPhyMode = "00";// 默认禁止开立
		}
	}

	/**
	 * 判断是否需要返回到前台
	 * 
	 * @return
	 */
	public boolean isNeedToFront() {
		if (this.skinTestParamMap == null) {
			return false;
		}
		Iterator<String> keys = this.skinTestParamMap.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			List<SkinTestSignParamDTO> ParamDTOlist = skinTestParamMap.get(key);
			if(ParamDTOlist!=null&&ParamDTOlist.size()>0){
				for(SkinTestSignParamDTO ParamDTO:ParamDTOlist){
			if (!SkinTestJudgeRstEnum.SKINTESTCREATESKINORDER
							.equals(ParamDTO.getEu_skintestjudgerst())) {
				return true;
			}
		}
				
			}
		}
		return false;
	}

	private CiOrderDO createSkinTestOrder(SkinTestSignParamDTO signParam, CiOrderDO orderDO,OrdSrvDO[] ordsrsvs) throws BizException {
		if (!isAutoCreateOrder(this.ciEnContextDTO.getId_org())) {
			throw new BizException(String.format("【%s】药品需要皮试，请开立皮试医嘱,签署失败", orderDO.getName_or()));
			// return new CiOrderDO();
		}
		String warnSkinCa = "【%s】关联皮试类型为空";
		String id_mm = signParam.getId_mm();
		MeterialDO skinMMDO = getMeterialMDORService().findById(id_mm);
		// 皮试类型:0,诊疗皮试;1,原液皮试
		String sd_skinca = skinMMDO.getSd_skinca();
		CiOrderDO skinOrder = null;
		if ("0".equals(sd_skinca)) {
			String id_srvskin = skinMMDO.getId_srvskin();
			// 将药品医嘱的CiOrderDO转换为CiEmsDTO,用于复用之前的的逻辑
			SaveTreatSkinBP saveTreatSkinBp = getSaveTreatBP();
			skinOrder = saveTreatSkinBp.save(orderDO, id_srvskin);
		} else if ("1".equals(sd_skinca)) {
			SaveDrugSkinBP saveDrugSkinBP = getSaveDrugBP();
			skinOrder = saveDrugSkinBP.save(orderDO,ordsrsvs, skinMMDO);
		} else {
			throw new BizException(String.format(warnSkinCa, signParam.getName_srv()));
		}
		//TODO 修改为方法，重写调用住院简易签署
		// 开立完皮试医嘱后，自动签署
		skinSign(ciEnContextDTO,skinOrder);
		return skinOrder;
	}
	protected SaveDrugSkinBP getSaveDrugBP() {
		return new SaveDrugSkinBP();
	}

	protected SaveTreatSkinBP getSaveTreatBP() {
		return new SaveTreatSkinBP();
	}

	/**
	 * 开立完皮试医嘱后，自动签署
	 * @param skinOrder
	 * @throws BizException
	 */
	public void skinSign(CiEnContextDTO ciEnContextDTO,CiOrderDO skinOrder)throws BizException{
		if (skinOrder != null) {
			SkinOrderSignBP signBP = new SkinOrderSignBP();
			OrderRstDTO rst = signBP.exec(ciEnContextDTO, skinOrder.getId_or());
			if(rst!=null && rst.getExtension()!=null){
				if(rst.getExtension().containsKey("ErrMsg")){
					if(this.extendsion.containsKey("ErrMsg")){
						this.extendsion.put("ErrMsg",(this.extendsion.get("ErrMsg")+"\r\n"+rst.getExtension().get("ErrMsg")));
						this.extendsion.put("UnCheckIdors",this.extendsion.get("UnCheckIdors"));
					}else{
						this.extendsion.put("ErrMsg",rst.getExtension().get("ErrMsg"));
						this.extendsion.put("UnCheckIdors",rst.getExtension().get("UnCheckIdors"));
					}
				}
			}
		}
	}

	private boolean isAutoCreateOrder(String id_org) {
		if (isAutoCreateOrder != null) {
			return "0".equals(isAutoCreateOrder);
		}
		try {
			this.isAutoCreateOrder = ParamsetQryUtil.getParaString(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_SkinTestOrderCreateMode);
			if (StringUtils.isNullOrEmpty(this.isAutoCreateOrder)) {
				this.isAutoCreateOrder = "0";
			}
		} catch (BizException e) {
			this.isAutoCreateOrder = "0";
		}
		return "0".equals(isAutoCreateOrder);
	}

	/**
	 * 在异常情况下，医生是否有权限进行强制用药
	 * 
	 * @return
	 */
	private FBoolean getFgHaspowertosign() {
		if ("0".equals(this.eu_unusualinjectmodel)) {
			// 允许全部医生强制用药，需要提示，是否继续，继续的话，需要填写强制用药原因【返回前台】
			return FBoolean.TRUE;
		} else if ("1".equals(this.eu_unusualinjectmodel)) {
			// 允许授权医生强制用药
			if (true) {
				// 在授权范围内，需要提示，是否继续，继续的话，需要录入强制用药原因
				return FBoolean.TRUE;
			} else {
				// 不能用药，提示存在阳性皮试记录，不允许用药【返回前台】
				return FBoolean.FALSE;
			}
		} else if ("2".equals(this.eu_unusualinjectmodel)) {
			// 禁止医生强制用药
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}

	private FBoolean getIsNeedToValidateContinueExcDrug(String id_org) {
		if (isNeedToValidateContinueExcDrug != null) {
			return isNeedToValidateContinueExcDrug;
		}
		try {
			this.isNeedToValidateContinueExcDrug = ParamsetQryUtil.getParaBoolean(id_org,
					ICiOrdNSysParamConst.SYS_PARAM_ValidateContinueExcDrug);
			return isNeedToValidateContinueExcDrug;
		} catch (Exception ex) {
			return FBoolean.FALSE;
		}
	}

	private IMeterialMDORService getMeterialMDORService() {
		if (mmRService == null) {
			mmRService = ServiceFinder.find(IMeterialMDORService.class);
		}
		return mmRService;
	}
	// private MeterialDO[] getSkinMerials(List<String> id_mms){
	// IMeterialMDORService service =
	// ServiceFinder.find(IMeterialMDORService.class);
	// }
	/**
	 * 去重
	 * @param signParamList
	 * @return
	 * @throws BizException
	 */
	private List<SkinTestSignParamDTO> removeDuplicate(List<SkinTestSignParamDTO> signParamList) throws BizException{
		// 当医生判断且有皮试结果时，直接传过来的集合里面没有皮试类型编码，皮试药品或皮试项目，需要重置一下，仅用于去重
		if (signParamList != null && signParamList.size() > 0) {
			for (SkinTestSignParamDTO signParam : signParamList) {
				if (!CiOrdUtils.isEmpty(signParam.getId_mm()) && CiOrdUtils.isEmpty(signParam.getSd_skinca())) {
					MeterialDO skinMMDO = getMeterialMDORService().findById(signParam.getId_mm());
					signParam.setSd_skinca(skinMMDO.getSd_skinca());
					if (!CiOrdUtils.isEmpty(skinMMDO.getId_mmskin())) {
						signParam.setId_mmskin(skinMMDO.getId_mmskin());
					}
					if (!CiOrdUtils.isEmpty(skinMMDO.getId_srvskin())) {
						signParam.setId_srvskin(skinMMDO.getId_srvskin());
					}
				}
			}
		}
		
		// 去重逻辑，当对象相同或对象的皮试类型编码一致且皮试药品或皮试项目一致时，去重操作
		if (signParamList != null && signParamList.size() > 0) {
			for (int i = 0; i < signParamList.size() - 1; i++) {
				for (int j = signParamList.size() - 1; j > i; j--) {
					if (signParamList.get(i).equals(signParamList.get(j))
							|| (!CiOrdUtils.isEmpty(signParamList.get(i).getSd_skinca())
									&& !CiOrdUtils.isEmpty(signParamList.get(j).getSd_skinca())
									&& signParamList.get(i).getSd_skinca().equals(signParamList.get(j).getSd_skinca())
									&& ((!CiOrdUtils.isEmpty(signParamList.get(i).getId_srvskin())
											&& !CiOrdUtils
													.isEmpty(signParamList.get(j).getId_srvskin())
											&& signParamList.get(i).getId_srvskin()
													.equals(signParamList.get(j).getId_srvskin()))
											|| (!CiOrdUtils.isEmpty(signParamList.get(i).getId_mmskin())
													&& !CiOrdUtils.isEmpty(signParamList.get(j).getId_mmskin())
													&& signParamList.get(i).getId_mmskin()
															.equals(signParamList.get(j).getId_mmskin()))))) {

						signParamList.remove(j);
					}
				}
			}
		}
		return signParamList;
	}
}
package iih.bl.itf.std.bp.ipcharge;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.itf.std.bean.input.charge.WsParamSetCostBill;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillCostInfo;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillCostItemInfo;
import iih.bl.itf.std.bean.output.WsResultMsgInfo;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamIPCostBilllValidator;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.GetMaterialPriceDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class SetIpCostBillBP extends BlItfBaseBP<WsParamSetCostBill, WsResultMsgInfo> {

	protected String getBusiness() {
		// TODO Auto-generated method stub
		return "住院退补费";
	}

	protected void checkParam(WsParamSetCostBill param) throws BizException {
		// 参数校验
		WsParamIPCostBilllValidator valistdator = new WsParamIPCostBilllValidator();
		valistdator.validate(param);

		WsParamBillCostInfo prepayInfo = param.getCostInfo();
		
		//设置记账人员
		if(!StringUtil.isEmpty(prepayInfo.getOperaCG())){
			// 设置人员上下文
			PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCG());
			if (psndocDO == null) {
				throw new BizException("住院退补费:未查询到记账人员信息");
			}
			Context.get().setStuffId(psndocDO.getId_psndoc());
		}

	}

	protected WsResultMsgInfo doWork(WsParamSetCostBill param) throws BizException {
		WsResultMsgInfo resultMsg = setResultMsg("0");

		// 1.根据科室编码查找部门ID
		String sIdDepMp = this.initDeptId(param.getCostInfo().getMpDepCode());
		BLThirdItfLogger.info("调用住院补费时执行科室ID：" + sIdDepMp);
		String sIdDepOr = this.initDeptId(param.getCostInfo().getCgDepCode());
		BLThirdItfLogger.info("调用住院补费时开单科室ID：" + sIdDepOr);
		// 2.根据患者编码和住院次数查找住院就诊信息
		PatiVisitDO patiVisitDO = this.initPatiVisitInfo(param);
		if (FBoolean.TRUE.equals(patiVisitDO.getFg_st())) {
			throw new BizException("该患者已经出院结算，不允许记费或退费");
		}
		// 3.根据医嘱编码查找医嘱信息
		CiOrderDO[] ciOrderDOs = this.initOrderInfo(param);

		// 4.住院补费
		if (param.getCostInfo().getChargeitems() != null && param.getCostInfo().getChargeitems().size() > 0) {
			this.setIpAddFee(param, patiVisitDO, null, sIdDepMp, sIdDepOr);
		}
		if (ciOrderDOs != null) {
			for (CiOrderDO ciOrderDO : ciOrderDOs) {
				this.setIpAddFee(param, patiVisitDO, ciOrderDO, sIdDepMp, sIdDepOr);
			}
		}

		return resultMsg;
	}

	/**
	 * 返回信息
	 * 
	 * @param resultCode
	 * @return
	 */
	private WsResultMsgInfo setResultMsg(String resultCode) {
		WsResultMsgInfo rltMsg = new WsResultMsgInfo();
		if (resultCode.endsWith("0")) {
			rltMsg.setCode("0");
			rltMsg.setMessage("成功！");
		} else {
			rltMsg.setCode("1");
			rltMsg.setMessage("失败！");
		}
		return rltMsg;
	}

	/***
	 * 进行住院退补费
	 * 
	 * @param param
	 * @param patiVistDO
	 * @param ciOrderDO
	 * @param idDepMp
	 * @param idDepOr
	 * @throws BizException
	 */
	private void setIpAddFee(WsParamSetCostBill param, PatiVisitDO patiVistDO, CiOrderDO ciOrderDO, String idDepMp,
			String idDepOr) throws BizException {
		BLThirdItfLogger.info("调用函数setIpAddFee开始");
		// 记账数据源
		List<BlCgAccountDTO> blCgAccountDTOList = new ArrayList<BlCgAccountDTO>();
		// 退费记账数据源
		List<BlCgRefundAccountDTO> BlCgRefundAccountDTOList = new ArrayList<BlCgRefundAccountDTO>();
		Integer directflag = 0;
		MedSrvDO[] medSrvDOs;
		if (ciOrderDO != null) {
			medSrvDOs = this.initMedSvrInfo(ciOrderDO.getCode_or(), param);
			directflag = this.getDirectFlag(ciOrderDO.getCode_or(), param);

		} else {
			medSrvDOs = this.initMedSvrInfo(param);
			if (medSrvDOs != null) {
				directflag = this.getDirectFlag(null, param);
			}
		}

		if (medSrvDOs != null) {
			try {
				BLThirdItfLogger.info("组装BlCgAccountDTO数据集开始");
				for (MedSrvDO medSrvDO : medSrvDOs) {
					// 获取一条补费信息
					WsParamBillCostItemInfo itemParamDTO = this.getBlCostAddItemParamDTO(param, ciOrderDO, medSrvDO);

					MeterialDO meterialDO = null;
					if (!StringUtil.isEmptyWithTrim(itemParamDTO.getMmCode())) {
						IMeterialMDORService mSerivce = ServiceFinder.find(IMeterialMDORService.class);//
						MeterialDO[] tmpDOs = mSerivce.findByAttrValString(MeterialDO.CODE, itemParamDTO.getMmCode());
						if (tmpDOs != null && tmpDOs.length > 0) {
							meterialDO = tmpDOs[0];
							IMaterialBaseInfoService mbaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
							GetMaterialPriceDTO mmPriceDTO = mbaseService.MaterialPriceForOt(meterialDO.getId_mm(),
									meterialDO.getId_unit_pkgbase());//Math.abs(mmPriceDTO.getPrice_act().toDouble() - Double.parseDouble(itemParamDTO.getPrice())) > 0
							if(mmPriceDTO != null && mmPriceDTO.getPrice_act() != null){
								if (mmPriceDTO.getPrice_act().compareTo(new FDouble(itemParamDTO.getPrice())) != 0) {
									StringBuilder sqlStrBuf = new StringBuilder();
									sqlStrBuf.append("住院补费：物品编码为[");
									sqlStrBuf.append(itemParamDTO.getMmCode());
									sqlStrBuf.append("]的补费价格(");
									sqlStrBuf.append(new FDouble(itemParamDTO.getPrice()));
									sqlStrBuf.append(")和IIH计算的价格(");
									sqlStrBuf.append(mmPriceDTO.getPrice_act());
									sqlStrBuf.append(")有差异！");
									throw new BizException(sqlStrBuf.toString());
								}
							}
		
						} // if (tmpDOs != null
					}
					// 筛选、组装记账信息
					if (param.getCostInfo().getDirectFlag().equals("1")) {
						// 筛选、组装记账信息
						BlCgAccountDTO blCgAccountDTO = this.getBlCgAccountDTO(patiVistDO, ciOrderDO, medSrvDO,
								meterialDO, itemParamDTO);
						// 记账方向

						blCgAccountDTO.setEu_direct(BookRtnDirectEnum.CHARGE); // 收费

						blCgAccountDTO.setId_dep_mp(idDepMp); // 执行科室
						blCgAccountDTO.setId_dep_or(idDepOr); // 开立科室

						//设置开立人员
						WsParamBillCostInfo prepayInfo = param.getCostInfo();
						if(!StringUtil.isEmpty(prepayInfo.getOperaOR())){
							// 设置人员上下文
							PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaOR());
							if (psndocDO == null) {
								throw new BizException("住院退补费:未查询到开立人员信息");
							}
							blCgAccountDTO.setId_emp_or(psndocDO.getId_psndoc());
						}
						blCgAccountDTOList.add(blCgAccountDTO);
						// 退费
					} else if (param.getCostInfo().getDirectFlag().equals("-1")) {
						BlCgRefundAccountDTOList = this.getBlCgRefundAccountDTO(patiVistDO, ciOrderDO, medSrvDO,
								meterialDO, itemParamDTO);
					}
				}

				BLThirdItfLogger.info("组装BlCgAccountDTO数据集结束");

				// 走补费逻辑
				if (!ListUtil.isEmpty(blCgAccountDTOList)) {
					BlCgAccountSetDTO blCgAccountSetDTO = new BlCgAccountSetDTO();
					blCgAccountSetDTO.setFg_exception(FBoolean.TRUE); // 抛异常
					blCgAccountSetDTO.setFg_addfee(FBoolean.TRUE); // 补费
					blCgAccountSetDTO.setSrcfunc_des(IBlCgCodeConst.IpRtnCompensteFee);
					blCgAccountSetDTO.setFg_price_cal(FBoolean.FALSE);
					// 调用补费接口
					BLThirdItfLogger.info(
							"调用IBlCgAccountService接口方法keepAccountForIp开始 补费" + ArrayUtils.toString(blCgAccountDTOList));
					if (blCgAccountDTOList != null && blCgAccountDTOList.size() > 0) {
						IBlCgAccountService blCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
						blCgAccountService.keepAccountForIp(blCgAccountDTOList.toArray(new BlCgAccountDTO[] {}),
								blCgAccountSetDTO);
					}
					// 退费逻辑
				} else if (!ListUtil.isEmpty(BlCgRefundAccountDTOList)) {
					BlCgRefundAccountSetDTO blCgAccountSetDTO = new BlCgRefundAccountSetDTO();
					blCgAccountSetDTO.setSrcfunc_des(IBlCgCodeConst.IpRtnCompensteFee);
					blCgAccountSetDTO.setEu_rfdmode(RefundModeEnum.CG_KEY);
					//设置退记账人员
					WsParamBillCostInfo prepayInfo = param.getCostInfo();
					if(!StringUtil.isEmpty(prepayInfo.getOperaCG())){
						// 设置人员上下文
						PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCG());
						if (psndocDO == null) {
							throw new BizException("住院退补费:未查询到退记账人员信息");
						}
						blCgAccountSetDTO.setId_emp_cg(psndocDO.getId_psndoc());
					}
					// 调用退费接口
					BLThirdItfLogger.info("调用IBlCgAccountService接口方法keepAccountForIp开始 退费"
							+ ArrayUtils.toString(BlCgRefundAccountDTOList));
					if (BlCgRefundAccountDTOList != null && BlCgRefundAccountDTOList.size() > 0) {
						IBlCgAccountService blCgAccountService = ServiceFinder.find(IBlCgAccountService.class);
						blCgAccountService.refundAccountForIp(
								BlCgRefundAccountDTOList.toArray(new BlCgRefundAccountDTO[] {}), blCgAccountSetDTO);
					}
				} else {
					throw new BizException("住院退补费失败");
				}
				BLThirdItfLogger.info("调用IBlCgAccountService接口方法keepAccountForIp结束");

				// “无需计费项目”返回成功
				// if (rtn != null && FBoolean.FALSE.equals(rtn.getFg_success())
				// &&
				// !getSuccessMessage().contains(rtn.getError_code())) {
				// throw new BizException(rtn.getError_msg());
				// }

				// 发送收费信息到集成平台
				// invokeOpAccEvent(dtos);
			} catch (Exception e) {
				e.printStackTrace();
				BLThirdItfLogger.error(e.getMessage(), e);
				throw new BizException(e.getMessage());
			}
		}
	}

	/**
	 * 组装新增记账数据
	 * 
	 * @param patiVistDO
	 * @param ciOrderDO
	 * @param medSrvDO
	 * @param BlCostAddItemParamDTO
	 * @param depId
	 * @return BlCgAccountDTO
	 * @author du_peng
	 */
	private BlCgAccountDTO getBlCgAccountDTO(PatiVisitDO patiVistDO, CiOrderDO ciOrderDO, MedSrvDO medSrvDO,
			MeterialDO meterialDO, WsParamBillCostItemInfo itemParamDTO) {
		BlCgAccountDTO tmpDTO = new BlCgAccountDTO();
		tmpDTO.setId_ent(patiVistDO.getId_ent()); // 就诊ID

		tmpDTO.setId_pat(patiVistDO.getId_pat()); // 患者ID
		if (ciOrderDO != null) {
			tmpDTO.setId_or(ciOrderDO.getId_or()); // 医嘱ID
		}

		// tmpDTO.setId_orsrv(""); //医嘱服务
		tmpDTO.setId_srv(medSrvDO.getId_srv()); // 服务
		// tmpDTO.setId_or_prsrv(""); //医嘱服务执行计划
		// tmpDTO.setId_unit_srv(""); //服务单位
		tmpDTO.setFg_mm(FBoolean.FALSE); // 物品管理标识
		if (itemParamDTO != null) {

			FDouble dTmp = new FDouble(Double.parseDouble(itemParamDTO.getPrice()));
			tmpDTO.setPrice_std(dTmp); // 标准价
			tmpDTO.setPrice_ratio(dTmp); // 折扣价
			tmpDTO.setRatio_pripat(new FDouble(1)); // 价格比例
			// tmpDTO.setBatch(String Batch); //批次
			if (itemParamDTO.getBarCode() != null) {
				tmpDTO.setOnly_code(itemParamDTO.getBarCode()); // 唯一码
			}
		}
		if (meterialDO != null) {
			tmpDTO.setFg_mm(FBoolean.TRUE); // 物品管理标识
			tmpDTO.setId_mm(meterialDO.getId_mm()); // 物品
			tmpDTO.setId_pkgu_cur(meterialDO.getId_unit_pkgbase()); // 物品单位
		}
		tmpDTO.setQuan(new FDouble(itemParamDTO.getQuan())); // 数量
		return tmpDTO;

	}

	/**
	 * 根据医嘱编码和服务编码获取补费参数DTO
	 * 
	 * @param orderCode
	 * @param chargeCode
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private WsParamBillCostItemInfo getBlCostAddItemParamDTO(WsParamSetCostBill param, CiOrderDO ciOrderDO,
			MedSrvDO medSrvDO) {
		String orderCode = "";
		if (ciOrderDO != null) {
			orderCode = ciOrderDO.getCode_or();
		}
		String chargeCode = medSrvDO.getCode();

		if ((StringUtil.isEmptyWithTrim(orderCode))) {
			List<WsParamBillCostItemInfo> itemList = param.getCostInfo().getChargeitems();
			for (int i = 0; i < itemList.size(); i++) {
				WsParamBillCostItemInfo subItem = (WsParamBillCostItemInfo) itemList.get(i);
				if (chargeCode.equals(subItem.getChargeCode())) {
					return subItem;
				}
			}
		} else {
			if (orderCode.equals(param.getCostInfo().getOrderCode())) {
				List<WsParamBillCostItemInfo> itemList = param.getCostInfo().getChargeitems();
				for (int i = 0; i < itemList.size(); i++) {
					WsParamBillCostItemInfo subItem = (WsParamBillCostItemInfo) itemList.get(i);
					if (chargeCode.equals(subItem.getChargeCode())) {
						return subItem;
					}
				}
			} // if (orderCode.equals(param.getOrdercode()))
		} // else

		return null;
	}

	/**
	 * 查询补退费方向
	 * 
	 * @param code_or
	 * @param param
	 * @return
	 * @throws BizException
	 */

	private Integer getDirectFlag(String code_or, WsParamSetCostBill param) throws BizException {
		String sDirectFlag = "0";
		if (code_or != null) {
			if (code_or.equals(param.getCostInfo().getOrderCode())) {
				sDirectFlag = param.getCostInfo().getDirectFlag();

			}
		} else {
			if (StringUtils.isBlank(param.getCostInfo().getOrderCode())) {
				sDirectFlag = param.getCostInfo().getDirectFlag();
			}

		}
		String[] arr = { "-1", "1" };
		if (!ArrayUtils.contains(arr, sDirectFlag)) {
			throw new BizException("费用方向标识不是一个有效值！");
		}
		Integer iDirectFlag = new Integer(sDirectFlag);
		return iDirectFlag;

	}

	/**
	 * 查服务编码为空的服务信息
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] initMedSvrInfo(WsParamSetCostBill param) throws BizException {
		FArrayList listMedSrvform = new FArrayList();

		if (StringUtils.isBlank(param.getCostInfo().getOrderCode())) {
			List<WsParamBillCostItemInfo> itemList = param.getCostInfo().getChargeitems();
			for (int i = 0; i < itemList.size(); i++) {
				WsParamBillCostItemInfo subItem = (WsParamBillCostItemInfo) itemList.get(i);
				if (StringUtil.isEmptyWithTrim(subItem.getChargeCode())) {
					// 判断物品编码是否为空
					if (StringUtil.isEmptyWithTrim(subItem.getMmCode())) {
						throw new BizException("住院补费：物品编码为空异常！");
					} else {
						MedSrvDO tmpMedSrvDo = this.GetMedSrvInfo(subItem.getMmCode());
						if (tmpMedSrvDo == null) {
							throw new BizException("住院补费：编码为[" + subItem.getMmCode() + "]的物品不存在！");
						}
						subItem.setChargeCode(tmpMedSrvDo.getCode());
						listMedSrvform.add(subItem.getChargeCode());
					}
				} else {
					listMedSrvform.add(subItem.getChargeCode());
				}
			}
		}

		if (listMedSrvform.size() > 0) {
			// logger.debug("listMedSrvform.size() > zero ");
			// 获取医疗服务_项目
			IMedsrvMDORService srvSerivce = ServiceFinder.find(IMedsrvMDORService.class);// SRV服务
			MedSrvDO[] medsrvs = srvSerivce.findByAttrValList(MedSrvDO.CODE, listMedSrvform);

			if (medsrvs == null || medsrvs.length < 0) {
				throw new BizException("住院补费：服务编码为" + listMedSrvform + "的服务不存在！");
			}
			// logger.debug("开始遍历 值，为了 ");
			if (medsrvs.length != listMedSrvform.size()) {
				for (MedSrvDO medSrvDO : medsrvs) {
					// Log.debug(medSrvDO.getBoil_code());
					if (FBoolean.TRUE.equals(medSrvDO.getFg_active())) {
						throw new BizException("住院补费：服务编码为" + medSrvDO.getCode() + "的服务无效！");
					}
					if (listMedSrvform.contains(medSrvDO.getCode())) {
						listMedSrvform.remove(medSrvDO.getCode());
					}
				}
				throw new BizException("住院补费：服务编码为" + listMedSrvform + "的服务不存在！");
			}
			return medsrvs;
		}
		return null;
	}

	/**
	 * 根据医嘱编码查询服务信息
	 * 
	 * @param code_or
	 * @param param
	 * @return
	 * @throws BizException
	 */

	private MedSrvDO[] initMedSvrInfo(String code_or, WsParamSetCostBill param) throws BizException {
		FArrayList listMedSrvform = new FArrayList();

		if (code_or.equals(param.getCostInfo().getOrderCode())) {
			List<WsParamBillCostItemInfo> itemList = param.getCostInfo().getChargeitems();
			for (int i = 0; i < itemList.size(); i++) {
				WsParamBillCostItemInfo subItem = (WsParamBillCostItemInfo) itemList.get(i);
				if (StringUtil.isEmptyWithTrim(subItem.getChargeCode())) {
					// 判断物品编码是否为空
					if (StringUtil.isEmptyWithTrim(subItem.getMmCode())) {
						throw new BizException("住院补费：物品编码为空异常！");
					} else {
						MedSrvDO tmpMedSrvDo = this.GetMedSrvInfo(subItem.getMmCode());
						if (tmpMedSrvDo == null) {
							throw new BizException("住院补费：编码为[" + subItem.getMmCode() + "]的物品不存在！");
						}
						subItem.setChargeCode(tmpMedSrvDo.getCode());
						listMedSrvform.add(subItem.getChargeCode());
					}
				} else {
					listMedSrvform.add(subItem.getChargeCode());
				}
			}
			if (listMedSrvform.size() > 0) {
				// 获取医疗服务_项目
				BLThirdItfLogger.info("获取医疗服务_项目开始");
				IMedsrvMDORService srvSerivce = ServiceFinder.find(IMedsrvMDORService.class);// SRV服务
				MedSrvDO[] medsrvs = srvSerivce.findByAttrValList(MedSrvDO.CODE, listMedSrvform);
				BLThirdItfLogger.info("获取医疗服务_项目结束");
				if (medsrvs == null || medsrvs.length < 0) {
					throw new BizException("住院补费：服务编码为" + listMedSrvform + "的服务不存在！");
				}
				return medsrvs;
			} // if (listMedSrvform.size() > 0)
		} // if (orderCode.equalsparam.getOrdercode()))
		return null;
	}

	/**
	 * 根据医嘱编码查询医嘱id
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */

	private CiOrderDO[] initOrderInfo(WsParamSetCostBill param) throws BizException {
		if (param.getCostInfo().getOrderCode() != null) {

			BLThirdItfLogger.info("调用ICiorderMDORService接口方法findByAttrValList开始");
			ICiorderMDORService ciService = ServiceFinder.find(ICiorderMDORService.class);
			CiOrderDO[] orders = ciService.findByAttrValString(CiOrderDO.CODE_OR, param.getCostInfo().getOrderCode());
			if (orders == null || orders.length < 0) {
				throw new BizException("住院补费：医嘱编码为" + param.getCostInfo().getOrderCode() + "的医嘱不存在！");
			}
			BLThirdItfLogger.info("调用ICiorderMDORService接口方法findByAttrValList结束");
			return orders;
		}
		return null;
	}

	/**
	 * 根据物品编码查询服务信息
	 * 
	 * @param mmCode
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO GetMedSrvInfo(String mmCode) throws BizException {
		// 获取患者本次就诊信息
		DAFacade daFacade = new DAFacade();
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append("SELECT b.id_srv, ");
		sqlStrBuf.append("  b.code ");
		sqlStrBuf.append("FROM bd_mm a ");
		sqlStrBuf.append("inner join bd_srv b on a.id_srv = b.id_srv ");
		sqlStrBuf.append("WHERE (a.code = ?) ");
		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(mmCode);
		List<MedSrvDO> tmpDTO = (List<MedSrvDO>) daFacade.execQuery(sqlStrBuf.toString(), sqlp1,
				new BeanListHandler(MedSrvDO.class));
		if (tmpDTO == null || tmpDTO.size() <= 0) {
			throw new BizException("编码为[" + mmCode + "]的物品不存在！");
		}
		if (tmpDTO != null && tmpDTO.size() > 0) {
			return tmpDTO.get(0);
		}
		return null;
	}

	/**
	 * 根据患者编码和住院次数查询患者信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */

	private PatiVisitDO initPatiVisitInfo(WsParamSetCostBill param) throws BizException {
		// 获取患者本次就诊信息
		DAFacade daFacade = new DAFacade();
		StringBuilder sqlStrBuf = new StringBuilder();
		sqlStrBuf.append("SELECT a.id_pat, ");
		sqlStrBuf.append(" a.id_ent, ");
		sqlStrBuf.append(" a.id_pripat, ");
		sqlStrBuf.append(" a.fg_st ");
		sqlStrBuf.append("FROM en_ent a ");
		sqlStrBuf.append("inner join en_ent_ip b on a.id_ent = b.id_ent ");
		sqlStrBuf.append("inner join pi_pat pat on a.id_pat= pat.id_pat ");
		sqlStrBuf.append("WHERE (pat.code = ?) ");
		sqlStrBuf.append(" AND (b.times_ip = ?) ");
		SqlParam sqlp1 = new SqlParam();
		sqlp1.addParam(param.getCostInfo().getPatCode());
		Integer timesIp = new Integer(param.getCostInfo().getTimesIP());
		sqlp1.addParam(timesIp);
		List<PatiVisitDO> tmpDTO = (List<PatiVisitDO>) daFacade.execQuery(sqlStrBuf.toString(), sqlp1,
				new BeanListHandler(PatiVisitDO.class));
		if (tmpDTO == null || tmpDTO.size() <= 0) {
			throw new BizException("住院补费：患者编码为" + param.getCostInfo().getPatCode() + "("
					+ param.getCostInfo().getTimesIP() + ")的就诊患者不存在！");
		}
		if (tmpDTO != null && tmpDTO.size() > 0) {
			return tmpDTO.get(0);
		}
		return null;
	}

	/**
	 * 查询部门id
	 * 
	 * @param mpdepcode
	 * @return
	 * @throws BizException
	 */

	private String initDeptId(String mpdepcode) throws BizException {
		DeptDO[] dept = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.CODE, mpdepcode);
		if (dept != null && dept.length > 0) {
			// 设置上下文科室信息
			Context.get().setDeptId(dept[0].getId_dep());
			return dept[0].getId_dep();
		}
		if (dept == null || dept.length < 0) {
			throw new BizException("住院补费：编码为[" + mpdepcode + "]的科室不存在！");
		}
		return "";
	}

	/**
	 * 组装退费记账数据
	 * 
	 * @param patiVistDO
	 * @param ciOrderDO
	 * @param medSrvDO
	 * @param BlCostAddItemParamDTO
	 * @param depId
	 * @return BlCgAccountDTO
	 * @author du_peng
	 * @throws BizException
	 */
	private List<BlCgRefundAccountDTO> getBlCgRefundAccountDTO(PatiVisitDO patiVistDO, CiOrderDO ciOrderDO,
			MedSrvDO medSrvDO, MeterialDO meterialDO, WsParamBillCostItemInfo itemParamDTO) throws BizException {
		List<BlCgRefundAccountDTO> tmpDTO = new ArrayList<BlCgRefundAccountDTO>();
		IBlcgqueryRService iBlcgqueryRService = ServiceFinder.find(IBlcgqueryRService.class);
		StringBuffer whereStr = new StringBuffer();
		whereStr.append(" id_pat ='" + patiVistDO.getId_pat() + "'");
		whereStr.append(" and  id_srv ='" + medSrvDO.getId_srv() + "'");
		whereStr.append(" and  price ='" + itemParamDTO.getPrice() + "'");
		if (ciOrderDO != null) {
			whereStr.append(" and id_or ='" + ciOrderDO.getId_or() + "'");
		}
		if (meterialDO != null) {
			whereStr.append(" and id_mm ='" + meterialDO.getId_mm() + "'");
		}
		whereStr.append(" and  fg_refund = 'N' and eu_direct = 1 ");
		String orderStr = " dt_or desc";
		BlCgIpDO[] blCgIpDOs = iBlcgqueryRService.find(whereStr.toString(), orderStr, FBoolean.FALSE);
		if (ArrayUtils.isEmpty(blCgIpDOs)) {
			throw new BizException("服务编码 " + itemParamDTO.getChargeCode() + "无可退费的数据");
		}
		FDouble canrnt = FDouble.ZERO_DBL;
		for (BlCgIpDO blCgIpDO : blCgIpDOs) {
			canrnt = canrnt.add(blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret()));
		}

		// 组装可退费的记账信息
		FDouble itfQuan = new FDouble(itemParamDTO.getQuan());
		if (canrnt.sub(itfQuan).compareTo(FDouble.ZERO_DBL) < 0) {
			throw new BizException("服务编码 " + itemParamDTO.getChargeCode() + "可退数量大于退费数量");
		}
		for (BlCgIpDO blCgIpDO : blCgIpDOs) {
			FDouble quan = blCgIpDO.getQuan().sub(blCgIpDO.getQuan_ret());
			FDouble relQuan = itfQuan.sub(quan);
			BlCgRefundAccountDTO cgRefundDTO = new BlCgRefundAccountDTO();
			if (relQuan.compareTo(FDouble.ZERO_DBL) > 0) {
				cgRefundDTO = this.setBlCgRefundAccountDTO(blCgIpDO, quan);
			} else {
				cgRefundDTO = this.setBlCgRefundAccountDTO(blCgIpDO, itfQuan);
			}

			tmpDTO.add(cgRefundDTO);
			itfQuan = relQuan;
			if (itfQuan.compareTo(FDouble.ZERO_DBL) <= 0) {
				break;
			}

		}
		return tmpDTO;

	}

	/**
	 * 设置可退数量
	 * 
	 * @param blCgIpDO
	 * @param relQuan
	 * @return
	 */
	private BlCgRefundAccountDTO setBlCgRefundAccountDTO(BlCgIpDO blCgIpDO, FDouble relQuan) {
		BlCgRefundAccountDTO refundDto = new BlCgRefundAccountDTO();
		refundDto.setId_cg(blCgIpDO.getId_cgip());
		refundDto.setId_ent(blCgIpDO.getId_ent());
		refundDto.setQuan(relQuan);
		return refundDto;
	}

}

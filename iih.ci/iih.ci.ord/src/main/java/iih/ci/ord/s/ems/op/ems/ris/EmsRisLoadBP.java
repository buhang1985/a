package iih.ci.ord.s.ems.op.ems.ris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.define.StringList;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.op.base.OpBaseEmsLoadBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;

/**
 * 检查医疗单加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsRisLoadBP extends OpBaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx, args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo) {
			throw new BizException("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());

		EmsObsItemDO ems = emsObsItemInfoFrom(ctx, ciEmsInfo, medSrvAggInfo);
		// 医疗单对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO());
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrvAggInfo.getParentDO().getId_srv(), "","","",medSrvAggInfo.getParentDO().getFg_long(),FBoolean.FALSE,ems.getDt_begin_ui());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 保存执行科室过滤条件
			if("1".equals(wf.getMp_source())){
				OrderEmsExtInfoUtils.SetMpDepFilter(rst,null);
			}else{
				OrderEmsExtInfoUtils.SetMpDepFilter(rst,
						CiOrdUtils.isEmpty(wf.getId_mp_depts()) ? null : wf.getId_mp_depts());
			}
			
			// 保存物资流向
			OrderEmsExtInfoUtils.SetWhDepFilter(rst,
					CiOrdUtils.isEmpty(wf.getId_dept_whs()) ? null : wf.getId_dept_whs());
			OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
			OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		}
		// 医疗单模型文档
		rst.setDocument(handleReturnDocument(ems));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
		// 医疗单类型
		rst.getDriverInfo().setEmsBackendDriver(EmsType.RIS.toString());
		return rsts;
	}

	protected EmsObsItemDO emsObsItemInfoFrom(CiEnContextDTO ctx, CiEmsDTO dto, MedsrvAggDO ordMainSrvAggInfo)
			throws BizException {
		EmsObsItemDO ems = new EmsObsItemDO();

		if (!dto.getOrapplysheet().containsKey((EmsType.RIS).toString())) {
			throw new BizException("获取申请单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
		}
		Object objInfo = dto.getOrapplysheet().get((EmsType.RIS).toString());

		OrdApObsDO apobs = (OrdApObsDO) objInfo;
		ems.setId_or(dto.getId_or());
		ems.setId_srv(dto.getId_srv()); // 服务id SING
		ems.setName_srv(dto.getName());// 服务名称 SING
		///////// 添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		ems.setSd_frequnitct(dto.getSd_frequnitct());// yzh 多剂量多次
		// 是否多剂量
		// ems.setIsmuldose(FBoolean.TRUE);
		ems.setIsmuldose(ordMainSrvAggInfo.getParentDO().getIsmuldose());
		ems.setFreqct(dto.getFreqct());
		// 是否多次执行
		// ems.setIsmulexec(FBoolean.TRUE);
		ems.setIsmulexec(ordMainSrvAggInfo.getParentDO().getIsmulexec());
		///////// 添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		ems.setAnnouncements(apobs.getAnnouncements());
		ems.setQuan_med(dto.getQuan_medu());
		// 还原bd_srv todo
		ems.setId_srvtp(dto.getId_srvtp()); // 服务类型
		ems.setNo_applyobs(apobs.getNo_applyform()); // 检查申请单号
		ems.setFg_urgent(apobs.getFg_urgent()); // 加急标识
		ems.setFg_mp_bed(dto.getFg_mp_bed()); // 床旁执行标志
		ems.setDt_plan(apobs.getDt_plan()); // 计划检查时间
		// 诊断信息映射
		ems.setId_di(apobs.getId_di()); // 诊断主项目id
		ems.setName_diag(apobs.getName_diag()); // 医疗单选择诊断的名称
		ems.setId_diitm(apobs.getId_diitm()); // 医疗单选择诊断的id
		ems.setId_didef(dto.getId_didef());//bd的诊断信息
		// 超量用药原因
		ems.setId_excessive_reason(dto.getId_excessive_reason());
		ems.setSd_excessive_reason(dto.getSd_excessive_reason());
		ems.setName_excessive_reason(dto.getName_excessive_reason());

		// 诊断的拼接需要取当前最新的值
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			ems.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			ems.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			ems.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
		}

		ems.setSd_pps(apobs.getSd_pps()); // 检查目的编码
		ems.setId_pps(apobs.getId_pps()); // 检查目的
		ems.setDes_pps(apobs.getDes_pps()); // 检查目的描述
		ems.setName_pps(apobs.getName_pps());
		ems.setDes_sympsign(apobs.getDes_sympsign());//病情描述
		ems.setDes_or(dto.getDes_or()); // 备注
		ems.setFg_selfpay((dto.getEu_hpindicjudge() == HpIndicJudgeEnum.SELFPAY ? FBoolean.TRUE : FBoolean.FALSE));
		ems.setEu_hpjudge(dto.getEu_hpjudge());
		ems.setEu_orhp(dto.getEu_orhp());
		// 拓展字段
		ems.setDef1(apobs.getDef1());
		ems.setDef2(apobs.getDef2());
		ems.setDef3(apobs.getDef3());
		ems.setDef4(apobs.getDef4());
		ems.setDef5(apobs.getDef5());
		ems.setDef6(apobs.getDef6());
		ems.setDef7(apobs.getDef7());
		ems.setDef8(apobs.getDef8());
		ems.setDef9(apobs.getDef9());
		ems.setDef10(apobs.getDef10());
		ems.setDef11(apobs.getDef11());
		ems.setDef12(apobs.getDef12());
		ems.setDef13(apobs.getDef13());
		ems.setDef14(apobs.getDef14());
		ems.setDef15(apobs.getDef15());
		ems.setDef16(apobs.getDef16());
		ems.setDef17(apobs.getDef17());
		ems.setDef18(apobs.getDef18());
		ems.setDef19(apobs.getDef19());
		ems.setDef20(apobs.getDef20());
		ems.setDef21(apobs.getDef21());
		ems.setDef22(apobs.getDef22());
		ems.setDef23(apobs.getDef23());
		ems.setDef24(apobs.getDef24());
		ems.setDef25(apobs.getDef25());
		ems.setDef26(apobs.getDef26());
		ems.setDef27(apobs.getDef27());
		ems.setDef28(apobs.getDef28());
		ems.setDef29(apobs.getDef29());
		ems.setDef30(apobs.getDef30());
		ems.setDef31(apobs.getDef31());
		ems.setDef32(apobs.getDef32());
		ems.setDef33(apobs.getDef33());
		ems.setDef34(apobs.getDef34());
		ems.setDef35(apobs.getDef35());
		ems.setDef36(apobs.getDef36());
		ems.setDef37(apobs.getDef37());
		ems.setDef38(apobs.getDef38());
		ems.setDef39(apobs.getDef39());
		ems.setDef40(apobs.getDef40());
		ems.setDef41(apobs.getDef41());
		ems.setDef42(apobs.getDef42());
		ems.setDef43(apobs.getDef43());
		ems.setDef44(apobs.getDef44());
		ems.setDef45(apobs.getDef45());
		ems.setDef46(apobs.getDef46());
		ems.setDef47(apobs.getDef47());
		ems.setDef48(apobs.getDef48());
		ems.setDef49(apobs.getDef49());
		ems.setDef50(apobs.getDef50());
		ems.setClinicalzztz(apobs.getClinicalzztz());
		ems.setAuximtexam(apobs.getAuximtexam());
		ems.setPastillness(apobs.getPastillness());

		ems.setUse_days(dto.getDays_or());
		ems.setId_mp_dep(dto.getId_dep_mp());
		ems.setName_mp_dep(dto.getName_dep_mp());

		ems.setStatus(DOStatus.UPDATED);
		// 医疗服务套项目定义,用于展现检查申请单中的检查部位
		MedSrvSetItemDO[] szMedSrvSetItem = null;

		MedsrvAggDO[] szMedSrvAggInfo = null;
		ems.setFg_set(dto.getFg_set());
		if (CiOrdUtils.isTrue(dto.getFg_set())) {
			ems.setUse_days(dto.getDays_or());
			ems.setId_unit_med(dto.getId_unit_med());
			ems.setName_unit_med(dto.getName_unit_med());
			ems.setQuan_med(dto.getQuan_medu());
			ems.setId_unit_sale(dto.getId_unit_med());
			ems.setName_unit_sale(dto.getName_unit_med());
			ems.setQuan_cur(new FDouble(dto.getTimes_cur().doubleValue()));
			szMedSrvSetItem = GetItemInSet(dto.getId_srv(), true);

			// 获取套内项目的所有定义服务数据
			StringList listSrvId = new StringList();
			for (MedSrvSetItemDO item : szMedSrvSetItem) {
				listSrvId.add(item.getId_srv_itm());
			}

			// 获取套内项目的基础服务定义信息
			szMedSrvAggInfo = ServiceFinder.find(IMedsrvRService.class)
					.findByIds(listSrvId.toArray(new String[listSrvId.size()]), FBoolean.FALSE);

			// 获取医疗单中的套内项目, 如果服务套医嘱没有套内项目信息，报错处理
			FArrayList srvSetItemList = (FArrayList) dto.getSrvsetitms().get(dto.getId_srv());
			if (srvSetItemList == null || srvSetItemList.size() == 0) {
				throw new BizException("此服务套医嘱存在错误，缺失套内项目信息", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_SETITEMS_NULL);
			}

			// 字典化-套内项目
			Map<String, OrdSrvSetDO> tmpOrdSrvSetMap = new HashMap<String, OrdSrvSetDO>();

			for (Object o : srvSetItemList) {
				OrdSrvSetDO ordSrvSetInfo = (OrdSrvSetDO) o;

				tmpOrdSrvSetMap.put(ordSrvSetInfo.getId_srvset(), ordSrvSetInfo);

			}

			// 字典化-服务项目
			Map<String, CiEmsSrvDTO> tmpSrvItemCache = new HashMap<String, CiEmsSrvDTO>();
			for (Object o : dto.getEmssrvs()) {
				CiEmsSrvDTO srvInfo = (CiEmsSrvDTO) o;
				tmpSrvItemCache.put(srvInfo.getId_srv(), srvInfo);
				if(StringUtils.isBlank(ems.getId_srv()) && ems.getId_srv().equals(ems.getId_srv())) {
				  ems.setPrice(srvInfo.getPrice());
				}
			}

			// 字典化-套内基础服务项目
			Map<String, MedsrvAggDO> tmpSrvItemMedSrvAggCache = new HashMap<String, MedsrvAggDO>();
			for (MedsrvAggDO agg : szMedSrvAggInfo) {
				tmpSrvItemMedSrvAggCache.put(agg.getParentDO().getId_srv(), agg);
			}

			// 构建检查套内项目列表数据源模型
			FArrayList obsList = new FArrayList();
			for (MedSrvSetItemDO item : szMedSrvSetItem)// 检查部位
			{
				EmsObsLap obs = new EmsObsLap();
				obs.setFg_edit(item.getFg_edit());
				obs.setId_srv(item.getId_srv_itm());

				if (tmpSrvItemMedSrvAggCache.containsKey(item.getId_srv_itm())) {
					MedsrvAggDO agg = tmpSrvItemMedSrvAggCache.get(item.getId_srv_itm());

					// 构建检查属性信息
					if (agg.getMedSrvRisDO() != null && agg.getMedSrvRisDO().length > 0) {
						MedSrvRisDO medSrvRis = agg.getMedSrvRisDO()[0];

						// 部位id、编码、名称
						obs.setId_body(medSrvRis.getId_body());
						obs.setSd_body(medSrvRis.getSd_body());
						obs.setName_body(medSrvRis.getName_body());
						
						// 体位 Id、编码、名称
						obs.setId_pos(medSrvRis.getId_pos());
						obs.setSd_pos(medSrvRis.getSd_pos());
						obs.setName_pos(medSrvRis.getName_pos());

						// 是否有检查部位
						obs.setFg_pos(medSrvRis.getFg_pos());

						obs.setAnnouncements(medSrvRis.getNote());
						obs.setFg_or(item.getFg_clinical());// todo
						//部位可修改标志
						obs.setFg_body_update(medSrvRis.getFg_body_update());
					}
					MedSrvDO setItemMedSrvInfo = agg.getParentDO();
					// 计价方式
					obs.setEu_blmd(setItemMedSrvInfo.getEu_blmd());
					obs.setId_srv(setItemMedSrvInfo.getId_srv());
					obs.setName_srv(setItemMedSrvInfo.getName());
					obs.setSd_srvtp(setItemMedSrvInfo.getSd_srvtp());
					obs.setId_srvtp(setItemMedSrvInfo.getId_srvtp());
					obs.setId_primd(setItemMedSrvInfo.getId_primd());
					obs.setFg_bl(setItemMedSrvInfo.getFg_bl());
					obs.setQuan_medu(item.getQuan_medu());
					obs.setId_medu(item.getId_medu());
					if (tmpSrvItemCache.containsKey(obs.getId_srv())) {
						CiEmsSrvDTO srvInfo = tmpSrvItemCache.get(obs.getId_srv());
						obs.setId_orsrv(srvInfo.getId_orsrv());
					}
				}

				if (tmpOrdSrvSetMap.containsKey(item.getId_srv_itm())) {
					obs.setFg_chk(FBoolean.TRUE);
					//部位可能在前台已经被修改，名称保存在ci_or_srv_set表中
					obs.setName_body(tmpOrdSrvSetMap.get(item.getId_srv_itm()).getBody_name());
					obs.setId_quan(tmpOrdSrvSetMap.get(item.getId_srv_itm()).getId_medu());
					obs.setQuan_medu(tmpOrdSrvSetMap.get(item.getId_srv_itm()).getQuan_medu());
					// headDo.Emsapobs.EmsOrObsListDel.Add(obs);
				}
				obsList.add(obs);
			}
			ems.setEmsOrObsListEx(obsList);
		} else {
			CiEmsSrvDTO srv = this.mainSrvInfoFrom(ctx, dto);

			if (null != srv) {
				ems.setId_unit_sale(srv.getId_unit_sale());
				ems.setName_unit_sale(srv.getName_unit_sale());
				ems.setQuan_cur(srv.getQuan_cur());
				ems.setFg_indic(srv.getFg_indic());
				ems.setId_unit_med(srv.getId_unit_med());
				ems.setId_orsrv(srv.getId_orsrv());
			   
				if (!CiOrdUtils.isEmpty(ordMainSrvAggInfo.getMedSrvRisDO())) {
					ems.setId_body(ordMainSrvAggInfo.getMedSrvRisDO()[0].getId_body()); // 身体部位id
					// 部位编码_
					ems.setSd_body(ordMainSrvAggInfo.getMedSrvRisDO()[0].getSd_body()); // 身体部位编码
				}

				// SINGLE
				// Stri
				ems.setId_primd(ordMainSrvAggInfo.getParentDO().getId_primd());
				ems.setId_primd(ordMainSrvAggInfo.getParentDO().getId_primd()); // 获取定价模式，TODO
				ems.setPrice(srv.getPrice());
				EmsObsLap obs = new EmsObsLap();
				// 计价方式
				obs.setEu_blmd(srv.getEu_blmd());
				obs.setId_body(srv.getId_body());
				obs.setSd_body(srv.getSd_body());
				if (!CiOrdUtils.isEmpty(ordMainSrvAggInfo.getMedSrvRisDO())) {
					obs.setFg_body_update(ordMainSrvAggInfo.getMedSrvRisDO()[0].getFg_body_update());
					obs.setName_body(ordMainSrvAggInfo.getMedSrvRisDO()[0].getName_body());
					obs.setName_pos(ordMainSrvAggInfo.getMedSrvRisDO()[0].getName_pos());
					obs.setFg_pos(ordMainSrvAggInfo.getMedSrvRisDO()[0].getFg_pos());
				}
				
				obs.setId_pos(srv.getId_pos());
				obs.setSd_pos(srv.getSd_pos());
				obs.setName_srv(srv.getName_srv());
				obs.setId_orsrv(srv.getId_orsrv());
				obs.setId_srv(srv.getId_srv());
				obs.setSd_srvtp(srv.getSd_srvtp());
				obs.setId_srvtp(srv.getId_srvtp());
				obs.setFg_chk(FBoolean.TRUE);
				obs.setQuan_medu(ordMainSrvAggInfo.getParentDO().getQuan_med());
				obs.setId_medu(ordMainSrvAggInfo.getParentDO().getId_unit_med());
				obs.setFg_bl(srv.getFg_bl());
				FArrayList obsList = new FArrayList();
				obsList.add(obs);
				ems.setEmsOrObsListEx(obsList);
			}
		}
		// 计算价格
		if(ems.getPrice() == null) {
			ems.setPrice(this.calculatePrice(ordMainSrvAggInfo.getParentDO(), ems.getEmsOrObsListEx(), ctx)); 
		}
		
		return ems;
	}

	/// <summary>
	/// 获得集合中医生开立的服务项目
	/// </summary>
	/// <param name="list"></param>
	/// <returns></returns>
	public List<CiEmsSrvDTO> getPhysignSrv(FArrayList list) {
		List<CiEmsSrvDTO> cests = new ArrayList<CiEmsSrvDTO>();
		if (list == null)
			return cests;
		for (Object o : list) {
			CiEmsSrvDTO dto = (CiEmsSrvDTO) o;
			if (dto.getEu_sourcemd() != null && (dto.getEu_sourcemd() == (int) OrSrvSourceFromEnum.PHYSIAN)
					|| dto.getEu_sourcemd() == (int) OrSrvSourceFromEnum.CP)// 添加临床路径开的医嘱
			{
				cests.add(dto);
			}
		}
		return cests;
	}

	/**
	 * 获取套内项目
	 * 
	 * @param id_srv
	 * @param is_clinical
	 * @return
	 * @throws BizException
	 */
	protected MedSrvSetItemDO[] GetItemInSet(String id_srv, boolean is_clinical) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class).find(String
				.format("a8.fg_clinical='%s' and a8.id_srv='%s' and a8.fg_active='Y'", is_clinical ? "Y" : "N", id_srv),
				"", FBoolean.FALSE);
	}

	/**
	 * 计算医嘱临床价格
	 * 
	 * @param szOrdSrvInfo
	 * @return
	 * @throws BizException
	 */
	protected FDouble calculatePrice(OrdSrvDO[] szOrdSrvInfo) throws BizException {
		FDouble price = new FDouble(0);
		for (OrdSrvDO ordSrvInfo : szOrdSrvInfo) {
			if (ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.PHYSIAN)
					|| ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMPRIMD)
					|| ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD)) {
				price = price.add(ordSrvInfo.getPri());
			}
		}
		return price;
	}

	protected FDouble calculatePrice(CiEmsSrvDTO[] szOrdSrvInfo) throws BizException {
		FDouble price = new FDouble(0);
		for (CiEmsSrvDTO ordSrvInfo : szOrdSrvInfo) {
			if (ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.PHYSIAN)
					|| ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMPRIMD)
					|| ordSrvInfo.getEu_sourcemd().equals(OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD)) {
				price = price.add(ordSrvInfo.getPrice());
			}
		}
		return price;
	}

	/// <summary>
	/// 医嘱服务计算价格（非物品计价）
	/// </summary>
	/// <param name="medsrv"></param>
	/// <param name="EmsOrObsList"></param>
	public FDouble calculatePrice(MedSrvDO medsrv, FArrayList emsOrObsList, CiEnContextDTO ctx) throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
		int iNumber = 0;

		priParam.setId_srv(medsrv.getId_srv());
		priParam.setId_primd(medsrv.getId_primd());
		priParam.setNum(iNumber);
		if (emsOrObsList != null) {
			FArrayList setItemSrvList = new FArrayList();
			for (Object obLap : emsOrObsList) {
				EmsObsLap lap = (EmsObsLap) obLap;
				if (CiOrdUtils.isTrue(lap.getFg_chk())) {
					iNumber++;
					BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
					param.setId_srv(lap.getId_srv());
					param.setId_primd(lap.getId_primd());
					
					FDouble quan_medu =lap.getQuan_medu();
					Integer num = (int) (quan_medu == null ? 1 : Math.ceil(quan_medu.toDouble()));
					param.setNum(num);
					
					setItemSrvList.add(param);
				}
			}
			priParam.setNum(iNumber);
			priParam.setSrvsetitms(setItemSrvList);
		}

		MedSrvPriceDO priceDo = ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCalByPriMode(priParam,
				ctx.getId_pripat());
		if (priceDo != null) {
			return priceDo.getPrice_ratio();
		}

		return FDouble.ZERO_DBL;
	}

}

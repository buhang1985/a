package iih.ci.ord.s.ems.op.ems.lis;

import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDSamptpInfoCache;
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
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验医疗单加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsLisLoadBP extends OpBaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx,args);
		EmsRstDTO rst = rsts[0];
		EmsLoadDTO arg = args[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo) {
			throw new BizException("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());

		EmsObsItemDO ems = emsObsItemInfoFrom(ctx, ciEmsInfo, medSrvAggInfo);
		
//		// 组织检验医疗单的列表数据项目
		EmsOrDrug drug = emsOrDrugFrom(medSrvAggInfo.getParentDO(),ems, this.mainSrvInfoFrom(ctx, ciEmsInfo));
		ems.setEmsOrDrugListEx(new FArrayList());
		ems.getEmsOrDrugListEx().add(drug);
		
		// 价格
		ems.setPrice(calculatePrice(medSrvAggInfo.getParentDO(), ems.getEmsOrObsListEx(), ctx));// 不需要重新计算，可以根据srv中的服务价格累加得出
		// 医疗单对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO());

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrvAggInfo.getParentDO().getId_srv(), "", "","",FBoolean.FALSE,ciEmsInfo.getFg_pres_outp(),ciEmsInfo.getDt_begin());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 封装错误信息
 			//FArrayList errorlist=new FArrayList();
			//errorlist.add("获取执行科室失败");
			//OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
 			//return rsts;
		// 保存执行科室过滤条件
 			if ("1".equals(wf.getMp_source())) {
				OrderEmsExtInfoUtils.SetMpDepFilter(rst, null);
			}else{
				OrderEmsExtInfoUtils.SetMpDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_mp_depts())?null:wf.getId_mp_depts());
			}
		// 保存物资流向
 	 		OrderEmsExtInfoUtils.SetWhDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_dept_whs())?null:wf.getId_dept_whs());
			OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
			OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
 		}
 		
 		

		// 医疗单模型文档

		rst.setDocument(handleReturnDocument(ems));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
		// 医疗单类型
		rst.getDriverInfo().setEmsBackendDriver(EmsType.LIS.toString());
		return rsts;
	}

	/**
	 * 组装【检验医疗单UI模型】对象
	 * @param ctx
	 * @param dto
	 * @param medSrvAggInfo
	 * @return
	 * @throws BizException
	 */
	protected EmsObsItemDO emsObsItemInfoFrom(CiEnContextDTO ctx, CiEmsDTO dto, MedsrvAggDO medSrvAggInfo)
			throws BizException {
		EmsObsItemDO ems = new EmsObsItemDO();
		ems.setStatus(DOStatus.UPDATED);
		ems.setId_or(dto.getId_or());
		Object objInfo = dto.getOrapplysheet().get((EmsType.LIS).toString());

		OrdApLabDO ordApLabInfo = (OrdApLabDO) objInfo;
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, dto);

		ems.setFg_set(medSrvAggInfo.getParentDO().getFg_set());
		if (null != mainSrvInfo) {
			ems.setId_orsrv(mainSrvInfo.getId_orsrv());
		}
		ems.setId_srv(dto.getId_srv()); // 服务id SING
		ems.setName_srv(dto.getName()); // 服务名称 SING
		ems.setId_srvtp(dto.getId_srvtp()); // 服务类型
		// ///////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 是否多剂量
		// ems.setIsmuldose(FBoolean.TRUE);
		ems.setSd_frequnitct(dto.getSd_frequnitct());// yzh 多剂量多次
		ems.setIsmuldose(medSrvAggInfo.getParentDO().getIsmuldose());
		ems.setFreqct(dto.getFreqct());
		ems.setId_freq(dto.getId_freq());
		ems.setName_freq(dto.getName_freq());
		// 是否多次执行
		// ems.setIsmulexec(FBoolean.TRUE);
		ems.setIsmulexec(medSrvAggInfo.getParentDO().getIsmulexec());
		// ///////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		ems.setNo_applyobs(ordApLabInfo.getNo_applyform());
		ems.setFg_urgent(ordApLabInfo.getFg_urgent()); // 加急标识 SINGLE FBoo
		ems.setDt_plan(ordApLabInfo.getDt_plan()); // 计划检查时间 SINGLE FDat
		ems.setId_di(ordApLabInfo.getId_di()); // 诊断id REF 医疗服务_疾病诊
		ems.setName_diag(ordApLabInfo.getName_diag()); // 诊断 SINGLE String
		ems.setId_diitm(ordApLabInfo.getId_diitm());
		ems.setId_didef(dto.getId_didef());	
		
		//Name_didef()为空赋值给Name_diag 会导致表单显示异常
		if(!StringUtils.isNullOrEmpty(dto.getName_didef())) {
			ems.setName_diag(dto.getName_didef());
		}

		//超量原因
		ems.setId_excessive_reason(dto.getId_excessive_reason());
		ems.setSd_excessive_reason(dto.getSd_excessive_reason());
		ems.setName_excessive_reason(dto.getName_excessive_reason());
		
		ems.setFg_selfpay((dto.getEu_hpindicjudge() == HpIndicJudgeEnum.SELFPAY ? FBoolean.TRUE : FBoolean.FALSE));
		
		ems.setEu_hpjudge(dto.getEu_hpjudge());
		ems.setEu_orhp(dto.getEu_orhp());
		// 诊断id
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			ems.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			ems.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			ems.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
		}
		// 量值赋值
		ems.setUse_days(dto.getDays_or());
		ems.setDt_begin_ui(dto.getDt_begin());
		ems.setDt_end_ui(dto.getDt_end());
		ems.setTimes_cur(dto.getTimes_cur());
		ems.setTimes_mp_in(dto.getTimes_mp_in());
		//
		ems.setSd_pps(ordApLabInfo.getSd_pps()); // 检查目的编码 SINGLE Stri
		ems.setId_pps(ordApLabInfo.getId_pps()); // 检查目的 SINGLE Stri
		ems.setDes_pps(ordApLabInfo.getDes_pps()); // 检查目的描述 SINGLE Stri
		ems.setName_pps(ordApLabInfo.getName_pps());
		ems.setDes_sympsign(ordApLabInfo.getDes_sympsign()); // 症状体征描述 SINGLE
		ems.setDes_or(dto.getDes_or()); // 备注
																// Stri
		if (null != mainSrvInfo) {
			ems.setId_body(mainSrvInfo.getId_body()); // 身体部位id REF 部位编码_
			ems.setSd_body(mainSrvInfo.getSd_body()); // 身体部位编码 SINGLE Stri
		}
		ems.setAnnouncements(ordApLabInfo.getAnnouncements());
		/**
		 * 2018年5月7日20点13分 
		 * BY-GengHao
		 * bug：0117285  
		 * Remarks 获取缓存中的值时使用的键错误
		 * 原代码：ems.setName_samptp(BDSamptpInfoCache.GetNameOfBdSamptpInfo(ordApLabInfo.getSd_samptp())); 
		 */
		//<-
		ems.setName_samptp(BDSamptpInfoCache.GetNameOfBdSamptpInfo(ordApLabInfo.getId_samptp()));
		//->
		ems.setId_samptp(ordApLabInfo.getId_samptp());
		ems.setSd_samptp(ordApLabInfo.getSd_samptp());
		// 新增#
		ems.setQuan_med(dto.getQuan_medu());
		ems.setId_unit_med(dto.getId_unit_med());
		ems.setName_unit_med(dto.getName_unit_med());

		ems.setId_unit_sale(dto.getId_unit_med());
		ems.setName_unit_sale(dto.getName_unit_med());
		ems.setQuan_cur(new FDouble(dto.getTimes_cur()));
		if (null != mainSrvInfo) {
			ems.setPrice(mainSrvInfo.getPrice());
		}
		ems.setUse_days(dto.getDays_or());
		if (null != mainSrvInfo) {
			ems.setId_mp_dep(mainSrvInfo.getId_dep());
			ems.setName_mp_dep(mainSrvInfo.getName_dep());
			ems.setFg_indic(mainSrvInfo.getFg_indic());
		} else {
			ems.setId_mp_dep(dto.getId_dep_mp());
			ems.setName_mp_dep(dto.getName_dep_mp());
			// ems.setFg_indic ( );
		}

		// 标本采集时间

		ems.setId_sampcoltime(ordApLabInfo.getId_sampcoltime());// 标本采集时间
		ems.setId_sampcollecttimetp(ordApLabInfo.getId_sampcollecttimetp());// 标本采集时间类型
		ems.setSd_sampcollecttimetp(ordApLabInfo.getSd_sampcollecttimetp());// 标本采集时间类型编码
		ems.setLen_sampcoltime(ordApLabInfo.getLen_sampcoltime());// 标本采集时长
		ems.setId_unit_sampcoltime(ordApLabInfo.getId_unit_sampcoltime());// 标本采集时间时长单位
		ems.setName_sampcoltime(ordApLabInfo.getName_sampcoltime());// 标本采集时间名称

		MedSrvDO medSrvDO = medSrvAggInfo.getParentDO();

		// 服务项目缓存映射
		Map<String, CiEmsSrvDTO> tmpEmsSrvCacheMap = new HashMap<String, CiEmsSrvDTO>();
		for (Object objSrv : dto.getEmssrvs()) {
			CiEmsSrvDTO srvInfo = (CiEmsSrvDTO) objSrv;
			tmpEmsSrvCacheMap.put(srvInfo.getId_srv(), srvInfo);
		}
		if (CiOrdUtils.isTrue(dto.getFg_set())) {
			

			FMap srvSetItemMap = dto.getSrvsetitms();
			FArrayList allSetItemInfoList = new FArrayList();
			if (srvSetItemMap != null) {
				allSetItemInfoList = (FArrayList) srvSetItemMap.get(dto.getId_srv());
			}

			// 所有套内项目临时缓存映射
			Map<String, OrdSrvSetDO> tmpOrdSrvSetCacheMap = new HashMap<String, OrdSrvSetDO>();
			for (Object objSetSrv : allSetItemInfoList) {
				OrdSrvSetDO medSrvSetInfo = (OrdSrvSetDO) objSetSrv;
				tmpOrdSrvSetCacheMap.put(medSrvSetInfo.getId_srvset(), medSrvSetInfo);
			}

			MedSrvSetItemDO[] szMedSrvSetItem = GetItemInSet(dto.getId_srv(), true);

			MedSrvSetItemDO mainItem = null;
			StringList listSrvId = new StringList();
			// 套内项目临时缓存
			Map<String, MedSrvSetItemDO> tmpMedSrvSetItemCacheMap = new HashMap<String, MedSrvSetItemDO>();
			for (MedSrvSetItemDO item : szMedSrvSetItem) {
				if (mainItem == null && ICiDictCodeConst.SD_SRVSETITEM_ROLE_MAIN.equals(item.getSd_srvsetrole())) {
					mainItem = item;
				}
				listSrvId.add(item.getId_srv_itm());
				tmpMedSrvSetItemCacheMap.put(item.getId_srv_itm(), item);
			}

			// 获取套内项目的基础服务定义信息
			MedsrvAggDO[] szMedSrvAggInfo = ServiceFinder.find(IMedsrvRService.class)
					.findByIds(listSrvId.toArray(new String[listSrvId.size()]), FBoolean.FALSE);
			if (szMedSrvAggInfo == null) {
				return ems;
			}

			FArrayList emsOrObsListEx = new FArrayList();
			for (MedsrvAggDO aggDO : szMedSrvAggInfo) {
				MedSrvDO medsrvdo = aggDO.getParentDO();
				if (tmpMedSrvSetItemCacheMap.containsKey(medsrvdo.getId_srv())) {

					MedSrvSetItemDO setItem = tmpMedSrvSetItemCacheMap.get(medsrvdo.getId_srv());
					if (CiOrdUtils.isTrue(setItem.getFg_clinical())) {
						EmsObsLap lab = new EmsObsLap();
						lab.setName_srv(setItem.getSet_name());
						lab.setId_srv(setItem.getId_srv_itm());
						lab.setId_or(dto.getId_or());
						lab.setFg_edit(setItem.getFg_edit());
						lab.setQuan_medu(dto.getQuan_medu());
						// 当医嘱中的医学剂量为空时，取bd_srv中的医学剂量
						if (dto.getQuan_medu() == null)
							lab.setQuan_medu(medsrvdo.getQuan_med());
						lab.setId_medu(dto.getId_unit_med());
						lab.setId_freq(dto.getId_freq());
						lab.setSd_srvtp(medsrvdo.getSd_srvtp());
						lab.setFg_bl(medsrvdo.getFg_bl());
						lab.setEu_blmd(medsrvdo.getEu_blmd());
						lab.setId_srvca(medsrvdo.getId_srvca());
						lab.setId_primd(medsrvdo.getId_primd());
						lab.setAnnouncements(ordApLabInfo.getAnnouncements());
						if (!CiOrdUtils.isEmpty(ordApLabInfo.getQuan())) { // 需求量
							lab.setQuan(new FDouble(ordApLabInfo.getQuan()));
						}
						lab.setId_quan(ordApLabInfo.getId_unit_quan()); // 需求量单位
																		// EmsObsLap中没有对应字段

						lab.setId_colltp(ordApLabInfo.getId_colltp()); // 采集方法
						lab.setSd_colltp(ordApLabInfo.getSd_colltp()); // 采集方法编码

						lab.setLen_sampcoltime(ordApLabInfo.getLen_sampcoltime());// 标本采集时长
						lab.setId_unit_sampcoltime(ordApLabInfo.getId_unit_sampcoltime());// 标本采集时长单位

						lab.setId_contp(ordApLabInfo.getId_contp()); // 容器类型
						lab.setSd_contp(ordApLabInfo.getSd_contp()); // 容器类型编码
						lab.setId_labgroup(ordApLabInfo.getId_labgroup());
						lab.setSd_labgroup(ordApLabInfo.getSd_labgroup());
						if (tmpEmsSrvCacheMap.containsKey(lab.getId_srv())) {
							CiEmsSrvDTO item = tmpEmsSrvCacheMap.get(lab.getId_srv());
							lab.setId_orsrv(item.getId_orsrv());
							lab.setEu_sourcemd(item.getEu_sourcemd());
						}

						if (tmpOrdSrvSetCacheMap.containsKey(setItem.getId_srv_itm())) {
							OrdSrvSetDO srvsetdo = tmpOrdSrvSetCacheMap.get(setItem.getId_srv_itm());
							lab.setFg_chk(FBoolean.TRUE);
							lab.setId_freq(srvsetdo.getId_freqdef());
							lab.setId_medu(srvsetdo.getId_medu());
							lab.setQuan_medu(srvsetdo.getQuan_medu());
							// ems.setEmsOrObsListDel.Add(lab);
						}
						emsOrObsListEx.add(lab);

					}
				}
			}
			ems.setPrice(calculatePrice(medSrvDO, emsOrObsListEx, ctx));
			ems.setEmsOrObsListEx(emsOrObsListEx);
		} else {

			MedSrvLisDO[] szMedSrvLisDO = medSrvAggInfo.getMedSrvLisDO();
			FArrayList emsOrObsListEx = new FArrayList();
			for (MedSrvLisDO lisdo : szMedSrvLisDO) {

				if (tmpEmsSrvCacheMap.containsKey(lisdo.getId_srv())) {
					EmsObsLap lab = new EmsObsLap();
					CiEmsSrvDTO item = tmpEmsSrvCacheMap.get(lisdo.getId_srv());
					lab.setName_srv(lisdo.getSrv_name());
					lab.setId_srv(lisdo.getId_srv());
					lab.setSd_srvtp(medSrvDO.getSd_srvtp());
					lab.setId_srvca(medSrvDO.getId_srvca());
					lab.setId_primd(medSrvDO.getId_primd());
					lab.setEu_blmd(medSrvDO.getEu_blmd());
					lab.setFg_bl(medSrvDO.getFg_bl());
					if (item != null) {
						lab.setId_orsrv(item.getId_orsrv());
						lab.setFg_chk(FBoolean.TRUE);
						lab.setFg_edit(FBoolean.FALSE);
						lab.setId_or(item.getId_or());
						lab.setId_medu(item.getId_unit_med());
						lab.setQuan_medu(item.getQuan_med());
						lab.setId_freq(item.getId_freq());
						lab.setSd_srvtp(item.getSd_srvtp());
						lab.setId_srvca(item.getId_srvca());
						lab.setId_orsrv(item.getId_orsrv());
						lab.setEu_blmd(item.getEu_blmd());
						lab.setEu_sourcemd(item.getEu_sourcemd());
					}

					lab.setAnnouncements(ordApLabInfo.getAnnouncements());
					if (!CiOrdUtils.isEmpty(ordApLabInfo.getQuan())) { // 需求量
						lab.setQuan(new FDouble(ordApLabInfo.getQuan()));
					}
					lab.setId_quan(ordApLabInfo.getId_unit_quan()); // 需求量单位
																	// EmsObsLap中没有对应字段

					lab.setId_colltp(ordApLabInfo.getId_colltp()); // 采集方法
					lab.setSd_colltp(ordApLabInfo.getSd_colltp()); // 采集方法编码

					lab.setLen_sampcoltime(ordApLabInfo.getLen_sampcoltime());// 标本采集时长
					lab.setId_unit_sampcoltime(ordApLabInfo.getId_unit_sampcoltime());// 标本采集时长单位

					lab.setId_contp(ordApLabInfo.getId_contp()); // 容器类型
					lab.setSd_contp(ordApLabInfo.getSd_contp()); // 容器类型编码
					lab.setId_labgroup(ordApLabInfo.getId_labgroup());
					lab.setSd_labgroup(ordApLabInfo.getSd_labgroup());
					emsOrObsListEx.add(lab);
				}
			}
			// 设置单价
			ems.setPrice(mainSrvInfo.getPrice());
			ems.setEmsOrObsListEx(emsOrObsListEx);
		}

		return ems;
	}

	/**
	 * 组装【检验医疗单表格UI模型对象】
	 * @param ems
	 * @param mainSrvInfo
	 * @return
	 */
	protected EmsOrDrug emsOrDrugFrom(MedSrvDO bdSrvInfo,EmsObsItemDO ems, CiEmsSrvDTO mainSrvInfo){
		EmsOrDrug drug = new EmsOrDrug();
		drug.setStatus(DOStatus.UPDATED);
		drug.setId_orsrv(ems.getId_orsrv());
		drug.setId_srv(ems.getId_srv());
		drug.setName_srv(ems.getName_srv());
		
		// 频次信息
		drug.setId_freq(ems.getId_freq());
		drug.setName_freq(ems.getName_freq());
		drug.setFreqct(ems.getFreqct());
		drug.setSd_frequnitct(ems.getSd_frequnitct());
		
		// 加急标志
		drug.setFg_urgent(ems.getFg_urgent());
		drug.setNo_applyform(ems.getNo_applyobs());
		
		// 使用天数
		drug.setUse_days(ems.getUse_days());
		// 单选模式
		drug.setFg_setradio(bdSrvInfo.getFg_setradio());
		
		// 剂量
		drug.setQuan_med(ems.getQuan_med());
		drug.setId_unit_med(ems.getId_unit_med());
		drug.setName_unit_med(ems.getName_unit_med());
		drug.setQuan_medu_virtual(ems.getQuan_med());
		drug.setName_unit_medu_virtual(ems.getName_unit_med());
		
		// 执行科室
		drug.setId_mp_dep(ems.getId_mp_dep());
		drug.setName_mp_dep(ems.getName_mp_dep());
		
		// 总量
		drug.setQuan_cur(mainSrvInfo.getQuan_total_medu());
		drug.setId_unit_sale(ems.getId_unit_sale());
		drug.setName_unit_sale(ems.getName_unit_sale());
		
		// 价格
		drug.setPrice(ems.getPrice());
		drug.setTotalprice(drug.getPrice().multiply(drug.getQuan_cur()));

		// 标本类型
		drug.setId_samptp(ems.getId_samptp());
		drug.setName_samptp(ems.getName_samptp());
		drug.setSd_samptp(ems.getSd_samptp());
		// 标本采集时间
		drug.setId_sampcoltime(ems.getId_sampcoltime());
		drug.setName_sampcoltime(ems.getName_sampcoltime());
		drug.setId_sampcollecttimetp(ems.getId_sampcollecttimetp());
		drug.setSd_sampcollecttimetp(ems.getSd_sampcollecttimetp());
		drug.setLen_sampcoltime(ems.getLen_sampcoltime());
		drug.setId_unit_sampcoltime(ems.getId_unit_sampcoltime());

		return drug;
	}
	
	
	protected MedSrvSetItemDO[] GetItemInSet(String id_srv, boolean is_clinical) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class).find(String
				.format("a8.fg_clinical='%s' and a8.id_srv='%s' and a8.fg_active='Y'", is_clinical ? "Y" : "N", id_srv),
				"", FBoolean.FALSE);
	}

	/// <summary>
	/// 医嘱服务计算价格（非物品计价）
	/// </summary>
	/// <param name="medsrv"></param>
	/// <param name="EmsOrObsList"></param>
	public FDouble calculatePrice(MedSrvDO medsrv, FArrayList emsOrObsList, CiEnContextDTO enContext)
			throws BizException {
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
				enContext.getId_pripat());
		if (priceDo != null) {
			return priceDo.getPrice_ratio();
		}

		return FDouble.ZERO_DBL;
	}
}

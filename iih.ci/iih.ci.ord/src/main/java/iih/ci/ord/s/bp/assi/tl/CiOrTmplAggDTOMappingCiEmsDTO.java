/**
 * 
 */
package iih.ci.ord.s.bp.assi.tl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.i.ICHerbBoilDesDORService;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.pub.util.tools.MessageConvertUtil;
import iih.ci.ord.s.bp.ems.CiEmsDefaultValueSetBP;
import iih.ci.ord.s.bp.emscalculate.total.CalTimesCurBP;
import iih.ci.ord.s.bp.quantum.CalDtEffeBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.quantum.times.QuanFirstDayMpBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.bp.validate.chain.AssembleAssiChain;
import iih.ci.ord.s.bp.validate.chain.ValidateDataDTO;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.utils.GetDrugDaysOfAvailable;
import iih.ci.ord.s.utils.GetDrugTotalQuan4DoseBP;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStatus;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * @ClassName: CiOrTmplAggDTOMappingCiEmsDTO
 * @Description: 医嘱模板映成CiEmsDTO
 * @author Comsys-li_zheng
 * @date 2016年9月6日 下午2:55:36
 * @Package iih.ci.ord.s.bp.assi Copyright: Copyright (c) 2011 Company:
 *          北大医疗信息技术有限责任公司
 */
public class CiOrTmplAggDTOMappingCiEmsDTO {

	// 频次
	private IFreqdefMDORService ifreqdefMDORService;
	// 用法
	private IMedusageRService imedusageRService;
	// 用法要求
	private IMedusagedesRService imedusagedesRService;
	// 煎法
	private ICherbboilmdMDORService icherbboilmdMDORService;
	// 煎法要求
	private ICHerbBoilDesDORService icHerbBoilDesDORService;
	// 医疗服务服务
	private IMedsrvMDORService imedsrvMDORService;
	// 套定义服务
	private IMedSrvSetItemDORService srvSetItemRSercie;
	// 检查属性
	private IMedSrvRisDORService imedSrvRisDORService = null;
	// 诊断服务接口
	private ICidiagQryService icidiagQryService;

	// 套内项目对应的服务map结构(每个套内项目对应map中一条记录，key：对应bd_srv中的id_srv)
	private Map<String, MedSrvSetItemDO> setItemSrvMap = null;
	// 服务套id与套内项目集合Map结构（key服务套的id_srv ，value 套内项目集合）
	private Map<String, List<MedSrvSetItemDO>> srvSetItemsMap = null;
	// 检查属性
	private Map<String, MedSrvRisDO> srvRisMap = null;
	// bd_srv
	private Map<String, MedSrvDO> bdSrvMap = null;
	// 计算总次数
	private CalTimesCurBP calTimesCurBP;
	// 将CiEmsDTO集合转换为 MoreEmsParamDTO对象
	private MoreEmsParamDTO moreEmsParam;

	// 映射初始化时CiEms不随医嘱变化的属性对象
	private InitMappingCiEmsProperty mappingProperty;

	// 门诊住院的可使用状态对应关系，用于过滤当前就诊环境下是否支持模板转换为医嘱
	// key 就诊类型 value 可使用标识字段名称
	private final static Map<String, String> FG_USE_MAP = new HashMap<String, String>() {
		{
			put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, "get" + MedSrvDO.FG_USE_OP); // 可使用标识_门诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW, "get" + MedSrvDO.FG_USE_ER); // 可使用标识_急诊流水
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID, "get" + MedSrvDO.FG_USE_ER1); // 可使用标识_急诊抢救
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS, "get" + MedSrvDO.FG_USE_ER2); // 可使用标识_急诊留观
			put(IBdFcDictCodeConst.SD_CODE_ENTP_PE, "get" + MedSrvDO.FG_USE_PE); // 可使用标识_体检
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, "get" + MedSrvDO.FG_USE_IP); // 可使用标识_住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE, "get" + MedSrvDO.FG_USE_PIP); // 可使用标识_预住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_FA, "get" + MedSrvDO.FG_USE_FM); // 可使用标识_家庭
		}
	};

	// 门诊住院的可使用状态对应关系，用于准确提示服务不可使用的场景
	// key 就诊类型 value 可使用标识字段名称
	private final static Map<String, String> FG_USE_MSG = new HashMap<String, String>() {
		{
			put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, "门诊"); // 可使用标识_门诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET, "体检"); // 可使用标识_急诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW, "急诊流水"); // 可使用标识_急诊流水
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID, "急诊抢救"); // 可使用标识_急诊抢救
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS, "急诊留观"); // 可使用标识_急诊留观
			put(IBdFcDictCodeConst.SD_CODE_ENTP_PE, "体检"); // 可使用标识_体检
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, "住院"); // 可使用标识_住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE, "预住院"); // 可使用标识_预住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_FA, "家庭"); // 可使用标识_家庭
		}
	};

	public CiOrTmplAggDTOMappingCiEmsDTO() {
		ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
		imedusageRService = (IMedusageRService) ServiceFinder.find(IMedusageRService.class);
		imedusagedesRService = (IMedusagedesRService) ServiceFinder.find(IMedusagedesRService.class);
		icherbboilmdMDORService = (ICherbboilmdMDORService) ServiceFinder.find(ICherbboilmdMDORService.class);
		icHerbBoilDesDORService = (ICHerbBoilDesDORService) ServiceFinder.find(ICHerbBoilDesDORService.class);
		imedsrvMDORService = (IMedsrvMDORService) ServiceFinder.find(IMedsrvMDORService.class);
		srvSetItemRSercie = (IMedSrvSetItemDORService) ServiceFinder.find(IMedSrvSetItemDORService.class);
		imedSrvRisDORService = (IMedSrvRisDORService) ServiceFinder.find(IMedSrvRisDORService.class);
		icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);

		calTimesCurBP = new CalTimesCurBP();
	}

	/**
	 * 医嘱模板映成CiEmsDTO
	 * 
	 * @param envinfo
	 *            上下文信息
	 * @param ciOrtmplAggDTO
	 *            医嘱逻辑模板
	 * @return CiEmsDTO[]
	 * @throws BizException
	 */
	public MoreEmsParamDTO Mapping(CiEnContextDTO envinfo, CiOrTmplDTO[] ciOrtmplAggDTO) throws BizException {

		if (ciOrtmplAggDTO == null || ciOrtmplAggDTO.length == 0)
			return null;

		// 不允许通过助手直接保存的医嘱提示信息
		StringBuffer refusedMsg = new StringBuffer();

		// 如果是医保就诊，判断是否存在保外诊断
		if (FBoolean.TRUE.equals(envinfo.getFg_hpfundpay())) {
			// 查询保外诊断
			CiDiagItemDO[] ciDiagItems = icidiagQryService.getHpjudgetpCiDiagItems(envinfo.getId_en());
			CiEnContextUtil.SetHpCiDiagItem(envinfo, ciDiagItems);
		}

		mappingProperty = new InitMappingCiEmsProperty(envinfo);

		// 构造套内项目集合key值为套内项目对应的服务id
		setItemSrvMap = new HashMap<String, MedSrvSetItemDO>();
		srvRisMap = new HashMap<String, MedSrvRisDO>();
		// 服务套与套内项目对应关系集合
		srvSetItemsMap = new HashMap<String, List<MedSrvSetItemDO>>();

		moreEmsParam = new MoreEmsParamDTO();

		this.createSrvSetItemMap(ciOrtmplAggDTO);

		List<CiEmsDTO> ciEmsList = new ArrayList<CiEmsDTO>();
		// 优化 一次查询 bd_srv
		bdSrvMap = OptimizationMedSrvDO(ciOrtmplAggDTO);
		for (int i = 0; i < ciOrtmplAggDTO.length; i++) {

			CiOrTmplDTO orTmplDTO = ciOrtmplAggDTO[i];
			String msg = this.getRefuseMsg(envinfo, orTmplDTO, bdSrvMap);
			if (StringUtils.isNotEmpty(msg)) {
				refusedMsg.append(msg).append(System.lineSeparator());
				continue;
			}
			if (envinfo.getEu_orsrcmdtp()!=null&&OrSourceFromEnum.IIHORTMPLHELPER.equals(envinfo.getEu_orsrcmdtp())) {
				//判断单位是否一致
				String message = JudgeMMUintQuanTotalMed(envinfo,orTmplDTO);
				if (StringUtils.isNotEmpty(message)) {
					refusedMsg.append(message).append(System.lineSeparator());
					//continue;
				}
			}
			// TODO: 此处应该根据不同的医疗单服务，调用不同的映射方法（普药、草药、检验检查、手术、会诊、治疗、病理、用血、备血等等）
			CiEmsDTO ciEmsDTO = new CiEmsDTO();
			ciEmsDTO.setStatus(DOStatus.NEW);// 设置为新建状态
			// 根据上下文环境 + 医嘱模板生成 = 医疗单CiEmsDTO数据
			MappingFieldOrder(envinfo, ciEmsDTO, orTmplDTO, bdSrvMap);
			if(ciEmsDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) { //手术
			    //补全手术信息 MedSrvOpDO bd_srv_sug 表中
				replenishSug(ciEmsDTO);
			}
			
			// 补充对CiEms,CiEmsSrv的属性赋值
			afterFieldMapping(envinfo, ciEmsDTO);
			if(FBoolean.TRUE.equals(ciEmsDTO.getFg_wholepack())||FBoolean.TRUE.equals(ciEmsDTO.getFg_pres_outp())){
				ciEmsDTO.setFg_long(FBoolean.FALSE);
			}
			// 医嘱项目
			ciEmsList.add(ciEmsDTO);
		}
		//0186425: 【验证版】住院医嘱，既往调入、复制、医嘱模板开了抗菌药，用药目的不应复制，应该让医生自己选择
		if (ciEmsList.size() > 0) {
			moreEmsParam = new MoreEmsParamDTO();
			// 校验医嘱模板开立服务的抗菌药属性
			String resonInfo = emsSrvValidateAnti(ciEmsList);
			if (!CiOrdUtils.isEmpty(resonInfo)) {
				refusedMsg.append(resonInfo).append(System.lineSeparator());
			}
		}

		if (ciEmsList.size() > 0) {
			new CovertTmplToMoreEmsParamBP().exec(envinfo, ciEmsList.toArray(new CiEmsDTO[0]), moreEmsParam);
		}
		if (refusedMsg.length() > 0) {
			moreEmsParam.setErrorinfo(refusedMsg
					.append(moreEmsParam.getErrorinfo() != null ? moreEmsParam.getErrorinfo() : "").toString());
		}
		return moreEmsParam;
		// return ciEmsDTOS;
	}

	/**
	 * 补全手术信息 IMedSrvOpDORService
	 * @throws BizException 
	 */
	private void replenishSug(CiEmsDTO ciEmsDto) throws BizException {
		if(StringUtils.isEmpty(ciEmsDto.getId_srv())) return;
		//基础数据设置默认值
		MedSrvOpDO[] medSrvOpDOArr =	ServiceFinder.find(IMedSrvOpDORService.class).findByAttrValString(MedSrvOpDO.ID_SRV,ciEmsDto.getId_srv());
		if(medSrvOpDOArr == null && medSrvOpDOArr.length<=0) return;
		MedSrvOpDO medSrvOpDO = medSrvOpDOArr[0];
		if(StringUtils.isNotEmpty(medSrvOpDO.getId_opclass())){
			ciEmsDto.setId_opclass(medSrvOpDO.getId_opclass()); 	//手术等级
			ciEmsDto.setSd_opclass(medSrvOpDO.getSd_opclass());
			ciEmsDto.setName_opclass(medSrvOpDO.getName_opclass());
		}
		if(StringUtils.isNotEmpty(medSrvOpDO.getId_incitp())){
			ciEmsDto.setId_incitp(medSrvOpDO.getId_incitp()); 		//切口等级
			ciEmsDto.setSd_incitp(medSrvOpDO.getSd_incitp());
			ciEmsDto.setName_incitp(medSrvOpDO.getName_incitp());
		}
	}
	
	private String JudgeMMUintQuanTotalMed(CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmplDTO) throws BizException {
		if (ciOrTmplDTO.getSd_srvtp() != null && ciOrTmplDTO.getSd_srvtp().startsWith("01") && !ciOrTmplDTO.getSd_srvtp().startsWith("0103")) {
			// 获取服务项目
			FArrayList ciOrTmplSrvs = ciOrTmplDTO.getOrtmplsrvs();
			CiOrTmplSrvDTO tmplSrvDTO = (CiOrTmplSrvDTO) ciOrTmplSrvs.get(0); // 取第0个作为主服务
			if(StringUtils.isEmpty(tmplSrvDTO.getId_unit_sale())){
				return "";
			}
			// 该医嘱下 所有物品单位
			MaterialUnitDTO[] materialUnitDTOs = BDMmDoseUnitInfoCache.getMaterialUnitInfos(envinfo.getCode_entp(),
					tmplSrvDTO.getId_mm().split(CiOrdUtils.COMMA_STR));
			if (CiOrdUtils.isEmpty(materialUnitDTOs)) {// 没有获取到包装单位
				return null;
			}
			boolean flag = false;
			for (MaterialUnitDTO dto : materialUnitDTOs) {
				// 判断该药品的所有物品单位中是否包含模板的总量单位
				if (dto.getId_measdoc() != null &&dto.getId_measdoc().equals(tmplSrvDTO.getId_unit_sale())) {
					flag = true;
				}

			}
			if (!flag&&tmplSrvDTO.getSd_drugdeliverymethod()!=null) {
				
					tmplSrvDTO.setId_unit_sale(materialUnitDTOs[0].getId_measdoc());
				
				CalQuantumBP bp = new CalQuantumBP();
				String id_mm = tmplSrvDTO.getId_mm();
				MeterialAggDO mmagg = CiOrdAppUtils.getIMeterialRService().findById(id_mm);
				MeterialDO parentDO = mmagg.getParentDO();
				MMPackageUnitDO[] mmpackageUnits = mmagg.getMMPackageUnitDO();
				//获得取整模式
				String sd_mupakgu=parentDO.getSd_opmutp();//取整模式
				//医基换算系数
				FDouble factor_mb = parentDO.getFactor_mb();
				//总量单位对基本包装单位的换算系数
				FDouble factor = bp.getFactorForUnitBaseToUnitSale(mmpackageUnits,tmplSrvDTO.getId_unit_sale());
				//医嘱执行总次数
				GetTotalTimesBP bp1 = new GetTotalTimesBP();
				Integer times = 0;
				if (ciOrTmplDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {//草药剂数=次数
					times=ciOrTmplDTO.getOrders();
				}else{
					Date date = new Date();
				    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    String dateString = formatter.format(date);
					times = bp1.getTotalTimes(new FDateTime(dateString),tmplSrvDTO.getId_freq(),ciOrTmplDTO.getDays_or());
				}
				FDouble quan_medu = tmplSrvDTO.getQuan_med();
				tmplSrvDTO.setQuan_total_medu(bp.getMMQuantum(sd_mupakgu, quan_medu, factor_mb, factor, times));

				
				return ciOrTmplDTO.getName() + "的药品单位已修改，请在医疗单中维护总量 或者去住院医嘱模板节点维护该药品的总量";
			}
		}

		return null;

	}

	/**
	 * 判断是否支持模板保存<br/>
	 * 
	 * @param envinfo
	 *            当前就诊上下文环境
	 * @param ciOrTmpl
	 *            标识模板
	 * @param bdSrvMap
	 *            服务集合
	 * @return
	 * @throws BizException
	 */
	private String getRefuseMsg(CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, Map<String, MedSrvDO> bdSrvMap)
			throws BizException {

		String codeEntp = envinfo.getCode_entp();

		if (FG_USE_MAP.containsKey(codeEntp)) {

			MedSrvDO medSrv = bdSrvMap.get(ciOrTmpl.getId_srv());
			if (!FBoolean.TRUE.equals(medSrv.getFg_active())) {
				return "服务【" + medSrv.getName() + "】已停用";
			}

			if (!FBoolean.TRUE.equals(medSrv.getFg_or())) {
				return "服务【" + medSrv.getName() + "】为非临床项目";
			}
			if (medSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_A)) {
				return "服务【" + medSrv.getName() + "】不支持通过助手开立医嘱";
			}
			try {

				// 获取可使用标识的get方法并执行
				Class<? extends MedSrvDO> cls = medSrv.getClass();
				Method getMethod = cls.getDeclaredMethod(FG_USE_MAP.get(codeEntp));
				Object fgUse = getMethod.invoke(medSrv);

				if (fgUse == null || !FBoolean.TRUE.equals(FBoolean.valueOf(fgUse.toString()))) {
					return FG_USE_MSG.get(codeEntp) + "中服务【" + medSrv.getName() + "】不可使用";
				}

			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

				throw new BizException("医嘱模板映射获取获取可使用标识失败");
			}
		}
		return null;
	}

	/**
	 * 获取bd套内项目集合
	 * 
	 * @param ciEmsDTO
	 * @throws BizException
	 */
	private void createSrvSetItemMap(CiOrTmplDTO[] ciOrTmpls) throws BizException {

		StringBuffer idSrvBuffer = new StringBuffer();
		StringBuffer idSetSrvBuffer = new StringBuffer();
		for (CiOrTmplDTO ciOrTmpl : ciOrTmpls) {
			if (FBoolean.TRUE.equals(ciOrTmpl.getFg_set())) {
				idSrvBuffer.append(",'" + ciOrTmpl.getId_srv() + "'");
			}
		}

		if (idSrvBuffer.length() > 0) {
			// 查询套内项目
			String whereStr = "id_srv in (" + idSrvBuffer.substring(1) + ")";
			MedSrvSetItemDO[] medSrvSetItems = srvSetItemRSercie.find(whereStr, null, FBoolean.FALSE);
			for (MedSrvSetItemDO medSrvSetItem : medSrvSetItems) {

				// 构造套内项目对应服务id，用于其他属性查询
				idSetSrvBuffer.append(",'" + medSrvSetItem.getId_srv_itm() + "'");

				// 套内项目对应的服务map集合
				setItemSrvMap.put(medSrvSetItem.getId_srv_itm(), medSrvSetItem);
				// 构造套内项目集合map结构
				List<MedSrvSetItemDO> setItemList = null;
				if (srvSetItemsMap.containsKey(medSrvSetItem.getId_srv())) {
					setItemList = srvSetItemsMap.get(medSrvSetItem.getId_srv());
				} else {
					setItemList = new ArrayList<MedSrvSetItemDO>();
					srvSetItemsMap.put(medSrvSetItem.getId_srv(), setItemList);
				}
				setItemList.add(medSrvSetItem);
			}
			// 查询检查属性
			String whereStrRis = "id_srv in (" + idSetSrvBuffer.substring(1) + ")";
			MedSrvRisDO[] medSrvRises = imedSrvRisDORService.find(whereStrRis, null, FBoolean.FALSE);
			for (MedSrvRisDO medSrvRis : medSrvRises) {
				srvRisMap.put(medSrvRis.getId_srv(), medSrvRis);
			}
		}
	}

	/**
	 * 医嘱模板的映射(普通药品医疗单)
	 * 
	 * @param envinfo
	 * @param ciEmsDTO
	 * @param aggDto
	 * @throws BizException
	 */
	private void MappingFieldOrder(CiEnContextDTO envinfo, CiEmsDTO ciEmsDTO, CiOrTmplDTO ciOrTmplDTO,
			Map<String, MedSrvDO> bdSrvMap) throws BizException {

		// 对应的 bd_srv，传递数据为医嘱模板时
		ciEmsDTO.setId_srv(ciOrTmplDTO.getId_srv());
		// 增加关联医嘱
		ciEmsDTO.setId_or_rel(ciOrTmplDTO.getId_or_rel());
		// 优化 一次查询
		// MedSrvDO medSrvDO =
		// imedsrvMDORService.findById(ciEmsDTO.getId_srv());
		MedSrvDO medSrvDO = null;
		if (bdSrvMap != null) {
			medSrvDO = bdSrvMap.get(ciEmsDTO.getId_srv());
		}
		if (medSrvDO == null) {
			OrdBizLogger.info(envinfo, "标准模板转CiEmsDTO时根据id_srv[" + ciEmsDTO.getId_srv() + "]未获取到服务项目");
			throw new BizException("标准模板转CiEmsDTO时根据id_srv[" + ciEmsDTO.getId_srv() + "]未获取到服务项目");
		}

		ValidateDataDTO param = new ValidateDataDTO();
		param.setMedSrv(medSrvDO);
		List<String> msgList = AssembleAssiChain.startValidate(envinfo, param);
		if (msgList.size() > 0) {
			throw new BizException(MessageConvertUtil.convertListToString(msgList));
		}
		ciEmsDTO.setFg_pres_outp(ciOrTmplDTO.getFg_pres_outp());
		ciEmsDTO.setFg_wholepack(ciOrTmplDTO.getFg_wholepack());
		ciEmsDTO.setId_drugdeliverymethod(ciOrTmplDTO.getId_drugdeliverymethod());
		ciEmsDTO.setSd_drugdeliverymethod(ciOrTmplDTO.getSd_drugdeliverymethod());
		ciEmsDTO.setName_drugdeliverymethod(ciOrTmplDTO.getName_drugdeliverymethod());
		ciEmsDTO.setNote(ciOrTmplDTO.getDes_or());// 医嘱描述
		ciEmsDTO.setId_pat(envinfo.getId_pat());// 患者
		ciEmsDTO.setId_en(envinfo.getId_en());// 就诊
		ciEmsDTO.setId_entp(envinfo.getId_entp());// 就诊类型
		ciEmsDTO.setCode_entp(envinfo.getCode_entp());// 就诊类型编码
		ciEmsDTO.setId_srvtp(medSrvDO.getId_srvtp());// 医嘱类型
		ciEmsDTO.setSd_srvtp(medSrvDO.getSd_srvtp());// 医嘱类型编码
		ciEmsDTO.setId_wg_or(envinfo.getId_wg_or());
		// 如果服务类型是0506 设置为皮试
		if (IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST.equals(ciEmsDTO.getSd_srvtp())) {
			ciEmsDTO.setFg_skintest(FBoolean.TRUE);
		}
		// 套服务是否包含套内项目，组套中的套都不包含套内项目
		CiOrTmplSrvDTO tmplSrvDTO = null;
		if (OrSourceFromEnum.IIHCLINICALKITHELPER != ciOrTmplDTO.getEu_orsrcmdtp()) {// 不是来源组套
			// 获取服务项目
			FArrayList ciOrTmplSrvs = ciOrTmplDTO.getOrtmplsrvs();
			tmplSrvDTO = (CiOrTmplSrvDTO) ciOrTmplSrvs.get(0); // 取第0个作为主服务
			// 将模板中的用法、频次、煎法 赋值到CiEmsDTO中
			// 频次
			if (StringUtils.isBlank(tmplSrvDTO.getId_freq())) {
				OrdBizLogger.error(envinfo, "执行方法 CiOrTmplAggDTOMappingCiEmsDTO.MappingFieldOrder,映射服务["
						+ tmplSrvDTO.getId_srv() + "]对应频次不能为空！");
				throw new BizException("频次不能为空！");
			}
			ciEmsDTO.setId_freq(tmplSrvDTO.getId_freq());// 频次id
			ciEmsDTO.setId_route(tmplSrvDTO.getId_route());// 用法id
			ciEmsDTO.setId_routedes(tmplSrvDTO.getId_routedes());// 用法要求
			ciEmsDTO.setId_boil(tmplSrvDTO.getId_boil());// 设置煎法id
			ciEmsDTO.setId_boildes(tmplSrvDTO.getId_boildes());// 煎法要求id
			ciEmsDTO.setId_dep_mp(tmplSrvDTO.getId_dep_mp());

		}
		ciEmsDTO.setDays_or(ciOrTmplDTO.getDays_or());// 医嘱天数

		// 补全频次、频次下次数、用法、用法要求、煎法、煎法要求
		this.setCiEmsDTOUseDetailByMedSrv(envinfo, ciEmsDTO, medSrvDO, ciOrTmplDTO);

		// 执行科室 执行完映射在设置执行科室
		// OrWfDeptInfoDTO deptMpDto = this.getMpDeptID(envinfo, medSrvDO,null);

		// ciEmsDTO.setSd_orrsttp(ciOrTmplDTO.getSd_orrsttp());//医嘱结果编码
		// ciEmsDTO.setId_dep_mp(deptMpDto.getFirstid_mp_dept());// 执行科室Id
		// ciEmsDTO.setName_dep_mp(deptMpDto.getFirstname_mp_dept());// 执行科室名称

		ciEmsDTO.setId_unit_med(medSrvDO.getId_unit_med());// 医学单位

		ciEmsDTO.setId_srvca(medSrvDO.getId_srvca());// 医嘱基本分类
		ciEmsDTO.setName_unit_med(medSrvDO.getMed_name());// 医学单位名称
		ciEmsDTO.setInnercode_srvca(medSrvDO.getSrvca_innercode());// 服务分类内码
		ciEmsDTO.setId_grp(envinfo.getId_grp());// 所属集团
		ciEmsDTO.setId_org(envinfo.getId_org());// 所属组织
		ciEmsDTO.setEmsappmode(envinfo.getEmsappmode());// 医疗单应用场景
		// 总量开单方式，多频次，多剂量
		ciEmsDTO.setSd_totalopenmode(medSrvDO.getSd_totalopenmode());
		ciEmsDTO.setIsmulexec(medSrvDO.getIsmulexec());
		ciEmsDTO.setIsmuldose(medSrvDO.getIsmuldose());
		// ciEmsDTO.setName_ems(medSrvDO.getName());// 医疗单显示名称
		// 医疗单名称不是服务名，从EmsMatchRstDTO中取

		// ciEmsDTO.setId_orpltp(ciOrTmplDTO.getId_orpltp());//医嘱执行闭环类型

		// ciEmsDTO.setMapkeys(ciOrTmplDTO.getMapkeys());//附加信息Map键值串
		// ciEmsDTO.setMapinfo(ciOrTmplDTO.getMapinfo());//相关附加信息MAP
		// ciEmsDTO.setFg_syncfee(ciOrTmplDTO.getFg_syncfee());//费用同步标识
		// ciEmsDTO.setFreqct(ciOrTmplDTO.getFreqct());//频次下次数
		// ciEmsDTO.setFrequnitct(ciOrTmplDTO.getFrequnitct());//频次周期数
		// ciEmsDTO.setSd_frequnitct(ciOrTmplDTO.getSd_frequnitct());//频次周期类型编码
		// ciEmsDTO.setSrvsetitms(ciOrTmplDTO.getSrvsetitms());//套对应的套内项目集合

		// ciEmsDTO.setOrapplysheet(ciOrTmplDTO.getOrapplysheet());//医嘱对应的申请单

		ciEmsDTO.setId_dept_en(envinfo.getId_dep_en());// 就诊科室
		ciEmsDTO.setId_dept_ns(envinfo.getId_dep_ns());// 护理单元
		ciEmsDTO.setFg_set(medSrvDO.getFg_set());// 是否是套
		ciEmsDTO.setDes_or(ciOrTmplDTO.getDes_or());// 嘱托

		// ciEmsDTO.setCiorfreqtimes(ciOrTmplDTO.getCiorfreqtimes());//医嘱计划频次执行时刻集合
		// ciEmsDTO.setFg_pres_outp(FBoolean.FALSE);// 出院带药标识

		// 门诊不使用后台匹配医疗单
		SrvMatchEmsRstDTO emsmatch = getFuncClassStr(envinfo, medSrvDO);
		if (emsmatch == null) {
			ciEmsDTO.setEmstype(EmsType.COMMON);
			ciEmsDTO.setFg_quickwflow(FBoolean.FALSE);
			// throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 配不到医疗单
			// ");
		} else {
			ciEmsDTO.setFuncclassstr(emsmatch.getFuncclassstr());// 医疗单URL
			ciEmsDTO.setId_srvof(emsmatch.getId_ems());// 医疗单
			ciEmsDTO.setName_ems(emsmatch.getName_show());// 医疗单名称
			ciEmsDTO.setFg_quickwflow(emsmatch.getFg_quickwflow());

			// try {
			// ciEmsDTO.setEmstype(
			// Integer.parseInt(CiOrdUtils.getEmsFunclassKVDTO(emsmatch.getFuncclassstr()).getEmstype()));//
			// 医疗单类型
			// } catch (Exception ex) {
			// OrdBizLogger.info(envinfo, "医疗服务 ：" + medSrvDO.getName() + "
			// 找不到医疗单类型 ");
			// throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 找不到医疗单类型
			// ");
			// }
		}
		if (!"0902".equals(medSrvDO.getSd_srvtp())) {
			ciEmsDTO.setApplyno(CiOrdUtils.getApplyNo(medSrvDO.getSd_srvtp()));// 申请单号
		}

		// ciEmsDTO.setFg_urgent(ciOrTmplDTO.getFg_urgent());//加急标识

		// ciEmsDTO.setId_orrsttp(ciOrTmplDTO.getId_orrsttp());//医嘱结果
		// ciEmsDTO.setId_or(ciOrTmplDTO.getId_or());//医嘱主键标识

		// ciEmsDTO.setId_srv_pkg(ciOrTmplDTO.getId_srv_pkg());//服务包
		if (!envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
				&& !envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)) { // 住院的常临标识通过
			// setCiEmsDTOUseDetailByMedSrv
			// 中频次定义设置，门诊的都设置false
			ciEmsDTO.setFg_long(FBoolean.FALSE);// 长临标识
		}

		// ciEmsDTO.setEmstype(JudgeEmsType(medSrvDO.getSd_srvtp()));//
		// 医疗单类型(药品)
		ciEmsDTO.setFg_boil(ciOrTmplDTO.getFg_boil());// 代煎标识
		if (!StringUtils.isEmpty(medSrvDO.getSd_srvtp())
				&& medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			ciEmsDTO.setEmstype(EmsType.HERB);
		}
		ciEmsDTO.setOrders(ciOrTmplDTO.getOrders());// 医嘱付数
		ciEmsDTO.setOrders_boil(ciOrTmplDTO.getOrders());// 代煎付数
		ciEmsDTO.setCode(ciOrTmplDTO.getCode());// 编码
		if (StringUtils.isBlank(ciEmsDTO.getCode())) {
			ciEmsDTO.setCode(medSrvDO.getCode());// 编码
		}
		ciEmsDTO.setName(ciOrTmplDTO.getName());// 医嘱名称
		if (StringUtils.isBlank(ciEmsDTO.getName())) {
			ciEmsDTO.setName(medSrvDO.getName());
		}
		// ciEmsDTO.setNote(ciOrTmplDTO.getNote());//备注
		ciEmsDTO.setId_emp_phy(envinfo.getId_emp_or());// 开立医生
		// ciEmsDTO.setName_emp_phy(envinfo.getName_emp());//开立医生姓名
		ciEmsDTO.setId_dep_phy(envinfo.getId_dep_or());// 开立科室
		// ciEmsDTO.setName_dep_phy(ciOrTmplDTO.getName_dep_phy());//开立科室名称
		ciEmsDTO.setId_wg_or(envinfo.getId_wg_or());// 医疗组
		FDateTime dt_open =envinfo.getDt_open();
		if(dt_open != null) {
			ciEmsDTO.setDt_begin(dt_open);// 开始日期
		}
		else {
		if (ciOrTmplDTO.getDt_effe() != null) {
			ciEmsDTO.setDt_begin(ciOrTmplDTO.getDt_effe());// 开始日期
		} else {
			FDateTime dt_begin = CiOrdUtils.getCompareFormatServerDateTime(ciEmsDTO.getId_en());
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciEmsDTO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ciEmsDTO.getCode_entp())
					|| IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ciEmsDTO.getCode_entp())) {
				dt_begin = CalDtEffeBP.GetDtEffe(ciEmsDTO.getId_freq());
			}
			ciEmsDTO.setDt_begin(dt_begin);// 开始日期
		}
		}
		

		if (!CiOrdUtils.isEmpty(ciEmsDTO.getDays_or())) {
			ciEmsDTO.setDt_end(new FDateTime(ciEmsDTO.getDt_begin().getBeginDate().getDateAfter(ciEmsDTO.getDays_or()),
					ciEmsDTO.getDt_begin().getUFTime()));// 结束日期
		}
		// ciEmsDTO.setDt_end(ciOrTmplDTO.getDt_end());//结束日期
		// ciEmsDTO.setContent(ciOrTmplDTO.getContent());//医嘱内容
		// ciEmsDTO.setDt_invalid(ciOrTmplDTO.getDt_invalid());//医嘱过期时间
		ciEmsDTO.setFg_bb(envinfo.getFg_bb());// 婴儿标识
		ciEmsDTO.setNo_bb(envinfo.getNo_bb());// 婴儿序号

		// ciEmsDTO.setFg_pmor(ciOrTmplDTO.getFg_pmor());//备用医嘱标识
		// ciEmsDTO.setDes_pmor(ciOrTmplDTO.getDes_pmor());//备用医嘱使用条件描述
		// ciEmsDTO.setId_or_rel(ciOrTmplDTO.getId_or_rel());//关联医嘱
		// ciEmsDTO.setFg_ctlcp(ciOrTmplDTO.getFg_ctlcp());//临床路径控制标识
		// ciEmsDTO.setFg_mr(ciOrTmplDTO.getFg_mr());//医疗记录联动标识
		// ciEmsDTO.setFg_skintest(ciOrTmplDTO.getFg_skintest());//需皮试标识
		// ciEmsDTO.setId_skintest_skip_reaso(ciOrTmplDTO.getId_skintest_skip_reaso());//不皮试原因（废弃不用了）
		// ciEmsDTO.setSd_skintest_skip_reaso(ciOrTmplDTO.getSd_skintest_skip_reaso());//不皮试原因编码（废弃不用了）

		ciEmsDTO.setTimes_cur(calTimesCurBP.exec(ciEmsDTO));// 总次数
		ciEmsDTO.setFg_mp_in(
				mappingProperty.getFgMpIn(ciEmsDTO.getCode_entp(), ciEmsDTO.getSd_srvtp(), ciEmsDTO.getId_route())); // 在院执行状态
		CiEmsDefaultValueSetBP defaultSetbp = new CiEmsDefaultValueSetBP();
		defaultSetbp.exec(ciEmsDTO);// 设置在院执行状态
		// ciEmsDTO.setFg_mp_in(FBoolean.TRUE);// 在院执行标识
		// 从助手生成的医疗单都设置在院执行，（医疗单中可以根据医生患者沟通确定是否需要在院执行）

		if (ciEmsDTO.getFg_mp_in().booleanValue()) { // 在院执行时
			ciEmsDTO.setTimes_mp_in(ciEmsDTO.getTimes_cur());// 如果是在院执行，助手中的构造的医嘱等于总次数
			/*
			 * if (ciEmsDTO.getTimes_mp_in() != null) { // TODO
			 * 上边没有设置在院执行次数的地方，这个判断没意义
			 * ciEmsDTO.setTimes_mp_in(ciEmsDTO.getTimes_mp_in()); } else {
			 * ciEmsDTO.setTimes_mp_in(CiOrdUtils.JudgeTiemMpIn(ciEmsDTO));
			 * ciEmsDTO.setTimes_cur(ciEmsDTO.getTimes_mp_in());// 总次数 TODO
			 * 总次数逻辑 }
			 */
		}

		// ciEmsDTO.setFg_mp_bed(ciOrTmplDTO.getFg_mp_bed());//床边执行标识
		// ciEmsDTO.setTimes_firday_mp(ciOrTmplDTO.getTimes_firday_mp());//首日执行次数
		// ciEmsDTO.setFg_or_doc(ciOrTmplDTO.getFg_or_doc());//医生医嘱标识
		// ciEmsDTO.setId_su_or(ciOrTmplDTO.getId_su_or());//医嘱状态
		// ciEmsDTO.setSd_su_or(ciOrTmplDTO.getSd_su_or());//医嘱状态编码
		// ciEmsDTO.setFg_active_pm(ciOrTmplDTO.getFg_active_pm());//备用医嘱启用标识
		// ciEmsDTO.setId_reltp(ciOrTmplDTO.getId_reltp());//关联医嘱类型编码
		// ciEmsDTO.setSd_reltp(ciOrTmplDTO.getSd_reltp());//关联医嘱类型
		ciEmsDTO.setEu_orsrcmdtp(ciOrTmplDTO.getEu_orsrcmdtp()); // 数据来源类型
																	// OrSourceFromEnum
																	// 既往、组套、模板、常规、分类...
		ciEmsDTO.setId_orsrc_main(ciOrTmplDTO.getId_orsrc_main());// 数据来源id
																	// ，既往id_or
																	// ,组套的定义id，模板(常规)id，
																	// 分类id
		ciEmsDTO.setId_orsrc_sub(ciOrTmplDTO.getId_orsrc_sub()); // 模板（常规）明细id
		ciEmsDTO.setId_orsrc_subsub(ciOrTmplDTO.getId_orsrc_subsub());// 医嘱来源孙标识
		// 存在保外诊断时，医保就诊状态调整为不需要判断医保状态（非医保状态）
		if (HpBeyondEnum.HPEXTERNALDIAG.equals(envinfo.getEu_hpbeyond())) {
			ciEmsDTO.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
		}

		ciEmsDTO.setBhpjudgerst(envinfo.getBhpjudgerst()); // 基本医保判断结果数据信息
		ciEmsDTO.setDes_bhpjudgerst(envinfo.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述

		if (OrSourceFromEnum.IIHCLINICALKITHELPER == ciOrTmplDTO.getEu_orsrcmdtp()
				&& FBoolean.TRUE.equals(ciOrTmplDTO.getFg_set())) {// 来源组套
			this.setMkrSetProperty(ciEmsDTO, envinfo, ciOrTmplDTO, medSrvDO);
		} else {
			// 创建套内项目集合
			ciEmsDTO.setSrvsetitms(this.createCiEmsSrvSetItems(ciOrTmplDTO));

			// 医嘱项目
			FArrayList list = this.getEmssrvs(ciEmsDTO, envinfo, ciOrTmplDTO, medSrvDO);
			ciEmsDTO.setEmssrvs(list);// 医疗单项目集合

			// ciEmsDTO 保留剂量
			CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) list.get(0);
			FArrayList srvlist = ciOrTmplDTO.getOrtmplsrvs();
			if (srvlist != null) {
				CiOrTmplSrvDTO tmplSrv = (CiOrTmplSrvDTO) srvlist.get(0);
				ciEmsDTO.setQuan_medu(tmplSrv.getQuan_med());
			} else {
				ciEmsDTO.setQuan_medu(ciEmsSrv.getQuan_med());
			}

			// 皮试套，套内项目的服务类型应该保持套内项目的服务类型，不一定与服务套的服务类型一致，检查检验的会一致
			for (int i = 1; i < list.size() && FBoolean.TRUE.equals(ciEmsDTO.getFg_skintest()); i++) {
				CiEmsSrvDTO ciEmsSrvItm = (CiEmsSrvDTO) list.get(i);
				MedSrvDO medSrv = bdSrvMap.get(ciEmsSrvItm.getId_srv());
				if (!CiOrdUtils.isEmpty(medSrv)) {
					ciEmsSrvItm.setId_srvtp(medSrv.getId_srvtp());
					ciEmsSrvItm.setSd_srvtp(medSrv.getSd_srvtp());
				}
			}

		}

		// 设置服务价格
		this.setCiEmsPrice(envinfo, ciEmsDTO, medSrvDO);
		// 通过ci_or_srv中的皮试标识，为ci_order表赋值，不对。
		// FArrayList emssrvList = ciEmsDTO.getEmssrvs();
		// for (Object obj : emssrvList) {
		// CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) obj;
		// if (srvDTO.getFg_skintest() == FBoolean.TRUE) {
		// ciEmsDTO.setFg_skintest(FBoolean.TRUE);
		// break;
		// }
		// }

		// TODO 代煎付数：计算代煎费用使用，草药的代煎付数等于草药付数
		// TODO 标本管理费用计算：检验门诊一条医嘱对应一组标本采集费 检验属性中标本类型，容器类型
		// 医嘱服务来源方式
		afterMergeEmsInfo(envinfo, ciEmsDTO);
		// 住院需要给首日执行次数赋值
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ciEmsDTO.getCode_entp())
				&& IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY.equals(ciEmsDTO.getSd_frequnitct())) {
			ciEmsDTO.setTimes_firday_mp(QuanFirstDayMpBP.CalFirstDayMp(ciEmsDTO.getId_freq(), ciEmsDTO.getDt_begin(),
					null, ciEmsDTO.getSd_srvtp(), ciEmsDTO.getCode_entp(), null, null));
		} else {
			ciEmsDTO.setTimes_firday_mp(QuanFirstDayMpBP.CalFirstDayMp(ciEmsDTO.getId_freq(), ciEmsDTO.getDt_begin()));
		}

		if (ciEmsDTO.getSd_srvtp() != null
				&& ciEmsDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			// 0127036: 门诊草药调用医嘱模板，嘱托赋值到备注里;如果模板备注为空，则拼接备注
			if (ciOrTmplDTO.getDes_or() == "" || ciOrTmplDTO.getDes_or() == null) {
				if (tmplSrvDTO != null && tmplSrvDTO.getQuan_med() != null) {
					// ciEmsDto.setNote(
					// "每日1剂," + (ciEmsDto.getName_boil() == "" ? "" :
					// ciEmsDto.getName_boil() + "至400ml,")
					// + tmplSrvDTO.getQuan_med() + " " + medSrvDO.getMed_name()
					// + ","
					// + ciEmsDto.getName_freq() + "," +
					// ciEmsDto.getName_route());
					ciEmsDTO.setNote(CiOrdUtils.genOrdDes(ciEmsDTO));

				} else {
					// ciEmsDto.setNote(CiOrdUtils.genOrdDes(ciEmsDto)
					// "每日1剂," + (ciEmsDto.getName_boil() == "" ? "" :
					// ciEmsDto.getName_boil() + "至400ml,")
					// + medSrvDO.getQuan_med() + " " + medSrvDO.getMed_name() +
					// ","
					// + ciEmsDto.getName_freq() + "," +
					// ciEmsDto.getName_route());
					ciEmsDTO.setNote(CiOrdUtils.genOrdDes(ciEmsDTO));
				}
			} else {
				ciEmsDTO.setNote(ciOrTmplDTO.getDes_or());
			}

			// ciEmsDto.setNote(ciEmsDto.getDes_or());

		} else {
			// ciEmsDto.setNote();
		}
	}

	protected void afterMergeEmsInfo(CiEnContextDTO ctx, CiEmsDTO ciEmsDTO) throws BizException {
		// 设置医嘱开立的医生站类型
		if (ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(ctx.getStationType())) {// 医技医生站
			ciEmsDTO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_MT);
			ciEmsDTO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);
		} else if (ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())) {// 护嘱医生站
			ciEmsDTO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_NUR);
			ciEmsDTO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_NUR);
		} else {
			ciEmsDTO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
			ciEmsDTO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
		}

	}

	/**
	 * 通过bd服务赋值频次、用法、用法要求、煎法、煎法要求、医嘱天数
	 * 
	 * @param ciEmsDTO
	 * @param ciOrTmplDTO
	 * @param tmplSrvDTO
	 * @param medSrvDOsetCiEmsDTOUseDetailByMedSrv
	 * @throws BizException
	 */
	private void setCiEmsDTOUseDetailByMedSrv(CiEnContextDTO envinfo, CiEmsDTO ciEmsDTO, MedSrvDO medSrvDO,
			CiOrTmplDTO ciOrTmplDTO) throws BizException {

		// 频次
		if (StringUtils.isBlank(ciEmsDTO.getId_freq())) {
			ciEmsDTO.setId_freq(medSrvDO.getId_freq());
		}

		// 获取SD中频次
		FreqDefDO freqDef = ifreqdefMDORService.findById(ciEmsDTO.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}

		ciEmsDTO.setFg_long(freqDef.getFg_long()); // 常临标识
													// 住院根据频次中定义的类型设置常临标识，门诊的都为false
		if (isAvailableFreq(envinfo.getCode_entp(), freqDef)) {
			ciEmsDTO.setName_freq(freqDef.getName());// 医嘱频次名称
			ciEmsDTO.setFreqct(freqDef.getFreqct()); // 频次周期下次数
			ciEmsDTO.setSd_frequnitct(freqDef.getSd_frequnitct()); // 频次周期类型编码
			ciEmsDTO.setFrequnitct(freqDef.getFrequnitct());
		} else {
			throw new BizException("服务【" + medSrvDO.getName() + "】中频次【" + freqDef.getName() + "】 在"
					+ FG_USE_MSG.get(envinfo.getCode_entp()) + "不可用！");
		}

		// 频次是一次的医嘱天数设置为1
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())) {
			ciEmsDTO.setDays_or(1);
		} else {
			if (ciOrTmplDTO != null && ciOrTmplDTO.getDays_or() != null) {
				ciEmsDTO.setDays_or(ciOrTmplDTO.getDays_or());
			} else if (envinfo != null && (envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
					|| envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)) && !FBoolean.TRUE.equals(ciEmsDTO.getFg_pres_outp())) {
				ciEmsDTO.setDays_or(null);// 医嘱天数
			}else {
				if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(ciEmsDTO.getSd_frequnitct())) { // 如果频次周期类型是星期，返回一个周期的天数
					ciEmsDTO.setDays_or(7);

				} else {
					ciEmsDTO.setDays_or(1);
				}
			}
		}

		// 设置用法id、名称
		if (StringUtils.isNotBlank(ciEmsDTO.getId_route())) {

			MedUsageDO medUsage = imedusageRService.findById(ciEmsDTO.getId_route()); // 用法
			if (medUsage == null) {
				throw new BizException("获取用法SD失败！");
			}
			ciEmsDTO.setName_route(medUsage.getName());// 用法名称
		} else {
			ciEmsDTO.setId_route(medSrvDO.getId_route());// 用法
			ciEmsDTO.setName_route(medSrvDO.getRoute_name());// 用法名称
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isNotBlank(ciEmsDTO.getId_routedes())) {
			ciEmsDTO.setName_routedes(getName_routes(ciEmsDTO.getId_routedes()));
		} else {
			ciEmsDTO.setId_routedes(medSrvDO.getId_routedes());
			ciEmsDTO.setName_routedes(medSrvDO.getRoutedes_name());
		}

		// 设置煎法id、名称
		if (StringUtils.isNotBlank(ciEmsDTO.getId_boil())) {

			// CHerbBoilMdDO cHerbBoilMd =
			// icherbboilmdMDORService.findById(ciEmsDTO.getId_boil());
			DAFacade dafa = new DAFacade();
			String sql = "select name  from bd_boil where id_boil='" + ciEmsDTO.getId_boil() + "'";
			CHerbBoilMdDO cHerbBoilMd = (CHerbBoilMdDO) dafa.execQuery(sql, new BeanHandler(CHerbBoilMdDO.class));
			if (cHerbBoilMd == null) {
				throw new BizException("获取煎法SD失败！");
			}
			ciEmsDTO.setName_boil(cHerbBoilMd.getName());
		} else {
			ciEmsDTO.setId_boil(medSrvDO.getId_boil());
			ciEmsDTO.setName_boil(medSrvDO.getBoil_name());
		}

		// 煎法要求
		if (StringUtils.isNotBlank(ciEmsDTO.getId_boildes())) {

			// CHerbBoilDesDO cherbBoilDes =
			// icHerbBoilDesDORService.findById(ciEmsDTO.getId_boildes());
			DAFacade dafa = new DAFacade();
			String sql = "select name  from bd_boil_des where id_boildes='" + ciEmsDTO.getId_boildes() + "'";
			CHerbBoilDesDO cherbBoilDes = (CHerbBoilDesDO) dafa.execQuery(sql, new BeanHandler(CHerbBoilDesDO.class));
			if (cherbBoilDes == null) {
				throw new BizException("煎法要求SD失败！");
			}
			ciEmsDTO.setName_boildes(cherbBoilDes.getName());
		} else {
			ciEmsDTO.setId_boildes(medSrvDO.getId_boildes());
			ciEmsDTO.setName_boildes(medSrvDO.getBoildes_name());
		}
	}

	private boolean isAvailableFreq(String code_entp, FreqDefDO freqDef) throws BizException {

		try {

			// 获取可使用标识的get方法并执行
			Class<? extends FreqDefDO> cls = freqDef.getClass();
			Method getMethod = cls.getDeclaredMethod(FG_USE_MAP.get(code_entp));
			Object fgUse = getMethod.invoke(freqDef);

			if (fgUse == null || !FBoolean.TRUE.equals(FBoolean.valueOf(fgUse.toString()))) {
				return false;
			}

		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

			throw new BizException("助手判断频次是否可用异常！");
		}

		return true;
	}

	/**
	 * @throws BizException
	 * 
	 */
	private void setMkrSetProperty(CiEmsDTO ciEmsDTO, CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, MedSrvDO medSrv)
			throws BizException {

		MedSrvDO[] medSrvs = this.getSetMedSrvDOs(ciOrTmpl);
		// 构造套内项目集合
		if (FBoolean.TRUE.equals(ciOrTmpl.getFg_set())) {

			FMap Srvsetitms = this.getSrvSetitmMap(ciOrTmpl.getId_srv(), medSrvs);
			ciEmsDTO.setSrvsetitms(Srvsetitms);
		}

		FArrayList ciEmsSrvList = new FArrayList();
		// 套的处理
		if (FBoolean.TRUE.equals(ciEmsDTO.getFg_set())) {
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
			this.setCiEmSrvPropertys(ciEmsDTO, srvdto, envinfo, null, medSrv);
			this.setCiEmsSrvMeduPropertys(envinfo, srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders(), ciOrTmpl);
			ciEmsSrvList.add(srvdto);
		}

		for (int i = 0; i < medSrvs.length; i++) {

			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();

			// 设置CiEmsSrvDTO相关属性，环境、服务、物品
			this.setCiEmSrvPropertys(ciEmsDTO, srvdto, envinfo, null, medSrvs[i]);

			// 设置量信息
			this.setCiEmsSrvMeduPropertys(envinfo, srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders(), ciOrTmpl);
			srvdto.setSortno(i + 1);// 设置排序
			if (FBoolean.TRUE.equals(ciOrTmpl.getFg_set())) {
				srvdto.setId_srv_set(ciOrTmpl.getId_srv());
			}
			srvdto.setCode_srv(medSrv.getCode());
			ciEmsSrvList.add(srvdto);
		}
		ciEmsDTO.setEmssrvs(ciEmsSrvList);
		CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) ciEmsSrvList.get(0);
		ciEmsDTO.setQuan_medu(srvDTO.getQuan_med());

		if (ciEmsDTO.getSd_srvtp() != null
				&& ciEmsDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			ciEmsDTO.setNote(" " + ciEmsDTO.getName_boil() + " " + srvDTO.getQuan_med() + "," + ciEmsDTO.getName_freq()
					+ "," + ciEmsDTO.getName_route());

		} else {
			// ciEmsDTO.setNote();
		}

	}

	/**
	 * 获取CiEmsSrvDTO集合
	 * 
	 * @param envinfo
	 *            当前环境吧信息
	 * @param ciOrTmpl
	 *            医嘱模板
	 * @param medSrv
	 *            基础服务
	 * @return
	 * @throws BizException
	 */
	private FArrayList getEmssrvs(CiEmsDTO ciEmsDTO, CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, MedSrvDO medSrv)
			throws BizException {

		FArrayList ciEmsSrvList = new FArrayList();
		FArrayList srvlist = ciOrTmpl.getOrtmplsrvs();
		// 套的处理
		if (FBoolean.TRUE.equals(medSrv.getFg_set())) {
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();

			this.setCiEmSrvPropertys(ciEmsDTO, srvdto, envinfo, null, medSrv);
			this.setCiEmsSrvMeduPropertys(envinfo, srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders(), ciOrTmpl);
			ciEmsSrvList.add(srvdto);
		}

		MedSrvDO tempMedSrv = null;

		for (int i = 0; i < srvlist.size(); i++) {
			CiOrTmplSrvDTO tmplSrv = (CiOrTmplSrvDTO) srvlist.get(i);
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
			srvdto.setId_hp(envinfo.getId_hp());
			tempMedSrv = CiOrdAppUtils.getIMedsrvMDORService().findById(tmplSrv.getId_srv());// 获取每个项目

			// 设置CiEmsSrvDTO相关属性，环境、模板、服务、物品
			this.setCiEmSrvPropertys(ciEmsDTO, srvdto, envinfo, tmplSrv, tempMedSrv);
			if (FBoolean.TRUE.equals(tempMedSrv.getFg_ctm())) {
				srvdto.setFg_selfsrv(FBoolean.TRUE);
				srvdto.setName_srv(ciOrTmpl.getName());
			}
			// 领药方式不为空时 直接从医嘱模板中获取总量
			if (tmplSrv.getQuan_total_medu() != null && tmplSrv.getSd_drugdeliverymethod() != null) {
				srvdto.setQuan_cur(tmplSrv.getQuan_total_medu());
				srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu());
				srvdto.setId_unit_sale(tmplSrv.getId_unit_sale());
			} else {
				// 设置量信息
				this.setCiEmsSrvMeduPropertys(envinfo, srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders(), ciOrTmpl);
			}

			srvdto.setSortno(i + 1);// 设置排序
			// 是套服务时才设置id_srv_set属性 2016-11-28
			if (FBoolean.TRUE.equals(medSrv.getFg_set())) {
				srvdto.setId_srv_set(ciOrTmpl.getId_srv());
			}
			srvdto.setCode_srv(tempMedSrv.getCode());
			srvdto.setFg_skintest(tmplSrv.getFg_skintest());
			srvdto.setFg_outp(ciOrTmpl.getFg_pres_outp());
			ciEmsSrvList.add(srvdto);
		}
		// 设置执行科室相关属性
		// this.setCiEmsSrvOrWfDept((CiEmsSrvDTO) ciEmsSrvList.get(0), envinfo,
		// medSrv, ciEmsDTO);
		// for (int i = 1; i < ciEmsSrvList.size(); i++) {
		// ((CiEmsSrvDTO) ciEmsSrvList.get(i)).setId_dep_wh(((CiEmsSrvDTO)
		// ciEmsSrvList.get(0)).getId_dep_wh());
		// ((CiEmsSrvDTO) ciEmsSrvList.get(i)).setName_dep_wh(((CiEmsSrvDTO)
		// ciEmsSrvList.get(0)).getName_dep_wh());
		// }
		return ciEmsSrvList;
	}

	/**
	 * 设置CiEmsSrvDTO对象属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param tmplSrv
	 *            医嘱模板（组套数据转换该值为null）
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmSrvPropertys(CiEmsDTO ciEmsDTO, CiEmsSrvDTO srvdto, CiEnContextDTO envinfo,
			CiOrTmplSrvDTO tmplSrv, MedSrvDO medSrv) throws BizException {

		// 设置环境相关属性
		this.setCiEmsSrvEnvinfoPropertys(srvdto, envinfo);

		// 设置服务相关属性
		this.setCiEmsSrvMedSrvPropertys(srvdto, medSrv);
		if (tmplSrv != null) { // 医嘱模板进来的为空
			// 设置模板中的属性
			this.setCiEmSrvTmplPropertys(srvdto, tmplSrv);
			// 设置频次、用法、用法要求、煎法、煎法要求
			this.setCiEmsSrvUseDetail(srvdto, medSrv);
		}
		// 设置物品相关属性
		this.setCiEmsSrvMmPropertys(ciEmsDTO, srvdto, envinfo, medSrv);

		// 医保就诊，并且都是保内诊断时为医保就诊，否则为自费（保外）
		if (envinfo.getId_hp() != null && HpBeyondEnum.HPDIAG.equals(envinfo.getEu_hpbeyond())) {
			srvdto.setFg_selfpay(FBoolean.FALSE);// 保内，非自费
		} else {
			srvdto.setFg_selfpay(FBoolean.TRUE);// 保外 、自费
		}

	}

	/**
	 * 设置环境相关属性
	 * 
	 * @param srvdto
	 *            服务项目
	 * @param envinfo
	 *            当前环境
	 */
	private void setCiEmsSrvEnvinfoPropertys(CiEmsSrvDTO srvdto, CiEnContextDTO envinfo) {

		srvdto.setStatus(DOStatus.NEW);

		srvdto.setId_dep_srv(envinfo.getId_dep_or());// 开立科室
		srvdto.setId_ward_srv(envinfo.getId_dep_ns());// 开立病区，门诊该值为空，住院时会有值
		srvdto.setId_emp_srv(envinfo.getId_emp_or());// 开立人员
		srvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());// 开立时间
		srvdto.setId_hp(envinfo.getId_hp());// 主医保计划

		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);// 医疗单项目数据来源方式
	}

	/**
	 * 设置模板中相关属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmSrvTmplPropertys(CiEmsSrvDTO srvdto, CiOrTmplSrvDTO tmplSrv) throws BizException {

		// srvdto.setId_orsrv(tmplSrv.getId_orsrv());//医疗单项目主键标识
		// srvdto.setId_or(tmplSrv.getId_or());//医疗单
		// srvdto.setSortno(tmplSrv.getSortno());// 序号 循环时统一设置
		srvdto.setId_srv(tmplSrv.getId_srv());// 医疗服务
		srvdto.setFg_self(tmplSrv.getFg_selfsrv()); // 自定义服务标识
		if (FBoolean.TRUE.equals(srvdto.getFg_self())) { // 自定义服务名，只有就诊历史会出现自定义服务
			srvdto.setName_srv(tmplSrv.getName_selfsrv());
		}
		srvdto.setFg_set(tmplSrv.getFg_set()); // TODO 套属性
												// 套内项目，基本服务，套属性都应该是false
												// ,自定义服务有tao概念没？
		if (StringUtils.isNotEmpty(tmplSrv.getId_srvtp())) {
			srvdto.setId_srvtp(tmplSrv.getId_srvtp());// 服务类型 mantis:0181513
														// 模板开立的id有为空的情况
		}
		if (StringUtils.isNotEmpty(tmplSrv.getSd_srvtp())) {
			srvdto.setSd_srvtp(tmplSrv.getSd_srvtp());// 服务类型编码
		}
		if (StringUtils.isNotEmpty(tmplSrv.getId_freq())) {
			srvdto.setId_freq(tmplSrv.getId_freq());// 频次
		}
		if (StringUtils.isNotEmpty(tmplSrv.getId_route())) {
			srvdto.setId_route(tmplSrv.getId_route());// 用法
		}
		if (StringUtils.isNotEmpty(tmplSrv.getId_routedes())) {
			srvdto.setId_routedes(tmplSrv.getId_routedes());// 用法要求
		}
		if (StringUtils.isNotEmpty(tmplSrv.getId_boil())) {
			srvdto.setId_boil(tmplSrv.getId_boil());// 煎法
		}
		if (StringUtils.isNotEmpty(tmplSrv.getId_boildes())) {
			srvdto.setId_boildes(tmplSrv.getId_boildes());// 煎法要求
		}
		if (tmplSrv.getQuan_med() != null) {
			srvdto.setQuan_med(tmplSrv.getQuan_med());// 医学单位数值（剂量）
		}
		if (StringUtils.isNotEmpty(tmplSrv.getId_unit_med())) {
			srvdto.setId_unit_med(tmplSrv.getId_unit_med());// 医学单位（计量单位）
			IMeasdocRService service = ServiceFinder.find(IMeasdocRService.class);
			MeasDocDO meas = service.findById(tmplSrv.getId_unit_med());
			if (meas != null) {
				srvdto.setName_unit_med(meas.getName());
			}
		}
		if (tmplSrv.getQuan_total_medu() != null) {
			srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu()); // 总量 TODO
			// 对于服务套来说，缺少总量单位
			srvdto.setId_unit_sale(tmplSrv.getId_unit_sale());
			IMeasdocRService service = ServiceFinder.find(IMeasdocRService.class);
			MeasDocDO meas = service.findById(tmplSrv.getId_unit_sale());
			if (meas != null) {
				srvdto.setName_unit_sale(meas.getName());
			}
		}

		srvdto.setId_dep(tmplSrv.getId_dep_mp()); // 执行科室
		srvdto.setId_mm(tmplSrv.getId_mm());// 物品
		// 服务分类开立医嘱的时候 当前剂量 换算系数等值为空
		if (tmplSrv.getFactor_cur() == null) {
			srvdto.setQuan_medu_cur(tmplSrv.getQuan_med());
			srvdto.setId_medu_cur(tmplSrv.getId_unit_med());
			srvdto.setFactor_medu_cur(new FDouble(1));
		} else {
			srvdto.setQuan_medu_cur(tmplSrv.getQuan_medu_cur());
			srvdto.setId_medu_cur(tmplSrv.getId_medu_cur());
			srvdto.setFactor_medu_cur(tmplSrv.getFactor_cur());
		}
	}

	/**
	 * 通过MedSrvDO补全CiEmsSrvDTO中缺失的属性
	 * 
	 * @param srvdto
	 *            CiEmsSrvDTO对象
	 * @param medSrv
	 *            服务对象
	 * @param sortNo
	 *            排序号
	 * @param idSrvSet
	 *            所属的服务套id
	 * @throws BizException
	 */
	private void setCiEmsSrvMedSrvPropertys(CiEmsSrvDTO srvdto, MedSrvDO medSrv) throws BizException {

		// 频次
		if (StringUtils.isBlank(srvdto.getId_freq())) {
			srvdto.setId_freq(medSrv.getId_freq());
		}

		// 设置用法id
		if (StringUtils.isBlank(srvdto.getId_route())) {
			srvdto.setId_route(medSrv.getId_route());
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isBlank(srvdto.getId_routedes())) {
			srvdto.setId_routedes(medSrv.getId_routedes());
		}

		// 设置煎法id
		if (StringUtils.isBlank(srvdto.getId_boil())) {
			srvdto.setId_boil(medSrv.getId_boil());
		}

		// 煎法要求
		if (StringUtils.isBlank(srvdto.getId_boildes())) {
			srvdto.setId_boildes(medSrv.getId_boildes());
		}

		// srvdto.setId_orsrv(tmplSrv.getId_orsrv());//医疗单项目主键标识
		// srvdto.setId_or(tmplSrv.getId_or());//医疗单
		// srvdto.setSortno(sortNo);// 序号

		if (StringUtils.isBlank(srvdto.getId_srv())) {
			srvdto.setId_srv(medSrv.getId_srv());// 医疗服务
		}

		if (StringUtils.isBlank(srvdto.getId_srvtp())) {
			srvdto.setId_srvtp(medSrv.getId_srvtp());// 服务类型
		}

		if (StringUtils.isBlank(srvdto.getSd_srvtp())) {
			srvdto.setSd_srvtp(medSrv.getSd_srvtp());// 服务类型编码
		}

		srvdto.setCode_srv(medSrv.getCode());// 医疗服务编码
		srvdto.setName_srv(medSrv.getName());// 医疗服务名称
		srvdto.setId_srvca(medSrv.getId_srvca());// 服务项目基本分类

		if (isFDoubleEmpty(srvdto.getQuan_med())) {
			srvdto.setQuan_med(medSrv.getQuan_med());// 医学单位数值（剂量）
		}

		if (StringUtils.isBlank(srvdto.getId_unit_med())) {
			srvdto.setId_unit_med(medSrv.getId_unit_med());// 医学单位(剂量单位)
		}
		srvdto.setName_unit_med(medSrv.getMed_name()); // 医学单位名称（剂量单位名称）

		// srvdto.setPrice(medSrv.getPri());// 参考价格 TODO 参考价为空时需要重新计算

		// srvdto.setFg_dose_anoma(tmplSrv.getFg_dose_anoma());//变动用药标识
		// srvdto.setDes_srv(tmplSrv.getDes_srv());//备注

		srvdto.setFg_mm(medSrv.getFg_mm());// 物品标识
		srvdto.setFg_set(medSrv.getFg_set());// 服务套标识 套内项目全设置为False TODO
		// srvdto.setId_srv_set(medSrv.getId_srv()); 在循环过程中设置该属性
		MedSrvSetItemDO medSrvSetItem = setItemSrvMap.get(srvdto.getId_srv());
		if (medSrvSetItem != null) {
			srvdto.setFg_or(medSrvSetItem.getFg_clinical());// 医嘱标识
		} else {
			srvdto.setFg_or(medSrv.getFg_or());// 医嘱标识
		}

		srvdto.setFg_bl(medSrv.getFg_bl());// 费用标识
		// srvdto.setFg_self(medSrvDO.getFg_self());//自备药标识
		// srvdto.setFg_outp(tmplSrv.getFg_outp());//出院带药标识（废弃不用了）
		// srvdto.setFg_propc(tmplSrv.getFg_propc());//预防用药标识
		// srvdto.setFg_treat(tmplSrv.getFg_treat());//治疗用药标识
		// srvdto.setId_org_srv(envinfo.getId_org_or());//开立机构
		// srvdto.setId_dep_srv(envinfo.getId_dep_or());// 开立科室
		// srvdto.setId_ward_srv(envinfo.getId_dep_ns());// 开立病区，门诊该值为空，住院时会有值
		// srvdto.setId_emp_srv(envinfo.getId_emp_or());// 开立人员
		// srvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());// 开立时间
		// OrWfDeptInfoDTO deptMpDTo1 = getMpDeptID(envinfo, medSrv); // 执行科室
		//
		// srvdto.setId_dep(deptMpDTo.getFirstid_mp_dept());// 执行科室
		// srvdto.setName_dep(deptMpDTo.getFirstname_mp_dept());// 执行科室名称
		// srvdto.setDt_last_bl(tmplSrv.getDt_last_bl());//最近生成日期
		srvdto.setEu_blmd(medSrv.getEu_blmd());// 划价方式
		// srvdto.setId_orsrvmm(tmplSrv.getId_orsrvmm());//服务项目物品
		// srvdto.setId_mm(tmplSrv.getId_mm());// 物品

		// srvdto.setEmsfreqdose(tmplSrv.getEmsfreqdose());//变动用药安排
		// 查询检查属性
		MedSrvRisDO[] medSrvRises = imedSrvRisDORService.findByAttrValString("Id_srv", srvdto.getId_srv());
					
		//MedSrvRisDO medSrvRis = srvRisMap.get(srvdto.getId_srv());
		if (medSrvRises != null&& medSrvRises.length>0&& medSrvRises[0]!=null && !FBoolean.TRUE.equals(srvdto.getFg_set())) {
			srvdto.setId_body(medSrvRises[0].getId_body());// 部位
			srvdto.setSd_body(medSrvRises[0].getSd_body());// 部位编码
			srvdto.setBody_name(medSrvRises[0].getName_body());// 部位名称
			srvdto.setId_pos(medSrvRises[0].getId_pos());// 体位
			srvdto.setSd_pos(medSrvRises[0].getSd_pos());// 体位编码
			srvdto.setPos_name(medSrvRises[0].getName_pos());// 体位名称
		}

		// srvdto.setFg_indic(tmplSrv.getFg_indic());//医保适应症标识
		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);// 医疗单项目数据来源方式
		// srvdto.setSrv_sv(medSrvDO.getSrv_sv());//服务版本号
		// srvdto.setMm_sv(tmplSrv.getMm_sv());//物品版本号
		// srvdto.setFg_skintest(tmplSrv.getFg_skintest());//需皮试标识
		// srvdto.setId_skintest_skip_reason(tmplSrv.getId_skintest_skip_reason());//不皮试原因
		// srvdto.setSd_skintest_skip_reason(tmplSrv.getSd_skintest_skip_reason());//不皮试原因编码
		// srvdto.setId_reltp(tmplSrv.getId_reltp());//关联类型
		// srvdto.setSd_reltp(tmplSrv.getSd_reltp());//关联类型编码
		// srvdto.setId_or_rel(tmplSrv.getId_or_rel());//关联医嘱
		// srvdto.setFg_skintest_rst(tmplSrv.getFg_skintest_rst());//皮试是否有结果
		srvdto.setFg_selfsrv(medSrv.getFg_ctm());// 自定义服务标识
		// srvdto.setId_srv_src(tmplSrv.getId_srv_src());//所属来源服务
		// srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu());// 服务总量
		srvdto.setId_primd(medSrv.getId_primd());// 定价模式
		// srvdto.setFg_selfpay(medSrvDO.getFg_selfpay());//自费标识
		// srvdto.setId_hp(envinfo.getId_hp());// 主医保计划
		// srvdto.setId_hpsrvtp(tmplSrv.getId_hpsrvtp());//医保目录类型
		// srvdto.setSd_hpsrvtp(tmplSrv.getSd_hpsrvtp());//医保目录类型编码
		// srvdto.setId_dep_wh(deptMpDTo.getId_dep_wh());// 仓库
		// srvdto.setEmsagentinfo(tmplSrv.getEmsagentinfo());//毒麻药品服务代办人信息
		srvdto.setInnercode_srvca(medSrv.getSrvca_code());// 服务分类内码
		// srvdto.setSd_frequnitct(tmplSrv.getSd_frequnitct());//频次周期类型
		// srvdto.setFrequnitct(tmplSrv.getFrequnitct());//频次周期数
		// srvdto.setFreqct(tmplSrv.getFreqct());//频次周期下次数
		// srvdto.setName_hpsrvtp(tmplSrv.getName_hpsrvtp());//医保目录名称
		// srvdto.setLimit(tmplSrv.getLimit());//限制报销条件
		// srvdto.setAmt_total(tmplSrv.getAmt_total());//总金额
		// srvdto.setName_dep_wh(deptMpDTo.getId_dep_wh());// 库房名称
		// srvdto.setId_unit_cg(tmplSrv.getId_unit_cg());//计费单位
		// srvdto.setName_unit_cg(meterial.getParentDO().getName_unit_cg());//计费单位名称
		// srvdto.setQuan_cgbase(meterial.getParentDO().getQuan_cgbase());//计费基数
		// srvdto.setFactor_cm(meterial.getParentDO().getFactor_cm());//系数_费医
		// srvdto.setSd_roundmd_cg(meterial.getParentDO().getSd_roundmd_cg());//计费取整模式

		// srvdto.setAmt_cur(tmplSrv.getAmt_cur());//金额
		// srvdto.setQuan_stock(tmplSrv.getQuan_stock());//可用库存
		// srvdto.setId_srvskin(tmplSrv.getId_srvskin());//对应皮试服务
		// srvdto.setMapkeys(tmplSrv.getMapkeys());//关联信息Map键值串
		// srvdto.setMapinfo(tmplSrv.getMapinfo());//服务与物品关联信息MAP
		// srvdto.setPriby(tmplSrv.getPriby());//计价依据
		// srvdto.setFg_base(tmplSrv.getFg_base());//基数药标识

		// TODO 调用计算总量方法
	}

	/**
	 * 设置CiEmsSrvDTO中物品相关属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmsSrvMmPropertys(CiEmsDTO ciEmsDTO, CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, MedSrvDO medSrv)
			throws BizException {

		if (!FBoolean.TRUE.equals(medSrv.getFg_mm())) {
			return;
		}
		MeterialAggDO meterialAgg = null;
		if (StringUtils.isNotBlank(srvdto.getId_mm())) {
			meterialAgg = CiOrdAppUtils.getIMeterialRService().findById(srvdto.getId_mm());
		} else {
			String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + "." + MeterialDO.ID_SRV + " = '" + medSrv.getId_srv()
					+ "'";
			MeterialAggDO[] meterAggDO = CiOrdAppUtils.getIMeterialRService().find(whereStr, MeterialDO.ID_SRV,
					FBoolean.FALSE);
			if (meterAggDO != null && meterAggDO.length > 0) {
				meterialAgg = meterAggDO[0];
			}
		}

		if (meterialAgg == null) {
			OrdBizLogger.info(envinfo, "服务【" + medSrv.getName() + "】没有查询到关联的物品！");
			throw new BizRuntimeException("服务【" + medSrv.getName() + "】没有查询到关联的物品！");
		}

		MeterialDO meterial = meterialAgg.getParentDO();
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		// 查询该物品药品属性是否抗菌素用药
		sql.append(" select fg_anti  from bd_srv_drug where id_srv = '" + medSrv.getId_srv() + "'");
		List<String> list = (List<String>) dafacade.execQuery(sql.toString(), new ColumnListHandler());
		if (!CiOrdUtils.isEmpty(list)) {
			FBoolean fg_anti = new FBoolean(list.get(0));
			if (fg_anti != null && fg_anti.booleanValue()) {
				//0192359: 【验证版】【住院医生站】抗菌药从服务分类开立时用药目的默认值应为空
				srvdto.setFg_propc(null);
			}
		}
		// 新生儿患者不进行皮试
		if (!FBoolean.TRUE.equals(envinfo.getFg_newborn())) {
			srvdto.setFg_skintest(meterial.getFg_skin());
		}
		srvdto.setFg_skintest_mm(meterial.getFg_skin());
		srvdto.setId_srvskin(meterial.getId_srvskin());
		// srvdto.setQuan_cur(tmplSrv.getQuan_cur());//总量_当前
		/// srvdto.setQuan_base(meterial.getQuan_base());//总量_基本
		srvdto.setId_mm(meterial.getId_mm());// 物品id
		srvdto.setName_mm(meterial.getName());// 物品名称
		srvdto.setSpec_mm(meterial.getSpec());// 规格
		// 获取物品的有效单位
		MaterialUnitDTO[] materIalUnits = BDMmDoseUnitInfoCache.getMaterialUnitInfos(envinfo.getCode_entp(),
				new String[] { srvdto.getId_mm() });
		if (srvdto.getId_unit_sale() == null) {
			srvdto.setId_unit_sale(materIalUnits[0].getId_measdoc());// 零售单位
			srvdto.setName_unit_sale(materIalUnits[0].getMeasdoc_name());// 零售单位名称
		}

		srvdto.setId_unit_base(meterial.getId_unit_pkgbase());// 基本单位
		srvdto.setName_unit_base(meterial.getPkgbase_name());// 基本单位名称
		// srvdto.setQuan_num_base(meterial.getParentDO().getQuan_num_base());//单次数量_分子
		// srvdto.setQuan_den_base(meterial.getParentDO().getQuan_den_base());//单次数量_分母
		// srvdto.setPrice_cur(tmplSrv.getPrice_cur());//参考价当前
		// srvdto.setQuan_bed_medu(tmplSrv.getQuan_bed_medu());//床边量_医学
		srvdto.setFactor_cb(materIalUnits[0].getFactor());// 当前基本换算系数
		srvdto.setFactor_mb(meterial.getFactor_mb());// 医疗基本换算系数
		// srvdto.setFactor(getSaleFactor(meterial,srvdto.getId_unit_sale()));//总量单位换算系数
		this.setCiEmsSrvOrWfDept(ciEmsDTO, srvdto, envinfo, medSrv);
		FDouble pricce = this.getMMPrice(meterial.getId_mm(), materIalUnits[0].getId_measdoc(), srvdto.getId_dep_wh());
		srvdto.setPrice_cur(pricce);
		srvdto.setPrice(pricce);
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_mupkgutp());// 住院-取整方式
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_opmutp());// 门诊-取整方式
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_ermutp());// 急诊流水-取整方式
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_er1mutp());// 急诊抢救-取整方式
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_er2mutp());// 急诊留观-取整方式
		}
		srvdto.setId_mupkgutp(meterial.getId_mupkgutp());// 物品住院取整模式id
		srvdto.setSd_mupkgutp(meterial.getSd_mupkgutp());// 物品住院取整模式d
		srvdto.setId_opmutp(meterial.getId_opmutp());// 物品门诊取整模式id
		srvdto.setSd_opmutp(meterial.getSd_opmutp());// 物品门诊取整模式sd
		// 获取药品属性 代优化 查询位置不对
		String whereStr = MedSrvDrugDO.ID_SRV + "='" + medSrv.getId_srv() + "'";
		MedSrvDrugDO[] drugDO = CiOrdAppUtils.getIMedSrvDrugDORService().find(whereStr, MedSrvDrugDO.ID_SRV,
				FBoolean.FALSE);
		if (drugDO != null && drugDO.length > 0) {
			srvdto.setId_dosage(drugDO[0].getId_dosage());// 药品剂型
			srvdto.setSd_dosage(drugDO[0].getSd_dosage());// 药品剂型编码
			srvdto.setId_pharm(drugDO[0].getId_pharm());// 药理分类
			srvdto.setSd_pharm(drugDO[0].getSd_pharm());// 药理分类编码
			srvdto.setId_pois(drugDO[0].getId_pois());// 毒麻分类
			srvdto.setSd_pois(drugDO[0].getSd_pois());// 毒麻分类编码
			srvdto.setId_anti(drugDO[0].getId_anti());// 抗菌药分类
			srvdto.setSd_anti(drugDO[0].getSd_anti());// 抗菌药分类编码
		}

		srvdto.setId_mmtp(meterial.getId_mmtp());// 物品类型
		srvdto.setSd_mmtp(meterial.getSd_mmtp());// 物品类型编码
		srvdto.setName_mmtp(meterial.getMmca_name());// 物品类型名称
		srvdto.setId_sup(meterial.getId_sup());// 厂家
		srvdto.setName_sup(meterial.getFactory_name());// 厂家名称
		srvdto.setCode_mm(meterial.getCode());// 物品编码
		srvdto.setSd_val(meterial.getSd_val());// 价值分类编码
		srvdto.setId_val(meterial.getId_val());// 价值分类
		srvdto.setIndica(meterial.getIndica());// 适应症
		srvdto.setConstr(meterial.getConstr());// 禁忌症
		srvdto.setReact(meterial.getReact());// 不良反应
		// srvdto.setGuide(meterial.getGuide());//主要作用
		srvdto.setFg_otc(meterial.getFg_otc());// OTC标识

		// srvdto.setPrice(meterial.getPrice());// 零售价
		srvdto.setId_medu_cur(srvdto.getId_unit_med());
		srvdto.setQuan_medu_cur(srvdto.getQuan_med());
		srvdto.setFactor_medu_cur(new FDouble("1"));
	}

	/**
	 * 设置服务价格
	 * 
	 * @param srvdto
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmsPrice(CiEnContextDTO envinfo, CiEmsDTO ciEmsDTO, MedSrvDO medSrv) throws BizException {

		String id_pripat = envinfo.getId_pripat();
		FArrayList emssrvList = ciEmsDTO.getEmssrvs();
		CiEmsSrvDTO srvdto = (CiEmsSrvDTO) emssrvList.get(0);
		// 如果价格不为空，或者套内项目不进行价格计算
		if (srvdto.getPrice() != null) {
			return;
		}
		// 套本身是不付费的，不用再算了，zhangwq20191108
		if (FBoolean.TRUE.equals(ciEmsDTO.getFg_set())) {
			return;
		}
		// 构造查询价格参数
		BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
		param.setId_srv(medSrv.getId_srv());
		param.setName_srv(medSrv.getName());
		param.setId_primd(medSrv.getId_primd());
		param.setNum(0);
		// 如果是套，根据套内项目计算价格
		if (FBoolean.TRUE.equals(ciEmsDTO.getFg_set()) && srvSetItemsMap.size() > 0) {

			// 计算费用的套内项目个数
			int clinicalBlCnt = 0;
			List<MedSrvSetItemDO> srvsetitmList = srvSetItemsMap.get(ciEmsDTO.getId_srv());
			FArrayList list = new FArrayList();
			if (srvsetitmList == null || srvsetitmList.size() == 0) {
				throw new BizRuntimeException("服务[" + ciEmsDTO.getName() + "]未找到对应的套内项目！");
			}
			for (MedSrvSetItemDO medSrvSetItem : srvsetitmList) {

				// 非临床的不计算价格
				if (!FBoolean.TRUE.equals(medSrvSetItem.getFg_clinical())) {
					continue;
				}

				BdSrvPriCalParamDTO srvParamDTO = new BdSrvPriCalParamDTO();
				srvParamDTO.setId_primd(medSrv.getId_primd());
				srvParamDTO.setNum(1);
				srvParamDTO.setId_srv(medSrvSetItem.getId_srv_itm());

				// 诊疗项目中勾选临床价格计算标识的才计算个数
				if (FBoolean.TRUE.equals(medSrvSetItem.getFg_clinical_bl())) {
					clinicalBlCnt++;
				}
				list.add(srvParamDTO);
			}

			param.setNum(clinicalBlCnt);
			param.setSrvsetitms(list);
		}

		CiOrBdSrvPricesCalByPriModeBP bp = new CiOrBdSrvPricesCalByPriModeBP();
		MedSrvPriceDO medSrvPrice = bp.exec(param, id_pripat);
		// 存在不计费服务
		if (null != medSrvPrice) {
			srvdto.setPrice(medSrvPrice.getPrice_ratio());
			srvdto.setPri_ratio(medSrvPrice.getPrice_ratio());
			srvdto.setPri_std(medSrvPrice.getPrice_std());
			srvdto.setPrice_cur(medSrvPrice.getPrice_ratio());
			srvdto.setId_pripat(id_pripat);
		} else {
			srvdto.setPrice(FDouble.ZERO_DBL);
			srvdto.setPri_ratio(FDouble.ONE_DBL);
			srvdto.setPri_std(FDouble.ZERO_DBL);
			srvdto.setPrice_cur(FDouble.ZERO_DBL);
			srvdto.setId_pripat(id_pripat);
		}

	}

	/**
	 * 计算CiEmsSrvDTO中的总量
	 * 
	 * @param srvdto
	 *            服务项目对象
	 * @param useDays
	 *            使用天数
	 * @param orders
	 *            医嘱付数（草药使用）
	 * @throws BizException
	 */
	private void setCiEmsSrvMeduPropertys(CiEnContextDTO envinfo, CiEmsSrvDTO srvdto, Integer useDays, Integer orders,
			CiOrTmplDTO ciOrTmpl) throws BizException {

		useDays = useDays == null ? 1 : useDays;
		orders = orders == null ? 7 : orders;
		CalQuantumBP calQuantumBP = new CalQuantumBP();
		// 如果是物品，重新获取物品对象 TODO 计算总量
		if (FBoolean.TRUE.equals(srvdto.getFg_mm())) {
			// 计算药品总量
			if (FBoolean.TRUE.equals(srvdto.getFg_dose_anoma())) { // 变动用药计算总量
				GetDrugTotalQuan4DoseBP bp = new GetDrugTotalQuan4DoseBP();
				srvdto.setQuan_cur(new FDouble(bp.exec(srvdto, useDays)));
			} else {
				// 门诊和出院带药计算总量
				if (CiOrdUtils.isOpWf(envinfo.getCode_entp()) || FBoolean.TRUE.equals(envinfo.getFg_pres_outp())) {
					if (srvdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
						srvdto.setQuan_cur(calQuantumBP.getMMQuantum(envinfo.getCode_entp(), envinfo.getFg_pres_outp(),
								orders, srvdto.getId_mm(), srvdto.getId_unit_sale(), srvdto.getQuan_med()));
					} else {
						srvdto.setQuan_cur(calQuantumBP.getMMQuantum(envinfo.getCode_entp(), envinfo.getFg_pres_outp(),
								ciOrTmpl.getDt_effe(), useDays, srvdto.getId_freq(), srvdto.getId_mm(),
								srvdto.getId_unit_sale(), srvdto.getQuan_med()));
					}
				}
				srvdto.setQuan_total_medu(srvdto.getQuan_cur());
			}
			// 领量天数
			srvdto.setDays_available(new GetDrugDaysOfAvailable().exec(srvdto));
		} else {
			// 计算非药品服务总量
			srvdto.setQuan_cur(calQuantumBP.getUnMMQuantum(ciOrTmpl.getDt_effe(), srvdto.getId_freq(), useDays,
					srvdto.getQuan_med()));
			srvdto.setQuan_total_medu(srvdto.getQuan_cur());
		}
	}

	/**
	 * 设置CiEmsSrvDTO中执行科室相关属性
	 * 
	 * @param srvdto
	 *            CiEmsSrv 服务项目
	 * @param envinfo
	 *            当前环境
	 * @param medSrv
	 *            bd中医疗服务对象
	 * @throws BizException
	 */
	private void setCiEmsSrvOrWfDept(CiEmsDTO ciEmsDTO, CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, MedSrvDO medSrv)
			throws BizException {

		if (srvdto == null || envinfo == null || medSrv == null) {
			return;
		}
		String sd_srvtp = srvdto.getSd_srvtp();
		medSrv.setId_route(srvdto.getId_route());// 用法应该采用模板传来的，而不是bd_srv查的
		// 获取执行科室 科室在这里指药房 通过类型字段区分的
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(envinfo, medSrv.getId_srv(), srvdto.getId_mm(),
				ciEmsDTO.getId_route(), ciEmsDTO.getId_dep_mp(), ciEmsDTO.getFg_long(), ciEmsDTO.getFg_pres_outp(),
				ciEmsDTO.getDt_begin());
		if (null != wf) {
			List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();
			if (sd_srvtp != null && sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {// 药品
				// 1.判断优先级最高的仓库是否有库存
				constructConditions(reqDtos, srvdto, wf.getId_dept_wh());
				MaterialStockDTO materialDo = selectWhDept(reqDtos);
				setWhDept(srvdto, materialDo, wf.getName_dept_wh());
				if (srvdto.getId_dep_wh() != null && srvdto.getName_dep_wh() != null) {// 若第一优先级药房附了值
																						// 直接返回
					return;
				}
				// 2.若优先级最高的没有库存，遍历其他优先级的仓库，从中任选一个
				FArrayList idDeptWhs = wf.getPharmwfwhdepts();
				if (idDeptWhs != null && idDeptWhs.size() > 0) {
					reqDtos = new ArrayList<GetStockReqDTO>();
					Map<String, String> map = new HashMap<String, String>();
					for (int i = 0; i < idDeptWhs.size(); i++) {
						OrWfExDeptDTO orWfExDeptDTO = (OrWfExDeptDTO) idDeptWhs.get(i);
						map.put(orWfExDeptDTO.getId_dept(), orWfExDeptDTO.getName_dept());
						constructConditions(reqDtos, srvdto, orWfExDeptDTO.getId_dept());
					}
					materialDo = selectWhDept(reqDtos);
					if (materialDo != null) {
						setWhDept(srvdto, materialDo, map.get(materialDo.getId_dep()));
					}
				}
			} else {
				srvdto.setId_dep_wh(wf.getId_dept_wh());
				srvdto.setName_dep_wh(wf.getName_dept_wh());
			}
		}
	}

	/**
	 * 设置库房字段值
	 * 
	 * @param srvdto
	 * @param materialDo
	 * @param deptName
	 */
	private void setWhDept(CiEmsSrvDTO srvdto, MaterialStockDTO materialDo, String deptName) {
		if (materialDo != null) {
			srvdto.setId_dep_wh(materialDo.getId_dep());
			srvdto.setName_dep_wh(deptName);
		}
	}

	/**
	 * 构造查询条件dtos
	 * 
	 * @param reqDtos
	 * @param srvdto
	 * @param id_dept
	 */
	private void constructConditions(List<GetStockReqDTO> reqDtos, CiEmsSrvDTO srvdto, String id_dept) {
		GetStockReqDTO reqDTO = new GetStockReqDTO();
		reqDTO.setId_mm(srvdto.getId_mm());// 物品id
		reqDTO.setId_dep(id_dept);// 物资科室(库房)
		reqDTO.setReq_unit_id(srvdto.getId_unit_sale());// 零售单位
		reqDtos.add(reqDTO);
	}

	/**
	 * 查询药房
	 * 
	 * @param reqDtos
	 * @throws BizException
	 */
	private MaterialStockDTO selectWhDept(List<GetStockReqDTO> reqDtos) throws BizException {
		if (reqDtos == null || reqDtos.size() <= 0) {
			return null;
		}
		IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
		MaterialStockDTO[] stockdto = null;
		try {
			stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
		} catch (Exception e) {
			;
		}
		if (stockdto != null) {
			for (MaterialStockDTO materialDo : stockdto) {
				FDouble mmcount = materialDo.getQuan_usable();
				if (materialDo.getMmstatus() != MaterialStatus.NORELATION
						&& materialDo.getMmstatus() != MaterialStatus.STOP && mmcount != null
						&& (mmcount.compareTo(new FDouble(0)) != 0)) {
					return materialDo;// 只要有一个满足条件就返回
				}
			}
		}
		return null;
	}

	/**
	 * 判断FDouble类型数据是否为空
	 * 
	 * @param doubleData
	 *            待判断的数据
	 * @return true doubleData为空，否则不为空
	 */
	private boolean isFDoubleEmpty(FDouble doubleData) {

		FDouble date1 = new FDouble(0.00000001);
		if (doubleData == null || date1.compareTo(doubleData) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取物品基本包装单位价格
	 * 
	 * @param id_mm
	 *            物品id
	 * @param id_unit_sale
	 *            物品零售单位
	 * @return
	 */
	private FDouble getMMPrice(String id_mm, String id_unit_sale, String id_dep_wh) throws BizException {
		IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
		GetStockReqDTO reqDto = new GetStockReqDTO();
		reqDto.setId_mm(id_mm);
		reqDto.setReq_unit_id(id_unit_sale);
		reqDto.setId_dep(id_dep_wh);
		GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
		reqDtoArr[0] = reqDto;
		MaterialStockDTO[] materials = service.getMaterialStocks(reqDtoArr);
		if (materials != null && materials.length > 0) {
			return materials[0].getPrice_act();
		} else {
			return null;
		}
	}

	/**
	 * 创建套内项目
	 * 
	 * @param envinfo
	 * @param ciOrTmpl
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	private FMap createCiEmsSrvSetItems(CiOrTmplDTO ciOrTmpl) throws BizException {

		FMap fmap = null;
		if (!FBoolean.TRUE.equals(ciOrTmpl.getFg_set())) {
			return fmap;
		}

		// 获取模板对应的套内项目
		MedSrvDO[] medSrvs = this.getSetMedSrvDOs(ciOrTmpl);

		return this.getSrvSetitmMap(ciOrTmpl.getId_srv(), medSrvs);
	}

	/**
	 * 获取套的map结果，
	 * 
	 * @param idSrv
	 * @param medSrvs
	 * @return
	 */
	private FMap getSrvSetitmMap(String idSrv, MedSrvDO[] medSrvs) {

		FMap fmap = new FMap();
		FArrayList ordSrvSetList = new FArrayList();
		List<MedSrvSetItemDO> setItems = srvSetItemsMap.get(idSrv);
		if (setItems != null && setItems.size() > 0) {
			for (MedSrvSetItemDO setItem : setItems) {
				OrdSrvSetDO ordSrvSet = new OrdSrvSetDO();
				ordSrvSet.setStatus(DOStatus.NEW);
				ordSrvSet.setId_srvsetdef(setItem.getId_srv()); // 服务套id
				ordSrvSet.setId_srvset(setItem.getId_srv_itm()); // 套内项目id
				ordSrvSet.setSortno(setItem.getSortno()); // 排序号
				ordSrvSet.setDes_srv(setItem.getDes()); // 套内服务项目描述
				ordSrvSet.setId_srvsetrole(setItem.getId_srvsetrole()); // 成员角色
				ordSrvSet.setSd_srvsetrole(setItem.getSd_srvsetrole()); // 成员角色编码
				ordSrvSet.setId_medu(setItem.getId_medu()); // 计量单位
				ordSrvSet.setQuan_medu(setItem.getQuan_medu()); // 数值_医疗单位
				ordSrvSet.setId_freqdef(setItem.getId_freq()); // 频次id
				// ordSrvSet.setSd_body( );

				ordSrvSetList.add(ordSrvSet);
			}
		}

		fmap.put(idSrv, ordSrvSetList);
		return fmap;
	}

	/**
	 * 获取套的套内项目服务集合
	 * 
	 * @param ciOrTmpl
	 *            模板
	 * @return 如果模板中的项目为空，返回套内项目，如果模板选择了部分套内项目，按选择的结果返回
	 * @throws BizException
	 */
	private MedSrvDO[] getSetMedSrvDOs(CiOrTmplDTO ciOrTmpl) throws BizException {

		MedSrvDO[] medSrvs = null;
		FArrayList ortmplsrvs = ciOrTmpl.getOrtmplsrvs();
		if (OrSourceFromEnum.IIHCLINICALKITHELPER == ciOrTmpl.getEu_orsrcmdtp()
				&& FBoolean.TRUE.equals(ciOrTmpl.getFg_set())) {// 来源组套

			String whereStr = "id_srv in (select srvset.id_srv_itm from bd_srvset_def srvset where srvset.id_srv ='"
					+ ciOrTmpl.getId_srv() + "')";
			medSrvs = imedsrvMDORService.find(whereStr, null, FBoolean.FALSE);
		} else {
			List<String> idSrvList = new ArrayList<String>();
			for (Object obj : ortmplsrvs) {
				CiOrTmplSrvDTO setItem = (CiOrTmplSrvDTO) obj;
				idSrvList.add(setItem.getId_srv());
			}

			medSrvs = imedsrvMDORService.findByIds(idSrvList.toArray(new String[0]), FBoolean.FALSE);
		}

		return medSrvs;
	}

	/**
	 * 设置CiEmsSrvDTO 频次、用法、用法要求、煎法、煎法要求
	 * 
	 * @param ciEmsDTO
	 * @param tmplSrvDTO
	 *            CiEmsDTO ciEmsDTO
	 * @throws BizException
	 */
	private void setCiEmsSrvUseDetail(CiEmsSrvDTO srvdto, MedSrvDO medSrvDO) throws BizException {

		// 频次
		if (StringUtils.isBlank(srvdto.getId_freq())) {
			throw new BizException("频次不能为空！");
		}

		FreqDefDO freqDef = ifreqdefMDORService.findById(srvdto.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}
		srvdto.setId_freq(freqDef.getId_freq());
		srvdto.setName_freq(freqDef.getName());// 医嘱频次名称
		srvdto.setFg_interval(freqDef.getFg_interval());// 频次是否为间隔类型
		srvdto.setFreqct(freqDef.getFreqct()); // 频次周期下次数
		srvdto.setSd_frequnitct(freqDef.getSd_frequnitct()); // 频次周期编码
		srvdto.setFrequnitct(freqDef.getFreqct());// TODO 频次周期数，使用混淆

		// 设置用法id、名称
		if (StringUtils.isNotBlank(srvdto.getId_route())) {

			// MedUsageDO medUsage =
			// imedusageRService.findById(srvdto.getId_route()); // 用法
			DAFacade dafa = new DAFacade();
			String sql = "select name from bd_route where id_route='" + srvdto.getId_route() + "'";
			MedUsageDO medUsage = (MedUsageDO) dafa.execQuery(sql, new BeanHandler(MedUsageDO.class));
			if (medUsage == null) {
				throw new BizException("获取用法SD失败！");
			}
			srvdto.setName_route(medUsage.getName());// 用法名称
		} else {
			srvdto.setId_route(medSrvDO.getId_route());// 用法
			srvdto.setName_route(medSrvDO.getRoute_name());// 用法名称
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isNotBlank(srvdto.getId_routedes())) {
			srvdto.setName_routedes(this.getName_routes(srvdto.getId_routedes()));
		} else {
			srvdto.setId_routedes(medSrvDO.getId_routedes());
			srvdto.setName_routedes(medSrvDO.getRoutedes_name());
		}

		// 设置煎法id、名称
		if (StringUtils.isNotBlank(srvdto.getId_boil())) {
			CHerbBoilMdDO cHerbBoilMd = icherbboilmdMDORService.findById(srvdto.getId_boil());
			if (cHerbBoilMd == null) {
				throw new BizException("获取煎法SD失败！");
			}
			srvdto.setName_boil(cHerbBoilMd.getName());
		} else {
			srvdto.setId_boil(medSrvDO.getId_boil());
			srvdto.setName_boil(medSrvDO.getBoil_name());
		}

		// 煎法要求
		if (StringUtils.isNotEmpty(srvdto.getId_boildes())) {
			CHerbBoilDesDO cherbBoilDes = icHerbBoilDesDORService.findById(srvdto.getId_boildes());
			if (cherbBoilDes == null) {
				throw new BizException("获取煎法要求SD失败！");
			}
			srvdto.setName_boildes(cherbBoilDes.getName());
		} else {
			srvdto.setId_boildes(medSrvDO.getId_boildes());
			srvdto.setName_boildes(medSrvDO.getBoildes_name());
		}
	}

	/**
	 * 医疗单匹配
	 * 
	 * @param envinfo
	 * @param medSrvDO
	 * @return
	 * @throws BizException
	 */
	public static SrvMatchEmsRstDTO getFuncClassStr(CiEnContextDTO envinfo, MedSrvDO medSrv) throws BizException {

		return getFuncClassStr(envinfo, medSrv.getId_srv(), medSrv.getSd_srvtp());
	}

	/**
	 * 医疗单的匹配
	 * 
	 * @return
	 */
	public static SrvMatchEmsRstDTO getFuncClassStr(CiEnContextDTO envinfo, String id_srv, String sd_srvtp)
			throws BizException {

		SrvMatchEmsParamDTO paramDto = new SrvMatchEmsParamDTO();
		paramDto.setId_org(envinfo.getId_org());
		paramDto.setId_grp(envinfo.getId_grp());
		paramDto.setId_dept(envinfo.getId_dep_or());
		paramDto.setId_emp(envinfo.getId_emp_or());
		paramDto.setCode_entp(envinfo.getCode_entp());
		paramDto.setSd_srvtp(sd_srvtp);
		paramDto.setId_srv(id_srv);
		paramDto.setDt_or(CiOrdAppUtils.getServerDateTime());// 系统时间
		paramDto.setEmsappmode(envinfo.getEmsappmode());// 智慧版

		FMap map = CiOrdAppUtils.getIEmsManagementService().medSrvMatchEms(new SrvMatchEmsParamDTO[] { paramDto });
		return (SrvMatchEmsRstDTO) map.get(id_srv);
	}

	/**
	 * 执行科室
	 * 
	 * @param envinfo
	 *            就诊环境
	 * @param medsrvDO
	 *            当前服务
	 * @param defaultMpDeptId
	 *            默认的执行科室id
	 * @return
	 * @throws BizException
	 */
	private OrWfDeptInfoDTO getMpDeptID(CiEnContextDTO envinfo, MedSrvDO medsrvDO, String defaultMpDeptId, String id_mm,
			CiEmsDTO ciEmsDTO) throws BizException {

		OrWfExDeptParamDTO paramdto = new OrWfExDeptParamDTO();
		paramdto.setId_mm(id_mm); // 服务选取的关联物品
		if (medsrvDO.getFg_mm().booleanValue()) {
			String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + "." + MeterialDO.ID_SRV + " = '" + medsrvDO.getId_srv()
					+ "'";
			MeterialDO[] meteralDO = CiOrdAppUtils.getMaterialQryService().find(whereStr, MeterialDO.ID_SRV,
					FBoolean.FALSE);
			if (meteralDO != null && meteralDO.length > 0) {
				for (MeterialDO meterial : meteralDO) {
					if (meterial.getId_mm() != null && meterial.getId_mm().equals(id_mm)) {
						paramdto.setSd_herbpreparationtp(meterial.getSd_herbpreparationtp());// 草药制剂类型
					}
				}
				// 查询服务的剂型和毒麻属性
				IMedSrvDrugDORService drugService = ServiceFinder.find(IMedSrvDrugDORService.class);
				MedSrvDrugDO[] medSrvDrugs = drugService.findByAttrValString(MedSrvDrugDO.ID_SRV, medsrvDO.getId_srv());
				if (medSrvDrugs != null && medSrvDrugs.length > 0) {
					paramdto.setId_dosage(medSrvDrugs[0].getId_dosage());
					paramdto.setSd_pois(medSrvDrugs[0].getSd_pois());
				}
			}

		}
		// dto.Innercode_srvca = "";//服务分类内码
		paramdto.setEu_wftp(0); // 0执行与物资 1执行科室 2物资流向
		paramdto.setCode_entp(envinfo.getCode_entp()); // 就诊类型
		paramdto.setId_dept_ns(envinfo.getId_dep_ns()); // 就诊护理病区
		paramdto.setId_dept_or(envinfo.getId_dep_or());// 开单科室
		paramdto.setId_dept_en(envinfo.getId_dep_en()); // id_dept_en;//就诊科室
		// dto.Recurstr = ""; //长临需要的 不知道 就为空
		paramdto.setId_srv(medsrvDO.getId_srv()); // 服务
		paramdto.setSd_srvtp(medsrvDO.getSd_srvtp()); // 服务类型sd
		paramdto.setId_srvca(medsrvDO.getId_srvca());// 服务分类
		if (envinfo.getFg_pres_outp() != null) {
			paramdto.setFg_pres_outp(envinfo.getFg_pres_outp());
		}
		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
		Date date = new Date();
		paramdto.setTimestr(new FTime(date));
		if (ciEmsDTO.getFg_long() == null) {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.NULL));
		} else if (ciEmsDTO.getFg_long().booleanValue()) {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.LONG));
		} else {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.TEMP));
		}
		paramdto.setId_usage(ciEmsDTO.getId_route());

		paramdto.setFg_pres_outp(FBoolean.FALSE);
		if(envinfo.getFg_pres_outp()!=null&&envinfo.getFg_pres_outp().booleanValue()) {
			paramdto.setFg_pres_outp(FBoolean.TRUE);
		}
		// paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW); //只求执行科室
		// 执行科室（新的）
		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
		OrWfDeptInfoDTO orWfDeptInfo = service.getExeDepts4CiOrSrvN(paramdto);

		// 执行科室集合
		FArrayList orwfexedeptList = orWfDeptInfo.getOrwfexedepts();

		// 如果传入的参数包含默认的执行科室，并且返回的执行科室列表包含默认执行科室id，将默认执行科室设置为第一执行科室
		if (orwfexedeptList != null && orwfexedeptList.size() > 0 && StringUtils.isNotBlank(defaultMpDeptId)) {

			for (Object orWfExDeptObj : orwfexedeptList) {

				OrWfExDeptDTO orWfExDept = (OrWfExDeptDTO) orWfExDeptObj;
				// 设置默认执行科室为第一执行科室
				if (orWfExDept.getId_dept().equals(defaultMpDeptId)) {

					orWfDeptInfo.setFirstid_mp_dept(defaultMpDeptId);
					orWfDeptInfo.setFirstname_mp_dept(orWfExDept.getName_dept());
				}
			}

		}

		return orWfDeptInfo;
	}

	/**
	 * 一次性查询bd_srv 数据
	 * 
	 * @param ciOrtmplAggDTO
	 * @return
	 * @throws BizException
	 */
	private Map<String, MedSrvDO> OptimizationMedSrvDO(CiOrTmplDTO[] ciOrtmplAggDTO) throws BizException {
		MedSrvDO[] medsrvDo = null;
		if (ciOrtmplAggDTO != null && ciOrtmplAggDTO.length > 0) {
			List<String> list = new ArrayList<String>();
			for (CiOrTmplDTO ciOrtmplDTO : ciOrtmplAggDTO) {
				if (ciOrtmplDTO.getId_srv() == null || ciOrtmplDTO.getId_srv() == "")
					continue;
				list.add(ciOrtmplDTO.getId_srv());
				FArrayList Ortmplsrvs = ciOrtmplDTO.getOrtmplsrvs();
				if (!CiOrdUtils.isEmpty(Ortmplsrvs)) {
					for (Object obj : Ortmplsrvs) {
						CiOrTmplSrvDTO setItem = (CiOrTmplSrvDTO) obj;
						list.add(setItem.getId_srv());
					}
				}
			}
			if (list != null && list.size() > 0) {
				String[] id_srv = list.toArray(new String[0]);
				medsrvDo = findByIds(id_srv, FBoolean.FALSE);
			}
		}
		return medSrvDOMap(medsrvDo);
	}

	/**
	 * 查询bd_srv
	 * 
	 * @param Id_srv
	 * @param IsLazy
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] findByIds(String[] Id_srv, FBoolean IsLazy) throws BizException {
		return imedsrvMDORService.findByIds(Id_srv, IsLazy);
	}

	/**
	 * MedsrvDO[] 转换成 map
	 * 
	 * @param medsrvDo
	 * @return
	 */
	private Map<String, MedSrvDO> medSrvDOMap(MedSrvDO[] medsrvDo) {
		Map<String, MedSrvDO> map = new HashMap<String, MedSrvDO>();
		if (medsrvDo == null)
			return null;
		for (MedSrvDO medsrvDO : medsrvDo) {
			map.put(medsrvDO.getId_srv(), medsrvDO);
		}
		return map;
	}

	/**
	 * CiEmsDTO执行属性映射后的设置
	 * 
	 * @param ctx
	 *            当前就诊环境
	 * @param ciEms
	 *            CiEmsDTO对象
	 * @throws BizException
	 */
	private void afterFieldMapping(CiEnContextDTO ctx, CiEmsDTO ciEms) throws BizException {

		MedSrvDO medSrv = bdSrvMap.get(ciEms.getId_srv());

		FArrayList emSrvList = ciEms.getEmssrvs();
		CiEmsSrvDTO firstCiEmsSrv = (CiEmsSrvDTO) emSrvList.get(0);

		// 如果医嘱模板配置的科室在执行流向里，取模板配置的科室
		OrWfDeptInfoDTO orWfDeptInfo = null;
		orWfDeptInfo = getMpDeptID(ctx, medSrv, firstCiEmsSrv.getId_dep(), firstCiEmsSrv.getId_mm(), ciEms);
		if (null != orWfDeptInfo) {
			if (ciEms.getId_dep_mp() != null) {
				Boolean flag = false;
				for (Object d : orWfDeptInfo.getOrwfexedepts()) {
					OrWfExDeptDTO dp = (OrWfExDeptDTO) d;
					if (ciEms.getId_dep_mp().equals(dp.getId_dept())) {
						ciEms.setName_dep_mp(dp.getName_dept());
						flag = true;
						break;
					}

				}
				if (!flag) {
					ciEms.setId_dep_mp(orWfDeptInfo.getFirstid_mp_dept());
					ciEms.setName_dep_mp(orWfDeptInfo.getFirstname_mp_dept());
				}
			} else {
				ciEms.setId_dep_mp(orWfDeptInfo.getFirstid_mp_dept());
				ciEms.setName_dep_mp(orWfDeptInfo.getFirstname_mp_dept());
			}

		}

		// 根据检查属性中的是否床边执行属性设置床旁执行属性
		MedSrvRisDO medSrvRis = srvRisMap.get(ciEms.getId_srv());
		if (medSrvRis != null && FBoolean.TRUE.equals(medSrvRis.getIf_mp_bed())) {
			ciEms.setFg_mp_bed(FBoolean.TRUE);
		} else {
			ciEms.setFg_mp_bed(FBoolean.FALSE);
		}

		// 设置服务项目中的执行科室
		for (Object obj : emSrvList) {

			CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) obj;
			ciEmsSrv.setId_dep(ciEms.getId_dep_mp());
			ciEmsSrv.setName_dep(ciEms.getName_dep_mp());
			// 设置高危用药标识
			MedSrvDrugDO[] medSrvDrugDOs = ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, ciEmsSrv.getId_srv());
			if (!ObjectUtils.isEmpty(medSrvDrugDOs)) {
				ciEmsSrv.setFg_highrisk(medSrvDrugDOs[0].getFg_highrisk());				
			}
		}
	}

	/***
	 * 校验库存
	 * 
	 * @param ciEmsList
	 * @return
	 * @throws BizException
	 */
	private String emsSrvValidateCount(List<CiEmsDTO> ciEmsList) throws BizException {
		Map<String, CiEmsDTO> mapDto = new HashMap<String, CiEmsDTO>();
		Map<String, String[]> mapParams = new HashMap<String, String[]>();
		for (CiEmsDTO ems : ciEmsList) {
			FArrayList srvs = ems.getEmssrvs();
			for (Object obj : srvs) {
				CiEmsSrvDTO srvdto = (CiEmsSrvDTO) obj;
				if (FBoolean.TRUE.equals(srvdto.getFg_mm())) {
					String[] params = new String[5];
					String keyId = getKeyId(srvdto.getId_mm(), srvdto.getId_dep_wh(), srvdto.getId_unit_sale());
					if (!CiOrdUtils.isEmpty(keyId)) {
						mapDto.put(keyId, ems);
						mapParams.put(keyId, params);
						params[0] = srvdto.getId_mm();
						params[1] = srvdto.getId_dep_wh();
						params[2] = srvdto.getId_unit_sale();
						params[3] = srvdto.getName_srv();
						params[4] = srvdto.getQuan_cur() == null ? "0" : srvdto.getQuan_cur().toString();
					}
				}
			}
		}
		if (!mapDto.isEmpty()) {
			List<CiEmsDTO> delEmsDTOs = new ArrayList<CiEmsDTO>();
			String refusedMsg = validateDrugCount(mapParams, mapDto, delEmsDTOs);
			if (delEmsDTOs.size() > 0) {
				FMap2 errorMap = new FMap2();
				for (CiEmsDTO ciEmsDTO : delEmsDTOs) {
					errorMap.put(ciEmsDTO.getName(), ciEmsDTO);
				}
				this.moreEmsParam.setErrormap2(errorMap);
			}
			ciEmsList.removeAll(delEmsDTOs);
			return refusedMsg;
		}
		return null;
	}

	/**
	 * 拼接key关键字
	 * 
	 * @param id_mm
	 * @param id_dep_wh
	 * @param id_unit_sale
	 * @return
	 */
	private String getKeyId(String id_mm, String id_dep_wh, String id_unit_sale) {
		return (id_mm == null ? "" : id_mm) + (id_dep_wh == null ? "" : id_dep_wh)
				+ (id_unit_sale == null ? "" : id_unit_sale);
	}

	/**
	 * 医嘱模板保存校验库存
	 * 
	 * @param paramsMap
	 * @param mapEmsDto
	 * @param delEmsDTOs
	 * @return
	 * @throws BizException
	 */
	public String validateDrugCount(Map<String, String[]> paramsMap, Map<String, CiEmsDTO> mapEmsDto,
			List<CiEmsDTO> delEmsDTOs) throws BizException {
		String nocount = "";// 无库存
		String stopSale = "";// 停发
		String noDrug = "";// 无此药
		List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();
		for (Map.Entry<String, String[]> map : paramsMap.entrySet()) {
			GetStockReqDTO reqDTO = new GetStockReqDTO();
			reqDTO.setId_mm(map.getValue()[0]);
			reqDTO.setId_dep(map.getValue()[1]);
			reqDTO.setReq_unit_id(map.getValue()[2]);
			reqDtos.add(reqDTO);
		}
		if (reqDtos.size() > 0) {
			IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
			MaterialStockDTO[] stockdto = null;
			stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
			if (stockdto != null) {
				String mmcounterror = "";
				for (MaterialStockDTO materialDo : stockdto) {
					String key = this.getKeyId(materialDo.getId_mm(), materialDo.getId_dep(),
							materialDo.getReq_unit_id());
					String[] param = paramsMap.get(key);
					FDouble mmcount = materialDo.getQuan_usable();
					// 药房无此药的移除
					if (materialDo.getMmstatus() == MaterialStatus.NORELATION) {
						noDrug += param[3] + ",";
						if (mapEmsDto.containsKey(key)) {
							delEmsDTOs.add(mapEmsDto.get(key));
						}
					} else if (materialDo.getMmstatus() == MaterialStatus.STOP) {
						stopSale += param[3] + ",";
						if (mapEmsDto.containsKey(key)) {
							delEmsDTOs.add(mapEmsDto.get(key));
						}
					} else if (mmcount.compareTo(new FDouble(param[4])) < 0) {
						nocount += param[3] + ",";
						if (mapEmsDto.containsKey(key)) {
							delEmsDTOs.add(mapEmsDto.get(key));
						}
					}
				}
				if (!CiOrdUtils.isEmpty(noDrug) && !mmcounterror.contains(noDrug)) {
					mmcounterror = "服务：" + noDrug.substring(0, noDrug.length() - 1) + "，药房无此药！\r\n";
				}
				if (!CiOrdUtils.isEmpty(stopSale) && !mmcounterror.contains(stopSale)) {
					mmcounterror += mmcounterror + "服务：" + stopSale.substring(0, stopSale.length() - 1) + "，已停发！\r\n";
				}
				if (!CiOrdUtils.isEmpty(nocount) && !mmcounterror.contains(nocount)) {
					mmcounterror += mmcounterror + "服务：" + nocount.substring(0, nocount.length() - 1) + "，库存不足！";
				}
				if (CiOrdUtils.isEmpty(mmcounterror))
					return null;
				return mmcounterror;
			}
		}
		return null;
	}

	private String getName_routes(String id_routdes) throws BizException {
		if (CiOrdUtils.isEmpty(id_routdes))
			return null;
		String[] idStr = id_routdes.split(",");
		MedUsageDesDO[] usageDes = imedusagedesRService.findByBIds(idStr, FBoolean.FALSE);
		if (usageDes == null) {
			throw new BizException("获取用法要求SD失败！");
		}
		String UsageDesNames = "";
		for (MedUsageDesDO usagedes : usageDes) {
			UsageDesNames += usagedes.getName() + ",";
		}
		if (UsageDesNames.length() > 0) {
			return UsageDesNames.substring(0, UsageDesNames.length() - 1);
		}
		return null;
	}

	//0186425: 【验证版】住院医嘱，既往调入、复制、医嘱模板开了抗菌药，用药目的不应复制，应该让医生自己选择
	private String validateDrugAnti(String[] mmList, List<String> mmDelList) throws BizException {
		if(mmList == null || mmList.length < 1){
			return null;
		}
		StringBuilder sqlQry = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sqlQry.append("SELECT a.id_mm,a.name,b.id_anti,b.sd_anti");
		sqlQry.append(" FROM bd_mm a inner join bd_srv_drug b on a.id_srv=b.id_srv");
		for(int i=0; i<mmList.length; i++){
			if(i == 0){
				sqlQry.append(" WHERE a.id_mm = ?");
			}else{
				sqlQry.append(" or a.id_mm = ?");
			}
			sqlParam.addParam(mmList[i]);
		}
		String err_msg = "";
		List<Map<String, Object>> sqlRst = (List<Map<String, Object>>) (new DAFacade().execQuery(sqlQry.toString(), sqlParam, new MapListHandler()));
		if (sqlRst != null && sqlRst.size() > 0) {
			for (Map<String, Object> map : sqlRst) {
				String sd_anti = map.get("sd_anti").toString();
				String name_mm = map.get("name").toString();
				if(!IBdSrvDictCodeConst.SD_ANTI_NONANTIBACTERIAL.equals(sd_anti)){
					err_msg += "," + name_mm;
					mmDelList.add(map.get("id_mm").toString());
				}
			}
		}
		//0189800: 开发版住院医生站智能助手服务分类开立草药类医嘱报错
		if(err_msg == null || "".equals(err_msg)){
			return null;
		}
		return "【"+err_msg.substring(1)+"】是抗菌药，需要选择“用药目的”，保存医嘱失败";
	}
	private String emsSrvValidateAnti(List<CiEmsDTO> ciEmsList) throws BizException {
		List<CiEmsDTO> delEmsDTOs = new ArrayList<CiEmsDTO>();
		List<String> mmList = new ArrayList<String>();
		List<String> mmDelList = new ArrayList<String>();
		for (CiEmsDTO ems : ciEmsList) {
			FArrayList srvs = ems.getEmssrvs();
			for (Object obj : srvs) {
				CiEmsSrvDTO srvdto = (CiEmsSrvDTO) obj;
				if (FBoolean.TRUE.equals(srvdto.getFg_mm())) {
					if(!mmList.contains(srvdto.getId_mm())){
						mmList.add(srvdto.getId_mm());
					}
				}
			}
		}
		if (!mmList.isEmpty()) {
			String refusedMsg = validateDrugAnti(mmList.toArray(new String[0]), mmDelList);
			if (StringUtils.isNotEmpty(refusedMsg)) {
				FMap2 errorMap = new FMap2();
				for (CiEmsDTO ems : ciEmsList) {
					FArrayList srvs = ems.getEmssrvs();
					FBoolean isDeleted = FBoolean.FALSE;
					for (Object obj : srvs) {
						CiEmsSrvDTO srvdto = (CiEmsSrvDTO) obj;
						if (FBoolean.TRUE.equals(srvdto.getFg_mm())
								&& mmDelList.contains(srvdto.getId_mm())){
							isDeleted = FBoolean.TRUE;
							break;
						}
					}
					if(FBoolean.TRUE.equals(isDeleted)){
						delEmsDTOs.add(ems);
						errorMap.put(ems.getName(), ems);
					}
				}
				//0189800: 开发版住院医生站智能助手服务分类开立草药类医嘱报错
				this.moreEmsParam.setErrormap2(errorMap);
				ciEmsList.removeAll(delEmsDTOs);
				return refusedMsg;
			}
		}
		return null;
	}
}

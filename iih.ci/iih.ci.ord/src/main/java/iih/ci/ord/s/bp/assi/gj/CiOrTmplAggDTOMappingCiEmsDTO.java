/**
 * 
 */
package iih.ci.ord.s.bp.assi.gj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.i.ICHerbBoilDesDORService;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import iih.bd.utils.BdMmParamUtils;
import iih.bd.utils.ParamUtils;
import iih.bl.params.BlParams;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.i.ICiDiagItemDORService;
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
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
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
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.bp.validate.chain.AssembleAssiChain;
import iih.ci.ord.s.bp.validate.chain.ValidateDataDTO;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvLisInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvRisInfoCache;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
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
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

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

	// 映射初始化时CiEms不随医嘱变化的属性对象
	private InitMappingCiEmsProperty mappingProperty;
	// 商品模式
	// 1. 商品名模式时，并且服务是开立绑定，判断药品的可使用标识，执行绑定不需要判断商品相关逻辑，停用，停开，可使用标识
	// 2. 通用名模式，开立绑定不需要判断商品的可使用标识，需要判断药品停用，停开。执行绑定不需要判断商品相关逻辑，停用，停开，可使用标识
	private String drugManagementModel;
	// 1. 商品名模式时，并且服务是开立绑定，判断药品的可使用标识，执行绑定不需要判断商品相关逻辑，停用，停开，可使用标识
	// 2. 通用名模式，开立绑定不需要判断商品的可使用标识，需要判断药品停用，停开。执行绑定不需要判断商品相关逻辑，停用，停开，可使用标识
	// 通用名在查询语句中过滤物品是否可用
	// 门诊住院的可使用状态对应关系，用于过滤当前就诊环境下是否支持模板转换为医嘱
	// key 就诊类型 value 可使用标识字段名称
	private final static Map<String, String> FG_USE_MAP = new HashMap<String, String>() {
		{
			put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, "get" + MedSrvDO.FG_USE_OP); // 可使用标识_门诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_PE, "get" + MedSrvDO.FG_USE_PE); // 可使用标识_体检
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, "get" + MedSrvDO.FG_USE_IP); // 可使用标识_住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_FA, "get" + MedSrvDO.FG_USE_FM); // 可使用标识_家庭
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW,"get" + MedSrvDO.FG_USE_ER);//可使用标识_急诊流水
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID,"get" + MedSrvDO.FG_USE_ER1);//可使用标识_急诊抢救
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS,"get" + MedSrvDO.FG_USE_ER2);//可使用标识_急诊留观
		}
		
	};

	// 门诊住院的可使用状态对应关系，用于准确提示服务不可使用的场景
	// key 就诊类型 value 可使用标识字段名称
	private final static Map<String, String> FG_USE_MSG = new HashMap<String, String>() {
		{
			put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, "门诊"); // 可使用标识_门诊
			put(IBdFcDictCodeConst.SD_CODE_ENTP_PE, "体检"); // 可使用标识_体检
			put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, "住院"); // 可使用标识_住院
			put(IBdFcDictCodeConst.SD_CODE_ENTP_FA, "家庭"); // 可使用标识_家庭
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW,"急诊流水");//可使用标识_急诊流水
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID,"急诊抢救");//可使用标识_急诊抢救
			put(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS,"急诊留观");//可使用标识_急诊留观
		}
	};

	public CiOrTmplAggDTOMappingCiEmsDTO() throws BizException {
		ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
		imedusageRService = (IMedusageRService) ServiceFinder.find(IMedusageRService.class);
		imedusagedesRService = (IMedusagedesRService) ServiceFinder.find(IMedusagedesRService.class);
		icherbboilmdMDORService = (ICherbboilmdMDORService) ServiceFinder.find(ICherbboilmdMDORService.class);
		icHerbBoilDesDORService = (ICHerbBoilDesDORService) ServiceFinder.find(ICHerbBoilDesDORService.class);
		imedsrvMDORService = (IMedsrvMDORService) ServiceFinder.find(IMedsrvMDORService.class);
		srvSetItemRSercie = (IMedSrvSetItemDORService) ServiceFinder.find(IMedSrvSetItemDORService.class);
		imedSrvRisDORService = (IMedSrvRisDORService) ServiceFinder.find(IMedSrvRisDORService.class);
		icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
		drugManagementModel = BdMmParamUtils.GetDrugMCPropMM();
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
	public MoreEmsParamDTO Mapping(CiEnContextDTO envinfo, CiOrTmplDTO[] ciOrtmplAggDTO, String clinicalzztz) throws BizException {

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

		this.createSrvSetItemMap(ciOrtmplAggDTO);

		// CiEmsDTO[] ciEmsDTOS = new CiEmsDTO[ciOrtmplAggDTO.length];
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
			CiEmsDTO ciEmsDto = new CiEmsDTO();
			ciEmsDto.setStatus(DOStatus.NEW);// 设置为新建状态
			// 根据上下文环境 + 医嘱模板生成 = 医疗单CiEmsDTO数据
			String msgWarn = MappingFieldOrder(envinfo, ciEmsDto, orTmplDTO, bdSrvMap);
			if (StringUtils.isNotEmpty(msgWarn)) {
				refusedMsg.append(msgWarn).append(System.lineSeparator());
			}
			
			if(ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) { //手术
			    //补全手术信息 MedSrvOpDO bd_srv_sug 表中
				replenishSug(ciEmsDto);
			}
			
			// 补充对CiEms,CiEmsSrv的属性赋值
			afterFieldMapping(envinfo, ciEmsDto);

			// 医嘱项目

			
			ciEmsList.add(ciEmsDto);
			// ciEmsDTOS[i] = ciEmsDto;
		}

		// 将CiEmsDTO集合转换为 MoreEmsParamDTO对象
		MoreEmsParamDTO moreEmsParam = new MoreEmsParamDTO();
		if (ciEmsList.size() > 0) {
			CovertTmplToMoreEmsParamBP bp = new CovertTmplToMoreEmsParamBP();
			moreEmsParam = bp.exec(envinfo, ciEmsList.toArray(new CiEmsDTO[0]), clinicalzztz);
		}
		if(!StringUtils.isEmpty(refusedMsg.toString())){
			String errroInfo = refusedMsg.toString();
			if(!StringUtils.isEmpty(moreEmsParam.getErrorinfo())){
				errroInfo += moreEmsParam.getErrorinfo();
			}
			moreEmsParam.setErrorinfo(errroInfo);
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
		if (ciOrTmplDTO.getSd_srvtp() != null && ciOrTmplDTO.getSd_srvtp().startsWith("01")) {
			// 获取服务项目
			FArrayList ciOrTmplSrvs = ciOrTmplDTO.getOrtmplsrvs();
			CiOrTmplSrvDTO tmplSrvDTO = (CiOrTmplSrvDTO) ciOrTmplSrvs.get(0); // 取第0个作为主服务
			//紧急补丁  0187822: 门急诊医生站升级到20200315版本，医嘱模板开立药品有提示信息 
			if(StringUtils.isEmpty(tmplSrvDTO.getId_unit_sale())){
				return "";
			}
		 	//该医嘱下 所有物品单位
			MaterialUnitDTO[] materialUnitDTOs=BDMmDoseUnitInfoCache.getMaterialUnitInfos(envinfo.getCode_entp(),tmplSrvDTO.getId_mm().split(CiOrdUtils.COMMA_STR));
			if(CiOrdUtils.isEmpty(materialUnitDTOs)) {//没有获取到包装单位
				return null;
			}
			boolean flag=false;
			for(MaterialUnitDTO dto:materialUnitDTOs) {
				//判断该药品的所有物品单位中是否包含模板的总量单位
				if (dto.getId_measdoc()!=null&&tmplSrvDTO.getId_unit_sale()!=null&&tmplSrvDTO.getId_unit_sale().equals(dto.getId_measdoc())) {
					flag = true;
				}
				
			}
			//获取门诊总量编辑模式
			String paramString="";
			paramString = getDealWithUnitParam(paramString);
			if ("1".equals(paramString)) {//可编辑
				
				if (!flag) {
				
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
					if(!ciOrTmplDTO.getSd_srvtp().startsWith("0103")){
						return ciOrTmplDTO.getName()+"的药品单位已修改，请在医疗单中维护总量 或者去门诊医嘱模板节点维护该药品的总量";
					}else{
						return "";
					}
				}
			}else{//不可编辑
				if (!flag) {//重新计算总量值
						
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
				}
				
			}
			
		}

			return null;
		
	}

	/**
	 * 获取处理单位的参数
	 * @param paramString
	 * @return
	 * @throws BizException
	 */
	private String getDealWithUnitParam(String paramString)throws BizException{
		try {
			paramString=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0210");//【门诊总量编辑控制模式】
		} catch (Exception e) {
			paramString="0";//不可编辑
		}
		return paramString;
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

			if ( !FBoolean.TRUE.equals(medSrv.getFg_or())) {
				return "服务【" + medSrv.getName() + "】为非临床项目";
			}
			if (medSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_A)) {
				return "服务【" + medSrv.getName() + "】不支持通过助手开立医嘱";
			}
			// try {

			// 获取可使用标识的get方法并执行
			/*
			 * Class<? extends MedSrvDO> cls = medSrv.getClass(); Method
			 * getMethod = cls.getDeclaredMethod(FG_USE_MAP.get(codeEntp));
			 */
			Object fgUse = "";// getMethod.invoke(medSrv);
			// medSrv.getFg_use_op()
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(codeEntp)) {
				fgUse = medSrv.getFg_use_op();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(codeEntp)) {
				fgUse = medSrv.getFg_use_er();
			}  else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(codeEntp)) {
				fgUse = medSrv.getFg_use_er1();
			}  else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(codeEntp)) {
				fgUse = medSrv.getFg_use_er2();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(codeEntp)) {
				fgUse = medSrv.getFg_use_ip();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(codeEntp)) {
				fgUse = medSrv.getFg_use_fm();
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(codeEntp)) {
				fgUse = medSrv.getFg_use_pe();
			}

			if (fgUse == null || !FBoolean.TRUE.equals(FBoolean.valueOf(fgUse.toString()))) {
				return FG_USE_MSG.get(codeEntp) + "中服务【" + medSrv.getName() + "】不可使用";
			}

			/*
			 * } catch (IllegalAccessException | InvocationTargetException |
			 * NoSuchMethodException e) {
			 * 
			 * throw new BizException("医嘱模板映射获取获取可使用标识失败"); }
			 */
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

			if(idSetSrvBuffer!=null &&idSetSrvBuffer.length()>0) {
				// 查询检查属性
				String whereStrRis = "id_srv in (" + idSetSrvBuffer.substring(1) + ")";
				MedSrvRisDO[] medSrvRises = imedSrvRisDORService.find(whereStrRis, null, FBoolean.FALSE);
				for (MedSrvRisDO medSrvRis : medSrvRises) {
					srvRisMap.put(medSrvRis.getId_srv(), medSrvRis);
				}
			}
		}
	}

	/**
	 * 医嘱模板的映射(普通药品医疗单)
	 * 
	 * @param envinfo
	 * @param ciEmsDto
	 * @param aggDto
	 * @throws BizException
	 */
	private String MappingFieldOrder(CiEnContextDTO envinfo, CiEmsDTO ciEmsDto, CiOrTmplDTO ciOrTmplDTO,
			Map<String, MedSrvDO> bdSrvMap) throws BizException {
		StringBuilder msgWarn = new StringBuilder();
		// 对应的 bd_srv，传递数据为医嘱模板时
		ciEmsDto.setId_srv(ciOrTmplDTO.getId_srv());
		// 优化 一次查询
		// MedSrvDO medSrvDO =
		// imedsrvMDORService.findById(ciEmsDto.getId_srv());
		MedSrvDO medSrvDO = null;
		if (bdSrvMap != null) {
			medSrvDO = bdSrvMap.get(ciEmsDto.getId_srv());
		}
		if (medSrvDO == null) {
			OrdBizLogger.info(envinfo, "标准模板转CiEmsDTO时根据id_srv[" + ciEmsDto.getId_srv() + "]未获取到服务项目");
			throw new BizException("标准模板转CiEmsDTO时根据id_srv[" + ciEmsDto.getId_srv() + "]未获取到服务项目");
		}

		ValidateDataDTO param = new ValidateDataDTO();
		param.setMedSrv(medSrvDO);
		List<String> msgList = AssembleAssiChain.startValidate(envinfo, param);
		if (msgList.size() > 0) {
			throw new BizException(MessageConvertUtil.convertListToString(msgList));
		}
		// ciEmsDto.setNote(ciOrTmplDTO.getDes_or());//医嘱描述
		ciEmsDto.setId_pat(envinfo.getId_pat());// 患者
		ciEmsDto.setId_en(envinfo.getId_en());// 就诊
		ciEmsDto.setId_entp(envinfo.getId_entp());// 就诊类型
		ciEmsDto.setCode_entp(envinfo.getCode_entp());// 就诊类型编码
		ciEmsDto.setId_srvtp(medSrvDO.getId_srvtp());// 医嘱类型
		ciEmsDto.setSd_srvtp(medSrvDO.getSd_srvtp());// 医嘱类型编码
		ciEmsDto.setId_wg_or(envinfo.getId_wg_or());
		ciEmsDto.setId_freq(ciOrTmplDTO.getId_freq());// 频次id
		ciEmsDto.setId_excessive_reason(ciOrTmplDTO.getId_excessive_reason());
		ciEmsDto.setSd_excessive_reason(ciOrTmplDTO.getSd_excessive_reason());
		// 套服务是否包含套内项目，组套中的套都不包含套内项目
		CiOrTmplSrvDTO tmplSrvDTO = null;
		if (OrSourceFromEnum.IIHCLINICALKITHELPER != ciOrTmplDTO.getEu_orsrcmdtp()) {// 不是来源组套
			// 获取服务项目
			FArrayList ciOrTmplSrvs = ciOrTmplDTO.getOrtmplsrvs();
			tmplSrvDTO = (CiOrTmplSrvDTO) ciOrTmplSrvs.get(0); // 取第0个作为主服务
			// 将模板中的用法、煎法 赋值到CiEmsDTO中
			ciEmsDto.setId_route(tmplSrvDTO.getId_route());// 用法id
			ciEmsDto.setId_routedes(tmplSrvDTO.getId_routedes());// 用法要求
			ciEmsDto.setId_boil(tmplSrvDTO.getId_boil());// 设置煎法id
			ciEmsDto.setId_boildes(tmplSrvDTO.getId_boildes());// 煎法要求id
			ciEmsDto.setId_dep_mp(tmplSrvDTO.getId_dep_mp());

		}
		if (envinfo != null && (IBdFcDictCodeConst.SD_CODE_ENTP_IP).equals(envinfo.getCode_entp())) {
			ciEmsDto.setDays_or(null);// 医嘱天数
		} else {
			ciEmsDto.setDays_or(ciOrTmplDTO.getDays_or());// 医嘱天数
		}
		
		// 0161344: 急诊科开的检验项目，默认勾上加急标志 参数 XH_CIOR0001
		// 急诊科室判断方式 1、当参数【是否急诊就诊判断方式】= 1 and 当前登录科室 in 【是否急诊就诊科室】参数值 and
		// 【急诊科开的检验项目，默认勾上加急标志】 = TRUE 时，门诊医生站开检验医嘱，默认勾选加急标志。
		try {
			// 【是否急诊就诊判断方式】
			Integer judge_urgent = ParamUtils.getOrgParamIntegerValue(ICiOrdCustomSysParamConst.LL_JUDGE_URGENT);
			// 【是否急诊就诊科室】
			String is_urgent = ParamUtils.getOrgParamStringValue(ICiOrdCustomSysParamConst.LL_IS_URGENT);
			// 【急诊科开的检验项目，默认勾上加急标志】
			FBoolean lis_fg_urgent = ParamUtils.getOrgParamFBooleanValue(ICiOrdCustomSysParamConst.XH_LIS_FG_URGENT);
			// 当前科室是否急诊科室
			FBoolean isUrgentDep = FBoolean.FALSE;
			if (FBoolean.TRUE.equals(lis_fg_urgent) && judge_urgent == 1
					&& is_urgent.contains(envinfo.getId_dep_or())) {
				isUrgentDep = FBoolean.TRUE;
			}
			if (FBoolean.TRUE.equals(lis_fg_urgent) && FBoolean.TRUE.equals(isUrgentDep) && ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
				ciEmsDto.setFg_urgent(FBoolean.TRUE);
			} else {
				// 医嘱模板开立的服务，如果加急项目维护中默认加急则赋值为Y,liyuelong
				if(!CiOrdUtils.isEmpty(ciOrTmplDTO.getId_srv())&&!CiOrdUtils.isEmpty(envinfo.getCode_entp())&&FBoolean.TRUE.equals(CiOrdUtils.getFgUrgent(ciOrTmplDTO.getId_srv(), envinfo.getCode_entp()))){
					ciEmsDto.setFg_urgent(FBoolean.TRUE);
				}else{
				ciEmsDto.setFg_urgent(FBoolean.FALSE);
				}
			}

		} catch (Exception e) {
			ciEmsDto.setFg_urgent(FBoolean.FALSE);
		}
		
		// 慢病标识
		if (ICiDoctorStationTypeConst.Type_Op_MbDoctor_Station.equals(envinfo.getStationType())) {
			ciEmsDto.setId_excessive_reason(ICiDictCodeConst.ID_EXCESSIVE_REASON_CHRONIC);
			ciEmsDto.setSd_excessive_reason(ICiDictCodeConst.SD_EXCESSIVE_REASON_CHRONIC);
		}
		FMap2 m1=envinfo.getEmsopenparam();
		if(m1!=null&&m1.containsKey("Id_excessive_reason")&&m1.containsKey("Sd_excessive_reason")) {
			String Id_excessive_reason=(String)m1.get("Id_excessive_reason");
			String Sd_excessive_reason=(String)m1.get("Sd_excessive_reason");
			String Name_excessive_reason=(String)m1.get("Name_excessive_reason");
			if(Id_excessive_reason!=null&&Sd_excessive_reason!=null) {
				ciEmsDto.setId_excessive_reason(Id_excessive_reason);
				ciEmsDto.setSd_excessive_reason(Sd_excessive_reason);
				ciEmsDto.setName_excessive_reason(Name_excessive_reason);
			}
			
		}
		// 补全频次、频次下次数、用法、用法要求、煎法、煎法要求
		this.setCiEmsDTOUseDetailByMedSrv(envinfo, ciEmsDto, medSrvDO,ciOrTmplDTO);

		// 执行科室 执行完映射在设置执行科室
		// OrWfDeptInfoDTO deptMpDto = this.getMpDeptID(envinfo, medSrvDO,null);

		// ciEmsDto.setSd_orrsttp(ciOrTmplDTO.getSd_orrsttp());//医嘱结果编码
		// ciEmsDto.setId_dep_mp(deptMpDto.getFirstid_mp_dept());// 执行科室Id
		// ciEmsDto.setName_dep_mp(deptMpDto.getFirstname_mp_dept());// 执行科室名称
		// bug 0112780: [国际现场]医嘱模板开立x-ray数字化牙片剂量为空
		if (!medSrvDO.getFg_mm().booleanValue()) {
			ciEmsDto.setId_unit_med(medSrvDO.getId_unit_med());// 医学单位
			ciEmsDto.setName_unit_med(medSrvDO.getMed_name());// 医学单位名称
		}

		ciEmsDto.setId_srvca(medSrvDO.getId_srvca());// 医嘱基本分类
		ciEmsDto.setInnercode_srvca(medSrvDO.getSrvca_innercode());// 服务分类内码
		ciEmsDto.setId_grp(envinfo.getId_grp());// 所属集团
		ciEmsDto.setId_org(envinfo.getId_org());// 所属组织
		ciEmsDto.setEmsappmode(envinfo.getEmsappmode());// 医疗单应用场景
		// 总量开单方式，多频次，多剂量
		ciEmsDto.setSd_totalopenmode(medSrvDO.getSd_totalopenmode());
		ciEmsDto.setIsmulexec(medSrvDO.getIsmulexec());
		ciEmsDto.setIsmuldose(medSrvDO.getIsmuldose());

		// ciEmsDto.setName_ems(medSrvDO.getName());// 医疗单显示名称
		// 医疗单名称不是服务名，从EmsMatchRstDTO中取

		// ciEmsDto.setId_orpltp(ciOrTmplDTO.getId_orpltp());//医嘱执行闭环类型

		// ciEmsDto.setMapkeys(ciOrTmplDTO.getMapkeys());//附加信息Map键值串
		// ciEmsDto.setMapinfo(ciOrTmplDTO.getMapinfo());//相关附加信息MAP
		// ciEmsDto.setFg_syncfee(ciOrTmplDTO.getFg_syncfee());//费用同步标识
		// ciEmsDto.setFreqct(ciOrTmplDTO.getFreqct());//频次下次数
		// ciEmsDto.setFrequnitct(ciOrTmplDTO.getFrequnitct());//频次周期数
		// ciEmsDto.setSd_frequnitct(ciOrTmplDTO.getSd_frequnitct());//频次周期类型编码
		// ciEmsDto.setSrvsetitms(ciOrTmplDTO.getSrvsetitms());//套对应的套内项目集合

		// ciEmsDto.setOrapplysheet(ciOrTmplDTO.getOrapplysheet());//医嘱对应的申请单

		ciEmsDto.setId_dept_en(envinfo.getId_dep_en());// 就诊科室
		ciEmsDto.setId_dept_ns(envinfo.getId_dep_ns());// 护理单元
		ciEmsDto.setFg_set(medSrvDO.getFg_set());// 是否是套
		ciEmsDto.setDes_or(ciOrTmplDTO.getDes_or());// 嘱托

		// ciEmsDto.setCiorfreqtimes(ciOrTmplDTO.getCiorfreqtimes());//医嘱计划频次执行时刻集合
		ciEmsDto.setFg_pres_outp(FBoolean.FALSE);// 出院带药标识

		// 门诊不使用后台匹配医疗单
		SrvMatchEmsRstDTO emsmatch = getFuncClassStr(envinfo, medSrvDO);
		if (emsmatch == null) {
			ciEmsDto.setEmstype(EmsType.COMMON);
			ciEmsDto.setFg_quickwflow(FBoolean.FALSE);
			// throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 配不到医疗单
			// ");
		} else {
			ciEmsDto.setFuncclassstr(emsmatch.getFuncclassstr());// 医疗单URL
			ciEmsDto.setId_srvof(emsmatch.getId_ems());// 医疗单
			ciEmsDto.setName_ems(emsmatch.getName_show());// 医疗单名称
			ciEmsDto.setFg_quickwflow(emsmatch.getFg_quickwflow());
			// emsType已经废弃不用了
			// try {
			// ciEmsDto.setEmstype(Integer.parseInt(CiOrdUtils.getEmsFunclassKVDTO(emsmatch.getFuncclassstr()).getEmstype()));//医疗单类型
			// } catch (Exception ex) {
			// OrdBizLogger.info(envinfo,"医疗服务 ：" + medSrvDO.getName() + "
			// 找不到医疗单类型 ");
			// throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 找不到医疗单类型
			// ");
			// }
		}
		if (!"0902".equals(medSrvDO.getSd_srvtp())) {
		ciEmsDto.setApplyno(CiOrdUtils.getApplyNo(medSrvDO.getSd_srvtp()));// 申请单号
		}
		// ciEmsDto.setFg_urgent(ciOrTmplDTO.getFg_urgent());//加急标识

		// ciEmsDto.setId_orrsttp(ciOrTmplDTO.getId_orrsttp());//医嘱结果
		// ciEmsDto.setId_or(ciOrTmplDTO.getId_or());//医嘱主键标识

		// ciEmsDto.setId_srv_pkg(ciOrTmplDTO.getId_srv_pkg());//服务包
		if (!envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)) { // 住院的常临标识通过
																					// setCiEmsDTOUseDetailByMedSrv
																					// 中频次定义设置，门诊的都设置false
			if (ciEmsDto.getFg_long() == null) {
				ciEmsDto.setFg_long(FBoolean.FALSE);// 长临标识
			}

		}

		// ciEmsDto.setEmstype(JudgeEmsType(medSrvDO.getSd_srvtp()));//
		// 医疗单类型(药品)
		ciEmsDto.setFg_boil(ciOrTmplDTO.getFg_boil());// 代煎标识

		ciEmsDto.setOrders(ciOrTmplDTO.getOrders());// 医嘱付数
		ciEmsDto.setOrders_boil(ciOrTmplDTO.getOrders());// 代煎付数
		ciEmsDto.setCode(ciOrTmplDTO.getCode());// 编码
		if (StringUtils.isBlank(ciEmsDto.getCode())) {
			ciEmsDto.setCode(medSrvDO.getCode());// 编码
		}
		ciEmsDto.setName(ciOrTmplDTO.getName());// 医嘱名称
		if (StringUtils.isBlank(ciEmsDto.getName())) {
			ciEmsDto.setName(medSrvDO.getName());
		}
		// ciEmsDto.setNote(ciOrTmplDTO.getNote());//备注
		ciEmsDto.setId_emp_phy(envinfo.getId_emp_or());// 开立医生
		// ciEmsDto.setName_emp_phy(envinfo.getName_emp());//开立医生姓名
		ciEmsDto.setId_dep_phy(envinfo.getId_dep_or());// 开立科室
		// ciEmsDto.setName_dep_phy(ciOrTmplDTO.getName_dep_phy());//开立科室名称
		ciEmsDto.setId_wg_or(envinfo.getId_wg_or());// 医疗组
		if (FBoolean.TRUE.equals(medSrvDO.getFg_mm())&&!StringUtils.isEmpty(ciEmsDto.getId_freq())) {
			FDateTime tm = CalDtEffeBP.GetDtEffe(ciEmsDto.getId_freq());
			ciEmsDto.setDt_begin(tm); // SINGLE
		}else{
			ciEmsDto.setDt_begin(CiOrdAppUtils.getServerDateTime());// 开始日期,门诊模板不用格式化时间
		}
		if (!CiOrdUtils.isEmpty(ciEmsDto.getDays_or())) {
			ciEmsDto.setDt_end(new FDateTime(ciEmsDto.getDt_begin().getBeginDate().getDateAfter(ciEmsDto.getDays_or()),
					ciEmsDto.getDt_begin().getUFTime()));// 结束日期
		}
		// ciEmsDto.setDt_end(ciOrTmplDTO.getDt_end());//结束日期
		// ciEmsDto.setContent(ciOrTmplDTO.getContent());//医嘱内容
		// ciEmsDto.setDt_invalid(ciOrTmplDTO.getDt_invalid());//医嘱过期时间
		ciEmsDto.setFg_bb(envinfo.getFg_bb());// 婴儿标识
		ciEmsDto.setNo_bb(envinfo.getNo_bb());// 婴儿序号

		// ciEmsDto.setFg_pmor(ciOrTmplDTO.getFg_pmor());//备用医嘱标识
		// ciEmsDto.setDes_pmor(ciOrTmplDTO.getDes_pmor());//备用医嘱使用条件描述
		// ciEmsDto.setId_or_rel(ciOrTmplDTO.getId_or_rel());//关联医嘱
		// ciEmsDto.setFg_ctlcp(ciOrTmplDTO.getFg_ctlcp());//临床路径控制标识
		// ciEmsDto.setFg_mr(ciOrTmplDTO.getFg_mr());//医疗记录联动标识
		// ciEmsDto.setFg_skintest(ciOrTmplDTO.getFg_skintest());//需皮试标识
		// ciEmsDto.setId_skintest_skip_reaso(ciOrTmplDTO.getId_skintest_skip_reaso());//不皮试原因（废弃不用了）
		// ciEmsDto.setSd_skintest_skip_reaso(ciOrTmplDTO.getSd_skintest_skip_reaso());//不皮试原因编码（废弃不用了）
		if (FBoolean.TRUE.equals(ciEmsDto.getIsmulexec())) {
			if (ciEmsDto.getSd_totalopenmode()!=null && "0".equals(ciEmsDto.getSd_totalopenmode())) {//周期开立
				//计算总次数
				GetTotalTimesBP  bp = new GetTotalTimesBP();
				Integer totalTimes = bp.getTotalTimes(ciOrTmplDTO.getDt_effe(), ciEmsDto.getId_freq(), ciEmsDto.getDays_or());
				ciEmsDto.setTimes_cur(totalTimes);
			}else{
				ciEmsDto.setTimes_cur(ciOrTmplDTO.getTimes());
			}
		}
		
		if (CiOrdUtils.isEmpty(ciEmsDto.getTimes_cur())) {
			ciEmsDto.setTimes_cur(calTimesCurBP.exec(ciEmsDto));// 总次数
		}
		
		ciEmsDto.setFg_mp_in(mappingProperty.getFgMpIn(ciEmsDto.getCode_entp(),ciEmsDto.getSd_srvtp(),ciEmsDto.getId_route())); // 在院执行状态
		CiEmsDefaultValueSetBP defaultSetbp = new CiEmsDefaultValueSetBP();
		defaultSetbp.exec(ciEmsDto);// 设置在院执行状态
		// ciEmsDto.setFg_mp_in(FBoolean.TRUE);// 在院执行标识
		// 从助手生成的医疗单都设置在院执行，（医疗单中可以根据医生患者沟通确定是否需要在院执行）

		if (ciEmsDto.getFg_mp_in().booleanValue()) { // 在院执行时
			ciEmsDto.setTimes_mp_in(ciEmsDto.getTimes_cur());// 如果是在院执行，助手中的构造的医嘱等于总次数
			/*
			 * if (ciEmsDto.getTimes_mp_in() != null) { // TODO
			 * 上边没有设置在院执行次数的地方，这个判断没意义
			 * ciEmsDto.setTimes_mp_in(ciEmsDto.getTimes_mp_in()); } else {
			 * ciEmsDto.setTimes_mp_in(CiOrdUtils.JudgeTiemMpIn(ciEmsDto));
			 * ciEmsDto.setTimes_cur(ciEmsDto.getTimes_mp_in());// 总次数 TODO
			 * 总次数逻辑 }
			 */
		}


		// ciEmsDto.setFg_mp_bed(ciOrTmplDTO.getFg_mp_bed());//床边执行标识
		// ciEmsDto.setTimes_firday_mp(ciOrTmplDTO.getTimes_firday_mp());//首日执行次数
		// ciEmsDto.setFg_or_doc(ciOrTmplDTO.getFg_or_doc());//医生医嘱标识
		// ciEmsDto.setId_su_or(ciOrTmplDTO.getId_su_or());//医嘱状态
		// ciEmsDto.setSd_su_or(ciOrTmplDTO.getSd_su_or());//医嘱状态编码
		// ciEmsDto.setFg_active_pm(ciOrTmplDTO.getFg_active_pm());//备用医嘱启用标识
		// ciEmsDto.setId_reltp(ciOrTmplDTO.getId_reltp());//关联医嘱类型编码
		// ciEmsDto.setSd_reltp(ciOrTmplDTO.getSd_reltp());//关联医嘱类型
		ciEmsDto.setEu_orsrcmdtp(ciOrTmplDTO.getEu_orsrcmdtp()); // 数据来源类型
																	// OrSourceFromEnum
																	// 既往、组套、模板、常规、分类...
		ciEmsDto.setId_orsrc_main(ciOrTmplDTO.getId_orsrc_main());// 数据来源id
																	// ，既往id_or
																	// ,组套的定义id，模板(常规)id，
																	// 分类id
		ciEmsDto.setId_orsrc_sub(ciOrTmplDTO.getId_orsrc_sub()); // 模板（常规）明细id
		ciEmsDto.setId_orsrc_subsub(ciOrTmplDTO.getId_orsrc_subsub());// 医嘱来源孙标识
		// 存在保外诊断时，医保就诊状态调整为不需要判断医保状态（非医保状态）
		if (HpBeyondEnum.HPEXTERNALDIAG.equals(envinfo.getEu_hpbeyond())) {
			ciEmsDto.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
		}

		ciEmsDto.setBhpjudgerst(envinfo.getBhpjudgerst()); // 基本医保判断结果数据信息
		ciEmsDto.setDes_bhpjudgerst(envinfo.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述
		// 诊断赋值
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(envinfo.getId_en());
		if (diagOutlineInfo != null) {
			ciEmsDto.setId_didef(diagOutlineInfo.getId_didef());// 主诊断的主项目id
			ciEmsDto.setName_didef(diagOutlineInfo.getName_diag());// 主诊断名称
			ciEmsDto.setId_diitm(diagOutlineInfo.getId_diitm());//诊断
			FMap2 m=envinfo.getEmsopenparam();
			if(m!=null&&m.containsKey("Id_di")&&m.containsKey("Id_diitem")) {
				String id_di=(String)m.get("Id_di");
				String id_diitm=(String)m.get("Id_diitem");
				if(id_di!=null&&id_diitm!=null) {
					if(diagOutlineInfo.getId_di().equals(id_di.trim())) {
						ICiDiagItemDORService itmser=ServiceFinder.find(ICiDiagItemDORService.class);
						CiDiagItemDO itm=itmser.findById(id_diitm.trim());
						if(itm!=null) {
							if(itm.getId_didef()!=null) {
								ciEmsDto.setId_diitm(itm.getId_diitm());
								ciEmsDto.setId_didef(itm.getId_didef());// 主诊断的主项目id
								ciEmsDto.setName_didef(itm.getId_didef_name());// 主诊断名称
							}
						}
					}
				}
				
			}
			
		}
		if (OrSourceFromEnum.IIHCLINICALKITHELPER == ciOrTmplDTO.getEu_orsrcmdtp()
				&&FBoolean.TRUE.equals( ciOrTmplDTO.getFg_set())) {// 来源组套
			this.setMkrSetProperty(ciEmsDto, envinfo, ciOrTmplDTO, medSrvDO);
		} else {
			// 创建套内项目集合
			ciEmsDto.setSrvsetitms(this.createCiEmsSrvSetItems(ciOrTmplDTO));

			// 医嘱项目
			FArrayList list = this.getEmssrvs(ciEmsDto,envinfo, ciOrTmplDTO, medSrvDO);
			ciEmsDto.setEmssrvs(list);// 医疗单项目集合

			// ciEmsDto 保留剂量
			CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) list.get(0);
			FArrayList srvlist = ciOrTmplDTO.getOrtmplsrvs();
			if (srvlist != null) {
				CiOrTmplSrvDTO tmplSrv = (CiOrTmplSrvDTO) srvlist.get(0);
				ciEmsDto.setQuan_medu(tmplSrv.getQuan_med());
			} else {
				ciEmsDto.setQuan_medu(ciEmsSrv.getQuan_med());
			}

		}

		// 设置服务价格
		this.setCiEmsPrice(envinfo, ciEmsDto, medSrvDO);

		FArrayList emssrvList = ciEmsDto.getEmssrvs();
		for (Object obj : emssrvList) {
			CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) obj;
			//0192960: 参数BLCG0040设置为false时，0元医嘱不可开立。0元手术仍能开立，应校验不可开立
			if(FBoolean.FALSE.equals(BlParams.BLCG0040())){
				if(FBoolean.TRUE.equals(srvDTO.getFg_bl()) && (srvDTO.getPrice() != null && srvDTO.getPrice().doubleValue() == 0)){
					if(srvDTO.getFg_mm().equals(FBoolean.TRUE)){
						OrdBizLogger.info(envinfo, "【" + srvDTO.getName_mm() + "】0元医嘱不可开立！");
						msgWarn.append("【" + srvDTO.getName_mm() + "】0元医嘱不可开立！");
					}else{
						OrdBizLogger.info(envinfo, "【" + srvDTO.getName_srv() + "】0元医嘱不可开立！");
						msgWarn.append("【" + srvDTO.getName_srv() + "】0元医嘱不可开立！");
					}
				}
			}else{
				if(FBoolean.TRUE.equals(srvDTO.getFg_bl()) &&
						(srvDTO.getEu_blmd() != null && 1 == srvDTO.getEu_blmd()) &&
						(srvDTO.getPrice() != null && srvDTO.getPrice().doubleValue() == 0)){
					if(srvDTO.getFg_mm().equals(FBoolean.TRUE)){
						OrdBizLogger.info(envinfo, "【" + srvDTO.getName_mm() + "】0元医嘱不可开立！");
						msgWarn.append("【" + srvDTO.getName_mm() + "】0元医嘱不可开立！");
					}else{
						OrdBizLogger.info(envinfo, "【" + srvDTO.getName_srv() + "】0元医嘱不可开立！");
						msgWarn.append("【" + srvDTO.getName_srv() + "】0元医嘱不可开立！");
					}
				}
			}
			if (FBoolean.TRUE.equals(srvDTO.getFg_skintest())) {
				ciEmsDto.setFg_skintest(FBoolean.TRUE);
				break;
			}
		}
		// TODO 代煎付数：计算代煎费用使用，草药的代煎付数等于草药付数
		// TODO 标本管理费用计算：检验门诊一条医嘱对应一组标本采集费 检验属性中标本类型，容器类型
		
		if (ciEmsDto.getSd_srvtp() != null) {
			if(ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				// 0127036: 门诊草药调用医嘱模板，嘱托赋值到备注里;如果模板备注为空，则拼接备注
				if (ciOrTmplDTO.getDes_or() == "" || ciOrTmplDTO.getDes_or() == null) {
					if (tmplSrvDTO != null && tmplSrvDTO.getQuan_med() != null) {
//						ciEmsDto.setNote(
//								"每日1剂," + (ciEmsDto.getName_boil() == "" ? "" : ciEmsDto.getName_boil() + "至400ml,")
//										+ tmplSrvDTO.getQuan_med() + " " + medSrvDO.getMed_name() + ","
//										+ ciEmsDto.getName_freq() + "," + ciEmsDto.getName_route());
						ciEmsDto.setNote(CiOrdUtils.genOrdDes(ciEmsDto));

					} else {
//						ciEmsDto.setNote(CiOrdUtils.genOrdDes(ciEmsDto)
//								"每日1剂," + (ciEmsDto.getName_boil() == "" ? "" : ciEmsDto.getName_boil() + "至400ml,")
//										+ medSrvDO.getQuan_med() + " " + medSrvDO.getMed_name() + ","
//										+ ciEmsDto.getName_freq() + "," + ciEmsDto.getName_route());
						ciEmsDto.setNote(CiOrdUtils.genOrdDes(ciEmsDto));
					}
				} else {
					ciEmsDto.setNote(ciOrTmplDTO.getDes_or());
				}
			} else if (ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS) || ciEmsDto.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				MedSrvLisDO listdo = BDSrvLisInfoCache.GetBdSrvLisInfo(envinfo, ciOrTmplDTO.getId_srv());
				if(listdo != null){
					ciEmsDto.setDes_or(listdo.getNote());
				}
			} else if (ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				MedSrvRisDO risdo = BDSrvRisInfoCache.GetBdSrvRisInfo(envinfo, ciOrTmplDTO.getId_srv());
				if(risdo != null){
					ciEmsDto.setDes_or(risdo.getNote());
				}
				
			} 
		}
		return msgWarn.toString();
	}

	/**
	 * 通过bd服务赋值频次、用法、用法要求、煎法、煎法要求、医嘱天数
	 * 
	 * @param ciEmsDto
	 * @param tmplSrvDTO
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void setCiEmsDTOUseDetailByMedSrv(CiEnContextDTO envinfo, CiEmsDTO ciEmsDto, MedSrvDO medSrvDO, CiOrTmplDTO ciOrTmplDTO)
			throws BizException {

		// 频次
		if (StringUtils.isBlank(ciEmsDto.getId_freq())) {
			ciEmsDto.setId_freq(medSrvDO.getId_freq());
		}

		// 获取SD中频次
		FreqDefDO freqDef = ifreqdefMDORService.findById(ciEmsDto.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}
		ciEmsDto.setFg_long(freqDef.getFg_long()); // 常临标识
													// 住院根据频次中定义的类型设置常临标识，门诊的都为false
		ciEmsDto.setName_freq(freqDef.getName());// 医嘱频次名称
		ciEmsDto.setFreqct(freqDef.getFreqct()); // 频次周期下次数
		ciEmsDto.setSd_frequnitct(freqDef.getSd_frequnitct()); // 频次周期类型编码
		ciEmsDto.setFrequnitct(freqDef.getFrequnitct());

		// 频次是一次的医嘱天数设置为1
				if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())) {
					ciEmsDto.setDays_or(1);
				}else{
					if (envinfo != null && (envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
							|| envinfo.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS))) {
						ciEmsDto.setDays_or(null);// 医嘱天数
					} else {
						if(ciOrTmplDTO!=null&&ciOrTmplDTO.getDays_or()!=null){
							ciEmsDto.setDays_or(ciOrTmplDTO.getDays_or());
						}else{
							if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(ciEmsDto.getSd_frequnitct())) { // 如果频次周期类型是星期，返回一个周期的天数
								ciEmsDto.setDays_or(7);
								
							}else{
								ciEmsDto.setDays_or(1);
							}
						}
					}
					
				}

		// 设置用法id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_route())) {

			MedUsageDO medUsage = imedusageRService.findById(ciEmsDto.getId_route()); // 用法
			if (medUsage == null) {
				throw new BizException("获取用法SD失败！");
			}
			ciEmsDto.setName_route(medUsage.getName());// 用法名称
		} else {
			ciEmsDto.setId_route(medSrvDO.getId_route());// 用法
			ciEmsDto.setName_route(medSrvDO.getRoute_name());// 用法名称
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_routedes())) {
			ciEmsDto.setName_routedes(getName_routes(ciEmsDto.getId_routedes()));
		} else {
			ciEmsDto.setId_routedes(medSrvDO.getId_routedes());
			ciEmsDto.setName_routedes(medSrvDO.getRoutedes_name());
		}

		// 设置煎法id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_boil())) {

			// CHerbBoilMdDO cHerbBoilMd =
			// icherbboilmdMDORService.findById(ciEmsDto.getId_boil());
			DAFacade dafa = new DAFacade();
			String sql = "select name  from bd_boil where id_boil='" + ciEmsDto.getId_boil() + "'";
			CHerbBoilMdDO cHerbBoil = (CHerbBoilMdDO) dafa.execQuery(sql, new BeanHandler(CHerbBoilMdDO.class));
			if (cHerbBoil == null) {
				throw new BizException("获取煎法SD失败！");
			}
			ciEmsDto.setName_boil(cHerbBoil.getName());
		} else {
			ciEmsDto.setId_boil(medSrvDO.getId_boil());
			ciEmsDto.setName_boil(medSrvDO.getBoil_name());
		}

		// 煎法要求
		if (StringUtils.isNotBlank(ciEmsDto.getId_boildes())) {

			// CHerbBoilDesDO cherbBoilDes =
			// icHerbBoilDesDORService.findById(ciEmsDto.getId_boildes());
			DAFacade dafa = new DAFacade();
			String sql = "select name  from bd_boil_des where id_boildes='" + ciEmsDto.getId_boildes() + "'";
			CHerbBoilDesDO cherbBoilDesc = (CHerbBoilDesDO) dafa.execQuery(sql, new BeanHandler(CHerbBoilDesDO.class));

			if (cherbBoilDesc == null) {
				throw new BizException("煎法要求SD失败！");
			}
			ciEmsDto.setName_boildes(cherbBoilDesc.getName());
		} else {
			ciEmsDto.setId_boildes(medSrvDO.getId_boildes());
			ciEmsDto.setName_boildes(medSrvDO.getBoildes_name());
		}
	}

	/**
	 * @throws BizException
	 * 
	 */
	private void setMkrSetProperty(CiEmsDTO ciEmsDto, CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, MedSrvDO medSrv)
			throws BizException {

		MedSrvDO[] medSrvs = this.getSetMedSrvDOs(ciOrTmpl);
		// 构造套内项目集合
		if (FBoolean.TRUE.equals(ciOrTmpl.getFg_set())) {
			List<String> idsrvs= new ArrayList<String>();
			for(Object srv : ciOrTmpl.getOrtmplsrvs()) {
				idsrvs.add(((CiOrTmplSrvDTO)srv).getId_srv());
			}
			
			FMap Srvsetitms = this.getSrvSetitmMap(ciOrTmpl.getId_srv(), idsrvs);
			ciEmsDto.setSrvsetitms(Srvsetitms);
		}

		FArrayList ciEmsSrvList = new FArrayList();
		// 套的处理
		if (FBoolean.TRUE.equals(ciEmsDto.getFg_set())) {
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
			this.setCiEmSrvPropertys(ciEmsDto,srvdto, envinfo, null, medSrv);
			this.setCiEmsSrvMeduPropertys(envinfo,srvdto, ciOrTmpl);
			ciEmsSrvList.add(srvdto);
		}

		for (int i = 0; i < medSrvs.length; i++) {

			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();

			// 设置CiEmsSrvDTO相关属性，环境、服务、物品
			this.setCiEmSrvPropertys(ciEmsDto,srvdto, envinfo, null, medSrvs[i]);

			// 设置量信息
			this.setCiEmsSrvMeduPropertys(envinfo,srvdto, ciOrTmpl);
			srvdto.setSortno(i + 1);// 设置排序
			if (FBoolean.TRUE.equals(ciOrTmpl.getFg_set())) {
				srvdto.setId_srv_set(ciOrTmpl.getId_srv());
			}
			srvdto.setCode_srv(medSrv.getCode());
			ciEmsSrvList.add(srvdto);
		}
		ciEmsDto.setEmssrvs(ciEmsSrvList);
		CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) ciEmsSrvList.get(0);
		ciEmsDto.setQuan_medu(srvDTO.getQuan_med());

		if (ciEmsDto.getSd_srvtp() != null
				&& ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			ciEmsDto.setNote(" " + ciEmsDto.getName_boil() + " " + srvDTO.getQuan_med() + "," + ciEmsDto.getName_freq()
					+ "," + ciEmsDto.getName_route());

		} else {
			// ciEmsDto.setNote();
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
	private FArrayList getEmssrvs( CiEmsDTO ciEmsDto,CiEnContextDTO envinfo, CiOrTmplDTO ciOrTmpl, MedSrvDO medSrv) throws BizException {

		FArrayList ciEmsSrvList = new FArrayList();
		FArrayList srvlist = ciOrTmpl.getOrtmplsrvs();
		// 套的处理
		/*if (FBoolean.TRUE.equals(medSrv.getFg_set())) {
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();

			this.setCiEmSrvPropertys(ciEmsDto,srvdto, envinfo, null, medSrv);
			this.setCiEmsSrvMeduPropertys(envinfo,srvdto, ciOrTmpl);
			ciEmsSrvList.add(srvdto);
		}*/

		MedSrvDO tempMedSrv = null;
		for (int i = 0; i < srvlist.size(); i++) {
			CiOrTmplSrvDTO tmplSrv = (CiOrTmplSrvDTO) srvlist.get(i);
			CiEmsSrvDTO srvdto = new CiEmsSrvDTO();
			srvdto.setId_hp(envinfo.getId_hp());
			tempMedSrv = CiOrdAppUtils.getIMedsrvMDORService().findById(tmplSrv.getId_srv());// 获取每个项目
			// 设置CiEmsSrvDTO相关属性，环境、模板、服务、物品
			this.setCiEmSrvPropertys(ciEmsDto,srvdto, envinfo, tmplSrv, tempMedSrv);
			
			// 设置量信息
			//获取门诊总量编辑模式
			String paramString="";
			paramString = getDealWithUnitParam(paramString);
			if ("0".equals(paramString)) {//不可编辑
				this.setCiEmsSrvMeduPropertys(envinfo,srvdto, ciOrTmpl,ciEmsDto);
			}else{
				if (tmplSrv.getQuan_total_medu()!=null && tmplSrv.getQuan_total_medu().compareTo(FDouble.ZERO_DBL) >0) {
					srvdto.setQuan_cur(tmplSrv.getQuan_total_medu());
					srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu());
				}else{
					this.setCiEmsSrvMeduPropertys(envinfo,srvdto, ciOrTmpl,ciEmsDto);
				}
			}
			
			srvdto.setDays_available(new GetDrugDaysOfAvailable().exec(srvdto));
			
			//this.setCiEmsSrvMeduPropertys(envinfo,srvdto, ciOrTmpl.getDays_or(), ciOrTmpl.getOrders());
			srvdto.setSortno(i + 1);// 设置排序
			// 是套服务时才设置id_srv_set属性 2016-11-28
			if (FBoolean.TRUE.equals(medSrv.getFg_set())) {
				srvdto.setId_srv_set(ciOrTmpl.getId_srv());
			}
			srvdto.setCode_srv(tempMedSrv.getCode());
			srvdto.setFg_skintest(tmplSrv.getFg_skintest());
			ciEmsSrvList.add(srvdto);
		}
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
	private void setCiEmSrvPropertys(CiEmsDTO ciEmsDTO,CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, CiOrTmplSrvDTO tmplSrv,
			MedSrvDO medSrv) throws BizException {

		// 设置环境相关属性
		this.setCiEmsSrvEnvinfoPropertys(srvdto, envinfo);
		
		// 设置服务相关属性
		this.setCiEmsSrvMedSrvPropertys(srvdto, medSrv, envinfo);
		if (tmplSrv != null) { // 医嘱模板进来的为空
			// 设置模板中的属性
			this.setCiEmSrvTmplPropertys(srvdto, tmplSrv);
			// 设置频次、用法、用法要求、煎法、煎法要求
			this.setCiEmsSrvUseDetail(srvdto, medSrv);
			if (FBoolean.TRUE.equals(medSrv.getFg_ctm())&&!StringUtils.isBlank(tmplSrv.getName_selfsrv())) {
				srvdto.setName_srv(tmplSrv.getName_selfsrv());
			}
		}
		// 设置物品相关属性
		this.setCiEmsSrvMmPropertys(ciEmsDTO,srvdto, envinfo, medSrv);
		
		
		// 设置执行科室相关属性
		//this.setCiEmsSrvOrWfDept(srvdto, envinfo, medSrv);

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
		if(StringUtils.isNotEmpty(tmplSrv.getId_srvtp())) {
			srvdto.setId_srvtp(tmplSrv.getId_srvtp());// 服务类型  mantis:0181513 模板开立的id有为空的情况 
		}
		if(StringUtils.isNotEmpty(tmplSrv.getSd_srvtp())) {
			srvdto.setSd_srvtp(tmplSrv.getSd_srvtp());// 服务类型编码
		}
		if(StringUtils.isNotEmpty(tmplSrv.getId_freq())) {
			srvdto.setId_freq(tmplSrv.getId_freq());// 频次
		}
		if(StringUtils.isNotEmpty(tmplSrv.getId_route())) {
			srvdto.setId_route(tmplSrv.getId_route());// 用法
		}
		if(StringUtils.isNotEmpty(tmplSrv.getId_routedes())) {
			srvdto.setId_routedes(tmplSrv.getId_routedes());// 用法要求
		}
		if(StringUtils.isNotEmpty(tmplSrv.getId_boil())) {
			srvdto.setId_boil(tmplSrv.getId_boil());// 煎法
		}
		if(StringUtils.isNotEmpty(tmplSrv.getId_boildes())) {
			srvdto.setId_boildes(tmplSrv.getId_boildes());// 煎法要求
		}
		if(tmplSrv.getQuan_med() != null) {
			srvdto.setQuan_med(tmplSrv.getQuan_med());// 医学单位数值（剂量）
		}
		if(StringUtils.isNotEmpty(tmplSrv.getId_unit_med())) {
			srvdto.setId_unit_med(tmplSrv.getId_unit_med());// 医学单位（计量单位）
		}
		if(tmplSrv.getId_unit_med()!=null){
			MeasDocDO[] measDocDO = getMeasDocDO(tmplSrv.getId_unit_med());
			if (measDocDO!=null&&measDocDO.length >0) {
				srvdto.setName_unit_med(measDocDO[0].getName());
			}
		}
		if (tmplSrv.getQuan_total_medu()!=null&&tmplSrv.getSd_srvtp().startsWith("01")) {
			 srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu()); // 总量 TODO
			 srvdto.setId_unit_sale(tmplSrv.getId_unit_sale());
		}
		
		// 对于服务套来说，缺少总量单位 总量应该放到后面计算

		srvdto.setId_dep(tmplSrv.getId_dep_mp()); // 执行科室
		srvdto.setId_mm(tmplSrv.getId_mm());// 物品
		//服务分类开立医嘱的时候 当前剂量 换算系数等值为空
		if (tmplSrv.getFactor_cur()==null) {
			srvdto.setQuan_medu_cur(tmplSrv.getQuan_med());
			srvdto.setId_medu_cur(tmplSrv.getId_unit_med());
			srvdto.setFactor_medu_cur(new FDouble(1));
		}else{
			srvdto.setQuan_medu_cur(tmplSrv.getQuan_medu_cur());
			srvdto.setId_medu_cur(tmplSrv.getId_medu_cur());
			srvdto.setFactor_medu_cur(tmplSrv.getFactor_cur());
		}
		
		if(tmplSrv.getId_medu_cur()!=null){
			MeasDocDO[] measDocDO = getMeasDocDO(tmplSrv.getId_medu_cur());
			if (measDocDO!=null&&measDocDO.length >0) {
				srvdto.setName_unit_medu_cur(measDocDO[0].getName());
			}
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
	private void setCiEmsSrvMedSrvPropertys(CiEmsSrvDTO srvdto, MedSrvDO medSrv, CiEnContextDTO envinfo)
			throws BizException {

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
		if (!OrSourceFromEnum.IIHSRVCAHELPER.equals(envinfo.getEu_orsrcmdtp())) {
			if (isFDoubleEmpty(srvdto.getQuan_med())) {
				srvdto.setQuan_med(medSrv.getQuan_med());// 医学单位数值（剂量）
			}
		}
		if (StringUtils.isBlank(srvdto.getId_unit_med())) {
			srvdto.setId_unit_med(medSrv.getId_unit_med());// 医学单位(剂量单位)
		}
		srvdto.setName_unit_med(medSrv.getMed_name()); // 医学单位名称（剂量单位名称）
		srvdto.setFg_mm(medSrv.getFg_mm());// 物品标识
		srvdto.setFg_set(medSrv.getFg_set());// 服务套标识 套内项目全设置为False
		MedSrvSetItemDO medSrvSetItem = setItemSrvMap.get(srvdto.getId_srv());
		if (medSrvSetItem != null) {
			srvdto.setFg_or(medSrvSetItem.getFg_clinical());// 医嘱标识
		} else {
			srvdto.setFg_or(medSrv.getFg_or());// 医嘱标识
		}

		srvdto.setFg_bl(medSrv.getFg_bl());// 费用标识
		srvdto.setEu_blmd(medSrv.getEu_blmd());// 划价方式
		MedSrvRisDO medSrvRis = srvRisMap.get(srvdto.getId_srv());
		if (medSrvRis != null && !FBoolean.TRUE.equals(srvdto.getFg_set())) {
			srvdto.setId_body(medSrvRis.getId_body());// 部位
			srvdto.setSd_body(medSrvRis.getSd_body());// 部位编码
			srvdto.setBody_name(medSrvRis.getName_body());// 部位名称
			srvdto.setId_pos(medSrvRis.getId_pos());// 体位
			srvdto.setSd_pos(medSrvRis.getSd_pos());// 体位编码
			srvdto.setPos_name(medSrvRis.getName_pos());// 体位名称
		}
		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);// 医疗单项目数据来源方式
		srvdto.setFg_selfsrv(medSrv.getFg_ctm());// 自定义服务标识
		srvdto.setId_primd(medSrv.getId_primd());// 定价模式
		srvdto.setInnercode_srvca(medSrv.getSrvca_code());// 服务分类内码
	}

	/**
	 * 设置CiEmsSrvDTO中物品相关属性
	 * 
	 * @param srvdto
	 * @param envinfo
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmsSrvMmPropertys(CiEmsDTO ciEmsDTO,CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, MedSrvDO medSrv)
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
				if (CiOrdUtils.isEmpty(srvdto.getFg_propc())) {
					srvdto.setFg_propc(FBoolean.FALSE); // emsordrug.Fg_propc
														// 可能存在空值
				}
			}
		}
		srvdto.setFg_skintest(meterial.getFg_skin());
		srvdto.setId_srvskin(meterial.getId_srvskin());
		srvdto.setId_unit_med(meterial.getId_unit_med());
		srvdto.setName_unit_med(meterial.getUnit_med_name());
		// 商品模式时才用bd_mm进行赋值
		if (IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(drugManagementModel)) {
			if (StringUtils.isEmpty(srvdto.getId_boil())) {
				srvdto.setId_boil(meterial.getId_boil());
				srvdto.setName_boil(meterial.getBoil_name());
			}
			if (StringUtils.isEmpty(srvdto.getId_boildes())) {
				srvdto.setId_boildes(meterial.getId_boildes());
				srvdto.setName_boildes(meterial.getBoildes_name());
			}
			if (StringUtils.isEmpty(srvdto.getId_route())) {
				srvdto.setId_route(meterial.getId_route());
				srvdto.setName_route(meterial.getRoute_name());
			}
			if (StringUtils.isEmpty(srvdto.getId_freq())) {
				srvdto.setId_freq(meterial.getId_freq());
				srvdto.setName_freq(meterial.getFreq_name());
			}
		}
		// srvdto.setQuan_cur(tmplSrv.getQuan_cur());//总量_当前
		/// srvdto.setQuan_base(meterial.getQuan_base());//总量_基本
		srvdto.setId_mm(meterial.getId_mm());// 物品id
		srvdto.setName_mm(meterial.getName());// 物品名称
		srvdto.setSpec_mm(meterial.getSpec());// 规格
		// 获取物品的有效单位
		MaterialUnitDTO[] materIalUnits = BDMmDoseUnitInfoCache.getMaterialUnitInfos(envinfo.getCode_entp(), new String[] {srvdto.getId_mm()});
		if(srvdto.getId_unit_sale()==null){
			srvdto.setId_unit_sale(materIalUnits[0].getId_measdoc());// 零售单位
			srvdto.setName_unit_sale(materIalUnits[0].getMeasdoc_name());// 零售单位名称
		}else{
			for (MaterialUnitDTO materialUnitDTO : materIalUnits) {
				if (materialUnitDTO.getId_measdoc().equals(srvdto.getId_unit_sale())) {
					srvdto.setName_unit_sale(materialUnitDTO.getMeasdoc_name());// 零售单位名称
				}
			}
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
//		OrWfDeptInfoDTO wf = getMpDeptID(envinfo, medSrv);// 药品仓库
//		if (null != wf) {
//			srvdto.setId_dep_wh(wf.getId_dept_wh());// 仓库
//			srvdto.setName_dep_wh(wf.getName_dept_wh()); // 仓库的名称
//		}
		//设置执行科室相关属性  仓库需要先查出来 后面计算价格需要仓库作为参数 
		this.setCiEmsSrvOrWfDept(ciEmsDTO,srvdto, envinfo, medSrv);
		FDouble pricce = this.getMMwhPrice(meterial.getId_mm(), materIalUnits[0].getId_measdoc(),
				srvdto.getId_dep_wh());
		srvdto.setPrice_cur(pricce);
		srvdto.setPrice(pricce);
		if (iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(envinfo.getCode_entp())) {
			srvdto.setSd_roundmd(meterial.getSd_mupkgutp());// 住院-取整方式
		} else {
			srvdto.setSd_roundmd(meterial.getSd_opmutp());// 门诊-取整方式
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
		//当前剂量和单位赋值 
		/*srvdto.setId_medu_cur(srvdto.getId_medu_cur());
		srvdto.setQuan_medu_cur(srvdto.getQuan_medu_cur());
		srvdto.setFactor_medu_cur(new FDouble("1"));*/
		MeasDocDO[] measDocDO = getMeasDocDO(srvdto.getId_medu_cur());
		if (measDocDO!=null&&measDocDO.length>0) {
			srvdto.setName_unit_medu_cur(measDocDO[0].getName());
		}
		
	}
	
	public MeasDocDO[] getMeasDocDO(String id_unit_med) throws BizException{

		MeasDocDOQuery qry=new MeasDocDOQuery(id_unit_med);
		MeasDocDO[] rtn = (MeasDocDO[])AppFwUtil.getDORstWithDao(qry, MeasDocDO.class);
		 return rtn;
	}

	/**
	 * 设置服务价格
	 * 
	 * @param srvdto
	 * @param medSrv
	 * @throws BizException
	 */
	private void setCiEmsPrice(CiEnContextDTO envinfo, CiEmsDTO ciEmsDto, MedSrvDO medSrv) throws BizException {

		String id_pripat = envinfo.getId_pripat();
		FArrayList emssrvList = ciEmsDto.getEmssrvs();
		CiEmsSrvDTO srvdto = (CiEmsSrvDTO) emssrvList.get(0);
		// 如果价格不为空，或者套内项目不进行价格计算
		if (srvdto.getPrice() != null) {
			return;
		}
		//套本身是不付费的，不用再算了，zhangwq20191108
		if (FBoolean.TRUE.equals(ciEmsDto.getFg_set())){
			return;
		}
		// 构造查询价格参数
		BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
		param.setId_srv(medSrv.getId_srv());
		param.setName_srv(medSrv.getName());
		param.setId_primd(medSrv.getId_primd());
		param.setNum(0);
		// 如果是套，根据套内项目计算价格, 排除服务套单选模式
		if (FBoolean.TRUE.equals(ciEmsDto.getFg_set()) &&  !FBoolean.TRUE.equals(medSrv.getFg_setradio()) && srvSetItemsMap.size()>0) {

			// 计算费用的套内项目个数
			int clinicalBlCnt = 0;
			List<MedSrvSetItemDO> srvsetitmList = srvSetItemsMap.get(ciEmsDto.getId_srv());
			FArrayList list = new FArrayList();
			if (srvsetitmList == null || srvsetitmList.size() == 0) {
				OrdBizLogger.info(envinfo, "服务[" + ciEmsDto.getName() + "]未找到对应的套内项目！");
				throw new BizRuntimeException("服务[" + ciEmsDto.getName() + "]未找到对应的套内项目！");
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
	private void setCiEmsSrvMeduPropertys(CiEnContextDTO envinfo,CiEmsSrvDTO srvdto, CiOrTmplDTO ciOrTmpl ) throws BizException {
		
		Integer useDays=ciOrTmpl.getDays_or();
		Integer orders=ciOrTmpl.getOrders();

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
				if (srvdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					srvdto.setQuan_cur(calQuantumBP.getMMQuantum(envinfo.getCode_entp(), envinfo.getFg_pres_outp(), orders, srvdto.getId_mm(), srvdto.getId_unit_sale(), srvdto.getQuan_med()));
				}else{
					srvdto.setQuan_cur(calQuantumBP.getMMQuantum(envinfo.getCode_entp(), envinfo.getFg_pres_outp(), ciOrTmpl.getDt_effe(),useDays, srvdto.getId_freq(), srvdto.getId_mm(), srvdto.getId_unit_sale(), srvdto.getQuan_med()));
				}
				srvdto.setQuan_total_medu(srvdto.getQuan_cur());
			}
			// 领量天数
			srvdto.setDays_available(new GetDrugDaysOfAvailable().exec(srvdto));
		} else {
			// 计算非药品服务总量
			if(ciOrTmpl.getTimes()!=null){
				srvdto.setQuan_cur(calQuantumBP.getQuantum(srvdto.getQuan_med(),ciOrTmpl.getTimes()));
			}else{
				srvdto.setQuan_cur(calQuantumBP.getUnMMQuantum(ciOrTmpl.getDt_effe(),srvdto.getId_freq(), useDays, srvdto.getQuan_med()));
			}
			
			srvdto.setQuan_total_medu(srvdto.getQuan_cur());
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
	private void setCiEmsSrvMeduPropertys(CiEnContextDTO envinfo,CiEmsSrvDTO srvdto, CiOrTmplDTO ciOrTmpl, CiEmsDTO ciEmsDto) throws BizException {
		
		Integer useDays=ciOrTmpl.getDays_or();
		Integer orders=ciOrTmpl.getOrders();

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
				if (srvdto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					srvdto.setQuan_cur(calQuantumBP.getMMQuantum(envinfo.getCode_entp(), envinfo.getFg_pres_outp(), orders, srvdto.getId_mm(), srvdto.getId_unit_sale(), srvdto.getQuan_med()));
				}else{
					srvdto.setQuan_cur(calQuantumBP.getMMQuantum(envinfo.getCode_entp(), envinfo.getFg_pres_outp(), ciOrTmpl.getDt_effe(),useDays, srvdto.getId_freq(), srvdto.getId_mm(), srvdto.getId_unit_sale(), srvdto.getQuan_med()));
				}
				srvdto.setQuan_total_medu(srvdto.getQuan_cur());
			}
			// 领量天数
			srvdto.setDays_available(new GetDrugDaysOfAvailable().exec(srvdto));
		} else {
			// 计算非药品服务总量
			if(ciEmsDto.getTimes_cur()!=null){
				srvdto.setQuan_cur(calQuantumBP.getQuantum(srvdto.getQuan_med(),ciEmsDto.getTimes_cur()));
			}else{
				srvdto.setQuan_cur(calQuantumBP.getUnMMQuantum(ciOrTmpl.getDt_effe(),srvdto.getId_freq(), useDays, srvdto.getQuan_med()));
			}
			
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
	private void setCiEmsSrvOrWfDept(CiEmsDTO ciEmsDto,CiEmsSrvDTO srvdto, CiEnContextDTO envinfo, MedSrvDO medSrv) throws BizException {
		if(srvdto == null || envinfo == null || medSrv ==null) {
			return;
		}
		String sd_srvtp = srvdto.getSd_srvtp();
		medSrv.setId_route(srvdto.getId_route());//用法应该采用模板传来的，而不是bd_srv查的
		//获取执行科室  科室在这里指药房 通过类型字段区分的
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(envinfo, medSrv.getId_srv(), srvdto.getId_mm(),ciEmsDto.getId_route(),ciEmsDto.getId_dep_mp(),ciEmsDto.getFg_long(),envinfo.getFg_pres_outp(),ciEmsDto.getDt_begin());
		if (null != wf) {
			List<GetStockReqDTO> reqDtos = new ArrayList<GetStockReqDTO>();
			if(sd_srvtp != null && sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {//药品
				//1.判断优先级最高的仓库是否有库存
				constructConditions(reqDtos,srvdto,wf.getId_dept_wh());
				MaterialStockDTO materialDo = selectWhDept(reqDtos);
				setWhDept(srvdto,materialDo,wf.getName_dept_wh());
				String id_dep_wh = wf.getId_dept_wh();
				if(srvdto.getId_dep_wh() != null && srvdto.getName_dep_wh() != null) {//若第一优先级药房附了值  直接返回
					return ;
				}
				//2.若优先级最高的没有库存，遍历其他优先级的仓库，从中任选一个
				FArrayList idDeptWhs = wf.getPharmwfwhdepts();
				if(idDeptWhs != null && idDeptWhs.size() > 0) {
					reqDtos = new ArrayList<GetStockReqDTO>();
					Map<String,String> map = new HashMap<String,String>();
					for(int i=0;i<idDeptWhs.size();i++) {
						OrWfExDeptDTO orWfExDeptDTO = (OrWfExDeptDTO)idDeptWhs.get(i);
						map.put(orWfExDeptDTO.getId_dept(), orWfExDeptDTO.getName_dept());
						constructConditions(reqDtos,srvdto,orWfExDeptDTO.getId_dept());
					}
					materialDo = selectWhDept(reqDtos);
					if(materialDo != null ) {
						setWhDept(srvdto,materialDo,map.get(materialDo.getId_dep()));
					}
				}
			}else {
				srvdto.setId_dep_wh(wf.getId_dept_wh());
				srvdto.setName_dep_wh(wf.getName_dept_wh()); 
			}
		}
	}
	/**
	 * 设置库房字段值
	 * @param srvdto
	 * @param materialDo
	 * @param deptName
	 */
	private void setWhDept(CiEmsSrvDTO srvdto,MaterialStockDTO materialDo,String deptName) {
		if(materialDo != null) {
			srvdto.setId_dep_wh(materialDo.getId_dep());
			srvdto.setName_dep_wh(deptName);
		}
	}
	/**
	 * 构造查询条件dtos
	 * @param reqDtos
	 * @param srvdto
	 * @param id_dept
	 */
	private void constructConditions(List<GetStockReqDTO> reqDtos,CiEmsSrvDTO srvdto, String id_dept) {
		GetStockReqDTO reqDTO = new GetStockReqDTO();
		reqDTO.setId_mm(srvdto.getId_mm());//物品id
		reqDTO.setId_dep(id_dept);//物资科室(库房)
		reqDTO.setReq_unit_id(srvdto.getId_unit_sale());//零售单位
		reqDtos.add(reqDTO);
	}
	/**
	 * 查询药房
	 * @param reqDtos
	 * @throws BizException
	 */
	private MaterialStockDTO selectWhDept(List<GetStockReqDTO> reqDtos) throws BizException{
		if(reqDtos == null || reqDtos.size() <= 0) {
			return null;
		}
		IMaterialStockService stoctService = CiOrdAppUtils.getMaterialStockQryService();
		MaterialStockDTO[] stockdto = null;
		try {
			stockdto = stoctService.getMaterialStocks(reqDtos.toArray(new GetStockReqDTO[0]));
		}catch(Exception e) {
			;
		}
		if (stockdto != null) {
			for (MaterialStockDTO materialDo : stockdto) {
				FDouble mmcount = materialDo.getQuan_usable();
				if (materialDo.getMmstatus() != MaterialStatus.NORELATION
						&& materialDo.getMmstatus() != MaterialStatus.STOP
						&& mmcount != null && (mmcount.compareTo(new FDouble(0)) != 0)
					) {
					return materialDo;
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
	private FDouble getMMPrice(String id_mm, String id_unit_sale) throws BizException {
		IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
		GetStockReqDTO reqDto = new GetStockReqDTO();
		reqDto.setId_mm(id_mm);
		reqDto.setReq_unit_id(id_unit_sale);
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
	 * 获取物品基本包装单位价格
	 * 
	 * @param id_mm
	 *            物品id
	 * @param id_unit_sale
	 *            物品零售单位
	 * @return
	 */
	private FDouble getMMwhPrice(String id_mm, String id_unit_sale, String id_dep_wh) throws BizException {
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

		List<String> idsrvs= new ArrayList<String>();
		for(Object srv : ciOrTmpl.getOrtmplsrvs()) {
			idsrvs.add(((CiOrTmplSrvDTO)srv).getId_srv());
		}

		return this.getSrvSetitmMap(ciOrTmpl.getId_srv(), idsrvs);
	}

	/**
	 * 获取套的map结果，
	 * 
	 * @param idSrv
	 * @param medSrvs
	 * @return
	 */
	private FMap getSrvSetitmMap(String idSrv, List<String> idsrvs) {

		FMap fmap = new FMap();
		FArrayList ordSrvSetList = new FArrayList();
		List<MedSrvSetItemDO> setItems = srvSetItemsMap.get(idSrv);
		if (setItems != null && setItems.size() > 0) {
			for (MedSrvSetItemDO setItem : setItems) {
				if(!idsrvs.contains(setItem.getId_srv_itm()))
					continue;
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
				MedSrvRisDO medSrvRis = srvRisMap.get(setItem.getId_srv_itm());
				if (!CiOrdUtils.isEmpty(medSrvRis)) {
					ordSrvSet.setBody_name(medSrvRis.getName_body());
					ordSrvSet.setId_body(medSrvRis.getId_body());
					ordSrvSet.setSd_body(medSrvRis.getSd_body());
					ordSrvSet.setId_pos(medSrvRis.getId_pos());
					ordSrvSet.setSd_pos(medSrvRis.getSd_pos());
				}
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
				&&FBoolean.TRUE.equals( ciOrTmpl.getFg_set())) {// 来源组套

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
	 * @param ciEmsDto
	 * @param tmplSrvDTO
	 *            CiEmsDTO ciEmsDto
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
		if (StringUtils.isNotBlank(srvdto.getId_boildes())) {
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
	private SrvMatchEmsRstDTO getFuncClassStr(CiEnContextDTO envinfo, MedSrvDO medSrvDO) throws BizException {
		return CiOrdUtils.getFuncClassStr_GJ(envinfo, medSrvDO);
	}

	/**
	 * 查询执行科室，不包含物质流向
	 * 
	 * @param envinfo
	 *            就诊环境
	 * @param medsrvDO
	 *            当前服务
	 * @return
	 * @throws BizException
	 */
	private OrWfDeptInfoDTO getMpDeptID(CiEnContextDTO envinfo, CiEmsDTO ciEms,MedSrvDO medsrvDO) throws BizException {
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(envinfo, medsrvDO.getId_srv(), null, ciEms.getId_route(),ciEms.getId_dep_mp(), ciEms.getFg_long(), ciEms.getFg_pres_outp(),ciEms.getDt_begin());

		return wf;
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
			}
			if (list != null && list.size() > 0) {
				String[] id_srv = list.toArray(new String[0]);
				medsrvDo = findByIds(id_srv, FBoolean.FALSE);
				
				
			}
		}
		createSrvRisMap(medsrvDo);
		return medSrvDOMap(medsrvDo);
	}
	
	private void createSrvRisMap(MedSrvDO[] medsrvDo) throws BizException {
		if (medsrvDo == null)
			return ;
		StringBuilder sb=new StringBuilder();
		MedSrvRisDO[] medSrvRises = null;
		for (MedSrvDO medsrvDO : medsrvDo) {
			if(medsrvDO.getSd_srvtp()!=null&&medsrvDO.getSd_srvtp().startsWith( IBdSrvDictCodeConst.SD_SRVTP_RIS )) {
				sb.append(",'"+medsrvDO.getId_srv()+"'");
			}
		}
		if (sb.length() > 0) {
			String whereStrRis = "id_srv in (" + sb.substring(1) + ")";
			medSrvRises = imedSrvRisDORService.find(whereStrRis, null, FBoolean.FALSE);
			
			for (MedSrvRisDO ris : medSrvRises) {
				srvRisMap.put(ris.getId_srv(), ris);
			}
			 
		}
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
		//如果医嘱模板配置的科室在执行流向里，取模板配置的科室
		OrWfDeptInfoDTO orWfDeptInfo =null;
		orWfDeptInfo = getMpDeptID(ctx, ciEms,medSrv);
		if (null != orWfDeptInfo) {
			if(ciEms.getId_dep_mp()!=null) {
	            Boolean flag=false;
				for (Object d : orWfDeptInfo.getOrwfexedepts()) {
					OrWfExDeptDTO dp=(OrWfExDeptDTO)d;
					if(ciEms.getId_dep_mp().equals(dp.getId_dept())) {
						ciEms.setName_dep_mp(dp.getName_dept());
						flag=true;
						break;
					}
						
				}
				if(!flag)
			   {
				   ciEms.setId_dep_mp(orWfDeptInfo.getFirstid_mp_dept());
				   ciEms.setName_dep_mp(orWfDeptInfo.getFirstname_mp_dept());
			    }
			}else {
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
		// 设置皮试医嘱标识 ,0506设置皮试标识为Y
		if (IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST.equals(medSrv.getSd_srvtp())) {
			ciEms.setFg_skintest(FBoolean.TRUE);
		}
		
		// 设置服务项目中的执行科室
		for (Object obj : emSrvList) {			
			CiEmsSrvDTO ciEmsSrv = (CiEmsSrvDTO) obj;
			ciEmsSrv.setId_dep(ciEms.getId_dep_mp());
			ciEmsSrv.setName_dep(ciEms.getName_dep_mp());

		}
		
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
				if (!CiOrdUtils.isEmpty(noDrug)  && !mmcounterror.contains(noDrug)) {
					mmcounterror = "服务：" + noDrug.substring(0, noDrug.length() - 1) + "，药房无此药！\r\n";
				}
				if (!CiOrdUtils.isEmpty(stopSale)  && !mmcounterror.contains(stopSale)) {
					mmcounterror += mmcounterror + "服务：" + stopSale.substring(0, stopSale.length() - 1) + "，已停开！\r\n";
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
}
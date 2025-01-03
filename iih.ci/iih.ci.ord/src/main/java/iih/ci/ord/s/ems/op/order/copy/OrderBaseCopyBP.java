package iih.ci.ord.s.ems.op.order.copy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bl.params.BlParams;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.params.CiParams;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.SortEnum;
import iih.ci.ord.s.bp.base.fc.GetOrMpCloseLoopTpBP;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.ci.ord.s.bp.ems.save.ip.CiOrEms2OrAggAndRelInfoBP;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdSrvValidateBP;
import iih.ci.ord.s.bp.ordsrvchangedval.qry.GetMedSrvDOsQry;
import iih.ci.ord.s.bp.quantum.CalDtEffeBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.QuanFirstDayMpBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.bp.validate.skintest.obsolete.SkinTestLogicBP;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvDrugInfoCache;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.op.order.copy.spec.MaterialCopySpec;
import iih.ci.ord.s.ems.utils.CiOrContentUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.utils.meta.DrugOrContentParam;
import iih.ci.ord.s.ems.utils.meta.HerbOrContentParam;
import iih.ci.ord.s.ems.utils.meta.OrContentDTO;
import iih.ci.ord.s.ems.utils.meta.TreatOrContentParam;
import iih.ci.ord.s.utils.GetOrdValidateInfoBP;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 复制基类
 * 
 * @author Young
 *
 */
public class OrderBaseCopyBP {
	// 新医嘱单的申请单号,key为新医嘱主键，value为新申请单号
	protected Map<String, String> mapApplynoTeam;
	// 新医嘱单的申请单号,key为新医嘱主键，value为新申请单号
	protected Map<String, String> mapNewOldKeys;
	//旧医嘱和新复制的医嘱之间的对应关系
	protected Map<String, String> mapIdors;
	private FArrayList errorEmsList;
	//可以保存的医嘱
	private List<CiorderAggDO> ciOrderAggs;
	//可以保存的物品
	private List<OrdSrvMmDO> mmdos;
	private OrderRstDTO orderRstDTO;
	private FMap fmapOldOrd;
	//缓存下Agg数据，用于后续使用
	private Map<String,CiorderAggDO> teampAggs;
	public OrderBaseCopyBP(){
		mapApplynoTeam = new HashMap<String, String>();
		mapNewOldKeys =  new HashMap<String, String>();
		mapIdors = new HashMap<String, String>();
		errorEmsList = new FArrayList();
		ciOrderAggs = new ArrayList<CiorderAggDO>();
		mmdos = new ArrayList<OrdSrvMmDO>();
		teampAggs = new HashMap<String,CiorderAggDO>();
		orderRstDTO = new OrderRstDTO();
		orderRstDTO.setIsSuccess(FBoolean.TRUE);
	}
	/**
	 * 执行复制
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public final OrderRstDTO copy(String[] id_ors, FMap2 extension,FDateTime defDatetime) throws BizException {
		Map<String, String> mapIdorsrvs = new HashMap<String, String>();
		CiorderAggDO[] aggDOs = getCiorderAggDOs(id_ors);
		if (CiOrdUtils.isEmpty(aggDOs))
			return null;
		//0195132: 开立组合定价、服务套模式得服务，费用对照中更改子项数量。复制该服务，子项数量应按最新的带出
		fmapOldOrd = ServiceFinder.find(ICiOrdQryService.class).getCiEmsDTO(id_ors);
		
		FDateTime dt = CiOrdAppUtils.getServerDateTime();// 获得开始时间格式化参数
		setCiorderAggDOs(aggDOs, mapIdors, mapIdorsrvs, dt, extension,defDatetime);
		
		//缓存所有的agg，用于后续处理
		teamAggs(aggDOs);

		OrdSrvMmDO[] ordSrvMmDOs = copyCiorSrvMM(mapIdorsrvs, dt);
		//0186425: 【验证版】住院医嘱，既往调入、复制、医嘱模板开了抗菌药，用药目的不应复制，应该让医生自己选择
		GetSrvDrugInfo(ordSrvMmDOs);
		//旧模式下，皮试判断逻辑（参数：CIOR0486，皮试逻辑使用的模式）
		aggDOs = skinLogic(aggDOs, ordSrvMmDOs);
		// 执行科室，价格等是需要重新计算的，因为有转科的情况
		aggDOs = handleDeptMp(aggDOs, ordSrvMmDOs,false);
		//获取【医嘱流向整体控制】排斥信息
		GetOrdValidateInfoBP bp=new GetOrdValidateInfoBP();
		String errorMsgString=bp.getOrdWhDeptValidateInfo(aggDOs);
		if(!CiOrdUtils.isEmpty(errorMsgString)) {
			this.setErrorInfo(errorMsgString);
			return orderRstDTO;
		}
		//计算非物品本服务定价价格
		handleSrvPrice(aggDOs);
		// 库存判断
		String stockWarn = checkStock(aggDOs, ordSrvMmDOs,false);
		orderRstDTO=returnOrderRstDTO();
		if(!CiOrdUtils.isEmpty(orderRstDTO) && !CiOrdUtils.isEmpty(orderRstDTO.getExtension())) {
			return orderRstDTO;
		}
		aggDOs = ciOrderAggs.toArray(new CiorderAggDO[]{});
		ordSrvMmDOs = mmdos.toArray(new OrdSrvMmDO[]{});
		Map<String, OrdSrvMmDO> mapTeamSrvDOs = new HashMap<String, OrdSrvMmDO>();
		for (OrdSrvMmDO mm : ordSrvMmDOs) {
			mapTeamSrvDOs.put(mm.getId_orsrv(), mm);
		}
		//开单总量单位处理
		dealWithIdPgkuCur(aggDOs,mapTeamSrvDOs);
		orderRstDTO=returnOrderRstDTO();
		if(!CiOrdUtils.isEmpty(orderRstDTO) && !CiOrdUtils.isEmpty(orderRstDTO.getExtension())) {
			return orderRstDTO;
		}
		aggDOs = ciOrderAggs.toArray(new CiorderAggDO[]{});
		//0194829: 用法费用对照、煎法费用对照、关联药袋费
		FMap2 srvinfo=ciOrRelSrvHandle(aggDOs);
		//0196661: 【验证版】复制已经带出被停用的附加费用不应该弹出提示
		aggDOs = srvOpenValidate(aggDOs);
		if(aggDOs==null || aggDOs.length ==0){
			if(errorEmsList!=null && errorEmsList.size() > 0){
				FMap2 error2 = new FMap2();
				error2.put("errorEmsList", errorEmsList);
				orderRstDTO.setIsSuccess(FBoolean.FALSE);
				orderRstDTO.setExtension(error2);
			}
			return orderRstDTO;
		}
		//校验临床申请单中的信息
		validateAppInfo(aggDOs);
		aggDOs = ciOrderAggs.toArray(new CiorderAggDO[]{});
		//处理手动划价
		dealWithHandInputPrice(aggDOs,mapTeamSrvDOs);
		orderRstDTO=returnOrderRstDTO();
		if(!CiOrdUtils.isEmpty(orderRstDTO) && !CiOrdUtils.isEmpty(orderRstDTO.getExtension())) {
			return orderRstDTO;
		}
		aggDOs = ciOrderAggs.toArray(new CiorderAggDO[]{});
		//出院带药患者历史判断使用天数
				if (extension!= null &&  extension.containsKey("Fg_pres_outp")) {
					ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
					if (aggDOs!=null) {
						for (CiorderAggDO ciorderAggDO : aggDOs) {
							OrdSrvDO[] ordSrvDOs = ciorderAggDO.getOrdSrvDO();
							CiOrderDO orderDO = ciorderAggDO.getParentDO();
							if (!orderDO.getSd_srvtp().startsWith("01")) {
								this.setErrorInfo("只能开立药品类医嘱！");
								return orderRstDTO;
							}
							for (OrdSrvDO ordSrvDO : ordSrvDOs) {
								if (ordSrvDO.getSd_nodispense()==null) {//自备
							if (FBoolean.TRUE.equals(ordSrvDO.getFg_self())) {
								ordSrvDO.setFg_self(FBoolean.FALSE);
								ordSrvDO.setFg_bl(FBoolean.TRUE);
							}
							}else{
								ordSrvDO.setFg_self(FBoolean.FALSE);
								ordSrvDO.setFg_bl(FBoolean.TRUE);
								ordSrvDO.setId_nodispense(null);
								ordSrvDO.setName_nodispense(null);
								ordSrvDO.setSd_nodispense(null);
							}
						
							}
							//计算药品总量
							handlerDrugQuanCur(orderDO,ordSrvDOs,ordSrvMmDOs);
							if (orderDO.getDays_or()==null) {
								this.setErrorInfo(orderDO.getName_or()+"的使用天数为空，请填写天数\n");
								CiEmsDTO ciEmsDTO=createCiEmsDTO(ordQryService,ciorderAggDO,false,ordSrvDOs);//创建医疗单
								ciEmsDTO.setFg_pres_outp(FBoolean.TRUE);
								ciEmsDTO.setId_drugdeliverymethod("@@@@Z8100000000UF5XZ");
								ciEmsDTO.setSd_drugdeliverymethod("2");
								ciEmsDTO.setName_drugdeliverymethod("出院带药");
								/*CiOrderDO ciOrderDO = ciorderAggDO.getParentDO();
								ciEmsDTO.setId_emp_stop(ciOrderDO.getId_emp_or());
								ciEmsDTO.setId_dep_stop(ciOrderDO.getId_dep_or());
								ciEmsDTO.setDt_stop(ordo.getDt_entry());*/
								
						
								errorEmsList.add(ciEmsDTO);
								FMap2 error2 = new FMap2();
		
								error2.put("errorEmsList", errorEmsList);
								orderRstDTO.setExtension(error2);
						orderRstDTO.setIsSuccess(FBoolean.FALSE);
						return orderRstDTO;
							}
						}
					}
					
				}
		//医嘱内容
		this.content_or(aggDOs, mapTeamSrvDOs);
		saveCiorSrvMM(ordSrvMmDOs);
		setOrdSortno(aggDOs, aggDOs[0].getParentDO().getId_en(), defDatetime);
		//0191247: 组套项目的子项及价格变更后，从历史里选择变更前的项目带出来仍是未调整的旧项目，导致费用错误
		CiorderAggDO[] aggSaveDOs = saveCiorderAggDOs(aggDOs);
		Map<String, String> mapIdorsrv = new HashMap<String, String>();
		for (CiorderAggDO aggDO : aggSaveDOs) {
			for(OrdSrvDO ordSrvDO : aggDO.getOrdSrvDO()){
				if(ordSrvDO.getId_srv().equals(aggDO.getParentDO().getId_srv())){
					mapIdorsrv.put(aggDO.getParentDO().getId_or(), ordSrvDO.getId_orsrv());
				}
			}
		}
		copyCiorSrvSet(mapIdors, dt, mapIdorsrv);
		copyCiorderAppInfo(mapIdors, dt);
		copySkinTestRst(mapIdors, dt);

		String afterSaveErrorInfo = afterSaveValidate(errorEmsList, aggDOs);
		afterSaveErrorInfo = (afterSaveErrorInfo == null ? stockWarn : (afterSaveErrorInfo += stockWarn));
		
		// 保存后信息完整性校验
		if(errorEmsList!=null && errorEmsList.size() > 0){
			FMap2 error2 = new FMap2();
			error2.put("errorEmsList", errorEmsList);
			orderRstDTO.setExtension(error2);
			if(afterSaveErrorInfo!=null) {//都到这的数据都是至少一个可以复制，一个不可复制，若不拼接 这样就会不提示信息 (都可复制不走这，都不可复制上面已经返回)
				orderRstDTO.setMessageInfo(orderRstDTO.getMessageInfo()+"\r\n"+afterSaveErrorInfo);
			}
			orderRstDTO.setIsSuccess(FBoolean.FALSE);
		} else if (StringUtils.isNotEmpty(afterSaveErrorInfo)) {
			orderRstDTO.setMessageInfo(StringUtils.isEmpty(orderRstDTO.getMessageInfo()) ? afterSaveErrorInfo : orderRstDTO.getMessageInfo() + "\r\n"+afterSaveErrorInfo);
			orderRstDTO.setIsSuccess(FBoolean.FALSE);
		}
		// 返回已保存医嘱
		FArrayList rstList = new FArrayList();
		for (CiorderAggDO orderAggDO : aggDOs) {
			rstList.append(orderAggDO);
		}
		orderRstDTO.setDocument(rstList);
		if(srvinfo!=null&&srvinfo.size()>0) {
			FMap2 extension2=orderRstDTO.getExtension();
			if(extension2==null) {
				extension2=new FMap2();
				this.orderRstDTO.setExtension(extension2);
			}
			extension2.put("RelSrvMessageList", srvinfo);
		}
		return orderRstDTO;
	}
	private void handlerDrugQuanCur(CiOrderDO orderDO, OrdSrvDO[] ordSrvDOs, OrdSrvMmDO[] ordSrvMmDOs) throws BizException {
		if (orderDO.getSd_srvtp().startsWith("01")) {
			String id_mmString="";
			Map<String, OrdSrvMmDO> mapTeamSrvDOs = new HashMap<String, OrdSrvMmDO>();
			for (OrdSrvMmDO mm : ordSrvMmDOs) {
				mapTeamSrvDOs.put(mm.getId_orsrv(), mm);
			}
			List<OrdSrvDO> srvlList=new ArrayList<OrdSrvDO>();//筛选只有物品的ordsrvdo 防止没有物品的
			for(OrdSrvDO ordSrvDO:ordSrvDOs) {
				if(ordSrvDO==null || ordSrvDO.getStatus()==DOStatus.DELETED || !ordSrvDO.getFg_mm().booleanValue() && !orderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					continue;
				}
				OrdSrvMmDO ordSrvMmDO=mapTeamSrvDOs.get(ordSrvDO.getId_orsrv());
				if(ordSrvMmDO==null || ordSrvMmDO.getStatus()==DOStatus.DELETED||CiOrdUtils.isEmpty(ordSrvMmDO.getId_mm())) {
					continue;
				}
				srvlList.add(ordSrvDO);
				id_mmString+=ordSrvMmDO.getId_mm()+CiOrdUtils.COMMA_STR;
			}
			OrdSrvDO[] newOrdSrvDOs=srvlList.toArray(new OrdSrvDO[0]);//只有药品的
			if (id_mmString.length() > 0) {
				id_mmString = id_mmString.substring(0, id_mmString.length() - 1);
			}
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				for (OrdSrvMmDO ordSrvMmDO : ordSrvMmDOs) {
					if (ordSrvMmDO.getId_orsrv()!=null&&ordSrvDO.getId_orsrv().equals(ordSrvMmDO.getId_orsrv())) {
						QuantumParamDTO paramDTO=new QuantumParamDTO(orderDO,ordSrvDO,false);
						
						//该医嘱下 所有物品单位
						MaterialUnitDTO[] materialUnitDTOs=BDMmDoseUnitInfoCache.getMaterialUnitInfos(orderDO.getCode_entp(),id_mmString.split(CiOrdUtils.COMMA_STR));
						if(CiOrdUtils.isEmpty(materialUnitDTOs)) {//没有获取到包装单位
							continue;
						}
						Map<String,List<MaterialUnitDTO>> fMap=new HashMap<String, List<MaterialUnitDTO>>();
						for(MaterialUnitDTO dto:materialUnitDTOs) {
							if(fMap.containsKey(dto.getId_mm())) {
								fMap.get(dto.getId_mm()).add(dto);
							}else {
								List<MaterialUnitDTO> list=new ArrayList<MaterialUnitDTO>();
								list.add(dto);
								fMap.put(dto.getId_mm(),list);
							}
						}

							List<MaterialUnitDTO> materDtos=fMap.get(ordSrvMmDO.getId_mm());
							if(CiOrdUtils.isEmpty(materDtos)) {
								continue;
							}
						paramDTO.setId_unit_sale(materDtos.get(0).getId_measdoc());
						CalQuantumBP bp1=new CalQuantumBP();
						ordSrvMmDO.setQuan_cur(bp1.getMMQuantum(paramDTO));
					}
				}
			}
		}
		
	}
	protected void validateAppInfo(CiorderAggDO[] aggDOs) throws BizException {
		
	}
	/**
	 * 返回需要修改的医疗单
	 * @return
	 * @throws BizException
	 */
	private OrderRstDTO returnOrderRstDTO()throws BizException{
		if(ciOrderAggs.size()==0){
			if(errorEmsList!=null && errorEmsList.size() > 0){
				FMap2 error2 = new FMap2();
				error2.put("errorEmsList", errorEmsList);
				orderRstDTO.setIsSuccess(FBoolean.FALSE);
				orderRstDTO.setExtension(error2);
			}
			return orderRstDTO;
		}
		return orderRstDTO;
	}
	/**
	 * 保存后信息完整性校验
	 * @param aggDOs
	 */
	protected String afterSaveValidate(FArrayList errorEmsList, CiorderAggDO[] aggDOs) throws BizException{
		// 子类重写
		return null;
	}
	/**
	 * 处理手动划价【0183788】
	 * @param aggDOs
	 * @param mapTeamSrvDOs
	 * @throws BizException
	 */
	private void dealWithHandInputPrice(CiorderAggDO[] aggDOs,Map<String, OrdSrvMmDO> mapTeamSrvDOs)throws BizException{
		if(CiOrdUtils.isEmpty(aggDOs)) {
			return;
		}
		for(CiorderAggDO aggDO:aggDOs) {
			ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
			boolean isCanSave = true;//是否可以保存
			CiOrderDO ciOrderDO = aggDO.getParentDO();
			if(CiOrdUtils.isEmpty(ciOrderDO) || DOStatus.DELETED == ciOrderDO.getStatus()) {
				continue;
			}
			OrdSrvDO[] ordSrvDOs = aggDO.getOrdSrvDO();
			if(CiOrdUtils.isEmpty(ordSrvDOs)) {
				continue;
			}
			List<String> canNotSaveId_srv = new ArrayList<String>();//用于记录需要手工划价的medsrv 
			Map<String, OrdSrvDO> map = new HashMap<String, OrdSrvDO>();
			for(OrdSrvDO srvDO:ordSrvDOs) {
				if(CiOrdUtils.isEmpty(srvDO) || srvDO.getStatus()==DOStatus.DELETED) {
					continue;
				}
				//0192851: 【验证版】门急诊医生站，参数BLCG0040设置成false，还是可以从历史里开出0元医嘱
				if(FDouble.ZERO_DBL.equals(srvDO.getPri())) {//手动划价(价格为0需要加 不然门诊诊查费这种虽然是手动 但开立时却带着价格)
					if(srvDO.getEu_blmd() !=null && 1 == (srvDO.getEu_blmd())){
						if(this.orderRstDTO.getMessageInfo() == null) {
							this.setErrorInfo(String.format("%s的划价方式为手工划价，价格不能为0，请修改后进行保存！\r\n",srvDO.getName()));
						}else if(!this.orderRstDTO.getMessageInfo().contains(srvDO.getName())){
							this.setErrorInfo(String.format("%s的划价方式为手工划价，价格不能为0，请修改后进行保存！\r\n",srvDO.getName()));
						}
						isCanSave = false;//只要有一个就不保存
						canNotSaveId_srv.add(srvDO.getId_srv());
						if(!map.containsKey(srvDO.getId_srv())) {//去重 保证一个服务即可
							map.put(srvDO.getId_srv(), srvDO);
						}
					}else{
						if(FBoolean.FALSE.equals(BlParams.BLCG0040()) && srvDO.getId_primd() != null && !IBdPrimdCodeConst.ID_PRI_FREE.equals(srvDO.getId_primd())){
							if(this.orderRstDTO.getMessageInfo() == null) {
								this.setErrorInfo(String.format("【%s】0元医嘱不可开立！\r\n",srvDO.getName()));
							}else if(!this.orderRstDTO.getMessageInfo().contains(srvDO.getName())){
								this.setErrorInfo(String.format("【%s】0元医嘱不可开立！\r\n",srvDO.getName()));
							}
							isCanSave = false;//只要有一个就不保存
							canNotSaveId_srv.add(srvDO.getId_srv());
							if(!map.containsKey(srvDO.getId_srv())) {//去重 保证一个服务即可
								map.put(srvDO.getId_srv(), srvDO);
							}
						}
					}
				}
			}
			if(isCanSave) {
				if(!ciOrderAggs.contains(aggDO)){
					ciOrderAggs.add(aggDO);
				}
			}else {
				if(ciOrderAggs.contains(aggDO)){
					ciOrderAggs.remove(aggDO);
				}
				CiEmsDTO ciEmsDTO = createCiEmsDTO(ordQryService,aggDO,false,ordSrvDOs);//创建医疗单
				//设置对应服务的价格为0
				FArrayList srvsList = ciEmsDTO.getEmssrvs();
				if(!CiOrdUtils.isEmpty(srvsList)) {
					for(int i=0;i<srvsList.size();i++) {
						CiEmsSrvDTO ciEmsSrvDTO = (CiEmsSrvDTO)ciEmsDTO.getEmssrvs().get(i);
						if(!CiOrdUtils.isEmpty(ciEmsSrvDTO) && !CiOrdUtils.isEmpty(canNotSaveId_srv)) {
							for(String idsrv:canNotSaveId_srv) {
								if(idsrv.equals(ciEmsSrvDTO.getId_srv())) {//考虑多服务情况
									ciEmsSrvDTO.setPrice(new FDouble(0));//清空价格 手动输入 
									ciEmsSrvDTO.setId_primd(map.get(idsrv).getId_primd());//定价模式不返回 会导致已经复制出来的医嘱 再多次复制时不提示手动划价信息
								}
							}
						}
					}
				}
				ciEmsDTO.setEmssrvs(srvsList);
				MedSrvDO[] medSrvDOs = getMedSrvDOs(canNotSaveId_srv);
				if(!CiOrdUtils.isEmpty(medSrvDOs)) {
					ciEmsDTO.setIsmuldose(medSrvDOs[0].getIsmuldose());//多剂量 不设置该值会导致返回的医疗部分列隐藏
					ciEmsDTO.setIsmulexec(medSrvDOs[0].getIsmulexec());//多频次
				}
				errorEmsList.append(ciEmsDTO);
				this.mapIdors.remove(mapNewOldKeys.get(aggDO.getParentDO().getId_or()));
			}
		}
	}
	/**
	 * 获取服务
	 * @param idSrvList
	 * @return
	 * @throws BizException
	 */
	public MedSrvDO[] getMedSrvDOs(List<String> idSrvList) throws BizException {
		MedSrvDO[] rtn = null;
		if (idSrvList != null && idSrvList.size() > 0) {
			GetMedSrvDOsQry qry = new GetMedSrvDOsQry(idSrvList);
			rtn = (MedSrvDO[]) AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
		}

		return rtn;
	}
	/**
	 * 皮试旧模式下皮试判断逻辑
	 * @param aggDOs
	 * @param ordSrvMmDOs
	 * @throws BizException
	 */
	private CiorderAggDO[] skinLogic(CiorderAggDO[] aggDOs, OrdSrvMmDO[] ordSrvMmDOs) throws BizException {
		if(ordSrvMmDOs == null || ordSrvMmDOs.length == 0 ||"1".equals(CiParams.CIOR0486())){
			return aggDOs;
		}
		List<CiorderAggDO> aggList = new ArrayList<CiorderAggDO>();
		for (CiorderAggDO aggDO : aggDOs) {
			aggList.add(aggDO);
			OrdSrvDO[] ordSrvDOs = aggDO.getOrdSrvDO();
			if (CiOrdUtils.isEmpty(ordSrvDOs))
				continue;
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				//旧模式处理模式
				if(FBoolean.TRUE.equals(ordSrvDO.getFg_skintest()) && FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
					for (OrdSrvMmDO ordSrvMmDO : ordSrvMmDOs) {
						if (ordSrvMmDO.getId_orsrv().equals(ordSrvDO.getId_orsrv())) {
							ordSrvDO.setId_mm(ordSrvMmDO.getId_mm());
							break;
						}
					}
					if(CiOrdUtils.isEmpty(ordSrvDO.getId_mm()))
					{
						continue;
					}
				
					String errorInfo = SkinTestLogicBP.CheckSrvSkinLogic(ordSrvDO, null);
					if(!CiOrdUtils.isEmpty(errorInfo)){
						if(aggList.contains(aggDO)){
							aggList.remove(aggDO);
						}
						this.setErrorInfo(errorInfo);
					}
				}
			}
		}
		return aggList.toArray(new CiorderAggDO[0]);
	}
	/**
	/**
	 * 处理开单总量单位
	 * 0181454: 【兰陵人民】门急诊医生站，调用历史处方或模板时，如果药品的包装单位已经停用，请提示修改，不允许签署
	 * @param aggDOs
	 * @param ordSrvMmDOs
	 * @throws BizException
	 */
	private String dealWithIdPgkuCur(CiorderAggDO[] aggDOs,Map<String, OrdSrvMmDO> mapTeamSrvDOs)throws BizException{
		String errorString="";
		if (CiOrdUtils.isEmpty(aggDOs)||CiOrdUtils.isEmpty(mapTeamSrvDOs)) {
			return null;
		}
		//1.获取参数
		String paramString="";
		paramString=getDealWithUnitParam(paramString);
		//2.获取药品基本信息处的包装单位
		for(CiorderAggDO ciorderAggDO:aggDOs) {
			Map<String, String[]> mapParams = new HashMap<String, String[]>();
			boolean isCanSave=true;
			CiOrderDO ciOrderDo = ciorderAggDO.getParentDO();
			if(ciOrderDo == null || ciOrderDo.getStatus()==DOStatus.DELETED || !ciOrderDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				continue;
			}
			String code_entp=ciOrderDo.getCode_entp();
			OrdSrvDO[] ordSrvDOs=ciorderAggDO.getOrdSrvDO();
			if(CiOrdUtils.isEmpty(ordSrvDOs)) {
				continue;
			}
			ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
			String id_mmString="";
			List<OrdSrvDO> srvlList=new ArrayList<OrdSrvDO>();//筛选只有物品的ordsrvdo 防止没有物品的
			for(OrdSrvDO ordSrvDO:ordSrvDOs) {
				if(ordSrvDO==null || ordSrvDO.getStatus()==DOStatus.DELETED || !ordSrvDO.getFg_mm().booleanValue() && !ciOrderDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					continue;
				}
				OrdSrvMmDO ordSrvMmDO=mapTeamSrvDOs.get(ordSrvDO.getId_orsrv());
				if(ordSrvMmDO==null || ordSrvMmDO.getStatus()==DOStatus.DELETED||CiOrdUtils.isEmpty(ordSrvMmDO.getId_mm())) {
					continue;
				}
				srvlList.add(ordSrvDO);
				id_mmString+=ordSrvMmDO.getId_mm()+CiOrdUtils.COMMA_STR;
			}
			OrdSrvDO[] newOrdSrvDOs=srvlList.toArray(new OrdSrvDO[0]);//只有药品的
			if (id_mmString.length() > 0) {
				id_mmString = id_mmString.substring(0, id_mmString.length() - 1);
			}
			//该医嘱下 所有物品单位
			MaterialUnitDTO[] materialUnitDTOs=BDMmDoseUnitInfoCache.getMaterialUnitInfos(code_entp,id_mmString.split(CiOrdUtils.COMMA_STR));
			if(CiOrdUtils.isEmpty(materialUnitDTOs)) {//没有获取到包装单位
				continue;
			}
			//构建map集合{id_mm,{MaterialUnitDTO1,MaterialUnitDTO2,MaterialUnitDTO3}}
			Map<String,List<MaterialUnitDTO>> fMap=new HashMap<String, List<MaterialUnitDTO>>();
			for(MaterialUnitDTO dto:materialUnitDTOs) {
				if(fMap.containsKey(dto.getId_mm())) {
					fMap.get(dto.getId_mm()).add(dto);
				}else {
					List<MaterialUnitDTO> list=new ArrayList<MaterialUnitDTO>();
					list.add(dto);
					fMap.put(dto.getId_mm(),list);
				}
			}
			for(OrdSrvDO ordSrvDO:newOrdSrvDOs) {
				OrdSrvMmDO ordSrvMmDO=mapTeamSrvDOs.get(ordSrvDO.getId_orsrv());
				List<MaterialUnitDTO> materDtos=fMap.get(ordSrvMmDO.getId_mm());
				if(CiOrdUtils.isEmpty(materDtos)) {
					continue;
				}
				String unitString="";
				for(MaterialUnitDTO dto:materDtos) {
					if(dto!=null && dto.getId_mm().equals(ordSrvMmDO.getId_mm())) {
						unitString+=dto.getId_measdoc()+CiOrdUtils.COMMA_STR;
					}
				}
				if(ordSrvMmDO.getId_pgku_cur()!=null &&!CiOrdUtils.isEmpty(unitString)&&unitString.contains(ordSrvMmDO.getId_pgku_cur())) {//
					//2.1可用(没变或者优先级变了)，不做处理，取之前的
					continue;
				}
				if(ordSrvMmDO.getId_pgku_cur()!=null &&!CiOrdUtils.isEmpty(unitString)&&!unitString.contains(ordSrvMmDO.getId_pgku_cur())) {
					//门诊
					if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)||IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)) {
						//2.2不可用 (0或者或者没维护或者删了)
						if("1".equals(paramString)) {
							//2.2.1【门诊总量编辑控制模式】=1，可编辑，清空总量，并提示【XXXX，药品总量单位已修改，请重新录入总量】
					    	isCanSave=false;
							if(this.orderRstDTO.getMessageInfo()==null) {
								this.setErrorInfo(String.format("%s药品单位已修改，请重新录入数量\r\n",ordSrvDO.getName()));
							}else if(!this.orderRstDTO.getMessageInfo().contains(ordSrvDO.getName())){
								this.setErrorInfo(String.format("%s药品单位已修改，请重新录入数量\r\n",ordSrvDO.getName()));
							}
						}else {
							//2.2.2【门诊总量编辑控制模式】=0，不可编辑，重新计算数据id_pgku_cur、 price_pgku_cur 、quan_cur 、factor
							ordSrvMmDO.setId_pgku_cur(materDtos.get(0).getId_measdoc());
							ordSrvMmDO.setFactor(materDtos.get(0).getFactor());
							CalQuantumBP bp=new CalQuantumBP();
							ordSrvDO.setId_mm(ordSrvMmDO.getId_mm());
							QuantumParamDTO paramDTO=new QuantumParamDTO(ciOrderDo,ordSrvDO,false);
							paramDTO.setId_unit_sale(materDtos.get(0).getId_measdoc());
							ordSrvMmDO.setQuan_cur(bp.getMMQuantum(paramDTO));
							ordSrvDO.setQuan_total_medu(ordSrvMmDO.getQuan_cur());
							//构建查询价格参数
							constractPriceParam(mapParams,ordSrvMmDO,ordSrvDO);
						}
					}
					if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)||IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)) {//住院
						//在院整领
						if(ciOrderDo.getFg_wholepack().booleanValue()) {
							//算总量 直接返回医疗单
							isCanSave=false;
							if(this.orderRstDTO.getMessageInfo()==null) {
								this.setErrorInfo(String.format("%s药品单位已修改，请重新录入数量\r\n",ordSrvDO.getName()));
							}else if(!this.orderRstDTO.getMessageInfo().contains(ordSrvDO.getName())){
								this.setErrorInfo(String.format("%s药品单位已修改，请重新录入数量\r\n",ordSrvDO.getName()));
							}
						}else {//不是在院整领
							//算总量 毒麻、草药
							if(!(ordSrvMmDO.getSd_pois() == null || ordSrvMmDO.getSd_pois().equals("0"))||ordSrvDO.getSd_srvtp().startsWith("0103")) {
								ordSrvMmDO.setId_pgku_cur(materDtos.get(0).getId_measdoc());
								ordSrvMmDO.setFactor(materDtos.get(0).getFactor());
								CalQuantumBP bp=new CalQuantumBP();
								ordSrvDO.setId_mm(ordSrvMmDO.getId_mm());
								QuantumParamDTO paramDTO=new QuantumParamDTO(ciOrderDo,ordSrvDO,false);
								paramDTO.setId_unit_sale(materDtos.get(0).getId_measdoc());
								ordSrvMmDO.setQuan_cur(bp.getMMQuantum(paramDTO));
								ordSrvDO.setQuan_total_medu(ordSrvMmDO.getQuan_cur());
							}else {//不算总量
								ordSrvMmDO.setId_pgku_cur(materDtos.get(0).getId_measdoc());
								ordSrvMmDO.setFactor(materDtos.get(0).getFactor());
								ordSrvDO.setId_mm(ordSrvMmDO.getId_mm());
							}
							//构建查询价格参数
							constractPriceParam(mapParams,ordSrvMmDO,ordSrvDO);
						}
					}
				}
			}
			
			if(isCanSave) {
				if(!ciOrderAggs.contains(ciorderAggDO)){
					ciOrderAggs.add(ciorderAggDO);
				}
				if (!mapParams.isEmpty()) {//不返回的医嘱重新计算价格
					Map<String,MaterialStockDTO> materialDoMap = new HashMap<String,MaterialStockDTO>();
					CiOrdUtils.ValidateDrugCountRstMap(mapParams,materialDoMap);
					for (OrdSrvDO srvdo : newOrdSrvDOs) {
						OrdSrvMmDO ordSrvMmDO=mapTeamSrvDOs.get(srvdo.getId_orsrv());
						MaterialStockDTO materialStockDTO = materialDoMap.get(ordSrvMmDO.getId_mm());
						if(materialStockDTO != null){
							ordSrvMmDO.setPrice_pgku_cur(materialStockDTO.getPrice_act());
							srvdo.setPri(materialStockDTO.getPrice_act());
						}
					}
				}
			}else {
				mapParams.clear();
				if(ciOrderAggs.contains(ciorderAggDO)){
					ciOrderAggs.remove(ciorderAggDO);
				}
				CiEmsDTO ciEmsDTO=createCiEmsDTO(ordQryService,ciorderAggDO,false,ordSrvDOs);//创建医疗单
				FArrayList emssrvs = ciEmsDTO.getEmssrvs();
				for(Object obj : emssrvs){
					CiEmsSrvDTO emssrv = (CiEmsSrvDTO)obj;
					if(emssrv==null || emssrv.getStatus()==DOStatus.DELETED||!emssrv.getFg_mm().booleanValue()||!emssrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {//药品的进行判断，假如不是药品的不管
						continue;
					}
					List<MaterialUnitDTO> dtos=fMap.get(emssrv.getId_mm());
					if(!CiOrdUtils.isEmpty(dtos)) {
						String idString="";
						for(MaterialUnitDTO dto:dtos) {
							idString+=dto.getId_measdoc()+CiOrdUtils.COMMA_STR;
						}
						if(idString.contains(emssrv.getId_unit_sale())) {
							//原单位还可用
							continue;
						}
						//原单位变了 重新赋值
						emssrv.setName_unit_sale(dtos.get(0).getMeasdoc_name());
						emssrv.setId_unit_sale(dtos.get(0).getId_measdoc());
						emssrv.setFactor_cb(dtos.get(0).getFactor());
						emssrv.setQuan_cur(FDouble.ZERO_DBL);
						
						//构建查询价格参数
						String[] params = new String[5];
						String keyId = CiOrdUtils.getKeyId(emssrv.getId_mm(), emssrv.getId_dep_wh(), emssrv.getId_unit_sale());
						if (!CiOrdUtils.isEmpty(keyId)) {
							mapParams.put(keyId, params);
							params[0] = emssrv.getId_mm();
							params[1] = emssrv.getId_dep_wh();
							params[2] = emssrv.getId_unit_sale();
							params[3] = emssrv.getName_srv();
							params[4] = emssrv.getQuan_cur() == null ? "0" : emssrv.getQuan_cur().toString();
						}
					}
				}
				if (!mapParams.isEmpty()) {//返回的医疗单重新计算价格
					Map<String,MaterialStockDTO> materialDoMap = new HashMap<String,MaterialStockDTO>();
					CiOrdUtils.ValidateDrugCountRstMap(mapParams,materialDoMap);
					for(Object obj : emssrvs){
						CiEmsSrvDTO emssrv = (CiEmsSrvDTO)obj;
						if(emssrv==null || emssrv.getStatus()==DOStatus.DELETED||!emssrv.getFg_mm().booleanValue()||!emssrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {//药品的进行判断，假如不是药品的不管
							continue;
						}
						MaterialStockDTO materialStockDTO = materialDoMap.get(emssrv.getId_mm());
						if(materialStockDTO != null){
							emssrv.setPrice(materialStockDTO.getPrice_act());
							emssrv.setPrice_cur(materialStockDTO.getPrice_act());
						}
					}
				}
				errorEmsList.append(ciEmsDTO);
				this.mapIdors.remove(mapNewOldKeys.get(ciorderAggDO.getParentDO().getId_or()));
			}
		}
		return errorString;
	}
	/**
	 * 构建价格查询参数
	 * @param mapParams
	 * @param ordSrvMmDO
	 * @param ordSrvDO
	 * @throws BizException
	 */
	private void constractPriceParam(Map<String, String[]> mapParams,OrdSrvMmDO ordSrvMmDO,OrdSrvDO ordSrvDO)throws BizException{
		String[] params = new String[5];
		String keyId = CiOrdUtils.getKeyId(ordSrvMmDO.getId_mm(), ordSrvDO.getId_dep_wh(), ordSrvMmDO.getId_pgku_cur());
		if (!CiOrdUtils.isEmpty(keyId)) {
			mapParams.put(keyId, params);
			params[0] = ordSrvMmDO.getId_mm();
			params[1] = ordSrvDO.getId_dep_wh();
			params[2] = ordSrvMmDO.getId_pgku_cur();
			params[3] = ordSrvDO.getName();
			params[4] = ordSrvMmDO.getQuan_cur() == null ? "0" : ordSrvMmDO.getQuan_cur().toString();
		}
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
	 * 计算服务中非药品且是本服务定价的服务
	 * @param aggDOs
	 * @throws BizException 
	 */
	private void handleSrvPrice(CiorderAggDO[] aggDOs) throws BizException {
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		for (CiorderAggDO ciorderAggDO : aggDOs) {
			
			OrdSrvDO[] ordSrvDOs = ciorderAggDO.getOrdSrvDO();
			
			OrdSrvDO mainSrv = this.getMainSrvDO(ordSrvDOs, ciorderAggDO.getParentDO().getId_srv());
			Map<String,PriStdSrvDTO> priStdSrvMap = new HashMap<String,PriStdSrvDTO>();
			if(mainSrv != null && IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(mainSrv.getId_primd())){
				PriStdSrvDTO[] priStdSrvs = CiOrSrvPriCalUtils.CalSrvCompPrice(mainSrv.getId_srv());
				if(priStdSrvs != null && priStdSrvs.length >0){
					for (PriStdSrvDTO priStdSrvDTO : priStdSrvs) {
						priStdSrvMap.put(priStdSrvDTO.getId_srv(), priStdSrvDTO);
					}
				}
			}
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				if (!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())&&IBdPrimdCodeConst.ID_PRI_SRV.equals(ordSrvDO.getId_primd())) {
					if(priStdSrvMap.containsKey(ordSrvDO.getId_srv())){
						ordSrvDO.setPri(priStdSrvMap.get(ordSrvDO.getId_srv()).getPrice());
					}else{
						MedSrvPriceDO calculatePrice = OrderEmsPriceUtils.calculatePrice(ordSrvDO.getId_srv(), ordSrvDO.getId_primd(), context.getId_pripat());
						if (calculatePrice!=null&&calculatePrice.getPrice_ratio()!=null) {
							ordSrvDO.setPri(calculatePrice.getPrice_ratio());
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * 缓存所有的agg，用于后续处理
	 * @param aggDOs
	 */
	private void teamAggs(CiorderAggDO[] aggDOs) {
		for (CiorderAggDO ciorderAggDO : aggDOs) {
			teampAggs.put(ciorderAggDO.getParentDO().getId_or(), ciorderAggDO);
		}
	}
	
	/**
	 * 校验库存，有异常的医嘱组装成CiEmsDTO后返回前台处理
	 * 
	 * @param ordSrvDOs
	 * @param ordSrvMmDOs
	 * @param isAddExt 是否是加顿
	 * @throws BizException
	 */
	private String checkStock(CiorderAggDO[] aggDOs, OrdSrvMmDO[] ordSrvMmDOs,boolean isAddExt) throws BizException {
		if (ordSrvMmDOs == null || ordSrvMmDOs.length == 0) {
			for(CiorderAggDO aggdo : aggDOs){
				if(!ciOrderAggs.contains(aggdo)){
					ciOrderAggs.add(aggdo);
				}
			}
			return null;
		}
		if(aggDOs == null || aggDOs.length == 0){
			return null;
		}
		
		
		ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
		
		// 部分药品没有库存（停用）时，给出提示，其余药品正常保存
		StringBuilder stockCheckWarn = new StringBuilder();
		for (CiorderAggDO aggdo : aggDOs) {
			boolean isCanSave = true;
			Map<String, String[]> mapParams = new HashMap<String, String[]>();
			OrdSrvDO[] ordSrvDOs = aggdo.getOrdSrvDO();
			OrdSrvDO mainSrvDO = getMainSrvDO(ordSrvDOs,aggdo.getParentDO().getId_srv());
			List<OrdSrvMmDO> materialList = new ArrayList<>(); 
			if(mainSrvDO == null){
				if(!ciOrderAggs.contains(aggdo)){
					ciOrderAggs.add(aggdo);
				}
				continue;
			}
			for (OrdSrvDO srvdo : ordSrvDOs) {
				if(StringUtils.isEmpty(srvdo.getId_dep_mp())){
					this.setErrorInfo(String.format("【%s】没有匹配到执行科室，保存医嘱失败",srvdo.getName()));
					isCanSave = false;
					continue; 
				}
			}
			//组合定价不用判断库存
			if(IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(mainSrvDO.getId_primd())){
				//0179454:复制组合计价包含的药品 ci_srv_mm表没有插入数据   liyue
				for (OrdSrvMmDO srvMM : ordSrvMmDOs) {
					if(!mmdos.contains(srvMM))
						mmdos.add(srvMM);
				}
				if(!ciOrderAggs.contains(aggdo)){
					ciOrderAggs.add(aggdo);
				}
				continue;
			}
			for (OrdSrvDO srvdo : ordSrvDOs) {
				OrdSrvMmDO mmdo = null;
				for (OrdSrvMmDO srvMM : ordSrvMmDOs) {
					if (srvMM.getId_orsrv().equals(srvdo.getId_orsrv())) {
						mmdo = srvMM;
						break;
					}
				}
				if (mmdo == null) {
					continue;
				}
				//0186425: 【验证版】住院医嘱，既往调入、复制、医嘱模板开了抗菌药，用药目的不应复制，应该让医生自己选择
				if(FBoolean.TRUE.equals(srvdo.getFg_mm()) && !IBdSrvDictCodeConst.SD_ANTI_NONANTIBACTERIAL.equals(mmdo.getSd_anti())){
					this.setErrorInfo(String.format("【%s】是抗菌药，需要选择“用药目的”，保存医嘱失败\r\n",mmdo.getName_mm()));
					isCanSave = false;
					mapParams.clear();
					break;
				}
				//自备药不进行库存校验
				if (FBoolean.TRUE.equals(srvdo.getFg_self())) {
					mmdos.add(mmdo);
					continue;
				}
				if(FBoolean.TRUE.equals(srvdo.getFg_mm()) && StringUtils.isEmpty(srvdo.getId_dep_wh())){
					this.setErrorInfo(String.format("【%s】没有匹配到物资仓库，保存医嘱失败",srvdo.getName()));
					isCanSave = false;
					mapParams.clear();
					break;
				}
				
				String[] params = new String[5];
				String keyId = CiOrdUtils.getKeyId(mmdo.getId_mm(), srvdo.getId_dep_wh(), mmdo.getId_pgku_cur());
				if (!CiOrdUtils.isEmpty(keyId)) {
					mapParams.put(keyId, params);
					params[0] = mmdo.getId_mm();
					params[1] = srvdo.getId_dep_wh();
					params[2] = mmdo.getId_pgku_cur();
					params[3] = srvdo.getName();
					params[4] = mmdo.getQuan_cur() == null ? "0" : mmdo.getQuan_cur().toString();
					materialList.add(mmdo);
				}
			}
			
			if (!mapParams.isEmpty()) {
				Map<String,MaterialStockDTO> materialDoMap = new HashMap<String,MaterialStockDTO>();
				Map<String,String> refusedMap = CiOrdUtils.ValidateDrugCountRstMap(mapParams,materialDoMap);
				// 检查药品是否停用或停开
				Map<String, MeterialDO> stopMaterialMap = MaterialCopySpec.checkStopMaterial(materialList, ordSrvDOs, aggdo.getParentDO());
				// 没有库存（停用）药品列表
				List<OrdSrvMmDO> noStockList = new ArrayList<>();
				for (OrdSrvDO srvdo : ordSrvDOs) {
					OrdSrvMmDO mmdo = null;
					for (OrdSrvMmDO srvMM : ordSrvMmDOs) {
						if (srvMM.getId_orsrv().equals(srvdo.getId_orsrv())) {
							mmdo = srvMM;
							break;
						}
					}
					if (mmdo == null) {
						continue;
					}
					MaterialStockDTO materialStockDTO = materialDoMap.get(mmdo.getId_mm());
					if(materialStockDTO != null){
						mmdo.setPrice_pgku_cur(materialStockDTO.getPrice_act());
						srvdo.setPri(materialStockDTO.getPrice_act());
					}
					String keyId = CiOrdUtils.getKeyId(mmdo.getId_mm(), srvdo.getId_dep_wh(), mmdo.getId_pgku_cur());
					if (refusedMap.containsKey(keyId) || stopMaterialMap.containsKey(mmdo.getId_mm())) {
					    // 如果该药品没有库存
					    noStockList.add(mmdo);
					} else {
						if (!mmdos.contains(mmdo)) {
						mmdos.add(mmdo);
					}
				}
			}
				
				// 过滤没有库存或停用的项目
				isCanSave = MaterialCopySpec.filterNoStockItems(ordSrvMmDOs, stockCheckWarn, aggdo, ordSrvDOs, noStockList, refusedMap, orderRstDTO);
			}
			
			// 判断是否能保存
			if(isCanSave){
				if(!ciOrderAggs.contains(aggdo)){
					ciOrderAggs.add(aggdo);
				}
			}else{
				CiEmsDTO ciEmsDTO=createCiEmsDTO(ordQryService,aggdo,isAddExt,ordSrvDOs);//创建医疗单
				errorEmsList.append(ciEmsDTO);
				this.mapIdors.remove(mapNewOldKeys.get(aggdo.getParentDO().getId_or()));
			}
		}
		return stockCheckWarn.toString();
	}
	
	protected CiEmsDTO createCiEmsDTO(ICiOrdQryService ordQryService,CiorderAggDO aggdo,boolean isAddExt,OrdSrvDO[] ordSrvDOs)throws BizException{
		CiEmsDTO ciEmsDTO = ordQryService.getCiEmsDTO_TL(mapNewOldKeys.get(aggdo.getParentDO().getId_or()));
		ciEmsDTO.setTimes_firday_mp(null);
		ciEmsDTO.setSd_su_or("0");
		ciEmsDTO.setStatus(DOStatus.NEW);
		ciEmsDTO.setId_or(null);
		ciEmsDTO.setId_dep_mp(aggdo.getParentDO().getId_dep_mp());
		ciEmsDTO.setName_dep_mp(aggdo.getParentDO().getName_dep_mp());
		ciEmsDTO.setFg_urgent(aggdo.getParentDO().getFg_urgent());
		//	0193037: 门急诊医生站通过患者就诊历史复制医嘱问题
		FDateTime tm = CalDtEffeBP.GetDtEffe(aggdo.getParentDO().getId_freq());
		ciEmsDTO.setDt_begin(tm);
		//ciEmsDTO.setDt_begin(CiOrdAppUtils.getServerDateTime());
		if(isAddExt){
			ciEmsDTO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			ciEmsDTO.setFg_long(FBoolean.FALSE);
			ciEmsDTO.setName_freq("一次");
			FArrayList emssrvs = ciEmsDTO.getEmssrvs();
			for(Object obj : emssrvs){
				CiEmsSrvDTO emssrv = (CiEmsSrvDTO)obj;
				emssrv.setId_or(null);
				emssrv.setId_orsrv(null);
				emssrv.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
				for(OrdSrvDO srv : ordSrvDOs){
					if(srv.getId_srv().equals(emssrv.getId_srv())){
						emssrv.setId_dep(srv.getId_dep_mp());
						emssrv.setName_dep(srv.getDep_mp_name());
						emssrv.setId_dep_wh(srv.getId_dep_wh());
						emssrv.setName_dep_wh(srv.getName_dep_wh());
						break;
					}
				}
			}
			ciEmsDTO.setDt_end(ciEmsDTO.getDt_begin());
		}else{
			if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciEmsDTO.getCode_entp())){
				if(ciEmsDTO.getDays_or()!=null){
					ciEmsDTO.setDt_end(ciEmsDTO.getDt_begin()
							.addSeconds(ciEmsDTO.getDays_or() != null ? ciEmsDTO.getDays_or() * 24 * 3600 : 0));
				}else{
					ciEmsDTO.setDt_end(null);
				}
			}else{
				if (!CiOrdUtils.isTrue(ciEmsDTO.getFg_long())||ciEmsDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					ciEmsDTO.setDt_end(ciEmsDTO.getDt_begin());
				}else{
					ciEmsDTO.setDt_end(null);
					ciEmsDTO.setDays_or(null);
				}
			}
			
			FArrayList emssrvs = ciEmsDTO.getEmssrvs();
			for(Object obj : emssrvs){
				CiEmsSrvDTO emssrv = (CiEmsSrvDTO)obj;
				emssrv.setId_or(null);
				emssrv.setId_orsrv(null);
				for(OrdSrvDO srv : ordSrvDOs){
					if(srv.getId_srv().equals(emssrv.getId_srv())){
						emssrv.setId_dep(srv.getId_dep_mp());
						emssrv.setName_dep(srv.getDep_mp_name());
						emssrv.setId_dep_wh(srv.getId_dep_wh());
						emssrv.setName_dep_wh(srv.getName_dep_wh());
						//0190509: 【验证版】门急诊医生站，患者历史既往调入皮试药，选择了“续用”，但是医疗单里皮试标识还是true
						emssrv.setFg_skintest(srv.getFg_skintest());
						//0192176: 【验证版】住院医生站，住院医嘱，既往调入、复制、医嘱模板开了抗菌药，用药目的不应复制
						if(FBoolean.TRUE.equals(emssrv.getFg_mm()) && !IBdSrvDictCodeConst.SD_ANTI_NONANTIBACTERIAL.equals(emssrv.getSd_anti())){
							emssrv.setFg_propc(null);
						}
						// 如果需要皮试，则不复制关联医嘱id，否则不会自动生成皮试医嘱
						if (FBoolean.TRUE.equals(emssrv.getFg_skintest()) && "1".equals(emssrv.getSd_reltp())) {
						    emssrv.setId_or_rel(null);
						}
						emssrv.setId_nodispense(srv.getId_nodispense());
						emssrv.setSd_nodispense(srv.getSd_nodispense());
						break;
					}
				}
			}
		}
		return ciEmsDTO;
	}
	/**
	 * 设置医嘱的排序号
	 * 
	 * @param szOrderInfo
	 * @param id_en
	 * @throws BizException
	 */
	protected void setOrdSortno(CiorderAggDO[] aggDOs, String id_en,FDateTime Dt_effe) throws BizException {
		String qryMaxSortno = "select max(nvl(sortno,0)) from ci_order where id_en = '" + id_en + "'";
		//设置时间
		Integer result = (Integer) new DAFacade().execQuery(qryMaxSortno, new ColumnHandler());
		if (result == null) {
			result = 0;
		}
		for (CiorderAggDO aggDO : aggDOs) {
			aggDO.getParentDO().setSortno(++result);
			if(Dt_effe !=null) {
				aggDO.getParentDO().setDt_effe(Dt_effe);
			}
		}
	}

	/**
	 * 重新计算执行科室
	 * @param aggDOs
	 * @param ordSrvMmDOs
	 * @param isUseNewDeps 是否使用新的科室
	 * @throws BizException
	 */
	protected CiorderAggDO[] handleDeptMp(CiorderAggDO[] aggDOs, OrdSrvMmDO[] ordSrvMmDOs,boolean isUseNewDeps) throws BizException {
		List<CiorderAggDO> aggs = new ArrayList<CiorderAggDO>();
		C:for (CiorderAggDO aggdo : aggDOs) {
			aggs.add(aggdo);
			CiOrderDO ciOrderDo = aggdo.getParentDO();
			OrWfDeptInfoDTO orWfDept = getExeWfDept(ciOrderDo);
			if (orWfDept != null) {
				//判断原医嘱的执行科室是否在返回的最新计算的医嘱流向中，如果不存在则修改为Firstid_mp_dept的值
				if(isUseNewDeps||StringUtils.isEmpty(ciOrderDo.getId_dep_mp())||(StringUtils.isNotEmpty(orWfDept.getId_mp_depts())&&!orWfDept.getId_mp_depts().contains(ciOrderDo.getId_dep_mp()))){
					ciOrderDo.setId_dep_mp(orWfDept.getFirstid_mp_dept());
					ciOrderDo.setName_dep_mp(aggdo.getParentDO().getName_dep_mp());
				}
			}
			OrdSrvDO[] ordSrvDOs = aggdo.getOrdSrvDO();
			for (OrdSrvDO ordSrv : ordSrvDOs) {
				//检查和检验，组合定价，直接取医嘱的流向
				if((StringUtils.isNotEmpty(ciOrderDo.getSd_srvtp())&&(ciOrderDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
						||ciOrderDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)))||IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(ordSrvDOs[0].getId_primd())){
					ordSrv.setId_dep_mp(ciOrderDo.getId_dep_mp());
					ordSrv.setDep_mp_name(ciOrderDo.getName_dep_mp());
				}else{
					String id_dep_mp_main = null;
					if(FBoolean.TRUE.equals(ciOrderDo.getFg_set())){
						id_dep_mp_main = ciOrderDo.getId_dep_mp();
					}
					OrWfDeptInfoDTO orWfDeptSrv = getExeWfDept(ciOrderDo, ordSrv, ordSrvMmDOs,id_dep_mp_main);
					if(StringUtils.isEmpty(orWfDeptSrv.getId_mp_depts())){
						//将执行科室置空
						ordSrv.setId_dep_mp(null);
						ordSrv.setDep_mp_name(null);
//						if(aggs.contains(aggdo)){
//							aggs.remove(aggdo);
//						}
//						this.setErrorInfo(String.format("【%s】没有匹配到执行科室，保存医嘱失败",ordSrv.getName()));
						continue C; 
					}
					if(FBoolean.TRUE.equals(ordSrv.getFg_mm()) && StringUtils.isEmpty(orWfDeptSrv.getId_dept_whs())){
						//将药房置空
						ordSrv.setId_dep_wh(null);
						ordSrv.setName_dep_wh(null);
//						if(aggs.contains(aggdo)){
//							aggs.remove(aggdo);
//						}
//						this.setErrorInfo(String.format("【%s】没有匹配到物资仓库，保存医嘱失败",ordSrv.getName()));
						continue C; 
					}
					//判断原医嘱的执行科室是否在返回的最新计算的医嘱流向中，如果不存在则修改为Firstid_mp_dept的值
					//0177568 liyuelong 2019/12/9 修改：执行科室，物资科室空判断
					if(isUseNewDeps||(StringUtils.isNotEmpty(orWfDeptSrv.getId_mp_depts())&&!orWfDeptSrv.getId_mp_depts().contains(ordSrv.getId_dep_mp()))){
						ordSrv.setId_dep_mp(orWfDeptSrv.getFirstid_mp_dept());
						ordSrv.setDep_mp_name(orWfDeptSrv.getFirstname_mp_dept());
					}
					//判断原医嘱的执行科室是否在返回的最新计算的医嘱流向中，如果不存在则修改为Firstid_mp_dept的值
					//0177568 liyuelong 2019/12/9 修改：执行科室，物资科室空判断
					if(isUseNewDeps||(StringUtils.isNotEmpty(orWfDeptSrv.getId_dept_whs()) && StringUtils.isNotEmpty(ordSrv.getId_dep_wh()) && !orWfDeptSrv.getId_dept_whs().contains(ordSrv.getId_dep_wh()))){
						ordSrv.setId_dep_wh(orWfDeptSrv.getId_dept_wh());
						ordSrv.setName_dep_wh(orWfDeptSrv.getName_dept_wh());
					}
					if(StringUtils.isNotEmpty(ordSrv.getId_srv())&&ordSrv.getId_srv().equals(ciOrderDo.getId_srv())){
						ciOrderDo.setId_dep_mp(ordSrv.getId_dep_mp());
						ciOrderDo.setName_dep_mp(ordSrv.getDep_mp_name());
					}
				}
			}
		}
		return aggs.toArray(new CiorderAggDO[0]);
	}

	/**
	 * 查询执行科室
	 * 
	 * @param ciOrderDO
	 * @return
	 * @throws BizException
	 */
	private OrWfDeptInfoDTO getExeWfDept(CiOrderDO ciOrderDO) throws BizException {
		// 获取上下文信息
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		OrWfExDeptParamDTO paramdto = new OrWfExDeptParamDTO();
		paramdto.setEu_wftp(1); // 0执行与物资 1执行科室 2物资流向
		paramdto.setCode_entp(ciOrderDO.getCode_entp()); // 就诊类型
		paramdto.setId_dept_ns(context.getId_dep_ns()); // 就诊护理病区
		paramdto.setId_dept_or(context.getId_dep_or());// 开单科室
		paramdto.setId_dept_en(context.getId_dep_en()); // id_dept_en;//就诊科室
		// dto.Recurstr = ""; //长临需要的 不知道 就为空
		paramdto.setId_srv(ciOrderDO.getId_srv()); // 服务
		paramdto.setSd_srvtp(ciOrderDO.getSd_srvtp()); // 服务类型sd
		paramdto.setId_srvca(ciOrderDO.getId_srvca());// 服务分类

		paramdto.setId_usage(ciOrderDO.getId_route()); // 用法
		paramdto.setFg_pres_outp(FBoolean.FALSE);
		if(ciOrderDO.getFg_pres_outp()!=null&&ciOrderDO.getFg_pres_outp().booleanValue()) {
			paramdto.setFg_pres_outp(FBoolean.TRUE);
		}
		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
		paramdto.setTimestr(ciOrderDO.getDt_effe().getUFTime());
		if (ciOrderDO.getFg_long() == null) {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.NULL));
		} else if (ciOrderDO.getFg_long().booleanValue()) {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.LONG));
		} else {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.TEMP));
		}
		// paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW); //只求执行科室
		// 执行科室（新的）
		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
		OrWfDeptInfoDTO orWfDeptInfo = service.getExeDepts4CiOrSrvN(paramdto);
		return orWfDeptInfo;
	}

	private OrWfDeptInfoDTO getExeWfDept(CiOrderDO ciOrderDO, OrdSrvDO ordSrvDO, OrdSrvMmDO[] ordSrvMmDOs,
			String defaultMpDeptId) throws BizException {
		// 获取上下文信息
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		OrWfExDeptParamDTO paramdto = new OrWfExDeptParamDTO();
		if (ordSrvMmDOs != null && ordSrvMmDOs.length > 0 && ordSrvDO != null) {
			OrdSrvMmDO srvmm = null;
			for (OrdSrvMmDO ordSrvMmDO : ordSrvMmDOs) {
				if (ordSrvMmDO.getId_orsrv().equals(ordSrvDO.getId_orsrv())) {
					srvmm = ordSrvMmDO;
					break;
				}
			}
			if (srvmm != null) {
				paramdto.setId_mm(srvmm.getId_mm());
				paramdto.setId_dosage(srvmm.getId_dosage());
				paramdto.setSd_herbpreparationtp(srvmm.getSd_herbpreparationtp());
				paramdto.setSd_pois(srvmm.getSd_pois());
			}
		}
		paramdto.setId_dept_ex(ciOrderDO.getId_dep_mp());
		paramdto.setEu_wftp(0); // 0执行与物资 1执行科室 2物资流向
		paramdto.setCode_entp(ciOrderDO.getCode_entp()); // 就诊类型
		paramdto.setId_dept_ns(context.getId_dep_ns()); // 就诊护理病区
		paramdto.setId_dept_or(context.getId_dep_or());// 开单科室
		paramdto.setId_dept_en(context.getId_dep_en()); // id_dept_en;//就诊科室
		// dto.Recurstr = ""; //长临需要的 不知道 就为空
		paramdto.setId_srv(ordSrvDO.getId_srv()); // 服务
		paramdto.setSd_srvtp(ordSrvDO.getSd_srvtp()); // 服务类型sd
		paramdto.setId_srvca(ordSrvDO.getId_srvca());// 服务分类

		paramdto.setId_usage(ciOrderDO.getId_route()); // 用法
		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
		paramdto.setTimestr(ciOrderDO.getDt_effe().getUFTime());
		if (ciOrderDO.getFg_long() == null) {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.NULL));
		} else if (ciOrderDO.getFg_long().booleanValue()) {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.LONG));
		} else {
			paramdto.setRecurstr(String.valueOf(OrRecurTypeEnum.TEMP));
		}
		if(ordSrvDO.getFg_pres_outp()!=null&&ordSrvDO.getFg_pres_outp().booleanValue()) {
			paramdto.setFg_pres_outp(FBoolean.TRUE);
		}else {
			paramdto.setFg_pres_outp(FBoolean.FALSE);
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
	 * 医嘱加顿
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public final OrderRstDTO addExtra(String[] id_ors,FDateTime dt_effe) throws BizException {
		Map<String, String> mapIdorsrvs = new HashMap<String, String>();
		fmapOldOrd = ServiceFinder.find(ICiOrdQryService.class).getCiEmsDTO(id_ors);
		CiorderAggDO[] aggDOs = getCiorderAggDOs(id_ors);
		if (CiOrdUtils.isEmpty(aggDOs)){
			orderRstDTO.setIsSuccess(FBoolean.FALSE);
			return orderRstDTO;
		}
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		setCiorderAggDOs(aggDOs, mapIdors, mapIdorsrvs, dt, null,dt_effe);

		// 先保存物品信息
		OrdSrvMmDO[] ordSrvMmDOs = copyCiorSrvMM(mapIdorsrvs, dt);
		Map<String, OrdSrvMmDO> mapTeamSrvDOs = new HashMap<String, OrdSrvMmDO>();
		for (OrdSrvMmDO mm : ordSrvMmDOs) {
			mapTeamSrvDOs.put(mm.getId_orsrv(), mm);
		}
		
		for (CiorderAggDO aggDO : aggDOs) {
			aggDO.getParentDO().setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			aggDO.getParentDO().setFg_long(FBoolean.FALSE);
			aggDO.getParentDO().setQuan_firday_mp(null);
			aggDO.getParentDO().setQuan_firday_mp(
					QuanFirstDayMpBP.CalFirstDayMp(aggDO.getParentDO().getId_freq(), aggDO.getParentDO().getDt_effe(),null,aggDO.getParentDO().getSd_srvtp(),aggDO.getParentDO().getCode_entp(),aggDO.getParentDO().getSd_orsrcfun(),aggDO.getParentDO().getFg_pres_outp()));// 首日执行次数
			aggDO.getParentDO().setFreq_name("一次");
			aggDO.getParentDO().setQuan_firday_mp(null);
			for (OrdSrvDO srvDO : aggDO.getOrdSrvDO()) {
				srvDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			}
			aggDO.getParentDO().setDt_end(aggDO.getParentDO().getDt_effe());
			//0163667: 住院医嘱里点了加顿的药品医嘱，目前为默认不打印在医嘱单上，按照临床科室要求，这边需要打印在医嘱单上，建议增加参数控制是否打印
			 String flag = ParamsetQryUtil.getParaString(Context.get().getOrgId(),ICiOrdNSysParamConst.SYS_PARAM_AddExtra_Fgprn);
				if(flag!=null){
					if("false".equals(flag)){
						aggDO.getParentDO().setFg_prn(FBoolean.FALSE);
					}else{
						aggDO.getParentDO().setFg_prn(FBoolean.TRUE);
					}
				}else {
					aggDO.getParentDO().setFg_prn(FBoolean.FALSE);
				}
			
		}
		//旧模式下，皮试判断逻辑（参数：CIOR0486，皮试逻辑使用的模式）
		aggDOs = skinLogic(aggDOs, ordSrvMmDOs);
		// 执行科室，价格等是需要重新计算的，因为有转科的情况
		aggDOs = handleDeptMp(aggDOs, ordSrvMmDOs,true);
		//获取【医嘱流向整体控制】排斥信息
		GetOrdValidateInfoBP bp=new GetOrdValidateInfoBP();
		String errorMsgString=bp.getOrdWhDeptValidateInfo(aggDOs);
		if(!CiOrdUtils.isEmpty(errorMsgString)) {
			this.setErrorInfo(errorMsgString);
			return orderRstDTO;
		}
		// 库存判断
		String stockWarn = checkStock(aggDOs, ordSrvMmDOs,true);
		
		if(ciOrderAggs.size()==0){
			if(errorEmsList!=null && errorEmsList.size() > 0){
				FMap2 error2 = new FMap2();
				//0192735: 住院医生站_医嘱加顿功能_抗生素加顿后生成在了长期医嘱  
				for (int j = 0; j <errorEmsList.size(); j++) {
					CiEmsDTO temp = (CiEmsDTO)errorEmsList.get(j);
					if (temp==null) {
						continue;
					}
				FArrayList list = temp.getEmssrvs(); 
				for(int i =0;i<list.size();i++) {
					CiEmsSrvDTO srvdto = (CiEmsSrvDTO)list.get(i);
					srvdto.setFg_propc(null);
				}
					temp.setSd_frequnitct(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE);// 临时医嘱	
				}
				
				//ciEmsDTO.
				//ciEmsDTO.setSd_frequnitct("0");
				error2.put("errorEmsList", errorEmsList);
				orderRstDTO.setExtension(error2);
			}
			return orderRstDTO;
		}
		aggDOs = ciOrderAggs.toArray(new CiorderAggDO[]{});
		ordSrvMmDOs = mmdos.toArray(new OrdSrvMmDO[]{});
		//开单总量单位处理
		dealWithIdPgkuCur(aggDOs,mapTeamSrvDOs);
		if(ciOrderAggs.size()==0){
			if(errorEmsList!=null && errorEmsList.size() > 0){
				FMap2 error2 = new FMap2();
				error2.put("errorEmsList", errorEmsList);
				orderRstDTO.setIsSuccess(FBoolean.FALSE);
				orderRstDTO.setExtension(error2);
			}
			return orderRstDTO;
		}
		aggDOs = ciOrderAggs.toArray(new CiorderAggDO[]{});
		
		//0194829: 用法费用对照、煎法费用对照、关联药袋费
		FMap2 srvinfo=ciOrRelSrvHandle(aggDOs);
		//组装医嘱内容
		content_or(aggDOs, mapTeamSrvDOs);
		
		saveCiorSrvMM(ordSrvMmDOs);
		saveCiorderAggDOs(aggDOs);

		copyCiorSrvSet(mapIdors, dt, new HashMap<String, String>());
		copyCiorderAppInfo(mapIdors, dt);
		
		if(errorEmsList!=null && errorEmsList.size() > 0){
			FMap2 error2 = new FMap2();
			//0192735: 住院医生站_医嘱加顿功能_抗生素加顿后生成在了长期医嘱  
			for (int j = 0; j <errorEmsList.size(); j++) {
				CiEmsDTO temp = (CiEmsDTO)errorEmsList.get(j);
				if (temp==null) {
					continue;
				}
			FArrayList list = temp.getEmssrvs(); 
			for(int i =0;i<list.size();i++) {
				CiEmsSrvDTO srvdto = (CiEmsSrvDTO)list.get(i);
				srvdto.setFg_propc(null);
			}
				temp.setSd_frequnitct(IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE);// 临时医嘱	
			}
		
			error2.put("errorEmsList", errorEmsList);
			orderRstDTO.setExtension(error2);
		} else if (StringUtils.isNotEmpty(stockWarn)) {
		    orderRstDTO.setMessageInfo(stockWarn);
		}
		if(srvinfo!=null&&srvinfo.size()>0) {
			FMap2 extension2=orderRstDTO.getExtension();
			if(extension2==null) {
				extension2=new FMap2();
				this.orderRstDTO.setExtension(extension2);
			}
			extension2.put("RelSrvMessageList", srvinfo);
		}
		return orderRstDTO;
	}

	/**
	 * 获取拼接医嘱内容的参数
	 */
	protected List<OrContentDTO> getOrContentDTOs(OrdSrvDO[] ordSrvs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) {
		List<OrContentDTO> list = new ArrayList<OrContentDTO>();
		ordSrvs = CiOrdUtils.Sort(ordSrvs, OrdSrvDO.SORTNO, SortEnum.ASC);
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			if (mapTeamSrvDOs.containsKey(ordSrvDO.getId_orsrv())) {
				OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO,mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()));
				orContentDTO.setSpec(mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()).getSpec());
				list.add(orContentDTO);
			}else{
				OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO);
				list.add(orContentDTO);
			}
		}
		return list;
	}

	/**
	 * 查询CiorderAggDO
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	protected CiorderAggDO[] getCiorderAggDOs(String[] id_ors) throws BizException {
		if (CiOrdUtils.isEmpty(id_ors))
			return null;
		return CiOrdAppUtils.getOrAggQryService().findByIds(id_ors, FBoolean.FALSE);
	}

	/**
	 * 重置CiorderAggDO
	 * 
	 * @param aggDOs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected void setCiorderAggDOs(CiorderAggDO[] aggDOs, Map<String, String> mapIdors,
			Map<String, String> mapIdorsrvs, FDateTime dt, FMap2 extension,FDateTime dt_effe) throws BizException {
		if (CiOrdUtils.isEmpty(aggDOs))
			return;
		// 获取上下文信息
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		// 生成ID
		String[] idors = new DBUtil().getOIDs(aggDOs.length);
		int i = 0;
		for (CiorderAggDO aggDO : aggDOs) {
			CiOrderDO ciOrderDO = aggDO.getParentDO();
			mapIdors.put(ciOrderDO.getId_or(), idors[i]);
			mapNewOldKeys.put(idors[i], ciOrderDO.getId_or());
			//0195132: 开立组合定价、服务套模式得服务，费用对照中更改子项数量。复制该服务，子项数量应按最新的带出
			OrdSrvDO mainOrdSrvDO = getMainSrvInfo(ciOrderDO, aggDO.getOrdSrvDO());
			if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS) ||
					ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS) ||
					IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(mainOrdSrvDO.getId_primd())){
				//0191247: 组套项目的子项及价格变更后，从历史里选择变更前的项目带出来仍是未调整的旧项目，导致费用错误
				CiEmsDTO ems = (CiEmsDTO) fmapOldOrd.get(ciOrderDO.getId_or());
				List<CiEmsSrvDTO> ciEmsSrvList = aggCiOrderTransferObs(ems);
				FArrayList srvsList = ems.getEmssrvs();
				if(!CiOrdUtils.isEmpty(srvsList) && ciEmsSrvList.size()>0) {
					srvsList.clear();
					for(CiEmsSrvDTO ciEmsSrvDTO : ciEmsSrvList){
						srvsList.add(ciEmsSrvDTO);
					}
				}
				ems.setEmssrvs(srvsList);
				ems.setId_or(null);
				ems.setStatus(DOStatus.NEW);
				CiOrAggAndRelDatum oragginfo = null;
				if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ciOrderDO.getCode_entp())
						||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(ciOrderDO.getCode_entp())||IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(ciOrderDO.getCode_entp())) {
					iih.ci.ord.s.bp.ems.save.ip.CiOrEms2OrAggAndRelInfoBP bpIp=new iih.ci.ord.s.bp.ems.save.ip.CiOrEms2OrAggAndRelInfoBP();
					oragginfo = bpIp.exec(ems);
				}else{
					ems.setFg_prisrvhandled(FBoolean.FALSE);
					iih.ci.ord.s.bp.ems.save.op.CiOrEms2OrAggAndRelInfoBP bpOp=new iih.ci.ord.s.bp.ems.save.op.CiOrEms2OrAggAndRelInfoBP();
					oragginfo = bpOp.exec(ems);
				}
				//放开多次多量后重新处理下总量和剂量
				handleSrvQuan(oragginfo,ems);
				//回写子项  0191247
				CiorderAggDO aggorder = oragginfo.getOraggdo();
				ArrayList<OrdSrvDO> ordSrvDOList = new ArrayList<OrdSrvDO>();
				for(OrdSrvDO ordSrvDO : aggorder.getOrdSrvDO()){
					if(ordSrvDO.getStatus() == DOStatus.DELETED){
						continue;
					}
					ordSrvDOList.add(ordSrvDO);
				}
				aggDO.setOrdSrvDO(ordSrvDOList.toArray(new OrdSrvDO[0]));
			}
			ciOrderDO.setId_or(idors[i]);
			ciOrderDO.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);
			ciOrderDO.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);
			ciOrderDO.setCode_entp(context.getCode_entp());
			ciOrderDO.setDt_entry(dt);
			ciOrderDO.setId_en(context.getId_en());
			ciOrderDO.setEu_feereversetp(null);
			//出院带药患者历史
			if (extension!= null &&  extension.containsKey("Fg_pres_outp")) {
				ciOrderDO.setFg_pres_outp(FBoolean.TRUE);
				ciOrderDO.setId_drugdeliverymethod("@@@@Z8100000000UF5XZ");
				ciOrderDO.setSd_drugdeliverymethod("2");
				ciOrderDO.setName_drugdeliverymethod("出院带药");
				
			}
			//护嘱医生站
			if(ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(context.getStationType())){
				ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_NUR);
			}else if(ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(context.getStationType())){
				//医技医生站
				ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);
			}else{
				//医嘱医生站
				ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
			}
			// 住院的需要格式化
			if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ciOrderDO.getCode_entp())
					||IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(ciOrderDO.getCode_entp())||IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(ciOrderDO.getCode_entp())) {
				ciOrderDO.setDt_effe(OrderUtils.getCompareFormatServerDateTime(ciOrderDO.getId_en()));
			} else {
				
				ciOrderDO.setDt_effe(CalDtEffeBP.GetDtEffe(ciOrderDO.getId_freq()));
			}
			if(FBoolean.TRUE.equals(ciOrderDO.getFg_long()))
			{
				ciOrderDO.setQuan_firday_mp(QuanFirstDayMpBP.CalFirstDayMp(aggDO.getParentDO().getId_freq(), aggDO.getParentDO().getDt_effe(),null,aggDO.getParentDO().getSd_srvtp(),aggDO.getParentDO().getCode_entp(),aggDO.getParentDO().getSd_orsrcfun(),aggDO.getParentDO().getFg_pres_outp()));// 首日执行次数
			}else{
				ciOrderDO.setQuan_firday_mp(null);
			}
			//0150033: 【工单】【开始时间默认赋值规则】参数值设为上条时间，第二条医嘱的开始时间没有跟随上一条的时间【南大象湖】
			if(dt_effe != null ) {
				ciOrderDO.setDt_effe(dt_effe);
			}
			//ciOrderDO.setDt_invalid(ciOrderDO.getDt_effe());
			
			ciOrderDO.setFg_stop(FBoolean.FALSE);// 停止标识
			ciOrderDO.setFg_chk_stop(null);
			ciOrderDO.setId_emp_stop(null);// 停止医生
			ciOrderDO.setId_dep_stop(null);// 停止科室
			ciOrderDO.setDt_stop(null);//
			ciOrderDO.setDt_end(null);//
			if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciOrderDO.getCode_entp())){
				// 如果是草药的话就不处理停止标识
				if (ciOrderDO.getSd_srvtp() != null
						&& !ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					ciOrderDO.setFg_stop(FBoolean.FALSE);// 停止标识
				}
				// 临时医嘱和草药医嘱，停止时间为开始时间
				if (!CiOrdUtils.isTrue(ciOrderDO.getFg_long())||ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					ciOrderDO.setDt_end(ciOrderDO.getDt_effe());
				} else {
					// 复制长期医嘱停止时间不取值
					if (ciOrderDO.getDays_or() != null) {
						ciOrderDO.setDt_end(ciOrderDO.getDt_effe()
								.addSeconds(ciOrderDO.getDays_or() != null ? ciOrderDO.getDays_or() * 24 * 3600 : 0).subSeconds(1));
						ciOrderDO.setFg_stop(FBoolean.TRUE);
						ciOrderDO.setId_emp_stop(Context.get().getStuffId());
						ciOrderDO.setId_dep_stop(Context.get().getDeptId());
					}else{
						ciOrderDO.setDt_end(null);
						ciOrderDO.setFg_stop(FBoolean.FALSE);
						ciOrderDO.setId_emp_stop(null);
						ciOrderDO.setId_dep_stop(null);
					}
				}
			}else{
				// 临时医嘱和草药医嘱，停止时间为开始时间
				if (!CiOrdUtils.isTrue(ciOrderDO.getFg_long())) {
					ciOrderDO.setDt_end(ciOrderDO.getDt_effe());
					ciOrderDO.setFg_stop(FBoolean.FALSE);
				}else{
					ciOrderDO.setDays_or(null);
				}
				if(ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
					ciOrderDO.setDt_end(ciOrderDO.getDt_effe());
					if(CiOrdUtils.isTrue(ciOrderDO.getFg_long())){
						ciOrderDO.setFg_stop(FBoolean.TRUE);
						ciOrderDO.setDt_stop(dt);
						ciOrderDO.setId_emp_stop(Context.get().getStuffId());
						ciOrderDO.setId_dep_stop(Context.get().getDeptId());
					}
				}
			}
			ciOrderDO.setFg_feertnable(FBoolean.TRUE);
			ciOrderDO.setFg_prn(FBoolean.TRUE);
			ciOrderDO.setFg_sign(FBoolean.FALSE);
			ciOrderDO.setDt_sign(null);
			ciOrderDO.setId_dep_sign(null);
			ciOrderDO.setId_emp_sign(null);
			ciOrderDO.setDt_last_bl(ciOrderDO.getDt_effe());
			ciOrderDO.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			ciOrderDO.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			ciOrderDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			ciOrderDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			ciOrderDO.setFg_flush2mr(FBoolean.FALSE);
			ciOrderDO.setFg_chk(FBoolean.FALSE);
			ciOrderDO.setId_emp_chk(null);
			ciOrderDO.setId_dep_chk(null);
			ciOrderDO.setFg_canc(FBoolean.FALSE);
			ciOrderDO.setFg_chk_canc(FBoolean.FALSE);
			ciOrderDO.setId_emp_chk_canc(null);
			ciOrderDO.setId_dep_chk_canc(null);
			ciOrderDO.setDt_chk(null);
			ciOrderDO.setDt_chk_canc(null);
			ciOrderDO.setDt_chk_stop(null);
			ciOrderDO.setId_emp_canc(null);
			ciOrderDO.setId_emp_chk_stop(null);
			ciOrderDO.setId_dep_chk_stop(null);
			ciOrderDO.setSd_orrsttp(null);
			// 生成医嘱编码
//			ciOrderDO.setCode_or(
//					CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
			ciOrderDO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
			ciOrderDO.setDt_canc(null);
			ciOrderDO.setId_emp_canc(null);
			ciOrderDO.setId_dep_canc(null);
			// 设置医嘱结果编码为空,复制医嘱时审核/结果状态为未出
			ciOrderDO.setSd_orrsttp(null);
			// 设置开立医生为当前医生
			ciOrderDO.setId_emp_or(context.getId_emp_or());
			// 开单科室
			ciOrderDO.setId_dep_or(context.getId_dep_or());
			// 就诊病区
			ciOrderDO.setId_dep_nur(context.getId_dep_ns());
			// 设置医嘱可取消标识
			ciOrderDO.setFg_uncancelable(FBoolean.FALSE);
			// 医嘱项目来源
			ciOrderDO.setEu_orsrcmdtp(OrSourceFromEnum.IIHORCLONE);
			if (!CiOrdUtils.isEmpty(ciOrderDO.getEu_verify_pharm())) {
				// 药品审核状态
				ciOrderDO.setEu_verify_pharm(0);
			}
			ciOrderDO.setApplyno(this.getApplyNo(ciOrderDO.getId_or()));
			ciOrderDO.setDt_last_mp(null);
			
			ciOrderDO.setId_orpltp(getOrCLoopTpId(ciOrderDO));//bug:0183778，liyuelong
			
			//0183615: 【验证版】门急诊医生站，开启超量开单原因后，服务分类调入医嘱，药品类的有赋值，其他类医嘱没赋值，希望处理一致。就诊历史同样处理。
			//关联 超量开单原因
			if(extension != null && extension.containsKey("Id_excessive_reason") && extension.containsKey("Sd_excessive_reason")) {
				String Id_excessive_reason=(String)extension.get("Id_excessive_reason");
				String Sd_excessive_reason=(String)extension.get("Sd_excessive_reason");
				String Name_excessive_reason=(String)extension.get("Name_excessive_reason");
				if(Id_excessive_reason != null && Sd_excessive_reason != null) {
					ciOrderDO.setId_excessive_reason(Id_excessive_reason);
					ciOrderDO.setSd_excessive_reason(Sd_excessive_reason);
					ciOrderDO.setName_excessive_reason(Name_excessive_reason);
				}
			}
			
			// 根据配置的参数设置指定属性
            setPropertyByConfig(context, ciOrderDO);
			
			ciOrderDO.setStatus(DOStatus.NEW);

			OrdSrvDO[] ordSrvDOs = aggDO.getOrdSrvDO();
			if (CiOrdUtils.isEmpty(ordSrvDOs))
				continue;
			EmsOrDrug skinDrug = null;
			if (extension != null && extension.size() > 0 && extension.containsKey(mapNewOldKeys.get(ciOrderDO.getId_or()))
					&& (extension.get(mapNewOldKeys.get(ciOrderDO.getId_or())) instanceof EmsOrDrug)) {
				skinDrug = (EmsOrDrug)extension.get(mapNewOldKeys.get(ciOrderDO.getId_or()));
			}
			String[] idorsrvs = new DBUtil().getOIDs(ordSrvDOs.length);
			int j = 0;
			
			
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				if(ordSrvDO.getStatus() == DOStatus.DELETED){
					continue;	//0191247
				}
				if (FBoolean.TRUE.equals(ordSrvDO.getFg_mm())) {
					mapIdorsrvs.put(ordSrvDO.getId_orsrv(), idorsrvs[j]);
					
					ordSrvDO.setFg_propc(null);
					ordSrvDO.setFg_highrisk(BDSrvDrugInfoCache.GetBdSrvDrugInfo(context, ordSrvDO.getId_srv()).getFg_highrisk());
				}
				String idorsrv = ordSrvDO.getId_orsrv();
				ordSrvDO.setId_orsrv(idorsrvs[j]);
				ordSrvDO.setId_or(idors[i]);
				ordSrvDO.setId_pres(null);
				ordSrvDO.setId_en(context.getId_en());
				ordSrvDO.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
				ordSrvDO.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
				ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
				ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
				ordSrvDO.setDt_last_bl(ciOrderDO.getDt_last_bl());
				ordSrvDO.setDt_last_mp(ciOrderDO.getDt_last_mp());
				ordSrvDO.setId_dep_srv(context.getId_dep_or());
				ordSrvDO.setId_emp_srv(context.getId_emp_or());
				ordSrvDO.setId_wg_or(context.getId_wg_or());
				ordSrvDO.setFg_skintest(skinDrug != null && idorsrv.equals(skinDrug.getId_orsrv()) ? skinDrug.getFg_skintest() : FBoolean.FALSE);
				ordSrvDO.setFg_skintest_rst(FBoolean.FALSE);
				ordSrvDO.setDt_last_cg(null);
				ordSrvDO.setDt_create(dt);
				ordSrvDO.setFg_feertnable(FBoolean.TRUE);
				ordSrvDO.setId_or_rel(null);
				// ordSrvDO.setQuan_medu(Quan_medu);
				// ordSrvDO.setQuan_total_medu(Quan_total_medu);
				// 0192981: 轻量级中的住院BS002检查申请服务，部分消息中 费用金额 字段值为空
				/*if(ordSrvDO.getQuan_total_medu() == null && ordSrvDO.getId_freq() != null && ordSrvDO.getId_freq().equals(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE)){
					ordSrvDO.setQuan_total_medu(FDouble.ONE_DBL);
				}*/
				//重新计算总量
				
				

				ordSrvDO.setStatus(DOStatus.NEW);

				j++;
			}
			//处理非药品的总量
			handlerNoDrugQuanToalMedu(ciOrderDO,ordSrvDOs);
			i++;
		}
	}
	
	private void handlerNoDrugQuanToalMedu(CiOrderDO ordo, OrdSrvDO[] ordsrvs) throws BizException {
		IFreqdefMDORService ifreqdefMDORService = CiOrdAppUtils.getFreqdefMDORService();
		FreqDefDO freqDef = ifreqdefMDORService.findById(ordo.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}
		CalQuantumBP bp = new CalQuantumBP();
		if(!ordo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG) ){
			
			if(ordo.getFg_set().equals(FBoolean.TRUE)){
				OrdSrvDO mainsrv = getMainSrvInfo(ordo, ordsrvs);
				if(!CiOrdUtils.isEmpty(mainsrv)){
					for (OrdSrvDO ordSrvDO : ordsrvs) {
						//组合定价中包含物品，但是总量不用重新计算了,因为在组装数据时已经算过了
						if(!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
							if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())) {
								QuantumParamDTO quantum = new QuantumParamDTO(ordo,ordSrvDO,true);
								ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
							}else{
								ordSrvDO.setQuan_total_medu(null);
							}
							
						}
					}

		}
			}else{
				for (OrdSrvDO ordSrvDO : ordsrvs) {
					//组合定价中包含物品，但是总量不用重新计算了,因为在组装数据时已经算过了
					if(!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
						if (IBdSrvDictCodeConst.SD_FREQNUNITCT_ONCE.equals(freqDef.getFre_code())) {
							QuantumParamDTO quantum = new QuantumParamDTO(ordo,ordSrvDO,false);
							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
						}else{
							ordSrvDO.setQuan_total_medu(null);
						}
							
					}
				}
			}
		}
		
	}

	/**
	 * 根据配置的参数设置指定属性
	 * @param context
	 * @param ciOrderDO
	 * @throws BizException
	 */
    private void setPropertyByConfig(CiEnContextDTO context, CiOrderDO ciOrderDO) throws BizException {
        String paraString = ParamsetQryUtil.getParaString(context.getId_org(), "CIOR0816");
        JSONObject paramConfig = null;
        try {
            paramConfig = (JSONObject) JSONObject.parse(paraString);            
        } catch (Exception e) {
            throw new BizException("JSON解析错误，请检查临床诊疗下CIOR0816参数是否配置正确。");
        }
        
        boolean configured = true;
        JSONArray params = (JSONArray) paramConfig.get(context.getStationType());
        if (paramConfig == null || params == null || params.size() == 0) {
            configured = false;
        }
        
        HashSet<String> paramSet = null;
        if (configured) {
            paramSet = new HashSet<>();
            Iterator<Object> iterator = params.iterator();
            while (iterator.hasNext()) {
                paramSet.add(iterator.next().toString().trim());
            }
        }

        // 诊断id
        if (configured && paramSet.contains("diag")) {
            // 保留原属性
        } else {
            // 默认按原有逻辑重新赋值
            DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(context.getId_en());
            if (diagOutlineInfo != null) {
                ciOrderDO.setId_didef(diagOutlineInfo.getId_didef());// 主诊断的主项目id
                ciOrderDO.setName_didef(diagOutlineInfo.getName_diag());// 主诊断名称
            }     
        }
        
        // 备注
        if (configured && paramSet.contains("des")) {
            // 保留原属性
        } else {
            // 默认按原有逻辑重新赋值
            if (!ciOrderDO.getSd_srvtp().startsWith("0103")) {
                ciOrderDO.setDes_or(null);
            }
        }
        
        // 加急标识
        if (configured && paramSet.contains("fg_urgent")) {
            // 保留原属性
        } else {
            // 默认按原有逻辑重新赋值
            ciOrderDO.setFg_urgent(CiOrdUtils.getFgUrgent(ciOrderDO.getId_srv(),ciOrderDO.getCode_entp()));
        }
    }

	/**
	 * 保存CiorderAggDO
	 * 
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 */
	protected CiorderAggDO[] saveCiorderAggDOs(CiorderAggDO[] aggDOs) throws BizException {
		if (CiOrdUtils.isEmpty(aggDOs))
			return null;
		return CiOrdAppUtils.getOrAggService().save(aggDOs);
	}

	/**
	 * 复制临床服务物品
	 * 
	 * @param mapIdorsrvs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO[] copyCiorSrvMM(Map<String, String> mapIdorsrvs, FDateTime dt) throws BizException {
		OrderSrvMMCopyBP srvMMCopyBP = new OrderSrvMMCopyBP();
		return srvMMCopyBP.copy(mapIdorsrvs, dt);
	}
	/**
	 * 保存服务物品信息
	 * @param ordSrvMmDOs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO[] saveCiorSrvMM(OrdSrvMmDO[] ordSrvMmDOs) throws BizException {
		OrderSrvMMCopyBP srvMMCopyBP = new OrderSrvMMCopyBP();
		return srvMMCopyBP.saveOrdSrvMmDOs(ordSrvMmDOs);
	}

	/**
	 * 复制临床服务套
	 * 
	 * @param mapIdors
	 * @return
	 * @throws BizException
	 */
	private Boolean copyCiorSrvSet(Map<String, String> mapIdors, FDateTime dt, Map<String, String> mapIdorsrv) throws BizException {
		OrderSrvSetCopyBP srvSetCopyBP = new OrderSrvSetCopyBP();
		return srvSetCopyBP.copy(mapIdors, dt, mapIdorsrv);
	}

	/**
	 * 复制医嘱相关申请单
	 * 
	 * @param id_ors
	 */
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		return true;
	}

	/**
	 * 申请单号
	 * 
	 * @return
	 */
	protected final String getApplyNo(String id_or) throws BizException {
		if (this.mapApplynoTeam.containsKey(id_or)) {
			return this.mapApplynoTeam.get(id_or);
		}
		String applyNo = getApplyNo();
		this.mapApplynoTeam.put(id_or, applyNo);
		return applyNo;
	}

	/**
	 * 计算对应申请单的申请单号
	 * 
	 * @return
	 */
	protected String getApplyNo() throws BizException {
		return "";
	}

	/**
	 * 拷贝皮试结果表
	 * 
	 * @param mapIdors
	 * @param dt
	 * @return
	 */
	protected CiSkinTestRstDO[] copySkinTestRst(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		return null;
	}
	/**
	 * 重新组装医嘱内容
	 * @param aggDOs
	 * @param mapTeamSrvDOs
	 * @throws BizException 
	 */
	protected void content_or(CiorderAggDO[]aggDOs,Map<String, OrdSrvMmDO> mapTeamSrvDOs) throws BizException{
		
		String sd_srvtp = null;
		CiOrderDO order = null;
		
		for (CiorderAggDO aggDO : aggDOs) {
			order = aggDO.getParentDO();
			sd_srvtp = aggDO.getParentDO().getSd_srvtp();
			
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
					HerbOrContentParam drugOrContentParam = new HerbOrContentParam(order.getOrders(),order.getSd_srvtp(), order.getFreq_name(),
							order.getDays_or(), order.getRoute_name(),order.getBoil_name(),order.getRoutedes_name(),
							order.getDes_or(), getOrContentDTOs(aggDO.getOrdSrvDO(), mapTeamSrvDOs));
					order.setContent_or(CiOrContentUtils.herbCreate(drugOrContentParam).toString());
				}else{
					DrugOrContentParam drugOrContentParam = new DrugOrContentParam(order.getSd_srvtp(), order.getFreq_name(),
							order.getDays_or(), order.getRoute_name(),
							order.getDes_or(),order.getFg_pres_outp(),order.getFg_wholepack(), getOrContentDTOs(aggDO.getOrdSrvDO(), mapTeamSrvDOs));
					order.setContent_or(CiOrContentUtils.create(drugOrContentParam).toString());
				}
			} //else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT_NUT)){
				//String sd_srvtp, String name_srv,String note_or,String name_freq, String name_route, FBoolean fg_urgent,String id_or_old, FDouble quan_medu, String id_unit_medu,String id_srv
				//TreatOrContentParam param = new TreatOrContentParam(order.getSd_srvtp(), order.getName_or(), order.getNote_or(),order.getFreq_name(),order.getRoute_name(),order.getFg_urgent(),null,order.getQuan_medu(),order.getName_unit_med(),order.getId_srv());
				//order.setContent_or(CiOrContentUtils.create(param).toString());
			//}
			else {
//				order.setContent_or(CiOrContentUtils
//								.create(order.getSd_srvtp(), order.getName_or(),
//										order.getRoute_name(), order.getFg_urgent())
//								.toString());
				//标准版开立时嘱托、护理和其他类医嘱都走的治疗类的开立模式，剩下的除了检查检验等这些，都不能复制，所以复制时也应和标准版开立治疗拼接医嘱内容方法一致
				String id_or_old = mapNewOldKeys.get(aggDO.getParentDO().getId_or());
				TreatOrContentParam treatOrContentParam = new TreatOrContentParam(id_or_old,aggDO.getParentDO());
				CiOrContentDO contentdo=new CiOrContentDO();
				Object[] params = new Object[]{contentdo,treatOrContentParam};
				BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_TREAT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
				EventDispatcher.fireEvent(event);
				aggDO.getParentDO().setContent_or(contentdo==null?null:contentdo.toString());
			}
		}
	}
	protected void setCopyCiEmsDTOInfo(CiEmsDTO ciEmsDTO) throws BizException {
		
	}

	/**
	 * 服务开单校验
	 * @param aggDOs
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO[] srvOpenValidate(CiorderAggDO[] aggDOs) throws BizException {
		if(aggDOs == null || aggDOs.length == 0){
			return aggDOs;
		}
		List<OrdSrvChangedInfoDTO> srvChangedtos = new ArrayList<OrdSrvChangedInfoDTO>();
		List<CiorderAggDO> aggs = new ArrayList<CiorderAggDO>();
		List<String> idsrvs = new ArrayList<String>();
		for (CiorderAggDO ciorderAggDO : aggDOs) {
			OrdSrvDO[] ordSrvs = ciorderAggDO.getOrdSrvDO();
			OrdSrvDO mainSrvDO = getMainSrvDO(ordSrvs,ciorderAggDO.getParentDO().getId_srv());
			if(mainSrvDO == null){
				continue;
			}
			//组合定价不用判断明细
			if(IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(mainSrvDO.getId_primd())){
				if(!idsrvs.contains(mainSrvDO.getId_srv())){
					OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
					dto.setId_srv(mainSrvDO.getId_srv());
					srvChangedtos.add(dto);
					
					idsrvs.add(mainSrvDO.getId_srv());
				}
			}else{
				for (OrdSrvDO ordSrvDO : ordSrvs) {
					if(!idsrvs.contains(ordSrvDO.getId_srv())){
						OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
						dto.setId_srv(ordSrvDO.getId_srv());
						srvChangedtos.add(dto);
						
						idsrvs.add(ordSrvDO.getId_srv());
					}
				}
			}
		}
		if(srvChangedtos.size() > 0){
			OrdSrvValidateBP validate = new OrdSrvValidateBP();
			FMap2 map = validate.exec(srvChangedtos.toArray(new OrdSrvChangedInfoDTO[0]), aggDOs[0].getParentDO().getCode_entp());
			
			C:for (CiorderAggDO ciorderAggDO : aggDOs) {
				OrdSrvDO[] ordSrvs = ciorderAggDO.getOrdSrvDO();
				for (OrdSrvDO ordSrvDO : ordSrvs) {
					if(map.containsKey(ordSrvDO.getId_srv())){
						setErrorInfo(map.get(ordSrvDO.getId_srv())==null?"":map.get(ordSrvDO.getId_srv()).toString());
						continue C; 
					}
				}
				if(!aggs.contains(ciorderAggDO))
					aggs.add(ciorderAggDO);
			}
		}
		return aggs.toArray(new CiorderAggDO[0]);
	}
	public Map<String, CiorderAggDO> getTeampAggs() {
		return teampAggs;
	}
	public void setTeampAggs(Map<String, CiorderAggDO> teampAggs) {
		this.teampAggs = teampAggs;
	}
	/**
	 * 获得主服务
	 * @param ordSrvs
	 * @param id_srv
	 * @return
	 */
	private OrdSrvDO getMainSrvDO(OrdSrvDO[] ordSrvs,String id_srv){
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			if(id_srv.equals(ordSrvDO.getId_srv())){
				return ordSrvDO;
			}
		}
		return null;
	}
	/**
	 *添加错误提示信息
	 */
	protected void setErrorInfo(String errorInfo){
		String messageInfo = orderRstDTO.getMessageInfo();
		messageInfo=((StringUtils.isEmpty(messageInfo)||"null".equals(messageInfo)?"":messageInfo)+errorInfo);
		orderRstDTO.setMessageInfo(messageInfo);
		orderRstDTO.setIsSuccess(FBoolean.FALSE);
	} 
	/**
	 * 获得医嘱闭环类型id
	 * 
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	public String getOrCLoopTpId(CiOrderDO ordo) throws BizException {
		try {
			GetOrMpCloseLoopTpBP bp = new GetOrMpCloseLoopTpBP();
			OrpltpDO[] cltpids = bp.exec(ordo);
			if (CiOrdUtils.isEmpty(cltpids) || cltpids[0] == null)
				return null;
			return cltpids[0].getId_orpltp();
		} catch (Exception e) {
			Logger.error(e);
		}
		return null;
	}

	public FArrayList getErrorEmsList() {
		return errorEmsList;
	}
	public void setErrorEmsList(FArrayList errorEmsList) {
		this.errorEmsList = errorEmsList;
	}
	public List<CiorderAggDO> getCiOrderAggs() {
		return ciOrderAggs;
	}
	public void setCiOrderAggs(List<CiorderAggDO> ciOrderAggs) {
		this.ciOrderAggs = ciOrderAggs;
	}

	//0190605：获得医嘱药品关联药袋费数据
	protected void aggCiOrderDrugHandle(CiorderAggDO aggDO, CiEmsDTO ems, Map<String, OrdSrvMmDO> mapMmDos,Hashtable ht) throws BizException {
		
	}
	
	/**
	 * 合并获得医嘱项目集合信息
	 */
	public OrdSrvDO[] merge(OrdSrvDO[] usgrelorsrvs, ArrayList<OrdSrvDO> orsrvs) {
		if (orsrvs == null || orsrvs.size() == 0) {
			return usgrelorsrvs;
		}
		OrdSrvDO[] orsrvdos = (OrdSrvDO[]) orsrvs.toArray((OrdSrvDO[]) Array.newInstance(OrdSrvDO.class, 0));

		// 返回处理
		return (OrdSrvDO[]) CiOrdUtils.mergeObjAry(orsrvdos, usgrelorsrvs);
	}

	//0192176: 【验证版】住院医生站，住院医嘱，既往调入、复制、医嘱模板开了抗菌药，用药目的不应复制
	protected void GetSrvDrugInfo(OrdSrvMmDO[] ordSrvMmDOs) throws BizException {

	}
	/**
	 * 医嘱关联服务数据信息处理
	 * @param ems
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	private FMap2 ciOrRelSrvHandle(CiorderAggDO[] aggDOs) throws BizException{
		Map<String, OrdSrvMmDO> mapMmDos = new HashMap<String,OrdSrvMmDO>();
		for(OrdSrvMmDO itm : mmdos){
			mapMmDos.put(itm.getId_orsrv(), itm);
		}
		String key="RelSrvMessageList";
		FMap2 srvrelinfo=new FMap2();

		for(CiorderAggDO aggDO : aggDOs){
			Hashtable ht=new Hashtable();
			CiOrderDO ciOrderDO = aggDO.getParentDO();
			CiEmsDTO ems = (CiEmsDTO) fmapOldOrd.get(mapNewOldKeys.get(aggDO.getParentDO().getId_or()));
			//获得医嘱关联费用服务数据
			UsageRelFeeSrvDO[] relfeesrvdos = null;
			OrdSrvDO[] relordSrvDOs = null;
			if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ciOrderDO.getCode_entp()) ||
					IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(ciOrderDO.getCode_entp()) ||
					IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(ciOrderDO.getCode_entp())) {
				iih.ci.ord.s.bp.ems.save.op.CiOrUsageRelFeeSrvGetBP bpOp=new iih.ci.ord.s.bp.ems.save.op.CiOrUsageRelFeeSrvGetBP();
				relfeesrvdos = bpOp.exec(ems);
				//医嘱关联费用服务信息创建医嘱项目
				iih.ci.ord.s.bp.ems.save.op.CiOrRelUsgFeeOrSrvBuildBP bpOpBuild=new iih.ci.ord.s.bp.ems.save.op.CiOrRelUsgFeeOrSrvBuildBP();
				relordSrvDOs = bpOpBuild.exec(aggDO, relfeesrvdos, ht);
			}else{
				iih.ci.ord.s.bp.ems.save.ip.CiOrUsageRelFeeSrvGetBP bpIp=new iih.ci.ord.s.bp.ems.save.ip.CiOrUsageRelFeeSrvGetBP();
				relfeesrvdos = bpIp.exec(ems);
				//医嘱关联费用服务信息创建医嘱项目
				iih.ci.ord.s.bp.ems.save.ip.CiOrRelUsgFeeOrSrvBuildBP bpIpBuild=new iih.ci.ord.s.bp.ems.save.ip.CiOrRelUsgFeeOrSrvBuildBP();
				relordSrvDOs = bpIpBuild.exec(aggDO, relfeesrvdos, ht);
			}
			//清除附加费用
			ArrayList<OrdSrvDO> ordSrvDOList = new ArrayList<OrdSrvDO>();
			for(int i=0; i<aggDO.getOrdSrvDO().length; i++){
				OrdSrvDO itm = aggDO.getOrdSrvDO()[i];
				if(!itm.getEu_sourcemd().equals(OrSrvSourceFromEnum.MMBAGFEE) &&
						!itm.getEu_sourcemd().equals(OrSrvSourceFromEnum.USAGERELFEE) &&
						!itm.getEu_sourcemd().equals(OrSrvSourceFromEnum.BOILRELFEE) &&
						!itm.getEu_sourcemd().equals(OrSrvSourceFromEnum.BOILDESRELFEE)){
					ordSrvDOList.add(itm);
				}
			}
			ArrayList<OrdSrvDO> bdsrvList = new ArrayList<>();
			if(relordSrvDOs != null){
				Collections.addAll(bdsrvList, relordSrvDOs);
			}
			OrdSrvDO[] ordSrvDOs = merge(ordSrvDOList.toArray(new OrdSrvDO[0]), bdsrvList);
			aggDO.setOrdSrvDO(ordSrvDOs);
			//煎法要求关联费用创建医嘱服务项目
			bdsrvList = new ArrayList<>();
			Collections.addAll(bdsrvList, aggDO.getOrdSrvDO());
			aggCiOrderHerbHandle(aggDO,ems,bdsrvList,ht);
			//0190605：获得医嘱药品关联药袋费数据
			aggCiOrderDrugHandle(aggDO, ems, mapMmDos,ht);
			
			if(ht.containsKey(key)) {
				StringList msgList=(StringList)ht.get(key);
				msgList.add(0, "医嘱 "+aggDO.getParentDO().getName_or()+":");
				srvrelinfo.put(aggDO.getParentDO().getId_or(), msgList.toString());
			}
		}
		return srvrelinfo;
	}

	//获得煎法要求关联费用数据
	protected void aggCiOrderHerbHandle(CiorderAggDO aggorder, CiEmsDTO ems, ArrayList<OrdSrvDO> bdsrvList,Hashtable ht) throws BizException {
		
	}
	
	/**
	 * 处理医嘱相关信息中总量计算处理
	 * @param oragginfo
	 * @throws BizException 
	 */
	private void handleSrvQuan(CiOrAggAndRelDatum oragginfo,CiEmsDTO ems) throws BizException{
		CiorderAggDO aggorder = oragginfo.getOraggdo();
		CiOrderDO ordo = aggorder.getParentDO();
		OrdSrvDO[] ordsrvs = aggorder.getOrdSrvDO();
		CalQuantumBP bp = new CalQuantumBP();
		
		if(ordo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS) || ordo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
			if(ordo.getFg_set().equals(FBoolean.TRUE)){
				OrdSrvDO mainsrv = getMainSrvInfo(ordo, ordsrvs);
				if(!CiOrdUtils.isEmpty(mainsrv)){
					for (OrdSrvDO ordSrvDO : ordsrvs) {
						//组合定价中包含物品，但是总量不用重新计算了,因为在组装数据时已经算过了
						if(!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
							QuantumParamDTO quantum = new QuantumParamDTO(ems,ordSrvDO,true);
							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
						}
					}
				}
			}else{
				for (OrdSrvDO ordSrvDO : ordsrvs) {
					//组合定价中包含物品，但是总量不用重新计算了,因为在组装数据时已经算过了
					if(!FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
						QuantumParamDTO quantum = new QuantumParamDTO(ems,ordSrvDO,false);
						ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));	
					}
				}
			}
		}
	}
	private OrdSrvDO getMainSrvInfo(CiOrderDO ordo,OrdSrvDO[] ordsrvs){
		for (OrdSrvDO ordSrvDO : ordsrvs) {
			if(ordo.getId_srv().equals(ordSrvDO.getId_srv())){
				return ordSrvDO;
			}
		}
		return null;
	}

	//0191247: 组套项目的子项及价格变更后，从历史里选择变更前的项目带出来仍是未调整的旧项目，导致费用错误
	protected List<CiEmsSrvDTO> aggCiOrderTransferObs(CiEmsDTO ems) throws BizException {
		return new ArrayList<CiEmsSrvDTO>();
	}
}

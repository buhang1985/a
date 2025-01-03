package iih.ci.ord.s.ems.ip.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.define.StringObjectMap;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.mi.ord.i.ICiMiOrdRService;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dto.hp.BdHpIndicDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.i.error.StackPointDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.JudgeOrderStatusBP;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.ci.ord.s.bp.ems.hp.CiOrHpInfoBP;
import iih.ci.ord.s.bp.ems.hp.NeusoftHpCheckedBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.ems.cache.EmsStackInfoCache;
import iih.ci.ord.s.ems.ip.order.OrderLoadBP;
import iih.ci.ord.s.ems.itf.IDefaultCreateOrderInfo;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.itf.bp.IOrderHpInfoBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.op.hp.gj.OrderHpInfoBP;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.stackpoint.IStackPointAction;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.hp.cp.docinfodto.d.CpOrderJudge;
import iih.hp.cp.itf.i.IHpcpAppItfService;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 住院医生站所有涉及医疗单（医嘱保存）基类实现
 * 
 * @author wangqingzhu
 *
 */
public class BaseIpEmsSaveBP extends BaseIpHpEmsSaveBP {

	/**
	 * 结构体（保存结果）
	 * 
	 * @author wangqingzhu
	 *
	 */
	public class EmsSaveRstInfo {
		public CiOrderDO[] szOrderInfo;

		public OrdSrvDO[] szOrderSrvInfo;

		public OrdSrvMmDO[] szOrderSrvMmInfo;

		public OrdSrvSetDO[] szOrderSrvSetInfo;

		public Object[] szAppInfo;
	}

	/**
	 * 有效性校验接口
	 */
	private IEmsValidate emsValidate = null;
	/**
	 * 就诊上下文
	 */
	private CiEnContextDTO enContextInfo = null;

	/**
	 * 医保信息处理逻辑对象
	 */
	private IOrderHpInfoBP orderHpInfoBP = new OrderHpInfoBP();

	/**
	 * 默认医嘱生成逻辑接口
	 */
	private IDefaultCreateOrderInfo defaultCreateOrderInfo = null;

	public IEmsValidate getEmsValidate() {
		return emsValidate;
	}

	public void setEmsValidate(IEmsValidate emsValidate) {
		this.emsValidate = emsValidate;
	}

	public IDefaultCreateOrderInfo getDefaultCreateOrderInfo() {
		return defaultCreateOrderInfo;
	}

	public void setDefaultCreateOrderInfo(IDefaultCreateOrderInfo defaultCreateOrderInfo) {
		this.defaultCreateOrderInfo = defaultCreateOrderInfo;
	}

	public CiEnContextDTO getEnContextInfo() {
		return enContextInfo;
	}

	public void setEnContextInfo(CiEnContextDTO enContextInfo) {
		this.enContextInfo = enContextInfo;
		
		Context.get().setAttribute("CiEnContextDTO", enContextInfo);
	}

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {

		EmsRstDTO rst = new EmsRstDTO();
		// 1. 获取就诊上下文
		EmsSaveDTO ems = szEms[0];
		this.setEnContextInfo(ctx);

		// 将FArrayList 对象转化为标准Jave类对象
		ObjectList emsList = new ObjectList();
		emsList.addAll(ems.getDocument());

		// TODO:先判断医嘱版本信息（时间戳sv)
		ErrorEmsList errorList = orSvValidate(ctx, ems);
		if (!CiOrdUtils.isEmpty(errorList)) {
			rst.setErrorEmsList(errorList.asFArrayList());
			return new EmsRstDTO[] { rst };
		}

		// 3. 有效性批量验证
		if (!verifyEmsInfo(ctx, emsList.toArray(), rst)) {
			return new EmsRstDTO[] { rst };
		}

		// 4. 默认值批量处理
		handleOrderPackageInfoDefaultValue(ctx, emsList);

		// 5. 批量构建
		OrderPackageInfo[] szOrderPakageInfo = handleOrderAggInfoList(ctx, emsList);

		// 6. 完整性批量验证
		ErrorEmsList rstValidate = getEmsValidate().beforeSaveValidate(szOrderPakageInfo);
		if (!CiOrdUtils.isEmpty(rstValidate)) {
			// 设置错误信息数据
			rst.setErrorEmsList(rstValidate.asFArrayList());
			// 将错误的医嘱保存对象从保存集合中移除
			OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPakageInfo);
			orderPackageInfoList.removeAll(rstValidate.asMetaDataList());
			szOrderPakageInfo = orderPackageInfoList.asArray();
		}
		// 7.临床路径医生审核标志判断并赋值
		handleHpAppOrDoctorCheckInfo(ctx, szOrderPakageInfo);
		// 8. 医保默认值
		szOrderPakageInfo = handleOrdDefaultHpInfo(ctx, szOrderPakageInfo);
		// 9. 批量执行
		EmsSaveRstInfo emsSaveRstInfo = handleSaveOrderPackageList(ctx, szOrderPakageInfo);
		OrdBizLogger.info(ctx, "[SaveBP]保存数据库通过");

		// 10. 返回值处理
		return handleEmsRstInfos(ctx, emsSaveRstInfo, rst);
	}

	/**
	 * 有效性验证，可以根据业务需求是否对验证不通过的医疗单数据做出终止执行逻辑
	 * @param ctx， 上下文对象
	 * @param szObj，医疗单对象
	 * @param rstInfo，结果对象
	 * @return 是否终止 医嘱保存
	 * @throws BizException
	 */
	protected boolean verifyEmsInfo(CiEnContextDTO ctx, Object[] szObj, EmsRstDTO rstInfo) throws BizException {
		ErrorEmsList errorAllList = getEmsValidate().viewModelValidate(szObj, ctx);
		if (CiOrdUtils.isEmpty(errorAllList)) {
			return true;
		}
			ErrorEmsList errorList=new ErrorEmsList();
			ErrorEmsList otherList=new ErrorEmsList();
			for(ErrorEmsDTO error:errorAllList){
				if(OrderUtils.ErrorLevel_E.equals(error.getError_level())){
					errorList.add(error);
				}else{
					otherList.add(error);
				}
			}
			
			if(errorList.size()>0){
				rstInfo.setErrorEmsList(errorList.asFArrayList());
			}
			else{
				rstInfo.setErrorEmsList(otherList.asFArrayList());
			}
//			ErrorEmsList rtnErrorMsg=new ErrorEmsList();
//			if(errorList.size()>0){
//				ErrorEmsDTO errorDTO=new ErrorEmsDTO();
//				errorDTO.setCode_or(errorList.get(0).getCode_or());
//				errorDTO.setName_or(errorList.get(0).getName_or());
//				errorDTO.setError_level(OrderUtils.ErrorLevel_E);
//				StringBuilder errorMsgSb=new StringBuilder();
//				for(ErrorEmsDTO error:errorList){
//					for(int i=0;i<error.getErrorInfo().size();i++){
//						errorMsgSb.append(i+1).append("、").append(error.getErrorInfo().get(i)).append("\n");
//					}
//				}
//				errorDTO.setError_message(errorMsgSb.toString());
//				rtnErrorMsg.add(errorDTO);
//			}else if(otherList.size()>0){
//				ErrorEmsDTO errorDTO=new ErrorEmsDTO();
//				errorDTO.setCode_or(otherList.get(0).getCode_or());
//				errorDTO.setName_or(otherList.get(0).getName_or());
//				errorDTO.setError_level(otherList.get(0).getError_level());
//				StringBuilder errorMsgSb=new StringBuilder();
//				for(ErrorEmsDTO error:otherList){
//					for(int i=0;i<error.getErrorInfo().size();i++){
//						errorMsgSb.append(i+1).append("、").append(error.getErrorInfo().get(i)).append("\n");
//					}
//				}
//				errorDTO.setError_message(errorMsgSb.toString());
//				rtnErrorMsg.add(errorDTO);
//			}
//			rstInfo.setErrorEmsList(rtnErrorMsg.asFArrayList());

			return false;
		
	}

	/**
	 * 设置医保默认值处理
	 * 
	 * @param ctx
	 * @param szOrderPackageInfo
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] handleOrdDefaultHpInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		
		if(szOrderPackageInfo!=null&&szOrderPackageInfo.length>0) {
			List<CiOrAggAndRelDatum> ordDatalist=new ArrayList<>();
			for (OrderPackageInfo packageInfo : szOrderPackageInfo) {
				CiOrAggAndRelDatum ordData=new CiOrAggAndRelDatum();
				CiorderAggDO oraggdo=new CiorderAggDO();
				ordData.setOraggdo(oraggdo);
		        oraggdo.setParentDO(packageInfo.getOrderInfo());
		        OrdSrvDO[] srvs=packageInfo.getOrderSrvList();
		        oraggdo.setOrdSrvDO(srvs);
		        List<OrdSrvMmDO> ordmmlist=packageInfo.asOrderSrvMmList();
		        Map<String,OrdSrvMmDO>mmmap=new HashMap<>();
		        FMap srvmmmap=new FMap();
		        for (OrdSrvMmDO ordSrvMmDO : ordmmlist) {
		        	if(ordSrvMmDO!=null) {
		        	mmmap.put(ordSrvMmDO.getId_orsrv(), ordSrvMmDO);
		        	}
				}
		        for (OrdSrvDO ordSrvDO : srvs) {
		        	OrdSrvMmDO mm=mmmap.get(ordSrvDO.getId_orsrv());
		        	if(mm!=null) {
		        		ordSrvDO.setId_mm(mm.getId_mm());
		        		String idsrvidmm=ordSrvDO.getId_srv() + "_" + ordSrvDO.getId_mm();		        		
		        		List<OrdSrvMmDO> mlist=new ArrayList<>();
		        		mlist.add(mm);
		        		srvmmmap.put(idsrvidmm, mlist);
		        	}
		        	if(isHpPat(ctx)) {
		        		ordSrvDO.setId_hp(ctx.getId_hp());
	        		}else {
	        			ordSrvDO.setId_hp(ctx.getId_hp_default());
	        		}
				}
		        
		        Hashtable ht=new Hashtable();
		        ht.put(OrdSrvMmDODesc.CLASS_FULLNAME, srvmmmap);
		        ordData.setOrattachht(ht);
		        Integer cpor = packageInfo.getOrderInfo().getEu_uncporjudge();
		        if(CpOrderJudge.OWNCP==cpor||CpOrderJudge.OWNREPEATCP==cpor) {
		        	ordData.setFg_cp("1");
		        }
		        CiOrHpInfoBP ordHpInfo = new CiOrHpInfoBP();
				CiorderAggDO orderAgg = ordHpInfo.exec(ctx, ordData);		
				ordDatalist.add(ordData);
				
			}
			new NeusoftHpCheckedBP().execChecked(ctx, ordDatalist);
		}

		return szOrderPackageInfo;
	}
	
	private boolean isHpPat(CiEnContextDTO ctx) {
		if(ctx!=null&&! StringUtils.isNullOrEmpty(ctx.getId_hp()) &&!StringUtils.isNullOrEmpty(ctx.getSd_hptp())&&ctx.getSd_hptp().startsWith("1")&&ctx.getFg_hpfundpay()==FBoolean.TRUE) {
			return true;
		}
		return false;
	}

	/**
	 * 修复医保数据
	 * @param ctx
	 * @param szOrderPackageInfo
	 */
	private OrderPackageInfo[] repairHpOrderPackageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo){
		
		
		List<OrderPackageInfo> orderPackageInfoList = new ArrayList<OrderPackageInfo>();
		for (OrderPackageInfo orderPackageInfo : szOrderPackageInfo) {
			
			if(!CiEnContextUtil.IsHpPat(ctx)){
				OrderSrvMmInfo[] orderSrvMmInfos = orderPackageInfo.getAllOrderSrvMmList().asArray();
				for(OrderSrvMmInfo orderSrvMmInfo : orderSrvMmInfos){
					OrdSrvDO ordSrv = orderSrvMmInfo.getOrderSrvInfo();
					if (DOStatus.DELETED == ordSrv.getStatus()) {
						continue;
					}
					
					ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.NON_MEDICAL);
					ordSrv.setFg_selfpay(FBoolean.TRUE);
					ordSrv.setFg_indic(FBoolean.FALSE);					
				}
			}else{
				orderPackageInfo = this.repairHpOrderPackageInfo(ctx, orderPackageInfo);
			}
			
			orderPackageInfoList.add(orderPackageInfo);
		}
		
		return orderPackageInfoList.toArray(new OrderPackageInfo[orderPackageInfoList.size()]);
	}
	
	/**
	 * 修复每个医嘱包中的医保信息
	 * @param ctx
	 * @param orderPackageInfo
	 * @return
	 */
	protected OrderPackageInfo repairHpOrderPackageInfo(CiEnContextDTO ctx, OrderPackageInfo orderPackageInfo){
		return orderPackageInfo;
	}
	
	/**
	 * 根据服务项目判医嘱时自费还是医保<br>
	 * 如果有一个费用项目是医保, 返回医保，否则返回自费
	 * @param orderPackageInfo
	 * @return FBoolean.TRUE 医保，FBoolean.FALSE 自费
	 */
	private FBoolean getFg_orhp(OrderPackageInfo orderPackageInfo) {

		OrderSrvMmInfo[] orderSrvMmInfos = orderPackageInfo.getAllOrderSrvMmList().asArray();
		for(OrderSrvMmInfo orderSrvMmInfo : orderSrvMmInfos){
			OrdSrvDO ordSrv = orderSrvMmInfo.getOrderSrvInfo();
			
			if(DOStatus.DELETED == ordSrv.getStatus() || !FBoolean.TRUE.equals(ordSrv.getFg_bl())){
				continue;
			}
			
			if(HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge() ) || ordSrv.getEu_hpindicjudge() == null){
				return null;
			}
			
			if(FBoolean.FALSE.equals(ordSrv.getFg_selfpay())){
				return FBoolean.TRUE;
			}
		}

		return FBoolean.FALSE;
	}
	
	/**
	 * 获取医嘱的判断类型
	 * @param orderPackageInfo
	 * @return
	 */
	private Integer getEu_hpindicjudge(OrderPackageInfo orderPackageInfo){
		
		List<OrdSrvDO> ordSrvList = new ArrayList<OrdSrvDO>();
		
		OrderSrvMmInfo[] orderSrvMmInfos = orderPackageInfo.getAllOrderSrvMmList().asArray();
		for(OrderSrvMmInfo orderSrvMmInfo : orderSrvMmInfos){
			OrdSrvDO ordSrv = orderSrvMmInfo.getOrderSrvInfo();
			
			if(DOStatus.DELETED == ordSrv.getStatus() || !FBoolean.TRUE.equals(ordSrv.getFg_bl())){
				continue;
			}
			
			ordSrvList.add(ordSrv);
		}
		
		// 不存在费用项目，返回判断类型为非费用项目
		if(ordSrvList.size() == 0){
			return HpIndicJudgeRstEnum.NON_BLITEM;
		}
		
		// 费用项目是否全为不需要判断
		boolean isAllNeverJudge =true;

		for (OrdSrvDO ordSrv : ordSrvList) {

			Integer eu_hpindicjudg = ordSrv.getEu_hpindicjudge();
			
			// 存在空的，未进行医保适应症判断
			if (ordSrv.getEu_hpindicjudge() == null) {
				return null;
			}
			
			// 如果存在非医保就诊的费用项目，返回本次非医保就诊
			if(HpIndicJudgeRstEnum.NON_MEDICAL.equals(eu_hpindicjudg)){
				return HpIndicJudgeRstEnum.NON_MEDICAL;
			}

			// 如果存在待判断的费用项目，返回待判断
			if (HpIndicJudgeRstEnum.WAITING_JUDGE.equals(eu_hpindicjudg)) {
				return HpIndicJudgeRstEnum.WAITING_JUDGE;
			}

			// 如果存在医生判断的费用项目，返回为医生判断
			if (HpIndicJudgeRstEnum.DOCTOR_JUDGE.equals(eu_hpindicjudg)) {
				return HpIndicJudgeRstEnum.DOCTOR_JUDGE;
			}
			
			if(!HpIndicJudgeRstEnum.NEVER_JUDGE.equals(eu_hpindicjudg)){
				isAllNeverJudge = false;
			}
			
		}
		
		if(isAllNeverJudge){
			return HpIndicJudgeRstEnum.NEVER_JUDGE;
		}

		return HpIndicJudgeRstEnum.SYSTEM_JUDGE;
	}

	/**
	 * 处理返回值结果
	 * 
	 * @param ctx
	 * @param szInnerOrderSaveInfo
	 * @param rst
	 * @throws BizException
	 */
	protected EmsRstDTO[] handleEmsRstInfos(CiEnContextDTO ctx, EmsSaveRstInfo emsSaveRstInfo, EmsRstDTO rst)
			throws BizException {
		StringList idorList = new StringList();
		for (CiOrderDO ord : emsSaveRstInfo.szOrderInfo) {
			idorList.add(ord.getId_or());
		}
		if (idorList.size() > 0) {
			rst.getDocument().addAll(new OrderLoadBP().load(ctx, idorList.asArray()));

			// TODO: 医保适应症
		}
		return new EmsRstDTO[] { rst };
	}

	/**
	 * 医嘱包默认值处理规则
	 * 
	 * @param ctx
	 * @param pInfo
	 */
	protected void handleOrderPackageInfoDefaultValue(CiEnContextDTO ctx, ObjectList uiDataList) {

	}

	/**
	 * 是否断点执行器逻辑
	 * 
	 * @param emsList
	 * @return
	 */
	protected boolean hasStackPoint(ObjectList emsList) {

		return emsList.get(0) instanceof IStackPointAction;
	}

	/**
	 * 验证版本
	 * 
	 * @author yzh
	 * @param ems
	 * @throws BizException
	 */
	protected ErrorEmsList orSvValidate(CiEnContextDTO ctx, EmsSaveDTO ems) throws BizException {
		if (ems.getStatus() == DOStatus.NEW)
			return null;// 值判断编辑的情况
		if (ems != null && ems.getDocument() != null && ems.getDocument().size() > 0) {
			if (ems.getDocument().get(0) instanceof StackPointDTO) {
				ErrorEmsList eerList = new ErrorEmsList();
				List<CiOrderDO> ciorderList = new ArrayList<CiOrderDO>();
				for (Object objInfo : ems.getDocument()) {
					CiOrderDO ordo = new CiOrderDO();
					StackPointDTO spd = (StackPointDTO) objInfo;
					OrderPackageInfo pInfo = popStack(ctx, spd.getStackKey());
					if (!CiOrdUtils.isEmpty(pInfo) && !CiOrdUtils.isEmpty(pInfo.getOrderInfo())) {
						ordo.setName_or(pInfo.getOrderInfo().getName_or());
						ordo.setSv(pInfo.getOrderInfo().getSv());
						ordo.setId_or(pInfo.getOrderInfo().getId_or());
						ciorderList.add(ordo);
					}
				}
				if (!CiOrdUtils.isEmpty(ciorderList)) {
					JudgeOrderStatusBP bp = new JudgeOrderStatusBP();
					bp.exe(ciorderList.toArray(new CiOrderDO[] {}), eerList, ctx);
					return eerList;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param stackey
	 * @return
	 */
	protected <T> T popStack(CiEnContextDTO ctx, String stackey) {
		return EmsStackInfoCache.GetCache(ctx, "StackPoint_Session" + "," + ctx.getId_en(), stackey);
	}

	protected <T> void pushStack(CiEnContextDTO ctx, String stackey, T value) {
		EmsStackInfoCache.PutCache(ctx, "StackPoint_Session" + "," + ctx.getId_en(), stackey, value);
	}

	/**
	 * 处理医嘱包的保存
	 * 
	 * @param ctx
	 * @param szOrderPackageInfo
	 * @return
	 * @throws BizException
	 */
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {

		EmsSaveRstInfo emsSaveRstInfo = new EmsSaveRstInfo();

		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPackageInfo);

		// 保存医嘱服务物品信息
		OrdSrvMmDO[] szOrdSrvMmInfo = orderPackageInfoList.asOrderSrvMmArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvMmInfo)) {
			emsSaveRstInfo.szOrderSrvMmInfo = CiOrdAppUtils.getOrsrvmmService().save(szOrdSrvMmInfo);

		}
		// 保存医嘱服务信息
		OrdSrvDO[] szOrdSrvInfo = orderPackageInfoList.asOrderSrvArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvInfo)) {
			emsSaveRstInfo.szOrderSrvInfo = ServiceFinder.find(IOrdSrvDOCudService.class).save(szOrdSrvInfo);
		}
		// 保存医嘱信息
		CiOrderDO[] szOrderInfo = orderPackageInfoList.asOrderArray();
		this.setOrdSortno(szOrderInfo, ctx.getId_en());// 设置医嘱序号
		if (!CiOrdUtils.isEmpty(szOrderInfo)) {
			emsSaveRstInfo.szOrderInfo = ServiceFinder.find(ICiorderMDOCudService.class).save(szOrderInfo);

		}

		return emsSaveRstInfo;
	}

	protected <T extends BaseDO> DefaultCreateParam[] SingleSrv_DefaultCreateParamArrayOf(List<Object> listUiModel)
			throws BizException {
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		for (Object uiModel : listUiModel) {
			T doInfo = (T) uiModel;
			som.put(doInfo.getAttrVal("Id_srv").toString(), uiModel);
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),
				FBoolean.FALSE);
		assert CiOrdUtils.isEmpty(szMedSrvInfo) : "获取医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo) {
			listDefaultCreateParam.add(new DefaultCreateParam(srvInfo, som.get(srvInfo.getId_srv())));
		}
		return listDefaultCreateParam.asArray();
	}

	protected <T extends BaseDO> DefaultCreateParam[] GroupDrugs_DefaultCreateParamArrayOf(List<Object> listUiModel)
			throws BizException {
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();

		return listDefaultCreateParam.asArray();
	}

	/**
	 * 构建医嘱保存时候的数据对象数组
	 * 
	 * @param objList
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] handleOrderAggInfoList(CiEnContextDTO ctx, ObjectList objList) throws BizException {
		OrderPackageInfoList listOrderPakageInfo = new OrderPackageInfoList();
		// 定义新建医嘱集合与更新医嘱集合
		List<Object> listCreateInfo = new ArrayList<Object>();
		List<Object> listUpdateInfo = new ArrayList<Object>();
		for (Object objInfo : objList) {
			// 是否为新建医疗单
			if (GetSrvObjStatus(objInfo) == DOStatus.NEW) {
				listCreateInfo.add(objInfo);
			}
			// 更新医疗单
			else if (GetSrvObjStatus(objInfo) == DOStatus.UPDATED || GetSrvObjStatus(objInfo) == DOStatus.DELETED) {
				listUpdateInfo.add(objInfo);
			}
		}

		OrderPackageInfo[] szCreateOrderAgg = handleCreateOrderInfo(ctx, listCreateInfo);
		if (szCreateOrderAgg != null && szCreateOrderAgg.length > 0) {
			listOrderPakageInfo.addAll(Arrays.asList(szCreateOrderAgg));
		}

		OrderPackageInfo[] szUpdateOrderAgg = handleUpdateOrderInfo(ctx, listUpdateInfo);
		if (szUpdateOrderAgg != null && szUpdateOrderAgg.length > 0) {
			listOrderPakageInfo.addAll(Arrays.asList(szUpdateOrderAgg));
		}

		return listOrderPakageInfo.asArray();
	}

	/**
	 * 处理新建医嘱逻辑
	 * 
	 * @param itemDO
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] handleCreateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel)
			throws BizException {
		if (listUiModel == null || listUiModel.size() <= 0)
			return null;

		return mergeOrderPakageInfo(ctx,
				getDefaultCreateOrderInfo().createOrderPakageInfo(ctx, defaultCreateParamFrom(listUiModel)));
	}

	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		return null;
	}

	/**
	 * 处理医嘱更新逻辑
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param listUiModel
	 *            医疗单模型列表
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] handleUpdateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel)
			throws BizException {

		return null;
	}

	protected int GetSrvObjStatus(Object objDO) {
		return DOStatus.UNCHANGED;
	}

	protected OrderSrvMmList createOrderSrvMmList(CiOrderDO orderInfo, Object[] szSrvViewDTO) throws BizException {
		return null;
	}

	@SuppressWarnings("unchecked")
	protected void orderSrvMmListFrom(OrderPackageInfo opi, SrvKey2UiModelMap srvKeyUiModelCache, CiOrderDO orderInfo,
			OrdSrvDO[] szOrdSrvDO, OrdSrvMmDO[] szOrdSrvMmDO) throws BizException {
		// 定义临时缓存映射表
		Map<String, OrdSrvMmDO> tmpSrvKeyOrdSrvMmCache = new HashMap<String, OrdSrvMmDO>();
		// 业务态物品信息集合缓存（id_orsrv->SrvMMDO对象）
		if (!CiOrdUtils.isEmpty(szOrdSrvMmDO)) {
			for (OrdSrvMmDO mmInfo : szOrdSrvMmDO) {
				tmpSrvKeyOrdSrvMmCache.put(mmInfo.getId_orsrv(), mmInfo);
			}
		}

		Object uiModel_MainSrv = null;
		for (OrdSrvDO srvInfo : szOrdSrvDO) {
			if (uiModel_MainSrv == null) {
				if (srvKeyUiModelCache.containsKey(srvInfo.getId_orsrv())) {
					uiModel_MainSrv = srvKeyUiModelCache.get(srvInfo.getId_orsrv());
				}
			}
		}

		List<OrdSrvDO> lstOrdSrvDO = new ArrayList<OrdSrvDO>(Arrays.asList(szOrdSrvDO));
		Collections.sort(lstOrdSrvDO, new SortBySrvNO());
		OrderSrvMmList ordSrvMmInfoList = new OrderSrvMmList();
		for (OrdSrvDO srvInfo : lstOrdSrvDO) {
			Object uiModel = null;
			if (srvKeyUiModelCache.containsKey(srvInfo.getId_orsrv())) {
				uiModel = srvKeyUiModelCache.get(srvInfo.getId_orsrv());
				srvKeyUiModelCache.remove(srvInfo.getId_orsrv());
			} else {
				uiModel = uiModel_MainSrv;
			}

			// 创建 服务物品信息聚合结构对象
			OrderSrvMmInfo orderSrvMmInfo = new OrderSrvMmInfo(srvInfo, uiModel);

			// 判断是否存在服务的物品信息，存在，则将物品信息设置到 服务物品信息聚合结构中
			if (tmpSrvKeyOrdSrvMmCache.containsKey(srvInfo.getId_orsrv())) {
				orderSrvMmInfo.setOrderSrvMmInfo(tmpSrvKeyOrdSrvMmCache.get(srvInfo.getId_orsrv()));
			}
			ordSrvMmInfoList.add(orderSrvMmInfo);
		}
		// 检查【主键和UI模型的映射(Id_srv->ViewDTO)对象映射集合】中是否有剩余数据（剩余数据为 客户端新增服务）
		if (srvKeyUiModelCache.size() > 0) {
			// TODO :创建 服务物品信息聚集对象
			OrderSrvMmList ls = createOrderSrvMmList(orderInfo, srvKeyUiModelCache.values().toArray());
			if (null != ls) {
				ordSrvMmInfoList.append(ls);
			}
		}
		// 将服务物品信息结合设置到医嘱包中
		opi.setOrderSrvMmList(ordSrvMmInfoList);
	}

	/**
	 * 根据医嘱OrderDO对象和服务物品结合，或者定义态服务bd_srv和bd_mm的信息聚合结构列表
	 * 
	 * @param orderInfo
	 * @param ordSrvMmInfoList
	 * @return
	 * @throws BizException
	 */
	protected BdSrvInfoList bdSrvInfoListFrom(CiOrderDO orderInfo, OrderSrvMmList ordSrvMmInfoList)
			throws BizException {
		if (CiOrdUtils.isTrue(orderInfo.getFg_set())) {
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[] { orderInfo.getId_srv() });
			return (new BdSrvInfoList(szMedSrvInfo));
		} else {

			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(ordSrvMmInfoList.asSrvKeyArray());
			return (new BdSrvInfoList(szMedSrvInfo));
		}
	}

	protected boolean canMergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo) {
		return true;
	}

	/**
	 * 合并用户数据到默认医嘱中
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param szOrderPakageInfo
	 *            批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException
	 *             业务异常
	 */
	protected OrderPackageInfo[] mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo)
			throws BizException {
		//
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {

			// 合并医嘱UI模型数据
			mergeOrderInfo(ctx, pInfo);
			//pInfo.getOrderInfo(), pInfo.getOrderSrvMmList().get(0).getUiModel()
			// 合并服务UI模型数据
			for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
				// 合并服务信息
				mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), srvMmInfo.getUiModel());
				// 处理其他信息
				afterMergeOrderSrvInfo(ctx, pInfo.getOrderInfo(), srvMmInfo.getOrderSrvInfo(), srvMmInfo.getUiModel());
				// 合并药品
				if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())) {
					mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(), srvMmInfo.getUiModel());
				}
			}
			afterMergeOrderPakageInfo(ctx, pInfo.getOrderInfo(), pInfo.getOrderSrvList(), pInfo.getUiModel());
		}
		return szOrderPakageInfo;
	}

	/**
	 * 将UI模型数据合并到医嘱信息中
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderInfo(CiEnContextDTO ctx, OrderPackageInfo pInfo) throws BizException {

	}

	/**
	 * 将UI信息合并到服务中
	 * 
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {

	}

	/**
	 * 合并服务信息之后的处理
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, final CiOrderDO orderInfo, OrdSrvDO srvInfo,
			Object uiModel) throws BizException {
		srvInfo.setId_dep_mp(orderInfo.getId_dep_mp());
		srvInfo.setDt_last_bl(orderInfo.getDt_last_bl());
	}

	/**
	 * 合并服务套服务信息之后的处理
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void afterMergeOrderSetSrvInfo(CiEnContextDTO ctx, final CiOrderDO orderInfo, OrdSrvDO srvInfo,
			Object uiModel, int sortno) throws BizException {

	}

	/**
	 * 合并服务信息之后处理医嘱相关信息
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void afterMergeOrderPakageInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] srvInfos,
			Object uiModel) throws BizException {
		// 计算不计费标志
		/**
		 * ①　	在医嘱列表上增加【费用标志】列，下拉参照使用【sd_nodispense不计费类型】档案字典。
		 * ②　	药品保存：针对选中的药品置上数据。
		 * ③　	非药品数据保存：需要赋值的数据
		 * a)	由医嘱本身关联出的费用，即临床项目费用。
		 * b)	临床项目本身
		 * c)	特殊说明：非临床项目费用对应【sd_nodispense不计费类型】 = 空，如用法关联、煎法关联、标本采集费用。
		 */
		OrdSrvDO mainSrvInfo = this.getMainSrvInfo(orderInfo, srvInfos);
		if(null != mainSrvInfo){
			for(OrdSrvDO srvInfo : srvInfos){
				// 非物品的临床服务项目,不计费标志跟随主服务一样
				if(!CiOrdUtils.isTrue(mainSrvInfo.getFg_mm()) &&
						!CiOrdUtils.isTrue(srvInfo.getFg_mm()) && 
						"0,2,8".contains(srvInfo.getEu_sourcemd().toString())){
					srvInfo.setId_nodispense(mainSrvInfo.getId_nodispense());
					srvInfo.setSd_nodispense(mainSrvInfo.getSd_nodispense());
					srvInfo.setName_nodispense(mainSrvInfo.getName_nodispense());
				}
			}
		}
		// 多剂量多频次计算总量
		handleSrvQuan(orderInfo, srvInfos);
	}

	/**
	 * 
	 * @param ctx
	 * @param opInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {

	}

	/**
	 * 合并申请单之后的处理
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param appSheetList
	 * @param extInfoList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void afterMergeOrderAppInfo(CiEnContextDTO ctx, final CiOrderDO orderInfo, Object[] appSheetList,
			Object[] extInfoList, Object uiModel) throws BizException {

	}

	/**
	 * 合并物品信息
	 * 
	 * @param ctx
	 * @param mmList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO srvMmInfo, Object uiModel) throws BizException {

	}

	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException {
		return OrderUtils.QryOrderAppSheetList(szId_or);
	}

	/**
	 * 医嘱内容拼接
	 * 
	 * @param ctx
	 * @param uiModel
	 * @return
	 */
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx, Object uiModel) {
		return CiOrContentUtils.getNullContent();
	}

	/**
	 * 设置医嘱的排序号
	 * 
	 * @param szOrderInfo
	 * @param id_en
	 * @throws BizException
	 */
	protected void setOrdSortno(CiOrderDO[] szOrderInfo, String id_en) throws BizException {
		String qryMaxSortno = "select max(nvl(sortno,0)) from ci_order where id_en = '" + id_en + "'";
		Integer result = (Integer) new DAFacade().execQuery(qryMaxSortno, new ColumnHandler());
		if (result == null) {
			result = 0;
		}
		for (CiOrderDO ciOrd : szOrderInfo) {
			if (CiOrdUtils.isEmpty(ciOrd.getSortno())) {
				ciOrd.setSortno(++result);
			}
		}
	}

	protected FDouble getPrice4OrSrv(String id_srv, String id_primd, String id_pripat) throws BizException {
		CiOrBdSrvPricesCalByPriModeBP bp = new CiOrBdSrvPricesCalByPriModeBP();
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
		priParam.setId_srv(id_srv);
		priParam.setId_primd(id_primd);
		priParam.setNum(0);
		MedSrvPriceDO priceDo = bp.exec(priParam, id_pripat);
		return priceDo.getPrice_ratio();
	}

	/**
	 * 多频次 多剂量 计算orsrv总量
	 * 
	 * @throws BizException
	 */
	protected void handleSrvQuan(CiOrderDO order, OrdSrvDO[] ordsrvs) throws BizException {
		String sd_srvtp = order.getSd_srvtp();

		CalQuantumBP bp = new CalQuantumBP();
		if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
				|| sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)
				|| sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
			OrdSrvDO mainsrv = getMainSrvInfo(order, ordsrvs);
			if (FBoolean.TRUE.equals(order.getFg_set())) {

				if (!CiOrdUtils.isEmpty(mainsrv)) {
					if (CiOrdUtils.isSrvsetMemberCntPrimd(mainsrv.getId_primd())) {// 套成员个数定价
						for (OrdSrvDO ordSrvDO : ordsrvs) {
							if (ordSrvDO.getFg_set().equals(FBoolean.FALSE)) {
								ordSrvDO.setQuan_medu(order.getQuan_medu());
							}
							QuantumParamDTO quantum = new QuantumParamDTO(order, ordSrvDO, true);
							//0191614: 临床路劲管理中维护腹部平片，医生站开立提示总量单位为空。
							if(ordSrvDO.getFg_mm()!=null&&ordSrvDO.getFg_mm().booleanValue()&&ordSrvDO.getId_mm()!=null) {
								   IMaterialBaseInfoService meterialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
						           MaterialUnitDTO[] materUnit = meterialBaseService.getMMunitByEntp(new String[]{ordSrvDO.getId_mm()}, order.getCode_entp());
						           if (materUnit != null && materUnit.length > 0)
						           {
						        	   quantum.setId_unit_sale(materUnit[0].getId_measdoc());
						           }

							}
							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
						}
					} else if (CiOrdUtils.isSrvsetMemCntAdditionalPrimd(mainsrv.getId_primd())) {// 套成员个数加收
						for (OrdSrvDO ordSrvDO : ordsrvs) {
							if (ordSrvDO.getFg_set().equals(FBoolean.FALSE)
									&& ordSrvDO.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMPRIMD) {
								ordSrvDO.setQuan_medu(ordSrvDO.getQuan_medu().multiply(order.getQuan_medu()));
							}
							QuantumParamDTO quantum = new QuantumParamDTO(order, ordSrvDO, true);
							//0191614: 临床路劲管理中维护腹部平片，医生站开立提示总量单位为空。
							if(ordSrvDO.getFg_mm()!=null&&ordSrvDO.getFg_mm().booleanValue()&&ordSrvDO.getId_mm()!=null) {
								   IMaterialBaseInfoService meterialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
						           MaterialUnitDTO[] materUnit = meterialBaseService.getMMunitByEntp(new String[]{ordSrvDO.getId_mm()}, order.getCode_entp());
						           if (materUnit != null && materUnit.length > 0)
						           {
						        	   quantum.setId_unit_sale(materUnit[0].getId_measdoc());
						           }

							}
							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
						}
					} else if (CiOrdUtils.isSrvsetMemberSumPrimd(mainsrv.getId_primd())) {// 套成员合计计价
						for (OrdSrvDO ordSrvDO : ordsrvs) {
							ordSrvDO.setQuan_medu(order.getQuan_medu());
							QuantumParamDTO quantum = new QuantumParamDTO(order, ordSrvDO, false);
							//0191614: 临床路劲管理中维护腹部平片，医生站开立提示总量单位为空。
							if(ordSrvDO.getFg_mm()!=null&&ordSrvDO.getFg_mm().booleanValue()&&ordSrvDO.getId_mm()!=null) {
								   IMaterialBaseInfoService meterialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
						           MaterialUnitDTO[] materUnit = meterialBaseService.getMMunitByEntp(new String[]{ordSrvDO.getId_mm()}, order.getCode_entp());
						           if (materUnit != null && materUnit.length > 0)
						           {
						        	   quantum.setId_unit_sale(materUnit[0].getId_measdoc());
						           }

							}
							ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
						}
					}
				}
			} else {
				for (OrdSrvDO ordSrvDO : ordsrvs) {
					QuantumParamDTO quantum = new QuantumParamDTO(order, ordSrvDO, false);
					if (!CiOrdUtils.isTrue(ordSrvDO.getFg_or())) {
						ordSrvDO.setQuan_medu(mainsrv.getQuan_medu().multiply(ordSrvDO.getQuan_medu()));
					}
					//0191614: 临床路劲管理中维护腹部平片，医生站开立提示总量单位为空。
					if(ordSrvDO.getFg_mm()!=null&&ordSrvDO.getFg_mm().booleanValue()&&ordSrvDO.getId_mm()!=null) {
						   IMaterialBaseInfoService meterialBaseService = ServiceFinder.find(IMaterialBaseInfoService.class);
				           MaterialUnitDTO[] materUnit = meterialBaseService.getMMunitByEntp(new String[]{ordSrvDO.getId_mm()}, order.getCode_entp());
				           if (materUnit != null && materUnit.length > 0)
				           {
				        	   quantum.setId_unit_sale(materUnit[0].getId_measdoc());
				           }

					}
					ordSrvDO.setQuan_total_medu(bp.getQuantum(quantum));
				}
			}
		}

	}

	/**
	 * 获得orsrv中的主服务
	 * 
	 * @param ordo
	 * @param ordsrvs
	 * @return
	 */
	private OrdSrvDO getMainSrvInfo(CiOrderDO ordo, OrdSrvDO[] ordsrvs) {
		for (OrdSrvDO ordSrvDO : ordsrvs) {
			if (ordo.getId_srv().equals(ordSrvDO.getId_srv())) {
				return ordSrvDO;
			}
		}
		return null;
	}

	/**
	 * 患者为在径患者时，需要判断所开医嘱的径内和径外标志，给医嘱ci_order的Eu_uncporjudge，字段赋值（0：不需要判断，1：待判断，2:已判断）
	 * 
	 * @param ctx
	 * @param szOrderPackageInfo
	 * @throws BizException
	 */
	protected void handleHpAppOrDoctorCheckInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {

		String id_ent = ctx.getId_en();
		// 判断是否临床路径患者
		IHpcpAppItfService service = CiOrdAppUtils.getIHpcpAppItfService();
		if (null != service && service.getEntIncpFlagExcludeWaitcp(id_ent)) {
			List<CiorderAggDO> ciorList = new ArrayList<CiorderAggDO>();
			for (OrderPackageInfo orderPackageInfo : szOrderPackageInfo) {
				CiorderAggDO aggDO = new CiorderAggDO();
				CiOrderDO ciOrderDO = orderPackageInfo.getOrderInfo();
				OrdSrvDO[] ordSrvDOs = orderPackageInfo.getOrderSrvList();
				aggDO.setParentDO(ciOrderDO);
				aggDO.setOrdSrvDO(ordSrvDOs);
				ciorList.add(aggDO);
			}
			try {
				CiorderAggDO[] aggArrays = ciorList.toArray(new CiorderAggDO[0]);
				CiOrdAppUtils.getIHpcpAppItfService().checkCiorderSrv(id_ent, aggArrays);
				if (CiOrdUtils.isEmpty(aggArrays))
					return;
				for (CiorderAggDO aggdo : aggArrays) {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class SortBySrvNO implements Comparator {
		public int compare(Object o1, Object o2) {
			OrdSrvDO s1 = (OrdSrvDO) o1;
			OrdSrvDO s2 = (OrdSrvDO) o2;
			if(s1.getSortno() == null || DOStatus.DELETED == s1.getStatus()){
				return 1;
			}
			if(s2.getSortno() == null || DOStatus.DELETED == s2.getStatus()){
				return -1;
			}
			if (s1.getSortno() > s2.getSortno()){
				return 1;
			}
			return -1;
		}
	}
}

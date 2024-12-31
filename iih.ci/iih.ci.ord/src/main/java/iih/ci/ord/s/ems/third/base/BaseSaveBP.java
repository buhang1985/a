package iih.ci.ord.s.ems.third.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.third.def.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.third.pres.PatchFeePresSplitBP;
import iih.ci.ord.s.ems.utils.CiEnContextUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 补费药品保存的基类
 * @author zhangwanqing
 *
 */
public class BaseSaveBP {
	protected FDateTime now = new FDateTime();
	/**
	 * 保存医嘱信息
	 * @param pakageInfo
	 * @return
	 * @throws BizException
	 */
	protected ThirdRstDTO saveData(OrderPakageInfo[] pakageInfo) throws BizException{
		PatchFeePresSplitBP split = new PatchFeePresSplitBP(); 
		FArrayList aggs = new FArrayList();
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		ThirdRstDTO ThirdRst = new ThirdRstDTO();
		for (OrderPakageInfo opInfo : pakageInfo) {
			// 保存医嘱
			CiorderAggDO[] szRstOrderAggInfo = CiOrdAppUtils.getOrAggService()
					.save(new CiorderAggDO[] { opInfo.getOrderAggInfo() });
			// 保存物品信息
			if (opInfo.getOrderSrvMmList() != null && opInfo.getOrderSrvMmList().size() > 0) {
				CiOrdAppUtils.getOrsrvmmService().save(updateOrderSrvMMInfo(szRstOrderAggInfo[0].getOrdSrvDO(), opInfo.getOrderSrvMmList()));
			}
			aggs.add(szRstOrderAggInfo[0]);
			orders.add(szRstOrderAggInfo[0].getParentDO());
		}
		ThirdRst.setOrderAggInfoList(aggs);
		ThirdRst.setSuccessful(FBoolean.TRUE);
		// 分方操作,使用老的分方规则，不需要CiEnContext对象
		split.exec(null,orders.toArray(new CiOrderDO[0]), null);
		//拆分事件
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,orders.toArray(new CiOrderDO[0]));
		return ThirdRst;
	}
	/**
	 * 组装数据
	 * @param pat
	 * @param params
	 * @param defaultparam
	 * @return
	 * @throws BizException
	 */
	protected OrderPakageInfo[] assembleData(PatiVisitDO pat, ChargeForCiParamDTO[] params, DefaultCreateParam[] defaultparam) throws BizException{
		CiEnContextUtils enContexxt = new CiEnContextUtils();
		DefaultDrugsCreateOrderInfo defaultDrug = new DefaultDrugsCreateOrderInfo();
		CiEnContextDTO ctx = enContexxt.getCiEnContextDTO(pat);
		this.setCiEnContextDTO(ctx, params[0]);
		Context.get().setAttribute("CiEnContextDTO",ctx);
		OrderPakageInfo[] szOrderPakageInfo = defaultDrug.createOrdeAggInfo(ctx,defaultparam);
		Map<String, ChargeForCiParamDTO> tempChargeMap = new HashMap<String, ChargeForCiParamDTO>();
		for (ChargeForCiParamDTO dto : params) {
			tempChargeMap.put(dto.getId_srv(), dto);
		}
		// 给总量赋值
		handleUserParameter(szOrderPakageInfo, tempChargeMap);
		return szOrderPakageInfo;
	}
	/**
	 * 给总量赋值
	 * 
	 * @param szOrderPakageInfo
	 * @param tempChargeMap
	 * @throws BizException 
	 */
	protected void handleUserParameter(OrderPakageInfo[] szOrderPakageInfo,
			Map<String, ChargeForCiParamDTO> tempChargeMap) throws BizException {
		for (OrderPakageInfo opInfo : szOrderPakageInfo) {
			opInfo.getOrderAggInfo().getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
			opInfo.getOrderAggInfo().getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
			opInfo.getOrderAggInfo().getParentDO().setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
			opInfo.getOrderAggInfo().getParentDO().setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
			opInfo.getOrderAggInfo().getParentDO().setFg_chk(FBoolean.TRUE);
			opInfo.getOrderAggInfo().getParentDO().setId_emp_chk(Context.get().getStuffId());
			opInfo.getOrderAggInfo().getParentDO().setId_dep_chk(Context.get().getDeptId());
			opInfo.getOrderAggInfo().getParentDO().setDt_chk(now);
			opInfo.getOrderAggInfo().getParentDO().setDt_last_bl(now);
			opInfo.getOrderAggInfo().getParentDO().setFg_sign(FBoolean.TRUE);
			opInfo.getOrderAggInfo().getParentDO().setDt_sign(now);
			opInfo.getOrderAggInfo().getParentDO().setDt_effe(now);
			List<OrdSrvMmDO> mms = opInfo.getOrderSrvMmList();
			Map<String,OrdSrvMmDO> teamMM = new HashMap<String,OrdSrvMmDO>();
			if (!CiOrdUtils.isEmpty(mms)) {
				for (OrdSrvMmDO mm : mms) {
					String key = mm.getId_srv()+mm.getId_mm();
					teamMM.put(key, mm);
					if (tempChargeMap.containsKey(key)) {
						mm.setFactor(getFactor(mm.getId_mm(),tempChargeMap.get(key).getId_unit_pkg(),opInfo.getOrderAggInfo().getParentDO().getCode_entp()));
						mm.setQuan_cur(new FDouble(tempChargeMap.get(key).getQuan()));
						mm.setPrice_pgku_cur(tempChargeMap.get(key).getPrice());
						mm.setId_pgku_cur(tempChargeMap.get(key).getId_unit_pkg());
					}
				}
			}
			OrdSrvDO[] results = opInfo.getOrderAggInfo().getOrdSrvDO();
			if (!CiOrdUtils.isEmpty(results)) {
				for (OrdSrvDO srv : results) {
					String key = srv.getId_srv()+(srv.getId_mm()==null?"":srv.getId_mm());
					if (tempChargeMap.containsKey(key)) {
						ChargeForCiParamDTO param = tempChargeMap.get(key);
						srv.setQuan_total_medu(new FDouble(param.getQuan()));
						if(StringUtils.isNotEmpty(param.getId_dep_wh())){
							srv.setId_dep_wh(param.getId_dep_wh());
						}
						if(CiOrdUtils.isEmpty(srv.getQuan_medu())){
							if(!CiOrdUtils.isEmpty(srv.getId_mm())&&teamMM.containsKey(key))
							srv.setQuan_medu(this.getQuan_medu(srv.getQuan_total_medu(),teamMM.get(key).getFactor(), teamMM.get(key).getFactor_mb()));
						}
					}
				}
			}
		}
	}
	/**
	 * 获得患者就诊ID，传入的参数是同一个就诊患者的，所以去任一个就诊id就可以了
	 * @param params
	 * @return
	 * @throws BizException
	 */
	protected String getId_ent(ChargeForCiParamDTO[] params) throws BizException{
		for(ChargeForCiParamDTO param:params){
			if(!CiOrdUtils.isEmpty(param.getId_ent())){
				return param.getId_ent();
			}
		}
		throw new BizException("就诊主键为空！");
	}
	/**
	 * 获得患者信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	protected PatiVisitDO getParInfo(String id_ent) throws BizException{
		if(CiOrdUtils.isEmpty(id_ent))
			return null;
		return CiOrdAppUtils.getEnOutQryService().getEnInfo(id_ent);
	}
	/**
	 * 生成默认医疗单时所需要的参数
	 * @param params
	 * @return
	 * @throws BizException
	 */
	protected Map<String,DefaultCreateParam[]> defaultCreateParamFrom(ChargeForCiParamDTO[] params) throws BizException {
		Map<String,DefaultCreateParam[]> teamMap = new HashMap<String,DefaultCreateParam[]>();
		List<DefaultCreateParam> defaultDrugsParams = new ArrayList<DefaultCreateParam>();
		List<DefaultCreateParam> defaultTreatParams = new ArrayList<DefaultCreateParam>();
		for (ChargeForCiParamDTO param : params) {
			String[] id_srvs = new String[] { param.getId_srv() };
			DefaultCreateParam defaultParma = null;
			if (!CiOrdUtils.isEmpty(param.getFg_mm()) && param.getFg_mm().equals("Y")) {
				String[] id_mms = new String[] { param.getId_mm() };
				defaultParma = new DefaultCreateParam(id_srvs, id_mms);
			} else {
				defaultParma = new DefaultCreateParam(id_srvs);
			}
			if(!CiOrdUtils.isEmpty(param.getFg_mm())&&param.getFg_mm().equals("Y")){
				defaultDrugsParams.add(defaultParma);
			}else{
				defaultTreatParams.add(defaultParma);
			}
		}
		if(defaultDrugsParams.size()>0){
			teamMap.put("drug", defaultDrugsParams.toArray(new DefaultCreateParam[0]));
		}
		if(defaultTreatParams.size()>0){
			teamMap.put("treat", defaultTreatParams.toArray(new DefaultCreateParam[0]));
		}
		return teamMap;
	}
	/**
	 * 更新物品表中id_orsrv外键
	 * 
	 * @param orsrvs
	 * @param orsrvmms
	 */
	protected OrdSrvMmDO[] updateOrderSrvMMInfo(OrdSrvDO[] orsrvs, List<OrdSrvMmDO> orsrvmms) {
		for (OrdSrvMmDO mm : orsrvmms) {
			for (OrdSrvDO srv : orsrvs) {
				if (srv.getId_srv().equals(mm.getId_srv())) {
					mm.setId_orsrv(srv.getId_orsrv());
					mm.setStatus(DOStatus.NEW);
				}
			}
		}
		return orsrvmms.toArray(new OrdSrvMmDO[0]);
	}
	protected Map<String, ChargeForCiParamDTO> getTempChargeMap(ChargeForCiParamDTO[] params){
		Map<String, ChargeForCiParamDTO> tempChargeMap = new HashMap<String, ChargeForCiParamDTO>();
		for (ChargeForCiParamDTO param : params) {
			String key = param.getId_srv();
			if(!CiOrdUtils.isEmpty(param.getFg_mm())&&param.getFg_mm().equals("Y")){
				key+=param.getId_mm();
			}
			tempChargeMap.put(key, param);
		}
		return tempChargeMap;
	}
	/**
	 * 获得基本换算系数
	 * @param id_mm
	 * @param id_unit_pkg
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	protected FDouble getFactor(String id_mm,String id_unit_pkg,String code_entp) throws BizException{
		MaterialUnitDTO[] materials = BDMmDoseUnitInfoCache.getMaterialUnitInfos(code_entp, new String[]{id_mm});
		 
		for(MaterialUnitDTO material : materials){
			if(material.getId_mm().equals(id_mm)&&material.getId_measdoc().equals(id_unit_pkg)){
				return material.getFactor(); 
			}
		}
		return null;
	}
	/**
	 * 通过总量反算剂量
	 * @param quan_cur
	 * @param factor
	 * @param factor_mb
	 * @return
	 */
	protected FDouble getQuan_medu(FDouble quan_cur,FDouble factor,FDouble factor_mb){
		if(CiOrdUtils.isEmpty(quan_cur)||CiOrdUtils.isEmpty(factor)||CiOrdUtils.isEmpty(factor_mb)){
			return null;
		}
		return quan_cur.div(factor).div(factor_mb);
	}
	/**
	 * 从传入参数中设置就诊上下文信息
	 * @param ctx
	 * @param param
	 */
	protected void setCiEnContextDTO(CiEnContextDTO ctx,ChargeForCiParamDTO param){
		ctx.setId_emp_or(param.getId_emp());
	}
}

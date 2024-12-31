package iih.ei.std.s.v1.bp.mp.updatebyplan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.i.IBlOutCmdService;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.i.external.provide.ICiOrdMpService;
import iih.ei.std.d.v1.mp.updatestatus.d.PlanStatusForLisDTO;
import iih.ei.std.d.v1.mp.updatestatus.d.PlanStatusForLisParamDTO;
import iih.ei.std.s.v1.bp.common.EiParamUtils;
import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import iih.ei.std.s.v1.bp.mp.updatebyplan.qry.GetOrPlanByIdOrSql;
import iih.mp.nr.api.lis.d.OrMpPlanDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.mpcharge.IMpChargeService;
import iih.mp.nr.mpcharge.d.MpChargeSetDTO;
import iih.pi.overview.overview.d.PiPatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * @Description: 检验合管插入的材料费和采血费单独改状态计费
 * @author: ma.meng@founder.com.cn
 * @version： 2019年12月9日 上午11:44:33 创建
 */
public class UpdatePlanStatusForLis2Bp {

	private String code_entp;// 就诊类型
	private Map<String, String> infoMap;// 人员部门基本信息

	/**
	 * 主入口
	 * 
	 * @param params
	 * @param listParam
	 * @throws BizException
	 */
	public void exec(PlanStatusForLisParamDTO param) throws BizException {
		
		// 1.参数校验
		validateParam(param);
		
		// 2、获取入参集合
		PlanStatusForLisDTO[] params = getParams(param);
		
		// 3、获取申请单号集合
		String[] no_appliforms = getApplyForms(params);
		
		// 4、获取医嘱id
		String[] id_ors = getIdOrs(no_appliforms);

		// 5、查询医嘱计划
		OrMpPlanDTO[] orPlanDTOs = getPlans(id_ors); 

		// 6、基础校验
		validation(orPlanDTOs);

		// 7、实例化人员部门信息
		setMpData(params);
		
		// 8、计费处理
		setbill(orPlanDTOs, params, no_appliforms, id_ors);
		
		// 9、状态处理
		ServiceFinder.find(IForeignService.class).UpdateOrderStatus(id_ors);
		
	}
	
	/**
	 * 参数校验
	 * 
	 * @param statusParam
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validateParam(PlanStatusForLisParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("Lis合管检验参数空异常！");
		}
		List<PlanStatusForLisDTO> list = param.getPlanstatusforlisdtos();
		if (list == null || list.size() < 1) {
			throw new BizException("Lis合管检验参数空异常！");
		}
		for (PlanStatusForLisDTO dto : list) {
			if (StringUtil.isEmptyWithTrim(dto.getNo_applyform())) {
				throw new BizException("Lis合管检验申请单号为空！");
			}
		}
	}
	
	/**
	 * 获取入参集合
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private PlanStatusForLisDTO[] getParams(PlanStatusForLisParamDTO param){
		List<PlanStatusForLisDTO> params = param.getPlanstatusforlisdtos();
		return params.toArray(new PlanStatusForLisDTO[0]);
	}
	
	/**
	 * 获取申请单号集合
	 * 
	 * @param params
	 * @return
	 */
	private String[] getApplyForms(PlanStatusForLisDTO[] params) {
		List<String> rtns = new ArrayList<String>();
		if(params != null && params.length > 0){
			for (PlanStatusForLisDTO param : params) {
				if (!rtns.contains(param.getNo_applyform())) {
					rtns.add(param.getNo_applyform());
				}
			}
		}
		return rtns.toArray(new String[0]);
	}
	
	/**
	 * 获取医嘱id
	 * 
	 * @param fmap
	 * @return
	 * @throws BizException 
	 */
	private String[] getIdOrs(String[] no_appliforms) throws BizException{
		// 根据申请单号查询相关采血费用（医嘱的内部接口）
		FMap fmap = ServiceFinder.find(ICiOrdMpService.class).getSampInfoByApplyno(no_appliforms);
		if(fmap == null || fmap.size() < 1)
			return null;
		List<String> rtns = new ArrayList<String>();
		for (String fkey : fmap.keySet()) {
			String[] ids = ((String) fmap.get(fkey)).split(",");
			if(ids.length < 1)
				continue;
			for (String id_or : ids) {
				if(rtns.contains(id_or))
					continue;
				rtns.add(id_or);
			}
		}
		return rtns.toArray(new String[0]);
	}
	
	/**
	 * 查询医嘱计划
	 * 
	 * @param no_appliforms
	 * @return
	 * @throws BizException
	 */
	private OrMpPlanDTO[] getPlans(String[] id_ors) throws BizException{
		if(id_ors.length < 1){
			return null;
		}
		GetOrPlanByIdOrSql sql = new GetOrPlanByIdOrSql(id_ors);
		return (OrMpPlanDTO[]) AppFwUtil.getDORstWithDao(sql, OrMpPlanDTO.class);		
	}
	
	/**
	 * 参数校验
	 * 
	 * @param orMpPlanDTOs
	 * @throws BizException
	 */
	private void validation(OrMpPlanDTO[] orMpPlanDTOs) throws BizException {
		if(orMpPlanDTOs == null || orMpPlanDTOs.length < 1){
			throw new BizException("Lis合管单独更新状态：医嘱空异常");
		}
		String code_entp = orMpPlanDTOs[0].getCode_entp();
		if (StringUtil.isEmptyWithTrim(code_entp)) {
			throw new BizException("Lis合管单独更新状态：就诊类型空异常");
		}
	}
	
	/**
	 * 赋值执行人执行科室，执行执行时间
	 * 
	 * @param orPlanDTOs
	 * @param params
	 * @throws BizException
	 */
	private void setMpData(PlanStatusForLisDTO[] params) throws BizException {
		infoMap = new HashMap<String, String>();
		DeptDO[] deptDOs = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.CODE, params[0].getCode_dep());
		PsnDocDO[] psnDocDOs = ServiceFinder.find(IPsndocMDORService.class).findByAttrValString(PsnDocDO.CODE, params[0].getCode_emp());
		if (deptDOs != null && deptDOs.length > 0) {
			infoMap.put(deptDOs[0].getCode(), deptDOs[0].getId_dep());
			Context.get().setDeptId(deptDOs[0].getId_dep());
		}
		if (psnDocDOs != null && psnDocDOs.length > 0) {
			infoMap.put(psnDocDOs[0].getCode(), psnDocDOs[0].getId_psndoc());
			Context.get().setStuffId(psnDocDOs[0].getId_psndoc());
		}
	}
	
	/**
	 * 计费
	 * 
	 * @param orPlanDTOs
	 * @param params
	 * @param no_appliforms
	 * @throws BizException
	 */
	@SuppressWarnings("static-access")
	private void setbill(OrMpPlanDTO[] orPlanDTOs, PlanStatusForLisDTO[] params, String[] no_appliforms, String[] id_ors) throws BizException {
		code_entp = orPlanDTOs[0].getCode_entp();
		EiParamUtils param = new EiParamUtils();
		// 门诊计费
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
			if (IBlDictCodeConst.PARAM_VALUE_EXECACCOUNT.equals(param.BLCG0002())) {
				Map<String, List<String>> mapPat = getIdOrsByPatID(orPlanDTOs, ICiDictCodeConst.SD_SU_BL_NONE+","+ICiDictCodeConst.SD_SU_BL_REFOUND, id_ors);
				Set<String> idpat = mapPat.keySet();
				IBlOutCmdService service = ServiceFinder.find(IBlOutCmdService.class);
				for (String patId : idpat) {
					List<String> ordList = mapPat.get(patId);
					service.chareForOpPrepayOr(patId, ordList.toArray(new String[0]), IBlCgCodeConst.LisOrPacs);
				}
			}else{//非预交金模式
				Map<String, List<CiOrderDO>> mapPat = getCiOrsByPatID(orPlanDTOs, ICiDictCodeConst.SD_SU_BL_NONE, id_ors);
				if (!mapPat.isEmpty()) {
					DAFacade daf = new DAFacade();
					Set<String> idpatSet = mapPat.keySet();
					@SuppressWarnings("unchecked")
					List<PiPatDO> pats = (List<PiPatDO>) daf.findByPKs(PiPatDO.class, idpatSet.toArray(new String[idpatSet.size()]));
					if (null != pats && pats.size() > 0) {
						StringBuffer buffer = new StringBuffer();
						for (PiPatDO piPatDO : pats) {
							buffer.append("患者");
							buffer.append("【"+piPatDO.getName()+"】的");
							List<CiOrderDO> ciorders = mapPat.get(piPatDO.getId_pat());
							for (CiOrderDO ciOrderDO : ciorders) {
								buffer.append("【"+ciOrderDO.getName_or()+"】医嘱");
							}
							buffer.append("未交费\n");
						}
						throw new BizException(buffer.toString());
					}
				}
			}
		}
		//
		// 住院计费
		//
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
			String[] id_orprs = getIdOrPrs(orPlanDTOs);
			MpChargeSetDTO paramSet = getParamset();
			ServiceFinder.find(IMpChargeService.class).mpChargingByOrpr(id_orprs, paramSet);
		}
	}
	
	/**
	 * 获取医嘱计划id
	 * 
	 * @param orPlanDTOs
	 * @return
	 */
	private String[] getIdOrPrs(OrMpPlanDTO[] orPlanDTOs){
		List<String> rtns = new ArrayList<String>();
		for (OrMpPlanDTO param : orPlanDTOs) {
			if(rtns.contains(param.getId_or_pr()))
				continue;
			rtns.add(param.getId_or_pr());
		}
		return rtns.toArray(new String[0]);
	}
	
	/**
	 * 获取医嘱ID集合按患者ID分组
	 * 
	 * @param orPlanDTOs
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<String>> getIdOrsByPatID(OrMpPlanDTO[] orPlanDTOs, String sd_su_bl, String[] id_ors) throws BizException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) daf.findByPKs(CiOrderDO.class, id_ors, new String[] { CiOrderDO.ID_OR, CiOrderDO.ID_PAT, CiOrderDO.SD_SU_BL });
		if (orderDOs != null && orderDOs.size() > 0) {
			for (CiOrderDO ord : orderDOs) {
				if (sd_su_bl.contains(ord.getSd_su_bl())) {
					if (map.containsKey(ord.getId_pat())) {
						map.get(ord.getId_pat()).add(ord.getId_or());
					} else {
						List<String> rtnList = new ArrayList<String>();
						rtnList.add(ord.getId_or());
						map.put(ord.getId_pat(), rtnList);
					}
				}
			}
		}
		return map;
	}
	
	/**
	 * 获取医嘱集合按患者ID分组
	 * 
	 * @param orPlanDTOs
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<CiOrderDO>> getCiOrsByPatID(OrMpPlanDTO[] orPlanDTOs, String sd_su_bl, String[] id_ors) throws BizException {
		IOrdSrvDORService srvDORService = ServiceFinder.find(IOrdSrvDORService.class);
		Map<String, List<CiOrderDO>> map = new HashMap<String, List<CiOrderDO>>();
		//查询服务项目
		OrdSrvDO[] srvdos =srvDORService.findByAttrValStrings(OrdSrvDO.ID_OR, id_ors);
		Map<String,List<OrdSrvDO>> srvMap = MpnrUtils.groupBaseDO(srvdos, OrdSrvDO.ID_OR);
		//返回是否计费医嘱
		Map<String,Boolean> mapb = chargeOrNot(id_ors,srvMap);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<CiOrderDO> orderDOs = (List<CiOrderDO>) daf.findByPKs(CiOrderDO.class, id_ors, new String[] { CiOrderDO.ID_OR, CiOrderDO.ID_PAT, CiOrderDO.SD_SU_BL,CiOrderDO.NAME_OR });
		if (orderDOs != null && orderDOs.size() > 0) {
			for (CiOrderDO ord : orderDOs) {
				if(!mapb.get(ord.getId_or())){
					continue;
				}
				if (sd_su_bl.equals(ord.getSd_su_bl())) {
					if (map.containsKey(ord.getId_pat())) {
						map.get(ord.getId_pat()).add(ord);
					} else {
						List<CiOrderDO> rtnList = new ArrayList<CiOrderDO>();
						rtnList.add(ord);
						map.put(ord.getId_pat(), rtnList);
					}
				}
			}
		}
		return map;
	}
	
	/**
	 * 判断医嘱是否收费
	 * @param id_orList
	 * @param srvMap
	 * @return
	 */
	private Map<String, Boolean> chargeOrNot(String[] id_ors, Map<String, List<OrdSrvDO>> srvMap) {
		Map<String, Boolean> mapRtn = new HashMap<String, Boolean>();
		for (String id_or : id_ors) {
			List<OrdSrvDO> orsrvList = srvMap.get(id_or);
			Boolean b = Boolean.FALSE;
			for (OrdSrvDO ordSrvDO : orsrvList) {
				if(FBoolean.TRUE.equals(ordSrvDO.getFg_bl())){
					b = Boolean.TRUE;
					break;
				}
			}
			mapRtn.put(id_or, b);
		}
		return mapRtn;
	}
	
	/**
	 * 获取记账参数
	 * 
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("static-access")
	private MpChargeSetDTO getParamset() throws BizException {
		MpChargeSetDTO rtn = new MpChargeSetDTO();
		rtn.setId_emp_cg(Context.get().getStuffId());// 记账人
		rtn.setId_dep_cg(Context.get().getDeptId());// 记账科室
		rtn.setDt_cg(new FDateTime());// 记账时间
		rtn.setFg_price_cal(FBoolean.TRUE);// 计算服务价格
		rtn.setFg_singlepat(FBoolean.FALSE);// 单患者模式
		if (FBoolean.TRUE.equals(new EiParamUtils().MPDGIP0005())) {			
			rtn.setFg_postpaid(FBoolean.TRUE);// 是否支持后付费
		} else {
			rtn.setFg_postpaid(FBoolean.FALSE);// 是否支持后付费
		}
		rtn.setFg_exception(FBoolean.TRUE);// 是否抛异常
		rtn.setSrcfunc_des("techcharge");// 记账来源
		return rtn;
	}
}

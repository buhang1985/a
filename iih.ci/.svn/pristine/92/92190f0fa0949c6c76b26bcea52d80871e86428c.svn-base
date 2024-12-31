package iih.ci.sdk.cache;

import java.util.List;
import java.util.Map;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.sdk.log.OrdBizLogger;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 执行科室缓存对象处理
 * 
 * @author wangqingzhu
 *
 */
public class CiDeptInfoCache {

	private CiDeptInfoCache() {
	}

	/**
	 * 获取医嘱流向科室数据
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param sd_srvtp
	 *            服务类型sd
	 * @param id_srvCa
	 *            服务分类
	 * @param id_srv
	 *            服务
	 * @param id_route
	 *            用法
	 * @param id_mm
	 *            服务选取的关联物品
	 * @param id_dept_crt
	 *            开单科室
	 * @param id_dept_nur
	 *            就诊护理病区
	 * @param id_dep_ent
	 *            就诊科室
	 * @param id_dep_follow
	 *            主服务执行科室--用于跟随情况
	 * @param id_dosage
	 *            药品剂型
	 * @param sd_pois
	 *            毒麻类别
	 * @param fg_pres_outp
	 *            出院点药标识
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(String id_grp, String id_org, String code_entp, String sd_srvtp,
			String id_srvCa, String id_srv, boolean fg_long, String id_route, String id_mm, String id_dept_crt,
			String id_dept_nur, String id_dep_ent, String id_dep_follow, String id_dosage, String sd_pois,
			FBoolean fg_pres_outp, FDateTime dt_effe) throws BizException {
		OrWfExDeptParamDTO dto = new OrWfExDeptParamDTO();
		dto.setEu_wftp(EnumFlow.NULL); // 0执行与物资 1执行科室 2物资流向
		dto.setCode_entp(code_entp); // 就诊类型
		dto.setId_dept_ns(id_dept_nur); // 就诊护理病区
		dto.setId_dept_or(id_dept_crt);// 开单科室
		dto.setId_dept_en(id_dep_ent); // 就诊科室
		dto.setRecurstr(fg_long ? "1" : "0"); // 长临需要的 不知道 就为空
		dto.setId_srv(id_srv); // 服务
		dto.setSd_srvtp(sd_srvtp); // 服务类型sd
		dto.setId_srvca(id_srvCa);// 服务分类
		dto.setId_dept_ex(id_dep_follow); // 主服务执行科室--用于跟随情况
		// dto.Innercode_srvca = "";//服务分类内码
		dto.setId_mm(id_mm); // 服务选取的关联物品
		dto.setId_usage(id_route); // 用法
		//dto.Weekno = "2";//生效日期时间相关的 周#与时间
		// dto.Reserv1 = ""; //暂时无用途 //预留项
		// dto.Reserv2 = ""; //暂时无用途
		// dto.Reserv3 = ""; //套内项目时：
		dto.setTimestr(ObjectUtils.isEmpty(dt_effe) ? new FTime() : dt_effe.getUFTime());// 医嘱开始事件
		// BD套内项目的科室计算方式sd值,BD套内项目的固定执行科室ID值,所属套的执行科室ID值
		dto.setId_dosage(id_dosage);// 剂型
		dto.setFg_pres_outp(new FBoolean(FBoolean.TRUE.equals(fg_pres_outp)));// 出院带药标识
		dto.setSd_pois(sd_pois);// 毒麻类别
//		String key = dto.serializeJson();
		//OrWfDeptInfoDTO obj = ContextCache.Get(CiDeptInfoCache.class.getSimpleName(), id_grp, id_org, "OrderWorkflowDeptCache", key);
		//if (null == obj) 
		//{
		//	obj = ServiceFinder.find(ICiOrdQryService.class).getExeDepts4CiOrSrvN(dto);
		//	ContextCache.Put(CiDeptInfoCache.class.getSimpleName(),id_grp, id_org, "OrderWorkflowDeptCache", key, obj);
		//}
		
		long t = OrdBizLogger.GetLocalTime();
		OrWfDeptInfoDTO obj = ServiceFinder.find(ICiOrdQryService.class).getExeDepts4CiOrSrvN(dto);
		OrdBizLogger.OutputCostTime("CiDeptInfoCache计算执行科室，耗时：", t);
		return obj;
	}
	

	public static Map<String,List<OrWfExDeptDTO>> GetOrWfDeptInfos(CiEnContextDTO ctx, OrdSrvDO[] szOrderSrvInfo) {
		
		return null;
	}

	/**
	 * 获取执行科室
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param id_mm
	 * @param id_dep_main
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, String id_mm, boolean fg_long,
			String id_dep_main, FDateTime dt_effe) throws BizException {
		// 获取服务用法
		String id_route = medSrv.getId_route();
		// 如果是药品服务为商品名模式，则需要获取商品中的用法定义
		if (ObjectUtils.isTrue(medSrv.getFg_mm()) && !ObjectUtils.isEmpty(id_mm)
				&& IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(BdMmParamUtils.GetDrugMCPropMM())) {
			MeterialDO mmInfo = BDMeterialInfoCache.GetMeterialInfo(ctx, id_mm);
			if (mmInfo != null) {
				id_route = mmInfo.getId_route();
			}
		}

		return GetOrWfDeptInfo(ctx, medSrv, id_mm, fg_long, id_route, id_dep_main, dt_effe);
	}

	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, String id_mm, boolean fg_long,
			String id_route, String id_dep_main, FDateTime dt_effe) throws BizException {
		String id_dosage = null, sd_pois = null;
		// 物品id_mm不为空，取出剂型和毒麻信息
		if (!ObjectUtils.isEmpty(id_mm)) {
			MedSrvDrugDO medSrvDrugDO = BDSrvDrugInfoCache.GetBdSrvDrugInfo(ctx, medSrv.getId_srv());// ServiceFinder.find(IMedSrvDrugDORService.class).findByAttrValString(MedSrvDrugDO.ID_SRV, medSrv.getId_srv());
			if (medSrvDrugDO != null) {
				id_dosage = medSrvDrugDO.getId_dosage();
				sd_pois = medSrvDrugDO.getSd_pois();
			}
		}

		OrWfDeptInfoDTO obj = GetOrWfDeptInfo(ctx.getId_grp(), ctx.getId_org(), ctx.getCode_entp(),
				medSrv.getSd_srvtp(), medSrv.getId_srvca(), medSrv.getId_srv(), fg_long, id_route, id_mm,
				ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(), id_dep_main, id_dosage, sd_pois,
				ctx.getFg_pres_outp(), dt_effe);

		// 医嘱执行科室流向配置参数
		// 执行流向没有匹配成功，并且，执行科室匹配参数为
		// 1（如果匹配后的流向科室为空则不抛异常而走组内默认值设置逻辑），则去获取另一个参数指定的默认值
		if (null == obj) {
			obj = new OrWfDeptInfoDTO();
		}
		return obj;
	}

	/**
	 * 获取执行科室信息
	 * 
	 * @param ctx
	 * @param id_srv
	 * @param sd_srvtp
	 * @param id_srvca
	 * @param id_route
	 * @param id_mm
	 * @param id_dep_main
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, String id_srv, String sd_srvtp, String id_srvca,
			boolean fg_long, String id_route, String id_mm, String id_dep_main, String id_dosage, String sd_pois,
			FDateTime dt_effe, FBoolean fg_pres_outp) throws BizException {

		if(ObjectUtils.isEmpty(id_srv)){
			return new OrWfDeptInfoDTO();
		}
		if (ObjectUtils.isEmpty(id_srvca)) {
			id_srvca = BDSrvInfoCache.GetBdSrvInfo(null, id_srv).getId_srvca();
		}

		OrWfDeptInfoDTO obj = GetOrWfDeptInfo(ctx.getId_grp(), ctx.getId_org(), ctx.getCode_entp(), sd_srvtp, id_srvca,
				id_srv, fg_long, id_route, id_mm, ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(),
				id_dep_main, id_dosage, sd_pois, fg_pres_outp, dt_effe);

		if (null == obj) {
			obj = new OrWfDeptInfoDTO();
		}
		return obj;
	}

	/**
	 * 获取执行科室信息
	 * 
	 * @param ctx
	 * @param id_srv
	 * @param sd_srvtp
	 * @param id_srvca
	 * @param id_route
	 * @param id_mm
	 * @param id_dep_main
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, String id_srv, String sd_srvtp, String id_srvca,
			boolean fg_long, String id_route, String id_mm, String id_dep_main, FDateTime dt_effe,FBoolean fg_pres_outp) throws BizException {
		String id_dosage = null, sd_pois = null;
		// 物品id_mm不为空，取出剂型和毒麻信息
		if (ObjectUtils.isEmpty(id_mm)) {
			MedSrvDrugDO medSrvDrugDO = BDSrvDrugInfoCache.GetBdSrvDrugInfo(ctx, id_srv);
			if (!ObjectUtils.isEmpty(medSrvDrugDO)) {
				id_dosage = medSrvDrugDO.getId_dosage();
				sd_pois = medSrvDrugDO.getSd_pois();
			}
		}
		if (ObjectUtils.isEmpty(id_srvca)) {
			id_srvca = BDSrvInfoCache.GetBdSrvInfo(null, id_srv).getId_srvca();
		}

		OrWfDeptInfoDTO obj = GetOrWfDeptInfo(ctx.getId_grp(), ctx.getId_org(), ctx.getCode_entp(), sd_srvtp, id_srvca,
				id_srv, fg_long, id_route, id_mm, ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(),
				id_dep_main, id_dosage, sd_pois, fg_pres_outp, dt_effe);

		if (null == obj) {
			obj = new OrWfDeptInfoDTO();
		}
		return obj;
	}

	public void Clear() {
		ContextCache.Clear(CiDeptInfoCache.class.getSimpleName());
	}
}

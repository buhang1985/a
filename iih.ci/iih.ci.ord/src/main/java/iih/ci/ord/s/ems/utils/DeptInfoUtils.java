package iih.ci.ord.s.ems.utils;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.cache.ContextCache;
import iih.bd.bc.param.IBdMmParamValueConst;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdMmParamUtils;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.CiOrdQryServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 执行科室缓存对象处理
 * @author wangqingzhu
 *
 */
public class DeptInfoUtils {

	private DeptInfoUtils() {
	}

	/**
	 * 获取医嘱流向科室数据
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param id_srv
	 *            服务
	 *            
	 * @param id_mm
	 *            服务选取的关联物品
	 * @param id_route
	 *            用法
	 * @param id_dept_crt
	 *            开单科室
	 * @param id_dept_nur
	 *            就诊护理病区
	 * @param id_dep_ent
	 *            就诊科室
	 * @param id_dep_follow
	 *            主服务执行科室--用于跟随情况
	 * @param isLong
	 * 			     长临标识
	 * @param fg_pres_outp
	 * 	                         出院带药标识
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(String code_entp, String id_srv,String id_mm, 
			String id_route, String id_dept_crt, String id_dept_nur, String id_dep_ent,
			String id_dep_follow,FBoolean isLong,FBoolean fg_pres_outp,FDateTime datetime,String dt_birth) throws BizException {

		OrWfExDeptParamDTO dto = new OrWfExDeptParamDTO();
		dto.setEu_wftp(EnumFlow.NULL); // 0执行与物资 1执行科室 2物资流向
		dto.setCode_entp(code_entp); // 就诊类型
		dto.setId_dept_ns(id_dept_nur); // 就诊护理病区
		dto.setId_dept_or(id_dept_crt);// 开单科室
		dto.setId_dept_en(id_dep_ent); // 就诊科室
		dto.setId_srv(id_srv); // 服务
		dto.setId_dept_ex(id_dep_follow); // 主服务执行科室--用于跟随情况
		dto.setId_mm(id_mm); // 服务选取的关联物品
		dto.setId_usage(id_route); // 用法
		Map<String,Object> rstMap = GetSrvInfo(id_srv,id_mm);
		if(rstMap!=null){
			//剂型
			dto.setId_dosage(rstMap.get("id_dosage")==null?null:rstMap.get("id_dosage").toString());
			//毒麻分类编码
			dto.setSd_pois(rstMap.get("sd_pois")==null?null:rstMap.get("sd_pois").toString());
			//草药制剂类型
			dto.setSd_herbpreparationtp(rstMap.get("sd_herbpreparationtp")==null?"":rstMap.get("sd_herbpreparationtp").toString());
			//服务类型 
			dto.setSd_srvtp(rstMap.get("sd_srvtp")==null?null:rstMap.get("sd_srvtp").toString());
			//服务分类
			dto.setId_srvca(rstMap.get("id_srvca")==null?null:rstMap.get("id_srvca").toString());
			if(StringUtils.isEmpty(id_route)){
				dto.setId_usage(rstMap.get("id_route")==null?null:rstMap.get("id_route").toString());
			}
		}	
		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
		if(datetime==null){
			datetime = CiOrdAppUtils.getServerDateTime();
		}
		dto.setTimestr(datetime.getUFTime());
		dto.setWeekno(CiOrdUtils.getDayOfWeek(datetime));
		dto.setRecurstr(CiOrdUtils.getFg_longStr(isLong));
		dto.setFg_pres_outp(fg_pres_outp);
		if(isNotEmptyIgnoreBlank(dt_birth)){
			String newStr=dt_birth.substring(0, 10);
			dto.setDt_birth(new FDate(newStr));// 患者年龄
		}
		return new CiOrdQryServiceImpl().getExeDepts4CiOrSrvN(dto);
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
	 * @param isLong
	 *            长临标识
	 * @param sd_herbpreparationtp
	 *            草药制剂类型          
	 * @param id_dosage
	 * 			     药品剂型 
	 * @param sd_pois
	 * 			     药品毒麻属性
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(String code_entp, String sd_srvtp, String id_srvCa, String id_srv,
			String id_route, String id_mm, String id_dept_crt, String id_dept_nur, String id_dep_ent,
			String id_dep_follow,FBoolean isLong,String sd_herbpreparationtp,String id_dosage,String sd_pois,String dt_Brith) throws BizException {

		OrWfExDeptParamDTO dto = new OrWfExDeptParamDTO();
		dto.setEu_wftp(EnumFlow.NULL); // 0执行与物资 1执行科室 2物资流向
		dto.setCode_entp(code_entp); // 就诊类型
		dto.setId_dept_ns(id_dept_nur); // 就诊护理病区
		dto.setId_dept_or(id_dept_crt);// 开单科室
		dto.setId_dept_en(id_dep_ent); // 就诊科室
		// dto.Recurstr = ""; //长临需要的 不知道 就为空
		dto.setId_srv(id_srv); // 服务
		dto.setSd_srvtp(sd_srvtp); // 服务类型sd
		dto.setId_srvca(id_srvCa);// 服务分类
		dto.setId_dept_ex(id_dep_follow); // 主服务执行科室--用于跟随情况
		// dto.Innercode_srvca = "";//服务分类内码
		dto.setId_mm(id_mm); // 服务选取的关联物品
		dto.setId_usage(id_route); // 用法
		dto.setId_dosage(id_dosage);
		dto.setSd_pois(sd_pois);
		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
		FDateTime fdt = CiOrdAppUtils.getServerDateTime();
		dto.setTimestr(fdt.getUFTime());
		dto.setWeekno(CiOrdUtils.getDayOfWeek(fdt));
		dto.setRecurstr(CiOrdUtils.getFg_longStr(isLong));
		dto.setSd_herbpreparationtp(sd_herbpreparationtp);
		if(isNotEmptyIgnoreBlank(dt_Brith)){
			String newStr=dt_Brith.substring(0, 10);
			dto.setDt_birth(new FDate(newStr));// 患者年龄
			
		}
		return new CiOrdQryServiceImpl().getExeDepts4CiOrSrvN(dto);
	}

	/**
	 * 获取执行科室信息
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
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, String id_srv,
			String id_mm,String id_route,  String id_dep_main,FBoolean isLong,FBoolean fg_pres_outp,FDateTime datetime) throws BizException {
		String Key_Dept_Cache = String.format("%s-%s-%s-%s-%s-%s-%s-%s", id_srv,
				CiOrdUtils.isEmpty(id_mm) ? "NULL_MM" : id_mm,
						id_route == null ? "NULL_ROUTE" : id_route, ctx.getId_dep_or(),
				ctx.getId_dep_ns(), ctx.getId_dep_en(),
				CiOrdUtils.isEmpty(id_dep_main) ? "NULL_DEP_MAINSRV" : id_dep_main,CiOrdUtils.isEmpty(isLong)?"NULL_LONG":isLong);
		OrWfDeptInfoDTO obj = ContextCache.Get(ctx.getId_grp(), ctx.getId_org(), "OrderWorkflowDeptCache",
					Key_Dept_Cache,null);

		if (null == obj) {
			obj = GetOrWfDeptInfo(ctx.getCode_entp(), id_srv,id_mm,
					id_route,ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(),
					id_dep_main,isLong,fg_pres_outp,datetime,ctx.getDt_birth());//传参增加出生日期
			ContextCache.Put(ctx.getId_grp(), ctx.getId_org(), "OrderWorkflowDeptCache", Key_Dept_Cache,null, obj);
		}
		return obj;
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
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, OrWfExDeptParamDTO param, String id_dep_main)
			throws BizException {
		String id_route = param.getId_usage();
		if(StringUtils.isEmpty(id_route)){
			id_route = medSrv.getId_route();
		}
		String Key_Dept_Cache = String.format("%s-%s-%s-%s-%s-%s-%s-%s", medSrv.getId_srv(),
				CiOrdUtils.isEmpty(param.getId_mm()) ? "NULL_MM" : param.getId_mm(),
						id_route == null ? "NULL_ROUTE" : id_route, ctx.getId_dep_or(),
				ctx.getId_dep_ns(), ctx.getId_dep_en(),
				CiOrdUtils.isEmpty(id_dep_main) ? "NULL_DEP_MAINSRV" : id_dep_main,CiOrdUtils.isEmpty(medSrv.getFg_long())?"NULL_LONG":medSrv.getFg_long());
		String key = medSrv.serializeJson();
		OrWfDeptInfoDTO obj = ContextCache.Get(ctx.getId_grp(), ctx.getId_org(), "OrderWorkflowDeptCache",
					Key_Dept_Cache,key);

		if (null == obj) {
			obj = GetOrWfDeptInfo(ctx.getCode_entp(), medSrv.getSd_srvtp(), medSrv.getId_srvca(), medSrv.getId_srv(),
					id_route, param.getId_mm(), ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(),
					id_dep_main,medSrv.getFg_long(),param.getSd_herbpreparationtp(),param.getId_dosage(),param.getSd_pois(),ctx.getDt_birth());
			ContextCache.Put(ctx.getId_grp(), ctx.getId_org(), "OrderWorkflowDeptCache",null, Key_Dept_Cache, obj);
		}
		return obj;
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
			String id_dept_nur, String id_dep_ent, String id_dep_follow, String id_dosage, String sd_pois,String sd_herbpreparationtp,
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
		dto.setTimestr(null==dt_effe?new FTime():dt_effe.getUFTime());// 医嘱开始事件
		// BD套内项目的科室计算方式sd值,BD套内项目的固定执行科室ID值,所属套的执行科室ID值
		dto.setId_dosage(id_dosage);// 剂型
		dto.setFg_pres_outp(fg_pres_outp == null ? FBoolean.FALSE : fg_pres_outp);// 出院带药标识
		dto.setSd_pois(sd_pois);// 毒麻类别
		String key = dto.serializeJson();
		OrWfDeptInfoDTO obj = ContextCache.Get(DeptInfoUtils.class.getSimpleName(), id_grp, id_org, "OrderWorkflowDeptCache", key);
		//if (null == obj) 
		{
			obj = new CiOrdQryServiceImpl().getExeDepts4CiOrSrvN(dto);
			ContextCache.Put(DeptInfoUtils.class.getSimpleName(),id_grp, id_org, "OrderWorkflowDeptCache", key, obj);
		}
		return obj;
	}

	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, String id_srv, String id_mm, FBoolean fg_long,
			String id_route, String id_dep_main, FDateTime dt_effe,FBoolean fg_pres_outp) throws BizException {
		OrWfDeptInfoDTO obj = GetOrWfDeptInfo(ctx.getCode_entp(),id_srv,id_mm,id_route, 
				ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(), id_dep_main, fg_long,fg_pres_outp,dt_effe,ctx.getDt_birth());
		if (null == obj) {
			obj = new OrWfDeptInfoDTO();
		}
		return obj;
	}

	public void Clear() {
		ContextCache.Clear(DeptInfoUtils.class.getSimpleName());
	}
	private static Map<String, Object> GetSrvInfo(String id_srv,String id_mm) throws BizException{
		if(StringUtils.isEmpty(id_mm)){
			String sql = "select srv.sd_srvtp,srv.id_srvca,srv.id_route            "
					+    "from bd_srv srv where srv.id_srv = ?             "; 
			DAFacade fa = new DAFacade();
			SqlParam param = new SqlParam();
			param.addParam(id_srv);
			Map<String, Object> rstMap = (Map<String, Object>)fa.execQuery(sql, param, new MapHandler());
			return rstMap;
		}else{
			String sql = null;
			if(IBdMmParamValueConst.DRUGMCPROPMM_DRUG.equals(BdMmParamUtils.GetDrugMCPropMM())){
				sql = "select drug.id_dosage,drug.sd_pois,mm.sd_herbpreparationtp,srv.sd_srvtp,srv.id_srvca,mm.id_route "
						+    "from bd_srv_drug drug inner join bd_srv srv on drug.id_srv = srv.id_srv              "
						+    "inner join bd_mm mm on mm.id_srv = srv.id_srv where drug.id_srv = ? and mm.id_mm = ? ";
			}else{
				sql = "select drug.id_dosage,drug.sd_pois,mm.sd_herbpreparationtp,srv.sd_srvtp,srv.id_srvca,srv.id_route "
					+"from bd_srv_drug drug inner join bd_srv srv on drug.id_srv = srv.id_srv              "
					+"inner join bd_mm mm on mm.id_srv = srv.id_srv where drug.id_srv = ? and mm.id_mm = ? ";
			}
			DAFacade fa = new DAFacade();
			SqlParam param = new SqlParam();
			param.addParam(id_srv);
			param.addParam(id_mm);
			Map<String, Object> rstMap = (Map<String, Object>)fa.execQuery(sql, param, new MapHandler());
			return rstMap;
		}
	}
	/** 
     * 判断字符串是否为非空(包含null与"","    ") 
     * @param str 
     * @return 
     */  
    public static boolean isNotEmptyIgnoreBlank(String str){  
        if(str == null || "".equals(str) || "".equals(str.trim()))  
            return false;  
        return true;  
    }
}

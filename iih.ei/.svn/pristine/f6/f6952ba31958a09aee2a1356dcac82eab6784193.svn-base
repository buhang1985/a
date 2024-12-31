package iih.ei.std.s.v1.bp.ci.thirdws.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.ICiOrContentConst;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * @code 标准化接口工具类
 * @author LiYue
 */
public class ThirdInfoUtils {
	
	/**
	 * 就诊信息
	 * @param en_code
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO getEntDO(String en_code) throws BizException{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] entdos = service.findByAttrValString(PatiVisitDO.CODE,en_code);
		if(entdos!=null && entdos.length>0){
			PatiVisitDO entdo = entdos[0];
			return entdo;
		}
		return null;
	}
	/**
	 * 申请单号
	 * 
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public static String getApplyNo(String sd_srvtp) throws BizException {
		if (!StringUtils.isNotEmpty(sd_srvtp))
			return "";
		// 医疗单类路径
		String classFullName = null;
		if (sd_srvtp.startsWith("02")) {// 检查

			if (sd_srvtp.startsWith("0207")) {// 病理
				classFullName = OrdApPathgyDODesc.CLASS_FULLNAME;
			} else {
				classFullName = OrdApObsDODesc.CLASS_FULLNAME;
			}

		} else if (sd_srvtp.startsWith("03")) {// 检验
			classFullName = OrdApLabDODesc.CLASS_FULLNAME;

		} else if (sd_srvtp.startsWith("04")) {// 手术
			classFullName = OrdApOpDODesc.CLASS_FULLNAME;
		} else if (sd_srvtp.startsWith("140101")) {// 备血
			classFullName = OrdApBtDODesc.CLASS_FULLNAME;

		} else if (sd_srvtp.startsWith("140102")) {// 用血
			classFullName = OrdAppBtUseDODesc.CLASS_FULLNAME;
		}

		if (StringUtils.isNotEmpty(classFullName)) {
			return ServiceFinder.find(IBillcodeManage.class).getPreBillCode_RequiresNew(classFullName);
		}
		return "";
	}

	/**
	 * 获得门诊就诊信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public OutpatientDO getEnEntOpDO(String id_ent) throws BizException{
		IOutpatientRService service = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] entiopdos = service.findByAttrValString(OutpatientDO.ID_ENT, id_ent);
		if(entiopdos!=null && entiopdos.length>0){
			return entiopdos[0];
		}
		return null;
	}
	/**
	 * 查询医保计划
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public EntHpDO getEntHpDO(String id_ent) throws BizException{
		IEnthpRService service = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] enthps = service.findByAttrValString(EntHpDO.ID_ENT,id_ent);
		if(enthps!=null && enthps.length>0){
			return enthps[0];
		}
		return new EntHpDO();
	}
	/**
	 * @code 科室code 查id和name
	 * @param code_dep
	 * @return
	 * @throws BizException
	 */
	public DeptDO getDep(String code_dep) throws BizException {
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = service.findByAttrValString(DeptDO.CODE, code_dep);
		if(deptDOs!=null && deptDOs.length>0) {
			return deptDOs[0];
		}
		return null;
	}
	
	/**
	 * 治疗类医嘱内容拼接
	 * 
	 * @param sd_srvtp
	 * @param fg_urgent
	 * @param name_srv
	 * @param name_route
	 * @return
	 */
	public static CiOrContentDO create(String sd_srvtp, String name_srv, String name_route, FBoolean fg_urgent) {
		CiOrContentDO contentdo = new CiOrContentDO();
		if (sd_srvtp != null && sd_srvtp != "") {
			contentdo.setTypeId(sd_srvtp);
		} else {
			contentdo.setTypeId(ICiOrContentConst.ORContent_TYPE_DEFAULT);
		}

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add(name_srv);
		list.add(arrList);

		ArrayList<String> routelist = new ArrayList<String>();
		// 拼接加急标识
		if (FBoolean.TRUE.equals(fg_urgent)) {
			routelist.add("加急！");
		}
		// 拼接用法标识
		if(StringUtils.isNotEmpty(name_route)){
			routelist.add(name_route);
		}

		contentdo.setTitle("");
		contentdo.setItemInfos(list);
		contentdo.setTailInfo(routelist);
		return contentdo;
	}
	/**
	 * 通过服务编码查询服务项目
	 * 
	 * @param code_srvs
	 * @return
	 * @throws BizException
	 */
	public Map<String, MedSrvDO> getMedSrvMap(List<String> code_srvs) throws BizException {
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medsrvs = service.findByAttrValStrings(MedSrvDO.CODE, code_srvs.toArray(new String[0]));
		Map<String, MedSrvDO> map = new HashMap<String, MedSrvDO>();
		for (MedSrvDO medSrvDO : medsrvs) {
			map.put(medSrvDO.getCode(), medSrvDO);
		}
		return map;
	}
	/**
	 * 通过科室编码查询科室信息
	 * @param deptcode
	 * @return
	 * @throws BizException
	 */
	public static DeptDO getDeptByCode(String deptcode) throws BizException{
		DeptDO[] depts = ServiceFinder.find(IDeptRService.class).findByAttrValString(DeptDO.CODE, deptcode);
		if(depts != null && depts.length >0 ){
			return depts[0];
		}
		return null;
	}
	/**
	 * 获得组织id
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public static String getOrgOfDept(String id_dep) throws BizException {
		DeptDO do1 = ServiceFinder.find(IDeptRService.class).findById(id_dep);
		if (do1 == null)
			return "";
		return do1.getId_org();
	}
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
		return  ts.getUFDateTime();
	}
	/**
	 * 二值逻辑的空处理逻辑
	 * 
	 * @param input
	 * @return
	 */
	public static FBoolean nullHandle(FBoolean input) {
		if (input == null)
			return new FBoolean(false);
		return input;
	}

	
	/**
	 * 判断在院执行标识
	 * @param code_entp
	 * @param sd_srvtp
	 * @return
	 */
	public static FBoolean JudgeFgMpIn(String code_entp, String sd_srvtp) {
		if (IEnDictCodeConst.SD_DIAGTYPE_HOSPITAL_IN.equals(code_entp)) {
			// 住院
			return FBoolean.TRUE;
		} else if (IEnDictCodeConst.SD_DIAGTYPE_OUTPATIENT.equals(code_entp)) {
			if (sd_srvtp != null) {
				// 草药
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					return FBoolean.FALSE;
				}
				// 西成药 注射
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)) {
					return FBoolean.TRUE;
				}
				// 非注射
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) {
					return FBoolean.FALSE;
				}
				// 非药品
				if (!sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					return FBoolean.TRUE;
				}
			}
		}
		return FBoolean.FALSE;
	}
}

/**
 * 
 */
package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UIEmsEnvDTO;
import iih.ci.ord.emsdi.d.EmsDiDTO;
import iih.ci.ord.emsdi.d.EmsDiSrvDTO;
import iih.ci.ord.emsdi.d.EmsDiSrvMmDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.GenEmsDiInfo8BdSrvParameterNUllException;
import iih.mm.itf.material.d.MaterialInfoDTO;

import java.util.Date;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: FieldMapping
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年7月26日 下午4:43:34
 * @Package iih.ci.ord.s.bp.common
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class FieldMapping {
  
	
	/**
	 * 上下文的字段映射映射到医疗单上
	 * @param uiEmsEnvDTO
	 * @param emsDiDTO
	 */
	@Deprecated
	public static void  UIEmsEnvDTOMappingEmsDiDTO(UIEmsEnvDTO uiEmsEnvDTO,CiEmsDTO emsDiDTO)throws BizException{
		if(emsDiDTO== null || uiEmsEnvDTO == null) throw new GenEmsDiInfo8BdSrvParameterNUllException(); 
			emsDiDTO.setId_org(uiEmsEnvDTO.getId_org());
			emsDiDTO.setId_grp(uiEmsEnvDTO.getId_grp());
			//emsDiDTO.setId_dep_or(uiEmsEnvDTO.getId_dep_or());
			//emsDiDTO.setId_emp_or(uiEmsEnvDTO.getId_emp_or());
			emsDiDTO.setEmsappmode(uiEmsEnvDTO.getEmsappmode());
			emsDiDTO.setId_pat(uiEmsEnvDTO.getId_pat());
			emsDiDTO.setId_en(uiEmsEnvDTO.getId_en());
			emsDiDTO.setCode_entp(uiEmsEnvDTO.getCode_entp());
	}
	 /**
	  * 医疗服务映射医疗单上
	  * @param medsrv
	  * @param emsDiDTO
	  */
	@Deprecated
	public static void MedSrvDOMapingEmsDiDTO(MedSrvDO medsrv,EmsDiDTO emsDiDTO){
	    
		emsDiDTO.setId_srv(medsrv.getId_srv()); 	 	 				 	 			 	 	 	
		emsDiDTO.setId_srvtp(medsrv.getId_srvtp()); 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setSd_srvtp(medsrv.getSd_srvtp());				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setFg_set(medsrv.getFg_set());			 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setId_srvca(medsrv.getId_srvca());				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setId_freq(medsrv.getId_freq()); 		 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setName_freq(medsrv.getFreq_name());	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setId_route(medsrv.getId_route());				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setName_route(medsrv.getRoute_name()); 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setId_routedes(medsrv.getId_routedes()); 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setName_routedes(medsrv.getRoutedes_name());				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setId_boil(medsrv.getId_boil());  	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setName_boil(medsrv.getBoil_name());	   				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setId_boildes(medsrv.getId_boildes()); 	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setName_boildes(medsrv.getBoildes_name());	 	 	 	 	 	 				 	 			 	 	 	
		emsDiDTO.setQuan_medu(medsrv.getQuan_med());	  				 	 	 	 		 	 			 	 	 	
		emsDiDTO.setId_unit_med(medsrv.getId_unit_med()); 		 	 	 	 	 	 				 	 			 	 	 	
		//emsDiDTO.setName_unit_med(medsrv.get);//剂量单位
	}
	/**
	 * 医疗服务映射医疗单项目上
	 * @param medSrvDO
	 * @param emsDiSrvDTO
	 */
	@Deprecated
	public static void MedSrvDOMapingEmsDiSrvDTO(MedSrvDO medSrvDO,EmsDiSrvDTO emsDiSrvDTO){
		
		emsDiSrvDTO.setId_srv(medSrvDO.getId_srv());//服务	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setCode_srv(medSrvDO.getCode());//服务编码	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setName_srv(medSrvDO.getName());	//服务名称	 	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_srvtp(medSrvDO.getId_srvtp());	//服务类型 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setSd_srvtp(medSrvDO.getSd_srvtp());	//服务类型编码   	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_srvca(medSrvDO.getId_srvca());	//服务基本分类 		 	 			 	 	 	
		//emsDiSrvDTO.setFg_selfsrv(medSrvDO.getFg_);	//自定义服务标识  	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_freq(medSrvDO.getId_freq());	//频次  				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setName_freq(medSrvDO.getFreq_name());	//频次名称 	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDiSrvDTO.setsd_frequnitct	//频次周期类型  	 			 	 	 	
		//emsDiSrvDTO.setfrequnitct	//频次周期数  	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDiSrvDTO.setfreqct	//频次周期下次数  				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_route(medSrvDO.getId_route());	//用法 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setName_route(medSrvDO.getRoute_name());	//用法名称  	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_routedes(medSrvDO.getId_routedes());	//要求  	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setName_routedes(medSrvDO.getRoute_name());	//要求名称  	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_boil(medSrvDO.getId_boil());	//煎法 			 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setName_boil(medSrvDO.getBoil_name());	//煎法名称  	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_boildes(medSrvDO.getId_boildes());	//煎法要求 			 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setName_boildes(medSrvDO.getBoil_name());	//煎法要求名称 	 	 			 	 	 	
		emsDiSrvDTO.setId_unit_med(medSrvDO.getId_unit_med());	//医学单位  	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDiSrvDTO.setname_medu(medSrvDO.getMed_name());	//计量单位名称 		 	 			 	 	 	
		emsDiSrvDTO.setQuan_medu(medSrvDO.getQuan_med());	//数值_医学单位  		 	 			 	 	 	
		//.seteu_sourcemd	//项目来源方式 		 	 			 	 	 	
		//emsDiSrvDTO.setid_srv_src(medSrvDO.getId_srv);	//来源服务项目 		 	 			 	 	 	
		emsDiSrvDTO.setFg_set(medSrvDO.getFg_set());	//套标识	 	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setFg_or(medSrvDO.getFg_or());	//医嘱标识 	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setFg_bl(medSrvDO.getFg_bl());	//费用标识 	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setFg_mm(medSrvDO.getFg_mm());	//物品标识  	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDiSrvDTO.setfg_self(medSrvDO.getFg_se);	//自备药标识  	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDiSrvDTO.setfg_propc(medSrvDO.getFg_propc());	//预防用药标识 		 	 			 	 	 	
		emsDiSrvDTO.setEu_blmd(medSrvDO.getEu_blmd());	//划价方式  	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setId_primd(medSrvDO.getId_primd());	//定价模式 	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDiSrvDTO.setPrice(medSrvDO.getPri());	//参考价
		
	}
	
	/**
	 * 映射物品信息到医疗单上的物品上
	 * @param meterialDO
	 * @param emsDiSrvMmDTO
	 */
	@Deprecated
	public static void MeterialDOMapingEmsDiSrvMmDTO(MeterialDO meterialDO, EmsDiSrvMmDTO emsDiSrvMmDTO){
		
	}
	/**
	 * 医疗服务字段映射到CiEmsDTO上
	 * @param medSrvDO
	 * @param emsDto
	 */
	public void MedSrvDOMappingCiEmsDTO(CiEnContextDTO envinfo,MedSrvDO medSrvDO ,CiEmsDTO emsDto) throws BizException{
		
 
		//   1	主键	id_or	医嘱主键标识	SINGLE	FID	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_pat(envinfo.getId_pat());//	患者	REF	患者基本信息	20	患者基本信息	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_en(envinfo.getId_en());//	就诊	REF	患者就诊	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_entp(envinfo.getId_entp());//	就诊类型	REF	流程配置_就诊类型	20	就诊类型	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setCode_entp(envinfo.getCode_entp());//	就诊类型编码	SINGLE	 	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_srvtp(medSrvDO.getId_srvtp());//	医嘱类型	REF	医疗服务类型_自定义档案	20	医疗服务类型_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setSd_srvtp(medSrvDO.getSd_srvtp());//	医嘱类型编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_srv(medSrvDO.getId_srv());//	对应服务	SINGLE	医疗服务	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDto.setId_srv_pkg(medSrvDO.getId_srv_pkg());//	服务包	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setFg_long(medSrvDO.getFg_long());//	长临标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDto.setEmstype(envinfo.getEmstype());//	医疗单类型	SINGLE	医疗单类型	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_freq(medSrvDO.getId_freq());//	医嘱频次	REF	医嘱频次定义	20	医嘱频次	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setName_freq(medSrvDO.getFreq_name());//	医嘱频次名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_route(medSrvDO.getId_route());//	用法	REF	医疗服务_医疗用法	20	医疗用法	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setName_route(medSrvDO.getRoute_name());//	用法名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_routedes(medSrvDO.getId_routedes());//	用法要求	REF	医疗用法要求	20	医疗用法之子	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setName_routedes(medSrvDO.getRoutedes_name());//	用法要求描述	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_boil(medSrvDO.getId_boil());//	煎法	REF	医疗服务中药煎法	20	医疗服务中药煎法	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setName_boil(medSrvDO.getBoil_name());//	煎法名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_boildes(medSrvDO.getId_boil());//	煎法要求	REF	中药煎法要求	20	中药煎法要求	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setName_boildes(medSrvDO.getBoildes_name());//	煎法要求名称	SINGLE	String	256	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//emsDto.setFg_boil(medSrvDO.getFg_boil());//	代煎标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//days_or	医嘱天数	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//orders	医嘱付数	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//orders_boil	代煎付数	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//code	编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setName(medSrvDO.getName());//	医嘱名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//content	医嘱内容	SINGLE	备注	4000	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//note	备注	SINGLE	备注	1000	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_emp_phy(envinfo.getId_emp_or());//	开立医生	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//name_emp_phy	开立医生姓名	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_dep_phy(envinfo.getId_dep_or());//	开立科室	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//name_dep_phy	开立科室名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_wg_or	医疗组	REF	业务组	20	业务组	 				 	 	 	 	 	 				 	 			 	 	 	
	    emsDto.setDt_begin(CiOrdAppUtils.getServerDateTime()); 	//开始日期	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//dt_end	结束日期	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//dt_invalid	医嘱过期时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_bb	婴儿标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//no_bb	婴儿序号	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_pmor	备用医嘱标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//des_pmor	备用医嘱使用条件描述	SINGLE	备注	300	 	 				 	 	 	 	 	 				 	 			 	 	 	
	    //fg_active_pm	备用医嘱启用标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_reltp	关联医嘱类型编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//sd_reltp	关联医嘱类型	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_or_rel	关联医嘱	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_ctlcp	临床路径控制标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_mr	医疗记录联动标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_skintest	需皮试标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_skintest_skip_reaso	不皮试原因（废弃不用了）	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//sd_skintest_skip_reaso	不皮试原因编码（废弃不用了）	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_mp_in	在院执行标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//times_mp_in	在院执行次数	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_mp_bed	床边执行标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//times_firday_mp	首日执行次数	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setFg_or_doc(medSrvDO.getFg_or());	//医生医嘱标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_su_or	医嘱状态	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//sd_su_or	医嘱状态编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//emssrvs	医疗单项目集合	ARRAY	医疗单项目	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ciorfreqtimes	医嘱计划频次执行时刻集合	ARRAY	医嘱计划频次执行时刻DTO	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//srvsetitms	套对应的套内项目集合	SINGLE	FMap	0	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//orapplysheet	医嘱对应的申请单	SINGLE	FMap	0	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_dept_en	就诊科室	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_dept_ns	护理单元	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setFg_set(medSrvDO.getFg_set());//	是否是套	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//des_or	嘱托	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_pres_outp	出院带药标识	SINGLE	FBoolean	1	
		EmsMatchRstDTO emsMatchRstDto = CiOrdUtils.getFuncClassStr(envinfo,medSrvDO);
		if(emsMatchRstDto ==null){ throw new BizException("没有匹配到医疗单");}
		emsDto.setFuncclassstr(emsMatchRstDto.getFuncclassstr());//	医疗单URL	SINGLE	String	256	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_srvof	医疗单	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setApplyno(CiOrdUtils.getApplyNo(medSrvDO.getSd_srvtp()));//	申请单号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//fg_urgent	加急标识	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//times_cur	总次数	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//id_orrsttp	医嘱结果	SINGLE	医嘱结果类型_自定义档案	20	医嘱结果类型_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
		//sd_orrsttp	医嘱结果编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
			 				 	 	 	 	 	 				 	 			 	 	 	
	    emsDto.setId_unit_med(medSrvDO.getId_unit_med());//	医学单位	SINGLE	计量单位	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setQuan_medu(medSrvDO.getQuan_med());//	数量_医学单位	SINGLE	FDouble	12	 	 				 	 	 	 	 	4				 	 			 	 	 	
		emsDto.setId_srvca(medSrvDO.getId_srvca());//	医嘱基本分类	SINGLE	医疗服务基本分类	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setName_unit_med(medSrvDO.getMed_name());//	医学单位名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setInnercode_srvca(medSrvDO.getSrvca_innercode());//	服务分类内码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_grp(medSrvDO.getId_grp());	//所属集团	SINGLE	String	50	 	Add01				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setId_org(medSrvDO.getId_org());//	所属组织	SINGLE	String	50	 	Add02				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setEmsappmode(envinfo.getEmsappmode());//	医疗单应用场景	SINGLE	医疗单应用模式	50	 	Add03				 	 	 	 	 	 				 	 			 	 	 	
		//name_ems	医疗单显示名称	SINGLE	String	50	 	Add04				 	 	 	 	 	 				 	 			 	 	 	
		//id_orpltp	医嘱执行闭环类型	SINGLE	String	50	 	Add05				 	 	 	 	 	 				 	 			 	 	 	
		//name_dep_mp	执行科室名称	SINGLE	String	50	 	Add06
		Object[] obj = this.getMedsrvRService(envinfo,medSrvDO);
		emsDto.setMapkeys(obj[0].toString());//	附加信息Map键值串	SINGLE	String	50	 	Add07				 	 	 	 	 	 				 	 			 	 	 	
		emsDto.setMapinfo((FMap2)obj[1]);//	相关附加信息MAP	SINGLE	FMap	0	 	Add08	 	 	 	 				 	 			 	 	 	
		//fg_syncfee	费用同步标识	SINGLE	FBoolean	1	 */
		OrWfDeptInfoDTO orwfDTO = this.getId_dep_mp(envinfo, medSrvDO, obj[2].toString());
		emsDto.setId_dep_mp(orwfDTO.getFirstid_mp_dept());//	执行科室	SINGLE	部门	20	 
	}
	 /**
	  * bd的关联数据（套的数据）
	  * @param envinfo
	  * @param medSrvDO
	  * @return
	  * @throws BizException
	  */
	 private  Object[] getMedsrvRService(CiEnContextDTO envinfo,MedSrvDO medSrvDO)throws BizException{
		 Object[] obj = new Object[3];
		 FMap2 map = new FMap2();
		 String Mapkeys = "MedsrvAggDO";
		 String id_mm = "";
		 MedsrvAggDO medSrvAggDO = CiOrdAppUtils.getMedsrvRService().findById(medSrvDO.getId_srv());
		 map.put("MedsrvAggDO", medSrvAggDO);
		 //套内项目
		 if(medSrvDO.getFg_set().booleanValue()){
			  Mapkeys += ",SetItemMedsrvDO,";
			  map.put("SetItemMedsrvDO",  convertArrayToList(medSrvAggDO));
		 }
		 
		 if(medSrvDO.getFg_mm().booleanValue()){
			 //物品信息
			 String whereStr = MeterialDODesc.TABLE_ALIAS_NAME+"."+MeterialDO.ID_SRV+" = '"+medSrvDO.getId_srv()+"'";
			 MeterialDO[] meteralDO = CiOrdAppUtils.getMaterialQryService().find(whereStr, MeterialDO.ID_SRV, FBoolean.FALSE);
			 Mapkeys += ",MeterialDO,";
			 map.put("MeterialDO", meteralDO);
			 //服务对应物品可用包装单位数据
			 //医保信息
			 if(meteralDO != null && meteralDO.length >0){
				 id_mm = meteralDO[0].getId_mm();
				 EmsOrDrug emsOrDrug = this.getEmsOrDrug(envinfo, medSrvDO,meteralDO[0],"");
				 Mapkeys += ",EmsOrDrug"; 
				 map.put("EmsOrDrug", emsOrDrug);
			 } 
			
		 }
		 obj[0]= Mapkeys;
		 obj[1]= map;
		 obj[2]= id_mm;
		 return obj;
	 }
	
	 
		private HPSrvorcaDO findHp(String id_hp, String id_Srv) throws BizException{
			IHpsrvorcaRService hpService=(IHpsrvorcaRService)ServiceFinder.find(IHpsrvorcaRService.class.getName());
			//return hpService.getHpSrvTpByCode(hpCode,id_Srv)
			String whereStr = HPSrvorcaDO.ID_HP +"='"+id_hp+"' and  "+ HPSrvorcaDO.ID_SRV +" ='"+id_Srv+"'";
			HPSrvorcaDO[] orca =  hpService.find(whereStr,HPSrvorcaDO.ID_HPSRVTP,FBoolean.FALSE);
			if(orca != null && orca.length >0){
				return orca[0];
			}else{
				throw new BizException("没有找医保信息");
			}
		}
	/**
	 * 医保信息
	 * @return
	 */
	private EmsOrDrug  getEmsOrDrug(CiEnContextDTO envinfo,MedSrvDO medSrvDO,MeterialDO meterialDO,String id_dep_mp)throws BizException{
		EmsOrDrug emsOrDrug=new EmsOrDrug();
		 HPSrvorcaDO hpMap=findHp(envinfo.getId_hp(),medSrvDO.getId_srv());
			String[]  id_mms= new String[]{meterialDO.getId_mm() };
			if(hpMap != null){
				 emsOrDrug.setName_heath(hpMap.getName());//医保
				 emsOrDrug.setLimit(hpMap.getDes());//报销限制条件
			}
	
		 emsOrDrug.setId_srv(medSrvDO.getId_srv());
		 MaterialInfoDTO dto = getMaterialDTO(id_mms);
		 if(dto != null){
			 emsOrDrug.setName_mm(dto.getName());
			 emsOrDrug.setId_mm(dto.getId_mm());
			 emsOrDrug.setSpec_mm(dto.getSpec());
			 emsOrDrug.setVender(dto.getName_sup());
			 //emsOrDrug.setPrice(dto.getPrice_sale());
			 emsOrDrug.setFactor_cb(dto.getFactor_sb());
			 emsOrDrug.setFactor_mb(dto.getFactor_mb());
			// emsOrDrug.setId_unit_sale(dto.getSale_pkgu_id());
			// emsOrDrug.setName_unit_sale(dto.getSale_pkgu_name());
			// emsOrDrug.setId_unit_base(dto.getBase_pkgu_id());
			// emsOrDrug.setName_unit_base(dto.getBase_pkgu_name());
			// emsOrDrug.setFact_count(dto.getStock_num());//库存
			 emsOrDrug.setFg_skintest(dto.getFg_skin());//皮试标志
			 //emsOrDrug.setSortno(mmMaps.get(id_srv).get(dto.getId_mm()).getSortno());
			// emsOrDrug.setSd_dosage(dto.getSd_dosage());//药品剂型
			// emsOrDrug.setSd_pharm(dto.getSd_pharm());//药品分类
			// emsOrDrug.setSd_pois(dto.getSd_pois());//毒麻药分类
			// emsOrDrug.setSd_anti(dto.getSd_anti());//抗菌药分类
			// emsOrDrug.setSd_mmtp(dto.getSd_mmtp());//物品分类
				//				mm.setSd_val();//价值分类
				//				mm.setSd_antipsy();//抗精神分类
		 }
		return emsOrDrug;
	}
	
	/**
	 * 默认第一个药品
	 * 物品库存 单位信息
	 * @param conditio
	 * @return
	 * @throws BizException
	 */
	private  MaterialInfoDTO	getMaterialDTO(String[] id_mms)throws BizException{
		//获取物品信息
		MaterialInfoDTO[] material = CiOrdAppUtils.getIMaterialBaseInfoService().getMaterialsByIds(id_mms);
		if(material== null || material.length==0){
			return null;
		}else{
		  return  material[0];
		}
	}
    
	/**
	 * 执行科室
	 * @param param
	 * @return OrWfDeptInfoDTO
	 * @throws BizException
	 */
	private  OrWfDeptInfoDTO getId_dep_mp(CiEnContextDTO envinfo,MedSrvDO medSrvDO,String id_mm)throws BizException{
		FDate fd = new FDate(new Date());
		FTime ft = new FTime(new Date());
		OrWfExDeptParamDTO param = new OrWfExDeptParamDTO();
		param.setId_srv(medSrvDO.getId_srv());
		param.setId_srvca(medSrvDO.getId_srvca());
		//param.setId_dept_en(envinfo.getId_dept_en);
		param.setId_dept_or(envinfo.getId_dep_or());
		param.setId_usage(medSrvDO.getId_route());
		param.setSd_srvtp(medSrvDO.getSd_srvtp());
		param.setId_mm(id_mm);
		param.setCode_entp(envinfo.getCode_entp());
		param.setInnercode_srvca(medSrvDO.getSrvca_innercode());
		param.setTimestr(ft);
		param.setWeekno(fd.getWeek()+"");
		GetExeDepts4CiOrSrvNBP bp =new GetExeDepts4CiOrSrvNBP();
		return bp.exec(param);
	}
	
	/**
	 * 套内项目的medsrv 的ids
	 * @param medSrvAggDO
	 * @return
	 */
	private String getMedSrvIds(MedsrvAggDO medSrvAggDO){
		String ids = "";
	    if(medSrvAggDO== null || medSrvAggDO.getMedSrvSetItemDO().length==0)return "";
	    for(MedSrvSetItemDO setItemDO:medSrvAggDO.getMedSrvSetItemDO()){
	    	ids +=",'"+setItemDO.getId_srv_itm()+"'";
	    }
		if(ids.length()>0){
			return ids.substring(1);
		}
		return ids;
	}
	
	 /***
	  * 数组转换FArrayList
	  * @param medSrvAggDO
	  * @return
	  * @throws BizException
	  */
	 private FArrayList convertArrayToList(MedsrvAggDO medSrvAggDO)throws BizException{
		 FArrayList list = new <MedsrvAggDO>FArrayList();
		 
		  String wherestr = MedSrvDODesc.TABLE_ALIAS_NAME+".id_srv in ( "+ getMedSrvIds(medSrvAggDO)+")";
		  MedsrvAggDO[] setMedSrvAggDO =CiOrdAppUtils.getMedsrvRService().find(wherestr, "id_srv", FBoolean.FALSE);
		  if(setMedSrvAggDO != null){
			  for(MedsrvAggDO aggDO:setMedSrvAggDO){
				  list.add(aggDO);
			  }
		   }
		 return list;
	 }
	 
	
	 
	 /**
	  * 映射医疗项目字段
	  * @param envinfo
	  * @return
	  */
	 public FArrayList getCiEmsSrvDTO(UIEmsEnvDTO envinfo,MedSrvDO medSrvDO,String id_dep_mp){
		 FArrayList srvList = new FArrayList();
		 //非套时
          CiEmsSrvDTO emssrv = new CiEmsSrvDTO();
          //emssrv.setId_orsrv("");//	医疗单项目主键标识	 	 			 	 	 	
		  //id_or	医疗单 	 				 	 	 	 	 	 				 	 			 	 	 	
		  //sortno	序号	 	 				 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setId_srv(medSrvDO.getId_srv());//	医疗服务	 	 	 	 	 				 	 			 	 	 	
			//id_srv_set	所属服务套 	 	 	 				 	 			 	 	 	
			emssrv.setId_srvtp(medSrvDO.getId_srvtp());//	服务类型 	
			emssrv.setSd_srvtp(medSrvDO.getSd_srvtp());//	服务类型编码	 	 			 	 	 	
			emssrv.setCode_srv(medSrvDO.getCode());//	医疗服务编码	 	 			 	 	 	
			emssrv.setName_srv(medSrvDO.getName());//	医疗服务名称	 	 			 	 	 	
			emssrv.setId_srvca(medSrvDO.getId_srvca());//	服务项目基本分类	 	 			 	 	 	
			emssrv.setId_unit_med(medSrvDO.getId_unit_med());//	医疗单位	 	 			 	 	 	
			emssrv.setName_unit_med(medSrvDO.getMed_name());//	医疗单位编码 	 			 	 	 	
			emssrv.setQuan_med(medSrvDO.getQuan_med());//	剂量		 	 			 	 	 	
			emssrv.setPrice(medSrvDO.getPri());//	参考价格
			emssrv.setId_freq(medSrvDO.getId_freq());//	医嘱频次 			 	 	 	
			emssrv.setName_freq(medSrvDO.getFreq_name());//	医嘱频次名称	 	 			 	 	 	
			emssrv.setId_route(medSrvDO.getId_route());//	用法标识	 	 	 	
			emssrv.setName_route(medSrvDO.getRoute_name());//	用法		 	 			 	 	 	
			emssrv.setId_routedes(medSrvDO.getId_routedes());//	用法要求标识	 	 	 	
			emssrv.setName_routedes(medSrvDO.getRoutedes_name());//	用法要求 	 			 	 	 	
			emssrv.setId_boil(medSrvDO.getId_boil());//	煎法标识 	 	 	
			emssrv.setName_boil(medSrvDO.getBoil_name());//	煎法			 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setId_boildes(medSrvDO.getId_boildes());//	煎法要求标识 	 	 	
			emssrv.setName_boildes(medSrvDO.getBoildes_name());// 	 			 	 	 	
			//fg_dose_anoma 	变动用药标识		 	 	 	
			emssrv.setDes_srv(medSrvDO.getDes());//	备注				 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setFg_mm(medSrvDO.getFg_mm());//	物品标识		 	 			 	 	 	
			emssrv.setFg_set(medSrvDO.getFg_set());//	服务套标识		 	 			 	 	 	
			emssrv.setFg_or(medSrvDO.getFg_or());//	医嘱标识		 	 			 	 	 	
			emssrv.setFg_bl(medSrvDO.getFg_bl());//	费用标识	 	 			 	 	 	
			//emssrv.setFg_self(medSrvDO.getFg_self());//	自备药标识	 	 			 	 	 	
			//fg_outp	出院带药标识（废弃不用了）	 			 	 	 	
			//fg_propc	预防用药标识 	 			 	 	 	
			//fg_treat	治疗用药标识 	 			 	 	 	
			emssrv.setId_org_srv(envinfo.getId_org());	//开立机构 				 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setId_dep_srv(envinfo.getId_dep_or());//	开立科室 				 	 	 	 	 	 				 	 			 	 	 	
			//emssrv.setId_ward_srv(envinfo.getId_dep_or());//	开立病区 				 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setId_emp_srv(envinfo.getId_emp_or());//	开立人员 				 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setDt_create_srv(CiOrdAppUtils.getServerDateTime());//	开立时间 	 				 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setId_dep(id_dep_mp);//	执行科室			 	 	 	 	 	 				 	 			 	 	 	
			emssrv.setName_dep("");//	 	 			 	 	 	
			//dt_last_bl	 	 			 	 	 	
			emssrv.setEu_blmd(medSrvDO.getEu_blmd());//	划价方式 	 			 	 	 	
			//id_orsrvmm	服务项目物品			 	 	 	
			//id_mm	物品	 	 	 	
//			46		code_mm	物品编码			 	 	 	 	 	 				 	 			 	 	 	
//			47		name_mm	物品名称		 	 			 	 	 	
//			48		spec_mm	规格	 	 	 	 	 	 				 	 			 	 	 	
//			49		id_unit_sale	 	 			 	 	 	
//			50		name_unit_sale 			 	 	 	
//			51		id_unit_base 	 			 	 	 	
			/*52		name_unit_base	基本单位名称 	 			 	 	 	
			53		quan_num_base	单次数量_分子		 	 			 	 	 	
			54		quan_den_base	单次数量_分母	 			 	 	 	
			55		price_cur	参考价当前
			56		quan_cur	总量_当前
			57		quan_base	总量_基本
			58		quan_bed_medu	床边量_医学	
			59		factor_cb	当前基本换算系数	 	
			60		factor_mb	医疗基本换算系数	 	
			61		id_dosage	药品剂型	 	 	 	 				 	 			 	 	 	
			62		sd_dosage	药品剂型编码	 	 	 	 				 	 			 	 	 	
			63		id_pharm	药理分类	 				 	 	 	 	 	 				 	 			 	 	 	
			64		sd_pharm	药理分类编码 	 				 	 			 	 	 	
			65		id_pois	毒麻分类 				 	 	 	 	 	 				 	 			 	 	 	
			66		sd_pois	毒麻分类编码 				 	 	 	 	 	 				 	 			 	 	 	
			67		id_anti	抗菌药分类				 	 	 	 	 	 				 	 			 	 	 	
			68		sd_anti	抗菌药分类编码 				 	 	 	 	 	 				 	 			 	 	 	
			69		id_mmtp	物品类型 				 	 	 	 	 	 				 	 			 	 	 	
			70		sd_mmtp	物品类型编码 	 				 	 	 	 	 	 				 	 			 	 	 	
			71		id_val	价值分类	 				 	 	 	 	 	 				 	 			 	 	 	
			72		sd_val	价值分类编码	 				 	 	 	 	 	 				 	 			 	 	 	
			73		indica	适应症		 	 	 	 	 	 				 	 			 	 	 	
			74		constr	禁忌症			 	 	 	 	 	 				 	 			 	 	 	
			75		react	不良反应			 	 			 	 	 	
			76		guide	主要作用		 	 			 	 	 	
			77		fg_otc	OTC标识 				 	 	 	 	 	 				 	 			 	 	 	
			78		emsfreqdose	变动用药安排				 	 			 	 	 	
			79		id_body	部位		 	 	 	 	 	 				 	 			 	 	 	
			80		sd_body	部位编码			 	 	 	 	 	 				 	 			 	 	 	
			81		body_name	部位名称				 	 	 	 	 	 				 	 			 	 	 	
			82		id_pos	体位			 	 	 	 	 	 				 	 			 	 	 	
			83		sd_pos	体位编码 				 	 	 	 	 	 				 	 			 	 	 	
			84		pos_name	体位名称	 				 	 	 	 	 	 				 	 			 	 	 	
			85		fg_indic	医保适应症标识	 	 			 	 	 	
			86		eu_sourcemd	医疗单项目数据来源方式	 	 			 	 	 	
			87		srv_sv	服务版本号 	 				 	 	 	 	 	 				 	 			 	 	 	
			88		mm_sv	物品版本号 	 				 	 	 	 	 	 				 	 			 	 	 	
			89		fg_skintest	需皮试标识		 	 			 	 	 	
			90		id_skintest_skip_reason	不皮试原因	 	 	 	 				 	 			 	 	 	
			91		sd_skintest_skip_reason	不皮试原因编码	 			 	 	 	
			92		id_reltp	关联类型		 	 	 	 	 	 				 	 			 	 	 	
			93		sd_reltp	关联类型编码	 	 	 				 	 			 	 	 	
			94		id_or_rel	关联医嘱	 	 	 	 				 	 			 	 	 	
			95		fg_skintest_rst	皮试是否有结果 	 			 	 	 	
			96		fg_selfsrv	自定义服务标识	 	 			 	 	 	
			97		id_srv_src	所属来源服务	 	 			 	 	 	
			98		quan_total_medu	服务总量
			99		id_primd	定价模式		 	 			 	 	 	
			100		fg_selfpay	自费标识		 	 			 	 	 	
			101		id_hp	主医保计划	 	 				 	 	 	 	 	 				 	 			 	 	 	
			102		id_hpsrvtp	医保目录类型	 	 	 				 	 			 	 	 	
			103		sd_hpsrvtp	医保目录类型编码	 	 				 	 			 	 	 	
			104		id_dep_wh	仓库	 				 	 	 	 	 	 				 	 			 	 	 	
			105		emsagentinfo	毒麻药品服务代办人信息		 	 	 	
			106		innercode_srvca	服务分类内码	 	 			 	 	 	
			107		sd_frequnitct	频次周期类型		 	 	 	
			108		frequnitct	频次周期数 	 			 	 	 	
			109		freqct	频次周期下次数 	 			 	 	 	
			110		name_hpsrvtp	医保目录名称		 	 	 	
			111		limit	限制报销条件	 			 	 	 	
			112		amt_total	总金额		 	 			 	 	 	
			113		name_dep_wh	库房名称 			 	 	 	
			114		id_unit_cg	计费单位	 			 	 	 	
			115		name_unit_cg	计费单位名称		 	 	 	
			116		quan_cgbase	计费基数
			117		factor_cm	系数_费医
			118		sd_roundmd_cg	计费取整模式		 	 	 	
			119		name_mmtp	物品类型名称			 	 	 	
			120		id_sup	厂家			 	 	 	 	 	 				 	 			 	 	 	
			121		name_sup	厂家名称 	 			 	 	 	
			122		sd_roundmd	取整方式	 	 			 	 	 	
			123		amt_cur	金额	 	 			 	 	 	
			124		quan_stock	可用库存
			125		id_srvskin	对应皮试服务			 	 	 	
			126		mapkeys	关联信息Map键值串	 			 	 	 	
			127		mapinfo	服务与物品关联信息MAP			 	 	 	
			128		priby	计价依据				 	 	 	 	 	 				 	 			 	 	 	
			129		fg_base	基数药标识*/
		 //套时
		 
		 
		 return srvList;
	 }
}

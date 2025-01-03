package iih.ei.std.s.v1.bp.ci.thirdws.query;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.ci.opr.d.AddOprDTO;
import iih.ei.std.d.v1.ci.opr.d.EntAndOrderInfoDTO;
import iih.ei.std.d.v1.ci.opr.d.OprInfoParamDTO;
import iih.ei.std.d.v1.ci.opr.d.OprInfoResultDTO;
import iih.ei.std.d.v1.ci.opr.d.OprPerDTO;
import iih.ei.std.d.v1.ci.opr.d.OprSrvDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
 * @author yangdong
 *
 * @date 2019年11月14日上午10:21:20
 *
 * @classpath iih.ei.std.s.v1.bp.ci.thirdws.query.OprInfoBP
 *
 * 手术查询接口
 *
 */
public class OprInfoBP extends IIHServiceBaseBP<OprInfoParamDTO, OprInfoResultDTO>{
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(OprInfoParamDTO param) throws BizException {
		if (param==null) {
			throw new BizException("手术查询失败:传入参数为空!");
		}else{
			if (StringUtil.isEmpty(param.getCode_entp())) {
				throw new BizException("手术查询失败:就诊类型编码为空!");
			}
			if (StringUtil.isEmpty(param.getCode_grp())) {
				throw new BizException("手术查询失败:所属集团编码为空!");
			}
			if (StringUtil.isEmpty(param.getCode_org())) {
				throw new BizException("手术查询失败:所属组织编码为空!");
			}
			//0189272: 标准接口：SI0134手术医嘱查询接口，去掉就诊次数和就诊编码的必填限制，实现批量查询
			//if(StringUtil.isEmpty(param.getCode_en())&&StringUtil.isEmpty(param.getTimes_en())){
			//	throw new BizException("医嘱查询失败:就诊次数和就诊编码不可同时为空！");
			//}
		}
		
	}
	
	@Override
	protected OprInfoResultDTO process(OprInfoParamDTO param) throws BizException {
		
		long start = System.currentTimeMillis();
		
		OprInfoResultDTO resultDTO = new OprInfoResultDTO();
		SqlParam sqlParam = new SqlParam();
		//获取就诊和医嘱信息
		String sql =getEntAndOrderInfoSql(param,sqlParam);
		Logger.info("手术医嘱查询就诊和医嘱信息sql："+sql);
		Logger.info("手术医嘱查询就诊和医嘱信息sqlParam："+sqlParam);
		List<EntAndOrderInfoDTO> list = (List<EntAndOrderInfoDTO>) new DAFacade().execQuery(sql,sqlParam,new BeanListHandler(EntAndOrderInfoDTO.class));
		
		if (ListUtil.isEmpty(list)) {
			return resultDTO;
		}
		
		//附加手术
		Map<String,List<AddOprDTO>> addOprMap = new HashMap<String,List<AddOprDTO>>();
		//人员信息
		Map<String,List<OprPerDTO>> oprPerMap = new HashMap<String,List<OprPerDTO>>();
		//费用信息
		Map<String,List<OprSrvDTO>> oprSrvMap = new HashMap<String,List<OprSrvDTO>>();

		
		StringBuffer buffer = new StringBuffer();
		SqlParam idOrSqlParam = new SqlParam();
		for (int i=0;i< list.size();i++) {
			EntAndOrderInfoDTO entAndOrderInfoDTO = list.get(i);
			idOrSqlParam.addParam(entAndOrderInfoDTO.getAttrVal("id_or"));
			buffer.append(",?");
			
			if(i>0 && i%900== 0){
				Map<String,List<AddOprDTO>> tempAddOprMap = this.getSugAddMap(buffer.substring(1), idOrSqlParam);
				addOprMap.putAll(tempAddOprMap);
				
				Map<String,List<OprPerDTO>> tempOprPerMap = this.getSugEmpMap(buffer.substring(1), idOrSqlParam);
				oprPerMap.putAll(tempOprPerMap);
				
				Map<String,List<OprSrvDTO>> tempOprSrvMap= this.getSrvMap(buffer.substring(1), idOrSqlParam);
				oprSrvMap.putAll(tempOprSrvMap);
				
				buffer.setLength(0);
				idOrSqlParam.clearParams();
			}
		}		
	
		
		if(buffer.length()>0){
			
			Map<String,List<AddOprDTO>> tempAddOprMap = this.getSugAddMap(buffer.substring(1), idOrSqlParam);
			addOprMap.putAll(tempAddOprMap);
			
			Map<String,List<OprPerDTO>> tempOprPerMap = this.getSugEmpMap(buffer.substring(1), idOrSqlParam);
			oprPerMap.putAll(tempOprPerMap);
			
			Map<String,List<OprSrvDTO>> tempOprSrvMap= this.getSrvMap(buffer.substring(1), idOrSqlParam);
			oprSrvMap.putAll(tempOprSrvMap);
		}
		
		for (EntAndOrderInfoDTO entAndOrderInfoDTO : list) {
			String key = entAndOrderInfoDTO.getAttrVal("id_or").toString();
			//获取附加手术
			List<AddOprDTO> addOprList = addOprMap.get(key);
			if(addOprList !=null && addOprList.size() >0){
				entAndOrderInfoDTO.setAddoprdto(ArrayListUtil.ConvertToFArrayList(addOprList));
			}
			
			//获取人员信息
			List<OprPerDTO> oprPerList = oprPerMap.get(key);
			if(oprPerList != null && oprPerList.size() >0){
				entAndOrderInfoDTO.setOprperdto(ArrayListUtil.ConvertToFArrayList(oprPerList));
			}
			
			//获取费用信息
			List<OprSrvDTO> oprSrvList = oprSrvMap.get(key);
			if(oprSrvList != null && oprSrvList.size()>0){
				entAndOrderInfoDTO.setOprsrvdto(ArrayListUtil.ConvertToFArrayList(oprSrvList));
			}
		}
		
		/*for (EntAndOrderInfoDTO entAndOrderInfoDTO : list) {
			String code_or = entAndOrderInfoDTO.getCode_or();
			//获取附加手术
			String sugAddSql = getSugAddSql(code_or);
			List<AddOprDTO> list1 = (List<AddOprDTO>) new DAFacade().execQuery(sugAddSql,new BeanListHandler(AddOprDTO.class));
			if (!ListUtil.isEmpty(list1)) {
				entAndOrderInfoDTO.setAddoprdto(ArrayListUtil.ConvertToFArrayList(list1));
			}
			//获取人员信息
			String sugEmpSql = getSugEmpSql(code_or);
			List<OprPerDTO> list2 = (List<OprPerDTO>) new DAFacade().execQuery(sugAddSql,new BeanListHandler(OprPerDTO.class));
			if (!ListUtil.isEmpty(list2)) {
				entAndOrderInfoDTO.setOprperdto(ArrayListUtil.ConvertToFArrayList(list2));
			}
			//获取费用信息
			String srvSql = getSrvSql(code_or);
			List<OprSrvDTO> list3 = (List<OprSrvDTO>) new DAFacade().execQuery(sugAddSql,new BeanListHandler(OprSrvDTO.class));
			if (!ListUtil.isEmpty(list3)) {
				entAndOrderInfoDTO.setOprsrvdto(ArrayListUtil.ConvertToFArrayList(list3));
			}
		}*/
		
		resultDTO.setEntandorderinfodto(ArrayListUtil.ConvertToFArrayList(list));
		long end = System.currentTimeMillis();
		Logger.info("调用手术查询接口耗时 " + (end - start) +"毫秒");
		return resultDTO;
	}
	
	private String getEntAndOrderInfoSql(OprInfoParamDTO param, SqlParam sqlParam){
		StringBuilder sqlQry = new StringBuilder();                                                
		sqlQry.append(" select c.id_or,grp.code as code_grp,                                 			");//所属集团
	    sqlQry.append("  org.code as code_org,                                           		");//所属组织
	    sqlQry.append("  p.code as code_pat,                                                	");//患者 
	    sqlQry.append("  (case when c.code_entp in('0103','10') then ei.times_ip                ");
	    sqlQry.append("        else eo.times_op                                                 ");
	    sqlQry.append("  end) as times_en ,                                              		");//就诊次数
	    sqlQry.append("  e.code as code_en,                                            			");//就诊编码  
	    sqlQry.append("  c.code_entp as code_entp,                                  			");//就诊类型编码 
	    sqlQry.append("  dep.code as code_dep_phy,                                   			");//当前就诊科室
	    sqlQry.append("  psn.code as code_emp_phy,                                   			");//当前主管医生
	    sqlQry.append("  psn1.code as code_emp_nur,                                  			");//当前责任护士
	    sqlQry.append("  dep1.code as code_dep_nur,                                  			");//当前所在病区
	    sqlQry.append("  bed.name as code_bed,                                             		");//床位号
	    sqlQry.append("  c.fg_vip as fg_vip,                                              		");//VIP标识
	    sqlQry.append("  c.fg_urgent as fg_urgent,                                              ");//加急标识
	    sqlQry.append("  '' as fg_hecominsur,                                        			");//高端商保标识
	    sqlQry.append("  ei.fg_newborn as fg_bb,                                         		");//婴儿标识
	    sqlQry.append("  c.code_or||c.sortno as sortno_or,                               		");//医嘱序号
	    sqlQry.append("  c.code_or as code_or,                                          		");//医嘱编码 
	    sqlQry.append("  srv.code as code_srv_or,                                    			");//手术项目编码
	    sqlQry.append("  srv.name as name_srv_or,                                    			");//手术项目名称
	    sqlQry.append("  sug.no_applyform as no_applyform,                           			");//手术申请单号
	    sqlQry.append("  psn2.code as code_emp_operate,                                  		");//主刀医生
	    sqlQry.append("  psn3.code as code_emp_helper,                                   		");//第一助手
	    sqlQry.append("  di.code as code_diag,                                       			");//临床诊断编码
	    sqlQry.append("  c.name_didef as name_diag,                                  			");//临床诊断名称
	    sqlQry.append("  sug.dt_plan as dt_plan,                                     			");//计划手术时间
	    sqlQry.append("  sug.sugplantime as sugplantime,                             			");//计划手术时长
	    sqlQry.append("  sug.sd_anestp as sd_anestp,                                     		");//麻醉方法
	    sqlQry.append("  sug.announcements as announcements,                             		");//注意事项
	    sqlQry.append("  sug.sd_sugbody as sd_sugbody,                                    		");//体位id 
	    sqlQry.append("  sug.sd_datelimittype as sd_datelimittype,                   			");//手术期限编码
	    sqlQry.append("  sug.sd_surgical_site as sd_surgical_site,                   			");//手术部位编码
	    sqlQry.append("  sug.id_incitp as id_incitp,                                            ");//切口等级
	    sqlQry.append("  sug.sd_incitp as sd_incitp,                                            ");//切口等级编码
	    sqlQry.append("  sug.id_lvlsug as id_lvlsug,                                            ");//手术等级
	    sqlQry.append("  sug.sd_lvlsug as sd_lvlsug,                                            ");//手术等级编码
	    sqlQry.append("  sug.specialdes as specialdes,                                   		");//特殊准备
	    sqlQry.append("  sug.fg_allergy as fg_allergy,                               			");//药物过敏标识
	    sqlQry.append("  c.des_or as des_or,                                                	");//嘱托 
	    sqlQry.append("  org1.code as code_org_or,                                       		");//开立机构
	    sqlQry.append("  dep2.code as code_dep_or,                                       		");//开立部门
	    sqlQry.append("  wg.code as code_wg_or,                                       			");//开立医疗组 
	    sqlQry.append("  psn_or.code as code_emp_or,                                     		");//开立医生
	    sqlQry.append("  c.dt_entry as dt_entry_or,                                      		");//开立日期
	    sqlQry.append("  org_mp.code as code_org_mp_or,                             			");//医嘱执行机构 
	    sqlQry.append("  dep_mp.code as code_dep_mp_or                               			");//医嘱执行科室
	    sqlQry.append("  from ci_ap_sug sug                                                     ");
	    sqlQry.append("  left join ci_order c on c.id_or=sug.id_or                              ");
	    sqlQry.append("  left join pi_pat p on p.id_pat=c.id_pat                                ");
	    sqlQry.append("  left join bd_grp grp on grp.id_grp = c.id_grp                          ");
	    sqlQry.append("  left join bd_org org on org.id_org = c.id_org                          ");
	    sqlQry.append("  left join en_ent_ip ei on ei.id_ent=c.id_en                            ");
	    sqlQry.append("  left join en_ent_op eo on eo.id_ent=c.id_en                            ");
	    sqlQry.append("  left join en_ent e on e.id_ent = c.id_en                               ");
	    sqlQry.append("  left join bd_dep dep  on dep.id_dep = e.id_dep_phy                     ");
	    sqlQry.append("  left join bd_dep dep1  on dep1.id_dep = e.id_dep_nur                   ");
	    sqlQry.append("  left join bd_psndoc psn  on psn.id_psndoc = e.id_emp_phy               ");
	    sqlQry.append("  left join bd_psndoc psn1  on psn1.id_psndoc = e.id_emp_nur             ");
	    sqlQry.append("  left join bd_bed bed  on bed.id_bed = ei.id_bed                        ");
	    sqlQry.append("  left join bd_srv srv on srv.id_srv=sug.id_srv                          ");
	    sqlQry.append("  left join bd_psndoc psn2 on  psn2.id_psndoc =sug.id_emp_operate        ");
	    sqlQry.append("  left join bd_psndoc psn3 on  psn3.id_psndoc =sug.id_emp_helper         ");
	    sqlQry.append("  left join bd_di_def di on  di.id_didef=c.id_didef                      ");
	    sqlQry.append("  left join bd_org org1 on org1.id_org = c.id_org_or                     ");
	    sqlQry.append("  left join bd_dep dep2 on dep2.id_dep =c.id_dep_or                      ");
	    sqlQry.append("  left join bd_dep dep_nur_or on dep_nur_or.id_dep=c.id_dep_nur_or       ");
	    sqlQry.append("  left join bd_psndoc psn_sign on psn_sign.id_psndoc = c.id_emp_sign     ");
		sqlQry.append("  left join bd_dep dep_sign on dep_sign.id_dep = c.id_dep_sign           ");
	    sqlQry.append("  left join bd_wg wg on wg.id_wg = c.id_wg_or                            ");
	    sqlQry.append("  left join bd_psndoc psn_or on psn_or.id_psndoc = c.id_emp_or           ");
	    sqlQry.append("  left join bd_dep dep_mp on dep_mp.id_dep = c.id_dep_mp                 ");
	    sqlQry.append("  left join bd_org org_mp on dep_mp.id_org = org_mp.id_org               ");
	    sqlQry.append("  where c.code_entp=? and grp.code=? and org.code=?        ");
	    sqlParam.addParam(param.getCode_entp());//就诊类型编码
		sqlParam.addParam(param.getCode_grp());//所属集团
		sqlParam.addParam(param.getCode_org());//所属组织
		if (!StringUtil.isEmpty(param.getFg_ip())) {//是否在院患者
			sqlQry.append(" and e.fg_ip=? ");
			sqlParam.addParam(param.getFg_ip());
		}
		
		if (!StringUtil.isEmpty(param.getCode_pat())) {//患者编码
			sqlQry.append(" and p.code=?");
			sqlParam.addParam(param.getCode_pat());
		}
		if (!StringUtil.isEmpty(param.getTimes_en())) {//就诊次数
			sqlQry.append(" and (case when c.code_entp in ('0103','10') then ei.times_ip else eo.times_op end)=?");
			sqlParam.addParam(param.getTimes_en());
		}
		if (!StringUtil.isEmpty(param.getCode_en())) {//就诊编码
			sqlQry.append(" and e.code=?");
			sqlParam.addParam(param.getCode_en());
		}
		if (!StringUtil.isEmpty(param.getDt_b_search())) {//查询开始时间
			sqlQry.append(" and c.dt_effe >=?");
			sqlParam.addParam(param.getDt_b_search());
		}
		if (!StringUtil.isEmpty(param.getDt_e_search())) {//查询结束时间
			sqlQry.append(" and c.dt_end <=?");
			sqlParam.addParam(param.getDt_e_search());
		}
		if (!StringUtil.isEmpty(param.getCode_or())) {//医嘱号
			sqlQry.append(" and c.code_or=?");
			sqlParam.addParam(param.getCode_or());
		}
		if (!StringUtil.isEmpty(param.getNo_applyform())) {//手术申请单号
			sqlQry.append(" and sug.no_applyform=?");
			sqlParam.addParam(param.getNo_applyform());
		}
		if (!StringUtil.isEmpty(param.getCode_emp_or())) {//开单医生编码
			sqlQry.append(" and psn_or.code=?");
			sqlParam.addParam(param.getCode_emp_or());
		}
		if (!StringUtil.isEmpty(param.getCode_dep_or())) {//开单科室编码
			sqlQry.append(" and dep2.code=?");
			sqlParam.addParam(param.getCode_dep_or());
		}
		if (!StringUtil.isEmpty(param.getCode_dep_nur_or())) {//病区编码
			sqlQry.append(" and dep_nur_or.code =?");
			sqlParam.addParam(param.getCode_dep_nur_or());
		}
		if (!StringUtil.isEmpty(param.getCode_emp_sign())) {//签署医生编码
			sqlQry.append(" and psn_sign.code =?");
			sqlParam.addParam(param.getCode_emp_sign());
		}
		if (!StringUtil.isEmpty(param.getCode_dep_sign())) {//签署科室编码
			sqlQry.append(" and dep_sign.code =?");
			sqlParam.addParam(param.getCode_dep_sign());
		}
		if (!StringUtil.isEmpty(param.getFg_sign())) {//签署标识
			sqlQry.append(" and c.fg_sign=?");
			sqlParam.addParam(param.getFg_sign());
		}
		if (!StringUtil.isEmpty(param.getFg_chk())) {//签署核对标识
			sqlQry.append(" and c.fg_chk=?");
			sqlParam.addParam(param.getFg_chk());
		}
		if (!StringUtil.isEmpty(param.getFg_canc())) {//作废标志
			sqlQry.append(" and c.fg_canc=?");
			sqlParam.addParam(param.getFg_canc());
		}
		if (!StringUtil.isEmpty(param.getFg_chk_canc())) {//作废确认标志
			sqlQry.append(" and c.fg_chk_canc=?");
			sqlParam.addParam(param.getFg_chk_canc());
		}
		if (!StringUtil.isEmpty(param.getSd_su_or())) {//医嘱状态
			sqlQry.append(" and  c.sd_su_or=?");
			sqlParam.addParam(param.getSd_su_or());
		}
		return sqlQry.toString();
	}
	
	/**
	 * 获取附加手术
	 * @return
	 */
	private String getSugAddSql(String code_or){
		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append(" select  srv.sortno as sortno_sug_add,         		");//序号
        sqlQry.append(" srv.code_srv as code_srv_sug_add,         		  		");//手术项目编码
        sqlQry.append(" srv.name as name_or_sug_add,              		");//手术项目名称
        sqlQry.append(" (case when srv.sortno='1' then '0'                  ");
        sqlQry.append("       else '1'                                      ");
        sqlQry.append(" end) as eu_sugaddtp                       			");//附加标识
        sqlQry.append(" from ci_or_srv srv                                  ");
        sqlQry.append(" left join ci_order c  on c.id_or=srv.id_or          ");
        sqlQry.append(" where c.code_or='"+code_or+"'                       ");
        return sqlQry.toString();
	}
	
	/**
	 * 获取附加手术
	 * @return
	 * @throws DAException 
	 */
	private Map<String,List<AddOprDTO>> getSugAddMap(String paramBuffer, SqlParam sqlParam) throws DAException{
		
		Map<String,List<AddOprDTO>> map = new HashMap<String,List<AddOprDTO>>();
		
		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append(" select  srv.id_or,srv.sortno as sortno_sug_add,         		");//序号
        sqlQry.append(" srv.code_srv as code_srv_sug_add,         		  		");//手术项目编码
        sqlQry.append(" srv.name as name_or_sug_add,              		");//手术项目名称
        sqlQry.append(" (case when srv.sortno='1' then '0'                  ");
        sqlQry.append("       else '1'                                      ");
        sqlQry.append(" end) as eu_sugaddtp                       			");//附加标识
        sqlQry.append(" from ci_or_srv srv                                  ");
        sqlQry.append(" where srv.id_or in ("+paramBuffer+") order by srv.id_or,srv.sortno");
        
        List<AddOprDTO> addOprList = (List<AddOprDTO>) new DAFacade().execQuery(sqlQry.toString(),sqlParam, new BeanListHandler(AddOprDTO.class));
        for(AddOprDTO addOpr: addOprList){
			String key = addOpr.getAttrVal("id_or").toString();
			if(!map.containsKey(key)){
				List<AddOprDTO> list = new ArrayList<AddOprDTO>();
				map.put(key, list);
			}
			map.get(key).add(addOpr);
		}
		
		return map;
        
	}
	/**
	 * 手术人员
	 * @param code_or
	 * @return
	 */
	private String getSugEmpSql(String code_or){
		StringBuilder sqlQry = new StringBuilder(); 
		sqlQry.append(" select emp.sortno as sortno_sug_emp,                         ");//序号
		sqlQry.append(" psn.code as code_emp_sug_emp,                                ");//人员
		sqlQry.append(" emp.sd_role as sd_role_sug_emp                               ");//角色编码
		sqlQry.append(" from ci_ap_sug_emp emp                                       ");
		sqlQry.append(" left join bd_psndoc psn on psn.id_psndoc = emp.id_emp        ");
		sqlQry.append(" left join ci_ap_sug sug on sug.id_apop = emp.id_apop         ");
		sqlQry.append(" left join ci_order c on c.id_or = sug.id_or       			 ");
		sqlQry.append(" where c.code_or='"+code_or+"'                         		 ");
		return sqlQry.toString();                                                    
	}
	
	/**
	 * 手术人员
	 * @param code_or
	 * @return
	 * @throws DAException 
	 */
	private Map<String,List<OprPerDTO>> getSugEmpMap(String paramBuffer, SqlParam sqlParam) throws DAException{
		
		Map<String,List<OprPerDTO>> map = new HashMap<String,List<OprPerDTO>>();
		StringBuilder sqlQry = new StringBuilder(); 
		sqlQry.append(" select sug.id_or,emp.sortno as sortno_sug_emp,");//序号
		sqlQry.append(" psn.code as code_emp_sug_emp,");//人员
		sqlQry.append(" emp.sd_role as sd_role_sug_emp");//角色编码
		sqlQry.append(" from ci_ap_sug_emp emp");
		sqlQry.append(" left join bd_psndoc psn on psn.id_psndoc = emp.id_emp");
		sqlQry.append(" left join ci_ap_sug sug on sug.id_apop = emp.id_apop ");
		sqlQry.append(" where sug.id_or in ("+paramBuffer+") order by sug.id_or,emp.sortno");
		List<OprPerDTO> oprPerList = (List<OprPerDTO>) new DAFacade().execQuery(sqlQry.toString(),sqlParam, new BeanListHandler(OprPerDTO.class));
		
		for(OprPerDTO oprPer: oprPerList){
			String key = oprPer.getAttrVal("id_or").toString();
			if(!map.containsKey(key)){
				List<OprPerDTO> list = new ArrayList<OprPerDTO>();
				map.put(key, list);
			}
			map.get(key).add(oprPer);
		}
		
		return map;
	}
	/**
	 * 费用明细
	 * @param code_or
	 * @return
	 */
	private String getSrvSql(String code_or){
		StringBuilder sqlQry = new StringBuilder(); 
		sqlQry.append(" select srv.code_srv as code_srv,                              ");//费用项目编码
		sqlQry.append(" srv.name as name_srv,                                         ");//费用项目名称
		sqlQry.append(" srv.quan_medu,                                                ");//费用项目单次数量
		sqlQry.append(" srv.sd_hpsrvtp as sd_hpsrvtp,                                 ");//医保目录类型
		sqlQry.append(" srv.fg_selfpay as fg_selfpay,                                 ");//自费标识
		sqlQry.append(" srv.fg_specill as fg_specill,                                 ");//特种病标识
		sqlQry.append(" srv.pri as pri,                                               ");//单价
		sqlQry.append(" srv.pri_std as pri_std,                                       ");//标准价
		sqlQry.append(" srv.pri_ratio as pri_ratio,                                   ");//价格系数
		sqlQry.append(" srv.fg_research as fg_research,                               ");//科研标识
		sqlQry.append(" srv.code_researchproject as code_researchproject,             ");//科研项目编码
		sqlQry.append(" org.code as code_org_mp_srv,                                  ");//费用执行机构
		sqlQry.append(" dep_mp.id_dep as code_org_mp_srv                              ");//费用执行科室
		sqlQry.append(" from ci_or_srv srv                                            ");
		sqlQry.append(" left join bd_dep dep_mp on dep_mp.id_dep=srv.id_dep_mp        ");
		sqlQry.append(" left join bd_org org on org.id_org = dep_mp.id_org            ");
		sqlQry.append(" left join ci_order c on srv.id_or = c.id_or                   ");
		sqlQry.append(" where c.code_or='"+code_or+"'                        		  ");
		return sqlQry.toString(); 
	}
	private Map<String,List<OprSrvDTO>> getSrvMap(String paramBuffer, SqlParam sqlParam) throws DAException{
		
		Map<String,List<OprSrvDTO>> map = new HashMap<String,List<OprSrvDTO>>();

		
		StringBuilder sqlQry = new StringBuilder(); 
		sqlQry.append(" select srv.id_or,srv.code_srv as code_srv,                              ");//费用项目编码
		sqlQry.append(" srv.name as name_srv,                                         ");//费用项目名称
		sqlQry.append(" srv.quan_medu,                                                ");//费用项目单次数量
		sqlQry.append(" srv.sd_hpsrvtp as sd_hpsrvtp,                                 ");//医保目录类型
		sqlQry.append(" srv.fg_selfpay as fg_selfpay,                                 ");//自费标识
		sqlQry.append(" srv.fg_specill as fg_specill,                                 ");//特种病标识
		sqlQry.append(" srv.pri as pri,                                               ");//单价
		sqlQry.append(" srv.pri_std as pri_std,                                       ");//标准价
		sqlQry.append(" srv.pri_ratio as pri_ratio,                                   ");//价格系数
		sqlQry.append(" srv.fg_research as fg_research,                               ");//科研标识
		sqlQry.append(" srv.code_researchproject as code_researchproject,             ");//科研项目编码
		sqlQry.append(" org.code as code_org_mp_srv,                                  ");//费用执行机构
		sqlQry.append(" dep_mp.id_dep as code_org_mp_srv                              ");//费用执行科室
		sqlQry.append(" from ci_or_srv srv                                            ");
		sqlQry.append(" left join bd_dep dep_mp on dep_mp.id_dep=srv.id_dep_mp        ");
		sqlQry.append(" left join bd_org org on org.id_org = dep_mp.id_org            ");
		sqlQry.append(" where srv.id_or in ("+paramBuffer+") order by srv.id_or,srv.sortno");
		List<OprSrvDTO> oprSrvList = (List<OprSrvDTO>) new DAFacade().execQuery(sqlQry.toString(),sqlParam,new BeanListHandler(OprSrvDTO.class));
		
		for(OprSrvDTO oprSrv: oprSrvList){
			String key = oprSrv.getAttrVal("id_or").toString();
			if(!map.containsKey(key)){
				List<OprSrvDTO> list = new ArrayList<OprSrvDTO>();
				map.put(key, list);
			}
			map.get(key).add(oprSrv);
		}
		
		return map;
	}
}

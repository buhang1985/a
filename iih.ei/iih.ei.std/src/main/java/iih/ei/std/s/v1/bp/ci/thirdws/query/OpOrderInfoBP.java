package iih.ei.std.s.v1.bp.ci.thirdws.query;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import iih.bd.base.utils.ArrayListUtil;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ei.std.d.v1.ci.order.op.d.EntAndOrderDiagDTO;
import iih.ei.std.d.v1.ci.order.op.d.EntAndOrderInfoDTO;
import iih.ei.std.d.v1.ci.order.op.d.OpOrderParamDTO;
import iih.ei.std.d.v1.ci.order.op.d.OpOrderResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 
 * @author yangdong
 *
 * @date 2019年11月14日上午10:21:55
 *
 * @classpath iih.ei.std.s.v1.bp.ci.thirdws.query.OpOrderInfoBP
 *
 *            医嘱查询接口（门诊模式）
 *
 */
public class OpOrderInfoBP extends IIHServiceBaseBP<OpOrderParamDTO, OpOrderResultDTO> {

	@Override
	protected void checkParam(OpOrderParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("医嘱查询失败:传入参数为空!");
		} else {
			if (StringUtil.isEmpty(param.getCode_entp())) {
				throw new BizException("医嘱查询失败:就诊类型编码为空!");
			}
			if (StringUtil.isEmpty(param.getCode_grp())) {
				throw new BizException("医嘱查询失败:所属集团编码为空!");
			}
			if (StringUtil.isEmpty(param.getCode_org())) {
				throw new BizException("医嘱查询失败:所属组织编码为空!");
			}
			//0190762: 标准接口：SI0132医嘱查询接口，去掉就诊次数或就诊编码的必填限制
			//if (StringUtil.isEmpty(param.getCode_en()) && StringUtil.isEmpty(param.getTimes_en())) {
			//	throw new BizException("医嘱查询失败:就诊次数和就诊编码不可同时为空！");
			//}
			if (!StringUtil.isEmpty(param.getModifyinterval())) {
				if (!isNumeric(param.getModifyinterval())) {
					throw new BizException("医嘱查询失败：修改间隔时间参数为整数");
				}
				
			}

		}
	}
	public static boolean isNumeric(String str){  
	    Pattern pattern = Pattern.compile("[0-9]*");  
	    return pattern.matcher(str).matches();     
	}
	@Override
	protected OpOrderResultDTO process(OpOrderParamDTO param) throws BizException {
		OpOrderResultDTO resultDTO = new OpOrderResultDTO();
		IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
		OrgDO[] orgDOs = orgRService.findByAttrValString("Code", param.getCode_org());
		if (orgDOs == null||orgDOs.length==0) {
			throw new BizException("医嘱查询失败:不存在所属组织！");
		}
		// 查询通用名模式还是商品模式
		String model = ParamsetQryUtil.getParaString(orgDOs[0].getId_org(), "BDMM0004");
		int modifytime = ParamsetQryUtil.getParaInt(orgDOs[0].getId_org(), ICiOrdNSysParamConst.SYS_PARAM_MODIFYINTERVAL);
		if (param.getModifyinterval()!=null) {
			int modifyinterval = Integer.parseInt( param.getModifyinterval() ); 

			if (modifyinterval>modifytime) {
				throw new BizException("医嘱查询失败:修改间隔时间不能超过"+modifytime+"分钟，如想修改极限值，请到轻量级修改参数CIOR0543的值!");
			}
		}
		// 获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql="";
		if (StringUtil.isEmpty(param.getSd_srvtp())) {
			String sql_drug = GetDrugInfo(param, sqlParam, model);
			String sql_nodrug = GetNoDrugInfo(param, sqlParam, model);
			sql = sql_drug +" union "+sql_nodrug;
		}else{
			if (param.getSd_srvtp().startsWith("01")) {
				String sql_drug = GetDrugInfo(param, sqlParam, model);
				sql = sql_drug;
			}else{
				String sql_nodrug = GetNoDrugInfo(param, sqlParam, model);
				sql = sql_nodrug;
			}
		
		}
		//根据code_or 进行排序
		sql=OrderBy(sql);
		Logger.error("医嘱查询（门诊模式）sql："+sql);
		Logger.error("医嘱查询（门诊模式）sqlParam："+sqlParam);
		List<EntAndOrderInfoDTO> list = (List<EntAndOrderInfoDTO>) new DAFacade().execQuery(sql,sqlParam,new BeanListHandler(EntAndOrderInfoDTO.class));
		Logger.error("医嘱查询（门诊模式）list.size()：" + list.size());
		if (ListUtil.isEmpty(list)) {
			return resultDTO;
		}
		// 判断医嘱查询回传的最大数据量
		int count = ParamsetQryUtil.getParaInt(orgDOs[0].getId_org(), ICiOrdNSysParamConst.SYS_PARAM_SEARCH_ORDER);
		if (list.size()>count) {
	
			throw new BizException("医嘱查询失败:查询数据量过大，请精确查询条件或者修改医嘱查询接口最大数据量的值！");
		}
		//0188089: 标准接口医嘱查询门诊SI0132增加 诊断信息 code，name
		Map<String, EntAndOrderDiagDTO> mapDiag = GetDiagInfo(list);
		for(EntAndOrderInfoDTO itm : list){
			if(mapDiag.containsKey(itm.getCode_en())){
				EntAndOrderDiagDTO diag = mapDiag.get(itm.getCode_en());
				itm.setCode_diag(diag.getCode_diag());
				itm.setName_diag(diag.getName_diag());
			}
		}
		resultDTO.setEntandorderinfodto(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
		
	}
	
	private String OrderBy(String sql) {
		
		return "select * from ("+sql+") order by code_or";
	}

	private String GetDrugInfo(OpOrderParamDTO param, SqlParam sqlParam, String model) {
		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append(" select grp.code as code_grp, ");// 所属集团
		sqlQry.append(" org.code as code_org, ");// 所属组织
		sqlQry.append(" pi.code as code_pat, ");// 患者
		sqlQry.append(" eo.times_op as times_en, ");// 就诊次数
		sqlQry.append(" e.code as code_en, ");// 就诊编码
		sqlQry.append(" ci_order.code_entp as code_entp, ");// 就诊类型编码
		sqlQry.append(" dep.code as code_dep_phy, ");// 当前就诊科室
		sqlQry.append(" psn.code as code_emp_phy, ");// 当前主管医生
		sqlQry.append(" psn1.code as code_emp_nur, ");// 当前责任护士
		sqlQry.append(" dep1.code as code_dep_nur, ");// 当前所在病区10
		sqlQry.append(" '' as code_bed, ");// 床位号
		sqlQry.append(" ci_order.fg_vip as fg_vip, ");// VIP标识
		sqlQry.append(" '' as fg_hecominsur, ");// 高端商保标识
		sqlQry.append(" pri.code as pri_pat_code, ");// 价格分类编码
		sqlQry.append(" pri.name as pri_pat_name, ");// 价格分类名称
		sqlQry.append(" e.name_pat as name_pat, ");// 姓名
		sqlQry.append(" e.sd_sex_pat as sd_sex_pat, ");// 性别编码
		sqlQry.append(" sex.name as name_sex_pat, ");// 性别名称
		sqlQry.append(" e.dt_birth_pat as dt_birth_pat, ");// 出生日期
		sqlQry.append(" pi.sd_idtp as sd_idtp, ");// 身份证件类型编码 20
		sqlQry.append(" idtp.name as name_idtp, ");// 身份证件类型名称
		sqlQry.append(" pi.id_code as id_code, ");// 身份证件类号码
		sqlQry.append(" pi.mob as mob, ");// 联系电话
		sqlQry.append(" e.dt_acpt as dt_enacpt,");// 接诊时间
		sqlQry.append(" ci_order.code_or as code_or, ");// 医嘱号
		sqlQry.append(" ci_order.code_or || ci_order.sortno as code_or_itm, ");// 医嘱下服务号
		sqlQry.append(" ci_order.dt_effe as dt_effe, ");// 医嘱开始时间
		sqlQry.append(" ci_order.days_or as days_or, ");// 医嘱天数
		sqlQry.append(" ci_order.fg_urgent as fg_urgent, ");// 加急标志
		sqlQry.append(" ci_order.des_or as des_or, ");// 备注(当前使用)30
		sqlQry.append(" ca.code as code_srvca,");// 服务基本分类编码
		sqlQry.append(" ca.name as name_srvca, ");// 服务基本分类名称
		sqlQry.append("	(case when substr(ci_order.sd_srvtp,0,2)='01' then srv.sd_srvtp else ci_order.sd_srvtp  end)as sd_srvtp,");// 医嘱类型编码
		sqlQry.append(" (case when substr(ci_order.sd_srvtp,0,2)='01' then name_srvtp.name else name_srvtp1.name end) as name_srvtp,");// 医嘱类型名称
		sqlQry.append(" dep_mp.code as code_dep_mp,");// 执行科室编码
		sqlQry.append(" dep_mp.name as name_dep_mp,");// 执行科室名称
		sqlQry.append(" ci_order.dt_entry as dt_entry,");// 开单时间
		sqlQry.append(" psn_or.code as code_emp_or,");// 开单医生编码
		sqlQry.append(" psn_or.name as name_emp_or,");// 开单医生名称
		sqlQry.append(" dep_or.code as code_dep_or,");// 开单科室编码 40
		sqlQry.append(" dep_or.name as name_dep_or,");// 开单科室名称
		sqlQry.append(" dep_nur_or.name as name_dep_nur_or,");// 开单所在病区名称
		sqlQry.append(" ci_order.fg_sign as fg_sign,");// 签署标识
		sqlQry.append(" psn_sign.code as code_emp_sign,");// 签署医生编码
		sqlQry.append(" psn_sign.name as name_emp_sign,");// 签署医生姓名
		sqlQry.append(" dep_sign.code as code_dep_sign,");// 签署科室编码
		sqlQry.append(" dep_sign.name as name_dep_sign,");// 签署科室名称
		sqlQry.append(" ci_order.fg_canc as fg_canc,");// 作废标志
		sqlQry.append(" psn_canc.code as code_emp_canc,");// 作废医生编码
		sqlQry.append(" psn_canc.name as name_emp_canc,");// 作废医生姓名 50
		sqlQry.append(" ci_order.orders as orders,");// 医嘱付数
		sqlQry.append(" ci_order. sd_su_bl as  sd_su_bl,");// 记账状态
		sqlQry.append(" ci_order.sd_su_or as sd_su_or ,");// 医嘱状态编码
		sqlQry.append(" name_su_or.name as name_su_or,");// 医嘱状态名称
		sqlQry.append("(case when substr(ci_order.sd_srvtp,0,2)='01' and " + model + "='0' then bd_srv.code ");
		sqlQry.append("      when substr(ci_order.sd_srvtp,0,2)='01' and " + model + "='1' then mm.code else bd_srv.code");
		sqlQry.append(" end) as code_or_srv,");// 医嘱项目编码
		sqlQry.append(" (case when substr(ci_order.sd_srvtp,0,2)!='01' then ci_order.name_or"
				+ " when substr(ci_order.sd_srvtp,0,2)='01' and bd_srv.fg_ctm='Y'then srv.name");
		sqlQry.append("  when substr(ci_order.sd_srvtp,0,2)='01' and  bd_srv.fg_ctm='N'then mm.name");
		sqlQry.append(" end) as name_or_srv,");// 医嘱项目名称
		sqlQry.append(" (case when substr(ci_order.sd_srvtp,0,2)='01' then ''    when substr(ci_order.sd_srvtp,0,2)!='01' then bd_srv.shortname     end)  as shortname,  ");// 医嘱简称
		sqlQry.append("	(case when  substr(ci_order.sd_srvtp,0,2)='01' then mm.printname else '' end) as printname,");// 药品打印名称
		sqlQry.append(" mm.sup_name as sup_name,");// 药品生产厂家
		sqlQry.append(" freq.code as code_freq,");// 频次编码 60
		sqlQry.append(" route.code as code_route,");// 给药方式编码
		sqlQry.append(" route.name as name_route,");// 给药方式名称
		sqlQry.append(" bd_wh.code as code_wh,");// 发药药房编码
		sqlQry.append(" mm.spec as spec,");// 规格
		sqlQry.append(" srv.fg_propc as fg_propc,");// 是否预防用药
		sqlQry.append(" srv.quan_medu as quan_medu,");// 单次医学剂量
		sqlQry.append(
				" (case when  substr(ci_order.sd_srvtp,0,2)='01' or substr(ci_order.sd_srvtp,0,4)='1401' then medu.code");
		sqlQry.append("       else ''");
		sqlQry.append(" end)as code_medu,");// 医学单位
		sqlQry.append("(case when  substr(ci_order.sd_srvtp,0,2)='01' then  decode(substr((to_char(ci_or_srv_mm.quan_medu_cur)),0,1),'.','0'||to_char(ci_or_srv_mm.quan_medu_cur),to_char(ci_or_srv_mm.quan_medu_cur)) else '' end) as quan_medu_cur,");// 界面录入单次用量
		sqlQry.append("ci_or_srv_mm.id_medu_cur  as code_medu_cur,");// 界面录入单次用量单位
		sqlQry.append("(case when  substr(ci_order.sd_srvtp,0,2)='01' then decode(substr((to_char(ci_or_srv_mm.factor_cur)),0,1),'.','0'||to_char(ci_or_srv_mm.factor_cur),to_char(ci_or_srv_mm.factor_cur)) else '' end)  as factor_cur,");// 界面录入单次用量单位换算系数
													// 70
		sqlQry.append("(case when  substr(ci_order.sd_srvtp,0,2)='01' then decode(substr((to_char(ci_or_srv_mm.quan_cur)),0,1),'.','0'||to_char(ci_or_srv_mm.quan_cur),to_char(ci_or_srv_mm.quan_cur)) else '' end)  as quan_cur,");// 总量
		sqlQry.append("pgku_cur.code as code_pgku_cur,");// 总量包装单位
		sqlQry.append(" pres.code as code_pres,");// 处方号
		sqlQry.append(" ci_order.fg_skintest as fg_skintest,");// 需皮试标记 皮试结果
		sqlQry.append(" srv.sd_nodispense as sd_nodispense,");// 不计费类型
		sqlQry.append(" srv.pri as pri");// 单价
		/*sqlQry.append(" srv.sd_hpsrvtp as sd_hpsrvtp,");// 医保目录类型
		sqlQry.append(" srv.fg_selfpay as fg_selfpay,");// 自费标识
		sqlQry.append(" srv.fg_specill as fg_specill,");// 特种病标识 80
		sqlQry.append(" srv.fg_research as fg_research,");// 科研标识
		sqlQry.append(" srv.code_researchproject as code_researchproject,");// 科研项目编码
		sqlQry.append(" mp_ne_lab_samp.no_bar as no_bar");// 标本号
*/		sqlQry.append(" from ci_or_srv   srv                                                                   ");
		sqlQry.append(" left join ci_order  on srv.id_or = ci_order.id_or                                   ");
		sqlQry.append(" left join bd_grp grp  on grp.id_grp = ci_order.id_grp                               ");
		sqlQry.append(" left join bd_org org  on org.id_org = ci_order.id_org                               ");
		sqlQry.append(" left join en_ent e  on e.id_ent = ci_order.id_en                                    ");
		sqlQry.append(" left join pi_pat pi  on pi.id_pat = ci_order.id_pat                                 ");
		sqlQry.append(" left join en_ent_op eo  on eo.id_ent = ci_order.id_en                               ");
		sqlQry.append(" left join bd_dep dep  on dep.id_dep = e.id_dep_phy                                  ");
		sqlQry.append(" left join bd_dep dep1  on dep1.id_dep = e.id_dep_nur                                ");
		sqlQry.append(" left join bd_psndoc psn  on psn.id_psndoc = e.id_emp_phy                            ");
		sqlQry.append(" left join bd_psndoc psn1  on psn1.id_psndoc = e.id_emp_nur                           ");
		sqlQry.append(" left join bd_pri_pat pri  on pri.name = e.id_pripat                                 ");
		sqlQry.append(" left join bd_udidoc sex  on e.id_sex_pat = sex.id_udidoc                            ");
		sqlQry.append(" left join bd_udidoc idtp  on idtp.id_udidoc = pi.id_idtp                            ");
		sqlQry.append(" left join  bd_srvca ca on ca.id_srvca =ci_order.id_srvca                            ");
		
		sqlQry.append(" left join bd_udidoc name_srvtp on name_srvtp.id_udidoc = srv.id_srvtp               ");
		sqlQry.append(" left join bd_udidoc name_srvtp1 on name_srvtp1.id_udidoc = ci_order.id_srvtp        ");
		sqlQry.append(" left join bd_dep dep_mp on dep_mp.id_dep = ci_order.id_dep_mp                       ");
		sqlQry.append(" left join bd_psndoc psn_or on psn_or.id_psndoc = ci_order.id_emp_or                 ");
		sqlQry.append(" left join bd_dep dep_or on dep_or.id_dep = ci_order.id_dep_or                       ");
		sqlQry.append(" left join bd_dep dep_nur_or on dep_nur_or.id_dep=ci_order.id_dep_nur_or             ");
		sqlQry.append(" left join bd_psndoc psn_sign on psn_sign.id_psndoc = ci_order.id_emp_sign           ");
		sqlQry.append(" left join bd_dep dep_sign on dep_sign.id_dep = ci_order.id_dep_sign                 ");
		sqlQry.append(" left join bd_psndoc psn_chk  on ci_order.id_emp_chk =psn_chk.id_psndoc              ");
		sqlQry.append(" left join bd_psndoc psn_stop on psn_stop.id_psndoc=ci_order.id_emp_stop             ");
		sqlQry.append(" left join bd_psndoc psn_canc on psn_canc.id_psndoc = ci_order.id_emp_canc           ");
		sqlQry.append(" left join bd_udidoc name_su_or on name_su_or.id_udidoc = ci_order.id_su_or          ");
		sqlQry.append(" left join bd_srv on bd_srv.id_srv=ci_order.id_srv                                   ");
		sqlQry.append(" left join ci_or_srv_mm on srv.id_orsrv=ci_or_srv_mm.id_orsrv                        ");
		sqlQry.append(" left join bd_mm mm on mm.id_mm = ci_or_srv_mm.id_mm                                 ");
		sqlQry.append(" left join bd_freq freq on  freq.id_freq = ci_order.id_freq                          ");
		sqlQry.append(" left join bd_route route on route.id_route=srv.id_route                             ");
		sqlQry.append(" left join bd_wh on bd_wh.id_dep_belong = srv.id_dep_wh                              ");
		sqlQry.append(" left join bd_measdoc medu on medu.id_measdoc = srv.id_medu                          ");
		sqlQry.append(" left join bd_measdoc pgku_base on pgku_base.id_measdoc = ci_or_srv_mm.id_pgku_base  ");
		sqlQry.append(" left join bd_measdoc pgku_cur on pgku_cur.id_measdoc = ci_or_srv_mm.id_pgku_cur     ");
		sqlQry.append(" left join mp_or_pr on mp_or_pr.id_or = ci_order.id_or                               ");
		sqlQry.append(" left join mp_ne_lab_samp_itm_ref ref1 on ref1.id_or_pr =mp_or_pr.id_or_pr           ");
		sqlQry.append(" left join mp_ne_lab_samp on mp_ne_lab_samp.id_labsamp = ref1.id_labsamp             ");
		sqlQry.append(" left join ci_pres pres on pres.id_pres=srv.id_pres                                  ");
		sqlQry.append(" left join ci_skin_test skin on skin.id_or = ci_order.id_or                          ");
		sqlQry.append(" where  srv.fg_or='Y' and (substr(ci_order.sd_srvtp, 0, 2)!='01') and ci_order.code_entp=?  and   grp.code=? and org.code=?      ");
		sqlParam.addParam(param.getCode_entp());// 就诊类型编码
		sqlParam.addParam(param.getCode_grp());// 所属集团
		sqlParam.addParam(param.getCode_org());// 所属组织
		if (!StringUtil.isEmpty(param.getCode_pat())) {//患者编码
			sqlQry.append(" and pi.code=?");
			sqlParam.addParam(param.getCode_pat());
		}
		if (!StringUtil.isEmpty(param.getTimes_en())) {// 就诊次数
			sqlQry.append(" and eo.times_op=?");
			sqlParam.addParam(param.getTimes_en());
		}
		if (!StringUtil.isEmpty(param.getCode_en())) {// 就诊编码
			sqlQry.append(" and e.code=?");
			sqlParam.addParam(param.getCode_en());
		}
		if (!StringUtil.isEmpty(param.getCode_srvca())) {// 服务基本分类编码
			sqlQry.append("  and ca.code =?");
			sqlParam.addParam(param.getCode_srvca());
		}
		if (!StringUtil.isEmpty(param.getSd_srvtp())) {// 医嘱类型
			sqlQry.append(" and ci_order.sd_srvtp =?");
			sqlParam.addParam(param.getSd_srvtp());
		}
		if (!StringUtil.isEmpty(param.getDt_b_search())) {//查询开始时间
			sqlQry.append(" and ci_order.dt_effe >=?");
			sqlParam.addParam(param.getDt_b_search());
		}
		if (!StringUtil.isEmpty(param.getDt_e_search())) {//查询结束时间
			sqlQry.append(" and ci_order.dt_end <=?");
			sqlParam.addParam(param.getDt_e_search());
		}
		if (!StringUtil.isEmpty(param.getCode_or())) {//医嘱号
			sqlQry.append(" and ci_order.code_or=?");
			sqlParam.addParam(param.getCode_or());
		}
		if (!StringUtil.isEmpty(param.getCode_emp_sign())) {//签署医生编码
			sqlQry.append(" and psn_sign.code=?");
			sqlParam.addParam(param.getCode_emp_sign());
		}
		if (!StringUtil.isEmpty(param.getCode_dep_sign())) {//签署科室编码
			sqlQry.append(" and dep_sign.code=?");
			sqlParam.addParam(param.getCode_dep_sign());
		}
		if (!StringUtil.isEmpty(param.getFg_sign())) {//签署标识
			sqlQry.append(" and ci_order.fg_sign=?");
			sqlParam.addParam(param.getFg_sign());
		}
		if (!StringUtil.isEmpty(param.getFg_chk())) {//签署核对标识
			sqlQry.append(" and ci_order.fg_chk=?");
			sqlParam.addParam(param.getFg_chk());
		}
		if (!StringUtil.isEmpty(param.getFg_canc())) {//作废标志
			sqlQry.append(" and ci_order.fg_canc=?");
			sqlParam.addParam(param.getFg_canc());
		}
		if (!StringUtil.isEmpty(param.getSd_su_bl())) {//记账状态
			sqlQry.append(" and ci_order.sd_su_bl=?");
			sqlParam.addParam(param.getSd_su_bl());
		}
		if(!StringUtil.isEmpty(param.getCode_dep_mp())){//执行科室编码
			sqlQry.append(" and dep_mp.code=?");
			sqlParam.addParam(param.getCode_dep_mp());
		}
		if (!StringUtil.isEmpty(param.getModifyinterval())) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   Calendar beforeTime = Calendar.getInstance();
			   int modifyinterval = Integer.parseInt(param.getModifyinterval() ); 
			   beforeTime.add(Calendar.MINUTE, -modifyinterval);// 几分钟之前的时间
			   Date beforeD = beforeTime.getTime();
			   String time = sdf.format(beforeD);
			sqlQry.append(" and ci_order.sv > '"+time+"'");
		}
		return sqlQry.toString();
	}

	private String GetNoDrugInfo(OpOrderParamDTO param, SqlParam sqlParam,String model) {
		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append(" select grp.code as code_grp, ");// 所属集团
		sqlQry.append(" org.code as code_org, ");// 所属组织
		sqlQry.append(" pi.code as code_pat, ");// 患者
		sqlQry.append(" eo.times_op as times_en, ");// 就诊次数
		sqlQry.append(" e.code as code_en, ");// 就诊编码
		sqlQry.append(" ci_order.code_entp as code_entp, ");// 就诊类型编码
		sqlQry.append(" dep.code as code_dep_phy, ");// 当前就诊科室
		sqlQry.append(" psn.code as code_emp_phy, ");// 当前主管医生
		sqlQry.append(" psn1.code as code_emp_nur, ");// 当前责任护士
		sqlQry.append(" dep1.code as code_dep_nur, ");// 当前所在病区10
		sqlQry.append(" '' as code_bed, ");// 床位号
		sqlQry.append(" ci_order.fg_vip as fg_vip, ");// VIP标识
		sqlQry.append(" '' as fg_hecominsur, ");// 高端商保标识
		sqlQry.append(" pri.code as pri_pat_code, ");// 价格分类编码
		sqlQry.append(" pri.name as pri_pat_name, ");// 价格分类名称
		sqlQry.append(" e.name_pat as name_pat, ");// 姓名
		sqlQry.append(" e.sd_sex_pat as sd_sex_pat, ");// 性别编码
		sqlQry.append(" sex.name as name_sex_pat, ");// 性别名称
		sqlQry.append(" e.dt_birth_pat as dt_birth_pat, ");// 出生日期
		sqlQry.append(" pi.sd_idtp as sd_idtp, ");// 身份证件类型编码 20
		sqlQry.append(" idtp.name as name_idtp, ");// 身份证件类型名称
		sqlQry.append(" pi.id_code as id_code, ");// 身份证件类号码
		sqlQry.append(" pi.mob as mob, ");// 联系电话
		sqlQry.append(" e.dt_acpt as dt_enacpt,");// 接诊时间
		sqlQry.append(" ci_order.code_or as code_or, ");// 医嘱号
		sqlQry.append(" ci_order.code_or || ci_order.sortno as code_or_itm, ");// 医嘱下服务号
		sqlQry.append(" ci_order.dt_effe as dt_effe, ");// 医嘱开始时间
		sqlQry.append(" ci_order.days_or as days_or, ");// 医嘱天数
		sqlQry.append(" ci_order.fg_urgent as fg_urgent, ");// 加急标志
		sqlQry.append(" ci_order.des_or as des_or, ");// 备注(当前使用)30
		sqlQry.append(" ca.code as code_srvca,");// 服务基本分类编码
		sqlQry.append(" ca.name as name_srvca, ");// 服务基本分类名称
		sqlQry.append("	(case when substr(ci_order.sd_srvtp,0,2)='01' then srv.sd_srvtp else ci_order.sd_srvtp  end)as sd_srvtp,");// 医嘱类型编码
		sqlQry.append(" (case when substr(ci_order.sd_srvtp,0,2)='01' then name_srvtp.name else name_srvtp1.name end) as name_srvtp,");// 医嘱类型名称
		sqlQry.append(" dep_mp.code as code_dep_mp,");// 执行科室编码
		sqlQry.append(" dep_mp.name as name_dep_mp,");// 执行科室名称
		sqlQry.append(" ci_order.dt_entry as dt_entry,");// 开单时间
		sqlQry.append(" psn_or.code as code_emp_or,");// 开单医生编码
		sqlQry.append(" psn_or.name as name_emp_or,");// 开单医生名称
		sqlQry.append(" dep_or.code as code_dep_or,");// 开单科室编码 40
		sqlQry.append(" dep_or.name as name_dep_or,");// 开单科室名称
		sqlQry.append(" dep_nur_or.name as name_dep_nur_or,");// 开单所在病区名称
		sqlQry.append(" ci_order.fg_sign as fg_sign,");// 签署标识
		sqlQry.append(" psn_sign.code as code_emp_sign,");// 签署医生编码
		sqlQry.append(" psn_sign.name as name_emp_sign,");// 签署医生姓名
		sqlQry.append(" dep_sign.code as code_dep_sign,");// 签署科室编码
		sqlQry.append(" dep_sign.name as name_dep_sign,");// 签署科室名称
		sqlQry.append(" ci_order.fg_canc as fg_canc,");// 作废标志
		sqlQry.append(" psn_canc.code as code_emp_canc,");// 作废医生编码
		sqlQry.append(" psn_canc.name as name_emp_canc,");// 作废医生姓名 50
		sqlQry.append(" ci_order.orders as orders,");// 医嘱付数
		sqlQry.append(" ci_order. sd_su_bl as  sd_su_bl,");// 记账状态
		sqlQry.append(" ci_order.sd_su_or as sd_su_or ,");// 医嘱状态编码
		sqlQry.append(" name_su_or.name as name_su_or,");// 医嘱状态名称
		sqlQry.append("(case when substr(ci_order.sd_srvtp,0,2)='01' and " + model + "='0' then bd_srv.code ");
		sqlQry.append("      when substr(ci_order.sd_srvtp,0,2)='01' and " + model + "='1' then mm.code else bd_srv.code");
		sqlQry.append(" end) as code_or_srv,");// 医嘱项目编码
		sqlQry.append(" (case when substr(ci_order.sd_srvtp,0,2)!='01' then ci_order.name_or"
				+ " when substr(ci_order.sd_srvtp,0,2)='01' and bd_srv.fg_ctm='Y'then srv.name");
		sqlQry.append("  when substr(ci_order.sd_srvtp,0,2)='01' and  bd_srv.fg_ctm='N'then mm.name");
		sqlQry.append(" end) as name_or_srv,");// 医嘱项目名称
		sqlQry.append(" (case when substr(ci_order.sd_srvtp,0,2)='01' then ''    when substr(ci_order.sd_srvtp,0,2)!='01' then bd_srv.shortname     end)  as shortname,  ");// 医嘱简称
		
		sqlQry.append(" (case when  substr(ci_order.sd_srvtp,0,2)='01' then mm.printname else '' end) as printname,");// 药品打印名称
		sqlQry.append(" mm.sup_name as sup_name,");// 药品生产厂家
		sqlQry.append(" freq.code as code_freq,");// 频次编码 60
		sqlQry.append(" route.code as code_route,");// 给药方式编码
		sqlQry.append(" route.name as name_route,");// 给药方式名称
		sqlQry.append(" bd_wh.code as code_wh,");// 发药药房编码
		sqlQry.append(" mm.spec as spec,");// 规格
		sqlQry.append(" srv.fg_propc as fg_propc,");// 是否预防用药
		sqlQry.append(" srv.quan_medu as quan_medu,");// 单次医学剂量
		sqlQry.append(
				" (case when  substr(ci_order.sd_srvtp,0,2)='01' or substr(ci_order.sd_srvtp,0,4)='1401' then medu.code");
		sqlQry.append("       else ''");
		sqlQry.append(" end)as code_medu,");// 医学单位
		sqlQry.append("(case when  substr(ci_order.sd_srvtp,0,2)='01' then  decode(substr((to_char(ci_or_srv_mm.quan_medu_cur)),0,1),'.','0'||to_char(ci_or_srv_mm.quan_medu_cur),to_char(ci_or_srv_mm.quan_medu_cur)) else '' end) as quan_medu_cur,");// 界面录入单次用量
		sqlQry.append("ci_or_srv_mm.id_medu_cur  as code_medu_cur,");// 界面录入单次用量单位
		sqlQry.append("(case when  substr(ci_order.sd_srvtp,0,2)='01' then decode(substr((to_char(ci_or_srv_mm.factor_cur)),0,1),'.','0'||to_char(ci_or_srv_mm.factor_cur),to_char(ci_or_srv_mm.factor_cur)) else '' end)  as factor_cur,");// 界面录入单次用量单位换算系数
													// 70
		sqlQry.append("(case when  substr(ci_order.sd_srvtp,0,2)='01' then decode(substr((to_char(ci_or_srv_mm.quan_cur)),0,1),'.','0'||to_char(ci_or_srv_mm.quan_cur),to_char(ci_or_srv_mm.quan_cur)) else '' end)  as quan_cur,");// 总量
		sqlQry.append("pgku_cur.code as code_pgku_cur,");// 总量包装单位
		sqlQry.append(" pres.code as code_pres,");// 处方号
		sqlQry.append(" ci_order.fg_skintest as fg_skintest,");// 需皮试标记 皮试结果
		sqlQry.append(" srv.sd_nodispense as sd_nodispense,");// 不计费类型
		sqlQry.append(" srv.pri as pri");// 单价
		/*sqlQry.append(" srv.sd_hpsrvtp as sd_hpsrvtp,");// 医保目录类型
		sqlQry.append(" srv.fg_selfpay as fg_selfpay,");// 自费标识
		sqlQry.append(" srv.fg_specill as fg_specill,");// 特种病标识 80
		sqlQry.append(" srv.fg_research as fg_research,");// 科研标识
		sqlQry.append(" srv.code_researchproject as code_researchproject,");// 科研项目编码
		sqlQry.append(" mp_ne_lab_samp.no_bar as no_bar");// 标本号
*/		sqlQry.append(" from ci_order                                                                       ");
		sqlQry.append(" left join bd_grp grp  on grp.id_grp = ci_order.id_grp                               ");
		sqlQry.append(" left join bd_org org  on org.id_org = ci_order.id_org                               ");
		sqlQry.append(" left join en_ent e  on e.id_ent = ci_order.id_en                                    ");
		sqlQry.append(" left join pi_pat pi  on pi.id_pat = ci_order.id_pat                                 ");
		sqlQry.append(" left join en_ent_op eo  on eo.id_ent = ci_order.id_en                               ");
		sqlQry.append(" left join bd_dep dep  on dep.id_dep = e.id_dep_phy                                  ");
		sqlQry.append(" left join bd_dep dep1  on dep1.id_dep = e.id_dep_nur                                ");
		sqlQry.append(" left join bd_psndoc psn  on psn.id_psndoc = e.id_emp_phy                            ");
		sqlQry.append(" left join bd_psndoc psn1  on psn1.id_psndoc = e.id_emp_nur                           ");
		sqlQry.append(" left join bd_pri_pat pri  on pri.name = e.id_pripat                                 ");
		sqlQry.append(" left join bd_udidoc sex  on e.id_sex_pat = sex.id_udidoc                            ");
		sqlQry.append(" left join bd_udidoc idtp  on idtp.id_udidoc = pi.id_idtp                            ");
		sqlQry.append(" left join  bd_srvca ca on ca.id_srvca =ci_order.id_srvca                            ");
		sqlQry.append(" left join ci_or_srv srv on srv.id_or = ci_order.id_or                               ");
		sqlQry.append(" left join bd_udidoc name_srvtp on name_srvtp.id_udidoc = srv.id_srvtp               ");
		sqlQry.append(" left join bd_udidoc name_srvtp1 on name_srvtp1.id_udidoc = ci_order.id_srvtp        ");
		sqlQry.append(" left join bd_dep dep_mp on dep_mp.id_dep = ci_order.id_dep_mp                       ");
		sqlQry.append(" left join bd_psndoc psn_or on psn_or.id_psndoc = ci_order.id_emp_or                 ");
		sqlQry.append(" left join bd_dep dep_or on dep_or.id_dep = ci_order.id_dep_or                       ");
		sqlQry.append(" left join bd_dep dep_nur_or on dep_nur_or.id_dep=ci_order.id_dep_nur_or             ");
		sqlQry.append(" left join bd_psndoc psn_sign on psn_sign.id_psndoc = ci_order.id_emp_sign           ");
		sqlQry.append(" left join bd_dep dep_sign on dep_sign.id_dep = ci_order.id_dep_sign                 ");
		sqlQry.append(" left join bd_psndoc psn_chk  on ci_order.id_emp_chk =psn_chk.id_psndoc              ");
		sqlQry.append(" left join bd_psndoc psn_stop on psn_stop.id_psndoc=ci_order.id_emp_stop             ");
		sqlQry.append(" left join bd_psndoc psn_canc on psn_canc.id_psndoc = ci_order.id_emp_canc           ");
		sqlQry.append(" left join bd_udidoc name_su_or on name_su_or.id_udidoc = ci_order.id_su_or          ");
		sqlQry.append(" left join bd_srv on bd_srv.id_srv=ci_order.id_srv                                   ");
		sqlQry.append(" left join ci_or_srv_mm on srv.id_orsrv=ci_or_srv_mm.id_orsrv                        ");
		sqlQry.append(" left join bd_mm mm on mm.id_mm = ci_or_srv_mm.id_mm                                 ");
		sqlQry.append(" left join bd_freq freq on  freq.id_freq = ci_order.id_freq                          ");
		sqlQry.append(" left join bd_route route on route.id_route=srv.id_route                             ");
		sqlQry.append(" left join bd_wh on bd_wh.id_dep_belong = srv.id_dep_wh                              ");
		sqlQry.append(" left join bd_measdoc medu on medu.id_measdoc = srv.id_medu                          ");
		sqlQry.append(" left join bd_measdoc pgku_base on pgku_base.id_measdoc = ci_or_srv_mm.id_pgku_base  ");
		sqlQry.append(" left join bd_measdoc pgku_cur on pgku_cur.id_measdoc = ci_or_srv_mm.id_pgku_cur     ");
		sqlQry.append(" left join mp_or_pr on mp_or_pr.id_or = ci_order.id_or                               ");
		sqlQry.append(" left join mp_ne_lab_samp_itm_ref ref1 on ref1.id_or_pr =mp_or_pr.id_or_pr           ");
		sqlQry.append(" left join mp_ne_lab_samp on mp_ne_lab_samp.id_labsamp = ref1.id_labsamp             ");
		sqlQry.append(" left join ci_pres pres on pres.id_pres=srv.id_pres                                  ");
		sqlQry.append(" left join ci_skin_test skin on skin.id_or = ci_order.id_or                          ");
		sqlQry.append(" where  (( substr(ci_order.sd_srvtp, 0, 2) = '01' and srv.fg_or='Y')    or(substr(ci_order.sd_srvtp, 0, 2) != '01')) and  (substr(ci_order.sd_srvtp, 0, 2) = '01' )  and  ci_order.code_entp=?  and grp.code=? and org.code=?        ");
		sqlParam.addParam(param.getCode_entp());// 就诊类型编码 
		sqlParam.addParam(param.getCode_grp());// 所属集团
		sqlParam.addParam(param.getCode_org());// 所属组织
		if (!StringUtil.isEmpty(param.getCode_pat())) {//患者编码
			sqlQry.append(" and pi.code=?");
			sqlParam.addParam(param.getCode_pat());
		}
		if (!StringUtil.isEmpty(param.getTimes_en())) {// 就诊次数
			sqlQry.append(" and eo.times_op=?");
			sqlParam.addParam(param.getTimes_en());
		}
		if (!StringUtil.isEmpty(param.getCode_en())) {// 就诊编码
			sqlQry.append(" and e.code=?");
			sqlParam.addParam(param.getCode_en());
		}
		if (!StringUtil.isEmpty(param.getCode_srvca())) {// 服务基本分类编码
			sqlQry.append("  and ca.code =?");
			sqlParam.addParam(param.getCode_srvca());
		}
		if (!StringUtil.isEmpty(param.getSd_srvtp())) {// 医嘱类型
			sqlQry.append(" and ci_order.sd_srvtp =?");
			sqlParam.addParam(param.getSd_srvtp());
		}
		if (!StringUtil.isEmpty(param.getDt_b_search())) {//查询开始时间
			sqlQry.append(" and ci_order.dt_effe >=?");
			sqlParam.addParam(param.getDt_b_search());
		}
		if (!StringUtil.isEmpty(param.getDt_e_search())) {//查询结束时间
			sqlQry.append(" and ci_order.dt_end <=?");
			sqlParam.addParam(param.getDt_e_search());
		}
		if (!StringUtil.isEmpty(param.getCode_or())) {//医嘱号
			sqlQry.append(" and ci_order.code_or=?");
			sqlParam.addParam(param.getCode_or());
		}
		if (!StringUtil.isEmpty(param.getCode_emp_sign())) {//签署医生编码
			sqlQry.append(" and psn_sign.code=?");
			sqlParam.addParam(param.getCode_emp_sign());
		}
		if (!StringUtil.isEmpty(param.getCode_dep_sign())) {//签署科室编码
			sqlQry.append(" and dep_sign.code=?");
			sqlParam.addParam(param.getCode_dep_sign());
		}
		if (!StringUtil.isEmpty(param.getFg_sign())) {//签署标识
			sqlQry.append(" and ci_order.fg_sign=?");
			sqlParam.addParam(param.getFg_sign());
		}
		if (!StringUtil.isEmpty(param.getFg_chk())) {//签署核对标识
			sqlQry.append(" and ci_order.fg_chk=?");
			sqlParam.addParam(param.getFg_chk());
		}
		if (!StringUtil.isEmpty(param.getFg_canc())) {//作废标志
			sqlQry.append(" and ci_order.fg_canc=?");
			sqlParam.addParam(param.getFg_canc());
		}
		if (!StringUtil.isEmpty(param.getSd_su_bl())) {//记账状态
			sqlQry.append(" and ci_order.sd_su_bl=?");
			sqlParam.addParam(param.getSd_su_bl());
		}
		if(!StringUtil.isEmpty(param.getCode_dep_mp())){//执行科室编码
			sqlQry.append(" and dep_mp.code=?");
			sqlParam.addParam(param.getCode_dep_mp());
		}
		if (!StringUtil.isEmpty(param.getModifyinterval())) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			   Calendar beforeTime = Calendar.getInstance();
			   int modifyinterval = Integer.parseInt(param.getModifyinterval() ); 
			   beforeTime.add(Calendar.MINUTE, -modifyinterval);// 几分钟之前的时间
			   Date beforeD = beforeTime.getTime();
			   String time = sdf.format(beforeD);
			sqlQry.append(" and ci_order.sv > '"+time+"'");
		}
		return sqlQry.toString();
	}

	//0188089: 标准接口医嘱查询门诊SI0132增加 诊断信息 code，name
	private Map<String, EntAndOrderDiagDTO> GetDiagInfo(List<EntAndOrderInfoDTO> list) throws DAException {
		List<String> listCodes = new ArrayList<String>();
		for(EntAndOrderInfoDTO itm : list){
			if(!listCodes.contains(itm.getCode_en())){
				listCodes.add(itm.getCode_en());
			}
		}
		Map<String, EntAndOrderDiagDTO> ret = new HashMap<String, EntAndOrderDiagDTO>();
		StringBuilder sqlQry = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sqlQry.append("SELECT di_ent.code_en,di_itm.id_didef_code code_diag,di_itm.id_didef_name name_diag");
		sqlQry.append(" FROM (SELECT  ent.code code_en,di.id_en, max(di.dt_di) dt_di FROM ci_di di inner join en_ent ent on di.id_en=ent.id_ent");
		sqlQry.append(" WHERE fg_sign = 'Y' and fg_cancel='N' and (");
		for(int i=0; i<listCodes.size(); i++){
			if(i == 0){
				sqlQry.append("ent.code = ?");
			}else{
				sqlQry.append(" or ent.code = ?");
			}
			String code_en = listCodes.get(i);
			sqlParam.addParam(code_en);
		}
		sqlQry.append(") Group By ent.code,di.id_en) di_ent");
		sqlQry.append(" INNER JOIN ci_di di ON di_ent.id_en = di.id_en and di_ent.dt_di=di.dt_di");
		sqlQry.append(" INNER JOIN ci_di_itm di_itm ON di.id_di = di_itm.id_di");
		sqlQry.append(" Where di_itm.fg_majdi='Y'");
		List<EntAndOrderDiagDTO> listDiag = (List<EntAndOrderDiagDTO>) new DAFacade().execQuery(sqlQry.toString(),sqlParam,new BeanListHandler(EntAndOrderDiagDTO.class));
		for(EntAndOrderDiagDTO itm : listDiag){
			if(!ret.containsKey(itm.getCode_en())){
				ret.put(itm.getCode_en(), itm);
			}
		}
		return ret;
	}
}

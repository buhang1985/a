package iih.ci.ord.ciordsheet.bp;

import java.util.List;

import iih.ci.ord.ciordsheet.CiOrdSheetDTO;
import iih.ci.ord.ciordsheet.CiOrdSheetParamDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 查询医嘱单打印数据
 * @author Young
 *
 */
public class GetOrdSheetDataBaseBP {

	public List<CiOrdSheetDTO> exec(CiOrdSheetParamDTO paramDTO, String pageNums)
			throws Exception {
		return CiorderPrintUtils.GetQueryResulte(CiOrdSheetDTO.class, this.getQuerySql(paramDTO, pageNums));
	}
	
	/**
	 * 获取查询的sql语句
	 * @return
	 */
	protected String getQuerySql(CiOrdSheetParamDTO paramDTO, String pageNums) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select * from (");
		buffer.append(this.getStrFields(paramDTO));
		buffer.append(" from (");
		buffer.append(this.getStrFieldsOrSrvMM());
		buffer.append(this.getFromSqlOrSrvMM());
		buffer.append(this.getWhereSqlOrSrvMM(paramDTO, pageNums));
		buffer.append(") ORSRVMM");
		buffer.append(this.getFromSql());
		buffer.append(")");
		buffer.append(this.getOrderBySql());

		return buffer.toString();
	}
	
	 /**
	 * 查询sql语句字段
	 * @return
	 */
	protected String getStrFieldsOrSrvMM() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ORD.id_grp,ORD.id_org,ORD.id_pat,ORD.id_en,");
		sb.append("ORD.id_emp_sign,ORD.dt_sign,ORD.id_emp_chk,ORD.id_emp_stop,ORD.id_emp_chk_stop,ORD.id_emp_canc,");
		sb.append("ORD.id_or||','||ORSRV.id_srv||','||ORSRV.sortno id_orsrv_key,ORD.id_or,ORD.content_or,ORD.code_or,ORD.sd_srvtp,ORD.dt_effe,");
		sb.append("(case when ORD.dt_end>'2098-01-01 00:00:00' then '' else ORD.dt_end end) dt_end,");
		sb.append("ORD.dt_canc,ORD.fg_chk,ORD.fg_chk_stop,ORD.fg_chk_canc,Skintestrst.code,SKINTEST.sd_rst_skintest,");
		sb.append("(case when ORD.fg_chk_canc='Y' then '取消' else '' end) cancelName,");
//		sb.append("(case when ORD.fg_pres_outp='Y' then '【出院带药】' else '' end)||ORD.des_or des_or,ORD.orders,ORD.fg_set,");
		sb.append("ORD.des_or,ORD.orders,ORD.fg_set,ORD.Fg_pres_outp,ORD.Fg_wholepack,");
		sb.append("(case when ORD.fg_pres_outp='Y' then 'N' else ORD.fg_long end) as fg_long,");
		sb.append("ORSRV.fg_self,ORSRV.fg_selfsrv,");
		// 医嘱服务项目：服务名、剂量
		sb.append("(case when ORSRV.fg_mm='Y' then (ORSRV.name||(case length(ORSRV.id_boildes) when 1 then '' else '('||BOILDES.name||')' end)||' '||decode(substr(ORSRV.quan_medu,1,1),'.','0'||ORSRV.quan_medu,ORSRV.quan_medu)||MEAS.name) ");
		sb.append("else ORSRV.name end) name_srv,");
//		sb.append("(case when ORD.fg_pres_outp='Y' or ORD.Fg_wholepack='Y' then ORSRV.quan_total_medu else ORSRV.quan_medu end) quan_medu,ORD.sortno,ORSRV.sortno sortno_srv,");
		sb.append("ORSRV.quan_medu quan_medu,ORD.sortno,ORSRV.sortno sortno_srv,");
		// 医嘱服务项目物品：物品名称
		sb.append("SRVMM.name_mm,");
		// 医嘱服务项目物品：商品打印名称
		sb.append("MM.printname name_prn,");
		// 医疗物品_基本信息：物品规格
		sb.append("MM.spec,");
		// 计量单位：单位名称
//		sb.append("(case when ORD.fg_pres_outp='Y' or ORD.Fg_wholepack='Y' then MEAS1.name else MEAS.name end) medu_name,");
		sb.append("MEAS.name medu_name,");
		// 用法：用法名称
		sb.append("ROUT.name route_name,");
		// 用法要求
		sb.append("ROUTDES.name routedes_name,");
		// 频次： 频次名称
		sb.append("FREQ.name freq_name,");
		// 皮试标识
		sb.append("ord.fg_skintest fg_skintest,");
		// 加急标识
		sb.append("ord.fg_urgent,");
		sb.append("SRVMM.quan_cur,");
		sb.append("MEAS1.name Name_unit_sale");
		// 预住院标识【0185267: 预住院医嘱单打印处理】
		sb.append(",nvl(ciorpip.fg_pip,'N') fg_pip");
		
		return sb.toString();
	}
	
	/**
	 * 获取from部分语句
	 * @return
	 */
	protected String getFromSqlOrSrvMM() {
		StringBuilder sb = new StringBuilder();
		sb.append(" from ci_order ORD inner join ci_or_srv ORSRV on ORD.id_or=ORSRV.id_or and ORSRV.fg_or='Y' and (ORSRV.SD_NODISPENSE!='2' or ORSRV.SD_NODISPENSE is null)")
//		sb.append(" from ci_order ORD inner join ci_or_srv ORSRV on ORD.id_or=ORSRV.id_or and ORSRV.fg_or='Y' and ORSRV.SD_NODISPENSE!='2' ")
		.append(" left join ci_skin_test SKINTEST on ORD.id_or = SKINTEST.id_or")
		.append(" left join bd_udidoc SKINTESTRST on SKINTEST.id_rst_skintest = SKINTESTRST.id_udidoc")
		.append(" left join bd_route ROUT on ORD.id_route=ROUT.id_route")
		.append(" left join bd_freq  FREQ on ORD.id_freq=FREQ.id_freq")
		.append(" left join bd_measdoc MEAS on ORSRV.id_medu=MEAS.id_measdoc")
		.append(this.getFromSql4Routedes())
		.append(" left join ci_or_srv_mm SRVMM on ORSRV.id_orsrv=SRVMM.id_orsrv")
		.append(" left join bd_mm MM on SRVMM.id_mm=MM.id_mm")
		.append(" left join bd_boil_des BOILDES on ORSRV.id_boildes=BOILDES.id_boildes")
		.append(" left join bd_measdoc MEAS1 on SRVMM.id_pgku_cur=MEAS1.id_measdoc")
		.append(" left join ci_or_prn ORPRN on ORPRN.id_en=ORD.id_en and ORPRN.id_or=ORD.id_or and ORPRN.id_srv=ORSRV.id_srv and ORPRN.sortno=ORSRV.sortno and ORPRN.fg_reformrow='N' and ORPRN.ds<1");
		// 预住院标识【0185267: 预住院医嘱单打印处理】
		sb.append(" left join ci_or_pip ciorpip on ORD.id_or=ciorpip.id_or");
		return sb.toString();
	}
	
	/**
	 * 根据入壶类药品成组开单模式，获取用法要求表
	 * @return
	 */
	private String getFromSql4Routedes() {
//		String paramDosage = SysParamUtils.getSysParam().getSYS_PARAM_IntravenousDrugCreateMode().getOrgParam();
//		return ICiOrdNSysParamConst.SYS_PARAM_IntravenousDrugCreateMode_Route.equals(paramDosage) 
//				? " left join bd_route ROUTDES on ORSRV.id_routedes = ROUTDES.id_route" 
//				: " left join bd_route_des ROUTDES on ORSRV.id_routedes = ROUTDES.id_routedes";
		return " left join bd_route_des ROUTDES on ORSRV.id_routedes = ROUTDES.id_routedes";
	}
	
	/**
	 * 获取where部分语句
	 * @return
	 */
	protected String getWhereSqlOrSrvMM(CiOrdSheetParamDTO paramDTO, String pageNums) {
		return "";
	}
	
	/**
	 * 查询sql语句字段
	 * @return
	 */
	protected String getStrFields(CiOrdSheetParamDTO paramDTO) {
		StringBuilder sb = new StringBuilder();
		// 机构名称
		sb.append("select ORG.name name_org,");
		// 就诊 ：住院病案号
		sb.append("ENIP.code_amr_ip,");
		// 床位
		sb.append("ENIP.name_bed,");
		// 患者
		sb.append("PAT.name name_pat_en,SEX.name sex_pat,PAT.dt_birth_hms age,en.fg_ip,enip.fg_newborn,en.dt_acpt,");
		// 就诊科室
		sb.append("DEPPHY.name name_dep_phy,");
		// 就诊（护理病区）
		sb.append("DEPNUR.name name_dep_nur,");
		// 签署医生
		sb.append("EMPSIGN.id_psndoc id_emp_sign,");
		sb.append("EMPSIGN.name name_emp_sign,");
		// 核对护士
		sb.append("EMPCHK.id_psndoc id_emp_chk,");
		sb.append("EMPCHK.name name_emp_chk,");
		// 执行人员
		if(!paramDTO.getFg_long().isValue()&&paramDTO.getExeInfoSrc().equals("2")){
			sb.append("EMPEXE.name name_emp_exe,");
		} else {
			sb.append("EMPCHK.name name_emp_exe,");
		}
		// 执行科室
		sb.append("'' name_dep_exe,");
		// 签署时间
		sb.append("ORSRVMM.dt_sign,");
		// 执行时间
		//执行时间 dt_mp   核对护士 id_emp_chk   TODO： 这里‘执行人’在‘核对护士’字段！
		//gh 2019年2月25日  如果为临时医嘱 判断系统参数- 确定执行人和执行时间的数据来源
		if(!paramDTO.getFg_long().isValue()&&paramDTO.getExeInfoSrc().equals("2")){
			sb.append("  to_char(to_date(ORNU.dt_exec,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd HH24:mi:ss') dt_mp, ");
		} else {
			sb.append("  to_char(to_date(ORSRVMM.dt_effe,'yyyy-MM-dd HH24:mi:ss')+15/24/60,'yyyy-MM-dd HH24:mi:ss') dt_mp ,  ");
		}
		//sb.append(" ORD.id_dep_chk,EMPCHK.code code_emp_chk,EMPCHK.name name_emp_chk,");
		// 停止医生
		sb.append("EMPSTOP.id_psndoc id_emp_stop,");
		sb.append("EMPSTOP.name name_emp_stop,");
		// 停止核对护士
		sb.append("EMPSTOPCHK.id_psndoc id_emp_chk_stop,");
		sb.append("EMPSTOPCHK.name name_emp_chk_stop,");
		// 作废医生
		sb.append("EMPCANC.name name_emp_canc,ORSRVMM.dt_canc,ORSRVMM.sd_rst_skintest as rst_skintest,");
		// 作废核对护士
		// sb.append("EMPCANCCHK.name name_emp_chk_canc,");
		//皮试
		sb.append("ORSRVMM.fg_skintest,");
		//皮试结果
		sb.append("(case orsrvmm.code when '0' then '-' when '1' then '+' else '' end) skintestrst,");
		//加急标识
		sb.append("ORSRVMM.fg_urgent,");
		//预住院标识【0185267: 预住院医嘱单打印处理】
		sb.append("ORSRVMM.fg_pip,");
		
		sb.append("ORSRVMM.id_en,ORSRVMM.id_orsrv_key,ORSRVMM.id_or,ORSRVMM.content_or,ORSRVMM.code_or,ORSRVMM.sd_srvtp,ORSRVMM.dt_end,");
		sb.append("(case when ORSRVMM.fg_long='N' then substr(ORSRVMM.dt_effe, 0,16) else ORSRVMM.dt_effe end) dt_effe,");
		sb.append("ORSRVMM.fg_chk,ORSRVMM.fg_chk_stop,ORSRVMM.fg_chk_canc,ORSRVMM.des_or,ORSRVMM.orders,");
		sb.append("ORSRVMM.fg_long,ORSRVMM.fg_set,ORSRVMM.fg_self,ORSRVMM.fg_selfsrv,");
		sb.append("ORSRVMM.name_srv,ORSRVMM.quan_medu,ORSRVMM.sortno,ORSRVMM.sortno_srv,");
		sb.append("ORSRVMM.name_mm,ORSRVMM.name_prn,ORSRVMM.spec,ORSRVMM.medu_name,");
		sb.append("ORSRVMM.route_name,ORSRVMM.routedes_name,ORSRVMM.freq_name,'N' fg_reformrow, ");
		sb.append("ORSRVMM.Fg_pres_outp,ORSRVMM.Fg_wholepack,ORSRVMM.quan_cur,ORSRVMM.Name_unit_sale ");
//		sb.append("ORSRVMM.id_orprn,ORSRVMM.name_orprn,ORSRVMM.page_num,ORSRVMM.row_num,ORSRVMM.fg_canc_prn,ORSRVMM.fg_stop_prn ");
		
		return sb.toString();
	}
	
	/**
	 * 获取from部分语句
	 * @return
	 */
	protected String getFromSql() {
		StringBuilder sb = new StringBuilder();
		sb.append(" left join en_ent EN on ORSRVMM.id_en=EN.id_ent")
		.append(" left join en_ent_ip ENIP on ORSRVMM.id_en=ENIP.id_ent")
		.append(" left join pi_pat PAT on ORSRVMM.id_pat=PAT.id_pat")
		.append(" left join bd_udidoc SEX on PAT.id_sex=SEX.id_udidoc")
		.append(" left join bd_org ORG on ORSRVMM.id_org=ORG.id_org")
		.append(" left join bd_dep DEPPHY on EN.id_dep_phy=DEPPHY.id_dep")
		.append(" left join bd_dep DEPNUR on EN.id_dep_nur=DEPNUR.id_dep")
		.append(" left join bd_psndoc EMPSIGN on ORSRVMM.id_emp_sign=EMPSIGN.id_psndoc")
		.append(" left join bd_psndoc EMPCHK on ORSRVMM.id_emp_chk=EMPCHK.id_psndoc")
		.append(" left join bd_psndoc EMPSTOP on ORSRVMM.id_emp_stop=EMPSTOP.id_psndoc")
		.append(" left join bd_psndoc EMPSTOPCHK on ORSRVMM.id_emp_chk_stop=EMPSTOPCHK.id_psndoc")
		.append(" left join bd_psndoc EMPCANC on ORSRVMM.id_emp_canc=EMPCANC.id_psndoc")
		.append(" left join mp_or_nur ORNU on ORSRVMM.id_or=ORNU.id_or")
		.append(" left join bd_psndoc EMPEXE on ORNU.id_emp_nur=EMPEXE.id_psndoc ");
		return sb.toString();
	}
	
	
	/**
	 * 根据类型编码和档案编码获取档案信息
	 * 
	 * @param udidocTypeCode
	 * @param udidocCode
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO getUdidocByCode(String udidocTypeCode, String udidocCode) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO result = udidocServiceExt.findByCode(udidocTypeCode, udidocCode);
		if (result == null) {
			String msg = String.format("获取自定义档案失败，档案类型编码:\"%s\",档案编码:\"%s\".", udidocTypeCode, udidocCode);
			throw new BizException(msg);

		}
		return result;
	}
	
	/**
	 * 获取排序sql
	 * @return
	 */
	protected String getOrderBySql() {
		return "";
	}
}

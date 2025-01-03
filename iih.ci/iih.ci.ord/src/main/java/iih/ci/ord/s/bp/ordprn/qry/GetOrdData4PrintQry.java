package iih.ci.ord.s.bp.ordprn.qry;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.bd.utils.ParamUtils;
import iih.bd.utils.UdidocUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 查询待打印医嘱数据
 * @author Young
 *
 */
public class GetOrdData4PrintQry implements ITransQry{
	private boolean isPrintHerb = false;
	private OrdPrintParamDTO paramDTO;

	public GetOrdData4PrintQry(OrdPrintParamDTO paramDTO) {
		this.paramDTO = paramDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(paramDTO.getId_en());
//		sqlparam.addParam(paramDTO.getFg_long());
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = this.getQuerySql(paramDTO);
		return sql;
	}

	/**
	 * 查询sql语句字段（药品）
	 * @return
	 */
	private String getStrFieldsDrug() {
		StringBuilder sb = new StringBuilder(this.getStrFields());
		// 医嘱服务项目：服务名、剂量
		sb.append("(case instr(ORSRV.sd_srvtp,'0103') when 1 then ORSRV.name||(case length(ORSRV.id_boildes) when 1 then '' else '('||BOILDES.name||')' end)||' '||decode(substr(ORSRV.quan_medu,1,1),'.','0'||ORSRV.quan_medu,ORSRV.quan_medu)||MEAS.name else ORSRV.name||' '||decode(substr(ORSRV.quan_medu,1,1),'.','0'||ORSRV.quan_medu,ORSRV.quan_medu)||MEAS.name end) as name_srv,ORSRV.quan_medu,ORSRV.sortno,");
		// 医嘱服务项目物品：物品名称
		sb.append("ORSRVMM.name_mm,");
		// 医嘱服务项目物品：商品打印名称
		//sb.append("MM.printname name_prn,");
		sb.append("decode(ORSRV.fg_self,'Y',ORSRV.name||'(自备)',bdsrv.name) name_prn,");
		// 医疗物品_基本信息：物品规格
		sb.append("MM.spec,");
		// 医疗物品 打印标识
		sb.append("MM.fg_skin,");
		// 计量单位：单位名称
		sb.append("MEAS.name medu_name,");
		//草药是否打印在临时医嘱单上
		if(herbPrintTemp()){
			// 长临标识
			sb.append("case when ORD.fg_pres_outp='Y' then 'N' when instr(ORSRV.sd_srvtp,'0103') = 1  then 'N' else ORD.fg_long end as fg_long,");
		}else{
			sb.append("case when ORD.fg_pres_outp='Y' then 'N' else ORD.fg_long end as fg_long,");
		}
		// 皮试标志
		//sb.append("CASE WHEN ORD.id_srv = ORSRV.id_srv  then ORD.fg_skintest END fg_skintest,");
		sb.append(" ORD.fg_skintest ,");
		//自备药标识
		sb.append("ORSRV.fg_self, ");
		//皮试结果 //0122667: 皮试医嘱执行后医嘱单没有显示皮试结果  添加皮试结果表的连接
		sb.append("SKINRST.sd_rst_skintest as rst_skintest,");
		sb.append("decode(nvl(SKINRST.sd_rst_skintest,'~'),'~','N','Y') as fg_skintest_rst, ");
		sb.append("ORD.sortno ord_sortno, ");
		//总量
		sb.append("ORSRVMM.quan_cur, ");
		//总量单位
		sb.append("salemeas.name as Name_unit_sale ");
		return sb.toString();
	}
	
	/**
	 * 查询sql语句字段（非药品）
	 * @return
	 */
	private String getStrFieldsNotDrug() {
		StringBuilder sb = new StringBuilder(this.getStrFields());
		// 医嘱服务项目：服务名、剂量
		sb.append("case ORD.sd_srvtp when '1201' then Ord.name_or || ' 至 ' || transDep.name else ORD.name_or end  name_srv,ORD.quan_medu,nvl (ORD.sortno, 0 ) as sortno,");
		// 医嘱服务项目物品：物品名称
		sb.append("'' name_mm,");
		// 医嘱服务项目物品：商品打印名称
		sb.append("'' name_prn,");
		// 医疗物品_基本信息：物品规格
		sb.append("'' spec,");
		// 医疗物品 的皮试标识
		sb.append("'' fg_skin,");
		// 计量单位：单位名称
		sb.append("MEAS.name medu_name,");
		// 长临标识
		sb.append("ORD.fg_long,");
		//自备药标识
		sb.append("'' fg_self, ");
		//皮试标识
		sb.append("'' fg_skintest, ");
		//皮试结果 //0122667: 皮试医嘱执行后医嘱单没有显示皮试结果  添加皮试结果表的连接   2018年6月23日 修改为获取皮试结果code
		sb.append("SKINRST.sd_rst_skintest as rst_skintest,");
		sb.append("decode(nvl(SKINRST.sd_rst_skintest,'~'),'~','N','Y') as fg_skintest_rst,");
		sb.append("ORD.sortno ord_sortno,");
		//总量
		sb.append("0 as quan_cur, ");
		//总量单位
		sb.append("'' as Name_unit_sale ");
		return sb.toString();
	}
	
	/**
	 * 查询sql语句字段
	 * @return
	 */
	private String getStrFields(){
		StringBuilder sb = new StringBuilder();
		// 医嘱表内容，ci_order
		sb.append("ORD.id_grp,ORD.id_org,ORG.name name_org,");
		sb.append("ORD.id_or,ORD.id_srvtp,ORD.sd_srvtp,ORD.dt_effe,(case when ORD.dt_end>'2098-01-01 00:00:00' then null else ORD.dt_end end) dt_end,");
		sb.append("ORD.fg_chk,ORD.fg_chk_stop,ORD.fg_chk_canc,");	
		//
		sb.append("ORD.fg_urgent,");
		sb.append("ORD.des_or,ORD.orders,ORD.fg_set,ORD.content_or,");
		// 就诊 ：住院病案号
		sb.append("ORD.id_en,ORD.id_entp,ORD.code_entp,ENIP.code_amr_ip,");
		// 用法：用法名称
		sb.append("ROUT.name route_name,");
		// 用法要求
		sb.append("ROUTDES.name routedes_name,");
		// 频次： 频次名称
		sb.append("FREQ.name freq_name,");
		// 患者
		sb.append("ORD.id_pat,PAT.code code_pat_en,EN.name_pat name_pat_en,SEX.name sex_pat,PAT.dt_birth_hms age,");
		// 就诊科室
		sb.append("ORD.id_dep_or id_dep_phy,DEPPHY.code code_dep_phy,DEPPHY.name name_dep_phy,");
		// 就诊（护理病区）
		sb.append("EN.id_dep_nur,DEPNUR.code code_dep_nur,DEPNUR.name name_dep_nur,");
		// 床位
		sb.append("ENIP.id_bed,ENIP.name_bed,");
		// 入院时间
		sb.append("EN.dt_acpt,");
		// 核对时间
		sb.append("ORD.dt_chk,");
		// 签署时间
		sb.append("ORD.dt_sign,");
		// 签署医生
		sb.append("ORD.id_emp_sign,ORD.id_dep_sign,EMPSIGN.code code_emp_sign,EMPSIGN.name name_emp_sign,");
		
		//执行时间 dt_mp   核对护士 id_emp_chk   TODO： 这里‘执行人’在‘核对护士’字段！
		//gh 2019年2月25日  如果为临时医嘱 判断系统参数- 确定执行人和执行时间的数据来源
		if(!this.paramDTO.getFg_long().isValue()&&this.paramDTO.getCheckSourceType().equals("2")){
			sb.append("  to_char(to_date(mpnur.dt_exec,'yyyy-MM-dd HH24:mi:ss'),'yyyy-MM-dd HH24:mi:ss') dt_mp,mpnur.id_emp_nur id_emp_chk, ");
		}else{
			sb.append("  to_char(to_date(ORD.dt_effe,'yyyy-MM-dd HH24:mi:ss')+15/24/60,'yyyy-MM-dd HH24:mi:ss') dt_mp,ORD.id_emp_chk ,  ");
		}
		sb.append(" ORD.id_dep_chk,EMPCHK.code code_emp_chk,EMPCHK.name name_emp_chk,");
		
		// 医嘱确认护士
		sb.append("ORD.id_emp_chk id_emp_exe,ORDCHK.name name_emp_exe,");
		// 执行科室
		sb.append("'' id_dep_exe,'' name_dep_exe,");
		// 停止医生
		sb.append("ORD.id_emp_stop,ORD.id_dep_stop,EMPSTOP.code code_emp_stop,EMPSTOP.name name_emp_stop,");
		// 停止核对护士
		sb.append("ORD.id_emp_chk_stop,ORD.id_dep_chk_stop,EMPSTOPCHK.code code_emp_chk_stop,EMPSTOPCHK.name name_emp_chk_stop,");
		//停止核对时间
		sb.append("ORD.dt_chk_stop,");
		// 在院标识
		sb.append("EN.fg_ip,");
		// 新生儿标识
		sb.append("ENIP.fg_newborn,");
		// 作废医生
		sb.append("ORD.id_emp_canc,empcanc.name as name_emp_canc,");
		//出院带药标识
		sb.append("ORD.Fg_pres_outp,");
		//在院整领标识
		sb.append("ORD.Fg_wholepack,");
		//自定义服务标识
		sb.append("bdsrv.Fg_ctm,");
		//0185267: 预住院医嘱单打印处理
		sb.append("nvl(ciorpip.fg_pip,'N') fg_pip,");
		return sb.toString();
	}

	/**
	 * 获取from部分语句
	 * @return
	 */
	private String getBaseFromSql(Boolean isDrug) {
		 //0122667: 皮试医嘱执行后医嘱单没有显示皮试结果  添加皮试结果表的连接 ci_skin_test SKINRST
		String str = " from ci_order ORD,en_ent_ip ENIP,bd_route ROUT,bd_route_des ROUTDES,bd_freq FREQ,pi_pat PAT,bd_udidoc SEX,en_ent EN,bd_org ORG,bd_dep DEPPHY,bd_dep DEPNUR,bd_psndoc EMPSIGN,bd_psndoc EMPCHK,bd_psndoc EMPSTOP,bd_psndoc ORDCHK,bd_psndoc EMPSTOPCHK，ci_skin_test SKINRST,ci_ap_trans trans,bd_dep transDep,bd_psndoc empcanc,bd_measdoc MEAS,bd_srv bdsrv,ci_or_pip ciorpip ";
		if (isDrug) {
			str += ",ci_or_srv ORSRV,ci_or_srv_mm ORSRVMM,bd_mm MM,bd_boil_des BOILDES,bd_measdoc salemeas ";
		}
		//gh 2019年2月25日  如果为临时医嘱 判断系统参数- 确定执行人和执行时间的数据来源
		if(!this.paramDTO.getFg_long().isValue()&&this.paramDTO.getCheckSourceType().equals("2")){
			str += " ,mp_or_nur mpnur ";
		}
		return str;
	}

	/**
	 * 获取where部分语句
	 * @return
	 */
	private String getBaseWhereSql(Boolean isDrug) {
		
		//长期医嘱条件    
		//0121993: 医嘱单医生站签署完成可以打印   将fg_chk(是否核对字段)改为 fg_sign(是否签署) gh
		String whereSql1 = " where ORD.Sd_orsrcfun !='2' and ORD.sd_srvtp like '01%' and  ORD.Eu_Orsrcmdtp != '0C'  and ORSRV.fg_or='Y' and ORD.fg_sign='Y'  ";
				if(OrderChkParam()) {
					whereSql1 +=" and ORD.fg_chk='Y' ";	
				}
		whereSql1+= " and ORD.id_or=ORSRV.id_or and ORSRV.id_orsrv=ORSRVMM.id_orsrv(+) and ORSRVMM.id_mm=MM.id_mm(+) and ORSRV.id_medu=MEAS.id_measdoc(+) and ORSRV.id_boildes=BOILDES.id_boildes(+) "
				+ " and ORSRV.id_srv=bdsrv.id_srv(+) "
				+ " and ORSRVMM.id_pgku_cur = salemeas.id_measdoc(+) ";
		//临时医嘱条件
		//0121993: 医嘱单医生站签署完成可以打印   将fg_chk(是否核对字段)改为 fg_sign(是否签署) gh  //2019-10-28  0173146 ： 改为可配置 
		String whereSql2 = " where ORD.Sd_orsrcfun !='2' and ORD.sd_srvtp not like '01%' and ORD.Eu_Orsrcmdtp != '0C' and ORD.fg_sign='Y' ";
				if(OrderChkParam()) {
					whereSql1 +=" and ORD.fg_chk='Y' ";	
				}
				whereSql2 += " and ORD.id_srv=bdsrv.id_srv(+) "
				+" and ORD.id_unit_med=MEAS.id_measdoc(+) ";
		//	0122508: 作废医嘱屏蔽打印后医嘱单继续显示作废医嘱    过滤取消打印的医嘱 添加过滤字段ORD.FG_PRN  
        //0122667: 皮试医嘱执行后医嘱单没有显示皮试结果  添加皮试结果表的连接 and ORD.id_or=SKINRST.id_or(+) 
		String whereSql = "and ORD.id_or=SKINRST.id_or(+) and ORD.id_or =trans.id_or(+) and trans.id_dep_to = transDep.id_dep(+) and ORD.FG_PRN='Y' and ORD.id_en=ENIP.id_ent and ORD.id_route=ROUT.id_route(+)";
				if(OrderChkParam()) {
					whereSql +=" and ORD.fg_chk='Y' ";	
				}
		whereSql += "and ORD.id_routedes=ROUTDES.id_routedes(+) and ORD.id_freq=FREQ.id_freq(+) and ORD.id_org=ORG.id_org(+) "
				+ " and ORD.id_pat=PAT.id_pat and PAT.id_sex=SEX.id_udidoc(+) and en.id_dep_phy=DEPPHY.id_dep(+) and ORD.id_en=EN.id_ent and EN.id_dep_nur=DEPNUR.id_dep(+) "
				+ " and ORD.id_emp_sign=EMPSIGN.id_psndoc(+)  and ORD.id_emp_stop=EMPSTOP.id_psndoc(+)   and ORD.id_emp_chk=ORDCHK.id_psndoc(+)   and ORD.id_emp_chk_stop=EMPSTOPCHK.id_psndoc(+)"
				+ " and ORD.id_emp_canc=empcanc.id_psndoc(+) and ORD.id_or=ciorpip.id_or(+)";//0185267: 预住院医嘱单打印处理
		
		//gh 2019年2月25日  如果为临时医嘱 判断系统参数- 确定执行人和执行时间的数据来源
		if(!this.paramDTO.getFg_long().isValue()&&this.paramDTO.getCheckSourceType().equals("2")){
			whereSql += " and ORD.id_or = mpnur.id_or(+) and mpnur.id_emp_nur = EMPCHK.id_psndoc(+) ";
		}else{
			whereSql += " and ORD.id_emp_chk = EMPCHK.id_psndoc(+) ";
		}
		
		// 参数配置出院带药是否打印
		try {
			if (FBoolean.FALSE.equals(
					ParamUtils.GetOrgParamFBooleanValue(ICiOrdCustomSysParamConst.LL_PARAM_PRINT_OUT_HOSPITAL))) {
				whereSql += " and ORD.fg_pres_outp='N' ";
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
		// 0133584: 护嘱 -不在医嘱单上显示
		whereSql += " and ORD.Sd_orsrcfun != '2' " + " and "
				+ BdEnvContextUtil.processEnvContext(new CiOrderDO(), "ORD");

		return isDrug ? whereSql1 + whereSql : whereSql2 + whereSql;
	}

	/**
	 * 获取查询的sql语句
	 * @return
	 */
	private String getQuerySql(OrdPrintParamDTO paramDTO) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("select t.* from (");
		buffer.append(" select ");
		buffer.append(this.getStrFieldsDrug());
		buffer.append(this.getBaseFromSql(Boolean.TRUE));
		buffer.append(this.getBaseWhereSql(Boolean.TRUE));
		buffer.append(" union all select ");
		buffer.append(this.getStrFieldsNotDrug());
		buffer.append(this.getBaseFromSql(Boolean.FALSE));
		buffer.append(this.getBaseWhereSql(Boolean.FALSE));
		buffer.append(") t where ");
		buffer.append(this.getDynamicWhereSql(paramDTO));
		buffer.append(" order by ").append(this.getOrderBySql());

		return buffer.toString();
	}

	/**
	 * 获取动态条件语句
	 * @return
	 */
	private String getDynamicWhereSql(OrdPrintParamDTO paramDTO) {
		try {
			//查看草药医嘱单是否启用了，启用，草药都打在草药医嘱单上面
			UdidocDO udidoc = UdidocUtils.getUdidocByCode(ICiDictCodeTypeConst.SD_POSTMPLMODE,"3");
			StringBuffer buffer = new StringBuffer();
			buffer.append(" t.id_en= ?");
			if( this.paramDTO.getFg_herb().equals(FBoolean.TRUE)){
				buffer.append(" and t.sd_srvtp like '0103%' ");
			}else if(FBoolean.TRUE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
				//草药医嘱单启用
				if(new Integer(2).equals(udidoc.getActivestate())){
					buffer.append(" and t.fg_long='Y' and t.sd_srvtp not like '0103%' ");
				}else{
					buffer.append("  and t.fg_long='Y' ");
				}
			}else if(FBoolean.FALSE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
				//草药医嘱单启用
				if(new Integer(2).equals(udidoc.getActivestate())){
					buffer.append(" and t.fg_long='N' and t.sd_srvtp not like '0103%' ");
				}else{
					buffer.append("  and t.fg_long='N' ");
				}
			}
			//草药医嘱是否打印
			if(!this.herbIsPrint()){
				buffer.append("  and t.sd_srvtp not like '0103%'");
			}
			buffer.append(" and ").append(this.getSqlByPrintMode(paramDTO));
			return buffer.toString();
		} catch (BizException e1) {
			//出现异常，走默认打印
			StringBuffer buffer = new StringBuffer();
			if(FBoolean.TRUE.equals(this.paramDTO.getFg_herb())){
				buffer.append(" and t.sd_srvtp like '0103%' ");
			}else if(FBoolean.TRUE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
				buffer.append(" and t.fg_long='Y' and t.sd_srvtp not like '0103%' ");
			}else if(FBoolean.FALSE.equals(this.paramDTO.getFg_long()) && FBoolean.FALSE.equals(this.paramDTO.getFg_herb())){
				// 参数配置草药是否打印在临时医嘱单
				buffer.append(" and  t.fg_long='N' and t.sd_srvtp not like '0103%' ");
			}
			buffer.append(" and ").append(this.getSqlByPrintMode(paramDTO));
			return buffer.toString();
		}
		
//		if(FBoolean.TRUE == this.paramDTO.getFg_long() && FBoolean.TRUE == this.paramDTO.getFg_herb()){
//			buffer.append(" and t.fg_long='Y' ");
//		}else if(FBoolean.TRUE == this.paramDTO.getFg_long() && FBoolean.FALSE == this.paramDTO.getFg_herb()){
//			buffer.append(" and t.fg_long='Y' and t.sd_srvtp not like '0103%' ");
//		}else if(FBoolean.FALSE == this.paramDTO.getFg_long() && FBoolean.TRUE == this.paramDTO.getFg_herb()){
//			buffer.append(" and t.sd_srvtp like '0103%' ");
//		}else if(FBoolean.FALSE == this.paramDTO.getFg_long() && FBoolean.FALSE == this.paramDTO.getFg_herb()){
//			//0122280: 临时医嘱单出现了草药处方  临时医嘱单过滤掉草药数据
//			buffer.append(" and t.fg_long='N' and t.sd_srvtp not like '0103%' ");
//		}
		
		
	}

	/**
	 * 根据打印模式获取拼接续打Sql
	 * @return
	 */
	private String getSqlByPrintMode(OrdPrintParamDTO paramDTO) {
		String sql = null;
		switch (paramDTO.getPrint_mode()) {
		case "1": // 一般续打：相同就诊，排除已经打印过的医嘱，如果是重整，需要注意重整前没有打印停止时间的也需要查询出来
			sql = " not exists (select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or=t.id_or and prn.ds<1)";
			//sql = " not exists ( select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or = t.id_or and (prn.fg_reformed = 'N' or prn.fg_stop_prn='Y' or prn.fg_canc_prn='Y'))";
			break;
		case "2": // 重整打印：需要排除已经打印完停止时间的(排除执行过停止打印的记录)，并且不包含作废医嘱（是否包含作废医嘱可以通过配置实现）
			sql = " not exists (select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or=t.id_or and prn.ds<1"
					+ " and (prn.fg_stop_prn='Y' or prn.fg_canc_prn='Y')) and t.fg_chk_canc!='Y' ";

			break;
		case "3": // 撤销打印（作废打印）：打印已作废的医嘱，排除已经执行过作废打印的医嘱(打印表中作废打印标记为false，医嘱中作废标记为true)
			sql = " exists (select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or=t.id_or "
					+ " and prn.fg_canc_prn = 'N' and t.fg_chk_canc = 'Y' and prn.fg_reformed = 'N' and prn.ds<1)";
			break;
		case "4": // 停止打印：打印已经停止的医嘱（需要排除已经打印过的停止医嘱）
			sql = " exists (select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or=t.id_or "
					+ " and prn.fg_stop_prn = 'N' and t.fg_chk_stop = 'Y' and prn.fg_reformed = 'N' and prn.ds<1)";
			break;
		case "5":// 查询指定页码需要补打作废线or停止时间的数据
			sql = " exists (select id_orprn from ci_or_prn prn where prn.id_en = t.id_en and prn.id_or=t.id_or "
					+ " and ((prn.fg_stop_prn = 'N' and t.fg_chk_stop = 'Y') or (prn.fg_canc_prn = 'N' and t.fg_chk_canc = 'Y') "
					+ " or (prn.fg_skin_prn = 'N' and t.fg_skintest_rst = 'Y' )) "
					+ " and prn.fg_reformed = 'N' and prn.page_num = '" + paramDTO.getPage_num().toString() + "' and prn.ds<1)";
		case "6":// 皮试结果打印：打印有皮试结果的医嘱（需要排除已经打印过皮试的医嘱）
			sql = " exists (select id_orprn from ci_or_prn prn where prn.id_en = t.id_en and prn.id_or=t.id_or "
					+ " and prn.fg_skin_prn = 'N' and t.fg_skintest_rst = 'Y' and prn.fg_reformed = 'N' and prn.ds<1) ";
			break;
		}

		return sql;
	}

	/**
	 * 获取排序sql
	 * @return
	 */
	private String getOrderBySql() {

		return " dt_effe asc, ord_sortno asc,sortno asc";
	}
	/**
	 * 草药是否打印在临时医嘱单上
	 * @return
	 */
	private boolean herbPrintTemp(){
		try {
			return ParamUtils.GetOrgParamFBooleanValue(ICiOrdCustomSysParamConst.LL_TEMP_PRINT_HERB).booleanValue();
		} catch (BizException e) {
			return true;
		}
	}
	/**
	 * 医嘱单打印是否为护士确认后的医嘱
	 */
	private boolean OrderChkParam() {
		try {
			return ParamUtils.GetOrgParamFBooleanValue(ICiOrdCustomSysParamConst.UL_PARAM_UL_CIOR0001).booleanValue();
		} catch (BizException e) {
			return false;
		}
	}
	/**
	 * 是否打印草药
	 * @return
	 */
	private boolean herbIsPrint(){
		if(isPrintHerb){
			return isPrintHerb;
		}
		try {
			isPrintHerb =  ParamUtils.GetOrgParamFBooleanValue(ICiOrdCustomSysParamConst.LL_HERB_IS_PRINT).booleanValue();
		} catch (BizException e) {
			return true;
		}
		return isPrintHerb;
	}
}

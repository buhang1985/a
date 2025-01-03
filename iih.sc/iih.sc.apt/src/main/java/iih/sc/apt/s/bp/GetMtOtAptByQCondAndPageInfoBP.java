package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OpAptDetailDTO;
import iih.sc.apt.dto.d.OpAptQryDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScSqlUtils;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtOtAptByQCondAndPageInfoBP {

	/**
	 * 手术、医技预约查询
	 *
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<OpAptDetailDTO> exec(OpAptQryDTO opAptQryDTO, PaginationInfo pg) throws BizException {

		PagingServiceImpl<OpAptDetailDTO> pageQryService = new PagingServiceImpl<OpAptDetailDTO>();


		SqlParam param = new SqlParam();
		String sql = null;
		//获取预约类型
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getSd_aptmd()) && opAptQryDTO.getSd_aptmd().equals("1")){
			sql = this.getQrySQL4NoAppl(opAptQryDTO, param);
		}else{
			sql = this.getQrySQLStr(opAptQryDTO, param);
		}
		PagingRtnData<OpAptDetailDTO> datas = pageQryService.findByPageInfo(new OpAptDetailDTO(), pg, sql,
				"", param);
		this.processDatas(datas);
		return datas;
	}

	/**
	 * 处理数据
	 *
	 * @author zhengcm
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void processDatas(PagingRtnData<OpAptDetailDTO> datas) throws BizException {
		if (datas == null || datas.getPageData() == null) {
			return;
		}
		FArrayList list = datas.getPageData();
		for (Object obj : list) {
			OpAptDetailDTO dto = (OpAptDetailDTO) obj;
			if (dto.getDt_birth() != null) {
				dto.setAge_pat(AgeCalcUtil.getAge(dto.getDt_birth()));
			}
			if (dto.getDt_b() != null) {
				dto.setD_b(dto.getDt_b());
			}
			if (dto.getDt_appt() != null) {
				dto.setD_b_appt(dto.getDt_appt());
			}
			// 登记人为token时显示对应的渠道名称 changed by zhengcm 2018-03-13
			if (!StringUtil.isEmptyWithTrim(dto.getName_emp_appt())
					&& dto.getName_emp_appt().toUpperCase().startsWith("TOKEN")) {
				dto.setName_emp_appt(dto.getName_scchl());
			}
			//合单医嘱内容修改
			if (!StringUtil.isEmpty(dto.getContent_or())) {
				this.setContentOrAndSrvName(dto);
			}
		}
	}

	/**
	 * 合单医嘱内容和诊疗项目修改
	 *
	 * @param DTO
	 * @return
	 * @author yu.b
	 */

	private void setContentOrAndSrvName(OpAptDetailDTO dto){

		StringBuilder sb_or = new StringBuilder("||");
		StringBuilder sb_srv = new StringBuilder();
		LinkedList<String> strs = new LinkedList<String>(Arrays.asList(dto.getContent_or().split("\\|\\|")));
		if(strs.size() <= 2){
			return;
		}
		strs.remove(0);
		for(String str1 : strs) {
			if(StringUtil.isEmpty(str1)) continue;
			String[] strArr = str1.split("&");
			if(ArrayUtil.isEmpty(strArr)) continue;
			sb_or.append(strArr[0]);
			sb_srv.append(strArr[0]);
			if(strArr.length >= 3){
				sb_or.append(" ");
				sb_or.append(StringUtil.isEmpty(strArr[3]) ? "" : strArr[3].split("\\|")[0]);
			}
			sb_srv.append(";");
			sb_or.append(";");

		}
		sb_or.append("&&&|&&");
		dto.setName_srv(StringUtil.isEmpty(sb_srv.toString()) ? dto.getName_srv() : sb_srv.toString());
		dto.setContent_or(sb_or.toString());

	}
	/**
	 * 外系统申请查询
	 * @param opAptQryDTO
	 * @param param
	 * @return
	 */
	private String getQrySQL4NoAppl(OpAptQryDTO opAptQryDTO, SqlParam param){
		StringBuffer sb = new StringBuffer();
		sb.append("select rownum as sortno,a.* from ( ");
		sb.append("SELECT ");
		sb.append("dep3.name as name_dept_appt,");//申请科室
		sb.append("appl.dt_effe_or,");
		sb.append("PL.EU_EDIT_TP,");
		sb.append("pl.id_dep as id_dept,");// add by zhengcm 2018-01-29
		sb.append("APT.ID_APT,");
		sb.append("apt.code as code_apt,");
		sb.append("pat.code as code_pat,");
		sb.append("PAT.NAME AS name_pat,");
		sb.append("PAT.MOB,");
		sb.append("PAT.DT_BIRTH,");
		sb.append("PAT.ID_PAT,");
		sb.append("APT.Id_tick,");
		sb.append("APT.DT_B,");
		sb.append("APT.DT_E,");
		sb.append("pat.id_sex,");
		sb.append("pat.sd_sex,");
		sb.append("docpat.name as name_sex,");//性别
		sb.append("LOT.name as name_dateslot,");
		sb.append("RES.NAME AS name_scres,");
		sb.append("APT.QUENO,");
		sb.append("APPTDOC.NAME AS NAME_EMP_APPT,");
		sb.append("APT.DT_APPT,");
		sb.append("APT.SD_STATUS,");
		sb.append("chl.name as name_scchl,");
		sb.append("DEP.NAME AS NAME_DEPT,");//执行科室
		sb.append("appl.id_aptappl as id_apt_appl,");
		sb.append("entp.name as name_enttp, ");
		sb.append("exchl.code_apt as code_apt_exchl,");
		sb.append("docapt.name as name_status,");
		sb.append("(case apt.sd_status when '4' then case apt.dt_canc when null then cancdoc.name else case apt.id_emp_canc when null then '管理员' when '~' then '管理员' else cancdoc.name end end end)NAME_EMP_CANC,");
		sb.append(" appl.id_ent,");
		sb.append(" appl.id_or,");
		sb.append("APT.DT_CANC,");
		sb.append("APT.NOTE_CANC, ");
		sb.append("aptmt.note, ");
		sb.append("appl.id_srv, ");
		sb.append("bdsrv.name as name_srv,");
		sb.append("appl.fg_bl, ");
		sb.append("appl.id_emp_appl, ");
		sb.append("appl.applyno, ");//2019.03.21 增加申请单号
		sb.append("appl.des as des_appl, ");//2019.04.01 增加申请描述
		sb.append("exchl.name_org_appl, ");//2019.04.02外院机构
		sb.append("exchl.name_dep_appl, ");//2019.04.02外院科室
		sb.append("exchl.name_phy_appl, ");//2019.04.02外院医生
		sb.append("psn.name as name_emp_appl, ");
		sb.append("aptmt.fg_manu_tak, ");
		sb.append("aptmt.id_emp_cfm, ");
		sb.append("psn1.name as name_emp_cfm, ");
		sb.append("aptmt.dt_apt_cfm, ");
		sb.append("aptmt.id_aptmt as id_apt_mt, ");
		sb.append("aptmt.url_photo ");
		sb.append("FROM sc_apt_appl appl  ");
		sb.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = APPL.ID_PI ");
		sb.append("left join bd_dep dep3 on dep3.id_dep = appl.id_dep_appl ");//申请科室
		sb.append("left join bd_srv bdsrv on appl.id_srv = bdsrv.id_srv ");
		sb.append("left join bd_psndoc psn on appl.id_emp_appl = psn.id_psndoc  ");
		sb.append("left join bd_entp entp on appl.id_entp = entp.id_entp ");
		sb.append("left join sc_apt apt on appl.id_scapt = apt.id_apt ");
		sb.append("LEFT JOIN SC_SCH SCH ON SCH.ID_SCH = APT.ID_SCH ");
		sb.append("LEFT JOIN SC_PL PL ON PL.ID_SCPL = SCH.ID_SCPL ");
		sb.append("LEFT JOIN BD_DAYSLOT LOT ON LOT.ID_dayslot = APT.ID_dateslot ");
		sb.append("LEFT JOIN SC_RES RES ON RES.id_scres = PL.id_scres ");
		sb.append("LEFT JOIN BD_PSNDOC APPTDOC ON APPTDOC.ID_PSNDOC = APT.ID_EMP_APPT ");
		sb.append("LEFT JOIN BD_PSNDOC CANCDOC ON CANCDOC.ID_PSNDOC = APT.ID_EMP_CANC ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join sc_apt_exchl exchl on exchl.id_apt = apt.id_apt ");
		sb.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = appl.id_dep_mp ");//执行科室
		sb.append("LEFT JOIN sc_apt_mt aptmt ON aptmt.id_apt = APT.ID_APT ");
		sb.append("left join bd_psndoc psn1 on aptmt.id_emp_cfm = psn1.id_psndoc  ");
		sb.append("left join bd_udidoc docpat on appl.id_sex = docpat.id_udidoc ");//性别
		sb.append("left join bd_udidoc docapt on apt.id_status = docapt.id_udidoc ");
		sb.append("left join sc_apt_appl_exchl exchl  on appl.id_aptappl = exchl.id_aptappl ");
		sb.append("WHERE appl.SD_SCTP = '03' and appl.sd_aptmd = '1' ");
		sb.append(" and appl.sd_sys_from in ('2','3') ");
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getName_pat())) {
			sb.append(" AND appl.piname = ? ");
			param.addParam(opAptQryDTO.getName_pat());
		}
		//申请单号
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getApplyno()))
		{
			sb.append(" and appl.applyno = ? ");
			param.addParam(opAptQryDTO.getApplyno());
		}
		// 检查日期
		if (opAptQryDTO.getD_b() != null) {
			sb.append("and apt.dt_b >= ? ");
			String dbStr = opAptQryDTO.getD_b().toStdString() + " 00:00:00";
			param.addParam(dbStr);
		}
		if (opAptQryDTO.getD_e() != null) {
			sb.append("and apt.dt_b <= ? ");
			String deStr = opAptQryDTO.getD_e().toStdString() + " 23:59:59";
			param.addParam(deStr);
		}
		//诊疗项目
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_srv()))
		{
			String[] srvIds = opAptQryDTO.getId_srv().split(",");
			if(srvIds.length > 1){
				String cond = ScSqlUtils.buildIdStr(srvIds);
				sb.append(" and appl.id_srv in ("+cond+")");
			}else{
			sb.append(" and appl.id_srv = ? ");
			param.addParam(opAptQryDTO.getId_srv());
		}
		}
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scres())) {
			String[] resIds = opAptQryDTO.getId_scres().split(",");
			if(resIds.length > 1){
				String cond = ScSqlUtils.buildIdStr(resIds);
				sb.append("AND APT.id_scres in ("+cond+") ");
			}else{
			sb.append("AND APT.id_scres = ? ");
			param.addParam(opAptQryDTO.getId_scres());
		}
		}
		// 预约备注
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getNote())){
			sb.append(" and aptmt.note like ? ");
			param.addParam("%"+opAptQryDTO.getNote()+"%");
		}
		// 预约状态
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getSd_aptstatus())) {
			sb.append("and apt.sd_status = ? ");
			param.addParam(opAptQryDTO.getSd_aptstatus());
		}
		// 排班服务
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scsrv())) {
			sb.append("AND APPL.id_scsrv = ? ");
			param.addParam(opAptQryDTO.getId_scsrv());
		}
		// 预约渠道
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scchl())) {
			sb.append("and apt.id_scchl = ? ");
			param.addParam(opAptQryDTO.getId_scchl());
		}
		// 操作开始日期
		if (opAptQryDTO.getD_b_appt() != null) {
			sb.append("and apt.dt_appt >= ? ");
			//String dbStr = opAptQryDTO.getD_b_appt().toStdString() + " 00:00:00";
			String dbStr = opAptQryDTO.getD_b_appt().toStdString();
			param.addParam(dbStr);
		}
		// 操作结束日期
		if (opAptQryDTO.getD_e_appt() != null) {
			sb.append("and apt.dt_appt <= ? ");
			//String deStr = opAptQryDTO.getD_e_appt().toStdString() + " 23:59:59";
			String deStr = opAptQryDTO.getD_e_appt().toStdString();
			param.addParam(deStr);
		}
		// 排班服务
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scsrv())) {
			sb.append("AND APPL.id_scsrv = ? ");
			param.addParam(opAptQryDTO.getId_scsrv());
		}
		// 预约渠道
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scchl())) {
			sb.append("and apt.id_scchl = ? ");
			param.addParam(opAptQryDTO.getId_scchl());
		}
		// 操作开始日期
		if (opAptQryDTO.getD_b_appt() != null) {
			sb.append("and apt.dt_appt >= ? ");
			String dbStr = opAptQryDTO.getD_b_appt().toStdString() + " 00:00:00";
			param.addParam(dbStr);
		}
		// 操作结束日期
		if (opAptQryDTO.getD_e_appt() != null) {
			sb.append("and apt.dt_appt <= ? ");
			String deStr = opAptQryDTO.getD_e_appt().toStdString() + " 23:59:59";
			param.addParam(deStr);
		}
		// 预约号
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getCode_apt())) {
			sb.append("and (apt.code = ? or exchl.code_apt = ? ) ");
			param.addParam(opAptQryDTO.getCode_apt());
			param.addParam(opAptQryDTO.getCode_apt());
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getCode_pat())) {
			sb.append("and pat.code = ? ");
			param.addParam(opAptQryDTO.getCode_pat());
		}
		// 开单科室
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_dep_appt())) {
			sb.append(" and appl.id_dep_appl = ? ");
			param.addParam(opAptQryDTO.getId_dep_appt());
		}
		// 预约操作人
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_emp_appt())) {
			sb.append("and apt.id_emp_appt = ? ");
			param.addParam(opAptQryDTO.getId_emp_appt());
		}
		// 排班服务
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scsrv()))
		{
			sb.append(" and apt.id_scsrv = ? ");
			param.addParam(opAptQryDTO.getId_scsrv());
		}
		// 执行科室
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_dep())) {
			sb.append("and pl.id_dep = ? ");
			param.addParam(opAptQryDTO.getId_dep());
		}
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "APPL"));
		sb.append(" order by appl.d_b,sch.d_sch,sch.id_sch) a  ");
		return sb.toString();
	}
	/**
	 * 医技预约查询
	 * @param opAptQryDTO
	 * @param param
	 * @return
	 */
	private String getQrySQLStr(OpAptQryDTO opAptQryDTO, SqlParam param) {
		StringBuffer sb = new StringBuffer();
		sb.append("select rownum as sortno,a.* from ( ");
		sb.append("SELECT ");
		sb.append("dep3.name as name_dept_appt,");//申请科室
		sb.append("appl.code_entp,");
		sb.append("appl.dt_effe_or,");
		sb.append("PL.EU_EDIT_TP,");
		sb.append("pl.id_dep as id_dept,");// add by zhengcm 2018-01-29
		sb.append("APT.ID_APT,");
		sb.append("apt.code as code_apt,");
		sb.append("APT.ID_PAT,");
		sb.append("APT.Id_tick,");
		sb.append("pat.code as code_pat,");
		sb.append("PAT.NAME AS name_pat,");
		sb.append("PAT.MOB,");
		sb.append("PAT.DT_BIRTH,");
		sb.append("APT.DT_B,");
		sb.append("APT.DT_E,");
		sb.append("pat.id_sex,");
		sb.append("pat.sd_sex,");
		sb.append("docpat.name as name_sex,");//性别
		sb.append("LOT.name as name_dateslot,");
		sb.append("RES.NAME AS name_scres,");
		sb.append("SRV.NAME AS NAME_SCSRV,");
		sb.append("APT.QUENO,");
		sb.append("APPTDOC.NAME AS NAME_EMP_APPT,");
		sb.append("APT.DT_APPT,");
		sb.append("APT.SD_STATUS,");
		sb.append("chl.name as name_scchl,");
		sb.append("DEP.NAME AS NAME_DEPT,");//执行科室
		sb.append("war.name as name_dep_nuradm,");
		sb.append("ip.name_bed,");
		sb.append("appl.id_aptappl as id_apt_appl,");
		sb.append("entp.name as name_enttp, ");
		sb.append("exchl.code_apt as code_apt_exchl,");
		sb.append("docapt.name as name_status,");
		sb.append("(case apt.sd_status when '4' then case apt.dt_canc when null then cancdoc.name else case apt.id_emp_canc when null then '管理员' when '~' then '管理员' else cancdoc.name end end end)NAME_EMP_CANC,");
		sb.append(" appl.id_ent,");
		sb.append(" appl.id_or,");
		sb.append("APT.DT_CANC,");
		sb.append("APT.NOTE_CANC, ");
		sb.append("aptmt.note, ");
		sb.append("appl.content_or, ");
		sb.append("appl.id_srv, ");
		sb.append("bdsrv.name as name_srv,");
		sb.append("appl.fg_bl, ");
		sb.append("appl.id_emp_appl, ");
		sb.append("appl.applyno, ");//2019.03.21 增加申请单号
		sb.append("appl.dt_appl, ");//2019.07.16 增加 医嘱申请时间
		sb.append("psn.name as name_emp_appl, ");
		sb.append("aptmt.fg_manu_tak, ");
		sb.append("aptmt.id_emp_cfm, ");
		sb.append("psn1.name as name_emp_cfm, ");
		sb.append("aptmt.dt_apt_cfm, ");
		sb.append("aptmt.id_aptmt as id_apt_mt, ");
		sb.append("aptmt.url_photo, ");
		sb.append("tick.eu_used, ");	//已使用标志add by yaohl 2019/06/11
		sb.append("tick.eu_usescope, ");	//可使用范围add by yaohl 2019/06/11 开放/保留
		sb.append("tick.fg_active ");	//号位启用状态add by yaohl 2019/06/11
		sb.append("FROM SC_APT APT ");
		sb.append("INNER JOIN PI_PAT PAT ON PAT.ID_PAT = APT.ID_PAT ");
		sb.append("LEFT JOIN SC_SCH SCH ON SCH.ID_SCH = APT.ID_SCH ");
		sb.append("LEFT JOIN SC_PL PL ON PL.ID_SCPL = SCH.ID_SCPL ");
		sb.append("LEFT JOIN BD_DAYSLOT LOT ON LOT.ID_dayslot = APT.ID_dateslot ");
		sb.append("LEFT JOIN SC_RES RES ON RES.id_scres = PL.id_scres ");
		sb.append("LEFT JOIN SC_SRV SRV ON SRV.ID_SCSRV = PL.ID_SCSRV ");
		sb.append("LEFT JOIN BD_PSNDOC APPTDOC ON APPTDOC.ID_PSNDOC = APT.ID_EMP_APPT ");
		sb.append("LEFT JOIN BD_PSNDOC CANCDOC ON CANCDOC.ID_PSNDOC = APT.ID_EMP_CANC ");
		sb.append("left join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join sc_apt_exchl exchl on exchl.id_apt = apt.id_apt ");
		sb.append("inner join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
		sb.append("left join en_ent_ip ip  on ip.id_ent = appl.id_ent ");
		sb.append("left join bd_dep war on war.id_dep = ip.id_dep_nuradm ");
		sb.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = appl.id_dep_mp ");//执行科室
		sb.append("LEFT JOIN sc_apt_mt aptmt ON aptmt.id_apt = APT.ID_APT ");
		sb.append("left join bd_dep dep3 on dep3.id_dep = appl.id_dep_appl ");//申请科室
		sb.append("left join bd_srv bdsrv on appl.id_srv = bdsrv.id_srv ");
		sb.append("left join bd_psndoc psn on appl.id_emp_appl = psn.id_psndoc  ");
		sb.append("left join bd_psndoc psn1 on aptmt.id_emp_cfm = psn1.id_psndoc  ");
		sb.append("left join bd_entp entp on appl.id_entp = entp.id_entp ");
		sb.append("left join bd_udidoc docapt on apt.id_status = docapt.id_udidoc ");
		sb.append("left join bd_udidoc docpat on pat.id_sex = docpat.id_udidoc ");//性别
		sb.append("left join sc_tick tick on apt.id_tick = tick.id_tick ");//号位
		// 手术，fanlq-2018.02.28
		if (opAptQryDTO.getSd_sctp() != null && opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT)) {
			sb.append("left join sc_apt_opt aptopt on aptopt.id_apt = apt.id_apt ");
			sb.append("left join bd_dep dep3 on dep3.id_dep = appl.id_dep_appl ");

		}
		sb.append("WHERE APT.SD_SCTP = ? ");
		param.addParam(opAptQryDTO.getSd_sctp());

		if (opAptQryDTO.getSd_sctp() != null && opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_MT)) {
			sb.append(" and appl.sd_sys_from in ('1','0') "); // //医技 0:iih 1:chis
		}

		// 门诊、住院、急诊标志
		if (FBoolean.TRUE.equals(opAptQryDTO.getFg_op()) || FBoolean.TRUE.equals(opAptQryDTO.getFg_inhos())
				|| FBoolean.TRUE.equals(opAptQryDTO.getFg_emg())) {
			sb.append(" and  " + getEntTpSql(opAptQryDTO));
		}
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getName_pat())) {
			sb.append("AND PAT.NAME = ? ");
			param.addParam(opAptQryDTO.getName_pat());
		}
		//申请单号
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getApplyno()))
		{
			sb.append(" and appl.applyno = ? ");
			param.addParam(opAptQryDTO.getApplyno());
		}
		// 检查日期
		if (opAptQryDTO.getD_b() != null) {
			sb.append("and apt.dt_b >= ? ");
			String dbStr = opAptQryDTO.getD_b().toStdString() + " 00:00:00";
			param.addParam(dbStr);
		}
		if (opAptQryDTO.getD_e() != null) {
			sb.append("and apt.dt_b <= ? ");
			String deStr = opAptQryDTO.getD_e().toStdString() + " 23:59:59";
			param.addParam(deStr);
		}
		//诊疗项目
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_srv()))
		{
			String[] srvIds = opAptQryDTO.getId_srv().split(",");
			if(srvIds.length > 1){
				String cond = ScSqlUtils.buildIdStr(srvIds);
				sb.append(" and appl.id_srv in ("+cond+")");
			}else{
			sb.append(" and appl.id_srv = ? ");
			param.addParam(opAptQryDTO.getId_srv());
		}
		}
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scres())) {
			String[] resIds = opAptQryDTO.getId_scres().split(",");
			if(resIds.length > 1){
				String cond = ScSqlUtils.buildIdStr(resIds);
				sb.append("AND APT.id_scres in ("+cond+") ");
			}else{
			sb.append("AND APT.id_scres = ? ");
			param.addParam(opAptQryDTO.getId_scres());
		}
		}
		//预约备注
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getNote())){
			sb.append(" and aptmt.note like ? ");
			param.addParam("%"+opAptQryDTO.getNote()+"%");
		}
		//  预约状态
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getSd_aptstatus())) {
			sb.append("and apt.sd_status = ? ");
			param.addParam(opAptQryDTO.getSd_aptstatus());
		}
		// 预约渠道
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scchl())) {
			sb.append("and apt.id_scchl = ? ");
			param.addParam(opAptQryDTO.getId_scchl());
		}
		// 操作开始日期
		if (opAptQryDTO.getD_b_appt() != null) {
			sb.append("and apt.dt_appt >= ? ");
			//String dbStr = opAptQryDTO.getD_b_appt().toStdString() + " 00:00:00";
			String dbStr = opAptQryDTO.getD_b_appt().toStdString();
			param.addParam(dbStr);
		}
		// 操作结束日期
		if (opAptQryDTO.getD_e_appt() != null) {
			sb.append("and apt.dt_appt <= ? ");
			//String deStr = opAptQryDTO.getD_e_appt().toStdString() + " 23:59:59";
			String deStr = opAptQryDTO.getD_e_appt().toStdString();
			param.addParam(deStr);
		}
		// 预约号
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getCode_apt())) {
			sb.append("and (apt.code = ? or exchl.code_apt = ? ) ");
			param.addParam(opAptQryDTO.getCode_apt());
			param.addParam(opAptQryDTO.getCode_apt());
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getCode_pat())) {
			sb.append("and pat.code = ? ");
			param.addParam(opAptQryDTO.getCode_pat());
		}
		// 开单科室
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_dep_appt())) {
			sb.append(" and appl.id_dep_appl = ? ");
			param.addParam(opAptQryDTO.getId_dep_appt());
		}
		// 预约操作人
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_emp_appt())) {
			sb.append("and apt.id_emp_appt = ? ");
			param.addParam(opAptQryDTO.getId_emp_appt());
		}
		//排班服务
		if(!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_scsrv()))
		{
			sb.append(" and apt.id_scsrv = ? ");
			param.addParam(opAptQryDTO.getId_scsrv());
		}
		// 执行科室
		if (!StringUtil.isEmptyWithTrim(opAptQryDTO.getId_dep())) {
			sb.append("and pl.id_dep = ? ");
			param.addParam(opAptQryDTO.getId_dep());
		}

		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "APT"));

		sb.append(" order by apt.dt_b,sch.d_sch,sch.id_sch) a  ");
		return sb.toString();
	}

	/***
	 * 获取门诊、住院、急诊标识的SQL连接语句
	 *
	 * @author fanlq
	 * @return
	 */
	private String getEntTpSql(OpAptQryDTO opAptQryDTO) {
		List<String> list = new ArrayList<String>();
		if (FBoolean.TRUE.equals(opAptQryDTO.getFg_op())) {
			list.add(IEnDictCodeConst.SD_ENTP_OUTPATIENT);
		}
		if (FBoolean.TRUE.equals(opAptQryDTO.getFg_inhos())) {
			list.add(IEnDictCodeConst.SD_ENTP_INPATIENT);
		}
		if (FBoolean.TRUE.equals(opAptQryDTO.getFg_emg())) {
			list.add(IEnDictCodeConst.SD_ENTP_EMERGENCY);
		}
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return ScSqlUtils.getInSqlByIds("appl.code_entp", list);
	}
}

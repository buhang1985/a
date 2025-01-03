package iih.sc.apt.s.bp.op.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OpAptQryDTO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScSqlUtils;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @modifier zhengcm 增加集团管控
 * @modifier zhengcm 2017-09-08 按照需求文档重新调整界面和数据
 * @date 2017-06-26 11:29:20
 *
 */
public class SelopAptDetailSql implements ITransQry {

	private OpAptQryDTO opAptQryDTO;

	public SelopAptDetailSql(OpAptQryDTO opAptQryDTO) {
		if (opAptQryDTO != null)
			this.opAptQryDTO = opAptQryDTO;
		else {
			this.opAptQryDTO = new OpAptQryDTO();
		}
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getName_pat())) {
			param.addParam(this.opAptQryDTO.getName_pat());
		}
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_scres())) {
			param.addParam(this.opAptQryDTO.getId_scres());
		}
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_scsrv())) {
			param.addParam(this.opAptQryDTO.getId_scsrv());
		}
		if (this.opAptQryDTO.getD_b() != null) {
			String dbStr = this.opAptQryDTO.getD_b().toStdString() + " 00:00:00";
			param.addParam(dbStr);
		}
		if (this.opAptQryDTO.getD_e() != null) {
			String deStr = this.opAptQryDTO.getD_e().toStdString() + " 23:59:59";
			param.addParam(deStr);
		}
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getSd_aptstatus())) {
			param.addParam(this.opAptQryDTO.getSd_aptstatus());
		}
		// 操作开始日期
		if (this.opAptQryDTO.getD_b_appt() != null) {
			//String dbStr = this.opAptQryDTO.getD_b_appt().toStdString() + " 00:00:00";
			String dbStr = this.opAptQryDTO.getD_b_appt().toStdString();
			param.addParam(dbStr);
		}
		// 操作结束日期
		if (this.opAptQryDTO.getD_e_appt() != null) {
			//String deStr = this.opAptQryDTO.getD_e_appt().toStdString() + " 23:59:59";
			String deStr = this.opAptQryDTO.getD_e_appt().toStdString();
			param.addParam(deStr);
		}
		// 科室
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_dep())) {
			param.addParam(this.opAptQryDTO.getId_dep());
		}
		// 午别
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_dayslot())) {
			param.addParam(this.opAptQryDTO.getId_dayslot());
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getCode_pat())) {
			param.addParam(this.opAptQryDTO.getCode_pat());
		}
		// 登记人
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_emp_appt())) {
			param.addParam(this.opAptQryDTO.getId_emp_appt());
		}
		// 预约号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getCode_apt())) {
			param.addParam(this.opAptQryDTO.getCode_apt());
			param.addParam(this.opAptQryDTO.getCode_apt());
		}
		// 预约渠道
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_scchl())) {
			param.addParam(this.opAptQryDTO.getId_scchl());
		}
		// 手术，fanlq-2018.02.28
		if (this.opAptQryDTO.getSd_sctp() != null && this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT)) {
			// 包含取消
			if (FBoolean.FALSE.equals(this.opAptQryDTO.getFg_canc())) {
				param.addParam(FBoolean.FALSE);
			}
			// 申请科室
			if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_dep_appt())) {
				param.addParam(this.opAptQryDTO.getId_dep_appt());
			}
		}
		// 身份证号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_code())) {
			param.addParam(this.opAptQryDTO.getId_code());
		}
		// 手机号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getTel())) {
			param.addParam(this.opAptQryDTO.getTel());
			param.addParam(this.opAptQryDTO.getTel());
		}
		// 医保号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getNo_hp())) {
			param.addParam(this.opAptQryDTO.getNo_hp());
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		if (this.opAptQryDTO.getSd_sctp() != null
				&& (this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_MT) || this.opAptQryDTO.getSd_sctp()
						.equals(IScDictCodeConst.SD_SCTP_OT))) {
			sb.append("dep3.name as name_dept_appt,");
			sb.append("appl.code_entp,");
		}
		sb.append("PL.EU_EDIT_TP,");
		sb.append("pl.id_dep as id_dept,");// add by zhengcm 2018-01-29
		sb.append("APT.ID_APT,");
		sb.append("apt.code as code_apt,");
		sb.append("APT.ID_PAT,");
		sb.append("APT.Id_tick,");
		sb.append("pat.code as code_pat,");
		sb.append("PAT.NAME AS name_pat,");
		sb.append("PAT.DT_BIRTH,");
		sb.append("APT.DT_B,");
		sb.append("APT.DT_E,");
		sb.append("pat.id_code as id_code,");// 身份证号
		sb.append("NVL(PAT.TEL,PAT.MOB) AS MOB,");// 手机号
		sb.append("PATHP.NO_HP AS NO_HP,");// 手机号
		sb.append("LOT.name as name_dateslot,");
		sb.append("RES.NAME AS name_scres,");
		sb.append("SRV.NAME AS NAME_SCSRV,");
		sb.append("APT.QUENO,");
		sb.append("APPTDOC.NAME AS NAME_EMP_APPT,");
		sb.append("APT.DT_APPT,");
		sb.append("APT.SD_STATUS,");
		sb.append("chl.name as name_scchl,");
		sb.append("DEP.NAME AS NAME_DEPT,");
		if(this.opAptQryDTO.getSd_sctp() != null && this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OP))//门诊预约表不一样
		{
			sb.append("'门诊' as name_enttp, ");
		}
		else
		{
			sb.append("war.name as name_dep_nuradm,");	
			sb.append("ip.name_bed,");
			sb.append("appl.id_aptappl as id_apt_appl,");
			sb.append("decode(appl.code_entp,'00','门诊','10','住院','01','急诊','02','体检','20','家庭病床') as name_enttp, ");
		}
		sb.append("exchl.code_apt as code_apt_exchl,");
		sb.append("DECODE(APT.SD_STATUS,'1','预约','2','支付','3','完成','4','取消') AS NAME_STATUS,");
		// sb.append(" CANCDOC.NAME AS NAME_EMP_CANC,");
		sb.append("(case apt.sd_status when '4' then case apt.dt_canc when null then cancdoc.name else case apt.id_emp_canc when null then '管理员' when '~' then '管理员' else cancdoc.name end end end)NAME_EMP_CANC,");
		if (this.opAptQryDTO.getSd_sctp() != null && (this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_MT) || this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT))) {// 医技
			sb.append(" appl.id_ent,");
			sb.append(" appl.id_or,");
			sb.append(" appl.dt_effe_or,");
			sb.append(" opt.id_anestp,");
			sb.append(" anestp.name as name_anestp,");
			sb.append(" site.name as name_surgical_site,");
		}
		sb.append("APT.DT_CANC,");
		sb.append("APT.NOTE_CANC ");
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
		sb.append("left join pi_pat_hp pathp on pat.id_pat = pathp.id_pat ");
		if(this.opAptQryDTO.getSd_sctp() != null && this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OP))//门诊预约表不一样
		{
			sb.append("left join sc_apt_op op on op.id_apt = apt.id_apt ");
			sb.append("left join bd_dep dep on op.id_dep = dep.id_dep ");
		}
		else
		{
			sb.append("left join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
			sb.append("left join en_ent_ip ip  on ip.id_ent = appl.id_ent ");
			sb.append("left join bd_dep war on war.id_dep = ip.id_dep_nuradm ");
			sb.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = appl.id_dep_appl ");
		}
		
		if (this.opAptQryDTO.getSd_sctp() != null && this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_MT)) {// 医技
			sb.append("LEFT JOIN sc_apt_mt aptmt ON aptmt.id_apt = APT.ID_APT ");
			sb.append("left join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
			sb.append("left join bd_dep dep3 on dep3.id_dep = appl.id_dep_appl ");
		}
		sb.append("LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = PL.ID_DEP ");
		// 手术，fanlq-2018.02.28
		if (this.opAptQryDTO.getSd_sctp() != null && this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT)) {
			sb.append("left join sc_apt_opt aptopt on aptopt.id_apt = apt.id_apt ");
			// sb.append("left join bd_dep dep2 on dep2.id_dep = aptopt.id_dep_belong ");
			sb.append("left join sc_apt_appl appl on appl.id_scapt = apt.id_apt ");
			sb.append("left join bd_dep dep3 on dep3.id_dep = appl.id_dep_appl ");
			sb.append("left join sc_apt_appl_opt opt on opt.id_aptappl = appl.id_aptappl ");
			sb.append("left join bd_udidoc anestp on anestp.id_udidoc = opt.id_anestp ");
			sb.append(" left join ci_ap_sug sug on sug.id_or = appl.id_or ");
			sb.append("left join bd_udidoc site on site.id_udidoc = sug.id_surgical_site ");
		}
		
			
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getSd_sctp())) {
			sb.append("WHERE APT.SD_SCTP='" + this.opAptQryDTO.getSd_sctp() + "' ");
		} else {
			sb.append("WHERE APT.SD_SCTP='" + IScDictCodeConst.SD_SCTP_OP + "' ");
		}
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getName_pat())) {
			sb.append("AND PAT.NAME = ? ");
		}
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_scres())) {
			sb.append("AND APT.id_scres = ? ");
		}
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_scsrv())) {
			sb.append("AND APT.id_scsrv = ? ");
		}
		if (this.opAptQryDTO.getD_b() != null) {
			sb.append("and apt.dt_b >= ? ");
		}
		if (this.opAptQryDTO.getD_e() != null) {
			sb.append("and apt.dt_b <= ? ");
		}
		// Changed by zhengcm:增加预约状态字段（2017-03-07）
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getSd_aptstatus())) {
			sb.append("and apt.sd_status = ? ");
		}

		// 操作开始日期
		if (this.opAptQryDTO.getD_b_appt() != null) {
			sb.append("and apt.dt_appt >= ? ");
		}
		// 操作结束日期
		if (this.opAptQryDTO.getD_e_appt() != null) {
			sb.append("and apt.dt_appt <= ? ");
		}
		// 科室
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_dep())) {
			sb.append("and pl.id_dep = ? ");
		}
		// 午别
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_dayslot())) {
			sb.append("and apt.id_dateslot = ? ");
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getCode_pat())) {
			sb.append("and pat.code = ? ");
		}
		// 登记人
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_emp_appt())) {
			sb.append("and apt.id_emp_appt = ? ");
		}
		// 预约号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getCode_apt())) {
			sb.append("and (apt.code = ? or exchl.code_apt = ? ) ");
		}
		// 预约渠道
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_scchl())) {
			sb.append("and apt.id_scchl = ? ");
		}

		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "APT"));

		// 手术，fanlq-2018.02.28
		if (this.opAptQryDTO.getSd_sctp() != null && this.opAptQryDTO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_OT)) {
			// 包含取消
			if (FBoolean.FALSE.equals(this.opAptQryDTO.getFg_canc())) {
				sb.append(" and apt.fg_canc = ?");
			}
			// 门诊、住院、急诊标志
			if (FBoolean.TRUE.equals(this.opAptQryDTO.getFg_op())
					|| FBoolean.TRUE.equals(this.opAptQryDTO.getFg_inhos())
					|| FBoolean.TRUE.equals(this.opAptQryDTO.getFg_emg())) {
				sb.append(" and  " + this.getEntTpSql());
			}
			// 申请科室
			if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_dep_appt())) {
				sb.append(" and appl.id_dep_appl = ? ");
			}
		}
		// 身份证号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getId_code())) {
			sb.append("and pat.id_code = ? ");
		}
		// 手机号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getTel())) {
			sb.append("and (pat.tel = ? or pat.mob = ? )");
		}
		// 医保号
		if (!StringUtil.isEmptyWithTrim(this.opAptQryDTO.getNo_hp())) {
			sb.append("and pathp.no_hp = ? ");
		}
		return sb.toString();
	}

	/***
	 * 获取门诊、住院、急诊标识的SQL连接语句
	 * 
	 * @author fanlq
	 * @return
	 */
	private String getEntTpSql() {
		List<String> list = new ArrayList<String>();
		if (FBoolean.TRUE.equals(this.opAptQryDTO.getFg_op())) {
			list.add(IEnDictCodeConst.SD_ENTP_OUTPATIENT);
		}
		if (FBoolean.TRUE.equals(this.opAptQryDTO.getFg_inhos())) {
			list.add(IEnDictCodeConst.SD_ENTP_INPATIENT);
		}
		if (FBoolean.TRUE.equals(this.opAptQryDTO.getFg_emg())) {
			list.add(IEnDictCodeConst.SD_ENTP_EMERGENCY);
		}
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return ScSqlUtils.getInSqlByIds("appl.code_entp", list);
	}
}

package iih.sc.sch.s.bp.op;

import iih.en.pv.outpatient.d.EuRegTp;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchCancDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门诊排班停诊排班预约信息BP
 * 
 * @author zhengcm
 * @date 2017-11-17 09:09:40
 *
 */
public class GetOpSchCancAptInfoBP {

	/**
	 * 获取门诊排班停诊排班预约信息
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 09:09:58
	 *
	 * @param id_sch
	 * @param isShowCancel
	 * @return
	 * @throws BizException
	 */
	public SchCancDTO[] exec(String id_sch, FBoolean isShowCancel) throws BizException {
		// 校验参数
		ScValidator.validateParam("id_sch", id_sch);
		ScValidator.validateParam("isFilterCancel", isShowCancel);
		// 查询预约数据
		List<SchCancDTO> datas = this.queryAptDatas(id_sch, isShowCancel);
		// 查询挂号数据
		List<SchCancDTO> regDatas = this.queryRegDatas(id_sch);
		// 合并预约和挂号数据
		datas.addAll(regDatas);
		// 计算患者年龄
		this.calcPatAge(datas);
		if (ListUtil.isEmpty(datas)) {
			return null;
		}
		return datas.toArray(new SchCancDTO[0]);
	}

	/**
	 * 查询排班预约数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 09:11:59
	 *
	 * @param id_sch
	 * @param isShowCancel
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<SchCancDTO> queryAptDatas(String id_sch, FBoolean isShowCancel) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.d_sch,");
		sb.append("apt.id_apt,");
		sb.append("apt.id_sch,");
		sb.append("apt.id_tick,");
		sb.append("tick.queno,");
		sb.append("pat.barcode_chis as code_chis,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.dt_birth as d_birth,");
		sb.append("pat.mob as mob_pat,");
		sb.append("emp_reg.name as name_emp_reg,");
		sb.append("apt.sd_status,");
		sb.append("status.name as name_status,");
		sb.append("emp_canc.name as name_emp_canc,");
		sb.append("apt.id_scchl,");
		sb.append("chl.name as name_scchl,");
		sb.append("apt2.dt_b as dt_apt_cancto,");
		sb.append("pl2.name as name_scpl_cancto,");
		sb.append("apt2.queno as queno_cancto,");
		sb.append("op.id_en as id_ent,");
		sb.append("tick.t_b as dt_b ");
		sb.append("from ");
		sb.append("sc_apt apt ");
		sb.append("inner join sc_tick tick on tick.id_tick = apt.id_tick ");
		sb.append("inner join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("inner join pi_pat pat on pat.id_pat = apt.id_pat ");
		sb.append("inner join bd_psndoc emp_reg on emp_reg.id_psndoc = apt.id_emp_appt ");
		sb.append("inner join sc_chl chl on chl.id_scchl = apt.id_scchl ");
		sb.append("left join bd_udidoc status on status.id_udidoc = apt.id_status ");
		sb.append("left join bd_psndoc emp_canc on emp_canc.id_psndoc = apt.id_emp_canc ");
		sb.append("left join sc_apt apt2 on apt2.id_apt = apt.id_scapt_cancto ");
		sb.append("left join sc_tick tick2 on tick2.id_tick = apt2.id_tick ");
		sb.append("left join sc_sch sch2 on sch2.id_sch = apt2.id_sch ");
		sb.append("left join sc_pl pl2 on pl2.id_scpl = sch2.id_scpl ");
		sb.append("left join sc_apt_op op on op.id_apt = apt.id_apt ");
		sb.append("left join sc_sch sch on sch.id_sch = apt.id_sch ");
		sb.append("where 1 = 1 ");
		sb.append("and apt.id_grp = ? ");
		sb.append("and apt.id_org = ? ");
		sb.append("and apt.id_sch = ? ");
		if (!isShowCancel.booleanValue()) {
			sb.append("and apt.fg_canc = 'N' ");
		}
		sb.append("order by apt.queno,apt2.queno ");
		SqlParam params = new SqlParam();
		params.addParam(ScContextUtils.getGrpId());
		params.addParam(ScContextUtils.getOrgId());
		params.addParam(id_sch);
		List<SchCancDTO> list = (List<SchCancDTO>) new DAFacade().execQuery(sb.toString(), params, new BeanListHandler(
				SchCancDTO.class));
		return list;
	}

	/**
	 * 查询排班挂号数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-01 15:04:44
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<SchCancDTO> queryRegDatas(String id_sch) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("op.id_sch,");
		sb.append("op.id_tick,");
		sb.append("op.ticketno as queno,");
		sb.append("pat.barcode_chis as code_chis,");
		sb.append("pat.name as name_pat,");
		sb.append("pat.dt_birth as d_birth,");
		sb.append("pat.mob as mob_pat,");
		sb.append("emp.name as name_emp_reg,");
		sb.append("'挂号' as name_status,");
		sb.append("op.eu_regtp as sd_status,");
		sb.append("tick.t_b as dt_b,");
		sb.append("sch.d_sch ");
		sb.append("from ");
		sb.append("en_ent_op op ");
		sb.append("inner join en_ent ent on op.id_ent = ent.id_ent ");
		sb.append("inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sb.append("inner join bd_psndoc emp on emp.id_psndoc = op.id_emp_reg ");
		sb.append("left join sc_tick tick on op.id_tick = tick.id_tick ");
		sb.append("left join sc_sch sch on op.id_sch = sch.id_sch ");
		sb.append("where 1 = 1 ");
		sb.append("and nvl(ent.fg_canc, 'N') = 'N' ");
		sb.append("and (op.id_schapt is null or op.id_schapt = '~') ");
		sb.append("and ent.id_org = ? ");
		sb.append("and op.id_sch = ? ");
		sb.append("order by op.ticketno ");
		SqlParam params = new SqlParam();
		params.addParam(ScContextUtils.getOrgId());
		params.addParam(id_sch);
		List<SchCancDTO> list = (List<SchCancDTO>) new DAFacade().execQuery(sb.toString(), params, new BeanListHandler(
				SchCancDTO.class));
		// 设置挂号渠道名称
		this.setRegtpName(list);
		return list;
	}

	/**
	 * 计算患者年龄
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 09:21:15
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void calcPatAge(List<SchCancDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (SchCancDTO data : datas) {
			if (null != data.getD_birth()) {
				data.setAge_pat(AgeCalcUtil.getAge(data.getD_birth()));
			}
		}
	}

	/**
	 * 设置挂号渠道名称
	 * 
	 * @author zhengcm
	 * @date 2017-12-01 14:56:16
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void setRegtpName(List<SchCancDTO> datas) throws BizException {
		if (ListUtil.isEmpty(datas)) {
			return;
		}
		for (SchCancDTO data : datas) {
			data.setName_scchl(this.getRegTpName(data.getSd_status()));
			data.setSd_status(null);
		}
	}

	/**
	 * 获取挂号渠道名称
	 * 
	 * @author zhengcm
	 * @date 2017-12-01 14:54:44
	 *
	 * @param eu_regtp
	 * @return
	 * @throws BizException
	 */
	private String getRegTpName(String eu_regtp) throws BizException {
		if (StringUtil.isEmptyWithTrim(eu_regtp)) {
			return null;
		}
		String regtpName = null;
		switch (eu_regtp) {
		case EuRegTp.COMMON:
			regtpName = "普通挂号";
			break;
		case EuRegTp.TRIAGE:
			regtpName = "分诊台挂号";
			break;
		case EuRegTp.PAYAFTERDI:
			regtpName = "先诊疗后付费方式挂号";
			break;
		case EuRegTp.CONSULTINGROOM:
			regtpName = "医生诊间挂号";
			break;
		case EuRegTp.APT:
			regtpName = "预约";
			break;
		}
		return regtpName;
	}

}

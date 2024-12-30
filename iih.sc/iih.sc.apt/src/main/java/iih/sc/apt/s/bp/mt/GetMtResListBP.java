package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.s.bp.CalcSchChlRemainBP;
import iih.sc.apt.s.bp.GetAptChlMaxDateBP;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.scsch.d.ScSchDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医技排班信息
 * 
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 *
 */
public class GetMtResListBP {
	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	public MtResDTO[] exec(MtAppQryDTO qryDTO) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		// 检查参数
		ScValidator.validateParam("id_dep", qryDTO.getId_dep());
		ScValidator.validateParam("id_scchl", qryDTO.getId_scchl());
		ScValidator.validateParam("d_begin", qryDTO.getD_begin());
		ScValidator.validateParam("d_end", qryDTO.getD_end());
		if (qryDTO.getFg_autofilter().booleanValue()) {
			ScValidator.validateParam("id_srv", qryDTO.getId_srv_filter());
		}

		// 根据渠道最大预约日期修正查询的结束日期
		FDate end = this.getChlMaxDate(qryDTO);
		if (end != null && qryDTO.getD_end().after(end)) {
			qryDTO.setD_end(end);
		}

		// 查询数据
		List<MtResDTO> mtAptDTOs = this.queryDatas(qryDTO);
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return null;
		}

		// 设置号位和号段数据
		new SetMtAptSchTicksBP().exec(mtAptDTOs);

		// 设置排班对应号位和号段的排班服务
		new SetMtAptScSrvBP().exec(mtAptDTOs);

		// 计算渠道剩余可预约数
		new CalcSchChlRemainBP().exec(mtAptDTOs);

		return mtAptDTOs.toArray(new MtResDTO[0]);
	}

	/**
	 * 查询数据
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@SuppressWarnings("unchecked")
	private List<MtResDTO> queryDatas(MtAppQryDTO qryDTO) throws BizException {
		StringBuilder sql = this.getSql(qryDTO.getFg_autofilter().booleanValue());
		SqlParam params = new SqlParam();
		params.addParam(qryDTO.getId_dep());
		if (null != qryDTO.getQrytype() && qryDTO.getQrytype() == 3) {
			params.addParam(IScDictCodeConst.SD_SCTP_OT);// 医技
		} else {
			params.addParam(IScDictCodeConst.SD_SCTP_MT);// 手术
		}
		params.addParam(qryDTO.getId_scchl());
		params.addParam(qryDTO.getD_begin());
		params.addParam(qryDTO.getD_end());
		if (qryDTO.getFg_autofilter().booleanValue()) {
			params.addParam(qryDTO.getId_srv_filter());
		}
		List<MtResDTO> mtAptDTOs = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params,
				new BeanListHandler(MtResDTO.class));
		return mtAptDTOs;
	}

	/**
	 * 查询Sql
	 *
	 * @param isAutoFilter 是否自动过滤
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(boolean isAutoFilter) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_tickmd,");
		sb.append("pl.sd_tickmd,");
		sb.append("pl.id_dep,");
		sb.append("pl.srvslot_min as srvlot_min,");
		sb.append("pl.eu_timeslottp as Eu_timeslottp,");
		sb.append("res.id_scres as id_res,");
		sb.append("res.name as name_res,");
		sb.append("res.code as code_res,");
		sb.append("res.id_mt,");
		sb.append("chl.id_scchl,");
		sb.append("chl.scpolcn,");
		sb.append("sch.id_dayslot,");
		sb.append("lot.code as sd_dayslot,");
		sb.append("lot.name as name_dayslot,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_appt,");
		sb.append("sch.quan_total_used,");
		sb.append("sch.fg_active,");
		sb.append("sch.t_b_acpt,");
		sb.append("sch.t_e_acpt,");
		sb.append("sch.quan0_appt,");
		sb.append("sch.quan1_appt,");
		sb.append("sch.quan2_appt,");
		sb.append("sch.quan3_appt,");
		sb.append("sch.quan4_appt,");
		sb.append("sch.quan5_appt,");
		sb.append("sch.quan6_appt,");
		sb.append("sch.quan7_appt,");
		sb.append("sch.quan8_appt,");
		sb.append("sch.quan9_appt,");
		sb.append("sch.quan0_used,");
		sb.append("sch.quan1_used,");
		sb.append("sch.quan2_used,");
		sb.append("sch.quan3_used,");
		sb.append("sch.quan4_used,");
		sb.append("sch.quan5_used,");
		sb.append("sch.quan6_used,");
		sb.append("sch.quan7_used,");
		sb.append("sch.quan8_used,");
		sb.append("sch.quan9_used ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join sc_sch_chl chl on chl.id_sch = sch.id_sch ");
		sb.append("inner join sc_res res on res.id_scres = pl.id_scres ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		sb.append("and pl.sd_sctp = ? ");
		sb.append("and chl.id_scchl = ? ");
		sb.append("and sch.d_sch >= ? ");
		sb.append("and sch.d_sch <= ? ");
		if (isAutoFilter) {
			sb.append("and sch.id_sch in (select tick.id_sch from sc_tick tick inner join sc_srv_rel rel on rel.id_scsrv = tick.id_scsrv and rel.id_mdsrv = ?) ");
		}
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));
		sb.append("order by sch.id_sch");
		return sb;
	}

	/**
	 * 获取渠道最大预约日期
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private FDate getChlMaxDate(MtAppQryDTO qryDTO) throws BizException {
		if (StringUtil.isEmptyWithTrim(qryDTO.getId_scchl())) {
			return null;
		}
		ISchedulechlMDORService chlQryService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO chlDO = chlQryService.findById(qryDTO.getId_scchl());
		if (chlDO == null) {
			return null;
		}
		String sd_sctp = IScDictCodeConst.SD_SCTP_MT;
		if (null != qryDTO.getQrytype() && qryDTO.getQrytype() == 3) {
			sd_sctp = IScDictCodeConst.SD_SCTP_OT;
		}
		return new GetAptChlMaxDateBP().exec(chlDO.getCode_scchltp(), sd_sctp);
	}
}

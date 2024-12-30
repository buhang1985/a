package iih.sc.apt.s.bp.op.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OpAptQryDTO;
import iih.sc.apt.s.bp.CalcSchChlRemainBP;
import iih.sc.apt.s.bp.GetAptChlMaxDateBP;
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
 * 门诊预约排班信息查询BP
 * 
 * @author zhengcm
 * @modifier zhengcm 增加集团管控
 * 
 */
public class GetOpResBP {

	/**
	 * 门诊预约排班信息查询
	 * 
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MtResDTO[] exec(OpAptQryDTO qryDTO) throws BizException {
		if (qryDTO == null) {
			return null;
		}
		List<MtResDTO> resDTOList = (List<MtResDTO>) new DAFacade().execQuery(this.getSql(qryDTO).toString(),
				this.getParams(qryDTO), new BeanListHandler(MtResDTO.class));
		if (ListUtil.isEmpty(resDTOList)) {
			return null;
		}
		// 计算渠道剩余可预约数
		new CalcSchChlRemainBP().exec(resDTOList);
		return resDTOList.toArray(new MtResDTO[0]);
	}

	/**
	 * 查询Sql
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private StringBuilder getSql(OpAptQryDTO qryDTO) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_appt,");
		sb.append("sch.quan_total_used,");
		sb.append("sch.fg_active,");
		sb.append("sch.id_dayslot,");
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
		sb.append("sch.quan9_used,");
		sb.append("chl.id_scchl,");
		sb.append("chl.scpolcn,");
		sb.append("lot.code as sd_dayslot,");
		sb.append("lot.name as name_dayslot,");
		sb.append("lot.id_dayslottp as id_dayslottp,");
		sb.append("pl.id_scpl,");
		sb.append("pl.name as name_scpl,");
		sb.append("pl.id_dep,");
		sb.append("pl.id_scsrv,");
		sb.append("pl.id_tickmd,");
		sb.append("pl.sd_tickmd,");
		sb.append("dep.name as name_dep,");
		sb.append("srv.name as name_scsrv,");
		sb.append("res.id_scres as id_res,");
		sb.append("res.name as name_res,");
		sb.append("res.code as code_res ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on sch.id_scpl = pl.id_scpl ");
		sb.append("inner join sc_res res on pl.id_scres = res.id_scres ");
		sb.append("inner join sc_sch_chl chl on chl.id_sch = sch.id_sch ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("inner join bd_dep dep on dep.id_dep = pl.id_dep ");
		sb.append("inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv ");
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		sb.append("and chl.id_scchl = ? ");
		// sb.append("and pl.eu_edit_tp = '0' ");
		sb.append("and pl.sd_sctp = ? ");
		sb.append("and sch.d_sch >= ? ");
		sb.append("and sch.d_sch <= ? ");
		if (!StringUtil.isEmptyWithTrim(qryDTO.getId_scres())) {
			sb.append("and res.id_scres = ? ");
		}
		if (!StringUtil.isEmptyWithTrim(qryDTO.getId_scsrv())) {
			sb.append("and srv.id_scsrv = ? ");
		}
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));
		return sb;
	}

	/**
	 * 查询参数
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private SqlParam getParams(OpAptQryDTO qryDTO) throws BizException {
		SqlParam params = new SqlParam();
		params.addParam(qryDTO.getId_dep());
		params.addParam(qryDTO.getId_scchl());
		params.addParam(IScDictCodeConst.SD_SCTP_OP);
		params.addParam(qryDTO.getD_b());
		FDate end = this.getChlMaxDate(qryDTO);
		if (end != null && qryDTO.getD_e().after(end)) {
			params.addParam(end);
		} else {
			params.addParam(qryDTO.getD_e());
		}
		if (!StringUtil.isEmptyWithTrim(qryDTO.getId_scres())) {
			params.addParam(qryDTO.getId_scres());
		}
		if (!StringUtil.isEmptyWithTrim(qryDTO.getId_scsrv())) {
			params.addParam(qryDTO.getId_scsrv());
		}
		return params;
	}

	/**
	 * 获取渠道最大预约日期
	 *
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private FDate getChlMaxDate(OpAptQryDTO qryDTO) throws BizException {
		if (StringUtil.isEmptyWithTrim(qryDTO.getId_scchl())) {
			return null;
		}
		ISchedulechlMDORService chlQryService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO chlDO = chlQryService.findById(qryDTO.getId_scchl());
		if (chlDO == null) {
			return null;
		}
		return new GetAptChlMaxDateBP().exec(chlDO.getCode_scchltp(), IScDictCodeConst.SD_SCTP_OP);
	}

}

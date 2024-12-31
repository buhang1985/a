package iih.ei.std.s.v1.bp.sc;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.sc.mtstopsch.d.MtStopSchDTO;
import iih.ei.std.d.v1.sc.mtstopsch.d.MtStopSchParamDTO;
import iih.ei.std.d.v1.sc.mtstopsch.d.MtStopSchResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtStopSchListBP extends IIHServiceBaseBP<MtStopSchParamDTO, MtStopSchResultDTO> {

	@Override
	protected void checkParam(MtStopSchParamDTO param) throws BizException {
		validData(param.getDate_begin(), param.getDate_end());
	}

	@Override
	protected MtStopSchResultDTO process(MtStopSchParamDTO param) throws BizException {
		return getResult(param);
	}

	/**
	 * 获取医技停诊列表
	 * 
	 * @param beginDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private MtStopSchResultDTO getResult(MtStopSchParamDTO inparam) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append("  select ");
		sql.append(" sch.id_sch as id_sch,");
		sql.append(" sch.d_sch as date_sch,");
		sql.append(" pl.id_dep as code_dept,");
		sql.append(" dep.name as name_dept,");
		sql.append(" res.name as name_res,");
		sql.append(" res.code as code_res,");
		sql.append(" srv.name as name_srv,");
		sql.append(" srv.code as code_srv,");
		sql.append(" days.sd_dayslottp as dayslottp,");
		sql.append(" days.name as ampm,");
		sql.append(" (sch.quan_total_appt - sch.quan_total_used) as remain,");
		sql.append(" pl.note as note,");
		sql.append(" 'N' as fg_active");
		sql.append(" from sc_sch sch");
		sql.append(" inner join sc_pl pl on sch.id_scpl = pl.id_scpl");
		sql.append(" inner join bd_dep dep on dep.id_dep = pl.id_dep");
		sql.append(" inner join sc_res res on res.id_scres = pl.id_scres");
		sql.append(" inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv");
		sql.append(" inner join bd_dayslot days on days.id_dayslot = sch.id_dayslot");
		sql.append(" where sch.fg_active = 'N'");
		sql.append(" and pl.sd_sctp = '03'");
		sql.append(" and sch.d_sch >= ? ");
		sql.append(" and sch.d_sch <= ? ");
		SqlParam param = new SqlParam();
		param.addParam(inparam.getDate_begin());
		FDate endFDate = inparam.getDate_end().getDateAfter(1);
		param.addParam(endFDate.asBegin());
		PageInfoDTO pageInfoDto = (PageInfoDTO) inparam.getPageinfo().get(0);
		List<MtStopSchDTO> list = this.findPagingData(pageInfoDto,sql.toString(), param, MtStopSchDTO.class);
		MtStopSchResultDTO resultDTO = new MtStopSchResultDTO();
		resultDTO.setMtstopschdto(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}

	/**
	 * 校验数据
	 * 
	 * @param patCode
	 * @param eus_bbrtp
	 * @throws BizException
	 */
	private void validData(FDate beginDate, FDate endDate) throws BizException {
		if (null == beginDate) {
			throw new BizException("获取医技停诊列表失败:开始时间传入为空!");
		}
		if (null == endDate) {
			throw new BizException("获取医技停诊列表失败:结束时间传入为空!");
		}
	}

}

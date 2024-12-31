package iih.ei.std.s.v1.bp.sc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.sc.mtschlist.d.MtSchListDTO;
import iih.ei.std.d.v1.sc.mtschlist.d.MtSchListParamDTO;
import iih.ei.std.d.v1.sc.mtschlist.d.MtSchListResultDTO;
import iih.ei.std.d.v1.sc.mtschlist.d.MtSchResDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.i.IScSchOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMtSchListBP extends IIHServiceBaseBP<MtSchListParamDTO, MtSchListResultDTO> {

	@Override
	protected void checkParam(MtSchListParamDTO param) throws BizException {
		validData(param);
	}

	@Override
	protected MtSchListResultDTO process(MtSchListParamDTO param) throws BizException {
		return getResult(param);
	}

	/**
	 * 取医技排班列表
	 * 
	 * @param scDate
	 *            排班日期yyyy-MM-dd（为避免性能问题，只取一天的记录）
	 * @param idSrv
	 *            诊疗项目id
	 * @param chlType
	 *            渠道类型
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MtSchListResultDTO getResult(MtSchListParamDTO inparam) throws BizException {
		FDate date_b = inparam.getDate_b();
		FDate date_e = inparam.getDate_e();
		String id_srv = inparam.getId_srv();
		String chl_type = inparam.getChl_type();

		// 获取渠道id
		ISchedulechlMDORService rService = ServiceFinder.find(ISchedulechlMDORService.class);
		String id_org = Context.get().getOrgId();
		SchedulechlDO[] chlDOs = rService.find(String.format(" code = '%s' and id_org='%s' ", chl_type, id_org), "",
				FBoolean.FALSE);
		if (ArrayUtil.isEmpty(chlDOs)) {
			throw new BizException("查询医技排班列表失败:渠道编码:" + chl_type + ",未查询到渠道id");
		}
		String id_scchl = chlDOs[0].getId_scchl();
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append("'" + id_scchl + "' as id_scchl, ");
		sql.append(" sch.id_sch,");
		sql.append(" sch.d_sch,");
		sql.append(" pl.id_scca,");
		sql.append(" pl.id_scpl,");
		sql.append(" pl.name as name_scpl,");
		sql.append(" pl.id_tickmd,");
		sql.append(" pl.sd_tickmd,");
		sql.append(" pl.id_dep,");
		sql.append(" pl.id_scsrv,");
		sql.append(" pl.srvslot_min as srvlot_min,");
		sql.append(" pl.eu_timeslottp as Eu_timeslottp,");// 类型
		sql.append(" res.id_scres as id_res,");
		sql.append(" res.name as name_res,");
		sql.append(" res.code as code_res,");
		sql.append(" res.id_mt,");
		sql.append(" sch.id_dayslot,");
		sql.append(" lot.code as sd_dayslot,");
		sql.append(" lot.name as name_dayslot,");
		sql.append(" sch.quan_total,");
		sql.append(" sch.quan_total_appt,");
		sql.append(" sch.quan_total_used,");
		sql.append(" sch.fg_active,");
		sql.append(" sch.t_b_acpt,");
		sql.append(" sch.t_e_acpt,");
		sql.append(" pl.note as speciality,");
		sql.append(" ca.code as code_scca,");
		sql.append(" srv.code as code_srv,");
		sql.append(" sch.quan0_appt,");
		sql.append(" sch.quan1_appt,");
		sql.append(" sch.quan2_appt,");
		sql.append(" sch.quan3_appt,");
		sql.append(" sch.quan4_appt,");
		sql.append(" sch.quan5_appt,");
		sql.append(" sch.quan6_appt,");
		sql.append(" sch.quan7_appt,");
		sql.append(" sch.quan8_appt,");
		sql.append(" sch.quan9_appt,");
		sql.append(" sch.quan0_used,");
		sql.append(" sch.quan1_used,");
		sql.append(" sch.quan2_used,");
		sql.append(" sch.quan3_used,");
		sql.append(" sch.quan4_used,");
		sql.append(" sch.quan5_used,");
		sql.append(" sch.quan6_used,");
		sql.append(" sch.quan7_used,");
		sql.append(" sch.quan8_used,");
		sql.append(" sch.quan9_used ");
		sql.append(" from ");
		sql.append(" sc_sch sch ");
		sql.append(" inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sql.append(" inner join sc_res res on res.id_scres = pl.id_scres ");
		sql.append(" inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sql.append(" inner join sc_srv srv on pl.id_scsrv = srv.id_scsrv ");
		sql.append(" inner join sc_ca ca on ca.id_scca = pl.id_scca");
		sql.append(" inner join sc_srv srv on srv.id_scsrv = pl.id_scsrv");
		sql.append(" where ");
		sql.append(" sch.id_sch in (select id_sch from sc_sch_chl where id_scchl=?)");
		sql.append(" and (sch.d_sch >= ? and sch.d_sch <= ?) ");
		sql.append(" and pl.id_scsrv in (select rel.id_scsrv from sc_srv_rel rel where rel.id_mdsrv = ?) ");
		SqlParam params = new SqlParam();
		params.addParam(id_scchl);
		params.addParam(date_b);
		params.addParam(date_e);
		params.addParam(id_srv);
		PageInfoDTO pageInfoDto = (PageInfoDTO) inparam.getPageinfo().get(0);
		List<MtSchResDTO> list = this.findPagingData(pageInfoDto,sql.toString(), params, MtSchResDTO.class);
		// 计算渠道剩余可预约数
		this.calcSchChlRemainNew(list);
		if (ListUtil.isEmpty(list)) {
			return null;
		}

		List<MtSchListDTO> result = new ArrayList<MtSchListDTO>();
		for (MtSchResDTO resDTO : list) {
			MtSchListDTO bean = new MtSchListDTO();
			bean.setId_sch(resDTO.getId_sch());
			bean.setCode_res(resDTO.getCode_res());
			bean.setName_res(resDTO.getName_res());
			bean.setCode_dept(resDTO.getId_dep());
			bean.setName_dept(resDTO.getName_dep());
			bean.setDate_sch(resDTO.getD_sch());
			bean.setDayslottp(resDTO.getSd_dayslot());
			bean.setCode_srv(resDTO.getCode_srv());
			bean.setName_srv(resDTO.getName_scsrv());
			bean.setTotal(resDTO.getQuan_total());
			bean.setRemain(resDTO.getQuan_remain());
			bean.setCode_scca(resDTO.getCode_scca());
			bean.setSpeciality(resDTO.getSpeciality());
			result.add(bean);
		}
		MtSchListResultDTO mtSchListResultDTO = new MtSchListResultDTO();
		mtSchListResultDTO.setMtschlistdto(ArrayListUtil.ConvertToFArrayList(result));
		return mtSchListResultDTO;
	}

	/**
	 * 计算排班对应渠道剩余可预约数量
	 * 
	 * @param resDTOList
	 * @throws BizException
	 */
	private void calcSchChlRemainNew(List<MtSchResDTO> resDTOList) throws BizException {
		if (ListUtil.isEmpty(resDTOList)) {
			return;
		}
		String id_scchl = resDTOList.get(0).getId_scchl();
		List<String> schIdList = new ArrayList<String>();
		for (MtSchResDTO resDTO : resDTOList) {
			String schId = resDTO.getId_sch();
			if (!schIdList.contains(schId)) {
				schIdList.add(schId);
			}
		}

		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		Map<String, Map<Integer, Integer>> map = schOutQryService.batchGetChlSchRemainAmount(schIdList, id_scchl);
		if (null == map || map.isEmpty()) {
			return;
		}
		for (MtSchResDTO resDTO : resDTOList) {
			String key = resDTO.getId_sch();
			if (!map.containsKey(key) || null == map.get(key)) {
				continue;
			}
			resDTO.setQuan_remain(map.get(key).get(IScDictCodeConst.SC_CHL_REMAIN));
		}
	}

	/**
	 * 校验数据有效性
	 * 
	 * @param scDate
	 * @param idSrv
	 * @param oprCode
	 * @throws BizException
	 */
	private void validData(MtSchListParamDTO param) throws BizException {
		FDate date_b = param.getDate_b();
		FDate date_e = param.getDate_e();
		String id_srv = param.getId_srv();
		String code_opr = param.getCode_opr();
		if (null == date_b) {
			throw new BizException("查询医技排班列表失败:排班开始日期传入为空!");
		}
		if (null == date_e) {
			throw new BizException("查询医技排班列表失败:排班结束日期传入为空!");
		}
		if (StringUtil.isEmpty(id_srv)) {
			throw new BizException("查询医技排班列表失败:诊疗项目id传入为空!");
		}
		if (StringUtil.isEmpty(code_opr)) {
			throw new BizException("查询医技排班列表失败:操作员传入为空!");
		}
		id_srv = id_srv.replaceAll(".*([';]+|(--)+).*", "");
		code_opr = code_opr.replaceAll(".*([';]+|(--)+).*", "");
		if (StringUtil.isEmpty(id_srv.trim())) {
			throw new BizException("查询医技排班列表失败:诊疗项目id是非法字符!");
		}
		if (StringUtil.isEmpty(code_opr.trim())) {
			throw new BizException("查询医技排班列表失败:操作员是非法字符!");
		}
	}

}

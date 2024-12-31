package iih.ei.sc.s.bp.qry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.ws.bean.GetSchListBean;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.i.IScSchOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSchListBP {

	/**
	 * 取医技排班列表
	 * @param scDate 排班日期yyyy-MM-dd（为避免性能问题，只取一天的记录）
	 * @param idSrv 诊疗项目id
	 * @param chlType 渠道类型
	 * @return
	 * @throws BizException
	 */
	public GetSchListBean[] exec(String dateB,String dateE,String idSrv,String chlType,String oprCode) throws BizException {

		this.validData(dateB,dateE, idSrv, oprCode);
		//获取渠道id
		ISchedulechlMDORService rService = ServiceFinder.find(ISchedulechlMDORService.class);
		String id_org = Context.get().getOrgId();
		SchedulechlDO[] chlDOs = rService.find(String.format(" code = '%s' and id_org='%s' ",chlType,id_org), "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(chlDOs))
		{
			throw new BizException("查询医技排班列表失败:渠道编码:"+chlType+",未查询到渠道id");
		}
		String id_scchl = chlDOs[0].getId_scchl();

		IScBdQryService iscbdqryservice = ServiceFinder.find(IScBdQryService.class);
		TimeService ts = ServiceFinder.find(TimeService.class);
		FDate begin_date = ts.getUFDateTime().getDate().asLocalBegin();
		FDate end_date = iscbdqryservice.getChlMaxAptDateBP(id_scchl, IScDictCodeConst.SD_SCTP_MT);
		FBoolean isQry = FBoolean.FALSE;
		FDate begin_temp = StringUtil.isEmpty(dateB)?null:new FDate(dateB).asBegin();
		FDate end_temp = StringUtil.isEmpty(dateE)?null:new FDate(dateE).asEnd();
		FMap resultMap = this.handleBeginAndEndDate(begin_date, end_date, begin_temp, end_temp);
		isQry = new FBoolean(resultMap.get("isQry").toString());
		if (!isQry.booleanValue()) {
			return null;
		}
		begin_date = new FDate(resultMap.get("beginDate").toString());
		end_date = new FDate(resultMap.get("endDate").toString());
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append("'"+id_scchl+"' as id_scchl, ");
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
		sql.append(" pl.eu_timeslottp as Eu_timeslottp,");//类型
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
		params.addParam(begin_date.toString());
		params.addParam(end_date.toString());
		params.addParam(idSrv);
		List<MtResDTO> list = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params, new BeanListHandler(MtResDTO.class));

		// 计算渠道剩余可预约数
		this.calcSchChlRemainNew(list);
		if(ListUtil.isEmpty(list))
		{
			return null;
		}

		List<GetSchListBean> result = new ArrayList<GetSchListBean>();
		for (MtResDTO resDTO : list) {
			GetSchListBean bean = new GetSchListBean();
			bean.setIdSch(resDTO.getId_sch());
			bean.setResCode(resDTO.getCode_res());
			bean.setResName(resDTO.getName_res());
			bean.setDeptCode(resDTO.getId_dep());
			bean.setDeptName(resDTO.getName_dep());
			bean.setSchDate(resDTO.getD_sch().toStdString());
			bean.setDayslottp(resDTO.getSd_dayslot());
			bean.setCodeSrv(resDTO.getCode_srv());
			bean.setNameSrv(resDTO.getName_scsrv());
			bean.setTotal(resDTO.getQuan_total().toString());
			bean.setRemain(resDTO.getQuan_remain().toString());
			bean.setCodeScca(resDTO.getCode_scca());
			bean.setSpeciality(resDTO.getSpeciality());
			result.add(bean);
		}

		return result.toArray(new GetSchListBean[0]);
	}

	/**
	 * 计算排班对应渠道剩余可预约数量
	 * @param resDTOList
	 * @throws BizException
	 */
	private void calcSchChlRemainNew(List<MtResDTO> resDTOList) throws BizException
	{
		if (ListUtil.isEmpty(resDTOList)) {
			return;
		}
		String id_scchl = resDTOList.get(0).getId_scchl();
		List<String> schIdList = new ArrayList<String>();
		for (MtResDTO resDTO : resDTOList) {
			String schId = resDTO.getId_sch();
			if (!schIdList.contains(schId)) {
				schIdList.add(schId);
			}
		}

		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		Map<String,Map<Integer, Integer>> map = schOutQryService.batchGetChlSchRemainAmount(schIdList, id_scchl);
		if (null == map || map.isEmpty()) {
			return;
		}
		for (MtResDTO resDTO : resDTOList) {
			String key = resDTO.getId_sch();
			if (!map.containsKey(key) || null == map.get(key)) {
				continue;
			}
			resDTO.setQuan_remain(map.get(key).get(IScDictCodeConst.SC_CHL_REMAIN));
		}
	}

	/**
	 * 校验数据有效性
	 * @param scDate
	 * @param idSrv
	 * @param oprCode
	 * @throws BizException
	 */
	private void validData(String dateB,String dateE,String idSrv,String oprCode) throws BizException
	{
		if(StringUtil.isEmpty(dateB))
		{
			throw new BizException("查询医技排班列表失败:排班开始日期传入为空!");
		}
		if(StringUtil.isEmpty(dateE))
		{
			throw new BizException("查询医技排班列表失败:排班结束日期传入为空!");
		}
		if(StringUtil.isEmpty(idSrv))
		{
			throw new BizException("查询医技排班列表失败:诊疗项目id传入为空!");
		}
		if(StringUtil.isEmpty(oprCode))
		{
			throw new BizException("查询医技排班列表失败:操作员传入为空!");
		}
		dateB = dateB.replaceAll(".*([';]+|(--)+).*", "");
		dateE = dateE.replaceAll(".*([';]+|(--)+).*", "");
		idSrv = idSrv.replaceAll(".*([';]+|(--)+).*", "");
		oprCode = oprCode.replaceAll(".*([';]+|(--)+).*", "");
		if(StringUtil.isEmpty(dateB.trim()))
		{
			throw new BizException("查询医技排班列表失败:排班开始日期是非法字符!");
		}
		if(StringUtil.isEmpty(dateE.trim()))
		{
			throw new BizException("查询医技排班列表失败:排班结束日期是非法字符!");
		}
		if(StringUtil.isEmpty(idSrv.trim()))
		{
			throw new BizException("查询医技排班列表失败:诊疗项目id是非法字符!");
		}
		if(StringUtil.isEmpty(oprCode.trim()))
		{
			throw new BizException("查询医技排班列表失败:操作员是非法字符!");
		}
	}
	/**
	 * 处理查询排班的开始和结束时间
	 * @param begin 当前开始时间
	 * @param end 根据渠道期间计算的结束时间
	 * @param begin_temp 传入的开始时间
	 * @param end_temp 传入的结束时间
	 * @param isQry 是否查询排班
	 */
	private FMap handleBeginAndEndDate(FDate begin,FDate end,FDate begin_temp,FDate end_temp){
		FMap result = new FMap();
		FBoolean isQry = FBoolean.TRUE;
		result.put("beginDate", begin.toString());
		result.put("endDate", end.toString());
		//未维护期间日期则取结束时间为2100-01-01
		if(end == null){
			result.put("endDate", "2100-01-01");
		}

		if(end_temp.compareTo(begin)<0){
			isQry = FBoolean.FALSE;
		}else if(begin_temp.compareTo(end)>0){
			isQry = FBoolean.FALSE;
		}else{
			if(begin_temp.compareTo(begin)>=0 && begin.compareTo(end_temp)<=0){
				//begin = begin_temp;
				result.put("beginDate", begin_temp.toString());
			}
			if (begin_temp.compareTo(end)<=0 && end.compareTo(end_temp)>=0) {
				//end = end_temp;
				result.put("endDate", end_temp.toString());
			}
			isQry = FBoolean.TRUE;
		}
		result.put("isQry", isQry.toString());
		return result;

	}
}

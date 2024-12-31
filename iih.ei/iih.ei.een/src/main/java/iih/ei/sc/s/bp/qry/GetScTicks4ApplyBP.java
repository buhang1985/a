package iih.ei.sc.s.bp.qry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.ws.bean.GetScTicks4ApplyBean;
import iih.ei.sc.ws.bean.GetValidPeriodBean;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.i.IScAptQryService;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetScTicks4ApplyBP {
	/**
	 * 根据申请单号获取可以预约的号位
	 * @param code_apt
	 * @return
	 * @throws BizException
	 */
	public GetScTicks4ApplyBean[] exec(String id_aptappl,String d_sch,String chlType) throws BizException {
		return this.getScTicks4Apply(id_aptappl,d_sch,chlType);
	}
	/**
	 * 根据患者编码查询患者医技未预约申请单
	 * @param code_pat
	 * @return
	 * @throws BizException
	 */
	private GetScTicks4ApplyBean[] getScTicks4Apply(String id_aptappl,String d_sch,String chlType) throws BizException{
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO applDO = iscaptapplmdorservice.findById(id_aptappl);
		if(applDO == null){
			return null;
		}
		GetValidPeriodBean[] datebeans = new GetValidPeriodBP().exec(id_aptappl, chlType);
		MtAppQryDTO qry = new MtAppQryDTO();
		qry.setFg_autofilter(FBoolean.TRUE);
		qry.setId_dep(applDO.getId_dep_mp());
		if(!ArrayUtil.isEmpty(datebeans)){
			qry.setD_begin(new FDate(datebeans[0].getD_b()));
			qry.setD_end(new FDate(datebeans[0].getD_e()));
		}
		qry.setId_srv(applDO.getId_srv());
		qry.setId_entp(applDO.getId_entp());
		qry.setQrytype(0);// 3为手术
		qry.setId_scca(applDO.getId_scca());
		qry.setD_sch(new FDate(d_sch));
		MtResDTO[] schs = this.getCanAptSch(qry);
		if(ArrayUtil.isEmpty(schs)) return null;
		IScAptOutQryService iscaptqryservice = ServiceFinder.find(IScAptOutQryService.class);
		SchedulechlDO chlDO = this.getChlDO(chlType);
		FArrayList result = new FArrayList();
		String errorMsg = "";
		for (MtResDTO sch : schs) {
			try {
				FArrayList ticks = iscaptqryservice.getMtAptSchTicks8FilterForWeChat(sch.getId_sch(), applDO.getId_srv(), chlDO.getId_scchl(), applDO.getId_entp(), applDO.getId_pi(), applDO.getId_ent(), sch.getD_sch(), applDO.getFg_hp());
				result.addAll(ticks);
			} catch (Exception e) {
				errorMsg = e.getMessage();
			}
		}
		if(ListUtil.isEmpty(result)){
			if(!StringUtil.isEmpty(errorMsg)){
				throw new BizException(errorMsg);
			}
			return null;
		}
		return this.handleResult(result);
	}
	
	
	
	/**
	 * 结果转换
	 * @param tickList
	 * @return
	 */
	private GetScTicks4ApplyBean[] handleResult(FArrayList tickList){
		List<GetScTicks4ApplyBean> result = new ArrayList<GetScTicks4ApplyBean>();
		for (Object tick : tickList) {
			ScSchTickDO tickDO = (ScSchTickDO) tick;
			GetScTicks4ApplyBean bean = new GetScTicks4ApplyBean();
			bean.setId_tick(tickDO.getId_tick());
			bean.setId_org(tickDO.getId_org());
			bean.setId_sch(tickDO.getId_sch());
			bean.setQueno(tickDO.getQueno().toString());
			bean.setId_ticks(tickDO.getId_ticks());
			bean.setT_b(tickDO.getT_b().toString());
			bean.setT_e(tickDO.getT_e().toString());
			result.add(bean);
		}
		return result.toArray(new GetScTicks4ApplyBean[0]);
	}

	/**
	 * 查询医技排班信息
	 * 
	 * @param qryDTO 查询DTO
	 * @return
	 * @throws BizException
	 */
	public MtResDTO[] getCanAptSch(MtAppQryDTO qryDTO) throws BizException {
		if (null == qryDTO) {
			return null;
		}
		IScbdsrvMDORService iscbdsrvmdorservice = ServiceFinder.find(IScbdsrvMDORService.class);
		ScBdsrvDO[] scbdsrvdos = iscbdsrvmdorservice.find("id_srv ='"+qryDTO.getId_srv()+"'", null, FBoolean.FALSE);
		
		if (!ArrayUtil.isEmpty(scbdsrvdos)) {
			ScBdsrvDO scbdsrvdo = scbdsrvdos[0];
			qryDTO.setId_scca(scbdsrvdo.getId_scca());
		}else{
			throw new BizException("该服务未在医技排班医疗项目中!");
		}
		//排班当天可以预约的午别
		List<String> dayslotList = this.getDayslotList(qryDTO.getId_scca(), qryDTO.getId_dep(), IScDictCodeConst.SD_SCTP_MT);
		// 检查参数
		validateParam("id_dep", qryDTO.getId_dep());
		validateParam("d_begin", qryDTO.getD_begin());
		validateParam("d_end", qryDTO.getD_end());
		validateParam("id_entp", qryDTO.getId_entp());
		validateParam("d_sch", qryDTO.getD_sch());
		if(qryDTO.getD_begin().compareTo(qryDTO.getD_sch()) < 0 && qryDTO.getD_end().compareTo(qryDTO.getD_sch())>=0){
			qryDTO.setD_begin(qryDTO.getD_sch());
		}
		//ScValidator.validateParam("d_end", qryDTO.getD_end());
		if (qryDTO.getFg_autofilter().booleanValue()) {
			validateParam("id_srv", qryDTO.getId_srv());
		}
		// 查询数据
		List<MtResDTO> mtAptDTOs = this.queryDatas(qryDTO,dayslotList);
		if (ListUtil.isEmpty(mtAptDTOs)) {
			return null;
		}

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
	private List<MtResDTO> queryDatas(MtAppQryDTO qryDTO,List<String> dayslotList) throws BizException {
		boolean hasToday = !ListUtil.isEmpty(dayslotList);
		FDate now = this.getServerDate();
		if(qryDTO.getD_sch().compareTo(now) > 0){
			hasToday = false;
		}
		StringBuilder sql = this.getSql(hasToday,dayslotList);
		SqlParam params = new SqlParam();
		params.addParam(qryDTO.getId_dep());
		if (null != qryDTO.getQrytype() && qryDTO.getQrytype() == 3) {
			params.addParam(IScDictCodeConst.SD_SCTP_OT);// 手术
		} else {
			params.addParam(IScDictCodeConst.SD_SCTP_MT);// 医技
		}
		params.addParam(qryDTO.getD_begin());
		params.addParam(qryDTO.getId_entp());
		params.addParam(qryDTO.getId_srv());
		//params.addParam(qryDTO.getD_end());
		List<MtResDTO> mtAptDTOs = (List<MtResDTO>) new DAFacade().execQuery(sql.toString(), params,
				new BeanListHandler(MtResDTO.class));
		return this.duplicate(mtAptDTOs);
	}
	/**
	 * 去重
	 * @param mtAptDTOs
	 * @return
	 */
	private List<MtResDTO> duplicate(List<MtResDTO> mtAptDTOs){
		if(!ListUtil.isEmpty(mtAptDTOs)){
			List<MtResDTO> result = new ArrayList<MtResDTO>();
			Map<String,String> map = new HashMap<String,String>();
			for (MtResDTO mtResDTO : mtAptDTOs) {
				if(!map.containsKey(mtResDTO.getId_sch())){
					result.add(mtResDTO);
					map.put(mtResDTO.getId_sch(), mtResDTO.getId_sch());
				}
			}
			return result;
		}
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
	private StringBuilder getSql(boolean hasToday,List<String> dayslotList) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch ");
//		sb.append("res.id_mt,");
//		sb.append("pl.id_scpl,");
//		sb.append("pl.name as name_scpl,");
//		sb.append("pl.id_tickmd,");
//		sb.append("pl.sd_tickmd,");
//		sb.append("pl.id_dep,");
//		sb.append("pl.srvslot_min as srvlot_min,");
//		sb.append("pl.eu_timeslottp as Eu_timeslottp,");
//		sb.append("pl.level_pri,");
//		sb.append("sch.id_dayslot,");
//		sb.append("sch.quan_total,");
//		sb.append("sch.quan_total_appt,");
//		sb.append("sch.quan_total_used,");
//		sb.append("sch.fg_active,");
//		sb.append("sch.t_b_acpt,");
//		sb.append("sch.t_e_acpt,");
//		sb.append("sch.quan0_appt,");
//		sb.append("sch.quan1_appt,");
//		sb.append("sch.quan2_appt,");
//		sb.append("sch.quan3_appt,");
//		sb.append("sch.quan4_appt,");
//		sb.append("sch.quan5_appt,");
//		sb.append("sch.quan6_appt,");
//		sb.append("sch.quan7_appt,");
//		sb.append("sch.quan8_appt,");
//		sb.append("sch.quan9_appt,");
//		sb.append("sch.quan0_used,");
//		sb.append("sch.quan1_used,");
//		sb.append("sch.quan2_used,");
//		sb.append("sch.quan3_used,");
//		sb.append("sch.quan4_used,");
//		sb.append("sch.quan5_used,");
//		sb.append("sch.quan6_used,");
//		sb.append("sch.quan7_used,");
//		sb.append("sch.quan8_used,");
//		sb.append("sch.quan9_used ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join sc_srv_rel rel on pl.id_scsrv=rel.id_scsrv ");
		sb.append("left outer join sc_sch_en schen on sch.id_sch = schen.id_sch ");
		sb.append("inner join sc_res res on pl.id_scres=res.id_scres ");
		sb.append("where ");
		sb.append("pl.id_dep = ? ");
		//sb.append("and to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') < (sch.d_sch|| ' '||sch.t_e_acpt) ");
		sb.append("and pl.sd_sctp = ? ");
		String cond = buildIdStr(dayslotList);
		if(hasToday){
			sb.append("and (sch.d_sch = ? and sch.id_dayslot in (").append(cond).append(")) ");
		}else{
			sb.append("and sch.d_sch = ? ");
		}
		sb.append("and (INSTR(schen.id_entp, ?) > 0 or schen.id_entp is null) ");
		sb.append("and rel.id_mdsrv= ? ");
		sb.append("and sch.fg_active = 'Y' ");
		//sb.append("and sch.d_sch <= ? ");
		// 集团管控
		sb.append(" and " + ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch"));
		sb.append("order by sch.d_sch,sch.t_b_acpt desc ,sch.id_sch");
		return sb;
	}

	/**
	 * 获取当天可以预约的午别
	 * @param id_scca
	 * @param id_dep_mp
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 */
	public List<String> getDayslotList(String id_scca, String id_dep_mp,String sd_sctp) throws BizException {
		// 检查参数
		validateParam("id_scca", id_scca);
		validateParam("id_dep_mp", id_dep_mp);
		FDateTime now = getServerDateTime();
		List<String> dayslotList = new ArrayList<String>();
		IScAptQryService qry = ServiceFinder.find(IScAptQryService.class);
		ScdeptparamAggDO[] aggDOs = qry.getDeptParamList(id_dep_mp, sd_sctp);
		if(ArrayUtil.isEmpty(aggDOs)){
			throw new BizException("排班科室参数为空!");
		}
		for (ScdeptparamAggDO scdeptparamAggDO : aggDOs) {
			ScDeptParamDO deptParamDO = scdeptparamAggDO.getParentDO();
			if(id_scca.equals(deptParamDO.getId_scca())){
				ScDeptParamDsDO[] deptParamDs = scdeptparamAggDO.getScDeptParamDsDO();
				if(ArrayUtil.isEmpty(deptParamDs)){
					throw new BizException("排班科室参数为空");
				}
				for (ScDeptParamDsDO scDeptParamDsDO : deptParamDs) {
					FDate nowDate = now.getBeginDate();
					if(now.compareTo(new FDateTime(nowDate, scDeptParamDsDO.getT_end_reg())) < 0){
						dayslotList.add(scDeptParamDsDO.getId_dayslot());
					}
				}
				return dayslotList;
			}
		}
		return dayslotList;
	}
	/**
	 * 验证参数
	 * @param paramName 参数名
	 * @param paramValue 参数值
	 * @throws BizException
	 */
	private void validateParam(String paramName,Object paramValue) throws BizException{
		if(isNullOrEmpty(paramValue)){
			String msg = String.format("参数：%s为空", paramName);
			throw new BizException(msg);
		}
	}
	
	/**
	 * 是否为null或空
	 * @param paramValue
	 * @return
	 */
	private boolean isNullOrEmpty(Object paramValue){
		if(paramValue==null){
			return true;
		}
		//字符串
		if(String.class.isInstance(paramValue)){
			return paramValue.toString().trim().length()<=0;
		}
		//数组
		if(paramValue.getClass().isArray()){
			if(((Object[])paramValue).length<=0){
				return true;
			}
		}
		//FArrayList
		if(FArrayList.class.isInstance(paramValue)){
			if(((FArrayList)paramValue).size()<=0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 生成id的查询串
	 * 
	 * @param idList id集合
	 * @return
	 */
	private String buildIdStr(List<String> idList) {
		if (ListUtil.isEmpty(idList)) {
			return null;
		}

		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : idList) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", id));
		}

		return builder.toString();
	}
	
	/***
	 * 获得服务器日期时间
	 * 
	 * @return
	 */
	private FDateTime getServerDateTime() {
		TimeService ts = ServiceFinder.find(TimeService.class);
		return ts.getUFDateTime();
	}
	/**
	 * 根据渠道编码获取渠道信息
	 * @param chlType
	 * @return
	 * @throws BizException 
	 */
	private SchedulechlDO getChlDO(String chlType) throws BizException{
		if (StringUtil.isEmptyWithTrim(chlType)) {
			return null;
		}
		IScAptQryService iscaptqryservice = ServiceFinder.find(IScAptQryService.class);
		SchedulechlDO[] schedulechldos = iscaptqryservice.valAptHaveChannel(chlType);
		if(ArrayUtil.isEmpty(schedulechldos)){
			return null;
		}
		SchedulechlDO chlDO = schedulechldos[0];
		return chlDO;
	}
	
	/***
	 * 获得服务器日期
	 * 
	 * @return
	 */
	private FDate getServerDate() {
		TimeService ts = ServiceFinder.find(TimeService.class);
		return new FDate (ts.getUFDateTime().toLocalString());
	}
}

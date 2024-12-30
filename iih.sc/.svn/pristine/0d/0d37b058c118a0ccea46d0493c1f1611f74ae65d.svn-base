package iih.sc.sch.s.task.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊排班关闭渠道任务BP
 * 
 * @author yaohl
 * @date 2019年2月26日 10:43:20
 *
 */
public class CloseSchChlBP {

	/**
	 * 任务执行
	 * 
	 * @author yhl
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {

		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));

		// 排班和主号源关联Map
		Map<String, Integer> schMajMap = new HashMap<String, Integer>();
		// 排班主键列表
		List<String> schIdsList = new ArrayList<String>();
		
		//排班类型  -- 查询日历用
		String sd_sctp = null;
		// 1、获取回收天数参数   Tip(最大关闭天数)
		int recycleDays = ScParamUtils.getOpTickRecycleDays();

		// 2、查询排班和主号源池数据
		FArrayList schList = this.querySch(recycleDays);
		if (null == schList || schList.isEmpty()) {
			return;
		}
		
		// 3、处理排班数据
		sd_sctp = this.processSchDatas(schList, schMajMap, schIdsList);
        // 循环排班ID
		for (String id_sch : schIdsList) {
			
			// 4.查询渠道期间  相关数据，过滤出应该被关闭的渠道
		    List<String> idChls = this.filterChl(id_sch,sd_sctp);

			if(!ListUtil.isEmpty(idChls) && idChls.size() > 0 ){
				 // 查主号源池渠道集合
			    Integer MainPolcn = schMajMap.get(id_sch);//主号源池
			    String sqlMain = "select id_scchl from sc_sch_chl where id_sch = ? and scpolcn = ?";
				SqlParam paramMain = new SqlParam();
				paramMain.addParam(id_sch);
				paramMain.addParam(MainPolcn);
				List<String> id_schchl_mains = ( List<String>)new DAFacade().execQuery(sqlMain, paramMain, new ColumnListHandler());
				//如果id_sch_chls 为空，说明主号源池中所有渠道都将关闭  此时则不关闭主号源池的渠道
				if(!ListUtil.isEmpty(id_schchl_mains)&& idChls.containsAll(id_schchl_mains)){
					idChls.removeAll(id_schchl_mains);
				}
		    // 5.关闭渠道
				this.updateSchChl(id_sch,idChls);
			}else{
				continue;
			}
			// 6.需关闭的号源池渠道是否为空
			List<Integer> scpolcns = this.getScpolcn(id_sch);
			// 需要减去渠道 和 号位中的渠道
			List<String> IdScchlsTemp = new ArrayList<String>();
			IdScchlsTemp.addAll(idChls);
			if(scpolcns != null && scpolcns.size() >0 ){
				//从idChls中剔除 号源池为scpolcns的渠道
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < scpolcns.size(); i++) {
					if(i == scpolcns.size()-1){
						sb.append(scpolcns.get(i).toString());
					}else{
						sb.append(scpolcns.get(i).toString()+",");
					}
				}
				
				String sql = "select id_scchl from sc_sch_chl where id_sch = ? and scpolcn  in ("+sb.toString()+")";
				SqlParam param = new SqlParam();
				param.addParam(id_sch);
				List<String> reduceIdScchls = ( List<String>)new DAFacade().execQuery(sql, param, new ColumnListHandler());
				IdScchlsTemp.removeAll(reduceIdScchls);
				
				for (Integer polcn : scpolcns) {
					//7.1 更新排班主号源池
					this.updateMpolcnSch(id_sch,polcn,schMajMap);
					//7.2 更新关闭的号源池
					this.updateClosePolcnSch(id_sch,polcn);
					//7.3 更新号位  -- 清除号位中渠道  和号源池
					this.updateTick(id_sch,polcn);
				}
			}else{
				IdScchlsTemp = idChls;
			}
			if(!ListUtil.isEmpty(IdScchlsTemp) ){
				
				// 8. 剔除排班渠道中渠道
				this.updateScSchChl(id_sch,IdScchlsTemp);
				// 9. 剔除号位表中的渠道
				this.updateTickTwo(id_sch, IdScchlsTemp);
			}
		}
	}
	/**
	 * 更新号位
	 * @param id_sch 排班id
	 * @param idChls 关闭的渠道id
	 * @throws BizException 
	 */
	private void updateTickTwo(String id_sch, List<String> idChls) throws BizException{
		DAFacade dafacade = new DAFacade();
		String inSqlByIds = ScSqlUtils.getInSqlByIds(ScSchChlDO.ID_SCCHL,idChls);
		ISctickRService sctickRService = ServiceFinder.find(ISctickRService.class);
	    StringBuilder qrySql = new StringBuilder();
	    qrySql.append("select id_tick from sc_tick where id_sch = '");
	    qrySql.append(id_sch);
	    qrySql.append("' ");
	    List<String> idTickDos = ( List<String>)dafacade.execQuery(qrySql.toString(), new ColumnListHandler());
	    
	    StringBuffer sql = new StringBuffer();
	    String condition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_TICK, idTickDos);
		sql.delete(0, sql.length());
		//释放指定渠道
		for (String id_scchl : idChls) {
			sql.delete(0, sql.length());
			sql.append(" update sc_tick set ids_scchl = replace(ids_scchl,'")
			.append(id_scchl).append("','') where ")
			.append(condition);
			dafacade.execUpdate(sql.toString());
			sql.delete(0, sql.length());
			//将,,替换为''
			sql.append(" update sc_tick set ids_scchl = replace(ids_scchl,',,',',') where ")
			.append(condition);
			dafacade.execUpdate(sql.toString());
			sql.delete(0, sql.length());
			//将首位字符为,的替换为''
			sql.append(" update sc_tick set ids_scchl =substr(ids_scchl,2,length(ids_kinditm)-1)  where substr(ids_kinditm,0,1)=',' and ")
			.append(condition);
			dafacade.execUpdate(sql.toString());
			sql.delete(0, sql.length());
			//将末位字符为,的替换为''
			sql.append(" update sc_tick set ids_scchl =substr(ids_scchl,1,length(ids_kinditm)-1)  where substr(ids_kinditm,length(ids_kinditm),1)=',' and ")
			.append(condition);
			dafacade.execUpdate(sql.toString());
		}
		//将号位中渠道为null的，号源池更新为null
		if(StringUtil.isEmpty(id_sch)){
			SqlParam param = new SqlParam();
			sql.delete(0, sql.length());
			sql.append(" update sc_tick set polno = null where id_sch = ? and ids_scchl is null");
			param.addParam(id_sch);
			dafacade.execUpdate(sql.toString(),param);
		}
	}
	
	/**
	 * 多渠道情况 清除排班渠道中渠道
	 * @param id_sch
	 * @param idChls 
	 * @throws DAException 
	 */
	private void updateScSchChl(String id_sch,List<String> idChls) throws DAException{
		StringBuilder updateSchChl = new StringBuilder();
		String condition = ScSqlUtils.getInSqlByIds(" and id_scchl",idChls);
		updateSchChl.append("update sc_sch_chl set id_scchl = '' where id_sch = ? ");
		updateSchChl.append(condition);
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		new DAFacade().execUpdate(updateSchChl.toString(),param);
	}
	/**
	 * 更新主号源池
	 * 
	 * @param id_sch 排班id
	 * @param polcn  需要更新的号源池
	 * @param schMajMap 排班id和主号源池集合 
	 * @throws DAException 
	 */
	private void updateMpolcnSch(String id_sch,Integer polcn,Map<String, Integer> schMajMap) throws DAException{
		Integer MainPolcn = schMajMap.get(id_sch);//主号源池
		String QuanUsed_appt = String.format("Quan%s_appt", polcn);
		String QuanUesd_used = String.format("Quan%s_used", polcn);
		String QuanMain_appt = String.format("Quan%s_appt", MainPolcn);
		StringBuilder updateSql = new StringBuilder();
		updateSql.append("update sc_sch set ");
		updateSql.append(QuanMain_appt);
		updateSql.append(" = ");
		updateSql.append(QuanMain_appt);
		updateSql.append(" + ");
		updateSql.append(QuanUsed_appt);
		updateSql.append(" - ");
		updateSql.append(QuanUesd_used);
		updateSql.append(" where id_sch = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		new DAFacade().execUpdate(updateSql.toString(),param);
	}
	/**
	 * 更新删除的号源池
	 * @param id_sch 排班id
	 * @param polcn  需要更新的号源池
	 * @throws DAException 
	 */
	private void updateClosePolcnSch(String id_sch,Integer polcn) throws DAException{
		String QuanUsed_appt = String.format("Quan%s_appt", polcn);
		String QuanUesd_used = String.format("Quan%s_used", polcn);
		StringBuilder updateSql = new StringBuilder();
		updateSql.append("update sc_sch set ")
		.append(QuanUsed_appt)
		.append("=")
		.append(QuanUesd_used)
		.append(" where id_sch = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		new DAFacade().execUpdate(updateSql.toString(),param);
	}
	/**
	 * 更新号位
	 * @param id_sch 排班id
	 * @param polcn  需要更新的号源池
	 * @author ylh
	 * @throws DAException 
	 * 
	 */
	private void updateTick(String id_sch,Integer polcn) throws DAException{
		SqlParam param = new SqlParam();
		param.addParam(id_sch);
		param.addParam(polcn);
		String updateTick = "update sc_tick set ids_scchl = null , polno = null where id_sch = ? and polno = ?";
		new DAFacade().execUpdate(updateTick,param);
	}
	
	
	
	/**
	 * 处理排班数据
	 *
	 * @param schList 排班主号源池数据列表
	 * @param schMajMap 排班与主号源池的对应Map
	 * @param schIdsList 排班主键列表
	 * @throws BizException
	 * @author yhl
	 */
	@SuppressWarnings("unchecked")
	private String processSchDatas(FArrayList schList, Map<String, Integer> schMajMap, List<String> schIdsList)
			throws BizException {
		String sd_sctp = null;
		for (int i = 0; i < schList.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) schList.get(i);
			String schId = map.get("id_sch").toString();
			sd_sctp = map.get("sd_sctp").toString();
			Integer polnoMaj = 0;
			if (null != map.get("polno_maj")) {
				polnoMaj = Integer.parseInt(map.get("polno_maj").toString());
			}
			schMajMap.put(schId, polnoMaj);
			schIdsList.add(schId);
		}
		return sd_sctp;
	}
	/**
	 * 获取号源池号
	 * @param idChls 没有开放号源池渠道id
	 * @author yhl
	 * @return
	 * @throws DAException 
	 */
	public List<Integer> getScpolcn(String id_sch) throws DAException{
		
		
		//获取所有的号源池
		String sb = "select distinct scpolcn from sc_sch_chl where id_sch = '"+id_sch+"' ";
		List<Integer> scpolcnSum = (List<Integer>) new DAFacade().execQuery(sb.toString(), new ColumnListHandler());
		//获取开放的号源池号
		String sbb = "select distinct scpolcn from sc_sch_chl where id_sch = '"+id_sch+"' and fg_active = 'Y'";
		List<Integer> scpolcnUse = (List<Integer>) new DAFacade().execQuery(sbb, new ColumnListHandler());
		
		if(scpolcnSum.size() > scpolcnUse.size()){
			//获取不开放的号源池
			scpolcnSum.removeAll(scpolcnUse);
			return scpolcnSum;
		}else{
			return null;
		}
		
	}
	
	/**
	 * 更新渠道  设置渠道fg_active = false
	 * @author yhl
	 * @param idChls 更新的渠道 sc_sch_chl.fg_active = false
	 * @throws DAException 
	 */
	private void updateSchChl(String id_sch,List<String> idChls ) throws DAException{
		for (String id_schchl : idChls) {
			StringBuilder updateScchl = new StringBuilder();
			updateScchl.append("update sc_sch_chl set fg_active = 'N' where id_sch = ? and id_scchl = ? ");
			SqlParam param = new SqlParam();
			param.addParam(id_sch);
			param.addParam(id_schchl);
			DAFacade dafacade = new DAFacade();
			dafacade.execUpdate(updateScchl.toString(),param);
		}	
	}
	/**
	 * 校验需要关闭的渠道 
	 * @author yhl
	 * @param id_sch 排班id
	 * @param sd_sctp 排班分类编码
	 * @return 需要关闭的渠道id
	 * @throws BizException
	 */
	private List<String> filterChl(String id_sch,String sd_sctp) throws BizException{
		List<String> closeIdChls = new ArrayList<String>();//需要关闭的渠道id集合
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ");
		sb.append("chl.id_scchl, ");
		sb.append("prd.fg_holiday_excl, ");
		sb.append("prd.sd_period_tp, ");
		sb.append("prd.num_day, ");
		sb.append("prd.num_hour ");
		sb.append("from sc_sch_chl chl ");
		sb.append("inner join sc_chl_period prd on chl.id_scchl =  prd.id_scchl ");
		sb.append("where prd.sd_sctp = '01' and chl.id_sch = '"+id_sch+"'");
		FArrayList list = AppFwUtil.getMapListWithDao(sb.toString());		
		if(ListUtil.isEmpty(list))return null;
		//获取档期排班日期
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO scSchDO = schRService.findById(id_sch);
		FDate d_sch = scSchDO.getD_sch().asBegin();//排班日期
		FTime t_b_acpt = scSchDO.getT_b_acpt();//开始就诊时间
		FDateTime now = ScAppUtils.getServerDateTime();//当前时间
		FDate d_today = now.getBeginDate();//当前日期
		
		FDateTime d_schh = new FDateTime(d_sch, new FTime("00:00:00"));
		FDateTime t_b_acptt = new FDateTime(d_sch,t_b_acpt);
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> chlMap = (Map<String, Object>) list.get(i);
			String id_scchl = chlMap.get("id_scchl").toString();
			String sd_period_tp = chlMap.get("sd_period_tp").toString();
			String fg_holiday_excl = chlMap.get("fg_holiday_excl").toString();
			Integer num_day = (Integer) chlMap.get("num_day");
			Integer num_hour = (Integer) chlMap.get("num_hour");
			if(num_day == null || num_day == -1){
				continue;
			}else if(IScDictCodeConst.SD_PERIOD_TP_FIX.equals(sd_period_tp)){//固定时间点释放
				if(IScDictCodeConst.FG_HOLIDAY_EXCL_TRUE.equals(fg_holiday_excl)){//是否计算节假日
					FDateTime dt_time_point = this.getDateExclHoliday(now,num_day,num_hour,IScDictCodeConst.SD_PERIOD_TP_FIX, sd_sctp);
					if(d_schh.compareTo(dt_time_point) <= 0){
						closeIdChls.add(id_scchl);
					}
				}else if(d_sch.compareTo(d_today) >=0 && d_schh.getDateTimeBefore(num_day).addSeconds(num_hour*60*60).compareTo(now) <= 0){
					closeIdChls.add(id_scchl);
				}
			}else if(IScDictCodeConst.SD_PERIOD_TP_REF_OPT.equals(sd_period_tp)){//相对开始时间释放
				if(IScDictCodeConst.FG_HOLIDAY_EXCL_TRUE.equals(fg_holiday_excl)){//是否计算节假日
					FDateTime dt_time_point = this.getDateExclHoliday(now,num_day,num_hour,IScDictCodeConst.SD_PERIOD_TP_REF_OPT, sd_sctp);
					if(t_b_acptt.compareTo(dt_time_point) <= 0){
						closeIdChls.add(id_scchl);
					}
				}else if(d_sch.compareTo(d_today) >=0 && t_b_acptt.addSeconds((num_day*24*60*60+num_hour*60*60)*-1).compareTo(now) <= 0 ){
					closeIdChls.add(id_scchl);
				}
			}
		}
		return closeIdChls;
	}
	


	/**
	 * 查询排班和主号源池
	 *
	 * @author zhengcm
	 * 
	 * @param recycleDays 号源回收天数
	 * @return 排班与主号源池数据
	 * @throws BizException
	 */
	private FArrayList querySch(int recycleDays) throws BizException {
		    // 开始日期
			String dt_begin = ScAppUtils.getServerDate().toString();
			// 结束日期
			String dt_end = ScAppUtils.getDateAfter(dt_begin, recycleDays);
			// 查询SQL
			StringBuilder sb = new StringBuilder();
			sb.append(" select distinct ");
			sb.append(" sch.id_sch, ");
			sb.append(" sch.sd_sctp, ");
			sb.append(" param.polno_maj ");
			sb.append(" from ");
			sb.append(" sc_sch sch ");
			sb.append(" inner join sc_pl pl on sch.id_scpl = pl.id_scpl ");
			sb.append(" inner join sc_dep_param param on pl.id_dep = param.id_dep ");
			sb.append(" where ");
			sb.append(" sch.d_sch >= '" + dt_begin + "' ");
			sb.append(" and sch.d_sch < '" + dt_end + "' ");
			sb.append(" and sch.sd_sctp = '" + IScDictCodeConst.SD_SCTP_OP + "' ");
			String idDepOrals = ScParamUtils.getParamOral();
			if(!StringUtil.isEmpty(idDepOrals)){
				String[] idDepArr = idDepOrals.split(idDepOrals);
				String cond = ScSqlUtils.getInSqlByIds( " and  pl.id_dep not", idDepArr);
				sb.append(cond);
			}
			// 查询
			FArrayList list = AppFwUtil.getMapListWithDao(sb.toString());
			return list;
	}
	/**
	 * 获取排除节假日后的日期
	 * @param now
	 * @param num_day
	 * @param num_hour
	 * @param time_type
	 * @return
	 * @throws BizException 
	 */
	private FDateTime getDateExclHoliday(FDateTime now, int num_day, int num_hour, String time_type,
			String sd_sctp) throws BizException {
		WorkCalendDateDO[] workCaleDatesIncrease = this.getWorkCalendDate(now, sd_sctp,true);
		WorkCalendDateDO[] workCaleDatesDecrease = this.getWorkCalendDate(now, sd_sctp,false);
		switch (time_type) {
		case IScDictCodeConst.SD_PERIOD_TP_FIX:
			int hour = now.getHour();
			num_day = hour >= num_hour ? num_day : num_day - 1;
			for (int i = 0; i <= num_day; i++) {
				if (i == 0) {
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				} else {
					now = now.getDateTimeAfter(1);
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				}
			}
			break;
		case IScDictCodeConst.SD_PERIOD_TP_REF_OPT:
			for (int i = 0; i <= num_day; i++) {
				if (i == 0) {
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				} else {
					now = now.getDateTimeAfter(1);
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				}
			}
			now = this.filterHoliday(now.addSeconds(num_hour * 60 * 60), workCaleDatesIncrease,true);
			break;

		default:
			break;
		}
		return now;
	}
	/**
	 * 获取工作日历日期信息
	 * @param scaptrlsruledo
	 * @return
	 * @throws BizException 
	 * @author yzh
	 */
	private WorkCalendDateDO[] getWorkCalendDate(FDateTime dt,String sd_sctp,boolean isIncrease) throws BizException{
		ISchedulecaRService ischedulecarservice = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] sccas = ischedulecarservice.find("id_sctp='"+sd_sctp+"'", null, FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(sccas)) {
			// 获取工作日历   
			IWorkCalendDateDORService iworkcalenddatedorservice = ServiceFinder.find(IWorkCalendDateDORService.class);
			String id_cal = sccas[0].getId_cal();
			String sql = this.getSql(dt, id_cal,isIncrease);
			WorkCalendDateDO[] workCaleDates = iworkcalenddatedorservice.find(sql, WorkCalendDateDO.CALENDARDATE, FBoolean.FALSE);
			return workCaleDates;
		}
		return null;
	}
	
	private String getSql(FDateTime dt,String id_cal,boolean isIncrease){
		StringBuffer sql = new StringBuffer();
		sql.append("id_workcalendar='")
		.append(id_cal).append("'");
		if (isIncrease) {
			sql.append(" and calendardate>='")
			.append(dt.getDate().toLocalString())
			.append("' and calendardate <='")
			.append(dt.getDateTimeAfter(30).getDate().toLocalString())
			.append("'");
		}else{
			sql.append(" and calendardate>='")
			.append(dt.getDateTimeBefore(30).getDate().toLocalString())
			.append("' and calendardate <='")
			.append(dt.getDate().toLocalString())
			.append("'");
		}
		return sql.toString();
	}
	/**
	 * 判断一个日期是否节假日 是的话顺延
	 * @param dt
	 * @param workCaleDates
	 * @return
	 */
	private FDateTime filterHoliday(FDateTime dt, WorkCalendDateDO[] workCaleDates,boolean isIncrease ) {
		if (!ArrayUtil.isEmpty(workCaleDates)) {
			FDate dt_point = dt.getBeginDate();
			if(isIncrease){
				for (int i = 0; i < workCaleDates.length; i++) {
					WorkCalendDateDO workCalendDateDO = workCaleDates[i];
					FDate workDate = workCalendDateDO.getCalendardate().asBegin();
					if (dt_point.compareTo(workDate) == 0) {
						if (workCalendDateDO.getDateworktype() == 0) {
							return new FDateTime(workDate, dt.getUFTime());
						} else {
							if (i + 1 < workCaleDates.length) {
								dt_point = workCaleDates[i + 1].getCalendardate().asBegin();
							} else {
								return new FDateTime(workDate, dt.getUFTime());
							}
						}
					}
				}
			}else{
				for (int i = workCaleDates.length; i < 0; i--) {
					WorkCalendDateDO workCalendDateDO = workCaleDates[i];
					FDate workDate = workCalendDateDO.getCalendardate().asBegin();
					if (dt_point.compareTo(workDate) == 0) {
						if (workCalendDateDO.getDateworktype() == 0) {
							return new FDateTime(workDate, dt.getUFTime());
						} else {
							if (i - 1 >= 0) {
								dt_point = workCaleDates[i - 1].getCalendardate().asBegin();
							} else {
								return new FDateTime(workDate, dt.getUFTime());
							}
						}
					}
				}
			}
		}
		return dt;
	}
}

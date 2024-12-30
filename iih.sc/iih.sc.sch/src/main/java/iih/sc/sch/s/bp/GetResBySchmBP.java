package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.comm.FBooleanUtils;
import iih.sc.comm.IScConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.IntegerUtils;
import iih.sc.comm.ProcResBP;
import iih.sc.comm.ProcSuggResBp;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import iih.sc.sch.scsch.d.desc.ScSchDODesc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据查询模板查询资源
 * 
 * @author yank
 */
public class GetResBySchmBP {
	/**
	 * 根据查询模板查询资源
	 * 
	 * @param qryScheme 查询模板
	 * @return
	 * @throws BizException
	 */
	public RegResDTO[] exec(ResQrySchemeDTO qryScheme) throws BizException {
		this.validate(qryScheme);
		
		//默认加载号源，TODO 所有改完后，DELETE
		if(qryScheme.getFg_quan()==null){
			qryScheme.setFg_quan(FBoolean.TRUE);
		}
		if(ScValidator.isEmptyIgnoreBlank(qryScheme.getSd_sctp())){
			qryScheme.setSd_sctp(IScDictCodeConst.SD_SCTP_OP);
		}
		
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		
		// 取指定行数
		if (IntegerUtils.isMoreThanZero(qryScheme.getRows())) {
			sqlBuilder.append("SELECT TOP ").append(qryScheme.getRows()).append(" * FROM (");
		}
		// 1、查询SQL
		this.initSql(sqlBuilder, qryScheme);

		// 2、添加查询条件
		this.addFilter(sqlBuilder, param, qryScheme);

		// 3、添加排序
		this.addOrder(sqlBuilder,qryScheme);

		//取指定行数结束
		if (IntegerUtils.isMoreThanZero(qryScheme.getRows())) {
			sqlBuilder.append(") ");
		}

		//4、执行查询
		@SuppressWarnings("unchecked")
		List<RegResDTO> resList = (List<RegResDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(RegResDTO.class));

		//5、结果处理
		if (!ListUtil.isEmpty(resList)) {
			for(RegResDTO res : resList){
				res.setT_acpt(res.getT_b_acpt().substring(0, 5) + "-" + res.getT_e_acpt().substring(0, 5));
			}
			// 推荐号源判断
			if(FBoolean.TRUE.equals(qryScheme.getFg_suggest())){
				return new ProcSuggResBp().exec(resList, false);
			}
			return new ProcResBP().exec(resList, false);
		}
		return null;
	}
	/**
	 * 验证参数
	 * @param qryScheme
	 * @throws BizException
	 */
	private void validate(ResQrySchemeDTO qryScheme) throws BizException{
		ScValidator.validateParam("查询模板", qryScheme);
		if(FBoolean.FALSE.equals(qryScheme.getFg_reg())){
			ScValidator.validateParam("渠道ID", qryScheme.getId_scchl());
		}
	}
	/**
	 * 获取查询SQL
	 * 
	 * @throws BizException
	 */
	private void initSql(StringBuilder sqlBuilder,ResQrySchemeDTO qryScheme) throws BizException {
		sqlBuilder.append("SELECT SCH.ID_SCH,SCH.D_SCH,");
		sqlBuilder.append("SCH.T_E_REG,");//停止挂号时间
		sqlBuilder.append("SCH.T_B_ACPT,");//接诊开始时间
		sqlBuilder.append("SCH.T_E_ACPT,");//接诊结束时间
		sqlBuilder.append("PL.ID_SCPL,PL.NAME AS NAME_SCPL,");
		sqlBuilder.append("PL.SD_TICKMD,PL.ID_DEP,DEP.NAME AS NAME_DEP,PL.PYCODE,");
		sqlBuilder.append("SCH.ID_DAYSLOT,LOT.NAME AS NAME_DAYSLOT,");
		sqlBuilder.append("SRV.ID_SCSRV,SRV.NAME AS NAME_SCSRV,SRV.SD_SRVTP,SRV.ID_SRVTP,");//排班服务
		sqlBuilder.append("RES.ID_SCRES,RES.NAME AS NAME_SCRES,RES.ID_EMP,RES.DES AS SCRES_DES,");//排班资源
		if(FBoolean.TRUE.equals(qryScheme.getFg_quan())){
			if(FBooleanUtils.isNullOrFalse(qryScheme.getFg_reg())){
				//预约
				sqlBuilder.append("CHL.ID_SCCHL,");//渠道
				sqlBuilder.append("CHL.SCPOLCN AS POLCN,");//号源池			
				sqlBuilder.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_APPT,0) WHEN 1 THEN NVL(SCH.QUAN1_APPT,0) WHEN 2 THEN NVL(SCH.QUAN2_APPT,0) WHEN 3 THEN NVL(SCH.QUAN3_APPT,0) WHEN 4 THEN NVL(SCH.QUAN4_APPT,0) WHEN 5 THEN NVL(SCH.QUAN5_APPT,0) WHEN 6 THEN NVL(SCH.QUAN6_APPT,0) WHEN 7 THEN NVL(SCH.QUAN7_APPT,0) WHEN 8 THEN NVL(SCH.QUAN8_APPT,0) WHEN 9 THEN NVL(SCH.QUAN9_APPT,0) ELSE NVL(QUAN_TOTAL_APPT，0)  END AS TOTAL,");
				sqlBuilder.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_USED,0) WHEN 1 THEN NVL(SCH.QUAN1_USED,0) WHEN 2 THEN NVL(SCH.QUAN2_USED,0) WHEN 3 THEN NVL(SCH.QUAN3_USED,0) WHEN 4 THEN NVL(SCH.QUAN4_USED,0) WHEN 5 THEN NVL(SCH.QUAN5_USED,0) WHEN 6 THEN NVL(SCH.QUAN6_USED,0) WHEN 7 THEN NVL(SCH.QUAN7_USED,0) WHEN 8 THEN NVL(SCH.QUAN8_USED,0) WHEN 9 THEN NVL(SCH.QUAN9_USED,0) ELSE NVL(QUAN_TOTAL_USED，0)  END AS USED,");
			}else{
				//挂号为0号源池
				sqlBuilder.append("0 AS POLCN,");
				sqlBuilder.append("SCH.QUAN0_APPT AS TOTAL,");
				sqlBuilder.append("NVL(SCH.QUAN0_USED,0) AS USED,");
			}
		}
		sqlBuilder.append("ISNULL(SCH.FG_ACTIVE,'N') AS FG_ACTIVE,");
		sqlBuilder.append("NVL(SCH.ADDQUECN,0) AS ADDQUAN, ");// 加号数量
		sqlBuilder.append("NVL(SCH.MAX_NUM_ADD,0) AS MAX_NUM_ADD ");// 最大可加号数
		sqlBuilder.append(" FROM SC_SCH SCH ");
		sqlBuilder.append(" INNER JOIN SC_PL PL ON SCH.ID_SCPL = PL.ID_SCPL ");
		if(FBooleanUtils.isNullOrFalse(qryScheme.getFg_reg())){
			sqlBuilder.append("INNER JOIN SC_SCH_CHL CHL ON SCH.ID_SCH = CHL.ID_SCH ");
		}
		sqlBuilder.append(" INNER JOIN SC_SRV SRV ON PL.ID_SCSRV=SRV.ID_SCSRV ");
		sqlBuilder.append(" INNER JOIN SC_RES RES  ON PL.ID_SCRES=RES.ID_SCRES ");
		sqlBuilder.append(" LEFT JOIN BD_DEP DEP ON PL.ID_DEP=DEP.ID_DEP ");
		sqlBuilder.append(" LEFT JOIN  BD_DAYSLOT LOT ON LOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
	}

	/**
	 * 添加过滤条件
	 * 
	 * @param sqlBuilder SQL
	 * @param param 参数
	 * @param qryScheme 查询模板
	 * @throws BizException
	 */
	private void addFilter(StringBuilder sqlBuilder, SqlParam param,ResQrySchemeDTO qryScheme) throws BizException {
		sqlBuilder.append(" WHERE 1=1 ");
		sqlBuilder.append(" AND ").append(ScGroupControlUtils.getGroupControlFitler(new ScSchDODesc(), "SCH"));
		// 排班类型，默认为门诊
		if(!StringUtil.isEmpty(qryScheme.getSd_sctp())){
			sqlBuilder.append(" AND PL.SD_SCTP=? ");
			param.addParam(qryScheme.getSd_sctp());
		}
		//加载号源时，增加渠道过滤条件
		if(FBoolean.TRUE.equals(qryScheme.getFg_quan())){
			this.addChlFilter(qryScheme, sqlBuilder, param);
		}
		
		// 添加排班分类条件
		this.addDayslotCaFilter(qryScheme.getSd_sctp(),sqlBuilder, param);
		
		// 添加日期时间条件（含午别）
		this.addDateTimeFilter(qryScheme, sqlBuilder, param);

		// 科室
		if (qryScheme.getIds_dep() != null) {
			String depIdsStr = ScSqlUtils.arrayToStr(qryScheme.getIds_dep());
			if (depIdsStr.contains(IScConst.SC_OP_REG_OF_ALL_DEPT)) {
				// % 代表全部科室
			} else {
				sqlBuilder.append(" AND PL.ID_DEP IN (" + depIdsStr + ")");
			}
		}

		// 指定人员的资源
		if (!ScCollectionUtils.isNullOrEmpty(qryScheme.getIds_emp())) {
			sqlBuilder.append(" AND RES.SD_SCRESTP=?");
			param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
			sqlBuilder.append(" AND RES.ID_EMP IN (" + ScSqlUtils.arrayToStr(qryScheme.getIds_emp()) + ") ");
		}
		// 排班
		if (!ScCollectionUtils.isNullOrEmpty(qryScheme.getIds_sch())) {
			String ids = ScSqlUtils.arrayToStr(qryScheme.getIds_sch());
			sqlBuilder.append(" AND SCH.ID_SCH IN (" + ids + ") ");
		}
		// 排班计划
		if (qryScheme.getId_pl() != null) {
			sqlBuilder.append(" AND PL.ID_SCPL =?");
			param.addParam(qryScheme.getId_pl());
		}
		// 号别
		if (!ScCollectionUtils.isNullOrEmpty(qryScheme.getIds_scsrv())) {
			sqlBuilder.append(" AND PL.ID_SCSRV IN (" + ScSqlUtils.arrayToStr(qryScheme.getIds_scsrv()) + ") ");
		}
		// 是否过滤无剩余号源资源及停诊
		if (FBoolean.TRUE.equals(qryScheme.getFg_remain())) {
			sqlBuilder.append(" AND (SCH.QUAN_TOTAL_APPT-NVL(SCH.QUAN_TOTAL_USED,0))>0");
			sqlBuilder.append(" AND SCH.FG_ACTIVE = ?");
			param.addParam(FBoolean.TRUE);
		}

		// 模糊查询
		this.addFuzzSearch(sqlBuilder,param,qryScheme.getFuzzy_cond());
	}
	/**
	 * 增加渠道过滤条件
	 * @param qryScheme
	 * @param sqlBuilder
	 * @param param
	 * @throws BizException
	 */
	private void addChlFilter(ResQrySchemeDTO qryScheme,StringBuilder sqlBuilder, SqlParam param) throws BizException{
		if(!StringUtil.isEmpty(qryScheme.getId_scchl())){
			sqlBuilder.append("AND CHL.ID_SCCHL =? ");
			param.addParam(qryScheme.getId_scchl());
		}else if(!StringUtil.isEmpty(qryScheme.getSd_scchltp())){
			IScBdQryService bdQryService = ServiceFinder.find(IScBdQryService.class);
			SchedulechlDO[] chls = bdQryService.getChlByTp(qryScheme.getSd_scchltp());
			//院内渠道只能对应一条数据，院外渠道根据渠道ID处理
			if(ArrayUtils.isNotEmpty(chls)){
				sqlBuilder.append("AND CHL.ID_SCCHL =? ");
				param.addParam(chls[0].getId_scchl());
			}
		}
	}
	/**
	 * 添加日期时间过滤条件，含午别
	 * 
	 * @param qryScheme 查询模板
	 * @param sqlBuilder SQL
	 * @param param 参数
	 * @throws BizException
	 */
	private void addDateTimeFilter(ResQrySchemeDTO qryScheme, StringBuilder sqlBuilder, SqlParam param)
			throws BizException {		
		if (qryScheme.getDate() != null) {
			sqlBuilder.append(" AND SCH.D_SCH=? ");// 日期
			param.addParam(qryScheme.getDate());

			// 午别,依赖于日期
			if (!StringUtils.isEmpty(qryScheme.getId_dayslot())) {
				sqlBuilder.append(" AND SCH.ID_DAYSLOT=? ");
				param.addParam(qryScheme.getId_dayslot());
			} else {
				this.addDefaultDayslotFilter(qryScheme, sqlBuilder,qryScheme.getDate());
			}
		} else {
			if (qryScheme.getD_begin() != null && qryScheme.getD_end() != null) {
				// 获取当天可用午别的推荐号源
				sqlBuilder.append(" AND ((SCH.D_SCH = ? ");
				param.addParam(qryScheme.getD_begin());
				this.addDefaultDayslotFilter(qryScheme, sqlBuilder,qryScheme.getD_begin());
				sqlBuilder.append(")");
				// 获取今天之后的推荐号源
				sqlBuilder.append(" OR (SCH.D_SCH>=? AND SCH.D_SCH<=? ");
				param.addParam(qryScheme.getD_begin().getDateAfter(1));
				qryScheme.getD_begin().getDateAfter(1);
				param.addParam(qryScheme.getD_end());
				this.addslotFilter(qryScheme, sqlBuilder,qryScheme.getD_begin().getDateAfter(1));
				sqlBuilder.append("))");
			}
		}
	}

	/**
	 * 添加日期分组分类过滤条件
	 * 
	 * @param scTp 排班类型
	 * @param sqlBuilder 查询SQL
	 * @param param 参数
	 * @throws BizException
	 */
	private void addDayslotCaFilter(String scTp,StringBuilder sqlBuilder, SqlParam param) throws BizException {
		if(StringUtil.isEmpty(scTp)){
			return;
		}
		ScheduleCADO schCaDO = this.getScCa(scTp);
		if (schCaDO == null) {
			throw new BizException(IScMsgConst.SC_SCTP_UNDEFINED);
		}
		String dayslotCaId = schCaDO.getId_dayslottp();
		sqlBuilder.append(" AND LOT.ID_DAYSLOTCA=?");// 日期分组分类
		param.addParam(dayslotCaId);
	}

	/**
	 * 添加当天午别过滤
	 * 
	 * @param sqlBuilder 查询SQL
	 * @param date 日期
	 * @throws BizException
	 */
	private void addDefaultDayslotFilter(ResQrySchemeDTO qryScheme, StringBuilder sqlBuilder,FDate date) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(qryScheme.getSd_sctp()))
			return;
		String[] dayslotIds = this.getTodaysDayslotIds(qryScheme, date);
		if (!ArrayUtil.isEmpty(dayslotIds)) {
			sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.ID_DAYSLOT", dayslotIds));
		}
	}
	
	/**
	 * 添加午别过滤
	 * @param qryScheme
	 * @param sqlBuilder
	 * @param date
	 * @throws BizException
	 */
	private void addslotFilter(ResQrySchemeDTO qryScheme, StringBuilder sqlBuilder,FDate date) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(qryScheme.getSd_sctp()))
			return;
		String[] dayslotIds = this.getDayslotIds(qryScheme, date);
		if (!ArrayUtil.isEmpty(dayslotIds)) {
			sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("SCH.ID_DAYSLOT", dayslotIds));
		}
	}

	/**
	 * 添加模糊查询
	 * 
	 * @param sqlBuilder SQL
	 * @param fuzzCond 模糊查询
	 * @throws BizException
	 */
	private void addFuzzSearch(StringBuilder sqlBuilder,SqlParam param,String fuzzCond) throws BizException {
		if (!StringUtil.isEmptyWithTrim(fuzzCond)) {
			sqlBuilder.append(" AND (");
			sqlBuilder.append(" UPPER(PL.PYCODE) LIKE ?");// 计划拼音
			sqlBuilder.append(" OR PL.NAME LIKE ?");// 计划名称
			sqlBuilder.append(")");
			
			param.addParam("%"+fuzzCond.toUpperCase()+"%");
			param.addParam("%"+fuzzCond+"%");
		}
	}
	/**
	 * 获取门诊排班分类
	 * @param scTp 排班类型
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private ScheduleCADO getScCa(String scTp) throws BizException {
		// 查询日期分组分类
		ISchedulecaRService serv = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] sccas = serv.findByAttrValString(ScheduleCADO.SD_SCTP, scTp);
		if (ArrayUtil.isEmpty(sccas))
			return null;
		return sccas[0];
	}

	/**
	 * 获取今天的可用午别id集合字符串
	 * 
	 * @return
	 * @throws BizException
	 */
	private String[] getTodaysDayslotIds(ResQrySchemeDTO qryScheme, FDate date) throws BizException {
		// 默认取当天可用午别
		IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] dayslotDOArray = dayslotQryService.getAllowedDaysLotsCross(qryScheme.getSd_sctp(), FBoolean.FALSE);
		Set<String> set = new HashSet<>();
		if (!ArrayUtil.isEmptyNoNull(dayslotDOArray)) {
			for (DaysLotDO dayslot : dayslotDOArray) {
				if(dayslot.getDef1() == null)
					continue;
				if(date.asBegin().compareTo(new FDate(dayslot.getDef1()).asBegin())==0)
					set.add(dayslot.getId_dayslot());
			}
		}
		return set.isEmpty() ? null : set.toArray(new String[0]);
	}
	
	/**
	 * 获取午别id集合字符串
	 * 
	 * @return
	 * @throws BizException
	 */
	private String[] getDayslotIds(ResQrySchemeDTO qryScheme, FDate date) throws BizException {
		// 可用午别
		IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] dayslotDOArray = dayslotQryService.getDaysLotDOs(qryScheme.getSd_sctp());
		Set<String> set = new HashSet<>();
		if (!ArrayUtil.isEmptyNoNull(dayslotDOArray)) {
			for (DaysLotDO dayslot : dayslotDOArray) {
				set.add(dayslot.getId_dayslot());
			}
		}
		return set.isEmpty() ? null : set.toArray(new String[0]);
	}

	/**
	 * 添加排序
	 * 
	 * @param sqlBuilder SQL
	 * @param qryScheme 查询模板
	 * @throws BizException
	 */
	private void addOrder(StringBuilder sqlBuilder,ResQrySchemeDTO qryScheme) throws BizException {
		sqlBuilder.append(" ORDER BY ");
		if (!StringUtil.isEmpty(qryScheme.getOrderstr())) {
			//推荐号源根据日期排序
			sqlBuilder.append(qryScheme.getOrderstr());
		}else{
			// 根据科室，号别，剩余号倒序排列
			sqlBuilder.append(" NAME_DEP,LOT.TIME_BEGIN ASC");
		}
	}


}

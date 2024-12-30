package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.apt.dto.d.AptQryDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ProcResBP;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
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

/**
 * 获取可预约资源
 * 
 * @author yank
 *
 */
public class GetCanApptResListBP {
	/**
	 * 获取可预约资源
	 * 
	 * @param qryScheme
	 *            查询模板
	 * @return 可预约资源信息集合
	 * @throws BizException
	 */
	public RegResDTO[] exec(AptQryDTO qryScheme) throws BizException {
		ScValidator.validateParam("查询模板", qryScheme);

		// 1、查询可预约资源
		RegResDTO[] resArray = this.getCanAptRes(qryScheme);

		// 2、加载价格
		IScSchOutQryService schService = ServiceFinder.find(IScSchOutQryService.class);
		schService.loadResPri(resArray);

		return resArray;
	}

	/**
	 * 查询可预约资源
	 * 
	 * @param qryScheme
	 *            查询模板
	 * @return
	 * @throws BizException
	 */
	private RegResDTO[] getCanAptRes(AptQryDTO qryScheme) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();

		// 1、设置查询SQL
		this.initSql(sqlBuilder);

		// 2、设置查询条件
		this.setDefaultFilter(qryScheme, sqlBuilder, param);
		if (FBoolean.TRUE.equals(qryScheme.getFg_auth())) {
			this.setOtherDocFitler(qryScheme, sqlBuilder, param);// 预约其他医生的，含授权预约
			// this.setAuthFilter(qryScheme, sqlBuilder, param);// 授权预约
		} else {
			this.setDeptChlFilter(sqlBuilder, param);// 设置渠道过滤条件
		}

		// 3、 排序
		this.addOrder(sqlBuilder);

		// 4、执行查询
		List<RegResDTO> resDTOList = (List<RegResDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param,
				new BeanListHandler(RegResDTO.class));

		// 5、结果处理
		if (!ListUtil.isEmpty(resDTOList)) {
			for (RegResDTO res : resDTOList) {
				res.setT_acpt(res.getT_b_acpt().substring(0, 5) + "-" + res.getT_e_acpt().substring(0, 5));
			}
		}
		// 6、资源重复，取号源较多资源，处理停诊标志
		ProcResBP procBP = new ProcResBP();
		return procBP.exec(resDTOList, true);
	}

	/**
	 * 设置默认查询条件
	 * 
	 * @param qryScheme
	 *            查询模板
	 * @param sqlBuilder
	 *            SQL
	 * @param param
	 *            参数
	 * @throws BizException
	 */
	private void setDefaultFilter(AptQryDTO qryScheme, StringBuilder sqlBuilder, SqlParam param) throws BizException {
		sqlBuilder.append(" WHERE 1=1 ");
		// 排班类型
		sqlBuilder.append(" AND SCH.SD_SCTP=? ");
		String scTp = StringUtil.isEmpty(qryScheme.getSd_sctp()) ? IScDictCodeConst.SD_SCTP_OP : qryScheme.getSd_sctp();// 默认为门诊
		param.addParam(scTp);
		// 排班启用
		sqlBuilder.append(" AND SCH.FG_ACTIVE='Y'");
		// 出诊科室
		if (StringUtils.isNotEmpty(qryScheme.getId_dept())) {
			sqlBuilder.append(" AND PL.ID_DEP=?");
			param.addParam(qryScheme.getId_dept());
		}
		// 时间过滤
		this.addDateTimeFilter(qryScheme, sqlBuilder, param);

		// 医生
		if (StringUtils.isNotEmpty(qryScheme.getId_doc())) {
			sqlBuilder.append(" AND ((RES.ID_EMP=? AND SD_SCRESTP=?) OR (RES.ID_DEP=? AND SD_SCRESTP=?)) ");
			param.addParam(qryScheme.getId_doc());
			param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
			param.addParam(qryScheme.getId_dept());
			param.addParam(IScDictCodeConst.SD_SCRESTP_DEP);
		} else if (ScContextUtils.getDeptId().equals(qryScheme.getId_dept())) {
			// 预约其他人的，需排除本人或者本科室普通号
			sqlBuilder.append(" AND (RES.ID_EMP<>? AND SD_SCRESTP=?)");
			param.addParam(ScContextUtils.getPsnId());
			param.addParam(IScDictCodeConst.SD_SCRESTP_EMP);
		}
		// 号别
		if (StringUtils.isNotEmpty(qryScheme.getId_scsrv())) {
			sqlBuilder.append(" AND PL.ID_SCSRV=?");
			param.addParam(qryScheme.getId_scsrv());
		}
	}

	/**
	 * 添加日期时间过滤条件，含午别
	 * 
	 * @param qryScheme
	 *            查询模板
	 * @param sqlBuilder
	 *            SQL
	 * @param param
	 *            参数
	 * @throws BizException
	 */
	private void addDateTimeFilter(AptQryDTO qryScheme, StringBuilder sqlBuilder, SqlParam param) throws BizException {
		// 日期
		if (qryScheme.getDate() != null) {
			sqlBuilder.append(" AND (SCH.D_SCH=? ");
			param.addParam(qryScheme.getDate());

			this.addDefaultDayslotFilter(sqlBuilder, qryScheme.getDate(), param);
			sqlBuilder.append(")");
		} else {
			if (qryScheme.getD_begin() != null && qryScheme.getD_end() != null) {
				sqlBuilder.append(" AND ((SCH.D_SCH >? ");
				sqlBuilder.append(" AND  SCH.D_SCH <=? )");
				param.addParam(qryScheme.getD_begin());
				param.addParam(qryScheme.getD_end());

				// 默认午别
				this.addDefaultDayslotFilter(sqlBuilder, qryScheme.getD_begin(), param);
				sqlBuilder.append(")");
			}
		}
	}

	/**
	 * 添加午别过滤
	 * 
	 * @param sqlBuilder
	 *            查询SQL
	 * @param date
	 *            日期
	 * @throws BizException
	 */
	private void addDefaultDayslotFilter(StringBuilder sqlBuilder, FDate date, SqlParam param) throws BizException {
		FDateTime currentTime = ScAppUtils.getServerDateTime();
		if (currentTime.getDate().toString().equals(date.toString())) {
			String dayslotIds = this.getTodaysDayslotIds();
			if (!StringUtil.isEmpty(dayslotIds)) {
				sqlBuilder.append(" OR (SCH.D_SCH = ? AND SCH.ID_DAYSLOT IN (").append(dayslotIds).append("))");
				param.addParam(date);
			}
		} else if (date.afterDate(currentTime.getDate().asLocalBegin())) {
			sqlBuilder.append(" OR (SCH.D_SCH = ?) ");
			param.addParam(date);
		}
	}

	/**
	 * 获取今天的可用午别id集合字符串
	 * 
	 * @return
	 * @throws BizException
	 */
	private String getTodaysDayslotIds() throws BizException {
		// 默认取当天可用午别
		IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] dayslotDOArray = dayslotQryService.getAllowedDaysLots(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
		if (!ArrayUtil.isEmptyNoNull(dayslotDOArray)) {
			StringBuilder dayslotIdbuilder = new StringBuilder();
			boolean first = true;
			for (DaysLotDO dayslot : dayslotDOArray) {
				if (first)
					first = false;
				else
					dayslotIdbuilder.append(",");
				dayslotIdbuilder.append("'" + dayslot.getId_dayslot() + "'");
			}
			return dayslotIdbuilder.toString();
		}
		return null;
	}

	/**
	 * 设置诊间渠道过滤条件
	 * 
	 * @param sqlBuilder
	 *            SQL
	 * @param param
	 *            SQL参数
	 * @throws BizException
	 */
	private void setDeptChlFilter(StringBuilder sqlBuilder, SqlParam param) throws BizException {
		// 渠道限制条件,诊间渠道、诊间渠道（本科）
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		SchedulechlDO[] chlDOs = bdQryService.getChlByTp(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT);
		if (ArrayUtils.isEmpty(chlDOs)) {
			throw new BizException(IScMsgConst.SC_CHL_IN_ROOM_DEPT_NOT_DEFINED);
		}
		sqlBuilder.append(" AND CHL.ID_SCCHL=? ");
		param.addParam(chlDOs[0].getId_scchl());
	}

	/**
	 * 设置诊间渠道（其他科室）过滤条件
	 * 
	 * @param sqlBuilder
	 *            SQL
	 * @param param
	 *            SQL参数
	 * @throws BizException
	 */
	private void setRoomChlFilter(StringBuilder sqlBuilder, SqlParam param) throws BizException {
		// 渠道限制条件,诊间渠道、诊间渠道（本科）
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		SchedulechlDO[] chlDOs = bdQryService.getChlByTp(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM);
		if (ArrayUtils.isEmpty(chlDOs)) {
			throw new BizException(IScMsgConst.SC_CHL_IN_ROOM_NOT_DEFINED);
		}
		param.addParam(chlDOs[0].getId_scchl());
	}

	/**
	 * 设置其他医生过滤条件 授权科室与授权人员没有所属关系
	 * 
	 * @param qryScheme
	 *            查询模板
	 * @param sqlBuilder
	 *            SQL
	 * @param param
	 *            参数
	 * @throws BizException
	 */
	private void setOtherDocFitler(AptQryDTO qryScheme, StringBuilder sqlBuilder, SqlParam param) throws BizException {
		sqlBuilder.append(" AND CHL.ID_SCCHL =? ");
		sqlBuilder.append(" AND (PATINDEX('%" + ScContextUtils.getDeptId() + "%',CHL.IDS_DEP_SPEC)>0 OR PATINDEX ('%"
				+ ScContextUtils.getPsnId()
				+ "%',CHL.IDS_EMP_SPEC)>0 OR (ISNULL(CHL.IDS_DEP_SPEC,'~')='~' AND ISNULL(IDS_EMP_SPEC,'~') ='~')) ");
		this.setRoomChlFilter(sqlBuilder, param); // 渠道设置诊间渠道
		// param.addParam(" %" +
		// ScContextUtils.getDeptId()+"%");//当前科室,采用这种方式，SQL解析为：ORPATINDEX
		// param.addParam("%"+ScContextUtils.getPsnId()+"%");//医生ID
	}

	/**
	 * 初始化查询SQL
	 * 
	 * @return
	 */
	private void initSql(StringBuilder sqlBuilder) {
		sqlBuilder.append(
				"SELECT SCH.ID_SCH,CHL.ID_SCCHL,CHL.SCPOLCN POLCN,SCH.D_SCH,SCH.T_E_REG,SCH.T_B_ACPT,SCH.T_E_ACPT,");// 排班信息
		sqlBuilder.append("PL.ID_SCPL,PL.NAME AS NAME_SCPL,PL.SD_TICKMD,PL.ID_DEP,DEP.NAME AS NAME_DEP,PL.PYCODE,");// 计划信息
		sqlBuilder.append("SCH.ID_DAYSLOT,LOT.NAME AS NAME_DAYSLOT,");// 午别
		sqlBuilder.append("SRV.ID_SCSRV,SRV.NAME AS NAME_SCSRV,SRV.SD_SRVTP,SRV.ID_SRVTP,");// 排班服务
		sqlBuilder.append("RES.ID_SCRES,RES.NAME AS NAME_SCRES,RES.ID_EMP,");// 排班资源
		sqlBuilder.append(
				"CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_APPT,0) WHEN 1 THEN NVL(SCH.QUAN1_APPT,0) WHEN 2 THEN NVL(SCH.QUAN2_APPT,0) WHEN 3 THEN NVL(SCH.QUAN3_APPT,0) WHEN 4 THEN NVL(SCH.QUAN4_APPT,0) WHEN 5 THEN NVL(SCH.QUAN5_APPT,0) WHEN 6 THEN NVL(SCH.QUAN6_APPT,0) WHEN 7 THEN NVL(SCH.QUAN7_APPT,0) WHEN 8 THEN NVL(SCH.QUAN8_APPT,0) WHEN 9 THEN NVL(SCH.QUAN9_APPT,0) ELSE NVL(QUAN_TOTAL_APPT，0)  END AS TOTAL,");
		sqlBuilder.append(
				"CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_USED,0) WHEN 1 THEN NVL(SCH.QUAN1_USED,0) WHEN 2 THEN NVL(SCH.QUAN2_USED,0) WHEN 3 THEN NVL(SCH.QUAN3_USED,0) WHEN 4 THEN NVL(SCH.QUAN4_USED,0) WHEN 5 THEN NVL(SCH.QUAN5_USED,0) WHEN 6 THEN NVL(SCH.QUAN6_USED,0) WHEN 7 THEN NVL(SCH.QUAN7_USED,0) WHEN 8 THEN NVL(SCH.QUAN8_USED,0) WHEN 9 THEN NVL(SCH.QUAN9_USED,0) ELSE NVL(QUAN_TOTAL_USED，0)  END AS USED,");
		sqlBuilder.append("SCH.FG_ACTIVE AS FG_ACTIVE  ");
		sqlBuilder.append("FROM SC_SCH SCH ");
		sqlBuilder.append("INNER JOIN SC_PL PL ON SCH.ID_SCPL=PL.ID_SCPL ");
		sqlBuilder.append("INNER JOIN SC_SCH_CHL CHL ON SCH.ID_SCH = CHL.ID_SCH ");
		sqlBuilder.append("INNER JOIN SC_SRV SRV ON PL.ID_SCSRV=SRV.ID_SCSRV ");
		sqlBuilder.append("INNER JOIN SC_RES RES  ON PL.ID_SCRES=RES.ID_SCRES ");
		sqlBuilder.append("LEFT JOIN BD_DEP DEP ON PL.ID_DEP=DEP.ID_DEP ");
		sqlBuilder.append("LEFT JOIN  BD_DAYSLOT LOT ON LOT.ID_DAYSLOT=SCH.ID_DAYSLOT ");
	}

	/**
	 * 获取排序 按排班日期排序
	 */
	private void addOrder(StringBuilder sqlBuilder) {
		sqlBuilder.append(" ORDER BY SUBSTR(SCH.D_SCH,0,10) ASC,NAME_DEP,TIME_BEGIN ASC");// 按排班日期、科室名称、开始时间
	}
}

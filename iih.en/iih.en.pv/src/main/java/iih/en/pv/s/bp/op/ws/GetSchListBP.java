package iih.en.pv.s.bp.op.ws;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.SchDayslotDTO;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.sctick.d.ScSchTickDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取排班信息
 * 
 * @author WJY
 *
 */
public class GetSchListBP {
	/**
	 * 获取排班信息
	 * 
	 * @param deptCode 科室编码
	 * @param doctorName 医生姓名(模糊匹配)
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @param srvType 号别
	 * @param chlType 渠道类型编码
	 * @author WJY
	 * @return
	 * @throws BizException
	 */
	public SchInfoDTO[] exec(String deptCode, String doctorName, String beginDate, String endDate, String srvType,
			String chlType) throws BizException {

		// 记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo(
				"方法：GetSchListBP参数为:deptCode:" + deptCode + ";doctorName:" + doctorName + ";beginDate:" + beginDate
						+ ";endDate:" + endDate + ";srvType:" + srvType + ";chlType:" + chlType);

		// 校验不可为空参数
		if (!this.validParam(beginDate, endDate))
			return null;

		// 获取渠道
		SchedulechlDO chlDo = this.getScChlByTp(chlType);

		// 获取排班信息
		List<SchInfoDTO> schInfoList = this.getSchInfos(chlDo, srvType, beginDate, endDate, deptCode, doctorName);
		if (schInfoList == null)
			return null;

		// 医生职称为NULL时，显示为空字符串，fanlq-08-29
		for (SchInfoDTO schInfo : schInfoList) {
			if (schInfo.getDoctorTitle() == null) {
				schInfo.setDoctorTitle("");
			}
		}

		// 加载价格信息
		this.loadSrvPrice(schInfoList);
		//获取没有过停止挂号时间的排班
		schInfoList = getNotEndReg(schInfoList);
		return schInfoList.toArray(new SchInfoDTO[0]);
	}

	/**
	 * 根据渠道类型获取渠道信息
	 * 
	 * @param chlType 渠道类型
	 * @author WJY
	 * @return
	 * @throws BizException
	 */
	private SchedulechlDO getScChlByTp(String chlType) throws BizException {
		if (chlType == null || "".equals(chlType)) {
			return null;
		}
		IScBdOutQryService bdQryService = ServiceFinder.find(IScBdOutQryService.class);
		SchedulechlDO[] chlDOs = bdQryService.getChlByTp(chlType);
		if (!EnValidator.isEmpty(chlDOs)) {
			return chlDOs[0];
		} else {
			throw new BizException("获取渠道信息失败！");
		}
	}

	/**
	 * 获取排班信息
	 * 
	 * @param chlId 渠道ID
	 * @param srvTp 号别
	 * @param beginDate 查询开始日期
	 * @param endDate 查询结束日期
	 * @param depCode 科室编号
	 * @return
	 * @throws BizException
	 */
	private List<SchInfoDTO> getSchInfos(SchedulechlDO chlDo, String srvTp, String beginDate, String endDate,
			String depCode, String doctorName) throws BizException {
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT SCH.D_SCH AS SCHDATE,DEP.CODE AS DEPTCODE,DEP.NAME AS DEPTNAME,  SCPL.NOTE AS SPECIALITY, ");
		builder.append("PSN.NAME AS DOCTORNAME, PSN.CODE AS DOCTORCODE,SRV.ID_SCSRV AS SRVID,SRV.NAME AS SRVNAME,SRV.CODE AS SRVCODE,");
		builder.append("LOT.NAME AS DAYSLOTTYPE, LOT.SD_DAYSLOTTP AS DAYSLOTTP,SCPL.SD_TICKMD AS TICKTP, ");
		if (chlDo != null) {
			builder.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_APPT,0) WHEN 1 THEN NVL(SCH.QUAN1_APPT,0) WHEN 2 THEN NVL(SCH.QUAN2_APPT,0) WHEN 3 THEN NVL(SCH.QUAN3_APPT,0) WHEN 4 THEN NVL(SCH.QUAN4_APPT,0) WHEN 5 THEN NVL(SCH.QUAN5_APPT,0) WHEN 6 THEN NVL(SCH.QUAN6_APPT,0) WHEN 7 THEN NVL(SCH.QUAN7_APPT,0) WHEN 8 THEN NVL(SCH.QUAN8_APPT,0) WHEN 9 THEN NVL(SCH.QUAN9_APPT,0) ELSE NVL(QUAN_TOTAL_APPT，0)  END AS TOTAL,");
			builder.append("CASE CHL.SCPOLCN WHEN 0 THEN NVL(SCH.QUAN0_USED,0) WHEN 1 THEN NVL(SCH.QUAN1_USED,0) WHEN 2 THEN NVL(SCH.QUAN2_USED,0) WHEN 3 THEN NVL(SCH.QUAN3_USED,0) WHEN 4 THEN NVL(SCH.QUAN4_USED,0) WHEN 5 THEN NVL(SCH.QUAN5_USED,0) WHEN 6 THEN NVL(SCH.QUAN6_USED,0) WHEN 7 THEN NVL(SCH.QUAN7_USED,0) WHEN 8 THEN NVL(SCH.QUAN8_USED,0) WHEN 9 THEN NVL(SCH.QUAN9_USED,0) ELSE NVL(QUAN_TOTAL_USED，0)  END AS USED,");
		} else {
			builder.append(" QUAN_TOTAL_APPT  TOTAL,");
			builder.append(" QUAN_TOTAL_USED  USED,");
		}
		builder.append("SCH.ID_SCH AS ID_SCH, RES.CODE AS RESCODE, RES.NAME AS RESNAME, RES.SD_SCRESTP, ");
		if (null != chlDo) {
			builder.append("CHL.SCPOLCN, ");// 号源池
		}
		builder.append("SCH.FG_ACTIVE AS ISOPEN, ");
		builder.append("bd_udidoc.name as DoctorTitle, ");// 职称
		builder.append("SRV.SD_SRVTP AS SRVTYPE ");
		builder.append("FROM SC_SCH SCH ");
		builder.append("INNER JOIN SC_PL SCPL ");
		builder.append("ON SCH.ID_SCPL = SCPL.ID_SCPL ");
		builder.append("INNER JOIN SC_RES RES ");
		builder.append("ON SCPL.ID_SCRES = RES.ID_SCRES ");
		builder.append("INNER JOIN SC_SRV SRV ");
		builder.append("ON SCPL.ID_SCSRV = SRV.ID_SCSRV ");
		if (chlDo != null) {
			builder.append("INNER JOIN SC_SCH_CHL CHL ");
			builder.append("ON CHL.ID_SCH = SCH.ID_SCH ");
		}
		builder.append("INNER JOIN BD_DEP DEP ");
		builder.append("ON SCPL.ID_DEP = DEP.ID_DEP ");
		builder.append("INNER JOIN BD_DAYSLOT LOT ");
		builder.append("ON SCH.ID_DAYSLOT = LOT.ID_DAYSLOT ");
		builder.append("LEFT JOIN BD_PSNDOC PSN ");
		builder.append("ON RES.ID_EMP = PSN.ID_PSNDOC ");
		builder.append("left join bd_udidoc bd_udidoc on bd_udidoc.id_udidoc = PSN.Id_Emptitle ");// 显示医生职称，fanlq-2018.04.02
		builder.append("WHERE  SCH.FG_ACTIVE ='Y' AND SCH.SD_SCTP = ? ");
		param.addParam(IScDictCodeConst.SD_SCTP_OP);

		if (!EnValidator.isEmpty(srvTp)) {
			String[] srvTps = EnCodeUtils.srvTypeTOIIHSrvTp(srvTp);
			if(!EnValidator.isEmpty(srvTps)){
				builder.append("AND " + EnSqlUtils.getInSqlByIds("SRV.SD_SRVTP", srvTps));
			}
		}
		if (chlDo != null) {
			builder.append(" AND CHL.ID_SCCHL =? ");
			param.addParam(chlDo.getId_scchl());
		}
		builder.append("AND SCH.D_SCH >= ? ");
		param.addParam(beginDate);

		builder.append("AND SCH.D_SCH <=? ");
		param.addParam(endDate);

		if (!EnValidator.isEmpty(depCode)) {
			builder.append("AND DEP.CODE =? ");
			param.addParam(depCode);
		}

		// 添加模糊查询
		this.addFuzzSearch(builder, doctorName);

		builder.append(" ORDER BY SCH.D_SCH, LOT.SD_DAYSLOTTP ");

		List<SchInfoDTO> schInfoList = (List<SchInfoDTO>) new DAFacade().execQuery(builder.toString(), param,
				new BeanListHandler(SchInfoDTO.class));
		if (EnValidator.isEmpty(schInfoList))
			return null;
		// 进一步处理

		// 查询所有排班同号源池不包含当前渠道的号位 add by zhengcm 2018-04-25
		Map<String, List<ScSchTickDO>> map = null;
		if (null != chlDo) {
			Map<String, Integer> schMap = new HashMap<String, Integer>();
			for (SchInfoDTO info : schInfoList) {
				if (!schMap.containsKey(info.getId_sch())) {
					schMap.put(info.getId_sch(), info.getScpolcn());
				}
			}
			map = ServiceFinder.find(IScSchOutQryService.class).batchGetSchOtherChlTick(schMap, chlDo);
		}

		List<SchInfoDTO> schInfos = new LinkedList<>();
		for (SchInfoDTO schInfo : schInfoList) {
			if (schInfo.getTotal() == 0)
				continue;
			schInfo.setRemain(schInfo.getTotal() - schInfo.getUsed());// 计算剩余
			schInfo.setAmpm(EnCodeUtils.dayslotTpTOHisCode(schInfo.getDayslottp()));
			schInfo.setSrvType(EnCodeUtils.srvTpTOHisSrvCode(schInfo.getSrvType()));
			if (EnValidator.isEmpty(schInfo.getDoctorName()))
				schInfo.setDoctorName("-1");
			if (EnValidator.isEmpty(schInfo.getDoctorCode()))
				schInfo.setDoctorCode("-1");
			// 渠道非空时可预约数需要减去同号源池不包含当前渠道的号位数量
			if (null != chlDo && null != map && map.containsKey(schInfo.getId_sch())) {
				schInfo.setTotal(schInfo.getTotal() - map.get(schInfo.getId_sch()).size());
				schInfo.setRemain(schInfo.getTotal() - schInfo.getUsed());
			}
			schInfos.add(schInfo);
		}
		if (EnValidator.isEmpty(schInfos))
			return null;
		return schInfos;
	}

	/**
	 * 获取服务价格信息
	 * 
	 * @param regResList 资源集合
	 * @return
	 * @throws BizException
	 */
	private void loadSrvPrice(List<SchInfoDTO> regResList) throws BizException {
		RegResDTO[] regResDTOs = new RegResDTO[regResList.size()];
		for (int i = 0; i < regResList.size(); i++) {
			RegResDTO regRes = new RegResDTO();
			regRes.setId_scsrv(regResList.get(i).getSrvId());
			regResDTOs[i] = regRes;
		}

		IScSchOutQryService scSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		RegResDTO[] resResult = scSchOutQryService.loadResPri(regResDTOs);

		Map<String, FDouble> regResMap = new LinkedHashMap<String, FDouble>();
		for (RegResDTO regResDTO : resResult) {
			regResMap.put(regResDTO.getId_scsrv(), regResDTO.getAmt_st());
		}

		for (SchInfoDTO schInfo : regResList) {
			schInfo.setPrice(regResMap.get(schInfo.getSrvId()).floatValue());
		}
	}

	/**
	 * 添加模糊查询
	 * 
	 * @param sqlBuilder SQL
	 * @param fuzzCond 模糊查询
	 * @throws BizException
	 */
	private void addFuzzSearch(StringBuilder sqlBuilder, String fuzzCond) throws BizException {
		if (!EnValidator.isEmpty(fuzzCond)) {
			sqlBuilder.append(" AND (");
			sqlBuilder.append(" RES.NAME LIKE '%" + SqlUtils.formatSQLInjection(fuzzCond) + "%'");// 计划拼音
			sqlBuilder.append(" OR PSN.NAME LIKE '%" + SqlUtils.formatSQLInjection(fuzzCond) + "%'");// 计划名称
			sqlBuilder.append(")");
		}
	}

	/**
	 * 验证必输项参数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param srvType
	 * @param chlType
	 * @return
	 */
	private Boolean validParam(String beginDate, String endDate) {
		if (EnValidator.isEmpty(beginDate)) {
			// Logger.error("开始日期不能为空！");
			return false;
		}
		if (EnValidator.isEmpty(endDate)) {
			// Logger.error("结束日期不能为空！");
			return false;
		}
		return true;
	}
	/***
	 * @Description:获取没有过停止挂号时间的排班-fanlq-2019-09-12
	 * @param beginDate
	 * @param schInfoList
	 * @return
	 * @throws BizException
	 */
	private List<SchInfoDTO> getNotEndReg(List<SchInfoDTO> schInfoList) throws BizException{
		List<SchInfoDTO> list = new ArrayList<SchInfoDTO>();
		List<String> schIds = new ArrayList<String>();
		for(SchInfoDTO schInfoDTO : schInfoList){
			schIds.add(schInfoDTO.getId_sch());
		}
		if(schIds.size() <= 0) return schInfoList;
		StringBuffer sql = new StringBuffer();
		sql.append("select sch.id_sch, ");
		sql.append("sch.d_sch, " );
		sql.append("sch.t_e_reg, " );
		sql.append("dayslot.time_begin, " );
		sql.append("dayslot.time_end " );
		sql.append("from sc_sch sch " );
		sql.append("inner join bd_dayslot dayslot on dayslot.id_dayslot = sch.id_dayslot " );
		sql.append("where "+SqlUtils.getInSqlByBigIds("sch.id_sch", schIds.toArray(new String[0])));
		@SuppressWarnings("unchecked")
		List<SchDayslotDTO> schDayslotList = (List<SchDayslotDTO>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(SchDayslotDTO.class));
		if (EnValidator.isEmpty(schDayslotList)) return schInfoList;
		FMap map = new FMap();
		for(SchDayslotDTO dto : schDayslotList){
			map.put(dto.getId_sch(), dto);
		}
		FDateTime curDateTime = EnAppUtils.getServerDateTime();
		FDateTime endDateTime = EnAppUtils.getServerDateTime();
		for(SchInfoDTO schInfoDTO : schInfoList){
			SchDayslotDTO dto = (SchDayslotDTO)map.get(schInfoDTO.getId_sch());
			if(dto.getTime_begin().after(dto.getTime_end()))
				endDateTime = new FDateTime(dto.getD_sch().getDateAfter(1), dto.getT_e_reg());
			else
				endDateTime = new FDateTime(dto.getD_sch(), dto.getT_e_reg());
			if(!curDateTime.after(endDateTime)){
				list.add(schInfoDTO);
			}
		}
		return list;
	}
	
}

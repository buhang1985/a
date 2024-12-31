package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpVisitTimesStatDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 统计门急诊就诊人次
 * 
 * @author liubin
 *
 */
public class GetVisitTimesStatBP {
	public OpVisitTimesStatDTO[] exec(String date)
			throws BizException {
		FDate fDate = this.string2FDate(date);
		if(fDate == null)
			return null;
		FDateTime dateTime = EnAppUtils.getFDateTime(fDate, new FTime("00:00:00"));
		return this.getOpVisitTimesStat(dateTime);
	}
	/**
	 * 获取门急诊就诊人次
	 * 
	 * @param dateTime
	 * @return
	 * @throws BizException
	 */
	private OpVisitTimesStatDTO[] getOpVisitTimesStat(FDateTime dateTime) 
			throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("SELECT STAT.*, DEP.CODE AS CODEDEPT,DEP.NAME AS NAMEDEPT ");
		sqlBuilder.append("FROM ( ");
		sqlBuilder.append("SELECT OP.ID_DEP_REG AS ID_STAT_DEP, ");
		sqlBuilder.append("SUM(CASE EN.CODE_ENTP WHEN ? THEN 1 ELSE 0 END) AS ENTTIMESOP, ");
		sqlBuilder.append("SUM(CASE EN.CODE_ENTP WHEN ? THEN 1 ELSE 0 END) AS ENTTIMESEMG, ");
		sqlBuilder.append("SUM(CASE OP.SD_SVRTP WHEN ? THEN 1  WHEN ? THEN 1 ELSE 0 END) AS ENTTIMESPROF, ");
		sqlBuilder.append("SUM(CASE OP.SD_SVRTP WHEN ? THEN 1  ELSE 0 END) AS ENTTIMESCOMM, ");
		sqlBuilder.append("COUNT(DISTINCT CASE OP.SD_SVRTP WHEN ? THEN OP.ID_SCH  WHEN ? THEN OP.ID_SCH ELSE NULL END)*0.5 AS PHYDAYSPROF, ");
		sqlBuilder.append("COUNT(DISTINCT CASE OP.SD_SVRTP WHEN ? THEN OP.ID_SCH  ELSE NULL END)*0.5 AS PHYDAYSCOMM  ");
		sqlBuilder.append("FROM EN_ENT EN ");
		sqlBuilder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append("WHERE EN.FG_CANC = ? ");
		sqlBuilder.append("AND EN.DT_ENTRY = ? ");
		sqlBuilder.append("GROUP BY OP.ID_DEP_REG ");
		sqlBuilder.append(") STAT ");
		sqlBuilder.append("INNER JOIN BD_DEP DEP ON STAT.ID_STAT_DEP = DEP.ID_DEP ");
		String sql = sqlBuilder.toString();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL);
		param.addParam(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM);
		param.addParam(FBoolean.FALSE);
		param.addParam(dateTime);
		@SuppressWarnings("unchecked")
		List<OpVisitTimesStatDTO> list = (List<OpVisitTimesStatDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(OpVisitTimesStatDTO.class));
		if(EnValidator.isEmpty(list))
			return null;
		for(OpVisitTimesStatDTO opVisitTimesStat : list)
			opVisitTimesStat.setDate(dateTime.getDate().toStdString());
		return list.toArray(new OpVisitTimesStatDTO[0]);
	}
	/**
	 * 日期转换
	 * 
	 * @param str
	 * @return
	 */
	private FDate string2FDate(String str){
		try{
			return new FDate(str);
		} catch(Throwable t){
			EnLogUtil.getInstance().logError("日期转换出错！" + str);
		}
		return null;
	}
}

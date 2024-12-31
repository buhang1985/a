package iih.en.comm.util;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 就诊次数帮助类
 * 
 * @author liubin
 *
 */
public class EnVisitTimesUtils {
	
	/**
	 * 计算门诊就诊次数
	 * 
	 * @param patId 患者ID
	 * @return
	 * @throws BizException
	 */
	public static Integer calcTimesOp(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select max(op.times_op) timesop ");
		sql.append(" from en_ent_op op ");
		sql.append(" left join en_ent ent ");
		sql.append(" on op.id_ent = ent.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		SqlParam param = new SqlParam();
        param.addParam(patId);
		Integer timesop = execQuery(sql.toString(), param);
		Integer deftimesop = EnParamUtils.getDefTimesOp();
		if (timesop == null || timesop < deftimesop){
			if(deftimesop > 0)
				return deftimesop;
			timesop = 0;
		}
		return timesop== null ? 1 : timesop + 1;
	}
	/**
	 * 计算住院次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public static int calcAdmIpTimes(String patId) throws BizException{
		Integer maxTimes = getMaxIpTimes(patId, IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		return maxTimes == null || maxTimes < 0 ? 1 : maxTimes + 1;
	}
	/**
	 * 计算住院次数(取消登记，退院)
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public static int calcCancIpTimes(String patId) throws BizException{
		Integer minTimes = getMinIpTimes(patId);
		return minTimes == null || minTimes >= 0 ? -1 : minTimes - 1;
	}
	/**
	 * 计算入急诊留观就诊次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public static int calcAdmObsTimes(String patId) throws BizException{
		Integer deftimes = EnParamUtils.getDefTimesObs();
		Integer maxTimes = getMaxIpTimes(patId, IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		if(maxTimes == null || maxTimes < deftimes){
			if(deftimes > 0)
				return deftimes;
		}
		return maxTimes == null || maxTimes < 0  ? 1 : maxTimes + 1;
	}
	/**
	 * 计算就诊次数(取消留观登记，留观退院)
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	
	public static int calcCancObsTimes(String patId) throws BizException{
		Integer minTimes = getMinIpTimes(patId);
		return minTimes == null || minTimes >= 0 ? -1 : minTimes - 1;
	}
	
	
	/**
	 * 获取住院表最大住院次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private static Integer getMaxIpTimes(String patId, String codeEntp) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  max(times_ip)  times_ip from en_ent_ip  ip");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = ip.id_ent");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" and ent.code_entp = ? ");
		SqlParam param = new SqlParam();
        param.addParam(patId);
        param.addParam(codeEntp);
		return execQuery(sql.toString(), param);
	}
	/**
	 * 获取住院表最小住院次数(不区分就诊类型)
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private static Integer getMinIpTimes(String patId) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  min(nvl(times_ip,0))  times_ip from en_ent_ip  ip");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = ip.id_ent");
		sql.append(" where ent.id_pat = ? ");
		SqlParam param = new SqlParam();
        param.addParam(patId);
		return execQuery(sql.toString(), param);
	}
	/**
	 * 数据库查询
	 * 
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private static Integer execQuery(String sql, SqlParam param) throws BizException{
		return (Integer) new DAFacade().execQuery(sql, param, new ColumnHandler());
	}
}

package iih.pi.reg.pat.s.bp;

import org.apache.commons.lang.exception.ExceptionUtils;

import iih.bd.utils.FileUtils;
import iih.pi.reg.i.IPiPatLogService;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者建档日志业务逻辑
 * 
 * @author hao_wu
 *
 */
public class PiPatCreateLogBp {

	/**
	 * 创建前
	 */
	public final static String BeforeCreate = "1";
	/**
	 * 创建后
	 */
	public final static String AfterCreate = "2";

	public void exec(PatDO[] pats, String createType) {
		if (pats == null || pats.length <= 0) {
			return;
		}

		StringBuilder logBuilder = new StringBuilder();
		buildLogByCreateType(createType, logBuilder);
		buildLogByPats(pats, logBuilder);
		setStackTraceToLog(logBuilder);
		writeLog(logBuilder.toString());
	}

	/**
	 * 设置堆栈到日志
	 * 
	 * @param logBuilder
	 */
	private void setStackTraceToLog(StringBuilder logBuilder) {
		logBuilder.append(FileUtils.NewLine);
		BizException exception = new BizException();
		logBuilder.append(ExceptionUtils.getFullStackTrace(exception));
	}

	/**
	 * 根据建档类型构建日志
	 * 
	 * @param createType
	 * @param logBuilder
	 */
	private void buildLogByCreateType(String createType, StringBuilder logBuilder) {
		if (createType.equals(BeforeCreate)) {
			logBuilder.append("患者建档时机：建档前");

		} else if (createType.equals(AfterCreate)) {
			logBuilder.append("患者建档时机：建档后");
		}
		logBuilder.append(FileUtils.NewLine);
	}

	/**
	 * 根据患者信息构建日志
	 * 
	 * @param pats
	 * @param logBuilder
	 */
	private void buildLogByPats(PatDO[] pats, StringBuilder logBuilder) {
		String log = String.format("患者个数:%s", pats.length);
		logBuilder.append(log);
		logBuilder.append(FileUtils.NewLine);

		for (PatDO patDO : pats) {
			buildLogByPat(patDO, logBuilder);
		}
	}

	/**
	 * 根据患者信息构建日志
	 * 
	 * @param patDO
	 * @param logBuilder
	 */
	private void buildLogByPat(PatDO patDO, StringBuilder logBuilder) {
		String log = String.format("患者编码:%s,患者名称:%s,证件类型:%s,证件号:%s,手机号:%s,出生日期:%s,患者分类:%s,CHIS条码号:%s,实名认证:%s",
				patDO.getCode(), patDO.getName(), patDO.getSd_idtp(), patDO.getId_code(), patDO.getMob(),
				patDO.getDt_birth(), patDO.getId_paticate(), patDO.getBarcode_chis(), patDO.getFg_realname());
		logBuilder.append(log);

	}

	/**
	 * 写日志
	 * 
	 * @param logContent
	 */
	private void writeLog(String logContent) {
		logContent = String.format("%s%s", FileUtils.NewLine, logContent);

		IPiPatLogService piPatLogService = ServiceFinder.find(IPiPatLogService.class);
		piPatLogService.log(logContent, Level.INFO);
	}
}

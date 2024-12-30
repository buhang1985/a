package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取未取号的预约总数
 * @author yank
 *
 */
public class GetUntakenAptCountBP {
	/**
	 * 获取未取号的预约总数
	 * @param scTp 排班类型
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public Integer exec(String scTp,String patId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT COUNT(ID_APT)");
		sqlBuilder.append(" FROM SC_APT APT");
		sqlBuilder.append(" WHERE 1=1 ");		
		SqlParam param = new SqlParam();		
		sqlBuilder.append(" AND SD_SCTP=? ");	//排班类型
		param.addParam(scTp);				
		sqlBuilder.append(" AND ID_PAT=? ");//患者id	
		param.addParam(patId);				
		sqlBuilder.append(" AND SUBSTR(DT_B,0,10)>=? ");//当天后预约号的信息
		FDateTime currentTime = ScAppUtils.getServerDateTime();
		param.addParam(currentTime.getDate());
		if(ScParamUtils.getEnTakeAptDays() != null){
			FDateTime dt_end = currentTime.getDateTimeAfter(ScParamUtils.getEnTakeAptDays()-1);
			sqlBuilder.append(" AND SUBSTR(APT.DT_B,0,10) <= ? ");
			param.addParam(dt_end);
		}
		sqlBuilder.append(" AND (SD_STATUS=?");//只查询状态为预约和支付的预约信息
		param.addParam(IScDictCodeConst.SD_APTSTATUS_ORDER);//预约
		sqlBuilder.append(" OR SD_STATUS=? )");
		param.addParam(IScDictCodeConst.SD_APTSTATUS_PAY);//支付
		
		DAFacade daf = new DAFacade();
		Integer aptCount = (Integer)daf.execQuery(sqlBuilder.toString(),param,
				new ColumnHandler());
		return aptCount;
	}
}

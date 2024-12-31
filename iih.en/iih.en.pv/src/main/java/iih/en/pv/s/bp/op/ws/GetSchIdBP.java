package iih.en.pv.s.bp.op.ws;

import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取排班Id
 * 
 * @author liubin
 *
 */
public class GetSchIdBP {
	public String exec(String deptCode, String resCode, String date,
			String ampm, String srvCode) throws BizException {
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetSchIdBP参数为:deptCode:"+deptCode+";resCode:"+resCode
				+";date:"+date+";ampm:"+ampm+";srvCode:"+srvCode);
		
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT SC_SCH.ID_SCH ");
		builder.append("FROM SC_SCH SC_SCH ");
		builder.append("INNER JOIN SC_PL SC_PL ON SC_SCH.ID_SCPL = SC_PL.ID_SCPL ");
		builder.append("LEFT JOIN SC_RES SC_RES ON SC_PL.ID_SCRES = SC_RES.ID_SCRES ");
		builder.append("LEFT JOIN SC_SRV SC_SRV ON SC_PL.ID_SCSRV = SC_SRV.ID_SCSRV ");
		builder.append("LEFT JOIN BD_DEP BD_DEP ON SC_PL.ID_DEP = BD_DEP.ID_DEP ");
		builder.append("LEFT JOIN BD_DAYSLOT BD_DAYSLOT ON SC_SCH.ID_DAYSLOT = BD_DAYSLOT.ID_DAYSLOT ");
		builder.append("WHERE SC_SCH.D_SCH = ? ");
		param.addParam(date);
		builder.append("AND SC_RES.CODE = ? ");
		param.addParam(resCode);
		if(!EnValidator.isEmpty(srvCode)){
			builder.append("AND SC_SRV.CODE = ? ");
			param.addParam(srvCode);
		}
		builder.append("AND BD_DEP.CODE = ? ");
		param.addParam(deptCode);
		builder.append("AND BD_DAYSLOT.SD_DAYSLOTTP = ? ");
		String sql = builder.toString();
		param.addParam(EnCodeUtils.hisCodeToDaysLotTp(ampm));
		return (String) new DAFacade().execQuery(sql, param, new ColumnHandler());
	}
}

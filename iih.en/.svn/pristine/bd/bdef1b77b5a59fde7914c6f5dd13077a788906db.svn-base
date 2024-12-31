package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 为ci提供判定是否是特需(国际专用)
 * @author renying
 *
 */
public class GetSrvtpforCIBP {
 
	private static final String srvName = "特需";
	/**
	 * 为ci提供判定是否是特需(国际专用)
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	public FBoolean exec(String entId) throws BizException{
		ScheduleSrvDO srvDO = this.getScSrvDO(entId);
		if(srvDO ==null)
			return null;
		if(!EnValidator.isEmpty(srvDO.getName()) &&srvDO.getName().contains(srvName))
				return FBoolean.TRUE;
	
		 return FBoolean.FALSE;
	}
	
	
	/**
	 * 获取基础查询SQL
	 * 
	 * @return
	 * @throws DAException 
	 */
	private ScheduleSrvDO getScSrvDO(String entId) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * ");
		builder.append("FROM EN_ENT EN ");
		builder.append("INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = EN.ID_ENT ");
		builder.append("LEFT JOIN SC_SRV SRV ON OP.ID_SCSRV = SRV.ID_SCSRV ");
		builder.append("WHERE EN.ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		List<ScheduleSrvDO> list = (List<ScheduleSrvDO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(ScheduleSrvDO.class));
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new ScheduleSrvDO[0])[0];
		}
		return null;
	}
}

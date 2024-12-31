package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 获取患者预约渠道打印标识
 * 
 */
public class GetScSchPrintIdentBP {
	/**
	 * 获取患者预约渠道打印标识
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public String exec(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT UDI.* ");
		sqlBuilder.append("FROM EN_ENT_OP OP ");
		sqlBuilder.append("INNER JOIN SC_APT APT ON OP.ID_SCHAPT = APT.ID_APT ");
		sqlBuilder.append("INNER JOIN SC_CHL CHL ON APT.ID_SCCHL = CHL.ID_SCCHL ");
		sqlBuilder.append("INNER JOIN BD_UDIDOC UDI ON CHL.ID_SCCHLTP = UDI.ID_UDIDOC ");
		sqlBuilder.append("WHERE OP.ID_ENT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		List<UdidocDO> list = (List<UdidocDO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(UdidocDO.class));
		if(EnValidator.isEmpty(list))
			return null;
		return list.get(0).getCtrl1();
	}
}

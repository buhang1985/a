package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否可以打印发票
 * @author fanliqin
 *
 */
public class GetOpSdStatusBP {
	 /**
	  * 是否可以打印发票
	  * @param entId
	  * @return
	  * @throws BizException
	  */
	public String exec(String entId) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		StringBuffer ipntBuffer = new StringBuffer();
		SqlParam param = new SqlParam();
		ipntBuffer.append("select op.sd_status ");
		ipntBuffer.append("from en_ent_op op ");
		ipntBuffer.append("where op.id_ent = ? ");
		param.addParam(entId);
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(ipntBuffer.toString(), param, new BeanListHandler(PatiVisitDO.class));
		if(list != null && list.size() > 0 ){
			return list.toArray(new PatiVisitDO[]{})[0].getSd_status();
		}
		return null;
	}
}

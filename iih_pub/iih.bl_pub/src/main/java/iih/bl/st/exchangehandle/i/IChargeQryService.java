package iih.bl.st.exchangehandle.i;

import iih.bl.cg.dto.d.BlChargeDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊收费相关查询接口
 * @author yi
 *
 */
public interface IChargeQryService {

	BlChargeDTO[] getChargeItem(String id_pat,String id_grp,String validateDateTime) throws BizException; 
}

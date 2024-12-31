package iih.bl.st.s.bp;

import iih.bl.st.blstip.d.BlStIpDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 判断是否存在欠款未结清的结算信息
 * 
 * @author liwq
 *
 */
public class HasDebtUnSettledBP {

	public FBoolean exec(String id_ent) throws BizException {	
		if (StringUtil.isEmptyWithTrim(id_ent)) {
			throw new BizException("患者就诊id不能为空！");
		}
		String[] fileds = {"fg_arclear"};
		String whereCond =  "fg_arclear= 'N' and fg_canc= 'N' and id_ent = '"+ id_ent +"' ";
		List<BlStIpDO> list = (List<BlStIpDO>) new DAFacade().findByCond(BlStIpDO.class, whereCond,fileds);		
		return list.get(0).getFg_arclear();
	}
}

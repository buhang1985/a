package iih.bl.hp.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保患者是否进行的中途结算
 * @param idEnt
 * @return
 * @throws BizException
 * @author liwq   作废
 */
public class HasHalfSettledBp {

	public FBoolean exec(String idEnt) throws BizException {
		
		
		IBlstipRService stService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO[] ipStDOs = stService.findByAttrValString("Id_ent", idEnt);
		if(ArrayUtils.isEmpty(ipStDOs)) {
			return FBoolean.FALSE;
		}
		ArrayList<String> id_stipList = new ArrayList<String>();
		 for(BlStIpDO itm : ipStDOs) {
			 id_stipList.add(itm.getId_stip());
		 }
		String whereIn = SqlUtils.getInSqlByIds("Id_stip", id_stipList);
		String[] strFileds = {"Id_propip"};
		DAFacade dAFacade=new DAFacade();
		ArrayList<BlPropIpDO> propList = (ArrayList<BlPropIpDO>)dAFacade.findByCond(BlPropIpDO.class, whereIn,"1", strFileds);
		if(propList != null && propList.size() > 0) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}

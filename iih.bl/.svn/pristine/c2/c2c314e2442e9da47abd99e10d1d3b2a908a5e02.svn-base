package iih.bl.inc.s.ep;

import iih.bd.base.utils.SqlUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.d.desc.BlIncIpDODesc;
import iih.bl.inc.blincip.i.IBlincipMDOCudService;
import iih.bl.inc.blincip.i.IBlincipRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 住院发票EP
 * @author ly 2018/12/08
 *
 */
public class IncIpEP {

	/**
	 * 根据结算id 查询住院发票信息
	 * @param stIds
	 * @return
	 * @throws BizException
	 */
	public BlincipAggDO[] findIncByStId(String... stIds) throws BizException{
		IBlincipRService rService =ServiceFinder.find(IBlincipRService.class);
		String whereSql="";
		if(stIds.length==1){
			whereSql=BlIncIpDODesc.TABLE_ALIAS_NAME + ".id_stip = '"+stIds[0]+"'";
		}else{
			whereSql = SqlUtils.getInSqlByIds(BlIncIpDODesc.TABLE_ALIAS_NAME + ".id_stip", stIds);
		}
		
		BlincipAggDO[] aggDos = rService.find(whereSql, BlIncIpDODesc.TABLE_ALIAS_NAME+".incno", FBoolean.FALSE);
		return aggDos;
	}
	
	/**
	 * 回写电子发票属性
	 * @param incDO
	 * @throws BizException
	 * @author ly 2019/12/16
	 */
	public void writebackEcIncInfo(BlIncIpDO incDO) throws BizException{
		
		//重新查询
		DAFacade daf = new DAFacade();
		BlIncIpDO oldIncDO = (BlIncIpDO)daf.findByPK(BlIncIpDO.class, incDO.getId_incip());
		oldIncDO.setIncno(incDO.getIncno());
		oldIncDO.setEc_inc_code(incDO.getEc_inc_code());
		oldIncDO.setEc_inc_checkno(incDO.getEc_inc_checkno());
		oldIncDO.setEc_url(incDO.getEc_url());
		oldIncDO.setEc_net_url(incDO.getEc_net_url());
		
		oldIncDO.setFg_print(FBoolean.TRUE);
		oldIncDO.setId_emp_inc(Context.get().getStuffId());
		oldIncDO.setDt_inc(BlFlowContextUtil.getNowTime());
		oldIncDO.setStatus(DOStatus.UPDATED);
		
		IBlincipMDOCudService incService = ServiceFinder.find(IBlincipMDOCudService.class);
		incService.update(new BlIncIpDO[] { oldIncDO });
	}
}

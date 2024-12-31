package iih.pi.reg.s.bp;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 入院登记专用患者保存
 * @author ly 2017/1/12
 *
 */
public class PiSavePatForHosRegBp {

	/**
	 * 保存患者
	 * @param aggDo
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO exec(PatiAggDO aggDo) throws BizException{
		
		if(aggDo == null || aggDo.getParentDO() == null)
			return null;
		
		IPatiCudService service = ServiceFinder.find(IPatiCudService.class);
		
		if(aggDo.getParentDO().getStatus()==DOStatus.NEW){
			aggDo.getParentDO().setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
			aggDo = service.insert(new PatiAggDO[]{aggDo})[0];
			
			/*aggDo.getParentDO().setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
			BDCommonEvent event = new BDCommonEvent(
					PatiAggDO.class.getName(),
					IEventType.TYPE_UPDATE_AFTER, new Object[]{aggDo},new Object[]{aggDo});
			EventDispatcher.fireEvent(event);*/
			
			//aggDo.getParentDO().setStatus(DOStatus.UPDATED);
			//aggDo.getParentDO().setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
			//aggDo = service.update(new PatiAggDO[]{aggDo})[0];
			
		}else if(aggDo.getParentDO().getStatus() == DOStatus.UPDATED){
			aggDo.getParentDO().setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
			aggDo = service.update(new PatiAggDO[]{aggDo})[0];
		}
		
		return aggDo;
	}
}

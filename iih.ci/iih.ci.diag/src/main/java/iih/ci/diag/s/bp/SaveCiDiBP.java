package iih.ci.diag.s.bp;

import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.pub.CiDiAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 诊断保存
 * @author li_zheng
 *
 */
public class SaveCiDiBP {
	
	public CidiagAggDO exec(CidiagAggDO aggDO)throws BizException{
		   //诊断
		  CiDiAppUtils.getICidiagCudService().save( new CidiagAggDO[]{aggDO});
		  //事件
		  CiDiAppUtils.getICieventCudService().save(new CiEventDO[]{this.getCiEventDO(aggDO)});
		return aggDO;
	}

	/**
	 * 诊断事件
	 * @param agg
	 * @return
	 */
	private  CiEventDO getCiEventDO(CidiagAggDO agg) {
		CiEventDO  cievent = new CiEventDO();
    	cievent.setStatus(DOStatus.NEW);
   	    cievent.setId_di(agg.getParentDO().getId_di());
   	    cievent.setId_pat(agg.getParentDO().getId_pat());
   	    cievent.setId_ettp(agg.getParentDO().getId_en());
   	    return cievent;
	}
}

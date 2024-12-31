package iih.pe.pps.pepositrack.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pps.pepositrack.d.PePosiTrackDO;
import iih.pe.pps.pepositrack.d.PePostTrackHistDO;
import iih.pe.pps.pepositrack.d.desc.PePostTrackHistDODesc;
import iih.pe.pps.pepositrack.d.PePosiTrackDtlDO;
import iih.pe.pps.pepositrack.d.desc.PePosiTrackDtlDODesc;

/**
 * 体检阳性结果追踪
 * @author
 *
 */
public class PepositrackAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PepositrackAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PePosiTrackDO.class);
        addChildren(PePostTrackHistDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePostTrackHistDODesc.class).getFKAttrDesc());        
        addChildren(PePosiTrackDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePosiTrackDtlDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.nm.nqm.aer.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.aer.d.NmAerDO;
import iih.nm.nqm.aer.d.NmAerCaDO;
import iih.nm.nqm.aer.d.desc.NmAerCaDODesc;
import iih.nm.nqm.aer.d.NmAerPatDO;
import iih.nm.nqm.aer.d.desc.NmAerPatDODesc;

/**
 * 不良事件上报
 * @author
 *
 */
public class AerAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public AerAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmAerDO.class);
        addChildren(NmAerCaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmAerCaDODesc.class).getFKAttrDesc());        
        addChildren(NmAerPatDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmAerPatDODesc.class).getFKAttrDesc());        
	  }	  
}
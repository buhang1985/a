package iih.nm.nbd.nbddepca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nbd.nbddepca.d.NbdDepCaDO;
import iih.nm.nbd.nbddepca.d.NbdDepDO;
import iih.nm.nbd.nbddepca.d.desc.NbdDepDODesc;

/**
 * 护理单元
 * @author
 *
 */
public class NbddepcaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NbddepcaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NbdDepCaDO.class);
        addChildren(NbdDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NbdDepDODesc.class).getFKAttrDesc());        
	  }	  
}
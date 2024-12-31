package iih.mp.ne.transfusion.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.ne.transfusion.d.NeBtrDO;
import iih.mp.ne.transfusion.d.NeBtrItmDO;
import iih.mp.ne.transfusion.d.desc.NeBtrItmDODesc;
import iih.mp.ne.transfusion.d.NeBtrReaDO;
import iih.mp.ne.transfusion.d.desc.NeBtrReaDODesc;
import iih.mp.ne.transfusion.d.NeBtrVtDO;
import iih.mp.ne.transfusion.d.desc.NeBtrVtDODesc;

/**
 * 输血执行
 * @author
 *
 */
public class TransfusionAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public TransfusionAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NeBtrDO.class);
        addChildren(NeBtrItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NeBtrItmDODesc.class).getFKAttrDesc());        
        addChildren(NeBtrReaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NeBtrReaDODesc.class).getFKAttrDesc());        
        addChildren(NeBtrVtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NeBtrVtDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.nm.nom.nmnomwbkitm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nmnomwbkitm.d.NmNomWbkCaDO;
import iih.nm.nom.nmnomwbkitm.d.NmNomWbkItmDO;
import iih.nm.nom.nmnomwbkitm.d.desc.NmNomWbkItmDODesc;

/**
 * 护士长手册模板
 * @author
 *
 */
public class NmnomwbkitmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnomwbkitmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNomWbkCaDO.class);
        addChildren(NmNomWbkItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNomWbkItmDODesc.class).getFKAttrDesc());        
	  }	  
}
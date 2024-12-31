package iih.nm.nom.nmnomwbkconfig.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nmnomwbkconfig.d.NmNomWbkConfigDO;
import iih.nm.nom.nmnomwbkconfig.d.NmNomWbkDepDO;
import iih.nm.nom.nmnomwbkconfig.d.desc.NmNomWbkDepDODesc;

/**
 * 护士长手册配置
 * @author
 *
 */
public class NmnomwbkconfigAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnomwbkconfigAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNomWbkConfigDO.class);
        addChildren(NmNomWbkDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNomWbkDepDODesc.class).getFKAttrDesc());        
	  }	  
}
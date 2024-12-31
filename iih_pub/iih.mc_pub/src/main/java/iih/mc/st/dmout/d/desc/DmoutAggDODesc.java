package iih.mc.st.dmout.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.st.dmout.d.McDamageOutDO;
import iih.mc.st.dmout.d.McDamageOutItmDO;
import iih.mc.st.dmout.d.desc.McDamageOutItmDODesc;

/**
 * 高值耗材报损
 * @author
 *
 */
public class DmoutAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public DmoutAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McDamageOutDO.class);
        addChildren(McDamageOutItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McDamageOutItmDODesc.class).getFKAttrDesc());        
	  }	  
}
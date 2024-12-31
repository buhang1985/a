package iih.bl.st.blstaroep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.st.blstaroep.d.BlStArOepDO;
import iih.bl.st.blstaroep.d.BlStArItmOepDO;
import iih.bl.st.blstaroep.d.desc.BlStArItmOepDODesc;
import iih.bl.st.blstaroep.d.BlStArSegOepDO;
import iih.bl.st.blstaroep.d.desc.BlStArSegOepDODesc;

/**
 * 结算应收_门急体
 * @author
 *
 */
public class BlstaroepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlstaroepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlStArOepDO.class);
        addChildren(BlStArItmOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlStArItmOepDODesc.class).getFKAttrDesc());        
        addChildren(BlStArSegOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlStArSegOepDODesc.class).getFKAttrDesc());        
	  }	  
}
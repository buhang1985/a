package iih.bl.st.blpaypatoep.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.desc.BlPayItmPatOepDODesc;

/**
 * 组件
 * @author
 *
 */
public class BlpaypatoepAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlpaypatoepAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlPayPatOepDO.class);
        addChildren(BlPayItmPatOepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlPayItmPatOepDODesc.class).getFKAttrDesc());        
	  }	  
}
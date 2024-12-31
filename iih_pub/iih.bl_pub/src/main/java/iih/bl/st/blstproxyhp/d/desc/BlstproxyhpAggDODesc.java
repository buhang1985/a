package iih.bl.st.blstproxyhp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bl.st.blstproxyhp.d.BlStProxyhpDO;
import iih.bl.st.blstproxyhp.d.BlStProxyhpItmDO;
import iih.bl.st.blstproxyhp.d.desc.BlStProxyhpItmDODesc;

/**
 * 代报结算_门急诊转住院
 * @author
 *
 */
public class BlstproxyhpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BlstproxyhpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(BlStProxyhpDO.class);
        addChildren(BlStProxyhpItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BlStProxyhpItmDODesc.class).getFKAttrDesc());        
	  }	  
}
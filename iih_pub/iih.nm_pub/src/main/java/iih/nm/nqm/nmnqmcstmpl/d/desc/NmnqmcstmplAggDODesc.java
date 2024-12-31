package iih.nm.nqm.nmnqmcstmpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nmnqmcstmpl.d.NmnqmcstmplDO;
import iih.nm.nqm.nmnqmcstmpl.d.NmnqmtmplitmDO;
import iih.nm.nqm.nmnqmcstmpl.d.desc.NmnqmtmplitmDODesc;

/**
 * 护理管理_检查标准模板
 * @author
 *
 */
public class NmnqmcstmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnqmcstmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmnqmcstmplDO.class);
        addChildren(NmnqmtmplitmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmnqmtmplitmDODesc.class).getFKAttrDesc());        
	  }	  
}
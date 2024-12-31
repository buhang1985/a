package iih.bd.srv.mrelement.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.mrelement.d.MrElementDO;
import iih.bd.srv.mrelement.d.MrEleValDO;
import iih.bd.srv.mrelement.d.desc.MrEleValDODesc;

/**
 * 病历元素
 * @author
 *
 */
public class BdmrdeAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BdmrdeAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MrElementDO.class);
        addChildren(MrEleValDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MrEleValDODesc.class).getFKAttrDesc());        
	  }	  
}
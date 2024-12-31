package iih.bd.srv.emrterm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.emrterm.d.EmrNormWordCaDO;
import iih.bd.srv.emrterm.d.EmrNormWordDO;
import iih.bd.srv.emrterm.d.desc.EmrNormWordDODesc;

/**
 * 病历常用词分类
 * @author
 *
 */
public class EmrnormwordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EmrnormwordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EmrNormWordCaDO.class);
        addChildren(EmrNormWordDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EmrNormWordDODesc.class).getFKAttrDesc());        
	  }	  
}
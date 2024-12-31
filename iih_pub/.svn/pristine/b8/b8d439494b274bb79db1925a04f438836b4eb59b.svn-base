package iih.bd.srv.ortpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.desc.OrTplNItmDODesc;

/**
 * 医嘱模板
 * @author
 *
 */
public class OrtmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OrtmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrTmplDO.class);
        addChildren(OrTplNItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrTplNItmDODesc.class).getFKAttrDesc());        
	  }	  
}
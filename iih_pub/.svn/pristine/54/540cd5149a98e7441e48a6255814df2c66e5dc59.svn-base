package iih.bd.srv.ortpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.ortpl.d.OrTplItmDO;
import iih.bd.srv.ortpl.d.OrTplItmDtDO;
import iih.bd.srv.ortpl.d.desc.OrTplItmDtDODesc;
import iih.bd.srv.ortpl.d.OrTplItmSetDO;
import iih.bd.srv.ortpl.d.desc.OrTplItmSetDODesc;

/**
 * 医嘱模板项目
 * @author
 *
 */
public class SrvortplitemAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SrvortplitemAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrTplItmDO.class);
        addChildren(OrTplItmDtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrTplItmDtDODesc.class).getFKAttrDesc());        
        addChildren(OrTplItmSetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrTplItmSetDODesc.class).getFKAttrDesc());        
	  }	  
}
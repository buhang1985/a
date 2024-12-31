package iih.nm.nhr.nmdeppl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmdeppl.d.NmDepplDO;
import iih.nm.nhr.nmdeppl.d.NmNurpsnPlDO;
import iih.nm.nhr.nmdeppl.d.desc.NmNurpsnPlDODesc;

/**
 * 实习科室轮转计划
 * @author
 *
 */
public class NmdepplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmdepplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmDepplDO.class);
        addChildren(NmNurpsnPlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNurpsnPlDODesc.class).getFKAttrDesc());        
	  }	  
}
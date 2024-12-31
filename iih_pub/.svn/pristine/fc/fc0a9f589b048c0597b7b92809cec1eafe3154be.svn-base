package iih.bd.fc.orwf.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.fc.orwf.d.OrWfCfgDO;
import iih.bd.fc.orwf.d.WfCfgAttrDO;
import iih.bd.fc.orwf.d.desc.WfCfgAttrDODesc;

/**
 * 医嘱流向
 * @author
 *
 */
public class OrwfAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OrwfAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrWfCfgDO.class);
        addChildren(WfCfgAttrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(WfCfgAttrDODesc.class).getFKAttrDesc());        
	  }	  
}
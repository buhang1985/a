package iih.bd.fc.orpltp.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.d.desc.OrpltpStaDODesc;

/**
 * 医嘱执行计划状态
 * @author
 *
 */
public class OrpltpAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OrpltpAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrpltpDO.class);
        addChildren(OrpltpStaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrpltpStaDODesc.class).getFKAttrDesc());        
	  }	  
}
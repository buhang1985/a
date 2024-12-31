package iih.bd.fc.orpltpmatch.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchAttrDO;
import iih.bd.fc.orpltpmatch.d.desc.OrpltpMatchAttrDODesc;

/**
 * 医嘱闭环匹配
 * @author
 *
 */
public class OrpltpmatchAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OrpltpmatchAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OrpltpMatchDO.class);
        addChildren(OrpltpMatchAttrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OrpltpMatchAttrDODesc.class).getFKAttrDesc());        
	  }	  
}
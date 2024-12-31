package iih.pe.pitm.pepsydef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pepsydef.d.PePsyTpDO;
import iih.pe.pitm.pepsydef.d.PePsyDefDO;
import iih.pe.pitm.pepsydef.d.desc.PePsyDefDODesc;

/**
 * 体检心理处方定义
 * @author
 *
 */
public class PepsydefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PepsydefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PePsyTpDO.class);
        addChildren(PePsyDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePsyDefDODesc.class).getFKAttrDesc());        
	  }	  
}
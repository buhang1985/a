package iih.mp.nr.nurhdv.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.nr.nurhdv.d.HdvEntDO;
import iih.mp.nr.nurhdv.d.HdvEntAttrDO;
import iih.mp.nr.nurhdv.d.desc.HdvEntAttrDODesc;
import iih.mp.nr.nurhdv.d.HdvEntTagtDO;
import iih.mp.nr.nurhdv.d.desc.HdvEntTagtDODesc;

/**
 * 护士交接班
 * @author
 *
 */
public class NurhdvAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NurhdvAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(HdvEntDO.class);
        addChildren(HdvEntAttrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HdvEntAttrDODesc.class).getFKAttrDesc());        
        addChildren(HdvEntTagtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(HdvEntTagtDODesc.class).getFKAttrDesc());        
	  }	  
}
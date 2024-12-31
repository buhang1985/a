package iih.mc.st.inspection.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mc.st.inspection.d.McInspectionDo;
import iih.mc.st.inspection.d.McInspectionItemDo;
import iih.mc.st.inspection.d.desc.McInspectionItemDoDesc;

/**
 * 高值耗材验收表
 * @author
 *
 */
public class InspectionAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public InspectionAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(McInspectionDo.class);
        addChildren(McInspectionItemDo.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(McInspectionItemDoDesc.class).getFKAttrDesc());        
	  }	  
}
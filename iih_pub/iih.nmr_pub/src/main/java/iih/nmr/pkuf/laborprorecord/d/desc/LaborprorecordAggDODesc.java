package iih.nmr.pkuf.laborprorecord.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.laborprorecord.d.PuerperainfoDO;
import iih.nmr.pkuf.laborprorecord.d.LaborprorecorditmDO;
import iih.nmr.pkuf.laborprorecord.d.desc.LaborprorecorditmDODesc;

/**
 * 产程观察护理记录
 * @author
 *
 */
public class LaborprorecordAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public LaborprorecordAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PuerperainfoDO.class);
        addChildren(LaborprorecorditmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(LaborprorecorditmDODesc.class).getFKAttrDesc());        
	  }	  
}
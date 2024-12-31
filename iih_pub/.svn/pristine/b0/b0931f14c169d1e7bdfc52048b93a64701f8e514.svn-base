package iih.bd.pp.singlediamt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.singlediamt.d.SingleDiAmtDO;
import iih.bd.pp.singlediamt.d.SingleDiDepAmtDO;
import iih.bd.pp.singlediamt.d.desc.SingleDiDepAmtDODesc;

/**
 * 医保计划单病种控费
 * @author
 *
 */
public class SinglediamtAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SinglediamtAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SingleDiAmtDO.class);
        addChildren(SingleDiDepAmtDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SingleDiDepAmtDODesc.class).getFKAttrDesc());        
	  }	  
}
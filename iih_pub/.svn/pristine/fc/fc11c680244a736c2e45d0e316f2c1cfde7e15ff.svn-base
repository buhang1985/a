package iih.pe.phm.perstin.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.perstin.d.PeRstinDO;
import iih.pe.phm.perstin.d.PeRstinDtlDO;
import iih.pe.phm.perstin.d.desc.PeRstinDtlDODesc;

/**
 * 体检手工录入结果
 * @author
 *
 */
public class PerstinAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstinAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstinDO.class);
        addChildren(PeRstinDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstinDtlDODesc.class).getFKAttrDesc());        
	  }	  
}
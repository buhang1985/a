package iih.pe.phm.perstsurvery.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.phm.perstsurvery.d.PeRstSurveryDO;
import iih.pe.phm.perstsurvery.d.PeRstSurveryKeyDO;
import iih.pe.phm.perstsurvery.d.desc.PeRstSurveryKeyDODesc;

/**
 * 体检问卷结果
 * @author
 *
 */
public class PerstsurveryAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstsurveryAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstSurveryDO.class);
        addChildren(PeRstSurveryKeyDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstSurveryKeyDODesc.class).getFKAttrDesc());        
	  }	  
}
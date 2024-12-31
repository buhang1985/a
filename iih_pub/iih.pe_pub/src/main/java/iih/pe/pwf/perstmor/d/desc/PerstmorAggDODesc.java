package iih.pe.pwf.perstmor.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pwf.perstmor.d.PeRstMorDO;
import iih.pe.pwf.perstmor.d.PeRstMorItmDO;
import iih.pe.pwf.perstmor.d.desc.PeRstMorItmDODesc;

/**
 * 体检形态学报告
 * @author
 *
 */
public class PerstmorAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PerstmorAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeRstMorDO.class);
        addChildren(PeRstMorItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeRstMorItmDODesc.class).getFKAttrDesc());        
	  }	  
}
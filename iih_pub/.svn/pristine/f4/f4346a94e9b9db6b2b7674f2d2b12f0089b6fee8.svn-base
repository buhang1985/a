package iih.nm.nit.nipracfbtmpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nipracfbtmpl.d.NiPracfbTmplDO;
import iih.nm.nit.nipracfbtmpl.d.NiPracfbTmplItmDO;
import iih.nm.nit.nipracfbtmpl.d.desc.NiPracfbTmplItmDODesc;

/**
 * 实习反馈模板
 * @author
 *
 */
public class NipracfbtmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NipracfbtmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NiPracfbTmplDO.class);
        addChildren(NiPracfbTmplItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NiPracfbTmplItmDODesc.class).getFKAttrDesc());        
	  }	  
}
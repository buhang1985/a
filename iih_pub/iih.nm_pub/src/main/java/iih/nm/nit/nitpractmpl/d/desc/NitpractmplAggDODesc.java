package iih.nm.nit.nitpractmpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nit.nitpractmpl.d.NitPractmplDO;
import iih.nm.nit.nitpractmpl.d.NitPractmplDepDO;
import iih.nm.nit.nitpractmpl.d.desc.NitPractmplDepDODesc;

/**
 * 护理管理_实习科室轮转模板
 * @author
 *
 */
public class NitpractmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NitpractmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NitPractmplDO.class);
        addChildren(NitPractmplDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NitPractmplDepDODesc.class).getFKAttrDesc());        
	  }	  
}
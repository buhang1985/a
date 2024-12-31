package iih.nm.nca.nmncatmpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nca.nmncatmpl.d.NmNcaTpmlDO;
import iih.nm.nca.nmncatmpl.d.NmNcaTmplItmDO;
import iih.nm.nca.nmncatmpl.d.desc.NmNcaTmplItmDODesc;

/**
 * 满意度问卷模板
 * @author
 *
 */
public class NmncatmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmncatmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNcaTpmlDO.class);
        addChildren(NmNcaTmplItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNcaTmplItmDODesc.class).getFKAttrDesc());        
	  }	  
}
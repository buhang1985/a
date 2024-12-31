package iih.nm.nca.nmncatmplca.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nca.nmncatmplca.d.NmNcaTmplcaDO;
import iih.nm.nca.nmncatmplca.d.NmNcaTmplOptaDO;
import iih.nm.nca.nmncatmplca.d.desc.NmNcaTmplOptaDODesc;

/**
 * 满意度问卷模板分类
 * @author
 *
 */
public class NmncatmplcaAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmncatmplcaAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNcaTmplcaDO.class);
        addChildren(NmNcaTmplOptaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNcaTmplOptaDODesc.class).getFKAttrDesc());        
	  }	  
}
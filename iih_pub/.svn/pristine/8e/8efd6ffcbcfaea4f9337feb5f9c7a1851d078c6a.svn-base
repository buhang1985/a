package iih.nmr.pkuf.nmrbase.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.nmrbase.d.NmrBaseDO;
import iih.nmr.pkuf.nmrbase.d.NmrBaseAttrDO;
import iih.nmr.pkuf.nmrbase.d.desc.NmrBaseAttrDODesc;

/**
 * 文书属性信息
 * @author
 *
 */
public class NmrbaseAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmrbaseAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmrBaseDO.class);
        addChildren(NmrBaseAttrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrBaseAttrDODesc.class).getFKAttrDesc());        
	  }	  
}
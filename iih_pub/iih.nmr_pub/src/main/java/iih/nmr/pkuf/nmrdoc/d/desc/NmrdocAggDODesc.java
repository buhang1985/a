package iih.nmr.pkuf.nmrdoc.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.nmrdoc.d.NmrDocDO;
import iih.nmr.pkuf.nmrdoc.d.NmrDocAttrDO;
import iih.nmr.pkuf.nmrdoc.d.desc.NmrDocAttrDODesc;

/**
 * 文书基本信息
 * @author
 *
 */
public class NmrdocAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmrdocAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmrDocDO.class);
        addChildren(NmrDocAttrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrDocAttrDODesc.class).getFKAttrDesc());        
	  }	  
}
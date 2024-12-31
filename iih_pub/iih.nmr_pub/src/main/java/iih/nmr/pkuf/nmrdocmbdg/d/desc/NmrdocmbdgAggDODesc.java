package iih.nmr.pkuf.nmrdocmbdg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.nmrdocmbdg.d.NmrDocMbdgDO;
import iih.nmr.pkuf.nmrdocmbdg.d.NmrDocMbdeDO;
import iih.nmr.pkuf.nmrdocmbdg.d.desc.NmrDocMbdeDODesc;

/**
 * 文书_移动_数据组
 * @author
 *
 */
public class NmrdocmbdgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmrdocmbdgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmrDocMbdgDO.class);
        addChildren(NmrDocMbdeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrDocMbdeDODesc.class).getFKAttrDesc());        
	  }	  
}
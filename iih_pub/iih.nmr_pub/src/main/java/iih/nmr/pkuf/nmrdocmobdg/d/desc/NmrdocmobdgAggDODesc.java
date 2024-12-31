package iih.nmr.pkuf.nmrdocmobdg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nmr.pkuf.nmrdocmobdg.d.NmrDocMobdgDO;
import iih.nmr.pkuf.nmrdocmobdg.d.NmrDocMobdeDO;
import iih.nmr.pkuf.nmrdocmobdg.d.desc.NmrDocMobdeDODesc;

/**
 * 移动数据集新版
 * @author
 *
 */
public class NmrdocmobdgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmrdocmobdgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmrDocMobdgDO.class);
        addChildren(NmrDocMobdeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmrDocMobdeDODesc.class).getFKAttrDesc());        
	  }	  
}
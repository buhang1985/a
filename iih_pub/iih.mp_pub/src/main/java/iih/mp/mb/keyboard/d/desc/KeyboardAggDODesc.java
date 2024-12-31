package iih.mp.mb.keyboard.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.mb.keyboard.d.KeyBoardDO;
import iih.mp.mb.keyboard.d.KeyBoardSrvDO;
import iih.mp.mb.keyboard.d.desc.KeyBoardSrvDODesc;

/**
 * 移动护理键盘
 * @author
 *
 */
public class KeyboardAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public KeyboardAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(KeyBoardDO.class);
        addChildren(KeyBoardSrvDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(KeyBoardSrvDODesc.class).getFKAttrDesc());        
	  }	  
}
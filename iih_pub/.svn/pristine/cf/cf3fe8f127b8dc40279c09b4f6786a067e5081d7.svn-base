package iih.en.que.board.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnBrdConfigDO;
import iih.en.que.board.d.desc.EnBrdConfigDODesc;

/**
 * 患者就诊_大屏
 * @author
 *
 */
public class EnbrddoAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public EnbrddoAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(EnBrdDO.class);
        addChildren(EnBrdConfigDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(EnBrdConfigDODesc.class).getFKAttrDesc());        
	  }	  
}
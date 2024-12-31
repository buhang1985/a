package iih.pe.por.pepsncard.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.por.pepsncard.d.PePsnCardDDO;
import iih.pe.por.pepsncard.d.PePsnCardRecDO;
import iih.pe.por.pepsncard.d.desc.PePsnCardRecDODesc;
import iih.pe.por.pepsncard.d.PePsnCardMemDO;
import iih.pe.por.pepsncard.d.desc.PePsnCardMemDODesc;

/**
 * 体检客户会员卡
 * @author
 *
 */
public class PepsncardAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PepsncardAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PePsnCardDDO.class);
        addChildren(PePsnCardRecDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePsnCardRecDODesc.class).getFKAttrDesc());        
        addChildren(PePsnCardMemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PePsnCardMemDODesc.class).getFKAttrDesc());        
	  }	  
}
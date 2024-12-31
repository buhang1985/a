package iih.ci.ord.specanti.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.ord.specanti.d.SpecAntiConsDO;
import iih.ci.ord.specanti.d.SpecAntiInvitesDO;
import iih.ci.ord.specanti.d.desc.SpecAntiInvitesDODesc;
import iih.ci.ord.specanti.d.SpecAntiReviewDO;
import iih.ci.ord.specanti.d.desc.SpecAntiReviewDODesc;

/**
 * 特殊使用级抗菌药物会诊申请
 * @author
 *
 */
public class SpecanticonsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SpecanticonsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SpecAntiConsDO.class);
        addChildren(SpecAntiInvitesDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SpecAntiInvitesDODesc.class).getFKAttrDesc());        
        addChildren(SpecAntiReviewDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(SpecAntiReviewDODesc.class).getFKAttrDesc());        
	  }	  
}
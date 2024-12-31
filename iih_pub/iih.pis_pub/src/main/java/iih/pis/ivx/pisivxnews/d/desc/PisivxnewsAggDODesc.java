package iih.pis.ivx.pisivxnews.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pis.ivx.pisivxnews.d.PisivxNewsDO;
import iih.pis.ivx.pisivxnews.d.PisivxArticleDO;
import iih.pis.ivx.pisivxnews.d.desc.PisivxArticleDODesc;

/**
 * 微信服务-新闻服务
 * @author
 *
 */
public class PisivxnewsAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PisivxnewsAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PisivxNewsDO.class);
        addChildren(PisivxArticleDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PisivxArticleDODesc.class).getFKAttrDesc());        
	  }	  
}
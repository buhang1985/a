package iih.mp.dg.mpdgshetpprntmpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.mp.dg.mpdgshetpprntmpl.d.MpdgShetpPrntmplDO;
import iih.mp.dg.mpdgshetpprntmpl.d.MpdgShetpPrntmplIitmDO;
import iih.mp.dg.mpdgshetpprntmpl.d.desc.MpdgShetpPrntmplIitmDODesc;

/**
 * 药单打印模板管理
 * @author
 *
 */
public class MpdgshetpprntmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MpdgshetpprntmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MpdgShetpPrntmplDO.class);
        addChildren(MpdgShetpPrntmplIitmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MpdgShetpPrntmplIitmDODesc.class).getFKAttrDesc());        
	  }	  
}
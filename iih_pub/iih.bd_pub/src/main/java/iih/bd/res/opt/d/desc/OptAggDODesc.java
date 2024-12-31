package iih.bd.res.opt.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.res.opt.d.OptDO;
import iih.bd.res.opt.d.OptFaDO;
import iih.bd.res.opt.d.desc.OptFaDODesc;
import iih.bd.res.opt.d.OptDepDO;
import iih.bd.res.opt.d.desc.OptDepDODesc;
import iih.bd.res.opt.d.OptEntpDO;
import iih.bd.res.opt.d.desc.OptEntpDODesc;

/**
 * 手术台
 * @author
 *
 */
public class OptAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public OptAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(OptDO.class);
        addChildren(OptFaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OptFaDODesc.class).getFKAttrDesc());        
        addChildren(OptDepDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OptDepDODesc.class).getFKAttrDesc());        
        addChildren(OptEntpDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(OptEntpDODesc.class).getFKAttrDesc());        
	  }	  
}
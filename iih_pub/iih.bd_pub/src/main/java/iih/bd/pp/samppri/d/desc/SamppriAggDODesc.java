package iih.bd.pp.samppri.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.pp.samppri.d.SampPriDO;
import iih.bd.pp.samppri.d.BdSampPriItmDO;
import iih.bd.pp.samppri.d.desc.BdSampPriItmDODesc;

/**
 * 标本费用对照
 * @author
 *
 */
public class SamppriAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public SamppriAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(SampPriDO.class);
        addChildren(BdSampPriItmDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdSampPriItmDODesc.class).getFKAttrDesc());        
	  }	  
}
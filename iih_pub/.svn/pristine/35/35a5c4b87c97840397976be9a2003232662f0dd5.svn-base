package iih.nm.nhr.nmnhrsi.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nhr.nmnhrsi.d.NmNhrSiDO;
import iih.nm.nhr.nmnhrsi.d.NmNhrSiBedDO;
import iih.nm.nhr.nmnhrsi.d.desc.NmNhrSiBedDODesc;

/**
 * 班次信息
 * @author
 *
 */
public class NmnhrsiAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NmnhrsiAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNhrSiDO.class);
        addChildren(NmNhrSiBedDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNhrSiBedDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.nm.nqm.nqmchkitm.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nqm.nqmchkitm.d.NmNqmChkitmcaDo;
import iih.nm.nqm.nqmchkitm.d.NmNqmChkitmDo;
import iih.nm.nqm.nqmchkitm.d.desc.NmNqmChkitmDoDesc;

/**
 * 护理管理_评分项目
 * @author
 *
 */
public class NqmchkitmAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NqmchkitmAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NmNqmChkitmcaDo.class);
        addChildren(NmNqmChkitmDo.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NmNqmChkitmDoDesc.class).getFKAttrDesc());        
	  }	  
}
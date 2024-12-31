package iih.ci.mr.mrsign.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.d.CiMrSignCaDO;
import iih.ci.mr.mrsign.d.desc.CiMrSignCaDODesc;

/**
 * 临床医疗记录签名
 * @author
 *
 */
public class MrsignAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MrsignAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(CiMrSignDO.class);
        addChildren(CiMrSignCaDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(CiMrSignCaDODesc.class).getFKAttrDesc());        
	  }	  
}
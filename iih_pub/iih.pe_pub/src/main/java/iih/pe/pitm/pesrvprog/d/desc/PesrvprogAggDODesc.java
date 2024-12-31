package iih.pe.pitm.pesrvprog.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pesrvprog.d.PeSrvProgDO;
import iih.pe.pitm.pesrvprog.d.PeSrvProgAgeDO;
import iih.pe.pitm.pesrvprog.d.desc.PeSrvProgAgeDODesc;

/**
 * 体检方案定义
 * @author
 *
 */
public class PesrvprogAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PesrvprogAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeSrvProgDO.class);
        addChildren(PeSrvProgAgeDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvProgAgeDODesc.class).getFKAttrDesc());        
	  }	  
}
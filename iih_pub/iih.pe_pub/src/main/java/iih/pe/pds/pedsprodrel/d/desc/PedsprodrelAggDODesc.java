package iih.pe.pds.pedsprodrel.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pds.pedsprodrel.d.PeDsProdRelDO;
import iih.pe.pds.pedsprodrel.d.PeDsProdRelDtlDO;
import iih.pe.pds.pedsprodrel.d.desc.PeDsProdRelDtlDODesc;

/**
 * 体检产品项目关联关系
 * @author
 *
 */
public class PedsprodrelAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PedsprodrelAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeDsProdRelDO.class);
        addChildren(PeDsProdRelDtlDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeDsProdRelDtlDODesc.class).getFKAttrDesc());        
	  }	  
}
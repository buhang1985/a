package iih.bd.mm.materialnames.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.mm.materialnames.d.desc.MnAliasSetDODesc;
import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.mm.materialnames.d.desc.MnCodeSetDODesc;
import iih.bd.mm.materialnames.d.MaterialsDO;
import iih.bd.mm.materialnames.d.desc.MaterialsDODesc;

/**
 * 药品通用名目录
 * @author
 *
 */
public class MaterialnamesAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MaterialnamesAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MaterialNamesDO.class);
        addChildren(MnAliasSetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MnAliasSetDODesc.class).getFKAttrDesc());        
        addChildren(MnCodeSetDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MnCodeSetDODesc.class).getFKAttrDesc());        
        addChildren(MaterialsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MaterialsDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.bd.res.bed.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.Bdbedfa;
import iih.bd.res.bed.d.desc.BdbedfaDesc;
import iih.bd.res.bed.d.BedAttrDO;
import iih.bd.res.bed.d.desc.BedAttrDODesc;

/**
 * 床位管理
 * @author
 *
 */
public class BedAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public BedAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(Bdbed.class);
        addChildren(Bdbedfa.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BdbedfaDesc.class).getFKAttrDesc());        
        addChildren(BedAttrDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(BedAttrDODesc.class).getFKAttrDesc());        
	  }	  
}
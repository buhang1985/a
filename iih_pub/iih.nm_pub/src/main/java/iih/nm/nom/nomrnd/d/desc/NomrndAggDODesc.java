package iih.nm.nom.nomrnd.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nomrnd.d.NomRndDO;
import iih.nm.nom.nomrnd.d.NomRndPsnDO;
import iih.nm.nom.nomrnd.d.desc.NomRndPsnDODesc;

/**
 * 护理查房记录
 * @author
 *
 */
public class NomrndAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NomrndAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NomRndDO.class);
        addChildren(NomRndPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NomRndPsnDODesc.class).getFKAttrDesc());        
	  }	  
}
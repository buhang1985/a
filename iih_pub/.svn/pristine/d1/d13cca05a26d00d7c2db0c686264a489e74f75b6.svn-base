package iih.nm.nom.nomev.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nomev.d.NomEvDO;
import iih.nm.nom.nomev.d.NomEvFileDO;
import iih.nm.nom.nomev.d.desc.NomEvFileDODesc;
import iih.nm.nom.nomev.d.NomEvPsnDO;
import iih.nm.nom.nomev.d.desc.NomEvPsnDODesc;

/**
 * 护理部大事记
 * @author
 *
 */
public class NomevAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NomevAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NomEvDO.class);
        addChildren(NomEvFileDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NomEvFileDODesc.class).getFKAttrDesc());        
        addChildren(NomEvPsnDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NomEvPsnDODesc.class).getFKAttrDesc());        
	  }	  
}
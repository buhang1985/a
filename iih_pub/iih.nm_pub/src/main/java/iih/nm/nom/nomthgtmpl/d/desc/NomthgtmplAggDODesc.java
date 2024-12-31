package iih.nm.nom.nomthgtmpl.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.nm.nom.nomthgtmpl.d.NomThgTmplCaDO;
import iih.nm.nom.nomthgtmpl.d.NomThgTmplDO;
import iih.nm.nom.nomthgtmpl.d.desc.NomThgTmplDODesc;

/**
 * 病区事物记录模板
 * @author
 *
 */
public class NomthgtmplAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public NomthgtmplAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(NomThgTmplCaDO.class);
        addChildren(NomThgTmplDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(NomThgTmplDODesc.class).getFKAttrDesc());        
	  }	  
}
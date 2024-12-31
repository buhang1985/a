package iih.bd.srv.medsrvpkg.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.bd.srv.medsrvpkg.d.MedSrvPkgDO;
import iih.bd.srv.medsrvpkg.d.MedSrvPkgItemDO;
import iih.bd.srv.medsrvpkg.d.desc.MedSrvPkgItemDODesc;

/**
 * 医疗服务包
 * @author
 *
 */
public class MedsrvpkgAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public MedsrvpkgAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(MedSrvPkgDO.class);
        addChildren(MedSrvPkgItemDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(MedSrvPkgItemDODesc.class).getFKAttrDesc());        
	  }	  
}
package iih.pe.pitm.pesrvsetdef.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetDefDO;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetItmDefDO;
import iih.pe.pitm.pesrvsetdef.d.desc.PeSrvSetItmDefDODesc;
import iih.pe.pitm.pesrvsetdef.d.PeSrvSetIllDefDO;
import iih.pe.pitm.pesrvsetdef.d.desc.PeSrvSetIllDefDODesc;

/**
 * 体检套餐定义（项目组合）
 * @author
 *
 */
public class PesrvsetdefAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PesrvsetdefAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeSrvSetDefDO.class);
        addChildren(PeSrvSetItmDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvSetItmDefDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvSetIllDefDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvSetIllDefDODesc.class).getFKAttrDesc());        
	  }	  
}
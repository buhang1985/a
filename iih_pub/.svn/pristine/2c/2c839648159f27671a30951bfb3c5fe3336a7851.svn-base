package iih.pe.pitm.pesrvitem.d.desc;

import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.desc.ent.agg.AbstractAggDesc;
import iih.pe.pitm.pesrvitem.d.PeSrvItemDO;
import iih.pe.pitm.pesrvitem.d.PeSrvitmDiagDO;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmDiagDODesc;
import iih.pe.pitm.pesrvitem.d.PeSrvitmSuggDO;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmSuggDODesc;
import iih.pe.pitm.pesrvitem.d.PeSrvitmOptsDO;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmOptsDODesc;
import iih.pe.pitm.pesrvitem.d.PeSrvitmSignDO;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmSignDODesc;
import iih.pe.pitm.pesrvitem.d.PeSrvitmLisDO;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmLisDODesc;
import iih.pe.pitm.pesrvitem.d.PeSrvitmRisDO;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmRisDODesc;
import iih.pe.pitm.pesrvitem.d.PeSrvitmWarnValDO;
import iih.pe.pitm.pesrvitem.d.desc.PeSrvitmWarnValDODesc;

/**
 * 体检检查项目结果
 * @author
 *
 */
public class PesrvitemAggDODesc extends AbstractAggDesc {
	
	 /**
	  * 无参构造函数
	  */
	 public PesrvitemAggDODesc()
	  {
	    init();
	  }

	  /**
	   * 数据初始化
	   */
	  private void init() {
	    setParent(PeSrvItemDO.class);
        addChildren(PeSrvitmDiagDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvitmDiagDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvitmSuggDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvitmSuggDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvitmOptsDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvitmOptsDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvitmSignDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvitmSignDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvitmLisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvitmLisDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvitmRisDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvitmRisDODesc.class).getFKAttrDesc());        
        addChildren(PeSrvitmWarnValDO.class);
        addChildForeignKey(DescManager.getInstance().getDODesc(PeSrvitmWarnValDODesc.class).getFKAttrDesc());        
	  }	  
}
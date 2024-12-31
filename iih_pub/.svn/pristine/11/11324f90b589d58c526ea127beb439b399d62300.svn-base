package iih.bd.srv.outputtemplate.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.outputtemplate.d.desc.OutputtemplateAggDODesc;



/**
 * 输出模板
 */
public class OutputtemplateAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OutputTemplateDO getParentDO() {
		return ((OutputTemplateDO) super.getParentDO());
	}

	public void setParentDO(OutputTemplateDO headDO) {
		setParent(headDO);
	}

	public OutputTemplateMedRedTypeDO[] getOutputTemplateMedRedTypeDO() {
		IBaseDO[] dos = getChildren(OutputTemplateMedRedTypeDO.class);
		if(dos==null) return null;
		OutputTemplateMedRedTypeDO[] result=new OutputTemplateMedRedTypeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OutputTemplateMedRedTypeDO)dos[i];
		}
		return result;
	}
	
	public void setOutputTemplateMedRedTypeDO(OutputTemplateMedRedTypeDO[] dos) {
		setChildren(OutputTemplateMedRedTypeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OutputtemplateAggDODesc desc = new OutputtemplateAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OutputTemplateDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.outputtemplate.d.OutputTemplateMedRedTypeDO")) {
             return new OutputTemplateMedRedTypeDO();
         }
         return null;
     }
}
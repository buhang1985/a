package iih.mc.st.inspection.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mc.st.inspection.d.desc.InspectionAggDODesc;



/**
 * 高值耗材验收表
 */
public class InspectionAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public McInspectionDo getParentDO() {
		return ((McInspectionDo) super.getParentDO());
	}

	public void setParentDO(McInspectionDo headDO) {
		setParent(headDO);
	}

	public McInspectionItemDo[] getMcInspectionItemDo() {
		IBaseDO[] dos = getChildren(McInspectionItemDo.class);
		if(dos==null) return null;
		McInspectionItemDo[] result=new McInspectionItemDo[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(McInspectionItemDo)dos[i];
		}
		return result;
	}
	
	public void setMcInspectionItemDo(McInspectionItemDo[] dos) {
		setChildren(McInspectionItemDo.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		InspectionAggDODesc desc = new InspectionAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new McInspectionDo();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mc.st.inspection.d.McInspectionItemDo")) {
             return new McInspectionItemDo();
         }
         return null;
     }
}
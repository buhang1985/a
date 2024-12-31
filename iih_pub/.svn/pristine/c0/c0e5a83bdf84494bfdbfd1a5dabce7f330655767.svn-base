package iih.pe.pds.pedsprodrel.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pds.pedsprodrel.d.desc.PedsprodrelAggDODesc;



/**
 * 体检产品项目关联关系
 */
public class PedsprodrelAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDsProdRelDO getParentDO() {
		return ((PeDsProdRelDO) super.getParentDO());
	}

	public void setParentDO(PeDsProdRelDO headDO) {
		setParent(headDO);
	}

	public PeDsProdRelDtlDO[] getPeDsProdRelDtlDO() {
		IBaseDO[] dos = getChildren(PeDsProdRelDtlDO.class);
		if(dos==null) return null;
		PeDsProdRelDtlDO[] result=new PeDsProdRelDtlDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDsProdRelDtlDO)dos[i];
		}
		return result;
	}
	
	public void setPeDsProdRelDtlDO(PeDsProdRelDtlDO[] dos) {
		setChildren(PeDsProdRelDtlDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PedsprodrelAggDODesc desc = new PedsprodrelAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDsProdRelDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pds.pedsprodrel.d.PeDsProdRelDtlDO")) {
             return new PeDsProdRelDtlDO();
         }
         return null;
     }
}
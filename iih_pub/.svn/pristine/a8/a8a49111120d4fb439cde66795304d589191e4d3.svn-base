package iih.bd.pp.singlediamt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.singlediamt.d.desc.SinglediamtAggDODesc;



/**
 * 医保计划单病种控费
 */
public class SinglediamtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SingleDiAmtDO getParentDO() {
		return ((SingleDiAmtDO) super.getParentDO());
	}

	public void setParentDO(SingleDiAmtDO headDO) {
		setParent(headDO);
	}

	public SingleDiDepAmtDO[] getSingleDiDepAmtDO() {
		IBaseDO[] dos = getChildren(SingleDiDepAmtDO.class);
		if(dos==null) return null;
		SingleDiDepAmtDO[] result=new SingleDiDepAmtDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(SingleDiDepAmtDO)dos[i];
		}
		return result;
	}
	
	public void setSingleDiDepAmtDO(SingleDiDepAmtDO[] dos) {
		setChildren(SingleDiDepAmtDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SinglediamtAggDODesc desc = new SinglediamtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SingleDiAmtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.singlediamt.d.SingleDiDepAmtDO")) {
             return new SingleDiDepAmtDO();
         }
         return null;
     }
}
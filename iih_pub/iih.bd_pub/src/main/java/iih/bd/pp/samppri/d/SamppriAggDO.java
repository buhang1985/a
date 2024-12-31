package iih.bd.pp.samppri.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.pp.samppri.d.desc.SamppriAggDODesc;



/**
 * 标本费用对照
 */
public class SamppriAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public SampPriDO getParentDO() {
		return ((SampPriDO) super.getParentDO());
	}

	public void setParentDO(SampPriDO headDO) {
		setParent(headDO);
	}

	public BdSampPriItmDO[] getBdSampPriItmDO() {
		IBaseDO[] dos = getChildren(BdSampPriItmDO.class);
		if(dos==null) return null;
		BdSampPriItmDO[] result=new BdSampPriItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BdSampPriItmDO)dos[i];
		}
		return result;
	}
	
	public void setBdSampPriItmDO(BdSampPriItmDO[] dos) {
		setChildren(BdSampPriItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		SamppriAggDODesc desc = new SamppriAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new SampPriDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.pp.samppri.d.BdSampPriItmDO")) {
             return new BdSampPriItmDO();
         }
         return null;
     }
}
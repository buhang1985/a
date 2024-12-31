package iih.bd.srv.emrtpl.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.emrtpl.d.desc.EmrtplAggDODesc;



/**
 * 医疗记录模板
 */
public class EmrtplAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EmrTplDO getParentDO() {
		return ((EmrTplDO) super.getParentDO());
	}

	public void setParentDO(EmrTplDO headDO) {
		setParent(headDO);
	}

	public MrTplRelDO[] getMrTplRelDO() {
		IBaseDO[] dos = getChildren(MrTplRelDO.class);
		if(dos==null) return null;
		MrTplRelDO[] result=new MrTplRelDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrTplRelDO)dos[i];
		}
		return result;
	}
	
	public void setMrTplRelDO(MrTplRelDO[] dos) {
		setChildren(MrTplRelDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		EmrtplAggDODesc desc = new EmrtplAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new EmrTplDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.emrtpl.d.MrTplRelDO")) {
             return new MrTplRelDO();
         }
         return null;
     }
}
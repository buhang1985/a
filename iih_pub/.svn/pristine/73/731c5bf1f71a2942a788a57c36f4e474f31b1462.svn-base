package iih.ci.mr.mrsign.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.mrsign.d.desc.MrsignAggDODesc;



/**
 * 临床医疗记录签名
 */
public class MrsignAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrSignDO getParentDO() {
		return ((CiMrSignDO) super.getParentDO());
	}

	public void setParentDO(CiMrSignDO headDO) {
		setParent(headDO);
	}

	public CiMrSignCaDO[] getCiMrSignCaDO() {
		IBaseDO[] dos = getChildren(CiMrSignCaDO.class);
		if(dos==null) return null;
		CiMrSignCaDO[] result=new CiMrSignCaDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrSignCaDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrSignCaDO(CiMrSignCaDO[] dos) {
		setChildren(CiMrSignCaDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrsignAggDODesc desc = new MrsignAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrSignDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.mrsign.d.CiMrSignCaDO")) {
             return new CiMrSignCaDO();
         }
         return null;
     }
}
package iih.pe.por.pecorpbinfo.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.por.pecorpbinfo.d.desc.PecorpbinfoAggDODesc;



/**
 * 体检团体信息
 */
public class PecorpbinfoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeCorpbInfoDO getParentDO() {
		return ((PeCorpbInfoDO) super.getParentDO());
	}

	public void setParentDO(PeCorpbInfoDO headDO) {
		setParent(headDO);
	}

	public PeCorpDeptDO[] getPeCorpDeptDO() {
		IBaseDO[] dos = getChildren(PeCorpDeptDO.class);
		if(dos==null) return null;
		PeCorpDeptDO[] result=new PeCorpDeptDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCorpDeptDO)dos[i];
		}
		return result;
	}
	
	public void setPeCorpDeptDO(PeCorpDeptDO[] dos) {
		setChildren(PeCorpDeptDO.class, dos);
	}
	public PeCorpPrivacyDO[] getPeCorpPrivacyDO() {
		IBaseDO[] dos = getChildren(PeCorpPrivacyDO.class);
		if(dos==null) return null;
		PeCorpPrivacyDO[] result=new PeCorpPrivacyDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeCorpPrivacyDO)dos[i];
		}
		return result;
	}
	
	public void setPeCorpPrivacyDO(PeCorpPrivacyDO[] dos) {
		setChildren(PeCorpPrivacyDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PecorpbinfoAggDODesc desc = new PecorpbinfoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeCorpbInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.por.pecorpbinfo.d.PeCorpDeptDO")) {
             return new PeCorpDeptDO();
         }
	    else if (clzName.equals("iih.pe.por.pecorpbinfo.d.PeCorpPrivacyDO")) {
             return new PeCorpPrivacyDO();
         }
         return null;
     }
}
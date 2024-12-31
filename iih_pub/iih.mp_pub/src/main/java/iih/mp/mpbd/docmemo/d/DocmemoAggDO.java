package iih.mp.mpbd.docmemo.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.mp.mpbd.docmemo.d.desc.DocmemoAggDODesc;



/**
 * 医生备忘录
 */
public class DocmemoAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public DocrMemoDO getParentDO() {
		return ((DocrMemoDO) super.getParentDO());
	}

	public void setParentDO(DocrMemoDO headDO) {
		setParent(headDO);
	}

	public DocMemoFileDO[] getDocMemoFileDO() {
		IBaseDO[] dos = getChildren(DocMemoFileDO.class);
		if(dos==null) return null;
		DocMemoFileDO[] result=new DocMemoFileDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(DocMemoFileDO)dos[i];
		}
		return result;
	}
	
	public void setDocMemoFileDO(DocMemoFileDO[] dos) {
		setChildren(DocMemoFileDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		DocmemoAggDODesc desc = new DocmemoAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new DocrMemoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.mp.mpbd.docmemo.d.DocMemoFileDO")) {
             return new DocMemoFileDO();
         }
         return null;
     }
}
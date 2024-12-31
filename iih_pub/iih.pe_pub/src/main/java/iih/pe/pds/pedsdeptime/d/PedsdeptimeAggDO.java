package iih.pe.pds.pedsdeptime.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.pe.pds.pedsdeptime.d.desc.PedsdeptimeAggDODesc;



/**
 * 体检科室检查时间优化
 */
public class PedsdeptimeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PeDsDeptimeDO getParentDO() {
		return ((PeDsDeptimeDO) super.getParentDO());
	}

	public void setParentDO(PeDsDeptimeDO headDO) {
		setParent(headDO);
	}

	public PeDsDeptimeChkDO[] getPeDsDeptimeChkDO() {
		IBaseDO[] dos = getChildren(PeDsDeptimeChkDO.class);
		if(dos==null) return null;
		PeDsDeptimeChkDO[] result=new PeDsDeptimeChkDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PeDsDeptimeChkDO)dos[i];
		}
		return result;
	}
	
	public void setPeDsDeptimeChkDO(PeDsDeptimeChkDO[] dos) {
		setChildren(PeDsDeptimeChkDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PedsdeptimeAggDODesc desc = new PedsdeptimeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PeDsDeptimeDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.pe.pds.pedsdeptime.d.PeDsDeptimeChkDO")) {
             return new PeDsDeptimeChkDO();
         }
         return null;
     }
}
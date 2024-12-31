package iih.bd.srv.mrtplstblsec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.bd.srv.mrtplstblsec.d.desc.MrtplstblsecAggDODesc;



/**
 * 医疗记录模板智能表格段落
 */
public class MrtplstblsecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public MrTplSTblSecDO getParentDO() {
		return ((MrTplSTblSecDO) super.getParentDO());
	}

	public void setParentDO(MrTplSTblSecDO headDO) {
		setParent(headDO);
	}

	public MrTplSTblSecItmDO[] getMrTplSTblSecItmDO() {
		IBaseDO[] dos = getChildren(MrTplSTblSecItmDO.class);
		if(dos==null) return null;
		MrTplSTblSecItmDO[] result=new MrTplSTblSecItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(MrTplSTblSecItmDO)dos[i];
		}
		return result;
	}
	
	public void setMrTplSTblSecItmDO(MrTplSTblSecItmDO[] dos) {
		setChildren(MrTplSTblSecItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		MrtplstblsecAggDODesc desc = new MrtplstblsecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new MrTplSTblSecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.bd.srv.mrtplstblsec.d.MrTplSTblSecItmDO")) {
             return new MrTplSTblSecItmDO();
         }
         return null;
     }
}
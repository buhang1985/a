package iih.nmr.ha.tcho.ipevalsigle.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.ha.tcho.ipevalsigle.d.desc.TchoipevalsigleAggDODesc;



/**
 * 住院患者评价单
 */
public class TchoipevalsigleAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TchoEvaluateDO getParentDO() {
		return ((TchoEvaluateDO) super.getParentDO());
	}

	public void setParentDO(TchoEvaluateDO headDO) {
		setParent(headDO);
	}

	public TchoEvaluateItmDO[] getTchoEvaluateItmDO() {
		IBaseDO[] dos = getChildren(TchoEvaluateItmDO.class);
		if(dos==null) return null;
		TchoEvaluateItmDO[] result=new TchoEvaluateItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TchoEvaluateItmDO)dos[i];
		}
		return result;
	}
	
	public void setTchoEvaluateItmDO(TchoEvaluateItmDO[] dos) {
		setChildren(TchoEvaluateItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		TchoipevalsigleAggDODesc desc = new TchoipevalsigleAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TchoEvaluateDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.ha.tcho.ipevalsigle.d.TchoEvaluateItmDO")) {
             return new TchoEvaluateItmDO();
         }
         return null;
     }
}
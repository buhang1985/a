package iih.nmr.ha.tcho.sugeryip.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.nmr.ha.tcho.sugeryip.d.desc.Surgeryip1AggDODesc;



/**
 * 外科住院患者护理记录单
 */
public class Surgeryip1AggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public TchoSurgeryPatInfoDO getParentDO() {
		return ((TchoSurgeryPatInfoDO) super.getParentDO());
	}

	public void setParentDO(TchoSurgeryPatInfoDO headDO) {
		setParent(headDO);
	}

	public TchoSurgeryIpDO[] getTchoSurgeryIpDO() {
		IBaseDO[] dos = getChildren(TchoSurgeryIpDO.class);
		if(dos==null) return null;
		TchoSurgeryIpDO[] result=new TchoSurgeryIpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(TchoSurgeryIpDO)dos[i];
		}
		return result;
	}
	
	public void setTchoSurgeryIpDO(TchoSurgeryIpDO[] dos) {
		setChildren(TchoSurgeryIpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		Surgeryip1AggDODesc desc = new Surgeryip1AggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new TchoSurgeryPatInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.nmr.ha.tcho.sugeryip.d.TchoSurgeryIpDO")) {
             return new TchoSurgeryIpDO();
         }
         return null;
     }
}
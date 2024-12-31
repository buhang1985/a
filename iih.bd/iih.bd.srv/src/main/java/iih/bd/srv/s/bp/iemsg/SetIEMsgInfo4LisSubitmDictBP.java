package iih.bd.srv.s.bp.iemsg;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.iemsg.d.IELisSubitmDictDTO;

/**
 * MS064 ：检验子项目字典
 * @author YANG
 *
 */
public class SetIEMsgInfo4LisSubitmDictBP {

	public void exec(IELisSubitmDictDTO[] dtos){
		if (dtos == null || dtos.length <= 0)
			return;
		
		for(IELisSubitmDictDTO dto:dtos){
			switch(dto.getAction()){
			case IBdSrvIEEventConst.ACTION_INSERT:
				break;
			case IBdSrvIEEventConst.ACTION_UPDATE:
				break;
			case IBdSrvIEEventConst.ACTION_DELETE:
				break;
			}
		}
	}
}

package iih.ci.ord.s.bp;

import iih.ci.ord.dto.d.LabDTO;
import iih.ci.ord.s.bp.qry.getLabItmsQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getLabItms8DateBP {
	
	public LabDTO[] exec(String idpat,FDateTime dt_end,FDateTime dt_start,String[] srvlist) throws BizException{
		
		StringBuilder sb=new StringBuilder();
		Boolean flag=true;
		for (String s : srvlist) {
			if(flag){
				flag=false;
			}else{
			     sb.append(",");
			}
			sb.append(String.format("'%s'", s));
		}

		getLabItmsQry qry=new getLabItmsQry(idpat,sb.toString(),dt_end.toString(),dt_start.toString());
		LabDTO[] rtn =  (LabDTO[])AppFwUtil.getDORstWithDao(qry, LabDTO.class);
		 return rtn;

		}

}

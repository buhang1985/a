package iih.bl.pay.designedfundspkgcollect.bp;

import iih.bl.pay.dto.d.PipatSrvPkgDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class execQryAllPipatSrvPkgDTOs {

	/***
	    * 得到所有可用的优惠包，和患者无关
	    * @return
	    * @throws BizException
	    */
	  public PipatSrvPkgDTO[] execQryAllPipatSrvPkgDTOs()throws BizException{
		  StringBuffer sb=new StringBuffer();
		   sb.append(" select A.id_srvpkg,A.NAME,A.code ,A.id_srvpkgbltp,A.sd_srvpkgbltp,A.fg_multien,A.Fg_Entp_Er,A.Fg_Entp_Fm,A.Fg_Entp_Ip,A.Fg_Entp_Op,A.Fg_Entp_Pe, ");
		   sb.append("  B.amt,B.id_pripkg  ");
		   sb.append("        from  bd_srv_pkg       A  ");
		   sb.append("      left  join    bd_pri_pkg       B ");
		   sb.append("        on A.id_srvpkg=B.id_srvpkg ");
		   sb.append("   ");
		   
		   @SuppressWarnings("unchecked")
		   List<PipatSrvPkgDTO> list  = (List<PipatSrvPkgDTO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(PipatSrvPkgDTO.class));
		   PipatSrvPkgDTO[]  ppspDOArr=list.toArray(new PipatSrvPkgDTO[]{});
		   return ppspDOArr;
	  }
	
}

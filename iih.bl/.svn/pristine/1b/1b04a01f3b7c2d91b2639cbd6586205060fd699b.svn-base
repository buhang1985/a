package iih.bl.pay.designedfundspkgcollect.bp;

import iih.bl.pay.dto.d.PipatSrvPkgDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class execQryPiPatSrvPkgDTOById {
	/**
	 * 通过患者的主键id获得改患者名下的优惠包
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public PipatSrvPkgDTO[] execfindPiPatSrvPkgDTOByIdpat(String id_pat) throws BizException {
		// TODO Auto-generated method stub
		 StringBuffer sb=new StringBuffer();
		   sb.append(" select A.id_srvpkg,A.name,B.amt,C.code as code_pat,C.name as name_pat,D.name as name_empinc  ");
		   sb.append("  ");
		   sb.append("        from  pi_pat_srv_pkg  A ");
		   sb.append("   left  join  bd_pri_pkg     B ");
		   sb.append("       on A.id_srvpkg=B.id_srvpkg ");
		   sb.append("    join       pi_pat         C  ");
		   sb.append("       on A.id_pat=C.id_pat ");
		   sb.append("    join       bd_psndoc      D  ");
		   sb.append("       on A.id_emp_sale=D.id_psndoc");
		   sb.append(" where fg_pay='N'  ");
		  // sb.append("     and  A.id_pat='").append(id_pat).append("' ");
		   sb.append("     and  A.id_pat=?  ");
		   SqlParam sqlparam=new SqlParam();
		   sqlparam.addParam(id_pat);
		 
		   @SuppressWarnings("unchecked")
		   List<PipatSrvPkgDTO> list  = (List<PipatSrvPkgDTO>)new DAFacade().execQuery(sb.toString(),sqlparam, new BeanListHandler(PipatSrvPkgDTO.class));
		   PipatSrvPkgDTO[]  ppspDOArr=list.toArray(new PipatSrvPkgDTO[]{});
		   return ppspDOArr;
	}
}

package iih.bd.pp.bdprisamp.bp;

import java.util.List;

import iih.bd.pp.bdprisamp.d.BdPriSampDO;
import iih.bd.pp.bdprisamp.i.IBdprisampRService;
import iih.bd.pp.dto.d.BdPriSampDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;


public class BdPriSampBp {
	/**
	 * 根据标本类型查询标本采集费用对照
	 * @param sd_samptp 标本类型
	 * @return 标本采集费用对照
	 * @throws BizException
	 */
	public BdPriSampDO[] getBdPriSampDOBySampTp(String sd_samptp)
			throws BizException {
		IBdprisampRService iBdprisampRService=ServiceFinder.find(IBdprisampRService.class);
		String cond=" sd_samptp='"+sd_samptp+"'";
		return iBdprisampRService.find(cond, "", FBoolean.TRUE);
		
	}

	public BdPriSampDTO[] findAllSampTypesByQuery() throws BizException{
		// TODO Auto-generated method stub
		
		 StringBuffer sb=new StringBuffer();
		   sb.append("  select DISTINCT A.ID_UDIDOC,A.Id_Udidoclist,A.ID_GROUP,A.ID_ORG,A.ID_PARENT,A.CODE AS SD_SAMPTP,A.NAME AS NAME_SAMPTP,  ");
		   sb.append("    A.PYCODE,A.WBCODE,A.MNECODE,A.ACTIVESTATE,A.FG_SYS,A.SHORTNAME,A.DATATYPE,A.DES,A.DS,A.SV,      ");
		   sb.append("    B.CODE  AS CODE_CHILD,B.NAME AS NAME_CHILD,B.DS AS DS_CHILD,B.SV AS SV_CHILD      ");
		   sb.append("  from bd_udidoc  A        ");
		   sb.append("  inner join bd_udidoclist  B           ");
		   sb.append("         on  A.id_udidoclist=B.Id_Udidoclist       ");
		   sb.append("  where B.name like '%标本类型%'          ");
		   sb.append("        AND A.DS=0 AND B.DS=0                                   ");
		   sb.append("   order by  A.code  asc       ");
		   sb.append("          ");
		   sb.append("          ");
		  

		   
		   List<BdPriSampDTO> list  = (List<BdPriSampDTO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(BdPriSampDTO.class));
		   BdPriSampDTO[]  ppspDOArr=list.toArray(new BdPriSampDTO[]{});
		   return ppspDOArr;
		
		
		
	}

}

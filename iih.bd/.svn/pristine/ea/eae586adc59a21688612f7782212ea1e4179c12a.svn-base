package iih.bd.srv.medsrv.bf;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.dto.d.MedSrvPriDTO;
import iih.bd.srv.medsrv.bf.qry.MedSrvPriDtoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据服务基本分类ID获得医疗服务定价信息集合BP
 */
public class GetSrvPriMdInfoByCaBP {
	static final String fldname="id_srvca";  
	
	/**
	 * 根据服务基本分类ID获得医疗服务定价信息集合操作
	 * @param id_srvca
	 * @return
	 * @throws BizException
	 */
	public  MedSrvPriDTO[] exec(String id_srvca)  throws BizException
	{
		if(StringUtils.isBlank(id_srvca))return null;
		MedSrvPriDtoQry qry=new MedSrvPriDtoQry(id_srvca,fldname);
		MedSrvPriDTO[] rtn=(MedSrvPriDTO[])AppFwUtil.getDORstWithDao(qry, MedSrvPriDTO.class);
		return rtn;
	}
}

package iih.bd.srv.medsrv.bf;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.dto.d.MedSrvPriDTO;
import iih.bd.srv.medsrv.bf.qry.MedSrvPriDtoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据定价模式ID获得医疗服务定价信息BP
 */
public class GetSrvPriMdInfoBP {
	static final String fldname="id_primd";  	
	/**
	 * 根据定价模式ID获得医疗服务定价信息操作
	 * @param id_primd
	 * @return
	 * @throws BizException
	 */
	public  MedSrvPriDTO[] exec(String id_primd)  throws BizException
	{
		if(StringUtils.isBlank(id_primd))return null;
		MedSrvPriDtoQry qry=new MedSrvPriDtoQry(id_primd,fldname);
		MedSrvPriDTO[] rtn=(MedSrvPriDTO[])AppFwUtil.getDORstWithDao(qry, MedSrvPriDTO.class);
		return rtn;
	}
	
}

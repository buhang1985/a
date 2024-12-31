package iih.ci.mrm.i.mrmmail.audlogic;

import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;

public interface IMrmMailAudLogicService {
	
	/**
	 * 根据id_udidoc查询到病案邮寄表中的对应数据；
	 * 同时根据id_udidoclist = '@@@@TL400000000000SS' and code = '03'在bd_udidoc表中查询到已邮寄状态的数据；
	 * 将病案邮寄表中对应的数据的id和code改为查询到内容
	 * @param id_amr
	 * @return
	 */
	public abstract int updateCiMrmMailDO(CiMrmQryListDTO[] ciMrmQryListDtos, String confirmId) throws BizException;
	
}

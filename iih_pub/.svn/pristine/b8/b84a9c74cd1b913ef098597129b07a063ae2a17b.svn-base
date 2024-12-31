package iih.ci.mrm.i.mrmprint.audlogic;

import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.ci.mrm.cimrmcopy.d.CiMrmCopyDO;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.dto.mrmprintdto.d.MrmPrintDTO;
import xap.mw.core.data.BizException;

public interface IMrmPrintAudLogicService {

	/**
	 * 根据idamr查询复印历史
	 * @param id_amr
	 * @return
	 */
	public abstract CiMrmCopyDO[] qryCiMrmCopyDOList(String id_amr)  throws BizException;
	
	/**
	 * 根据参数获取打印的单价     方法废弃  暂时保留
	 * @return
	 */
	public abstract double getPrintOnceCopyMoney()  throws BizException;
	
	/**
	 * 根据输出模板 获得对应病案分类
	 * @return
	 */
	public abstract MrmTypeDO[] getMrmTypeDOForPrint(String id_bd_mrm_pt)  throws BizException;
	
	/**
	 * 病案复印登记信息保存（改变邮寄状态）
	 * @param ciMrmQryListDto
	 * @param ciMrmCopyDo
	 * @param mrmPrintDto
	 * @return
	 * @throws BizException
	 */
	public abstract boolean saveCiMrmCopyDO(CiMrmQryListDTO ciMrmQryListDto, CiMrmCopyDO ciMrmCopyDo, MrmPrintDTO mrmPrintDto) throws BizException;
	
}

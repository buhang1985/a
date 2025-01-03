package iih.bl.inc.i;

import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoInDTO;
import iih.bl.inc.blecincprint.d.BlEcIncCurPIncnoOutDTO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.dto.blecinctrasinfodto.d.BlecinctrasInfoDTO;
import iih.bl.inc.dto.blinctf.d.BlIncIssDTO;
import iih.bl.inc.dto.pcbillstatisdto.d.PcBillStatisDto;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 票据查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlIncQryService {
	
    public PagingRtnData<PcBillStatisDto> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr) throws BizException;
    public PagingRtnData<PcBillStatisDto> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
            PaginationInfo pg) throws BizException;
	/**
	 * 获取住院患者可重打的发票信息
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author wq.li
	 * 
	 */
	public abstract BlIncIpDO GetReprintIncInfo(String entId)throws BizException;

	/**
	 * 获取当前票号是否作废
	 * @param invoiceNo 票号
	 * @param strCodeIncca 票包编码
	 * @return
	 * @throws BizException
	 * @author LIM 2018-07-28
	 */
	public abstract FBoolean getCurnoCancStatus(String invoiceNo, String strCodeIncca)throws BizException;

	/**
	 * 查询票据领用记录(含转移信息)
	 * @param empId 人员id
	 * @param pcId 计算机id
	 * @return 票据记录
	 * @throws BizException
	 * @author ly 2019/02/19
	 */
	public abstract BlIncIssDTO[] getIncIssWithTfRecord(String empId, String pcId,FBoolean leftorright) throws BizException;
    
    /***
     * 根据时间，就诊类型，患者来查找对应的信息
     * @param pg
     * @param wherePart
     * @param orderByPart
     * @return
     * @throws BizException
     */
    public abstract PagingRtnData<BlecinctrasInfoDTO> findbBlecinctrasInfoDtos(QryRootNodeDTO qry,PaginationInfo pg) throws BizException;
	
    /**
     * 获取电子票当前纸质票当前号
     * @param dto
     * @return
     * @throws BizException
     * @author ly 2020/01/06
     */
    public abstract BlEcIncCurPIncnoOutDTO getPaperIncCurNO(BlEcIncCurPIncnoInDTO dto) throws BizException;
}

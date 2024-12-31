package iih.mp.ne.mptb.i;

import iih.mp.ne.mptb.d.MpTableDTO;
import iih.mp.ne.mptb.d.MpTbDO;
import iih.mp.ne.mptb.d.MpTbpatDTO;
import xap.mw.core.data.BizException;

public interface IMptbExtService {
	
	/**
	 * 获取当前病区取血单未打印的患者
	 * @param depnur
	 * @return
	 * @throws BizException
	 */
	public MpTbpatDTO[] getMpTbpatDtos(String depnur) throws BizException;

	/**
	 * 根据时间过滤已打印的取血单信息（列表形式）
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws BizException
	 */
	public MpTbDO[] getMptbdos(String beginDate, String endDate) throws BizException;

	/**
	 * 查询未打印的取血单信息
	 * @param mptbpatdtos
	 * @return
	 * @throws BizException
	 */
	public MpTableDTO[] getMpTableDtos(MpTbpatDTO[] mptbpatdtos) throws BizException;

	/**
	 * 查询已打印取血单信息（打印模板显示）
	 * @param mptbdo
	 * @return
	 * @throws BizException
	 */
	public MpTableDTO[] getMpTablePrinted(MpTbDO[] mptbdo) throws BizException;
}

package iih.bl.st.ip.i;

import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import iih.bl.st.blcgipdto.d.BlStBaseInfo;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.itf.context.InsureContext;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**医保前置流程接口集合
 * @author Administrator
 *
 */
public interface IHpPrePositionFlowService {
	/**医保取消结算撤销更新记账数据
	 * @return
	 * @param isUploaded 上传或者撤销
	 * @param isFrontAfter
	 * @throws BizException
	 */
	public abstract FBoolean updateHpCgFlag(String strIdEnt,IpBillItmUploadHpDTO[] list,FBoolean isUploaded,FBoolean isFrontAfter) throws BizException;

	/**根据结算主键医保取消结算更新记账数据(撤销)
	 * @return
	 * @param isUploaded 上传或者撤销
	 * @param isFrontAfter
	 * @throws BizException
	 */
	public abstract FBoolean updateHpCgByIdStIp(String strIdEnt,String strIdStIp,IpBillItmUploadHpDTO[] list) throws BizException;

	/**结算操作
	 * @return 结算操作是否成功
	 * @throws BizException
	 */
	public abstract FBoolean doSettlement(InsureContext insureContext,String strIdEnt,String id_dep, String id_emp, FDateTime dt_end,InpPayRtnValDTO hpPayRtnValDto) throws BizException;
	
	/**结算操作
	 * @return 结算操作是否成功
	 * @throws BizException
	 */
	public abstract FBoolean doSettlementByCgIps(InsureContext insureContext,String strIdEnt,String id_dep, String id_emp, FDateTime dt_end,InpPayRtnValDTO hpPayRtnValDto,String[] idCgIps) throws BizException;
	
	/**
	 * 住院取消结算
	 * 
	 * @param blStIpDO
	 *            结算DO
	 * @return
	 * @throws BizException
	 * @author liwq
	 * @since 2017-7-13 11:33:26
	 */
	public FBoolean doCancelSettlement(InsureContext insureContext,BlStBaseInfo blStIpDO) throws BizException;

	
	/** 修改业务逻辑，获取医保分摊数据
	 * @param insureContext
	 * @param blStIpDO
	 * @return
	 * @throws BizException
	 * @Date 2018-04-23
	 * @author yangyang
	 */
	public CommonPropDataDTO getPropData(InsureContext insureContext,String strStId) throws BizException;
	

	/**上传病案
	 * @param strIdEnt 就诊主键
	 * @param fg_xy 是否西医诊断
	 * @throws BizException
	 */
	public void uploadMedicalData(String strIdEnt,FBoolean fg_xy) throws BizException;
	
	/**
	*  门诊转住院记账明细数据更新(自用)
	*/
	public abstract BlCgIpTfInDO[] updateObject(BlCgIpTfInDO[] aggdos) throws BizException;
}

package iih.ci.sdk.ems.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 计算价格
 * @author li_zheng
 *
 */
public interface ICalculatePriceBP {
  /**
   * 价格计算
   * @param BdSrvPriCalParamDTO
   * @param CiEnContext
   * @return 0,折扣价  1,标准价格
   * @throws BizException
   */
  public abstract FDouble[] CalculatePrice(BdSrvPriCalParamDTO param,CiEnContextDTO CiEnContext)throws BizException;
  
}

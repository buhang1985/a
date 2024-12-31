package iih.ci.ord.i.external.provide;

import iih.ci.ord.i.external.provide.meta.cdss.OrderInfoDTO;
import iih.ci.ord.i.external.provide.meta.cdss.PatInfoDTO;
import iih.ci.ord.i.external.provide.meta.cdss.PsnInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 临床对CDSS提供的对外查询接口
 * 
 * @author MaKunPeng
 * @date 2020-7-13 10:48:43
 */
public interface ICiOrdCdssService {
    
    /**
     * 查询人员信息
     * @param id_psn
     * @return
     */
    PsnInfoDTO getPsnInfo(String id_psn) throws BizException;
    
    /**
     * 查询患者信息
     * @param id_en
     * @return
     */
    PatInfoDTO getPatInfo(String id_en) throws BizException;
    
    /**
     * 查询医嘱信息
     * @param orderIds
     * @return
     */
    OrderInfoDTO[] getOrderInfo(String[] orderIds) throws BizException;
}

package iih.ci.ord.i.external.obtain;

import java.util.List;

import iih.ci.ord.i.external.obtain.meta.en.PatEnInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

/**
 * 获取EN域数据接口
 * @author HUMS
 *
 */
public interface ICiOrdEnRService {
	
	/**
	 * 根据患者id获取住院患者信息，用于第三方URL展示参数
	 * @param id_pat
	 */
	public PatEnInfoDTO getOpEnPatInfo(String id_pat, String code_entp) throws DAException;
	/**
     * 查询本次抢救中前一次就诊的当前诊断
     * @param id_en
     * @return
     * @throws BizException
     */
    public String[] getLastEnDiIds(String id_en) throws BizException;
    
    /**
     * 	获取患者的授权科室集合
     * 
     * @param id_en 患者就诊id
     * @return
     * @throws BizException
     */
    public List<String> getAuthorisedDepIds(String id_en) throws BizException;
}

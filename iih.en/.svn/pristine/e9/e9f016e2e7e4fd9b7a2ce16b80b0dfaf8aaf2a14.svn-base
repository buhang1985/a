package iih.en.pv.s.bp.ip;

import iih.en.comm.validator.EnValidator;
import iih.mp.nr.dto.d.ParamDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 医技检查参数解析器
 * @author Sarah
 *
 */
public class ChkParamParser {
	/**
	 * 解析参数
	 * @param srvTpsFlag 项目类型
	 * @param srvStatus 项目状态
	 * @return
	 */
	public ParamDTO[] parse(String srvTpsFlag) throws BizException{
		if(EnValidator.isEmpty(srvTpsFlag)){
			throw new BizException("参数设置的项目类型或项目状态为空！");
		}
        List<ParamDTO> list = new ArrayList<ParamDTO>();
        String[] tpItms = srvTpsFlag.split(",");
        for(int i=0;i<tpItms.length;i++){
            ParamDTO paramDTO = new ParamDTO();
            paramDTO.setSd_srvtp(tpItms[i]);   
            list.add(paramDTO);
        }
        
		return list.toArray(new ParamDTO[0]);
	}
}

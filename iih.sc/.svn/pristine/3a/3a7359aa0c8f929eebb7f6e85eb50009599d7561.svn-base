package iih.sc.sch.s.bp;

import java.util.List;

import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.RelSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 绑定挂号资源和费用
 * @author yank
 *
 */
public class BindResAndSrvBP {
	/**
	 * 绑定挂号资源和费用
	 * @param regResDTO 挂号资源
	 * @param relSrvArray 服务费用集合
	 * @return
	 * @throws BizException
	 */
	public RegResDTO exec(RegResDTO regResDTO,List<RelSrvDTO> relSrvArray) throws BizException{		
		if(ListUtil.isEmpty(relSrvArray)){
			return regResDTO;
		}	
		//默认值
		regResDTO.setAmt_st(FDouble.ZERO_DBL);
		regResDTO.setAmt_hp(FDouble.ZERO_DBL);
		regResDTO.setAmt_pat(FDouble.ZERO_DBL);
		regResDTO.setAmt(FDouble.ZERO_DBL);
		
		FDouble regfee = new FDouble(0);//挂号费
		FDouble diagfee = new FDouble(0);//诊疗费
		FArrayList arrayList = new FArrayList();		
		for(RelSrvDTO srvDTO : relSrvArray){			
			if(FBoolean.TRUE.equals(srvDTO.getFg_maj())){
				//如果是主服务，则是诊疗费
				diagfee = diagfee.add(srvDTO.getAmt_st());
			}else{
				regfee = regfee.add(srvDTO.getAmt_st());//其余为挂号费
			}
			
			//更新挂号资源价格
			regResDTO.setAmt_st(regResDTO.getAmt_st().add(srvDTO.getAmt_st()));
			regResDTO.setAmt_hp(regResDTO.getAmt_hp().add(srvDTO.getAmt_hp()));
			regResDTO.setAmt_pat(regResDTO.getAmt_pat().add(srvDTO.getAmt_pat()));
			regResDTO.setAmt(regResDTO.getAmt().add(srvDTO.getAmt()));
			arrayList.add(srvDTO);
		}
		regResDTO.setSrvarray(arrayList);
		regResDTO.setRegfee(regfee);
		regResDTO.setDiagfee(diagfee);
		
		return regResDTO;
	}
}

package iih.crm.conm.i;

import iih.crm.conm.dto.d.CrmConDataShowDTO;
import iih.crm.conm.dto.d.CrmConRelationPatDTO;
import iih.crm.conm.dto.d.MarPlanShowDataDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
* @ClassName: ICrmConmCmdService  
* @Description: 客户关系客户标准命令服务 
* @author xy.zhou
* @date 2019年3月19日
 */
public interface ICrmConmCmdService {

	/**
	 * 
	* @Title: relieveComcon  
	* @Description: 解除指定合同 
	* @param id_con
	* @throws BizException  
	* @return FBoolean 
	* @author xy.zhou
	 */
	public abstract FBoolean relieveComcon(String id_con)throws BizException;
	
	/**
	 * 合同签订
	 * @param 营销方案信息
	 * @param mianPatDto 合同签订人
	 * @param conRelationPats 合同绑定人员
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean contractSigning(MarPlanShowDataDTO marDto,CrmConRelationPatDTO mianPatDto,CrmConRelationPatDTO[] conRelationPats)throws BizException;


	/**
	 * 合同绑定人员修改
	 * @param id_con 合同信息
	 * @param conRelationPats 合同绑定人员集合
	 * @return
	 */
	public abstract FBoolean contractEdit(String id_con,CrmConRelationPatDTO[] conRelationPats)throws BizException ;
}

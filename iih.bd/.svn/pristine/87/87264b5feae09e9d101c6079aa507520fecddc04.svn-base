package iih.bd.pp.s.bp;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpDictCodeConst;
import iih.bd.pp.dto.accsrvrelat.d.AccSrvRelatDTO;
import iih.bd.pp.s.bp.qry.GetAccSrvRelatQry;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取核算分类医疗服务关系
 * @author ly 2018/05/14
 *
 */
public class BdPpGetAccSrvRelatBP {

	/**
	 * 获取核算分类医疗服务关系
	 * @param srvIds 医疗服务id数组
	 * @param codeEntp 就诊类型编码
	 * @return
	 * @throws BizException
	 */
	public AccSrvRelatDTO[] exec(String[] srvIds,String codeEntp) throws BizException{
		
		this.validate(srvIds, codeEntp);
		
		FBoolean ifAcc = BlParams.BLAC000001();
		if(FBoolean.FALSE.equals(ifAcc)){
			return null;
		}
		
		//匹配核算体系
		String accId = this.getAccId(codeEntp);
		
		//查询关系数据
		AccSrvRelatDTO[] rlt = (AccSrvRelatDTO[]) AppFwUtil.getDORstWithDao(
				new GetAccSrvRelatQry(srvIds, accId), AccSrvRelatDTO.class);
		return rlt;
	}
	
	/**
	 * 参数校验
	 * @param srvIds
	 * @param codeEntp
	 * @throws BizException
	 */
	private void validate(String[] srvIds,String codeEntp) throws BizException{
		
		if(ArrayUtil.isEmpty(srvIds)){
			throw new ArgumentNullException("获取核算分类医疗服务关系", "医疗服务id数组");
		}
		
		if(StringUtil.isEmpty(codeEntp)){
			throw new ArgumentNullException("获取核算分类医疗服务关系", "就诊类型编码");
		}
		
		if(!IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(codeEntp) &&
				!IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(codeEntp) &&
				!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(codeEntp)){
			throw new BizException(String.format("该就诊类型(编码%s)未定义核算体系", codeEntp));
		}
	}

	/**
	 * 获取核算体系
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	private String getAccId(String codeEntp) throws BizException{
		
		FBoolean ifShare = BlParams.BLAC000002();
		if(FBoolean.TRUE.equals(ifShare)){
			return IBdPpDictCodeConst.ID_ACCOUNT_GY;
		}
		
		return IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(codeEntp) ? 
				IBdPpDictCodeConst.ID_ACCOUNT_ZY : IBdPpDictCodeConst.ID_ACCOUNT_MZ;
	}
}

package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiBuIpOrQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台用血服务数据信息操作BP
 * （住院）
 * @author yangz
 */
public class GetIEIpMsgInfo4UBtBP {
	/**
	 * 生成集成平台用血服务数据信息
	 * （住院）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpBtUseOrDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//查询并获得返回值
		CiBuIpOrQry qry=new CiBuIpOrQry(id_ors);
		IEOpBtUseOrDTO[] rtn = (IEOpBtUseOrDTO[])AppFwUtil.getDORstWithDao(qry, IEOpBtUseOrDTO.class);
		if (!CiOrdUtils.isEmpty(rtn)){
			for (IEOpBtUseOrDTO ieOpBtUseOrDTO : rtn) {
				FDate birthday = ieOpBtUseOrDTO.getBrithday();
				String age = AgeCalcUtil.getAge(birthday);
				ieOpBtUseOrDTO.setAge(age);
			}
		} 
		
		return rtn;
	}
}

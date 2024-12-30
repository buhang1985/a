package iih.sc.scbd.s.bp;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取渠道
 * 
 * @author yank
 *
 */
public class GetChlByTpBP {
	/**
	 * 获取渠道
	 * 
	 * @param chlTp
	 *            渠道类型编码
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public SchedulechlDO[] exec(String chlTp) throws BizException {
		String whereString = "Sd_scchltp = '"+ chlTp +"'";
		if(!StringUtils.isNullOrEmpty(ScGroupControlUtils.getGroupControlFitler(new SchedulechlDO(),""))){
			whereString = "Sd_scchltp = '"+ chlTp +"' and " + ScGroupControlUtils.getGroupControlFitler(new SchedulechlDO(), "");
		}
		List<SchedulechlDO> list = (List<SchedulechlDO>) new DAFacade().findByCond(SchedulechlDO.class, whereString, SchedulechlDO.CODE);
		if (!ListUtil.isEmpty(list))
			return list.toArray(new SchedulechlDO[0]);
		return null;
	}
}

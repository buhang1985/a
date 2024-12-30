package iih.sc.apt.s.bp.op;

import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import sun.print.resources.serviceui;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/****
 * 门诊医生站撤回、删除医技医嘱是否已确认判断
 * @author yu.b 2020-07-20
 */
public class GetAptNotConfirm4CiBP {
	
	public FMap exec(FArrayList idOrs) throws BizException{
		if(idOrs.isEmpty()) {
			throw new BizException("医嘱ID为空！");
		}
		FMap map = new FMap();
		ScAptApplDO[] dos = this.getScAptApplDOs(idOrs);
		StringBuilder sb = new StringBuilder();
		for(ScAptApplDO aptApplDO : dos){
			if(aptApplDO.getFg_comfirm() == FBoolean.TRUE){
				sb.append(aptApplDO.getName());
				sb.append("已于");
				sb.append(aptApplDO.getDt_appl());
				sb.append("预约确认\n");
			}
			map.put(aptApplDO.getId_or(), !aptApplDO.getFg_comfirm().booleanValue());
		}
		String msg = sb.toString();
		if(!StringUtil.isEmpty(msg)){
			sb.append("无法撤销或删除！");
		}
		map.put("msg", sb.toString());
		return map;
	}
	
	private ScAptApplDO[] getScAptApplDOs(FArrayList idOrs) throws BizException{
		@SuppressWarnings("unchecked")
		String[] ors = (String[]) idOrs.toArray(new String[idOrs.size()]);
		IScaptapplMDORService service = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] dos = service.findByAttrValStrings("Id_or", ors);
		if(ArrayUtil.isEmpty(dos)) {
			throw new BizException("未查询到医技预约信息！");
		}
		return dos;
		
	}

}

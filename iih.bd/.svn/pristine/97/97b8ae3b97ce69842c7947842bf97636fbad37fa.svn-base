package iih.bd.fc.s.bp;

import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.pub.BdFcUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FTime;

/**
 *医嘱流向参数有效性校验操作BP
 */
public class OrWfArguValidateBP {

	/**
	 * 医嘱流向参数有效性校验
	 * @param wforinfo
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public boolean exec(MdWfOrDO wforinfo,OrWfExDeptParamDTO param,String idwfstr) throws BizException {
		//有效性判断
		if(wforinfo==null  || param==null)return false;
		
		//流向模式
		if(!idwfstr.contains(BdFcUtils.addLRCommaStr(wforinfo.getId_wf()))){
			return false;
		}

		//服务匹配
		if(!BdFcUtils.isStrEqualMatch(wforinfo.getId_srv(),param.getId_srv())){
			return false;
		}
		
		//服务分类匹配
		if(!isStrIncludeMatch(wforinfo.getId_srvca(),param.getId_srvca())){
			return false;
		}
		
		//服务类型匹配
		if(!BdFcUtils.isStrIncludeMatch(wforinfo.getSd_srvtp(),param.getSd_srvtp())){
			return false;
		}
		
		//用法匹配
		if(!BdFcUtils.isStrEqualMatch(wforinfo.getId_usg(),param.getId_usage())){
			return false;
		}
		
		//医嘱长临匹配 0临时   1长期  空位全部
		if(!(wforinfo.getId_ordrecurtp()==null || wforinfo.getId_ordrecurtp().trim().equals(""))){
			if(!BdFcUtils.isStrEqualMatch(wforinfo.getId_ordrecurtp(),param.getRecurstr())){
				return false;
			}
		}
		
		//星期数控制 不空则做控制   1,2,3,4,5,6,7
		if(!BdFcUtils.isEmpty(wforinfo.getWeeks())){
			String inputWeek=null;
			if(BdFcUtils.isEmpty(param.getWeekno())){
				inputWeek=Integer.toString(BdFcAppUtils.getServerDateTime().getWeek());
			}else{
				inputWeek=param.getWeekno();
			}
			if(!wforinfo.getWeeks().contains(inputWeek)){
				return false;
			}
		}
		
		//开始结束时间控制
		if(!BdFcUtils.isEmpty(wforinfo.getTime_b()) && !BdFcUtils.isEmpty(wforinfo.getTime_e())){
			FTime inputTime=null;
			if(BdFcUtils.isEmpty(param.getTimestr())){
				inputTime=BdFcAppUtils.getServerDateTime().getUFTime();
			}else{
				inputTime=param.getTimestr();
			}
			if (inputTime.before(wforinfo.getTime_b())
					|| inputTime.after(wforinfo.getTime_e())) {
				return false;
			}
		}
		
		return true;

	}
	
	/**
	 * 服务分类匹配
	 * @param id_srvca0
	 * @param id_srvca1
	 * @return
	 * @throws BizException
	 */
	private boolean isStrIncludeMatch(String id_srvca0,String id_srvca1) throws BizException{
		if(BdFcUtils.isEmpty(id_srvca0) || BdFcUtils.isEmpty(id_srvca1)) return true;
		GetBdSrvcaMatchStrBP bp=new GetBdSrvcaMatchStrBP();
		String[] matchstrs=bp.exec(new String[]{id_srvca0,id_srvca1});
		if(matchstrs==null || matchstrs.length!=2)return true;
		if(matchstrs[1].indexOf(matchstrs[0])!=0)return false;
		return true;
	}

}

package iih.bd.srv.s.bp;

import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.eu_srvcatpenum;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.MedSrvMatchEmsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 医生站医疗服务选择时，医疗单匹配操作BP
 */
public class MedSrvEmsMatchBP {
	/**
	 * 医生站医疗服务选择时，医疗单匹配
	 * @param param
	 * @throws BizException
	 */
	public EmsMatchRstDTO exec(SrvMatchEmsParamDTO param) throws BizException{
		//有效性校验
		if(!invalidate(param))return null;
		
		//获得查询SQl
		MedSrvMatchEmsQry qry = new MedSrvMatchEmsQry(param);
		
		//匹配医疗单结果
		EmsMatchRstDTO[] emsmatchrst = (EmsMatchRstDTO[])AppFwUtil.getDORstWithDao(qry, EmsMatchRstDTO.class);

		//返回值处理
		EmsMatchRstDTO rtn=getSrvMatchEms(emsmatchrst, param);
		return rtn;
	}
	
	/**
	 * 有效性校验
	 * @param param
	 * @return
	 */
	private boolean invalidate(SrvMatchEmsParamDTO param){
		if(BdSrvUtils.isEmpty(param))return false;
		if(BdSrvUtils.isEmpty(param.getId_grp())
				|| BdSrvUtils.isEmpty(param.getId_org())
				|| BdSrvUtils.isEmpty(param.getId_dept())
				|| BdSrvUtils.isEmpty(param.getId_srv())
				|| BdSrvUtils.isEmpty(param.getSd_srvtp())
				|| BdSrvUtils.isEmpty(param.getCode_entp())
				|| BdSrvUtils.isEmpty(param.getDt_or())
				|| BdSrvUtils.isEmpty(param.getEmsappmode())
				)return false;
		return true;
	}
	
	/**
	 * 获得医疗服务匹配的医疗单数据信息
	 * @param emsmatchrst
	 * @param param
	 * @return
	 */
	private EmsMatchRstDTO getSrvMatchEms(EmsMatchRstDTO[] emsmatchrst,SrvMatchEmsParamDTO param){
		if(BdSrvUtils.isEmpty(emsmatchrst))return null;
		int ipos=0,iWeight=0;
		String id_srv=param.getId_srv();
		String sd_srvtp=param.getSd_srvtp();
		String id_ems=emsmatchrst[0].getId_ems();
	    
		//遍历
		for(int i=0;i<emsmatchrst.length;i++){
			if(id_ems.equals(emsmatchrst[i].getId_ems())){
				iWeight+=getSrvWeight(emsmatchrst[i].getEu_direct(),id_srv,sd_srvtp,emsmatchrst[i]);
			}else{
				if(iWeight>0){return emsmatchrst[ipos];}
				id_ems=emsmatchrst[i].getId_ems();
				ipos=i;
				iWeight=0;
				iWeight+=getSrvWeight(emsmatchrst[i].getEu_direct(),id_srv,sd_srvtp,emsmatchrst[i]);
			}
		}
		if(iWeight>0){return emsmatchrst[ipos];}
		
		return null;
	}
	
	/**
	 * 获得匹配权重
	 * @param direct
	 * @param id_srv
	 * @param sd_srvtp
	 * @param matchrst
	 * @return
	 */
	private int getSrvWeight(int direct,String id_srv,String sd_srvtp,EmsMatchRstDTO matchrst){
		if(eu_srvcatpenum.SRV.equals(matchrst.getEu_ofreftp()) ){
			if(id_srv.equals(matchrst.getId_srv())){
				return direct;
			}
		}else if(eu_srvcatpenum.CA.equals(matchrst.getEu_ofreftp())){
			if(BdSrvUtils.isCapitalInStr(sd_srvtp, matchrst.getSd_srvtp())){
				return direct;
			}
		}
		return 0;
	}
}

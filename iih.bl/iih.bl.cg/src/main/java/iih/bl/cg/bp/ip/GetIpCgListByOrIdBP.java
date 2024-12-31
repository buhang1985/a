package iih.bl.cg.bp.ip;

import iih.bd.pp.hp.d.HpAggDO;
import iih.bd.pp.hp.i.IHpRService;
import iih.bl.cg.bp.ip.qry.GetIpCgListByOrIdQry;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 
 * @author 
 *
 */
public class GetIpCgListByOrIdBP {
	/**
	 * 获取住院医嘱的记账信息
	 * @param pageInfo 分页信息
	 * @param orId 医嘱id
	 * @return
	 * @throws BizException
	 * @author liwenqiang 2017年12月6日 16:59:06
	 */
	public PagingRtnData<BlIpCgDTO> exec(PaginationInfo pageInfo,String orId, String entId,String srvId) throws BizException{
		//校验医嘱Id
		if(StringUtil.isEmpty(orId) || StringUtil.isEmpty(entId)){
			return null;
		}
		
		PagingRtnData<BlIpCgDTO> pageCiCgDto = new PagingRtnData<BlIpCgDTO>();
		PagingServiceImpl<BlIpCgDTO> service =new PagingServiceImpl<BlIpCgDTO>();
		//由于多医保计划，所以必须确定患者属于哪个医保计划下的，否则会导致出现多条重复数据
		IPativisitRService patiSer = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiDos = patiSer.findByAttrValString("Id_ent", entId);
		String idHp = "";
		if(StringUtils.isEmptyWithTrim(patiDos[0].getId_hp())) {
			//如果患者该次就诊没有医保计划，则使用默认的医保计划
			IHpRService hpSer = ServiceFinder.find(IHpRService.class);
			HpAggDO[] hpAggDos = hpSer.find("fg_default = 'Y' ", "", FBoolean.TRUE);
			if(!ArrayUtil.isEmpty(hpAggDos)){
				idHp = hpAggDos[0].getParentDO().getId_hp();
			}
		}
		GetIpCgListByOrIdQry qry=new GetIpCgListByOrIdQry(orId,entId,srvId,idHp);
		pageCiCgDto = service.findByPageInfo(new BlIpCgDTO(), pageInfo, qry.getQrySQLStr(), "", qry.getQryParameter(null));	
		return pageCiCgDto;
	}
	
	
}
